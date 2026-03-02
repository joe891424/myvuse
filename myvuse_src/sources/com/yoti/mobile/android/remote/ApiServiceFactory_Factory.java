package com.yoti.mobile.android.remote;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class ApiServiceFactory_Factory implements Factory<ApiServiceFactory> {
    private final Provider<Context> contextProvider;
    private final Provider<ServiceLocation> serviceLocationProvider;

    public ApiServiceFactory_Factory(Provider<ServiceLocation> provider, Provider<Context> provider2) {
        this.serviceLocationProvider = provider;
        this.contextProvider = provider2;
    }

    @Override // javax.inject.Provider
    public ApiServiceFactory get() {
        return newInstance(this.serviceLocationProvider.get(), this.contextProvider.get());
    }

    public static ApiServiceFactory_Factory create(Provider<ServiceLocation> provider, Provider<Context> provider2) {
        return new ApiServiceFactory_Factory(provider, provider2);
    }

    public static ApiServiceFactory newInstance(ServiceLocation serviceLocation, Context context) {
        return new ApiServiceFactory(serviceLocation, context);
    }
}
