package com.yoti.mobile.android.remote.p075di;

import com.yoti.mobile.android.remote.ApiServiceFactory;
import com.yoti.mobile.android.remote.interceptor.TypedInterceptor;
import com.yoti.mobile.android.remote.model.Session;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.remote.di.RemoteModule_ProvideAuthInterceptor$remote_productionReleaseFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4920x3eb9105a implements Factory<TypedInterceptor> {
    private final Provider<ApiServiceFactory> apiServiceFactoryProvider;
    private final RemoteModule module;
    private final Provider<Session> sessionProvider;

    public C4920x3eb9105a(RemoteModule remoteModule, Provider<ApiServiceFactory> provider, Provider<Session> provider2) {
        this.module = remoteModule;
        this.apiServiceFactoryProvider = provider;
        this.sessionProvider = provider2;
    }

    @Override // javax.inject.Provider
    public TypedInterceptor get() {
        return provideAuthInterceptor$remote_productionRelease(this.module, this.apiServiceFactoryProvider.get(), this.sessionProvider.get());
    }

    public static C4920x3eb9105a create(RemoteModule remoteModule, Provider<ApiServiceFactory> provider, Provider<Session> provider2) {
        return new C4920x3eb9105a(remoteModule, provider, provider2);
    }

    public static TypedInterceptor provideAuthInterceptor$remote_productionRelease(RemoteModule remoteModule, ApiServiceFactory apiServiceFactory, Session session) {
        return (TypedInterceptor) Preconditions.checkNotNullFromProvides(remoteModule.provideAuthInterceptor$remote_productionRelease(apiServiceFactory, session));
    }
}
