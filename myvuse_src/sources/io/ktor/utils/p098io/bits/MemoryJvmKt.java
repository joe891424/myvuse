package io.ktor.utils.p098io.bits;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.utils.p098io.core.internal.NumbersKt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;

/* JADX INFO: compiled from: MemoryJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0010\u0005\n\u0002\b\t\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\b\u001a,\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a,\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\r\u0010\u001c\u001a\u00020\u0004*\u00020\u0004H\u0082\b\u001a\r\u0010\u001d\u001a\u00020\u0004*\u00020\u0004H\u0082\b\u001a\u001c\u0010\u001e\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0000\u001a\r\u0010\u001f\u001a\u00020\u0004*\u00020\u0004H\u0082\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, m5598d2 = {"copyTo", "", "Lio/ktor/utils/io/bits/Memory;", FirebaseAnalytics.Param.DESTINATION, "Ljava/nio/ByteBuffer;", TypedValues.CycleType.S_WAVE_OFFSET, "", "copyTo-jqM8g04", "(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;I)V", "", "copyTo-rB7MWs8", "(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;J)V", "", "length", "destinationOffset", "copyTo-Fs5fovk", "(Ljava/nio/ByteBuffer;[BIII)V", "copyTo-odTdu9Q", "(Ljava/nio/ByteBuffer;[BJII)V", "copyTo-rDIWIdE", "fill", NewHtcHomeBadger.COUNT, "value", "", "fill-Bd10AMI", "(Ljava/nio/ByteBuffer;IIB)V", "fill-syO9epc", "(Ljava/nio/ByteBuffer;JJB)V", "myDuplicate", "mySlice", "sliceSafe", "suppressNullCheck", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class MemoryJvmKt {
    private static final ByteBuffer suppressNullCheck(ByteBuffer byteBuffer) {
        return byteBuffer;
    }

    /* JADX INFO: renamed from: copyTo-Fs5fovk, reason: not valid java name */
    public static final void m6968copyToFs5fovk(ByteBuffer copyTo, byte[] destination, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(copyTo, "$this$copyTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (copyTo.hasArray() && !copyTo.isReadOnly()) {
            System.arraycopy(copyTo.array(), copyTo.arrayOffset() + i, destination, i3, i2);
        } else {
            copyTo.duplicate().get(destination, i3, i2);
        }
    }

    /* JADX INFO: renamed from: copyTo-odTdu9Q, reason: not valid java name */
    public static final void m6970copyToodTdu9Q(ByteBuffer copyTo, byte[] destination, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(copyTo, "$this$copyTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (j < 2147483647L) {
            m6968copyToFs5fovk(copyTo, destination, (int) j, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: copyTo-jqM8g04, reason: not valid java name */
    public static final void m6969copyTojqM8g04(ByteBuffer copyTo, ByteBuffer destination, int i) {
        Intrinsics.checkNotNullParameter(copyTo, "$this$copyTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        int iRemaining = destination.remaining();
        if (copyTo.hasArray() && !copyTo.isReadOnly() && destination.hasArray() && !destination.isReadOnly()) {
            int iPosition = destination.position();
            System.arraycopy(copyTo.array(), copyTo.arrayOffset() + i, destination.array(), destination.arrayOffset() + iPosition, iRemaining);
        } else {
            ByteBuffer byteBufferDuplicate = copyTo.duplicate();
            destination.put(byteBufferDuplicate);
        }
    }

    /* JADX INFO: renamed from: copyTo-rB7MWs8, reason: not valid java name */
    public static final void m6971copyTorB7MWs8(ByteBuffer copyTo, ByteBuffer destination, long j) {
        Intrinsics.checkNotNullParameter(copyTo, "$this$copyTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (j < 2147483647L) {
            m6969copyTojqM8g04(copyTo, destination, (int) j);
        } else {
            NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: copyTo-rDIWIdE, reason: not valid java name */
    public static final void m6972copyTorDIWIdE(ByteBuffer copyTo, ByteBuffer destination, int i) {
        Intrinsics.checkNotNullParameter(copyTo, "$this$copyTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (copyTo.hasArray() && !copyTo.isReadOnly()) {
            byte[] bArrArray = copyTo.array();
            Intrinsics.checkNotNullExpressionValue(bArrArray, "array()");
            int iArrayOffset = copyTo.arrayOffset() + copyTo.position();
            int iRemaining = copyTo.remaining();
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArrArray, iArrayOffset, iRemaining).slice().order(ByteOrder.BIG_ENDIAN);
            Intrinsics.checkNotNullExpressionValue(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
            Memory.m6952copyTof5Ywojk(Memory.m6951constructorimpl(byteBufferOrder), destination, 0, iRemaining, i);
            return;
        }
        sliceSafe(destination, i, copyTo.remaining()).put(copyTo);
    }

    private static final ByteBuffer myDuplicate(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        Intrinsics.checkNotNullExpressionValue(byteBufferDuplicate, "");
        return byteBufferDuplicate;
    }

    private static final ByteBuffer mySlice(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        Intrinsics.checkNotNullExpressionValue(byteBufferSlice, "");
        return byteBufferSlice;
    }

    /* JADX INFO: renamed from: fill-syO9epc, reason: not valid java name */
    public static final void m6974fillsyO9epc(ByteBuffer fill, long j, long j2, byte b) {
        Intrinsics.checkNotNullParameter(fill, "$this$fill");
        if (j >= 2147483647L) {
            NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
            throw new KotlinNothingValueException();
        }
        int i = (int) j;
        if (j2 < 2147483647L) {
            m6973fillBd10AMI(fill, i, (int) j2, b);
        } else {
            NumbersKt.failLongToIntConversion(j2, NewHtcHomeBadger.COUNT);
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: fill-Bd10AMI, reason: not valid java name */
    public static final void m6973fillBd10AMI(ByteBuffer fill, int i, int i2, byte b) {
        Intrinsics.checkNotNullParameter(fill, "$this$fill");
        int i3 = i2 + i;
        if (i >= i3) {
            return;
        }
        while (true) {
            int i4 = i + 1;
            fill.put(i, b);
            if (i4 >= i3) {
                return;
            } else {
                i = i4;
            }
        }
    }

    public static final ByteBuffer sliceSafe(ByteBuffer byteBuffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        Intrinsics.checkNotNullExpressionValue(byteBufferDuplicate, "");
        ByteBuffer byteBufferSlice = byteBufferDuplicate.slice();
        Intrinsics.checkNotNullExpressionValue(byteBufferSlice, "");
        return byteBufferSlice;
    }
}
