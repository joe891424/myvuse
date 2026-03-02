package com.yoti.mobile.android.yotidocs.common.p079di.schedulers;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0017J\b\u0010\u0005\u001a\u00020\u0004H\u0017J\b\u0010\u0006\u001a\u00020\u0004H\u0007¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/di/schedulers/SchedulersModule;", "", "()V", "computationScheduler", "Lio/reactivex/Scheduler;", "ioScheduler", "mainThreadScheduler", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module
public class SchedulersModule {
    @Provides
    @ForComputation
    public Scheduler computationScheduler() {
        Scheduler schedulerComputation = Schedulers.computation();
        Intrinsics.checkNotNullExpressionValue(schedulerComputation, "computation()");
        return schedulerComputation;
    }

    @ForIo
    @Provides
    public Scheduler ioScheduler() {
        Scheduler schedulerM5595io = Schedulers.m5595io();
        Intrinsics.checkNotNullExpressionValue(schedulerM5595io, "io()");
        return schedulerM5595io;
    }

    @Provides
    @ForMainThread
    public final Scheduler mainThreadScheduler() {
        Scheduler schedulerMainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(schedulerMainThread, "mainThread()");
        return schedulerMainThread;
    }
}
