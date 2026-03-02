package com.yoti.mobile.android.remote.p075di;

import com.yoti.mobile.android.remote.ServiceLocation;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes4.dex */
public final class RemoteModule_ProvidesServiceLocationFactory implements Factory<ServiceLocation> {
    private final RemoteModule module;

    public RemoteModule_ProvidesServiceLocationFactory(RemoteModule remoteModule) {
        this.module = remoteModule;
    }

    @Override // javax.inject.Provider
    public ServiceLocation get() {
        return providesServiceLocation(this.module);
    }

    public static RemoteModule_ProvidesServiceLocationFactory create(RemoteModule remoteModule) {
        return new RemoteModule_ProvidesServiceLocationFactory(remoteModule);
    }

    public static ServiceLocation providesServiceLocation(RemoteModule remoteModule) {
        return (ServiceLocation) Preconditions.checkNotNullFromProvides(remoteModule.providesServiceLocation());
    }
}
