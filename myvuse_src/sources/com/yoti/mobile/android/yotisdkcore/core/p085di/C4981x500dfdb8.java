package com.yoti.mobile.android.yotisdkcore.core.p085di;

import com.yoti.mobile.android.yotisdkcore.core.data.cache.SessionConfigurationCacheDataStore;
import com.yoti.mobile.android.yotisdkcore.core.data.repository.ISessionConfigurationCacheDataStore;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.core.di.SessionConfigurationModule_ProvidesSessionConfigurationDataStoreFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4981x500dfdb8 implements Factory<ISessionConfigurationCacheDataStore> {
    private final Provider<SessionConfigurationCacheDataStore> dataStoreProvider;
    private final SessionConfigurationModule module;

    public C4981x500dfdb8(SessionConfigurationModule sessionConfigurationModule, Provider<SessionConfigurationCacheDataStore> provider) {
        this.module = sessionConfigurationModule;
        this.dataStoreProvider = provider;
    }

    public static C4981x500dfdb8 create(SessionConfigurationModule sessionConfigurationModule, Provider<SessionConfigurationCacheDataStore> provider) {
        return new C4981x500dfdb8(sessionConfigurationModule, provider);
    }

    public static ISessionConfigurationCacheDataStore providesSessionConfigurationDataStore(SessionConfigurationModule sessionConfigurationModule, SessionConfigurationCacheDataStore sessionConfigurationCacheDataStore) {
        return (ISessionConfigurationCacheDataStore) Preconditions.checkNotNullFromProvides(sessionConfigurationModule.providesSessionConfigurationDataStore(sessionConfigurationCacheDataStore));
    }

    @Override // javax.inject.Provider
    public ISessionConfigurationCacheDataStore get() {
        return providesSessionConfigurationDataStore(this.module, this.dataStoreProvider.get());
    }
}
