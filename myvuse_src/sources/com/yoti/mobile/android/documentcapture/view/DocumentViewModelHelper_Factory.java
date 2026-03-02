package com.yoti.mobile.android.documentcapture.view;

import com.yoti.mobile.android.documentcapture.domain.DocumentFeatureErrorToSessionStatusTypeMapper;
import com.yoti.mobile.android.documentcapture.domain.GetDocumentCaptureConfigurationInteractor;
import com.yoti.mobile.android.documentcapture.domain.GetScanConfigurationInteractor;
import com.yoti.mobile.android.documentcapture.domain.model.IScanConfigurationEntity;
import com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsFragment;
import com.yoti.mobile.android.documentcapture.view.scan.IScanConfigurationViewData;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeEntityToViewDataMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentViewModelHelper_Factory implements Factory<DocumentViewModelHelper> {
    private final Provider<AdditionalInstructionsFragment.FragmentArgsFactory> additionalInstructionsFragmentArgsFactoryProvider;
    private final Provider<DocumentTypeEntityToViewDataMapper> documentTypeEntityToViewDataMapperProvider;
    private final Provider<Mapper<Throwable, YdsFailure>> errorToFailureMapperProvider;
    private final Provider<DocumentFeatureErrorToSessionStatusTypeMapper> errorToSessionStatusTypeMapperProvider;
    private final Provider<DocumentCaptureConfiguration> featureConfigurationProvider;
    private final Provider<GetDocumentCaptureConfigurationInteractor> getDocumentCaptureConfigurationInteractorProvider;
    private final Provider<GetScanConfigurationInteractor> getScanConfigurationInteractorProvider;
    private final Provider<Mapper<IScanConfigurationEntity, IScanConfigurationViewData>> scanConfigurationEntityToViewDataMapperProvider;
    private final Provider<SessionStatus> sessionStatusProvider;

    public DocumentViewModelHelper_Factory(Provider<GetDocumentCaptureConfigurationInteractor> provider, Provider<GetScanConfigurationInteractor> provider2, Provider<SessionStatus> provider3, Provider<DocumentCaptureConfiguration> provider4, Provider<AdditionalInstructionsFragment.FragmentArgsFactory> provider5, Provider<DocumentTypeEntityToViewDataMapper> provider6, Provider<Mapper<Throwable, YdsFailure>> provider7, Provider<Mapper<IScanConfigurationEntity, IScanConfigurationViewData>> provider8, Provider<DocumentFeatureErrorToSessionStatusTypeMapper> provider9) {
        this.getDocumentCaptureConfigurationInteractorProvider = provider;
        this.getScanConfigurationInteractorProvider = provider2;
        this.sessionStatusProvider = provider3;
        this.featureConfigurationProvider = provider4;
        this.additionalInstructionsFragmentArgsFactoryProvider = provider5;
        this.documentTypeEntityToViewDataMapperProvider = provider6;
        this.errorToFailureMapperProvider = provider7;
        this.scanConfigurationEntityToViewDataMapperProvider = provider8;
        this.errorToSessionStatusTypeMapperProvider = provider9;
    }

    public static DocumentViewModelHelper_Factory create(Provider<GetDocumentCaptureConfigurationInteractor> provider, Provider<GetScanConfigurationInteractor> provider2, Provider<SessionStatus> provider3, Provider<DocumentCaptureConfiguration> provider4, Provider<AdditionalInstructionsFragment.FragmentArgsFactory> provider5, Provider<DocumentTypeEntityToViewDataMapper> provider6, Provider<Mapper<Throwable, YdsFailure>> provider7, Provider<Mapper<IScanConfigurationEntity, IScanConfigurationViewData>> provider8, Provider<DocumentFeatureErrorToSessionStatusTypeMapper> provider9) {
        return new DocumentViewModelHelper_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static DocumentViewModelHelper newInstance(GetDocumentCaptureConfigurationInteractor getDocumentCaptureConfigurationInteractor, GetScanConfigurationInteractor getScanConfigurationInteractor, SessionStatus sessionStatus, DocumentCaptureConfiguration documentCaptureConfiguration, AdditionalInstructionsFragment.FragmentArgsFactory fragmentArgsFactory, DocumentTypeEntityToViewDataMapper documentTypeEntityToViewDataMapper, Mapper<Throwable, YdsFailure> mapper, Mapper<IScanConfigurationEntity, IScanConfigurationViewData> mapper2, DocumentFeatureErrorToSessionStatusTypeMapper documentFeatureErrorToSessionStatusTypeMapper) {
        return new DocumentViewModelHelper(getDocumentCaptureConfigurationInteractor, getScanConfigurationInteractor, sessionStatus, documentCaptureConfiguration, fragmentArgsFactory, documentTypeEntityToViewDataMapper, mapper, mapper2, documentFeatureErrorToSessionStatusTypeMapper);
    }

    @Override // javax.inject.Provider
    public DocumentViewModelHelper get() {
        return newInstance(this.getDocumentCaptureConfigurationInteractorProvider.get(), this.getScanConfigurationInteractorProvider.get(), this.sessionStatusProvider.get(), this.featureConfigurationProvider.get(), this.additionalInstructionsFragmentArgsFactoryProvider.get(), this.documentTypeEntityToViewDataMapperProvider.get(), this.errorToFailureMapperProvider.get(), this.scanConfigurationEntityToViewDataMapperProvider.get(), this.errorToSessionStatusTypeMapperProvider.get());
    }
}
