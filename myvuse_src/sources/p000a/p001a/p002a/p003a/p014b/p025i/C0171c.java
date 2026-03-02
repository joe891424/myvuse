package p000a.p001a.p002a.p003a.p014b.p025i;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.TextView;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p014b.p016b.C0069a;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0107c;
import p000a.p001a.p002a.p003a.p014b.p021e.C0109d;
import p000a.p001a.p002a.p003a.p014b.p021e.C0115i;
import p000a.p001a.p002a.p003a.p014b.p021e.C0117k;
import p000a.p001a.p002a.p003a.p014b.p021e.C0118l;
import p000a.p001a.p002a.p003a.p014b.p021e.C0124r;
import p000a.p001a.p002a.p003a.p014b.p021e.C0126t;
import p000a.p001a.p002a.p003a.p014b.p021e.C0130x;

/* JADX INFO: renamed from: a.a.a.a.b.i.c */
/* JADX INFO: loaded from: classes.dex */
public class C0171c {

    /* JADX INFO: renamed from: A */
    public C0106b0 f1474A;

    /* JADX INFO: renamed from: B */
    public C0106b0 f1475B;

    /* JADX INFO: renamed from: C */
    public C0106b0 f1476C;

    /* JADX INFO: renamed from: D */
    public C0106b0 f1477D;

    /* JADX INFO: renamed from: E */
    public C0106b0 f1478E;

    /* JADX INFO: renamed from: F */
    public String f1479F;

    /* JADX INFO: renamed from: G */
    public String f1480G;

    /* JADX INFO: renamed from: I */
    public boolean f1482I;

    /* JADX INFO: renamed from: L */
    public String f1485L;

    /* JADX INFO: renamed from: a */
    public C0069a f1486a;

    /* JADX INFO: renamed from: b */
    public C0069a f1487b;

    /* JADX INFO: renamed from: c */
    public C0169a f1488c;

    /* JADX INFO: renamed from: d */
    public JSONObject f1489d;

    /* JADX INFO: renamed from: e */
    public C0069a f1490e;

    /* JADX INFO: renamed from: f */
    public C0069a f1491f;

    /* JADX INFO: renamed from: g */
    public C0069a f1492g;

    /* JADX INFO: renamed from: h */
    public C0069a f1493h;

    /* JADX INFO: renamed from: i */
    public C0069a f1494i;

    /* JADX INFO: renamed from: j */
    public C0069a f1495j;

    /* JADX INFO: renamed from: k */
    public C0069a f1496k;

    /* JADX INFO: renamed from: l */
    public C0069a f1497l;

    /* JADX INFO: renamed from: m */
    public C0069a f1498m;

    /* JADX INFO: renamed from: n */
    public C0069a f1499n;

    /* JADX INFO: renamed from: o */
    public boolean f1500o;

    /* JADX INFO: renamed from: q */
    public String f1502q;

    /* JADX INFO: renamed from: r */
    public String f1503r;

    /* JADX INFO: renamed from: s */
    public String f1504s;

    /* JADX INFO: renamed from: t */
    public String f1505t;

    /* JADX INFO: renamed from: u */
    public C0126t f1506u;

    /* JADX INFO: renamed from: v */
    public C0124r f1507v;

    /* JADX INFO: renamed from: w */
    public C0069a f1508w;

    /* JADX INFO: renamed from: x */
    public C0069a f1509x;

    /* JADX INFO: renamed from: y */
    public String f1510y;

    /* JADX INFO: renamed from: z */
    public String f1511z;

    /* JADX INFO: renamed from: p */
    public JSONArray f1501p = new JSONArray();

    /* JADX INFO: renamed from: H */
    public String f1481H = "";

    /* JADX INFO: renamed from: J */
    public boolean f1483J = true;

    /* JADX INFO: renamed from: K */
    public boolean f1484K = false;

    /* JADX INFO: renamed from: a */
    public C0126t m962a() {
        return this.f1506u;
    }

