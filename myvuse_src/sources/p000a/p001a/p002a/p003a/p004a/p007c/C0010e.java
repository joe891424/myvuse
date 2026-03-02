package p000a.p001a.p002a.p003a.p004a.p007c;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTBroadcastServiceKeys;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;

/* JADX INFO: renamed from: a.a.a.a.a.c.e */
/* JADX INFO: loaded from: classes.dex */
public class C0010e {

    /* JADX INFO: renamed from: a */
    public Context f20a;

    public C0010e(Context context) {
        this.f20a = context;
    }

    /* JADX INFO: renamed from: a */
    public void m61a(String str, int i) {
        OTLogger.m2743a(4, "OTConsentChanges", "Sending " + str + " broadcast, value = " + i);
        Intent intent = new Intent(str);
        intent.putExtra(OTBroadcastServiceKeys.EVENT_STATUS, i);
        intent.setPackage(this.f20a.getApplicationContext().getPackageName());
        this.f20a.sendBroadcast(intent);
    }

    /* JADX INFO: renamed from: a */
    public void m62a(JSONObject jSONObject) {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        Context context = this.f20a;
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
        String string = sharedPreferences.getString("OT_GROUP_ID_OBJECT", "");
        if (C0048h.m305b(string)) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(string);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                int i = jSONObject.getInt(next);
                if (jSONObject2.has(next)) {
                    m61a(next, i);
                }
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OTConsentChanges", "error in broadcasting status. err = " + e.getMessage() + " changedConsents = " + (!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)));
        }
    }
}
