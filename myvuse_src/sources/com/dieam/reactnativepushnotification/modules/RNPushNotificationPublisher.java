package com.dieam.reactnativepushnotification.modules;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
public class RNPushNotificationPublisher extends BroadcastReceiver {
    static final String NOTIFICATION_ID = "notificationId";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        LogInstrumentation.m2730i(RNPushNotification.LOG_TAG, "NotificationPublisher: Prepare To Publish: " + intent.getIntExtra(NOTIFICATION_ID, 0) + ", Now Time: " + System.currentTimeMillis());
        Bundle extras = intent.getExtras();
        LogInstrumentation.m2732v(RNPushNotification.LOG_TAG, "onMessageReceived: " + extras);
        handleLocalNotification(context, extras);
    }

    private void handleLocalNotification(Context context, Bundle bundle) {
        if (bundle.getString("id") == null) {
            bundle.putString("id", String.valueOf(new SecureRandom().nextInt()));
        }
        RNPushNotificationHelper rNPushNotificationHelper = new RNPushNotificationHelper((Application) context.getApplicationContext());
        LogInstrumentation.m2732v(RNPushNotification.LOG_TAG, "sendNotification: " + bundle);
        rNPushNotificationHelper.sendToNotificationCentre(bundle);
    }
}
