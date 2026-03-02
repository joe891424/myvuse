package com.yoti.mobile.android.documentcapture.p055id.p056di;

import com.yoti.mobile.android.documentcapture.p054di.IDocumentScanDependenciesProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.di.IdDocumentCaptureModule_ProvidesCoreScanDependenciesProviderFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4615xce94b35f implements Factory<IDocumentScanDependenciesProvider> {
    private final Provider<IdDocumentScanDependenciesProvider> idDocumentScanDependenciesProvider;
    private final IdDocumentCaptureModule module;

    public C4615xce94b35f(IdDocumentCaptureModule idDocumentCaptureModule, Provider<IdDocumentScanDependenciesProvider> provider) {
        this.module = idDocumentCaptureModule;
        this.idDocumentScanDependenciesProvider = provider;
    }

    public static C4615xce94b35f create(IdDocumentCaptureModule idDocumentCaptureModule, Provider<IdDocumentScanDependenciesProvider> provider) {
        return new C4615xce94b35f(idDocumentCaptureModule, provider);
    }

    public static IDocumentScanDependenciesProvider providesCoreScanDependenciesProvider(IdDocumentCaptureModule idDocumentCaptureModule, IdDocumentScanDependenciesProvider idDocumentScanDependenciesProvider) {
        return (IDocumentScanDependenciesProvider) Preconditions.checkNotNullFromProvides(idDocumentCaptureModule.providesCoreScanDependenciesProvider(idDocumentScanDependenciesProvider));
    }

    @Override // javax.inject.Provider
    public IDocumentScanDependenciesProvider get() {
        return providesCoreScanDependenciesProvider(this.module, this.idDocumentScanDependenciesProvider.get());
    }
}
