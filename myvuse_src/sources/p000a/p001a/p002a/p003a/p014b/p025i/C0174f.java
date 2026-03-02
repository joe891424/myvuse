package p000a.p001a.p002a.p003a.p014b.p025i;

import android.content.Context;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p014b.p021e.C0104a0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0107c;
import p000a.p001a.p002a.p003a.p014b.p021e.C0114h;
import p000a.p001a.p002a.p003a.p014b.p021e.C0115i;
import p000a.p001a.p002a.p003a.p014b.p021e.C0127u;
import p000a.p001a.p002a.p003a.p014b.p021e.C0132z;

/* JADX INFO: renamed from: a.a.a.a.b.i.f */
/* JADX INFO: loaded from: classes.dex */
public class C0174f {

    /* JADX INFO: renamed from: a */
    public JSONObject f1527a;

    /* JADX INFO: renamed from: b */
    public C0132z f1528b;

    /* JADX INFO: renamed from: c */
    public C0127u f1529c;

    /* JADX INFO: renamed from: d */
    public C0106b0 f1530d;

    /* JADX INFO: renamed from: e */
    public C0106b0 f1531e;

    /* JADX INFO: renamed from: f */
    public C0104a0 f1532f;

    /* JADX INFO: renamed from: g */
    public C0107c f1533g;

    /* JADX INFO: renamed from: h */
    public String f1534h;

    /* JADX INFO: renamed from: i */
    public String f1535i;

    /* JADX INFO: renamed from: j */
    public String f1536j;

    /* JADX INFO: renamed from: k */
    public String f1537k;

    /* JADX INFO: renamed from: l */
    public String f1538l;

    /* JADX INFO: renamed from: m */
    public String f1539m;

    /* JADX INFO: renamed from: n */
    public String f1540n;

    /* JADX INFO: renamed from: o */
    public String f1541o;

    /* JADX INFO: renamed from: p */
    public String f1542p;

    /* JADX INFO: renamed from: q */
    public Context f1543q;

    /* JADX INFO: renamed from: r */
    public String f1544r = "";

    /* JADX INFO: renamed from: a */
    public static String m994a(String str, String str2, JSONObject jSONObject) {
        return (C0048h.m305b(str2) || str2 == null) ? !C0048h.m305b(str) ? jSONObject.optString(str) : "" : str2;
    }

    /* JADX INFO: renamed from: a */
    public C0107c m998a(C0107c c0107c, String str) {
        C0107c c0107c2 = new C0107c();
        C0115i c0115i = c0107c.f728a;
        c0107c2.f728a = c0115i;
        c0107c2.f734g = m994a(str, c0107c.mo376a(), this.f1527a);
        if (!C0048h.m305b(c0115i.f751b)) {
            c0107c2.f728a.f751b = c0115i.f751b;
        }
        c0107c2.f730c = m995a(this.f1527a, c0107c.mo378b(), "PcButtonTextColor");
        c0107c2.f729b = m995a(this.f1527a, c0107c.f729b, "PcButtonColor");
        if (!C0048h.m305b(c0107c.f731d)) {
            c0107c2.f731d = c0107c.f731d;
        }
        if (!C0048h.m305b(c0107c.f733f)) {
            c0107c2.f733f = c0107c.f733f;
        }
        if (!C0048h.m305b(c0107c.f732e)) {
            c0107c2.f732e = c0107c.f732e;
        }
        return c0107c2;
    }

    /* JADX INFO: renamed from: a */
    public C0104a0 m996a(C0104a0 c0104a0, String str) {
        C0104a0 c0104a02 = new C0104a0();
        if (!C0048h.m305b(c0104a0.f713b)) {
            c0104a02.f713b = c0104a0.f713b;
        }
        if (!C0048h.m305b(c0104a0.f720i)) {
            c0104a02.f720i = c0104a0.f720i;
        }
        if (!C0048h.m305b(c0104a0.f714c)) {
            c0104a02.f714c = c0104a0.f714c;
        }
        if (!C0048h.m305b(c0104a0.f715d)) {
            c0104a02.f715d = c0104a0.f715d;
        }
        if (!C0048h.m305b(c0104a0.f717f)) {
            c0104a02.f717f = c0104a0.f717f;
        }
        c0104a02.f718g = C0048h.m305b(c0104a0.f718g) ? "0" : c0104a0.f718g;
        if (!C0048h.m305b(c0104a0.f716e)) {
            str = c0104a0.f716e;
        }
        if (!C0048h.m305b(str)) {
            c0104a02.f716e = str;
        }
        c0104a02.f712a = C0048h.m305b(c0104a0.f712a) ? "#2D6B6767" : c0104a0.f712a;
        c0104a02.f719h = C0048h.m305b(c0104a0.f719h) ? "20" : c0104a0.f719h;
        return c0104a02;
    }

    /* JADX INFO: renamed from: a */
    public static String m995a(JSONObject jSONObject, String str, String str2) {
        if (!C0048h.m305b(str) && str != null) {
            return str;
        }
        try {
            return jSONObject.getString(str2);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "VLDataConfig", "error while applying header text color" + e.getMessage());
            return "";
        }
    }

    /* JADX INFO: renamed from: a */
    public C0106b0 m997a(JSONObject jSONObject, C0106b0 c0106b0, String str, boolean z) {
        C0106b0 c0106b02 = new C0106b0();
        C0115i c0115i = c0106b0.f722a;
        c0106b02.f722a = c0115i;
        c0106b02.f724c = m995a(jSONObject, c0106b0.f724c, "PcTextColor");
        if (!C0048h.m305b(c0115i.f751b)) {
            c0106b02.f722a.f751b = c0115i.f751b;
        }
        if (!C0048h.m305b(c0106b0.f723b)) {
            c0106b02.f723b = c0106b0.f723b;
        }
        if (!z) {
            c0106b02.f726e = m994a(str, c0106b0.f726e, jSONObject);
        }
        return c0106b02;
    }

    /* JADX INFO: renamed from: a */
    public final void m999a() {
        C0114h c0114h = this.f1528b.f916t;
        if (this.f1527a.has("PCenterVendorListFilterAria")) {
            c0114h.f747a = this.f1527a.optString("PCenterVendorListFilterAria");
        }
        if (this.f1527a.has("PCVendorListFilterUnselectedAriaLabel")) {
            c0114h.f749c = this.f1527a.optString("PCVendorListFilterUnselectedAriaLabel");
        }
        if (this.f1527a.has("PCVendorListFilterSelectedAriaLabel")) {
            c0114h.f748b = this.f1527a.optString("PCVendorListFilterSelectedAriaLabel");
        }
        if (this.f1527a.has("PCenterVendorListSearch")) {
            this.f1528b.f910n.f720i = this.f1527a.optString("PCenterVendorListSearch");
        }
    }
}
