package com.salesforce.marketingcloud;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.salesforce.marketingcloud.notifications.C4273a;
import com.salesforce.marketingcloud.notifications.NotificationManager;
import com.salesforce.marketingcloud.util.C4393l;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class NotificationOpenedService extends IntentService {

    /* JADX INFO: renamed from: a */
    private static final String f4281a = C4170g.m3197a("NotificationOpenedService");

    public NotificationOpenedService() {
        super(f4281a);
    }

    /* JADX INFO: renamed from: a */
    private static void m2841a(Context context, Bundle bundle) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(C4273a.f5394n).putExtras(bundle));
    }

    /* JADX INFO: renamed from: b */
    public static Intent m2842b(Context context, Bundle bundle) {
        return new Intent(context, (Class<?>) NotificationOpenedService.class).setAction(NotificationManager.ACTION_NOTIFICATION_CLICKED).putExtras(bundle);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return;
        }
        PowerManager.WakeLock wakeLockNewWakeLock = null;
        try {
            try {
                PowerManager powerManager = (PowerManager) getSystemService("power");
                String str = f4281a;
                wakeLockNewWakeLock = powerManager.newWakeLock(1, str);
                wakeLockNewWakeLock.setReferenceCounted(false);
                wakeLockNewWakeLock.acquire(TimeUnit.SECONDS.toMillis(30L));
                if (!C4393l.m4342a(500L, 50L) || MarketingCloudSdk.getInstance() == null) {
                    C4170g.m3216e(str, "MarketingCloudSdk#init must be called in your application's onCreate", new Object[0]);
                } else if (NotificationManager.ACTION_NOTIFICATION_CLICKED.equals(intent.getAction())) {
                    m2841a(getApplicationContext(), intent.getExtras());
                }
                if (!wakeLockNewWakeLock.isHeld()) {
                    return;
                }
            } catch (Exception e) {
                C4170g.m3207b(f4281a, e, "Encountered exception while handling action: %s", intent.getAction());
                if (0 == 0 || !wakeLockNewWakeLock.isHeld()) {
                    return;
                }
            }
            try {
                wakeLockNewWakeLock.release();
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            if (0 != 0 && wakeLockNewWakeLock.isHeld()) {
                try {
                    wakeLockNewWakeLock.release();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }
}
