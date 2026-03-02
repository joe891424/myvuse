package com.newrelic.agent.android.distributedtracing;

import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public abstract class TraceParent implements TraceHeader {
    public static final String TRACE_PARENT_HEADER = "traceparent";
    static final String TRACE_PARENT_HEADER_FMT = "%s-%s-%s-%s";
    static final int TRACE_PARENT_VERSION = 0;
    final String parentId = DistributedTracing.generateSpanId();
    final TraceContext traceContext;

    public static TraceParent createTraceParent(TraceContext traceContext) {
        return new W3CTraceParent(traceContext);
    }

    protected TraceParent(TraceContext traceContext) {
        this.traceContext = traceContext;
    }

    @Override // com.newrelic.agent.android.distributedtracing.TraceHeader
    public String getHeaderName() {
        return TRACE_PARENT_HEADER;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getVersion() {
        return String.format(Locale.ROOT, "%02x", 0);
    }

    static class W3CTraceParent extends TraceParent {
        static final String TRACE_PARENT_HEADER_REGEX = "^(\\d+)-([A-Fa-f0-9]{32})-([A-Fa-f0-9]{16})?-(\\d+)$";

        W3CTraceParent(TraceContext traceContext) {
            super(traceContext);
        }

        @Override // com.newrelic.agent.android.distributedtracing.TraceHeader
        public String getHeaderValue() {
            return String.format(Locale.ROOT, TraceParent.TRACE_PARENT_HEADER_FMT, getVersion(), this.traceContext.traceId, this.parentId, this.traceContext.getSampled());
        }
    }
}
