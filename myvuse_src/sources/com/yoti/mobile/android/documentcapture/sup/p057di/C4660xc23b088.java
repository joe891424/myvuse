package com.yoti.mobile.android.documentcapture.sup.p057di;

import com.yoti.mobile.android.documentcapture.p054di.IDocumentUploadDependenciesProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.sup.di.SupDocumentCaptureModule_ProvidesCoreUploadDependenciesProviderFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4660xc23b088 implements Factory<IDocumentUploadDependenciesProvider> {
    private final SupDocumentCaptureModule module;
    private final Provider<NonIdDocumentUploadDependenciesProvider> nonIdDocumentUploadDependenciesProvider;

    public C4660xc23b088(SupDocumentCaptureModule supDocumentCaptureModule, Provider<NonIdDocumentUploadDependenciesProvider> provider) {
        this.module = supDocumentCaptureModule;
        this.nonIdDocumentUploadDependenciesProvider = provider;
    }

    public static C4660xc23b088 create(SupDocumentCaptureModule supDocumentCaptureModule, Provider<NonIdDocumentUploadDependenciesProvider> provider) {
        return new C4660xc23b088(supDocumentCaptureModule, provider);
    }

    public static IDocumentUploadDependenciesProvider providesCoreUploadDependenciesProvider(SupDocumentCaptureModule supDocumentCaptureModule, NonIdDocumentUploadDependenciesProvider nonIdDocumentUploadDependenciesProvider) {
        return (IDocumentUploadDependenciesProvider) Preconditions.checkNotNullFromProvides(supDocumentCaptureModule.providesCoreUploadDependenciesProvider(nonIdDocumentUploadDependenciesProvider));
    }

    @Override // javax.inject.Provider
    public IDocumentUploadDependenciesProvider get() {
        return providesCoreUploadDependenciesProvider(this.module, this.nonIdDocumentUploadDependenciesProvider.get());
    }
}
