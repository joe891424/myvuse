package p000a.p001a.p002a.p003a.p004a.p007c;

import android.content.SharedPreferences;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0032d;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;

/* JADX INFO: renamed from: a.a.a.a.a.c.d */
/* JADX INFO: loaded from: classes.dex */
public class C0009d {
    /* JADX INFO: renamed from: a */
    public static JSONArray m51a(JSONObject jSONObject, JSONArray jSONArray) {
        return jSONObject.has("consentPayload") ? jSONObject.getJSONObject("consentPayload").getJSONArray("purposes") : jSONArray;
    }

    /* JADX INFO: renamed from: a */
    public static void m53a(JSONObject jSONObject, JSONObject jSONObject2, String str, JSONArray jSONArray) throws JSONException {
        if (jSONObject2.has(str)) {
            String string = jSONObject2.getString(str);
            jSONObject2.remove(str);
            if (jSONObject.has(string)) {
                jSONObject.remove(string);
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                if (string.equals(jSONArray.getString(i))) {
                    jSONArray.remove(i);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m55a(JSONObject jSONObject, boolean z) {
        if (jSONObject.optBoolean("IsIabPurpose") && jSONObject.optString("Status", "").contains(ReactScrollViewHelper.OVER_SCROLL_ALWAYS)) {
            return true;
        }
        return !z ? jSONObject.optBoolean("HasConsentOptOut") : jSONObject.optBoolean("HasConsentOptOut") || jSONObject.optBoolean("HasLegIntOptOut");
    }

    /* JADX INFO: renamed from: a */
    public String m56a(C0045d c0045d) {
        String string = c0045d.m271a().getString("OT_TEMPLATE_TYPE", "");
        return C0048h.m305b(string) ? "" : string;
    }

    /* JADX INFO: renamed from: a */
    public void m58a(String str, JSONObject jSONObject) {
        try {
            JSONArray jSONArrayM51a = m51a(jSONObject, new JSONArray());
            for (int i = 0; i < jSONArrayM51a.length(); i++) {
                if (str.equalsIgnoreCase(jSONArrayM51a.getJSONObject(i).getString("Id"))) {
                    jSONArrayM51a.getJSONObject(i).put("TransactionType", "OPT_OUT");
                }
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "exception while changing no  LI toggle purposes from saved Consent data" + e.toString());
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m59a(JSONObject jSONObject) {
        return jSONObject.optString("IabType").equals("IAB2");
    }

    /* JADX INFO: renamed from: b */
    public boolean m60b(C0045d c0045d) {
        return "IAB2".equalsIgnoreCase(m56a(c0045d));
    }

    /* JADX INFO: renamed from: a */
    public static boolean m54a(JSONObject jSONObject, String str) {
        if (!C0048h.m305b(str)) {
            try {
                JSONArray jSONArrayNames = new JSONObject(str).names();
                if (jSONArrayNames == null) {
                    return true;
                }
                for (int i = 0; i < jSONArrayNames.length(); i++) {
                    jSONObject.put(jSONArrayNames.getString(i).toLowerCase(), -1);
                }
            } catch (JSONException e) {
                OTLogger.m2743a(6, "AppDataUtils", "checkAndUpdateConsentMap: " + e);
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public static void m52a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            JSONArray jSONArrayM51a = m51a(jSONObject, jSONArray);
            JSONArray jSONArrayM51a2 = m51a(jSONObject2, jSONArray2);
            for (int i = 0; i < jSONArrayM51a.length(); i++) {
                Locale locale = Locale.ENGLISH;
                if (str.toLowerCase(locale).equals(jSONArrayM51a.getJSONObject(i).getString("Id").toLowerCase(locale))) {
                    jSONArrayM51a.remove(i);
                }
                if (str.toLowerCase(locale).equals(jSONArrayM51a2.getJSONObject(i).getString("Id").toLowerCase(locale))) {
                    jSONArrayM51a2.remove(i);
                }
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "exception while removing no toggle purposes from saved Consent data" + e.toString());
        }
    }

    /* JADX INFO: renamed from: a */
    public void m57a(SharedPreferences sharedPreferences, boolean z, JSONArray jSONArray, JSONArray jSONArray2, boolean z2) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        if (!z || !z2 || C0032d.m239a(jSONArray)) {
            OTLogger.m2743a(3, "OneTrust", "No changes in purpose toggle configurations found");
            return;
        }
        String string6 = sharedPreferences.getString("OTT_CONSENT_STATUS", "{}");
        String string7 = sharedPreferences.getString("OTT_INTERNAL_PURPOSE_GROUP_MAP", "{}");
        String string8 = sharedPreferences.getString("OTT_CONSENTABLE_PARENT_GROUPS", "{}");
        String string9 = sharedPreferences.getString("OTT_CONSENT_LOG_DATA", "{}");
        String string10 = sharedPreferences.getString("OT_CL_DEFAULT_PAYLOAD", "{}");
        try {
            JSONObject jSONObject = new JSONObject(string6);
            JSONObject jSONObject2 = new JSONObject(string7);
            JSONArray jSONArray3 = new JSONArray(string8);
            JSONObject jSONObject3 = new JSONObject(string9);
            JSONObject jSONObject4 = new JSONObject(string10);
            for (int i = 0; i < jSONArray.length(); i++) {
                String string11 = jSONArray.getString(i);
                m53a(jSONObject, jSONObject2, string11, jSONArray3);
                m52a(string11, jSONObject3, jSONObject4);
            }
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                String string12 = jSONArray.getString(i2);
                m53a(jSONObject, jSONObject2, string12, jSONArray3);
                try {
                    m58a(string12, jSONObject3);
                } catch (JSONException e) {
                    e = e;
                    OTLogger.m2743a(6, "OneTrust", "exception while removing no toggle purposes from saved Data " + e.toString());
                    return;
                }
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (jSONObject instanceof JSONObject) {
                string = JSONObjectInstrumentation.toString(jSONObject);
            } else {
                string = jSONObject.toString();
            }
            editorEdit.putString("OTT_CONSENT_STATUS", string);
            if (jSONObject2 instanceof JSONObject) {
                string2 = JSONObjectInstrumentation.toString(jSONObject2);
            } else {
                string2 = jSONObject2.toString();
            }
            editorEdit.putString("OTT_INTERNAL_PURPOSE_GROUP_MAP", string2);
            if (jSONArray3 instanceof JSONArray) {
                string3 = JSONArrayInstrumentation.toString(jSONArray3);
            } else {
                string3 = jSONArray3.toString();
            }
            editorEdit.putString("OTT_PARENT_GROUPS", string3);
            if (jSONObject3 instanceof JSONObject) {
                string4 = JSONObjectInstrumentation.toString(jSONObject3);
            } else {
                string4 = jSONObject3.toString();
            }
            editorEdit.putString("OTT_CONSENT_LOG_DATA", string4);
            if (jSONObject4 instanceof JSONObject) {
                string5 = JSONObjectInstrumentation.toString(jSONObject4);
            } else {
                string5 = jSONObject4.toString();
            }
            editorEdit.putString("OT_CL_DEFAULT_PAYLOAD", string5);
            editorEdit.apply();
        } catch (JSONException e2) {
            e = e2;
        }
    }
}
