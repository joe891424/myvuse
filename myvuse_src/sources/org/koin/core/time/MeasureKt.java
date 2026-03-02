package org.koin.core.time;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeMark;
import kotlin.time.TimeSource;

/* JADX INFO: compiled from: Measure.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u001a&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00010\b\"\u0004\b\u0000\u0010\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\t0\u0003\u001a'\u0010\u0007\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\t0\u0003¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m5598d2 = {"measureDuration", "", "code", "Lkotlin/Function0;", "", "message", "", "measureDurationForResult", "Lkotlin/Pair;", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "koin-core"}, m5599k = 2, m5600mv = {1, 1, 16})
public final class MeasureKt {
    public static final double measureDuration(Function0<Unit> code) {
        Intrinsics.checkParameterIsNotNull(code, "code");
        TimeMark timeMarkMarkNow = TimeSource.Monotonic.INSTANCE.markNow();
        code.invoke();
        return Duration.getInMilliseconds-impl(timeMarkMarkNow.elapsedNow());
    }

    public static final void measureDuration(String message, Function0<Unit> code) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(code, "code");
        System.out.println((Object) (message + " - " + measureDuration(code) + " ms"));
    }

    public static final <T> Pair<T, Double> measureDurationForResult(Function0<? extends T> code) {
        Intrinsics.checkParameterIsNotNull(code, "code");
        return new Pair<>(code.invoke(), Double.valueOf(Duration.getInMilliseconds-impl(TimeSource.Monotonic.INSTANCE.markNow().elapsedNow())));
    }

    public static final <T> T measureDurationForResult(String message, Function0<? extends T> code) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(code, "code");
        Pair pairMeasureDurationForResult = measureDurationForResult(code);
        T t = (T) pairMeasureDurationForResult.component1();
        System.out.println((Object) (message + " - " + ((Number) pairMeasureDurationForResult.component2()).doubleValue() + " ms"));
        return t;
    }
}
