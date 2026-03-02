package com.yoti.mobile.android.liveness.zoom.p072di.module;

import com.google.gson.Gson;
import com.yoti.mobile.android.liveness.zoom.data.remote.LivenessFaceTecApiService;
import com.yoti.mobile.android.remote.ApiServiceFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessFaceTecApiServiceModule_ProvidesApiServiceFactory implements Factory<LivenessFaceTecApiService> {
    private final Provider<ApiServiceFactory> apiServiceFactoryProvider;
    private final Provider<Gson> gsonProvider;
    private final LivenessFaceTecApiServiceModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public LivenessFaceTecApiServiceModule_ProvidesApiServiceFactory(LivenessFaceTecApiServiceModule livenessFaceTecApiServiceModule, Provider<ApiServiceFactory> provider, Provider<OkHttpClient> provider2, Provider<Gson> provider3) {
        this.module = livenessFaceTecApiServiceModule;
        this.apiServiceFactoryProvider = provider;
        this.okHttpClientProvider = provider2;
        this.gsonProvider = provider3;
    }

    public static LivenessFaceTecApiServiceModule_ProvidesApiServiceFactory create(LivenessFaceTecApiServiceModule livenessFaceTecApiServiceModule, Provider<ApiServiceFactory> provider, Provider<OkHttpClient> provider2, Provider<Gson> provider3) {
        return new LivenessFaceTecApiServiceModule_ProvidesApiServiceFactory(livenessFaceTecApiServiceModule, provider, provider2, provider3);
    }

    public static LivenessFaceTecApiService providesApiService(LivenessFaceTecApiServiceModule livenessFaceTecApiServiceModule, ApiServiceFactory apiServiceFactory, OkHttpClient okHttpClient, Gson gson) {
        return (LivenessFaceTecApiService) Preconditions.checkNotNullFromProvides(livenessFaceTecApiServiceModule.providesApiService(apiServiceFactory, okHttpClient, gson));
    }

    @Override // javax.inject.Provider
    public LivenessFaceTecApiService get() {
        return providesApiService(this.module, this.apiServiceFactoryProvider.get(), this.okHttpClientProvider.get(), this.gsonProvider.get());
    }
}
