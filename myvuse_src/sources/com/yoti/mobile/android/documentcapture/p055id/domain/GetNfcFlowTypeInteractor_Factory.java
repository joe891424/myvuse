package com.yoti.mobile.android.documentcapture.p055id.domain;

import com.yoti.mobile.android.mrtd.domain.INfcStateRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class GetNfcFlowTypeInteractor_Factory implements Factory<GetNfcFlowTypeInteractor> {
    private final Provider<INfcPassportCountriesRepository> nfcPassportCountriesRepositoryProvider;
    private final Provider<INfcStateRepository> nfcStateRepositoryProvider;

    public GetNfcFlowTypeInteractor_Factory(Provider<INfcStateRepository> provider, Provider<INfcPassportCountriesRepository> provider2) {
        this.nfcStateRepositoryProvider = provider;
        this.nfcPassportCountriesRepositoryProvider = provider2;
    }

    public static GetNfcFlowTypeInteractor_Factory create(Provider<INfcStateRepository> provider, Provider<INfcPassportCountriesRepository> provider2) {
        return new GetNfcFlowTypeInteractor_Factory(provider, provider2);
    }

    public static GetNfcFlowTypeInteractor newInstance(INfcStateRepository iNfcStateRepository, INfcPassportCountriesRepository iNfcPassportCountriesRepository) {
        return new GetNfcFlowTypeInteractor(iNfcStateRepository, iNfcPassportCountriesRepository);
    }

    @Override // javax.inject.Provider
    public GetNfcFlowTypeInteractor get() {
        return newInstance(this.nfcStateRepositoryProvider.get(), this.nfcPassportCountriesRepositoryProvider.get());
    }
}
