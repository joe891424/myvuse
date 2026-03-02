package com.yoti.mobile.android.documentcapture.p054di;

import com.yoti.mobile.android.documentcapture.data.DocumentResourceConfigurationRepository;
import com.yoti.mobile.android.yotisdkcore.core.data.ResourceConfigurationRepository;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.di.DocumentCaptureCoreModule_ProvidesDocumentResourceConfigurationRepositoryFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4600xf38726ee implements Factory<ResourceConfigurationRepository<DocumentResourceConfigEntity>> {
    private final DocumentCaptureCoreModule module;
    private final Provider<DocumentResourceConfigurationRepository> repositoryProvider;

    public C4600xf38726ee(DocumentCaptureCoreModule documentCaptureCoreModule, Provider<DocumentResourceConfigurationRepository> provider) {
        this.module = documentCaptureCoreModule;
        this.repositoryProvider = provider;
    }

    public static C4600xf38726ee create(DocumentCaptureCoreModule documentCaptureCoreModule, Provider<DocumentResourceConfigurationRepository> provider) {
        return new C4600xf38726ee(documentCaptureCoreModule, provider);
    }

    public static ResourceConfigurationRepository<DocumentResourceConfigEntity> providesDocumentResourceConfigurationRepository(DocumentCaptureCoreModule documentCaptureCoreModule, DocumentResourceConfigurationRepository documentResourceConfigurationRepository) {
        return (ResourceConfigurationRepository) Preconditions.checkNotNullFromProvides(documentCaptureCoreModule.providesDocumentResourceConfigurationRepository(documentResourceConfigurationRepository));
    }

    @Override // javax.inject.Provider
    public ResourceConfigurationRepository<DocumentResourceConfigEntity> get() {
        return providesDocumentResourceConfigurationRepository(this.module, this.repositoryProvider.get());
    }
}
