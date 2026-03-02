package com.yoti.mobile.android.yotisdkcore.stepTracker.di;

import com.yoti.mobile.android.yotisdkcore.stepTracker.domain.ISessionTokenRepository;
import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class StepTrackerCoreModule_ProvidesSessionTokenRepositoryFactory implements Factory<ISessionTokenRepository> {

    /* JADX INFO: renamed from: a */
    private final StepTrackerCoreModule f7629a;

    public StepTrackerCoreModule_ProvidesSessionTokenRepositoryFactory(StepTrackerCoreModule stepTrackerCoreModule) {
        this.f7629a = stepTrackerCoreModule;
    }

    public static StepTrackerCoreModule_ProvidesSessionTokenRepositoryFactory create(StepTrackerCoreModule stepTrackerCoreModule) {
        return new StepTrackerCoreModule_ProvidesSessionTokenRepositoryFactory(stepTrackerCoreModule);
    }

    public static ISessionTokenRepository providesSessionTokenRepository(StepTrackerCoreModule stepTrackerCoreModule) {
        return stepTrackerCoreModule.m5152d();
    }

    @Override // javax.inject.Provider
    public ISessionTokenRepository get() {
        return providesSessionTokenRepository(this.f7629a);
    }
}
