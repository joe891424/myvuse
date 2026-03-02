package p000a.p001a.p002a.p003a.p004a.p010g;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* JADX INFO: renamed from: a.a.a.a.a.g.a */
/* JADX INFO: loaded from: classes.dex */
public class C0042a {

    /* JADX INFO: renamed from: a */
    public SharedPreferences f89a;

    public C0042a(Context context) {
        this.f89a = PreferenceManager.getDefaultSharedPreferences(context);
    }

    /* JADX INFO: renamed from: a */
    public void m263a(String str) {
        if (this.f89a.contains(str)) {
            this.f89a.edit().remove(str).apply();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m264a(String str, int i) {
        this.f89a.edit().putInt(str, i).apply();
    }

    /* JADX INFO: renamed from: a */
    public void m265a(String str, String str2) {
        this.f89a.edit().putString(str, str2).apply();
    }

    /* JADX INFO: renamed from: b */
    public int m266b(String str) {
        return this.f89a.getInt(str, -1);
    }

    /* JADX INFO: renamed from: c */
    public String m267c(String str) {
        return this.f89a.getString(str, "");
    }
}
