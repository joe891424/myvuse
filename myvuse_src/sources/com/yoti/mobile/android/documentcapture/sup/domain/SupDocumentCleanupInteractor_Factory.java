package com.yoti.mobile.android.documentcapture.sup.domain;

import android.content.Context;
import com.yoti.mobile.android.documentcapture.sup.view.scan.SupDocumentFileProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public final class SupDocumentCleanupInteractor_Factory implements Factory<SupDocumentCleanupInteractor> {
    private final Provider<Context> contextProvider;
    private final Provider<SupDocumentFileProvider> fileProvider;
    private final Provider<CoroutineContext> ioContextProvider;

    public SupDocumentCleanupInteractor_Factory(Provider<Context> provider, Provider<SupDocumentFileProvider> provider2, Provider<CoroutineContext> provider3) {
        this.contextProvider = provider;
        this.fileProvider = provider2;
        this.ioContextProvider = provider3;
    }

    public static SupDocumentCleanupInteractor_Factory create(Provider<Context> provider, Provider<SupDocumentFileProvider> provider2, Provider<CoroutineContext> provider3) {
        return new SupDocumentCleanupInteractor_Factory(provider, provider2, provider3);
    }

    public static SupDocumentCleanupInteractor newInstance(Context context, SupDocumentFileProvider supDocumentFileProvider, CoroutineContext coroutineContext) {
        return new SupDocumentCleanupInteractor(context, supDocumentFileProvider, coroutineContext);
    }

    @Override // javax.inject.Provider
    public SupDocumentCleanupInteractor get() {
        return newInstance(this.contextProvider.get(), this.fileProvider.get(), this.ioContextProvider.get());
    }
}
