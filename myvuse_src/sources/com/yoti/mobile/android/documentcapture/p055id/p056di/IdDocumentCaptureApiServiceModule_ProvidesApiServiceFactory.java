package com.yoti.mobile.android.documentcapture.p055id.p056di;

import com.google.gson.Gson;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.DocumentCaptureApiService;
import com.yoti.mobile.android.remote.ApiServiceFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes5.dex */
public final class IdDocumentCaptureApiServiceModule_ProvidesApiServiceFactory implements Factory<DocumentCaptureApiService> {
    private final Provider<ApiServiceFactory> apiServiceFactoryProvider;
    private final Provider<Gson> gsonProvider;
    private final IdDocumentCaptureApiServiceModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public IdDocumentCaptureApiServiceModule_ProvidesApiServiceFactory(IdDocumentCaptureApiServiceModule idDocumentCaptureApiServiceModule, Provider<ApiServiceFactory> provider, Provider<OkHttpClient> provider2, Provider<Gson> provider3) {
        this.module = idDocumentCaptureApiServiceModule;
        this.apiServiceFactoryProvider = provider;
        this.okHttpClientProvider = provider2;
        this.gsonProvider = provider3;
    }

    public static IdDocumentCaptureApiServiceModule_ProvidesApiServiceFactory create(IdDocumentCaptureApiServiceModule idDocumentCaptureApiServiceModule, Provider<ApiServiceFactory> provider, Provider<OkHttpClient> provider2, Provider<Gson> provider3) {
        return new IdDocumentCaptureApiServiceModule_ProvidesApiServiceFactory(idDocumentCaptureApiServiceModule, provider, provider2, provider3);
    }

    public static DocumentCaptureApiService providesApiService(IdDocumentCaptureApiServiceModule idDocumentCaptureApiServiceModule, ApiServiceFactory apiServiceFactory, OkHttpClient okHttpClient, Gson gson) {
        return (DocumentCaptureApiService) Preconditions.checkNotNullFromProvides(idDocumentCaptureApiServiceModule.providesApiService(apiServiceFactory, okHttpClient, gson));
    }

    @Override // javax.inject.Provider
    public DocumentCaptureApiService get() {
        return providesApiService(this.module, this.apiServiceFactoryProvider.get(), this.okHttpClientProvider.get(), this.gsonProvider.get());
    }
}
