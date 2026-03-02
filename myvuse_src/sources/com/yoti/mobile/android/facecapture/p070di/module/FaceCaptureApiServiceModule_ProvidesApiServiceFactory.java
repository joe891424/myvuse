package com.yoti.mobile.android.facecapture.p070di.module;

import com.google.gson.Gson;
import com.yoti.mobile.android.facecapture.data.remote.IFaceCaptureApiService;
import com.yoti.mobile.android.facecapture.data.remote.SelfieApiServiceAdapter;
import com.yoti.mobile.android.remote.ApiServiceFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceCaptureApiServiceModule_ProvidesApiServiceFactory implements Factory<IFaceCaptureApiService> {
    private final Provider<ApiServiceFactory> apiServiceFactoryProvider;
    private final Provider<Gson> gsonProvider;
    private final FaceCaptureApiServiceModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<SelfieApiServiceAdapter> selfieApiServiceAdapterProvider;

    public FaceCaptureApiServiceModule_ProvidesApiServiceFactory(FaceCaptureApiServiceModule faceCaptureApiServiceModule, Provider<ApiServiceFactory> provider, Provider<OkHttpClient> provider2, Provider<Gson> provider3, Provider<SelfieApiServiceAdapter> provider4) {
        this.module = faceCaptureApiServiceModule;
        this.apiServiceFactoryProvider = provider;
        this.okHttpClientProvider = provider2;
        this.gsonProvider = provider3;
        this.selfieApiServiceAdapterProvider = provider4;
    }

    public static FaceCaptureApiServiceModule_ProvidesApiServiceFactory create(FaceCaptureApiServiceModule faceCaptureApiServiceModule, Provider<ApiServiceFactory> provider, Provider<OkHttpClient> provider2, Provider<Gson> provider3, Provider<SelfieApiServiceAdapter> provider4) {
        return new FaceCaptureApiServiceModule_ProvidesApiServiceFactory(faceCaptureApiServiceModule, provider, provider2, provider3, provider4);
    }

    public static IFaceCaptureApiService providesApiService(FaceCaptureApiServiceModule faceCaptureApiServiceModule, ApiServiceFactory apiServiceFactory, OkHttpClient okHttpClient, Gson gson, SelfieApiServiceAdapter selfieApiServiceAdapter) {
        return (IFaceCaptureApiService) Preconditions.checkNotNullFromProvides(faceCaptureApiServiceModule.providesApiService(apiServiceFactory, okHttpClient, gson, selfieApiServiceAdapter));
    }

    @Override // javax.inject.Provider
    public IFaceCaptureApiService get() {
        return providesApiService(this.module, this.apiServiceFactoryProvider.get(), this.okHttpClientProvider.get(), this.gsonProvider.get(), this.selfieApiServiceAdapterProvider.get());
    }
}
