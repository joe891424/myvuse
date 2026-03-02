package p000a.p001a.p002a.p003a.p004a.p007c;

import android.content.Context;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0032d;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;

/* JADX INFO: renamed from: a.a.a.a.a.c.y */
/* JADX INFO: loaded from: classes.dex */
public class C0030y {

    /* JADX INFO: renamed from: a */
    public Context f57a;

    /* JADX INFO: renamed from: b */
    public C0045d f58b;

    /* JADX INFO: renamed from: c */
    public C0031z f59c;

    public C0030y(Context context) {
        this.f57a = context;
        this.f58b = new C0045d(context, "OTT_DEFAULT_USER");
        this.f59c = new C0031z(context);
    }

    /* JADX INFO: renamed from: a */
    public void m212a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, String str, String str2, String str3) throws JSONException {
        if (jSONObject3.optString("userConsentStatus").equals(jSONObject3.optString("transactionType"))) {
            return;
        }
        jSONObject2.put("TopicId", str);
        jSONObject2.put("TransactionType", str2);
        jSONObject.put("TransactionType", str3);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:64|31|32|(8:68|35|36|76|37|88|33|78)|87|40|41|(1:43)(8:44|(1:46)|48|49|72|50|86|61)|47|48|49|72|50|86|61|29) */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012a, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r26v0, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v2, types: [int] */
    /* JADX WARN: Type inference failed for: r4v4, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r4v5, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m214a(org.json.JSONObject r23, org.json.JSONObject r24, org.json.JSONObject r25, org.json.JSONArray r26) {
        /*
            Method dump skipped, instruction units count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p007c.C0030y.m214a(org.json.JSONObject, org.json.JSONObject, org.json.JSONObject, org.json.JSONArray):void");
    }

    /* JADX INFO: renamed from: a */
    public final boolean m215a(String str, JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        boolean zM216a;
        int i = jSONObject.getInt("status");
        int iM237d = this.f59c.m237d(str);
        if (i != iM237d) {
            jSONObject.put("status", iM237d);
            zM216a = true;
        } else {
            zM216a = false;
        }
        JSONObject jSONObject3 = jSONObject.getJSONObject("topics");
        if (!C0032d.m240a(jSONObject3)) {
            JSONArray jSONArrayNames = jSONObject3.names();
            for (int i2 = 0; i2 < jSONObject3.length(); i2++) {
                String string = jSONArrayNames.getString(i2);
                int i3 = jSONObject3.getInt(string);
                int iM218a = this.f59c.m218a(string, str);
                if (i3 != iM218a) {
                    jSONObject3.put(string, iM218a);
                    zM216a = true;
                }
            }
        }
        JSONObject jSONObject4 = jSONObject.getJSONObject("custom_preferences");
        if (!C0032d.m240a(jSONObject4)) {
            for (int i4 = 0; i4 < jSONObject4.length(); i4++) {
                String string2 = jSONObject4.names().getString(i4);
                zM216a = m216a(str, zM216a, string2, jSONObject4.getJSONObject(string2));
            }
        }
        if (zM216a) {
            jSONObject2.put(str, jSONObject);
        }
        return zM216a;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m216a(String str, boolean z, String str2, JSONObject jSONObject) throws JSONException {
        for (int i = 0; i < jSONObject.length(); i++) {
            String string = jSONObject.names().getString(i);
            int i2 = jSONObject.getInt(string);
            int iM219a = this.f59c.m219a(string, str, str2);
            if (i2 != iM219a) {
                jSONObject.put(string, iM219a);
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    public void m213a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, String str, JSONArray jSONArray) throws JSONException {
        String str2;
        for (int i = 0; i < jSONObject.length(); i++) {
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(jSONObject.getJSONObject(jSONObject.names().get(i).toString()).optString("purposeTopicId"));
            String strOptString = jSONObjectOptJSONObject.optString("id");
            if (jSONObjectOptJSONObject.optString("purposeId").equals(str)) {
                if ((jSONObject3.optString("userConsentStatus").equals("ACTIVE") && jSONObject3.optString("transactionType").equals("OPT_OUT") && jSONObjectOptJSONObject.optString("transactionType").equals("OPT_IN")) || (jSONObject3.optString("userConsentStatus").equals("ACTIVE") && jSONObject3.optString("transactionType").equals("OPT_OUT") && jSONObjectOptJSONObject.optString("userConsentStatus").equals("OPT_IN"))) {
                    jSONObject4.put("TopicId", strOptString);
                    jSONObject2.put("TransactionType", "CONFIRMED");
                } else {
                    if (!jSONObject3.optString("userConsentStatus").equals("ACTIVE") || !jSONObject3.optString("transactionType").equals("ACTIVE") || !jSONObjectOptJSONObject.optString("userConsentStatus").equals("OPT_IN")) {
                        str2 = (jSONObject3.optString("userConsentStatus").equals("ACTIVE") && jSONObject3.optString("transactionType").equals("ACTIVE") && jSONObjectOptJSONObject.optString("userConsentStatus").equals("OPT_OUT")) ? "OPT_OUT" : "OPT_IN";
                    }
                    m212a(jSONObject2, jSONObject4, jSONObjectOptJSONObject, strOptString, str2, "CHANGE_PREFERENCES");
                }
                if (!(!(jSONObject4 instanceof JSONObject) ? jSONObject4.toString() : JSONObjectInstrumentation.toString(jSONObject4)).equals("{}")) {
                    jSONArray.put(jSONObject4);
                }
            }
        }
        jSONObject2.put("Preferences", jSONArray);
    }

    /* JADX INFO: renamed from: a */
    public JSONArray m211a() {
        String string = this.f58b.m271a().getString("OT_UC_PURPOSES_PURPOSE_SERVER_DATA", "");
        String string2 = this.f58b.m271a().getString("OT_UC_PURPOSES_CUSTOM_PREF_OPTIONS_SERVER_DATA", "");
        String string3 = this.f58b.m271a().getString("OT_UC_PURPOSES_TOPIC_SERVER_DATA", "");
        JSONArray jSONArray = new JSONArray();
        try {
            m214a(new JSONObject(string), new JSONObject(string2), new JSONObject(string3), jSONArray);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "UCPConsentLoggingData", "Error in fetching saved ucp data :" + e.getMessage());
        }
        OTLogger.m2743a(3, "UCPConsentLoggingData", "UCP consent payload :" + jSONArray);
        return jSONArray;
    }

    /* JADX INFO: renamed from: a */
    public static void m210a(JSONObject jSONObject, JSONObject jSONObject2, JSONArray jSONArray, JSONArray jSONArray2, JSONObject jSONObject3, JSONObject jSONObject4) throws JSONException {
        if ((!(jSONObject.optString("userConsentStatus").equals("ACTIVE") && jSONObject.optString("transactionType").equals("OPT_OUT")) && jSONObject.optString("userConsentStatus").equals("ACTIVE") && jSONObject.optString("transactionType").equals("ACTIVE")) ? !jSONObject4.optString("userConsentStatus").equals(jSONObject4.optString("transactionType")) : false) {
            jSONObject2.put("TransactionType", "CHANGE_PREFERENCES");
            jSONObject3.put("OptionId", jSONObject4.optString("id"));
            jSONObject3.put("TransactionType", jSONObject4.optString("userConsentStatus").equals("OPT_IN") ? "OPT_IN" : "OPT_OUT");
            jSONArray.put(jSONObject3);
            return;
        }
        if (!jSONObject.optString("userConsentStatus").equals("ACTIVE") || jSONObject2.getString("TransactionType").equals("CHANGE_PREFERENCES")) {
            return;
        }
        jSONObject2.put("TransactionType", "CONFIRMED");
        if (jSONObject4.getString("userConsentStatus").equals("OPT_IN")) {
            jSONArray2.put(jSONObject4.optString("id"));
        }
    }
}