    /* JADX INFO: renamed from: a */
    public final void m968a(Context context) {
        if (!C0048h.m305b(this.f1506u.f826I) && "true".equals(this.f1506u.f826I)) {
            C0126t c0126t = this.f1506u;
            this.f1510y = c0126t.f826I;
            if (!C0048h.m305b(c0126t.f827J) && "true".equals(this.f1506u.f827J)) {
                C0126t c0126t2 = this.f1506u;
                this.f1511z = c0126t2.f827J;
                JSONObject jSONObject = this.f1489d;
                C0106b0 c0106b0 = c0126t2.f847r;
                C0106b0 c0106b02 = new C0106b0();
                C0115i c0115i = c0106b0.f722a;
                c0106b02.f722a = c0115i;
                c0106b02.f724c = C0174f.m995a(jSONObject, c0106b0.f724c, "PcTextColor");
                if (!C0048h.m305b(c0115i.f751b)) {
                    c0106b02.f722a.f751b = c0115i.f751b;
                }
                if (!C0048h.m305b(c0106b0.f723b)) {
                    c0106b02.f723b = c0106b0.f723b;
                }
                c0106b02.f726e = C0174f.m994a("", c0106b0.f726e, jSONObject);
                this.f1475B = c0106b02;
            }
            JSONObject jSONObject2 = this.f1489d;
            C0106b0 c0106b03 = this.f1506u.f843n;
            C0106b0 c0106b04 = new C0106b0();
            C0115i c0115i2 = c0106b03.f722a;
            c0106b04.f722a = c0115i2;
            c0106b04.f724c = C0174f.m995a(jSONObject2, c0106b03.f724c, "PcTextColor");
            if (!C0048h.m305b(c0115i2.f751b)) {
                c0106b04.f722a.f751b = c0115i2.f751b;
            }
            if (!C0048h.m305b(c0106b03.f723b)) {
                c0106b04.f723b = c0106b03.f723b;
            }
            c0106b04.f726e = C0174f.m994a("", c0106b03.f726e, jSONObject2);
            this.f1476C = c0106b04;
            JSONObject jSONObject3 = this.f1489d;
            C0106b0 c0106b05 = this.f1506u.f842m;
            C0106b0 c0106b06 = new C0106b0();
            C0115i c0115i3 = c0106b05.f722a;
            c0106b06.f722a = c0115i3;
            c0106b06.f724c = C0174f.m995a(jSONObject3, c0106b05.f724c, "PcTextColor");
            if (!C0048h.m305b(c0115i3.f751b)) {
                c0106b06.f722a.f751b = c0115i3.f751b;
            }
            if (!C0048h.m305b(c0106b05.f723b)) {
                c0106b06.f723b = c0106b05.f723b;
            }
            c0106b06.f726e = C0174f.m994a("", c0106b05.f726e, jSONObject3);
            this.f1474A = c0106b06;
            this.f1482I = this.f1506u.f829L;
        }
        if (C0048h.m305b(this.f1506u.f828K) || !"true".equals(this.f1506u.f828K)) {
            return;
        }
        this.f1479F = this.f1506u.f828K;
        String string = new C0045d(context, "OTT_DEFAULT_USER").m271a().getString("OTT_LAST_GIVEN_CONSENT", "0");
        m963a((C0048h.m305b(string) ? 0L : Long.parseLong(string)) != 0 ? this.f1506u.f845p : this.f1506u.f846q);
    }

    /* JADX INFO: renamed from: a */
    public void m971a(TextView textView, String str, String str2) {
        textView.setVisibility(("true".equals(str) || !C0048h.m305b(str2)) ? 0 : 8);
    }

    /* JADX INFO: renamed from: b */
    public JSONArray m974b() {
        return this.f1501p;
    }

    /* JADX INFO: renamed from: b */
    public final void m975b(C0106b0 c0106b0, C0069a c0069a, String str) {
        if (!c0106b0.m614a() || C0048h.m305b(c0106b0.f726e)) {
            c0069a.f229m = 8;
            return;
        }
        c0069a.f734g = c0106b0.f726e;
        c0069a.f229m = 0;
        String strM950a = this.f1488c.m950a(c0106b0.f724c, this.f1489d.optString(str), "#696969", "#FFFFFF");
        if (c0069a == this.f1490e) {
            strM950a = this.f1488c.m950a(c0106b0.f724c, this.f1489d.optString(str), "#3860BE", "#3860BE");
        }
        c0069a.f730c = strM950a;
        c0069a.f230n = this.f1488c.m949a(c0106b0.f723b);
        C0115i c0115i = c0106b0.f722a;
        if (!C0048h.m305b(c0115i.f751b)) {
            c0069a.f231o = c0115i.f751b;
        }
        c0069a.f728a = c0115i;
    }

