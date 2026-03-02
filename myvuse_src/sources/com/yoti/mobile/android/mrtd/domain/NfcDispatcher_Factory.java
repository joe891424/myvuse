package com.yoti.mobile.android.mrtd.domain;

import android.nfc.NfcAdapter;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class NfcDispatcher_Factory implements Factory<NfcDispatcher> {
    private final Provider<NfcAdapter> nfcAdapterProvider;
    private final Provider<INfcTagProcessor> nfcTagProcessorProvider;

    public NfcDispatcher_Factory(Provider<NfcAdapter> provider, Provider<INfcTagProcessor> provider2) {
        this.nfcAdapterProvider = provider;
        this.nfcTagProcessorProvider = provider2;
    }

    public static NfcDispatcher_Factory create(Provider<NfcAdapter> provider, Provider<INfcTagProcessor> provider2) {
        return new NfcDispatcher_Factory(provider, provider2);
    }

    public static NfcDispatcher newInstance(NfcAdapter nfcAdapter, INfcTagProcessor iNfcTagProcessor) {
        return new NfcDispatcher(nfcAdapter, iNfcTagProcessor);
    }

    @Override // javax.inject.Provider
    public NfcDispatcher get() {
        return newInstance(this.nfcAdapterProvider.get(), this.nfcTagProcessorProvider.get());
    }
}
