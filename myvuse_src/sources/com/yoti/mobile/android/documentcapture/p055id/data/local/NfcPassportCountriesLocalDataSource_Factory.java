package com.yoti.mobile.android.documentcapture.p055id.data.local;

import android.content.Context;
import com.google.gson.Gson;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public final class NfcPassportCountriesLocalDataSource_Factory implements Factory<NfcPassportCountriesLocalDataSource> {
    private final Provider<Context> contextProvider;
    private final Provider<Gson> gsonProvider;
    private final Provider<CoroutineContext> ioContextProvider;

    public NfcPassportCountriesLocalDataSource_Factory(Provider<Context> provider, Provider<Gson> provider2, Provider<CoroutineContext> provider3) {
        this.contextProvider = provider;
        this.gsonProvider = provider2;
        this.ioContextProvider = provider3;
    }

    public static NfcPassportCountriesLocalDataSource_Factory create(Provider<Context> provider, Provider<Gson> provider2, Provider<CoroutineContext> provider3) {
        return new NfcPassportCountriesLocalDataSource_Factory(provider, provider2, provider3);
    }

    public static NfcPassportCountriesLocalDataSource newInstance(Context context, Gson gson, CoroutineContext coroutineContext) {
        return new NfcPassportCountriesLocalDataSource(context, gson, coroutineContext);
    }

    @Override // javax.inject.Provider
    public NfcPassportCountriesLocalDataSource get() {
        return newInstance(this.contextProvider.get(), this.gsonProvider.get(), this.ioContextProvider.get());
    }
}
