package com.yoti.mobile.android.documentcapture.p055id.p056di;

import com.yoti.mobile.android.documentcapture.p055id.data.IdScanConfigurationRepository;
import com.yoti.mobile.android.documentcapture.p055id.view.navigation.IdDocumentScanNavigatorProvider;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.IdScanConfigurationEntityToViewDataMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class IdDocumentScanDependenciesProvider_Factory implements Factory<IdDocumentScanDependenciesProvider> {
    private final Provider<IdScanConfigurationEntityToViewDataMapper> scanConfigEntityToViewDataMapperProvider;
    private final Provider<IdScanConfigurationRepository> scanConfigRepositoryProvider;
    private final Provider<IdDocumentScanNavigatorProvider> scanNavProvider;

    public IdDocumentScanDependenciesProvider_Factory(Provider<IdDocumentScanNavigatorProvider> provider, Provider<IdScanConfigurationRepository> provider2, Provider<IdScanConfigurationEntityToViewDataMapper> provider3) {
        this.scanNavProvider = provider;
        this.scanConfigRepositoryProvider = provider2;
        this.scanConfigEntityToViewDataMapperProvider = provider3;
    }

    public static IdDocumentScanDependenciesProvider_Factory create(Provider<IdDocumentScanNavigatorProvider> provider, Provider<IdScanConfigurationRepository> provider2, Provider<IdScanConfigurationEntityToViewDataMapper> provider3) {
        return new IdDocumentScanDependenciesProvider_Factory(provider, provider2, provider3);
    }

    public static IdDocumentScanDependenciesProvider newInstance(IdDocumentScanNavigatorProvider idDocumentScanNavigatorProvider, IdScanConfigurationRepository idScanConfigurationRepository, IdScanConfigurationEntityToViewDataMapper idScanConfigurationEntityToViewDataMapper) {
        return new IdDocumentScanDependenciesProvider(idDocumentScanNavigatorProvider, idScanConfigurationRepository, idScanConfigurationEntityToViewDataMapper);
    }

    @Override // javax.inject.Provider
    public IdDocumentScanDependenciesProvider get() {
        return newInstance(this.scanNavProvider.get(), this.scanConfigRepositoryProvider.get(), this.scanConfigEntityToViewDataMapperProvider.get());
    }
}
