package io.reactivex.rxkotlin;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: completable.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007\u001a\u0012\u0010\u0004\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\u0012\u0010\u0004\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a\u0010\u0010\u0007\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\t0\b\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\n\u001a\u0012\u0010\u0007\u001a\u00020\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\t0\u000b\u001a\u0012\u0010\u0007\u001a\u00020\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\t0\f¨\u0006\r"}, m5598d2 = {"concatAll", "Lio/reactivex/Completable;", "", "Lio/reactivex/CompletableSource;", "mergeAllCompletables", "Lio/reactivex/Flowable;", "Lio/reactivex/Observable;", "toCompletable", "Lkotlin/Function0;", "", "Lio/reactivex/functions/Action;", "Ljava/util/concurrent/Callable;", "Ljava/util/concurrent/Future;", "rxkotlin"}, m5599k = 2, m5600mv = {1, 1, 15})
public final class CompletableKt {
    public static final Completable toCompletable(Action toCompletable) {
        Intrinsics.checkParameterIsNotNull(toCompletable, "$this$toCompletable");
        Completable completableFromAction = Completable.fromAction(toCompletable);
        Intrinsics.checkExpressionValueIsNotNull(completableFromAction, "Completable.fromAction(this)");
        return completableFromAction;
    }

    public static final Completable toCompletable(Callable<? extends Object> toCompletable) {
        Intrinsics.checkParameterIsNotNull(toCompletable, "$this$toCompletable");
        Completable completableFromCallable = Completable.fromCallable(toCompletable);
        Intrinsics.checkExpressionValueIsNotNull(completableFromCallable, "Completable.fromCallable(this)");
        return completableFromCallable;
    }

    public static final Completable toCompletable(Future<? extends Object> toCompletable) {
        Intrinsics.checkParameterIsNotNull(toCompletable, "$this$toCompletable");
        Completable completableFromFuture = Completable.fromFuture(toCompletable);
        Intrinsics.checkExpressionValueIsNotNull(completableFromFuture, "Completable.fromFuture(this)");
        return completableFromFuture;
    }

    public static final Completable toCompletable(final Function0<? extends Object> toCompletable) {
        Intrinsics.checkParameterIsNotNull(toCompletable, "$this$toCompletable");
        Completable completableFromCallable = Completable.fromCallable(new Callable() { // from class: io.reactivex.rxkotlin.CompletableKt$sam$java_util_concurrent_Callable$0
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return toCompletable.invoke();
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(completableFromCallable, "Completable.fromCallable(this)");
        return completableFromCallable;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final Completable mergeAllCompletables(Observable<Completable> mergeAllCompletables) {
        Intrinsics.checkParameterIsNotNull(mergeAllCompletables, "$this$mergeAllCompletables");
        Completable completableFlatMapCompletable = mergeAllCompletables.flatMapCompletable(new Function<Completable, CompletableSource>() { // from class: io.reactivex.rxkotlin.CompletableKt.mergeAllCompletables.1
            @Override // io.reactivex.functions.Function
            public final Completable apply(Completable it2) {
                Intrinsics.checkParameterIsNotNull(it2, "it");
                return it2;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(completableFlatMapCompletable, "flatMapCompletable { it }");
        return completableFlatMapCompletable;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static final Completable mergeAllCompletables(Flowable<Completable> mergeAllCompletables) {
        Intrinsics.checkParameterIsNotNull(mergeAllCompletables, "$this$mergeAllCompletables");
        Completable completableFlatMapCompletable = mergeAllCompletables.flatMapCompletable(new Function<Completable, CompletableSource>() { // from class: io.reactivex.rxkotlin.CompletableKt.mergeAllCompletables.2
            @Override // io.reactivex.functions.Function
            public final Completable apply(Completable it2) {
                Intrinsics.checkParameterIsNotNull(it2, "it");
                return it2;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(completableFlatMapCompletable, "flatMapCompletable { it }");
        return completableFlatMapCompletable;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final Completable concatAll(Iterable<? extends CompletableSource> concatAll) {
        Intrinsics.checkParameterIsNotNull(concatAll, "$this$concatAll");
        Completable completableConcat = Completable.concat(concatAll);
        Intrinsics.checkExpressionValueIsNotNull(completableConcat, "Completable.concat(this)");
        return completableConcat;
    }
}
