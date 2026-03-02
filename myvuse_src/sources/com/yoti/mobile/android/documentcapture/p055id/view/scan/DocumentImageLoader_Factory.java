package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentImageLoader_Factory implements Factory<DocumentImageLoader> {
    private final Provider<Context> contextProvider;
    private final Provider<CoroutineContext> ioContextProvider;

    public DocumentImageLoader_Factory(Provider<Context> provider, Provider<CoroutineContext> provider2) {
        this.contextProvider = provider;
        this.ioContextProvider = provider2;
    }

    public static DocumentImageLoader_Factory create(Provider<Context> provider, Provider<CoroutineContext> provider2) {
        return new DocumentImageLoader_Factory(provider, provider2);
    }

    public static DocumentImageLoader newInstance(Context context, CoroutineContext coroutineContext) {
        return new DocumentImageLoader(context, coroutineContext);
    }

    @Override // javax.inject.Provider
    public DocumentImageLoader get() {
        return newInstance(this.contextProvider.get(), this.ioContextProvider.get());
    }
}
