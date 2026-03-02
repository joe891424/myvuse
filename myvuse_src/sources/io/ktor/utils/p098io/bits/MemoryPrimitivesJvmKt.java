package io.ktor.utils.p098io.bits;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.ktor.utils.p098io.core.internal.NumbersKt;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MemoryPrimitivesJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00004\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u001a\u001a\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001f\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001f\u0010\u0010\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001f\u0010\u0010\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001f\u0010\u0015\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001f\u0010\u0015\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001f\u0010\u001a\u001a\u00020\u001b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001f\u0010\u001a\u001a\u00020\u001b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a'\u0010 \u001a\u00020!*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a'\u0010 \u001a\u00020!*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a'\u0010'\u001a\u00020!*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000bH\u0086\bø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a'\u0010'\u001a\u00020!*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u000bH\u0086\bø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a'\u0010,\u001a\u00020!*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a'\u0010,\u001a\u00020!*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b/\u00100\u001a'\u00101\u001a\u00020!*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a'\u00101\u001a\u00020!*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a'\u00106\u001a\u00020!*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u001bH\u0086\bø\u0001\u0000¢\u0006\u0004\b7\u00108\u001a'\u00106\u001a\u00020!*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u001bH\u0086\bø\u0001\u0000¢\u0006\u0004\b9\u0010:\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006;"}, m5598d2 = {"loadDoubleAt", "", "Lio/ktor/utils/io/bits/Memory;", TypedValues.CycleType.S_WAVE_OFFSET, "", "loadDoubleAt-xtk156I", "(Ljava/nio/ByteBuffer;I)D", "", "loadDoubleAt-pkUVrfw", "(Ljava/nio/ByteBuffer;J)D", "loadFloatAt", "", "loadFloatAt-xtk156I", "(Ljava/nio/ByteBuffer;I)F", "loadFloatAt-pkUVrfw", "(Ljava/nio/ByteBuffer;J)F", "loadIntAt", "loadIntAt-xtk156I", "(Ljava/nio/ByteBuffer;I)I", "loadIntAt-pkUVrfw", "(Ljava/nio/ByteBuffer;J)I", "loadLongAt", "loadLongAt-xtk156I", "(Ljava/nio/ByteBuffer;I)J", "loadLongAt-pkUVrfw", "(Ljava/nio/ByteBuffer;J)J", "loadShortAt", "", "loadShortAt-xtk156I", "(Ljava/nio/ByteBuffer;I)S", "loadShortAt-pkUVrfw", "(Ljava/nio/ByteBuffer;J)S", "storeDoubleAt", "", "value", "storeDoubleAt-Zzg3DGc", "(Ljava/nio/ByteBuffer;ID)V", "storeDoubleAt-KOHjTOE", "(Ljava/nio/ByteBuffer;JD)V", "storeFloatAt", "storeFloatAt-r2iD9jY", "(Ljava/nio/ByteBuffer;IF)V", "storeFloatAt-t3dZL90", "(Ljava/nio/ByteBuffer;JF)V", "storeIntAt", "storeIntAt-5Mw_xsg", "(Ljava/nio/ByteBuffer;II)V", "storeIntAt-Ywqd6oY", "(Ljava/nio/ByteBuffer;JI)V", "storeLongAt", "storeLongAt-USuK2a8", "(Ljava/nio/ByteBuffer;IJ)V", "storeLongAt-PxUP_Lw", "(Ljava/nio/ByteBuffer;JJ)V", "storeShortAt", "storeShortAt-tJtnceY", "(Ljava/nio/ByteBuffer;IS)V", "storeShortAt-zC5p9Kc", "(Ljava/nio/ByteBuffer;JS)V", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class MemoryPrimitivesJvmKt {
    /* JADX INFO: renamed from: loadShortAt-xtk156I, reason: not valid java name */
    public static final short m6992loadShortAtxtk156I(ByteBuffer loadShortAt, int i) {
        Intrinsics.checkNotNullParameter(loadShortAt, "$this$loadShortAt");
        return loadShortAt.getShort(i);
    }

    /* JADX INFO: renamed from: loadShortAt-pkUVrfw, reason: not valid java name */
    public static final short m6991loadShortAtpkUVrfw(ByteBuffer loadShortAt, long j) {
        Intrinsics.checkNotNullParameter(loadShortAt, "$this$loadShortAt");
        if (j < 2147483647L) {
            return loadShortAt.getShort((int) j);
        }
        NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: loadIntAt-xtk156I, reason: not valid java name */
    public static final int m6988loadIntAtxtk156I(ByteBuffer loadIntAt, int i) {
        Intrinsics.checkNotNullParameter(loadIntAt, "$this$loadIntAt");
        return loadIntAt.getInt(i);
    }

    /* JADX INFO: renamed from: loadIntAt-pkUVrfw, reason: not valid java name */
    public static final int m6987loadIntAtpkUVrfw(ByteBuffer loadIntAt, long j) {
        Intrinsics.checkNotNullParameter(loadIntAt, "$this$loadIntAt");
        if (j < 2147483647L) {
            return loadIntAt.getInt((int) j);
        }
        NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: loadLongAt-xtk156I, reason: not valid java name */
    public static final long m6990loadLongAtxtk156I(ByteBuffer loadLongAt, int i) {
        Intrinsics.checkNotNullParameter(loadLongAt, "$this$loadLongAt");
        return loadLongAt.getLong(i);
    }

    /* JADX INFO: renamed from: loadLongAt-pkUVrfw, reason: not valid java name */
    public static final long m6989loadLongAtpkUVrfw(ByteBuffer loadLongAt, long j) {
        Intrinsics.checkNotNullParameter(loadLongAt, "$this$loadLongAt");
        if (j < 2147483647L) {
            return loadLongAt.getLong((int) j);
        }
        NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: loadFloatAt-xtk156I, reason: not valid java name */
    public static final float m6986loadFloatAtxtk156I(ByteBuffer loadFloatAt, int i) {
        Intrinsics.checkNotNullParameter(loadFloatAt, "$this$loadFloatAt");
        return loadFloatAt.getFloat(i);
    }

    /* JADX INFO: renamed from: loadFloatAt-pkUVrfw, reason: not valid java name */
    public static final float m6985loadFloatAtpkUVrfw(ByteBuffer loadFloatAt, long j) {
        Intrinsics.checkNotNullParameter(loadFloatAt, "$this$loadFloatAt");
        if (j < 2147483647L) {
            return loadFloatAt.getFloat((int) j);
        }
        NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: loadDoubleAt-xtk156I, reason: not valid java name */
    public static final double m6984loadDoubleAtxtk156I(ByteBuffer loadDoubleAt, int i) {
        Intrinsics.checkNotNullParameter(loadDoubleAt, "$this$loadDoubleAt");
        return loadDoubleAt.getDouble(i);
    }

    /* JADX INFO: renamed from: loadDoubleAt-pkUVrfw, reason: not valid java name */
    public static final double m6983loadDoubleAtpkUVrfw(ByteBuffer loadDoubleAt, long j) {
        Intrinsics.checkNotNullParameter(loadDoubleAt, "$this$loadDoubleAt");
        if (j < 2147483647L) {
            return loadDoubleAt.getDouble((int) j);
        }
        NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: storeIntAt-5Mw_xsg, reason: not valid java name */
    public static final void m6997storeIntAt5Mw_xsg(ByteBuffer storeIntAt, int i, int i2) {
        Intrinsics.checkNotNullParameter(storeIntAt, "$this$storeIntAt");
        storeIntAt.putInt(i, i2);
    }

    /* JADX INFO: renamed from: storeShortAt-tJtnceY, reason: not valid java name */
    public static final void m7001storeShortAttJtnceY(ByteBuffer storeShortAt, int i, short s) {
        Intrinsics.checkNotNullParameter(storeShortAt, "$this$storeShortAt");
        storeShortAt.putShort(i, s);
    }

    /* JADX INFO: renamed from: storeLongAt-USuK2a8, reason: not valid java name */
    public static final void m7000storeLongAtUSuK2a8(ByteBuffer storeLongAt, int i, long j) {
        Intrinsics.checkNotNullParameter(storeLongAt, "$this$storeLongAt");
        storeLongAt.putLong(i, j);
    }

    /* JADX INFO: renamed from: storeFloatAt-r2iD9jY, reason: not valid java name */
    public static final void m6995storeFloatAtr2iD9jY(ByteBuffer storeFloatAt, int i, float f) {
        Intrinsics.checkNotNullParameter(storeFloatAt, "$this$storeFloatAt");
        storeFloatAt.putFloat(i, f);
    }

    /* JADX INFO: renamed from: storeDoubleAt-Zzg3DGc, reason: not valid java name */
    public static final void m6994storeDoubleAtZzg3DGc(ByteBuffer storeDoubleAt, int i, double d) {
        Intrinsics.checkNotNullParameter(storeDoubleAt, "$this$storeDoubleAt");
        storeDoubleAt.putDouble(i, d);
    }

    /* JADX INFO: renamed from: storeIntAt-Ywqd6oY, reason: not valid java name */
    public static final void m6998storeIntAtYwqd6oY(ByteBuffer storeIntAt, long j, int i) {
        Intrinsics.checkNotNullParameter(storeIntAt, "$this$storeIntAt");
        if (j >= 2147483647L) {
            NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
            throw new KotlinNothingValueException();
        }
        storeIntAt.putInt((int) j, i);
    }

    /* JADX INFO: renamed from: storeShortAt-zC5p9Kc, reason: not valid java name */
    public static final void m7002storeShortAtzC5p9Kc(ByteBuffer storeShortAt, long j, short s) {
        Intrinsics.checkNotNullParameter(storeShortAt, "$this$storeShortAt");
        if (j >= 2147483647L) {
            NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
            throw new KotlinNothingValueException();
        }
        storeShortAt.putShort((int) j, s);
    }

    /* JADX INFO: renamed from: storeLongAt-PxUP_Lw, reason: not valid java name */
    public static final void m6999storeLongAtPxUP_Lw(ByteBuffer storeLongAt, long j, long j2) {
        Intrinsics.checkNotNullParameter(storeLongAt, "$this$storeLongAt");
        if (j >= 2147483647L) {
            NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
            throw new KotlinNothingValueException();
        }
        storeLongAt.putLong((int) j, j2);
    }

    /* JADX INFO: renamed from: storeFloatAt-t3dZL90, reason: not valid java name */
    public static final void m6996storeFloatAtt3dZL90(ByteBuffer storeFloatAt, long j, float f) {
        Intrinsics.checkNotNullParameter(storeFloatAt, "$this$storeFloatAt");
        if (j >= 2147483647L) {
            NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
            throw new KotlinNothingValueException();
        }
        storeFloatAt.putFloat((int) j, f);
    }

    /* JADX INFO: renamed from: storeDoubleAt-KOHjTOE, reason: not valid java name */
    public static final void m6993storeDoubleAtKOHjTOE(ByteBuffer storeDoubleAt, long j, double d) {
        Intrinsics.checkNotNullParameter(storeDoubleAt, "$this$storeDoubleAt");
        if (j >= 2147483647L) {
            NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
            throw new KotlinNothingValueException();
        }
        storeDoubleAt.putDouble((int) j, d);
    }
}
