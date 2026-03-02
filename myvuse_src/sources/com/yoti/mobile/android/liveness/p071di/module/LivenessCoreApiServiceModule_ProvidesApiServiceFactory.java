package com.yoti.mobile.android.liveness.p071di.module;

import com.google.gson.Gson;
import com.yoti.mobile.android.liveness.data.remote.LivenessCoreApiService;
import com.yoti.mobile.android.remote.ApiServiceFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessCoreApiServiceModule_ProvidesApiServiceFactory implements Factory<LivenessCoreApiService> {
    private final Provider<ApiServiceFactory> apiServiceFactoryProvider;
    private final Provider<Gson> gsonProvider;
    private final LivenessCoreApiServiceModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public LivenessCoreApiServiceModule_ProvidesApiServiceFactory(LivenessCoreApiServiceModule livenessCoreApiServiceModule, Provider<ApiServiceFactory> provider, Provider<OkHttpClient> provider2, Provider<Gson> provider3) {
        this.module = livenessCoreApiServiceModule;
        this.apiServiceFactoryProvider = provider;
        this.okHttpClientProvider = provider2;
        this.gsonProvider = provider3;
    }

    public static LivenessCoreApiServiceModule_ProvidesApiServiceFactory create(LivenessCoreApiServiceModule livenessCoreApiServiceModule, Provider<ApiServiceFactory> provider, Provider<OkHttpClient> provider2, Provider<Gson> provider3) {
        return new LivenessCoreApiServiceModule_ProvidesApiServiceFactory(livenessCoreApiServiceModule, provider, provider2, provider3);
    }

    public static LivenessCoreApiService providesApiService(LivenessCoreApiServiceModule livenessCoreApiServiceModule, ApiServiceFactory apiServiceFactory, OkHttpClient okHttpClient, Gson gson) {
        return (LivenessCoreApiService) Preconditions.checkNotNullFromProvides(livenessCoreApiServiceModule.providesApiService(apiServiceFactory, okHttpClient, gson));
    }

    @Override // javax.inject.Provider
    public LivenessCoreApiService get() {
        return providesApiService(this.module, this.apiServiceFactoryProvider.get(), this.okHttpClientProvider.get(), this.gsonProvider.get());
    }
}
