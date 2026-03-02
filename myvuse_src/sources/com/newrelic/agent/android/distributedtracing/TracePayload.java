package com.newrelic.agent.android.distributedtracing;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;

/* JADX INFO: loaded from: classes6.dex */
public class TracePayload implements TraceHeader {
    static final String ACCOUNT_ID_KEY = "ac";
    static final String APP_ID_KEY = "ap";
    static final String CALLER_TYPE = "Mobile";
    static final String DATA_KEY = "d";
    static final String GUID_KEY = "id";
    static final int MAJOR_VERSION = 0;
    static final int MINOR_VERSION = 2;
    static final String PAYLOAD_TYPE_KEY = "ty";
    static final String TIMESTAMP_KEY = "ti";
    static final String TRACE_ID_KEY = "tr";
    public static final String TRACE_PAYLOAD_HEADER = "newrelic";
    static final String TRUST_ACCOUNT_KEY = "tk";
    static final String VERSION_KEY = "v";
    private static final AgentLog log = AgentLogManager.getAgentLog();
    final String spanId;
    final long timestampMs = DistributedTracing.generateNormalizedTimestamp();
    final TraceContext traceContext;

    public TracePayload(TraceContext traceContext) {
        String parentId;
        this.traceContext = traceContext;
        if (traceContext.tracePayload == null) {
            parentId = traceContext.getParentId();
        } else {
            parentId = traceContext.tracePayload.spanId;
        }
        this.spanId = parentId;
    }

    public JsonObject asJson() {
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        JsonObject jsonObject2 = new JsonObject();
        try {
            jsonArray.add(new JsonPrimitive((Number) 0));
            jsonArray.add(new JsonPrimitive((Number) 2));
            jsonObject2.add(PAYLOAD_TYPE_KEY, new JsonPrimitive("Mobile"));
            jsonObject2.add(ACCOUNT_ID_KEY, new JsonPrimitive(this.traceContext.traceConfiguration.accountId));
            jsonObject2.add(APP_ID_KEY, new JsonPrimitive(this.traceContext.traceConfiguration.applicationId));
            jsonObject2.add(TRACE_ID_KEY, new JsonPrimitive(this.traceContext.traceId));
            jsonObject2.add("id", new JsonPrimitive(this.spanId));
            jsonObject2.add(TIMESTAMP_KEY, new JsonPrimitive(Long.valueOf(this.timestampMs)));
            jsonObject2.add(TRUST_ACCOUNT_KEY, new JsonPrimitive(this.traceContext.traceConfiguration.trustedAccountId));
            jsonObject.add(VERSION_KEY, jsonArray);
            jsonObject.add("d", jsonObject2);
        } catch (Exception e) {
            log.error("Unable to create payload asJSON", e);
        }
        return jsonObject;
    }

    String asBase64Json() {
        try {
            return Agent.getEncoder().encodeNoWrap(asJson().toString().getBytes());
        } catch (Exception e) {
            log.error("asBase64Json: " + e.getLocalizedMessage());
            return "";
        }
    }

    public String getTraceId() {
        return this.traceContext.getTraceId();
    }

    public String getSpanId() {
        return this.spanId;
    }

    @Override // com.newrelic.agent.android.distributedtracing.TraceHeader
    public String getHeaderName() {
        return "newrelic";
    }

    @Override // com.newrelic.agent.android.distributedtracing.TraceHeader
    public String getHeaderValue() {
        return asBase64Json();
    }
}
