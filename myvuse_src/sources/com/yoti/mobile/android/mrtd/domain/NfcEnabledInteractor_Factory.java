package com.yoti.mobile.android.mrtd.domain;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class NfcEnabledInteractor_Factory implements Factory<NfcEnabledInteractor> {
    private final Provider<INfcStateRepository> repositoryProvider;

    public NfcEnabledInteractor_Factory(Provider<INfcStateRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static NfcEnabledInteractor_Factory create(Provider<INfcStateRepository> provider) {
        return new NfcEnabledInteractor_Factory(provider);
    }

    public static NfcEnabledInteractor newInstance(INfcStateRepository iNfcStateRepository) {
        return new NfcEnabledInteractor(iNfcStateRepository);
    }

    @Override // javax.inject.Provider
    public NfcEnabledInteractor get() {
        return newInstance(this.repositoryProvider.get());
    }
}
