package com.yoti.mobile.android.remote.p075di;

import com.yoti.mobile.android.remote.interceptor.SessionIdInterceptor;
import com.yoti.mobile.android.remote.interceptor.TypedInterceptor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.remote.di.RemoteModule_ProvideSessionInterceptor$remote_productionReleaseFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4923xa107bd4 implements Factory<TypedInterceptor> {
    private final Provider<SessionIdInterceptor> actualProvider;
    private final RemoteModule module;

    public C4923xa107bd4(RemoteModule remoteModule, Provider<SessionIdInterceptor> provider) {
        this.module = remoteModule;
        this.actualProvider = provider;
    }

    @Override // javax.inject.Provider
    public TypedInterceptor get() {
        return provideSessionInterceptor$remote_productionRelease(this.module, this.actualProvider.get());
    }

    public static C4923xa107bd4 create(RemoteModule remoteModule, Provider<SessionIdInterceptor> provider) {
        return new C4923xa107bd4(remoteModule, provider);
    }

    public static TypedInterceptor provideSessionInterceptor$remote_productionRelease(RemoteModule remoteModule, SessionIdInterceptor sessionIdInterceptor) {
        return (TypedInterceptor) Preconditions.checkNotNullFromProvides(remoteModule.provideSessionInterceptor$remote_productionRelease(sessionIdInterceptor));
    }
}
