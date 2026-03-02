package p000a.p001a.p002a.p003a.p004a.p007c;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTGeolocationModel;
import com.onetrust.otpublishers.headless.Public.Keys.OTGppKeys;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABCCPAKeys;
import com.onetrust.otpublishers.headless.Public.OTCCPAGeolocationConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.C0046e;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;
import p000a.p001a.p002a.p003a.p028d.C0187b;

/* JADX INFO: renamed from: a.a.a.a.a.c.f */
/* JADX INFO: loaded from: classes.dex */
public class C0011f {

    /* JADX INFO: renamed from: a */
    public Context f21a;

    /* JADX INFO: renamed from: b */
    public C0045d f22b;

    /* JADX INFO: renamed from: c */
    public SharedPreferences f23c;

    public C0011f(Context context) {
        this.f21a = context;
        this.f23c = PreferenceManager.getDefaultSharedPreferences(context);
        this.f22b = new C0045d(context, "OTT_DEFAULT_USER");
    }

    /* JADX INFO: renamed from: a */
    public String m64a() {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        Context context = this.f21a;
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z = true;
        } else {
            sharedPreferencesC0047f = null;
        }
        if (z) {
            sharedPreferences = sharedPreferencesC0047f;
        }
        return sharedPreferences.getString("OT_CCPA_CATEGORY_ID", "");
    }

    /* JADX INFO: renamed from: b */
    public final void m69b(String str) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f21a);
        defaultSharedPreferences.edit().putString(OTGppKeys.IAB_GPP_USP1_STRING, str).apply();
        defaultSharedPreferences.edit().putInt(OTGppKeys.IAB_GPP_USP1_VERSION, 1).apply();
        defaultSharedPreferences.edit().putString(OTGppKeys.IAB_GPP_USP1_NOTICE, String.valueOf(str.charAt(1))).apply();
        defaultSharedPreferences.edit().putString(OTGppKeys.IAB_GPP_USP1_OPT_OUT, String.valueOf(str.charAt(2))).apply();
        defaultSharedPreferences.edit().putString(OTGppKeys.IAB_GPP_USP1_LSPA_COVERED, String.valueOf(str.charAt(3))).apply();
    }

    /* JADX INFO: renamed from: a */
    public static boolean m63a(OTGeolocationModel oTGeolocationModel, String str, boolean z) {
        String str2 = oTGeolocationModel.country;
        String str3 = oTGeolocationModel.state;
        OTLogger.m2743a(3, "IABCCPA_Consent", "bannerLoaded country = " + str2 + " state = " + str3);
        if (C0048h.m305b(str2)) {
            return z;
        }
        OTLogger.m2743a(4, "IABCCPA_Consent", "Initialized location for CCPA = " + str);
        if ((!OTCCPAGeolocationConstants.f4105CA.equalsIgnoreCase(str) || ("US".equalsIgnoreCase(str2) && "CA".equalsIgnoreCase(str3))) && (!OTCCPAGeolocationConstants.f4106US.equalsIgnoreCase(str) || "US".equalsIgnoreCase(str2))) {
            return z;
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public void m65a(String str) {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        boolean z;
        Context context = this.f21a;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z = true;
        } else {
            sharedPreferencesC0047f = null;
            z = false;
        }
        new C0187b(context);
        if (z) {
            sharedPreferences = sharedPreferencesC0047f;
        }
        boolean z2 = sharedPreferences.getBoolean("OT_GPP_IS_ENABLED", false);
        boolean zEquals = this.f23c.getString(OTIABCCPAKeys.OT_IAB_US_PRIVACY_STRING, "").equals(str);
        if (!z2) {
            m66a(str, zEquals);
        } else if (this.f23c.contains(OTIABCCPAKeys.OT_IAB_US_PRIVACY_STRING)) {
            m66a(str, zEquals);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public void m67a(JSONObject jSONObject) {
        String str;
        String string;
        Object[] objArr;
        String strOptString = jSONObject.optString("parentCCPACategory", "");
        String strOptString2 = jSONObject.optString("ccpaGeo", "");
        boolean zOptBoolean = jSONObject.optBoolean("ccpaLspa", false);
        boolean zOptBoolean2 = jSONObject.optBoolean("ccpaExpNotice", false);
        boolean zOptBoolean3 = jSONObject.optBoolean("computeCCPA", false);
        this.f22b.m271a().edit().putBoolean("OT_COMPUTE_CCPA_REGION", zOptBoolean3).apply();
        OTGeolocationModel oTGeolocationModel = null;
        SharedPreferencesC0047f sharedPreferencesC0047f = null;
        if (zOptBoolean3) {
            if (!C0048h.m305b(strOptString)) {
                if (C0048h.m306b(strOptString, this.f22b.m271a().getString("OT_UI_VALID_GROUP_IDS", ""))) {
                    Context context = this.f21a;
                    SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                    if (C0026u.m181a(context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0).getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                        sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                        objArr = true;
                    } else {
                        objArr = false;
                    }
                    new C0187b(context);
                    if (objArr != false) {
                        sharedPreferences = sharedPreferencesC0047f;
                    }
                    String str2 = sharedPreferences.getBoolean("OT_GPP_IS_ENABLED", false) ? OTGppKeys.IAB_GPP_USP1_STRING : OTIABCCPAKeys.OT_IAB_US_PRIVACY_STRING;
                    if (!this.f23c.contains(str2)) {
                        this.f23c.edit().putString(str2, "1---").apply();
                        OTLogger.m2743a(4, "IABCCPA_Consent", "CCPA initialized? = " + this.f23c.contains(str2));
                    }
                    SharedPreferences.Editor editorEdit = this.f22b.m271a().edit();
                    editorEdit.putString("OT_CCPA_CATEGORY_ID", strOptString);
                    editorEdit.putString("OTT_CCPA_GEOLOCATIONS", strOptString2);
                    editorEdit.putBoolean("OTT_EXPLICIT_NOTICE", zOptBoolean2);
                    editorEdit.putBoolean("OTT_AGREEMENT_TERMS_APPLIES", zOptBoolean);
                    editorEdit.apply();
                    m68a(new C0046e(this.f21a).m272a(strOptString) == 1, false);
                } else {
                    OTLogger.m2743a(5, "OneTrust", "Invalid CCPA configuration. Please assign SDKs to the CCPA category or its subgroups.");
                }
            }
        } else {
            m65a("1---");
            String string2 = this.f22b.m271a().getString("OT_DATA_DOWNLOADED_GEO_LOCATION", "");
            if (!C0048h.m305b(strOptString)) {
                new C0045d(this.f21a, "OTT_DEFAULT_USER");
                if (!C0048h.m305b(string2)) {
                    oTGeolocationModel = new OTGeolocationModel();
                    try {
                        JSONObject jSONObject2 = new JSONObject(string2);
                        oTGeolocationModel.country = jSONObject2.optString("country");
                        oTGeolocationModel.state = jSONObject2.optString("state");
                    } catch (JSONException e) {
                        OTLogger.m2743a(6, "GLDataHandler", "error in formatting ott data with err = " + e.getMessage());
                    }
                }
                str = (!OTCCPAGeolocationConstants.ALL.equalsIgnoreCase(strOptString2) && (C0048h.m305b(strOptString2) || oTGeolocationModel == null || !oTGeolocationModel.compareLocation(strOptString2))) ? "CCPA string not updated for location " + strOptString2 + " as user's location " + string2 + " is out of ccpa configured region" : "Compute CCPA disabled for this template from OneTrust UI";
            }
            OTLogger.m2743a(5, "OneTrust", str);
        }
        if (C0048h.m305b(m64a())) {
            return;
        }
        new JSONArray();
        String strM64a = m64a();
        try {
            JSONObject jSONObject3 = new JSONObject(this.f22b.m271a().getString("OTT_PARENT_GROUPS", ""));
            if (jSONObject3.has(strM64a)) {
                JSONArray jSONArray = jSONObject3.getJSONArray(strM64a);
                SharedPreferences.Editor editorEdit2 = this.f22b.m271a().edit();
                if (jSONArray instanceof JSONArray) {
                    string = JSONArrayInstrumentation.toString(jSONArray);
                } else {
                    string = jSONArray.toString();
                }
                editorEdit2.putString("OTT_CCPA_CUSTOM_GROUP_IDS", string).apply();
            }
        } catch (JSONException e2) {
            OTLogger.m2743a(6, "IABCCPA_Consent", "Error when CCPA subgroups are fetched, err : " + e2.getMessage());
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m66a(String str, boolean z) {
        if (z) {
            return;
        }
        this.f23c.edit().putString(OTIABCCPAKeys.OT_IAB_US_PRIVACY_STRING, str).apply();
        OTLogger.m2743a(4, "IABCCPA_Consent", "Resetting CCPA String on template change");
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x02ff A[Catch: JSONException -> 0x0326, TryCatch #0 {JSONException -> 0x0326, blocks: (B:85:0x023c, B:86:0x0247, B:88:0x024d, B:90:0x028f, B:92:0x029c, B:95:0x02a7, B:97:0x02af, B:99:0x02b5, B:113:0x02eb, B:116:0x030a, B:115:0x02ff, B:106:0x02ce, B:110:0x02e5, B:117:0x030e), top: B:141:0x023c }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0170  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m68a(boolean r23, boolean r24) {
        /*
            Method dump skipped, instruction units count: 916
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p007c.C0011f.m68a(boolean, boolean):boolean");
    }
}
