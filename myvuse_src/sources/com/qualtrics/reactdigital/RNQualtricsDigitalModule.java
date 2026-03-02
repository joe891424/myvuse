package com.qualtrics.reactdigital;

import com.facebook.common.util.UriUtil;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.qualtrics.digital.IQualtricsCallback;
import com.qualtrics.digital.IQualtricsInitializationCallback;
import com.qualtrics.digital.IQualtricsProjectEvaluationCallback;
import com.qualtrics.digital.IQualtricsProjectInitializationCallback;
import com.qualtrics.digital.InitializationResult;
import com.qualtrics.digital.Qualtrics;
import com.qualtrics.digital.TargetingResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RNQualtricsDigitalModule.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u0006\n\u0002\b\u0003\u0018\u0000 ,2\u00020\u0001:\u0001,B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017J\u001c\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0017J\u001c\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0017J\u0012\u0010\u0012\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0017J\b\u0010\u0013\u001a\u00020\nH\u0017J\b\u0010\u0014\u001a\u00020\nH\u0017J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017J\b\u0010\u0016\u001a\u00020\u000fH\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017J&\u0010\u0018\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0017J&\u0010\u001b\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0017J&\u0010\u001d\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0017J\b\u0010\u001e\u001a\u00020\nH\u0017J\b\u0010\u001f\u001a\u00020\nH\u0017J\u0012\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\u000fH\u0017J\b\u0010\"\u001a\u00020\nH\u0017J\b\u0010#\u001a\u00020\nH\u0017J\u0010\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u000fH\u0017J\u0012\u0010&\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010\u000fH\u0017J\u0018\u0010(\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020*H\u0017J\u0018\u0010+\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000fH\u0017R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, m5598d2 = {"Lcom/qualtrics/reactdigital/RNQualtricsDigitalModule;", "Lcom/qualtrics/reactdigital/RNQualtricsDigitalSpec;", "context", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "gInitializationResult", "Lcom/qualtrics/digital/InitializationResult;", "gTargetingResult", "Lcom/qualtrics/digital/TargetingResult;", "display", "", "callback", "Lcom/facebook/react/bridge/Callback;", "displayIntercept", "interceptId", "", "displayTarget", "surveyUrl", "evaluateIntercept", "evaluateProject", "evaluateTargetingLogic", "getInitializedIntercepts", "getName", "getPassingIntercepts", "initialize", "brandId", "zoneId", "initializeProject", "extRefId", "initializeWithCompletion", "recordClick", "recordImpression", "registerViewVisit", "viewName", "resetTimer", "resetViewCounter", "setDateTime", "key", "setNotificationIconAsset", UriUtil.LOCAL_ASSET_SCHEME, "setNumber", "value", "", "setString", "Companion", "react-native-qualtrics_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class RNQualtricsDigitalModule extends RNQualtricsDigitalSpec {
    private static final String EVALUATE_EVENT = "evaluateEvent";
    private static final String EVALUATE_INTERCEPT_EVENT = "evaluateInterceptEvent";
    private static final String EVALUATE_PROJECT_EVENT = "evaluateProjectEvent";
    private static final String INITIALIZE_EVENT = "initializeEvent";
    private static final String INITIALIZE_PROJECT_EVENT = "initializeProjectEvent";
    public static final String NAME = "RNQualtricsDigital";
    private static final String TAG = "Qualtrics";
    private InitializationResult gInitializationResult;
    private TargetingResult gTargetingResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RNQualtricsDigitalModule(ReactApplicationContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.qualtrics.reactdigital.RNQualtricsDigitalSpec
    @ReactMethod
    public void initialize(String brandId, String zoneId, String interceptId) {
        Qualtrics.instance().initialize(brandId, zoneId, interceptId, getReactApplicationContext());
    }

    @Override // com.qualtrics.reactdigital.RNQualtricsDigitalSpec
    @ReactMethod
    public void initializeWithCompletion(String brandId, String zoneId, String interceptId) {
        Qualtrics.instance().initialize(brandId, zoneId, interceptId, getReactApplicationContext(), new IQualtricsInitializationCallback() { // from class: com.qualtrics.reactdigital.RNQualtricsDigitalModule$$ExternalSyntheticLambda6
            @Override // com.qualtrics.digital.IQualtricsInitializationCallback
            public final void run(InitializationResult initializationResult) {
                RNQualtricsDigitalModule.initializeWithCompletion$lambda$0(this.f$0, initializationResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initializeWithCompletion$lambda$0(RNQualtricsDigitalModule this$0, InitializationResult initializationResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WritableMap writableMapCreateMap = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
        if (initializationResult != null) {
            this$0.gInitializationResult = initializationResult;
            writableMapCreateMap.putBoolean("passed", initializationResult.passed());
            writableMapCreateMap.putString("message", initializationResult.getMessage());
        }
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this$0.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(INITIALIZE_EVENT, writableMapCreateMap);
    }

    @Override // com.qualtrics.reactdigital.RNQualtricsDigitalSpec
    @ReactMethod
    public void initializeProject(String brandId, String zoneId, String extRefId) {
        Qualtrics.instance().initializeProject(brandId, zoneId, extRefId, getReactApplicationContext(), new IQualtricsProjectInitializationCallback() { // from class: com.qualtrics.reactdigital.RNQualtricsDigitalModule$$ExternalSyntheticLambda7
            @Override // com.qualtrics.digital.IQualtricsProjectInitializationCallback
            public final void run(Map map) {
                RNQualtricsDigitalModule.initializeProject$lambda$1(this.f$0, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initializeProject$lambda$1(RNQualtricsDigitalModule this$0, Map map) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WritableMap writableMapCreateMap = Arguments.createMap();
        for (String str : map.keySet()) {
            WritableMap writableMapCreateMap2 = Arguments.createMap();
            InitializationResult initializationResult = (InitializationResult) map.get(str);
            Intrinsics.checkNotNull(initializationResult);
            writableMapCreateMap2.putBoolean("passed", initializationResult.passed());
            writableMapCreateMap2.putString("message", initializationResult.getMessage());
            writableMapCreateMap.putMap(str, writableMapCreateMap2);
        }
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this$0.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(INITIALIZE_PROJECT_EVENT, writableMapCreateMap);
    }

    @Override // com.qualtrics.reactdigital.RNQualtricsDigitalSpec
    @ReactMethod
    public void evaluateTargetingLogic() {
        final WritableMap writableMapCreateMap = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
        InitializationResult initializationResult = this.gInitializationResult;
        if (initializationResult != null) {
            Intrinsics.checkNotNull(initializationResult);
            if (!initializationResult.passed()) {
                InitializationResult initializationResult2 = this.gInitializationResult;
                Intrinsics.checkNotNull(initializationResult2);
                writableMapCreateMap.putBoolean("passed", initializationResult2.passed());
                writableMapCreateMap.putString("surveyUrl", null);
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(EVALUATE_EVENT, writableMapCreateMap);
                return;
            }
        }
        Qualtrics.instance().evaluateTargetingLogic(new IQualtricsCallback() { // from class: com.qualtrics.reactdigital.RNQualtricsDigitalModule$$ExternalSyntheticLambda4
            @Override // com.qualtrics.digital.IQualtricsCallback
            public final void run(TargetingResult targetingResult) {
                RNQualtricsDigitalModule.evaluateTargetingLogic$lambda$2(this.f$0, writableMapCreateMap, targetingResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void evaluateTargetingLogic$lambda$2(RNQualtricsDigitalModule this$0, WritableMap targetResult, TargetingResult targetingResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(targetResult, "$targetResult");
        if (targetingResult != null) {
            this$0.gTargetingResult = targetingResult;
            targetResult.putBoolean("passed", targetingResult.passed());
            targetResult.putString("surveyUrl", targetingResult.getSurveyUrl());
        }
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this$0.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(EVALUATE_EVENT, targetResult);
    }

    @Override // com.qualtrics.reactdigital.RNQualtricsDigitalSpec
    @ReactMethod
    public void evaluateProject() {
        final WritableMap writableMapCreateMap = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
        Qualtrics.instance().evaluateProject(new IQualtricsProjectEvaluationCallback() { // from class: com.qualtrics.reactdigital.RNQualtricsDigitalModule$$ExternalSyntheticLambda3
            @Override // com.qualtrics.digital.IQualtricsProjectEvaluationCallback
            public final void run(Map map) {
                RNQualtricsDigitalModule.evaluateProject$lambda$3(writableMapCreateMap, this, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void evaluateProject$lambda$3(WritableMap evaluateProjectResult, RNQualtricsDigitalModule this$0, Map map) {
        Intrinsics.checkNotNullParameter(evaluateProjectResult, "$evaluateProjectResult");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        for (String str : map.keySet()) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
            TargetingResult targetingResult = (TargetingResult) map.get(str);
            Intrinsics.checkNotNull(targetingResult);
            String strName = targetingResult.getCreativeType() == null ? null : targetingResult.getCreativeType().name();
            writableMapCreateMap.putBoolean("passed", targetingResult.passed());
            writableMapCreateMap.putString("surveyUrl", targetingResult.getSurveyUrl());
            writableMapCreateMap.putString("creativeType", strName);
            writableMapCreateMap.putString("targetingResultStatus", targetingResult.getTargetingResultStatus().toString());
            if (targetingResult.getError() != null) {
                writableMapCreateMap.putString("error", targetingResult.getError().getMessage());
            }
            evaluateProjectResult.putMap(str, writableMapCreateMap);
        }
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this$0.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(EVALUATE_PROJECT_EVENT, evaluateProjectResult);
    }

    @Override // com.qualtrics.reactdigital.RNQualtricsDigitalSpec
    @ReactMethod
    public void evaluateIntercept(String interceptId) {
        final WritableMap writableMapCreateMap = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
        Qualtrics.instance().evaluateIntercept(interceptId, new IQualtricsCallback() { // from class: com.qualtrics.reactdigital.RNQualtricsDigitalModule$$ExternalSyntheticLambda2
            @Override // com.qualtrics.digital.IQualtricsCallback
            public final void run(TargetingResult targetingResult) {
                RNQualtricsDigitalModule.evaluateIntercept$lambda$4(writableMapCreateMap, this, targetingResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void evaluateIntercept$lambda$4(WritableMap evaluateInterceptResult, RNQualtricsDigitalModule this$0, TargetingResult targetingResult) {
        Intrinsics.checkNotNullParameter(evaluateInterceptResult, "$evaluateInterceptResult");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String strName = targetingResult.getCreativeType() == null ? null : targetingResult.getCreativeType().name();
        evaluateInterceptResult.putBoolean("passed", targetingResult.passed());
        evaluateInterceptResult.putString("surveyUrl", targetingResult.getSurveyUrl());
        evaluateInterceptResult.putString("creativeType", strName);
        evaluateInterceptResult.putString("targetingResultStatus", targetingResult.getTargetingResultStatus().toString());
        if (targetingResult.getError() != null) {
            evaluateInterceptResult.putString("error", targetingResult.getError().getMessage());
        }
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this$0.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(EVALUATE_INTERCEPT_EVENT, evaluateInterceptResult);
    }

    @Override // com.qualtrics.reactdigital.RNQualtricsDigitalSpec
    @ReactMethod
    public void display(final Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        InitializationResult initializationResult = this.gInitializationResult;
        if (initializationResult != null) {
            Intrinsics.checkNotNull(initializationResult);
            if (!initializationResult.passed()) {
                callback.invoke(false);
                return;
            }
        }
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.qualtrics.reactdigital.RNQualtricsDigitalModule$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                RNQualtricsDigitalModule.display$lambda$5(this.f$0, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void display$lambda$5(RNQualtricsDigitalModule this$0, Callback callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (this$0.getCurrentActivity() != null) {
            boolean zDisplay = Qualtrics.instance().display(this$0.getCurrentActivity());
            if (zDisplay) {
                this$0.gTargetingResult = null;
            }
            callback.invoke(Boolean.valueOf(zDisplay));
            return;
        }
        LogInstrumentation.m2734w("Qualtrics", "Display requires active activity");
        callback.invoke(false);
    }

    @Override // com.qualtrics.reactdigital.RNQualtricsDigitalSpec
    @ReactMethod
    public void displayTarget(final String surveyUrl, final Callback callback) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.qualtrics.reactdigital.RNQualtricsDigitalModule$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                RNQualtricsDigitalModule.displayTarget$lambda$6(surveyUrl, this, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void displayTarget$lambda$6(java.lang.String r2, com.qualtrics.reactdigital.RNQualtricsDigitalModule r3, com.facebook.react.bridge.Callback r4) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 1
            if (r2 != 0) goto L2c
            com.qualtrics.digital.TargetingResult r2 = r3.gTargetingResult
            if (r2 == 0) goto L41
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.String r2 = r2.getSurveyUrl()
            if (r2 == 0) goto L41
            com.qualtrics.digital.Qualtrics r2 = com.qualtrics.digital.Qualtrics.instance()
            android.app.Activity r1 = r3.getCurrentActivity()
            android.content.Context r1 = (android.content.Context) r1
            com.qualtrics.digital.TargetingResult r3 = r3.gTargetingResult
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.String r3 = r3.getSurveyUrl()
            r2.displayTarget(r1, r3)
            goto L42
        L2c:
            com.qualtrics.digital.Qualtrics r1 = com.qualtrics.digital.Qualtrics.instance()     // Catch: java.lang.Exception -> L3a
            android.app.Activity r3 = r3.getCurrentActivity()     // Catch: java.lang.Exception -> L3a
            android.content.Context r3 = (android.content.Context) r3     // Catch: java.lang.Exception -> L3a
            r1.displayTarget(r3, r2)     // Catch: java.lang.Exception -> L3a
            goto L42
        L3a:
            java.lang.String r2 = "Qualtrics"
            java.lang.String r3 = "DisplayTarget requires valid surveyUrl"
            com.newrelic.agent.android.instrumentation.LogInstrumentation.m2734w(r2, r3)
        L41:
            r0 = 0
        L42:
            if (r4 == 0) goto L4f
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r0)
            java.lang.Object[] r2 = new java.lang.Object[]{r2}
            r4.invoke(r2)
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qualtrics.reactdigital.RNQualtricsDigitalModule.displayTarget$lambda$6(java.lang.String, com.qualtrics.reactdigital.RNQualtricsDigitalModule, com.facebook.react.bridge.Callback):void");
    }

    @Override // com.qualtrics.reactdigital.RNQualtricsDigitalSpec
    @ReactMethod
    public void displayIntercept(final String interceptId, final Callback callback) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.qualtrics.reactdigital.RNQualtricsDigitalModule$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RNQualtricsDigitalModule.displayIntercept$lambda$7(this.f$0, interceptId, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void displayIntercept$lambda$7(RNQualtricsDigitalModule this$0, String str, Callback callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getCurrentActivity() != null) {
            boolean zDisplayIntercept = Qualtrics.instance().displayIntercept(this$0.getCurrentActivity(), str);
            if (callback != null) {
                callback.invoke(Boolean.valueOf(zDisplayIntercept));
                return;
            }
            return;
        }
        LogInstrumentation.m2734w("Qualtrics", "Display requires active activity");
        if (callback != null) {
            callback.invoke(false);
        }
    }

    @Override // com.qualtrics.reactdigital.RNQualtricsDigitalSpec
    @ReactMethod
    public void setString(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Qualtrics.instance().properties.setContext(getReactApplicationContext());
        Qualtrics.instance().properties.setString(key, value);
    }

    @Override // com.qualtrics.reactdigital.RNQualtricsDigitalSpec
    @ReactMethod
    public void setNumber(String key, double value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Qualtrics.instance().properties.setNumber(key, value);
    }

    @Override // com.qualtrics.reactdigital.RNQualtricsDigitalSpec
    @ReactMethod
    public void setDateTime(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Qualtrics.instance().properties.setDateTime(key);
    }

    @Override // com.qualtrics.reactdigital.RNQualtricsDigitalSpec
    @ReactMethod
    public void setNotificationIconAsset(String asset) {
        Qualtrics.instance().properties.setNotificationIconAsset(getReactApplicationContext().getResources().getIdentifier(asset, "drawable", getReactApplicationContext().getPackageName()));
    }

    @Override // com.qualtrics.reactdigital.RNQualtricsDigitalSpec
    @ReactMethod
    public void registerViewVisit(String viewName) {
        Qualtrics.instance().registerViewVisit(viewName);
    }

    @Override // com.qualtrics.reactdigital.RNQualtricsDigitalSpec
    @ReactMethod
    public void resetTimer() {
        Qualtrics.instance().resetTimer();
    }

    @Override // com.qualtrics.reactdigital.RNQualtricsDigitalSpec
    @ReactMethod
    public void resetViewCounter() {
        Qualtrics.instance().resetViewCounter();
    }

    @Override // com.qualtrics.reactdigital.RNQualtricsDigitalSpec
    @ReactMethod
    public void recordClick() {
        TargetingResult targetingResult = this.gTargetingResult;
        if (targetingResult == null || targetingResult == null) {
            return;
        }
        targetingResult.recordClick();
    }

    @Override // com.qualtrics.reactdigital.RNQualtricsDigitalSpec
    @ReactMethod
    public void recordImpression() {
        TargetingResult targetingResult = this.gTargetingResult;
        if (targetingResult == null || targetingResult == null) {
            return;
        }
        targetingResult.recordImpression();
    }

    @Override // com.qualtrics.reactdigital.RNQualtricsDigitalSpec
    @ReactMethod
    public void getInitializedIntercepts(Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Intrinsics.checkNotNullExpressionValue(writableArrayCreateArray, "createArray(...)");
        ArrayList<String> initializedIntercepts = Qualtrics.instance().getInitializedIntercepts();
        Intrinsics.checkNotNullExpressionValue(initializedIntercepts, "getInitializedIntercepts(...)");
        Iterator<String> it2 = initializedIntercepts.iterator();
        while (it2.hasNext()) {
            writableArrayCreateArray.pushString(it2.next());
        }
        callback.invoke(writableArrayCreateArray);
    }

    @Override // com.qualtrics.reactdigital.RNQualtricsDigitalSpec
    @ReactMethod
    public void getPassingIntercepts(Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Intrinsics.checkNotNullExpressionValue(writableArrayCreateArray, "createArray(...)");
        ArrayList<String> passingIntercepts = Qualtrics.instance().getPassingIntercepts();
        Intrinsics.checkNotNullExpressionValue(passingIntercepts, "getPassingIntercepts(...)");
        Iterator<String> it2 = passingIntercepts.iterator();
        while (it2.hasNext()) {
            writableArrayCreateArray.pushString(it2.next());
        }
        callback.invoke(writableArrayCreateArray);
    }
}
