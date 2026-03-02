package com.yoti.mobile.android.facecapture.p070di.module;

import com.google.gson.Gson;
import com.yoti.mobile.android.facecapture.data.remote.SelfieApiService;
import com.yoti.mobile.android.remote.ApiServiceFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceCaptureApiServiceModule_ProvidesSelfieApiServiceFactory implements Factory<SelfieApiService> {
    private final Provider<ApiServiceFactory> apiServiceFactoryProvider;
    private final Provider<Gson> gsonProvider;
    private final FaceCaptureApiServiceModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public FaceCaptureApiServiceModule_ProvidesSelfieApiServiceFactory(FaceCaptureApiServiceModule faceCaptureApiServiceModule, Provider<ApiServiceFactory> provider, Provider<OkHttpClient> provider2, Provider<Gson> provider3) {
        this.module = faceCaptureApiServiceModule;
        this.apiServiceFactoryProvider = provider;
        this.okHttpClientProvider = provider2;
        this.gsonProvider = provider3;
    }

    public static FaceCaptureApiServiceModule_ProvidesSelfieApiServiceFactory create(FaceCaptureApiServiceModule faceCaptureApiServiceModule, Provider<ApiServiceFactory> provider, Provider<OkHttpClient> provider2, Provider<Gson> provider3) {
        return new FaceCaptureApiServiceModule_ProvidesSelfieApiServiceFactory(faceCaptureApiServiceModule, provider, provider2, provider3);
    }

    public static SelfieApiService providesSelfieApiService(FaceCaptureApiServiceModule faceCaptureApiServiceModule, ApiServiceFactory apiServiceFactory, OkHttpClient okHttpClient, Gson gson) {
        return (SelfieApiService) Preconditions.checkNotNullFromProvides(faceCaptureApiServiceModule.providesSelfieApiService(apiServiceFactory, okHttpClient, gson));
    }

    @Override // javax.inject.Provider
    public SelfieApiService get() {
        return providesSelfieApiService(this.module, this.apiServiceFactoryProvider.get(), this.okHttpClientProvider.get(), this.gsonProvider.get());
    }
}
