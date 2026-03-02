package p000a.p001a.p002a.p003a.p028d.p029g;

import android.content.Context;
import android.preference.PreferenceManager;
import com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTGppKeys;
import java.util.HashMap;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p028d.C0187b;
import p000a.p001a.p002a.p003a.p028d.C0189d;

/* JADX INFO: renamed from: a.a.a.a.d.g.f */
/* JADX INFO: loaded from: classes.dex */
public class C0197f {

    /* JADX INFO: renamed from: a */
    public Context f1683a;

    public C0197f(Context context) {
        this.f1683a = context;
    }

    /* JADX INFO: renamed from: a */
    public static StringBuilder m1061a(JSONObject jSONObject, JSONObject jSONObject2, C0189d c0189d) {
        int iM1042a;
        int iM1042a2;
        int iM1042a3;
        int iM1042a4;
        int iM1042a5;
        int iM1042a6;
        int iM1042a7;
        int iM1042a8;
        if (jSONObject.optBoolean("sensitiveDataProcessApplicable")) {
            iM1042a = c0189d.m1042a(jSONObject2.optString(BlinkIdCombinedRecognizer.VerificationConstants.Race));
            iM1042a3 = c0189d.m1042a(jSONObject2.optString(BlinkIdCombinedRecognizer.VerificationConstants.Religion));
            iM1042a4 = c0189d.m1042a(jSONObject2.optString("health"));
            iM1042a5 = c0189d.m1042a(jSONObject2.optString("sexualOrientation"));
            iM1042a6 = c0189d.m1042a(jSONObject2.optString("immigration"));
            iM1042a7 = c0189d.m1042a(jSONObject2.optString("genetic"));
            iM1042a8 = c0189d.m1042a(jSONObject2.optString("biometric"));
            iM1042a2 = c0189d.m1042a(jSONObject2.optString("geolocation"));
        } else {
            iM1042a = 0;
            iM1042a2 = 0;
            iM1042a3 = 0;
            iM1042a4 = 0;
            iM1042a5 = 0;
            iM1042a6 = 0;
            iM1042a7 = 0;
            iM1042a8 = 0;
        }
        HashMap map = new HashMap();
        map.put("sdp1", Integer.valueOf(iM1042a));
        map.put("sdp2", Integer.valueOf(iM1042a3));
        map.put("sdp3", Integer.valueOf(iM1042a4));
        map.put("sdp4", Integer.valueOf(iM1042a5));
        map.put("sdp5", Integer.valueOf(iM1042a6));
        map.put("sdp6", Integer.valueOf(iM1042a7));
        map.put("sdp7", Integer.valueOf(iM1042a8));
        map.put("sdp8", Integer.valueOf(iM1042a2));
        return C0189d.m1041a(map, new String[]{"sdp1", "sdp2", "sdp3", "sdp4", "sdp5", "sdp6", "sdp7", "sdp8"});
    }

    /* JADX INFO: renamed from: a */
    public void m1062a() {
        String str = "";
        try {
            Context context = this.f1683a;
            C0045d c0045d = new C0045d(context, "OTT_DEFAULT_USER");
            C0045d c0045d2 = new C0045d(context, "OTT_DEFAULT_USER");
            new C0187b(context);
            if (c0045d2.m271a().getBoolean("OT_GPP_IS_ENABLED", false)) {
                String string = c0045d.m271a().getString("OT_TEMPLATE_TYPE", "");
                if (!C0048h.m305b(string)) {
                    str = string;
                }
                if (c0045d.m271a().getBoolean("OT_USE_GPP_USNATIONAL", false)) {
                    str = "USNATIONAL";
                }
                if ("CDPA".equalsIgnoreCase(str)) {
                    String strM1063b = m1063b();
                    OTLogger.m2743a(4, "OneTrust", "Gpp - CDPA (Virginia) String : " + strM1063b);
                    if (C0048h.m305b(strM1063b)) {
                        return;
                    }
                    PreferenceManager.getDefaultSharedPreferences(this.f1683a).edit().putString(OTGppKeys.IAB_GPP_USVA_STRING, strM1063b).apply();
                }
            }
        } catch (Exception e) {
            OTLogger.m2743a(6, "OneTrust", "computeVirginiaString failed:" + e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00da  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String m1063b() throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p028d.p029g.C0197f.m1063b():java.lang.String");
    }
}
