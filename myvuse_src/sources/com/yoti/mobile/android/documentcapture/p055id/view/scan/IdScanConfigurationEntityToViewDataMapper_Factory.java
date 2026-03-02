package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeEntityToViewDataMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class IdScanConfigurationEntityToViewDataMapper_Factory implements Factory<IdScanConfigurationEntityToViewDataMapper> {
    private final Provider<DocumentTypeEntityToViewDataMapper> documentTypeEntityToViewDataMapperProvider;
    private final Provider<DocumentCaptureConfiguration> featureConfigurationProvider;

    public IdScanConfigurationEntityToViewDataMapper_Factory(Provider<DocumentTypeEntityToViewDataMapper> provider, Provider<DocumentCaptureConfiguration> provider2) {
        this.documentTypeEntityToViewDataMapperProvider = provider;
        this.featureConfigurationProvider = provider2;
    }

    public static IdScanConfigurationEntityToViewDataMapper_Factory create(Provider<DocumentTypeEntityToViewDataMapper> provider, Provider<DocumentCaptureConfiguration> provider2) {
        return new IdScanConfigurationEntityToViewDataMapper_Factory(provider, provider2);
    }

    public static IdScanConfigurationEntityToViewDataMapper newInstance(DocumentTypeEntityToViewDataMapper documentTypeEntityToViewDataMapper, DocumentCaptureConfiguration documentCaptureConfiguration) {
        return new IdScanConfigurationEntityToViewDataMapper(documentTypeEntityToViewDataMapper, documentCaptureConfiguration);
    }

    @Override // javax.inject.Provider
    public IdScanConfigurationEntityToViewDataMapper get() {
        return newInstance(this.documentTypeEntityToViewDataMapperProvider.get(), this.featureConfigurationProvider.get());
    }
}
