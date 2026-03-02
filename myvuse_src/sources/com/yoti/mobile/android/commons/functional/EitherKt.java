package com.yoti.mobile.android.commons.functional;

import androidx.exifinterface.media.ExifInterface;
import com.yoti.mobile.android.commons.functional.Either;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Either.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u001aW\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001aa\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\t*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\n2\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00028\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\n0\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001aU\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\t*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\r\u001a1\u0010\u0010\u001a\u00028\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\t*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n2\u0006\u0010\u000f\u001a\u00028\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, m5598d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "Lkotlin/Function1;", "f", "andThen", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "MappedSuccessType", "FailureType", "SuccessType", "Lcom/yoti/mobile/android/commons/functional/Either;", "mapFunction", "flatMap", "(Lcom/yoti/mobile/android/commons/functional/Either;Lkotlin/jvm/functions/Function1;)Lcom/yoti/mobile/android/commons/functional/Either;", "map", "value", "getOrElse", "(Lcom/yoti/mobile/android/commons/functional/Either;Ljava/lang/Object;)Ljava/lang/Object;", "commons-functional_release"}, m5599k = 2, m5600mv = {1, 4, 2})
public final class EitherKt {
    public static final <FailureType, SuccessType> SuccessType getOrElse(Either<? extends FailureType, ? extends SuccessType> getOrElse, SuccessType successtype) {
        Intrinsics.checkNotNullParameter(getOrElse, "$this$getOrElse");
        if (getOrElse instanceof Either.Failure) {
            return successtype;
        }
        if (getOrElse instanceof Either.Success) {
            return (SuccessType) ((Either.Success) getOrElse).getSuccessResult();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <A, B, C> Function1<A, C> andThen(final Function1<? super A, ? extends B> andThen, final Function1<? super B, ? extends C> f) {
        Intrinsics.checkNotNullParameter(andThen, "$this$andThen");
        Intrinsics.checkNotNullParameter(f, "f");
        return new Function1<A, C>() { // from class: com.yoti.mobile.android.commons.functional.EitherKt.andThen.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final C invoke(A a2) {
                return (C) f.invoke(andThen.invoke(a2));
            }
        };
    }

    public static final <MappedSuccessType, FailureType, SuccessType> Either<FailureType, MappedSuccessType> flatMap(Either<? extends FailureType, ? extends SuccessType> flatMap, Function1<? super SuccessType, ? extends Either<? extends FailureType, ? extends MappedSuccessType>> mapFunction) {
        Intrinsics.checkNotNullParameter(flatMap, "$this$flatMap");
        Intrinsics.checkNotNullParameter(mapFunction, "mapFunction");
        if (flatMap instanceof Either.Failure) {
            return new Either.Failure(((Either.Failure) flatMap).getFailResult());
        }
        if (flatMap instanceof Either.Success) {
            return mapFunction.invoke((Object) ((Either.Success) flatMap).getSuccessResult());
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <MappedSuccessType, FailureType, SuccessType> Either<FailureType, MappedSuccessType> map(final Either<? extends FailureType, ? extends SuccessType> map, final Function1<? super SuccessType, ? extends MappedSuccessType> mapFunction) {
        Intrinsics.checkNotNullParameter(map, "$this$map");
        Intrinsics.checkNotNullParameter(mapFunction, "mapFunction");
        Function1 function1 = new Function1<SuccessType, Either.Success<? extends MappedSuccessType>>() { // from class: com.yoti.mobile.android.commons.functional.EitherKt$map$$inlined$andThen$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Either.Success<? extends MappedSuccessType> invoke(SuccessType successtype) {
                return map.success(mapFunction.invoke(successtype));
            }
        };
        if (map instanceof Either.Failure) {
            return new Either.Failure(((Either.Failure) map).getFailResult());
        }
        if (map instanceof Either.Success) {
            return (Either) function1.invoke(((Either.Success) map).getSuccessResult());
        }
        throw new NoWhenBranchMatchedException();
    }
}
