package p000a.p001a.p002a.p003a.p004a.p007c;

import android.content.Context;
import android.content.SharedPreferences;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p008e.C0033a;
import p000a.p001a.p002a.p003a.p004a.p008e.C0034b;
import p000a.p001a.p002a.p003a.p004a.p008e.C0036d;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;

/* JADX INFO: renamed from: a.a.a.a.a.c.c */
/* JADX INFO: loaded from: classes.dex */
public class C0008c {

    /* JADX INFO: renamed from: a */
    public C0045d f19a;

    public C0008c(C0045d c0045d) {
        this.f19a = c0045d;
    }

    /* JADX INFO: renamed from: a */
    public void m50a(boolean z, String str, String str2) {
        if (z) {
            OTLogger.m2743a(3, "AppDataParser", str + str2);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m46a(JSONObject jSONObject, JSONArray jSONArray, Context context) throws JSONException {
        String str;
        C0033a c0033a = new C0033a();
        C0034b c0034b = new C0034b();
        if (jSONObject.getJSONObject("culture").getJSONObject("CommonData").has("ConsentIntegration")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("culture").getJSONObject("CommonData").getJSONObject("ConsentIntegration");
            if (jSONObject2.optString("ConsentApi") != null) {
                C0045d c0045d = new C0045d(context, "OTT_DEFAULT_USER");
                String string = "";
                String string2 = c0045d.m271a().getString("OTT_DATA_SUBJECT_IDENTIFIER", "");
                if (string2 == null) {
                    string2 = "";
                }
                if (C0048h.m305b(string2)) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                    string = sharedPreferences.getString("OT_GENERIC_PROFILE_IDENTIFIER", null);
                    if (C0048h.m305b(string)) {
                        string = UUID.randomUUID().toString();
                        sharedPreferences.edit().putString("OT_GENERIC_PROFILE_IDENTIFIER", string).apply();
                    }
                    c0045d.m271a().edit().putString("OTT_DATA_SUBJECT_IDENTIFIER", string).apply();
                    c0045d.m271a().edit().putInt("OTT_DATA_SUBJECT_IDENTIFIER_TYPE", 1).apply();
                } else {
                    String string3 = c0045d.m271a().getString("OTT_DATA_SUBJECT_IDENTIFIER", "");
                    if (string3 != null) {
                        string = string3;
                    }
                }
                c0034b.f70c = string;
                c0034b.f69b = jSONArray;
                c0034b.f68a = jSONObject2.optString("RequestInformation");
                c0033a.f66a = jSONObject2.optString("ConsentApi");
                c0033a.f67b = c0034b;
                try {
                    new C0014i(context).m79a(c0033a);
                    return;
                } catch (Exception unused) {
                    str = "could not construct consent logging data";
                }
            } else {
                str = "error while constructing consent payload";
            }
            OTLogger.m2743a(4, "AppDataParser", str);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m45a(JSONObject jSONObject, boolean z) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONObject("culture").getJSONObject("DomainData").getJSONArray("Groups");
        for (int i = 0; i < jSONArray.length(); i++) {
            if (!jSONArray.getJSONObject(i).getString("Parent").isEmpty()) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String string = jSONArray.getJSONObject(i).getString("Parent");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    try {
                        if (string.equals(jSONArray.getJSONObject(i2).optString("CustomGroupId"))) {
                            m44a(jSONArray, jSONObject2, i2, z);
                        }
                    } catch (JSONException e) {
                        OTLogger.m2743a(6, "AppDataParser", "error while moving subgroups with err = " + e.getMessage());
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m47a(boolean z, SharedPreferences sharedPreferences, JSONObject jSONObject, C0036d c0036d) throws JSONException {
        if (jSONObject.has("DomainData")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("DomainData");
            boolean z2 = jSONObject2 instanceof JSONObject;
            m50a(z, "culture data : ", !z2 ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2));
            sharedPreferences.edit().putString("OTT_CULTURE_DOMAIN_DATA", !z2 ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2)).apply();
            if (jSONObject2.has("LastReconsentDate") && c0036d.m244a() == -1) {
                String string = !jSONObject2.isNull("LastReconsentDate") ? jSONObject2.get("LastReconsentDate").toString() : "";
                OTLogger.m2743a(4, "ShowBanner", "Initializing the last re-consent date to - " + string);
                if (C0048h.m305b(string) || jSONObject2.isNull("LastReconsentDate")) {
                    c0036d.f75b.edit().putString("OTT_LAST_RE_CONSENT_DATE", "0").apply();
                } else {
                    c0036d.m245a(string);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c6  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m49a(boolean r8, android.content.SharedPreferences r9, org.json.JSONObject r10, android.content.Context r11, p000a.p001a.p002a.p003a.p004a.p010g.C0046e r12, boolean r13, boolean r14) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 563
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p007c.C0008c.m49a(boolean, android.content.SharedPreferences, org.json.JSONObject, android.content.Context, a.a.a.a.a.g.e, boolean, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0144  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m48a(boolean r18, android.content.SharedPreferences r19, org.json.JSONObject r20, android.content.Context r21, p000a.p001a.p002a.p003a.p004a.p010g.C0046e r22) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 441
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p007c.C0008c.m48a(boolean, android.content.SharedPreferences, org.json.JSONObject, android.content.Context, a.a.a.a.a.g.e):void");
    }

    /* JADX INFO: renamed from: a */
    public static void m44a(JSONArray jSONArray, JSONObject jSONObject, int i, boolean z) throws JSONException {
        if (!(jSONObject.getBoolean("IsIabPurpose") && jSONObject.getBoolean("ShowInPopup") && C0009d.m55a(jSONObject, z)) && jSONObject.getJSONArray("FirstPartyCookies").length() <= 0) {
            return;
        }
        if (jSONArray.getJSONObject(i).has("SubGroups")) {
            jSONArray.getJSONObject(i).getJSONArray("SubGroups").put(jSONObject);
            return;
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(jSONObject);
        jSONArray.getJSONObject(i).put("SubGroups", jSONArray2);
    }
}
