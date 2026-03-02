package com.yoti.mobile.android.yotisdkcore.stepTracker.domain;

import com.yoti.mobile.android.yotisdkcore.core.domain.ISessionConfigurationRepository;
import com.yoti.mobile.android.yotisdkcore.core.domain.ISessionStatusRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class FinishSessionInteractor_Factory implements Factory<FinishSessionInteractor> {

    /* JADX INFO: renamed from: a */
    private final Provider<ISessionTokenRepository> f7678a;

    /* JADX INFO: renamed from: b */
    private final Provider<ISessionStatusRepository> f7679b;

    /* JADX INFO: renamed from: c */
    private final Provider<ISessionConfigurationRepository> f7680c;

    public FinishSessionInteractor_Factory(Provider<ISessionTokenRepository> provider, Provider<ISessionStatusRepository> provider2, Provider<ISessionConfigurationRepository> provider3) {
        this.f7678a = provider;
        this.f7679b = provider2;
        this.f7680c = provider3;
    }

    public static FinishSessionInteractor_Factory create(Provider<ISessionTokenRepository> provider, Provider<ISessionStatusRepository> provider2, Provider<ISessionConfigurationRepository> provider3) {
        return new FinishSessionInteractor_Factory(provider, provider2, provider3);
    }

    public static FinishSessionInteractor newInstance(ISessionTokenRepository iSessionTokenRepository, ISessionStatusRepository iSessionStatusRepository, ISessionConfigurationRepository iSessionConfigurationRepository) {
        return new FinishSessionInteractor(iSessionTokenRepository, iSessionStatusRepository, iSessionConfigurationRepository);
    }

    @Override // javax.inject.Provider
    public FinishSessionInteractor get() {
        return newInstance(this.f7678a.get(), this.f7679b.get(), this.f7680c.get());
    }
}
