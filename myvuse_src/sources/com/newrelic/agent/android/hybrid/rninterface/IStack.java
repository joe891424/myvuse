package com.newrelic.agent.android.hybrid.rninterface;

/* JADX INFO: loaded from: classes6.dex */
public interface IStack {
    String getId();

    IStackFrame[] getStackFrames();

    boolean isThrowingThread();
}