    /* JADX INFO: renamed from: a */
    public static C0126t m961a(JSONObject jSONObject, C0126t c0126t) {
        C0106b0 c0106b0 = c0126t.f840k;
        if (C0048h.m305b(c0106b0.f726e) && !C0048h.m305b(jSONObject.optString("MainText"))) {
            c0106b0.f726e = jSONObject.optString("MainText");
            c0106b0.f725d = String.valueOf(true);
            c0126t.f840k = c0106b0;
        }
        C0106b0 c0106b02 = c0126t.f841l;
        if (C0048h.m305b(c0106b02.f726e) && !C0048h.m305b(jSONObject.optString("MainInfoText"))) {
            c0106b02.f726e = jSONObject.optString("MainInfoText");
            c0106b02.f725d = String.valueOf(true);
            c0126t.f841l = c0106b02;
        }
        C0118l c0118l = c0126t.f818A;
        if (C0048h.m305b(c0118l.m650a()) && !C0048h.m305b(jSONObject.optString("OptanonLogo"))) {
            c0118l.f761b = jSONObject.optString("OptanonLogo");
            c0126t.f818A = c0118l;
        }
        C0117k c0117k = c0126t.f821D;
        if (!C0048h.m305b(jSONObject.optString("AboutText")) && C0048h.m305b(c0117k.f755a.f726e)) {
            c0117k.f755a.f726e = jSONObject.optString("AboutText");
            c0117k.f755a.f725d = String.valueOf(true);
            if (C0048h.m305b(c0117k.f756b)) {
                c0117k.f756b = jSONObject.optString("AboutLink");
            }
            c0126t.f821D = c0117k;
        }
        c0126t.f851v.f725d = String.valueOf(true);
        C0117k c0117k2 = c0126t.f822E;
        if (!C0048h.m305b(jSONObject.optString("PCenterVendorsListText")) && C0048h.m305b(c0117k2.f755a.f726e)) {
            c0117k2.f755a.f726e = jSONObject.optString("PCenterVendorsListText");
            c0117k2.f755a.f725d = String.valueOf(true);
            c0126t.f822E = c0117k2;
        }
        C0106b0 c0106b03 = c0126t.f848s;
        if (C0048h.m305b(c0106b03.f726e) && !C0048h.m305b(jSONObject.optString("PreferenceCenterManagePreferencesText"))) {
            c0106b03.f726e = jSONObject.optString("PreferenceCenterManagePreferencesText");
        }
        c0106b03.f725d = String.valueOf(true);
        c0126t.f848s = c0106b03;
        C0107c c0107c = c0126t.f852w;
        if (C0048h.m305b(c0107c.mo376a())) {
            c0107c.f734g = jSONObject.optString("ConfirmText", "");
            c0107c.f735h = C0048h.m305b(jSONObject.optString("ConfirmText", "")) ? String.valueOf(false) : String.valueOf(true);
            c0126t.f852w = c0107c;
        }
        C0107c c0107c2 = c0126t.f853x;
        if (C0048h.m305b(c0107c2.mo376a())) {
            c0107c2.f734g = jSONObject.optString("PCenterRejectAllButtonText", "");
            c0107c2.f735h = (!jSONObject.optBoolean("PCenterShowRejectAllButton") || C0048h.m305b(jSONObject.optString("PCenterRejectAllButtonText", ""))) ? String.valueOf(false) : String.valueOf(true);
            c0126t.f853x = c0107c2;
        }
        C0107c c0107c3 = c0126t.f854y;
        if (C0048h.m305b(c0107c3.mo376a())) {
            c0107c3.f734g = jSONObject.optString("PreferenceCenterConfirmText", "");
        }
        c0107c3.f735h = String.valueOf(true);
        c0126t.f854y = c0107c3;
        return c0126t;
    }

