package p000a.p001a.p002a.p003a.p004a.p011i;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTProfileSyncParams;
import com.onetrust.otpublishers.headless.Public.DataModel.OTSdkParams;
import com.onetrust.otpublishers.headless.Public.OTCallback;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.Response.OTResponse;
import com.onetrust.otpublishers.headless.Public.Response.OTResponseType;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p007c.C0014i;
import p000a.p001a.p002a.p003a.p004a.p007c.C0021p;
import p000a.p001a.p002a.p003a.p004a.p007c.C0022q;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p009f.C0038b;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import retrofit2.Response;

/* JADX INFO: renamed from: a.a.a.a.a.i.d */
/* JADX INFO: loaded from: classes.dex */
public class C0052d {

    /* JADX INFO: renamed from: a */
    public final C0045d f109a;

    /* JADX INFO: renamed from: b */
    public final C0050b f110b;

    /* JADX INFO: renamed from: c */
    public final Context f111c;

    public C0052d(Context context) {
        this.f111c = context;
        C0045d c0045d = new C0045d(context, "OTT_DEFAULT_USER", false);
        this.f109a = c0045d;
        this.f110b = new C0050b(context, c0045d);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m328a(JSONArray jSONArray, String str) {
        return -1 != m329b(jSONArray, str);
    }

    /* JADX INFO: renamed from: a */
    public String m330a(OTSdkParams oTSdkParams) {
        OTProfileSyncParams otProfileSyncParams;
        if (oTSdkParams != null && (otProfileSyncParams = oTSdkParams.getOtProfileSyncParams()) != null) {
            String identifier = otProfileSyncParams.getIdentifier();
            if (!C0048h.m305b(identifier)) {
                return identifier;
            }
            if (identifier != null && identifier.isEmpty()) {
                return m342c();
            }
        }
        return this.f109a.m271a().getString("OTT_DATA_SUBJECT_IDENTIFIER", null);
    }

    /* JADX INFO: renamed from: a */
    public boolean m333a() {
        String string = this.f109a.m271a().getString("OT_MULTI_PROFILE_ID_MAP", null);
        if (C0048h.m305b(string)) {
            return true;
        }
        JSONArray jSONArray = new JSONArray(string);
        for (int i = 0; i < jSONArray.length(); i++) {
            m334a(jSONArray.getString(i));
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public boolean m334a(String str) {
        String str2;
        String lowerCase = str.toLowerCase(Locale.US);
        String strM345d = m345d(lowerCase);
        boolean z = true;
        if (!C0048h.m305b(strM345d)) {
            String str3 = "com.onetrust.otpublishers.headless.preference.OTT_USER_" + strM345d;
            this.f111c.getSharedPreferences(str3, 0).edit().clear().apply();
            if (this.f111c.deleteSharedPreferences(str3)) {
                OTLogger.m2743a(4, "MultiprofileConsent", "Profile file " + str3 + " deleted.");
                str2 = "Profile " + lowerCase + " deleted.";
            } else {
                OTLogger.m2743a(4, "MultiprofileConsent", "Failed to delete profile file " + str3 + " .");
                str2 = "Failed to delete profile " + lowerCase + " .";
                z = false;
            }
            OTLogger.m2743a(4, "MultiprofileConsent", str2);
        }
        m340b(lowerCase);
        return z;
    }

    /* JADX INFO: renamed from: b */
    public String m339b() {
        return this.f109a.m271a().getString("OT_ACTIVE_PROFILE_ID", "");
    }

    /* JADX INFO: renamed from: b */
    public final boolean m340b(String str) {
        String string = this.f109a.m271a().getString("OT_MULTI_PROFILE_ID_MAP", null);
        String string2 = this.f109a.m271a().getString("OT_MULTI_PROFILE_PROFILE_ID_FILE_MAP", null);
        if (C0048h.m305b(string) || C0048h.m305b(string2)) {
            return false;
        }
        JSONArray jSONArray = new JSONArray(string);
        JSONObject jSONObject = new JSONObject(string2);
        int iM329b = m329b(jSONArray, str);
        if (-1 == iM329b) {
            return false;
        }
        jSONObject.remove(jSONArray.getString(iM329b));
        jSONArray.remove(iM329b);
        this.f109a.m271a().edit().putString("OT_MULTI_PROFILE_ID_MAP", !(jSONArray instanceof JSONArray) ? jSONArray.toString() : JSONArrayInstrumentation.toString(jSONArray)).apply();
        this.f109a.m271a().edit().putString("OT_MULTI_PROFILE_PROFILE_ID_FILE_MAP", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)).apply();
        return true;
    }

    /* JADX INFO: renamed from: c */
    public String m342c() {
        String string = this.f109a.m271a().getString("OT_GENERIC_PROFILE_IDENTIFIER", null);
        if (!C0048h.m305b(string)) {
            return string;
        }
        String string2 = UUID.randomUUID().toString();
        m350h(string2);
        return string2;
    }

    /* JADX INFO: renamed from: c */
    public String m343c(String str) {
        String strM345d = m345d(str);
        return strM345d != null ? strM345d : m342c();
    }

    /* JADX INFO: renamed from: d */
    public final String m345d(String str) {
        String string = this.f109a.m271a().getString("OT_MULTI_PROFILE_PROFILE_ID_FILE_MAP", null);
        if (!C0048h.m305b(string)) {
            try {
                String string2 = new JSONObject(string).getString(str);
                if (!C0048h.m305b(string2)) {
                    return string2;
                }
            } catch (JSONException e) {
                OTLogger.m2743a(6, "MultiprofileConsent", "Error on profile ID file name map. Error = " + e.getMessage());
            }
        }
        Context context = this.f111c;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        String string3 = sharedPreferences.getString("OT_MULTI_PROFILE_ID_MAP", null);
        String string4 = sharedPreferences.getString("OT_MULTI_PROFILE_PROFILE_ID_FILE_MAP", null);
        if (!C0048h.m305b(string3) && C0048h.m305b(string4) && context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0).getLong("OT_SDK_VERSION_CODE", 0L) < 63900) {
            try {
                this.f111c.getSharedPreferences("com.onetrust.otpublishers.headless.preference.OTT_USER_" + str, 0);
                return str;
            } catch (IllegalArgumentException e2) {
                OTLogger.m2743a(6, "MultiprofileConsent", "Error on file creation, file name = " + str);
                OTLogger.m2743a(6, "MultiprofileConsent", "Error on file creation, error = " + e2.getMessage());
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: e */
    public boolean m346e() {
        return C0026u.m181a(this.f109a.m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false);
    }

    /* JADX INFO: renamed from: e */
    public boolean m347e(String str) {
        if (str == null) {
            return false;
        }
        if (!C0048h.m305b(this.f109a.m271a().getString("OT_MULTI_PROFILE_ID_MAP", null))) {
            try {
                return !m328a(new JSONArray(r1), str);
            } catch (JSONException e) {
                OTLogger.m2743a(6, "MultiprofileConsent", "Error on getting profilemap. Error = " + e.getMessage());
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: f */
    public int m348f(String str) {
        String strM339b = m339b();
        if (!C0048h.m305b(strM339b) && strM339b.equalsIgnoreCase(str)) {
            return 0;
        }
        if (!C0048h.m305b(str)) {
            this.f110b.m326a(strM339b, str, true, true);
            return 1;
        }
        if (str == null && C0048h.m305b(strM339b)) {
            this.f110b.m326a(strM339b, m342c(), false, false);
            return 2;
        }
        if (str == null && !C0048h.m305b(strM339b)) {
            return 3;
        }
        if (str == null || !str.isEmpty()) {
            return -1;
        }
        this.f110b.m326a(strM339b, m342c(), true, true);
        return 4;
    }

    /* JADX INFO: renamed from: g */
    public void m349g(String str) {
        this.f109a.m271a().edit().putString("OT_ACTIVE_PROFILE_ID", str.toLowerCase(Locale.US)).apply();
    }

    /* JADX INFO: renamed from: h */
    public void m350h(String str) {
        this.f109a.m271a().edit().putString("OT_GENERIC_PROFILE_IDENTIFIER", str).apply();
    }

    /* JADX INFO: renamed from: b */
    public static int m329b(JSONArray jSONArray, String str) {
        String lowerCase = str.toLowerCase(Locale.US);
        for (int i = 0; i < jSONArray.length(); i++) {
            if (lowerCase.equalsIgnoreCase(jSONArray.getString(i))) {
                return i;
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004c A[Catch: Exception -> 0x005d, TryCatch #0 {Exception -> 0x005d, blocks: (B:3:0x0016, B:5:0x0026, B:10:0x0046, B:12:0x004c, B:14:0x0050, B:15:0x0055, B:9:0x0041, B:8:0x002d), top: B:72:0x0016, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0074  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m341b(java.lang.String r16, com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK r17, com.onetrust.otpublishers.headless.Public.OTCallback r18, boolean r19, java.lang.String r20, java.lang.String r21) {
        /*
            Method dump skipped, instruction units count: 617
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p011i.C0052d.m341b(java.lang.String, com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK, com.onetrust.otpublishers.headless.Public.OTCallback, boolean, java.lang.String, java.lang.String):boolean");
    }

    /* JADX INFO: renamed from: a */
    public boolean m335a(String str, OTPublishersHeadlessSDK oTPublishersHeadlessSDK, OTCallback oTCallback, boolean z, String str2, String str3) {
        boolean zM334a;
        String lowerCase = str.toLowerCase(Locale.US);
        try {
            zM334a = m334a(lowerCase);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "MultiprofileConsent", "Exception on profile delete for id = " + lowerCase + " . Exception = " + e.getMessage());
            zM334a = false;
        }
        if (zM334a) {
            if (lowerCase.equalsIgnoreCase(this.f109a.m271a().getString("OT_GENERIC_PROFILE_IDENTIFIER", null))) {
                this.f109a.m271a().edit().putString("OT_GENERIC_PROFILE_IDENTIFIER", "").apply();
            }
            if (lowerCase.equalsIgnoreCase(m339b())) {
                m349g("");
                m341b(m342c(), oTPublishersHeadlessSDK, oTCallback, z, str2, str3);
            } else if (oTCallback != null) {
                oTCallback.onSuccess(new OTResponse(OTResponseType.OT_SUCCESS, 14, this.f111c.getResources().getString(C3896R.string.ott_profile_delete_profile_success), ""));
            }
        } else if (oTCallback != null) {
            oTCallback.onFailure(new OTResponse(OTResponseType.OT_ERROR, 13, this.f111c.getResources().getString(C3896R.string.ott_profile_delete_profile_error), ""));
        }
        return zM334a;
    }

    /* JADX INFO: renamed from: d */
    public int m344d() {
        String string = this.f109a.m271a().getString("OT_MULTI_PROFILE_ID_MAP", null);
        if (C0048h.m305b(string)) {
            return -1;
        }
        try {
            return new JSONArray(string).length();
        } catch (JSONException e) {
            OTLogger.m2743a(6, "MultiprofileConsent", "Error on getting profilemap JSON. Error = " + e.getMessage());
            return -1;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m332a(String str, OTPublishersHeadlessSDK oTPublishersHeadlessSDK, OTCallback oTCallback) {
        OTLogger.m2743a(3, "MultiprofileConsent", "Switch profile with data download failed, so switching profile without data download now.");
        m331a(str, oTPublishersHeadlessSDK);
        if (oTCallback != null) {
            oTCallback.onSuccess(new OTResponse(OTResponseType.OT_SUCCESS, 9, this.f111c.getResources().getString(C3896R.string.ott_data_parsed_with_existing_data), ""));
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m336a(String str, String str2) {
        String string = this.f109a.m271a().getString("OT_MULTI_PROFILE_ID_MAP", null);
        if (!C0048h.m305b(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (!m328a(jSONArray, str)) {
                    OTLogger.m2743a(5, "MultiprofileConsent", "No user profile found with ID " + str + ". Please pass a valid user ID to update");
                    return false;
                }
                if (m328a(jSONArray, str2)) {
                    OTLogger.m2743a(5, "MultiprofileConsent", "Two users cannot have the same user ID " + str2 + ". Thus, pass a unique user ID");
                    return false;
                }
                OTLogger.m2743a(5, "MultiprofileConsent", "Renaming profile ID from  " + str + " , to " + str2 + " .");
                String strM339b = m339b();
                String string2 = this.f109a.m271a().getString("OT_GENERIC_PROFILE_IDENTIFIER", null);
                if (m337a(str2, str, this.f109a)) {
                    return m338a(str, str2, strM339b, string2);
                }
            } catch (JSONException e) {
                OTLogger.m2743a(6, "MultiprofileConsent", "JSON error on renameProfile. Error = " + e.getMessage());
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public final void m331a(String str, OTPublishersHeadlessSDK oTPublishersHeadlessSDK) {
        C0045d c0045d = new C0045d(this.f111c, "OTT_DEFAULT_USER", false);
        Context context = this.f111c;
        new C0038b(context).m257a((Response<String>) null, C0026u.m164a(c0045d), (OTCallback) null, (Handler) null, oTPublishersHeadlessSDK, false);
        new C0022q(context).m135a(context, c0045d.m271a().getString("OT_IAB_GLOBAL_VENDORLIST", ""));
        new C0021p(context).m116a(context, c0045d.m271a().getString("OT_GOOGLE_GVL_COMPLETE_OBJECT", null));
        OTLogger.m2743a(4, "MultiprofileConsent", "The user’s profile has been switched successfully. Profile switched to : " + str);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m327a(String str, C0045d c0045d) throws JSONException {
        String string = c0045d.m271a().getString("OT_MULTI_PROFILE_ID_MAP", null);
        JSONArray jSONArray = new JSONArray();
        if (!C0048h.m305b(string)) {
            try {
                jSONArray = new JSONArray(string);
            } catch (JSONException e) {
                OTLogger.m2743a(6, "MultiprofileConsent", "Error on getting multi-profile id maps. Error = " + e.getMessage());
            }
        }
        String lowerCase = str.toLowerCase(Locale.US);
        if (m328a(jSONArray, lowerCase)) {
            return false;
        }
        OTLogger.m2743a(3, "MultiprofileConsent", "Adding profileID " + lowerCase + " to the profile map.");
        jSONArray.put(lowerCase);
        String string2 = c0045d.m271a().getString("OT_MULTI_PROFILE_PROFILE_ID_FILE_MAP", null);
        JSONObject jSONObject = string2 != null ? new JSONObject(string2) : new JSONObject();
        String string3 = c0045d.m271a().getString("OT_GENERIC_PROFILE_IDENTIFIER", null);
        if (!lowerCase.equalsIgnoreCase(string3)) {
            string3 = UUID.randomUUID().toString();
        }
        jSONObject.put(lowerCase, string3);
        c0045d.m271a().edit().putString("OT_MULTI_PROFILE_ID_MAP", !(jSONArray instanceof JSONArray) ? jSONArray.toString() : JSONArrayInstrumentation.toString(jSONArray)).apply();
        c0045d.m271a().edit().putString("OT_MULTI_PROFILE_PROFILE_ID_FILE_MAP", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)).apply();
        return true;
    }

    /* JADX INFO: renamed from: a */
    public boolean m337a(String str, String str2, C0045d c0045d) throws JSONException {
        String string = c0045d.m271a().getString("OT_MULTI_PROFILE_ID_MAP", null);
        JSONArray jSONArray = new JSONArray();
        if (!C0048h.m305b(string)) {
            try {
                jSONArray = new JSONArray(string);
            } catch (JSONException e) {
                OTLogger.m2743a(6, "MultiprofileConsent", "Error on getting multi-profile id maps. Error = " + e.getMessage());
            }
        }
        Locale locale = Locale.US;
        String lowerCase = str.toLowerCase(locale);
        if (m328a(jSONArray, lowerCase)) {
            return false;
        }
        String strM343c = m343c(str2.toLowerCase(locale));
        m340b(str2);
        OTLogger.m2743a(3, "MultiprofileConsent", "Adding profileID " + lowerCase + " to the profile map.");
        jSONArray.put(lowerCase);
        String string2 = c0045d.m271a().getString("OT_MULTI_PROFILE_PROFILE_ID_FILE_MAP", null);
        JSONObject jSONObject = string2 != null ? new JSONObject(string2) : new JSONObject();
        jSONObject.put(lowerCase, strM343c);
        c0045d.m271a().edit().putString("OT_MULTI_PROFILE_ID_MAP", !(jSONArray instanceof JSONArray) ? jSONArray.toString() : JSONArrayInstrumentation.toString(jSONArray)).apply();
        c0045d.m271a().edit().putString("OT_MULTI_PROFILE_PROFILE_ID_FILE_MAP", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)).apply();
        return true;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m338a(String str, String str2, String str3, String str4) {
        if (str.equalsIgnoreCase(str3)) {
            this.f110b.m325a(str2);
        }
        if (str.equalsIgnoreCase(str4)) {
            this.f109a.m271a().edit().putString("OT_GENERIC_PROFILE_IDENTIFIER", "").apply();
        }
        try {
            C0014i c0014i = new C0014i(this.f111c);
            c0014i.m80a(this.f111c, str2);
            c0014i.m78a(2);
            return true;
        } catch (JSONException e) {
            OTLogger.m2743a(6, "MultiprofileConsent", "error in updating consent : " + e.getMessage());
            return false;
        }
    }
}
