package com.yoti.mobile.android.documentcapture.p055id.domain;

import com.yoti.mobile.android.mrtd.data.NfcStateRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class GetCanPerformNfcReadInteractor_Factory implements Factory<GetCanPerformNfcReadInteractor> {
    private final Provider<NfcStateRepository> nfcStateRepositoryProvider;

    public GetCanPerformNfcReadInteractor_Factory(Provider<NfcStateRepository> provider) {
        this.nfcStateRepositoryProvider = provider;
    }

    public static GetCanPerformNfcReadInteractor_Factory create(Provider<NfcStateRepository> provider) {
        return new GetCanPerformNfcReadInteractor_Factory(provider);
    }

    public static GetCanPerformNfcReadInteractor newInstance(NfcStateRepository nfcStateRepository) {
        return new GetCanPerformNfcReadInteractor(nfcStateRepository);
    }

    @Override // javax.inject.Provider
    public GetCanPerformNfcReadInteractor get() {
        return newInstance(this.nfcStateRepositoryProvider.get());
    }
}
