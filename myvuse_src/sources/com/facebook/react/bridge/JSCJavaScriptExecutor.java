package com.facebook.react.bridge;

import com.facebook.jni.HybridData;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
class JSCJavaScriptExecutor extends JavaScriptExecutor {
    private static native HybridData initHybrid(ReadableNativeMap readableNativeMap);

    static {
        ReactBridge.staticInit();
    }

    JSCJavaScriptExecutor(ReadableNativeMap readableNativeMap) {
        super(initHybrid(readableNativeMap));
    }

    @Override // com.facebook.react.bridge.JavaScriptExecutor
    public String getName() {
        return "JSCJavaScriptExecutor";
    }
}
