package com.salesforce.marketingcloud.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.Trace;
import com.salesforce.marketingcloud.C4170g;

/* JADX INFO: loaded from: classes6.dex */
public class NotificationOpenActivity extends FragmentActivity implements TraceFieldInterface {

    /* JADX INFO: renamed from: b */
    private static final String f5391b = C4170g.m3197a("NotificationOpenActivity");
    public Trace _nr_trace;

    /* JADX INFO: renamed from: a */
    private BroadcastReceiver f5392a;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.notifications.NotificationOpenActivity$a */
    class C4272a extends BroadcastReceiver {
        C4272a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NotificationOpenActivity.this.m3854a();
        }
    }

    /* JADX INFO: renamed from: a */
    public static Intent m3852a(Context context, Bundle bundle) {
        return new Intent(context, (Class<?>) NotificationOpenActivity.class).setAction(NotificationManager.ACTION_NOTIFICATION_CLICKED).putExtras(bundle).setFlags(8388608);
    }

    /* JADX INFO: renamed from: b */
    private void m3853b(Context context, Bundle bundle) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(C4273a.f5394n).putExtras(bundle));
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00ba A[EXC_TOP_SPLITTER, PHI: r1
      0x00ba: PHI (r1v2 android.os.PowerManager$WakeLock) = (r1v1 android.os.PowerManager$WakeLock), (r1v3 android.os.PowerManager$WakeLock) binds: [B:27:0x00b8, B:19:0x0099] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onCreate(android.os.Bundle r7) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.notifications.NotificationOpenActivity.onCreate(android.os.Bundle):void");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    /* JADX INFO: renamed from: a */
    protected void m3854a() {
        if (this.f5392a != null) {
            try {
                LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f5392a);
            } catch (IllegalArgumentException unused) {
                C4170g.m3216e(f5391b, "com.salesforce.marketingcloud.notifications.open.RECEIVED Receiver is not registered.", new Object[0]);
            }
        }
        if (isFinishing()) {
            return;
        }
        finish();
    }
}
