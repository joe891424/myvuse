package com.surajit.rnrg;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

/* JADX INFO: loaded from: classes6.dex */
public class RNRadialGradientModule extends ReactContextBaseJavaModule {
    private final ReactApplicationContext reactContext;

    public RNRadialGradientModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNRadialGradient";
    }
}
