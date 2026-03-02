package com.yoti.mobile.android.documentcapture.data;

import com.yoti.mobile.android.yotisdkcore.core.data.DataExceptionToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.core.data.repository.IResourceConfigurationCacheDataStore;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentResourceConfigurationToEntityMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentResourceConfigurationRepository_Factory implements Factory<DocumentResourceConfigurationRepository> {
    private final Provider<DataExceptionToEntityMapper> errorMapperProvider;
    private final Provider<IResourceConfigurationCacheDataStore> resourceConfigurationDataSourceProvider;
    private final Provider<DocumentResourceConfigurationToEntityMapper> resourceMapperProvider;

    public DocumentResourceConfigurationRepository_Factory(Provider<IResourceConfigurationCacheDataStore> provider, Provider<DocumentResourceConfigurationToEntityMapper> provider2, Provider<DataExceptionToEntityMapper> provider3) {
        this.resourceConfigurationDataSourceProvider = provider;
        this.resourceMapperProvider = provider2;
        this.errorMapperProvider = provider3;
    }

    public static DocumentResourceConfigurationRepository_Factory create(Provider<IResourceConfigurationCacheDataStore> provider, Provider<DocumentResourceConfigurationToEntityMapper> provider2, Provider<DataExceptionToEntityMapper> provider3) {
        return new DocumentResourceConfigurationRepository_Factory(provider, provider2, provider3);
    }

    public static DocumentResourceConfigurationRepository newInstance(IResourceConfigurationCacheDataStore iResourceConfigurationCacheDataStore, DocumentResourceConfigurationToEntityMapper documentResourceConfigurationToEntityMapper, DataExceptionToEntityMapper dataExceptionToEntityMapper) {
        return new DocumentResourceConfigurationRepository(iResourceConfigurationCacheDataStore, documentResourceConfigurationToEntityMapper, dataExceptionToEntityMapper);
    }

    @Override // javax.inject.Provider
    public DocumentResourceConfigurationRepository get() {
        return newInstance(this.resourceConfigurationDataSourceProvider.get(), this.resourceMapperProvider.get(), this.errorMapperProvider.get());
    }
}
