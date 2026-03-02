package com.yoti.mobile.android.documentcapture.sup.p057di;

import com.yoti.mobile.android.documentcapture.sup.data.SupDocumentScanConfigurationRepository;
import com.yoti.mobile.android.documentcapture.sup.domain.ISupDocumentScanConfigurationRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.sup.di.SupDocumentCaptureModule_ProvidesSupDocumentScanConfigurationRepositoryFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4662x901b2708 implements Factory<ISupDocumentScanConfigurationRepository> {
    private final SupDocumentCaptureModule module;
    private final Provider<SupDocumentScanConfigurationRepository> supDocumentScanConfigurationRepositoryProvider;

    public C4662x901b2708(SupDocumentCaptureModule supDocumentCaptureModule, Provider<SupDocumentScanConfigurationRepository> provider) {
        this.module = supDocumentCaptureModule;
        this.supDocumentScanConfigurationRepositoryProvider = provider;
    }

    public static C4662x901b2708 create(SupDocumentCaptureModule supDocumentCaptureModule, Provider<SupDocumentScanConfigurationRepository> provider) {
        return new C4662x901b2708(supDocumentCaptureModule, provider);
    }

    public static ISupDocumentScanConfigurationRepository providesSupDocumentScanConfigurationRepository(SupDocumentCaptureModule supDocumentCaptureModule, SupDocumentScanConfigurationRepository supDocumentScanConfigurationRepository) {
        return (ISupDocumentScanConfigurationRepository) Preconditions.checkNotNullFromProvides(supDocumentCaptureModule.providesSupDocumentScanConfigurationRepository(supDocumentScanConfigurationRepository));
    }

    @Override // javax.inject.Provider
    public ISupDocumentScanConfigurationRepository get() {
        return providesSupDocumentScanConfigurationRepository(this.module, this.supDocumentScanConfigurationRepositoryProvider.get());
    }
}
