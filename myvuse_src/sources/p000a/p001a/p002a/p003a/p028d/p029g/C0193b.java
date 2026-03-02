package p000a.p001a.p002a.p003a.p028d.p029g;

import android.content.Context;
import android.preference.PreferenceManager;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTGppKeys;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p028d.C0187b;

/* JADX INFO: renamed from: a.a.a.a.d.g.b */
/* JADX INFO: loaded from: classes.dex */
public class C0193b {

    /* JADX INFO: renamed from: a */
    public Context f1679a;

    public C0193b(Context context) {
        this.f1679a = context;
    }

    /* JADX INFO: renamed from: a */
    public void m1053a() {
        String str = "";
        try {
            Context context = this.f1679a;
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
                if ("COLORADO".equalsIgnoreCase(str)) {
                    String strM1054b = m1054b();
                    OTLogger.m2743a(4, "OneTrust", "Gpp - CPA (Colorado) String : " + strM1054b);
                    if (C0048h.m305b(strM1054b)) {
                        return;
                    }
                    PreferenceManager.getDefaultSharedPreferences(this.f1679a).edit().putString(OTGppKeys.IAB_GPP_USCO_STRING, strM1054b).apply();
                }
            }
        } catch (Exception e) {
            OTLogger.m2743a(6, "OneTrust", "computeColoradoString failed:" + e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0190  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String m1054b() throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 578
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p028d.p029g.C0193b.m1054b():java.lang.String");
    }
}
