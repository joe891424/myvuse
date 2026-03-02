package com.dieam.reactnativepushnotification.modules;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import androidx.core.app.NotificationCompat;
import com.brentvatne.react.ReactVideoView;
import com.dieam.reactnativepushnotification.modules.RNPushNotificationPicturesAggregator;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jose4j.jwx.HeaderParameterNames;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class RNPushNotificationHelper {
    private static final long DEFAULT_VIBRATION = 300;
    public static final String PREFERENCES_KEY = "rn_push_notification";
    private RNPushNotificationConfig config;
    private Context context;
    private final SharedPreferences scheduledNotificationsPersistence;

    public RNPushNotificationHelper(Application application) {
        this.context = application;
        this.config = new RNPushNotificationConfig(application);
        this.scheduledNotificationsPersistence = application.getSharedPreferences(PREFERENCES_KEY, 0);
    }

    public Class getMainActivityClass() {
        try {
            return Class.forName(this.context.getPackageManager().getLaunchIntentForPackage(this.context.getPackageName()).getComponent().getClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private AlarmManager getAlarmManager() {
        return (AlarmManager) this.context.getSystemService(NotificationCompat.CATEGORY_ALARM);
    }

    public void invokeApp(Bundle bundle) {
        try {
            Intent intent = new Intent(this.context, Class.forName(this.context.getPackageManager().getLaunchIntentForPackage(this.context.getPackageName()).getComponent().getClassName()));
            if (bundle != null) {
                intent.putExtra("notification", bundle);
            }
            intent.addFlags(268435456);
            this.context.startActivity(intent);
        } catch (Exception e) {
            LogInstrumentation.m2729e(RNPushNotification.LOG_TAG, "Class not found", e);
        }
    }

    private PendingIntent toScheduleNotificationIntent(Bundle bundle) {
        try {
            int i = Integer.parseInt(bundle.getString("id"));
            Intent intent = new Intent(this.context, (Class<?>) RNPushNotificationPublisher.class);
            intent.putExtra("notificationId", i);
            intent.putExtras(bundle);
            return PendingIntent.getBroadcast(this.context, i, intent, 201326592);
        } catch (Exception e) {
            LogInstrumentation.m2729e(RNPushNotification.LOG_TAG, "Unable to parse Notification ID", e);
            return null;
        }
    }

    public void sendNotificationScheduled(Bundle bundle) {
        if (getMainActivityClass() == null) {
            LogInstrumentation.m2728e(RNPushNotification.LOG_TAG, "No activity class found for the scheduled notification");
            return;
        }
        if (bundle.getString("message") == null) {
            LogInstrumentation.m2728e(RNPushNotification.LOG_TAG, "No message specified for the scheduled notification");
            return;
        }
        if (bundle.getString("id") == null) {
            LogInstrumentation.m2728e(RNPushNotification.LOG_TAG, "No notification ID specified for the scheduled notification");
            return;
        }
        if (bundle.getDouble("fireDate") == 0.0d) {
            LogInstrumentation.m2728e(RNPushNotification.LOG_TAG, "No date specified for the scheduled notification");
            return;
        }
        RNPushNotificationAttributes rNPushNotificationAttributes = new RNPushNotificationAttributes(bundle);
        String id = rNPushNotificationAttributes.getId();
        LogInstrumentation.m2726d(RNPushNotification.LOG_TAG, "Storing push notification with id " + id);
        SharedPreferences.Editor editorEdit = this.scheduledNotificationsPersistence.edit();
        JSONObject json = rNPushNotificationAttributes.toJson();
        editorEdit.putString(id, !(json instanceof JSONObject) ? json.toString() : JSONObjectInstrumentation.toString(json));
        editorEdit.apply();
        if (!this.scheduledNotificationsPersistence.contains(id)) {
            LogInstrumentation.m2728e(RNPushNotification.LOG_TAG, "Failed to save " + id);
        }
        sendNotificationScheduledCore(bundle);
    }

    public void sendNotificationScheduledCore(Bundle bundle) {
        long j = (long) bundle.getDouble("fireDate");
        boolean z = bundle.getBoolean("allowWhileIdle");
        PendingIntent scheduleNotificationIntent = toScheduleNotificationIntent(bundle);
        if (scheduleNotificationIntent == null) {
            return;
        }
        LogInstrumentation.m2726d(RNPushNotification.LOG_TAG, String.format("Setting a notification with id %s at time %s", bundle.getString("id"), Long.toString(j)));
        if (z) {
            getAlarmManager().setExactAndAllowWhileIdle(0, j, scheduleNotificationIntent);
        } else {
            getAlarmManager().setExact(0, j, scheduleNotificationIntent);
        }
    }

    public void sendToNotificationCentre(final Bundle bundle) {
        RNPushNotificationPicturesAggregator rNPushNotificationPicturesAggregator = new RNPushNotificationPicturesAggregator(new RNPushNotificationPicturesAggregator.Callback() { // from class: com.dieam.reactnativepushnotification.modules.RNPushNotificationHelper.1
            @Override // com.dieam.reactnativepushnotification.modules.RNPushNotificationPicturesAggregator.Callback
            public void call(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
                RNPushNotificationHelper.this.sendToNotificationCentreWithPicture(bundle, bitmap, bitmap2, bitmap3);
            }
        });
        rNPushNotificationPicturesAggregator.setLargeIconUrl(this.context, bundle.getString("largeIconUrl"));
        rNPushNotificationPicturesAggregator.setBigLargeIconUrl(this.context, bundle.getString("bigLargeIconUrl"));
        rNPushNotificationPicturesAggregator.setBigPictureUrl(this.context, bundle.getString("bigPictureUrl"));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01ae A[Catch: Exception -> 0x04d0, TryCatch #0 {Exception -> 0x04d0, blocks: (B:19:0x0068, B:23:0x007e, B:25:0x0088, B:26:0x0090, B:59:0x00df, B:61:0x00e8, B:88:0x0135, B:90:0x013d, B:91:0x0143, B:93:0x0190, B:94:0x0193, B:96:0x0199, B:99:0x01a6, B:101:0x01ae, B:102:0x01b5, B:105:0x01c2, B:107:0x01c8, B:109:0x01ce, B:117:0x01e3, B:120:0x01ec, B:122:0x01f1, B:124:0x01f9, B:126:0x01ff, B:128:0x0205, B:134:0x0216, B:137:0x021f, B:138:0x0222, B:140:0x0232, B:143:0x0239, B:145:0x0241, B:147:0x0247, B:149:0x024d, B:151:0x0254, B:156:0x028a, B:159:0x02b6, B:160:0x02b9, B:162:0x02bf, B:165:0x02d3, B:167:0x02df, B:170:0x02ec, B:172:0x02ff, B:176:0x030d, B:178:0x0327, B:190:0x0359, B:192:0x0361, B:193:0x0364, B:195:0x0372, B:197:0x037a, B:198:0x0381, B:200:0x038f, B:202:0x0397, B:203:0x039e, B:204:0x03af, B:206:0x03b7, B:182:0x0331, B:184:0x0339, B:189:0x034b, B:175:0x030a, B:169:0x02e5, B:164:0x02c5, B:152:0x026a, B:154:0x0272, B:155:0x027c, B:131:0x020e, B:112:0x01d7, B:98:0x019f, B:68:0x0104, B:71:0x010e, B:74:0x0118, B:28:0x0094, B:31:0x009e, B:34:0x00a8, B:37:0x00b2, B:40:0x00bc), top: B:250:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01d7 A[Catch: Exception -> 0x04d0, TRY_LEAVE, TryCatch #0 {Exception -> 0x04d0, blocks: (B:19:0x0068, B:23:0x007e, B:25:0x0088, B:26:0x0090, B:59:0x00df, B:61:0x00e8, B:88:0x0135, B:90:0x013d, B:91:0x0143, B:93:0x0190, B:94:0x0193, B:96:0x0199, B:99:0x01a6, B:101:0x01ae, B:102:0x01b5, B:105:0x01c2, B:107:0x01c8, B:109:0x01ce, B:117:0x01e3, B:120:0x01ec, B:122:0x01f1, B:124:0x01f9, B:126:0x01ff, B:128:0x0205, B:134:0x0216, B:137:0x021f, B:138:0x0222, B:140:0x0232, B:143:0x0239, B:145:0x0241, B:147:0x0247, B:149:0x024d, B:151:0x0254, B:156:0x028a, B:159:0x02b6, B:160:0x02b9, B:162:0x02bf, B:165:0x02d3, B:167:0x02df, B:170:0x02ec, B:172:0x02ff, B:176:0x030d, B:178:0x0327, B:190:0x0359, B:192:0x0361, B:193:0x0364, B:195:0x0372, B:197:0x037a, B:198:0x0381, B:200:0x038f, B:202:0x0397, B:203:0x039e, B:204:0x03af, B:206:0x03b7, B:182:0x0331, B:184:0x0339, B:189:0x034b, B:175:0x030a, B:169:0x02e5, B:164:0x02c5, B:152:0x026a, B:154:0x0272, B:155:0x027c, B:131:0x020e, B:112:0x01d7, B:98:0x019f, B:68:0x0104, B:71:0x010e, B:74:0x0118, B:28:0x0094, B:31:0x009e, B:34:0x00a8, B:37:0x00b2, B:40:0x00bc), top: B:250:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01f1 A[Catch: Exception -> 0x04d0, TryCatch #0 {Exception -> 0x04d0, blocks: (B:19:0x0068, B:23:0x007e, B:25:0x0088, B:26:0x0090, B:59:0x00df, B:61:0x00e8, B:88:0x0135, B:90:0x013d, B:91:0x0143, B:93:0x0190, B:94:0x0193, B:96:0x0199, B:99:0x01a6, B:101:0x01ae, B:102:0x01b5, B:105:0x01c2, B:107:0x01c8, B:109:0x01ce, B:117:0x01e3, B:120:0x01ec, B:122:0x01f1, B:124:0x01f9, B:126:0x01ff, B:128:0x0205, B:134:0x0216, B:137:0x021f, B:138:0x0222, B:140:0x0232, B:143:0x0239, B:145:0x0241, B:147:0x0247, B:149:0x024d, B:151:0x0254, B:156:0x028a, B:159:0x02b6, B:160:0x02b9, B:162:0x02bf, B:165:0x02d3, B:167:0x02df, B:170:0x02ec, B:172:0x02ff, B:176:0x030d, B:178:0x0327, B:190:0x0359, B:192:0x0361, B:193:0x0364, B:195:0x0372, B:197:0x037a, B:198:0x0381, B:200:0x038f, B:202:0x0397, B:203:0x039e, B:204:0x03af, B:206:0x03b7, B:182:0x0331, B:184:0x0339, B:189:0x034b, B:175:0x030a, B:169:0x02e5, B:164:0x02c5, B:152:0x026a, B:154:0x0272, B:155:0x027c, B:131:0x020e, B:112:0x01d7, B:98:0x019f, B:68:0x0104, B:71:0x010e, B:74:0x0118, B:28:0x0094, B:31:0x009e, B:34:0x00a8, B:37:0x00b2, B:40:0x00bc), top: B:250:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x021f A[Catch: Exception -> 0x04d0, TryCatch #0 {Exception -> 0x04d0, blocks: (B:19:0x0068, B:23:0x007e, B:25:0x0088, B:26:0x0090, B:59:0x00df, B:61:0x00e8, B:88:0x0135, B:90:0x013d, B:91:0x0143, B:93:0x0190, B:94:0x0193, B:96:0x0199, B:99:0x01a6, B:101:0x01ae, B:102:0x01b5, B:105:0x01c2, B:107:0x01c8, B:109:0x01ce, B:117:0x01e3, B:120:0x01ec, B:122:0x01f1, B:124:0x01f9, B:126:0x01ff, B:128:0x0205, B:134:0x0216, B:137:0x021f, B:138:0x0222, B:140:0x0232, B:143:0x0239, B:145:0x0241, B:147:0x0247, B:149:0x024d, B:151:0x0254, B:156:0x028a, B:159:0x02b6, B:160:0x02b9, B:162:0x02bf, B:165:0x02d3, B:167:0x02df, B:170:0x02ec, B:172:0x02ff, B:176:0x030d, B:178:0x0327, B:190:0x0359, B:192:0x0361, B:193:0x0364, B:195:0x0372, B:197:0x037a, B:198:0x0381, B:200:0x038f, B:202:0x0397, B:203:0x039e, B:204:0x03af, B:206:0x03b7, B:182:0x0331, B:184:0x0339, B:189:0x034b, B:175:0x030a, B:169:0x02e5, B:164:0x02c5, B:152:0x026a, B:154:0x0272, B:155:0x027c, B:131:0x020e, B:112:0x01d7, B:98:0x019f, B:68:0x0104, B:71:0x010e, B:74:0x0118, B:28:0x0094, B:31:0x009e, B:34:0x00a8, B:37:0x00b2, B:40:0x00bc), top: B:250:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0232 A[Catch: Exception -> 0x04d0, TryCatch #0 {Exception -> 0x04d0, blocks: (B:19:0x0068, B:23:0x007e, B:25:0x0088, B:26:0x0090, B:59:0x00df, B:61:0x00e8, B:88:0x0135, B:90:0x013d, B:91:0x0143, B:93:0x0190, B:94:0x0193, B:96:0x0199, B:99:0x01a6, B:101:0x01ae, B:102:0x01b5, B:105:0x01c2, B:107:0x01c8, B:109:0x01ce, B:117:0x01e3, B:120:0x01ec, B:122:0x01f1, B:124:0x01f9, B:126:0x01ff, B:128:0x0205, B:134:0x0216, B:137:0x021f, B:138:0x0222, B:140:0x0232, B:143:0x0239, B:145:0x0241, B:147:0x0247, B:149:0x024d, B:151:0x0254, B:156:0x028a, B:159:0x02b6, B:160:0x02b9, B:162:0x02bf, B:165:0x02d3, B:167:0x02df, B:170:0x02ec, B:172:0x02ff, B:176:0x030d, B:178:0x0327, B:190:0x0359, B:192:0x0361, B:193:0x0364, B:195:0x0372, B:197:0x037a, B:198:0x0381, B:200:0x038f, B:202:0x0397, B:203:0x039e, B:204:0x03af, B:206:0x03b7, B:182:0x0331, B:184:0x0339, B:189:0x034b, B:175:0x030a, B:169:0x02e5, B:164:0x02c5, B:152:0x026a, B:154:0x0272, B:155:0x027c, B:131:0x020e, B:112:0x01d7, B:98:0x019f, B:68:0x0104, B:71:0x010e, B:74:0x0118, B:28:0x0094, B:31:0x009e, B:34:0x00a8, B:37:0x00b2, B:40:0x00bc), top: B:250:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x026a A[Catch: Exception -> 0x04d0, TryCatch #0 {Exception -> 0x04d0, blocks: (B:19:0x0068, B:23:0x007e, B:25:0x0088, B:26:0x0090, B:59:0x00df, B:61:0x00e8, B:88:0x0135, B:90:0x013d, B:91:0x0143, B:93:0x0190, B:94:0x0193, B:96:0x0199, B:99:0x01a6, B:101:0x01ae, B:102:0x01b5, B:105:0x01c2, B:107:0x01c8, B:109:0x01ce, B:117:0x01e3, B:120:0x01ec, B:122:0x01f1, B:124:0x01f9, B:126:0x01ff, B:128:0x0205, B:134:0x0216, B:137:0x021f, B:138:0x0222, B:140:0x0232, B:143:0x0239, B:145:0x0241, B:147:0x0247, B:149:0x024d, B:151:0x0254, B:156:0x028a, B:159:0x02b6, B:160:0x02b9, B:162:0x02bf, B:165:0x02d3, B:167:0x02df, B:170:0x02ec, B:172:0x02ff, B:176:0x030d, B:178:0x0327, B:190:0x0359, B:192:0x0361, B:193:0x0364, B:195:0x0372, B:197:0x037a, B:198:0x0381, B:200:0x038f, B:202:0x0397, B:203:0x039e, B:204:0x03af, B:206:0x03b7, B:182:0x0331, B:184:0x0339, B:189:0x034b, B:175:0x030a, B:169:0x02e5, B:164:0x02c5, B:152:0x026a, B:154:0x0272, B:155:0x027c, B:131:0x020e, B:112:0x01d7, B:98:0x019f, B:68:0x0104, B:71:0x010e, B:74:0x0118, B:28:0x0094, B:31:0x009e, B:34:0x00a8, B:37:0x00b2, B:40:0x00bc), top: B:250:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02b6 A[Catch: Exception -> 0x04d0, TRY_ENTER, TryCatch #0 {Exception -> 0x04d0, blocks: (B:19:0x0068, B:23:0x007e, B:25:0x0088, B:26:0x0090, B:59:0x00df, B:61:0x00e8, B:88:0x0135, B:90:0x013d, B:91:0x0143, B:93:0x0190, B:94:0x0193, B:96:0x0199, B:99:0x01a6, B:101:0x01ae, B:102:0x01b5, B:105:0x01c2, B:107:0x01c8, B:109:0x01ce, B:117:0x01e3, B:120:0x01ec, B:122:0x01f1, B:124:0x01f9, B:126:0x01ff, B:128:0x0205, B:134:0x0216, B:137:0x021f, B:138:0x0222, B:140:0x0232, B:143:0x0239, B:145:0x0241, B:147:0x0247, B:149:0x024d, B:151:0x0254, B:156:0x028a, B:159:0x02b6, B:160:0x02b9, B:162:0x02bf, B:165:0x02d3, B:167:0x02df, B:170:0x02ec, B:172:0x02ff, B:176:0x030d, B:178:0x0327, B:190:0x0359, B:192:0x0361, B:193:0x0364, B:195:0x0372, B:197:0x037a, B:198:0x0381, B:200:0x038f, B:202:0x0397, B:203:0x039e, B:204:0x03af, B:206:0x03b7, B:182:0x0331, B:184:0x0339, B:189:0x034b, B:175:0x030a, B:169:0x02e5, B:164:0x02c5, B:152:0x026a, B:154:0x0272, B:155:0x027c, B:131:0x020e, B:112:0x01d7, B:98:0x019f, B:68:0x0104, B:71:0x010e, B:74:0x0118, B:28:0x0094, B:31:0x009e, B:34:0x00a8, B:37:0x00b2, B:40:0x00bc), top: B:250:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02c5 A[Catch: Exception -> 0x04d0, TryCatch #0 {Exception -> 0x04d0, blocks: (B:19:0x0068, B:23:0x007e, B:25:0x0088, B:26:0x0090, B:59:0x00df, B:61:0x00e8, B:88:0x0135, B:90:0x013d, B:91:0x0143, B:93:0x0190, B:94:0x0193, B:96:0x0199, B:99:0x01a6, B:101:0x01ae, B:102:0x01b5, B:105:0x01c2, B:107:0x01c8, B:109:0x01ce, B:117:0x01e3, B:120:0x01ec, B:122:0x01f1, B:124:0x01f9, B:126:0x01ff, B:128:0x0205, B:134:0x0216, B:137:0x021f, B:138:0x0222, B:140:0x0232, B:143:0x0239, B:145:0x0241, B:147:0x0247, B:149:0x024d, B:151:0x0254, B:156:0x028a, B:159:0x02b6, B:160:0x02b9, B:162:0x02bf, B:165:0x02d3, B:167:0x02df, B:170:0x02ec, B:172:0x02ff, B:176:0x030d, B:178:0x0327, B:190:0x0359, B:192:0x0361, B:193:0x0364, B:195:0x0372, B:197:0x037a, B:198:0x0381, B:200:0x038f, B:202:0x0397, B:203:0x039e, B:204:0x03af, B:206:0x03b7, B:182:0x0331, B:184:0x0339, B:189:0x034b, B:175:0x030a, B:169:0x02e5, B:164:0x02c5, B:152:0x026a, B:154:0x0272, B:155:0x027c, B:131:0x020e, B:112:0x01d7, B:98:0x019f, B:68:0x0104, B:71:0x010e, B:74:0x0118, B:28:0x0094, B:31:0x009e, B:34:0x00a8, B:37:0x00b2, B:40:0x00bc), top: B:250:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02e5 A[Catch: Exception -> 0x04d0, TryCatch #0 {Exception -> 0x04d0, blocks: (B:19:0x0068, B:23:0x007e, B:25:0x0088, B:26:0x0090, B:59:0x00df, B:61:0x00e8, B:88:0x0135, B:90:0x013d, B:91:0x0143, B:93:0x0190, B:94:0x0193, B:96:0x0199, B:99:0x01a6, B:101:0x01ae, B:102:0x01b5, B:105:0x01c2, B:107:0x01c8, B:109:0x01ce, B:117:0x01e3, B:120:0x01ec, B:122:0x01f1, B:124:0x01f9, B:126:0x01ff, B:128:0x0205, B:134:0x0216, B:137:0x021f, B:138:0x0222, B:140:0x0232, B:143:0x0239, B:145:0x0241, B:147:0x0247, B:149:0x024d, B:151:0x0254, B:156:0x028a, B:159:0x02b6, B:160:0x02b9, B:162:0x02bf, B:165:0x02d3, B:167:0x02df, B:170:0x02ec, B:172:0x02ff, B:176:0x030d, B:178:0x0327, B:190:0x0359, B:192:0x0361, B:193:0x0364, B:195:0x0372, B:197:0x037a, B:198:0x0381, B:200:0x038f, B:202:0x0397, B:203:0x039e, B:204:0x03af, B:206:0x03b7, B:182:0x0331, B:184:0x0339, B:189:0x034b, B:175:0x030a, B:169:0x02e5, B:164:0x02c5, B:152:0x026a, B:154:0x0272, B:155:0x027c, B:131:0x020e, B:112:0x01d7, B:98:0x019f, B:68:0x0104, B:71:0x010e, B:74:0x0118, B:28:0x0094, B:31:0x009e, B:34:0x00a8, B:37:0x00b2, B:40:0x00bc), top: B:250:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02ff A[Catch: Exception -> 0x04d0, TryCatch #0 {Exception -> 0x04d0, blocks: (B:19:0x0068, B:23:0x007e, B:25:0x0088, B:26:0x0090, B:59:0x00df, B:61:0x00e8, B:88:0x0135, B:90:0x013d, B:91:0x0143, B:93:0x0190, B:94:0x0193, B:96:0x0199, B:99:0x01a6, B:101:0x01ae, B:102:0x01b5, B:105:0x01c2, B:107:0x01c8, B:109:0x01ce, B:117:0x01e3, B:120:0x01ec, B:122:0x01f1, B:124:0x01f9, B:126:0x01ff, B:128:0x0205, B:134:0x0216, B:137:0x021f, B:138:0x0222, B:140:0x0232, B:143:0x0239, B:145:0x0241, B:147:0x0247, B:149:0x024d, B:151:0x0254, B:156:0x028a, B:159:0x02b6, B:160:0x02b9, B:162:0x02bf, B:165:0x02d3, B:167:0x02df, B:170:0x02ec, B:172:0x02ff, B:176:0x030d, B:178:0x0327, B:190:0x0359, B:192:0x0361, B:193:0x0364, B:195:0x0372, B:197:0x037a, B:198:0x0381, B:200:0x038f, B:202:0x0397, B:203:0x039e, B:204:0x03af, B:206:0x03b7, B:182:0x0331, B:184:0x0339, B:189:0x034b, B:175:0x030a, B:169:0x02e5, B:164:0x02c5, B:152:0x026a, B:154:0x0272, B:155:0x027c, B:131:0x020e, B:112:0x01d7, B:98:0x019f, B:68:0x0104, B:71:0x010e, B:74:0x0118, B:28:0x0094, B:31:0x009e, B:34:0x00a8, B:37:0x00b2, B:40:0x00bc), top: B:250:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0331 A[Catch: Exception -> 0x04d0, TryCatch #0 {Exception -> 0x04d0, blocks: (B:19:0x0068, B:23:0x007e, B:25:0x0088, B:26:0x0090, B:59:0x00df, B:61:0x00e8, B:88:0x0135, B:90:0x013d, B:91:0x0143, B:93:0x0190, B:94:0x0193, B:96:0x0199, B:99:0x01a6, B:101:0x01ae, B:102:0x01b5, B:105:0x01c2, B:107:0x01c8, B:109:0x01ce, B:117:0x01e3, B:120:0x01ec, B:122:0x01f1, B:124:0x01f9, B:126:0x01ff, B:128:0x0205, B:134:0x0216, B:137:0x021f, B:138:0x0222, B:140:0x0232, B:143:0x0239, B:145:0x0241, B:147:0x0247, B:149:0x024d, B:151:0x0254, B:156:0x028a, B:159:0x02b6, B:160:0x02b9, B:162:0x02bf, B:165:0x02d3, B:167:0x02df, B:170:0x02ec, B:172:0x02ff, B:176:0x030d, B:178:0x0327, B:190:0x0359, B:192:0x0361, B:193:0x0364, B:195:0x0372, B:197:0x037a, B:198:0x0381, B:200:0x038f, B:202:0x0397, B:203:0x039e, B:204:0x03af, B:206:0x03b7, B:182:0x0331, B:184:0x0339, B:189:0x034b, B:175:0x030a, B:169:0x02e5, B:164:0x02c5, B:152:0x026a, B:154:0x0272, B:155:0x027c, B:131:0x020e, B:112:0x01d7, B:98:0x019f, B:68:0x0104, B:71:0x010e, B:74:0x0118, B:28:0x0094, B:31:0x009e, B:34:0x00a8, B:37:0x00b2, B:40:0x00bc), top: B:250:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0339 A[Catch: Exception -> 0x04d0, TryCatch #0 {Exception -> 0x04d0, blocks: (B:19:0x0068, B:23:0x007e, B:25:0x0088, B:26:0x0090, B:59:0x00df, B:61:0x00e8, B:88:0x0135, B:90:0x013d, B:91:0x0143, B:93:0x0190, B:94:0x0193, B:96:0x0199, B:99:0x01a6, B:101:0x01ae, B:102:0x01b5, B:105:0x01c2, B:107:0x01c8, B:109:0x01ce, B:117:0x01e3, B:120:0x01ec, B:122:0x01f1, B:124:0x01f9, B:126:0x01ff, B:128:0x0205, B:134:0x0216, B:137:0x021f, B:138:0x0222, B:140:0x0232, B:143:0x0239, B:145:0x0241, B:147:0x0247, B:149:0x024d, B:151:0x0254, B:156:0x028a, B:159:0x02b6, B:160:0x02b9, B:162:0x02bf, B:165:0x02d3, B:167:0x02df, B:170:0x02ec, B:172:0x02ff, B:176:0x030d, B:178:0x0327, B:190:0x0359, B:192:0x0361, B:193:0x0364, B:195:0x0372, B:197:0x037a, B:198:0x0381, B:200:0x038f, B:202:0x0397, B:203:0x039e, B:204:0x03af, B:206:0x03b7, B:182:0x0331, B:184:0x0339, B:189:0x034b, B:175:0x030a, B:169:0x02e5, B:164:0x02c5, B:152:0x026a, B:154:0x0272, B:155:0x027c, B:131:0x020e, B:112:0x01d7, B:98:0x019f, B:68:0x0104, B:71:0x010e, B:74:0x0118, B:28:0x0094, B:31:0x009e, B:34:0x00a8, B:37:0x00b2, B:40:0x00bc), top: B:250:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0361 A[Catch: Exception -> 0x04d0, TryCatch #0 {Exception -> 0x04d0, blocks: (B:19:0x0068, B:23:0x007e, B:25:0x0088, B:26:0x0090, B:59:0x00df, B:61:0x00e8, B:88:0x0135, B:90:0x013d, B:91:0x0143, B:93:0x0190, B:94:0x0193, B:96:0x0199, B:99:0x01a6, B:101:0x01ae, B:102:0x01b5, B:105:0x01c2, B:107:0x01c8, B:109:0x01ce, B:117:0x01e3, B:120:0x01ec, B:122:0x01f1, B:124:0x01f9, B:126:0x01ff, B:128:0x0205, B:134:0x0216, B:137:0x021f, B:138:0x0222, B:140:0x0232, B:143:0x0239, B:145:0x0241, B:147:0x0247, B:149:0x024d, B:151:0x0254, B:156:0x028a, B:159:0x02b6, B:160:0x02b9, B:162:0x02bf, B:165:0x02d3, B:167:0x02df, B:170:0x02ec, B:172:0x02ff, B:176:0x030d, B:178:0x0327, B:190:0x0359, B:192:0x0361, B:193:0x0364, B:195:0x0372, B:197:0x037a, B:198:0x0381, B:200:0x038f, B:202:0x0397, B:203:0x039e, B:204:0x03af, B:206:0x03b7, B:182:0x0331, B:184:0x0339, B:189:0x034b, B:175:0x030a, B:169:0x02e5, B:164:0x02c5, B:152:0x026a, B:154:0x0272, B:155:0x027c, B:131:0x020e, B:112:0x01d7, B:98:0x019f, B:68:0x0104, B:71:0x010e, B:74:0x0118, B:28:0x0094, B:31:0x009e, B:34:0x00a8, B:37:0x00b2, B:40:0x00bc), top: B:250:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03b7 A[Catch: JSONException -> 0x03c8, Exception -> 0x04d0, TRY_LEAVE, TryCatch #0 {Exception -> 0x04d0, blocks: (B:19:0x0068, B:23:0x007e, B:25:0x0088, B:26:0x0090, B:59:0x00df, B:61:0x00e8, B:88:0x0135, B:90:0x013d, B:91:0x0143, B:93:0x0190, B:94:0x0193, B:96:0x0199, B:99:0x01a6, B:101:0x01ae, B:102:0x01b5, B:105:0x01c2, B:107:0x01c8, B:109:0x01ce, B:117:0x01e3, B:120:0x01ec, B:122:0x01f1, B:124:0x01f9, B:126:0x01ff, B:128:0x0205, B:134:0x0216, B:137:0x021f, B:138:0x0222, B:140:0x0232, B:143:0x0239, B:145:0x0241, B:147:0x0247, B:149:0x024d, B:151:0x0254, B:156:0x028a, B:159:0x02b6, B:160:0x02b9, B:162:0x02bf, B:165:0x02d3, B:167:0x02df, B:170:0x02ec, B:172:0x02ff, B:176:0x030d, B:178:0x0327, B:190:0x0359, B:192:0x0361, B:193:0x0364, B:195:0x0372, B:197:0x037a, B:198:0x0381, B:200:0x038f, B:202:0x0397, B:203:0x039e, B:204:0x03af, B:206:0x03b7, B:182:0x0331, B:184:0x0339, B:189:0x034b, B:175:0x030a, B:169:0x02e5, B:164:0x02c5, B:152:0x026a, B:154:0x0272, B:155:0x027c, B:131:0x020e, B:112:0x01d7, B:98:0x019f, B:68:0x0104, B:71:0x010e, B:74:0x0118, B:28:0x0094, B:31:0x009e, B:34:0x00a8, B:37:0x00b2, B:40:0x00bc), top: B:250:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x048b A[Catch: Exception -> 0x04ce, TryCatch #1 {Exception -> 0x04ce, blocks: (B:216:0x03d4, B:218:0x03da, B:219:0x03de, B:221:0x0413, B:222:0x0416, B:224:0x0426, B:228:0x0477, B:225:0x045b, B:227:0x046d, B:229:0x0480, B:231:0x048b, B:232:0x0497, B:234:0x049d, B:240:0x04ca, B:236:0x04a5, B:238:0x04b8, B:239:0x04c5, B:213:0x03cd, B:204:0x03af, B:206:0x03b7), top: B:252:0x03af, inners: #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x04a5 A[Catch: Exception -> 0x04ce, TryCatch #1 {Exception -> 0x04ce, blocks: (B:216:0x03d4, B:218:0x03da, B:219:0x03de, B:221:0x0413, B:222:0x0416, B:224:0x0426, B:228:0x0477, B:225:0x045b, B:227:0x046d, B:229:0x0480, B:231:0x048b, B:232:0x0497, B:234:0x049d, B:240:0x04ca, B:236:0x04a5, B:238:0x04b8, B:239:0x04c5, B:213:0x03cd, B:204:0x03af, B:206:0x03b7), top: B:252:0x03af, inners: #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:238:0x04b8 A[Catch: Exception -> 0x04ce, TryCatch #1 {Exception -> 0x04ce, blocks: (B:216:0x03d4, B:218:0x03da, B:219:0x03de, B:221:0x0413, B:222:0x0416, B:224:0x0426, B:228:0x0477, B:225:0x045b, B:227:0x046d, B:229:0x0480, B:231:0x048b, B:232:0x0497, B:234:0x049d, B:240:0x04ca, B:236:0x04a5, B:238:0x04b8, B:239:0x04c5, B:213:0x03cd, B:204:0x03af, B:206:0x03b7), top: B:252:0x03af, inners: #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x04c5 A[Catch: Exception -> 0x04ce, TryCatch #1 {Exception -> 0x04ce, blocks: (B:216:0x03d4, B:218:0x03da, B:219:0x03de, B:221:0x0413, B:222:0x0416, B:224:0x0426, B:228:0x0477, B:225:0x045b, B:227:0x046d, B:229:0x0480, B:231:0x048b, B:232:0x0497, B:234:0x049d, B:240:0x04ca, B:236:0x04a5, B:238:0x04b8, B:239:0x04c5, B:213:0x03cd, B:204:0x03af, B:206:0x03b7), top: B:252:0x03af, inners: #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x013d A[Catch: Exception -> 0x04d0, TryCatch #0 {Exception -> 0x04d0, blocks: (B:19:0x0068, B:23:0x007e, B:25:0x0088, B:26:0x0090, B:59:0x00df, B:61:0x00e8, B:88:0x0135, B:90:0x013d, B:91:0x0143, B:93:0x0190, B:94:0x0193, B:96:0x0199, B:99:0x01a6, B:101:0x01ae, B:102:0x01b5, B:105:0x01c2, B:107:0x01c8, B:109:0x01ce, B:117:0x01e3, B:120:0x01ec, B:122:0x01f1, B:124:0x01f9, B:126:0x01ff, B:128:0x0205, B:134:0x0216, B:137:0x021f, B:138:0x0222, B:140:0x0232, B:143:0x0239, B:145:0x0241, B:147:0x0247, B:149:0x024d, B:151:0x0254, B:156:0x028a, B:159:0x02b6, B:160:0x02b9, B:162:0x02bf, B:165:0x02d3, B:167:0x02df, B:170:0x02ec, B:172:0x02ff, B:176:0x030d, B:178:0x0327, B:190:0x0359, B:192:0x0361, B:193:0x0364, B:195:0x0372, B:197:0x037a, B:198:0x0381, B:200:0x038f, B:202:0x0397, B:203:0x039e, B:204:0x03af, B:206:0x03b7, B:182:0x0331, B:184:0x0339, B:189:0x034b, B:175:0x030a, B:169:0x02e5, B:164:0x02c5, B:152:0x026a, B:154:0x0272, B:155:0x027c, B:131:0x020e, B:112:0x01d7, B:98:0x019f, B:68:0x0104, B:71:0x010e, B:74:0x0118, B:28:0x0094, B:31:0x009e, B:34:0x00a8, B:37:0x00b2, B:40:0x00bc), top: B:250:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0190 A[Catch: Exception -> 0x04d0, TryCatch #0 {Exception -> 0x04d0, blocks: (B:19:0x0068, B:23:0x007e, B:25:0x0088, B:26:0x0090, B:59:0x00df, B:61:0x00e8, B:88:0x0135, B:90:0x013d, B:91:0x0143, B:93:0x0190, B:94:0x0193, B:96:0x0199, B:99:0x01a6, B:101:0x01ae, B:102:0x01b5, B:105:0x01c2, B:107:0x01c8, B:109:0x01ce, B:117:0x01e3, B:120:0x01ec, B:122:0x01f1, B:124:0x01f9, B:126:0x01ff, B:128:0x0205, B:134:0x0216, B:137:0x021f, B:138:0x0222, B:140:0x0232, B:143:0x0239, B:145:0x0241, B:147:0x0247, B:149:0x024d, B:151:0x0254, B:156:0x028a, B:159:0x02b6, B:160:0x02b9, B:162:0x02bf, B:165:0x02d3, B:167:0x02df, B:170:0x02ec, B:172:0x02ff, B:176:0x030d, B:178:0x0327, B:190:0x0359, B:192:0x0361, B:193:0x0364, B:195:0x0372, B:197:0x037a, B:198:0x0381, B:200:0x038f, B:202:0x0397, B:203:0x039e, B:204:0x03af, B:206:0x03b7, B:182:0x0331, B:184:0x0339, B:189:0x034b, B:175:0x030a, B:169:0x02e5, B:164:0x02c5, B:152:0x026a, B:154:0x0272, B:155:0x027c, B:131:0x020e, B:112:0x01d7, B:98:0x019f, B:68:0x0104, B:71:0x010e, B:74:0x0118, B:28:0x0094, B:31:0x009e, B:34:0x00a8, B:37:0x00b2, B:40:0x00bc), top: B:250:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x019f A[Catch: Exception -> 0x04d0, TryCatch #0 {Exception -> 0x04d0, blocks: (B:19:0x0068, B:23:0x007e, B:25:0x0088, B:26:0x0090, B:59:0x00df, B:61:0x00e8, B:88:0x0135, B:90:0x013d, B:91:0x0143, B:93:0x0190, B:94:0x0193, B:96:0x0199, B:99:0x01a6, B:101:0x01ae, B:102:0x01b5, B:105:0x01c2, B:107:0x01c8, B:109:0x01ce, B:117:0x01e3, B:120:0x01ec, B:122:0x01f1, B:124:0x01f9, B:126:0x01ff, B:128:0x0205, B:134:0x0216, B:137:0x021f, B:138:0x0222, B:140:0x0232, B:143:0x0239, B:145:0x0241, B:147:0x0247, B:149:0x024d, B:151:0x0254, B:156:0x028a, B:159:0x02b6, B:160:0x02b9, B:162:0x02bf, B:165:0x02d3, B:167:0x02df, B:170:0x02ec, B:172:0x02ff, B:176:0x030d, B:178:0x0327, B:190:0x0359, B:192:0x0361, B:193:0x0364, B:195:0x0372, B:197:0x037a, B:198:0x0381, B:200:0x038f, B:202:0x0397, B:203:0x039e, B:204:0x03af, B:206:0x03b7, B:182:0x0331, B:184:0x0339, B:189:0x034b, B:175:0x030a, B:169:0x02e5, B:164:0x02c5, B:152:0x026a, B:154:0x0272, B:155:0x027c, B:131:0x020e, B:112:0x01d7, B:98:0x019f, B:68:0x0104, B:71:0x010e, B:74:0x0118, B:28:0x0094, B:31:0x009e, B:34:0x00a8, B:37:0x00b2, B:40:0x00bc), top: B:250:0x0068 }] */
    /* JADX WARN: Type inference failed for: r12v22, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v25, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v29 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void sendToNotificationCentreWithPicture(android.os.Bundle r25, android.graphics.Bitmap r26, android.graphics.Bitmap r27, android.graphics.Bitmap r28) {
        /*
            Method dump skipped, instruction units count: 1266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dieam.reactnativepushnotification.modules.RNPushNotificationHelper.sendToNotificationCentreWithPicture(android.os.Bundle, android.graphics.Bitmap, android.graphics.Bitmap, android.graphics.Bitmap):void");
    }

    private void scheduleNextNotificationIfRepeating(Bundle bundle) {
        long timeInMillis;
        String string = bundle.getString("repeatType");
        long j = (long) bundle.getDouble("repeatTime");
        if (string != null) {
            long j2 = (long) bundle.getDouble("fireDate");
            if (!Arrays.asList("time", "month", "week", "day", "hour", "minute").contains(string)) {
                LogInstrumentation.m2734w(RNPushNotification.LOG_TAG, String.format("Invalid repeatType specified as %s", string));
                return;
            }
            if ("time".equals(string) && j <= 0) {
                LogInstrumentation.m2734w(RNPushNotification.LOG_TAG, "repeatType specified as time but no repeatTime has been mentioned");
                return;
            }
            if ("time".equals(string)) {
                timeInMillis = j2 + j;
            } else {
                int repeatField = getRepeatField(string);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(j2);
                calendar.add(repeatField, j > 0 ? (int) j : 1);
                timeInMillis = calendar.getTimeInMillis();
            }
            if (timeInMillis != 0) {
                LogInstrumentation.m2726d(RNPushNotification.LOG_TAG, String.format("Repeating notification with id %s at time %s", bundle.getString("id"), Long.toString(timeInMillis)));
                bundle.putDouble("fireDate", timeInMillis);
                sendNotificationScheduled(bundle);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int getRepeatField(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = 1
            r2 = 3
            r3 = 2
            switch(r0) {
                case -1074026988: goto L34;
                case 99228: goto L2a;
                case 3208676: goto L20;
                case 3645428: goto L15;
                case 104080000: goto Lb;
                default: goto La;
            }
        La:
            goto L3e
        Lb:
            java.lang.String r0 = "month"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L3e
            r5 = 0
            goto L3f
        L15:
            java.lang.String r0 = "week"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L3e
            r5 = r1
            goto L3f
        L20:
            java.lang.String r0 = "hour"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L3e
            r5 = r3
            goto L3f
        L2a:
            java.lang.String r0 = "day"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L3e
            r5 = 4
            goto L3f
        L34:
            java.lang.String r0 = "minute"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L3e
            r5 = r2
            goto L3f
        L3e:
            r5 = -1
        L3f:
            if (r5 == 0) goto L50
            if (r5 == r1) goto L4f
            if (r5 == r3) goto L4c
            if (r5 == r2) goto L49
            r5 = 5
            return r5
        L49:
            r5 = 12
            return r5
        L4c:
            r5 = 10
            return r5
        L4f:
            return r2
        L50:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dieam.reactnativepushnotification.modules.RNPushNotificationHelper.getRepeatField(java.lang.String):int");
    }

    private Uri getSoundUri(String str) {
        int identifier;
        if (str == null || Constants.COLLATION_DEFAULT.equalsIgnoreCase(str)) {
            return RingtoneManager.getDefaultUri(2);
        }
        if (this.context.getResources().getIdentifier(str, "raw", this.context.getPackageName()) != 0) {
            identifier = this.context.getResources().getIdentifier(str, "raw", this.context.getPackageName());
        } else {
            identifier = this.context.getResources().getIdentifier(str.substring(0, str.lastIndexOf(46)), "raw", this.context.getPackageName());
        }
        return Uri.parse("android.resource://" + this.context.getPackageName() + "/" + identifier);
    }

    public void clearNotifications() {
        LogInstrumentation.m2730i(RNPushNotification.LOG_TAG, "Clearing alerts from the notification centre");
        notificationManager().cancelAll();
    }

    public void clearNotification(String str, int i) {
        LogInstrumentation.m2730i(RNPushNotification.LOG_TAG, "Clearing notification: " + i);
        NotificationManager notificationManager = notificationManager();
        if (str != null) {
            notificationManager.cancel(str, i);
        } else {
            notificationManager.cancel(i);
        }
    }

    public void clearDeliveredNotifications(ReadableArray readableArray) {
        NotificationManager notificationManager = notificationManager();
        for (int i = 0; i < readableArray.size(); i++) {
            String string = readableArray.getString(i);
            LogInstrumentation.m2730i(RNPushNotification.LOG_TAG, "Removing notification with id " + string);
            notificationManager.cancel(Integer.parseInt(string));
        }
    }

    public WritableArray getDeliveredNotifications() {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        StatusBarNotification[] activeNotifications = notificationManager().getActiveNotifications();
        LogInstrumentation.m2730i(RNPushNotification.LOG_TAG, "Found " + activeNotifications.length + " delivered notifications");
        for (StatusBarNotification statusBarNotification : activeNotifications) {
            Notification notification = statusBarNotification.getNotification();
            Bundle bundle = notification.extras;
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString(ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER, "" + statusBarNotification.getId());
            writableMapCreateMap.putString("title", bundle.getString(NotificationCompat.EXTRA_TITLE));
            writableMapCreateMap.putString("body", bundle.getString(NotificationCompat.EXTRA_TEXT));
            writableMapCreateMap.putString(HeaderParameterNames.AUTHENTICATION_TAG, statusBarNotification.getTag());
            writableMapCreateMap.putString("group", notification.getGroup());
            writableArrayCreateArray.pushMap(writableMapCreateMap);
        }
        return writableArrayCreateArray;
    }

    public WritableArray getScheduledLocalNotifications() {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Iterator<Map.Entry<String, ?>> it2 = this.scheduledNotificationsPersistence.getAll().entrySet().iterator();
        while (it2.hasNext()) {
            try {
                RNPushNotificationAttributes rNPushNotificationAttributesFromJson = RNPushNotificationAttributes.fromJson(it2.next().getValue().toString());
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putString("title", rNPushNotificationAttributesFromJson.getTitle());
                writableMapCreateMap.putString("message", rNPushNotificationAttributesFromJson.getMessage());
                writableMapCreateMap.putString("number", rNPushNotificationAttributesFromJson.getNumber());
                writableMapCreateMap.putDouble("date", rNPushNotificationAttributesFromJson.getFireDate());
                writableMapCreateMap.putString("id", rNPushNotificationAttributesFromJson.getId());
                writableMapCreateMap.putString("repeatInterval", rNPushNotificationAttributesFromJson.getRepeatType());
                writableMapCreateMap.putString("soundName", rNPushNotificationAttributesFromJson.getSound());
                writableMapCreateMap.putString("data", rNPushNotificationAttributesFromJson.getUserInfo());
                writableArrayCreateArray.pushMap(writableMapCreateMap);
            } catch (JSONException e) {
                LogInstrumentation.m2728e(RNPushNotification.LOG_TAG, e.getMessage());
            }
        }
        return writableArrayCreateArray;
    }

    public void cancelAllScheduledNotifications() {
        LogInstrumentation.m2730i(RNPushNotification.LOG_TAG, "Cancelling all notifications");
        Iterator<String> it2 = this.scheduledNotificationsPersistence.getAll().keySet().iterator();
        while (it2.hasNext()) {
            cancelScheduledNotification(it2.next());
        }
    }

    public void cancelScheduledNotification(String str) {
        LogInstrumentation.m2730i(RNPushNotification.LOG_TAG, "Cancelling notification: " + str);
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        PendingIntent scheduleNotificationIntent = toScheduleNotificationIntent(bundle);
        if (scheduleNotificationIntent != null) {
            getAlarmManager().cancel(scheduleNotificationIntent);
        }
        if (this.scheduledNotificationsPersistence.contains(str)) {
            SharedPreferences.Editor editorEdit = this.scheduledNotificationsPersistence.edit();
            editorEdit.remove(str);
            editorEdit.apply();
        } else {
            LogInstrumentation.m2734w(RNPushNotification.LOG_TAG, "Unable to find notification " + str);
        }
        try {
            notificationManager().cancel(Integer.parseInt(str));
        } catch (Exception e) {
            LogInstrumentation.m2729e(RNPushNotification.LOG_TAG, "Unable to parse Notification ID " + str, e);
        }
    }

    private NotificationManager notificationManager() {
        return (NotificationManager) this.context.getSystemService("notification");
    }

    public List<String> listChannels() {
        ArrayList arrayList = new ArrayList();
        NotificationManager notificationManager = notificationManager();
        if (notificationManager == null) {
            return arrayList;
        }
        Iterator<NotificationChannel> it2 = notificationManager.getNotificationChannels().iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().getId());
        }
        return arrayList;
    }

    public boolean channelBlocked(String str) {
        NotificationChannel notificationChannel;
        NotificationManager notificationManager = notificationManager();
        return (notificationManager == null || (notificationChannel = notificationManager.getNotificationChannel(str)) == null || notificationChannel.getImportance() != 0) ? false : true;
    }

    public boolean channelExists(String str) {
        NotificationManager notificationManager = notificationManager();
        return (notificationManager == null || notificationManager.getNotificationChannel(str) == null) ? false : true;
    }

    public void deleteChannel(String str) {
        NotificationManager notificationManager = notificationManager();
        if (notificationManager == null) {
            return;
        }
        notificationManager.deleteNotificationChannel(str);
    }

    private boolean checkOrCreateChannel(NotificationManager notificationManager, String str, String str2, String str3, Uri uri, int i, long[] jArr) {
        if (notificationManager == null) {
            return false;
        }
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
        if ((notificationChannel != null || str2 == null || str3 == null) && (notificationChannel == null || ((str2 == null || str2.equals(notificationChannel.getName())) && (str3 == null || str3.equals(notificationChannel.getDescription()))))) {
            return false;
        }
        NotificationChannel notificationChannel2 = new NotificationChannel(str, str2, i);
        notificationChannel2.setDescription(str3);
        notificationChannel2.enableLights(true);
        notificationChannel2.enableVibration(jArr != null);
        notificationChannel2.setVibrationPattern(jArr);
        if (uri != null) {
            notificationChannel2.setSound(uri, new AudioAttributes.Builder().setContentType(4).setUsage(5).build());
        } else {
            notificationChannel2.setSound(null, null);
        }
        notificationManager.createNotificationChannel(notificationChannel2);
        return true;
    }

    public boolean createChannel(ReadableMap readableMap) {
        String string = readableMap.getString("channelId");
        String string2 = readableMap.getString("channelName");
        String string3 = readableMap.hasKey("channelDescription") ? readableMap.getString("channelDescription") : "";
        boolean z = !readableMap.hasKey("playSound") || readableMap.getBoolean("playSound");
        String string4 = readableMap.hasKey("soundName") ? readableMap.getString("soundName") : Constants.COLLATION_DEFAULT;
        return checkOrCreateChannel(notificationManager(), string, string2, string3, z ? getSoundUri(string4) : null, readableMap.hasKey(AnalyticsAttribute.APP_EXIT_IMPORTANCE_ATTRIBUTE) ? readableMap.getInt(AnalyticsAttribute.APP_EXIT_IMPORTANCE_ATTRIBUTE) : 4, (readableMap.hasKey("vibrate") && readableMap.getBoolean("vibrate")) ? new long[]{0, DEFAULT_VIBRATION} : null);
    }

    public boolean isApplicationInForeground() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(this.context.getPackageName()) && runningAppProcessInfo.importance == 100 && runningAppProcessInfo.pkgList.length > 0) {
                return true;
            }
        }
        return false;
    }
}
