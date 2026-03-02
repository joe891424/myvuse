package com.yoti.mobile.android.documentcapture.p055id.p056di;

import com.yoti.mobile.android.documentcapture.p054di.IDocumentSelectionDependenciesProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.di.IdDocumentCaptureModule_ProvidesCoreSelectionDependenciesProviderFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4616x9943fd18 implements Factory<IDocumentSelectionDependenciesProvider> {
    private final Provider<IdDocumentSelectionDependenciesProvider> idDocumentSelectionDependenciesProvider;
    private final IdDocumentCaptureModule module;

    public C4616x9943fd18(IdDocumentCaptureModule idDocumentCaptureModule, Provider<IdDocumentSelectionDependenciesProvider> provider) {
        this.module = idDocumentCaptureModule;
        this.idDocumentSelectionDependenciesProvider = provider;
    }

    public static C4616x9943fd18 create(IdDocumentCaptureModule idDocumentCaptureModule, Provider<IdDocumentSelectionDependenciesProvider> provider) {
        return new C4616x9943fd18(idDocumentCaptureModule, provider);
    }

    public static IDocumentSelectionDependenciesProvider providesCoreSelectionDependenciesProvider(IdDocumentCaptureModule idDocumentCaptureModule, IdDocumentSelectionDependenciesProvider idDocumentSelectionDependenciesProvider) {
        return (IDocumentSelectionDependenciesProvider) Preconditions.checkNotNullFromProvides(idDocumentCaptureModule.providesCoreSelectionDependenciesProvider(idDocumentSelectionDependenciesProvider));
    }

    @Override // javax.inject.Provider
    public IDocumentSelectionDependenciesProvider get() {
        return providesCoreSelectionDependenciesProvider(this.module, this.idDocumentSelectionDependenciesProvider.get());
    }
}
