package io.reactivex.rxkotlin;

import androidx.exifinterface.media.ExifInterface;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntProgression;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: compiled from: observable.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0018\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\u0006\n\u0002\u0010\u0013\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\n\n\u0002\u0010\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0001H\u0087\b\u001a^\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00010\u00062)\b\u0004\u0010\u0007\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00020\bH\u0087\b\u001a(\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00010\u0001H\u0007\u001a(\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000e0\u0006H\u0007\u001a*\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003*\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00060\u0001H\u0007\u001a*\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003*\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00060\u0001H\u0007\u001aI\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00050\u00012\u001a\b\u0004\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00130\bH\u0087\b\u001a*\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00050\u00010\u0006H\u0007\u001a(\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00010\u0001H\u0007\u001a*\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00050\u00010\u0006H\u0007\u001a#\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0001H\u0087\b\u001a(\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00010\u0001H\u0007\u001a(\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00010\u0001H\u0007\u001a\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0006\"\b\b\u0000\u0010\u0005*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00050\u001bH\u0002\u001aD\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H 0\u001e0\u001d\"\b\b\u0000\u0010\u001f*\u00020\u0003\"\b\b\u0001\u0010 *\u00020\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H 0!0\u0001H\u0007\u001aJ\u0010\"\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H 0#0\u001e0\u001d\"\b\b\u0000\u0010\u001f*\u00020\u0003\"\b\b\u0001\u0010 *\u00020\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H 0!0\u0001H\u0007\u001a'\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00050%H\u0007¢\u0006\u0002\u0010&\u001a\u0012\u0010$\u001a\b\u0012\u0004\u0012\u00020'0\u0001*\u00020(H\u0007\u001a\u0012\u0010$\u001a\b\u0012\u0004\u0012\u00020)0\u0001*\u00020*H\u0007\u001a\u0012\u0010$\u001a\b\u0012\u0004\u0012\u00020+0\u0001*\u00020,H\u0007\u001a\u0012\u0010$\u001a\b\u0012\u0004\u0012\u00020-0\u0001*\u00020.H\u0007\u001a\u0012\u0010$\u001a\b\u0012\u0004\u0012\u00020/0\u0001*\u000200H\u0007\u001a\u0012\u0010$\u001a\b\u0012\u0004\u0012\u0002010\u0001*\u000202H\u0007\u001a\u0012\u0010$\u001a\b\u0012\u0004\u0012\u0002030\u0001*\u000204H\u0007\u001a\u0012\u0010$\u001a\b\u0012\u0004\u0012\u0002050\u0001*\u000206H\u0007\u001a\"\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00050\u0006H\u0007\u001a\"\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00050\u001bH\u0007\u001a\u0012\u0010$\u001a\b\u0012\u0004\u0012\u0002010\u0001*\u000207H\u0007\u001a\"\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00050\u0013H\u0007\u001a^\u00108\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00010\u00062)\b\u0004\u00109\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00020\bH\u0087\b¨\u0006:"}, m5598d2 = {"cast", "Lio/reactivex/Observable;", "R", "", "combineLatest", ExifInterface.GPS_DIRECTION_TRUE, "", "combineFunction", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "args", "concatAll", "Lio/reactivex/ObservableSource;", "concatMapIterable", "flatMapIterable", "flatMapSequence", "body", "Lkotlin/sequences/Sequence;", "merge", "mergeAll", "mergeDelayError", "ofType", "switchLatest", "switchOnNext", "toIterable", "", "toMap", "Lio/reactivex/Single;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Lkotlin/Pair;", "toMultimap", "", "toObservable", "", "([Ljava/lang/Object;)Lio/reactivex/Observable;", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "Lkotlin/ranges/IntProgression;", HeaderParameterNames.ZIP, "zipFunction", "rxkotlin"}, m5599k = 2, m5600mv = {1, 1, 15})
public final class ObservableKt {
    @SchedulerSupport("none")
    @CheckReturnValue
    public static final Observable<Boolean> toObservable(boolean[] toObservable) {
        Intrinsics.checkParameterIsNotNull(toObservable, "$this$toObservable");
        return toObservable(ArraysKt.asIterable(toObservable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final Observable<Byte> toObservable(byte[] toObservable) {
        Intrinsics.checkParameterIsNotNull(toObservable, "$this$toObservable");
        return toObservable(ArraysKt.asIterable(toObservable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final Observable<Character> toObservable(char[] toObservable) {
        Intrinsics.checkParameterIsNotNull(toObservable, "$this$toObservable");
        return toObservable(ArraysKt.asIterable(toObservable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final Observable<Short> toObservable(short[] toObservable) {
        Intrinsics.checkParameterIsNotNull(toObservable, "$this$toObservable");
        return toObservable(ArraysKt.asIterable(toObservable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final Observable<Integer> toObservable(int[] toObservable) {
        Intrinsics.checkParameterIsNotNull(toObservable, "$this$toObservable");
        return toObservable(ArraysKt.asIterable(toObservable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final Observable<Long> toObservable(long[] toObservable) {
        Intrinsics.checkParameterIsNotNull(toObservable, "$this$toObservable");
        return toObservable(ArraysKt.asIterable(toObservable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final Observable<Float> toObservable(float[] toObservable) {
        Intrinsics.checkParameterIsNotNull(toObservable, "$this$toObservable");
        return toObservable(ArraysKt.asIterable(toObservable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final Observable<Double> toObservable(double[] toObservable) {
        Intrinsics.checkParameterIsNotNull(toObservable, "$this$toObservable");
        return toObservable(ArraysKt.asIterable(toObservable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T> Observable<T> toObservable(T[] toObservable) {
        Intrinsics.checkParameterIsNotNull(toObservable, "$this$toObservable");
        Observable<T> observableFromArray = Observable.fromArray(Arrays.copyOf(toObservable, toObservable.length));
        Intrinsics.checkExpressionValueIsNotNull(observableFromArray, "Observable.fromArray(*this)");
        return observableFromArray;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final Observable<Integer> toObservable(IntProgression toObservable) {
        Intrinsics.checkParameterIsNotNull(toObservable, "$this$toObservable");
        if (toObservable.getStep() != 1 || ((long) toObservable.getLast()) - ((long) toObservable.getFirst()) >= Integer.MAX_VALUE) {
            Observable<Integer> observableFromIterable = Observable.fromIterable(toObservable);
            Intrinsics.checkExpressionValueIsNotNull(observableFromIterable, "Observable.fromIterable(this)");
            return observableFromIterable;
        }
        Observable<Integer> observableRange = Observable.range(toObservable.getFirst(), Math.max(0, (toObservable.getLast() - toObservable.getFirst()) + 1));
        Intrinsics.checkExpressionValueIsNotNull(observableRange, "Observable.range(first, …max(0, last - first + 1))");
        return observableRange;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T> Observable<T> toObservable(Iterator<? extends T> toObservable) {
        Intrinsics.checkParameterIsNotNull(toObservable, "$this$toObservable");
        return toObservable(toIterable(toObservable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T> Observable<T> toObservable(Iterable<? extends T> toObservable) {
        Intrinsics.checkParameterIsNotNull(toObservable, "$this$toObservable");
        Observable<T> observableFromIterable = Observable.fromIterable(toObservable);
        Intrinsics.checkExpressionValueIsNotNull(observableFromIterable, "Observable.fromIterable(this)");
        return observableFromIterable;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T> Observable<T> toObservable(Sequence<? extends T> toObservable) {
        Intrinsics.checkParameterIsNotNull(toObservable, "$this$toObservable");
        return toObservable(SequencesKt.asIterable(toObservable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T> Observable<T> merge(Iterable<? extends Observable<? extends T>> merge) {
        Intrinsics.checkParameterIsNotNull(merge, "$this$merge");
        Observable<T> observableMerge = Observable.merge(toObservable(merge));
        Intrinsics.checkExpressionValueIsNotNull(observableMerge, "Observable.merge(this.toObservable())");
        return observableMerge;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T> Observable<T> mergeDelayError(Iterable<? extends Observable<? extends T>> mergeDelayError) {
        Intrinsics.checkParameterIsNotNull(mergeDelayError, "$this$mergeDelayError");
        Observable<T> observableMergeDelayError = Observable.mergeDelayError(toObservable(mergeDelayError));
        Intrinsics.checkExpressionValueIsNotNull(observableMergeDelayError, "Observable.mergeDelayError(this.toObservable())");
        return observableMergeDelayError;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T> Observable<T> flatMapIterable(Observable<? extends Iterable<? extends T>> flatMapIterable) {
        Intrinsics.checkParameterIsNotNull(flatMapIterable, "$this$flatMapIterable");
        Observable<T> observable = (Observable<T>) flatMapIterable.flatMapIterable(new Function<T, Iterable<? extends U>>() { // from class: io.reactivex.rxkotlin.ObservableKt.flatMapIterable.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.functions.Function
            public final Iterable<T> apply(Iterable<? extends T> it2) {
                Intrinsics.checkParameterIsNotNull(it2, "it");
                return it2;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observable, "flatMapIterable { it }");
        return observable;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T> Observable<T> concatMapIterable(Observable<? extends Iterable<? extends T>> concatMapIterable) {
        Intrinsics.checkParameterIsNotNull(concatMapIterable, "$this$concatMapIterable");
        Observable<T> observable = (Observable<T>) concatMapIterable.concatMapIterable(new Function<T, Iterable<? extends U>>() { // from class: io.reactivex.rxkotlin.ObservableKt.concatMapIterable.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.functions.Function
            public final Iterable<T> apply(Iterable<? extends T> it2) {
                Intrinsics.checkParameterIsNotNull(it2, "it");
                return it2;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observable, "concatMapIterable { it }");
        return observable;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T, R> Observable<R> flatMapSequence(Observable<T> flatMapSequence, final Function1<? super T, ? extends Sequence<? extends R>> body) {
        Intrinsics.checkParameterIsNotNull(flatMapSequence, "$this$flatMapSequence");
        Intrinsics.checkParameterIsNotNull(body, "body");
        Observable<R> observableFlatMap = flatMapSequence.flatMap(new Function<T, ObservableSource<? extends R>>() { // from class: io.reactivex.rxkotlin.ObservableKt.flatMapSequence.1
            @Override // io.reactivex.functions.Function
            public final Observable<R> apply(T it2) {
                Intrinsics.checkParameterIsNotNull(it2, "it");
                return ObservableKt.toObservable((Sequence) body.invoke(it2));
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observableFlatMap, "flatMap { body(it).toObservable() }");
        return observableFlatMap;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T, R> Observable<R> combineLatest(Iterable<? extends Observable<T>> combineLatest, final Function1<? super List<? extends T>, ? extends R> combineFunction) {
        Intrinsics.checkParameterIsNotNull(combineLatest, "$this$combineLatest");
        Intrinsics.checkParameterIsNotNull(combineFunction, "combineFunction");
        Observable<R> observableCombineLatest = Observable.combineLatest(combineLatest, new Function<Object[], R>() { // from class: io.reactivex.rxkotlin.ObservableKt.combineLatest.1
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
        Intrinsics.checkExpressionValueIsNotNull(observableCombineLatest, "Observable.combineLatest…List().map { it as T }) }");
        return observableCombineLatest;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T, R> Observable<R> zip(Iterable<? extends Observable<T>> zip, final Function1<? super List<? extends T>, ? extends R> zipFunction) {
        Intrinsics.checkParameterIsNotNull(zip, "$this$zip");
        Intrinsics.checkParameterIsNotNull(zipFunction, "zipFunction");
        Observable<R> observableZip = Observable.zip(zip, new Function<Object[], R>() { // from class: io.reactivex.rxkotlin.ObservableKt.zip.1
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
        Intrinsics.checkExpressionValueIsNotNull(observableZip, "Observable.zip(this) { z…List().map { it as T }) }");
        return observableZip;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final /* synthetic */ <R> Observable<R> cast(Observable<?> cast) {
        Intrinsics.checkParameterIsNotNull(cast, "$this$cast");
        Intrinsics.reifiedOperationMarker(4, "R");
        Observable<R> observable = (Observable<R>) cast.cast(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(observable, "cast(R::class.java)");
        return observable;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final /* synthetic */ <R> Observable<R> ofType(Observable<?> ofType) {
        Intrinsics.checkParameterIsNotNull(ofType, "$this$ofType");
        Intrinsics.reifiedOperationMarker(4, "R");
        Observable<R> observable = (Observable<R>) ofType.ofType(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(observable, "ofType(R::class.java)");
        return observable;
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: io.reactivex.rxkotlin.ObservableKt$toIterable$1 */
    /* JADX INFO: compiled from: observable.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004"}, m5598d2 = {"io/reactivex/rxkotlin/ObservableKt$toIterable$1", "", "iterator", "", "rxkotlin"}, m5599k = 1, m5600mv = {1, 1, 15})
    public static final class C54391<T> implements Iterable<T>, KMappedMarker {
        final /* synthetic */ Iterator $this_toIterable;

        C54391(Iterator<? extends T> it2) {
            this.$this_toIterable = it2;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.$this_toIterable;
        }
    }

    private static final <T> Iterable<T> toIterable(Iterator<? extends T> it2) {
        return new C54391(it2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T> Observable<T> mergeAll(Observable<Observable<T>> mergeAll) {
        Intrinsics.checkParameterIsNotNull(mergeAll, "$this$mergeAll");
        Observable<T> observable = (Observable<T>) mergeAll.flatMap(new Function<T, ObservableSource<? extends R>>() { // from class: io.reactivex.rxkotlin.ObservableKt.mergeAll.1
            @Override // io.reactivex.functions.Function
            public final Observable<T> apply(Observable<T> it2) {
                Intrinsics.checkParameterIsNotNull(it2, "it");
                return it2;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observable, "flatMap { it }");
        return observable;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T> Observable<T> concatAll(Observable<Observable<T>> concatAll) {
        Intrinsics.checkParameterIsNotNull(concatAll, "$this$concatAll");
        Observable<T> observable = (Observable<T>) concatAll.concatMap(new Function<T, ObservableSource<? extends R>>() { // from class: io.reactivex.rxkotlin.ObservableKt.concatAll.1
            @Override // io.reactivex.functions.Function
            public final Observable<T> apply(Observable<T> it2) {
                Intrinsics.checkParameterIsNotNull(it2, "it");
                return it2;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observable, "concatMap { it }");
        return observable;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T> Observable<T> switchLatest(Observable<Observable<T>> switchLatest) {
        Intrinsics.checkParameterIsNotNull(switchLatest, "$this$switchLatest");
        Observable<T> observable = (Observable<T>) switchLatest.switchMap(new Function<T, ObservableSource<? extends R>>() { // from class: io.reactivex.rxkotlin.ObservableKt.switchLatest.1
            @Override // io.reactivex.functions.Function
            public final Observable<T> apply(Observable<T> it2) {
                Intrinsics.checkParameterIsNotNull(it2, "it");
                return it2;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observable, "switchMap { it }");
        return observable;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T> Observable<T> switchOnNext(Observable<Observable<T>> switchOnNext) {
        Intrinsics.checkParameterIsNotNull(switchOnNext, "$this$switchOnNext");
        Observable<T> observableSwitchOnNext = Observable.switchOnNext(switchOnNext);
        Intrinsics.checkExpressionValueIsNotNull(observableSwitchOnNext, "Observable.switchOnNext(this)");
        return observableSwitchOnNext;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <A, B> Single<Map<A, B>> toMap(Observable<Pair<A, B>> toMap) {
        Intrinsics.checkParameterIsNotNull(toMap, "$this$toMap");
        Single<Map<A, B>> single = (Single<Map<A, B>>) toMap.toMap(new Function<T, K>() { // from class: io.reactivex.rxkotlin.ObservableKt.toMap.1
            /* JADX WARN: Type inference failed for: r2v1, types: [A, java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public final A apply(Pair<? extends A, ? extends B> it2) {
                Intrinsics.checkParameterIsNotNull(it2, "it");
                return it2.getFirst();
            }
        }, new Function<T, V>() { // from class: io.reactivex.rxkotlin.ObservableKt.toMap.2
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
    @CheckReturnValue
    public static final <A, B> Single<Map<A, Collection<B>>> toMultimap(Observable<Pair<A, B>> toMultimap) {
        Intrinsics.checkParameterIsNotNull(toMultimap, "$this$toMultimap");
        Single<Map<A, Collection<B>>> single = (Single<Map<A, Collection<B>>>) toMultimap.toMultimap(new Function<T, K>() { // from class: io.reactivex.rxkotlin.ObservableKt.toMultimap.1
            /* JADX WARN: Type inference failed for: r2v1, types: [A, java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public final A apply(Pair<? extends A, ? extends B> it2) {
                Intrinsics.checkParameterIsNotNull(it2, "it");
                return it2.getFirst();
            }
        }, new Function<T, V>() { // from class: io.reactivex.rxkotlin.ObservableKt.toMultimap.2
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
    @CheckReturnValue
    public static final <T> Observable<T> concatAll(Iterable<? extends ObservableSource<T>> concatAll) {
        Intrinsics.checkParameterIsNotNull(concatAll, "$this$concatAll");
        Observable<T> observableConcat = Observable.concat(concatAll);
        Intrinsics.checkExpressionValueIsNotNull(observableConcat, "Observable.concat(this)");
        return observableConcat;
    }
}
