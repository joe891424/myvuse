package com.yoti.mobile.android.documentcapture.p055id.domain;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public final class CaptureStorage_Factory implements Factory<CaptureStorage> {
    private final Provider<Context> contextProvider;
    private final Provider<CoroutineContext> ioContextProvider;

    public CaptureStorage_Factory(Provider<Context> provider, Provider<CoroutineContext> provider2) {
        this.contextProvider = provider;
        this.ioContextProvider = provider2;
    }

    public static CaptureStorage_Factory create(Provider<Context> provider, Provider<CoroutineContext> provider2) {
        return new CaptureStorage_Factory(provider, provider2);
    }

    public static CaptureStorage newInstance(Context context, CoroutineContext coroutineContext) {
        return new CaptureStorage(context, coroutineContext);
    }

    @Override // javax.inject.Provider
    public CaptureStorage get() {
        return newInstance(this.contextProvider.get(), this.ioContextProvider.get());
    }
}
