package com.facebook.react.bridge;

/* JADX INFO: loaded from: classes3.dex */
interface ReactCallback {
    void decrementPendingJSCalls();

    void incrementPendingJSCalls();

    void onBatchComplete();
}
