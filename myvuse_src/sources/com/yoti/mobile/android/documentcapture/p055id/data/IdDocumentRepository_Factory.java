package com.yoti.mobile.android.documentcapture.p055id.data;

import com.yoti.mobile.android.documentcapture.data.AssessmentEntityToAssessmentResultMapper;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.DocumentCaptureApiService;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.DocumentUploadService;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class IdDocumentRepository_Factory implements Factory<IdDocumentRepository> {
    private final Provider<AssessmentEntityToAssessmentResultMapper> assessmentEntityToAssessmentResultMapperProvider;
    private final Provider<DocumentCaptureApiService> documentApiServiceProvider;
    private final Provider<DocumentEntityToDataMapper> documentEntityToDataMapperProvider;
    private final Provider<UploadExceptionToEntityMapper> exceptionToEntityMapperProvider;
    private final Provider<DocumentUploadService> uploadServiceProvider;

    public IdDocumentRepository_Factory(Provider<DocumentUploadService> provider, Provider<DocumentCaptureApiService> provider2, Provider<DocumentEntityToDataMapper> provider3, Provider<AssessmentEntityToAssessmentResultMapper> provider4, Provider<UploadExceptionToEntityMapper> provider5) {
        this.uploadServiceProvider = provider;
        this.documentApiServiceProvider = provider2;
        this.documentEntityToDataMapperProvider = provider3;
        this.assessmentEntityToAssessmentResultMapperProvider = provider4;
        this.exceptionToEntityMapperProvider = provider5;
    }

    public static IdDocumentRepository_Factory create(Provider<DocumentUploadService> provider, Provider<DocumentCaptureApiService> provider2, Provider<DocumentEntityToDataMapper> provider3, Provider<AssessmentEntityToAssessmentResultMapper> provider4, Provider<UploadExceptionToEntityMapper> provider5) {
        return new IdDocumentRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static IdDocumentRepository newInstance(DocumentUploadService documentUploadService, DocumentCaptureApiService documentCaptureApiService, DocumentEntityToDataMapper documentEntityToDataMapper, AssessmentEntityToAssessmentResultMapper assessmentEntityToAssessmentResultMapper, UploadExceptionToEntityMapper uploadExceptionToEntityMapper) {
        return new IdDocumentRepository(documentUploadService, documentCaptureApiService, documentEntityToDataMapper, assessmentEntityToAssessmentResultMapper, uploadExceptionToEntityMapper);
    }

    @Override // javax.inject.Provider
    public IdDocumentRepository get() {
        return newInstance(this.uploadServiceProvider.get(), this.documentApiServiceProvider.get(), this.documentEntityToDataMapperProvider.get(), this.assessmentEntityToAssessmentResultMapperProvider.get(), this.exceptionToEntityMapperProvider.get());
    }
}
