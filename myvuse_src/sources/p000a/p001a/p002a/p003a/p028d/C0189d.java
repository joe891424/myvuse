package p000a.p001a.p002a.p003a.p028d;

import android.content.Context;
import android.content.SharedPreferences;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p007c.C0028w;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.C0046e;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;

/* JADX INFO: renamed from: a.a.a.a.d.d */
/* JADX INFO: loaded from: classes.dex */
public class C0189d {

    /* JADX INFO: renamed from: a */
    public Context f1672a;

    /* JADX INFO: renamed from: b */
    public C0045d f1673b;

    public C0189d(Context context) {
        this.f1672a = context;
        this.f1673b = new C0045d(context, "OTT_DEFAULT_USER");
    }

    /* JADX INFO: renamed from: a */
    public static StringBuilder m1041a(Map<String, Integer> map, String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            Integer num = map.get(str);
            if (num != null) {
                sb.append(C0191f.m1048a(num.intValue(), 2));
            }
        }
        return sb;
    }

    /* JADX INFO: renamed from: a */
    public int m1042a(String str) {
        int i;
        if (!m1045b(str)) {
            return 0;
        }
        Context context = this.f1672a;
        JSONObject jSONObject = new JSONObject();
        new JSONObject();
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
        }
        C0046e c0046e = new C0046e(context);
        new C0028w(context);
        try {
            i = jSONObject.has(str) ? jSONObject.getInt(str) : c0046e.m272a(str);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "CustomGroupDetails", "Error while getting updated value of Purpose Consent " + e.getMessage());
            i = -1;
        }
        return i == 1 ? 2 : 1;
    }

    /* JADX INFO: renamed from: a */
    public int m1043a(String str, String str2) {
        return (m1045b(str) || m1045b(str2)) ? 1 : 0;
    }

    /* JADX INFO: renamed from: a */
    public int m1044a(boolean z) {
        return z ? 1 : 2;
    }

    /* JADX INFO: renamed from: b */
    public boolean m1045b(String str) {
        return !C0048h.m305b(str) && C0048h.m306b(str, this.f1673b.m271a().getString("OT_UI_VALID_GROUP_IDS", ""));
    }
}
