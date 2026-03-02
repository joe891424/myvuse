package io.ktor.utils.p098io.bits;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.ktor.utils.p098io.core.internal.NumbersKt;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MemoryPrimitives.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001f\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001f\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001f\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a'\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a'\u0010\u001d\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a'\u0010\u001d\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000bH\u0086\bø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a'\u0010\"\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0011H\u0086\bø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a'\u0010\"\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0011H\u0086\bø\u0001\u0000¢\u0006\u0004\b%\u0010&\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, m5598d2 = {"loadUIntAt", "Lkotlin/UInt;", "Lio/ktor/utils/io/bits/Memory;", TypedValues.CycleType.S_WAVE_OFFSET, "", "loadUIntAt-xtk156I", "(Ljava/nio/ByteBuffer;I)I", "", "loadUIntAt-pkUVrfw", "(Ljava/nio/ByteBuffer;J)I", "loadULongAt", "Lkotlin/ULong;", "loadULongAt-xtk156I", "(Ljava/nio/ByteBuffer;I)J", "loadULongAt-pkUVrfw", "(Ljava/nio/ByteBuffer;J)J", "loadUShortAt", "Lkotlin/UShort;", "loadUShortAt-xtk156I", "(Ljava/nio/ByteBuffer;I)S", "loadUShortAt-pkUVrfw", "(Ljava/nio/ByteBuffer;J)S", "storeUIntAt", "", "value", "storeUIntAt-sLALDiY", "(Ljava/nio/ByteBuffer;II)V", "storeUIntAt-0Rnu8j8", "(Ljava/nio/ByteBuffer;JI)V", "storeULongAt", "storeULongAt-K5D3Yio", "(Ljava/nio/ByteBuffer;IJ)V", "storeULongAt-vUOAiV4", "(Ljava/nio/ByteBuffer;JJ)V", "storeUShortAt", "storeUShortAt-OsIYvYc", "(Ljava/nio/ByteBuffer;IS)V", "storeUShortAt-_uj5-7g", "(Ljava/nio/ByteBuffer;JS)V", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class MemoryPrimitivesKt {
    /* JADX INFO: renamed from: loadUShortAt-xtk156I, reason: not valid java name */
    public static final short m7008loadUShortAtxtk156I(ByteBuffer loadUShortAt, int i) {
        Intrinsics.checkNotNullParameter(loadUShortAt, "$this$loadUShortAt");
        return UShort.m7514constructorimpl(loadUShortAt.getShort(i));
    }

    /* JADX INFO: renamed from: loadUShortAt-pkUVrfw, reason: not valid java name */
    public static final short m7007loadUShortAtpkUVrfw(ByteBuffer loadUShortAt, long j) {
        Intrinsics.checkNotNullParameter(loadUShortAt, "$this$loadUShortAt");
        if (j < 2147483647L) {
            return UShort.m7514constructorimpl(loadUShortAt.getShort((int) j));
        }
        NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: storeUShortAt-OsIYvYc, reason: not valid java name */
    public static final void m7013storeUShortAtOsIYvYc(ByteBuffer storeUShortAt, int i, short s) {
        Intrinsics.checkNotNullParameter(storeUShortAt, "$this$storeUShortAt");
        storeUShortAt.putShort(i, s);
    }

    /* JADX INFO: renamed from: storeUShortAt-_uj5-7g, reason: not valid java name */
    public static final void m7014storeUShortAt_uj57g(ByteBuffer storeUShortAt, long j, short s) {
        Intrinsics.checkNotNullParameter(storeUShortAt, "$this$storeUShortAt");
        if (j >= 2147483647L) {
            NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
            throw new KotlinNothingValueException();
        }
        storeUShortAt.putShort((int) j, s);
    }

    /* JADX INFO: renamed from: loadUIntAt-xtk156I, reason: not valid java name */
    public static final int m7004loadUIntAtxtk156I(ByteBuffer loadUIntAt, int i) {
        Intrinsics.checkNotNullParameter(loadUIntAt, "$this$loadUIntAt");
        return UInt.m7328constructorimpl(loadUIntAt.getInt(i));
    }

    /* JADX INFO: renamed from: loadUIntAt-pkUVrfw, reason: not valid java name */
    public static final int m7003loadUIntAtpkUVrfw(ByteBuffer loadUIntAt, long j) {
        Intrinsics.checkNotNullParameter(loadUIntAt, "$this$loadUIntAt");
        if (j < 2147483647L) {
            return UInt.m7328constructorimpl(loadUIntAt.getInt((int) j));
        }
        NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: storeUIntAt-sLALDiY, reason: not valid java name */
    public static final void m7010storeUIntAtsLALDiY(ByteBuffer storeUIntAt, int i, int i2) {
        Intrinsics.checkNotNullParameter(storeUIntAt, "$this$storeUIntAt");
        storeUIntAt.putInt(i, i2);
    }

    /* JADX INFO: renamed from: storeUIntAt-0Rnu8j8, reason: not valid java name */
    public static final void m7009storeUIntAt0Rnu8j8(ByteBuffer storeUIntAt, long j, int i) {
        Intrinsics.checkNotNullParameter(storeUIntAt, "$this$storeUIntAt");
        if (j >= 2147483647L) {
            NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
            throw new KotlinNothingValueException();
        }
        storeUIntAt.putInt((int) j, i);
    }

    /* JADX INFO: renamed from: loadULongAt-xtk156I, reason: not valid java name */
    public static final long m7006loadULongAtxtk156I(ByteBuffer loadULongAt, int i) {
        Intrinsics.checkNotNullParameter(loadULongAt, "$this$loadULongAt");
        return ULong.m7407constructorimpl(loadULongAt.getLong(i));
    }

    /* JADX INFO: renamed from: loadULongAt-pkUVrfw, reason: not valid java name */
    public static final long m7005loadULongAtpkUVrfw(ByteBuffer loadULongAt, long j) {
        Intrinsics.checkNotNullParameter(loadULongAt, "$this$loadULongAt");
        if (j < 2147483647L) {
            return ULong.m7407constructorimpl(loadULongAt.getLong((int) j));
        }
        NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: storeULongAt-K5D3Yio, reason: not valid java name */
    public static final void m7011storeULongAtK5D3Yio(ByteBuffer storeULongAt, int i, long j) {
        Intrinsics.checkNotNullParameter(storeULongAt, "$this$storeULongAt");
        storeULongAt.putLong(i, j);
    }

    /* JADX INFO: renamed from: storeULongAt-vUOAiV4, reason: not valid java name */
    public static final void m7012storeULongAtvUOAiV4(ByteBuffer storeULongAt, long j, long j2) {
        Intrinsics.checkNotNullParameter(storeULongAt, "$this$storeULongAt");
        if (j >= 2147483647L) {
            NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
            throw new KotlinNothingValueException();
        }
        storeULongAt.putLong((int) j, j2);
    }
}
