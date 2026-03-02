package com.yoti.mobile.android.remote.p075di;

import com.yoti.mobile.android.remote.ip_tracking.data.IIpCacheDataSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: renamed from: com.yoti.mobile.android.remote.di.IpTrackingModule_ProvidesIpCacheDataSource$remote_productionReleaseFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4916xc9de3fea implements Factory<IIpCacheDataSource> {
    private final IpTrackingModule module;

    public C4916xc9de3fea(IpTrackingModule ipTrackingModule) {
        this.module = ipTrackingModule;
    }

    @Override // javax.inject.Provider
    public IIpCacheDataSource get() {
        return providesIpCacheDataSource$remote_productionRelease(this.module);
    }

    public static C4916xc9de3fea create(IpTrackingModule ipTrackingModule) {
        return new C4916xc9de3fea(ipTrackingModule);
    }

    public static IIpCacheDataSource providesIpCacheDataSource$remote_productionRelease(IpTrackingModule ipTrackingModule) {
        return (IIpCacheDataSource) Preconditions.checkNotNullFromProvides(ipTrackingModule.providesIpCacheDataSource$remote_productionRelease());
    }
}
