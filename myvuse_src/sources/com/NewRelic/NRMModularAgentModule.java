package com.NewRelic;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes.dex */
public class NRMModularAgentModule extends ReactContextBaseJavaModule {
    private final NRMModularAgentModuleImpl impl;

    public NRMModularAgentModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.impl = new NRMModularAgentModuleImpl(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return NRMModularAgentModuleImpl.NAME;
    }

    @ReactMethod
    public void startAgent(String str, String str2, String str3, ReadableMap readableMap) {
        this.impl.startAgent(str, str2, str3, readableMap);
    }

    @ReactMethod
    public void isAgentStarted(Promise promise) {
        this.impl.isAgentStarted(promise);
    }

    @ReactMethod
    public void setJSAppVersion(String str) {
        this.impl.setJSAppVersion(str);
    }

    @ReactMethod
    public void analyticsEventEnabled(boolean z) {
        this.impl.analyticsEventEnabled(z);
    }

    @ReactMethod
    public void networkRequestEnabled(boolean z) {
        this.impl.networkRequestEnabled(z);
    }

    @ReactMethod
    public void networkErrorRequestEnabled(boolean z) {
        this.impl.networkErrorRequestEnabled(z);
    }

    @ReactMethod
    public void httpResponseBodyCaptureEnabled(boolean z) {
        this.impl.httpResponseBodyCaptureEnabled(z);
    }

    @ReactMethod
    public void recordCustomEvent(String str, String str2, ReadableMap readableMap) {
        this.impl.recordCustomEvent(str, str2, readableMap);
    }

    @ReactMethod
    public void addHTTPHeadersTrackingFor(ReadableArray readableArray) {
        this.impl.addHTTPHeadersTrackingFor(readableArray);
    }

    @ReactMethod
    public void crashNow(String str) {
        this.impl.crashNow(str);
    }

    @ReactMethod
    public void currentSessionId(Promise promise) {
        this.impl.currentSessionId(promise);
    }

    @ReactMethod
    public void noticeNetworkFailure(String str, String str2, double d, double d2, String str3) {
        this.impl.noticeNetworkFailure(str, str2, d, d2, str3);
    }

    @ReactMethod
    public void recordMetric(String str, String str2, double d, String str3, String str4) {
        this.impl.recordMetric(str, str2, d, str3, str4);
    }

    @ReactMethod
    public void removeAllAttributes() {
        this.impl.removeAllAttributes();
    }

    @ReactMethod
    public void setMaxEventBufferTime(int i) {
        this.impl.setMaxEventBufferTime(i);
    }

    @ReactMethod
    public void setMaxOfflineStorageSize(int i) {
        this.impl.setMaxOfflineStorageSize(i);
    }

    @ReactMethod
    public void setMaxEventPoolSize(int i) {
        this.impl.setMaxEventPoolSize(i);
    }

    @ReactMethod
    public void setStringAttribute(String str, String str2) {
        this.impl.setStringAttribute(str, str2);
    }

    @ReactMethod
    public void setBoolAttribute(String str, boolean z) {
        this.impl.setBoolAttribute(str, z);
    }

    @ReactMethod
    public void setNumberAttribute(String str, Double d) {
        this.impl.setNumberAttribute(str, d);
    }

    @ReactMethod
    public void removeAttribute(String str) {
        this.impl.removeAttribute(str);
    }

    @ReactMethod
    public void incrementAttribute(String str, Double d) {
        this.impl.incrementAttribute(str, d);
    }

    @ReactMethod
    public void setUserId(String str) {
        this.impl.setUserId(str);
    }

    @ReactMethod
    public void recordBreadcrumb(String str, ReadableMap readableMap) {
        this.impl.recordBreadcrumb(str, readableMap);
    }

    @ReactMethod
    public void startInteraction(String str, Promise promise) {
        this.impl.startInteraction(str, promise);
    }

    @ReactMethod
    public void endInteraction(String str) {
        this.impl.endInteraction(str);
    }

    @ReactMethod
    public void setInteractionName(String str) {
        this.impl.setInteractionName(str);
    }

    @ReactMethod
    public void nativeLog(String str, String str2) {
        this.impl.nativeLog(str, str2);
    }

    @ReactMethod
    public void noticeHttpTransaction(String str, String str2, int i, int i2, int i3, int i4, int i5, String str3) {
        this.impl.noticeHttpTransaction(str, str2, i, i2, i3, i4, i5, str3);
    }

    @ReactMethod
    public void logAttributes(ReadableMap readableMap) {
        this.impl.logAttributes(readableMap);
    }

    @ReactMethod
    public void recordStack(String str, String str2, String str3, boolean z, String str4) {
        this.impl.recordStack(str, str2, str3, z, str4);
    }

    @ReactMethod
    public void shutdown() {
        this.impl.shutdown();
    }

    @ReactMethod
    public void recordHandledException(ReadableMap readableMap) {
        this.impl.recordHandledException(readableMap);
    }
}
