package com.yoti.mobile.android.remote.p075di;

import com.google.gson.Gson;
import com.yoti.mobile.android.remote.ApiServiceFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class RemoteModule_ProvidesGsonFactory implements Factory<Gson> {
    private final Provider<ApiServiceFactory> apiServiceFactoryProvider;
    private final RemoteModule module;

    public RemoteModule_ProvidesGsonFactory(RemoteModule remoteModule, Provider<ApiServiceFactory> provider) {
        this.module = remoteModule;
        this.apiServiceFactoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public Gson get() {
        return providesGson(this.module, this.apiServiceFactoryProvider.get());
    }

    public static RemoteModule_ProvidesGsonFactory create(RemoteModule remoteModule, Provider<ApiServiceFactory> provider) {
        return new RemoteModule_ProvidesGsonFactory(remoteModule, provider);
    }

    public static Gson providesGson(RemoteModule remoteModule, ApiServiceFactory apiServiceFactory) {
        return (Gson) Preconditions.checkNotNullFromProvides(remoteModule.providesGson(apiServiceFactory));
    }
}
