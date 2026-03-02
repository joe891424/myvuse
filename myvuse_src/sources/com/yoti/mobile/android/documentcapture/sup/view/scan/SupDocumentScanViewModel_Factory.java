package com.yoti.mobile.android.documentcapture.sup.view.scan;

import com.yoti.mobile.android.documentcapture.sup.domain.ISupDocumentScanConfigurationRepository;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class SupDocumentScanViewModel_Factory implements Factory<SupDocumentScanViewModel> {
    private final Provider<DocumentCaptureConfiguration> featureConfigurationProvider;
    private final Provider<SupDocumentScanConfigEntityToViewDataMapper> scanConfigEntityToViewDataMapperProvider;
    private final Provider<ISupDocumentScanConfigurationRepository> scanConfigurationRepositoryProvider;

    public SupDocumentScanViewModel_Factory(Provider<DocumentCaptureConfiguration> provider, Provider<ISupDocumentScanConfigurationRepository> provider2, Provider<SupDocumentScanConfigEntityToViewDataMapper> provider3) {
        this.featureConfigurationProvider = provider;
        this.scanConfigurationRepositoryProvider = provider2;
        this.scanConfigEntityToViewDataMapperProvider = provider3;
    }

    public static SupDocumentScanViewModel_Factory create(Provider<DocumentCaptureConfiguration> provider, Provider<ISupDocumentScanConfigurationRepository> provider2, Provider<SupDocumentScanConfigEntityToViewDataMapper> provider3) {
        return new SupDocumentScanViewModel_Factory(provider, provider2, provider3);
    }

    public static SupDocumentScanViewModel newInstance(DocumentCaptureConfiguration documentCaptureConfiguration, ISupDocumentScanConfigurationRepository iSupDocumentScanConfigurationRepository, SupDocumentScanConfigEntityToViewDataMapper supDocumentScanConfigEntityToViewDataMapper) {
        return new SupDocumentScanViewModel(documentCaptureConfiguration, iSupDocumentScanConfigurationRepository, supDocumentScanConfigEntityToViewDataMapper);
    }

    @Override // javax.inject.Provider
    public SupDocumentScanViewModel get() {
        return newInstance(this.featureConfigurationProvider.get(), this.scanConfigurationRepositoryProvider.get(), this.scanConfigEntityToViewDataMapperProvider.get());
    }
}
