package p000a.p001a.p002a.p003a.p004a.p010g;

import android.content.SharedPreferences;
import java.util.Set;
import p000a.p001a.p002a.p003a.p004a.p005a.C0001a;

/* JADX INFO: renamed from: a.a.a.a.a.g.c */
/* JADX INFO: loaded from: classes.dex */
public class SharedPreferencesEditorC0044c implements SharedPreferences.Editor {

    /* JADX INFO: renamed from: a */
    public final SharedPreferences.Editor f91a;

    /* JADX INFO: renamed from: b */
    public final SharedPreferences.Editor f92b;

    public SharedPreferencesEditorC0044c(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        this.f91a = sharedPreferences.edit();
        this.f92b = sharedPreferences2.edit();
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        this.f91a.apply();
        this.f92b.apply();
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        this.f91a.clear();
        this.f92b.clear();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return this.f91a.commit() && this.f92b.commit();
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        (C0001a.f0a.contains(str) ? this.f92b : this.f91a).putBoolean(str, z);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f) {
        (C0001a.f0a.contains(str) ? this.f92b : this.f91a).putFloat(str, f);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i) {
        (C0001a.f0a.contains(str) ? this.f92b : this.f91a).putInt(str, i);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        (C0001a.f0a.contains(str) ? this.f92b : this.f91a).putLong(str, j);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        (C0001a.f0a.contains(str) ? this.f92b : this.f91a).putString(str, str2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        (C0001a.f0a.contains(str) ? this.f92b : this.f91a).putStringSet(str, set);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        (C0001a.f0a.contains(str) ? this.f92b : this.f91a).remove(str);
        return this;
    }
}
