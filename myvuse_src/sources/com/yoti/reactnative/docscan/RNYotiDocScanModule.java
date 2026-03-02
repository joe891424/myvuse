package com.yoti.reactnative.docscan;

import android.app.Activity;
import android.content.Intent;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.yoti.mobile.android.yotisdkcore.YotiSdk;

/* JADX INFO: loaded from: classes4.dex */
public class RNYotiDocScanModule extends ReactContextBaseJavaModule {
    private static final int SESSION_SUCCESS_CODE = 0;
    private final ActivityEventListener mActivityEventListener;
    private Callback mErrorCallback;
    private int mRequestCode;
    private Callback mSuccessCallback;
    private YotiSdk mYotiSdk;

    @ReactMethod
    public void setPrimaryColorRGB(double d, double d2, double d3) {
    }

    RNYotiDocScanModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mRequestCode = 9001;
        BaseActivityEventListener baseActivityEventListener = new BaseActivityEventListener() { // from class: com.yoti.reactnative.docscan.RNYotiDocScanModule.1
            @Override // com.facebook.react.bridge.BaseActivityEventListener, com.facebook.react.bridge.ActivityEventListener
            public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
                if (i != RNYotiDocScanModule.this.mRequestCode) {
                    return;
                }
                int sessionStatusCode = RNYotiDocScanModule.this.mYotiSdk.getSessionStatusCode();
                String sessionStatusDescription = RNYotiDocScanModule.this.mYotiSdk.getSessionStatusDescription();
                if (i2 == -1 && sessionStatusCode == 0) {
                    RNYotiDocScanModule.this.mSuccessCallback.invoke(Integer.valueOf(sessionStatusCode), sessionStatusDescription);
                } else {
                    RNYotiDocScanModule.this.mErrorCallback.invoke(Integer.valueOf(sessionStatusCode), sessionStatusDescription);
                }
            }
        };
        this.mActivityEventListener = baseActivityEventListener;
        reactApplicationContext.addActivityEventListener(baseActivityEventListener);
        this.mYotiSdk = new YotiSdk(reactApplicationContext).configureReactNativeClient();
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNYotiDocScan";
    }

    @ReactMethod
    public void useCanadaService() {
        this.mYotiSdk.useCanadaService();
    }

    @ReactMethod
    public void setRequestCode(int i) {
        this.mRequestCode = i;
    }

    @ReactMethod
    public void startSession(String str, String str2, Callback callback, Callback callback2) {
        this.mErrorCallback = callback2;
        this.mSuccessCallback = callback;
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            this.mErrorCallback.invoke("E_ACTIVITY_DOES_NOT_EXIST");
        } else {
            if (this.mYotiSdk.setSessionId(str).setClientSessionToken(str2).start(currentActivity, this.mRequestCode)) {
                return;
            }
            int sessionStatusCode = this.mYotiSdk.getSessionStatusCode();
            this.mErrorCallback.invoke(Integer.valueOf(sessionStatusCode), this.mYotiSdk.getSessionStatusDescription());
        }
    }
}
