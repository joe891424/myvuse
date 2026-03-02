package p000a.p001a.p002a.p003a.p004a.p007c;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABTCFKeys;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p010g.C0046e;

/* JADX INFO: renamed from: a.a.a.a.a.c.s */
/* JADX INFO: loaded from: classes.dex */
public class C0024s {

    /* JADX INFO: renamed from: a */
    public final C0046e f49a;

    /* JADX INFO: renamed from: b */
    public final Context f50b;

    public C0024s(Context context) {
        this.f50b = context;
        this.f49a = new C0046e(context);
    }

    /* JADX INFO: renamed from: a */
    public static void m153a(JSONObject jSONObject, String str, boolean z) throws JSONException {
        if (str != null) {
            int i = 0;
            while (i < str.length()) {
                int i2 = i + 1;
                jSONObject.put((z ? "IABV2_" : "ISFV2_") + i2, Integer.parseInt(str.substring(i, i2)));
                i = i2;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m155a(JSONObject jSONObject) {
        this.f49a.m274a(1);
        JSONObject jSONObject2 = new JSONObject();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f50b);
        SharedPreferences sharedPreferences = this.f50b.getSharedPreferences("com.onetrust.otpublisherssdk.Internal.preference", 0);
        String string = defaultSharedPreferences.getString("optanonCookieConsentGroups", "");
        String string2 = defaultSharedPreferences.getString("completeOptanonCookie", "");
        String string3 = defaultSharedPreferences.getString("OTuserConsentGivenLocation", "");
        int i = sharedPreferences.getInt("OT_BANNER_SHOWN_TO_USER", -1);
        String string4 = defaultSharedPreferences.getString(OTIABTCFKeys.IABTCF_SPECIALFEATURESOPTINS, "");
        String string5 = defaultSharedPreferences.getString(OTIABTCFKeys.IABTCF_PURPOSECONSENTS, "");
        String string6 = defaultSharedPreferences.getString(OTIABTCFKeys.IABTCF_PURPOSELEGITIMATEINTERESTS, "");
        String string7 = defaultSharedPreferences.getString(OTIABTCFKeys.IABTCF_VENDORCONSENTS, "");
        String string8 = defaultSharedPreferences.getString(OTIABTCFKeys.IABTCF_VENDORLEGITIMATEINTERESTS, "");
        try {
            JSONObject jSONObject3 = new JSONObject();
            if (!C0048h.m305b(string)) {
                jSONObject3 = new JSONObject(string);
            }
            JSONArray jSONArray = new JSONArray(new JSONTokener(string2).nextValue().toString());
            int i2 = 0;
            while (true) {
                if (i2 >= jSONArray.length()) {
                    break;
                }
                if (jSONArray.getJSONObject(i2).optString("name", "").equals("OptanonAlertBoxClosed")) {
                    jSONObject2 = jSONArray.getJSONObject(i2);
                    break;
                }
                i2++;
            }
            m157b(jSONObject2);
            m154a(string3);
            C0048h c0048h = new C0048h();
            if (c0048h.m311a(this.f50b) < 1 && i == 1) {
                c0048h.m312a(this.f50b, 1);
            }
            JSONArray jSONArrayNames = jSONObject3.names();
            if (jSONArrayNames != null) {
                for (int i3 = 0; i3 < jSONArrayNames.length(); i3++) {
                    jSONObject.put(jSONArrayNames.getString(i3), Integer.parseInt(jSONObject3.getString(jSONArrayNames.getString(i3))));
                }
            }
            m156a(jSONObject, string4, string5, string6, string7, string8, jSONObject2);
            if (this.f49a.m287i() != 6) {
                this.f49a.m274a(3);
            }
        } catch (JSONException e) {
            this.f49a.m274a(2);
            OTLogger.m2743a(6, "OneTrust", "error while syncing data from Web SDK, err: " + e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m157b(org.json.JSONObject r7) throws org.json.JSONException {
        /*
            r6 = this;
            java.lang.String r0 = "value"
            boolean r1 = r7.has(r0)
            if (r1 == 0) goto L61
            java.lang.String r7 = r7.getString(r0)
            boolean r0 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r7)
            if (r0 != 0) goto L61
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.lang.String r1 = "yyyy-MM-dd'T'HH:mm:ss"
            r0.<init>(r1)
            java.lang.String r1 = "UTC"
            java.util.TimeZone r1 = java.util.TimeZone.getTimeZone(r1)
            r0.setTimeZone(r1)
            java.lang.String r1 = "OTSDKMigration"
            r2 = -1
            if (r7 == 0) goto L4d
            java.util.Date r7 = r0.parse(r7)     // Catch: java.text.ParseException -> L35
            if (r7 == 0) goto L4d
            long r4 = r7.getTime()     // Catch: java.text.ParseException -> L35
            goto L4e
        L35:
            r7 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "Error while migrating consent given time, err : "
            r0.<init>(r4)
            java.lang.String r7 = r7.getMessage()
            java.lang.StringBuilder r7 = r0.append(r7)
            java.lang.String r7 = r7.toString()
            r0 = 6
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r0, r1, r7)
        L4d:
            r4 = r2
        L4e:
            int r7 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r7 == 0) goto L5b
            a.a.a.a.a.g.e r7 = r6.f49a
            java.lang.String r0 = java.lang.String.valueOf(r4)
            r7.m283e(r0)
        L5b:
            java.lang.String r7 = "Saving Consent given time from WebSDK"
            r0 = 2
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r0, r1, r7)
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p007c.C0024s.m157b(org.json.JSONObject):void");
    }

    /* JADX INFO: renamed from: a */
    public void m154a(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                C0018m c0018m = new C0018m(this.f50b);
                c0018m.m106a(1, jSONObject.optString("country"), jSONObject.optString("state"));
                c0018m.m106a(3, jSONObject.optString("country"), jSONObject.optString("state"));
                OTLogger.m2743a(2, "OTSDKMigration", "Saving Consent given location from Web SDK, country : " + jSONObject.optString("country") + "state : " + jSONObject.optString("state"));
            } catch (Exception e) {
                OTLogger.m2743a(3, "OTSDKMigration", "Error while migrating consent given location, err : " + e.getMessage());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x017f  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m156a(org.json.JSONObject r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, org.json.JSONObject r23) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p007c.C0024s.m156a(org.json.JSONObject, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, org.json.JSONObject):void");
    }
}
