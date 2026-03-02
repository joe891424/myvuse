package com.yoti.mobile.android.documentcapture.p055id.p056di;

import com.yoti.mobile.android.remote.ApiServiceFactory;
import com.yoti.mobile.android.yotisdkcore.core.data.remote.SdkCoreApiService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.di.IdDocumentCaptureApiServiceModule_ProvidesSessionConfigurationApiServiceFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4613x9da8fa95 implements Factory<SdkCoreApiService> {
    private final Provider<ApiServiceFactory> apiServiceFactoryProvider;
    private final IdDocumentCaptureApiServiceModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public C4613x9da8fa95(IdDocumentCaptureApiServiceModule idDocumentCaptureApiServiceModule, Provider<ApiServiceFactory> provider, Provider<OkHttpClient> provider2) {
        this.module = idDocumentCaptureApiServiceModule;
        this.apiServiceFactoryProvider = provider;
        this.okHttpClientProvider = provider2;
    }

    public static C4613x9da8fa95 create(IdDocumentCaptureApiServiceModule idDocumentCaptureApiServiceModule, Provider<ApiServiceFactory> provider, Provider<OkHttpClient> provider2) {
        return new C4613x9da8fa95(idDocumentCaptureApiServiceModule, provider, provider2);
    }

    public static SdkCoreApiService providesSessionConfigurationApiService(IdDocumentCaptureApiServiceModule idDocumentCaptureApiServiceModule, ApiServiceFactory apiServiceFactory, OkHttpClient okHttpClient) {
        return (SdkCoreApiService) Preconditions.checkNotNullFromProvides(idDocumentCaptureApiServiceModule.providesSessionConfigurationApiService(apiServiceFactory, okHttpClient));
    }

    @Override // javax.inject.Provider
    public SdkCoreApiService get() {
        return providesSessionConfigurationApiService(this.module, this.apiServiceFactoryProvider.get(), this.okHttpClientProvider.get());
    }
}
