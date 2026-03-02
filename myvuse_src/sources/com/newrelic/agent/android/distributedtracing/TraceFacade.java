package com.newrelic.agent.android.distributedtracing;

import com.newrelic.agent.android.instrumentation.TransactionState;

/* JADX INFO: loaded from: classes6.dex */
public interface TraceFacade {
    void setConfiguration(TraceConfiguration traceConfiguration);

    void setTraceListener(TraceListener traceListener);

    TraceContext startTrace(TransactionState transactionState);
}
