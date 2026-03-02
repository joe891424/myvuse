package com.yoti.mobile.android.documentcapture.p054di;

import com.yoti.mobile.android.documentcapture.domain.IScanConfigurationRepository;
import com.yoti.mobile.android.documentcapture.domain.model.IScanConfigurationEntity;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes5.dex */
public final class ScanModule_ProvidesScanConfigurationRepositoryFactory implements Factory<IScanConfigurationRepository<IScanConfigurationEntity>> {
    private final ScanModule module;

    public ScanModule_ProvidesScanConfigurationRepositoryFactory(ScanModule scanModule) {
        this.module = scanModule;
    }

    public static ScanModule_ProvidesScanConfigurationRepositoryFactory create(ScanModule scanModule) {
        return new ScanModule_ProvidesScanConfigurationRepositoryFactory(scanModule);
    }

    public static IScanConfigurationRepository<IScanConfigurationEntity> providesScanConfigurationRepository(ScanModule scanModule) {
        return (IScanConfigurationRepository) Preconditions.checkNotNullFromProvides(scanModule.providesScanConfigurationRepository());
    }

    @Override // javax.inject.Provider
    public IScanConfigurationRepository<IScanConfigurationEntity> get() {
        return providesScanConfigurationRepository(this.module);
    }
}
