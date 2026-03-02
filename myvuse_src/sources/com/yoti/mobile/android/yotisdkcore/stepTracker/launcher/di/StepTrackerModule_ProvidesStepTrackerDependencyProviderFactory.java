package com.yoti.mobile.android.yotisdkcore.stepTracker.launcher.di;

import com.yoti.mobile.android.yotisdkcore.stepTracker.di.IStepTrackerCoreDependencyProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class StepTrackerModule_ProvidesStepTrackerDependencyProviderFactory implements Factory<IStepTrackerCoreDependencyProvider> {

    /* JADX INFO: renamed from: a */
    private final StepTrackerModule f7696a;

    /* JADX INFO: renamed from: b */
    private final Provider<StepTrackerDependencyProvider> f7697b;

    public StepTrackerModule_ProvidesStepTrackerDependencyProviderFactory(StepTrackerModule stepTrackerModule, Provider<StepTrackerDependencyProvider> provider) {
        this.f7696a = stepTrackerModule;
        this.f7697b = provider;
    }

    public static StepTrackerModule_ProvidesStepTrackerDependencyProviderFactory create(StepTrackerModule stepTrackerModule, Provider<StepTrackerDependencyProvider> provider) {
        return new StepTrackerModule_ProvidesStepTrackerDependencyProviderFactory(stepTrackerModule, provider);
    }

    public static IStepTrackerCoreDependencyProvider providesStepTrackerDependencyProvider(StepTrackerModule stepTrackerModule, StepTrackerDependencyProvider stepTrackerDependencyProvider) {
        return (IStepTrackerCoreDependencyProvider) Preconditions.checkNotNullFromProvides(stepTrackerModule.m5188a(stepTrackerDependencyProvider));
    }

    @Override // javax.inject.Provider
    public IStepTrackerCoreDependencyProvider get() {
        return providesStepTrackerDependencyProvider(this.f7696a, this.f7697b.get());
    }
}
