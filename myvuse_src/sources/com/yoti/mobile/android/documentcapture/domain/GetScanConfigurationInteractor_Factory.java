package com.yoti.mobile.android.documentcapture.domain;

import com.yoti.mobile.android.documentcapture.domain.model.IScanConfigurationEntity;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class GetScanConfigurationInteractor_Factory implements Factory<GetScanConfigurationInteractor> {
    private final Provider<IScanConfigurationRepository<IScanConfigurationEntity>> configurationRepositoryProvider;

    public GetScanConfigurationInteractor_Factory(Provider<IScanConfigurationRepository<IScanConfigurationEntity>> provider) {
        this.configurationRepositoryProvider = provider;
    }

    public static GetScanConfigurationInteractor_Factory create(Provider<IScanConfigurationRepository<IScanConfigurationEntity>> provider) {
        return new GetScanConfigurationInteractor_Factory(provider);
    }

    public static GetScanConfigurationInteractor newInstance(IScanConfigurationRepository<IScanConfigurationEntity> iScanConfigurationRepository) {
        return new GetScanConfigurationInteractor(iScanConfigurationRepository);
    }

    @Override // javax.inject.Provider
    public GetScanConfigurationInteractor get() {
        return newInstance(this.configurationRepositoryProvider.get());
    }
}
