package p000a.p001a.p002a.p003a.p004a.p010g;

import android.content.Context;
import android.content.SharedPreferences;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;

/* JADX INFO: renamed from: a.a.a.a.a.g.d */
/* JADX INFO: loaded from: classes.dex */
public class C0045d {

    /* JADX INFO: renamed from: a */
    public final SharedPreferences f93a;

    /* JADX INFO: renamed from: b */
    public SharedPreferencesC0047f f94b;

    /* JADX INFO: renamed from: c */
    public boolean f95c;

    /* JADX INFO: renamed from: d */
    public final Context f96d;

    public C0045d(Context context, String str) {
        this.f96d = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preference" + str, 0);
        this.f93a = sharedPreferences;
        if (C0026u.m181a(context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0).getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            this.f95c = true;
            this.f94b = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
        }
    }

    /* JADX INFO: renamed from: a */
    public SharedPreferences m271a() {
        return this.f95c ? this.f94b : this.f93a;
    }

    public C0045d(Context context, String str, boolean z) {
        this.f96d = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preference" + str, 0);
        this.f93a = sharedPreferences;
        if (z && C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            this.f95c = z;
            this.f94b = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
        }
    }
}
