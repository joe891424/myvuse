package p000a.p001a.p002a.p003a.p004a.p007c;

import android.content.Context;
import android.content.SharedPreferences;
import com.brentvatne.react.ReactVideoView;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p008e.C0033a;
import p000a.p001a.p002a.p003a.p004a.p009f.C0038b;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.C0046e;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;

/* JADX INFO: renamed from: a.a.a.a.a.c.i */
/* JADX INFO: loaded from: classes.dex */
public class C0014i {

    /* JADX INFO: renamed from: a */
    public C0045d f26a;

    /* JADX INFO: renamed from: b */
    public C0046e f27b;

    public C0014i(Context context) {
        C0045d c0045d = new C0045d(context, "OTT_DEFAULT_USER");
        this.f26a = c0045d;
        this.f27b = new C0046e(c0045d);
    }

    /* JADX INFO: renamed from: a */
    public String m77a() {
        return this.f26a.m271a().getString("OTT_CONSENT_LOG_DATA", "");
    }

    /* JADX INFO: renamed from: a */
    public void m79a(C0033a c0033a) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put(ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER, c0033a.f67b.f70c);
        jSONObject.put("purposes", c0033a.f67b.f69b);
        jSONObject.put("requestInformation", c0033a.f67b.f68a);
        jSONObject2.put("consentApi", c0033a.f66a);
        jSONObject2.put("consentPayload", jSONObject);
        OTLogger.m2743a(3, "consent data", "data" + jSONObject2);
        boolean z = jSONObject2 instanceof JSONObject;
        this.f26a.m271a().edit().putString("OTT_CONSENT_LOG_DATA", !z ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2)).apply();
        this.f26a.m271a().edit().putString("OT_CL_DEFAULT_PAYLOAD", !z ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2)).apply();
        if (this.f26a.m271a().getString("OT_CL_DEFAULT_PAYLOAD", "").isEmpty()) {
            return;
        }
        String string = this.f26a.m271a().getString("OT_CL_DEFAULT_PAYLOAD", "");
        String string2 = this.f26a.m271a().getString("OT_CL_DEFAULT_TRANSACTION_VALUES", "");
        JSONObject jSONObject3 = new JSONObject(string);
        jSONObject3.getJSONObject("consentPayload").put("purposes", new JSONArray(string2));
        OTLogger.m2743a(3, "consentLoggingDH", "default payload " + jSONObject3);
        this.f26a.m271a().edit().putString("OT_CL_DEFAULT_PAYLOAD", !(jSONObject3 instanceof JSONObject) ? jSONObject3.toString() : JSONObjectInstrumentation.toString(jSONObject3)).apply();
    }

    /* JADX INFO: renamed from: b */
    public void m82b() {
        String string;
        String string2;
        try {
            if (C0048h.m305b(m77a())) {
                return;
            }
            OTLogger.m2743a(4, "consentLoggingDH", "setting DSID to Consent payload");
            JSONObject jSONObject = new JSONObject(m77a());
            String strM282e = this.f27b.m282e();
            jSONObject.getJSONObject("consentPayload").put(ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER, strM282e);
            if (jSONObject instanceof JSONObject) {
                string = JSONObjectInstrumentation.toString(jSONObject);
            } else {
                string = jSONObject.toString();
            }
            this.f26a.m271a().edit().putString("OTT_CONSENT_LOG_DATA", string).apply();
            if (this.f26a.m271a().getString("OT_CL_DEFAULT_PAYLOAD", "").isEmpty()) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject(this.f26a.m271a().getString("OT_CL_DEFAULT_PAYLOAD", ""));
            jSONObject2.getJSONObject("consentPayload").put(ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER, strM282e);
            SharedPreferences.Editor editorEdit = this.f26a.m271a().edit();
            if (jSONObject2 instanceof JSONObject) {
                string2 = JSONObjectInstrumentation.toString(jSONObject2);
            } else {
                string2 = jSONObject2.toString();
            }
            editorEdit.putString("OT_CL_DEFAULT_PAYLOAD", string2).apply();
        } catch (Exception e) {
            OTLogger.m2743a(6, "consentLoggingDH", "error while setting DSID to consent payload" + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: a */
    public void m81a(String str) {
        this.f27b.f97a.m271a().edit().putString("OTT_DATA_SUBJECT_IDENTIFIER", str).apply();
    }

    /* JADX INFO: renamed from: a */
    public void m78a(int i) {
        this.f27b.f97a.m271a().edit().putInt("OTT_DATA_SUBJECT_IDENTIFIER_TYPE", i).apply();
    }

    /* JADX INFO: renamed from: a */
    public void m80a(Context context, String str) {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        OTLogger.m2743a(4, "consentLoggingDH", "override data subject identifier : " + str);
        JSONObject jSONObject = new JSONObject();
        if (this.f27b.m282e().equals(str)) {
            return;
        }
        m81a(str);
        m82b();
        if (!C0048h.m305b(m77a())) {
            jSONObject = new JSONObject(m77a());
        }
        if (jSONObject.length() > 0) {
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
            if (sharedPreferences.getInt("OTT_USER_CONSENT_STATUS", -1) == 1) {
                OTLogger.m2743a(4, "consentLoggingDH", "Consent logging with overridden data subject identifier");
                if (jSONObject.getJSONObject("consentPayload").getJSONArray("purposes").length() > 0) {
                    String string = jSONObject.getString("consentApi");
                    C0038b c0038b = new C0038b(context);
                    JSONObject jSONObject2 = jSONObject.getJSONObject("consentPayload");
                    c0038b.m254a("https://cookies2-ds.dev.otdev.org/request/v1/", string, !(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2), 1);
                }
            }
        }
    }
}
