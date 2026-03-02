package com.yoti.mobile.android.facecapture.data.remote;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class SelfieApiServiceAdapter_Factory implements Factory<SelfieApiServiceAdapter> {
    private final Provider<SelfieApiService> apiServiceProvider;

    public SelfieApiServiceAdapter_Factory(Provider<SelfieApiService> provider) {
        this.apiServiceProvider = provider;
    }

    public static SelfieApiServiceAdapter_Factory create(Provider<SelfieApiService> provider) {
        return new SelfieApiServiceAdapter_Factory(provider);
    }

    public static SelfieApiServiceAdapter newInstance(SelfieApiService selfieApiService) {
        return new SelfieApiServiceAdapter(selfieApiService);
    }

    @Override // javax.inject.Provider
    public SelfieApiServiceAdapter get() {
        return newInstance(this.apiServiceProvider.get());
    }
}
