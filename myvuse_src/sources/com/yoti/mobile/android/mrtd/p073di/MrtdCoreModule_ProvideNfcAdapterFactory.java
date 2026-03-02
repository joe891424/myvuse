package com.yoti.mobile.android.mrtd.p073di;

import android.content.Context;
import android.nfc.NfcAdapter;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class MrtdCoreModule_ProvideNfcAdapterFactory implements Factory<NfcAdapter> {
    private final Provider<Context> contextProvider;
    private final MrtdCoreModule module;

    public MrtdCoreModule_ProvideNfcAdapterFactory(MrtdCoreModule mrtdCoreModule, Provider<Context> provider) {
        this.module = mrtdCoreModule;
        this.contextProvider = provider;
    }

    public static MrtdCoreModule_ProvideNfcAdapterFactory create(MrtdCoreModule mrtdCoreModule, Provider<Context> provider) {
        return new MrtdCoreModule_ProvideNfcAdapterFactory(mrtdCoreModule, provider);
    }

    public static NfcAdapter provideNfcAdapter(MrtdCoreModule mrtdCoreModule, Context context) {
        return mrtdCoreModule.provideNfcAdapter(context);
    }

    @Override // javax.inject.Provider
    public NfcAdapter get() {
        return provideNfcAdapter(this.module, this.contextProvider.get());
    }
}
