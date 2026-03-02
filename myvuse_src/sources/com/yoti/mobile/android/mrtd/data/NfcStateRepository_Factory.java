package com.yoti.mobile.android.mrtd.data;

import android.nfc.NfcAdapter;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class NfcStateRepository_Factory implements Factory<NfcStateRepository> {
    private final Provider<NfcAdapter> nfcAdapterProvider;

    public NfcStateRepository_Factory(Provider<NfcAdapter> provider) {
        this.nfcAdapterProvider = provider;
    }

    public static NfcStateRepository_Factory create(Provider<NfcAdapter> provider) {
        return new NfcStateRepository_Factory(provider);
    }

    public static NfcStateRepository newInstance(NfcAdapter nfcAdapter) {
        return new NfcStateRepository(nfcAdapter);
    }

    @Override // javax.inject.Provider
    public NfcStateRepository get() {
        return newInstance(this.nfcAdapterProvider.get());
    }
}
