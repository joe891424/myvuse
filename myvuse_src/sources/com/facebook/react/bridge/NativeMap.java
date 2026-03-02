package com.facebook.react.bridge;

import com.facebook.jni.HybridData;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeMap {
    private HybridData mHybridData;

    public native String toString();

    static {
        ReactBridge.staticInit();
    }

    public NativeMap(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
