package p000a.p001a.p002a.p003a.p004a.p007c;

import android.content.Context;
import android.content.SharedPreferences;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;

/* JADX INFO: renamed from: a.a.a.a.a.c.p */
/* JADX INFO: loaded from: classes.dex */
public class C0021p {

    /* JADX INFO: renamed from: a */
    public final Context f43a;

    public C0021p(Context context) {
        this.f43a = context;
    }

    /* JADX INFO: renamed from: a */
    public static void m112a(JSONObject jSONObject, JSONObject jSONObject2, String str) throws JSONException {
        JSONArray jSONArrayNames = jSONObject2.names();
        if (jSONArrayNames != null) {
            for (int i = 0; i < jSONArrayNames.length(); i++) {
                String string = jSONArrayNames.getString(i);
                JSONObject jSONObject3 = jSONObject2.getJSONObject(string);
                if (jSONObject.has(string)) {
                    jSONObject3.put(OTVendorUtils.CONSENT_TYPE, jSONObject.getJSONObject(string).getInt(OTVendorUtils.CONSENT_TYPE));
                } else {
                    jSONObject3.put(OTVendorUtils.CONSENT_TYPE, str);
                }
                jSONObject2.put(string, jSONObject3);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public String m114a(JSONObject jSONObject) {
        return jSONObject.has("PCIABVendorsText") ? jSONObject.getString("PCIABVendorsText") : jSONObject.has("PCenterVendorsListText") ? jSONObject.getString("PCenterVendorsListText") : "";
    }

    /* JADX INFO: renamed from: a */
    public void m117a(SharedPreferences sharedPreferences, String str, String str2) {
        sharedPreferences.edit().putString(str2, str).apply();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0097 A[Catch: JSONException -> 0x00db, TryCatch #0 {JSONException -> 0x00db, blocks: (B:3:0x000c, B:5:0x0012, B:8:0x003c, B:12:0x004e, B:20:0x007c, B:22:0x0087, B:24:0x008d, B:25:0x0091, B:27:0x0097, B:28:0x009b, B:32:0x00a8, B:34:0x00b4, B:36:0x00ba, B:38:0x00c4, B:40:0x00d0, B:41:0x00d3, B:42:0x00d6, B:19:0x0077, B:18:0x0063, B:14:0x005a), top: B:53:0x000c, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b4 A[Catch: JSONException -> 0x00db, LOOP:0: B:34:0x00b4->B:41:0x00d3, LOOP_START, PHI: r6
      0x00b4: PHI (r6v2 int) = (r6v1 int), (r6v3 int) binds: [B:33:0x00b2, B:41:0x00d3] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {JSONException -> 0x00db, blocks: (B:3:0x000c, B:5:0x0012, B:8:0x003c, B:12:0x004e, B:20:0x007c, B:22:0x0087, B:24:0x008d, B:25:0x0091, B:27:0x0097, B:28:0x009b, B:32:0x00a8, B:34:0x00b4, B:36:0x00ba, B:38:0x00c4, B:40:0x00d0, B:41:0x00d3, B:42:0x00d6, B:19:0x0077, B:18:0x0063, B:14:0x005a), top: B:53:0x000c, inners: #1 }] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m115a(android.content.Context r11, p000a.p001a.p002a.p003a.p004a.p010g.C0045d r12, org.json.JSONObject r13, org.json.JSONObject r14) {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p007c.C0021p.m115a(android.content.Context, a.a.a.a.a.g.d, org.json.JSONObject, org.json.JSONObject):void");
    }

    /* JADX INFO: renamed from: a */
    public String m113a(Context context) throws JSONException {
        String string;
        try {
            string = new C0045d(context, "OTT_DEFAULT_USER").m271a().getString("OT_MOBILE_DATA", "");
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "error while getting mobile data json, err: " + e.getMessage());
        }
        JSONObject jSONObject = !C0048h.m305b(string) ? new JSONObject(string) : new JSONObject();
        if (jSONObject.has("preferenceCenterData")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("preferenceCenterData");
            if (jSONObject2.has("googleVendors")) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject("googleVendors");
                if (jSONObject3.has(OTVendorListMode.GENERAL)) {
                    return jSONObject3.getJSONObject(OTVendorListMode.GENERAL).getString("text");
                }
            }
        }
        return "";
    }

    /* JADX INFO: renamed from: a */
    public void m116a(Context context, String str) {
        JSONObject jSONObject;
        String string;
        OTLogger.m2743a(3, "GoogleVendorHelper", "Parsing Google vendor list.");
        if (C0048h.m305b(str)) {
            return;
        }
        C0045d c0045d = new C0045d(context, "OTT_DEFAULT_USER");
        String string2 = c0045d.m271a().getString("OT_GOOGLE_ACTIVE_VENDOR_LIST", null);
        JSONObject jSONObject2 = new JSONObject();
        if (!C0048h.m305b(string2)) {
            try {
                jSONObject2 = new JSONObject(string2);
            } catch (JSONException e) {
                OTLogger.m2743a(6, "GoogleVendorHelper", "Error on parsing google vendors on savedGoogleActiveVendorList, error = " + e.getMessage());
            }
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            e = e2;
        }
        try {
            SharedPreferences sharedPreferencesM271a = c0045d.m271a();
            if (jSONObject instanceof JSONObject) {
                string = JSONObjectInstrumentation.toString(jSONObject);
            } else {
                string = jSONObject.toString();
            }
            m117a(sharedPreferencesM271a, string, "OT_GOOGLE_GVL_COMPLETE_OBJECT");
        } catch (JSONException e3) {
            e = e3;
            jSONObject3 = jSONObject;
            OTLogger.m2743a(6, "GoogleVendorHelper", "Error on parsing google vendors on newGoogleActiveVendorList, error = " + e.getMessage());
            jSONObject = jSONObject3;
        }
        m115a(context, c0045d, jSONObject2, jSONObject);
    }
}
