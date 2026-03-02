package com.yoti.mobile.android.yotidocs.common;

import io.branch.rnbranch.RNBranchModule;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0019\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00018\u0000H$¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\nJ\u001f\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/CompletableUseCase;", "Params", "", "threadExecutor", "Lio/reactivex/Scheduler;", "postExecutionThread", "(Lio/reactivex/Scheduler;Lio/reactivex/Scheduler;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "addDisposable", "", "disposable", "Lio/reactivex/disposables/Disposable;", "buildUseCase", "Lio/reactivex/Completable;", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "(Ljava/lang/Object;)Lio/reactivex/Completable;", "clear", "execute", "completableObserver", "Lio/reactivex/observers/DisposableCompletableObserver;", "(Lio/reactivex/observers/DisposableCompletableObserver;Ljava/lang/Object;)V", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class CompletableUseCase<Params> {

    /* JADX INFO: renamed from: a */
    private final Scheduler f7453a;

    /* JADX INFO: renamed from: b */
    private final Scheduler f7454b;

    /* JADX INFO: renamed from: c */
    private final CompositeDisposable f7455c;

    /* JADX WARN: Multi-variable type inference failed */
    public CompletableUseCase() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public CompletableUseCase(Scheduler threadExecutor, Scheduler postExecutionThread) {
        Intrinsics.checkNotNullParameter(threadExecutor, "threadExecutor");
        Intrinsics.checkNotNullParameter(postExecutionThread, "postExecutionThread");
        this.f7453a = threadExecutor;
        this.f7454b = postExecutionThread;
        this.f7455c = new CompositeDisposable();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CompletableUseCase(Scheduler scheduler, Scheduler scheduler2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            scheduler = Schedulers.m5595io();
            Intrinsics.checkNotNullExpressionValue(scheduler, "io()");
        }
        if ((i & 2) != 0) {
            scheduler2 = AndroidSchedulers.mainThread();
            Intrinsics.checkNotNullExpressionValue(scheduler2, "mainThread()");
        }
        this(scheduler, scheduler2);
    }

    /* JADX INFO: renamed from: a */
    private final void m5078a(Disposable disposable) {
        this.f7455c.add(disposable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Completable buildUseCase$default(CompletableUseCase completableUseCase, Object obj, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildUseCase");
        }
        if ((i & 1) != 0) {
            obj = null;
        }
        return completableUseCase.buildUseCase(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void execute$default(CompletableUseCase completableUseCase, DisposableCompletableObserver disposableCompletableObserver, Object obj, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: execute");
        }
        if ((i & 2) != 0) {
            obj = null;
        }
        completableUseCase.execute(disposableCompletableObserver, obj);
    }

    protected abstract Completable buildUseCase(Params params);

    public final void clear() {
        this.f7455c.clear();
    }

    public final void execute(DisposableCompletableObserver completableObserver, Params params) {
        Intrinsics.checkNotNullParameter(completableObserver, "completableObserver");
        Completable completableObserveOn = buildUseCase(params).subscribeOn(this.f7453a).observeOn(this.f7454b);
        Intrinsics.checkNotNullExpressionValue(completableObserveOn, "buildUseCase(params)\n   …veOn(postExecutionThread)");
        CompletableObserver completableObserverSubscribeWith = completableObserveOn.subscribeWith(completableObserver);
        Intrinsics.checkNotNullExpressionValue(completableObserverSubscribeWith, "completable.subscribeWith(completableObserver)");
        m5078a((Disposable) completableObserverSubscribeWith);
    }
}
