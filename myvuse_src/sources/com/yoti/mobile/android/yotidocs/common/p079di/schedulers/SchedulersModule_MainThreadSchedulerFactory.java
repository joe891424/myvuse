package com.yoti.mobile.android.yotidocs.common.p079di.schedulers;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.reactivex.Scheduler;

/* JADX INFO: loaded from: classes4.dex */
public final class SchedulersModule_MainThreadSchedulerFactory implements Factory<Scheduler> {

    /* JADX INFO: renamed from: a */
    private final SchedulersModule f7483a;

    public SchedulersModule_MainThreadSchedulerFactory(SchedulersModule schedulersModule) {
        this.f7483a = schedulersModule;
    }

    public static SchedulersModule_MainThreadSchedulerFactory create(SchedulersModule schedulersModule) {
        return new SchedulersModule_MainThreadSchedulerFactory(schedulersModule);
    }

    public static Scheduler mainThreadScheduler(SchedulersModule schedulersModule) {
        return (Scheduler) Preconditions.checkNotNullFromProvides(schedulersModule.mainThreadScheduler());
    }

    @Override // javax.inject.Provider
    public Scheduler get() {
        return mainThreadScheduler(this.f7483a);
    }
}
