package com.yoti.mobile.android.remote.interceptor;

import com.yoti.mobile.android.remote.ApiServiceFactory;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class TypedLoggingInterceptor_Factory implements Factory<TypedLoggingInterceptor> {
    private final Provider<ApiServiceFactory> apiServiceFactoryProvider;

    public TypedLoggingInterceptor_Factory(Provider<ApiServiceFactory> provider) {
        this.apiServiceFactoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public TypedLoggingInterceptor get() {
        return newInstance(this.apiServiceFactoryProvider.get());
    }

    public static TypedLoggingInterceptor_Factory create(Provider<ApiServiceFactory> provider) {
        return new TypedLoggingInterceptor_Factory(provider);
    }

    public static TypedLoggingInterceptor newInstance(ApiServiceFactory apiServiceFactory) {
        return new TypedLoggingInterceptor(apiServiceFactory);
    }
}
