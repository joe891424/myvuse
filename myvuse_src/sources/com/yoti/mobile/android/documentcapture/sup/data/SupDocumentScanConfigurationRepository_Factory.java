package com.yoti.mobile.android.documentcapture.sup.data;

import com.yoti.mobile.android.documentcapture.sup.data.cache.SupDocumentScanConfigurationCacheDataSource;
import com.yoti.mobile.android.documentcapture.sup.data.remote.SupDocumentScanConfigurationService;
import com.yoti.mobile.android.remote.exception.RemoteExceptionToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentTypeEntityToDataMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class SupDocumentScanConfigurationRepository_Factory implements Factory<SupDocumentScanConfigurationRepository> {
    private final Provider<SupDocumentScanConfigurationCacheDataSource> configurationCacheDataSourceProvider;
    private final Provider<SupDocumentScanConfigurationService> configurationServiceProvider;
    private final Provider<DocumentTypeEntityToDataMapper> documentTypeEntityToDataMapperProvider;
    private final Provider<RemoteExceptionToEntityMapper> exceptionToEntityMapperProvider;
    private final Provider<String> requirementIdProvider;
    private final Provider<SupDocumentScanConfigDataToEntityMapper> scanConfigDataToEntityMapperProvider;

    public SupDocumentScanConfigurationRepository_Factory(Provider<SupDocumentScanConfigurationService> provider, Provider<SupDocumentScanConfigurationCacheDataSource> provider2, Provider<String> provider3, Provider<SupDocumentScanConfigDataToEntityMapper> provider4, Provider<DocumentTypeEntityToDataMapper> provider5, Provider<RemoteExceptionToEntityMapper> provider6) {
        this.configurationServiceProvider = provider;
        this.configurationCacheDataSourceProvider = provider2;
        this.requirementIdProvider = provider3;
        this.scanConfigDataToEntityMapperProvider = provider4;
        this.documentTypeEntityToDataMapperProvider = provider5;
        this.exceptionToEntityMapperProvider = provider6;
    }

    public static SupDocumentScanConfigurationRepository_Factory create(Provider<SupDocumentScanConfigurationService> provider, Provider<SupDocumentScanConfigurationCacheDataSource> provider2, Provider<String> provider3, Provider<SupDocumentScanConfigDataToEntityMapper> provider4, Provider<DocumentTypeEntityToDataMapper> provider5, Provider<RemoteExceptionToEntityMapper> provider6) {
        return new SupDocumentScanConfigurationRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static SupDocumentScanConfigurationRepository newInstance(SupDocumentScanConfigurationService supDocumentScanConfigurationService, SupDocumentScanConfigurationCacheDataSource supDocumentScanConfigurationCacheDataSource, String str, SupDocumentScanConfigDataToEntityMapper supDocumentScanConfigDataToEntityMapper, DocumentTypeEntityToDataMapper documentTypeEntityToDataMapper, RemoteExceptionToEntityMapper remoteExceptionToEntityMapper) {
        return new SupDocumentScanConfigurationRepository(supDocumentScanConfigurationService, supDocumentScanConfigurationCacheDataSource, str, supDocumentScanConfigDataToEntityMapper, documentTypeEntityToDataMapper, remoteExceptionToEntityMapper);
    }

    @Override // javax.inject.Provider
    public SupDocumentScanConfigurationRepository get() {
        return newInstance(this.configurationServiceProvider.get(), this.configurationCacheDataSourceProvider.get(), this.requirementIdProvider.get(), this.scanConfigDataToEntityMapperProvider.get(), this.documentTypeEntityToDataMapperProvider.get(), this.exceptionToEntityMapperProvider.get());
    }
}
