package com.bat.myvuse.mobile;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.dieam.reactnativepushnotification.modules.RNReceivedMessageHandler;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.messages.push.PushMessageManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class NotificationService extends FirebaseMessagingService {
    private static String TAG = "NotificationService";
    private FirebaseMessagingService mFirebaseServiceDelegate;
    private RNReceivedMessageHandler mMessageReceivedHandler;

    public NotificationService() {
        this.mMessageReceivedHandler = new RNReceivedMessageHandler(this);
    }

    public NotificationService(FirebaseMessagingService firebaseMessagingService) {
        this.mFirebaseServiceDelegate = firebaseMessagingService;
        this.mMessageReceivedHandler = new RNReceivedMessageHandler(firebaseMessagingService);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(final String str) {
        LogInstrumentation.m2730i(TAG, "entro in onNewToken. Token: " + str);
        MarketingCloudSdk.requestSdk(new MarketingCloudSdk.WhenReadyListener() { // from class: com.bat.myvuse.mobile.NotificationService$$ExternalSyntheticLambda0
            @Override // com.salesforce.marketingcloud.MarketingCloudSdk.WhenReadyListener
            public final void ready(MarketingCloudSdk marketingCloudSdk) {
                marketingCloudSdk.getPushMessageManager().setPushToken(str);
            }
        });
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(final RemoteMessage remoteMessage) {
        LogInstrumentation.m2730i(TAG, "Enter in onMessageReceived");
        LogInstrumentation.m2730i(TAG, remoteMessage.toString());
        if (PushMessageManager.isMarketingCloudPush(remoteMessage)) {
            LogInstrumentation.m2730i(TAG, "Push by SFMC");
            if (!((MainApplication) getApplication()).isAppInForeground()) {
                LogInstrumentation.m2726d(TAG, "App in background");
                MarketingCloudSdk.requestSdk(new MarketingCloudSdk.WhenReadyListener() { // from class: com.bat.myvuse.mobile.NotificationService$$ExternalSyntheticLambda1
                    @Override // com.salesforce.marketingcloud.MarketingCloudSdk.WhenReadyListener
                    public final void ready(MarketingCloudSdk marketingCloudSdk) {
                        marketingCloudSdk.getPushMessageManager().handleMessage(remoteMessage);
                    }
                });
                return;
            }
            LogInstrumentation.m2726d(TAG, "App in foreground");
            LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
            Intent intent = new Intent("my-custom-event");
            LogInstrumentation.m2730i(TAG, "remoteMessage.getNotification()");
            String str = remoteMessage.getData().get("webview_title");
            String str2 = remoteMessage.getData().get("webview_url");
            String str3 = remoteMessage.getData().get("title");
            String str4 = remoteMessage.getData().get("alert");
            String str5 = remoteMessage.getData().get("cta");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cta", str5);
                jSONObject.put("webview_title", str);
                jSONObject.put("webview_url", str2);
                jSONObject.put("title", str3);
                jSONObject.put("message", str4);
                jSONObject.put("foreground", true);
            } catch (JSONException unused) {
                LogInstrumentation.m2728e(TAG, "parsing error");
            }
            intent.putExtra("notification", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
            localBroadcastManager.sendBroadcast(intent);
            return;
        }
        LogInstrumentation.m2730i(TAG, "Push of other systems different from SFMC (Firebase)");
        if (remoteMessage.getNotification() != null) {
            LogInstrumentation.m2726d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
            this.mMessageReceivedHandler.handleReceivedMessage(remoteMessage);
        }
    }
}
