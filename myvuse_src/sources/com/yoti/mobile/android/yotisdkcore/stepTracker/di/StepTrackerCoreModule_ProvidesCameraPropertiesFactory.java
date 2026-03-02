package com.yoti.mobile.android.yotisdkcore.stepTracker.di;

import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.CaptureCameraProperties;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes4.dex */
public final class StepTrackerCoreModule_ProvidesCameraPropertiesFactory implements Factory<CaptureCameraProperties> {

    /* JADX INFO: renamed from: a */
    private final StepTrackerCoreModule f7626a;

    public StepTrackerCoreModule_ProvidesCameraPropertiesFactory(StepTrackerCoreModule stepTrackerCoreModule) {
        this.f7626a = stepTrackerCoreModule;
    }

    public static StepTrackerCoreModule_ProvidesCameraPropertiesFactory create(StepTrackerCoreModule stepTrackerCoreModule) {
        return new StepTrackerCoreModule_ProvidesCameraPropertiesFactory(stepTrackerCoreModule);
    }

    public static CaptureCameraProperties providesCameraProperties(StepTrackerCoreModule stepTrackerCoreModule) {
        return (CaptureCameraProperties) Preconditions.checkNotNullFromProvides(stepTrackerCoreModule.m5149a());
    }

    @Override // javax.inject.Provider
    public CaptureCameraProperties get() {
        return providesCameraProperties(this.f7626a);
    }
}
