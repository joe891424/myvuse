package com.salesforce.marketingcloud.alarms;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.salesforce.marketingcloud.AbstractC4169f;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.MCReceiver;
import com.salesforce.marketingcloud.alarms.AbstractC4092a;
import com.salesforce.marketingcloud.behaviors.C4140c;
import com.salesforce.marketingcloud.behaviors.EnumC4138a;
import com.salesforce.marketingcloud.behaviors.InterfaceC4139b;
import com.salesforce.marketingcloud.storage.C4374j;
import com.salesforce.marketingcloud.util.C4391j;
import com.salesforce.marketingcloud.util.C4393l;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.b */
/* JADX INFO: loaded from: classes6.dex */
public class C4093b extends AbstractC4169f implements InterfaceC4139b {

    /* JADX INFO: renamed from: j */
    public static final String f4339j = "com.salesforce.marketingcloud.ACTION_ALARM_WAKE_EVENT";

    /* JADX INFO: renamed from: k */
    public static final String f4340k = "com.salesforce.marketingcloud.WAKE_FOR_ALARM";

    /* JADX INFO: renamed from: l */
    static final String f4341l = "pending_alarms";

    /* JADX INFO: renamed from: m */
    static final String f4342m = C4170g.m3197a("AlarmScheduler");

    /* JADX INFO: renamed from: n */
    private static final long f4343n = 0;

    /* JADX INFO: renamed from: d */
    private final Map<AbstractC4092a.a, b> f4344d = new HashMap();

    /* JADX INFO: renamed from: e */
    private final C4140c f4345e;

    /* JADX INFO: renamed from: f */
    BroadcastReceiver f4346f;

    /* JADX INFO: renamed from: g */
    private Context f4347g;

    /* JADX INFO: renamed from: h */
    private C4374j f4348h;

    /* JADX INFO: renamed from: i */
    private SharedPreferences f4349i;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.b$a */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f4350a;

