package com.yoti.mobile.android.yotidocs.common.p079di.schedulers;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.reactivex.Scheduler;

/* JADX INFO: loaded from: classes4.dex */
public final class SchedulersModule_IoSchedulerFactory implements Factory<Scheduler> {

    /* JADX INFO: renamed from: a */
    private final SchedulersModule f7482a;

    public SchedulersModule_IoSchedulerFactory(SchedulersModule schedulersModule) {
        this.f7482a = schedulersModule;
    }

    public static SchedulersModule_IoSchedulerFactory create(SchedulersModule schedulersModule) {
        return new SchedulersModule_IoSchedulerFactory(schedulersModule);
    }

    public static Scheduler ioScheduler(SchedulersModule schedulersModule) {
        return (Scheduler) Preconditions.checkNotNullFromProvides(schedulersModule.ioScheduler());
    }

    @Override // javax.inject.Provider
    public Scheduler get() {
        return ioScheduler(this.f7482a);
    }
}
