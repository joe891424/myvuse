package com.yoti.mobile.android.documentcapture.sup.p057di;

import com.yoti.mobile.android.documentcapture.sup.data.SupDocumentScanConfigurationRepository;
import com.yoti.mobile.android.documentcapture.sup.view.navigation.SupDocumentScanNavigatorProvider;
import com.yoti.mobile.android.documentcapture.sup.view.scan.SupDocumentScanConfigEntityToViewDataMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class NonIdDocumentScanDependenciesProvider_Factory implements Factory<NonIdDocumentScanDependenciesProvider> {
    private final Provider<SupDocumentScanConfigEntityToViewDataMapper> scanConfigEntityToViewDataMapperProvider;
    private final Provider<SupDocumentScanConfigurationRepository> scanConfigRepositoryProvider;
    private final Provider<SupDocumentScanNavigatorProvider> scanNavProvider;

    public NonIdDocumentScanDependenciesProvider_Factory(Provider<SupDocumentScanNavigatorProvider> provider, Provider<SupDocumentScanConfigurationRepository> provider2, Provider<SupDocumentScanConfigEntityToViewDataMapper> provider3) {
        this.scanNavProvider = provider;
        this.scanConfigRepositoryProvider = provider2;
        this.scanConfigEntityToViewDataMapperProvider = provider3;
    }

    public static NonIdDocumentScanDependenciesProvider_Factory create(Provider<SupDocumentScanNavigatorProvider> provider, Provider<SupDocumentScanConfigurationRepository> provider2, Provider<SupDocumentScanConfigEntityToViewDataMapper> provider3) {
        return new NonIdDocumentScanDependenciesProvider_Factory(provider, provider2, provider3);
    }

    public static NonIdDocumentScanDependenciesProvider newInstance(SupDocumentScanNavigatorProvider supDocumentScanNavigatorProvider, SupDocumentScanConfigurationRepository supDocumentScanConfigurationRepository, SupDocumentScanConfigEntityToViewDataMapper supDocumentScanConfigEntityToViewDataMapper) {
        return new NonIdDocumentScanDependenciesProvider(supDocumentScanNavigatorProvider, supDocumentScanConfigurationRepository, supDocumentScanConfigEntityToViewDataMapper);
    }

    @Override // javax.inject.Provider
    public NonIdDocumentScanDependenciesProvider get() {
        return newInstance(this.scanNavProvider.get(), this.scanConfigRepositoryProvider.get(), this.scanConfigEntityToViewDataMapperProvider.get());
    }
}
