package com.salesforce.marketingcloud;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.salesforce.marketingcloud.alarms.C4093b;
import com.salesforce.marketingcloud.behaviors.C4140c;
import com.salesforce.marketingcloud.behaviors.EnumC4138a;
import com.salesforce.marketingcloud.http.C4173b;
import com.salesforce.marketingcloud.http.C4174c;
import com.salesforce.marketingcloud.http.C4175d;
import com.salesforce.marketingcloud.messages.push.C4268a;
import com.salesforce.marketingcloud.util.C4393l;

/* JADX INFO: loaded from: classes6.dex */
public class MCService extends AbstractServiceC4142c {

    /* JADX INFO: renamed from: k */
    static final String f4230k = "com.salesforce.marketingcloud.HTTP_REQUEST";

    /* JADX INFO: renamed from: l */
    static final String f4231l = "com.salesforce.marketingcloud.ALARM_WAKE";

    /* JADX INFO: renamed from: m */
    static final String f4232m = "com.salesforce.marketingcloud.SYSTEM_BEHAVIOR";

    /* JADX INFO: renamed from: n */
    static final String f4233n = "com.salesforce.marketingcloud.TOKEN_REQUEST";

    /* JADX INFO: renamed from: o */
    private static final String f4234o = "behavior";

    /* JADX INFO: renamed from: p */
    private static final String f4235p = "data";

    /* JADX INFO: renamed from: q */
    private static final String f4236q = "alarmName";

    /* JADX INFO: renamed from: r */
    private static final String f4237r = "senderId";

    /* JADX INFO: renamed from: s */
    private static final int f4238s = 3000;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.MCService$a */
    class C4083a implements OnCompleteListener<String> {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ String[] f4239a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Context f4240b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ String f4241c;

