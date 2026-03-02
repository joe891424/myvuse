package p000a.p001a.p002a.p003a.p004a.p007c;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTBroadcastServiceKeys;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.C0046e;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;

/* JADX INFO: renamed from: a.a.a.a.a.c.w */
/* JADX INFO: loaded from: classes.dex */
public class C0028w {

    /* JADX INFO: renamed from: a */
    public SharedPreferences f51a;

    /* JADX INFO: renamed from: b */
    public C0046e f52b;

    /* JADX INFO: renamed from: c */
    public JSONObject f53c = new JSONObject();

    /* JADX INFO: renamed from: d */
    public Context f54d;

    public C0028w(Context context) {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        this.f54d = context;
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z = true;
        } else {
            sharedPreferencesC0047f = null;
        }
        this.f51a = z ? sharedPreferencesC0047f : sharedPreferences;
        this.f52b = new C0046e(this.f54d);
    }

    /* JADX INFO: renamed from: a */
    public String m191a(String str) {
        String str2 = "";
        try {
            JSONObject jSONObject = new JSONObject(this.f51a.getString("OTT_INTERNAL_SDK_GROUP_MAP", ""));
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (jSONObject.get(next).toString().contains(str)) {
                    str2 = next;
                }
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "SdkListHelper", "Error while fetching groupId by sdkId : " + e.getMessage());
        }
        return str2;
    }

    /* JADX INFO: renamed from: b */
    public JSONArray m193b(String str) {
        String string = this.f51a.getString("OTT_INTERNAL_SDK_GROUP_MAP", "");
        JSONArray jSONArray = new JSONArray();
        if (C0048h.m305b(string)) {
            return jSONArray;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            return jSONObject.has(str) ? new JSONArray(jSONObject.get(str).toString()) : jSONArray;
        } catch (JSONException e) {
            OTLogger.m2743a(6, "SdkListHelper", "Error while fetching Sdks by group : " + e.getMessage());
            return jSONArray;
        }
    }

    /* JADX INFO: renamed from: c */
    public void m194c(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
            try {
                m192a(this.f53c, jSONObject);
            } catch (JSONException e) {
                e = e;
                OTLogger.m2743a(6, "SdkListHelper", "Error while Saving sdk status " + e.getMessage());
            }
        } catch (JSONException e2) {
            e = e2;
            jSONObject = null;
        }
        if (jSONObject != null) {
            this.f51a.edit().putString("OT_INTERNAL_SDK_STATUS_MAP", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)).apply();
        }
    }

    /* JADX INFO: renamed from: a */
    public int m189a(String str, boolean z) {
        String string = this.f51a.getString("OT_INTERNAL_SDK_STATUS_MAP", "");
        OTLogger.m2743a(4, "SdkListHelper", "SDK Status Object - " + string);
        try {
            JSONObject jSONObject = this.f53c;
            return (jSONObject == null || !jSONObject.has(str)) ? m190a(str, z, string) : this.f53c.getInt(str);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "SdkListHelper", "Error while getting sdk status " + e.getMessage());
            return -1;
        }
    }

    /* JADX INFO: renamed from: a */
    public final int m190a(String str, boolean z, String str2) {
        Integer numValueOf;
        if (!C0048h.m305b(str2)) {
            JSONObject jSONObject = new JSONObject(str2);
            if (!str2.contains(str)) {
                String strM191a = m191a(str);
                numValueOf = strM191a != null ? Integer.valueOf(this.f52b.m272a(strM191a)) : null;
                if (numValueOf != null) {
                    return numValueOf.intValue();
                }
                OTLogger.m2743a(4, "SdkListHelper", "Invalid SDK_ID passed - " + str);
                return -1;
            }
            if (jSONObject.getInt(str) == 2) {
                return z ? 2 : 1;
            }
            OTLogger.m2743a(4, "SdkListHelper", "SDK_ID " + str + "  Status " + jSONObject.get(str));
            return jSONObject.getInt(str);
        }
        String strM191a2 = m191a(str);
        numValueOf = strM191a2 != null ? Integer.valueOf(this.f52b.m272a(strM191a2)) : null;
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    public final void m192a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            int i = jSONObject.getInt(next);
            if (jSONObject2.has(next)) {
                int i2 = jSONObject2.getInt(next);
                Context context = this.f54d;
                boolean z = false;
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                if (C0026u.m181a(context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0).getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                    z = true;
                    sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                } else {
                    sharedPreferencesC0047f = null;
                }
                if (z) {
                    sharedPreferences = sharedPreferencesC0047f;
                }
                String string = sharedPreferences.getString("OTT_LAST_GIVEN_CONSENT", "0");
                if (0 == (C0048h.m305b(string) ? 0L : Long.parseLong(string))) {
                    jSONObject2.put(next, i);
                    Context context2 = this.f54d;
                    OTLogger.m2743a(4, "OTConsentChanges", "Sending " + next + " broadcast, value = " + i);
                    Intent intent = new Intent(next);
                    intent.putExtra(OTBroadcastServiceKeys.EVENT_STATUS, i);
                    intent.setPackage(context2.getApplicationContext().getPackageName());
                    context2.sendBroadcast(intent);
                } else if (i2 != i) {
                    jSONObject2.put(next, i);
                    Context context3 = this.f54d;
                    OTLogger.m2743a(4, "OTConsentChanges", "Sending " + next + " broadcast, value = " + i);
                    Intent intent2 = new Intent(next);
                    intent2.putExtra(OTBroadcastServiceKeys.EVENT_STATUS, i);
                    intent2.setPackage(context3.getApplicationContext().getPackageName());
                    context3.sendBroadcast(intent2);
                }
            }
        }
    }
}
