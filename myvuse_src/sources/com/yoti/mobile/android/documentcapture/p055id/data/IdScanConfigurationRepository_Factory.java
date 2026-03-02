package com.yoti.mobile.android.documentcapture.p055id.data;

import com.yoti.mobile.android.documentcapture.p055id.data.remote.ScanConfigurationService;
import com.yoti.mobile.android.remote.exception.RemoteExceptionToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.core.data.repository.IResourceConfigurationCacheDataStore;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentTypeEntityToDataMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class IdScanConfigurationRepository_Factory implements Factory<IdScanConfigurationRepository> {
    private final Provider<ScanConfigurationService> configurationServiceProvider;
    private final Provider<DocumentTypeEntityToDataMapper> documentTypeEntityToDataMapperProvider;
    private final Provider<RemoteExceptionToEntityMapper> exceptionToEntityMapperProvider;
    private final Provider<String> requirementIdProvider;
    private final Provider<IResourceConfigurationCacheDataStore> resourceConfigDataSourceProvider;
    private final Provider<ScanConfigurationDataToEntityMapper> scanConfigurationDataToEntityMapperProvider;

    public IdScanConfigurationRepository_Factory(Provider<ScanConfigurationService> provider, Provider<IResourceConfigurationCacheDataStore> provider2, Provider<String> provider3, Provider<ScanConfigurationDataToEntityMapper> provider4, Provider<DocumentTypeEntityToDataMapper> provider5, Provider<RemoteExceptionToEntityMapper> provider6) {
        this.configurationServiceProvider = provider;
        this.resourceConfigDataSourceProvider = provider2;
        this.requirementIdProvider = provider3;
        this.scanConfigurationDataToEntityMapperProvider = provider4;
        this.documentTypeEntityToDataMapperProvider = provider5;
        this.exceptionToEntityMapperProvider = provider6;
    }

    public static IdScanConfigurationRepository_Factory create(Provider<ScanConfigurationService> provider, Provider<IResourceConfigurationCacheDataStore> provider2, Provider<String> provider3, Provider<ScanConfigurationDataToEntityMapper> provider4, Provider<DocumentTypeEntityToDataMapper> provider5, Provider<RemoteExceptionToEntityMapper> provider6) {
        return new IdScanConfigurationRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static IdScanConfigurationRepository newInstance(ScanConfigurationService scanConfigurationService, IResourceConfigurationCacheDataStore iResourceConfigurationCacheDataStore, String str, ScanConfigurationDataToEntityMapper scanConfigurationDataToEntityMapper, DocumentTypeEntityToDataMapper documentTypeEntityToDataMapper, RemoteExceptionToEntityMapper remoteExceptionToEntityMapper) {
        return new IdScanConfigurationRepository(scanConfigurationService, iResourceConfigurationCacheDataStore, str, scanConfigurationDataToEntityMapper, documentTypeEntityToDataMapper, remoteExceptionToEntityMapper);
    }

    @Override // javax.inject.Provider
    public IdScanConfigurationRepository get() {
        return newInstance(this.configurationServiceProvider.get(), this.resourceConfigDataSourceProvider.get(), this.requirementIdProvider.get(), this.scanConfigurationDataToEntityMapperProvider.get(), this.documentTypeEntityToDataMapperProvider.get(), this.exceptionToEntityMapperProvider.get());
    }
}
