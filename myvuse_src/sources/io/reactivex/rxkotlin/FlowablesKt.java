package io.reactivex.rxkotlin;

import androidx.exifinterface.media.ExifInterface;
import io.reactivex.Flowable;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
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
import org.reactivestreams.Publisher;

/* JADX INFO: compiled from: Flowables.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ad\u0010\u0000\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0006\"\b\b\u0001\u0010\u0004*\u00020\u0006\"\b\b\u0002\u0010\u0005*\u00020\u0006*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\bH\u0007\u001a\u007f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0006\"\b\b\u0001\u0010\u0004*\u00020\u0006\"\b\b\u0002\u0010\u0005*\u00020\u0006\"\b\b\u0003\u0010\n*\u00020\u0006*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\b2 \b\u0004\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\n0\fH\u0087\b\u001a\u009d\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0006\"\b\b\u0001\u0010\u0004*\u00020\u0006\"\b\b\u0002\u0010\u0005*\u00020\u0006\"\b\b\u0003\u0010\r*\u00020\u0006\"\b\b\u0004\u0010\n*\u00020\u0006*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\b2&\b\u0004\u0010\u000b\u001a \u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\n0\u000fH\u0087\b\u001a»\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0006\"\b\b\u0001\u0010\u0004*\u00020\u0006\"\b\b\u0002\u0010\u0005*\u00020\u0006\"\b\b\u0003\u0010\r*\u00020\u0006\"\b\b\u0004\u0010\u0010*\u00020\u0006\"\b\b\u0005\u0010\n*\u00020\u0006*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\b2,\b\u0004\u0010\u000b\u001a&\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\n0\u0012H\u0087\b\u001aF\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00140\u00130\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0006\"\b\b\u0001\u0010\u0014*\u00020\u0006*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\bH\u0007\u001aa\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0006\"\b\b\u0001\u0010\u0014*\u00020\u0006\"\b\b\u0002\u0010\n*\u00020\u0006*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\b2\u001a\b\u0004\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\n0\u0016H\u0087\b\u001aF\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00140\u00130\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0006\"\b\b\u0001\u0010\u0014*\u00020\u0006*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\bH\u0007\u001aa\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0006\"\b\b\u0001\u0010\u0014*\u00020\u0006\"\b\b\u0002\u0010\n*\u00020\u0006*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\b2\u001a\b\u0004\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\n0\u0016H\u0087\b¨\u0006\u0019"}, m5598d2 = {"withLatestFrom", "Lio/reactivex/Flowable;", "Lkotlin/Triple;", ExifInterface.GPS_DIRECTION_TRUE, "T1", "T2", "", "o1", "Lorg/reactivestreams/Publisher;", "o2", "R", "combiner", "Lkotlin/Function3;", "T3", "o3", "Lkotlin/Function4;", "T4", "o4", "Lkotlin/Function5;", "Lkotlin/Pair;", "U", "other", "Lkotlin/Function2;", "zipWith", "zipper", "rxkotlin"}, m5599k = 2, m5600mv = {1, 1, 15})
public final class FlowablesKt {
    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static final <T, U, R> Flowable<R> withLatestFrom(Flowable<T> withLatestFrom, Publisher<U> other, final Function2<? super T, ? super U, ? extends R> combiner) {
        Intrinsics.checkParameterIsNotNull(withLatestFrom, "$this$withLatestFrom");
        Intrinsics.checkParameterIsNotNull(other, "other");
        Intrinsics.checkParameterIsNotNull(combiner, "combiner");
        Flowable<R> flowableWithLatestFrom = withLatestFrom.withLatestFrom(other, new BiFunction<T, U, R>() { // from class: io.reactivex.rxkotlin.FlowablesKt.withLatestFrom.1
            @Override // io.reactivex.functions.BiFunction
            public final R apply(T t, U u) {
                Intrinsics.checkParameterIsNotNull(t, "t");
                Intrinsics.checkParameterIsNotNull(u, "u");
                return (R) combiner.invoke(t, u);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flowableWithLatestFrom, "withLatestFrom(other, Bi… combiner.invoke(t, u) })");
        return flowableWithLatestFrom;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static final <T, U> Flowable<Pair<T, U>> withLatestFrom(Flowable<T> withLatestFrom, Publisher<U> other) {
        Intrinsics.checkParameterIsNotNull(withLatestFrom, "$this$withLatestFrom");
        Intrinsics.checkParameterIsNotNull(other, "other");
        Flowable<Pair<T, U>> flowable = (Flowable<Pair<T, U>>) withLatestFrom.withLatestFrom(other, new BiFunction<T, U, Pair<? extends T, ? extends U>>() { // from class: io.reactivex.rxkotlin.FlowablesKt.withLatestFrom.2
            @Override // io.reactivex.functions.BiFunction
            public final Pair<T, U> apply(T t, U u) {
                Intrinsics.checkParameterIsNotNull(t, "t");
                Intrinsics.checkParameterIsNotNull(u, "u");
                return new Pair<>(t, u);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flowable, "withLatestFrom(other, Bi…n { t, u -> Pair(t, u) })");
        return flowable;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static final <T, T1, T2, R> Flowable<R> withLatestFrom(Flowable<T> withLatestFrom, Publisher<T1> o1, Publisher<T2> o2, final Function3<? super T, ? super T1, ? super T2, ? extends R> combiner) {
        Intrinsics.checkParameterIsNotNull(withLatestFrom, "$this$withLatestFrom");
        Intrinsics.checkParameterIsNotNull(o1, "o1");
        Intrinsics.checkParameterIsNotNull(o2, "o2");
        Intrinsics.checkParameterIsNotNull(combiner, "combiner");
        Flowable<R> flowableWithLatestFrom = withLatestFrom.withLatestFrom(o1, o2, new io.reactivex.functions.Function3<T, T1, T2, R>() { // from class: io.reactivex.rxkotlin.FlowablesKt.withLatestFrom.3
            @Override // io.reactivex.functions.Function3
            public final R apply(T t, T1 t1, T2 t2) {
                Intrinsics.checkParameterIsNotNull(t, "t");
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                return (R) combiner.invoke(t, t1, t2);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flowableWithLatestFrom, "withLatestFrom(o1, o2, F…iner.invoke(t, t1, t2) })");
        return flowableWithLatestFrom;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static final <T, T1, T2> Flowable<Triple<T, T1, T2>> withLatestFrom(Flowable<T> withLatestFrom, Publisher<T1> o1, Publisher<T2> o2) {
        Intrinsics.checkParameterIsNotNull(withLatestFrom, "$this$withLatestFrom");
        Intrinsics.checkParameterIsNotNull(o1, "o1");
        Intrinsics.checkParameterIsNotNull(o2, "o2");
        Flowable<Triple<T, T1, T2>> flowable = (Flowable<Triple<T, T1, T2>>) withLatestFrom.withLatestFrom(o1, o2, new io.reactivex.functions.Function3<T, T1, T2, Triple<? extends T, ? extends T1, ? extends T2>>() { // from class: io.reactivex.rxkotlin.FlowablesKt.withLatestFrom.4
            @Override // io.reactivex.functions.Function3
            public final Triple<T, T1, T2> apply(T t, T1 t1, T2 t2) {
                Intrinsics.checkParameterIsNotNull(t, "t");
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                return new Triple<>(t, t1, t2);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flowable, "withLatestFrom(o1, o2, F…2 -> Triple(t, t1, t2) })");
        return flowable;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static final <T, T1, T2, T3, R> Flowable<R> withLatestFrom(Flowable<T> withLatestFrom, Publisher<T1> o1, Publisher<T2> o2, Publisher<T3> o3, final Function4<? super T, ? super T1, ? super T2, ? super T3, ? extends R> combiner) {
        Intrinsics.checkParameterIsNotNull(withLatestFrom, "$this$withLatestFrom");
        Intrinsics.checkParameterIsNotNull(o1, "o1");
        Intrinsics.checkParameterIsNotNull(o2, "o2");
        Intrinsics.checkParameterIsNotNull(o3, "o3");
        Intrinsics.checkParameterIsNotNull(combiner, "combiner");
        Flowable<R> flowableWithLatestFrom = withLatestFrom.withLatestFrom(o1, o2, o3, new io.reactivex.functions.Function4<T, T1, T2, T3, R>() { // from class: io.reactivex.rxkotlin.FlowablesKt.withLatestFrom.5
            @Override // io.reactivex.functions.Function4
            public final R apply(T t, T1 t1, T2 t2, T3 t3) {
                Intrinsics.checkParameterIsNotNull(t, "t");
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                return (R) combiner.invoke(t, t1, t2, t3);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flowableWithLatestFrom, "withLatestFrom(o1, o2, o….invoke(t, t1, t2, t3) })");
        return flowableWithLatestFrom;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T, T1, T2, T3, T4, R> Flowable<R> withLatestFrom(Flowable<T> withLatestFrom, Publisher<T1> o1, Publisher<T2> o2, Publisher<T3> o3, Publisher<T4> o4, final Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? extends R> combiner) {
        Intrinsics.checkParameterIsNotNull(withLatestFrom, "$this$withLatestFrom");
        Intrinsics.checkParameterIsNotNull(o1, "o1");
        Intrinsics.checkParameterIsNotNull(o2, "o2");
        Intrinsics.checkParameterIsNotNull(o3, "o3");
        Intrinsics.checkParameterIsNotNull(o4, "o4");
        Intrinsics.checkParameterIsNotNull(combiner, "combiner");
        Flowable<R> flowableWithLatestFrom = withLatestFrom.withLatestFrom(o1, o2, o3, o4, new io.reactivex.functions.Function5<T, T1, T2, T3, T4, R>() { // from class: io.reactivex.rxkotlin.FlowablesKt.withLatestFrom.6
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
        Intrinsics.checkExpressionValueIsNotNull(flowableWithLatestFrom, "withLatestFrom(o1, o2, o…oke(t, t1, t2, t3, t4) })");
        return flowableWithLatestFrom;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static final <T, U, R> Flowable<R> zipWith(Flowable<T> zipWith, Publisher<U> other, final Function2<? super T, ? super U, ? extends R> zipper) {
        Intrinsics.checkParameterIsNotNull(zipWith, "$this$zipWith");
        Intrinsics.checkParameterIsNotNull(other, "other");
        Intrinsics.checkParameterIsNotNull(zipper, "zipper");
        Flowable<R> flowableZipWith = zipWith.zipWith(other, new BiFunction<T, U, R>() { // from class: io.reactivex.rxkotlin.FlowablesKt.zipWith.1
            @Override // io.reactivex.functions.BiFunction
            public final R apply(T t, U u) {
                Intrinsics.checkParameterIsNotNull(t, "t");
                Intrinsics.checkParameterIsNotNull(u, "u");
                return (R) zipper.invoke(t, u);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flowableZipWith, "zipWith(other, BiFunctio…-> zipper.invoke(t, u) })");
        return flowableZipWith;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T, U> Flowable<Pair<T, U>> zipWith(Flowable<T> zipWith, Publisher<U> other) {
        Intrinsics.checkParameterIsNotNull(zipWith, "$this$zipWith");
        Intrinsics.checkParameterIsNotNull(other, "other");
        Flowable<Pair<T, U>> flowable = (Flowable<Pair<T, U>>) zipWith.zipWith(other, new BiFunction<T, U, Pair<? extends T, ? extends U>>() { // from class: io.reactivex.rxkotlin.FlowablesKt.zipWith.2
            @Override // io.reactivex.functions.BiFunction
            public final Pair<T, U> apply(T t, U u) {
                Intrinsics.checkParameterIsNotNull(t, "t");
                Intrinsics.checkParameterIsNotNull(u, "u");
                return new Pair<>(t, u);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flowable, "zipWith(other, BiFunction { t, u -> Pair(t, u) })");
        return flowable;
    }
}
