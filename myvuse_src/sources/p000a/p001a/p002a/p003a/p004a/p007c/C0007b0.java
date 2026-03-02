package p000a.p001a.p002a.p003a.p004a.p007c;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTGppKeys;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABCCPAKeys;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABTCFKeys;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0032d;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;

/* JADX INFO: renamed from: a.a.a.a.a.c.b0 */
/* JADX INFO: loaded from: classes.dex */
public class C0007b0 {

    /* JADX INFO: renamed from: a */
    public Context f18a;

    public C0007b0(Context context) {
        this.f18a = context;
    }

    /* JADX INFO: renamed from: a */
    public static void m40a(JSONObject jSONObject, String str, Object obj, JSONObject jSONObject2) throws JSONException {
        if (str.equals(jSONObject2.optString("CustomGroupId", "")) && "COOKIE".equals(jSONObject2.getString("Type")) && !jSONObject2.getBoolean("IsIabPurpose")) {
            jSONObject.put(str, obj);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m43a(JSONObject jSONObject) throws JSONException {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        boolean z;
        Context context = this.f18a;
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
        String string = sharedPreferences.getString("OTT_ALWAYS_ACTIVE_GROUPS", "");
        if (C0048h.m305b(string)) {
            return;
        }
        JSONArray jSONArrayNames = new JSONObject(string).names();
        if (C0032d.m239a(jSONArrayNames)) {
            return;
        }
        for (int i = 0; i < jSONArrayNames.length(); i++) {
            String string2 = jSONArrayNames.getString(i);
            if (!string2.startsWith("ISPV2") && !string2.startsWith("IFEV2")) {
                jSONObject.put(string2, 1);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final String m42a(boolean z) {
        boolean z2;
        SharedPreferencesC0047f sharedPreferencesC0047f;
        JSONObject jSONObject = new JSONObject();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f18a);
        try {
            JSONObject preferenceCenterData = new OTPublishersHeadlessSDK(this.f18a).getPreferenceCenterData();
            if (preferenceCenterData == null) {
                OTLogger.m2743a(5, "WebviewConsentHelper", "Consent for WebView: No app data found, returning empty JSON.");
            } else {
                JSONArray jSONArray = preferenceCenterData.getJSONArray("Groups");
                Context context = this.f18a;
                boolean z3 = false;
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                SharedPreferencesC0047f sharedPreferencesC0047f2 = null;
                String str = "";
                if (C0026u.m181a(context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0).getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                    sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                    z2 = true;
                } else {
                    z2 = false;
                    sharedPreferencesC0047f = null;
                }
                if (z2) {
                    sharedPreferences = sharedPreferencesC0047f;
                }
                jSONObject.put("groups", m41a(sharedPreferences.getString("OTT_CONSENT_STATUS", ""), jSONArray).replace("{", "").replace("}", "").replace("\"", ""));
                jSONObject.put("USPrivacy", defaultSharedPreferences.getString(OTIABCCPAKeys.OT_IAB_US_PRIVACY_STRING, ""));
                if (z) {
                    Context context2 = this.f18a;
                    SharedPreferences sharedPreferences2 = context2.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                    if (C0026u.m181a(new C0045d(context2, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                        sharedPreferencesC0047f2 = new SharedPreferencesC0047f(context2, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", ""));
                        z3 = true;
                    }
                    if (z3) {
                        sharedPreferences2 = sharedPreferencesC0047f2;
                    }
                    long jLongValue = Long.valueOf(sharedPreferences2.getString("OTT_LAST_GIVEN_CONSENT", "0")).longValue();
                    TimeZone timeZone = TimeZone.getTimeZone("GMT");
                    SimpleDateFormat simpleDateFormatM309d = C0048h.m309d("EEE, dd MMM yyyy HH:mm:ss z");
                    simpleDateFormatM309d.setTimeZone(timeZone);
                    Date date = new Date();
                    date.setTime(jLongValue);
                    jSONObject.put("consentedDate", simpleDateFormatM309d.format(date));
                    jSONObject.put("addtlString", defaultSharedPreferences.getString(OTIABTCFKeys.IABTCF_ADD_TL_CONSENT, ""));
                    SharedPreferences defaultSharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(this.f18a);
                    String string = defaultSharedPreferences2.getString(OTGppKeys.IAB_GPP_TCFEU2_STRING, "");
                    if (C0048h.m305b(string)) {
                        string = defaultSharedPreferences2.getString(OTIABTCFKeys.IABTCF_TCSTRING, "");
                    }
                    if (!C0048h.m305b(string)) {
                        str = string;
                    }
                } else {
                    jSONObject.put("consentedDate", "");
                    jSONObject.put("addtlString", "");
                }
                jSONObject.put("tcString", str);
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "WebviewConsentHelper", "Error on constructing webviewConsentObject. Error msg = " + e.getMessage());
        }
        String str2 = "var OTExternalConsent = " + (!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
        OTLogger.m2743a(3, "WebviewConsentHelper", "ConsentForWebView :" + str2);
        return str2;
    }

    /* JADX INFO: renamed from: a */
    public String m41a(String str, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject(str);
        OTLogger.m2743a(3, "WebviewConsentHelper", "OTSDK consented group and status = " + str);
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                Object obj = jSONObject.get(next);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                    if (jSONObject3.has("SubGroups")) {
                        JSONArray jSONArray2 = jSONObject3.getJSONArray("SubGroups");
                        m40a(jSONObject2, next, obj, jSONObject3);
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            m40a(jSONObject2, next, obj, jSONArray2.getJSONObject(i2));
                        }
                    } else {
                        m40a(jSONObject2, next, obj, jSONObject3);
                    }
                }
                m43a(jSONObject2);
            } catch (JSONException e) {
                OTLogger.m2743a(6, "WebviewConsentHelper", "Error on parsing. Error msg = " + e.getMessage());
            }
        }
        return !(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2);
    }
}
