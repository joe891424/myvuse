package com.yoti.mobile.android.remote.p075di;

import com.google.gson.Gson;
import com.yoti.mobile.android.remote.ip_tracking.data.remote.IcanhazipApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.remote.di.IpTrackingModule_ProvidesIcanhazipApiService$remote_productionReleaseFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4915xdf915f86 implements Factory<IcanhazipApi> {
    private final Provider<Gson> gsonProvider;
    private final IpTrackingModule module;

    public C4915xdf915f86(IpTrackingModule ipTrackingModule, Provider<Gson> provider) {
        this.module = ipTrackingModule;
        this.gsonProvider = provider;
    }

    @Override // javax.inject.Provider
    public IcanhazipApi get() {
        return providesIcanhazipApiService$remote_productionRelease(this.module, this.gsonProvider.get());
    }

    public static C4915xdf915f86 create(IpTrackingModule ipTrackingModule, Provider<Gson> provider) {
        return new C4915xdf915f86(ipTrackingModule, provider);
    }

    public static IcanhazipApi providesIcanhazipApiService$remote_productionRelease(IpTrackingModule ipTrackingModule, Gson gson) {
        return (IcanhazipApi) Preconditions.checkNotNullFromProvides(ipTrackingModule.providesIcanhazipApiService$remote_productionRelease(gson));
    }
}
