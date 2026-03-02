package com.salesforce.marketingcloud;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.salesforce.marketingcloud.C4137b;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.alarms.AbstractC4092a;
import com.salesforce.marketingcloud.alarms.C4093b;
import com.salesforce.marketingcloud.analytics.InterfaceC4117l;
import com.salesforce.marketingcloud.behaviors.C4140c;
import com.salesforce.marketingcloud.behaviors.EnumC4138a;
import com.salesforce.marketingcloud.behaviors.InterfaceC4139b;
import com.salesforce.marketingcloud.config.C4143a;
import com.salesforce.marketingcloud.http.C4173b;
import com.salesforce.marketingcloud.http.C4174c;
import com.salesforce.marketingcloud.http.C4175d;
import com.salesforce.marketingcloud.http.EnumC4172a;
import com.salesforce.marketingcloud.internal.AbstractRunnableC4184g;
import com.salesforce.marketingcloud.internal.C4189l;
import com.salesforce.marketingcloud.storage.C4374j;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.k */
/* JADX INFO: loaded from: classes6.dex */
public class C4193k implements InterfaceC4147e, InterfaceC4139b, C4174c.c, C4093b.b {

    /* JADX INFO: renamed from: n */
    private static final String f4939n = C4170g.m3197a("SyncRouteComponent");

    /* JADX INFO: renamed from: o */
    private static final int f4940o = 202;

    /* JADX INFO: renamed from: d */
    protected final MarketingCloudConfig f4941d;

    /* JADX INFO: renamed from: e */
    protected final C4174c f4942e;

    /* JADX INFO: renamed from: f */
    protected final C4374j f4943f;

    /* JADX INFO: renamed from: g */
    protected final String f4944g;

    /* JADX INFO: renamed from: h */
    private final C4189l f4945h;

    /* JADX INFO: renamed from: i */
    private final C4140c f4946i;

    /* JADX INFO: renamed from: j */
    private final C4093b f4947j;

    /* JADX INFO: renamed from: k */
    private final InterfaceC4117l f4948k;

    /* JADX INFO: renamed from: l */
    protected Map<d, e> f4949l = new ArrayMap(d.values().length);

    /* JADX INFO: renamed from: m */
    private boolean f4950m;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.k$a */
    class a implements MarketingCloudSdk.WhenReadyListener {
        a() {
        }

