package com.yoti.mobile.android.documentcapture.sup.data;

import com.yoti.mobile.android.documentcapture.data.AssessmentEntityToAssessmentResultMapper;
import com.yoti.mobile.android.documentcapture.sup.data.remote.SupDocumentCaptureApiService;
import com.yoti.mobile.android.documentcapture.sup.data.remote.SupDocumentUploadService;
import com.yoti.mobile.android.remote.exception.RemoteExceptionToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.core.data.repository.IResourceConfigurationCacheDataStore;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class SupDocumentRepository_Factory implements Factory<SupDocumentRepository> {
    private final Provider<AssessmentEntityToAssessmentResultMapper> assessmentEntityToAssessmentResultMapperProvider;
    private final Provider<SupDocumentCaptureApiService> documentApiServiceProvider;
    private final Provider<SupDocumentUploadService> documentUploadServiceProvider;
    private final Provider<SupDocumentEntityToDataMapper> entityToDataMapperProvider;
    private final Provider<RemoteExceptionToEntityMapper> exceptionToEntityMapperProvider;
    private final Provider<IResourceConfigurationCacheDataStore> resourceConfigDataSourceProvider;

    public SupDocumentRepository_Factory(Provider<SupDocumentUploadService> provider, Provider<SupDocumentCaptureApiService> provider2, Provider<IResourceConfigurationCacheDataStore> provider3, Provider<SupDocumentEntityToDataMapper> provider4, Provider<AssessmentEntityToAssessmentResultMapper> provider5, Provider<RemoteExceptionToEntityMapper> provider6) {
        this.documentUploadServiceProvider = provider;
        this.documentApiServiceProvider = provider2;
        this.resourceConfigDataSourceProvider = provider3;
        this.entityToDataMapperProvider = provider4;
        this.assessmentEntityToAssessmentResultMapperProvider = provider5;
        this.exceptionToEntityMapperProvider = provider6;
    }

    public static SupDocumentRepository_Factory create(Provider<SupDocumentUploadService> provider, Provider<SupDocumentCaptureApiService> provider2, Provider<IResourceConfigurationCacheDataStore> provider3, Provider<SupDocumentEntityToDataMapper> provider4, Provider<AssessmentEntityToAssessmentResultMapper> provider5, Provider<RemoteExceptionToEntityMapper> provider6) {
        return new SupDocumentRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static SupDocumentRepository newInstance(SupDocumentUploadService supDocumentUploadService, SupDocumentCaptureApiService supDocumentCaptureApiService, IResourceConfigurationCacheDataStore iResourceConfigurationCacheDataStore, SupDocumentEntityToDataMapper supDocumentEntityToDataMapper, AssessmentEntityToAssessmentResultMapper assessmentEntityToAssessmentResultMapper, RemoteExceptionToEntityMapper remoteExceptionToEntityMapper) {
        return new SupDocumentRepository(supDocumentUploadService, supDocumentCaptureApiService, iResourceConfigurationCacheDataStore, supDocumentEntityToDataMapper, assessmentEntityToAssessmentResultMapper, remoteExceptionToEntityMapper);
    }

    @Override // javax.inject.Provider
    public SupDocumentRepository get() {
        return newInstance(this.documentUploadServiceProvider.get(), this.documentApiServiceProvider.get(), this.resourceConfigDataSourceProvider.get(), this.entityToDataMapperProvider.get(), this.assessmentEntityToAssessmentResultMapperProvider.get(), this.exceptionToEntityMapperProvider.get());
    }
}
