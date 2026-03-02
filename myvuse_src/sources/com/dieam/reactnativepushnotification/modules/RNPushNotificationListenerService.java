package com.dieam.reactnativepushnotification.modules;

import android.os.Handler;
import android.os.Looper;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;

/* JADX INFO: loaded from: classes3.dex */
public class RNPushNotificationListenerService extends FirebaseMessagingService {
    private FirebaseMessagingService mFirebaseServiceDelegate;
    private RNReceivedMessageHandler mMessageReceivedHandler;

    public RNPushNotificationListenerService() {
        this.mMessageReceivedHandler = new RNReceivedMessageHandler(this);
    }

    public RNPushNotificationListenerService(FirebaseMessagingService firebaseMessagingService) {
        this.mFirebaseServiceDelegate = firebaseMessagingService;
        this.mMessageReceivedHandler = new RNReceivedMessageHandler(firebaseMessagingService);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(final String str) {
        final FirebaseMessagingService firebaseMessagingService = this.mFirebaseServiceDelegate;
        if (firebaseMessagingService == null) {
            firebaseMessagingService = this;
        }
        LogInstrumentation.m2726d(RNPushNotification.LOG_TAG, "Refreshed token: " + str);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.dieam.reactnativepushnotification.modules.RNPushNotificationListenerService.1
            @Override // java.lang.Runnable
            public void run() {
                final ReactInstanceManager reactInstanceManager = ((ReactApplication) firebaseMessagingService.getApplication()).getReactNativeHost().getReactInstanceManager();
                ReactContext currentReactContext = reactInstanceManager.getCurrentReactContext();
                if (currentReactContext != null) {
                    RNPushNotificationListenerService.this.handleNewToken((ReactApplicationContext) currentReactContext, str);
                    return;
                }
                reactInstanceManager.addReactInstanceEventListener(new ReactInstanceManager.ReactInstanceEventListener() { // from class: com.dieam.reactnativepushnotification.modules.RNPushNotificationListenerService.1.1
                    @Override // com.facebook.react.ReactInstanceEventListener
                    public void onReactContextInitialized(ReactContext reactContext) {
                        RNPushNotificationListenerService.this.handleNewToken((ReactApplicationContext) reactContext, str);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNewToken(ReactApplicationContext reactApplicationContext, String str) {
        RNPushNotificationJsDelivery rNPushNotificationJsDelivery = new RNPushNotificationJsDelivery(reactApplicationContext);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("deviceToken", str);
        rNPushNotificationJsDelivery.sendEvent("remoteNotificationsRegistered", writableMapCreateMap);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        this.mMessageReceivedHandler.handleReceivedMessage(remoteMessage);
    }
}
