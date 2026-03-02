package com.dieam.reactnativepushnotification.modules;

import android.app.Application;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.RemoteInput;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.ReactContext;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: loaded from: classes3.dex */
public class RNPushNotificationActions extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        String str = context.getPackageName() + ".ACTION_";
        LogInstrumentation.m2730i(RNPushNotification.LOG_TAG, "RNPushNotificationBootEventReceiver loading scheduled notifications");
        if (intent.getAction() == null || !intent.getAction().startsWith(str)) {
            return;
        }
        final Bundle bundleExtra = intent.getBundleExtra("notification");
        Bundle resultsFromIntent = RemoteInput.getResultsFromIntent(intent);
        if (resultsFromIntent != null) {
            bundleExtra.putCharSequence("reply_text", resultsFromIntent.getCharSequence(RNPushNotification.KEY_TEXT_REPLY));
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        int i = Integer.parseInt(bundleExtra.getString("id"));
        if (bundleExtra.getBoolean("autoCancel", true)) {
            if (bundleExtra.containsKey(HeaderParameterNames.AUTHENTICATION_TAG)) {
                notificationManager.cancel(bundleExtra.getString(HeaderParameterNames.AUTHENTICATION_TAG), i);
            } else {
                notificationManager.cancel(i);
            }
        }
        if (bundleExtra.getBoolean("invokeApp", true)) {
            new RNPushNotificationHelper((Application) context.getApplicationContext()).invokeApp(bundleExtra);
            context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.dieam.reactnativepushnotification.modules.RNPushNotificationActions.1
                @Override // java.lang.Runnable
                public void run() {
                    final ReactInstanceManager reactInstanceManager = ((ReactApplication) context.getApplicationContext()).getReactNativeHost().getReactInstanceManager();
                    ReactContext currentReactContext = reactInstanceManager.getCurrentReactContext();
                    if (currentReactContext != null) {
                        new RNPushNotificationJsDelivery(currentReactContext).notifyNotificationAction(bundleExtra);
                        return;
                    }
                    reactInstanceManager.addReactInstanceEventListener(new ReactInstanceManager.ReactInstanceEventListener() { // from class: com.dieam.reactnativepushnotification.modules.RNPushNotificationActions.1.1
                        @Override // com.facebook.react.ReactInstanceEventListener
                        public void onReactContextInitialized(ReactContext reactContext) {
                            new RNPushNotificationJsDelivery(reactContext).notifyNotificationAction(bundleExtra);
                            reactInstanceManager.removeReactInstanceEventListener(this);
                        }
                    });
                    if (reactInstanceManager.hasStartedCreatingInitialContext()) {
                        return;
                    }
                    reactInstanceManager.createReactContextInBackground();
                }
            });
        }
    }
}
