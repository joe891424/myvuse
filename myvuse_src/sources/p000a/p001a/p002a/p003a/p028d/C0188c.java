package p000a.p001a.p002a.p003a.p028d;

import android.content.Context;
import android.content.SharedPreferences;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;

/* JADX INFO: renamed from: a.a.a.a.d.c */
/* JADX INFO: loaded from: classes.dex */
public class C0188c {

    /* JADX INFO: renamed from: a */
    public C0045d f1669a;

    /* JADX INFO: renamed from: b */
    public Context f1670b;

    /* JADX INFO: renamed from: c */
    public C0187b f1671c;

    public C0188c(Context context) {
        this.f1670b = context;
        this.f1669a = new C0045d(context, "OTT_DEFAULT_USER");
        this.f1671c = new C0187b(context);
    }

    /* JADX INFO: renamed from: a */
    public static String m1034a(String str, String str2) {
        return !C0048h.m305b(str) ? str2 + "~" + str : str2;
    }

    /* JADX INFO: renamed from: a */
    public static String m1035a(String str, ArrayList<Integer> arrayList, int i, String str2) {
        if (C0048h.m305b(str)) {
            return str2;
        }
        arrayList.add(Integer.valueOf(i));
        return str;
    }

    /* JADX INFO: renamed from: a */
    public static void m1036a(String str, int i, boolean z, StringBuilder sb) {
        if (str.equals(String.valueOf(i)) && z) {
            if (C0048h.m305b(sb.toString())) {
                sb.append(str);
            } else {
                sb.append("_").append(str);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public JSONObject m1039b() {
        String string = this.f1669a.m271a().getString("OT_GPP_DATA_BACKUP", "");
        if (!C0048h.m305b(string)) {
            try {
                return new JSONObject(string);
            } catch (JSONException e) {
                OTLogger.m2743a(6, "GPPStringHandler", "getGppBackUpData: " + e);
            }
        }
        return new JSONObject();
    }

    /* JADX INFO: renamed from: c */
    public boolean m1040c() {
        return this.f1669a.m271a().getBoolean("OT_GPP_IS_ENABLED", false);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0120  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m1038a() {
        /*
            Method dump skipped, instruction units count: 589
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p028d.C0188c.m1038a():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX INFO: renamed from: a */
    public final String m1037a(ArrayList<Integer> arrayList) {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        boolean z;
        SharedPreferencesC0047f sharedPreferencesC0047f2;
        boolean z2;
        SharedPreferencesC0047f sharedPreferencesC0047f3;
        boolean z3;
        SharedPreferencesC0047f sharedPreferencesC0047f4;
        boolean z4;
        SharedPreferencesC0047f sharedPreferencesC0047f5;
        boolean z5;
        StringBuilder sb = new StringBuilder("");
        String string = this.f1669a.m271a().getString("OT_TEMPLATE_TYPE", "");
        if (C0048h.m305b(string)) {
            string = "";
        }
        ?? r7 = 0;
        boolean z6 = this.f1669a.m271a().getBoolean("OT_COMPUTE_CCPA_REGION", false);
        int i = 0;
        while (i < arrayList.size()) {
            String string2 = arrayList.get(i).toString();
            if (string2.equals(String.valueOf(2)) && string.equals("IAB2")) {
                sb.append(string2);
            }
            m1036a(string2, 6, z6, sb);
            Context context = this.f1670b;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", r7);
            String str = string;
            SharedPreferencesC0047f sharedPreferencesC0047f6 = null;
            boolean z7 = true;
            if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", r7).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), (boolean) r7)) {
                sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z = true;
            } else {
                sharedPreferencesC0047f = null;
                z = false;
            }
            String string3 = (z ? sharedPreferencesC0047f : sharedPreferences).getString("OT_TEMPLATE_TYPE", "");
            if (C0048h.m305b(string3)) {
                string3 = "";
            }
            if (z) {
                sharedPreferences = sharedPreferencesC0047f;
            }
            if (sharedPreferences.getBoolean("OT_USE_GPP_USNATIONAL", false)) {
                string3 = "USNATIONAL";
            }
            m1036a(string2, 7, "USNATIONAL".equalsIgnoreCase(string3), sb);
            Context context2 = this.f1670b;
            boolean z8 = z6;
            SharedPreferences sharedPreferences2 = context2.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (C0026u.m181a(new C0045d(context2, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                sharedPreferencesC0047f2 = new SharedPreferencesC0047f(context2, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", ""));
                z2 = true;
            } else {
                sharedPreferencesC0047f2 = null;
                z2 = false;
            }
            String string4 = (z2 ? sharedPreferencesC0047f2 : sharedPreferences2).getString("OT_TEMPLATE_TYPE", "");
            if (C0048h.m305b(string4)) {
                string4 = "";
            }
            if (z2) {
                sharedPreferences2 = sharedPreferencesC0047f2;
            }
            if (sharedPreferences2.getBoolean("OT_USE_GPP_USNATIONAL", false)) {
                string4 = "USNATIONAL";
            }
            m1036a(string2, 8, "CPRA".equalsIgnoreCase(string4), sb);
            Context context3 = this.f1670b;
            SharedPreferences sharedPreferences3 = context3.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (C0026u.m181a(new C0045d(context3, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                sharedPreferencesC0047f3 = new SharedPreferencesC0047f(context3, sharedPreferences3, sharedPreferences3.getString("OT_ACTIVE_PROFILE_ID", ""));
                z3 = true;
            } else {
                sharedPreferencesC0047f3 = null;
                z3 = false;
            }
            String string5 = (z3 ? sharedPreferencesC0047f3 : sharedPreferences3).getString("OT_TEMPLATE_TYPE", "");
            if (C0048h.m305b(string5)) {
                string5 = "";
            }
            if (z3) {
                sharedPreferences3 = sharedPreferencesC0047f3;
            }
            if (sharedPreferences3.getBoolean("OT_USE_GPP_USNATIONAL", false)) {
                string5 = "USNATIONAL";
            }
            m1036a(string2, 9, "CDPA".equalsIgnoreCase(string5), sb);
            Context context4 = this.f1670b;
            SharedPreferences sharedPreferences4 = context4.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (C0026u.m181a(new C0045d(context4, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                sharedPreferencesC0047f4 = new SharedPreferencesC0047f(context4, sharedPreferences4, sharedPreferences4.getString("OT_ACTIVE_PROFILE_ID", ""));
                z4 = true;
            } else {
                sharedPreferencesC0047f4 = null;
                z4 = false;
            }
            String string6 = (z4 ? sharedPreferencesC0047f4 : sharedPreferences4).getString("OT_TEMPLATE_TYPE", "");
            if (C0048h.m305b(string6)) {
                string6 = "";
            }
            if (z4) {
                sharedPreferences4 = sharedPreferencesC0047f4;
            }
            if (sharedPreferences4.getBoolean("OT_USE_GPP_USNATIONAL", false)) {
                string6 = "USNATIONAL";
            }
            m1036a(string2, 10, "COLORADO".equalsIgnoreCase(string6), sb);
            Context context5 = this.f1670b;
            SharedPreferences sharedPreferences5 = context5.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (C0026u.m181a(new C0045d(context5, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                sharedPreferencesC0047f5 = new SharedPreferencesC0047f(context5, sharedPreferences5, sharedPreferences5.getString("OT_ACTIVE_PROFILE_ID", ""));
                z5 = true;
            } else {
                sharedPreferencesC0047f5 = null;
                z5 = false;
            }
            String string7 = (z5 ? sharedPreferencesC0047f5 : sharedPreferences5).getString("OT_TEMPLATE_TYPE", "");
            if (C0048h.m305b(string7)) {
                string7 = "";
            }
            if (z5) {
                sharedPreferences5 = sharedPreferencesC0047f5;
            }
            if (sharedPreferences5.getBoolean("OT_USE_GPP_USNATIONAL", false)) {
                string7 = "USNATIONAL";
            }
            m1036a(string2, 11, "UCPA".equalsIgnoreCase(string7), sb);
            Context context6 = this.f1670b;
            SharedPreferences sharedPreferences6 = context6.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (C0026u.m181a(new C0045d(context6, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                sharedPreferencesC0047f6 = new SharedPreferencesC0047f(context6, sharedPreferences6, sharedPreferences6.getString("OT_ACTIVE_PROFILE_ID", ""));
            } else {
                z7 = false;
            }
            String string8 = (z7 ? sharedPreferencesC0047f6 : sharedPreferences6).getString("OT_TEMPLATE_TYPE", "");
            if (C0048h.m305b(string8)) {
                string8 = "";
            }
            if (z7) {
                sharedPreferences6 = sharedPreferencesC0047f6;
            }
            m1036a(string2, 12, "CTDPA".equalsIgnoreCase(sharedPreferences6.getBoolean("OT_USE_GPP_USNATIONAL", false) ? "USNATIONAL" : string8), sb);
            i++;
            r7 = 0;
            string = str;
            z6 = z8;
        }
        return sb.toString();
    }
}
