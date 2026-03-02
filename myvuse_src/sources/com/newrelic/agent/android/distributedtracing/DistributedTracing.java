package com.newrelic.agent.android.distributedtracing;

import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.agentdata.AgentDataController;
import com.newrelic.agent.android.harvest.HarvestConfiguration;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public class DistributedTracing implements TraceFacade, TraceListener {
    public static final String ACTION_TYPE_ATTRIBUTE = "actionType";
    public static final String NR_GUID_ATTRIBUTE = "guid";
    public static final String NR_ID_ATTRIBUTE = "id";
    public static final String NR_SPAN_ID_ATTRIBUTE = "span.id";
    public static final String NR_TRACE_ID_ATTRIBUTE = "trace.id";
    static final DistributedTracing instance = new DistributedTracing();
    static final AgentLog log = AgentLogManager.getAgentLog();
    AtomicReference<TraceListener> traceListener = new AtomicReference<>(this);

    @Override // com.newrelic.agent.android.distributedtracing.TraceListener
    public void onSpanCreated(Map<String, String> map) {
    }

    @Override // com.newrelic.agent.android.distributedtracing.TraceListener
    public void onTraceCreated(Map<String, String> map) {
    }

    public static final DistributedTracing getInstance() {
        return instance;
    }

    @Override // com.newrelic.agent.android.distributedtracing.TraceFacade
    public TraceContext startTrace(TransactionState transactionState) {
        TraceContext traceContextCreateTraceContext = TraceContext.createTraceContext(new HashMap<String, String>(transactionState) { // from class: com.newrelic.agent.android.distributedtracing.DistributedTracing.1
            final /* synthetic */ TransactionState val$transactionState;

            {
                this.val$transactionState = transactionState;
                put("url", transactionState.getUrl());
                put("httpMethod", transactionState.getHttpMethod());
                put("thread.id", Long.toString(Thread.currentThread().getId()));
            }
        });
        invokeListeners(traceContextCreateTraceContext);
        return traceContextCreateTraceContext;
    }

    @Override // com.newrelic.agent.android.distributedtracing.TraceFacade
    public void setConfiguration(TraceConfiguration traceConfiguration) {
        TraceConfiguration.setInstance(traceConfiguration);
    }

    @Override // com.newrelic.agent.android.distributedtracing.TraceFacade
    public void setTraceListener(TraceListener traceListener) {
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
            if (traceListener == null) {
                this.traceListener.set(this);
            } else {
                this.traceListener.set(traceListener);
            }
        }
    }

    public void setConfiguration(HarvestConfiguration harvestConfiguration) {
        TraceConfiguration.getInstance().setConfiguration(harvestConfiguration);
    }

    private void invokeListeners(TraceContext traceContext) {
        try {
            traceContext.requestContext.put(NR_TRACE_ID_ATTRIBUTE, traceContext.traceId);
            instance.traceListener.get().onTraceCreated(traceContext.requestContext);
        } catch (Exception e) {
            DistributedTracing distributedTracing = instance;
            distributedTracing.traceListener.set(distributedTracing);
            log.error("The provided listener has thrown an exception and has been removed: " + e.getLocalizedMessage());
            AgentDataController.sendAgentData(e, null);
        }
        try {
            traceContext.requestContext.put(NR_SPAN_ID_ATTRIBUTE, traceContext.tracePayload.getSpanId());
            instance.traceListener.get().onSpanCreated(traceContext.requestContext);
        } catch (Exception e2) {
            DistributedTracing distributedTracing2 = instance;
            distributedTracing2.traceListener.set(distributedTracing2);
            log.error("The provided listener has thrown an exception and has been removed: " + e2.getLocalizedMessage());
            AgentDataController.sendAgentData(e2, new HashMap());
        }
    }

    static String generateRandomBytes(int i) {
        String str = "";
        while (str.length() < i) {
            str = str + UUID.randomUUID().toString().replace("-", "");
        }
        return str.substring(0, i);
    }

    public static String generateTraceId() {
        return generateRandomBytes(32);
    }

    public static String generateSpanId() {
        return generateRandomBytes(16);
    }

    public static long generateNormalizedTimestamp() {
        return System.currentTimeMillis();
    }

    public static void setDistributedTraceListener(TraceListener traceListener) {
        instance.setTraceListener(traceListener);
    }
}
