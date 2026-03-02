package p000a.p001a.p002a.p003a.p004a.p007c;

import android.content.Context;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0032d;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.C0046e;

/* JADX INFO: renamed from: a.a.a.a.a.c.a0 */
/* JADX INFO: loaded from: classes.dex */
public class C0005a0 {
    /* JADX INFO: renamed from: a */
    public static void m1a(C0045d c0045d, JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject.has("IabV2Data") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("IabV2Data")) != null && jSONObjectOptJSONObject.has("vendorListVersion")) {
            c0045d.m271a().edit().putInt("OT_DOMAIN_DATA_IAB_VENDOR_LIST_VERSION", Integer.parseInt(jSONObjectOptJSONObject.optString("vendorListVersion"))).apply();
        }
    }

    /* JADX INFO: renamed from: a */
    public JSONObject m4a(JSONObject jSONObject, String str, String str2) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("id", str);
        jSONObject2.put("name", str2);
        jSONObject.put(str, jSONObject2);
        return jSONObject;
    }

    /* JADX INFO: renamed from: a */
    public void m6a(JSONObject jSONObject, C0046e c0046e) {
        if (jSONObject.length() == 0) {
            return;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("Groups");
            if (C0032d.m239a(jSONArray)) {
                return;
            }
            m5a(c0046e, jSONArray);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "VendorUtils", "error while constructing IAB purposes object, err:" + e.toString());
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m7a(JSONObject jSONObject) {
        if (jSONObject.isNull("LegIntSettings") || !jSONObject.getJSONObject("LegIntSettings").has("PAllowLI")) {
            return true;
        }
        return jSONObject.getJSONObject("LegIntSettings").getBoolean("PAllowLI");
    }

    /* JADX INFO: renamed from: a */
    public static void m2a(JSONObject jSONObject, JSONObject jSONObject2, String str) throws JSONException {
        String str2;
        OTLogger.m2743a(2, "VendorUtils", "getting details of " + str + "from GVL");
        JSONArray jSONArray = new JSONArray();
        if (str.equals("legIntPurposes") || str.equals("flexiblePurposes")) {
            OTLogger.m2743a(2, "VendorUtils", "contains legIntPurposes/flexiblePurposes details");
            str2 = "purposes";
        } else {
            str2 = str;
        }
        for (int i = 0; i < jSONObject2.getJSONArray(str).length(); i++) {
            jSONArray.put(jSONObject.getJSONObject(str2).get(jSONObject2.getJSONArray(str).get(i).toString()));
        }
        jSONObject2.put(str, jSONArray);
    }

    /* JADX INFO: renamed from: a */
    public JSONObject m3a(Context context, int i, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
        C0046e c0046e = new C0046e(context);
        String strM285g = c0046e.m285g();
        boolean zM7a = m7a(c0046e.m280d());
        if (C0048h.m305b(strM285g)) {
            m6a(c0046e.m280d(), c0046e);
            strM285g = c0046e.m285g();
        }
        if (!C0048h.m305b(strM285g)) {
            try {
                JSONObject jSONObject3 = new JSONObject(strM285g);
                if (jSONObject2.getJSONArray("purposes").length() > 0) {
                    m2a(jSONObject3, jSONObject2, "purposes");
                }
                if (jSONObject2.getJSONArray("legIntPurposes").length() > 0 && zM7a) {
                    m2a(jSONObject3, jSONObject2, "legIntPurposes");
                } else if (!zM7a) {
                    jSONObject2.put("legIntPurposes", new JSONArray());
                }
                if (jSONObject2.getJSONArray("specialFeatures").length() > 0) {
                    m2a(jSONObject3, jSONObject2, "specialFeatures");
                }
                if (jSONObject2.getJSONArray("specialPurposes").length() > 0) {
                    m2a(jSONObject3, jSONObject2, "specialPurposes");
                }
                if (jSONObject2.getJSONArray("features").length() > 0) {
                    m2a(jSONObject3, jSONObject2, "features");
                }
                if (jSONObject2.getJSONArray("flexiblePurposes").length() > 0) {
                    m2a(jSONObject3, jSONObject2, "flexiblePurposes");
                }
                OTLogger.m2743a(4, "VendorUtils", "Vendor details for ID " + i + " : " + jSONObject2);
                return jSONObject2;
            } catch (Exception e) {
                OTLogger.m2743a(6, "VendorUtils", "Could not fetch Vendor details for ID " + i + " : " + e.getMessage());
                return null;
            }
        }
        OTLogger.m2743a(5, "VendorUtils", "Empty Vendor List to fetch Details");
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void m5a(C0046e c0046e, JSONArray jSONArray) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        JSONObject jSONObject5 = new JSONObject();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject6 = jSONArray.getJSONObject(i);
            if (jSONObject6.getBoolean("IsIabPurpose")) {
                String strM123b = C0022q.m123b(jSONObject6.optString("CustomGroupId", "-1"));
                String string = jSONObject6.getString("Type");
                String string2 = jSONObject6.getString("GroupName");
                if (string.equals("IAB2_PURPOSE")) {
                    jSONObject4 = m4a(jSONObject4, strM123b, string2);
                }
                if (string.equals("IAB2_FEATURE")) {
                    jSONObject2 = m4a(jSONObject2, strM123b, string2);
                }
                if (string.equals("IAB2_SPL_PURPOSE")) {
                    jSONObject5 = m4a(jSONObject5, strM123b, string2);
                }
                if (string.equals("IAB2_SPL_FEATURE")) {
                    jSONObject3 = m4a(jSONObject3, strM123b, string2);
                }
            }
        }
        jSONObject.put("features", jSONObject2);
        jSONObject.put("purposes", jSONObject4);
        jSONObject.put("specialFeatures", jSONObject3);
        jSONObject.put("specialPurposes", jSONObject5);
        c0046e.f97a.m271a().edit().putString("OT_IAB_PURPOSES_TRANSLATED", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)).apply();
    }
}
