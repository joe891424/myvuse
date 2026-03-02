package com.yoti.mobile.android.yotisdkcore.stepTracker.launcher.di;

import com.yoti.mobile.android.yotisdkcore.core.data.SessionConfigurationRepository;
import com.yoti.mobile.android.yotisdkcore.stepTracker.data.SessionTokenRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class StepTrackerDependencyProvider_Factory implements Factory<StepTrackerDependencyProvider> {

    /* JADX INFO: renamed from: a */
    private final Provider<SessionTokenRepository> f7694a;

    /* JADX INFO: renamed from: b */
    private final Provider<SessionConfigurationRepository> f7695b;

    public StepTrackerDependencyProvider_Factory(Provider<SessionTokenRepository> provider, Provider<SessionConfigurationRepository> provider2) {
        this.f7694a = provider;
        this.f7695b = provider2;
    }

    public static StepTrackerDependencyProvider_Factory create(Provider<SessionTokenRepository> provider, Provider<SessionConfigurationRepository> provider2) {
        return new StepTrackerDependencyProvider_Factory(provider, provider2);
    }

    public static StepTrackerDependencyProvider newInstance(SessionTokenRepository sessionTokenRepository, SessionConfigurationRepository sessionConfigurationRepository) {
        return new StepTrackerDependencyProvider(sessionTokenRepository, sessionConfigurationRepository);
    }

    @Override // javax.inject.Provider
    public StepTrackerDependencyProvider get() {
        return newInstance(this.f7694a.get(), this.f7695b.get());
    }
}
