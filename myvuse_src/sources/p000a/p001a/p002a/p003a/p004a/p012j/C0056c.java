package p000a.p001a.p002a.p003a.p004a.p012j;

import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;
import p000a.p001a.p002a.p003a.p014b.p025i.C0170b;

/* JADX INFO: renamed from: a.a.a.a.a.j.c */
/* JADX INFO: loaded from: classes.dex */
public class C0056c {

    /* JADX INFO: renamed from: c */
    public boolean f117c;

    /* JADX INFO: renamed from: d */
    public int f118d;

    /* JADX INFO: renamed from: a */
    public JSONObject f115a = new JSONObject();

    /* JADX INFO: renamed from: b */
    public JSONObject f116b = new JSONObject();

    /* JADX INFO: renamed from: e */
    public int f119e = 10;

    /* JADX INFO: renamed from: a */
    public void m368a(Context context) {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        if (C0170b.m959a(context, "AppDataParser")) {
            boolean z = false;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (C0026u.m181a(context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0).getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                z = true;
                sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            } else {
                sharedPreferencesC0047f = null;
            }
            if (z) {
                sharedPreferences = sharedPreferencesC0047f;
            }
            sharedPreferences.edit().putInt("OT_SHOW_SYNC_NOTIFICATION", 10).apply();
        }
    }
}
