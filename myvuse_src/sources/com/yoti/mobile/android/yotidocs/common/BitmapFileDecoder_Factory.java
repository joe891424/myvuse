package com.yoti.mobile.android.yotidocs.common;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes4.dex */
public final class BitmapFileDecoder_Factory implements Factory<BitmapFileDecoder> {

    /* JADX INFO: renamed from: a */
    private final Provider<CoroutineContext> f7446a;

    public BitmapFileDecoder_Factory(Provider<CoroutineContext> provider) {
        this.f7446a = provider;
    }

    public static BitmapFileDecoder_Factory create(Provider<CoroutineContext> provider) {
        return new BitmapFileDecoder_Factory(provider);
    }

    public static BitmapFileDecoder newInstance(CoroutineContext coroutineContext) {
        return new BitmapFileDecoder(coroutineContext);
    }

    @Override // javax.inject.Provider
    public BitmapFileDecoder get() {
        return newInstance(this.f7446a.get());
    }
}
