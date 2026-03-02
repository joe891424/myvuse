package com.yoti.mobile.android.documentcapture.sup.p057di;

import com.yoti.mobile.android.documentcapture.p054di.IDocumentScanDependenciesProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.sup.di.SupDocumentCaptureModule_ProvidesCoreScanDependenciesProviderFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4658x45b92ccc implements Factory<IDocumentScanDependenciesProvider> {
    private final SupDocumentCaptureModule module;
    private final Provider<NonIdDocumentScanDependenciesProvider> nonIdDocumentScanDependenciesProvider;

    public C4658x45b92ccc(SupDocumentCaptureModule supDocumentCaptureModule, Provider<NonIdDocumentScanDependenciesProvider> provider) {
        this.module = supDocumentCaptureModule;
        this.nonIdDocumentScanDependenciesProvider = provider;
    }

    public static C4658x45b92ccc create(SupDocumentCaptureModule supDocumentCaptureModule, Provider<NonIdDocumentScanDependenciesProvider> provider) {
        return new C4658x45b92ccc(supDocumentCaptureModule, provider);
    }

    public static IDocumentScanDependenciesProvider providesCoreScanDependenciesProvider(SupDocumentCaptureModule supDocumentCaptureModule, NonIdDocumentScanDependenciesProvider nonIdDocumentScanDependenciesProvider) {
        return (IDocumentScanDependenciesProvider) Preconditions.checkNotNullFromProvides(supDocumentCaptureModule.providesCoreScanDependenciesProvider(nonIdDocumentScanDependenciesProvider));
    }

    @Override // javax.inject.Provider
    public IDocumentScanDependenciesProvider get() {
        return providesCoreScanDependenciesProvider(this.module, this.nonIdDocumentScanDependenciesProvider.get());
    }
}
