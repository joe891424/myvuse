package com.yoti.mobile.android.documentcapture.sup.p057di;

import com.google.gson.Gson;
import com.yoti.mobile.android.documentcapture.sup.data.remote.SupDocumentCaptureApiService;
import com.yoti.mobile.android.remote.ApiServiceFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes5.dex */
public final class SupDocumentCaptureApiServiceModule_ProvidesApiServiceFactory implements Factory<SupDocumentCaptureApiService> {
    private final Provider<ApiServiceFactory> apiServiceFactoryProvider;
    private final Provider<Gson> gsonProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public SupDocumentCaptureApiServiceModule_ProvidesApiServiceFactory(Provider<ApiServiceFactory> provider, Provider<OkHttpClient> provider2, Provider<Gson> provider3) {
        this.apiServiceFactoryProvider = provider;
        this.okHttpClientProvider = provider2;
        this.gsonProvider = provider3;
    }

    public static SupDocumentCaptureApiServiceModule_ProvidesApiServiceFactory create(Provider<ApiServiceFactory> provider, Provider<OkHttpClient> provider2, Provider<Gson> provider3) {
        return new SupDocumentCaptureApiServiceModule_ProvidesApiServiceFactory(provider, provider2, provider3);
    }

    public static SupDocumentCaptureApiService providesApiService(ApiServiceFactory apiServiceFactory, OkHttpClient okHttpClient, Gson gson) {
        return (SupDocumentCaptureApiService) Preconditions.checkNotNullFromProvides(SupDocumentCaptureApiServiceModule.INSTANCE.providesApiService(apiServiceFactory, okHttpClient, gson));
    }

    @Override // javax.inject.Provider
    public SupDocumentCaptureApiService get() {
        return providesApiService(this.apiServiceFactoryProvider.get(), this.okHttpClientProvider.get(), this.gsonProvider.get());
    }
}
