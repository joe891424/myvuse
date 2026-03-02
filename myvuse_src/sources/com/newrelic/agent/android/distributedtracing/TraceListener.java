package com.newrelic.agent.android.distributedtracing;

import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public interface TraceListener {
    void onSpanCreated(Map<String, String> map);

    void onTraceCreated(Map<String, String> map);
}
