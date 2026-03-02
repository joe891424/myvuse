package p000a.p001a.p002a.p003a.p004a.p010g;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import java.util.Set;
import p000a.p001a.p002a.p003a.p004a.p005a.C0001a;
import p000a.p001a.p002a.p003a.p004a.p011i.C0052d;

/* JADX INFO: renamed from: a.a.a.a.a.g.f */
/* JADX INFO: loaded from: classes.dex */
public class SharedPreferencesC0047f implements SharedPreferences {

    /* JADX INFO: renamed from: a */
    public final SharedPreferencesEditorC0044c f99a;

    /* JADX INFO: renamed from: b */
    public final SharedPreferences f100b;

    /* JADX INFO: renamed from: c */
    public final SharedPreferences f101c;

    public SharedPreferencesC0047f(Context context, SharedPreferences sharedPreferences, String str) {
        this.f100b = sharedPreferences;
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preference.OTT_USER_" + new C0052d(context).m343c(str), 0);
        this.f101c = sharedPreferences2;
        this.f99a = new SharedPreferencesEditorC0044c(sharedPreferences, sharedPreferences2);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return (C0001a.f0a.contains(str) ? this.f101c : this.f100b).contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.f99a;
    }

    @Override // android.content.SharedPreferences
    @Deprecated
    public Map<String, ?> getAll() {
        return null;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return (C0001a.f0a.contains(str) ? this.f101c : this.f100b).getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return (C0001a.f0a.contains(str) ? this.f101c : this.f100b).getFloat(str, f);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return (C0001a.f0a.contains(str) ? this.f101c : this.f100b).getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return (C0001a.f0a.contains(str) ? this.f101c : this.f100b).getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        return (C0001a.f0a.contains(str) ? this.f101c : this.f100b).getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return (C0001a.f0a.contains(str) ? this.f101c : this.f100b).getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f100b.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        this.f101c.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f100b.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        this.f101c.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
