package com.yoti.mobile.android.documentcapture.p055id.p056di;

import com.yoti.mobile.android.documentcapture.p054di.IDocumentUploadDependenciesProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.di.IdDocumentCaptureModule_ProvidesCoreUploadDependenciesProviderFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4617xcc37de5b implements Factory<IDocumentUploadDependenciesProvider> {
    private final Provider<IdDocumentUploadDependenciesProvider> idDocumentUploadDependenciesProvider;
    private final IdDocumentCaptureModule module;

    public C4617xcc37de5b(IdDocumentCaptureModule idDocumentCaptureModule, Provider<IdDocumentUploadDependenciesProvider> provider) {
        this.module = idDocumentCaptureModule;
        this.idDocumentUploadDependenciesProvider = provider;
    }

    public static C4617xcc37de5b create(IdDocumentCaptureModule idDocumentCaptureModule, Provider<IdDocumentUploadDependenciesProvider> provider) {
        return new C4617xcc37de5b(idDocumentCaptureModule, provider);
    }

    public static IDocumentUploadDependenciesProvider providesCoreUploadDependenciesProvider(IdDocumentCaptureModule idDocumentCaptureModule, IdDocumentUploadDependenciesProvider idDocumentUploadDependenciesProvider) {
        return (IDocumentUploadDependenciesProvider) Preconditions.checkNotNullFromProvides(idDocumentCaptureModule.providesCoreUploadDependenciesProvider(idDocumentUploadDependenciesProvider));
    }

    @Override // javax.inject.Provider
    public IDocumentUploadDependenciesProvider get() {
        return providesCoreUploadDependenciesProvider(this.module, this.idDocumentUploadDependenciesProvider.get());
    }
}
