package com.salesforce.marketingcloud.notifications;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.InterfaceC4147e;
import com.salesforce.marketingcloud.analytics.InterfaceC4115j;
import com.salesforce.marketingcloud.behaviors.C4140c;
import com.salesforce.marketingcloud.behaviors.EnumC4138a;
import com.salesforce.marketingcloud.notifications.NotificationManager;
import com.salesforce.marketingcloud.storage.C4374j;
import com.salesforce.marketingcloud.util.C4391j;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.notifications.a */
/* JADX INFO: loaded from: classes6.dex */
public class C4273a extends NotificationManager implements InterfaceC4147e {

    /* JADX INFO: renamed from: n */
    public static final String f5394n = "com.salesforce.marketingcloud.notifications.OPENED";

    /* JADX INFO: renamed from: o */
    public static final String f5395o = "com.salesforce.marketingcloud.notifications.open.RECEIVED";

    /* JADX INFO: renamed from: p */
    public static final String f5396p = "com.salesforce.marketingcloud.notifications.MESSAGE";

    /* JADX INFO: renamed from: q */
    static final String f5397q = "com.salesforce.marketingcloud.notifications.EXTRA_OPEN_INTENT";

    /* JADX INFO: renamed from: r */
    static final String f5398r = "com.salesforce.marketingcloud.notifications.EXTRA_AUTO_CANCEL";

    /* JADX INFO: renamed from: s */
    public static final int f5399s = -1;

    /* JADX INFO: renamed from: t */
    static final String f5400t = "com.marketingcloud.salesforce.notifications.TAG";

    /* JADX INFO: renamed from: u */
    static final String f5401u = "com.marketingcloud.salesforce.notifications.ENABLED";

    /* JADX INFO: renamed from: v */
    static final String f5402v = "notification_id_key";

    /* JADX INFO: renamed from: f */
    final C4274b f5403f;

    /* JADX INFO: renamed from: g */
    final Context f5404g;

    /* JADX INFO: renamed from: h */
    private final C4374j f5405h;

    /* JADX INFO: renamed from: j */
    private final InterfaceC4115j f5407j;

    /* JADX INFO: renamed from: k */
    private NotificationManager.ShouldShowNotificationListener f5408k;

    /* JADX INFO: renamed from: l */
    private BroadcastReceiver f5409l;

    /* JADX INFO: renamed from: m */
    private boolean f5410m = true;

    /* JADX INFO: renamed from: i */
    private final Set<NotificationManager.NotificationMessageDisplayedListener> f5406i = new ArraySet();

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.notifications.a$a */
    class a extends Thread {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ NotificationMessage f5411a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ b f5412b;

        a(NotificationMessage notificationMessage, b bVar) {
            this.f5411a = notificationMessage;
            this.f5412b = bVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int iNotificationId;
            android.app.NotificationManager notificationManager;
            C4273a c4273a = C4273a.this;
            NotificationCompat.Builder builder = c4273a.f5403f.setupNotificationBuilder(c4273a.f5404g, this.f5411a);
            try {
                notificationManager = (android.app.NotificationManager) C4273a.this.f5404g.getSystemService("notification");
            } catch (Exception e) {
                C4170g.m3207b(NotificationManager.f5388d, e, "Unable to show notification due to an exception thrown by Android.", new Object[0]);
            }
            if (notificationManager != null) {
                notificationManager.notify(C4273a.f5400t, this.f5411a.notificationId(), builder.build());
                C4273a.this.m3859a(this.f5411a);
                iNotificationId = this.f5411a.notificationId();
            } else {
                iNotificationId = -1;
            }
            b bVar = this.f5412b;
            if (bVar != null) {
                bVar.mo3675a(iNotificationId);
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.notifications.a$b */
    public interface b {
        /* JADX INFO: renamed from: a */
        void mo3675a(int i);
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.notifications.a$c */
    class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C4170g.m3202a(NotificationManager.f5388d, "Received null intent", new Object[0]);
                return;
            }
            LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(C4273a.f5395o));
            String action = intent.getAction();
            if (action == null) {
                C4170g.m3202a(NotificationManager.f5388d, "Received null action", new Object[0]);
            } else if (C4273a.f5394n.equals(action)) {
                C4273a.this.m3858a(context, NotificationManager.extractMessage(intent), (PendingIntent) intent.getParcelableExtra(C4273a.f5397q), intent.getBooleanExtra(C4273a.f5398r, true));
            } else {
                C4170g.m3202a(NotificationManager.f5388d, "Received unknown action: %s", action);
            }
        }
    }

    C4273a(Context context, C4374j c4374j, C4274b c4274b, InterfaceC4115j interfaceC4115j) {
        this.f5404g = context;
        this.f5405h = c4374j;
        this.f5403f = c4274b;
        this.f5407j = (InterfaceC4115j) C4391j.m4326a(interfaceC4115j, "MessageAnalyticEventListener is null.");
    }

    /* JADX INFO: renamed from: a */
    private void m3857a(Context context) {
        if (this.f5405h == null) {
            return;
        }
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(context);
        int i = this.f5405h.mo4222f().getInt(f5402v, -1);
        for (int i2 = 0; i >= 0 && i2 < 100; i2++) {
            notificationManagerCompatFrom.cancel(f5400t, i);
            i--;
        }
    }

