package com.qualtrics.digital;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.qualtrics.C3902R;
import java.util.UUID;

/* JADX INFO: loaded from: classes6.dex */
public class QualtricsNotificationManager extends BroadcastReceiver {
    private static final String CHANNEL_ID = "qualtrics_notification_channel";

    public final class IntentKeys {
        static final String ACTIONSETID = "actionSetID";
        static final String AUTO_CLOSE_AT_END_OF_SURVEY = "autoCloseAtEndOfSurvey";
        static final String CREATIVEID = "creativeID";
        private static final String DESCRIPTION = "description";
        static final String INTERCEPTID = "interceptID";
        static final String TARGET_URL = "targetURL";
        private static final String TITLE = "title";

        public IntentKeys() {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            Bundle extras = intent.getExtras();
            display(context, extras.getString("title"), extras.getString("description"), extras.getString("targetURL"), extras.getString("interceptID"), extras.getString("creativeID"), extras.getString("actionSetID"), extras.getBoolean("autoCloseAtEndOfSurvey"));
        } catch (Throwable th) {
            CrashReporter.logCrash(th);
        }
    }

    static boolean schedule(Context context, NotificationOptions notificationOptions, String str, String str2, String str3, String str4, boolean z) {
        if (!((NotificationManager) context.getSystemService(NotificationManager.class)).areNotificationsEnabled()) {
            QualtricsLog.logError("Could not schedule notification - notifications are disabled");
            return false;
        }
        if (notificationOptions.Notification.Delay == 0) {
            display(context, notificationOptions.Notification.Title, notificationOptions.Notification.Description, str, str2, str3, str4, z);
            return true;
        }
        String string = UUID.randomUUID().toString();
        Bundle bundle = new Bundle();
        bundle.putString("targetURL", str);
        bundle.putString("description", notificationOptions.Notification.Description);
        bundle.putString("title", notificationOptions.Notification.Title);
        bundle.putString("interceptID", str2);
        bundle.putString("creativeID", str3);
        bundle.putString("actionSetID", str4);
        bundle.putBoolean("autoCloseAtEndOfSurvey", z);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, (Class<?>) QualtricsNotificationManager.class).putExtras(bundle).setFlags(874512384).setData(Uri.parse(string)), 67108864);
        ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(2, SystemClock.elapsedRealtime() + ((long) (notificationOptions.Notification.Delay * 1000)), broadcast);
        return true;
    }

    private static void display(Context context, String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        String string = UUID.randomUUID().toString();
        int i = C3902R.drawable.default_notification_icon;
        int notificationIconAsset = Properties.instance(context).getNotificationIconAsset();
        if (notificationIconAsset != 0) {
            i = notificationIconAsset;
        }
        Intent flags = new Intent(context, (Class<?>) QualtricsSurveyActivity.class).putExtra("targetURL", str3).putExtra("interceptID", str4).putExtra("creativeID", str5).putExtra("actionSetID", str6).setData(Uri.parse(string)).setFlags(874512384);
        flags.putExtra("autoCloseAtEndOfSurvey", z);
        PendingIntent activity = PendingIntent.getActivity(context, 0, flags, 67108864);
        NotificationCompat.Builder autoCancel = new NotificationCompat.Builder(context, CHANNEL_ID).setSmallIcon(i).setContentTitle(str).setContentText(str2).setPriority(0).setGroup(string).setAutoCancel(true);
        if (str3 != null) {
            autoCancel.setContentIntent(activity);
        }
        NotificationManagerCompat.from(context).notify(string, 0, autoCancel.build());
    }

    static void createChannel(Context context) {
        String string = context.getResources().getString(C3902R.string.qualtrics_channel_name);
        String string2 = context.getResources().getString(C3902R.string.qualtrics_channel_description);
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, string, 3);
        notificationChannel.setDescription(string2);
        ((NotificationManager) context.getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
    }
}
