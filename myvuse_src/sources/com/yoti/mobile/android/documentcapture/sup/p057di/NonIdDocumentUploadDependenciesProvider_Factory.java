package com.yoti.mobile.android.documentcapture.sup.p057di;

import com.yoti.mobile.android.documentcapture.sup.data.SupDocumentRepository;
import com.yoti.mobile.android.documentcapture.sup.domain.SupDocumentCleanupInteractor;
import com.yoti.mobile.android.documentcapture.sup.view.navigation.SupDocumentUploadNavigatorProvider;
import com.yoti.mobile.android.documentcapture.sup.view.upload.SupDocumentViewDataToEntityMapper;
import com.yoti.mobile.android.documentcapture.sup.view.upload.UploadErrorToViewDataMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class NonIdDocumentUploadDependenciesProvider_Factory implements Factory<NonIdDocumentUploadDependenciesProvider> {
    private final Provider<SupDocumentCleanupInteractor> cleanupInteractorProvider;
    private final Provider<SupDocumentRepository> docRepositoryProvider;
    private final Provider<SupDocumentViewDataToEntityMapper> scanViewDataToEntityMapperProvider;
    private final Provider<UploadErrorToViewDataMapper> uploadErrorToViewDataMapperProvider;
    private final Provider<SupDocumentUploadNavigatorProvider> uploadNavProvider;

    public NonIdDocumentUploadDependenciesProvider_Factory(Provider<SupDocumentUploadNavigatorProvider> provider, Provider<SupDocumentRepository> provider2, Provider<SupDocumentViewDataToEntityMapper> provider3, Provider<UploadErrorToViewDataMapper> provider4, Provider<SupDocumentCleanupInteractor> provider5) {
        this.uploadNavProvider = provider;
        this.docRepositoryProvider = provider2;
        this.scanViewDataToEntityMapperProvider = provider3;
        this.uploadErrorToViewDataMapperProvider = provider4;
        this.cleanupInteractorProvider = provider5;
    }

    public static NonIdDocumentUploadDependenciesProvider_Factory create(Provider<SupDocumentUploadNavigatorProvider> provider, Provider<SupDocumentRepository> provider2, Provider<SupDocumentViewDataToEntityMapper> provider3, Provider<UploadErrorToViewDataMapper> provider4, Provider<SupDocumentCleanupInteractor> provider5) {
        return new NonIdDocumentUploadDependenciesProvider_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static NonIdDocumentUploadDependenciesProvider newInstance(SupDocumentUploadNavigatorProvider supDocumentUploadNavigatorProvider, SupDocumentRepository supDocumentRepository, SupDocumentViewDataToEntityMapper supDocumentViewDataToEntityMapper, UploadErrorToViewDataMapper uploadErrorToViewDataMapper, SupDocumentCleanupInteractor supDocumentCleanupInteractor) {
        return new NonIdDocumentUploadDependenciesProvider(supDocumentUploadNavigatorProvider, supDocumentRepository, supDocumentViewDataToEntityMapper, uploadErrorToViewDataMapper, supDocumentCleanupInteractor);
    }

    @Override // javax.inject.Provider
    public NonIdDocumentUploadDependenciesProvider get() {
        return newInstance(this.uploadNavProvider.get(), this.docRepositoryProvider.get(), this.scanViewDataToEntityMapperProvider.get(), this.uploadErrorToViewDataMapperProvider.get(), this.cleanupInteractorProvider.get());
    }
}
