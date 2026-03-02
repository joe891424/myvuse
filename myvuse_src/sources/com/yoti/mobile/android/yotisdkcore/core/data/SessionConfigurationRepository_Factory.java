package com.yoti.mobile.android.yotisdkcore.core.data;

import com.yoti.mobile.android.yotisdkcore.core.data.remote.SessionConfigurationService;
import com.yoti.mobile.android.yotisdkcore.core.data.repository.ISessionConfigurationCacheDataStore;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class SessionConfigurationRepository_Factory implements Factory<SessionConfigurationRepository> {
    private final Provider<ISessionConfigurationCacheDataStore> configurationCacheProvider;
    private final Provider<SessionConfigurationService> configurationServiceProvider;
    private final Provider<DataExceptionToEntityMapper> exceptionToEntityMapperProvider;
    private final Provider<SessionConfigurationDataToEntityMapper> sessionConfigurationDataToEntityMapperProvider;

    public SessionConfigurationRepository_Factory(Provider<SessionConfigurationService> provider, Provider<ISessionConfigurationCacheDataStore> provider2, Provider<SessionConfigurationDataToEntityMapper> provider3, Provider<DataExceptionToEntityMapper> provider4) {
        this.configurationServiceProvider = provider;
        this.configurationCacheProvider = provider2;
        this.sessionConfigurationDataToEntityMapperProvider = provider3;
        this.exceptionToEntityMapperProvider = provider4;
    }

    public static SessionConfigurationRepository_Factory create(Provider<SessionConfigurationService> provider, Provider<ISessionConfigurationCacheDataStore> provider2, Provider<SessionConfigurationDataToEntityMapper> provider3, Provider<DataExceptionToEntityMapper> provider4) {
        return new SessionConfigurationRepository_Factory(provider, provider2, provider3, provider4);
    }

    public static SessionConfigurationRepository newInstance(SessionConfigurationService sessionConfigurationService, ISessionConfigurationCacheDataStore iSessionConfigurationCacheDataStore, SessionConfigurationDataToEntityMapper sessionConfigurationDataToEntityMapper, DataExceptionToEntityMapper dataExceptionToEntityMapper) {
        return new SessionConfigurationRepository(sessionConfigurationService, iSessionConfigurationCacheDataStore, sessionConfigurationDataToEntityMapper, dataExceptionToEntityMapper);
    }

    @Override // javax.inject.Provider
    public SessionConfigurationRepository get() {
        return newInstance(this.configurationServiceProvider.get(), this.configurationCacheProvider.get(), this.sessionConfigurationDataToEntityMapperProvider.get(), this.exceptionToEntityMapperProvider.get());
    }
}
