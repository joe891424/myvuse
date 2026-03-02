package p000a.p001a.p002a.p003a.p014b.p017d.p019b;

import android.content.Context;
import android.text.Html;
import android.text.SpannableStringBuilder;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0032d;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p007c.C0021p;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0107c;
import p000a.p001a.p002a.p003a.p014b.p021e.C0119m;
import p000a.p001a.p002a.p003a.p014b.p021e.C0120n;
import p000a.p001a.p002a.p003a.p014b.p021e.C0126t;

/* JADX INFO: renamed from: a.a.a.a.b.d.b.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0087c {

    /* JADX INFO: renamed from: o */
    public static C0087c f368o;

    /* JADX INFO: renamed from: a */
    public JSONObject f369a;

    /* JADX INFO: renamed from: b */
    public String f370b;

    /* JADX INFO: renamed from: c */
    public JSONObject f371c;

    /* JADX INFO: renamed from: d */
    public JSONObject f372d;

    /* JADX INFO: renamed from: e */
    public boolean f373e;

    /* JADX INFO: renamed from: f */
    public String f374f;

    /* JADX INFO: renamed from: g */
    public String f375g;

    /* JADX INFO: renamed from: h */
    public String f376h;

    /* JADX INFO: renamed from: i */
    public boolean f377i;

    /* JADX INFO: renamed from: j */
    public C0126t f378j;

    /* JADX INFO: renamed from: k */
    public String f379k;

    /* JADX INFO: renamed from: l */
    public String f380l;

    /* JADX INFO: renamed from: m */
    public String f381m;

    /* JADX INFO: renamed from: n */
    public boolean f382n;

    /* JADX INFO: renamed from: a */
    public static boolean m480a(JSONObject jSONObject) {
        if (!C0032d.m239a(jSONObject.optJSONArray("FirstPartyCookies"))) {
            return true;
        }
        if (!jSONObject.has("SubGroups")) {
            return false;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("SubGroups");
        if (!C0032d.m239a(jSONArrayOptJSONArray)) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                if (!C0032d.m239a(jSONArrayOptJSONArray.optJSONObject(i).optJSONArray("FirstPartyCookies"))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public static String m481b(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("GroupDescription");
        return (!jSONObject.has("GroupDescriptionOTT") || C0048h.m305b(jSONObject.optString("GroupDescriptionOTT")) || jSONObject.isNull("GroupDescriptionOTT")) ? strOptString : jSONObject.optString("GroupDescriptionOTT");
    }

    /* JADX INFO: renamed from: c */
    public static synchronized C0087c m482c() {
        if (f368o == null) {
            f368o = new C0087c();
        }
        return f368o;
    }

    /* JADX INFO: renamed from: c */
    public static String m483c(JSONObject jSONObject) {
        return new SpannableStringBuilder(Html.fromHtml(jSONObject.optString("DescriptionLegal"), null, new C0074f.a())).toString().replace("\n\n", "\n\n• ").concat("*").replace("\n\n• *", "");
    }

    /* JADX INFO: renamed from: g */
    public static JSONArray m484g(JSONObject jSONObject) {
        if (jSONObject.optJSONArray("SubGroups") == null || jSONObject.optJSONArray("SubGroups").length() <= 0) {
            return null;
        }
        return jSONObject.optJSONArray("SubGroups");
    }

    /* JADX INFO: renamed from: h */
    public static boolean m485h(JSONObject jSONObject) {
        return (jSONObject.has("SubGroups") && jSONObject.optBoolean("ShowSubgroup")) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    public int m486a(int i) {
        return (!this.f377i || i <= -1) ? 8 : 0;
    }

    /* JADX INFO: renamed from: b */
    public String m494b() {
        String str = this.f378j.f830a;
        return str != null ? str : "#FFFFFF";
    }

    /* JADX INFO: renamed from: d */
    public int m497d(JSONObject jSONObject) {
        String strM483c = m483c(jSONObject);
        return (C0048h.m305b(strM483c) || !this.f373e || "*".equals(strM483c)) ? 8 : 0;
    }

    /* JADX INFO: renamed from: e */
    public int m499e(JSONObject jSONObject) {
        return (jSONObject.optBoolean("ShowSDKListLink") && this.f382n && m480a(jSONObject)) ? 0 : 8;
    }

    /* JADX INFO: renamed from: e */
    public boolean m500e() {
        return this.f373e || C0086b.m475a().f360o;
    }

    /* JADX INFO: renamed from: f */
    public int m501f(JSONObject jSONObject) {
        return (jSONObject.optString("Status").contains(ReactScrollViewHelper.OVER_SCROLL_ALWAYS) || !m492a(jSONObject.optString("Parent"))) ? 8 : 0;
    }

    /* JADX INFO: renamed from: a */
    public final void m491a(Context context) {
        C0126t c0126t = this.f378j;
        C0106b0 c0106b0 = c0126t.f843n;
        C0106b0 c0106b02 = c0126t.f842m;
        C0106b0 c0106b03 = c0126t.f845p;
        C0106b0 c0106b04 = c0126t.f844o;
        C0106b0 c0106b05 = c0126t.f847r;
        boolean z = Boolean.parseBoolean(c0126t.f826I);
        boolean z2 = Boolean.parseBoolean(this.f378j.f828K);
        boolean z3 = Boolean.parseBoolean(this.f378j.f827J);
        int i = z ? 0 : 8;
        int i2 = z2 ? 0 : 8;
        int i3 = (!z3 || C0048h.m305b(this.f378j.f847r.f726e)) ? 8 : 0;
        c0106b0.f727f = i;
        c0106b02.f727f = i;
        c0106b03.f727f = i2;
        c0106b04.f727f = i2;
        c0106b05.f727f = i3;
        String string = new C0045d(context, "OTT_DEFAULT_USER").m271a().getString("OTT_LAST_GIVEN_CONSENT", "0");
        if (0 == (C0048h.m305b(string) ? 0L : Long.parseLong(string))) {
            c0106b03.f726e = this.f378j.f846q.f726e;
        }
    }

    /* JADX INFO: renamed from: b */
    public JSONObject m495b(Context context) {
        JSONObject jSONObject = this.f369a;
        if (jSONObject != null) {
            return jSONObject;
        }
        String string = new C0045d(context, "OTT_DEFAULT_USER").m271a().getString("OTT_PC_DATA", null);
        if (C0048h.m305b(string)) {
            return null;
        }
        return new JSONObject(string);
    }

    /* JADX INFO: renamed from: c */
    public void m496c(Context context) {
        try {
            JSONObject jSONObjectM495b = m495b(context);
            this.f369a = jSONObjectM495b;
            if (jSONObjectM495b == null) {
                return;
            }
            String strOptString = jSONObjectM495b.optString("PcBackgroundColor");
            String strOptString2 = this.f369a.optString("PcTextColor");
            String strOptString3 = this.f369a.optString("PcButtonColor");
            String strOptString4 = this.f369a.optString("MainText");
            String strOptString5 = this.f369a.optString("MainInfoText");
            String strOptString6 = this.f369a.optString("ConfirmText");
            String strOptString7 = this.f369a.optString("PCenterRejectAllButtonText");
            String strOptString8 = this.f369a.optString("PreferenceCenterConfirmText");
            String strOptString9 = this.f369a.optString("PcButtonTextColor");
            this.f370b = this.f369a.optString("AlwaysActiveText").isEmpty() ? "Always On" : this.f369a.optString("AlwaysActiveText");
            String strOptString10 = this.f369a.optString("OptanonLogo");
            this.f371c = m489a(C0026u.m168a(this.f369a));
            this.f373e = this.f369a.optBoolean("IsIabEnabled");
            this.f374f = this.f369a.optString("IabType");
            this.f375g = this.f369a.optString("BConsentText");
            this.f376h = this.f369a.optString("BLegitInterestText");
            if (this.f369a.has("LegIntSettings") && !C0048h.m305b("LegIntSettings")) {
                this.f377i = this.f369a.getJSONObject("LegIntSettings").getBoolean("PAllowLI");
            }
            String strOptString11 = this.f369a.optString("VendorListText");
            C0086b c0086bM475a = C0086b.m475a();
            C0126t c0126tM662a = new C0120n(context).m662a(22);
            this.f378j = c0126tM662a;
            if (c0126tM662a != null) {
                if (C0048h.m305b(c0126tM662a.f840k.f726e)) {
                    this.f378j.f840k.f726e = strOptString4;
                }
                if (C0048h.m305b(this.f378j.f841l.f726e)) {
                    this.f378j.f841l.f726e = strOptString5;
                }
                m479a(this.f378j.f852w, strOptString6, strOptString3, strOptString9);
                m479a(this.f378j.f853x, strOptString7, strOptString3, strOptString9);
                m479a(this.f378j.f854y, strOptString8, strOptString3, strOptString9);
                this.f378j.f854y.mo377a(0);
                if (C0048h.m305b(this.f378j.f818A.m650a())) {
                    this.f378j.f818A.f761b = strOptString10;
                }
                if (C0048h.m305b(this.f378j.f830a)) {
                    this.f378j.f830a = strOptString;
                }
                m490a(c0086bM475a);
                C0106b0 c0106b0 = this.f378j.f841l;
                if (C0048h.m305b(c0106b0.f724c)) {
                    c0106b0.f724c = strOptString2;
                }
                if (C0048h.m305b(this.f378j.f822E.f755a.f726e)) {
                    this.f378j.f822E.f755a.f726e = strOptString11;
                }
                this.f378j.f823F.f755a.f726e = this.f369a.optString("ThirdPartyCookieListText");
                m491a(context);
            }
            C0021p c0021p = new C0021p(context);
            this.f380l = c0021p.m113a(context);
            this.f379k = c0021p.m114a(this.f369a);
            this.f381m = this.f369a.optString("PCenterVendorListDescText", "");
            this.f382n = this.f369a.optBoolean("ShowCookieList");
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "Error while parsing preference center data, error: " + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: d */
    public String m498d() {
        String str = this.f378j.f841l.f724c;
        return str != null ? str : "#696969";
    }

    /* JADX INFO: renamed from: a */
    public final JSONObject m489a(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    if (jSONArray.getJSONObject(i).has("SubGroups")) {
                        String strOptString = jSONArray.getJSONObject(i).optString("CustomGroupId");
                        JSONArray jSONArray2 = new JSONArray();
                        JSONArray jSONArray3 = jSONArray.getJSONObject(i).getJSONArray("SubGroups");
                        jSONObject2.put(strOptString, jSONArray.getJSONObject(i).optBoolean("ShowSubgroupToggle"));
                        for (int i2 = 0; i2 < jSONArray3.length(); i2++) {
                            jSONArray2.put(jSONArray3.getJSONObject(i2).optString("CustomGroupId"));
                            jSONObject.put(strOptString, jSONArray2);
                        }
                    }
                } catch (JSONException e) {
                    OTLogger.m2743a(6, "OneTrust", "Error in getting subgroups for a category on TV, err: " + e.getMessage());
                }
            }
        }
        this.f372d = jSONObject2;
        return jSONObject;
    }

    /* JADX INFO: renamed from: a */
    public String m487a() {
        String str = this.f378j.f850u.f726e;
        return str != null ? str : this.f370b;
    }

    /* JADX INFO: renamed from: a */
    public String m488a(boolean z) {
        if (z) {
            return C0086b.m475a().f361p;
        }
        return this.f375g;
    }

    /* JADX INFO: renamed from: a */
    public boolean m493a(String str, OTPublishersHeadlessSDK oTPublishersHeadlessSDK) {
        JSONObject jSONObject = this.f371c;
        JSONArray jSONArrayNames = jSONObject.names();
        if (!(!(jSONArrayNames instanceof JSONArray) ? jSONArrayNames.toString() : JSONArrayInstrumentation.toString(jSONArrayNames)).contains(str)) {
            return false;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            if (oTPublishersHeadlessSDK.getPurposeLegitInterestLocal(jSONArrayOptJSONArray.getString(i)) == 0) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public boolean m492a(String str) {
        JSONObject jSONObject = this.f372d;
        if (jSONObject == null || C0048h.m305b(str)) {
            return true;
        }
        return jSONObject.optBoolean(str);
    }

    /* JADX INFO: renamed from: a */
    public static void m479a(C0107c c0107c, String str, String str2, String str3) {
        String str4;
        if (C0048h.m305b(c0107c.mo376a())) {
            c0107c.f734g = str;
        }
        if (C0048h.m305b(c0107c.f729b)) {
            c0107c.f729b = str2;
        }
        C0086b c0086bM475a = C0086b.m475a();
        if (C0048h.m305b(c0107c.mo378b())) {
            c0107c.f730c = str3;
        }
        if (c0086bM475a.f365t) {
            c0107c.f731d = str3;
            str4 = c0086bM475a.f353h;
        } else {
            str4 = "";
            c0107c.f731d = "";
        }
        c0107c.f738k = str4;
        c0107c.mo377a((!C0026u.m181a(c0107c.f735h, false) || C0048h.m305b(c0107c.mo376a())) ? 8 : 0);
        c0107c.f736i = c0086bM475a.f352g;
        c0107c.f737j = c0086bM475a.f353h;
    }

    /* JADX INFO: renamed from: a */
    public final void m490a(C0086b c0086b) {
        C0119m c0119m = this.f378j.f819B;
        String str = c0086b.f354i;
        c0119m.f763a = str;
        if (C0048h.m305b(str)) {
            c0119m.f763a = this.f378j.f830a;
        }
        String str2 = c0086b.f355j;
        c0119m.f764b = str2;
        if (C0048h.m305b(str2)) {
            c0119m.f763a = this.f378j.f849t.f724c;
        }
        c0119m.f765c = c0086b.f356k;
        c0119m.f766d = c0086b.f357l;
        c0119m.f767e = c0086b.f358m;
        c0119m.f768f = c0086b.f359n;
    }
}
