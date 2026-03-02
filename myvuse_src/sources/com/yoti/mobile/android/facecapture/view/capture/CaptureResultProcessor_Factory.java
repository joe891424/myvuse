package com.yoti.mobile.android.facecapture.view.capture;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes4.dex */
public final class CaptureResultProcessor_Factory implements Factory<CaptureResultProcessor> {
    private final Provider<Context> contextProvider;
    private final Provider<CoroutineContext> ioContextProvider;

    public CaptureResultProcessor_Factory(Provider<Context> provider, Provider<CoroutineContext> provider2) {
        this.contextProvider = provider;
        this.ioContextProvider = provider2;
    }

    public static CaptureResultProcessor_Factory create(Provider<Context> provider, Provider<CoroutineContext> provider2) {
        return new CaptureResultProcessor_Factory(provider, provider2);
    }

    public static CaptureResultProcessor newInstance(Context context, CoroutineContext coroutineContext) {
        return new CaptureResultProcessor(context, coroutineContext);
    }

    @Override // javax.inject.Provider
    public CaptureResultProcessor get() {
        return newInstance(this.contextProvider.get(), this.ioContextProvider.get());
    }
}
