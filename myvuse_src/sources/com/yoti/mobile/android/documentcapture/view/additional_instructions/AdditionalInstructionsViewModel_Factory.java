package com.yoti.mobile.android.documentcapture.view.additional_instructions;

import com.yoti.mobile.android.documentcapture.view.DocumentViewModelHelper;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentTypeViewDataToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class AdditionalInstructionsViewModel_Factory implements Factory<AdditionalInstructionsViewModel> {
    private final Provider<DocumentTypeViewDataToEntityMapper> documentTypeViewDataToEntityMapperProvider;
    private final Provider<DocumentViewModelHelper> documentViewModelHelperProvider;
    private final Provider<DocumentCaptureConfiguration> featureConfigurationProvider;
    private final Provider<SessionStatus> sessionStatusProvider;

    public AdditionalInstructionsViewModel_Factory(Provider<DocumentViewModelHelper> provider, Provider<DocumentCaptureConfiguration> provider2, Provider<SessionStatus> provider3, Provider<DocumentTypeViewDataToEntityMapper> provider4) {
        this.documentViewModelHelperProvider = provider;
        this.featureConfigurationProvider = provider2;
        this.sessionStatusProvider = provider3;
        this.documentTypeViewDataToEntityMapperProvider = provider4;
    }

    public static AdditionalInstructionsViewModel_Factory create(Provider<DocumentViewModelHelper> provider, Provider<DocumentCaptureConfiguration> provider2, Provider<SessionStatus> provider3, Provider<DocumentTypeViewDataToEntityMapper> provider4) {
        return new AdditionalInstructionsViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static AdditionalInstructionsViewModel newInstance(DocumentViewModelHelper documentViewModelHelper, DocumentCaptureConfiguration documentCaptureConfiguration, SessionStatus sessionStatus, DocumentTypeViewDataToEntityMapper documentTypeViewDataToEntityMapper) {
        return new AdditionalInstructionsViewModel(documentViewModelHelper, documentCaptureConfiguration, sessionStatus, documentTypeViewDataToEntityMapper);
    }

    @Override // javax.inject.Provider
    public AdditionalInstructionsViewModel get() {
        return newInstance(this.documentViewModelHelperProvider.get(), this.featureConfigurationProvider.get(), this.sessionStatusProvider.get(), this.documentTypeViewDataToEntityMapperProvider.get());
    }
}
