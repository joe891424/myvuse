package com.yoti.mobile.android.yotisdkcore.stepTracker.domain;

import com.yoti.mobile.android.yotisdkcore.core.domain.ISessionConfigurationRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class GetSessionConfigurationInteractor_Factory implements Factory<GetSessionConfigurationInteractor> {

    /* JADX INFO: renamed from: a */
    private final Provider<ISessionConfigurationRepository> f7681a;

    /* JADX INFO: renamed from: b */
    private final Provider<SessionConfigurationFilterProcessor> f7682b;

    public GetSessionConfigurationInteractor_Factory(Provider<ISessionConfigurationRepository> provider, Provider<SessionConfigurationFilterProcessor> provider2) {
        this.f7681a = provider;
        this.f7682b = provider2;
    }

    public static GetSessionConfigurationInteractor_Factory create(Provider<ISessionConfigurationRepository> provider, Provider<SessionConfigurationFilterProcessor> provider2) {
        return new GetSessionConfigurationInteractor_Factory(provider, provider2);
    }

    public static GetSessionConfigurationInteractor newInstance(ISessionConfigurationRepository iSessionConfigurationRepository, SessionConfigurationFilterProcessor sessionConfigurationFilterProcessor) {
        return new GetSessionConfigurationInteractor(iSessionConfigurationRepository, sessionConfigurationFilterProcessor);
    }

    @Override // javax.inject.Provider
    public GetSessionConfigurationInteractor get() {
        return newInstance(this.f7681a.get(), this.f7682b.get());
    }
}
