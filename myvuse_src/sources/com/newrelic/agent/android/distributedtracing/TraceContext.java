package com.newrelic.agent.android.distributedtracing;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.stats.StatsEngine;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public abstract class TraceContext {
    public static final String INVALID_SPAN_ID = "0000000000000000";
    public static final String INVALID_TRACE_ID = "00000000000000000000000000000000";
    static final String SPAN_ID_REGEX = "^([A-Fa-f0-9]{16})?";
    public static final String SUPPORTABILITY_TRACE_CONTEXT_CREATED = "Supportability/TraceContext/Create/Success";
    public static final String SUPPORTABILITY_TRACE_CONTEXT_EXCEPTION = "Supportability/TraceContext/Create/Exception/%s";
    static final String TRACE_FIELD_UNUSED = "";
    static final String TRACE_ID_REGEX = "^[A-Fa-f0-9]{32}";
    protected static final AgentLog log = AgentLogManager.getAgentLog();
    final Map<String, String> requestContext;
    final String traceId;
    final TraceParent traceParent;
    final TracePayload tracePayload;
    final TraceState traceState;
    boolean legacyHeadersEnabled = true;
    final TraceConfiguration traceConfiguration = TraceConfiguration.getInstance();

    public static TraceContext createTraceContext(Map<String, String> map) {
        return new W3CTraceContext(map);
    }

    public TraceContext(Map<String, String> map) {
        map = map == null ? new HashMap<>() : map;
        this.requestContext = map;
        this.traceId = DistributedTracing.generateTraceId();
        this.traceParent = TraceParent.createTraceParent(this);
        this.traceState = TraceState.createTraceState(this);
        this.tracePayload = new TracePayload(this);
        map.put("thread.id", String.valueOf(Thread.currentThread().getId()));
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String getParentId() {
        return this.traceParent.getParentId();
    }

    public String getSampled() {
        return String.format(Locale.ROOT, "%02x", Integer.valueOf(this.traceConfiguration.isSampled() ? 1 : 0));
    }

    public String getVendor() {
        return String.format(Locale.ROOT, "%s@nr", this.traceConfiguration.trustedAccountId);
    }

    public String getAccountId() {
        return String.format(Locale.ROOT, "%s", this.traceConfiguration.accountId);
    }

    public String getApplicationId() {
        return String.format(Locale.ROOT, "%s", this.traceConfiguration.applicationId);
    }

    public Set<TraceHeader> getHeaders() {
        return new HashSet<TraceHeader>() { // from class: com.newrelic.agent.android.distributedtracing.TraceContext.1
            {
                if (TraceContext.this.legacyHeadersEnabled) {
                    add(TraceContext.this.tracePayload);
                }
            }
        };
    }

    public TracePayload getTracePayload() {
        return this.tracePayload;
    }

    public static void reportSupportabilityMetrics() {
        StatsEngine.get().inc(SUPPORTABILITY_TRACE_CONTEXT_CREATED);
    }

    public static void reportSupportabilityExceptionMetric(Exception exc) {
        log.error("setDistributedTraceHeaders: Unable to add trace headers. ", exc);
        StatsEngine.get().inc(String.format(Locale.ROOT, SUPPORTABILITY_TRACE_CONTEXT_EXCEPTION, exc.getClass().getSimpleName()));
    }

    public Map<String, Object> asTraceAttributes() {
        return new HashMap<String, Object>() { // from class: com.newrelic.agent.android.distributedtracing.TraceContext.2
            {
                put("id", TraceContext.this.tracePayload.spanId);
                put(DistributedTracing.NR_GUID_ATTRIBUTE, TraceContext.this.tracePayload.spanId);
                put(DistributedTracing.NR_TRACE_ID_ATTRIBUTE, TraceContext.this.traceId);
            }
        };
    }

    public void putRequestContext(Map<String, String> map) {
        if (map != null) {
            this.requestContext.putAll(map);
        }
    }

    public Map<String, String> getRequestContext() {
        return this.requestContext;
    }

    static class W3CTraceContext extends TraceContext {
        public W3CTraceContext(Map<String, String> map) {
            super(map);
        }

        @Override // com.newrelic.agent.android.distributedtracing.TraceContext
        public String getParentId() {
            return this.traceParent.getParentId();
        }

        @Override // com.newrelic.agent.android.distributedtracing.TraceContext
        public Set<TraceHeader> getHeaders() {
            Set<TraceHeader> headers = super.getHeaders();
            headers.add(this.traceParent);
            headers.add(this.traceState);
            return headers;
        }
    }
}
