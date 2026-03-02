package com.bat.myvuse.mobile;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.bat.myvuse.mobile.rncomponents.nodes.NodesPackage;
import com.bat.myvuse.mobile.rncomponents.notif.PushNotificationHandlerPackege;
import com.bat.myvuse.mobile.rncomponents.notifications.NotificationsPackage;
import com.bat.myvuse.mobile.rncomponents.p036ui.LoadingViewPackage;
import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.soloader.SoLoader;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.reactnativenavigation.NavigationApplication;
import com.reactnativenavigation.react.NavigationReactNativeHost;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.UrlHandler;
import com.salesforce.marketingcloud.notifications.NotificationCustomizationOptions;
import com.salesforce.marketingcloud.notifications.NotificationManager;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.sfmcsdk.InitializationStatus;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdk;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdkModuleConfig;
import io.branch.rnbranch.RNBranchModule;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MainApplication extends NavigationApplication implements ReactApplication {
    private static final String PREF_NAME = "MYVUSESFMCParams";
    private static String TAG = "MainApplication";
    private static SharedPreferences sharedPreferences;
    private boolean isAppInForeground;
    private final ReactNativeHost mReactNativeHost = new NavigationReactNativeHost(this) { // from class: com.bat.myvuse.mobile.MainApplication.1
        @Override // com.facebook.react.ReactNativeHost
        public boolean getUseDeveloperSupport() {
            return false;
        }

        @Override // com.facebook.react.defaults.DefaultReactNativeHost
        protected boolean isNewArchEnabled() {
            return false;
        }

        @Override // com.facebook.react.ReactNativeHost
        protected List<ReactPackage> getPackages() {
            ArrayList<ReactPackage> packages = new PackageList(this).getPackages();
            packages.add(new LoadingViewPackage());
            packages.add(new NodesPackage());
            packages.add(new NotificationsPackage());
            packages.add(new PushNotificationHandlerPackege());
            return packages;
        }

        @Override // com.facebook.react.ReactNativeHost
        protected String getJSMainModuleName() {
            return FirebaseAnalytics.Param.INDEX;
        }

        @Override // com.facebook.react.defaults.DefaultReactNativeHost
        protected Boolean isHermesEnabled() {
            return true;
        }
    };

    @Override // com.facebook.react.ReactApplication
    public ReactNativeHost getReactNativeHost() {
        return this.mReactNativeHost;
    }

    @Override // com.reactnativenavigation.NavigationApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        SoLoader.init((Context) this, false);
        sharedPreferences = getSharedPreferences(PREF_NAME, 0);
        ProcessLifecycleOwner.get().getLifecycle().addObserver(new SdkLifecycle(this, ProcessLifecycleOwner.get().getLifecycle()));
        RNBranchModule.getAutoInstance(this);
        registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.bat.myvuse.mobile.MainApplication.2
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                MainApplication.this.isAppInForeground = true;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                MainApplication.this.isAppInForeground = false;
            }
        });
        if (sharedPreferences.contains("applicationId") && sharedPreferences.contains("accessToken") && sharedPreferences.contains("url")) {
            final String string = sharedPreferences.getString("applicationId", "");
            final String string2 = sharedPreferences.getString("accessToken", "");
            final String string3 = sharedPreferences.getString("url", "");
            LogInstrumentation.m2730i(TAG, "INIT SFMC SDK");
            LogInstrumentation.m2730i(TAG, "applicationId: " + string);
            LogInstrumentation.m2730i(TAG, "accessToken: " + string2);
            LogInstrumentation.m2730i(TAG, "url: " + string3);
            SFMCSdk.configure(this, SFMCSdkModuleConfig.build(new Function1() { // from class: com.bat.myvuse.mobile.MainApplication$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return this.f$0.lambda$onCreate$2(string, string2, string3, (SFMCSdkModuleConfig.Builder) obj);
                }
            }), new Function1() { // from class: com.bat.myvuse.mobile.MainApplication$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MainApplication.lambda$onCreate$3((InitializationStatus) obj);
                }
            });
            return;
        }
        LogInstrumentation.m2730i(TAG, "SFMC non init because props are still empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$2(String str, String str2, String str3, SFMCSdkModuleConfig.Builder builder) {
        builder.setPushModuleConfig(MarketingCloudConfig.builder().setApplicationId(str).setAccessToken(str2).setMarketingCloudServerUrl(str3).setNotificationCustomizationOptions(NotificationCustomizationOptions.create(new NotificationManager.NotificationBuilder() { // from class: com.bat.myvuse.mobile.MainApplication$$ExternalSyntheticLambda2
            @Override // com.salesforce.marketingcloud.notifications.NotificationManager.NotificationBuilder
            public final NotificationCompat.Builder setupNotificationBuilder(Context context, NotificationMessage notificationMessage) {
                return this.f$0.lambda$onCreate$0(context, notificationMessage);
            }
        })).setUrlHandler(new UrlHandler() { // from class: com.bat.myvuse.mobile.MainApplication$$ExternalSyntheticLambda3
            @Override // com.salesforce.marketingcloud.UrlHandler
            public final PendingIntent handleUrl(Context context, String str4, String str5) {
                return this.f$0.lambda$onCreate$1(context, str4, str5);
            }
        }).setAnalyticsEnabled(true).build(this));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ NotificationCompat.Builder lambda$onCreate$0(Context context, NotificationMessage notificationMessage) {
        String strCreateDefaultNotificationChannel = NotificationManager.createDefaultNotificationChannel(context);
        LogInstrumentation.m2730i(TAG, "Received notification");
        LogInstrumentation.m2730i(TAG, notificationMessage.toString());
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
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
        PendingIntent activity = PendingIntent.getActivity(context, new Random().nextInt(), intent, provideIntentFlags());
        NotificationCompat.Builder defaultNotificationBuilder = NotificationManager.getDefaultNotificationBuilder(context, notificationMessage, strCreateDefaultNotificationChannel, C1410R.drawable.atoms_branding_bg_logo);
        defaultNotificationBuilder.setContentIntent(NotificationManager.redirectIntentForAnalytics(context, activity, notificationMessage, true));
        return defaultNotificationBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ PendingIntent lambda$onCreate$1(Context context, String str, String str2) {
        return PendingIntent.getActivity(context, new Random().nextInt(), new Intent("android.intent.action.VIEW", Uri.parse(str)), provideIntentFlags());
    }

    static /* synthetic */ Unit lambda$onCreate$3(InitializationStatus initializationStatus) {
        LogInstrumentation.m2728e(TAG, "STATUS " + initializationStatus);
        if (initializationStatus.getStatus() != 1) {
            return null;
        }
        LogInstrumentation.m2728e(TAG, "STATUS SUCCESS");
        return null;
    }

    public static SharedPreferences getMySharedPreferences() {
        return sharedPreferences;
    }

    public static void setPref(String str, String str2) {
        SharedPreferences.Editor editorEdit = getMySharedPreferences().edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
        editorEdit.commit();
    }

    public boolean isAppInForeground() {
        return this.isAppInForeground;
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
}
