package p000a.p001a.p002a.p003a.p028d.p029g;

import android.content.Context;
import android.preference.PreferenceManager;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTGppKeys;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p028d.C0187b;

/* JADX INFO: renamed from: a.a.a.a.d.g.e */
/* JADX INFO: loaded from: classes.dex */
public class C0196e {

    /* JADX INFO: renamed from: a */
    public Context f1682a;

    public C0196e(Context context) {
        this.f1682a = context;
    }

    /* JADX INFO: renamed from: a */
    public void m1059a() {
        String str = "";
        try {
            Context context = this.f1682a;
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
                if ("UCPA".equalsIgnoreCase(str)) {
                    String strM1060b = m1060b();
                    OTLogger.m2743a(4, "OneTrust", "Gpp - UCPA (Utah) String : " + strM1060b);
                    if (C0048h.m305b(strM1060b)) {
                        return;
                    }
                    PreferenceManager.getDefaultSharedPreferences(this.f1682a).edit().putString(OTGppKeys.IAB_GPP_USUT_STRING, strM1060b).apply();
                }
            }
        } catch (Exception e) {
            OTLogger.m2743a(6, "OneTrust", "computeUtahString failed:" + e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x01b7  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String m1060b() throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 639
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p028d.p029g.C0196e.m1060b():java.lang.String");
    }
}
