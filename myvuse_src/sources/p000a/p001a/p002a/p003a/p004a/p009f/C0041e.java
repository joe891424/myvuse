package p000a.p001a.p002a.p003a.p004a.p009f;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.onetrust.otpublishers.headless.Public.OTCallback;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p007c.C0021p;
import p000a.p001a.p002a.p003a.p004a.p007c.C0022q;
import retrofit2.Response;

/* JADX INFO: renamed from: a.a.a.a.a.f.e */
/* JADX INFO: loaded from: classes.dex */
public class C0041e {
    /* JADX INFO: renamed from: a */
    public void m262a(Context context, OTPublishersHeadlessSDK oTPublishersHeadlessSDK, JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4 = jSONObject.has("otData") ? jSONObject.getJSONObject("otData") : null;
        if (jSONObject.has("vendorListData")) {
            JSONObject jSONObject5 = jSONObject.getJSONObject("vendorListData");
            jSONObject3 = jSONObject5.has("iabData") ? jSONObject5.getJSONObject("iabData") : null;
            jSONObject2 = jSONObject5.has("googleData") ? jSONObject5.getJSONObject("googleData") : null;
        } else {
            jSONObject2 = null;
            jSONObject3 = null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", "") == null) {
            String string = sharedPreferences.getString("OT_GENERIC_PROFILE_IDENTIFIER", null);
            if (C0048h.m305b(string)) {
                string = UUID.randomUUID().toString();
                sharedPreferences.edit().putString("OT_GENERIC_PROFILE_IDENTIFIER", string).apply();
            }
            sharedPreferences.edit().putString("OT_ACTIVE_PROFILE_ID", string.toLowerCase(Locale.US)).apply();
        }
        if (jSONObject4 != null) {
            new C0038b(context).m257a((Response<String>) null, !(jSONObject4 instanceof JSONObject) ? jSONObject4.toString() : JSONObjectInstrumentation.toString(jSONObject4), (OTCallback) null, (Handler) null, oTPublishersHeadlessSDK, false);
        }
        if (jSONObject3 != null) {
            new C0022q(context).m135a(context, !(jSONObject3 instanceof JSONObject) ? jSONObject3.toString() : JSONObjectInstrumentation.toString(jSONObject3));
        }
        if (jSONObject2 != null) {
            new C0021p(context).m116a(context, !(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2));
        }
    }
}
