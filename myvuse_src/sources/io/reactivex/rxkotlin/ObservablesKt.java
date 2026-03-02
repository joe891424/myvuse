package io.reactivex.rxkotlin;

import androidx.exifinterface.media.ExifInterface;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Observables.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ad\u0010\u0000\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0006\"\b\b\u0001\u0010\u0004*\u00020\u0006\"\b\b\u0002\u0010\u0005*\u00020\u0006*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\bH\u0007\u001a\u007f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0006\"\b\b\u0001\u0010\u0004*\u00020\u0006\"\b\b\u0002\u0010\u0005*\u00020\u0006\"\b\b\u0003\u0010\n*\u00020\u0006*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\b2 \b\u0004\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\n0\fH\u0087\b\u001a\u009d\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0006\"\b\b\u0001\u0010\u0004*\u00020\u0006\"\b\b\u0002\u0010\u0005*\u00020\u0006\"\b\b\u0003\u0010\r*\u00020\u0006\"\b\b\u0004\u0010\n*\u00020\u0006*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\b2&\b\u0004\u0010\u000b\u001a \u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\n0\u000fH\u0087\b\u001a»\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0006\"\b\b\u0001\u0010\u0004*\u00020\u0006\"\b\b\u0002\u0010\u0005*\u00020\u0006\"\b\b\u0003\u0010\r*\u00020\u0006\"\b\b\u0004\u0010\u0010*\u00020\u0006\"\b\b\u0005\u0010\n*\u00020\u0006*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\b2,\b\u0004\u0010\u000b\u001a&\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\n0\u0012H\u0087\b\u001aF\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00140\u00130\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0006\"\b\b\u0001\u0010\u0014*\u00020\u0006*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\bH\u0007\u001aa\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0006\"\b\b\u0001\u0010\u0014*\u00020\u0006\"\b\b\u0002\u0010\n*\u00020\u0006*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\b2\u001a\b\u0004\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\n0\u0016H\u0087\b\u001aF\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00140\u00130\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0006\"\b\b\u0001\u0010\u0014*\u00020\u0006*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\bH\u0007\u001aa\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0006\"\b\b\u0001\u0010\u0014*\u00020\u0006\"\b\b\u0002\u0010\n*\u00020\u0006*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\b2\u001a\b\u0004\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\n0\u0016H\u0087\b¨\u0006\u0019"}, m5598d2 = {"withLatestFrom", "Lio/reactivex/Observable;", "Lkotlin/Triple;", ExifInterface.GPS_DIRECTION_TRUE, "T1", "T2", "", "o1", "Lio/reactivex/ObservableSource;", "o2", "R", "combiner", "Lkotlin/Function3;", "T3", "o3", "Lkotlin/Function4;", "T4", "o4", "Lkotlin/Function5;", "Lkotlin/Pair;", "U", "other", "Lkotlin/Function2;", "zipWith", "zipper", "rxkotlin"}, m5599k = 2, m5600mv = {1, 1, 15})
public final class ObservablesKt {
    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T, U, R> Observable<R> withLatestFrom(Observable<T> withLatestFrom, ObservableSource<U> other, final Function2<? super T, ? super U, ? extends R> combiner) {
        Intrinsics.checkParameterIsNotNull(withLatestFrom, "$this$withLatestFrom");
        Intrinsics.checkParameterIsNotNull(other, "other");
        Intrinsics.checkParameterIsNotNull(combiner, "combiner");
        Observable<R> observableWithLatestFrom = withLatestFrom.withLatestFrom(other, new BiFunction<T, U, R>() { // from class: io.reactivex.rxkotlin.ObservablesKt.withLatestFrom.1
            @Override // io.reactivex.functions.BiFunction
            public final R apply(T t, U u) {
                Intrinsics.checkParameterIsNotNull(t, "t");
                Intrinsics.checkParameterIsNotNull(u, "u");
                return (R) combiner.invoke(t, u);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observableWithLatestFrom, "withLatestFrom(other, Bi… combiner.invoke(t, u) })");
        return observableWithLatestFrom;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T, U> Observable<Pair<T, U>> withLatestFrom(Observable<T> withLatestFrom, ObservableSource<U> other) {
        Intrinsics.checkParameterIsNotNull(withLatestFrom, "$this$withLatestFrom");
        Intrinsics.checkParameterIsNotNull(other, "other");
        Observable<Pair<T, U>> observable = (Observable<Pair<T, U>>) withLatestFrom.withLatestFrom(other, new BiFunction<T, U, Pair<? extends T, ? extends U>>() { // from class: io.reactivex.rxkotlin.ObservablesKt.withLatestFrom.2
            @Override // io.reactivex.functions.BiFunction
            public final Pair<T, U> apply(T t, U u) {
                Intrinsics.checkParameterIsNotNull(t, "t");
                Intrinsics.checkParameterIsNotNull(u, "u");
                return new Pair<>(t, u);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observable, "withLatestFrom(other, Bi…n { t, u -> Pair(t, u) })");
        return observable;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T, T1, T2, R> Observable<R> withLatestFrom(Observable<T> withLatestFrom, ObservableSource<T1> o1, ObservableSource<T2> o2, final Function3<? super T, ? super T1, ? super T2, ? extends R> combiner) {
        Intrinsics.checkParameterIsNotNull(withLatestFrom, "$this$withLatestFrom");
        Intrinsics.checkParameterIsNotNull(o1, "o1");
        Intrinsics.checkParameterIsNotNull(o2, "o2");
        Intrinsics.checkParameterIsNotNull(combiner, "combiner");
        Observable<R> observableWithLatestFrom = withLatestFrom.withLatestFrom(o1, o2, new io.reactivex.functions.Function3<T, T1, T2, R>() { // from class: io.reactivex.rxkotlin.ObservablesKt.withLatestFrom.3
            @Override // io.reactivex.functions.Function3
            public final R apply(T t, T1 t1, T2 t2) {
                Intrinsics.checkParameterIsNotNull(t, "t");
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                return (R) combiner.invoke(t, t1, t2);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observableWithLatestFrom, "withLatestFrom(o1, o2, F…iner.invoke(t, t1, t2) })");
        return observableWithLatestFrom;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T, T1, T2> Observable<Triple<T, T1, T2>> withLatestFrom(Observable<T> withLatestFrom, ObservableSource<T1> o1, ObservableSource<T2> o2) {
        Intrinsics.checkParameterIsNotNull(withLatestFrom, "$this$withLatestFrom");
        Intrinsics.checkParameterIsNotNull(o1, "o1");
        Intrinsics.checkParameterIsNotNull(o2, "o2");
        Observable<Triple<T, T1, T2>> observable = (Observable<Triple<T, T1, T2>>) withLatestFrom.withLatestFrom(o1, o2, new io.reactivex.functions.Function3<T, T1, T2, Triple<? extends T, ? extends T1, ? extends T2>>() { // from class: io.reactivex.rxkotlin.ObservablesKt.withLatestFrom.4
            @Override // io.reactivex.functions.Function3
            public final Triple<T, T1, T2> apply(T t, T1 t1, T2 t2) {
                Intrinsics.checkParameterIsNotNull(t, "t");
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                return new Triple<>(t, t1, t2);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observable, "withLatestFrom(o1, o2, F…2 -> Triple(t, t1, t2) })");
        return observable;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T, T1, T2, T3, R> Observable<R> withLatestFrom(Observable<T> withLatestFrom, ObservableSource<T1> o1, ObservableSource<T2> o2, ObservableSource<T3> o3, final Function4<? super T, ? super T1, ? super T2, ? super T3, ? extends R> combiner) {
        Intrinsics.checkParameterIsNotNull(withLatestFrom, "$this$withLatestFrom");
        Intrinsics.checkParameterIsNotNull(o1, "o1");
        Intrinsics.checkParameterIsNotNull(o2, "o2");
        Intrinsics.checkParameterIsNotNull(o3, "o3");
        Intrinsics.checkParameterIsNotNull(combiner, "combiner");
        Observable<R> observableWithLatestFrom = withLatestFrom.withLatestFrom(o1, o2, o3, new io.reactivex.functions.Function4<T, T1, T2, T3, R>() { // from class: io.reactivex.rxkotlin.ObservablesKt.withLatestFrom.5
            @Override // io.reactivex.functions.Function4
            public final R apply(T t, T1 t1, T2 t2, T3 t3) {
                Intrinsics.checkParameterIsNotNull(t, "t");
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                return (R) combiner.invoke(t, t1, t2, t3);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observableWithLatestFrom, "withLatestFrom(o1, o2, o….invoke(t, t1, t2, t3) })");
        return observableWithLatestFrom;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T, T1, T2, T3, T4, R> Observable<R> withLatestFrom(Observable<T> withLatestFrom, ObservableSource<T1> o1, ObservableSource<T2> o2, ObservableSource<T3> o3, ObservableSource<T4> o4, final Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? extends R> combiner) {
        Intrinsics.checkParameterIsNotNull(withLatestFrom, "$this$withLatestFrom");
        Intrinsics.checkParameterIsNotNull(o1, "o1");
        Intrinsics.checkParameterIsNotNull(o2, "o2");
        Intrinsics.checkParameterIsNotNull(o3, "o3");
        Intrinsics.checkParameterIsNotNull(o4, "o4");
        Intrinsics.checkParameterIsNotNull(combiner, "combiner");
        Observable<R> observableWithLatestFrom = withLatestFrom.withLatestFrom(o1, o2, o3, o4, new io.reactivex.functions.Function5<T, T1, T2, T3, T4, R>() { // from class: io.reactivex.rxkotlin.ObservablesKt.withLatestFrom.6
            @Override // io.reactivex.functions.Function5
            public final R apply(T t, T1 t1, T2 t2, T3 t3, T4 t4) {
                Intrinsics.checkParameterIsNotNull(t, "t");
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                Intrinsics.checkParameterIsNotNull(t4, "t4");
                return (R) combiner.invoke(t, t1, t2, t3, t4);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observableWithLatestFrom, "withLatestFrom(o1, o2, o…oke(t, t1, t2, t3, t4) })");
        return observableWithLatestFrom;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T, U, R> Observable<R> zipWith(Observable<T> zipWith, ObservableSource<U> other, final Function2<? super T, ? super U, ? extends R> zipper) {
        Intrinsics.checkParameterIsNotNull(zipWith, "$this$zipWith");
        Intrinsics.checkParameterIsNotNull(other, "other");
        Intrinsics.checkParameterIsNotNull(zipper, "zipper");
        Observable<R> observableZipWith = zipWith.zipWith(other, new BiFunction<T, U, R>() { // from class: io.reactivex.rxkotlin.ObservablesKt.zipWith.1
            @Override // io.reactivex.functions.BiFunction
            public final R apply(T t, U u) {
                Intrinsics.checkParameterIsNotNull(t, "t");
                Intrinsics.checkParameterIsNotNull(u, "u");
                return (R) zipper.invoke(t, u);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observableZipWith, "zipWith(other, BiFunctio…-> zipper.invoke(t, u) })");
        return observableZipWith;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T, U> Observable<Pair<T, U>> zipWith(Observable<T> zipWith, ObservableSource<U> other) {
        Intrinsics.checkParameterIsNotNull(zipWith, "$this$zipWith");
        Intrinsics.checkParameterIsNotNull(other, "other");
        Observable<Pair<T, U>> observable = (Observable<Pair<T, U>>) zipWith.zipWith(other, new BiFunction<T, U, Pair<? extends T, ? extends U>>() { // from class: io.reactivex.rxkotlin.ObservablesKt.zipWith.2
            @Override // io.reactivex.functions.BiFunction
            public final Pair<T, U> apply(T t, U u) {
                Intrinsics.checkParameterIsNotNull(t, "t");
                Intrinsics.checkParameterIsNotNull(u, "u");
                return new Pair<>(t, u);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observable, "zipWith(other, BiFunction { t, u -> Pair(t, u) })");
        return observable;
    }
}
