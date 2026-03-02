package p000a.p001a.p002a.p003a.p004a.p007c;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;

/* JADX INFO: renamed from: a.a.a.a.a.c.g */
/* JADX INFO: loaded from: classes.dex */
public class C0012g {
    /* JADX INFO: renamed from: a */
    public static boolean m71a(JSONObject jSONObject, boolean z) {
        return jSONObject != null ? jSONObject.getBoolean("PAllowLI") : z;
    }

    /* JADX INFO: renamed from: a */
    public void m74a(JSONArray jSONArray, JSONObject jSONObject) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2.has("SubGroups") && jSONObject2.has("CustomGroupId") && !jSONObject2.getString("Status").contains(ReactScrollViewHelper.OVER_SCROLL_ALWAYS)) {
                    String string = jSONObject2.getString("CustomGroupId");
                    int i2 = jSONObject.getInt(string);
                    int iM70a = m70a(jSONObject, i2, jSONObject2, false, null, null);
                    if (i2 >= 0 && i2 != iM70a) {
                        jSONObject.put(string, iM70a);
                        OTLogger.m2743a(3, "OneTrust", "setting consent status of " + string + " to " + iM70a + "as per status configured for its subgroups");
                    }
                }
            } catch (JSONException e) {
                OTLogger.m2743a(6, "OneTrust", "error while setting default consent status of parent category,err: " + e.toString());
                return;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m73a(JSONArray jSONArray, C0022q c0022q, C0045d c0045d) {
        String string;
        try {
            String string2 = c0045d.m271a().getString("OTT_IAB_CONSENTABLE_PURPOSES", "");
            JSONObject jSONObject = new JSONObject();
            if (!C0048h.m305b(string2)) {
                jSONObject = new JSONObject(string2);
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2.has("SubGroups")) {
                    String strOptString = jSONObject2.optString("CustomGroupId", "-1");
                    int iM125a = c0022q.m125a(C0022q.m123b(strOptString), "purposeLegitimateInterests", "active", c0045d, false);
                    int iM70a = m70a(new JSONObject(), iM125a, jSONObject2, true, c0022q, c0045d);
                    if (jSONObject.has("purposeLegitimateInterests")) {
                        JSONObject jSONObject3 = jSONObject.getJSONObject("purposeLegitimateInterests");
                        if (iM125a >= 0 && iM125a != iM70a) {
                            jSONObject3.put(C0022q.m123b(strOptString), iM70a);
                            jSONObject.put("purposeLegitimateInterests", jSONObject3);
                            OTLogger.m2743a(3, "OneTrust", "setting LI status of " + strOptString + " to " + iM70a + "as per status configured for its subgroups");
                        }
                    }
                }
            }
            SharedPreferences.Editor editorEdit = c0045d.m271a().edit();
            if (jSONObject instanceof JSONObject) {
                string = JSONObjectInstrumentation.toString(jSONObject);
            } else {
                string = jSONObject.toString();
            }
            editorEdit.putString("OTT_IAB_CONSENTABLE_PURPOSES", string).apply();
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "error while setting default LI status of parent category,err: " + e.toString());
        }
    }

    /* JADX INFO: renamed from: a */
    public static int m70a(JSONObject jSONObject, int i, JSONObject jSONObject2, boolean z, C0022q c0022q, C0045d c0045d) throws JSONException {
        int iM125a;
        JSONArray jSONArray = jSONObject2.getJSONArray("SubGroups");
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            JSONObject jSONObject3 = jSONArray.getJSONObject(i4);
            if (jSONObject3.optString("Status", "").startsWith(ReactScrollViewHelper.OVER_SCROLL_ALWAYS)) {
                i3++;
                i2++;
            } else {
                String strOptString = jSONObject3.optString("CustomGroupId", "-1");
                if (!z || c0022q == null || c0045d == null) {
                    iM125a = jSONObject.has(strOptString) ? jSONObject.getInt(strOptString) : -1;
                } else {
                    iM125a = c0022q.m125a(C0022q.m123b(strOptString), "purposeLegitimateInterests", "active", c0045d, false);
                }
                if (iM125a == 0) {
                    return 0;
                }
                if (iM125a < 0) {
                    i3++;
                }
            }
        }
        if (i2 > 0) {
            if (i2 == jSONArray.length()) {
                return i;
            }
            return 1;
        }
        if (i3 == jSONArray.length()) {
            return i;
        }
        return 1;
    }

    /* JADX INFO: renamed from: a */
    public void m72a(String str, boolean z, JSONObject jSONObject, C0045d c0045d, Context context) {
        String string;
        try {
            JSONObject jSONObject2 = new JSONObject(c0045d.m271a().getString("OTT_CONSENT_STATUS", "{}"));
            JSONArray jSONArray = new JSONObject(str).getJSONArray("Groups");
            boolean zM71a = m71a(jSONObject, false);
            if (jSONArray != null && jSONArray.length() > 0) {
                m74a(jSONArray, jSONObject2);
                if (z && zM71a) {
                    m73a(jSONArray, new C0022q(context), c0045d);
                }
            }
            SharedPreferences.Editor editorEdit = c0045d.m271a().edit();
            if (jSONObject2 instanceof JSONObject) {
                string = JSONObjectInstrumentation.toString(jSONObject2);
            } else {
                string = jSONObject2.toString();
            }
            editorEdit.putString("OTT_CONSENT_STATUS", string).apply();
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "error while setting default status of parent category,err: " + e.toString());
        }
    }
}
