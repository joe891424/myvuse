package com.salesforce.marketingcloud.notifications;

import android.app.PendingIntent;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.salesforce.marketingcloud.notifications.NotificationManager;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.notifications.c */
/* JADX INFO: loaded from: classes6.dex */
public class C4275c extends C4274b {
    public C4275c(int i, NotificationManager.NotificationChannelIdProvider notificationChannelIdProvider) {
        super(i, null, null, notificationChannelIdProvider);
    }

    @Override // com.salesforce.marketingcloud.notifications.C4274b, com.salesforce.marketingcloud.notifications.NotificationManager.NotificationBuilder
    public NotificationCompat.Builder setupNotificationBuilder(Context context, NotificationMessage notificationMessage) {
        NotificationCompat.Builder builderM3863a = C4274b.m3863a(context, notificationMessage, m3867a(context, notificationMessage), this.f5418d);
        PendingIntent pendingIntentM3869c = m3869c(context, notificationMessage);
        if (pendingIntentM3869c != null) {
            builderM3863a.setContentIntent(NotificationManager.redirectIntentForAnalytics(context, pendingIntentM3869c, notificationMessage, true));
        }
        return builderM3863a;
    }
}
