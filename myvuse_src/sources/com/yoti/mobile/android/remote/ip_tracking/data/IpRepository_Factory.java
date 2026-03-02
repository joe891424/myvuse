package com.yoti.mobile.android.remote.ip_tracking.data;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class IpRepository_Factory implements Factory<IpRepository> {
    private final Provider<IIpCacheDataSource> cacheDataSourceProvider;
    private final Provider<IIpRemoteDataSource> remoteDataSourceProvider;

    public IpRepository_Factory(Provider<IIpRemoteDataSource> provider, Provider<IIpCacheDataSource> provider2) {
        this.remoteDataSourceProvider = provider;
        this.cacheDataSourceProvider = provider2;
    }

    @Override // javax.inject.Provider
    public IpRepository get() {
        return newInstance(this.remoteDataSourceProvider.get(), this.cacheDataSourceProvider.get());
    }

    public static IpRepository_Factory create(Provider<IIpRemoteDataSource> provider, Provider<IIpCacheDataSource> provider2) {
        return new IpRepository_Factory(provider, provider2);
    }

    public static IpRepository newInstance(IIpRemoteDataSource iIpRemoteDataSource, IIpCacheDataSource iIpCacheDataSource) {
        return new IpRepository(iIpRemoteDataSource, iIpCacheDataSource);
    }
}
