package p000a.p001a.p002a.p003a.p014b.p017d.p019b;

import android.content.Context;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p014b.p021e.C0107c;
import p000a.p001a.p002a.p003a.p014b.p021e.C0120n;
import p000a.p001a.p002a.p003a.p014b.p021e.C0132z;

/* JADX INFO: renamed from: a.a.a.a.b.d.b.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0088d {

    /* JADX INFO: renamed from: h */
    public static C0088d f383h;

    /* JADX INFO: renamed from: a */
    public JSONObject f384a;

    /* JADX INFO: renamed from: b */
    public String f385b;

    /* JADX INFO: renamed from: c */
    public String f386c;

    /* JADX INFO: renamed from: d */
    public String f387d;

    /* JADX INFO: renamed from: e */
    public String f388e = "";

    /* JADX INFO: renamed from: f */
    public C0132z f389f;

    /* JADX INFO: renamed from: g */
    public C0107c f390g;

    /* JADX INFO: renamed from: a */
    public static void m502a(JSONArray jSONArray, JSONArray jSONArray2, int i, JSONObject jSONObject) throws JSONException {
        if (!jSONArray.getJSONObject(i).has("ShowSDKListLink") || jSONArray.getJSONObject(i).getBoolean("ShowSDKListLink")) {
            if (jSONArray.getJSONObject(i).getString("Type").equals("COOKIE") && jSONArray.getJSONObject(i).getJSONArray("FirstPartyCookies").length() > 0) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String strOptString = jSONObject2.optString("GroupNameMobile");
                if (C0048h.m305b(strOptString)) {
                    strOptString = jSONObject2.optString("GroupName");
                }
                jSONObject.put("GroupName", strOptString);
                jSONObject.put("CustomGroupId", jSONArray.getJSONObject(i).optString("CustomGroupId", ""));
                jSONArray2.put(jSONObject);
            }
            if (jSONArray.getJSONObject(i).has("SubGroups")) {
                JSONArray jSONArray3 = jSONArray.getJSONObject(i).getJSONArray("SubGroups");
                for (int i2 = 0; i2 < jSONArray3.length(); i2++) {
                    JSONObject jSONObject3 = new JSONObject();
                    if (jSONArray3.getJSONObject(i2).getString("Type").equals("COOKIE") && jSONArray3.getJSONObject(i2).getJSONArray("FirstPartyCookies").length() > 0) {
                        JSONObject jSONObject4 = jSONArray3.getJSONObject(i2);
                        String strOptString2 = jSONObject4.optString("GroupNameMobile");
                        if (C0048h.m305b(strOptString2)) {
                            strOptString2 = jSONObject4.optString("GroupName");
                        }
                        jSONObject3.put("GroupName", strOptString2);
                        jSONObject3.put("CustomGroupId", jSONArray3.getJSONObject(i2).optString("CustomGroupId", ""));
                        jSONArray2.put(jSONObject3);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static synchronized C0088d m503b() {
        if (f383h == null) {
            f383h = new C0088d();
        }
        return f383h;
    }

    /* JADX INFO: renamed from: b */
    public void m506b(Context context) {
        try {
            JSONObject jSONObjectM505a = m505a(context);
            this.f384a = jSONObjectM505a;
            if (jSONObjectM505a == null) {
                return;
            }
            this.f385b = jSONObjectM505a.optString("PcTextColor");
            if (this.f384a.has("LegIntSettings") && !C0048h.m305b("LegIntSettings")) {
                this.f384a.getJSONObject("LegIntSettings").getBoolean("PAllowLI");
            }
            String strOptString = this.f384a.optString("PCenterVendorsListText");
            this.f386c = this.f384a.optString("PCenterApplyFiltersText");
            this.f387d = this.f384a.optString("PCenterClearFiltersText");
            this.f388e = this.f384a.optString("ThirdPartyCookieListText");
            C0132z c0132zM665b = new C0120n(context).m665b(22);
            this.f389f = c0132zM665b;
            if (c0132zM665b != null) {
                if (C0048h.m305b(c0132zM665b.f914r.f856a.f726e)) {
                    this.f389f.f914r.f856a.f726e = strOptString;
                }
                this.f390g = new C0107c();
                if (C0086b.m475a().f363r) {
                    this.f390g.mo377a(0);
                } else {
                    this.f390g.mo377a(8);
                }
                if (C0048h.m305b(this.f389f.f902f)) {
                    this.f389f.f902f = this.f384a.optString("PcButtonColor");
                }
                C0107c c0107c = this.f390g;
                C0132z c0132z = this.f389f;
                c0107c.f730c = c0132z.f902f;
                if (C0048h.m305b(c0132z.f903g)) {
                    this.f389f.f903g = this.f384a.optString("PcTextColor");
                }
                C0107c c0107c2 = this.f390g;
                c0107c2.f729b = this.f389f.f903g;
                c0107c2.f736i = C0086b.m475a().f352g;
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "Error while parsing PC data for VL rendering, error: " + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: c */
    public JSONArray m507c() {
        return C0026u.m168a(this.f384a);
    }

    /* JADX INFO: renamed from: d */
    public String m508d() {
        String str;
        C0132z c0132z = this.f389f;
        return (c0132z == null || (str = c0132z.f914r.f856a.f726e) == null) ? "" : str;
    }

    /* JADX INFO: renamed from: a */
    public JSONArray m504a() {
        JSONArray jSONArrayM168a = C0026u.m168a(this.f384a);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < jSONArrayM168a.length(); i++) {
            try {
                m502a(jSONArrayM168a, jSONArray, i, new JSONObject());
            } catch (JSONException e) {
                OTLogger.m2743a(6, "TVDataUtils", "Error on parsing Categories list. Error msg = " + e.getMessage());
            }
        }
        return jSONArray;
    }

    /* JADX INFO: renamed from: a */
    public JSONObject m505a(Context context) {
        JSONObject jSONObject = this.f384a;
        if (jSONObject != null) {
            return jSONObject;
        }
        String string = new C0045d(context, "OTT_DEFAULT_USER").m271a().getString("OTT_PC_DATA", null);
        if (C0048h.m305b(string)) {
            return null;
        }
        return new JSONObject(string);
    }
}