        static {
            int[] iArr = new int[EnumC4138a.values().length];
            f4350a = iArr;
            try {
                iArr[EnumC4138a.BEHAVIOR_APP_PACKAGE_REPLACED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4350a[EnumC4138a.BEHAVIOR_DEVICE_BOOT_COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.b$b */
    public interface b {
        /* JADX INFO: renamed from: a */
        void mo2870a(AbstractC4092a.a aVar);
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.b$c */
    class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C4170g.m3213d(C4093b.f4342m, "Received null intent", new Object[0]);
                return;
            }
            String action = intent.getAction();
            if (action == null) {
                C4170g.m3213d(C4093b.f4342m, "Received null action", new Object[0]);
                return;
            }
            Bundle extras = intent.getExtras();
            if (extras == null) {
                C4170g.m3213d(C4093b.f4342m, "Intent had no extras", new Object[0]);
                return;
            }
            if (!action.equals(C4093b.f4339j)) {
                C4170g.m3202a(C4093b.f4342m, "Received unknown action: %s", action);
                return;
            }
            String string = extras.getString("com.salesforce.marketingcloud.WAKE_FOR_ALARM", null);
            if (string != null) {
                C4170g.m3213d(C4093b.f4342m, "ACTION_ALARM_WAKE_EVENT had extra: %s", string);
                try {
                    C4093b.this.m2860a(AbstractC4092a.a.valueOf(string));
                } catch (IllegalArgumentException unused) {
                    C4170g.m3216e(C4093b.f4342m, "Woke for an unknown alarm: %s", string);
                }
            }
        }
    }

    public C4093b(Context context, C4374j c4374j, C4140c c4140c) {
        this.f4347g = context;
        this.f4348h = c4374j;
        this.f4345e = (C4140c) C4391j.m4326a(c4140c, "BehaviorManager is null");
        this.f4349i = c4374j.mo4222f();
    }

    /* JADX INFO: renamed from: a */
    void m2860a(AbstractC4092a.a aVar) {
        m2862a(aVar);
        b bVar = this.f4344d.get(aVar);
        if (bVar != null) {
            bVar.mo2870a(aVar);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m2865b(AbstractC4092a.a... aVarArr) {
        for (AbstractC4092a.a aVar : aVarArr) {
            m2857a(aVar, false);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m2866c(AbstractC4092a.a... aVarArr) {
        for (AbstractC4092a.a aVar : aVarArr) {
            C4170g.m3202a(f4342m, "Resetting %s Alarm Interval.", aVar.name());
            this.f4349i.edit().putLong(aVar.mo2852b().m2845c(), 0L).apply();
        }
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public final String componentName() {
        return "AlarmScheduler";
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public final JSONObject componentState() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            for (AbstractC4092a.a aVar : AbstractC4092a.a.values()) {
                if (m2863a(aVar, jCurrentTimeMillis)) {
                    jSONObject2.put(aVar.name(), C4393l.m4336a(new Date(this.f4349i.getLong(aVar.mo2852b().m2843a(), 0L) + this.f4349i.getLong(aVar.mo2852b().m2845c(), 0L))));
                }
            }
            jSONObject.put(f4341l, jSONObject2);
        } catch (JSONException e) {
            C4170g.m3207b(f4342m, e, "Failed to generate Component State JSONObject.", new Object[0]);
        }
        return jSONObject;
    }

    /* JADX INFO: renamed from: d */
    public void m2868d(AbstractC4092a.a... aVarArr) {
        for (AbstractC4092a.a aVar : aVarArr) {
            m2866c(aVar);
            m2862a(aVar);
            try {
                ((AlarmManager) this.f4347g.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(m2854a(this.f4347g, aVar.name(), Integer.valueOf(aVar.mo2852b().m2844b())));
                C4170g.m3202a(f4342m, "Reset %s alarm.", aVar.name());
            } catch (Exception e) {
                C4170g.m3217e(f4342m, e, "Could not cancel %s alarm.", aVar.name());
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public void m2869e(AbstractC4092a.a... aVarArr) {
        synchronized (this.f4344d) {
            for (AbstractC4092a.a aVar : aVarArr) {
                this.f4344d.remove(aVar);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.behaviors.InterfaceC4139b
    public final void onBehavior(EnumC4138a enumC4138a, Bundle bundle) {
        int i = a.f4350a[enumC4138a.ordinal()];
        if (i == 1 || i == 2) {
            m2855a(bundle.getLong("timestamp"));
        }
    }

    @Override // com.salesforce.marketingcloud.AbstractC4169f, com.salesforce.marketingcloud.InterfaceC4146d
    public final void tearDown(boolean z) {
        if (z) {
            m2868d(AbstractC4092a.a.values());
        }
        Context context = this.f4347g;
        if (context != null) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this.f4346f);
        }
        this.f4345e.m3036a(this);
    }

    /* JADX INFO: renamed from: a */
    void m2862a(AbstractC4092a.a... aVarArr) {
        for (AbstractC4092a.a aVar : aVarArr) {
            C4170g.m3202a(f4342m, "Resetting %s Alarm Active Flag to FALSE", aVar.name());
            this.f4349i.edit().putLong(aVar.mo2852b().m2843a(), 0L).apply();
        }
    }

    /* JADX INFO: renamed from: b */
    final long m2864b(AbstractC4092a.a aVar) {
        long j = this.f4349i.getLong(aVar.mo2852b().m2845c(), 0L);
        long jM2846d = j == 0 ? aVar.mo2852b().m2846d() : (long) (j * aVar.mo2852b().m2847e());
        if (jM2846d <= aVar.mo2852b().m2848f()) {
            return jM2846d;
        }
        long jM2848f = aVar.mo2852b().m2848f();
        C4170g.m3202a(f4342m, "%s MAX INTERVAL exceeded. Setting interval to %s milliseconds.", aVar.name(), Long.valueOf(jM2848f));
        return jM2848f;
    }

    /* JADX INFO: renamed from: c */
    public boolean m2867c(AbstractC4092a.a aVar) {
        return aVar.mo2852b().m2849g() && m2857a(aVar, true);
    }

    /* JADX INFO: renamed from: a */
    private boolean m2857a(AbstractC4092a.a aVar, boolean z) {
        if (!aVar.m2851a(this.f4348h)) {
            C4170g.m3202a(f4342m, "shouldCreateAlarm() for %s Alarm was FALSE.  Aborting alarm creation.", aVar.name());
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jM2864b = m2864b(aVar);
        if (m2863a(aVar, jCurrentTimeMillis)) {
            if (z) {
                return false;
            }
            C4170g.m3202a(f4342m, "%s Send Pending ... will send at %s", aVar.name(), C4393l.m4336a(new Date(this.f4348h.mo4222f().getLong(aVar.mo2852b().m2843a(), 0L) + jM2864b)));
            return false;
        }
        C4170g.m3202a(f4342m, "No pending %s Alarm. Creating one ...", aVar.name());
        m2856a(aVar, jCurrentTimeMillis, jM2864b);
        m2858a(this.f4347g, aVar, z ? 1000L : jM2864b, jCurrentTimeMillis);
        return true;
    }

    /* JADX INFO: renamed from: a */
    private static PendingIntent m2854a(Context context, String str, Integer num) {
        return PendingIntent.getBroadcast(context, num.intValue(), MCReceiver.m2813a(context, str), C4393l.m4333a(134217728));
    }

    @Override // com.salesforce.marketingcloud.AbstractC4169f
    /* JADX INFO: renamed from: a */
    protected final void mo2859a(InitializationStatus.C4081a c4081a) {
        this.f4345e.m3037a(this, EnumSet.of(EnumC4138a.BEHAVIOR_DEVICE_BOOT_COMPLETE, EnumC4138a.BEHAVIOR_APP_PACKAGE_REPLACED));
        this.f4346f = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(f4339j);
        LocalBroadcastManager.getInstance(this.f4347g).registerReceiver(this.f4346f, intentFilter);
    }

    /* JADX INFO: renamed from: a */
    final boolean m2863a(AbstractC4092a.a aVar, long j) {
        return this.f4349i.getLong(aVar.mo2852b().m2843a(), 0L) > j - this.f4349i.getLong(aVar.mo2852b().m2845c(), 0L);
    }

    /* JADX INFO: renamed from: a */
    private void m2855a(long j) {
        for (AbstractC4092a.a aVar : AbstractC4092a.a.values()) {
            AbstractC4092a abstractC4092aMo2852b = aVar.mo2852b();
            long j2 = this.f4349i.getLong(abstractC4092aMo2852b.m2843a(), 0L);
            if (j2 > 0) {
                if (m2863a(aVar, j)) {
                    m2858a(this.f4347g, aVar, this.f4349i.getLong(abstractC4092aMo2852b.m2845c(), abstractC4092aMo2852b.m2846d()), j2);
                } else {
                    m2860a(aVar);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2861a(b bVar, AbstractC4092a.a... aVarArr) {
        synchronized (this.f4344d) {
            for (AbstractC4092a.a aVar : aVarArr) {
                this.f4344d.put(aVar, bVar);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2856a(AbstractC4092a.a aVar, long j, long j2) {
        C4170g.m3202a(f4342m, "Setting the %s Alarm Flag ...", aVar.name());
        this.f4349i.edit().putLong(aVar.mo2852b().m2843a(), j).putLong(aVar.mo2852b().m2845c(), j2).apply();
    }

    /* JADX INFO: renamed from: a */
    void m2858a(Context context, AbstractC4092a.a aVar, long j, long j2) {
        PendingIntent pendingIntentM2854a = m2854a(context, aVar.name(), Integer.valueOf(aVar.mo2852b().m2844b()));
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        long j3 = j2 + j;
        String strM4336a = C4393l.m4336a(new Date(j3));
        try {
            if (Build.VERSION.SDK_INT < 31 || alarmManager.canScheduleExactAlarms()) {
                alarmManager.setExact(0, j3, pendingIntentM2854a);
            } else {
                alarmManager.set(0, j3, pendingIntentM2854a);
            }
            C4170g.m3213d(f4342m, "%s Alarm scheduled to wake at %s.", aVar.name(), strM4336a);
        } catch (Exception e) {
            C4170g.m3217e(f4342m, e, "Failed to schedule alarm %s for %s", aVar.name(), strM4336a);
        }
    }
}
