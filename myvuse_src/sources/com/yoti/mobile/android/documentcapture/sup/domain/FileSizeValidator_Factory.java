package com.yoti.mobile.android.documentcapture.sup.domain;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public final class FileSizeValidator_Factory implements Factory<FileSizeValidator> {
    private final Provider<Context> contextProvider;
    private final Provider<CoroutineContext> ioContextProvider;

    public FileSizeValidator_Factory(Provider<Context> provider, Provider<CoroutineContext> provider2) {
        this.contextProvider = provider;
        this.ioContextProvider = provider2;
    }

    public static FileSizeValidator_Factory create(Provider<Context> provider, Provider<CoroutineContext> provider2) {
        return new FileSizeValidator_Factory(provider, provider2);
    }

    public static FileSizeValidator newInstance(Context context, CoroutineContext coroutineContext) {
        return new FileSizeValidator(context, coroutineContext);
    }

    @Override // javax.inject.Provider
    public FileSizeValidator get() {
        return newInstance(this.contextProvider.get(), this.ioContextProvider.get());
    }
}
