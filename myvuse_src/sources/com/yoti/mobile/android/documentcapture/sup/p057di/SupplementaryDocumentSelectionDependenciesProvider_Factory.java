package com.yoti.mobile.android.documentcapture.sup.p057di;

import com.yoti.mobile.android.documentcapture.sup.view.SupDocumentFeatureErrorToFailureMapper;
import com.yoti.mobile.android.documentcapture.sup.view.selection.SupDocumentConfigToDocSelectionViewDataMapper;
import com.yoti.mobile.android.documentcapture.sup.view.selection.SupDocumentEducationalArgumentsToViewDataMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class SupplementaryDocumentSelectionDependenciesProvider_Factory implements Factory<SupplementaryDocumentSelectionDependenciesProvider> {
    private final Provider<SupDocumentConfigToDocSelectionViewDataMapper> docResourceConfigToSelectionViewDataMapperProvider;
    private final Provider<SupDocumentEducationalArgumentsToViewDataMapper> documentEducationalArgumentsToViewDataMapperProvider;
    private final Provider<SupDocumentFeatureErrorToFailureMapper> documentFeatureErrorToFailureMapperProvider;

    public SupplementaryDocumentSelectionDependenciesProvider_Factory(Provider<SupDocumentConfigToDocSelectionViewDataMapper> provider, Provider<SupDocumentEducationalArgumentsToViewDataMapper> provider2, Provider<SupDocumentFeatureErrorToFailureMapper> provider3) {
        this.docResourceConfigToSelectionViewDataMapperProvider = provider;
        this.documentEducationalArgumentsToViewDataMapperProvider = provider2;
        this.documentFeatureErrorToFailureMapperProvider = provider3;
    }

    public static SupplementaryDocumentSelectionDependenciesProvider_Factory create(Provider<SupDocumentConfigToDocSelectionViewDataMapper> provider, Provider<SupDocumentEducationalArgumentsToViewDataMapper> provider2, Provider<SupDocumentFeatureErrorToFailureMapper> provider3) {
        return new SupplementaryDocumentSelectionDependenciesProvider_Factory(provider, provider2, provider3);
    }

    public static SupplementaryDocumentSelectionDependenciesProvider newInstance(SupDocumentConfigToDocSelectionViewDataMapper supDocumentConfigToDocSelectionViewDataMapper, SupDocumentEducationalArgumentsToViewDataMapper supDocumentEducationalArgumentsToViewDataMapper, SupDocumentFeatureErrorToFailureMapper supDocumentFeatureErrorToFailureMapper) {
        return new SupplementaryDocumentSelectionDependenciesProvider(supDocumentConfigToDocSelectionViewDataMapper, supDocumentEducationalArgumentsToViewDataMapper, supDocumentFeatureErrorToFailureMapper);
    }

    @Override // javax.inject.Provider
    public SupplementaryDocumentSelectionDependenciesProvider get() {
        return newInstance(this.docResourceConfigToSelectionViewDataMapperProvider.get(), this.documentEducationalArgumentsToViewDataMapperProvider.get(), this.documentFeatureErrorToFailureMapperProvider.get());
    }
}
