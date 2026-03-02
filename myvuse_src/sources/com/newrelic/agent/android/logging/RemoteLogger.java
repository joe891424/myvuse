package com.newrelic.agent.android.logging;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.harvest.HarvestLifecycleAware;
import com.newrelic.agent.android.util.NamedThreadFactory;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class RemoteLogger implements HarvestLifecycleAware, Logger {
    protected ThreadPoolExecutor executor;
    static int POOL_SIZE = Math.max(2, Runtime.getRuntime().availableProcessors() / 4);
    static long QUEUE_THREAD_TTL = 1000;
    static MessageValidator validator = LogReporting.validator;
    static int MAX_ATTRIBUTES_PER_EVENT = 255;
    static int MAX_ATTRIBUTES_NAME_SIZE = 255;
    static int MAX_ATTRIBUTES_VALUE_SIZE = 4096;

    public RemoteLogger() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, POOL_SIZE, QUEUE_THREAD_TTL, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("LogReporting"));
        this.executor = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.executor.prestartCoreThread();
    }

    @Override // com.newrelic.agent.android.logging.Logger
    public void log(LogLevel logLevel, String str) {
        if (isLevelEnabled(logLevel)) {
            appendToWorkingLogfile(logLevel, validator.validate(str), null, null);
        }
    }

    @Override // com.newrelic.agent.android.logging.Logger
    public void logThrowable(LogLevel logLevel, String str, Throwable th) {
        if (isLevelEnabled(logLevel)) {
            appendToWorkingLogfile(logLevel, str, validator.validate(th), null);
        }
    }

    @Override // com.newrelic.agent.android.logging.Logger
    public void logAttributes(Map<String, Object> map) {
        Map<String, Object> mapValidate = validator.validate(map);
        LogLevel logLevelValueOf = LogLevel.valueOf(((String) mapValidate.getOrDefault(FirebaseAnalytics.Param.LEVEL, LogLevel.INFO.name())).toUpperCase());
        if (isLevelEnabled(logLevelValueOf)) {
            appendToWorkingLogfile(logLevelValueOf, (String) mapValidate.getOrDefault("message", null), null, mapValidate);
        }
    }

    @Override // com.newrelic.agent.android.logging.Logger
    public void logAll(Throwable th, Map<String, Object> map) {
        Map<String, Object> mapValidate = validator.validate(map);
        String str = (String) mapValidate.getOrDefault(FirebaseAnalytics.Param.LEVEL, LogLevel.INFO.name());
        if (isLevelEnabled(LogLevel.valueOf(str.toUpperCase()))) {
            appendToWorkingLogfile(LogLevel.valueOf(str.toUpperCase()), validator.validate((String) mapValidate.getOrDefault("message", null)), th, mapValidate);
        }
    }

    public void appendToWorkingLogfile(final LogLevel logLevel, final String str, final Throwable th, final Map<String, Object> map) {
        if (LogReporting.isRemoteLoggingEnabled() && isLevelEnabled(logLevel) && AgentConfiguration.getInstance().getLogReportingConfiguration().isSampled()) {
            if ((str == null || str.isEmpty()) && th == null && (map == null || map.isEmpty())) {
                return;
            }
            final LogReporter logReporter = LogReporter.getInstance();
            Callable callable = new Callable() { // from class: com.newrelic.agent.android.logging.RemoteLogger$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f$0.m2740xa42c13a1(logLevel, str, th, map, logReporter);
                }
            };
            if (this.executor.isTerminating() || this.executor.isShutdown()) {
                try {
                    callable.call();
                    return;
                } catch (Exception e) {
                    AgentLogManager.getAgentLog().error(e.toString());
                    return;
                }
            }
            synchronized (this.executor) {
                this.executor.submit(callable);
            }
        }
    }

    /* JADX INFO: renamed from: lambda$appendToWorkingLogfile$0$com-newrelic-agent-android-logging-RemoteLogger */
    /* synthetic */ Boolean m2740xa42c13a1(LogLevel logLevel, String str, Throwable th, Map map, LogReporter logReporter) throws Exception {
        try {
            try {
                LogReporter.workingFileLock.lock();
                HashMap map2 = new HashMap();
                map2.put("timestamp", String.valueOf(System.currentTimeMillis()));
                map2.put(FirebaseAnalytics.Param.LEVEL, logLevel.name().toUpperCase());
                if (str != null) {
                    map2.put("message", str);
                }
                if (th != null) {
                    map2.put("error.message", th.toString());
                    map2.put("error.stack", th.getStackTrace()[0].toString());
                    map2.put("error.class", th.getClass().getSimpleName());
                }
                if (map != null) {
                    map2.put(C4352k.a.f5654h, map);
                }
                LogReporter.workingFileLock.unlock();
                if (logReporter == null) {
                    synchronized (this.executor) {
                        this.executor.notify();
                    }
                    return false;
                }
                logReporter.appendToWorkingLogfile(map2);
                synchronized (this.executor) {
                    this.executor.notify();
                }
                return true;
            } catch (IOException e) {
                AgentLogManager.getAgentLog().error("Error recording log message: " + e.toString());
                synchronized (this.executor) {
                    this.executor.notify();
                    return false;
                }
            }
        } catch (Throwable th2) {
            synchronized (this.executor) {
                this.executor.notify();
                throw th2;
            }
        }
    }

    @Override // com.newrelic.agent.android.harvest.HarvestLifecycleAware
    public void onHarvest() {
        flush();
    }

    @Override // com.newrelic.agent.android.harvest.HarvestLifecycleAware
    public void onHarvestStop() {
        try {
            onHarvest();
        } catch (Exception e) {
            AgentLogManager.getAgentLog().error(e.toString());
        }
    }

    private int getPendingTaskCount() {
        return this.executor.getQueue().size() + this.executor.getActiveCount();
    }

    protected void flush() {
        synchronized (this.executor) {
            while (getPendingTaskCount() > 0 && !this.executor.isTerminating() && !this.executor.isTerminated()) {
                try {
                    this.executor.wait(QUEUE_THREAD_TTL, 0);
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    void shutdown() {
        this.executor.shutdown();
        try {
            this.executor.awaitTermination(3L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            this.executor.shutdownNow();
        }
    }
}
