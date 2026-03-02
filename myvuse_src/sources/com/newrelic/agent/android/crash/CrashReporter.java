package com.newrelic.agent.android.crash;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.payload.PayloadController;
import com.newrelic.agent.android.payload.PayloadReporter;
import com.newrelic.agent.android.payload.PayloadSender;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.util.Constants;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public class CrashReporter extends PayloadReporter {
    protected static AtomicReference<CrashReporter> instance = new AtomicReference<>(null);
    private static boolean jitCrashReporting = false;
    protected final CrashStore crashStore;
    private final UncaughtExceptionHandler uncaughtExceptionHandler;

    public static CrashReporter getInstance() {
        return instance.get();
    }

    public static CrashReporter initialize(AgentConfiguration agentConfiguration) {
        PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m1161m(instance, null, new CrashReporter(agentConfiguration));
        Harvest.addHarvestListener(instance.get());
        return instance.get();
    }

    public static void shutdown() {
        if (isInitialized()) {
            instance.get().stop();
            instance.set(null);
        }
    }

    public static void setReportCrashes(boolean z) {
        if (isInitialized()) {
            jitCrashReporting = z;
        }
    }

    public static boolean getReportCrashes() {
        return jitCrashReporting;
    }

    public static UncaughtExceptionHandler getUncaughtExceptionHandler() {
        if (isInitialized()) {
            return instance.get().uncaughtExceptionHandler;
        }
        return null;
    }

    protected static boolean isInitialized() {
        return instance.get() != null;
    }

    protected CrashReporter(AgentConfiguration agentConfiguration) {
        super(agentConfiguration);
        this.uncaughtExceptionHandler = new UncaughtExceptionHandler(this);
        this.crashStore = agentConfiguration.getCrashStore();
        this.isEnabled.set(FeatureFlag.featureEnabled(FeatureFlag.CrashReporting));
    }

    @Override // com.newrelic.agent.android.payload.PayloadReporter
    public void start() {
        if (isInitialized()) {
            if (isEnabled()) {
                if (this.isStarted.compareAndSet(false, true)) {
                    this.uncaughtExceptionHandler.installExceptionHandler();
                    jitCrashReporting = this.agentConfiguration.getReportCrashes();
                    return;
                }
                return;
            }
            log.warn("CrashReporter: Crash reporting feature is disabled.");
            return;
        }
        log.error("CrashReporter: Must initialize PayloadController first.");
    }

    @Override // com.newrelic.agent.android.payload.PayloadReporter
    protected void stop() {
        if (getUncaughtExceptionHandler() != null) {
            getUncaughtExceptionHandler().resetExceptionHandler();
        }
    }

    protected void reportSavedCrashes() {
        CrashStore crashStore = this.crashStore;
        if (crashStore != null) {
            for (Crash crash : crashStore.fetchAll()) {
                if (crash.isStale()) {
                    this.crashStore.delete(crash);
                    log.info("CrashReporter: Crash [" + crash.getUuid().toString() + "] has become stale, and has been removed");
                    StatsEngine.get().inc(MetricNames.SUPPORTABILITY_CRASH_REMOVED_STALE);
                } else {
                    reportCrash(crash);
                }
            }
        }
    }

    protected Future reportCrash(final Crash crash) {
        if (crash != null) {
            boolean zIsValid = crash.getDataToken().isValid();
            if (!isEnabled()) {
                log.warn("CrashReporter: agent has not successfully connected and cannot report crashes.");
            } else {
                if (zIsValid) {
                    CrashSender crashSender = new CrashSender(crash, this.agentConfiguration);
                    if (crash.asJsonObject().toString().getBytes().length > Constants.Network.MAX_PAYLOAD_SIZE) {
                        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_MAXPAYLOADSIZELIMIT_ENDPOINT.replace(MetricNames.TAG_FRAMEWORK, Agent.getDeviceInformation().getApplicationFramework().name()).replace(MetricNames.TAG_DESTINATION, MetricNames.METRIC_DATA_USAGE_COLLECTOR).replace(MetricNames.TAG_SUBDESTINATION, "mobile_crash"));
                        this.crashStore.delete(crash);
                        log.error("Unable to upload crashes because payload is larger than 1 MB, crash report is discarded.");
                        return null;
                    }
                    PayloadSender.CompletionHandler completionHandler = new PayloadSender.CompletionHandler() { // from class: com.newrelic.agent.android.crash.CrashReporter.1
                        @Override // com.newrelic.agent.android.payload.PayloadSender.CompletionHandler
                        public void onResponse(PayloadSender payloadSender) {
                            if (payloadSender.isSuccessfulResponse()) {
                                if (CrashReporter.this.crashStore != null) {
                                    CrashReporter.this.crashStore.delete(crash);
                                }
                                StatsEngine.get().sampleMetricDataUsage(MetricNames.SUPPORTABILITY_SUBDESTINATION_OUTPUT_BYTES.replace(MetricNames.TAG_FRAMEWORK, Agent.getDeviceInformation().getApplicationFramework().name()).replace(MetricNames.TAG_DESTINATION, MetricNames.METRIC_DATA_USAGE_COLLECTOR).replace(MetricNames.TAG_SUBDESTINATION, "mobile_crash"), crash.asJsonObject().toString().getBytes().length, 0.0f);
                                return;
                            }
                            if (FeatureFlag.featureEnabled(FeatureFlag.OfflineStorage)) {
                                CrashReporter.log.warn("CrashReporter didn't send due to lack of network connection");
                            }
                        }

                        @Override // com.newrelic.agent.android.payload.PayloadSender.CompletionHandler
                        public void onException(PayloadSender payloadSender, Exception exc) {
                            CrashReporter.log.error("CrashReporter: Crash upload failed: " + String.valueOf(exc));
                        }
                    };
                    if (!crashSender.shouldUploadOpportunistically()) {
                        log.warn("CrashReporter: network is unreachable. Crash will be uploaded on next app launch");
                    }
                    return PayloadController.submitPayload(crashSender, completionHandler);
                }
                log.warn("CrashReporter: attempted to report null crash.");
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028 A[Catch: Exception -> 0x003e, TryCatch #0 {Exception -> 0x003e, blocks: (B:11:0x0024, B:13:0x0028, B:15:0x002e, B:16:0x0036), top: B:21:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void storeAndReportCrash(com.newrelic.agent.android.crash.Crash r4) {
        /*
            r3 = this;
            com.newrelic.agent.android.crash.CrashStore r0 = r3.crashStore
            if (r0 == 0) goto L1c
            if (r4 == 0) goto L14
            boolean r0 = r0.store(r4)
            if (r0 != 0) goto L24
            com.newrelic.agent.android.logging.AgentLog r1 = com.newrelic.agent.android.crash.CrashReporter.log
            java.lang.String r2 = "CrashReporter: failed to store passed crash."
            r1.warn(r2)
            goto L24
        L14:
            com.newrelic.agent.android.logging.AgentLog r0 = com.newrelic.agent.android.crash.CrashReporter.log
            java.lang.String r1 = "CrashReporter: attempted to store null crash."
            r0.warn(r1)
            goto L23
        L1c:
            com.newrelic.agent.android.logging.AgentLog r0 = com.newrelic.agent.android.crash.CrashReporter.log
            java.lang.String r1 = "CrashReporter: attempted to store crash without a crash store."
            r0.warn(r1)
        L23:
            r0 = 0
        L24:
            boolean r1 = com.newrelic.agent.android.crash.CrashReporter.jitCrashReporting     // Catch: java.lang.Exception -> L3e
            if (r1 == 0) goto L2c
            r3.reportCrash(r4)     // Catch: java.lang.Exception -> L3e
            goto L57
        L2c:
            if (r0 == 0) goto L36
            com.newrelic.agent.android.logging.AgentLog r4 = com.newrelic.agent.android.crash.CrashReporter.log     // Catch: java.lang.Exception -> L3e
            java.lang.String r0 = "CrashReporter: Crash has been recorded and will be uploaded during the next app launch."
            r4.debug(r0)     // Catch: java.lang.Exception -> L3e
            goto L57
        L36:
            com.newrelic.agent.android.logging.AgentLog r4 = com.newrelic.agent.android.crash.CrashReporter.log     // Catch: java.lang.Exception -> L3e
            java.lang.String r0 = "CrashReporter: Crash was dropped (Crash not stored and Just-in-time crash reporting is disabled)."
            r4.error(r0)     // Catch: java.lang.Exception -> L3e
            goto L57
        L3e:
            r4 = move-exception
            com.newrelic.agent.android.logging.AgentLog r0 = com.newrelic.agent.android.crash.CrashReporter.log
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "CrashReporter.storeAndReportCrash(Crash): "
            r1.<init>(r2)
            java.lang.StringBuilder r4 = r1.append(r4)
            java.lang.String r4 = r4.toString()
            r0.warn(r4)
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.newrelic.agent.android.crash.CrashReporter.storeAndReportCrash(com.newrelic.agent.android.crash.Crash):void");
    }

    @Override // com.newrelic.agent.android.harvest.HarvestLifecycleAware
    public void onHarvestConnected() {
        PayloadController.submitCallable(new Callable() { // from class: com.newrelic.agent.android.crash.CrashReporter.2
            @Override // java.util.concurrent.Callable
            public Void call() {
                CrashReporter.this.reportSavedCrashes();
                return null;
            }
        });
    }
}
