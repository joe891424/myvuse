package com.yoti.mobile.android.mrtd.domain;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class NfcStartListeningUseCase_Factory implements Factory<NfcStartListeningUseCase> {
    private final Provider<INfcReadController> listenerProvider;

    public NfcStartListeningUseCase_Factory(Provider<INfcReadController> provider) {
        this.listenerProvider = provider;
    }

    public static NfcStartListeningUseCase_Factory create(Provider<INfcReadController> provider) {
        return new NfcStartListeningUseCase_Factory(provider);
    }

    public static NfcStartListeningUseCase newInstance(INfcReadController iNfcReadController) {
        return new NfcStartListeningUseCase(iNfcReadController);
    }

    @Override // javax.inject.Provider
    public NfcStartListeningUseCase get() {
        return newInstance(this.listenerProvider.get());
    }
}
