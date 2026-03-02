package com.yoti.mobile.android.yotisdkcore.core.p085di;

import com.yoti.mobile.android.remote.ApiServiceFactory;
import com.yoti.mobile.android.yotisdkcore.stepTracker.data.remote.DeleteSessionTokenApiService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes4.dex */
public final class SessionTokenApiServiceModule_ProvidesApiServiceFactory implements Factory<DeleteSessionTokenApiService> {
    private final Provider<ApiServiceFactory> apiServiceFactoryProvider;
    private final SessionTokenApiServiceModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public SessionTokenApiServiceModule_ProvidesApiServiceFactory(SessionTokenApiServiceModule sessionTokenApiServiceModule, Provider<ApiServiceFactory> provider, Provider<OkHttpClient> provider2) {
        this.module = sessionTokenApiServiceModule;
        this.apiServiceFactoryProvider = provider;
        this.okHttpClientProvider = provider2;
    }

    public static SessionTokenApiServiceModule_ProvidesApiServiceFactory create(SessionTokenApiServiceModule sessionTokenApiServiceModule, Provider<ApiServiceFactory> provider, Provider<OkHttpClient> provider2) {
        return new SessionTokenApiServiceModule_ProvidesApiServiceFactory(sessionTokenApiServiceModule, provider, provider2);
    }

    public static DeleteSessionTokenApiService providesApiService(SessionTokenApiServiceModule sessionTokenApiServiceModule, ApiServiceFactory apiServiceFactory, OkHttpClient okHttpClient) {
        return (DeleteSessionTokenApiService) Preconditions.checkNotNullFromProvides(sessionTokenApiServiceModule.providesApiService(apiServiceFactory, okHttpClient));
    }

    @Override // javax.inject.Provider
    public DeleteSessionTokenApiService get() {
        return providesApiService(this.module, this.apiServiceFactoryProvider.get(), this.okHttpClientProvider.get());
    }
}
