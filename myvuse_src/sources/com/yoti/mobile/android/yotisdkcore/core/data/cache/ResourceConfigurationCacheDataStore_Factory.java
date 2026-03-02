package com.yoti.mobile.android.yotisdkcore.core.data.cache;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class ResourceConfigurationCacheDataStore_Factory implements Factory<ResourceConfigurationCacheDataStore> {
    private final Provider<Gson> gsonProvider;
    private final Provider<SharedPreferences> preferencesProvider;
    private final Provider<String> requirementIdProvider;

    public ResourceConfigurationCacheDataStore_Factory(Provider<SharedPreferences> provider, Provider<String> provider2, Provider<Gson> provider3) {
        this.preferencesProvider = provider;
        this.requirementIdProvider = provider2;
        this.gsonProvider = provider3;
    }

    public static ResourceConfigurationCacheDataStore_Factory create(Provider<SharedPreferences> provider, Provider<String> provider2, Provider<Gson> provider3) {
        return new ResourceConfigurationCacheDataStore_Factory(provider, provider2, provider3);
    }

    public static ResourceConfigurationCacheDataStore newInstance(SharedPreferences sharedPreferences, String str, Gson gson) {
        return new ResourceConfigurationCacheDataStore(sharedPreferences, str, gson);
    }

    @Override // javax.inject.Provider
    public ResourceConfigurationCacheDataStore get() {
        return newInstance(this.preferencesProvider.get(), this.requirementIdProvider.get(), this.gsonProvider.get());
    }
}
