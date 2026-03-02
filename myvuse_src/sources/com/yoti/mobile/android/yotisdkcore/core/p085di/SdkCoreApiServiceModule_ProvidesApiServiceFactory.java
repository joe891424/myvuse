package com.yoti.mobile.android.yotisdkcore.core.p085di;

import com.yoti.mobile.android.remote.ApiServiceFactory;
import com.yoti.mobile.android.yotisdkcore.core.data.remote.SdkCoreApiService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes4.dex */
public final class SdkCoreApiServiceModule_ProvidesApiServiceFactory implements Factory<SdkCoreApiService> {
    private final Provider<ApiServiceFactory> apiServiceFactoryProvider;
    private final SdkCoreApiServiceModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public SdkCoreApiServiceModule_ProvidesApiServiceFactory(SdkCoreApiServiceModule sdkCoreApiServiceModule, Provider<ApiServiceFactory> provider, Provider<OkHttpClient> provider2) {
        this.module = sdkCoreApiServiceModule;
        this.apiServiceFactoryProvider = provider;
        this.okHttpClientProvider = provider2;
    }

    public static SdkCoreApiServiceModule_ProvidesApiServiceFactory create(SdkCoreApiServiceModule sdkCoreApiServiceModule, Provider<ApiServiceFactory> provider, Provider<OkHttpClient> provider2) {
        return new SdkCoreApiServiceModule_ProvidesApiServiceFactory(sdkCoreApiServiceModule, provider, provider2);
    }

    public static SdkCoreApiService providesApiService(SdkCoreApiServiceModule sdkCoreApiServiceModule, ApiServiceFactory apiServiceFactory, OkHttpClient okHttpClient) {
        return (SdkCoreApiService) Preconditions.checkNotNullFromProvides(sdkCoreApiServiceModule.providesApiService(apiServiceFactory, okHttpClient));
    }

    @Override // javax.inject.Provider
    public SdkCoreApiService get() {
        return providesApiService(this.module, this.apiServiceFactoryProvider.get(), this.okHttpClientProvider.get());
    }
}