    @Override // com.salesforce.marketingcloud.notifications.NotificationManager
    public final synchronized boolean areNotificationsEnabled() {
        return this.f5410m;
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public final String componentName() {
        return "NotificationManager";
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public final JSONObject componentState() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("notificationsEnabled", areNotificationsEnabled());
            NotificationManager.ShouldShowNotificationListener shouldShowNotificationListener = this.f5408k;
            if (shouldShowNotificationListener != null) {
                jSONObject.put("shouldShowNotificationListener", shouldShowNotificationListener.getClass().getName());
            }
        } catch (JSONException e) {
            C4170g.m3207b(NotificationManager.f5388d, e, "Unable to create component state for %s", componentName());
        }
        return jSONObject;
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4147e
    public void controlChannelInit(int i) {
    }

    @Override // com.salesforce.marketingcloud.notifications.NotificationManager
    public final synchronized void disableNotifications() {
        if (this.f5410m) {
            this.f5410m = false;
            m3856a();
        }
    }

    @Override // com.salesforce.marketingcloud.notifications.NotificationManager
    public final synchronized void enableNotifications() {
        if (this.f5410m) {
            return;
        }
        this.f5410m = true;
        m3856a();
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4147e
    public final void init(InitializationStatus.C4081a c4081a, int i) {
        this.f5410m = this.f5405h.mo4222f().getBoolean(f5401u, true);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(f5394n);
        this.f5409l = new c();
        LocalBroadcastManager.getInstance(this.f5404g).registerReceiver(this.f5409l, intentFilter);
    }

    @Override // com.salesforce.marketingcloud.notifications.NotificationManager
    public final void registerNotificationMessageDisplayedListener(NotificationManager.NotificationMessageDisplayedListener notificationMessageDisplayedListener) {
        if (notificationMessageDisplayedListener == null) {
            return;
        }
        synchronized (this.f5406i) {
            this.f5406i.add(notificationMessageDisplayedListener);
        }
    }

    @Override // com.salesforce.marketingcloud.notifications.NotificationManager
    public void setShouldShowNotificationListener(NotificationManager.ShouldShowNotificationListener shouldShowNotificationListener) {
        this.f5408k = shouldShowNotificationListener;
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public final void tearDown(boolean z) {
        if (z) {
            m3857a(this.f5404g);
        }
        Context context = this.f5404g;
        if (context != null) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this.f5409l);
        }
    }

    @Override // com.salesforce.marketingcloud.notifications.NotificationManager
    public final void unregisterNotificationMessageDisplayedListener(NotificationManager.NotificationMessageDisplayedListener notificationMessageDisplayedListener) {
        synchronized (this.f5406i) {
            this.f5406i.remove(notificationMessageDisplayedListener);
        }
    }

    /* JADX INFO: renamed from: a */
    public static C4273a m3855a(Context context, C4374j c4374j, NotificationCustomizationOptions notificationCustomizationOptions, InterfaceC4115j interfaceC4115j) {
        return new C4273a(context, c4374j, new C4274b(notificationCustomizationOptions.smallIconResId, notificationCustomizationOptions.launchIntentProvider, notificationCustomizationOptions.notificationBuilder, notificationCustomizationOptions.channelIdProvider), interfaceC4115j);
    }

    /* JADX INFO: renamed from: a */
    void m3859a(NotificationMessage notificationMessage) {
        synchronized (this.f5406i) {
            if (!this.f5406i.isEmpty()) {
                for (NotificationManager.NotificationMessageDisplayedListener notificationMessageDisplayedListener : this.f5406i) {
                    if (notificationMessageDisplayedListener != null) {
                        try {
                            notificationMessageDisplayedListener.onNotificationMessageDisplayed(notificationMessage);
                        } catch (Exception e) {
                            C4170g.m3207b(NotificationManager.f5388d, e, "%s threw an exception while processing notification message (%s)", notificationMessageDisplayedListener.getClass().getName(), notificationMessage.m3845id());
                        }
                    }
                }
            }
        }
        try {
            this.f5407j.mo2919b(notificationMessage);
        } catch (Exception e2) {
            C4170g.m3207b(NotificationManager.f5388d, e2, "Failed to log analytics for message displayed.", new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    void m3858a(Context context, NotificationMessage notificationMessage, PendingIntent pendingIntent, boolean z) {
        C4170g.m3202a(NotificationManager.f5388d, "Notification open Event Logged for id : (%s)", notificationMessage.m3845id());
        this.f5407j.mo2926a(notificationMessage);
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException e) {
                C4170g.m3207b(NotificationManager.f5388d, e, "Failed to send notification's open action PendingIntent.", new Object[0]);
            }
        }
        if (z) {
            NotificationManager.cancelNotificationMessage(context, notificationMessage);
        }
        if (Build.VERSION.SDK_INT <= 30) {
            context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(f5396p, notificationMessage);
        C4140c.m3035a(context, EnumC4138a.BEHAVIOR_SDK_NOTIFICATION_OPENED, bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00c1 A[Catch: all -> 0x00d7, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0008, B:7:0x0019, B:10:0x001e, B:12:0x0029, B:14:0x0034, B:17:0x0039, B:20:0x0041, B:23:0x0046, B:26:0x004b, B:31:0x006b, B:37:0x0084, B:39:0x009f, B:34:0x0072, B:40:0x00a3, B:42:0x00c1, B:43:0x00c6, B:29:0x0051), top: B:51:0x0001, inners: #0, #2 }] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void m3860a(com.salesforce.marketingcloud.notifications.NotificationMessage r9, com.salesforce.marketingcloud.notifications.C4273a.b r10) {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.notifications.C4273a.m3860a(com.salesforce.marketingcloud.notifications.NotificationMessage, com.salesforce.marketingcloud.notifications.a$b):void");
    }

    /* JADX INFO: renamed from: a */
    private void m3856a() {
        C4374j c4374j = this.f5405h;
        if (c4374j != null) {
            c4374j.mo4222f().edit().putBoolean(f5401u, this.f5410m).apply();
        }
    }
}
