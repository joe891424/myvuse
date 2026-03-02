package com.yoti.mobile.android.remote.p075di;

import com.google.gson.Gson;
import com.yoti.mobile.android.remote.ip_tracking.data.remote.IpifyApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.remote.di.IpTrackingModule_ProvidesIpifyApiService$remote_productionReleaseFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4919xbf389a5a implements Factory<IpifyApi> {
    private final Provider<Gson> gsonProvider;
    private final IpTrackingModule module;

    public C4919xbf389a5a(IpTrackingModule ipTrackingModule, Provider<Gson> provider) {
        this.module = ipTrackingModule;
        this.gsonProvider = provider;
    }

    @Override // javax.inject.Provider
    public IpifyApi get() {
        return providesIpifyApiService$remote_productionRelease(this.module, this.gsonProvider.get());
    }

    public static C4919xbf389a5a create(IpTrackingModule ipTrackingModule, Provider<Gson> provider) {
        return new C4919xbf389a5a(ipTrackingModule, provider);
    }

    public static IpifyApi providesIpifyApiService$remote_productionRelease(IpTrackingModule ipTrackingModule, Gson gson) {
        return (IpifyApi) Preconditions.checkNotNullFromProvides(ipTrackingModule.providesIpifyApiService$remote_productionRelease(gson));
    }
}
