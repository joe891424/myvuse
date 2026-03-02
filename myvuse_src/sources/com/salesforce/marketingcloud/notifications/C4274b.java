package com.salesforce.marketingcloud.notifications;

import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import com.salesforce.marketingcloud.C4089R;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.notifications.NotificationManager;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.util.C4393l;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.notifications.b */
/* JADX INFO: loaded from: classes6.dex */
class C4274b implements NotificationManager.NotificationBuilder {

    /* JADX INFO: renamed from: a */
    private final NotificationManager.NotificationLaunchIntentProvider f5415a;

    /* JADX INFO: renamed from: b */
    private final NotificationManager.NotificationBuilder f5416b;

    /* JADX INFO: renamed from: c */
    private final NotificationManager.NotificationChannelIdProvider f5417c;

    /* JADX INFO: renamed from: d */
    final int f5418d;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.notifications.b$a */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f5419a;

        static {
            int[] iArr = new int[NotificationMessage.Sound.values().length];
            f5419a = iArr;
            try {
                iArr[NotificationMessage.Sound.CUSTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5419a[NotificationMessage.Sound.DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5419a[NotificationMessage.Sound.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public C4274b(int i, NotificationManager.NotificationLaunchIntentProvider notificationLaunchIntentProvider, NotificationManager.NotificationBuilder notificationBuilder, NotificationManager.NotificationChannelIdProvider notificationChannelIdProvider) {
        this.f5415a = notificationLaunchIntentProvider;
        this.f5416b = notificationBuilder;
        this.f5417c = notificationChannelIdProvider;
        this.f5418d = i;
    }

    /* JADX INFO: renamed from: a */
    static String m3864a(Context context, boolean z) {
        android.app.NotificationManager notificationManager;
        if (C4393l.m4349c() && (notificationManager = (android.app.NotificationManager) context.getSystemService("notification")) != null && (notificationManager.getNotificationChannel(NotificationManager.DEFAULT_FOREGROUND_CHANNEL_ID) == null || z)) {
            NotificationChannel notificationChannel = new NotificationChannel(NotificationManager.DEFAULT_FOREGROUND_CHANNEL_ID, context.getString(C4089R.string.mcsdk_foreground_notification_channel_name), 3);
            notificationChannel.enableLights(false);
            notificationChannel.enableVibration(false);
            notificationChannel.setShowBadge(false);
            notificationChannel.setSound(null, null);
            notificationChannel.setLockscreenVisibility(0);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        return NotificationManager.DEFAULT_FOREGROUND_CHANNEL_ID;
    }

    /* JADX INFO: renamed from: b */
    static String m3865b(Context context, boolean z) {
        android.app.NotificationManager notificationManager;
        if (C4393l.m4349c() && (notificationManager = (android.app.NotificationManager) context.getSystemService("notification")) != null && (notificationManager.getNotificationChannel(NotificationManager.DEFAULT_CHANNEL_ID) == null || z)) {
            NotificationChannel notificationChannel = new NotificationChannel(NotificationManager.DEFAULT_CHANNEL_ID, context.getString(C4089R.string.mcsdk_default_notification_channel_name), 3);
            notificationChannel.enableLights(false);
            notificationChannel.enableVibration(false);
            notificationChannel.setShowBadge(true);
            notificationChannel.setLockscreenVisibility(0);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        return NotificationManager.DEFAULT_CHANNEL_ID;
    }

    /* JADX INFO: renamed from: c */
    PendingIntent m3869c(Context context, NotificationMessage notificationMessage) {
        try {
            NotificationManager.NotificationLaunchIntentProvider notificationLaunchIntentProvider = this.f5415a;
            if (notificationLaunchIntentProvider != null) {
                return notificationLaunchIntentProvider.getNotificationPendingIntent(context, notificationMessage);
            }
        } catch (IllegalArgumentException e) {
            C4170g.m3207b(NotificationManager.f5388d, e, "Missing FLAG_IMMUTABLE or FLAG_MUTABLE flag in PendingIntent", new Object[0]);
        }
        int iM4333a = C4393l.m4333a(134217728);
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            return null;
        }
        Intent intentM3844a = NotificationManager.m3844a(launchIntentForPackage, notificationMessage);
        intentM3844a.addFlags(134217728);
        return PendingIntent.getActivity(context, notificationMessage.notificationId(), intentM3844a, iM4333a);
    }

    @Override // com.salesforce.marketingcloud.notifications.NotificationManager.NotificationBuilder
    public NotificationCompat.Builder setupNotificationBuilder(Context context, NotificationMessage notificationMessage) {
        NotificationCompat.Builder builderM3863a;
        NotificationManager.NotificationBuilder notificationBuilder = this.f5416b;
        if (notificationBuilder != null) {
            try {
                builderM3863a = notificationBuilder.setupNotificationBuilder(context, notificationMessage);
            } catch (Exception e) {
                C4170g.m3207b(NotificationManager.f5388d, e, "Custom notification builder threw an exception.  Using default notification builder.", new Object[0]);
                builderM3863a = null;
            }
        } else {
            builderM3863a = null;
        }
        if (builderM3863a == null) {
            builderM3863a = m3863a(context, notificationMessage, m3868b(context, notificationMessage), this.f5418d);
            PendingIntent pendingIntentM3869c = m3869c(context, notificationMessage);
            if (pendingIntentM3869c != null) {
                builderM3863a.setContentIntent(NotificationManager.redirectIntentForAnalytics(context, pendingIntentM3869c, notificationMessage, true));
            }
        }
        return builderM3863a;
    }

    /* JADX INFO: renamed from: a */
    private static Bitmap m3861a(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(URLConnectionInstrumentation.openConnection(new URL(str).openConnection())));
            httpURLConnection.setDoInput(true);
            httpURLConnection.setReadTimeout(HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT);
            httpURLConnection.setConnectTimeout(HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT);
            httpURLConnection.connect();
            return BitmapFactoryInstrumentation.decodeStream(httpURLConnection.getInputStream());
        } catch (Exception e) {
            C4170g.m3207b(NotificationManager.f5388d, e, "Unable to download image %s", str);
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    String m3868b(Context context, NotificationMessage notificationMessage) {
        String notificationChannelId;
        NotificationManager.NotificationChannelIdProvider notificationChannelIdProvider = this.f5417c;
        if (notificationChannelIdProvider != null) {
            try {
                notificationChannelId = notificationChannelIdProvider.getNotificationChannelId(context, notificationMessage);
            } catch (Exception e) {
                C4170g.m3207b(NotificationManager.f5388d, e, "Exception thrown while app determined channel id for notification message.", new Object[0]);
                notificationChannelId = null;
            }
        } else {
            notificationChannelId = null;
        }
        if (notificationChannelId != null) {
            return notificationChannelId;
        }
        m3865b(context, false);
        return NotificationManager.DEFAULT_CHANNEL_ID;
    }

    /* JADX INFO: renamed from: a */
    private static Uri m3862a(Context context, String str, Uri uri) {
        int identifier = context.getResources().getIdentifier(m3866b(str), "raw", context.getPackageName());
        return identifier > 0 ? Uri.parse("android.resource://" + context.getPackageName() + "/" + identifier) : uri;
    }

    /* JADX INFO: renamed from: b */
    private static String m3866b(String str) {
        return (str == null || str.lastIndexOf(46) <= 0) ? str : str.substring(0, str.lastIndexOf(46));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005e  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static androidx.core.app.NotificationCompat.Builder m3863a(android.content.Context r5, com.salesforce.marketingcloud.notifications.NotificationMessage r6, java.lang.String r7, int r8) {
        /*
            androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder
            r0.<init>(r5, r7)
            android.content.pm.ApplicationInfo r7 = r5.getApplicationInfo()
            int r7 = r7.icon
            if (r7 <= 0) goto L18
            android.content.res.Resources r1 = r5.getResources()
            android.graphics.Bitmap r7 = com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation.decodeResource(r1, r7)
            r0.setLargeIcon(r7)
        L18:
            r0.setSmallIcon(r8)
            java.lang.String r7 = r6.title()
            r0.setContentTitle(r7)
            java.lang.String r7 = r6.mediaUrl()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            r8 = 1
            r1 = 0
            if (r7 != 0) goto L5e
            java.lang.String r7 = r6.mediaUrl()     // Catch: java.lang.Exception -> L4e
            android.graphics.Bitmap r7 = m3861a(r7)     // Catch: java.lang.Exception -> L4e
            if (r7 == 0) goto L5e
            androidx.core.app.NotificationCompat$BigPictureStyle r2 = new androidx.core.app.NotificationCompat$BigPictureStyle     // Catch: java.lang.Exception -> L4e
            r2.<init>()     // Catch: java.lang.Exception -> L4e
            androidx.core.app.NotificationCompat$BigPictureStyle r7 = r2.bigPicture(r7)     // Catch: java.lang.Exception -> L4e
            java.lang.String r2 = r6.alert()     // Catch: java.lang.Exception -> L4e
            androidx.core.app.NotificationCompat$BigPictureStyle r7 = r7.setSummaryText(r2)     // Catch: java.lang.Exception -> L4e
            r0.setStyle(r7)     // Catch: java.lang.Exception -> L4e
            r7 = r8
            goto L5f
        L4e:
            r7 = move-exception
            java.lang.String r2 = com.salesforce.marketingcloud.notifications.NotificationManager.f5388d
            java.lang.String r3 = r6.mediaUrl()
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r4 = "Unable to load notification image %s"
            com.salesforce.marketingcloud.C4170g.m3207b(r2, r7, r4, r3)
        L5e:
            r7 = r1
        L5f:
            if (r7 != 0) goto L70
            java.lang.String r2 = r6.mediaAltText()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L70
            java.lang.String r2 = r6.mediaAltText()
            goto L74
        L70:
            java.lang.String r2 = r6.alert()
        L74:
            r0.setContentText(r2)
            r0.setTicker(r2)
            if (r7 != 0) goto L90
            androidx.core.app.NotificationCompat$BigTextStyle r7 = new androidx.core.app.NotificationCompat$BigTextStyle
            r7.<init>()
            androidx.core.app.NotificationCompat$BigTextStyle r7 = r7.bigText(r2)
            java.lang.String r2 = r6.title()
            androidx.core.app.NotificationCompat$BigTextStyle r7 = r7.setBigContentTitle(r2)
            r0.setStyle(r7)
        L90:
            int[] r7 = com.salesforce.marketingcloud.notifications.C4274b.a.f5419a
            com.salesforce.marketingcloud.notifications.NotificationMessage$Sound r2 = r6.sound()
            int r2 = r2.ordinal()
            r7 = r7[r2]
            if (r7 == r8) goto Lb2
            r5 = 2
            if (r7 == r5) goto Laf
            r5 = 3
            if (r7 == r5) goto La5
            goto Lbf
        La5:
            java.lang.String r5 = com.salesforce.marketingcloud.notifications.NotificationManager.f5388d
            java.lang.Object[] r6 = new java.lang.Object[r1]
            java.lang.String r7 = "No sound was set for notification."
            com.salesforce.marketingcloud.C4170g.m3202a(r5, r7, r6)
            goto Lbf
        Laf:
            android.net.Uri r5 = android.provider.Settings.System.DEFAULT_NOTIFICATION_URI
            goto Lbc
        Lb2:
            java.lang.String r6 = r6.soundName()
            android.net.Uri r7 = android.provider.Settings.System.DEFAULT_NOTIFICATION_URI
            android.net.Uri r5 = m3862a(r5, r6, r7)
        Lbc:
            r0.setSound(r5)
        Lbf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.notifications.C4274b.m3863a(android.content.Context, com.salesforce.marketingcloud.notifications.NotificationMessage, java.lang.String, int):androidx.core.app.NotificationCompat$Builder");
    }

    /* JADX INFO: renamed from: a */
    String m3867a(Context context, NotificationMessage notificationMessage) {
        String notificationChannelId;
        NotificationManager.NotificationChannelIdProvider notificationChannelIdProvider = this.f5417c;
        if (notificationChannelIdProvider != null) {
            try {
                notificationChannelId = notificationChannelIdProvider.getNotificationChannelId(context, notificationMessage);
            } catch (Exception e) {
                C4170g.m3207b(NotificationManager.f5388d, e, "Exception thrown while app determined channel id for notification message.", new Object[0]);
                notificationChannelId = null;
            }
        } else {
            notificationChannelId = null;
        }
        if (notificationChannelId != null) {
            return notificationChannelId;
        }
        m3864a(context, false);
        return NotificationManager.DEFAULT_FOREGROUND_CHANNEL_ID;
    }
}
