package p000a.p001a.p002a.p003a.p028d.p029g;

import android.content.Context;
import android.preference.PreferenceManager;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTGppKeys;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p028d.C0187b;
import p000a.p001a.p002a.p003a.p028d.C0189d;
import p000a.p001a.p002a.p003a.p028d.C0191f;

/* JADX INFO: renamed from: a.a.a.a.d.g.a */
/* JADX INFO: loaded from: classes.dex */
public class C0192a {

    /* JADX INFO: renamed from: a */
    public Context f1678a;

    public C0192a(Context context) {
        this.f1678a = context;
    }

    /* JADX INFO: renamed from: a */
    public static Map<String, Integer> m1049a(JSONObject jSONObject, JSONObject jSONObject2, C0189d c0189d) {
        int iM1042a;
        int iM1042a2;
        if (jSONObject.optBoolean("knownChildApplicable")) {
            iM1042a = c0189d.m1042a(jSONObject2.optString("knownChildSell"));
            iM1042a2 = c0189d.m1042a(jSONObject2.optString("knownChildSharePI"));
        } else {
            iM1042a = 0;
            iM1042a2 = 0;
        }
        HashMap map = new HashMap();
        map.put("knownChildSell", Integer.valueOf(iM1042a));
        map.put("knownChildShare", Integer.valueOf(iM1042a2));
        return map;
    }

    /* JADX INFO: renamed from: a */
    public static void m1050a(Map<String, Integer> map, StringBuilder sb, String[] strArr) {
        for (String str : strArr) {
            Integer num = map.get(str);
            if (num != null) {
                sb.append(C0191f.m1048a(num.intValue(), 2));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1051a() {
        String str = "";
        try {
            Context context = this.f1678a;
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
                if ("CPRA".equalsIgnoreCase(str)) {
                    String strM1052b = m1052b();
                    OTLogger.m2743a(4, "OneTrust", "Gpp - California/CPRA String : " + strM1052b);
                    if (C0048h.m305b(strM1052b)) {
                        return;
                    }
                    PreferenceManager.getDefaultSharedPreferences(this.f1678a).edit().putString(OTGppKeys.IAB_GPP_CALIFORNIA_STRING, strM1052b).apply();
                }
            }
        } catch (Exception e) {
            OTLogger.m2743a(6, "OneTrust", "compute California/CPRA String failed:" + e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x01f2  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String m1052b() throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 696
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p028d.p029g.C0192a.m1052b():java.lang.String");
    }
}
