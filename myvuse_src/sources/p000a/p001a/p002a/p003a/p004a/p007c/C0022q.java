package p000a.p001a.p002a.p003a.p004a.p007c;

import android.content.Context;
import android.content.SharedPreferences;
import com.microblink.entities.recognizers.blinkid.usdl.UsdlCombinedRecognizer;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p008e.C0036d;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.C0046e;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;

/* JADX INFO: renamed from: a.a.a.a.a.c.q */
/* JADX INFO: loaded from: classes.dex */
public class C0022q {

    /* JADX INFO: renamed from: a */
    public Context f44a;

    public C0022q(Context context) {
        this.f44a = context;
    }

    /* JADX INFO: renamed from: a */
    public static int m118a(JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3, int i) {
        if (jSONObject2.getJSONObject(str).has(str2)) {
            return jSONObject2.getJSONObject(str).getInt(str2);
        }
        if (jSONObject.getJSONObject(str).getJSONArray(str3).length() > 0) {
            return i;
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    public static JSONArray m119a(JSONArray jSONArray, int i) {
        jSONArray.remove(i);
        return jSONArray;
    }

    /* JADX INFO: renamed from: a */
    public static void m120a(C0045d c0045d, JSONObject jSONObject) {
        if (C0048h.m305b(c0045d.m271a().getString("OT_IAB_DEFAULT_AVL", ""))) {
            c0045d.m271a().edit().putString("OT_IAB_DEFAULT_AVL", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)).apply();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m122a(JSONObject jSONObject, String str, String str2, String str3) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
        if (jSONObject2.has(str3)) {
            JSONArray jSONArray = jSONObject2.getJSONArray(str3);
            if (C0048h.m296a(jSONArray, Integer.parseInt(str)) == -1) {
                jSONArray.put(str);
                jSONObject2.put(str3, jSONArray);
                jSONObject.put(str2, jSONObject2);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public static JSONObject m124e(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        if (!jSONObject.has("publisher")) {
            return jSONObject2;
        }
        JSONObject jSONObject3 = jSONObject.getJSONObject("publisher");
        return jSONObject3.has(UsdlCombinedRecognizer.VerificationConstants.Restrictions) ? jSONObject3.getJSONObject(UsdlCombinedRecognizer.VerificationConstants.Restrictions) : jSONObject2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c4 A[PHI: r0
      0x00c4: PHI (r0v31 ??) = (r0v42 ??), (r0v43 ??), (r0v44 ??) binds: [B:28:0x00b9, B:19:0x008b, B:21:0x0099] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d6  */
    /* JADX WARN: Type inference failed for: r0v14, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32, types: [int] */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v8, types: [org.json.JSONObject] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m136a(org.json.JSONObject r18, org.json.JSONObject r19, org.json.JSONObject r20, java.lang.String r21, boolean r22) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p007c.C0022q.m136a(org.json.JSONObject, org.json.JSONObject, org.json.JSONObject, java.lang.String, boolean):void");
    }

    /* JADX INFO: renamed from: b */
    public JSONArray m137b(JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < jSONObject.length(); i++) {
            try {
                if (jSONObject.getInt(jSONObject.names().get(i).toString()) != 0) {
                    jSONArray.put(Integer.parseInt(jSONObject.names().get(i).toString()));
                }
            } catch (Exception e) {
                OTLogger.m2743a(6, "IABHelper", "error in getting legInt ids : " + e.getMessage());
            }
        }
        OTLogger.m2743a(3, "IABHelper", "legInt consent " + (!(jSONArray instanceof JSONArray) ? jSONArray.toString() : JSONArrayInstrumentation.toString(jSONArray)));
        return jSONArray;
    }

    /* JADX INFO: renamed from: c */
    public JSONArray m139c(JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < jSONObject.length(); i++) {
            try {
                if (jSONObject.getInt(jSONObject.names().get(i).toString()) != 0) {
                    jSONArray.put(Integer.parseInt(jSONObject.names().get(i).toString()));
                }
            } catch (Exception e) {
                OTLogger.m2743a(6, "IABHelper", "error in getting specialFeatureOptIns ids : " + e.getMessage());
            }
        }
        OTLogger.m2743a(3, "IABHelper", "specialFeatureOptIns consent " + (!(jSONArray instanceof JSONArray) ? jSONArray.toString() : JSONArrayInstrumentation.toString(jSONArray)));
        return jSONArray;
    }

    /* JADX INFO: renamed from: d */
    public String m141d(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (!jSONObject.has("Language") || jSONObject.isNull("Language")) {
            return "en";
        }
        try {
            jSONObject2 = jSONObject.getJSONObject("Language");
        } catch (JSONException e) {
            OTLogger.m2743a(6, "IABHelper", "Error while getting lang, err" + e.toString());
        }
        String strOptString = C0048h.m305b(jSONObject2.optString("Culture")) ? "en" : jSONObject2.optString("Culture");
        return (strOptString.length() <= 2 || !strOptString.contains("-")) ? strOptString : strOptString.split("-")[0].toLowerCase(Locale.ENGLISH);
    }

    /* JADX INFO: renamed from: e */
    public boolean m142e(String str) {
        boolean z = false;
        if (!C0048h.m305b(m138c(str)) && (m138c(str).equals("purposes") || m138c(str).equals("special_feature_opt_ins"))) {
            z = true;
        }
        OTLogger.m2743a(3, "IABHelper", "IAB group " + str + " : " + z);
        return z;
    }

    /* JADX INFO: renamed from: d */
    public int m140d(String str) {
        OTLogger.m2743a(3, "IABHelper", "active vendorList = " + str);
        int i = 0;
        if (C0048h.m305b(str)) {
            return 0;
        }
        JSONArray jSONArrayNames = new JSONObject(str).names();
        if (jSONArrayNames != null) {
            int i2 = 0;
            while (i < jSONArrayNames.length()) {
                int i3 = Integer.parseInt(jSONArrayNames.getString(i));
                if (i3 > i2) {
                    i2 = i3;
                }
                i++;
            }
            i = i2;
        }
        OTLogger.m2743a(4, "IABHelper", "maximumVendorId = " + i);
        return i;
    }

    /* JADX INFO: renamed from: b */
    public static String m123b(String str) {
        try {
            return str.contains("_") ? str.split("_")[1] : "";
        } catch (Exception e) {
            OTLogger.m2743a(6, "IABHelper", "error while getting the iab group id " + e.getMessage());
            return "";
        }
    }

    /* JADX INFO: renamed from: c */
    public String m138c(String str) {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        Context context = this.f44a;
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
        try {
            JSONObject jSONObject = new JSONObject(sharedPreferences.getString("OT_IAB_PURPOSE_TYPES", ""));
            if (jSONObject.has(str)) {
                OTLogger.m2743a(3, "IABHelper", "IAB type of " + str + ": " + jSONObject.getString(str));
                return jSONObject.getString(str);
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "IABHelper", "Error while getting IAB type of updated group : " + e.getMessage());
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x009a A[Catch: Exception -> 0x027f, TryCatch #0 {Exception -> 0x027f, blocks: (B:5:0x0047, B:8:0x0077, B:14:0x009a, B:15:0x00a6, B:17:0x00b8, B:22:0x00d9, B:24:0x00f8, B:26:0x010b, B:28:0x011e, B:30:0x0147, B:32:0x0156, B:34:0x0165, B:36:0x0175, B:38:0x017e, B:40:0x0189, B:42:0x0193, B:44:0x019d, B:46:0x01ad, B:48:0x01b7, B:50:0x01d4, B:52:0x01fa, B:56:0x020c, B:21:0x00d4, B:20:0x00bf, B:12:0x0093, B:11:0x007e), top: B:69:0x0047, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d4 A[Catch: Exception -> 0x027f, TryCatch #0 {Exception -> 0x027f, blocks: (B:5:0x0047, B:8:0x0077, B:14:0x009a, B:15:0x00a6, B:17:0x00b8, B:22:0x00d9, B:24:0x00f8, B:26:0x010b, B:28:0x011e, B:30:0x0147, B:32:0x0156, B:34:0x0165, B:36:0x0175, B:38:0x017e, B:40:0x0189, B:42:0x0193, B:44:0x019d, B:46:0x01ad, B:48:0x01b7, B:50:0x01d4, B:52:0x01fa, B:56:0x020c, B:21:0x00d4, B:20:0x00bf, B:12:0x0093, B:11:0x007e), top: B:69:0x0047, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01fa A[Catch: Exception -> 0x027f, TryCatch #0 {Exception -> 0x027f, blocks: (B:5:0x0047, B:8:0x0077, B:14:0x009a, B:15:0x00a6, B:17:0x00b8, B:22:0x00d9, B:24:0x00f8, B:26:0x010b, B:28:0x011e, B:30:0x0147, B:32:0x0156, B:34:0x0165, B:36:0x0175, B:38:0x017e, B:40:0x0189, B:42:0x0193, B:44:0x019d, B:46:0x01ad, B:48:0x01b7, B:50:0x01d4, B:52:0x01fa, B:56:0x020c, B:21:0x00d4, B:20:0x00bf, B:12:0x0093, B:11:0x007e), top: B:69:0x0047, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject m132a(android.content.Context r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 670
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p007c.C0022q.m132a(android.content.Context):org.json.JSONObject");
    }

    /* JADX INFO: renamed from: a */
    public String m126a() {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        Context context = this.f44a;
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
        String string = sharedPreferences.getString("OT_IAB_ACTIVE_VENDORLIST", "");
        OTLogger.m2743a(3, "IABHelper", !C0048h.m305b(string) ? "Saved IAB Active Vendor List : " + string : "Vendor List is empty");
        return string;
    }

    /* JADX INFO: renamed from: a */
    public JSONArray m131a(JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < jSONObject.length(); i++) {
            try {
                if (jSONObject.getInt(jSONObject.names().get(i).toString()) != 0) {
                    jSONArray.put(Integer.parseInt(jSONObject.names().get(i).toString()));
                }
            } catch (Exception e) {
                OTLogger.m2743a(6, "IABHelper", "error in getting purpose ids : " + e.getMessage());
            }
        }
        OTLogger.m2743a(3, "IABHelper", "purposes consent " + (!(jSONArray instanceof JSONArray) ? jSONArray.toString() : JSONArrayInstrumentation.toString(jSONArray)));
        return jSONArray;
    }

    /* JADX INFO: renamed from: a */
    public JSONArray m130a(String str) {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        boolean z;
        JSONObject jSONObject;
        int i;
        JSONArray jSONArray;
        JSONArray jSONArray2 = new JSONArray();
        JSONArray jSONArray3 = new JSONArray();
        Context context = this.f44a;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z = true;
        } else {
            sharedPreferencesC0047f = null;
            z = false;
        }
        if (z) {
            sharedPreferences = sharedPreferencesC0047f;
        }
        String string = sharedPreferences.getString("OTT_CULTURE_DOMAIN_DATA", "");
        if (!C0048h.m305b(string)) {
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e) {
                OTLogger.m2743a(6, "OneTrust", "error while returning culture domain data, err: " + e.getMessage());
                jSONObject = new JSONObject();
            }
        } else {
            jSONObject = new JSONObject();
        }
        try {
            boolean zM7a = new C0005a0().m7a(jSONObject);
            JSONObject jSONObject2 = new JSONObject(m126a());
            for (int i2 = 0; i2 < jSONObject2.length(); i2++) {
                String string2 = jSONObject2.names().get(i2).toString();
                JSONObject jSONObject3 = jSONObject2.getJSONObject(string2);
                if (C0048h.m305b(str)) {
                    if (jSONObject3.getInt(OTVendorUtils.CONSENT_TYPE) == 1) {
                        i = Integer.parseInt(string2);
                        jSONArray = jSONArray2;
                        jSONArray.put(i);
                    }
                } else if (jSONObject3.getInt(OTVendorUtils.LEGITIMATE_CONSENT_TYPE) == 1 || (jSONObject3.getJSONArray("purposes").length() == 0 && jSONObject3.getJSONArray("legIntPurposes").length() == 0 && jSONObject3.getJSONArray("specialPurposes").length() > 0 && zM7a)) {
                    i = Integer.parseInt(string2);
                    jSONArray = jSONArray3;
                    jSONArray.put(i);
                }
            }
        } catch (Exception e2) {
            OTLogger.m2743a(6, "IABHelper", "error in getting vendor ids : " + e2.getMessage());
        }
        OTLogger.m2743a(3, "IABHelper", "vendor consent " + (!(jSONArray2 instanceof JSONArray) ? jSONArray2.toString() : JSONArrayInstrumentation.toString(jSONArray2)) + "vendor legInt " + (!(jSONArray3 instanceof JSONArray) ? jSONArray3.toString() : JSONArrayInstrumentation.toString(jSONArray3)));
        return C0048h.m305b(str) ? jSONArray2 : jSONArray3;
    }

    /* JADX INFO: renamed from: a */
    public int m125a(String str, String str2, String str3, C0045d c0045d, boolean z) {
        JSONObject jSONObject;
        boolean zM246a;
        String string = c0045d.m271a().getString("OTT_IAB_CONSENTABLE_PURPOSES", "");
        String string2 = new C0045d(this.f44a, "OTT_DEFAULT_USER").m271a().getString("OTT_CULTURE_DOMAIN_DATA", "");
        if (!C0048h.m305b(string2)) {
            try {
                jSONObject = new JSONObject(string2);
            } catch (JSONException e) {
                OTLogger.m2743a(6, "OneTrust", "error while returning culture domain data, err: " + e.getMessage());
                jSONObject = new JSONObject();
            }
        } else {
            jSONObject = new JSONObject();
        }
        try {
            zM246a = new C0036d(this.f44a).m246a(jSONObject);
        } catch (JSONException e2) {
            OTLogger.m2743a(3, "IABHelper", "error on checking reconsent for IAB status, " + e2.toString());
            zM246a = false;
        }
        boolean zEqualsIgnoreCase = "active".equalsIgnoreCase(str3);
        try {
            JSONObject jSONObject2 = new JSONObject(string);
            if (jSONObject2.getJSONObject(str2).has(str)) {
                return !zM246a ? jSONObject2.getJSONObject(str2).getInt(str) : zEqualsIgnoreCase ? 1 : 0;
            }
            if (z) {
                return zEqualsIgnoreCase ? 1 : 0;
            }
            return -1;
        } catch (JSONException e3) {
            OTLogger.m2743a(3, "IABHelper", "unable to get iab consent status" + e3.toString());
            return zEqualsIgnoreCase ? 1 : 0;
        }
    }

    /* JADX INFO: renamed from: a */
    public Date m129a(C0045d c0045d, Date date) {
        SharedPreferences.Editor editorEdit = c0045d.m271a().edit();
        editorEdit.putString("OT_IAB_TCStr_Created", date.toString());
        editorEdit.putLong("OT_IAB_TC_STR_CREATED_IN_MILLISECONDS", date.getTime()).apply();
        OTLogger.m2743a(3, "IABHelper", "Tc string Created date timestamp = " + date.getTime());
        return date;
    }

    /* JADX INFO: renamed from: a */
    public Date m128a(C0045d c0045d) {
        Date dateM299a = C0048h.m299a((Date) null);
        SharedPreferences.Editor editorEdit = c0045d.m271a().edit();
        editorEdit.putString("OT_IAB_TCStr_LastUpdated", dateM299a.toString());
        editorEdit.putLong("OT_IAB_TC_STR_LAST_UPDATED_IN_MILLISECONDS", dateM299a.getTime()).apply();
        OTLogger.m2743a(3, "IABHelper", "Tc string updating date timestamp = " + dateM299a.getTime());
        return dateM299a;
    }

    /* JADX INFO: renamed from: a */
    public String m127a(OTPublishersHeadlessSDK oTPublishersHeadlessSDK, JSONObject jSONObject) {
        HashMap map = new HashMap();
        try {
            if (!jSONObject.optString("Type").equalsIgnoreCase("IAB2_STACK") && jSONObject.getBoolean("IsIabPurpose")) {
                map.put(jSONObject.optString("CustomGroupId"), jSONObject.optString("Type", ""));
            }
            if (jSONObject.has("SubGroups")) {
                JSONArray jSONArray = jSONObject.getJSONArray("SubGroups");
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (jSONObject2.getBoolean("IsIabPurpose")) {
                        map.put(jSONObject2.getString("CustomGroupId"), jSONObject2.getString("Type"));
                    }
                }
            }
            JSONObject vendorsByPurpose = !map.isEmpty() ? oTPublishersHeadlessSDK.getOtVendorUtils().getVendorsByPurpose(map, oTPublishersHeadlessSDK.getVendorListUI(OTVendorListMode.IAB)) : oTPublishersHeadlessSDK.getVendorListUI(OTVendorListMode.IAB);
            return vendorsByPurpose != null ? String.valueOf(vendorsByPurpose.length()) : "";
        } catch (JSONException e) {
            OTLogger.m2743a(6, "IABHelper", "error in parsing vendorlist link on setCategoriesForVendorList, returning empty string." + e.getMessage());
            return "";
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m121a(String str, JSONObject jSONObject) {
        OTLogger.m2743a(4, "IABHelper", str);
        JSONArray jSONArrayNames = jSONObject.names();
        if (jSONArrayNames != null) {
            for (int i = 0; i < jSONArrayNames.length(); i++) {
                try {
                    String string = jSONArrayNames.getString(i);
                    OTLogger.m2743a(4, "IABHelper", string + ": " + jSONObject.getString(string));
                } catch (JSONException e) {
                    OTLogger.m2743a(5, "IABHelper", "error while logging IAB encoder details : " + e.getMessage());
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m133a(C0045d c0045d, boolean z, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, String str) throws JSONException {
        String str2;
        boolean z2;
        boolean z3;
        if (jSONObject3.length() > 0) {
            OTLogger.m2743a(3, "IABHelper", "domain id contains overridden vendors");
            JSONArray jSONArrayNames = jSONObject3.names();
            if (jSONArrayNames != null) {
                for (int i = 0; i < jSONArrayNames.length(); i++) {
                    String string = jSONArrayNames.getString(i);
                    if (jSONObject2.has(string)) {
                        JSONObject jSONObject4 = jSONObject3.getJSONObject(string);
                        if (jSONObject4.getBoolean("active")) {
                            JSONObject jSONObject5 = jSONObject2.getJSONObject(string);
                            if (jSONObject4.has("disabledCP") && jSONObject5.has("purposes")) {
                                JSONArray jSONArray = jSONObject4.getJSONArray("disabledCP");
                                JSONArray jSONArray2 = jSONObject5.getJSONArray("purposes");
                                z2 = false;
                                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                    int iM296a = C0048h.m296a(jSONArray2, jSONArray.getInt(i2));
                                    if (iM296a > -1) {
                                        jSONArray2 = m119a(jSONArray2, iM296a);
                                        z2 = true;
                                    }
                                }
                                if (z2) {
                                    jSONObject5.put("purposes", jSONArray2);
                                }
                            } else {
                                z2 = false;
                            }
                            if (jSONObject4.has("disabledLIP") && jSONObject5.has("legIntPurposes")) {
                                JSONArray jSONArray3 = jSONObject4.getJSONArray("disabledLIP");
                                JSONArray jSONArray4 = jSONObject5.getJSONArray("legIntPurposes");
                                z3 = false;
                                for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                                    int iM296a2 = C0048h.m296a(jSONArray4, jSONArray3.getInt(i3));
                                    if (iM296a2 > -1) {
                                        jSONArray4 = m119a(jSONArray4, iM296a2);
                                        z3 = true;
                                    }
                                }
                                if (z3) {
                                    jSONObject5.put("legIntPurposes", jSONArray4);
                                }
                            } else {
                                z3 = false;
                            }
                            if (z2 || z3) {
                                jSONObject2.put(string, jSONObject5);
                            }
                        } else {
                            jSONObject2.remove(string);
                        }
                    }
                }
                m136a(jSONObject2, jSONObject, jSONObject3, str, z);
            }
            OTLogger.m2743a(4, "IABHelper", "IAB TCF Active Vendor list, applied overridden  vendors rules : " + jSONObject2.length() + " " + jSONObject2);
            str2 = "IAB TCF Active Vendor list,  applied toggle state : " + jSONObject2.length() + " " + jSONObject2;
        } else {
            OTLogger.m2743a(3, "IABHelper", "domain id using global vendor list");
            m136a(jSONObject2, jSONObject, jSONObject3, str, z);
            str2 = "IAB TCF Active Vendor list : " + jSONObject2.length() + " " + (!(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2));
        }
        OTLogger.m2743a(4, "IABHelper", str2);
        c0045d.m271a().edit().putString("OT_IAB_ACTIVE_VENDORLIST", !(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2)).apply();
        m120a(c0045d, jSONObject2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02da A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02dc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0317 A[Catch: Exception -> 0x0326, TryCatch #4 {Exception -> 0x0326, blocks: (B:76:0x0244, B:78:0x0251, B:80:0x0255, B:82:0x0261, B:84:0x028d, B:87:0x02a4, B:98:0x02c9, B:102:0x02d4, B:106:0x02de, B:108:0x0317, B:109:0x031a, B:90:0x02ab, B:92:0x02b5, B:81:0x025a), top: B:133:0x0244 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0085 A[Catch: Exception -> 0x032f, TryCatch #0 {Exception -> 0x032f, blocks: (B:12:0x007f, B:14:0x0085, B:16:0x00a7, B:17:0x00c6, B:18:0x00cd, B:20:0x00f0, B:44:0x019c, B:47:0x01a9, B:49:0x01af, B:73:0x0207, B:53:0x01c6, B:57:0x01d4, B:59:0x01da, B:71:0x01fe, B:64:0x01ec, B:67:0x01f4, B:74:0x0213), top: B:125:0x007f }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0125 A[Catch: Exception -> 0x032a, TryCatch #2 {Exception -> 0x032a, blocks: (B:30:0x011f, B:32:0x0125, B:34:0x012b, B:36:0x0138, B:38:0x013e, B:40:0x0149, B:42:0x0163, B:41:0x0150, B:29:0x011a, B:25:0x0111, B:20:0x00f0), top: B:129:0x00ee, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0150 A[Catch: Exception -> 0x032a, TryCatch #2 {Exception -> 0x032a, blocks: (B:30:0x011f, B:32:0x0125, B:34:0x012b, B:36:0x0138, B:38:0x013e, B:40:0x0149, B:42:0x0163, B:41:0x0150, B:29:0x011a, B:25:0x0111, B:20:0x00f0), top: B:129:0x00ee, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x019c A[Catch: Exception -> 0x032f, TRY_ENTER, TryCatch #0 {Exception -> 0x032f, blocks: (B:12:0x007f, B:14:0x0085, B:16:0x00a7, B:17:0x00c6, B:18:0x00cd, B:20:0x00f0, B:44:0x019c, B:47:0x01a9, B:49:0x01af, B:73:0x0207, B:53:0x01c6, B:57:0x01d4, B:59:0x01da, B:71:0x01fe, B:64:0x01ec, B:67:0x01f4, B:74:0x0213), top: B:125:0x007f }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0255 A[Catch: Exception -> 0x0326, TryCatch #4 {Exception -> 0x0326, blocks: (B:76:0x0244, B:78:0x0251, B:80:0x0255, B:82:0x0261, B:84:0x028d, B:87:0x02a4, B:98:0x02c9, B:102:0x02d4, B:106:0x02de, B:108:0x0317, B:109:0x031a, B:90:0x02ab, B:92:0x02b5, B:81:0x025a), top: B:133:0x0244 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x025a A[Catch: Exception -> 0x0326, TryCatch #4 {Exception -> 0x0326, blocks: (B:76:0x0244, B:78:0x0251, B:80:0x0255, B:82:0x0261, B:84:0x028d, B:87:0x02a4, B:98:0x02c9, B:102:0x02d4, B:106:0x02de, B:108:0x0317, B:109:0x031a, B:90:0x02ab, B:92:0x02b5, B:81:0x025a), top: B:133:0x0244 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x028d A[Catch: Exception -> 0x0326, TryCatch #4 {Exception -> 0x0326, blocks: (B:76:0x0244, B:78:0x0251, B:80:0x0255, B:82:0x0261, B:84:0x028d, B:87:0x02a4, B:98:0x02c9, B:102:0x02d4, B:106:0x02de, B:108:0x0317, B:109:0x031a, B:90:0x02ab, B:92:0x02b5, B:81:0x025a), top: B:133:0x0244 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02c6  */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r0v58 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r6v11, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m135a(android.content.Context r25, java.lang.String r26) {
        /*
            Method dump skipped, instruction units count: 847
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p007c.C0022q.m135a(android.content.Context, java.lang.String):void");
    }

    /* JADX INFO: renamed from: a */
    public void m134a(C0046e c0046e, JSONArray jSONArray) {
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = new OTPublishersHeadlessSDK(this.f44a);
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                jSONObject.put(jSONObject2.getString("CustomGroupId"), m127a(oTPublishersHeadlessSDK, jSONObject2));
            } catch (JSONException e) {
                OTLogger.m2743a(6, "IAB2V2Flow", "Error on parsing vendor count for categories : " + e.getMessage());
            }
        }
        JSONObject vendorListUI = oTPublishersHeadlessSDK.getVendorListUI(OTVendorListMode.IAB);
        if (vendorListUI != null) {
            try {
                jSONObject.put("activeIabVendorsCount", String.valueOf(vendorListUI.length()));
            } catch (JSONException e2) {
                OTLogger.m2743a(6, "IAB2V2Flow", "Error on setting active vendors count : " + e2.getMessage());
            }
        }
        OTLogger.m2743a(3, "IAB2V2Flow", "Setting vendorCountForCategoryString = " + jSONObject);
        c0046e.f97a.m271a().edit().putString("OT_VENDOR_COUNT_FOR_CATEGORIES", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)).apply();
    }
}
