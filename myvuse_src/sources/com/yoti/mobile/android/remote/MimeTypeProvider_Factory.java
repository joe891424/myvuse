package com.yoti.mobile.android.remote;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class MimeTypeProvider_Factory implements Factory<MimeTypeProvider> {
    private final Provider<Context> contextProvider;

    public MimeTypeProvider_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public MimeTypeProvider get() {
        return newInstance(this.contextProvider.get());
    }

    public static MimeTypeProvider_Factory create(Provider<Context> provider) {
        return new MimeTypeProvider_Factory(provider);
    }

    public static MimeTypeProvider newInstance(Context context) {
        return new MimeTypeProvider(context);
    }
}