    /* JADX INFO: renamed from: a */
    public boolean m973a(OTPublishersHeadlessSDK oTPublishersHeadlessSDK, Context context, int i) {
        try {
            JSONObject preferenceCenterData = oTPublishersHeadlessSDK.getPreferenceCenterData();
            this.f1489d = preferenceCenterData;
            int i2 = 0;
            if (preferenceCenterData == null) {
                return false;
            }
            this.f1488c = new C0169a(i);
            C0074f.m404b(preferenceCenterData, false);
            C0130x c0130x = new C0130x(context);
            C0126t c0126tM671a = c0130x.m671a(i);
            this.f1506u = c0126tM671a;
            this.f1506u = m961a(this.f1489d, c0126tM671a);
            this.f1507v = c0130x.f880a.m622b();
            this.f1486a = new C0069a();
            this.f1487b = new C0069a();
            this.f1490e = new C0069a();
            this.f1491f = new C0069a();
            this.f1492g = new C0069a();
            this.f1493h = new C0069a();
            this.f1494i = new C0069a();
            this.f1495j = new C0069a();
            this.f1496k = new C0069a();
            this.f1497l = new C0069a();
            this.f1498m = new C0069a();
            this.f1499n = new C0069a();
            this.f1508w = new C0069a();
            this.f1509x = new C0069a();
            this.f1481H = this.f1489d.optString("BConsentText");
            m975b(this.f1506u.f840k, this.f1486a, "PcTextColor");
            m975b(this.f1506u.f841l, this.f1487b, "PcTextColor");
            C0117k c0117k = this.f1506u.f821D;
            String string = this.f1489d.getString("PcLinksTextColor");
            C0069a c0069a = this.f1490e;
            C0106b0 c0106b0 = c0117k.f755a;
            m975b(c0106b0, c0069a, "PcLinksTextColor");
            if (!C0048h.m305b(c0106b0.f724c)) {
                string = c0106b0.f724c;
            }
            c0069a.f730c = string;
            c0069a.f229m = C0026u.m181a(c0117k.f758d, false) ? 0 : 8;
            m975b(this.f1506u.f851v, this.f1491f, "PcTextColor");
            C0126t c0126t = this.f1506u;
            m965a(c0126t.f822E.f755a, c0126t.f849t, this.f1492g, "PcTextColor");
            C0126t c0126t2 = this.f1506u;
            m965a(c0126t2.f823F.f755a, c0126t2.f849t, this.f1493h, "PcTextColor");
            C0118l c0118l = this.f1506u.f818A;
            C0069a c0069a2 = this.f1494i;
            c0069a2.f734g = (c0118l.m650a() == null || c0118l.m650a().equals("")) ? null : c0118l.m650a();
            if (!c0118l.m651b()) {
                i2 = 8;
            }
            c0069a2.f229m = i2;
            m975b(this.f1506u.f848s, this.f1495j, "PcTextColor");
            m966a(this.f1506u.f852w, this.f1496k);
            m966a(this.f1506u.f853x, this.f1497l);
            m966a(this.f1506u.f854y, this.f1498m);
            if (this.f1489d.has("LegIntSettings") && !this.f1489d.isNull("LegIntSettings")) {
                this.f1500o = this.f1489d.getJSONObject("LegIntSettings").getBoolean("PAllowLI");
            }
            this.f1501p = C0026u.m168a(this.f1489d);
            C0126t c0126t3 = this.f1506u;
            this.f1502q = c0126t3.f821D.f756b;
            this.f1503r = this.f1488c.m950a(c0126t3.f830a, this.f1489d.optString("PcBackgroundColor"), "#FFFFFF", "#2F2F2F");
            this.f1504s = this.f1488c.m951a(this.f1506u.f836g, "PcTextColor", this.f1489d);
            this.f1488c.m951a("", "PcTextColor", this.f1489d);
            this.f1505t = this.f1488c.m950a(this.f1506u.f831b, "", "#E8E8E8", "#555555");
            C0126t c0126t4 = this.f1506u;
            this.f1480G = c0126t4.f837h;
            m967a(c0126t4.f855z, this.f1499n, this.f1507v);
            m964a(this.f1506u.f850u, this.f1508w, "PcLinksTextColor");
            m964a(this.f1506u.f849t, this.f1509x, "PcTextColor");
            m968a(context);
            m972a(this.f1489d);
            this.f1483J = this.f1506u.f839j;
            this.f1484K = this.f1489d.optBoolean("IsIabEnabled");
            this.f1485L = this.f1489d.optString("IabType");
            return true;
        } catch (JSONException e) {
            OTLogger.m2743a(6, "PC Config", "Error in ui property object, error message = " + e.getMessage());
            return true;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m967a(C0109d c0109d, C0069a c0069a, C0124r c0124r) {
        String strOptString;
        if (!C0026u.m181a(c0109d.f743d, false)) {
            c0069a.f229m = 8;
            c0069a.f233q = 8;
            c0069a.f234r = 8;
            return;
        }
        if (C0026u.m181a(c0109d.f742c, false) && !C0048h.m305b(c0109d.f745f.mo376a())) {
            if (C0026u.m181a(c0109d.f745f.f735h, false)) {
                c0069a.f234r = 0;
                c0069a.f233q = 8;
                c0069a.f229m = 8;
                String str = c0109d.f740a;
                C0107c c0107c = c0109d.f745f;
                C0115i c0115i = c0107c.f728a;
                if (!C0048h.m305b(c0115i.f751b)) {
                    c0069a.f231o = c0115i.f751b;
                }
                c0069a.f728a = c0115i;
                String strMo378b = c0107c.mo378b();
                if (!C0048h.m305b(strMo378b)) {
                    str = strMo378b;
                }
                c0069a.f730c = this.f1488c.m950a(str, this.f1489d.optString("PcTextColor"), "#696969", "#FFFFFF");
                c0069a.f729b = c0107c.f729b;
                c0069a.f232p = c0107c;
                if (!C0048h.m305b(c0107c.f731d)) {
                    c0069a.f731d = c0107c.f731d;
                }
            } else {
                String strM951a = this.f1488c.m951a(c0109d.f740a, "PcTextColor", this.f1489d);
                if (c0124r != null && !C0048h.m305b(c0124r.f801b)) {
                    strM951a = c0124r.f801b;
                }
                if (!C0048h.m305b(strM951a)) {
                    c0069a.f730c = strM951a;
                }
                c0069a.f233q = 0;
                c0069a.f234r = 8;
                c0069a.f229m = 8;
            }
            strOptString = c0109d.f745f.mo376a();
        } else {
            String strM950a = this.f1488c.m950a(c0109d.f744e, this.f1489d.optString("PcTextColor"), "#FFFFFF", "#696969");
            c0069a.f229m = 0;
            c0069a.f233q = 8;
            c0069a.f234r = 8;
            c0069a.f730c = strM950a;
            strOptString = this.f1489d.optString("CloseText");
        }
        c0069a.f734g = strOptString;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0080  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m969a(android.widget.TextView r2, p000a.p001a.p002a.p003a.p014b.p021e.C0106b0 r3, p000a.p001a.p002a.p003a.p014b.p016b.C0069a r4, com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration r5) {
        /*
            r1 = this;
            java.lang.String r0 = r4.mo378b()
            boolean r0 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r0)
            if (r0 != 0) goto L16
            java.lang.String r0 = r4.mo378b()
            int r0 = android.graphics.Color.parseColor(r0)
            r2.setTextColor(r0)
            goto L27
        L16:
            java.lang.String r0 = r3.f724c
            boolean r0 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r0)
            if (r0 != 0) goto L27
            java.lang.String r0 = r3.f724c
            int r0 = android.graphics.Color.parseColor(r0)
            r2.setTextColor(r0)
        L27:
            int r0 = r4.f230n
            r2.setTextAlignment(r0)
            java.lang.String r0 = r4.f231o
            boolean r0 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r0)
            if (r0 != 0) goto L37
            java.lang.String r3 = r4.f231o
            goto L45
        L37:
            a.a.a.a.b.e.i r0 = r3.f722a
            java.lang.String r0 = r0.f751b
            boolean r0 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r0)
            if (r0 != 0) goto L4c
            a.a.a.a.b.e.i r3 = r3.f722a
            java.lang.String r3 = r3.f751b
        L45:
            float r3 = java.lang.Float.parseFloat(r3)
            r2.setTextSize(r3)
        L4c:
            a.a.a.a.b.e.i r3 = r4.f728a
            java.lang.String r4 = r3.f753d
            boolean r0 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r4)
            if (r0 != 0) goto L62
            if (r5 == 0) goto L62
            android.graphics.Typeface r4 = r5.getOtTypeFaceMap(r4)
            if (r4 == 0) goto L62
            r2.setTypeface(r4)
            goto L8b
        L62:
            int r4 = r3.f752c
            r5 = -1
            if (r4 != r5) goto L71
            android.graphics.Typeface r5 = r2.getTypeface()
            if (r5 == 0) goto L71
            int r4 = r5.getStyle()
        L71:
            java.lang.String r5 = r3.f750a
            boolean r5 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r5)
            if (r5 != 0) goto L80
            java.lang.String r3 = r3.f750a
            android.graphics.Typeface r3 = android.graphics.Typeface.create(r3, r4)
            goto L88
        L80:
            android.graphics.Typeface r3 = r2.getTypeface()
            android.graphics.Typeface r3 = android.graphics.Typeface.create(r3, r4)
        L88:
            r2.setTypeface(r3)
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.p025i.C0171c.m969a(android.widget.TextView, a.a.a.a.b.e.b0, a.a.a.a.b.b.a, com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration):void");
    }

    /* JADX INFO: renamed from: a */
    public void m970a(TextView textView, OTConfiguration oTConfiguration) {
        Typeface typeface;
        Typeface otTypeFaceMap;
        C0126t c0126t = this.f1506u;
        if (c0126t != null && c0126t.f838i) {
            textView.setVisibility(0);
            C0106b0 c0106b0 = this.f1506u.f841l;
            textView.setTextColor(Color.parseColor(c0106b0.f724c));
            String str = c0106b0.f722a.f751b;
            if (str != null) {
                textView.setTextSize(Float.parseFloat(str));
            }
            C0115i c0115i = c0106b0.f722a;
            String str2 = c0115i.f753d;
            if (!C0048h.m305b(str2) && oTConfiguration != null && (otTypeFaceMap = oTConfiguration.getOtTypeFaceMap(str2)) != null) {
                textView.setTypeface(otTypeFaceMap);
                return;
            }
            int style = c0115i.f752c;
            if (style == -1 && (typeface = textView.getTypeface()) != null) {
                style = typeface.getStyle();
            }
            textView.setTypeface(!C0048h.m305b(c0115i.f750a) ? Typeface.create(c0115i.f750a, style) : Typeface.create(textView.getTypeface(), style));
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: renamed from: a */
    public final void m964a(C0106b0 c0106b0, C0069a c0069a, String str) {
        if (c0069a == this.f1508w) {
            String strOptString = C0048h.m305b(c0106b0.f726e) ? this.f1489d.optString("AlwaysActiveText", "") : c0106b0.f726e;
            c0069a.f730c = this.f1488c.m950a(c0106b0.f724c, this.f1489d.optString(str), "#3860BE", "#3860BE");
            c0069a.f734g = strOptString;
        } else {
            c0069a.f730c = this.f1488c.m950a(c0106b0.f724c, this.f1489d.optString(str), "#696969", "#FFFFFF");
            c0069a.f229m = 0;
        }
        c0069a.f230n = (c0069a == this.f1508w && C0048h.m305b(c0106b0.f723b)) ? 6 : this.f1488c.m949a(c0106b0.f723b);
        C0115i c0115i = c0106b0.f722a;
        if (!C0048h.m305b(c0115i.f751b)) {
            c0069a.f231o = c0115i.f751b;
        }
        c0069a.f728a = c0115i;
    }

    /* JADX INFO: renamed from: a */
    public final void m972a(JSONObject jSONObject) {
        this.f1506u.f855z.f741b = jSONObject.optString("CloseText");
        this.f1506u.f818A.f762c = jSONObject.optString("PCLogoScreenReader");
        this.f1506u.f824G.f754a = jSONObject.optString("PCDSIDCopyAriaLabel");
        this.f1506u.f821D.f759e = jSONObject.optString("PCPrivacyLinkActionAriaLabel");
    }

    /* JADX INFO: renamed from: a */
    public final void m966a(C0107c c0107c, C0069a c0069a) {
        C0115i c0115i = c0107c.f728a;
        if (!C0048h.m305b(c0115i.f751b)) {
            c0069a.f231o = c0115i.f751b;
        }
        c0069a.f728a = c0115i;
        String strM950a = this.f1488c.m950a(c0107c.mo378b(), this.f1489d.optString("PcButtonTextColor"), "#FFFFFF", "#FFFFFF");
        String strM950a2 = this.f1488c.m950a(c0107c.f729b, this.f1489d.optString("PcButtonColor"), "#6CC04A", "#80BE5A");
        if (c0069a == this.f1498m) {
            strM950a = this.f1488c.m950a(c0107c.mo378b(), this.f1489d.optString("PcButtonTextColor"), "#FFFFFF", "#80BE5A");
            strM950a2 = this.f1488c.m950a(c0107c.f729b, this.f1489d.optString("PcButtonColor"), "#6CC04A", "#FFFFFF");
        }
        c0069a.f730c = strM950a;
        c0069a.f729b = strM950a2;
        c0069a.f232p = c0107c;
        if (!C0048h.m305b(c0107c.f731d)) {
            c0069a.f731d = c0107c.f731d;
        }
        c0069a.f734g = c0107c.mo376a();
        if (c0069a == this.f1498m) {
            c0069a.f229m = 0;
        } else {
            c0069a.f229m = c0107c.f735h.equals(String.valueOf(true)) ? 0 : 8;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m965a(C0106b0 c0106b0, C0106b0 c0106b02, C0069a c0069a, String str) {
        if (c0069a == this.f1492g && !this.f1489d.optBoolean("IsIabEnabled") && "".equals(this.f1489d.optString("IabType"))) {
            c0069a.f229m = 8;
        }
        if (c0069a == this.f1493h) {
            c0069a.f229m = c0106b0.f727f;
        }
        c0069a.f734g = c0106b0.f726e;
        c0069a.f730c = this.f1488c.m950a(c0106b02.f724c, this.f1489d.optString(str), "#696969", "#FFFFFF");
        c0069a.f230n = this.f1488c.m949a(c0106b02.f723b);
        C0115i c0115i = c0106b02.f722a;
        if (!C0048h.m305b(c0115i.f751b)) {
            c0069a.f231o = c0115i.f751b;
        }
        c0069a.f728a = c0115i;
    }

    /* JADX INFO: renamed from: a */
    public final void m963a(C0106b0 c0106b0) {
        JSONObject jSONObject = this.f1489d;
        C0106b0 c0106b02 = new C0106b0();
        C0115i c0115i = c0106b0.f722a;
        c0106b02.f722a = c0115i;
        c0106b02.f724c = C0174f.m995a(jSONObject, c0106b0.f724c, "PcTextColor");
        if (!C0048h.m305b(c0115i.f751b)) {
            c0106b02.f722a.f751b = c0115i.f751b;
        }
        if (!C0048h.m305b(c0106b0.f723b)) {
            c0106b02.f723b = c0106b0.f723b;
        }
        c0106b02.f726e = C0174f.m994a("", c0106b0.f726e, jSONObject);
        this.f1477D = c0106b02;
        JSONObject jSONObject2 = this.f1489d;
        C0106b0 c0106b03 = this.f1506u.f844o;
        C0106b0 c0106b04 = new C0106b0();
        C0115i c0115i2 = c0106b03.f722a;
        c0106b04.f722a = c0115i2;
        c0106b04.f724c = C0174f.m995a(jSONObject2, c0106b03.f724c, "PcTextColor");
        if (!C0048h.m305b(c0115i2.f751b)) {
            c0106b04.f722a.f751b = c0115i2.f751b;
        }
        if (!C0048h.m305b(c0106b03.f723b)) {
            c0106b04.f723b = c0106b03.f723b;
        }
        c0106b04.f726e = C0174f.m994a("", c0106b03.f726e, jSONObject2);
        this.f1478E = c0106b04;
    }
}
