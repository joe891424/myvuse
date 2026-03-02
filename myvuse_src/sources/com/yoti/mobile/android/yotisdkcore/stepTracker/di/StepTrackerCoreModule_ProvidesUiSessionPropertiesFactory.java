package com.yoti.mobile.android.yotisdkcore.stepTracker.di;

import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.UiSessionProperties;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes4.dex */
public final class StepTrackerCoreModule_ProvidesUiSessionPropertiesFactory implements Factory<UiSessionProperties> {

    /* JADX INFO: renamed from: a */
    private final StepTrackerCoreModule f7631a;

    public StepTrackerCoreModule_ProvidesUiSessionPropertiesFactory(StepTrackerCoreModule stepTrackerCoreModule) {
        this.f7631a = stepTrackerCoreModule;
    }

    public static StepTrackerCoreModule_ProvidesUiSessionPropertiesFactory create(StepTrackerCoreModule stepTrackerCoreModule) {
        return new StepTrackerCoreModule_ProvidesUiSessionPropertiesFactory(stepTrackerCoreModule);
    }

    public static UiSessionProperties providesUiSessionProperties(StepTrackerCoreModule stepTrackerCoreModule) {
        return (UiSessionProperties) Preconditions.checkNotNullFromProvides(stepTrackerCoreModule.m5154f());
    }

    @Override // javax.inject.Provider
    public UiSessionProperties get() {
        return providesUiSessionProperties(this.f7631a);
    }
}
