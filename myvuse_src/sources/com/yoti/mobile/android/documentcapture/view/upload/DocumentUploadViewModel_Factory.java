package com.yoti.mobile.android.documentcapture.view.upload;

import com.yoti.mobile.android.documentcapture.domain.IDocumentCleanupInteractor;
import com.yoti.mobile.android.documentcapture.domain.UploadDocumentInteractor;
import com.yoti.mobile.android.documentcapture.domain.model.IDocumentEntity;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.SuspendMapper;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentUploadViewModel_Factory implements Factory<DocumentUploadViewModel> {
    private final Provider<IDocumentCleanupInteractor> documentCleanupInteractorProvider;
    private final Provider<SuspendMapper<IDocumentViewData, IDocumentEntity>> documentScanResultViewDataToEntityMapperProvider;
    private final Provider<Mapper<Throwable, YdsFailure>> errorToFailureMapperProvider;
    private final Provider<ErrorToSessionStatusTypeMapper> errorToSessionStatusTypeMapperProvider;
    private final Provider<SessionStatus> sessionStatusProvider;
    private final Provider<UploadDocumentInteractor> uploadDocumentInteractorProvider;

    public DocumentUploadViewModel_Factory(Provider<UploadDocumentInteractor> provider, Provider<IDocumentCleanupInteractor> provider2, Provider<SuspendMapper<IDocumentViewData, IDocumentEntity>> provider3, Provider<SessionStatus> provider4, Provider<ErrorToSessionStatusTypeMapper> provider5, Provider<Mapper<Throwable, YdsFailure>> provider6) {
        this.uploadDocumentInteractorProvider = provider;
        this.documentCleanupInteractorProvider = provider2;
        this.documentScanResultViewDataToEntityMapperProvider = provider3;
        this.sessionStatusProvider = provider4;
        this.errorToSessionStatusTypeMapperProvider = provider5;
        this.errorToFailureMapperProvider = provider6;
    }

    public static DocumentUploadViewModel_Factory create(Provider<UploadDocumentInteractor> provider, Provider<IDocumentCleanupInteractor> provider2, Provider<SuspendMapper<IDocumentViewData, IDocumentEntity>> provider3, Provider<SessionStatus> provider4, Provider<ErrorToSessionStatusTypeMapper> provider5, Provider<Mapper<Throwable, YdsFailure>> provider6) {
        return new DocumentUploadViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static DocumentUploadViewModel newInstance(UploadDocumentInteractor uploadDocumentInteractor, IDocumentCleanupInteractor iDocumentCleanupInteractor, SuspendMapper<IDocumentViewData, IDocumentEntity> suspendMapper, SessionStatus sessionStatus, ErrorToSessionStatusTypeMapper errorToSessionStatusTypeMapper, Mapper<Throwable, YdsFailure> mapper) {
        return new DocumentUploadViewModel(uploadDocumentInteractor, iDocumentCleanupInteractor, suspendMapper, sessionStatus, errorToSessionStatusTypeMapper, mapper);
    }

    @Override // javax.inject.Provider
    public DocumentUploadViewModel get() {
        return newInstance(this.uploadDocumentInteractorProvider.get(), this.documentCleanupInteractorProvider.get(), this.documentScanResultViewDataToEntityMapperProvider.get(), this.sessionStatusProvider.get(), this.errorToSessionStatusTypeMapperProvider.get(), this.errorToFailureMapperProvider.get());
    }
}
