package com.yoti.mobile.android.commons.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SharedPreferencesBase {
    protected static final int DEFAULT_VERSION = 1;
    public static final String PREF_FILE = "default_shared_prefs";
    protected final Context mContext;
    protected final String mKeyPrefix;

    public SharedPreferencesBase(Context context, String str) {
        this.mContext = context;
        this.mKeyPrefix = str;
        onPreCheckVersion();
        m4702a();
    }

    /* JADX INFO: renamed from: a */
    private void m4702a() {
        int storedVersion = getStoredVersion();
        if (storedVersion == -1) {
            setStoredVersion(getVersion());
        } else if (storedVersion != getVersion()) {
            while (storedVersion < getVersion()) {
                storedVersion++;
                updateStoreData(storedVersion);
                setStoredVersion(storedVersion);
            }
        }
    }

    protected String buildCompleteKey(String str) {
        return this.mKeyPrefix + str;
    }

    protected boolean contains(String str) {
        return getSharedPreferences().contains(buildCompleteKey(str));
    }

    protected boolean getBooleanPreference(String str, boolean z) {
        return getSharedPreferences().getBoolean(buildCompleteKey(str), z);
    }

    protected int getIntPreference(String str, int i) {
        return getSharedPreferences().getInt(buildCompleteKey(str), i);
    }

    protected long getLongPreference(String str, long j) {
        return getSharedPreferences().getLong(buildCompleteKey(str), j);
    }

    protected SharedPreferences.Editor getSharedEditor() {
        return getSharedPreferences().edit();
    }

    protected SharedPreferences getSharedPreferences() {
        return this.mContext.getSharedPreferences(PREF_FILE, 0);
    }

    protected String getSharedPreferencesName() {
        return getClass().getSimpleName();
    }

    protected int getStoredVersion() {
        return getSharedPreferences().getInt(buildCompleteKey("VERSION"), -1);
    }

    protected String getStringPreference(String str, String str2) {
        return getSharedPreferences().getString(buildCompleteKey(str), str2);
    }

    protected Set<String> getStringSetPreference(String str, Set<String> set) {
        return getSharedPreferences().getStringSet(buildCompleteKey(str), set);
    }

    protected abstract int getVersion();

    protected void onPreCheckVersion() {
    }

    protected void removePreference(String str) {
        SharedPreferences.Editor sharedEditor = getSharedEditor();
        sharedEditor.remove(buildCompleteKey(str));
        sharedEditor.apply();
    }

    protected void setBooleanPreference(String str, boolean z) {
        SharedPreferences.Editor sharedEditor = getSharedEditor();
        sharedEditor.putBoolean(buildCompleteKey(str), z);
        sharedEditor.apply();
    }

    protected void setIntPreference(String str, int i) {
        SharedPreferences.Editor sharedEditor = getSharedEditor();
        sharedEditor.putInt(buildCompleteKey(str), i);
        sharedEditor.apply();
    }

    protected void setLongPreference(String str, long j) {
        SharedPreferences.Editor sharedEditor = getSharedEditor();
        sharedEditor.putLong(buildCompleteKey(str), j);
        sharedEditor.apply();
    }

    protected void setStoredVersion(int i) {
        SharedPreferences.Editor sharedEditor = getSharedEditor();
        sharedEditor.putInt(buildCompleteKey("VERSION"), i);
        sharedEditor.apply();
    }

    protected void setStringPreference(String str, String str2) {
        SharedPreferences.Editor sharedEditor = getSharedEditor();
        sharedEditor.putString(buildCompleteKey(str), str2);
        sharedEditor.apply();
    }

    protected void setStringSetPreference(String str, Set<String> set) {
        SharedPreferences.Editor sharedEditor = getSharedEditor();
        sharedEditor.putStringSet(buildCompleteKey(str), set);
        sharedEditor.apply();
    }

    protected abstract void updateStoreData(int i);
}
