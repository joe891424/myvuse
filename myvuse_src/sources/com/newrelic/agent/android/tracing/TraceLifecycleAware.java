package com.newrelic.agent.android.tracing;

/* JADX INFO: loaded from: classes6.dex */
public interface TraceLifecycleAware {
    default void onEnterMethod() {
    }

    default void onExitMethod() {
    }

    default void onTraceComplete(ActivityTrace activityTrace) {
    }

    default void onTraceRename(ActivityTrace activityTrace) {
    }

    default void onTraceStart(ActivityTrace activityTrace) {
    }
}
