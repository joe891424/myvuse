package com.google.firebase.perf.transport;

import com.google.firebase.perf.p040v1.ApplicationProcessState;
import com.google.firebase.perf.p040v1.PerfMetric;

/* JADX INFO: loaded from: classes2.dex */
final class PendingPerfEvent {
    protected final ApplicationProcessState appState;
    protected final PerfMetric.Builder perfMetricBuilder;

    public PendingPerfEvent(PerfMetric.Builder builder, ApplicationProcessState applicationProcessState) {
        this.perfMetricBuilder = builder;
        this.appState = applicationProcessState;
    }
}
