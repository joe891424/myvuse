package p000a.p001a.p002a.p003a.p004a.p007c;

import android.content.Context;
import android.content.SharedPreferences;
import com.brentvatne.react.ReactVideoView;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p009f.C0038b;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;
import p000a.p001a.p002a.p003a.p004a.p011i.C0052d;

/* JADX INFO: renamed from: a.a.a.a.a.c.n */
/* JADX INFO: loaded from: classes.dex */
public class C0019n {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean, int] */
    /* JADX INFO: renamed from: a */
    public void m110a(Context context, JSONObject jSONObject, boolean z) throws Throwable {
        boolean z2;
        SharedPreferencesC0047f sharedPreferencesC0047f;
        JSONObject jSONObject2;
        String str;
        String str2;
        String str3;
        ?? r3;
        String string;
        String string2;
        String strOptString;
        String strOptString2;
        String str4;
        boolean z3;
        SharedPreferencesC0047f sharedPreferencesC0047f2;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z2 = true;
        } else {
            z2 = false;
            sharedPreferencesC0047f = null;
        }
        if (z2) {
            sharedPreferences = sharedPreferencesC0047f;
        }
        String string3 = sharedPreferences.getString("OTT_CULTURE_COMMON_DATA", "");
        if (C0048h.m305b(string3)) {
            jSONObject2 = new JSONObject();
        } else {
            try {
                jSONObject2 = new JSONObject(string3);
            } catch (JSONException e) {
                OTLogger.m2743a(6, "OneTrust", "error while returning common data, err: " + e.getMessage());
                jSONObject2 = new JSONObject();
            }
        }
        String str5 = z ? "OPT_OUT" : "CONFIRMED";
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        if (jSONObject2.has("ConsentIntegration")) {
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("ConsentIntegration");
            if (jSONObjectOptJSONObject != null) {
                strOptString2 = jSONObjectOptJSONObject.optString("RequestInformation");
                strOptString = jSONObjectOptJSONObject.optString("ConsentApi");
            } else {
                strOptString = null;
                strOptString2 = null;
            }
            str = "GoogleAd consent obj";
            try {
                SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                str4 = "com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER";
                try {
                    if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                        sharedPreferencesC0047f2 = new SharedPreferencesC0047f(context, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", ""));
                        z3 = true;
                    } else {
                        z3 = false;
                        sharedPreferencesC0047f2 = null;
                    }
                    if (z3) {
                        sharedPreferences2 = sharedPreferencesC0047f2;
                    }
                    String string4 = sharedPreferences2.getString("OTT_DATA_SUBJECT_IDENTIFIER", "");
                    if (string4 == null) {
                        string4 = "";
                    }
                    jSONObject3.put(ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER, string4);
                    jSONObject3.put("purposes", m108a(jSONObject, str5));
                    jSONObject3.put("requestInformation", strOptString2);
                    jSONObject4.put("consentApi", strOptString);
                    jSONObject4.put("consentPayload", jSONObject3);
                    str2 = "GoogleAdInfo";
                } catch (JSONException e2) {
                    e = e2;
                    str2 = "GoogleAdInfo";
                    OTLogger.m2743a(6, str2, "Error in creating Google Ad CL payload :" + e.getMessage());
                }
            } catch (JSONException e3) {
                e = e3;
                str4 = "com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER";
            }
            str3 = str4;
            r3 = 0;
        } else {
            str = "GoogleAd consent obj";
            str2 = "GoogleAdInfo";
            str3 = "com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER";
            r3 = 0;
        }
        SharedPreferences sharedPreferences3 = context.getSharedPreferences(str3, r3);
        if (C0026u.m181a(context.getSharedPreferences(str3, r3).getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), (boolean) r3)) {
            SharedPreferences sharedPreferences4 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preference.OTT_USER_" + new C0052d(context).m343c(sharedPreferences3.getString("OT_ACTIVE_PROFILE_ID", "")), r3);
            sharedPreferences3.edit();
            sharedPreferences4.edit();
        }
        try {
            C0038b c0038b = new C0038b(context);
            String string5 = jSONObject4.getString("consentApi");
            JSONObject jSONObject5 = jSONObject4.getJSONObject("consentPayload");
            if (jSONObject5 instanceof JSONObject) {
                string = JSONObjectInstrumentation.toString(jSONObject5);
            } else {
                string = jSONObject5.toString();
            }
            c0038b.m254a("https://cookies2-ds.dev.otdev.org/request/v1/", string5, string, 3);
            StringBuilder sb = new StringBuilder(str);
            JSONObject jSONObject6 = jSONObject4.getJSONObject("consentPayload");
            if (jSONObject6 instanceof JSONObject) {
                string2 = JSONObjectInstrumentation.toString(jSONObject6);
            } else {
                string2 = jSONObject6.toString();
            }
            OTLogger.m2743a(4, str2, sb.append(string2).toString());
        } catch (JSONException e4) {
            OTLogger.m2743a(6, str2, "Error while logging consent for GoogleAd." + e4.getMessage());
        }
    }

    /* JADX INFO: renamed from: b */
    public void m111b(final Context context, final JSONObject jSONObject) {
        new Thread(new Runnable() { // from class: a.a.a.a.a.c.n$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.m109a(context, jSONObject);
            }
        }).start();
    }

    /* JADX INFO: renamed from: a */
    public static JSONArray m108a(JSONObject jSONObject, String str) {
        JSONArray jSONArray = new JSONArray();
        if (jSONObject.has("purposeID")) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("id", jSONObject.getString("purposeID"));
                jSONObject2.put("TransactionType", str);
                jSONArray.put(jSONObject2);
            } catch (JSONException e) {
                OTLogger.m2743a(6, "GoogleAdInfo", "Error on getting Google Ad purposeID. Error = " + e.getMessage());
            }
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m109a(Context context, JSONObject jSONObject) throws Throwable {
        OTLogger.m2743a(4, "GoogleAdInfo", "Getting AdvertisingIdClient info in BG thread");
        try {
            boolean zIsLimitAdTrackingEnabled = AdvertisingIdClient.getAdvertisingIdInfo(context).isLimitAdTrackingEnabled();
            C0045d c0045d = new C0045d(context, "OTT_DEFAULT_USER");
            String string = c0045d.m271a().getString("OT_IS_LIMIT_AD_TRACKING_ENABLED", "");
            if (C0048h.m305b(string)) {
                c0045d.m271a().edit().putString("OT_IS_LIMIT_AD_TRACKING_ENABLED", Boolean.toString(zIsLimitAdTrackingEnabled)).apply();
                OTLogger.m2743a(4, "GoogleAdInfo", "Saving Google Ad isLimitAdTrackingEnabled, value = " + zIsLimitAdTrackingEnabled);
            } else if (Boolean.parseBoolean(string) == zIsLimitAdTrackingEnabled) {
                OTLogger.m2743a(4, "GoogleAdInfo", "Google Ad isLimitAdTrackingEnabled status not changed.");
                return;
            } else {
                c0045d.m271a().edit().putString("OT_IS_LIMIT_AD_TRACKING_ENABLED", Boolean.toString(zIsLimitAdTrackingEnabled)).apply();
                OTLogger.m2743a(4, "GoogleAdInfo", "Updating Google Ad isLimitAdTrackingEnabled, value = " + zIsLimitAdTrackingEnabled);
            }
            m110a(context, jSONObject, zIsLimitAdTrackingEnabled);
        } catch (Exception e) {
            OTLogger.m2743a(6, "GoogleAdInfo", "Error on saveAndConsentLogGooglePermissionState. Error = " + e.getMessage());
        }
    }
}
