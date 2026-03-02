package com.yoti.mobile.android.documentcapture.sup.p057di;

import com.yoti.mobile.android.documentcapture.p054di.IDocumentSelectionDependenciesProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.sup.di.SupDocumentCaptureModule_ProvidesCoreSelectionDependenciesProviderFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4659x2d035fcb implements Factory<IDocumentSelectionDependenciesProvider> {
    private final SupDocumentCaptureModule module;
    private final Provider<SupplementaryDocumentSelectionDependenciesProvider> supplementaryDocumentSelectionDependenciesProvider;

    public C4659x2d035fcb(SupDocumentCaptureModule supDocumentCaptureModule, Provider<SupplementaryDocumentSelectionDependenciesProvider> provider) {
        this.module = supDocumentCaptureModule;
        this.supplementaryDocumentSelectionDependenciesProvider = provider;
    }

    public static C4659x2d035fcb create(SupDocumentCaptureModule supDocumentCaptureModule, Provider<SupplementaryDocumentSelectionDependenciesProvider> provider) {
        return new C4659x2d035fcb(supDocumentCaptureModule, provider);
    }

    public static IDocumentSelectionDependenciesProvider providesCoreSelectionDependenciesProvider(SupDocumentCaptureModule supDocumentCaptureModule, SupplementaryDocumentSelectionDependenciesProvider supplementaryDocumentSelectionDependenciesProvider) {
        return (IDocumentSelectionDependenciesProvider) Preconditions.checkNotNullFromProvides(supDocumentCaptureModule.providesCoreSelectionDependenciesProvider(supplementaryDocumentSelectionDependenciesProvider));
    }

    @Override // javax.inject.Provider
    public IDocumentSelectionDependenciesProvider get() {
        return providesCoreSelectionDependenciesProvider(this.module, this.supplementaryDocumentSelectionDependenciesProvider.get());
    }
}
