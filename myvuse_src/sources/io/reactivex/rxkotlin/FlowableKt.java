package io.reactivex.rxkotlin;

import androidx.exifinterface.media.ExifInterface;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntProgression;
import kotlin.reflect.KDeclarationContainer;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jose4j.jwx.HeaderParameterNames;
import org.reactivestreams.Publisher;

/* JADX INFO: compiled from: flowable.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000ª\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0018\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\u0006\n\u0002\u0010\u0013\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\n\n\u0002\u0010\u0017\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0001H\u0087\b\u001aF\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00020\u00050\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001ad\u0010\u0004\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\b0\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003\"\b\b\u0002\u0010\t*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0001H\u0007\u001a^\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\f2)\b\u0004\u0010\r\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00060\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u0002H\u00020\u000eH\u0087\b\u001a(\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\u0001H\u0007\u001a(\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00140\fH\u0007\u001aI\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\u00012\u001a\b\u0004\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00170\u000eH\u0087\b\u001a*\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00060\u00010\fH\u0007\u001a(\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\u0001H\u0007\u001a*\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00060\u00010\fH\u0007\u001a#\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0001H\u0087\b\u001a(\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\u0001H\u0007\u001a(\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\u0001H\u0007\u001a'\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\u001fH\u0007¢\u0006\u0002\u0010 \u001a\u0012\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020!0\u0001*\u00020\"H\u0007\u001a\u0012\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020#0\u0001*\u00020$H\u0007\u001a\u0012\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020%0\u0001*\u00020&H\u0007\u001a\u0012\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020'0\u0001*\u00020(H\u0007\u001a\u0012\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020)0\u0001*\u00020*H\u0007\u001a\u0012\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020+0\u0001*\u00020,H\u0007\u001a\u0012\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020-0\u0001*\u00020.H\u0007\u001a\u0012\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020/0\u0001*\u000200H\u0007\u001a\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\fH\u0007\u001a \u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u000601\u001a\u0012\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020+0\u0001*\u000202H\u0007\u001a \u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\u0017\u001a\"\u00103\u001a\b\u0012\u0004\u0012\u0002H\u00060\f\"\b\b\u0000\u0010\u0006*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u000601H\u0002\u001aD\u00104\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u0002H80605\"\b\b\u0000\u00107*\u00020\u0003\"\b\b\u0001\u00108*\u00020\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u0002H80\u00050\u0001H\u0007\u001aJ\u00109\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H7\u0012\n\u0012\b\u0012\u0004\u0012\u0002H80:0605\"\b\b\u0000\u00107*\u00020\u0003\"\b\b\u0001\u00108*\u00020\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u0002H80\u00050\u0001H\u0007\u001a^\u0010;\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\f2)\b\u0004\u0010<\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00060\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u0002H\u00020\u000eH\u0087\b¨\u0006="}, m5598d2 = {"cast", "Lio/reactivex/Flowable;", "R", "", "combineLatest", "Lkotlin/Pair;", ExifInterface.GPS_DIRECTION_TRUE, "flowable", "Lkotlin/Triple;", "U", "flowable1", "flowable2", "", "combineFunction", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "args", "concatAll", "Lorg/reactivestreams/Publisher;", "flatMapSequence", "body", "Lkotlin/sequences/Sequence;", "merge", "mergeAll", "mergeDelayError", "ofType", "switchLatest", "switchOnNext", "toFlowable", "", "([Ljava/lang/Object;)Lio/reactivex/Flowable;", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "Lkotlin/ranges/IntProgression;", "toIterable", "toMap", "Lio/reactivex/Single;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "toMultimap", "", HeaderParameterNames.ZIP, "zipFunction", "rxkotlin"}, m5599k = 2, m5600mv = {1, 1, 15})
public final class FlowableKt {
    @CheckReturnValue
    public static final Flowable<Boolean> toFlowable(boolean[] toFlowable) {
        Intrinsics.checkParameterIsNotNull(toFlowable, "$this$toFlowable");
        return toFlowable(ArraysKt.asIterable(toFlowable));
    }

    @CheckReturnValue
    public static final Flowable<Byte> toFlowable(byte[] toFlowable) {
        Intrinsics.checkParameterIsNotNull(toFlowable, "$this$toFlowable");
        return toFlowable(ArraysKt.asIterable(toFlowable));
    }

    @CheckReturnValue
    public static final Flowable<Character> toFlowable(char[] toFlowable) {
        Intrinsics.checkParameterIsNotNull(toFlowable, "$this$toFlowable");
        return toFlowable(ArraysKt.asIterable(toFlowable));
    }

    @CheckReturnValue
    public static final Flowable<Short> toFlowable(short[] toFlowable) {
        Intrinsics.checkParameterIsNotNull(toFlowable, "$this$toFlowable");
        return toFlowable(ArraysKt.asIterable(toFlowable));
    }

    @CheckReturnValue
    public static final Flowable<Integer> toFlowable(int[] toFlowable) {
        Intrinsics.checkParameterIsNotNull(toFlowable, "$this$toFlowable");
        return toFlowable(ArraysKt.asIterable(toFlowable));
    }

    @CheckReturnValue
    public static final Flowable<Long> toFlowable(long[] toFlowable) {
        Intrinsics.checkParameterIsNotNull(toFlowable, "$this$toFlowable");
        return toFlowable(ArraysKt.asIterable(toFlowable));
    }

    @CheckReturnValue
    public static final Flowable<Float> toFlowable(float[] toFlowable) {
        Intrinsics.checkParameterIsNotNull(toFlowable, "$this$toFlowable");
        return toFlowable(ArraysKt.asIterable(toFlowable));
    }

    @CheckReturnValue
    public static final Flowable<Double> toFlowable(double[] toFlowable) {
        Intrinsics.checkParameterIsNotNull(toFlowable, "$this$toFlowable");
        return toFlowable(ArraysKt.asIterable(toFlowable));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T> Flowable<T> toFlowable(T[] toFlowable) {
        Intrinsics.checkParameterIsNotNull(toFlowable, "$this$toFlowable");
        Flowable<T> flowableFromArray = Flowable.fromArray(Arrays.copyOf(toFlowable, toFlowable.length));
        Intrinsics.checkExpressionValueIsNotNull(flowableFromArray, "Flowable.fromArray(*this)");
        return flowableFromArray;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final Flowable<Integer> toFlowable(IntProgression toFlowable) {
        Intrinsics.checkParameterIsNotNull(toFlowable, "$this$toFlowable");
        if (toFlowable.getStep() != 1 || ((long) toFlowable.getLast()) - ((long) toFlowable.getFirst()) >= Integer.MAX_VALUE) {
            Flowable<Integer> flowableFromIterable = Flowable.fromIterable(toFlowable);
            Intrinsics.checkExpressionValueIsNotNull(flowableFromIterable, "Flowable.fromIterable(this)");
            return flowableFromIterable;
        }
        Flowable<Integer> flowableRange = Flowable.range(toFlowable.getFirst(), Math.max(0, (toFlowable.getLast() - toFlowable.getFirst()) + 1));
        Intrinsics.checkExpressionValueIsNotNull(flowableRange, "Flowable.range(first, Ma…max(0, last - first + 1))");
        return flowableRange;
    }

    public static final <T> Flowable<T> toFlowable(Iterator<? extends T> toFlowable) {
        Intrinsics.checkParameterIsNotNull(toFlowable, "$this$toFlowable");
        return toFlowable(toIterable(toFlowable));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T> Flowable<T> toFlowable(Iterable<? extends T> toFlowable) {
        Intrinsics.checkParameterIsNotNull(toFlowable, "$this$toFlowable");
        Flowable<T> flowableFromIterable = Flowable.fromIterable(toFlowable);
        Intrinsics.checkExpressionValueIsNotNull(flowableFromIterable, "Flowable.fromIterable(this)");
        return flowableFromIterable;
    }

    public static final <T> Flowable<T> toFlowable(Sequence<? extends T> toFlowable) {
        Intrinsics.checkParameterIsNotNull(toFlowable, "$this$toFlowable");
        return toFlowable(SequencesKt.asIterable(toFlowable));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T> Flowable<T> merge(Iterable<? extends Flowable<? extends T>> merge) {
        Intrinsics.checkParameterIsNotNull(merge, "$this$merge");
        Flowable<T> flowableMerge = Flowable.merge(toFlowable(merge));
        Intrinsics.checkExpressionValueIsNotNull(flowableMerge, "Flowable.merge(this.toFlowable())");
        return flowableMerge;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T> Flowable<T> mergeDelayError(Iterable<? extends Flowable<? extends T>> mergeDelayError) {
        Intrinsics.checkParameterIsNotNull(mergeDelayError, "$this$mergeDelayError");
        Flowable<T> flowableMergeDelayError = Flowable.mergeDelayError(toFlowable(mergeDelayError));
        Intrinsics.checkExpressionValueIsNotNull(flowableMergeDelayError, "Flowable.mergeDelayError(this.toFlowable())");
        return flowableMergeDelayError;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T, R> Flowable<R> flatMapSequence(Flowable<T> flatMapSequence, final Function1<? super T, ? extends Sequence<? extends R>> body) {
        Intrinsics.checkParameterIsNotNull(flatMapSequence, "$this$flatMapSequence");
        Intrinsics.checkParameterIsNotNull(body, "body");
        Flowable<R> flowableFlatMap = flatMapSequence.flatMap(new Function<T, Publisher<? extends R>>() { // from class: io.reactivex.rxkotlin.FlowableKt.flatMapSequence.1
            @Override // io.reactivex.functions.Function
            public final Flowable<R> apply(T it2) {
                Intrinsics.checkParameterIsNotNull(it2, "it");
                return FlowableKt.toFlowable((Sequence) body.invoke(it2));
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flowableFlatMap, "flatMap { body(it).toFlowable() }");
        return flowableFlatMap;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T, R> Flowable<R> combineLatest(Iterable<? extends Flowable<T>> combineLatest, final Function1<? super List<? extends T>, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(combineLatest, "$this$combineLatest");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Flowable<R> flowableCombineLatest = Flowable.combineLatest(combineLatest, new Function<Object[], R>() { // from class: io.reactivex.rxkotlin.FlowableKt.combineLatest.1
            @Override // io.reactivex.functions.Function
            public final R apply(Object[] it2) {
                Intrinsics.checkParameterIsNotNull(it2, "it");
                Function1 function1 = combineFunction;
                List listAsList = ArraysKt.asList(it2);
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listAsList, 10));
                for (T t : listAsList) {
                    if (t == null) {
                        throw new TypeCastException("null cannot be cast to non-null type T");
                    }
                    arrayList.add(t);
                }
                return (R) function1.invoke(arrayList);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flowableCombineLatest, "Flowable.combineLatest(t…List().map { it as T }) }");
        return flowableCombineLatest;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T, R> Flowable<R> zip(Iterable<? extends Flowable<T>> zip, final Function1<? super List<? extends T>, ? extends R> zipFunction) {
        Intrinsics.checkParameterIsNotNull(zip, "$this$zip");
        Intrinsics.checkParameterIsNotNull(zipFunction, "zipFunction");
        Flowable<R> flowableZip = Flowable.zip(zip, new Function<Object[], R>() { // from class: io.reactivex.rxkotlin.FlowableKt.zip.1
            @Override // io.reactivex.functions.Function
            public final R apply(Object[] it2) {
                Intrinsics.checkParameterIsNotNull(it2, "it");
                Function1 function1 = zipFunction;
                List listAsList = ArraysKt.asList(it2);
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listAsList, 10));
                for (T t : listAsList) {
                    if (t == null) {
                        throw new TypeCastException("null cannot be cast to non-null type T");
                    }
                    arrayList.add(t);
                }
                return (R) function1.invoke(arrayList);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flowableZip, "Flowable.zip(this) { zip…List().map { it as T }) }");
        return flowableZip;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static final /* synthetic */ <R> Flowable<R> cast(Flowable<?> cast) {
        Intrinsics.checkParameterIsNotNull(cast, "$this$cast");
        Intrinsics.reifiedOperationMarker(4, "R");
        Flowable<R> flowable = (Flowable<R>) cast.cast(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(flowable, "cast(R::class.java)");
        return flowable;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static final /* synthetic */ <R> Flowable<R> ofType(Flowable<?> ofType) {
        Intrinsics.checkParameterIsNotNull(ofType, "$this$ofType");
        Intrinsics.reifiedOperationMarker(4, "R");
        Flowable<R> flowable = (Flowable<R>) ofType.ofType(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(flowable, "ofType(R::class.java)");
        return flowable;
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: io.reactivex.rxkotlin.FlowableKt$toIterable$1 */
    /* JADX INFO: compiled from: flowable.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004"}, m5598d2 = {"io/reactivex/rxkotlin/FlowableKt$toIterable$1", "", "iterator", "", "rxkotlin"}, m5599k = 1, m5600mv = {1, 1, 15})
    public static final class C53831<T> implements Iterable<T>, KMappedMarker {
        final /* synthetic */ Iterator $this_toIterable;

        C53831(Iterator<? extends T> it2) {
            this.$this_toIterable = it2;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.$this_toIterable;
        }
    }

    private static final <T> Iterable<T> toIterable(Iterator<? extends T> it2) {
        return new C53831(it2);
    }

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    /* JADX INFO: renamed from: io.reactivex.rxkotlin.FlowableKt$combineLatest$2 */
    /* JADX INFO: compiled from: flowable.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0015\u0010\u0005\u001a\u0011H\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b2\u0015\u0010\t\u001a\u0011H\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n¢\u0006\u0004\b\u000b\u0010\f"}, m5598d2 = {"<anonymous>", "Lkotlin/Pair;", ExifInterface.GPS_DIRECTION_TRUE, "R", "", "p1", "Lkotlin/ParameterName;", "name", "first", "p2", "second", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;"}, m5599k = 3, m5600mv = {1, 1, 15})
    static final /* synthetic */ class C53772<R, T> extends FunctionReference implements Function2<T, R, Pair<? extends T, ? extends R>> {
        public static final C53772 INSTANCE = new C53772();

        C53772() {
            super(2);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "<init>";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(Pair.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "<init>(Ljava/lang/Object;Ljava/lang/Object;)V";
        }

        @Override // kotlin.jvm.functions.Function2
        public final Pair<T, R> invoke(T p1, R p2) {
            Intrinsics.checkParameterIsNotNull(p1, "p1");
            Intrinsics.checkParameterIsNotNull(p2, "p2");
            return new Pair<>(p1, p2);
        }
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T, R> Flowable<Pair<T, R>> combineLatest(Flowable<T> combineLatest, Flowable<R> flowable) {
        Intrinsics.checkParameterIsNotNull(combineLatest, "$this$combineLatest");
        Intrinsics.checkParameterIsNotNull(flowable, "flowable");
        Flowable<T> flowable2 = combineLatest;
        Flowable<R> flowable3 = flowable;
        final C53772 c53772 = C53772.INSTANCE;
        Object obj = c53772;
        if (c53772 != null) {
            obj = new BiFunction() { // from class: io.reactivex.rxkotlin.FlowableKt$sam$io_reactivex_functions_BiFunction$0
                @Override // io.reactivex.functions.BiFunction
                public final /* synthetic */ Object apply(Object obj2, Object obj3) {
                    return c53772.invoke(obj2, obj3);
                }
            };
        }
        Flowable<Pair<T, R>> flowableCombineLatest = Flowable.combineLatest(flowable2, flowable3, (BiFunction) obj);
        Intrinsics.checkExpressionValueIsNotNull(flowableCombineLatest, "Flowable.combineLatest(t…able, BiFunction(::Pair))");
        return flowableCombineLatest;
    }

    /* JADX INFO: Add missing generic type declarations: [R, T, U] */
    /* JADX INFO: renamed from: io.reactivex.rxkotlin.FlowableKt$combineLatest$3 */
    /* JADX INFO: compiled from: flowable.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0005\"\b\b\u0001\u0010\u0003*\u00020\u0005\"\b\b\u0002\u0010\u0004*\u00020\u00052\u0015\u0010\u0006\u001a\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t2\u0015\u0010\n\u001a\u0011H\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b2\u0015\u0010\f\u001a\u0011H\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r¢\u0006\u0004\b\u000e\u0010\u000f"}, m5598d2 = {"<anonymous>", "Lkotlin/Triple;", ExifInterface.GPS_DIRECTION_TRUE, "R", "U", "", "p1", "Lkotlin/ParameterName;", "name", "first", "p2", "second", "p3", "third", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Triple;"}, m5599k = 3, m5600mv = {1, 1, 15})
    static final /* synthetic */ class C53783<R, T, U> extends FunctionReference implements Function3<T, R, U, Triple<? extends T, ? extends R, ? extends U>> {
        public static final C53783 INSTANCE = new C53783();

        C53783() {
            super(3);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "<init>";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(Triple.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "<init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V";
        }

        @Override // kotlin.jvm.functions.Function3
        public final Triple<T, R, U> invoke(T p1, R p2, U p3) {
            Intrinsics.checkParameterIsNotNull(p1, "p1");
            Intrinsics.checkParameterIsNotNull(p2, "p2");
            Intrinsics.checkParameterIsNotNull(p3, "p3");
            return new Triple<>(p1, p2, p3);
        }
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T, R, U> Flowable<Triple<T, R, U>> combineLatest(Flowable<T> combineLatest, Flowable<R> flowable1, Flowable<U> flowable2) {
        Intrinsics.checkParameterIsNotNull(combineLatest, "$this$combineLatest");
        Intrinsics.checkParameterIsNotNull(flowable1, "flowable1");
        Intrinsics.checkParameterIsNotNull(flowable2, "flowable2");
        Flowable<T> flowable = combineLatest;
        Flowable<R> flowable3 = flowable1;
        Flowable<U> flowable4 = flowable2;
        final C53783 c53783 = C53783.INSTANCE;
        Object obj = c53783;
        if (c53783 != null) {
            obj = new io.reactivex.functions.Function3() { // from class: io.reactivex.rxkotlin.FlowableKt$sam$io_reactivex_functions_Function3$0
                @Override // io.reactivex.functions.Function3
                public final /* synthetic */ Object apply(Object obj2, Object obj3, Object obj4) {
                    return c53783.invoke(obj2, obj3, obj4);
                }
            };
        }
        Flowable<Triple<T, R, U>> flowableCombineLatest = Flowable.combineLatest(flowable, flowable3, flowable4, (io.reactivex.functions.Function3) obj);
        Intrinsics.checkExpressionValueIsNotNull(flowableCombineLatest, "Flowable.combineLatest(t…le2, Function3(::Triple))");
        return flowableCombineLatest;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T> Flowable<T> mergeAll(Flowable<Flowable<T>> mergeAll) {
        Intrinsics.checkParameterIsNotNull(mergeAll, "$this$mergeAll");
        Flowable<T> flowable = (Flowable<T>) mergeAll.flatMap(new Function<T, Publisher<? extends R>>() { // from class: io.reactivex.rxkotlin.FlowableKt.mergeAll.1
            @Override // io.reactivex.functions.Function
            public final Flowable<T> apply(Flowable<T> it2) {
                Intrinsics.checkParameterIsNotNull(it2, "it");
                return it2;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flowable, "flatMap { it }");
        return flowable;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T> Flowable<T> concatAll(Flowable<Flowable<T>> concatAll) {
        Intrinsics.checkParameterIsNotNull(concatAll, "$this$concatAll");
        Flowable<T> flowable = (Flowable<T>) concatAll.concatMap(new Function<T, Publisher<? extends R>>() { // from class: io.reactivex.rxkotlin.FlowableKt.concatAll.1
            @Override // io.reactivex.functions.Function
            public final Flowable<T> apply(Flowable<T> it2) {
                Intrinsics.checkParameterIsNotNull(it2, "it");
                return it2;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flowable, "concatMap { it }");
        return flowable;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T> Flowable<T> switchLatest(Flowable<Flowable<T>> switchLatest) {
        Intrinsics.checkParameterIsNotNull(switchLatest, "$this$switchLatest");
        Flowable<T> flowable = (Flowable<T>) switchLatest.switchMap(new Function<T, Publisher<? extends R>>() { // from class: io.reactivex.rxkotlin.FlowableKt.switchLatest.1
            @Override // io.reactivex.functions.Function
            public final Flowable<T> apply(Flowable<T> it2) {
                Intrinsics.checkParameterIsNotNull(it2, "it");
                return it2;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flowable, "switchMap { it }");
        return flowable;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T> Flowable<T> switchOnNext(Flowable<Flowable<T>> switchOnNext) {
        Intrinsics.checkParameterIsNotNull(switchOnNext, "$this$switchOnNext");
        Flowable<T> flowableSwitchOnNext = Flowable.switchOnNext(switchOnNext);
        Intrinsics.checkExpressionValueIsNotNull(flowableSwitchOnNext, "Flowable.switchOnNext(this)");
        return flowableSwitchOnNext;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static final <A, B> Single<Map<A, B>> toMap(Flowable<Pair<A, B>> toMap) {
        Intrinsics.checkParameterIsNotNull(toMap, "$this$toMap");
        Single<Map<A, B>> single = (Single<Map<A, B>>) toMap.toMap(new Function<T, K>() { // from class: io.reactivex.rxkotlin.FlowableKt.toMap.1
            /* JADX WARN: Type inference failed for: r2v1, types: [A, java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public final A apply(Pair<? extends A, ? extends B> it2) {
                Intrinsics.checkParameterIsNotNull(it2, "it");
                return it2.getFirst();
            }
        }, new Function<T, V>() { // from class: io.reactivex.rxkotlin.FlowableKt.toMap.2
            /* JADX WARN: Type inference failed for: r2v1, types: [B, java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public final B apply(Pair<? extends A, ? extends B> it2) {
                Intrinsics.checkParameterIsNotNull(it2, "it");
                return it2.getSecond();
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(single, "toMap({ it.first }, { it.second })");
        return single;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static final <A, B> Single<Map<A, Collection<B>>> toMultimap(Flowable<Pair<A, B>> toMultimap) {
        Intrinsics.checkParameterIsNotNull(toMultimap, "$this$toMultimap");
        Single<Map<A, Collection<B>>> single = (Single<Map<A, Collection<B>>>) toMultimap.toMultimap(new Function<T, K>() { // from class: io.reactivex.rxkotlin.FlowableKt.toMultimap.1
            /* JADX WARN: Type inference failed for: r2v1, types: [A, java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public final A apply(Pair<? extends A, ? extends B> it2) {
                Intrinsics.checkParameterIsNotNull(it2, "it");
                return it2.getFirst();
            }
        }, new Function<T, V>() { // from class: io.reactivex.rxkotlin.FlowableKt.toMultimap.2
            /* JADX WARN: Type inference failed for: r2v1, types: [B, java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public final B apply(Pair<? extends A, ? extends B> it2) {
                Intrinsics.checkParameterIsNotNull(it2, "it");
                return it2.getSecond();
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(single, "toMultimap({ it.first }, { it.second })");
        return single;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T> Flowable<T> concatAll(Iterable<? extends Publisher<T>> concatAll) {
        Intrinsics.checkParameterIsNotNull(concatAll, "$this$concatAll");
        Flowable<T> flowableConcat = Flowable.concat(concatAll);
        Intrinsics.checkExpressionValueIsNotNull(flowableConcat, "Flowable.concat(this)");
        return flowableConcat;
    }
}
