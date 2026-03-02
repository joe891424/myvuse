package com.yoti.mobile.android.yotisdkcore.stepTracker.di;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class StepTrackerCoreSession_Factory implements Factory<StepTrackerCoreSession> {

    /* JADX INFO: renamed from: a */
    private final Provider<Context> f7632a;

    /* JADX INFO: renamed from: b */
    private final Provider<IStepTrackerCoreDependencyProvider> f7633b;

    public StepTrackerCoreSession_Factory(Provider<Context> provider, Provider<IStepTrackerCoreDependencyProvider> provider2) {
        this.f7632a = provider;
        this.f7633b = provider2;
    }

    public static StepTrackerCoreSession_Factory create(Provider<Context> provider, Provider<IStepTrackerCoreDependencyProvider> provider2) {
        return new StepTrackerCoreSession_Factory(provider, provider2);
    }

    public static StepTrackerCoreSession newInstance(Context context, IStepTrackerCoreDependencyProvider iStepTrackerCoreDependencyProvider) {
        return new StepTrackerCoreSession(context, iStepTrackerCoreDependencyProvider);
    }

    @Override // javax.inject.Provider
    public StepTrackerCoreSession get() {
        return newInstance(this.f7632a.get(), this.f7633b.get());
    }
}
