package com.salesforce.marketingcloud;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.salesforce.marketingcloud.C4193k;
import com.salesforce.marketingcloud.storage.C4370f;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.b */
/* JADX INFO: loaded from: classes6.dex */
public class C4137b implements InterfaceC4146d, C4193k.e {

    /* JADX INFO: renamed from: i */
    public static final int f4543i = 0;

    /* JADX INFO: renamed from: j */
    public static final int f4544j = 1;

    /* JADX INFO: renamed from: k */
    public static final int f4545k = 2;

    /* JADX INFO: renamed from: l */
    public static final int f4546l = 4;

    /* JADX INFO: renamed from: m */
    public static final int f4547m = 8;

    /* JADX INFO: renamed from: n */
    public static final int f4548n = 16;

    /* JADX INFO: renamed from: o */
    public static final int f4549o = 32;

    /* JADX INFO: renamed from: p */
    public static final int f4550p = 64;

    /* JADX INFO: renamed from: q */
    public static final int f4551q = 128;

    /* JADX INFO: renamed from: r */
    public static final int f4552r = 256;

    /* JADX INFO: renamed from: s */
    public static final int f4553s = 512;

    /* JADX INFO: renamed from: t */
    public static final int f4554t = 1024;

    /* JADX INFO: renamed from: u */
    public static final int f4555u = 2048;

    /* JADX INFO: renamed from: v */
    public static final int f4556v = 4096;

    /* JADX INFO: renamed from: w */
    private static final int f4557w = 1;

    /* JADX INFO: renamed from: d */
    private final C4370f f4558d;

    /* JADX INFO: renamed from: e */
    private final C4193k f4559e;

    /* JADX INFO: renamed from: f */
    private b f4560f;

    /* JADX INFO: renamed from: g */
    private c f4561g;

    /* JADX INFO: renamed from: h */
    private c f4562h;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.b$a */
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.b$b */
    interface b {
        /* JADX INFO: renamed from: a */
        void mo2837a(int i);
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.b$c */
    public enum c {
        RTBF(8191),
        ROP(8190),
        DNT(1888),
        NONE(0),
        NO_BEACON(64),
        NO_GEOFENCE(32),
        NO_LOCATION(96);


        /* JADX INFO: renamed from: a */
        public final int f4571a;

        c(int i) {
            this.f4571a = i;
        }

        /* JADX INFO: renamed from: a */
        public static c m3030a(String str) {
            try {
                return valueOf(str);
            } catch (Exception unused) {
                return NONE;
            }
        }
    }

    C4137b(C4193k c4193k, C4370f c4370f) {
        this.f4559e = c4193k;
        this.f4558d = c4370f;
        c cVarM3025b = m3025b(c4370f);
        this.f4562h = cVarM3025b;
        if (cVarM3025b != c.RTBF) {
            c4193k.m3444a(C4193k.d.blocked, this);
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m3024a(int i, int i2) {
        return (i & i2) == i2;
    }

    /* JADX INFO: renamed from: b */
    private static c m3025b(C4370f c4370f) {
        String strM4226a = c4370f.m4226a((String) null);
        return strM4226a != null ? c.m3030a(strM4226a) : c.NONE;
    }

    /* JADX INFO: renamed from: c */
    public static boolean m3027c(int i, int i2) {
        if (m3026b(i, i2)) {
            return false;
        }
        switch (i2) {
            case 2:
            case 256:
            case 512:
            case 2048:
                if (c.ROP.f4571a == i) {
                    return false;
                }
                break;
            case 4:
            case 8:
            case 16:
            case 32:
            case 64:
            case 128:
            case 4096:
                break;
            default:
                return false;
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    int m3028a() {
        return this.f4562h.f4571a;
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public String componentName() {
        return "ControlChannel";
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public JSONObject componentState() {
        try {
            return new JSONObject().put("flag", this.f4562h.name());
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.salesforce.marketingcloud.C4193k.e
    public void onSyncReceived(C4193k.d dVar, JSONObject jSONObject) {
        if (dVar == C4193k.d.blocked && jSONObject.optInt("version", -1) == 1) {
            try {
                m3023a(jSONObject.getJSONObject(FirebaseAnalytics.Param.ITEMS).getInt("blocked"));
            } catch (JSONException e) {
                C4170g.m3207b(MarketingCloudSdk.f4247u, e, "Failed to parse [blocked] sync data.", new Object[0]);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public void tearDown(boolean z) {
        this.f4559e.m3444a(C4193k.d.blocked, (C4193k.e) null);
        this.f4560f = null;
    }

    /* JADX INFO: renamed from: a */
    public static int m3022a(C4370f c4370f) {
        return m3025b(c4370f).f4571a;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m3026b(int i, int i2) {
        return !m3024a(i, i2);
    }

    /* JADX INFO: renamed from: a */
    private synchronized void m3023a(int i) {
        c cVar = c.RTBF;
        if (!m3024a(i, cVar.f4571a)) {
            cVar = c.ROP;
            if (!m3024a(i, cVar.f4571a)) {
                cVar = c.DNT;
                if (!m3024a(i, cVar.f4571a)) {
                    cVar = c.NONE;
                }
            }
        }
        C4170g.m3213d(MarketingCloudSdk.f4247u, "Control Channel blocked value %d received", Integer.valueOf(i));
        this.f4558d.m4228b(cVar.name());
        if (cVar != this.f4562h) {
            b bVar = this.f4560f;
            if (bVar != null) {
                this.f4562h = cVar;
                bVar.mo2837a(cVar.f4571a);
            } else {
                this.f4561g = cVar;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    synchronized void m3029a(b bVar) {
        c cVar;
        this.f4560f = bVar;
        if (bVar != null && (cVar = this.f4561g) != null) {
            this.f4562h = cVar;
            this.f4561g = null;
            bVar.mo2837a(cVar.f4571a);
        }
    }
}
