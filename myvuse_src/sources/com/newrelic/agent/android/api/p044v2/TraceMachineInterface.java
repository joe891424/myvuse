package com.newrelic.agent.android.api.p044v2;

/* JADX INFO: loaded from: classes6.dex */
public interface TraceMachineInterface {
    long getCurrentThreadId();

    String getCurrentThreadName();

    boolean isUIThread();
}
