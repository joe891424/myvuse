package com.yoti.mobile.android.remote.ip_tracking.data.remote;

import com.yoti.mobile.android.remote.ip_tracking.data.IIpRemoteDataSource;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class IpRemoteDataSourceWithFallback_Factory implements Factory<IpRemoteDataSourceWithFallback> {
    private final Provider<IIpRemoteDataSource> fallbackApiServiceProvider;
    private final Provider<IIpRemoteDataSource> primaryApiServiceProvider;

    public IpRemoteDataSourceWithFallback_Factory(Provider<IIpRemoteDataSource> provider, Provider<IIpRemoteDataSource> provider2) {
        this.primaryApiServiceProvider = provider;
        this.fallbackApiServiceProvider = provider2;
    }

    @Override // javax.inject.Provider
    public IpRemoteDataSourceWithFallback get() {
        return newInstance(this.primaryApiServiceProvider.get(), this.fallbackApiServiceProvider.get());
    }

    public static IpRemoteDataSourceWithFallback_Factory create(Provider<IIpRemoteDataSource> provider, Provider<IIpRemoteDataSource> provider2) {
        return new IpRemoteDataSourceWithFallback_Factory(provider, provider2);
    }

    public static IpRemoteDataSourceWithFallback newInstance(IIpRemoteDataSource iIpRemoteDataSource, IIpRemoteDataSource iIpRemoteDataSource2) {
        return new IpRemoteDataSourceWithFallback(iIpRemoteDataSource, iIpRemoteDataSource2);
    }
}