        @Override // com.salesforce.marketingcloud.MarketingCloudSdk.WhenReadyListener
        public void ready(MarketingCloudSdk marketingCloudSdk) {
            C4193k c4193k = C4193k.this;
            c4193k.f4942e.m3298a(EnumC4172a.f4824p.m3253a(c4193k.f4941d, c4193k.f4943f.mo4220c(), EnumC4172a.m3248c(C4193k.this.f4941d.applicationId(), C4193k.this.f4944g), "{}"));
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.k$b */
    class b extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ d f4952b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ JSONObject f4953c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, d dVar, JSONObject jSONObject) {
            super(str, objArr);
            this.f4952b = dVar;
            this.f4953c = jSONObject;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            e eVar = C4193k.this.f4949l.get(this.f4952b);
            if (eVar != null) {
                eVar.onSyncReceived(this.f4952b, this.f4953c);
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.k$c */
    static /* synthetic */ class c {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f4955a;

        static {
            int[] iArr = new int[EnumC4138a.values().length];
            f4955a = iArr;
            try {
                iArr[EnumC4138a.BEHAVIOR_APP_FOREGROUNDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4955a[EnumC4138a.BEHAVIOR_SDK_PUSH_RECEIVED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.k$d */
    public enum d {
        blocked,
        inAppMessages,
        triggers,
        pushFeaturesInUse,
        appConfig
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.k$e */
    public interface e {
        void onSyncReceived(d dVar, JSONObject jSONObject);
    }

    C4193k(String str, MarketingCloudConfig marketingCloudConfig, C4374j c4374j, C4174c c4174c, C4140c c4140c, C4093b c4093b, C4189l c4189l, InterfaceC4117l interfaceC4117l) {
        this.f4944g = str;
        this.f4941d = marketingCloudConfig;
        this.f4943f = c4374j;
        this.f4946i = c4140c;
        this.f4942e = c4174c;
        this.f4947j = c4093b;
        this.f4945h = c4189l;
        this.f4948k = interfaceC4117l;
    }

    /* JADX INFO: renamed from: a */
    private void m3437a() {
        if (m3443c()) {
            MarketingCloudSdk.requestSdk(m3446b());
        }
    }

    /* JADX INFO: renamed from: c */
    private boolean m3443c() {
        return !this.f4950m;
    }

    /* JADX INFO: renamed from: b */
    MarketingCloudSdk.WhenReadyListener m3446b() {
        return new a();
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public String componentName() {
        return "SyncRoute";
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public JSONObject componentState() {
        return null;
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4147e
    public void controlChannelInit(int i) {
        if (C4137b.m3024a(i, C4137b.c.RTBF.f4571a)) {
            this.f4946i.m3036a(this);
            this.f4942e.m3296a(EnumC4172a.f4824p);
            C4093b c4093b = this.f4947j;
            AbstractC4092a.a aVar = AbstractC4092a.a.f4322g;
            c4093b.m2869e(aVar);
            this.f4947j.m2868d(aVar);
            this.f4950m = true;
        }
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4147e
    public void init(InitializationStatus.C4081a c4081a, int i) {
        if (C4137b.m3024a(i, C4137b.c.RTBF.f4571a)) {
            this.f4950m = true;
            return;
        }
        this.f4942e.m3297a(EnumC4172a.f4824p, this);
        this.f4946i.m3037a(this, EnumSet.of(EnumC4138a.BEHAVIOR_APP_FOREGROUNDED, EnumC4138a.BEHAVIOR_SDK_PUSH_RECEIVED));
        this.f4947j.m2861a(this, AbstractC4092a.a.f4322g);
    }

    @Override // com.salesforce.marketingcloud.behaviors.InterfaceC4139b
    public void onBehavior(EnumC4138a enumC4138a, Bundle bundle) {
        int i = c.f4955a[enumC4138a.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            if (!bundle.containsKey("_sync")) {
                if (bundle.containsKey("_nodes")) {
                    m3439a(bundle.getString("_nodes"));
                    return;
                }
                return;
            }
        }
        m3437a();
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public void tearDown(boolean z) {
        this.f4946i.m3036a(this);
        this.f4942e.m3296a(EnumC4172a.f4824p);
        C4093b c4093b = this.f4947j;
        AbstractC4092a.a aVar = AbstractC4092a.a.f4322g;
        c4093b.m2869e(aVar);
        if (z) {
            this.f4947j.m2868d(aVar);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3439a(String str) {
        if (str != null) {
            try {
                m3440a(new JSONArray(str));
            } catch (Exception e2) {
                C4170g.m3207b(f4939n, e2, "Failed to parse sync push message", new Object[0]);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3440a(JSONArray jSONArray) throws JSONException {
        m3441a(jSONArray, 202);
    }

    /* JADX INFO: renamed from: a */
    private void m3441a(JSONArray jSONArray, int i) throws JSONException {
        String strOptString;
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            try {
                strOptString = jSONObject.optString("name");
                try {
                    d dVarValueOf = d.valueOf(strOptString);
                    if (i != 202 || dVarValueOf == d.appConfig || dVarValueOf == d.blocked) {
                        this.f4945h.m3398a().execute(new b(strOptString + "-sync_node_process", new Object[0], dVarValueOf, jSONObject));
                    }
                } catch (Exception unused) {
                    C4170g.m3202a(f4939n, "Failed to process node %s sync route", strOptString);
                }
            } catch (Exception unused2) {
                strOptString = null;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m3442a(Map<String, String> map) {
        return map.containsKey("_sync") || map.containsKey("_nodes");
    }

    @Override // com.salesforce.marketingcloud.alarms.C4093b.b
    /* JADX INFO: renamed from: a */
    public void mo2870a(AbstractC4092a.a aVar) {
        if (aVar == AbstractC4092a.a.f4322g) {
            m3437a();
        }
    }

    @Override // com.salesforce.marketingcloud.http.C4174c.c
    /* JADX INFO: renamed from: a */
    public void mo2932a(C4173b c4173b, C4175d c4175d) {
        if (!c4175d.m3307g()) {
            this.f4947j.m2865b(AbstractC4092a.a.f4322g);
            C4170g.m3206b(f4939n, "Sync route request failed with message: %s", c4175d.m3305e());
            return;
        }
        this.f4947j.m2868d(AbstractC4092a.a.f4322g);
        EnumC4172a.m3241a(c4175d.m3304d(), this.f4943f.mo4220c());
        m3438a(c4175d.m3308h());
        try {
            JSONArray jSONArray = new JSONObject(c4175d.m3301a()).getJSONArray("nodes");
            if (jSONArray != null) {
                m3441a(jSONArray, c4175d.m3302b());
            }
        } catch (Exception e2) {
            C4170g.m3207b(f4939n, e2, "Failed to parse /sync route response", new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3444a(d dVar, e eVar) {
        e eVar2 = this.f4949l.get(dVar);
        if (eVar2 == null || eVar == null || eVar2 == eVar) {
            this.f4949l.put(dVar, eVar);
        } else {
            C4170g.m3216e(f4939n, "Node %s already assigned to listener %s.  %s was not added for the Node.", dVar, eVar2, eVar);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3445a(EnumSet<d> enumSet, e eVar) {
        Iterator<d> it2 = enumSet.iterator();
        while (it2.hasNext()) {
            m3444a(it2.next(), eVar);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3438a(long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            InterfaceC4117l.a aVar = InterfaceC4117l.a.SYNC_API;
            jSONObject.put(aVar.m2951b(), j);
            if (C4143a.m3067e() == null || !C4143a.m3067e().m3079l()) {
                return;
            }
            this.f4948k.mo2945a(aVar, jSONObject);
        } catch (JSONException e2) {
            C4170g.m3207b(f4939n, e2, "Failed to log TelemetryEvent for Sync Route", new Object[0]);
        }
    }
}