        C4083a(String[] strArr, Context context, String str) {
            this.f4239a = strArr;
            this.f4240b = context;
            this.f4241c = str;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(Task<String> task) {
            if (task.isSuccessful()) {
                this.f4239a[0] = task.getResult();
            }
            C4268a.m3828a(this.f4240b, !TextUtils.isEmpty(this.f4239a[0]), this.f4241c, this.f4239a[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2816a(Context context, String str) {
        C4170g.m3213d(AbstractServiceC4142c.f4605h, "enqueueAlarmWake - %s", str);
        Bundle bundle = new Bundle();
        bundle.putString(f4236q, str);
        m2817a(context, f4231l, bundle);
    }

    /* JADX INFO: renamed from: b */
    public static void m2821b(Context context, String str) {
        C4170g.m3213d(AbstractServiceC4142c.f4605h, "enqueueTokenRequest", new Object[0]);
        Bundle bundle = new Bundle();
        bundle.putString(f4237r, str);
        m2817a(context, f4233n, bundle);
    }

    /* JADX INFO: renamed from: c */
    private static void m2822c(Context context, String str) {
        if (str == null) {
            C4170g.m3213d(AbstractServiceC4142c.f4605h, "alarm name not provided", new Object[0]);
            return;
        }
        C4170g.m3213d(AbstractServiceC4142c.f4605h, "handleAlarmWakeup - %s", str);
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(C4093b.f4339j).putExtra("com.salesforce.marketingcloud.WAKE_FOR_ALARM", str));
    }

    /* JADX INFO: renamed from: d */
    static void m2823d(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            C4170g.m3202a(AbstractServiceC4142c.f4605h, "Unable to refresh system token.  SenderId was invalid", new Object[0]);
            return;
        }
        C4170g.m3213d(AbstractServiceC4142c.f4605h, "handleTokenRequest", new Object[0]);
        try {
            FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new C4083a(new String[]{null}, context, str));
        } catch (Exception e) {
            C4170g.m3207b(AbstractServiceC4142c.f4605h, e, "Failed to retrieve InstanceId from Firebase.", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.AbstractServiceC4142c, android.app.Service
    public /* bridge */ /* synthetic */ IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override // com.salesforce.marketingcloud.AbstractServiceC4142c, android.app.Service
    public /* bridge */ /* synthetic */ void onCreate() {
        super.onCreate();
    }

    @Override // com.salesforce.marketingcloud.AbstractServiceC4142c, android.app.Service
    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    @Override // com.salesforce.marketingcloud.AbstractServiceC4142c, android.app.Service
    public /* bridge */ /* synthetic */ int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    /* JADX INFO: renamed from: a */
    public static void m2815a(Context context, C4173b c4173b) {
        C4170g.m3213d(AbstractServiceC4142c.f4605h, "handleHttpRequest - %s", c4173b.m3280r());
        m2817a(context, f4230k, c4173b.m3281s());
    }

    /* JADX INFO: renamed from: b */
    static void m2820b(Context context, C4173b c4173b) {
        if (c4173b == null) {
            C4170g.m3213d(AbstractServiceC4142c.f4605h, "request was null", new Object[0]);
        } else {
            C4170g.m3213d(AbstractServiceC4142c.f4605h, "handleHttpRequest - %s", c4173b.m3280r());
            LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(C4174c.f4865j).putExtra(C4174c.f4867l, c4173b.m3281s()).putExtra(C4174c.f4866k, m2818a(context) ? c4173b.m3272j() : C4175d.m3300a("No connectivity", -1)));
        }
    }

    @Override // com.salesforce.marketingcloud.AbstractServiceC4142c
    /* JADX INFO: renamed from: c */
    public /* bridge */ /* synthetic */ boolean mo2826c() {
        return super.mo2826c();
    }

    @Override // com.salesforce.marketingcloud.AbstractServiceC4142c
    /* JADX INFO: renamed from: d */
    public /* bridge */ /* synthetic */ boolean mo2827d() {
        return super.mo2827d();
    }

    /* JADX INFO: renamed from: a */
    static void m2814a(Context context, EnumC4138a enumC4138a, Bundle bundle) {
        C4170g.m3213d(AbstractServiceC4142c.f4605h, "enqueueSystemBehavior - %s", enumC4138a);
        Bundle bundle2 = new Bundle();
        bundle2.putString(f4234o, enumC4138a.f4590a);
        bundle2.putBundle("data", bundle);
        m2817a(context, f4232m, bundle2);
    }

    /* JADX INFO: renamed from: b */
    private static void m2819b(Context context, EnumC4138a enumC4138a, Bundle bundle) {
        if (enumC4138a == null) {
            C4170g.m3213d(AbstractServiceC4142c.f4605h, "Behavior was null", new Object[0]);
        } else {
            C4170g.m3213d(AbstractServiceC4142c.f4605h, "handleSystemBehavior - %s", enumC4138a);
            C4140c.m3035a(context, enumC4138a, bundle);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2817a(Context context, String str, Bundle bundle) {
        AbstractServiceC4142c.m3040a(context, MCService.class, 3000, new Intent(str).putExtras(bundle));
    }

    @Override // com.salesforce.marketingcloud.AbstractServiceC4142c
    /* JADX INFO: renamed from: b */
    public /* bridge */ /* synthetic */ void mo2825b(boolean z) {
        super.mo2825b(z);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m2818a(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnectedOrConnecting()) ? false : true;
    }

    @Override // com.salesforce.marketingcloud.AbstractServiceC4142c
    /* JADX INFO: renamed from: a */
    protected void mo2824a(Intent intent) {
        String action = intent.getAction();
        if (action == null) {
        }
        Context applicationContext = getApplicationContext();
        if (!C4393l.m4342a(500L, 50L) || MarketingCloudSdk.getInstance() == null) {
            C4170g.m3216e(AbstractServiceC4142c.f4605h, "MarketingCloudSdk#init must be called in your application's onCreate", new Object[0]);
            return;
        }
        action.hashCode();
        switch (action) {
            case "com.salesforce.marketingcloud.ALARM_WAKE":
                m2822c(applicationContext, intent.getStringExtra(f4236q));
                break;
            case "com.salesforce.marketingcloud.TOKEN_REQUEST":
                m2823d(applicationContext, intent.getStringExtra(f4237r));
                break;
            case "com.salesforce.marketingcloud.HTTP_REQUEST":
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    m2820b(applicationContext, C4173b.m3258a(extras));
                    break;
                }
                break;
            case "com.salesforce.marketingcloud.SYSTEM_BEHAVIOR":
                m2819b(applicationContext, EnumC4138a.m3033a(intent.getStringExtra(f4234o)), intent.getBundleExtra("data"));
                break;
        }
    }
}
