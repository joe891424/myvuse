package p000a.p001a.p002a.p003a.p004a;

import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: a.a.a.a.a.d */
/* JADX INFO: loaded from: classes.dex */
public class C0032d {
    /* JADX INFO: renamed from: a */
    public static JSONObject m238a(JSONObject jSONObject, String str) {
        try {
            if (jSONObject.has(str)) {
                return jSONObject.getJSONObject(str);
            }
            return null;
        } catch (JSONException e) {
            OTLogger.m2743a(6, "JSONUtils", "getObject failed: " + e);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m239a(JSONArray jSONArray) {
        return jSONArray == null || jSONArray.length() == 0;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m240a(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() == 0;
    }

    /* JADX INFO: renamed from: a */
    public void m241a(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        if (jSONObject2.has(str)) {
            try {
                jSONObject.put(str, jSONObject2.optString(str));
            } catch (JSONException e) {
                OTLogger.m2743a(6, "JSONUtils", "Error in parsing data. key = " + str + "Error message : " + e.getMessage());
            }
        }
    }
}
