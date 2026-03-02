package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import com.yoti.mobile.android.documentcapture.p055id.domain.CaptureStorage;
import com.yoti.mobile.android.documentcapture.p055id.domain.GetNfcFlowTypeInteractor;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper;
import com.yoti.mobile.android.documentcapture.p055id.view.verify.DocumentScanResultViewDataToBacCredentialMapper;
import com.yoti.mobile.android.yotidocs.common.error.ExceptionToFailureMapper;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentScanViewModel_Factory implements Factory<DocumentScanViewModel> {
    private final Provider<DocumentScanResultViewDataToBacCredentialMapper> bacCredentialMapperProvider;
    private final Provider<CaptureStorage> captureStorageProvider;
    private final Provider<DocumentScanResultsToDocumentScanResultViewDataMapper> documentCaptureResultToResultViewDataMapperProvider;
    private final Provider<DocumentCaptureResultToPageScanReviewViewDataMapper> documentCaptureResultToReviewViewDataMapperProvider;
    private final Provider<IdDocumentScanResultViewDataToEntityMapper> documentCaptureViewDataToEntityMapperProvider;
    private final Provider<ScanErrorToEntityMapper> errorToEntityMapperProvider;
    private final Provider<ExceptionToFailureMapper> errorToFailureMapperProvider;
    private final Provider<ScanErrorToSessionStatusTypeMapper> errorToSessionStatusMapperProvider;
    private final Provider<GetNfcFlowTypeInteractor> getNfcFlowTypeProvider;
    private final Provider<SessionStatus> sessionStatusProvider;

    public DocumentScanViewModel_Factory(Provider<GetNfcFlowTypeInteractor> provider, Provider<CaptureStorage> provider2, Provider<SessionStatus> provider3, Provider<DocumentScanResultViewDataToBacCredentialMapper> provider4, Provider<DocumentCaptureResultToPageScanReviewViewDataMapper> provider5, Provider<DocumentScanResultsToDocumentScanResultViewDataMapper> provider6, Provider<IdDocumentScanResultViewDataToEntityMapper> provider7, Provider<ScanErrorToEntityMapper> provider8, Provider<ExceptionToFailureMapper> provider9, Provider<ScanErrorToSessionStatusTypeMapper> provider10) {
        this.getNfcFlowTypeProvider = provider;
        this.captureStorageProvider = provider2;
        this.sessionStatusProvider = provider3;
        this.bacCredentialMapperProvider = provider4;
        this.documentCaptureResultToReviewViewDataMapperProvider = provider5;
        this.documentCaptureResultToResultViewDataMapperProvider = provider6;
        this.documentCaptureViewDataToEntityMapperProvider = provider7;
        this.errorToEntityMapperProvider = provider8;
        this.errorToFailureMapperProvider = provider9;
        this.errorToSessionStatusMapperProvider = provider10;
    }

    public static DocumentScanViewModel_Factory create(Provider<GetNfcFlowTypeInteractor> provider, Provider<CaptureStorage> provider2, Provider<SessionStatus> provider3, Provider<DocumentScanResultViewDataToBacCredentialMapper> provider4, Provider<DocumentCaptureResultToPageScanReviewViewDataMapper> provider5, Provider<DocumentScanResultsToDocumentScanResultViewDataMapper> provider6, Provider<IdDocumentScanResultViewDataToEntityMapper> provider7, Provider<ScanErrorToEntityMapper> provider8, Provider<ExceptionToFailureMapper> provider9, Provider<ScanErrorToSessionStatusTypeMapper> provider10) {
        return new DocumentScanViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static DocumentScanViewModel newInstance(GetNfcFlowTypeInteractor getNfcFlowTypeInteractor, CaptureStorage captureStorage, SessionStatus sessionStatus, DocumentScanResultViewDataToBacCredentialMapper documentScanResultViewDataToBacCredentialMapper, DocumentCaptureResultToPageScanReviewViewDataMapper documentCaptureResultToPageScanReviewViewDataMapper, DocumentScanResultsToDocumentScanResultViewDataMapper documentScanResultsToDocumentScanResultViewDataMapper, IdDocumentScanResultViewDataToEntityMapper idDocumentScanResultViewDataToEntityMapper, ScanErrorToEntityMapper scanErrorToEntityMapper, ExceptionToFailureMapper exceptionToFailureMapper, ScanErrorToSessionStatusTypeMapper scanErrorToSessionStatusTypeMapper) {
        return new DocumentScanViewModel(getNfcFlowTypeInteractor, captureStorage, sessionStatus, documentScanResultViewDataToBacCredentialMapper, documentCaptureResultToPageScanReviewViewDataMapper, documentScanResultsToDocumentScanResultViewDataMapper, idDocumentScanResultViewDataToEntityMapper, scanErrorToEntityMapper, exceptionToFailureMapper, scanErrorToSessionStatusTypeMapper);
    }

    @Override // javax.inject.Provider
    public DocumentScanViewModel get() {
        return newInstance(this.getNfcFlowTypeProvider.get(), this.captureStorageProvider.get(), this.sessionStatusProvider.get(), this.bacCredentialMapperProvider.get(), this.documentCaptureResultToReviewViewDataMapperProvider.get(), this.documentCaptureResultToResultViewDataMapperProvider.get(), this.documentCaptureViewDataToEntityMapperProvider.get(), this.errorToEntityMapperProvider.get(), this.errorToFailureMapperProvider.get(), this.errorToSessionStatusMapperProvider.get());
    }
}
