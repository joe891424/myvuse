package p000a.p001a.p002a.p003a.p014b.p017d.p019b;

import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;

/* JADX INFO: renamed from: a.a.a.a.b.d.b.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0089e {

    /* JADX INFO: renamed from: w */
    public static C0089e f391w;

    /* JADX INFO: renamed from: a */
    public JSONObject f392a;

    /* JADX INFO: renamed from: b */
    public JSONObject f393b;

    /* JADX INFO: renamed from: c */
    public String f394c = "";

    /* JADX INFO: renamed from: d */
    public String f395d = "";

    /* JADX INFO: renamed from: e */
    public String f396e = "";

    /* JADX INFO: renamed from: f */
    public String f397f = "";

    /* JADX INFO: renamed from: g */
    public String f398g = "";

    /* JADX INFO: renamed from: h */
    public String f399h = "";

    /* JADX INFO: renamed from: i */
    public String f400i = "";

    /* JADX INFO: renamed from: j */
    public String f401j = "";

    /* JADX INFO: renamed from: k */
    public String f402k = "";

    /* JADX INFO: renamed from: l */
    public String f403l = "";

    /* JADX INFO: renamed from: m */
    public String f404m = "";

    /* JADX INFO: renamed from: n */
    public String f405n = "";

    /* JADX INFO: renamed from: o */
    public String f406o = "";

    /* JADX INFO: renamed from: p */
    public String f407p = "";

    /* JADX INFO: renamed from: q */
    public String f408q = "";

    /* JADX INFO: renamed from: r */
    public String f409r = "";

    /* JADX INFO: renamed from: s */
    public String f410s = "";

    /* JADX INFO: renamed from: t */
    public String f411t = "";

    /* JADX INFO: renamed from: u */
    public String f412u = "";

    /* JADX INFO: renamed from: v */
    public String f413v = "";

    /* JADX INFO: renamed from: a */
    public static synchronized C0089e m509a() {
        if (f391w == null) {
            f391w = new C0089e();
        }
        return f391w;
    }

    /* JADX INFO: renamed from: a */
    public void m510a(JSONObject jSONObject) {
        this.f393b = jSONObject;
        if (this.f392a == null || jSONObject == null) {
            return;
        }
        this.f394c = jSONObject.optString("name");
        this.f397f = this.f392a.optString("PCenterVendorListLifespan") + " : ";
        this.f399h = this.f392a.optString("PCenterVendorListDisclosure");
        this.f400i = this.f392a.optString("BConsentPurposesText");
        this.f401j = this.f392a.optString("BLegitimateInterestPurposesText");
        this.f404m = this.f392a.optString("BSpecialFeaturesText");
        this.f403l = this.f392a.optString("BSpecialPurposesText");
        this.f402k = this.f392a.optString("BFeaturesText");
        this.f395d = this.f393b.optString("policyUrl");
        this.f396e = this.f392a.optString("PCenterViewPrivacyPolicyText");
        this.f398g = new C0074f().m407a(this.f393b.optLong("cookieMaxAgeSeconds"), this.f392a);
        this.f405n = this.f392a.optString("PCenterVendorListNonCookieUsage");
        this.f406o = this.f393b.optString("deviceStorageDisclosureUrl");
        this.f407p = this.f392a.optString("PCenterVendorListStorageIdentifier") + " : ";
        this.f408q = this.f392a.optString("PCenterVendorListStorageType") + " : ";
        this.f409r = this.f392a.optString("PCenterVendorListLifespan") + " : ";
        this.f410s = this.f392a.optString("PCenterVendorListStorageDomain") + " : ";
        this.f411t = this.f392a.optString("PCenterVendorListStoragePurposes") + " : ";
        this.f412u = this.f392a.optString("PCVLSDomainsUsed");
        this.f413v = this.f392a.optString("PCVLSUse") + " : ";
    }
}
