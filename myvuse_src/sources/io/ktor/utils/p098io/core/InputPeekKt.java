package io.ktor.utils.p098io.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.utils.p098io.errors.ErrorsKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: InputPeek.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0001H\u0007\u001a2\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0001H\u0007¨\u0006\t"}, m5598d2 = {"peekTo", "", "Lio/ktor/utils/io/core/Input;", FirebaseAnalytics.Param.DESTINATION, "Lio/ktor/utils/io/core/Buffer;", TypedValues.CycleType.S_WAVE_OFFSET, "min", "max", "Lio/ktor/utils/io/core/IoBuffer;", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class InputPeekKt {
    public static /* synthetic */ int peekTo$default(Input input, IoBuffer ioBuffer, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return peekTo(input, ioBuffer, i, i2, i3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ int peekTo(Input input, IoBuffer destination, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return peekTo(input, (Buffer) destination, i, i2, i3);
    }

    public static /* synthetic */ int peekTo$default(Input input, Buffer buffer, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return peekTo(input, buffer, i, i2, i3);
    }

    @Deprecated(message = "Use peekTo(Memory) instead.")
    public static final int peekTo(Input input, Buffer destination, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        ErrorsKt.checkPeekTo(destination, i, i2, i3);
        int iMo7100peekTo1dgeIsk = (int) input.mo7100peekTo1dgeIsk(destination.getMemory(), destination.getWritePosition(), i, i2, RangesKt.coerceAtMost(i3, destination.getLimit() - destination.getWritePosition()));
        destination.commitWritten(iMo7100peekTo1dgeIsk);
        return iMo7100peekTo1dgeIsk;
    }
}
