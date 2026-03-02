package com.yoti.mobile.android.yotidocs.common;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes4.dex */
public final class BitmapRotateUseCase_Factory implements Factory<BitmapRotateUseCase> {

    /* JADX INFO: renamed from: a */
    private final Provider<CoroutineContext> f7452a;

    public BitmapRotateUseCase_Factory(Provider<CoroutineContext> provider) {
        this.f7452a = provider;
    }

    public static BitmapRotateUseCase_Factory create(Provider<CoroutineContext> provider) {
        return new BitmapRotateUseCase_Factory(provider);
    }

    public static BitmapRotateUseCase newInstance(CoroutineContext coroutineContext) {
        return new BitmapRotateUseCase(coroutineContext);
    }

    @Override // javax.inject.Provider
    public BitmapRotateUseCase get() {
        return newInstance(this.f7452a.get());
    }
}
