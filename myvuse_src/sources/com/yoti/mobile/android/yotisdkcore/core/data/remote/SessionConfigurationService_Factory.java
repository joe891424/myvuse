package com.yoti.mobile.android.yotisdkcore.core.data.remote;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class SessionConfigurationService_Factory implements Factory<SessionConfigurationService> {
    private final Provider<SdkCoreApiService> sdkCoreApiServiceProvider;

    public SessionConfigurationService_Factory(Provider<SdkCoreApiService> provider) {
        this.sdkCoreApiServiceProvider = provider;
    }

    public static SessionConfigurationService_Factory create(Provider<SdkCoreApiService> provider) {
        return new SessionConfigurationService_Factory(provider);
    }

    public static SessionConfigurationService newInstance(SdkCoreApiService sdkCoreApiService) {
        return new SessionConfigurationService(sdkCoreApiService);
    }

    @Override // javax.inject.Provider
    public SessionConfigurationService get() {
        return newInstance(this.sdkCoreApiServiceProvider.get());
    }
}
