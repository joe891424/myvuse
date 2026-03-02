package com.yoti.mobile.android.documentcapture.domain;

import com.yoti.mobile.android.yotisdkcore.core.data.ResourceConfigurationRepository;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class GetDocumentCaptureConfigurationInteractor_Factory implements Factory<GetDocumentCaptureConfigurationInteractor> {
    private final Provider<ResourceConfigurationRepository<DocumentResourceConfigEntity>> documentResourceRepositoryProvider;

    public GetDocumentCaptureConfigurationInteractor_Factory(Provider<ResourceConfigurationRepository<DocumentResourceConfigEntity>> provider) {
        this.documentResourceRepositoryProvider = provider;
    }

    public static GetDocumentCaptureConfigurationInteractor_Factory create(Provider<ResourceConfigurationRepository<DocumentResourceConfigEntity>> provider) {
        return new GetDocumentCaptureConfigurationInteractor_Factory(provider);
    }

    public static GetDocumentCaptureConfigurationInteractor newInstance(ResourceConfigurationRepository<DocumentResourceConfigEntity> resourceConfigurationRepository) {
        return new GetDocumentCaptureConfigurationInteractor(resourceConfigurationRepository);
    }

    @Override // javax.inject.Provider
    public GetDocumentCaptureConfigurationInteractor get() {
        return newInstance(this.documentResourceRepositoryProvider.get());
    }
}
