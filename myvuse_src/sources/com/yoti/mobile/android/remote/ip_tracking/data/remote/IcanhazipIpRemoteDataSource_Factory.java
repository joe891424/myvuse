package com.yoti.mobile.android.remote.ip_tracking.data.remote;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class IcanhazipIpRemoteDataSource_Factory implements Factory<IcanhazipIpRemoteDataSource> {
    private final Provider<IcanhazipApi> apiServiceProvider;

    public IcanhazipIpRemoteDataSource_Factory(Provider<IcanhazipApi> provider) {
        this.apiServiceProvider = provider;
    }

    @Override // javax.inject.Provider
    public IcanhazipIpRemoteDataSource get() {
        return newInstance(this.apiServiceProvider.get());
    }

    public static IcanhazipIpRemoteDataSource_Factory create(Provider<IcanhazipApi> provider) {
        return new IcanhazipIpRemoteDataSource_Factory(provider);
    }

    public static IcanhazipIpRemoteDataSource newInstance(IcanhazipApi icanhazipApi) {
        return new IcanhazipIpRemoteDataSource(icanhazipApi);
    }
}
