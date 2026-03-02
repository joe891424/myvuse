package com.yoti.mobile.android.remote.p075di;

import com.yoti.mobile.android.remote.ip_tracking.data.IpRepository;
import com.yoti.mobile.android.remote.ip_tracking.domain.IIpRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.remote.di.IpTrackingModule_ProvidesIpRepository$remote_productionReleaseFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4918x4d860449 implements Factory<IIpRepository> {
    private final Provider<IpRepository> actualProvider;
    private final IpTrackingModule module;

    public C4918x4d860449(IpTrackingModule ipTrackingModule, Provider<IpRepository> provider) {
        this.module = ipTrackingModule;
        this.actualProvider = provider;
    }

    @Override // javax.inject.Provider
    public IIpRepository get() {
        return providesIpRepository$remote_productionRelease(this.module, this.actualProvider.get());
    }

    public static C4918x4d860449 create(IpTrackingModule ipTrackingModule, Provider<IpRepository> provider) {
        return new C4918x4d860449(ipTrackingModule, provider);
    }

    public static IIpRepository providesIpRepository$remote_productionRelease(IpTrackingModule ipTrackingModule, IpRepository ipRepository) {
        return (IIpRepository) Preconditions.checkNotNullFromProvides(ipTrackingModule.providesIpRepository$remote_productionRelease(ipRepository));
    }
}
