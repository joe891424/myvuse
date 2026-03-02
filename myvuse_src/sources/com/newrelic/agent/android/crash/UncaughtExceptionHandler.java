package com.newrelic.agent.android.crash;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.payload.PayloadController;
import com.newrelic.agent.android.stats.StatsEngine;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    protected static final AgentLog log = AgentLogManager.getAgentLog();
    static Thread.UncaughtExceptionHandler previousExceptionHandler = null;
    private final CrashReporter crashReporter;
    protected final AtomicBoolean handledException = new AtomicBoolean(false);

    public UncaughtExceptionHandler(CrashReporter crashReporter) {
        this.crashReporter = crashReporter;
    }

    public void installExceptionHandler() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (defaultUncaughtExceptionHandler instanceof UncaughtExceptionHandler) {
                log.debug("New Relic crash handler already installed.");
                return;
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = previousExceptionHandler;
            if (uncaughtExceptionHandler != null) {
                if (uncaughtExceptionHandler instanceof UncaughtExceptionHandler) {
                    log.warn("Previous uncaught exception handler[" + uncaughtExceptionHandler.getClass().getName() + "] exists, and it is us! Replace it.");
                } else {
                    log.warn("Previous uncaught exception handler[" + uncaughtExceptionHandler.getClass().getName() + "] exists. Assuming it delegates to [" + UncaughtExceptionHandler.class.getName() + "]");
                    return;
                }
            }
            log.debug("Installing New Relic crash handler and chaining to " + defaultUncaughtExceptionHandler.getClass().getName());
        } else {
            log.debug("Installing New Relic crash handler.");
        }
        previousExceptionHandler = defaultUncaughtExceptionHandler;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (!this.handledException.compareAndSet(false, true)) {
            StatsEngine.get().inc(MetricNames.SUPPORTABILITY_CRASH_RECURSIVE_HANDLER);
            return;
        }
        try {
            AgentConfiguration agentConfiguration = this.crashReporter.getAgentConfiguration();
            if (this.crashReporter.isEnabled() && FeatureFlag.featureEnabled(FeatureFlag.CrashReporting)) {
                AgentLog agentLog = log;
                agentLog.debug("A crash has been detected in " + thread.getStackTrace()[0].getClassName() + " and will be reported ASAP.");
                agentLog.debug("Analytics data is currently ".concat(agentConfiguration.getEnableAnalyticsEvents() ? "enabled " : "disabled"));
                AnalyticsControllerImpl analyticsControllerImpl = AnalyticsControllerImpl.getInstance();
                analyticsControllerImpl.setEnabled(true);
                if (Harvest.getMillisSinceStart() != 0) {
                    analyticsControllerImpl.setAttribute(AnalyticsAttribute.SESSION_DURATION_ATTRIBUTE, r4 / 1000.0f, false);
                }
                this.crashReporter.storeAndReportCrash(new Crash(th, analyticsControllerImpl.getSessionAttributes(), analyticsControllerImpl.getEventManager().getQueuedEvents(), agentConfiguration.getEnableAnalyticsEvents()));
                return;
            }
            log.debug("A crash has been detected but crash reporting is disabled!");
            if (Agent.isInstantApp()) {
                Harvest.shutdown();
                ApplicationStateMonitor.getInstance().uiHidden();
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = previousExceptionHandler;
            PayloadController.shutdown();
            chainExceptionHandler(uncaughtExceptionHandler, thread, th);
        } finally {
            if (Agent.isInstantApp()) {
                Harvest.shutdown();
                ApplicationStateMonitor.getInstance().uiHidden();
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = previousExceptionHandler;
            PayloadController.shutdown();
            chainExceptionHandler(uncaughtExceptionHandler2, thread, th);
        }
    }

    void chainExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Thread thread, Throwable th) {
        if (uncaughtExceptionHandler != null) {
            log.debug("Chaining crash reporting duties to " + uncaughtExceptionHandler.getClass().getSimpleName());
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    public void resetExceptionHandler() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
        if (previousExceptionHandler != null && (defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()) != null) {
            if (defaultUncaughtExceptionHandler instanceof UncaughtExceptionHandler) {
                Thread.setDefaultUncaughtExceptionHandler(previousExceptionHandler);
                previousExceptionHandler = null;
            } else {
                log.warn("Previous uncaught exception handler[" + defaultUncaughtExceptionHandler.getClass().getName() + "] was set after agent start. Let it be...");
            }
        }
        this.handledException.set(false);
    }

    public Thread.UncaughtExceptionHandler getPreviousExceptionHandler() {
        return previousExceptionHandler;
    }
}
