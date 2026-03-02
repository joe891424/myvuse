package p000a.p001a.p002a.p003a.p004a.p007c;

import android.content.Context;
import android.content.SharedPreferences;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTGeolocationModel;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;

/* JADX INFO: renamed from: a.a.a.a.a.c.m */
/* JADX INFO: loaded from: classes.dex */
public class C0018m {

    /* JADX INFO: renamed from: a */
    public C0045d f41a;

    public C0018m(Context context) {
        this.f41a = new C0045d(context, "OTT_DEFAULT_USER");
    }

    /* JADX INFO: renamed from: a */
    public OTGeolocationModel m105a(int i) {
        SharedPreferences sharedPreferencesM271a;
        String str;
        String string = "";
        if (i == 1) {
            sharedPreferencesM271a = this.f41a.m271a();
            str = "OTT_USER_CONSENT_LOCATION";
        } else {
            if (i != 2) {
                if (i == 3) {
                    sharedPreferencesM271a = this.f41a.m271a();
                    str = "OT_CONSENTED_LOCATION";
                }
                return m107a(string);
            }
            sharedPreferencesM271a = this.f41a.m271a();
            str = "OT_DATA_DOWNLOADED_GEO_LOCATION";
        }
        string = sharedPreferencesM271a.getString(str, "");
        return m107a(string);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0080  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.onetrust.otpublishers.headless.Public.DataModel.OTGeolocationModel m106a(int r3, java.lang.String r4, java.lang.String r5) throws org.json.JSONException {
        /*
            r2 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "country"
            r0.put(r1, r4)
            java.lang.String r4 = "state"
            r0.put(r4, r5)
            r4 = 1
            if (r3 != r4) goto L37
            a.a.a.a.a.g.d r3 = r2.f41a
            android.content.SharedPreferences r3 = r3.m271a()
            android.content.SharedPreferences$Editor r3 = r3.edit()
            boolean r4 = r0 instanceof org.json.JSONObject
            if (r4 != 0) goto L26
            java.lang.String r4 = r0.toString()
            goto L2d
        L26:
            r4 = r0
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            java.lang.String r4 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r0)
        L2d:
            java.lang.String r5 = "OTT_USER_CONSENT_LOCATION"
        L2f:
            android.content.SharedPreferences$Editor r3 = r3.putString(r5, r4)
            r3.apply()
            goto L77
        L37:
            r4 = 2
            if (r3 != r4) goto L57
            a.a.a.a.a.g.d r3 = r2.f41a
            android.content.SharedPreferences r3 = r3.m271a()
            android.content.SharedPreferences$Editor r3 = r3.edit()
            boolean r4 = r0 instanceof org.json.JSONObject
            if (r4 != 0) goto L4d
            java.lang.String r4 = r0.toString()
            goto L54
        L4d:
            r4 = r0
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            java.lang.String r4 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r0)
        L54:
            java.lang.String r5 = "OT_DATA_DOWNLOADED_GEO_LOCATION"
            goto L2f
        L57:
            r4 = 3
            if (r3 != r4) goto L77
            a.a.a.a.a.g.d r3 = r2.f41a
            android.content.SharedPreferences r3 = r3.m271a()
            android.content.SharedPreferences$Editor r3 = r3.edit()
            boolean r4 = r0 instanceof org.json.JSONObject
            if (r4 != 0) goto L6d
            java.lang.String r4 = r0.toString()
            goto L74
        L6d:
            r4 = r0
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            java.lang.String r4 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r0)
        L74:
            java.lang.String r5 = "OT_CONSENTED_LOCATION"
            goto L2f
        L77:
            boolean r3 = r0 instanceof org.json.JSONObject
            if (r3 != 0) goto L80
            java.lang.String r3 = r0.toString()
            goto L87
        L80:
            r3 = r0
            org.json.JSONObject r3 = (org.json.JSONObject) r3
            java.lang.String r3 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r0)
        L87:
            com.onetrust.otpublishers.headless.Public.DataModel.OTGeolocationModel r3 = r2.m107a(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p007c.C0018m.m106a(int, java.lang.String, java.lang.String):com.onetrust.otpublishers.headless.Public.DataModel.OTGeolocationModel");
    }

    /* JADX INFO: renamed from: a */
    public OTGeolocationModel m107a(String str) {
        if (C0048h.m305b(str)) {
            return null;
        }
        OTGeolocationModel oTGeolocationModel = new OTGeolocationModel();
        try {
            JSONObject jSONObject = new JSONObject(str);
            oTGeolocationModel.country = jSONObject.optString("country");
            oTGeolocationModel.state = jSONObject.optString("state");
        } catch (JSONException e) {
            OTLogger.m2743a(6, "GLDataHandler", "error in formatting ott data with err = " + e.getMessage());
        }
        return oTGeolocationModel;
    }
}
