package io.ktor.utils.p098io.errors;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.utils.p098io.core.Buffer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Errors.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a\u001b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u0007¢\u0006\u0002\u0010\u0004\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0000\u001a\b\u0010\r\u001a\u00020\u0001H\u0001¨\u0006\u000e"}, m5598d2 = {"TODO_ERROR", "", "R", "value", "(Ljava/lang/Object;)Ljava/lang/Void;", "checkPeekTo", "", FirebaseAnalytics.Param.DESTINATION, "Lio/ktor/utils/io/core/Buffer;", TypedValues.CycleType.S_WAVE_OFFSET, "", "min", "max", "incompatibleVersionError", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class ErrorsKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Not implemented.")
    public static final <R> Void TODO_ERROR(R r) {
        throw new NotImplementedError("An operation is not implemented: " + Intrinsics.stringPlus("Not implemented. Value is ", r));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Not implemented.")
    public static final Void TODO_ERROR() {
        throw new NotImplementedError("An operation is not implemented: Not implemented.");
    }

    public static final Void incompatibleVersionError() {
        throw new Error("This API is no longer supported. Please downgrade kotlinx-io or recompile your project/dependencies with new kotlinx-io.");
    }

    public static final void checkPeekTo(Buffer destination, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("offset shouldn't be negative: " + i + '.').toString());
        }
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("min shouldn't be negative: " + i2 + '.').toString());
        }
        if (!(i3 >= i2)) {
            throw new IllegalArgumentException(("max should't be less than min: max = " + i3 + ", min = " + i2 + '.').toString());
        }
        if (!(i2 <= destination.getLimit() - destination.getWritePosition())) {
            throw new IllegalArgumentException(("Not enough free space in the destination buffer to write the specified minimum number of bytes: min = " + i2 + ", free = " + (destination.getLimit() - destination.getWritePosition()) + '.').toString());
        }
    }
}
