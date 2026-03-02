package com.newrelic.agent.android.ndk;

import android.content.Context;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.NewRelic;
import com.newrelic.agent.android.agentdata.AgentDataController;
import com.newrelic.agent.android.agentdata.AgentDataReporter;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.crash.CrashReporter;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestAdapter;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.ndk.AgentNDK;
import com.newrelic.agent.android.stats.StatsEngine;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public class NativeReporting extends HarvestAdapter {
    protected final NativeReportListener nativeReportListener;
    protected static final AgentLog log = AgentLogManager.getAgentLog();
    protected static AtomicReference<NativeReporting> instance = new AtomicReference<>(null);
    protected static AtomicReference<AgentNDK> agentNdk = new AtomicReference<>(null);

    public static NativeReporting getInstance() {
        return instance.get();
    }

    public static NativeReporting initialize(Context context, AgentConfiguration agentConfiguration) {
        PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m1161m(instance, null, new NativeReporting(context, agentConfiguration));
        Harvest.addHarvestListener(instance.get());
        StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_NDK_INIT);
        return instance.get();
    }

    public static void shutdown() {
        if (isInitialized()) {
            Harvest.removeHarvestListener(instance.get());
            instance.get().stop();
        }
        instance.set(null);
    }

    public static boolean isInitialized() {
        return (instance.get() == null || agentNdk.get() == null || AgentNDK.getInstance() == null) ? false : true;
    }

    public static void crashNow(String str) {
        if (isInitialized()) {
            agentNdk.get().crashNow(str);
        }
    }

    public static boolean isRooted() {
        if (!isInitialized()) {
            return false;
        }
        StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_NDK_ROOTED_DEVICE);
        return AgentNDK.getInstance().isRooted();
    }

    protected NativeReporting(Context context, AgentConfiguration agentConfiguration) {
        NativeReportListener nativeReportListener = new NativeReportListener();
        this.nativeReportListener = nativeReportListener;
        PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m1161m(agentNdk, null, new AgentNDK.Builder(context).withBuildId(Agent.getBuildId()).withANRMonitor(!agentConfiguration.getApplicationExitConfiguration().isEnabled()).withSessionId(agentConfiguration.getSessionID()).withReportListener(nativeReportListener).withLogger(AgentLogManager.getAgentLog()).build());
    }

    public void start() {
        if (isInitialized()) {
            try {
                agentNdk.get().start();
                StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_NDK_START);
            } catch (Exception e) {
                log.error(e.toString());
            }
            boolean zIsRooted = isRooted();
            if (zIsRooted) {
                NewRelic.setAttribute(AnalyticsAttribute.NATIVE_ROOTED_DEVICE_ATTRIBUTE, zIsRooted);
                return;
            }
            return;
        }
        log.error("CrashReporter: Must first initialize native module.");
    }

    void stop() {
        if (isInitialized()) {
            try {
                agentNdk.get().stop();
            } catch (Exception e) {
                log.error(e.toString());
            }
            StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_NDK_STOP);
            agentNdk.set(null);
        }
    }

    @Override // com.newrelic.agent.android.harvest.HarvestLifecycleAware
    public void onHarvestStart() {
        agentNdk.get().flushPendingReports();
        StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_NDK_REPORTS_FLUSH);
    }

    static class NativeCrashException extends NativeException {
        public NativeCrashException(String str) {
            super(str);
        }
    }

    static class NativeUnhandledException extends NativeException {
        public NativeUnhandledException(String str) {
            super(str);
        }
    }

    static class ANRException extends NativeException {
        public ANRException(String str) {
            super(str);
        }
    }

    static class NativeReportListener implements AgentNDKListener {
        NativeReportListener() {
        }

        @Override // com.newrelic.agent.android.ndk.AgentNDKListener
        public boolean onNativeCrash(String str) {
            StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_NDK_REPORTS_CRASH);
            AnalyticsControllerImpl analyticsControllerImpl = AnalyticsControllerImpl.getInstance();
            HashSet<AnalyticsAttribute> hashSet = new HashSet<AnalyticsAttribute>(analyticsControllerImpl) { // from class: com.newrelic.agent.android.ndk.NativeReporting.NativeReportListener.1
                final /* synthetic */ AnalyticsControllerImpl val$analyticsController;

                {
                    this.val$analyticsController = analyticsControllerImpl;
                    addAll(analyticsControllerImpl.getSessionAttributes());
                }
            };
            NativeCrashException nativeCrashException = new NativeCrashException(str);
            hashSet.add(new AnalyticsAttribute("platform", "native"));
            hashSet.add(new AnalyticsAttribute(AnalyticsAttribute.NATIVE_CRASH, true));
            hashSet.add(new AnalyticsAttribute(AnalyticsAttribute.NATIVE_EXCEPTION_MESSAGE_ATTRIBUTE, nativeCrashException.getNativeStackTrace().getExceptionMessage()));
            if (nativeCrashException.getNativeStackTrace().getCrashedThread() != null) {
                hashSet.add(new AnalyticsAttribute(AnalyticsAttribute.NATIVE_CRASHING_THREAD_ID_ATTRIBUTE, nativeCrashException.getNativeStackTrace().getCrashedThread().getThreadId()));
            }
            NativeCrash nativeCrash = new NativeCrash(nativeCrashException, hashSet, analyticsControllerImpl.getEventManager().getQueuedEvents());
            if (CrashReporter.getInstance() != null) {
                CrashReporter.getInstance().storeAndReportCrash(nativeCrash);
                return true;
            }
            NativeReporting.log.error("Could not report native crash: CrashReporter is disabled.");
            return false;
        }

        @Override // com.newrelic.agent.android.ndk.AgentNDKListener
        public boolean onNativeException(String str) {
            StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_NDK_REPORTS_EXCEPTION);
            HashMap<String, Object> map = new HashMap<String, Object>() { // from class: com.newrelic.agent.android.ndk.NativeReporting.NativeReportListener.2
                {
                    put("platform", "native");
                    put(AnalyticsAttribute.UNHANDLED_NATIVE_EXCEPTION, true);
                }
            };
            NativeUnhandledException nativeUnhandledException = new NativeUnhandledException(str);
            map.put(AnalyticsAttribute.NATIVE_THREADS_ATTRIBUTE, nativeUnhandledException.getNativeStackTrace().getThreads());
            map.put(AnalyticsAttribute.NATIVE_EXCEPTION_MESSAGE_ATTRIBUTE, nativeUnhandledException.getNativeStackTrace().getExceptionMessage());
            if (nativeUnhandledException.getNativeStackTrace().getCrashedThread() != null) {
                map.put(AnalyticsAttribute.NATIVE_CRASHING_THREAD_ID_ATTRIBUTE, Long.valueOf(nativeUnhandledException.getNativeStackTrace().getCrashedThread().getThreadId()));
            }
            if (AgentDataReporter.getInstance() != null) {
                return AgentDataController.sendAgentData(nativeUnhandledException, map);
            }
            NativeReporting.log.error("Could not report native exception: AgentDataReporter is disabled.");
            return false;
        }

        @Override // com.newrelic.agent.android.ndk.AgentNDKListener
        public boolean onApplicationNotResponding(String str) {
            StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_NDK_REPORTS_ANR);
            HashMap<String, Object> map = new HashMap<String, Object>() { // from class: com.newrelic.agent.android.ndk.NativeReporting.NativeReportListener.3
                {
                    put("platform", "native");
                    put("ANR", true);
                }
            };
            ANRException aNRException = new ANRException(str);
            map.put(AnalyticsAttribute.NATIVE_THREADS_ATTRIBUTE, aNRException.getNativeStackTrace().getThreads());
            map.put(AnalyticsAttribute.NATIVE_EXCEPTION_MESSAGE_ATTRIBUTE, aNRException.getNativeStackTrace().getExceptionMessage());
            if (aNRException.getNativeStackTrace().getCrashedThread() != null) {
                map.put(AnalyticsAttribute.NATIVE_CRASHING_THREAD_ID_ATTRIBUTE, Long.valueOf(aNRException.getNativeStackTrace().getCrashedThread().getThreadId()));
            }
            if (AgentDataReporter.getInstance() != null) {
                return AgentDataController.sendAgentData(aNRException, map);
            }
            NativeReporting.log.error("Could not report native exception: AgentDataReporter is disabled.");
            return false;
        }
    }
}
