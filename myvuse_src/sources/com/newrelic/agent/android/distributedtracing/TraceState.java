package com.newrelic.agent.android.distributedtracing;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public abstract class TraceState implements TraceHeader {
    public static final String TRACE_STATE_HEADER = "tracestate";
    static final int TRACE_STATE_PARENT_TYPE = 2;
    static final int TRACE_STATE_VERSION = 0;
    final TraceContext traceContext;
    final long timestampMs = DistributedTracing.generateNormalizedTimestamp();
    final Map<String, String> entries = new HashMap();

    public static TraceState createTraceState(TraceContext traceContext) {
        return new W3CTraceState(traceContext);
    }

    TraceState(TraceContext traceContext) {
        this.traceContext = traceContext;
    }

    @Override // com.newrelic.agent.android.distributedtracing.TraceHeader
    public String getHeaderName() {
        return TRACE_STATE_HEADER;
    }

    static class W3CTraceState extends TraceState {
        static final String TRACE_STATE_ENTRY_REGEX = "(\\d)-(\\d+)-(\\d+)?-(\\d+)?-(\\w*)?-(\\w+)?-(\\d{1,2})?-(\\w)?-(\\d+)$";
        static final String TRACE_STATE_HEADER_FMT = "%1d-%1d-%s-%s-%s-%s-%s-%s-%d";
        static final String TRACE_STATE_HEADER_REGEX = "^(\\d+)?@nr=(\\d)-(\\d)-(\\d+)?-(\\d+)?-(\\w+)?-(\\w)?-(\\d{1,2})?-(\\w)?-(\\d+)$";
        static final String TRACE_STATE_VENDOR_REGEX = "^(\\d+?)(@nr)(=.*)?";

        W3CTraceState(TraceContext traceContext) {
            super(traceContext);
            this.entries.put(traceContext.getVendor(), getVendorState());
        }

        @Override // com.newrelic.agent.android.distributedtracing.TraceHeader
        public String getHeaderValue() {
            StringBuilder sb = new StringBuilder();
            for (String str : this.entries.keySet()) {
                sb.append(String.format("%s=%s,", str, this.entries.get(str)));
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        String getVendorState() {
            return String.format(Locale.ROOT, TRACE_STATE_HEADER_FMT, 0, 2, this.traceContext.getAccountId(), this.traceContext.getApplicationId(), this.traceContext.getParentId(), "", "", "", Long.valueOf(this.timestampMs));
        }
    }
}
