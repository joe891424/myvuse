package io.reactivex.rxkotlin;

import androidx.exifinterface.media.ExifInterface;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: maybe.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0001H\u0087\b\u001a(\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\b0\u0007H\u0007\u001a(\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\u0005H\u0007\u001a(\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\n\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\nH\u0007\u001a#\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0001H\u0087\b¨\u0006\f"}, m5598d2 = {"cast", "Lio/reactivex/Maybe;", "R", "", "concatAll", "Lio/reactivex/Flowable;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lio/reactivex/MaybeSource;", "mergeAllMaybes", "Lio/reactivex/Observable;", "ofType", "rxkotlin"}, m5599k = 2, m5600mv = {1, 1, 15})
public final class MaybeKt {
    @SchedulerSupport("none")
    @CheckReturnValue
    public static final /* synthetic */ <R> Maybe<R> cast(Maybe<?> cast) {
        Intrinsics.checkParameterIsNotNull(cast, "$this$cast");
        Intrinsics.reifiedOperationMarker(4, "R");
        Maybe<R> maybe = (Maybe<R>) cast.cast(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(maybe, "cast(R::class.java)");
        return maybe;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final /* synthetic */ <R> Maybe<R> ofType(Maybe<?> ofType) {
        Intrinsics.checkParameterIsNotNull(ofType, "$this$ofType");
        Intrinsics.reifiedOperationMarker(4, "R");
        Maybe<R> maybe = (Maybe<R>) ofType.ofType(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(maybe, "ofType(R::class.java)");
        return maybe;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T> Observable<T> mergeAllMaybes(Observable<Maybe<T>> mergeAllMaybes) {
        Intrinsics.checkParameterIsNotNull(mergeAllMaybes, "$this$mergeAllMaybes");
        Observable<T> observable = (Observable<T>) mergeAllMaybes.flatMapMaybe(new Function<T, MaybeSource<? extends R>>() { // from class: io.reactivex.rxkotlin.MaybeKt.mergeAllMaybes.1
            @Override // io.reactivex.functions.Function
            public final Maybe<T> apply(Maybe<T> it2) {
                Intrinsics.checkParameterIsNotNull(it2, "it");
                return it2;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observable, "flatMapMaybe { it }");
        return observable;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static final <T> Flowable<T> mergeAllMaybes(Flowable<Maybe<T>> mergeAllMaybes) {
        Intrinsics.checkParameterIsNotNull(mergeAllMaybes, "$this$mergeAllMaybes");
        Flowable<T> flowable = (Flowable<T>) mergeAllMaybes.flatMapMaybe(new Function<T, MaybeSource<? extends R>>() { // from class: io.reactivex.rxkotlin.MaybeKt.mergeAllMaybes.2
            @Override // io.reactivex.functions.Function
            public final Maybe<T> apply(Maybe<T> it2) {
                Intrinsics.checkParameterIsNotNull(it2, "it");
                return it2;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flowable, "flatMapMaybe { it }");
        return flowable;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T> Flowable<T> concatAll(Iterable<? extends MaybeSource<T>> concatAll) {
        Intrinsics.checkParameterIsNotNull(concatAll, "$this$concatAll");
        Flowable<T> flowableConcat = Maybe.concat(concatAll);
        Intrinsics.checkExpressionValueIsNotNull(flowableConcat, "Maybe.concat(this)");
        return flowableConcat;
    }
}
