package com.yoti.mobile.android.yotisdkcore.core.data;

import android.content.SharedPreferences;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class SessionStatusRepository_Factory implements Factory<SessionStatusRepository> {
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    public SessionStatusRepository_Factory(Provider<SharedPreferences> provider) {
        this.sharedPreferencesProvider = provider;
    }

    public static SessionStatusRepository_Factory create(Provider<SharedPreferences> provider) {
        return new SessionStatusRepository_Factory(provider);
    }

    public static SessionStatusRepository newInstance(SharedPreferences sharedPreferences) {
        return new SessionStatusRepository(sharedPreferences);
    }

    @Override // javax.inject.Provider
    public SessionStatusRepository get() {
        return newInstance(this.sharedPreferencesProvider.get());
    }
}
