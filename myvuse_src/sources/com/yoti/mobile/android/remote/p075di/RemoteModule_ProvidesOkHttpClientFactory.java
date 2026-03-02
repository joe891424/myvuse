package com.yoti.mobile.android.remote.p075di;

import com.yoti.mobile.android.remote.ApiServiceFactory;
import com.yoti.mobile.android.remote.interceptor.TypedInterceptor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes4.dex */
public final class RemoteModule_ProvidesOkHttpClientFactory implements Factory<OkHttpClient> {
    private final Provider<ApiServiceFactory> apiServiceFactoryProvider;
    private final Provider<Set<TypedInterceptor>> interceptorsProvider;
    private final RemoteModule module;

    public RemoteModule_ProvidesOkHttpClientFactory(RemoteModule remoteModule, Provider<ApiServiceFactory> provider, Provider<Set<TypedInterceptor>> provider2) {
        this.module = remoteModule;
        this.apiServiceFactoryProvider = provider;
        this.interceptorsProvider = provider2;
    }

    @Override // javax.inject.Provider
    public OkHttpClient get() {
        return providesOkHttpClient(this.module, this.apiServiceFactoryProvider.get(), this.interceptorsProvider.get());
    }

    public static RemoteModule_ProvidesOkHttpClientFactory create(RemoteModule remoteModule, Provider<ApiServiceFactory> provider, Provider<Set<TypedInterceptor>> provider2) {
        return new RemoteModule_ProvidesOkHttpClientFactory(remoteModule, provider, provider2);
    }

    public static OkHttpClient providesOkHttpClient(RemoteModule remoteModule, ApiServiceFactory apiServiceFactory, Set<TypedInterceptor> set) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(remoteModule.providesOkHttpClient(apiServiceFactory, set));
    }
}
