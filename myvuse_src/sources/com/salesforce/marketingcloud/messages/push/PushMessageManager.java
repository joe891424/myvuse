package com.salesforce.marketingcloud.messages.push;

import com.google.firebase.messaging.RemoteMessage;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public abstract class PushMessageManager {

    /* JADX INFO: renamed from: d */
    static final String f5362d = C4170g.m3197a("PushMessageManager");

    /* JADX INFO: renamed from: e */
    public static final String f5363e = "com.salesforce.marketingcloud.messages.push.TOKEN_REFRESHED";

    /* JADX INFO: renamed from: f */
    public static final String f5364f = "com.salesforce.marketingcloud.push.TOKEN_REFRESH_SUCCESSFUL";

    /* JADX INFO: renamed from: g */
    public static final String f5365g = "com.salesforce.marketingcloud.push.TOKEN_SENDER_ID";

    /* JADX INFO: renamed from: h */
    public static final String f5366h = "com.salesforce.marketingcloud.notifications.PUSH_ENABLED";

    /* JADX INFO: renamed from: i */
    public static final String f5367i = "com.salesforce.marketingcloud.push.TOKEN";

    public interface PushTokenRefreshListener {
        void onTokenRefreshed(String str);
    }

    public interface SilentPushListener {
        void silentPushReceived(Map<String, String> map);
    }

    public static boolean isMarketingCloudPush(RemoteMessage remoteMessage) {
        return remoteMessage != null && isMarketingCloudPush(remoteMessage.getData());
    }

    public abstract void disablePush();

    public abstract void enablePush();

    public abstract JSONObject getPushDebugInfo();

    public abstract String getPushToken();

    public abstract boolean handleMessage(RemoteMessage remoteMessage);

    public abstract boolean handleMessage(Map<String, String> map);

    public abstract boolean isPushEnabled();

    public abstract void registerSilentPushListener(SilentPushListener silentPushListener);

    public abstract void registerTokenRefreshListener(PushTokenRefreshListener pushTokenRefreshListener);

    public abstract void setPushToken(String str);

    public abstract void unregisterSilentPushListener(SilentPushListener silentPushListener);

    public abstract void unregisterTokenRefreshListener(PushTokenRefreshListener pushTokenRefreshListener);

    public static boolean isMarketingCloudPush(Map<String, String> map) {
        return map != null && "SFMC".equalsIgnoreCase(map.get(NotificationMessage.NOTIF_KEY_SID));
    }
}
