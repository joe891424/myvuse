package com.yoti.mobile.android.mrtd.domain;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class NfcStopListeningUseCase_Factory implements Factory<NfcStopListeningUseCase> {
    private final Provider<INfcReadController> listenerProvider;

    public NfcStopListeningUseCase_Factory(Provider<INfcReadController> provider) {
        this.listenerProvider = provider;
    }

    public static NfcStopListeningUseCase_Factory create(Provider<INfcReadController> provider) {
        return new NfcStopListeningUseCase_Factory(provider);
    }

    public static NfcStopListeningUseCase newInstance(INfcReadController iNfcReadController) {
        return new NfcStopListeningUseCase(iNfcReadController);
    }

    @Override // javax.inject.Provider
    public NfcStopListeningUseCase get() {
        return newInstance(this.listenerProvider.get());
    }
}
