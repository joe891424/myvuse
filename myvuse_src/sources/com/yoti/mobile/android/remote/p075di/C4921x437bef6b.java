package com.yoti.mobile.android.remote.p075di;

import com.yoti.mobile.android.remote.interceptor.TypedInterceptor;
import com.yoti.mobile.android.remote.interceptor.TypedLoggingInterceptor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.remote.di.RemoteModule_ProvideLoggingInterceptor$remote_productionReleaseFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4921x437bef6b implements Factory<TypedInterceptor> {
    private final Provider<TypedLoggingInterceptor> actualProvider;
    private final RemoteModule module;

    public C4921x437bef6b(RemoteModule remoteModule, Provider<TypedLoggingInterceptor> provider) {
        this.module = remoteModule;
        this.actualProvider = provider;
    }

    @Override // javax.inject.Provider
    public TypedInterceptor get() {
        return provideLoggingInterceptor$remote_productionRelease(this.module, this.actualProvider.get());
    }

    public static C4921x437bef6b create(RemoteModule remoteModule, Provider<TypedLoggingInterceptor> provider) {
        return new C4921x437bef6b(remoteModule, provider);
    }

    public static TypedInterceptor provideLoggingInterceptor$remote_productionRelease(RemoteModule remoteModule, TypedLoggingInterceptor typedLoggingInterceptor) {
        return (TypedInterceptor) Preconditions.checkNotNullFromProvides(remoteModule.provideLoggingInterceptor$remote_productionRelease(typedLoggingInterceptor));
    }
}
