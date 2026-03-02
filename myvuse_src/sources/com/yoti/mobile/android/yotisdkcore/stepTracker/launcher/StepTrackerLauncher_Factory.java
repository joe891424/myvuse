package com.yoti.mobile.android.yotisdkcore.stepTracker.launcher;

import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class StepTrackerLauncher_Factory implements Factory<StepTrackerLauncher> {

    /* JADX INFO: renamed from: a */
    private final Provider<SessionStatus> f7691a;

    public StepTrackerLauncher_Factory(Provider<SessionStatus> provider) {
        this.f7691a = provider;
    }

    public static StepTrackerLauncher_Factory create(Provider<SessionStatus> provider) {
        return new StepTrackerLauncher_Factory(provider);
    }

    public static StepTrackerLauncher newInstance(SessionStatus sessionStatus) {
        return new StepTrackerLauncher(sessionStatus);
    }

    @Override // javax.inject.Provider
    public StepTrackerLauncher get() {
        return newInstance(this.f7691a.get());
    }
}
