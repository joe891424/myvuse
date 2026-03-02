package com.salesforce.marketingcloud.notifications;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.RemoteMessage;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.NotificationOpenedService;
import com.salesforce.marketingcloud.internal.C4185h;
import com.salesforce.marketingcloud.internal.C4186i;
import com.salesforce.marketingcloud.util.C4393l;

/* JADX INFO: loaded from: classes6.dex */
public abstract class NotificationManager {
    public static final String ACTION_NOTIFICATION_CLICKED = "com.salesforce.marketingcloud.NOTIFICATION_CLICKED";
    public static final String DEFAULT_CHANNEL_ID = "com.salesforce.marketingcloud.DEFAULT_CHANNEL";
    public static final String DEFAULT_FOREGROUND_CHANNEL_ID = "com.salesforce.marketingcloud.DEFAULT_FOREGROUND_CHANNEL";

    /* JADX INFO: renamed from: d */
    static final String f5388d = C4170g.m3197a("NotificationManager");

    /* JADX INFO: renamed from: e */
    private static final String f5389e = "com.salesforce.marketingcloud.notifications.EXTRA_MESSAGE";

    public interface NotificationBuilder {
        NotificationCompat.Builder setupNotificationBuilder(Context context, NotificationMessage notificationMessage);
    }

    public interface NotificationChannelIdProvider {
        String getNotificationChannelId(Context context, NotificationMessage notificationMessage);
    }

    public interface NotificationLaunchIntentProvider {
        PendingIntent getNotificationPendingIntent(Context context, NotificationMessage notificationMessage);
    }

    public interface NotificationMessageDisplayedListener {
        void onNotificationMessageDisplayed(NotificationMessage notificationMessage);
    }

    public interface ShouldShowNotificationListener {
        boolean shouldShowNotification(NotificationMessage notificationMessage);
    }

    /* JADX INFO: renamed from: a */
    static Intent m3844a(Intent intent, NotificationMessage notificationMessage) {
        return intent.putExtra(f5389e, C4186i.m3383a(notificationMessage));
    }

    public static void cancelNotificationMessage(Context context, NotificationMessage notificationMessage) {
        if (notificationMessage.notificationId() >= 0) {
            ((android.app.NotificationManager) context.getSystemService("notification")).cancel("com.marketingcloud.salesforce.notifications.TAG", notificationMessage.notificationId());
        }
    }

    public static String createDefaultNotificationChannel(Context context) {
        return C4274b.m3865b(context, false);
    }

    public static String createForegroundNotificationChannel(Context context) {
        return C4274b.m3864a(context, false);
    }

    public static NotificationMessage extractMessage(Intent intent) {
        try {
            return (NotificationMessage) C4186i.m3382a(intent.getByteArrayExtra(f5389e), NotificationMessage.CREATOR);
        } catch (Exception e) {
            C4170g.m3207b(f5388d, e, "Unable to retrieve NotificationMessage from Intent (%s).", intent);
            return null;
        }
    }

    public static NotificationCompat.Builder getDefaultNotificationBuilder(Context context, NotificationMessage notificationMessage, String str, int i) {
        return C4274b.m3863a(context, notificationMessage, str, i);
    }

    public static PendingIntent redirectIntentForAnalytics(Context context, PendingIntent pendingIntent, RemoteMessage remoteMessage, boolean z) {
        try {
            return redirectIntentForAnalytics(context, pendingIntent, C4185h.m3377a(remoteMessage.getData()), z);
        } catch (Exception e) {
            C4170g.m3207b(f5388d, e, "Failed to create {NotificationMessage} from {RemoteMessage}, not processing {PendingIntent} for analytics.", new Object[0]);
            return null;
        }
    }

    public abstract boolean areNotificationsEnabled();

    public abstract void disableNotifications();

    public abstract void enableNotifications();

    public abstract void registerNotificationMessageDisplayedListener(NotificationMessageDisplayedListener notificationMessageDisplayedListener);

    public abstract void setShouldShowNotificationListener(ShouldShowNotificationListener shouldShowNotificationListener);

    public abstract void unregisterNotificationMessageDisplayedListener(NotificationMessageDisplayedListener notificationMessageDisplayedListener);

    public static String createDefaultNotificationChannel(Context context, boolean z) {
        return C4274b.m3865b(context, z);
    }

    public static PendingIntent redirectIntentForAnalytics(Context context, PendingIntent pendingIntent, NotificationMessage notificationMessage, boolean z) {
        Bundle bundle = new Bundle(3);
        bundle.putByteArray(f5389e, C4186i.m3383a(notificationMessage));
        bundle.putParcelable("com.salesforce.marketingcloud.notifications.EXTRA_OPEN_INTENT", pendingIntent);
        bundle.putBoolean("com.salesforce.marketingcloud.notifications.EXTRA_AUTO_CANCEL", z);
        Uri uriFromParts = Uri.fromParts("mcsdk", "pushOpen", String.valueOf(System.currentTimeMillis()));
        int iM4333a = C4393l.m4333a(1073741824);
        return Build.VERSION.SDK_INT >= 31 ? PendingIntent.getActivity(context, 0, NotificationOpenActivity.m3852a(context, bundle).setData(uriFromParts), iM4333a) : PendingIntent.getService(context, 0, NotificationOpenedService.m2842b(context, bundle).setData(uriFromParts), iM4333a);
    }
}
