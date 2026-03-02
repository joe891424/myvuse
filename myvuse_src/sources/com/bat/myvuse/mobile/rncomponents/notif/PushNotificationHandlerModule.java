package com.bat.myvuse.mobile.rncomponents.notif;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bat.myvuse.mobile.C1410R;
import com.bat.myvuse.mobile.MainActivity;
import com.bat.myvuse.mobile.MainApplication;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.UrlHandler;
import com.salesforce.marketingcloud.notifications.NotificationCustomizationOptions;
import com.salesforce.marketingcloud.notifications.NotificationManager;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.sfmcsdk.InitializationStatus;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdk;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdkModuleConfig;
import io.invertase.firebase.app.ReactNativeFirebaseApp;
import java.util.Map;
import java.util.Random;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PushNotificationHandlerModule extends ReactContextBaseJavaModule {
    private static String TAG = "PushNotificationHandlerModule";
    private LocalBroadcastReceiver mLocalBroadcastReceiver;
    private ReactContext mReactContext;
    private SharedPreferences sharedPreferences;

    public PushNotificationHandlerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mReactContext = reactApplicationContext;
        this.mLocalBroadcastReceiver = new LocalBroadcastReceiver();
        LogInstrumentation.m2730i(TAG, "PushNotificationHandlerModule mLocalBroadcastReceiver created");
        LocalBroadcastManager.getInstance(reactApplicationContext).registerReceiver(this.mLocalBroadcastReceiver, new IntentFilter("my-custom-event"));
        this.sharedPreferences = reactApplicationContext.getSharedPreferences("MYVUSEPrefs", 0);
    }

    public class LocalBroadcastReceiver extends BroadcastReceiver {
        public LocalBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            LogInstrumentation.m2730i(PushNotificationHandlerModule.TAG, "onReceive invoked, sending data to react");
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) PushNotificationHandlerModule.this.mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onNotificationReceived", intent.getStringExtra("notification"));
        }
    }

    @ReactMethod
    public void setString(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    @ReactMethod
    public void getString(String str, String str2, Promise promise) {
        LogInstrumentation.m2730i(TAG, "getString: " + str);
        String string = this.sharedPreferences.getString(str, str2);
        LogInstrumentation.m2730i(TAG, "ret: " + string);
        promise.resolve(string);
    }

    @ReactMethod
    public void clearAll() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.clear();
        editorEdit.commit();
    }

    @ReactMethod
    public void initSFMC(final String str, final String str2, String str3, final String str4, final Promise promise) {
        LogInstrumentation.m2730i(TAG, "entering initSFMC");
        MainApplication.setPref("applicationId", str);
        MainApplication.setPref("accessToken", str2);
        MainApplication.setPref("url", str4);
        SFMCSdk.configure(ReactNativeFirebaseApp.getApplicationContext(), SFMCSdkModuleConfig.build(new Function1() { // from class: com.bat.myvuse.mobile.rncomponents.notif.PushNotificationHandlerModule$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$initSFMC$2(str, str2, str4, (SFMCSdkModuleConfig.Builder) obj);
            }
        }), new Function1() { // from class: com.bat.myvuse.mobile.rncomponents.notif.PushNotificationHandlerModule$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PushNotificationHandlerModule.lambda$initSFMC$3(promise, (InitializationStatus) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$initSFMC$2(String str, String str2, String str3, SFMCSdkModuleConfig.Builder builder) {
        builder.setPushModuleConfig(MarketingCloudConfig.builder().setDelayRegistrationUntilContactKeyIsSet(true).setApplicationId(str).setAccessToken(str2).setMarketingCloudServerUrl(str3).setNotificationCustomizationOptions(NotificationCustomizationOptions.create(new NotificationManager.NotificationBuilder() { // from class: com.bat.myvuse.mobile.rncomponents.notif.PushNotificationHandlerModule$$ExternalSyntheticLambda2
            @Override // com.salesforce.marketingcloud.notifications.NotificationManager.NotificationBuilder
            public final NotificationCompat.Builder setupNotificationBuilder(Context context, NotificationMessage notificationMessage) {
                return this.f$0.lambda$initSFMC$0(context, notificationMessage);
            }
        })).setUrlHandler(new UrlHandler() { // from class: com.bat.myvuse.mobile.rncomponents.notif.PushNotificationHandlerModule$$ExternalSyntheticLambda3
            @Override // com.salesforce.marketingcloud.UrlHandler
            public final PendingIntent handleUrl(Context context, String str4, String str5) {
                return this.f$0.lambda$initSFMC$1(context, str4, str5);
            }
        }).setAnalyticsEnabled(true).build(ReactNativeFirebaseApp.getApplicationContext()));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ NotificationCompat.Builder lambda$initSFMC$0(Context context, NotificationMessage notificationMessage) {
        String strCreateDefaultNotificationChannel = NotificationManager.createDefaultNotificationChannel(context);
        LogInstrumentation.m2730i(TAG, "Received notification");
        LogInstrumentation.m2730i(TAG, notificationMessage.toString());
        Intent intent = new Intent(ReactNativeFirebaseApp.getApplicationContext(), (Class<?>) MainActivity.class);
        Map<String, String> mapCustomKeys = notificationMessage.customKeys();
        if (!mapCustomKeys.isEmpty()) {
            LogInstrumentation.m2730i(TAG, "Custom keys not empy");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cta", mapCustomKeys.get("cta"));
                jSONObject.put("webview_title", mapCustomKeys.get("webview_title"));
                jSONObject.put("webview_url", mapCustomKeys.get("webview_url"));
            } catch (JSONException unused) {
                LogInstrumentation.m2728e(TAG, "parsing error");
            }
            intent.putExtra("notification", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
        }
        PendingIntent activity = PendingIntent.getActivity(ReactNativeFirebaseApp.getApplicationContext(), new Random().nextInt(), intent, provideIntentFlags());
        NotificationCompat.Builder defaultNotificationBuilder = NotificationManager.getDefaultNotificationBuilder(context, notificationMessage, strCreateDefaultNotificationChannel, C1410R.drawable.atoms_branding_bg_logo);
        defaultNotificationBuilder.setContentIntent(NotificationManager.redirectIntentForAnalytics(context, activity, notificationMessage, true));
        return defaultNotificationBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ PendingIntent lambda$initSFMC$1(Context context, String str, String str2) {
        return PendingIntent.getActivity(context, new Random().nextInt(), new Intent("android.intent.action.VIEW", Uri.parse(str)), provideIntentFlags());
    }

    static /* synthetic */ Unit lambda$initSFMC$3(Promise promise, InitializationStatus initializationStatus) {
        LogInstrumentation.m2728e("TAG", "STATUS " + initializationStatus.toString());
        LogInstrumentation.m2728e("TAG", "STATUS CODE " + initializationStatus.getStatus());
        if (initializationStatus.getStatus() == 1) {
            LogInstrumentation.m2728e("TAG", "STATUS SUCCESS");
        }
        promise.resolve(true);
        return null;
    }

    private PendingIntent getPendingIntent(Context context, NotificationMessage notificationMessage) {
        if (TextUtils.isEmpty(notificationMessage.url())) {
            return PendingIntent.getActivity(context, new Random().nextInt(), context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()), provideIntentFlags());
        }
        return PendingIntent.getActivity(context, new Random().nextInt(), new Intent("android.intent.action.VIEW", Uri.parse(notificationMessage.url())), provideIntentFlags());
    }

    private int provideIntentFlags() {
        return Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "PushNotificationHandlerModule";
    }
}
