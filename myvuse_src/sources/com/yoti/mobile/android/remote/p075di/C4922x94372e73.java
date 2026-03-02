package com.yoti.mobile.android.remote.p075di;

import com.yoti.mobile.android.remote.interceptor.MetadataInterceptor;
import com.yoti.mobile.android.remote.interceptor.TypedInterceptor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.remote.di.RemoteModule_ProvideMetadataInterceptor$remote_productionReleaseFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4922x94372e73 implements Factory<TypedInterceptor> {
    private final Provider<MetadataInterceptor> actualProvider;
    private final RemoteModule module;

    public C4922x94372e73(RemoteModule remoteModule, Provider<MetadataInterceptor> provider) {
        this.module = remoteModule;
        this.actualProvider = provider;
    }

    @Override // javax.inject.Provider
    public TypedInterceptor get() {
        return provideMetadataInterceptor$remote_productionRelease(this.module, this.actualProvider.get());
    }

    public static C4922x94372e73 create(RemoteModule remoteModule, Provider<MetadataInterceptor> provider) {
        return new C4922x94372e73(remoteModule, provider);
    }

    public static TypedInterceptor provideMetadataInterceptor$remote_productionRelease(RemoteModule remoteModule, MetadataInterceptor metadataInterceptor) {
        return (TypedInterceptor) Preconditions.checkNotNullFromProvides(remoteModule.provideMetadataInterceptor$remote_productionRelease(metadataInterceptor));
    }
}
