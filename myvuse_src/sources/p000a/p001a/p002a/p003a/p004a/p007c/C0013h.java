package p000a.p001a.p002a.p003a.p004a.p007c;

import android.content.Context;
import android.content.SharedPreferences;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p009f.C0038b;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.C0046e;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;

/* JADX INFO: renamed from: a.a.a.a.a.c.h */
/* JADX INFO: loaded from: classes.dex */
public class C0013h {

    /* JADX INFO: renamed from: a */
    public final Context f24a;

    /* JADX INFO: renamed from: b */
    public final SharedPreferences f25b;

    public C0013h(Context context) {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        this.f24a = context;
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z = true;
        } else {
            sharedPreferencesC0047f = null;
        }
        this.f25b = z ? sharedPreferencesC0047f : sharedPreferences;
    }

    /* JADX INFO: renamed from: a */
    public void m75a(JSONObject jSONObject, boolean z) throws Throwable {
        String string;
        String string2;
        String string3;
        String string4 = this.f25b.getString("OTT_CONSENT_LOG_DATA", "");
        String string5 = this.f25b.getString("OT_CL_DEFAULT_PAYLOAD", "");
        String str = "consentLogging not initialized.";
        if (!C0048h.m305b(string4)) {
            if (!z || !new OTPublishersHeadlessSDK(this.f24a).shouldShowBanner()) {
                try {
                    JSONObject jSONObject2 = new JSONObject(string4);
                    if (m76a(jSONObject2, jSONObject, z)) {
                        C0045d c0045d = new C0045d(this.f24a, "OTT_DEFAULT_USER");
                        new C0046e(c0045d);
                        SharedPreferences.Editor editorEdit = c0045d.m271a().edit();
                        if (jSONObject2 instanceof JSONObject) {
                            string = JSONObjectInstrumentation.toString(jSONObject2);
                        } else {
                            string = jSONObject2.toString();
                        }
                        editorEdit.putString("OTT_CONSENT_LOG_DATA", string).apply();
                        String string6 = jSONObject2.getString("consentApi");
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("consentPayload");
                        if (jSONObject3 instanceof JSONObject) {
                            string2 = JSONObjectInstrumentation.toString(jSONObject3);
                        } else {
                            string2 = jSONObject3.toString();
                        }
                        OTLogger.m2743a(4, "ConsentLogging", "payloadObj" + string2);
                        OTLogger.m2743a(4, "ConsentLogging", "consent obj" + jSONObject2);
                        new C0038b(this.f24a).m254a("https://cookies2-ds.dev.otdev.org/request/v1/", string6, string2, 1);
                        return;
                    }
                    return;
                } catch (JSONException e) {
                    OTLogger.m2743a(6, "ConsentLogging", "error in reading old consent data. error - " + e.getMessage());
                    return;
                }
            }
            try {
                if (C0048h.m305b(string5)) {
                    OTLogger.m2743a(5, "ConsentLogging", "consentLogging not initialized.");
                    return;
                }
                JSONObject jSONObject4 = new JSONObject(string5);
                OTLogger.m2743a(4, "ConsentLogging", "payloadObj default" + jSONObject4.getJSONObject("consentPayload"));
                OTLogger.m2743a(4, "ConsentLogging", "consent obj default" + jSONObject4);
                C0038b c0038b = new C0038b(this.f24a);
                String string7 = jSONObject4.getString("consentApi");
                JSONObject jSONObject5 = jSONObject4.getJSONObject("consentPayload");
                if (jSONObject5 instanceof JSONObject) {
                    string3 = JSONObjectInstrumentation.toString(jSONObject5);
                } else {
                    string3 = jSONObject5.toString();
                }
                c0038b.m254a("https://cookies2-ds.dev.otdev.org/request/v1/", string7, string3, 1);
                return;
            } catch (JSONException e2) {
                str = "Error while logging consent for default values." + e2.getMessage();
            }
        }
        OTLogger.m2743a(5, "ConsentLogging", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00f5  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m76a(org.json.JSONObject r20, org.json.JSONObject r21, boolean r22) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p007c.C0013h.m76a(org.json.JSONObject, org.json.JSONObject, boolean):boolean");
    }
}
