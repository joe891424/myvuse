package io.ktor.utils.p098io.bits;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.utils.p098io.core.internal.DangerousInternalIoApi;
import io.ktor.utils.p098io.core.internal.NumbersKt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MemoryJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 42\u00020\u0001:\u00014B\u0014\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J0\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b \u0010\u000fJ\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\rH\u0086\b¢\u0006\u0004\b$\u0010%J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\tH\u0086\b¢\u0006\u0004\b$\u0010&J#\u0010'\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)J#\u0010'\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010*J \u0010+\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\r2\u0006\u0010,\u001a\u00020\"H\u0086\b¢\u0006\u0004\b-\u0010.J \u0010+\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\t2\u0006\u0010,\u001a\u00020\"H\u0086\b¢\u0006\u0004\b-\u0010/J\u0010\u00100\u001a\u000201HÖ\u0001¢\u0006\u0004\b2\u00103R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\r8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0088\u0001\u0002ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u00065"}, m5598d2 = {"Lio/ktor/utils/io/bits/Memory;", "", "buffer", "Ljava/nio/ByteBuffer;", "constructor-impl", "(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;", "getBuffer", "()Ljava/nio/ByteBuffer;", "size", "", "getSize-impl", "(Ljava/nio/ByteBuffer;)J", "size32", "", "getSize32-impl", "(Ljava/nio/ByteBuffer;)I", "copyTo", "", FirebaseAnalytics.Param.DESTINATION, TypedValues.CycleType.S_WAVE_OFFSET, "length", "destinationOffset", "copyTo-f5Ywojk", "(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;III)V", "copyTo-iAfECsU", "(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;JJJ)V", "equals", "", "other", "equals-impl", "(Ljava/nio/ByteBuffer;Ljava/lang/Object;)Z", "hashCode", "hashCode-impl", "loadAt", "", FirebaseAnalytics.Param.INDEX, "loadAt-impl", "(Ljava/nio/ByteBuffer;I)B", "(Ljava/nio/ByteBuffer;J)B", "slice", "slice-SK3TCg8", "(Ljava/nio/ByteBuffer;II)Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;JJ)Ljava/nio/ByteBuffer;", "storeAt", "value", "storeAt-impl", "(Ljava/nio/ByteBuffer;IB)V", "(Ljava/nio/ByteBuffer;JB)V", "toString", "", "toString-impl", "(Ljava/nio/ByteBuffer;)Ljava/lang/String;", "Companion", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
@JvmInline
public final class Memory {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ByteBuffer Empty;
    private final ByteBuffer buffer;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Memory m6950boximpl(ByteBuffer byteBuffer) {
        return new Memory(byteBuffer);
    }

