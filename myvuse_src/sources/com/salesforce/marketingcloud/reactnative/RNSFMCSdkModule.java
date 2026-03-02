package com.salesforce.marketingcloud.reactnative;

import android.util.Log;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.salesforce.marketingcloud.MCLogListener;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdk;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdkReadyListener;
import com.salesforce.marketingcloud.sfmcsdk.components.identity.Identity;
import com.salesforce.marketingcloud.sfmcsdk.components.logging.LogLevel;
import com.salesforce.marketingcloud.sfmcsdk.components.logging.LogListener;
import com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleInterface;
import com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleReadyListener;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class RNSFMCSdkModule extends ReactContextBaseJavaModule {
    private static int MAX_LOG_LENGTH = 4000;

    public RNSFMCSdkModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        handlePushAction(new MCPushAction() { // from class: com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.1
            @Override // com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.MCPushAction
            void execute(PushModuleInterface pushModuleInterface) {
                pushModuleInterface.getRegistrationManager().edit().addTag("React").commit();
            }
        });
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNSFMCSdk";
    }

    @ReactMethod
    public void logSdkState() {
        handleAction(new SFMCAction() { // from class: com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.2
            @Override // com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.SFMCAction
            void execute(SFMCSdk sFMCSdk) {
                String string;
                try {
                    StringBuilder sb = new StringBuilder("SDK State: ");
                    JSONObject sdkState = sFMCSdk.getSdkState();
                    if (sdkState instanceof JSONObject) {
                        JSONObject jSONObject = sdkState;
                        string = JSONObjectInstrumentation.toString(sdkState, 2);
                    } else {
                        string = sdkState.toString(2);
                    }
                    RNSFMCSdkModule.log("~#RNMCSdkModule", sb.append(string).toString());
                } catch (Exception unused) {
                }
            }
        });
    }

    @ReactMethod
    public void enableLogging() {
        SFMCSdk.INSTANCE.setLogging(LogLevel.DEBUG, new LogListener.AndroidLogger());
        MarketingCloudSdk.setLogLevel(2);
        MarketingCloudSdk.setLogListener(new MCLogListener.AndroidLogListener());
    }

    @ReactMethod
    public void disableLogging() {
        SFMCSdk.INSTANCE.setLogging(LogLevel.NONE, null);
        MarketingCloudSdk.setLogListener(null);
    }

    @ReactMethod
    public void getSystemToken(final Promise promise) {
        handlePushAction(new MCPushAction() { // from class: com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.MCPushAction
            void execute(PushModuleInterface pushModuleInterface) {
                promise.resolve(pushModuleInterface.getPushMessageManager().getPushToken());
            }
        });
    }

    @ReactMethod
    public void isPushEnabled(final Promise promise) {
        handlePushAction(new MCPushAction() { // from class: com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.MCPushAction
            void execute(PushModuleInterface pushModuleInterface) {
                promise.resolve(Boolean.valueOf(pushModuleInterface.getPushMessageManager().isPushEnabled()));
            }
        });
    }

    @ReactMethod
    public void enablePush() {
        handlePushAction(new MCPushAction() { // from class: com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.5
            @Override // com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.MCPushAction
            void execute(PushModuleInterface pushModuleInterface) {
                pushModuleInterface.getPushMessageManager().enablePush();
            }
        });
    }

    @ReactMethod
    public void disablePush() {
        handlePushAction(new MCPushAction() { // from class: com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.6
            @Override // com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.MCPushAction
            void execute(PushModuleInterface pushModuleInterface) {
                pushModuleInterface.getPushMessageManager().disablePush();
            }
        });
    }

    @ReactMethod
    public void getDeviceId(final Promise promise) {
        handlePushAction(new MCPushAction() { // from class: com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.MCPushAction
            void execute(PushModuleInterface pushModuleInterface) {
                promise.resolve(pushModuleInterface.getRegistrationManager().getDeviceId());
            }
        });
    }

    @ReactMethod
    public void getTags(final Promise promise) {
        handlePushAction(new MCPushAction() { // from class: com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.MCPushAction
            void execute(PushModuleInterface pushModuleInterface) {
                Set<String> tags = pushModuleInterface.getRegistrationManager().getTags();
                WritableNativeArray writableNativeArray = new WritableNativeArray();
                if (!tags.isEmpty()) {
                    Iterator<String> it2 = tags.iterator();
                    while (it2.hasNext()) {
                        writableNativeArray.pushString(it2.next());
                    }
                }
                promise.resolve(writableNativeArray);
            }
        });
    }

    @ReactMethod
    public void addTag(final String str) {
        handlePushAction(new MCPushAction() { // from class: com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.MCPushAction
            void execute(PushModuleInterface pushModuleInterface) {
                pushModuleInterface.getRegistrationManager().edit().addTag(str).commit();
            }
        });
    }

    @ReactMethod
    public void removeTag(final String str) {
        handlePushAction(new MCPushAction() { // from class: com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.MCPushAction
            void execute(PushModuleInterface pushModuleInterface) {
                pushModuleInterface.getRegistrationManager().edit().removeTag(str).commit();
            }
        });
    }

    @ReactMethod
    public void getContactKey(final Promise promise) {
        handlePushAction(new MCPushAction() { // from class: com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.MCPushAction
            void execute(PushModuleInterface pushModuleInterface) {
                promise.resolve(pushModuleInterface.getRegistrationManager().getContactKey());
            }
        });
    }

    @ReactMethod
    public void setContactKey(final String str) {
        handleIdentityAction(new SFMCIdentityAction() { // from class: com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.SFMCIdentityAction
            void execute(Identity identity) {
                identity.setProfileId(str);
            }
        });
    }

    @ReactMethod
    public void getAttributes(final Promise promise) {
        handlePushAction(new MCPushAction() { // from class: com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.13
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.MCPushAction
            void execute(PushModuleInterface pushModuleInterface) {
                Map<String, String> attributes = pushModuleInterface.getRegistrationManager().getAttributes();
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                if (!attributes.isEmpty()) {
                    for (Map.Entry<String, String> entry : attributes.entrySet()) {
                        writableNativeMap.putString(entry.getKey(), entry.getValue());
                    }
                }
                promise.resolve(writableNativeMap);
            }
        });
    }

    @ReactMethod
    public void setAttribute(final String str, final String str2) {
        handleIdentityAction(new SFMCIdentityAction() { // from class: com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.14
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.SFMCIdentityAction
            void execute(Identity identity) {
                identity.setProfileAttribute(str, str2);
            }
        });
    }

    @ReactMethod
    public void clearAttribute(final String str) {
        handleIdentityAction(new SFMCIdentityAction() { // from class: com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.15
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.SFMCIdentityAction
            void execute(Identity identity) {
                identity.clearProfileAttribute(str);
            }
        });
    }

    @ReactMethod
    public void track(ReadableMap readableMap) {
        SFMCSdk.track(EventUtility.toEvent(readableMap));
    }

    @ReactMethod
    public void isAnalyticsEnabled(final Promise promise) {
        handlePushAction(new MCPushAction() { // from class: com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.16
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.MCPushAction
            void execute(PushModuleInterface pushModuleInterface) {
                promise.resolve(Boolean.valueOf(pushModuleInterface.getAnalyticsManager().areAnalyticsEnabled()));
            }
        });
    }

    @ReactMethod
    public void setAnalyticsEnabled(final Boolean bool) {
        handlePushAction(new MCPushAction() { // from class: com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.17
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.MCPushAction
            void execute(PushModuleInterface pushModuleInterface) {
                if (bool.booleanValue()) {
                    pushModuleInterface.getAnalyticsManager().enableAnalytics();
                } else {
                    pushModuleInterface.getAnalyticsManager().disableAnalytics();
                }
            }
        });
    }

    @ReactMethod
    public void isPiAnalyticsEnabled(final Promise promise) {
        handlePushAction(new MCPushAction() { // from class: com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.18
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.MCPushAction
            void execute(PushModuleInterface pushModuleInterface) {
                promise.resolve(Boolean.valueOf(pushModuleInterface.getAnalyticsManager().arePiAnalyticsEnabled()));
            }
        });
    }

    @ReactMethod
    public void setPiAnalyticsEnabled(final Boolean bool) {
        handlePushAction(new MCPushAction() { // from class: com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.19
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.MCPushAction
            void execute(PushModuleInterface pushModuleInterface) {
                if (bool.booleanValue()) {
                    pushModuleInterface.getAnalyticsManager().enablePiAnalytics();
                } else {
                    pushModuleInterface.getAnalyticsManager().disablePiAnalytics();
                }
            }
        });
    }

    private void handleAction(final SFMCAction sFMCAction) {
        SFMCSdk.requestSdk(new SFMCSdkReadyListener() { // from class: com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.20
            @Override // com.salesforce.marketingcloud.sfmcsdk.SFMCSdkReadyListener
            public void ready(SFMCSdk sFMCSdk) {
                sFMCAction.execute(sFMCSdk);
            }
        });
    }

    private void handlePushAction(final MCPushAction mCPushAction) {
        SFMCSdk.requestSdk(new SFMCSdkReadyListener() { // from class: com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.21
            @Override // com.salesforce.marketingcloud.sfmcsdk.SFMCSdkReadyListener
            public void ready(SFMCSdk sFMCSdk) {
                sFMCSdk.m3974mp(new PushModuleReadyListener() { // from class: com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.21.1
                    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleReadyListener
                    public void ready(PushModuleInterface pushModuleInterface) {
                        mCPushAction.execute(pushModuleInterface);
                    }
                });
            }
        });
    }

    private void handleIdentityAction(final SFMCIdentityAction sFMCIdentityAction) {
        SFMCSdk.requestSdk(new SFMCSdkReadyListener() { // from class: com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.22
            @Override // com.salesforce.marketingcloud.sfmcsdk.SFMCSdkReadyListener
            public void ready(SFMCSdk sFMCSdk) {
                sFMCIdentityAction.execute(sFMCSdk.identity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void log(String str, String str2) {
        int length = str2.length();
        for (int i = 0; i < length; i += MAX_LOG_LENGTH) {
            Log.println(3, str, str2.substring(i, Math.min(length, MAX_LOG_LENGTH + i)));
        }
    }

    abstract class SFMCAction {
        void err() {
        }

        abstract void execute(SFMCSdk sFMCSdk);

        SFMCAction() {
        }
    }

    abstract class SFMCPromiseAction extends SFMCAction {
        private final Promise promise;

        abstract void execute(SFMCSdk sFMCSdk, Promise promise);

        SFMCPromiseAction(@Nonnull Promise promise) {
            super();
            this.promise = promise;
        }

        @Override // com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.SFMCAction
        final void execute(SFMCSdk sFMCSdk) {
            execute(sFMCSdk, this.promise);
        }

        @Override // com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.SFMCAction
        void err() {
            this.promise.reject("SFMCSDK-INIT", "The MarketingCloudSdk#init method must be called in the Application's onCreate.");
        }
    }

    abstract class MCPushAction {
        void err() {
        }

        abstract void execute(PushModuleInterface pushModuleInterface);

        MCPushAction() {
        }
    }

    abstract class MCPushPromiseAction extends MCPushAction {
        private final Promise promise;

        abstract void execute(PushModuleInterface pushModuleInterface, Promise promise);

        MCPushPromiseAction(@Nonnull Promise promise) {
            super();
            this.promise = promise;
        }

        @Override // com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.MCPushAction
        final void execute(PushModuleInterface pushModuleInterface) {
            execute(pushModuleInterface, this.promise);
        }

        @Override // com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.MCPushAction
        void err() {
            this.promise.reject("SFMCSDK-INIT", "The MarketingCloudSdk#init method must be called in the Application's onCreate.");
        }
    }

    abstract class SFMCIdentityAction {
        void err() {
        }

        abstract void execute(Identity identity);

        SFMCIdentityAction() {
        }
    }

    abstract class SFMCIdentityPromiseAction extends SFMCIdentityAction {
        private final Promise promise;

        abstract void execute(Identity identity, Promise promise);

        SFMCIdentityPromiseAction(@Nonnull Promise promise) {
            super();
            this.promise = promise;
        }

        @Override // com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.SFMCIdentityAction
        final void execute(Identity identity) {
            execute(identity, this.promise);
        }

        @Override // com.salesforce.marketingcloud.reactnative.RNSFMCSdkModule.SFMCIdentityAction
        void err() {
            this.promise.reject("SFMCSDK-INIT", "The SFMCSdk#configure method must be called in the Application's onCreate.");
        }
    }
}
