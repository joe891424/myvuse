package com.yoti.mobile.android.yotisdkcore.stepTracker.di;

import com.yoti.mobile.android.yotisdkcore.core.domain.ISessionConfigurationRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes4.dex */
public final class StepTrackerCoreModule_ProvidesStepRepositoryFactory implements Factory<ISessionConfigurationRepository> {

    /* JADX INFO: renamed from: a */
    private final StepTrackerCoreModule f7630a;

    public StepTrackerCoreModule_ProvidesStepRepositoryFactory(StepTrackerCoreModule stepTrackerCoreModule) {
        this.f7630a = stepTrackerCoreModule;
    }

    public static StepTrackerCoreModule_ProvidesStepRepositoryFactory create(StepTrackerCoreModule stepTrackerCoreModule) {
        return new StepTrackerCoreModule_ProvidesStepRepositoryFactory(stepTrackerCoreModule);
    }

    public static ISessionConfigurationRepository providesStepRepository(StepTrackerCoreModule stepTrackerCoreModule) {
        return (ISessionConfigurationRepository) Preconditions.checkNotNullFromProvides(stepTrackerCoreModule.m5153e());
    }

    @Override // javax.inject.Provider
    public ISessionConfigurationRepository get() {
        return providesStepRepository(this.f7630a);
    }
}
