package com.yoti.mobile.android.remote.ip_tracking.data.remote;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class IpifyIpRemoteDataSource_Factory implements Factory<IpifyIpRemoteDataSource> {
    private final Provider<IpifyApi> apiServiceProvider;

    public IpifyIpRemoteDataSource_Factory(Provider<IpifyApi> provider) {
        this.apiServiceProvider = provider;
    }

    @Override // javax.inject.Provider
    public IpifyIpRemoteDataSource get() {
        return newInstance(this.apiServiceProvider.get());
    }

    public static IpifyIpRemoteDataSource_Factory create(Provider<IpifyApi> provider) {
        return new IpifyIpRemoteDataSource_Factory(provider);
    }

    public static IpifyIpRemoteDataSource newInstance(IpifyApi ipifyApi) {
        return new IpifyIpRemoteDataSource(ipifyApi);
    }
}
