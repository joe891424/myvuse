package com.yoti.mobile.android.remote.p075di;

import com.google.gson.GsonBuilder;
import com.yoti.mobile.android.remote.ApiServiceFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class RemoteModule_ProvidesGsonBuilderFactory implements Factory<GsonBuilder> {
    private final Provider<ApiServiceFactory> apiServiceFactoryProvider;
    private final RemoteModule module;

    public RemoteModule_ProvidesGsonBuilderFactory(RemoteModule remoteModule, Provider<ApiServiceFactory> provider) {
        this.module = remoteModule;
        this.apiServiceFactoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public GsonBuilder get() {
        return providesGsonBuilder(this.module, this.apiServiceFactoryProvider.get());
    }

    public static RemoteModule_ProvidesGsonBuilderFactory create(RemoteModule remoteModule, Provider<ApiServiceFactory> provider) {
        return new RemoteModule_ProvidesGsonBuilderFactory(remoteModule, provider);
    }

    public static GsonBuilder providesGsonBuilder(RemoteModule remoteModule, ApiServiceFactory apiServiceFactory) {
        return (GsonBuilder) Preconditions.checkNotNullFromProvides(remoteModule.providesGsonBuilder(apiServiceFactory));
    }
}
