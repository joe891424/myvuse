package p000a.p001a.p002a.p003a.p004a.p008e;

import android.content.Context;
import android.content.SharedPreferences;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;

/* JADX INFO: renamed from: a.a.a.a.a.e.d */
/* JADX INFO: loaded from: classes.dex */
public class C0036d {

    /* JADX INFO: renamed from: a */
    public Context f74a;

    /* JADX INFO: renamed from: b */
    public SharedPreferences f75b;

    public C0036d(Context context) {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        this.f74a = context;
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z = true;
        } else {
            sharedPreferencesC0047f = null;
        }
        this.f75b = z ? sharedPreferencesC0047f : sharedPreferences;
    }

    /* JADX INFO: renamed from: a */
    public long m244a() {
        String string = this.f75b.getString("OTT_LAST_RE_CONSENT_DATE", String.valueOf(-1L));
        if (!C0048h.m305b(string)) {
            return Long.parseLong(string);
        }
        OTLogger.m2743a(4, "ShowBanner", "Last re-consent date not initialized, it will be set once OT SDK initialized.");
        return -1L;
    }

    /* JADX INFO: renamed from: a */
    public void m245a(String str) {
        this.f75b.edit().putString("OTT_LAST_RE_CONSENT_DATE", str).apply();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0075 A[Catch: Exception -> 0x0086, TryCatch #1 {Exception -> 0x0086, blocks: (B:9:0x0043, B:11:0x004f, B:16:0x006f, B:18:0x0075, B:20:0x0079, B:21:0x007e, B:15:0x006a, B:14:0x0056), top: B:154:0x0043, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009e  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int m247b(org.json.JSONObject r22) {
        /*
            Method dump skipped, instruction units count: 895
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p008e.C0036d.m247b(org.json.JSONObject):int");
    }

    /* JADX INFO: renamed from: a */
    public boolean m246a(JSONObject jSONObject) {
        String str;
        if (!jSONObject.has("LastReconsentDate")) {
            return false;
        }
        String string = !jSONObject.isNull("LastReconsentDate") ? jSONObject.get("LastReconsentDate").toString() : null;
        if (!C0048h.m305b(string) && !jSONObject.isNull("LastReconsentDate")) {
            long j = Long.parseLong(string);
            String string2 = this.f75b.getString("OTT_LAST_GIVEN_CONSENT", "0");
            long j2 = C0048h.m305b(string2) ? 0L : Long.parseLong(string2);
            long jM244a = m244a();
            if (j2 == 0 || j <= j2) {
                str = (j2 == 0 && jM244a != -1 && j > jM244a) ? "Reconsent Status: Show Banner is enabled for current geolocation rule and previous lastReconsentDateFromServer is older than lastReconsentDateFromServer" : "Reconsent Status: Show Banner is enabled for current geolocation rule and user consent is older than lastReconsentDateFromServer";
            }
            OTLogger.m2743a(4, "ShowBanner", str);
            return true;
        }
        return false;
    }
}
