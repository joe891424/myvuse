package com.yoti.mobile.android.documentcapture.view.selection;

import com.yoti.mobile.android.documentcapture.domain.DocumentFeatureErrorToSessionStatusTypeMapper;
import com.yoti.mobile.android.documentcapture.view.DocumentViewModelHelper;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentSelectionViewModel_Factory implements Factory<DocumentSelectionViewModel> {
    private final Provider<Mapper<DocumentResourceConfigEntity, DocumentSelectionViewData>> documentResourceConfigEntityToViewDataMapperProvider;
    private final Provider<DocumentTypeViewDataToEntityMapper> documentTypeViewDataToEntityMapperProvider;
    private final Provider<DocumentViewModelHelper> documentViewModelHelperProvider;
    private final Provider<Mapper<Throwable, YdsFailure>> errorToFailureMapperProvider;
    private final Provider<DocumentFeatureErrorToSessionStatusTypeMapper> errorToSessionStatusTypeMapperProvider;
    private final Provider<DocumentCaptureConfiguration> featureConfigurationProvider;
    private final Provider<SessionStatus> sessionStatusProvider;

    public DocumentSelectionViewModel_Factory(Provider<DocumentViewModelHelper> provider, Provider<SessionStatus> provider2, Provider<Mapper<DocumentResourceConfigEntity, DocumentSelectionViewData>> provider3, Provider<DocumentTypeViewDataToEntityMapper> provider4, Provider<Mapper<Throwable, YdsFailure>> provider5, Provider<DocumentFeatureErrorToSessionStatusTypeMapper> provider6, Provider<DocumentCaptureConfiguration> provider7) {
        this.documentViewModelHelperProvider = provider;
        this.sessionStatusProvider = provider2;
        this.documentResourceConfigEntityToViewDataMapperProvider = provider3;
        this.documentTypeViewDataToEntityMapperProvider = provider4;
        this.errorToFailureMapperProvider = provider5;
        this.errorToSessionStatusTypeMapperProvider = provider6;
        this.featureConfigurationProvider = provider7;
    }

    public static DocumentSelectionViewModel_Factory create(Provider<DocumentViewModelHelper> provider, Provider<SessionStatus> provider2, Provider<Mapper<DocumentResourceConfigEntity, DocumentSelectionViewData>> provider3, Provider<DocumentTypeViewDataToEntityMapper> provider4, Provider<Mapper<Throwable, YdsFailure>> provider5, Provider<DocumentFeatureErrorToSessionStatusTypeMapper> provider6, Provider<DocumentCaptureConfiguration> provider7) {
        return new DocumentSelectionViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static DocumentSelectionViewModel newInstance(DocumentViewModelHelper documentViewModelHelper, SessionStatus sessionStatus, Mapper<DocumentResourceConfigEntity, DocumentSelectionViewData> mapper, DocumentTypeViewDataToEntityMapper documentTypeViewDataToEntityMapper, Mapper<Throwable, YdsFailure> mapper2, DocumentFeatureErrorToSessionStatusTypeMapper documentFeatureErrorToSessionStatusTypeMapper, DocumentCaptureConfiguration documentCaptureConfiguration) {
        return new DocumentSelectionViewModel(documentViewModelHelper, sessionStatus, mapper, documentTypeViewDataToEntityMapper, mapper2, documentFeatureErrorToSessionStatusTypeMapper, documentCaptureConfiguration);
    }

    @Override // javax.inject.Provider
    public DocumentSelectionViewModel get() {
        return newInstance(this.documentViewModelHelperProvider.get(), this.sessionStatusProvider.get(), this.documentResourceConfigEntityToViewDataMapperProvider.get(), this.documentTypeViewDataToEntityMapperProvider.get(), this.errorToFailureMapperProvider.get(), this.errorToSessionStatusTypeMapperProvider.get(), this.featureConfigurationProvider.get());
    }
}
