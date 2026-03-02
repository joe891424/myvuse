package com.yoti.mobile.android.documentcapture.p055id.p056di;

import com.yoti.mobile.android.documentcapture.p055id.view.IdDocumentFeatureErrorToFailureMapper;
import com.yoti.mobile.android.documentcapture.p055id.view.selection.IdDocConfigToDocSelectionViewDataMapper;
import com.yoti.mobile.android.documentcapture.p055id.view.selection.IdDocumentEducationalArgumentsToViewDataMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class IdDocumentSelectionDependenciesProvider_Factory implements Factory<IdDocumentSelectionDependenciesProvider> {
    private final Provider<IdDocConfigToDocSelectionViewDataMapper> docResourceConfigToSelectionViewDataMapperProvider;
    private final Provider<IdDocumentEducationalArgumentsToViewDataMapper> documentEducationalArgumentsToViewDataMapperProvider;
    private final Provider<IdDocumentFeatureErrorToFailureMapper> documentFeatureErrorToFailureMapperProvider;

    public IdDocumentSelectionDependenciesProvider_Factory(Provider<IdDocConfigToDocSelectionViewDataMapper> provider, Provider<IdDocumentEducationalArgumentsToViewDataMapper> provider2, Provider<IdDocumentFeatureErrorToFailureMapper> provider3) {
        this.docResourceConfigToSelectionViewDataMapperProvider = provider;
        this.documentEducationalArgumentsToViewDataMapperProvider = provider2;
        this.documentFeatureErrorToFailureMapperProvider = provider3;
    }

    public static IdDocumentSelectionDependenciesProvider_Factory create(Provider<IdDocConfigToDocSelectionViewDataMapper> provider, Provider<IdDocumentEducationalArgumentsToViewDataMapper> provider2, Provider<IdDocumentFeatureErrorToFailureMapper> provider3) {
        return new IdDocumentSelectionDependenciesProvider_Factory(provider, provider2, provider3);
    }

    public static IdDocumentSelectionDependenciesProvider newInstance(IdDocConfigToDocSelectionViewDataMapper idDocConfigToDocSelectionViewDataMapper, IdDocumentEducationalArgumentsToViewDataMapper idDocumentEducationalArgumentsToViewDataMapper, IdDocumentFeatureErrorToFailureMapper idDocumentFeatureErrorToFailureMapper) {
        return new IdDocumentSelectionDependenciesProvider(idDocConfigToDocSelectionViewDataMapper, idDocumentEducationalArgumentsToViewDataMapper, idDocumentFeatureErrorToFailureMapper);
    }

    @Override // javax.inject.Provider
    public IdDocumentSelectionDependenciesProvider get() {
        return newInstance(this.docResourceConfigToSelectionViewDataMapperProvider.get(), this.documentEducationalArgumentsToViewDataMapperProvider.get(), this.documentFeatureErrorToFailureMapperProvider.get());
    }
}
