package com.bat.sdk;

import com.bat.sdk.logging.Logger;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DateExtension.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b\u001a\f\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\b\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\n"}, m5598d2 = {"referenceDate", "Ljava/time/Instant;", "getReferenceDate", "()Ljava/time/Instant;", "referenceDate$delegate", "Lkotlin/Lazy;", "isCurrentTime", "", "Ljava/util/Date;", "adjusted", "sdk_release"}, m5599k = 2, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class DateExtensionKt {
    private static final Lazy referenceDate$delegate = LazyKt.lazy(new Function0() { // from class: com.bat.sdk.DateExtensionKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return DateExtensionKt.referenceDate_delegate$lambda$1();
        }
    });

    public static final Instant getReferenceDate() {
        Object value = referenceDate$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Instant) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Instant referenceDate_delegate$lambda$1() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, 2018);
        return calendar.toInstant();
    }

    public static final boolean isCurrentTime(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        return date.toInstant().isAfter(getReferenceDate());
    }

    public static final Date adjusted(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!date.toInstant().isBefore(getReferenceDate())) {
            return date;
        }
        Long deviceTimeUnix = BatSdk.INSTANCE.getDeviceTimeUnix();
        if (deviceTimeUnix != null) {
            Logger.INSTANCE.log("[time] need to adjust puff record timestamp using current device time at: " + BatSdk.INSTANCE.getDeviceTimeUnix());
            return new Date((jCurrentTimeMillis - deviceTimeUnix.longValue()) + date.getTime());
        }
        Logger.INSTANCE.log("Invalid time, discarding puff");
        return null;
    }
}
