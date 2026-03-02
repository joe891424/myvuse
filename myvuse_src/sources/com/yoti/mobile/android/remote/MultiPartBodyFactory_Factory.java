package com.yoti.mobile.android.remote;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class MultiPartBodyFactory_Factory implements Factory<MultiPartBodyFactory> {
    private final Provider<Context> contextProvider;
    private final Provider<MimeTypeProvider> mimeTypeProvider;

    public MultiPartBodyFactory_Factory(Provider<Context> provider, Provider<MimeTypeProvider> provider2) {
        this.contextProvider = provider;
        this.mimeTypeProvider = provider2;
    }

    @Override // javax.inject.Provider
    public MultiPartBodyFactory get() {
        return newInstance(this.contextProvider.get(), this.mimeTypeProvider.get());
    }

    public static MultiPartBodyFactory_Factory create(Provider<Context> provider, Provider<MimeTypeProvider> provider2) {
        return new MultiPartBodyFactory_Factory(provider, provider2);
    }

    public static MultiPartBodyFactory newInstance(Context context, MimeTypeProvider mimeTypeProvider) {
        return new MultiPartBodyFactory(context, mimeTypeProvider);
    }
}
