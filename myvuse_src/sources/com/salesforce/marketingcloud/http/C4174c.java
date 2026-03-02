package com.salesforce.marketingcloud.http;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import androidx.collection.ArrayMap;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.security.ProviderInstaller;
import com.salesforce.marketingcloud.AbstractC4169f;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.MCService;
import com.salesforce.marketingcloud.internal.AbstractRunnableC4184g;
import com.salesforce.marketingcloud.internal.C4189l;
import com.salesforce.marketingcloud.util.C4391j;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.http.c */
/* JADX INFO: loaded from: classes6.dex */
public class C4174c extends AbstractC4169f {

    /* JADX INFO: renamed from: j */
    public static final String f4865j = "com.salesforce.marketingcloud.http.RESPONSE";

    /* JADX INFO: renamed from: k */
    public static final String f4866k = "http_response";

    /* JADX INFO: renamed from: l */
    public static final String f4867l = "http_request";

    /* JADX INFO: renamed from: m */
    private static final int f4868m = 10;

    /* JADX INFO: renamed from: n */
    static final String f4869n = C4170g.m3197a("RequestManager");

    /* JADX INFO: renamed from: f */
    private final Context f4872f;

    /* JADX INFO: renamed from: g */
    private final SharedPreferences f4873g;

    /* JADX INFO: renamed from: h */
    private C4189l f4874h;

    /* JADX INFO: renamed from: i */
    private BroadcastReceiver f4875i;

    /* JADX INFO: renamed from: e */
    private final Map<String, String> f4871e = new a();

    /* JADX INFO: renamed from: d */
    final Map<EnumC4172a, c> f4870d = new ArrayMap();

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.http.c$a */
    class a extends LinkedHashMap<String, String> {
        a() {
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, String> entry) {
            return size() > 10;
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.http.c$b */
    class b extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ c f4877b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ C4173b f4878c;

        /* JADX INFO: renamed from: d */
        final /* synthetic */ C4175d f4879d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, c cVar, C4173b c4173b, C4175d c4175d) {
            super(str, objArr);
            this.f4877b = cVar;
            this.f4878c = c4173b;
            this.f4879d = c4175d;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            this.f4877b.mo2932a(this.f4878c, this.f4879d);
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.http.c$c */
    public interface c {
        /* JADX INFO: renamed from: a */
        void mo2932a(C4173b c4173b, C4175d c4175d);
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.http.c$d */
    class d extends BroadcastReceiver {
        d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C4170g.m3213d(C4174c.f4869n, "Received null intent", new Object[0]);
                return;
            }
            String action = intent.getAction();
            if (action == null) {
                C4170g.m3213d(C4174c.f4869n, "Received null action", new Object[0]);
                return;
            }
            if (!action.equals(C4174c.f4865j)) {
                C4170g.m3202a(C4174c.f4869n, "Received unknown action: %s", action);
                return;
            }
            C4173b c4173bM3258a = C4173b.m3258a(intent.getBundleExtra(C4174c.f4867l));
            C4175d c4175d = (C4175d) intent.getParcelableExtra(C4174c.f4866k);
            if (c4173bM3258a == null || c4175d == null) {
                C4170g.m3213d(C4174c.f4869n, "Received null request/response", new Object[0]);
            } else {
                C4174c.this.m3299a(c4173bM3258a, c4175d);
            }
        }
    }

    public C4174c(Context context, SharedPreferences sharedPreferences, C4189l c4189l) {
        this.f4872f = (Context) C4391j.m4326a(context, "Context is null");
        this.f4873g = (SharedPreferences) C4391j.m4326a(sharedPreferences, "SharedPreferences is null");
        this.f4874h = c4189l;
    }

    /* JADX INFO: renamed from: a */
    public void m3296a(EnumC4172a enumC4172a) {
        synchronized (this.f4870d) {
            this.f4870d.remove(enumC4172a);
        }
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public final String componentName() {
        return "RequestManager";
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public final JSONObject componentState() {
        return new JSONObject(this.f4871e);
    }

    @Override // com.salesforce.marketingcloud.AbstractC4169f, com.salesforce.marketingcloud.InterfaceC4146d
    public final void tearDown(boolean z) {
        synchronized (this.f4870d) {
            this.f4870d.clear();
        }
        Context context = this.f4872f;
        if (context == null || this.f4875i == null) {
            return;
        }
        LocalBroadcastManager.getInstance(context).unregisterReceiver(this.f4875i);
    }

    @Override // com.salesforce.marketingcloud.AbstractC4169f
    /* JADX INFO: renamed from: a */
    protected final void mo2859a(InitializationStatus.C4081a c4081a) {
        try {
            m3295a();
        } catch (Exception e) {
            c4081a.m2809e(true);
            c4081a.m2802a("Failed to install providers: " + e.getMessage());
        }
        this.f4875i = new d();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(f4865j);
        LocalBroadcastManager.getInstance(this.f4872f).registerReceiver(this.f4875i, intentFilter);
    }

    /* JADX INFO: renamed from: a */
    private void m3295a() throws Exception {
        ProviderInstaller.installIfNeeded(this.f4872f);
    }

    /* JADX INFO: renamed from: a */
    void m3299a(C4173b c4173b, C4175d c4175d) {
        EnumC4172a enumC4172aM3278p = c4173b.m3278p();
        C4170g.m3213d(f4869n, "%s request took %dms with code: %d", enumC4172aM3278p.name(), Long.valueOf(c4175d.m3308h()), Integer.valueOf(c4175d.m3302b()));
        enumC4172aM3278p.m3255a(this.f4873g, c4175d);
        try {
            this.f4871e.put(c4173b.m3280r(), String.format(Locale.ENGLISH, "%s - %d", c4175d.m3305e(), Integer.valueOf(c4175d.m3302b())));
        } catch (Exception e) {
            C4170g.m3207b(f4869n, e, "Failed to record response.", new Object[0]);
        }
        synchronized (this.f4870d) {
            c cVar = this.f4870d.get(enumC4172aM3278p);
            if (cVar != null) {
                try {
                    this.f4874h.m3398a().execute(new b("onResponse", new Object[0], cVar, c4173b, c4175d));
                } catch (Exception e2) {
                    C4170g.m3207b(f4869n, e2, "Failed to deliver response.", new Object[0]);
                }
            } else {
                C4170g.m3216e(f4869n, "Request %s complete, but no listener was present to handle response %d.", c4173b.m3280r(), Integer.valueOf(c4175d.m3302b()));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3297a(EnumC4172a enumC4172a, c cVar) {
        synchronized (this.f4870d) {
            if (this.f4870d.put(enumC4172a, cVar) != null) {
                C4170g.m3202a(f4869n, "%s replaces previous listener for $s requests", cVar.getClass().getName(), enumC4172a.name());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m3298a(C4173b c4173b) {
        C4391j.m4326a(c4173b, "request is null");
        try {
            m3295a();
        } catch (Exception unused) {
            C4170g.m3216e(f4869n, "Failed to verify SSL providers via Google Play Services.", new Object[0]);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jM3257c = c4173b.m3278p().m3257c(this.f4873g);
        long jM3249a = c4173b.m3278p().m3249a(this.f4873g);
        if (jCurrentTimeMillis <= jM3257c || jCurrentTimeMillis <= jM3249a) {
            m3299a(c4173b, C4175d.m3300a("Too Many Requests", 429));
        } else {
            c4173b.m3278p().m3256b(this.f4873g);
            MCService.m2815a(this.f4872f, c4173b);
        }
    }
}
