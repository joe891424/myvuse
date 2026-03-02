package com.newrelic.agent.android.agentdata;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.payload.Payload;
import com.newrelic.agent.android.payload.PayloadController;
import com.newrelic.agent.android.payload.PayloadReporter;
import com.newrelic.agent.android.payload.PayloadSender;
import com.newrelic.agent.android.payload.PayloadStore;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.util.Constants;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public class AgentDataReporter extends PayloadReporter {
    protected static final AtomicReference<AgentDataReporter> instance = new AtomicReference<>(null);
    private static boolean reportExceptions = false;
    protected final PayloadStore<Payload> payloadStore;
    protected final Callable reportCachedAgentDataCallable;

    public static AgentDataReporter getInstance() {
        return instance.get();
    }

    public static AgentDataReporter initialize(AgentConfiguration agentConfiguration) {
        AtomicReference<AgentDataReporter> atomicReference = instance;
        PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m1161m(atomicReference, null, new AgentDataReporter(agentConfiguration));
        reportExceptions = agentConfiguration.getReportHandledExceptions();
        return atomicReference.get();
    }

    public static void shutdown() {
        if (isInitialized()) {
            try {
                AtomicReference<AgentDataReporter> atomicReference = instance;
                atomicReference.get().stop();
                atomicReference.set(null);
            } catch (Throwable th) {
                instance.set(null);
                throw th;
            }
        }
    }

    public static boolean reportAgentData(byte[] bArr) {
        if (isInitialized()) {
            if (reportExceptions) {
                instance.get().storeAndReportAgentData(new Payload(bArr));
                return true;
            }
        } else {
            log.error("AgentDataReporter not initialized");
        }
        return false;
    }

    protected static boolean isInitialized() {
        return instance.get() != null;
    }

    protected AgentDataReporter(AgentConfiguration agentConfiguration) {
        super(agentConfiguration);
        this.reportCachedAgentDataCallable = new Callable() { // from class: com.newrelic.agent.android.agentdata.AgentDataReporter.1
            @Override // java.util.concurrent.Callable
            public Object call() throws Exception {
                AgentDataReporter.this.reportCachedAgentData();
                return null;
            }
        };
        this.payloadStore = agentConfiguration.getPayloadStore();
        this.isEnabled.set(FeatureFlag.featureEnabled(FeatureFlag.HandledExceptions));
    }

    @Override // com.newrelic.agent.android.payload.PayloadReporter
    public void start() {
        if (PayloadController.isInitialized()) {
            if (isEnabled() && this.isStarted.compareAndSet(false, true)) {
                PayloadController.submitCallable(this.reportCachedAgentDataCallable);
                Harvest.addHarvestListener(this);
                return;
            }
            return;
        }
        log.error("AgentDataReporter.start(): Must initialize PayloadController first.");
    }

    @Override // com.newrelic.agent.android.payload.PayloadReporter
    public void stop() {
        Harvest.removeHarvestListener(this);
    }

    protected void reportCachedAgentData() {
        if (Agent.hasReachableNetworkConnection(null)) {
            if (isInitialized()) {
                PayloadStore<Payload> payloadStore = this.payloadStore;
                if (payloadStore != null) {
                    for (Payload payload : payloadStore.fetchAll()) {
                        if (!isPayloadStale(payload)) {
                            reportAgentData(payload);
                        }
                    }
                    return;
                }
                return;
            }
            log.error("AgentDataReporter not initialized");
        }
    }

    public Future reportAgentData(Payload payload) {
        AgentDataSender agentDataSender = new AgentDataSender(payload, getAgentConfiguration());
        if (payload.getBytes().length > Constants.Network.MAX_PAYLOAD_SIZE) {
            StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_MAXPAYLOADSIZELIMIT_ENDPOINT.replace(MetricNames.TAG_FRAMEWORK, Agent.getDeviceInformation().getApplicationFramework().name()).replace(MetricNames.TAG_DESTINATION, MetricNames.METRIC_DATA_USAGE_COLLECTOR).replace(MetricNames.TAG_SUBDESTINATION, "f"));
            this.payloadStore.delete(payload);
            log.error("Unable to upload handled exceptions because payload is larger than 1 MB, handled exceptions are discarded.");
            return null;
        }
        return PayloadController.submitPayload(agentDataSender, new PayloadSender.CompletionHandler() { // from class: com.newrelic.agent.android.agentdata.AgentDataReporter.2
            @Override // com.newrelic.agent.android.payload.PayloadSender.CompletionHandler
            public void onResponse(PayloadSender payloadSender) {
                if (payloadSender.isSuccessfulResponse()) {
                    if (AgentDataReporter.this.payloadStore != null) {
                        AgentDataReporter.this.payloadStore.delete(payloadSender.getPayload());
                    }
                    StatsEngine.get().sampleMetricDataUsage(MetricNames.SUPPORTABILITY_SUBDESTINATION_OUTPUT_BYTES.replace(MetricNames.TAG_FRAMEWORK, Agent.getDeviceInformation().getApplicationFramework().name()).replace(MetricNames.TAG_DESTINATION, MetricNames.METRIC_DATA_USAGE_COLLECTOR).replace(MetricNames.TAG_SUBDESTINATION, "f"), payloadSender.getPayload().getBytes().length, 0.0f);
                    return;
                }
                if (FeatureFlag.featureEnabled(FeatureFlag.OfflineStorage)) {
                    AgentDataReporter.log.warn("AgentDataReporter didn't send due to lack of network connection");
                }
            }

            @Override // com.newrelic.agent.android.payload.PayloadSender.CompletionHandler
            public void onException(PayloadSender payloadSender, Exception exc) {
                AgentDataReporter.log.error("AgentDataReporter.reportAgentData(Payload): " + String.valueOf(exc));
            }
        });
    }

    public Future storeAndReportAgentData(Payload payload) {
        if (this.payloadStore != null && payload.isPersisted() && this.payloadStore.store(payload)) {
            payload.setPersisted(false);
        }
        return reportAgentData(payload);
    }

    @Override // com.newrelic.agent.android.payload.PayloadReporter
    protected boolean isPayloadStale(Payload payload) {
        if (!payload.isStale(this.agentConfiguration.getPayloadTTL())) {
            return false;
        }
        this.payloadStore.delete(payload);
        log.info("Payload [" + payload.getUuid() + "] has become stale, and has been removed");
        StatsEngine.get().inc(MetricNames.SUPPORTABILITY_PAYLOAD_REMOVED_STALE);
        return true;
    }

    @Override // com.newrelic.agent.android.harvest.HarvestLifecycleAware
    public void onHarvest() {
        PayloadController.submitCallable(this.reportCachedAgentDataCallable);
    }
}
