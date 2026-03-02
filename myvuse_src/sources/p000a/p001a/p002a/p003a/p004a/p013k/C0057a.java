package p000a.p001a.p002a.p003a.p004a.p013k;

import android.content.Context;
import android.content.SharedPreferences;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;

/* JADX INFO: renamed from: a.a.a.a.a.k.a */
/* JADX INFO: loaded from: classes.dex */
public class C0057a {

    /* JADX INFO: renamed from: a */
    public final Context f120a;

    public C0057a(Context context) {
        this.f120a = context;
    }

    /* JADX INFO: renamed from: a */
    public void m369a() throws JSONException {
        if (m372c()) {
            SharedPreferences sharedPreferences = this.f120a.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            JSONArray jSONArray = new JSONArray(sharedPreferences.getString("OT_MULTI_PROFILE_ID_MAP", null));
            JSONObject jSONObject = new JSONObject();
            for (int i = 0; i < jSONArray.length(); i++) {
                String string = jSONArray.getString(i);
                try {
                    this.f120a.getSharedPreferences("com.onetrust.otpublishers.headless.preference.OTT_USER_" + string, 0);
                    jSONObject.put(string, string);
                } catch (IllegalArgumentException e) {
                    OTLogger.m2743a(6, "OneTrust", "Error on file creation, file name = " + string);
                    OTLogger.m2743a(6, "OneTrust", "Error on file creation, error = " + e.getMessage());
                    jSONObject.put(string, UUID.randomUUID().toString());
                }
            }
            sharedPreferences.edit().putString("OT_MULTI_PROFILE_PROFILE_ID_FILE_MAP", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)).apply();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m371b() {
        SharedPreferences sharedPreferences = this.f120a.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (!sharedPreferences.contains("OT_SDK_VERSION_CODE") || Long.parseLong(this.f120a.getString(C3896R.string.ot_sdk_version_code)) > sharedPreferences.getLong("OT_SDK_VERSION_CODE", 0L)) {
            try {
                SharedPreferences sharedPreferences2 = this.f120a.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                long j = Long.parseLong(this.f120a.getString(C3896R.string.ot_sdk_version_code));
                if (sharedPreferences2.getLong("OT_SDK_VERSION_CODE", 0L) < 63500) {
                    if (1 == sharedPreferences2.getInt("OTT_DATA_SUBJECT_IDENTIFIER_TYPE", 1)) {
                        String string = sharedPreferences2.getString("OTT_DATA_SUBJECT_IDENTIFIER", null);
                        if (!C0048h.m305b(string) && !sharedPreferences2.contains("OT_GENERIC_PROFILE_IDENTIFIER")) {
                            this.f120a.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0).edit().putString("OT_GENERIC_PROFILE_IDENTIFIER", string).apply();
                        }
                    }
                    m370a(sharedPreferences2);
                }
                OTLogger.m2743a(3, "OTSDKUpgrade", "Setting SDK version code = " + j);
                sharedPreferences2.edit().putLong("OT_SDK_VERSION_CODE", j).apply();
            } catch (Exception e) {
                OTLogger.m2743a(6, "OTSDKExceptions", "Error on handleSDKUpgradeIfNeeded,Error = " + e.getMessage());
            }
        }
        try {
            m369a();
        } catch (JSONException unused) {
            OTLogger.m2743a(6, "OneTrust", "Error on handling upgrade case for multiprofile file name change.");
        }
    }

    /* JADX INFO: renamed from: c */
    public boolean m372c() {
        SharedPreferences sharedPreferences = this.f120a.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        return !C0048h.m305b(sharedPreferences.getString("OT_MULTI_PROFILE_ID_MAP", null)) && C0048h.m305b(sharedPreferences.getString("OT_MULTI_PROFILE_PROFILE_ID_FILE_MAP", null));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0074 A[Catch: Exception -> 0x0085, TryCatch #1 {Exception -> 0x0085, blocks: (B:9:0x0041, B:11:0x004d, B:16:0x006e, B:18:0x0074, B:20:0x0078, B:21:0x007d, B:15:0x0069, B:14:0x0054), top: B:154:0x0041, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009c  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m370a(android.content.SharedPreferences r15) {
        /*
            Method dump skipped, instruction units count: 1021
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p013k.C0057a.m370a(android.content.SharedPreferences):void");
    }
}
