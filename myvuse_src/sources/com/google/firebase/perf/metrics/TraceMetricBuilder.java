package com.google.firebase.perf.metrics;

import com.google.firebase.perf.p040v1.PerfSession;
import com.google.firebase.perf.p040v1.TraceMetric;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class TraceMetricBuilder {
    private final Trace trace;

    TraceMetricBuilder(Trace trace) {
        this.trace = trace;
    }

    TraceMetric build() {
        TraceMetric.Builder durationUs = TraceMetric.newBuilder().setName(this.trace.getName()).setClientStartTimeUs(this.trace.getStartTime().getMicros()).setDurationUs(this.trace.getStartTime().getDurationMicros(this.trace.getEndTime()));
        for (Counter counter : this.trace.getCounters().values()) {
            durationUs.putCounters(counter.getName(), counter.getCount());
        }
        List<Trace> subtraces = this.trace.getSubtraces();
        if (!subtraces.isEmpty()) {
            Iterator<Trace> it2 = subtraces.iterator();
            while (it2.hasNext()) {
                durationUs.addSubtraces(new TraceMetricBuilder(it2.next()).build());
            }
        }
        durationUs.putAllCustomAttributes(this.trace.getAttributes());
        PerfSession[] perfSessionArrBuildAndSort = com.google.firebase.perf.session.PerfSession.buildAndSort(this.trace.getSessions());
        if (perfSessionArrBuildAndSort != null) {
            durationUs.addAllPerfSessions(Arrays.asList(perfSessionArrBuildAndSort));
        }
        return durationUs.build();
    }
}
