package p000a.p001a.p002a.p003a.p004a.p010g;

import android.content.Context;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;

/* JADX INFO: renamed from: a.a.a.a.a.g.e */
/* JADX INFO: loaded from: classes.dex */
public class C0046e {

    /* JADX INFO: renamed from: a */
    public final C0045d f97a;

    /* JADX INFO: renamed from: b */
    public C0043b f98b;

    public C0046e(C0045d c0045d) {
        this.f97a = c0045d;
        this.f98b = new C0043b(c0045d);
    }

    public C0046e(Context context) {
        C0045d c0045d = new C0045d(context, "OTT_DEFAULT_USER");
        this.f97a = c0045d;
        this.f98b = new C0043b(c0045d);
    }

    /* JADX INFO: renamed from: a */
    public JSONObject m273a() {
        try {
            String string = this.f97a.m271a().getString("OT_GOOGLE_ACTIVE_VENDOR_LIST", null);
            if (!C0048h.m305b(string)) {
                return new JSONObject(string);
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "error while getting culture data json on getActiveGoogleVendors, err: " + e.getMessage());
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void m274a(int i) {
        this.f97a.m271a().edit().putInt("OT_MIGRATION_STATUS", i).apply();
    }

    /* JADX INFO: renamed from: b */
    public JSONObject m276b() {
        String string = this.f97a.m271a().getString("OTT_CULTURE_COMMON_DATA", "");
        if (!C0048h.m305b(string)) {
            try {
                return new JSONObject(string);
            } catch (JSONException e) {
                OTLogger.m2743a(6, "OneTrust", "error while returning common data, err: " + e.getMessage());
            }
        }
        return new JSONObject();
    }

    /* JADX INFO: renamed from: c */
    public void m278c(String str) {
        Date dateM298a = C0048h.m298a(str, "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        if (dateM298a != null) {
            this.f97a.m271a().edit().putLong("OT_IAB_TC_STR_CREATED_IN_MILLISECONDS", dateM298a.getTime()).apply();
            OTLogger.m2743a(2, "TCStringDate", "Updating tc string Created date from profile sync value,Date = " + str + " , milliseconds = " + dateM298a.getTime());
        }
    }

    /* JADX INFO: renamed from: c */
    public boolean m279c() {
        if (this.f97a.m271a().contains("OT_PROFILE_SYNC_IAB_CONSENT_EXPIRED")) {
            return this.f97a.m271a().getBoolean("OT_PROFILE_SYNC_IAB_CONSENT_EXPIRED", false);
        }
        return false;
    }

    /* JADX INFO: renamed from: d */
    public JSONObject m280d() {
        String string = this.f97a.m271a().getString("OTT_CULTURE_DOMAIN_DATA", "");
        if (!C0048h.m305b(string)) {
            try {
                return new JSONObject(string);
            } catch (JSONException e) {
                OTLogger.m2743a(6, "OneTrust", "error while returning culture domain data, err: " + e.getMessage());
            }
        }
        return new JSONObject();
    }

    /* JADX INFO: renamed from: e */
    public String m282e() {
        String string = this.f97a.m271a().getString("OTT_DATA_SUBJECT_IDENTIFIER", "");
        return string == null ? "" : string;
    }

    /* JADX INFO: renamed from: e */
    public void m283e(String str) {
        OTLogger.m2743a(4, "OTSPUtils", "Updating consent given time, timeStamp = " + str);
        this.f97a.m271a().edit().putString("OTT_LAST_GIVEN_CONSENT", str).apply();
    }

    /* JADX INFO: renamed from: f */
    public String m284f() {
        try {
            JSONObject jSONObjectM280d = m280d();
            if (jSONObjectM280d.length() <= 0) {
                return "";
            }
            if (!(jSONObjectM280d instanceof JSONObject)) {
                return jSONObjectM280d.toString();
            }
            JSONObject jSONObject = jSONObjectM280d;
            return JSONObjectInstrumentation.toString(jSONObjectM280d);
        } catch (Exception e) {
            OTLogger.m2743a(3, "OneTrust", "empty data as SDK not yet initialized " + e.getMessage());
            return "";
        }
    }

    /* JADX INFO: renamed from: g */
    public String m285g() {
        return this.f97a.m271a().getString("OT_IAB_PURPOSES_TRANSLATED", "");
    }

    /* JADX INFO: renamed from: h */
    public String m286h() {
        return this.f97a.m271a().getString("OTT_LAST_GIVEN_CONSENT", "0");
    }

    /* JADX INFO: renamed from: i */
    public int m287i() {
        return this.f97a.m271a().getInt("OT_MIGRATION_STATUS", 5);
    }

    /* JADX INFO: renamed from: j */
    public JSONObject m288j() {
        try {
            String string = this.f97a.m271a().getString("OT_MOBILE_DATA", "");
            if (!C0048h.m305b(string)) {
                return new JSONObject(string);
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "error while getting mobile data json, err: " + e.getMessage());
        }
        return new JSONObject();
    }

    /* JADX INFO: renamed from: k */
    public JSONArray m289k() {
        JSONArray jSONArray = new JSONArray();
        String string = this.f97a.m271a().getString("OTT_PC_DATA", null);
        if (C0048h.m305b(string)) {
            return jSONArray;
        }
        try {
            return new JSONObject(string).getJSONArray("Groups");
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OTSPUtils", "Error on getting pc group array, message = " + e.getMessage());
            return jSONArray;
        }
    }

    /* JADX INFO: renamed from: l */
    public String m290l() {
        String string = this.f97a.m271a().getString("OT_TEMPLATE_TYPE", "");
        return C0048h.m305b(string) ? "" : string;
    }

    /* JADX INFO: renamed from: m */
    public JSONObject m291m() {
        String string = this.f97a.m271a().getString("OT_IAB_ACTIVE_VENDORLIST", null);
        if (C0048h.m305b(string)) {
            return null;
        }
        return new JSONObject(string);
    }

    /* JADX INFO: renamed from: n */
    public JSONObject m292n() {
        String string = this.f97a.m271a().getString("OT_VENDOR_COUNT_FOR_CATEGORIES", "");
        OTLogger.m2743a(3, "IAB2V2Flow", "Getting vendorCountForCategoryString = " + string);
        if (!C0048h.m305b(string)) {
            try {
                return new JSONObject(string);
            } catch (JSONException e) {
                OTLogger.m2743a(6, "OTSPUtils", "Error on getting vendor count for categories : " + e.getMessage());
            }
        }
        return new JSONObject();
    }

    /* JADX INFO: renamed from: o */
    public boolean m293o() {
        return this.f97a.m271a().getBoolean("OT_GOOGLE_VENDORS_ENABLED_STATE", false);
    }

    /* JADX INFO: renamed from: p */
    public boolean m294p() {
        try {
            JSONObject jSONObjectM295q = m295q();
            if (jSONObjectM295q != null) {
                String strOptString = jSONObjectM295q.optString("IabType");
                if (C0048h.m305b(strOptString)) {
                    return false;
                }
                return "IAB2V2".equalsIgnoreCase(strOptString);
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "IAB2V2Flow", "Error on getting iab type : " + e.getMessage());
        }
        return false;
    }

    /* JADX INFO: renamed from: q */
    public JSONObject m295q() {
        String string = this.f97a.m271a().getString("OTT_PC_DATA", null);
        if (C0048h.m305b(string)) {
            return null;
        }
        return new JSONObject(string);
    }

    /* JADX INFO: renamed from: a */
    public int m272a(String str) {
        String str2;
        JSONObject jSONObject;
        if (m277b(str)) {
            return 1;
        }
        String string = this.f97a.m271a().getString("OTT_CONSENT_STATUS", "");
        if (!C0048h.m305b(string)) {
            Locale locale = Locale.ENGLISH;
            String lowerCase = str.toLowerCase(locale);
            try {
                jSONObject = new JSONObject(string.toLowerCase(locale));
            } catch (JSONException unused) {
                jSONObject = null;
            }
            try {
                if (jSONObject.has(lowerCase)) {
                    return jSONObject.getInt(lowerCase);
                }
                return -1;
            } catch (JSONException unused2) {
                str2 = "error in json parsing for customGroup Value = " + jSONObject;
                OTLogger.m2743a(4, "OTSPUtils", str2);
                return -1;
            }
        }
        str2 = "customGroup Value not set.";
        OTLogger.m2743a(4, "OTSPUtils", str2);
        return -1;
    }

    /* JADX INFO: renamed from: a */
    public boolean m275a(String str, String str2) {
        String str3;
        JSONObject jSONObject;
        if (str2 != null && !C0048h.m305b(str2)) {
            Locale locale = Locale.ENGLISH;
            String lowerCase = str.toLowerCase(locale);
            try {
                jSONObject = new JSONObject(str2.toLowerCase(locale));
            } catch (JSONException unused) {
                jSONObject = null;
            }
            try {
                return jSONObject.has(lowerCase);
            } catch (JSONException unused2) {
                str3 = "error in json parsing for customGroup Value = " + jSONObject;
                OTLogger.m2743a(4, "OTSPUtils", str3);
                return false;
            }
        }
        str3 = "customGroup Value not set.";
        OTLogger.m2743a(4, "OTSPUtils", str3);
        return false;
    }

    /* JADX INFO: renamed from: b */
    public boolean m277b(String str) {
        String string = this.f97a.m271a().getString("OTT_ALWAYS_ACTIVE_GROUPS", "");
        if (C0048h.m305b(string)) {
            return false;
        }
        try {
            Locale locale = Locale.ENGLISH;
            return new JSONObject(string.toLowerCase(locale)).has(str.toLowerCase(locale));
        } catch (Exception e) {
            OTLogger.m2743a(6, "OTSPUtils", "Error in getting always active groups " + e.getMessage());
            return false;
        }
    }

    /* JADX INFO: renamed from: d */
    public void m281d(String str) {
        Date dateM298a = C0048h.m298a(str, "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        if (dateM298a != null) {
            this.f97a.m271a().edit().putLong("OT_IAB_TC_STR_LAST_UPDATED_IN_MILLISECONDS", dateM298a.getTime()).apply();
            OTLogger.m2743a(2, "TCStringDate", "Updating tc string updated date from profile sync value,Date = " + str + " , milliseconds = " + dateM298a.getTime());
        }
    }
}
