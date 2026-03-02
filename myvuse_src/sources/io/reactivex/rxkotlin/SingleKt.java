package io.reactivex.rxkotlin;

import androidx.exifinterface.media.ExifInterface;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: single.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0001H\u0086\b\u001a(\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\b0\u0007H\u0007\u001a(\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\u0005H\u0007\u001a(\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\n\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\nH\u0007¨\u0006\u000b"}, m5598d2 = {"cast", "Lio/reactivex/Single;", "R", "", "concatAll", "Lio/reactivex/Flowable;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lio/reactivex/SingleSource;", "mergeAllSingles", "Lio/reactivex/Observable;", "rxkotlin"}, m5599k = 2, m5600mv = {1, 1, 15})
public final class SingleKt {
    public static final /* synthetic */ <R> Single<R> cast(Single<?> cast) {
        Intrinsics.checkParameterIsNotNull(cast, "$this$cast");
        Intrinsics.reifiedOperationMarker(4, "R");
        Single<R> single = (Single<R>) cast.cast(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(single, "cast(R::class.java)");
        return single;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T> Observable<T> mergeAllSingles(Observable<Single<T>> mergeAllSingles) {
        Intrinsics.checkParameterIsNotNull(mergeAllSingles, "$this$mergeAllSingles");
        Observable<T> observable = (Observable<T>) mergeAllSingles.flatMapSingle(new Function<T, SingleSource<? extends R>>() { // from class: io.reactivex.rxkotlin.SingleKt.mergeAllSingles.1
            @Override // io.reactivex.functions.Function
            public final Single<T> apply(Single<T> it2) {
                Intrinsics.checkParameterIsNotNull(it2, "it");
                return it2;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observable, "flatMapSingle { it }");
        return observable;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static final <T> Flowable<T> mergeAllSingles(Flowable<Single<T>> mergeAllSingles) {
        Intrinsics.checkParameterIsNotNull(mergeAllSingles, "$this$mergeAllSingles");
        Flowable<T> flowable = (Flowable<T>) mergeAllSingles.flatMapSingle(new Function<T, SingleSource<? extends R>>() { // from class: io.reactivex.rxkotlin.SingleKt.mergeAllSingles.2
            @Override // io.reactivex.functions.Function
            public final Single<T> apply(Single<T> it2) {
                Intrinsics.checkParameterIsNotNull(it2, "it");
                return it2;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flowable, "flatMapSingle { it }");
        return flowable;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T> Flowable<T> concatAll(Iterable<? extends SingleSource<T>> concatAll) {
        Intrinsics.checkParameterIsNotNull(concatAll, "$this$concatAll");
        Flowable<T> flowableConcat = Single.concat(concatAll);
        Intrinsics.checkExpressionValueIsNotNull(flowableConcat, "Single.concat(this)");
        return flowableConcat;
    }
}