    @DangerousInternalIoApi
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static ByteBuffer m6951constructorimpl(ByteBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        return buffer;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6954equalsimpl(ByteBuffer byteBuffer, Object obj) {
        return (obj instanceof Memory) && Intrinsics.areEqual(byteBuffer, ((Memory) obj).m6966unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6955equalsimpl0(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        return Intrinsics.areEqual(byteBuffer, byteBuffer2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6958hashCodeimpl(ByteBuffer byteBuffer) {
        return byteBuffer.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m6965toStringimpl(ByteBuffer byteBuffer) {
        return "Memory(buffer=" + byteBuffer + ')';
    }

    public boolean equals(Object obj) {
        return m6954equalsimpl(this.buffer, obj);
    }

    public int hashCode() {
        return m6958hashCodeimpl(this.buffer);
    }

    public String toString() {
        return m6965toStringimpl(this.buffer);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ ByteBuffer m6966unboximpl() {
        return this.buffer;
    }

    @DangerousInternalIoApi
    private /* synthetic */ Memory(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
    }

    public final ByteBuffer getBuffer() {
        return this.buffer;
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static final long m6956getSizeimpl(ByteBuffer arg0) {
        Intrinsics.checkNotNullParameter(arg0, "arg0");
        return arg0.limit();
    }

    /* JADX INFO: renamed from: getSize32-impl, reason: not valid java name */
    public static final int m6957getSize32impl(ByteBuffer arg0) {
        Intrinsics.checkNotNullParameter(arg0, "arg0");
        return arg0.limit();
    }

    /* JADX INFO: renamed from: loadAt-impl, reason: not valid java name */
    public static final byte m6959loadAtimpl(ByteBuffer arg0, int i) {
        Intrinsics.checkNotNullParameter(arg0, "arg0");
        return arg0.get(i);
    }

    /* JADX INFO: renamed from: loadAt-impl, reason: not valid java name */
    public static final byte m6960loadAtimpl(ByteBuffer arg0, long j) {
        Intrinsics.checkNotNullParameter(arg0, "arg0");
        if (j < 2147483647L) {
            return arg0.get((int) j);
        }
        NumbersKt.failLongToIntConversion(j, FirebaseAnalytics.Param.INDEX);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: storeAt-impl, reason: not valid java name */
    public static final void m6963storeAtimpl(ByteBuffer arg0, int i, byte b) {
        Intrinsics.checkNotNullParameter(arg0, "arg0");
        arg0.put(i, b);
    }

    /* JADX INFO: renamed from: storeAt-impl, reason: not valid java name */
    public static final void m6964storeAtimpl(ByteBuffer arg0, long j, byte b) {
        Intrinsics.checkNotNullParameter(arg0, "arg0");
        if (j < 2147483647L) {
            arg0.put((int) j, b);
        } else {
            NumbersKt.failLongToIntConversion(j, FirebaseAnalytics.Param.INDEX);
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: slice-SK3TCg8, reason: not valid java name */
    public static final ByteBuffer m6961sliceSK3TCg8(ByteBuffer arg0, int i, int i2) {
        Intrinsics.checkNotNullParameter(arg0, "arg0");
        return m6951constructorimpl(MemoryJvmKt.sliceSafe(arg0, i, i2));
    }

    /* JADX INFO: renamed from: slice-SK3TCg8, reason: not valid java name */
    public static final ByteBuffer m6962sliceSK3TCg8(ByteBuffer arg0, long j, long j2) {
        Intrinsics.checkNotNullParameter(arg0, "arg0");
        if (j >= 2147483647L) {
            NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
            throw new KotlinNothingValueException();
        }
        int i = (int) j;
        if (j2 < 2147483647L) {
            return m6961sliceSK3TCg8(arg0, i, (int) j2);
        }
        NumbersKt.failLongToIntConversion(j2, "length");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: copyTo-f5Ywojk, reason: not valid java name */
    public static final void m6952copyTof5Ywojk(ByteBuffer arg0, ByteBuffer destination, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(arg0, "arg0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (arg0.hasArray() && destination.hasArray() && !arg0.isReadOnly() && !destination.isReadOnly()) {
            System.arraycopy(arg0.array(), arg0.arrayOffset() + i, destination.array(), destination.arrayOffset() + i3, i2);
            return;
        }
        ByteBuffer byteBufferDuplicate = arg0.duplicate();
        ByteBuffer byteBufferDuplicate2 = destination.duplicate();
        byteBufferDuplicate2.put(byteBufferDuplicate);
    }

    /* JADX INFO: renamed from: copyTo-iAfECsU, reason: not valid java name */
    public static final void m6953copyToiAfECsU(ByteBuffer arg0, ByteBuffer destination, long j, long j2, long j3) {
        Intrinsics.checkNotNullParameter(arg0, "arg0");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (j >= 2147483647L) {
            NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
            throw new KotlinNothingValueException();
        }
        int i = (int) j;
        if (j2 >= 2147483647L) {
            NumbersKt.failLongToIntConversion(j2, "length");
            throw new KotlinNothingValueException();
        }
        int i2 = (int) j2;
        if (j3 < 2147483647L) {
            m6952copyTof5Ywojk(arg0, destination, i, i2, (int) j3);
        } else {
            NumbersKt.failLongToIntConversion(j3, "destinationOffset");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: compiled from: MemoryJvm.kt */
    @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\b"}, m5598d2 = {"Lio/ktor/utils/io/bits/Memory$Companion;", "", "()V", "Empty", "Lio/ktor/utils/io/bits/Memory;", "getEmpty-SK3TCg8", "()Ljava/nio/ByteBuffer;", "Ljava/nio/ByteBuffer;", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getEmpty-SK3TCg8, reason: not valid java name */
        public final ByteBuffer m6967getEmptySK3TCg8() {
            return Memory.Empty;
        }
    }

    static {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(0).order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(byteBufferOrder, "allocate(0).order(ByteOrder.BIG_ENDIAN)");
        Empty = m6951constructorimpl(byteBufferOrder);
    }
}
