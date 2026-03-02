package com.salesforce.marketingcloud.messages.push;

import android.content.Context;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.MCService;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.util.C4393l;

/* JADX INFO: loaded from: classes6.dex */
public class MCFirebaseMessagingService extends FirebaseMessagingService {

    /* JADX INFO: renamed from: a */
    private static final String f5361a = C4170g.m3197a("MCFirebaseMessagingService");

    /* JADX INFO: renamed from: a */
    static void m3825a(RemoteMessage remoteMessage) {
        if (remoteMessage == null) {
            C4170g.m3216e(f5361a, "RemoteMessage was null.", new Object[0]);
            return;
        }
        String str = (remoteMessage.getData() == null || !remoteMessage.getData().containsKey(NotificationMessage.NOTIF_KEY_ID)) ? "Unknown Message" : remoteMessage.getData().get(NotificationMessage.NOTIF_KEY_ID);
        String str2 = f5361a;
        C4170g.m3213d(str2, "onMessageReceived() for MessageID: '%s'", str);
        MarketingCloudSdk marketingCloudSdkM3823a = m3823a();
        if (marketingCloudSdkM3823a == null) {
            C4170g.m3216e(str2, "Marketing Cloud SDK init failed.  Push message ignored.", new Object[0]);
        } else {
            marketingCloudSdkM3823a.getPushMessageManager().handleMessage(remoteMessage);
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        C4170g.m3213d(f5361a, "onMessageReceived()", new Object[0]);
        m3825a(remoteMessage);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        m3824a(this);
    }

    /* JADX INFO: renamed from: a */
    static void m3824a(Context context) {
        MarketingCloudSdk marketingCloudSdkM3823a = m3823a();
        if (marketingCloudSdkM3823a == null) {
            C4170g.m3216e(f5361a, "Marketing Cloud SDK init failed.  Unable to update push token.", new Object[0]);
            return;
        }
        String strSenderId = marketingCloudSdkM3823a.getMarketingCloudConfig().senderId();
        if (strSenderId != null) {
            MCService.m2821b(context, strSenderId);
        } else {
            C4170g.m3202a(f5361a, "Received new token intent but senderId was not set.", new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    private static MarketingCloudSdk m3823a() {
        if (C4393l.m4342a(1000L, 50L) && MarketingCloudSdk.getInstance() != null) {
            return MarketingCloudSdk.getInstance();
        }
        C4170g.m3216e(f5361a, "MarketingCloudSdk#init must be called in your application's onCreate", new Object[0]);
        return null;
    }
}
