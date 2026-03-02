package com.yoti.mobile.android.yotisdkcore.stepTracker.di;

import com.yoti.mobile.android.yotisdkcore.stepTracker.domain.SessionConfigurationFilterProcessor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.di.StepTrackerCoreModule_ProvidesSessionConfigurationFilterOptionsFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4998xaa5fb8fe implements Factory<SessionConfigurationFilterProcessor.a> {

    /* JADX INFO: renamed from: a */
    private final StepTrackerCoreModule f7628a;

    public C4998xaa5fb8fe(StepTrackerCoreModule stepTrackerCoreModule) {
        this.f7628a = stepTrackerCoreModule;
    }

    public static C4998xaa5fb8fe create(StepTrackerCoreModule stepTrackerCoreModule) {
        return new C4998xaa5fb8fe(stepTrackerCoreModule);
    }

    public static SessionConfigurationFilterProcessor.a providesSessionConfigurationFilterOptions(StepTrackerCoreModule stepTrackerCoreModule) {
        return (SessionConfigurationFilterProcessor.a) Preconditions.checkNotNullFromProvides(stepTrackerCoreModule.m5151c());
    }

    @Override // javax.inject.Provider
    public SessionConfigurationFilterProcessor.a get() {
        return providesSessionConfigurationFilterOptions(this.f7628a);
    }
}
