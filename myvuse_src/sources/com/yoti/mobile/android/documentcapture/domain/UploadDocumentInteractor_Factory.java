package com.yoti.mobile.android.documentcapture.domain;

import com.yoti.mobile.android.documentcapture.domain.model.IDocumentEntity;
import com.yoti.mobile.android.yotisdkcore.core.data.ResourceConfigurationRepository;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class UploadDocumentInteractor_Factory implements Factory<UploadDocumentInteractor> {
    private final Provider<IDocumentRepository<IDocumentEntity>> documentRepositoryProvider;
    private final Provider<ResourceConfigurationRepository<DocumentResourceConfigEntity>> resourceConfigurationRepositoryProvider;

    public UploadDocumentInteractor_Factory(Provider<IDocumentRepository<IDocumentEntity>> provider, Provider<ResourceConfigurationRepository<DocumentResourceConfigEntity>> provider2) {
        this.documentRepositoryProvider = provider;
        this.resourceConfigurationRepositoryProvider = provider2;
    }

    public static UploadDocumentInteractor_Factory create(Provider<IDocumentRepository<IDocumentEntity>> provider, Provider<ResourceConfigurationRepository<DocumentResourceConfigEntity>> provider2) {
        return new UploadDocumentInteractor_Factory(provider, provider2);
    }

    public static UploadDocumentInteractor newInstance(IDocumentRepository<IDocumentEntity> iDocumentRepository, ResourceConfigurationRepository<DocumentResourceConfigEntity> resourceConfigurationRepository) {
        return new UploadDocumentInteractor(iDocumentRepository, resourceConfigurationRepository);
    }

    @Override // javax.inject.Provider
    public UploadDocumentInteractor get() {
        return newInstance(this.documentRepositoryProvider.get(), this.resourceConfigurationRepositoryProvider.get());
    }
}
