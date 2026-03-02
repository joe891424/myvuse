package com.yoti.mobile.android.yotidocs.common.p079di.schedulers;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.reactivex.Scheduler;

/* JADX INFO: loaded from: classes4.dex */
public final class SchedulersModule_ComputationSchedulerFactory implements Factory<Scheduler> {

    /* JADX INFO: renamed from: a */
    private final SchedulersModule f7481a;

    public SchedulersModule_ComputationSchedulerFactory(SchedulersModule schedulersModule) {
        this.f7481a = schedulersModule;
    }

    public static Scheduler computationScheduler(SchedulersModule schedulersModule) {
        return (Scheduler) Preconditions.checkNotNullFromProvides(schedulersModule.computationScheduler());
    }

    public static SchedulersModule_ComputationSchedulerFactory create(SchedulersModule schedulersModule) {
        return new SchedulersModule_ComputationSchedulerFactory(schedulersModule);
    }

    @Override // javax.inject.Provider
    public Scheduler get() {
        return computationScheduler(this.f7481a);
    }
}
