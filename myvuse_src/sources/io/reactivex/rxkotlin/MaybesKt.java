package io.reactivex.rxkotlin;

import androidx.exifinterface.media.ExifInterface;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Maybes.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001aF\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0005\"\b\b\u0001\u0010\u0004*\u00020\u0005*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0007H\u0007\u001aa\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0005\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\b*\u00020\u0005*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00072\u001a\b\u0004\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\b0\nH\u0087\b¨\u0006\u000b"}, m5598d2 = {"zipWith", "Lio/reactivex/Maybe;", "Lkotlin/Pair;", ExifInterface.GPS_DIRECTION_TRUE, "U", "", "other", "Lio/reactivex/MaybeSource;", "R", "zipper", "Lkotlin/Function2;", "rxkotlin"}, m5599k = 2, m5600mv = {1, 1, 15})
public final class MaybesKt {
    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T, U, R> Maybe<R> zipWith(Maybe<T> zipWith, MaybeSource<U> other, final Function2<? super T, ? super U, ? extends R> zipper) {
        Intrinsics.checkParameterIsNotNull(zipWith, "$this$zipWith");
        Intrinsics.checkParameterIsNotNull(other, "other");
        Intrinsics.checkParameterIsNotNull(zipper, "zipper");
        Maybe<R> maybeZipWith = zipWith.zipWith(other, new BiFunction<T, U, R>() { // from class: io.reactivex.rxkotlin.MaybesKt.zipWith.1
            @Override // io.reactivex.functions.BiFunction
            public final R apply(T t, U u) {
                Intrinsics.checkParameterIsNotNull(t, "t");
                Intrinsics.checkParameterIsNotNull(u, "u");
                return (R) zipper.invoke(t, u);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(maybeZipWith, "zipWith(other, BiFunctio…-> zipper.invoke(t, u) })");
        return maybeZipWith;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T, U> Maybe<Pair<T, U>> zipWith(Maybe<T> zipWith, MaybeSource<U> other) {
        Intrinsics.checkParameterIsNotNull(zipWith, "$this$zipWith");
        Intrinsics.checkParameterIsNotNull(other, "other");
        Maybe<Pair<T, U>> maybe = (Maybe<Pair<T, U>>) zipWith.zipWith(other, new BiFunction<T, U, Pair<? extends T, ? extends U>>() { // from class: io.reactivex.rxkotlin.MaybesKt.zipWith.2
            @Override // io.reactivex.functions.BiFunction
            public final Pair<T, U> apply(T t, U u) {
                Intrinsics.checkParameterIsNotNull(t, "t");
                Intrinsics.checkParameterIsNotNull(u, "u");
                return new Pair<>(t, u);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(maybe, "zipWith(other, BiFunction { t, u -> Pair(t, u) })");
        return maybe;
    }
}
