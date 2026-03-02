package com.yoti.mobile.android.documentcapture.view.educational;

import com.yoti.mobile.android.documentcapture.view.DocumentViewModelHelper;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentTypeViewDataToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentEducationalViewModel_Factory implements Factory<DocumentEducationalViewModel> {
    private final Provider<DocumentEducationalArgumentsToViewDataMapper> documentEducationalArgumentsToViewDataMapperProvider;
    private final Provider<DocumentResourceConfigEntityToEducationalViewDataMapper> documentResourceConfigEntityToEducationalViewDataMapperProvider;
    private final Provider<DocumentTypeViewDataToEntityMapper> documentTypeViewDataToEntityMapperProvider;
    private final Provider<DocumentViewModelHelper> documentViewModelHelperProvider;
    private final Provider<DocumentCaptureConfiguration> featureConfigurationProvider;

    public DocumentEducationalViewModel_Factory(Provider<DocumentViewModelHelper> provider, Provider<DocumentResourceConfigEntityToEducationalViewDataMapper> provider2, Provider<DocumentEducationalArgumentsToViewDataMapper> provider3, Provider<DocumentTypeViewDataToEntityMapper> provider4, Provider<DocumentCaptureConfiguration> provider5) {
        this.documentViewModelHelperProvider = provider;
        this.documentResourceConfigEntityToEducationalViewDataMapperProvider = provider2;
        this.documentEducationalArgumentsToViewDataMapperProvider = provider3;
        this.documentTypeViewDataToEntityMapperProvider = provider4;
        this.featureConfigurationProvider = provider5;
    }

    public static DocumentEducationalViewModel_Factory create(Provider<DocumentViewModelHelper> provider, Provider<DocumentResourceConfigEntityToEducationalViewDataMapper> provider2, Provider<DocumentEducationalArgumentsToViewDataMapper> provider3, Provider<DocumentTypeViewDataToEntityMapper> provider4, Provider<DocumentCaptureConfiguration> provider5) {
        return new DocumentEducationalViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static DocumentEducationalViewModel newInstance(DocumentViewModelHelper documentViewModelHelper, DocumentResourceConfigEntityToEducationalViewDataMapper documentResourceConfigEntityToEducationalViewDataMapper, DocumentEducationalArgumentsToViewDataMapper documentEducationalArgumentsToViewDataMapper, DocumentTypeViewDataToEntityMapper documentTypeViewDataToEntityMapper, DocumentCaptureConfiguration documentCaptureConfiguration) {
        return new DocumentEducationalViewModel(documentViewModelHelper, documentResourceConfigEntityToEducationalViewDataMapper, documentEducationalArgumentsToViewDataMapper, documentTypeViewDataToEntityMapper, documentCaptureConfiguration);
    }

    @Override // javax.inject.Provider
    public DocumentEducationalViewModel get() {
        return newInstance(this.documentViewModelHelperProvider.get(), this.documentResourceConfigEntityToEducationalViewDataMapperProvider.get(), this.documentEducationalArgumentsToViewDataMapperProvider.get(), this.documentTypeViewDataToEntityMapperProvider.get(), this.featureConfigurationProvider.get());
    }
}
