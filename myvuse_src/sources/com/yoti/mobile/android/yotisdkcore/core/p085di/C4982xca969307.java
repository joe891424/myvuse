package com.yoti.mobile.android.yotisdkcore.core.p085di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import retrofit2.CallAdapter;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.core.di.SessionTokenApiServiceModule_ProvidesNetworkResponseAdapterFactoryFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4982xca969307 implements Factory<CallAdapter.Factory> {
    private final SessionTokenApiServiceModule module;

    public C4982xca969307(SessionTokenApiServiceModule sessionTokenApiServiceModule) {
        this.module = sessionTokenApiServiceModule;
    }

    public static C4982xca969307 create(SessionTokenApiServiceModule sessionTokenApiServiceModule) {
        return new C4982xca969307(sessionTokenApiServiceModule);
    }

    public static CallAdapter.Factory providesNetworkResponseAdapterFactory(SessionTokenApiServiceModule sessionTokenApiServiceModule) {
        return (CallAdapter.Factory) Preconditions.checkNotNullFromProvides(sessionTokenApiServiceModule.providesNetworkResponseAdapterFactory());
    }

    @Override // javax.inject.Provider
    public CallAdapter.Factory get() {
        return providesNetworkResponseAdapterFactory(this.module);
    }
}
