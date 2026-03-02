package com.yoti.mobile.android.documentcapture.view.requirements;

import com.yoti.mobile.android.documentcapture.view.DocumentViewModelHelper;
import com.yoti.mobile.android.documentcapture.view.selection.ValidationAndGuidanceEntityToViewDataMapper;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentRequirementsViewModel_Factory implements Factory<DocumentRequirementsViewModel> {
    private final Provider<DocumentViewModelHelper> documentViewModelHelperProvider;
    private final Provider<DocumentCaptureConfiguration> featureConfigurationProvider;
    private final Provider<SessionStatus> sessionStatusProvider;
    private final Provider<ValidationAndGuidanceEntityToViewDataMapper> validationAndGuidanceEntityToViewDataMapperProvider;

    public DocumentRequirementsViewModel_Factory(Provider<DocumentViewModelHelper> provider, Provider<SessionStatus> provider2, Provider<DocumentCaptureConfiguration> provider3, Provider<ValidationAndGuidanceEntityToViewDataMapper> provider4) {
        this.documentViewModelHelperProvider = provider;
        this.sessionStatusProvider = provider2;
        this.featureConfigurationProvider = provider3;
        this.validationAndGuidanceEntityToViewDataMapperProvider = provider4;
    }

    public static DocumentRequirementsViewModel_Factory create(Provider<DocumentViewModelHelper> provider, Provider<SessionStatus> provider2, Provider<DocumentCaptureConfiguration> provider3, Provider<ValidationAndGuidanceEntityToViewDataMapper> provider4) {
        return new DocumentRequirementsViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static DocumentRequirementsViewModel newInstance(DocumentViewModelHelper documentViewModelHelper, SessionStatus sessionStatus, DocumentCaptureConfiguration documentCaptureConfiguration, ValidationAndGuidanceEntityToViewDataMapper validationAndGuidanceEntityToViewDataMapper) {
        return new DocumentRequirementsViewModel(documentViewModelHelper, sessionStatus, documentCaptureConfiguration, validationAndGuidanceEntityToViewDataMapper);
    }

    @Override // javax.inject.Provider
    public DocumentRequirementsViewModel get() {
        return newInstance(this.documentViewModelHelperProvider.get(), this.sessionStatusProvider.get(), this.featureConfigurationProvider.get(), this.validationAndGuidanceEntityToViewDataMapperProvider.get());
    }
}
