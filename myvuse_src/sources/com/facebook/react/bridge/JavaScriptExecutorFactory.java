package com.facebook.react.bridge;

/* JADX INFO: loaded from: classes3.dex */
public interface JavaScriptExecutorFactory {
    JavaScriptExecutor create() throws Exception;

    void startSamplingProfiler();

    void stopSamplingProfiler(String str);
}
