package com.yoti.mobile.android.yotidocs.common;

import androidx.exifinterface.media.ExifInterface;
import io.branch.rnbranch.RNBranchModule;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00002\u00020\u0003B\u0019\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00018\u0001H$¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u000bJ%\u0010\u0013\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/SingleUseCase;", ExifInterface.GPS_DIRECTION_TRUE, "Params", "", "threadExecutor", "Lio/reactivex/Scheduler;", "postExecutionThread", "(Lio/reactivex/Scheduler;Lio/reactivex/Scheduler;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "addDisposable", "", "disposable", "Lio/reactivex/disposables/Disposable;", "buildUseCase", "Lio/reactivex/Single;", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "(Ljava/lang/Object;)Lio/reactivex/Single;", "clear", "execute", "singleObserver", "Lio/reactivex/observers/DisposableSingleObserver;", "(Lio/reactivex/observers/DisposableSingleObserver;Ljava/lang/Object;)V", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class SingleUseCase<T, Params> {

    /* JADX INFO: renamed from: a */
    private final Scheduler f7470a;

    /* JADX INFO: renamed from: b */
    private final Scheduler f7471b;

    /* JADX INFO: renamed from: c */
    private final CompositeDisposable f7472c;

    /* JADX WARN: Multi-variable type inference failed */
    public SingleUseCase() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public SingleUseCase(Scheduler threadExecutor, Scheduler postExecutionThread) {
        Intrinsics.checkNotNullParameter(threadExecutor, "threadExecutor");
        Intrinsics.checkNotNullParameter(postExecutionThread, "postExecutionThread");
        this.f7470a = threadExecutor;
        this.f7471b = postExecutionThread;
        this.f7472c = new CompositeDisposable();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SingleUseCase(Scheduler scheduler, Scheduler scheduler2, int i, DefaultConstructorMarker defaultConstructorMarker) {
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
    private final void m5081a(Disposable disposable) {
        this.f7472c.add(disposable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Single buildUseCase$default(SingleUseCase singleUseCase, Object obj, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildUseCase");
        }
        if ((i & 1) != 0) {
            obj = null;
        }
        return singleUseCase.buildUseCase(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void execute$default(SingleUseCase singleUseCase, DisposableSingleObserver disposableSingleObserver, Object obj, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: execute");
        }
        if ((i & 2) != 0) {
            obj = null;
        }
        singleUseCase.execute(disposableSingleObserver, obj);
    }

    protected abstract Single<T> buildUseCase(Params params);

    public final void clear() {
        this.f7472c.clear();
    }

    public final void execute(DisposableSingleObserver<T> singleObserver, Params params) {
        Intrinsics.checkNotNullParameter(singleObserver, "singleObserver");
        SingleObserver singleObserverSubscribeWith = buildUseCase(params).subscribeOn(this.f7470a).observeOn(this.f7471b).subscribeWith(singleObserver);
        Intrinsics.checkNotNullExpressionValue(singleObserverSubscribeWith, "single.subscribeWith(singleObserver)");
        m5081a((Disposable) singleObserverSubscribeWith);
    }
}
