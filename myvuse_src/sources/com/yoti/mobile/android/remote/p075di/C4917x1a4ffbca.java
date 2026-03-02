package com.yoti.mobile.android.remote.p075di;

import com.yoti.mobile.android.remote.ip_tracking.data.IIpRemoteDataSource;
import com.yoti.mobile.android.remote.ip_tracking.data.remote.IcanhazipIpRemoteDataSource;
import com.yoti.mobile.android.remote.ip_tracking.data.remote.IpifyIpRemoteDataSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.remote.di.IpTrackingModule_ProvidesIpRemoteDataSource$remote_productionReleaseFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4917x1a4ffbca implements Factory<IIpRemoteDataSource> {
    private final Provider<IcanhazipIpRemoteDataSource> fallbackProvider;
    private final IpTrackingModule module;
    private final Provider<IpifyIpRemoteDataSource> primaryProvider;

    public C4917x1a4ffbca(IpTrackingModule ipTrackingModule, Provider<IpifyIpRemoteDataSource> provider, Provider<IcanhazipIpRemoteDataSource> provider2) {
        this.module = ipTrackingModule;
        this.primaryProvider = provider;
        this.fallbackProvider = provider2;
    }

    @Override // javax.inject.Provider
    public IIpRemoteDataSource get() {
        return providesIpRemoteDataSource$remote_productionRelease(this.module, this.primaryProvider.get(), this.fallbackProvider.get());
    }

    public static C4917x1a4ffbca create(IpTrackingModule ipTrackingModule, Provider<IpifyIpRemoteDataSource> provider, Provider<IcanhazipIpRemoteDataSource> provider2) {
        return new C4917x1a4ffbca(ipTrackingModule, provider, provider2);
    }

    public static IIpRemoteDataSource providesIpRemoteDataSource$remote_productionRelease(IpTrackingModule ipTrackingModule, IpifyIpRemoteDataSource ipifyIpRemoteDataSource, IcanhazipIpRemoteDataSource icanhazipIpRemoteDataSource) {
        return (IIpRemoteDataSource) Preconditions.checkNotNullFromProvides(ipTrackingModule.providesIpRemoteDataSource$remote_productionRelease(ipifyIpRemoteDataSource, icanhazipIpRemoteDataSource));
    }
}
