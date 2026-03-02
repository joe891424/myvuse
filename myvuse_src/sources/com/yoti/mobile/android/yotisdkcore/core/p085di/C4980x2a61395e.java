package com.yoti.mobile.android.yotisdkcore.core.p085di;

import com.yoti.mobile.android.yotisdkcore.core.data.cache.ResourceConfigurationCacheDataStore;
import com.yoti.mobile.android.yotisdkcore.core.data.repository.IResourceConfigurationCacheDataStore;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.core.di.ResourceConfigurationModule_ProvidesResourceConfigurationDataStoreFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4980x2a61395e implements Factory<IResourceConfigurationCacheDataStore> {
    private final ResourceConfigurationModule module;
    private final Provider<ResourceConfigurationCacheDataStore> resourceConfigurationDataStoreProvider;

    public C4980x2a61395e(ResourceConfigurationModule resourceConfigurationModule, Provider<ResourceConfigurationCacheDataStore> provider) {
        this.module = resourceConfigurationModule;
        this.resourceConfigurationDataStoreProvider = provider;
    }

    public static C4980x2a61395e create(ResourceConfigurationModule resourceConfigurationModule, Provider<ResourceConfigurationCacheDataStore> provider) {
        return new C4980x2a61395e(resourceConfigurationModule, provider);
    }

    public static IResourceConfigurationCacheDataStore providesResourceConfigurationDataStore(ResourceConfigurationModule resourceConfigurationModule, ResourceConfigurationCacheDataStore resourceConfigurationCacheDataStore) {
        return (IResourceConfigurationCacheDataStore) Preconditions.checkNotNullFromProvides(resourceConfigurationModule.providesResourceConfigurationDataStore(resourceConfigurationCacheDataStore));
    }

    @Override // javax.inject.Provider
    public IResourceConfigurationCacheDataStore get() {
        return providesResourceConfigurationDataStore(this.module, this.resourceConfigurationDataStoreProvider.get());
    }
}
