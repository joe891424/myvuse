package com.yoti.mobile.android.yotisdkcore.core.data.cache;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class SessionConfigurationCacheDataStore_Factory implements Factory<SessionConfigurationCacheDataStore> {
    private final Provider<Gson> gsonProvider;
    private final Provider<SharedPreferences> preferencesProvider;

    public SessionConfigurationCacheDataStore_Factory(Provider<SharedPreferences> provider, Provider<Gson> provider2) {
        this.preferencesProvider = provider;
        this.gsonProvider = provider2;
    }

    public static SessionConfigurationCacheDataStore_Factory create(Provider<SharedPreferences> provider, Provider<Gson> provider2) {
        return new SessionConfigurationCacheDataStore_Factory(provider, provider2);
    }

    public static SessionConfigurationCacheDataStore newInstance(SharedPreferences sharedPreferences, Gson gson) {
        return new SessionConfigurationCacheDataStore(sharedPreferences, gson);
    }

    @Override // javax.inject.Provider
    public SessionConfigurationCacheDataStore get() {
        return newInstance(this.preferencesProvider.get(), this.gsonProvider.get());
    }
}
