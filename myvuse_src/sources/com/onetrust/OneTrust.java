package com.onetrust;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.appcompat.app.AppCompatActivity;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.onetrust.otpublishers.headless.Public.Keys.OTBroadcastServiceKeys;
import com.onetrust.otpublishers.headless.Public.OTConsentInteractionType;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class OneTrust extends ReactContextBaseJavaModule {
    String LOG_TAG;
    BroadcastReceiver actionConsent;

    /* JADX INFO: renamed from: ot */
    OTPublishersHeadlessSDK f4049ot;

    public OneTrust(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.LOG_TAG = "OTReactBridge";
        this.actionConsent = new BroadcastReceiver() { // from class: com.onetrust.OneTrust.5
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) OneTrust.this.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(intent.getAction(), Integer.valueOf(intent.getIntExtra(OTBroadcastServiceKeys.EVENT_STATUS, -1)));
            }
        };
        this.f4049ot = new OTPublishersHeadlessSDK(getReactApplicationContext());
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "OneTrust";
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0038  */
    @com.facebook.react.bridge.ReactMethod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void startSDK(java.lang.String r10, java.lang.String r11, java.lang.String r12, com.facebook.react.bridge.ReadableMap r13, final java.lang.Boolean r14, final com.facebook.react.bridge.Promise r15) {
        /*
            r9 = this;
            java.lang.String r0 = "profileSyncParams"
            boolean r1 = r13.hasKey(r0)
            r2 = 0
            if (r1 == 0) goto L38
            com.facebook.react.bridge.ReadableMap r0 = r13.getMap(r0)
            java.lang.String r1 = "identifier"
            java.lang.String r1 = r9.getParamStringValue(r0, r1)
            java.lang.String r3 = "syncProfileAuth"
            java.lang.String r0 = r9.getParamStringValue(r0, r3)
            java.lang.String r3 = ""
            boolean r4 = r1.equals(r3)
            if (r4 != 0) goto L38
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L38
            com.onetrust.otpublishers.headless.Public.DataModel.OTProfileSyncParams$OTProfileSyncParamsBuilder r3 = com.onetrust.otpublishers.headless.Public.DataModel.OTProfileSyncParams.OTProfileSyncParamsBuilder.newInstance()
            com.onetrust.otpublishers.headless.Public.DataModel.OTProfileSyncParams$OTProfileSyncParamsBuilder r0 = r3.setSyncProfileAuth(r0)
            com.onetrust.otpublishers.headless.Public.DataModel.OTProfileSyncParams$OTProfileSyncParamsBuilder r0 = r0.setIdentifier(r1)
            com.onetrust.otpublishers.headless.Public.DataModel.OTProfileSyncParams r0 = r0.build()
            goto L39
        L38:
            r0 = r2
        L39:
            java.lang.String r1 = "androidUXParams"
            boolean r3 = r13.hasKey(r1)
            if (r3 == 0) goto L62
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: org.json.JSONException -> L57
            java.lang.String r1 = r13.getString(r1)     // Catch: org.json.JSONException -> L57
            r3.<init>(r1)     // Catch: org.json.JSONException -> L57
            com.onetrust.otpublishers.headless.Public.DataModel.OTUXParams$OTUXParamsBuilder r1 = com.onetrust.otpublishers.headless.Public.DataModel.OTUXParams.OTUXParamsBuilder.newInstance()     // Catch: org.json.JSONException -> L57
            com.onetrust.otpublishers.headless.Public.DataModel.OTUXParams$OTUXParamsBuilder r1 = r1.setUXParams(r3)     // Catch: org.json.JSONException -> L57
            com.onetrust.otpublishers.headless.Public.DataModel.OTUXParams r2 = r1.build()     // Catch: org.json.JSONException -> L57
            goto L62
        L57:
            r1 = move-exception
            java.lang.String r3 = r9.LOG_TAG
            java.lang.String r4 = "Error parsing JSON from UXParamsJSON"
            com.newrelic.agent.android.instrumentation.LogInstrumentation.m2728e(r3, r4)
            r1.printStackTrace()
        L62:
            com.onetrust.otpublishers.headless.Public.DataModel.OTSdkParams$SdkParamsBuilder r1 = com.onetrust.otpublishers.headless.Public.DataModel.OTSdkParams.SdkParamsBuilder.newInstance()
            java.lang.String r3 = "sdkVersion"
            java.lang.String r3 = r9.getParamStringValue(r13, r3)
            com.onetrust.otpublishers.headless.Public.DataModel.OTSdkParams$SdkParamsBuilder r1 = r1.setAPIVersion(r3)
            java.lang.String r3 = "countryCode"
            java.lang.String r3 = r9.getParamStringValue(r13, r3)
            com.onetrust.otpublishers.headless.Public.DataModel.OTSdkParams$SdkParamsBuilder r1 = r1.setOTCountryCode(r3)
            java.lang.String r3 = "regionCode"
            java.lang.String r13 = r9.getParamStringValue(r13, r3)
            com.onetrust.otpublishers.headless.Public.DataModel.OTSdkParams$SdkParamsBuilder r13 = r1.setOTRegionCode(r13)
            if (r0 == 0) goto L8f
            com.onetrust.otpublishers.headless.Public.DataModel.OTSdkParams$SdkParamsBuilder r0 = r13.setProfileSyncParams(r0)
            java.lang.String r1 = "true"
            r0.shouldCreateProfile(r1)
        L8f:
            if (r2 == 0) goto L94
            r13.setOTUXParams(r2)
        L94:
            com.onetrust.otpublishers.headless.Public.DataModel.OTSdkParams r7 = r13.build()
            com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK r3 = r9.f4049ot
            com.onetrust.OneTrust$1 r8 = new com.onetrust.OneTrust$1
            r8.<init>()
            r4 = r10
            r5 = r11
            r6 = r12
            r3.startSDK(r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.OneTrust.startSDK(java.lang.String, java.lang.String, java.lang.String, com.facebook.react.bridge.ReadableMap, java.lang.Boolean, com.facebook.react.bridge.Promise):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBannerAutomatically() {
        if (this.f4049ot.shouldShowBanner()) {
            if (appIsActive().booleanValue()) {
                showBannerUI();
                return;
            }
            LogInstrumentation.m2730i(this.LOG_TAG, "Adding lifecycle callback to load banner the next time the app resumes.");
            if (getReactApplicationContext() == null) {
                return;
            }
            getReactApplicationContext().addLifecycleEventListener(new LifecycleEventListener() { // from class: com.onetrust.OneTrust.2
                @Override // com.facebook.react.bridge.LifecycleEventListener
                public void onHostDestroy() {
                }

                @Override // com.facebook.react.bridge.LifecycleEventListener
                public void onHostPause() {
                }

                @Override // com.facebook.react.bridge.LifecycleEventListener
                public void onHostResume() {
                    if (OneTrust.this.f4049ot.getBannerData() != null) {
                        OneTrust.this.showBannerUI();
                    }
                    OneTrust.this.getReactApplicationContext().removeLifecycleEventListener(this);
                }
            });
        }
    }

    private String getParamStringValue(ReadableMap readableMap, String str) {
        if (!readableMap.hasKey(str)) {
            return "";
        }
        return readableMap.getString(str);
    }

    private Boolean appIsActive() {
        return Boolean.valueOf(getReactApplicationContext().getLifecycleState() == LifecycleState.RESUMED);
    }

    @ReactMethod
    public void showBannerUI() {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null || !appIsActive().booleanValue()) {
            return;
        }
        currentActivity.runOnUiThread(new Runnable() { // from class: com.onetrust.OneTrust.3
            @Override // java.lang.Runnable
            public void run() {
                OneTrust.this.f4049ot.showBannerUI((AppCompatActivity) currentActivity);
            }
        });
    }

    @ReactMethod
    public void showPreferenceCenterUI() {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null || !appIsActive().booleanValue()) {
            return;
        }
        currentActivity.runOnUiThread(new Runnable() { // from class: com.onetrust.OneTrust.4
            @Override // java.lang.Runnable
            public void run() {
                OneTrust.this.f4049ot.showPreferenceCenterUI((AppCompatActivity) currentActivity);
            }
        });
    }

    @ReactMethod
    public void setDataSubjectIdentifier(String str) {
        this.f4049ot.overrideDataSubjectIdentifier(str);
    }

    @ReactMethod
    public void getConsentStatusForCategory(String str, Promise promise) {
        promise.resolve(Integer.valueOf(this.f4049ot.getConsentStatusForGroupId(str)));
    }

    @ReactMethod
    public void getConsentStatusForSDKId(String str, Promise promise) {
        promise.resolve(Integer.valueOf(this.f4049ot.getConsentStatusForSDKId(str)));
    }

    @ReactMethod
    public void shouldShowBanner(Promise promise) {
        promise.resolve(Boolean.valueOf(this.f4049ot.shouldShowBanner()));
    }

    @ReactMethod
    public void listenForConsentChanges(String str) {
        getReactApplicationContext().registerReceiver(this.actionConsent, new IntentFilter(str));
    }

    @ReactMethod
    public void stopListeningForConsentChanges() {
        try {
            getReactApplicationContext().unregisterReceiver(this.actionConsent);
        } catch (Exception e) {
            LogInstrumentation.m2728e(this.LOG_TAG, "Error when trying to unregister receiver. See StackTrace for more details.");
            e.printStackTrace();
        }
    }

    @ReactMethod
    public void getOTConsentJSForWebView(Promise promise) {
        promise.resolve(this.f4049ot.getOTConsentJSForWebView());
    }

    @ReactMethod
    public void getDomainInfo(Promise promise) {
        JSONObject domainInfo = this.f4049ot.getDomainInfo();
        promise.resolve(!(domainInfo instanceof JSONObject) ? domainInfo.toString() : JSONObjectInstrumentation.toString(domainInfo));
    }

    @ReactMethod
    public void showConsentPurposesUI() {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null || !appIsActive().booleanValue()) {
            return;
        }
        currentActivity.runOnUiThread(new Runnable() { // from class: com.onetrust.OneTrust.6
            @Override // java.lang.Runnable
            public void run() {
                OneTrust.this.f4049ot.showConsentPurposesUI((AppCompatActivity) currentActivity);
            }
        });
    }

    @ReactMethod
    public void getUCPurposeConsent(String str, Promise promise) {
        promise.resolve(Integer.valueOf(this.f4049ot.getUCPurposeConsent(str)));
    }

    @ReactMethod
    public void getUCCustomPreferenceConsent(String str, String str2, String str3, Promise promise) {
        promise.resolve(Integer.valueOf(this.f4049ot.getUCPurposeConsent(str, str2, str3)));
    }

    @ReactMethod
    public void getUCTopicConsent(String str, String str2, Promise promise) {
        promise.resolve(Integer.valueOf(this.f4049ot.getUCPurposeConsent(str, str2)));
    }

    @ReactMethod
    public void updateUCPurposeConsent(String str, Boolean bool) {
        this.f4049ot.updateUCPurposeConsent(str, bool.booleanValue());
    }

    @ReactMethod
    public void updateUCCustomPreferenceConsent(String str, String str2, String str3, Boolean bool) {
        this.f4049ot.updateUCPurposeConsent(str, str2, str3, bool.booleanValue());
    }

    @ReactMethod
    public void updateUCTopicConsent(String str, String str2, Boolean bool) {
        this.f4049ot.updateUCPurposeConsent(str, str2, bool.booleanValue());
    }

    @ReactMethod
    public void saveUCConsent() {
        this.f4049ot.saveConsent(OTConsentInteractionType.UC_PC_CONFIRM);
    }

    @ReactMethod
    public void updatePurposeConsent(String str, Boolean bool) {
        this.f4049ot.updatePurposeConsent(str, bool.booleanValue());
    }

    @ReactMethod
    public void resetUpdatedConsent() {
        this.f4049ot.resetUpdatedConsent();
    }

    @ReactMethod
    public void saveConsent(int i, Promise promise) {
        String str;
        switch (i) {
            case 1:
                str = OTConsentInteractionType.BANNER_ALLOW_ALL;
                break;
            case 2:
                str = OTConsentInteractionType.BANNER_REJECT_ALL;
                break;
            case 3:
                str = OTConsentInteractionType.BANNER_CLOSE;
                break;
            case 4:
                str = OTConsentInteractionType.BANNER_CONTINUE_WITHOUT_ACCEPTING;
                break;
            case 5:
                str = OTConsentInteractionType.PC_ALLOW_ALL;
                break;
            case 6:
                str = OTConsentInteractionType.PC_REJECT_ALL;
                break;
            case 7:
                str = OTConsentInteractionType.PC_CONFIRM;
                break;
            case 8:
                str = OTConsentInteractionType.PC_CLOSE;
                break;
            default:
                promise.reject("Interaction type not recognized", "Only pass in enum OTConsentInteractionType");
                return;
        }
        this.f4049ot.saveConsent(str);
        promise.resolve(null);
    }

    @ReactMethod
    public void getCurrentActiveProfile(Promise promise) {
        promise.resolve(this.f4049ot.getOTCache().getDataSubjectIdentifier());
    }
}
