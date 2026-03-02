package io.ktor.utils.p098io.bits;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;

/* JADX INFO: compiled from: PrimiteArrays.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a;\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000f2\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\n\u001a;\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000f2\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\r\u001a;\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00132\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a;\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00132\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a;\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00192\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a;\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00192\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a;\u0010\u001e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u001f2\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a;\u0010\u001e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u001f2\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a;\u0010$\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00062\b\b\u0002\u0010&\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b'\u0010\n\u001a;\u0010$\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u00062\b\b\u0002\u0010&\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b(\u0010\r\u001a;\u0010)\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010&\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b*\u0010\n\u001a;\u0010)\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010&\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b+\u0010\r\u001a;\u0010,\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00132\b\b\u0002\u0010&\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b-\u0010\u0015\u001a;\u0010,\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u00132\b\b\u0002\u0010&\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b.\u0010\u0017\u001a;\u0010/\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b0\u0010\u001b\u001a;\u0010/\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b1\u0010\u001d\u001a;\u00102\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u001f2\b\b\u0002\u0010&\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b3\u0010!\u001a;\u00102\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u001f2\b\b\u0002\u0010&\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b4\u0010#\u0082\u0002\u0004\n\u0002\b\u0019¨\u00065"}, m5598d2 = {"loadByteArray", "", "Lio/ktor/utils/io/bits/Memory;", TypedValues.CycleType.S_WAVE_OFFSET, "", FirebaseAnalytics.Param.DESTINATION, "", "destinationOffset", NewHtcHomeBadger.COUNT, "loadByteArray-1sQv-GY", "(Ljava/nio/ByteBuffer;I[BII)V", "", "loadByteArray-tS5kjXo", "(Ljava/nio/ByteBuffer;J[BII)V", "loadUByteArray", "Lkotlin/UByteArray;", "loadUByteArray-MNnqWwU", "loadUByteArray-zUZJq0w", "loadUIntArray", "Lkotlin/UIntArray;", "loadUIntArray-c9ghqu0", "(Ljava/nio/ByteBuffer;I[III)V", "loadUIntArray-IiM6BKY", "(Ljava/nio/ByteBuffer;J[III)V", "loadULongArray", "Lkotlin/ULongArray;", "loadULongArray--ReD1cY", "(Ljava/nio/ByteBuffer;I[JII)V", "loadULongArray-LZRIK90", "(Ljava/nio/ByteBuffer;J[JII)V", "loadUShortArray", "Lkotlin/UShortArray;", "loadUShortArray-Fd_0kgM", "(Ljava/nio/ByteBuffer;I[SII)V", "loadUShortArray-ItsHwlw", "(Ljava/nio/ByteBuffer;J[SII)V", "storeByteArray", "source", "sourceOffset", "storeByteArray-1sQv-GY", "storeByteArray-tS5kjXo", "storeUByteArray", "storeUByteArray-MNnqWwU", "storeUByteArray-zUZJq0w", "storeUIntArray", "storeUIntArray-c9ghqu0", "storeUIntArray-IiM6BKY", "storeULongArray", "storeULongArray--ReD1cY", "storeULongArray-LZRIK90", "storeUShortArray", "storeUShortArray-Fd_0kgM", "storeUShortArray-ItsHwlw", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class PrimiteArraysKt {
    /* JADX INFO: renamed from: loadByteArray-1sQv-GY$default, reason: not valid java name */
    public static /* synthetic */ void m7016loadByteArray1sQvGY$default(ByteBuffer loadByteArray, int i, byte[] destination, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = destination.length - i2;
        }
        Intrinsics.checkNotNullParameter(loadByteArray, "$this$loadByteArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        MemoryJvmKt.m6968copyToFs5fovk(loadByteArray, destination, i, i3, i2);
    }

    /* JADX INFO: renamed from: loadByteArray-1sQv-GY, reason: not valid java name */
    public static final void m7015loadByteArray1sQvGY(ByteBuffer loadByteArray, int i, byte[] destination, int i2, int i3) {
        Intrinsics.checkNotNullParameter(loadByteArray, "$this$loadByteArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        MemoryJvmKt.m6968copyToFs5fovk(loadByteArray, destination, i, i3, i2);
    }

    /* JADX INFO: renamed from: loadByteArray-tS5kjXo$default, reason: not valid java name */
    public static /* synthetic */ void m7018loadByteArraytS5kjXo$default(ByteBuffer loadByteArray, long j, byte[] destination, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = destination.length - i4;
        }
        Intrinsics.checkNotNullParameter(loadByteArray, "$this$loadByteArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        MemoryJvmKt.m6970copyToodTdu9Q(loadByteArray, destination, j, i2, i4);
    }

    /* JADX INFO: renamed from: loadByteArray-tS5kjXo, reason: not valid java name */
    public static final void m7017loadByteArraytS5kjXo(ByteBuffer loadByteArray, long j, byte[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(loadByteArray, "$this$loadByteArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        MemoryJvmKt.m6970copyToodTdu9Q(loadByteArray, destination, j, i2, i);
    }

    /* JADX INFO: renamed from: loadUByteArray-MNnqWwU$default, reason: not valid java name */
    public static /* synthetic */ void m7020loadUByteArrayMNnqWwU$default(ByteBuffer loadUByteArray, int i, byte[] destination, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = UByteArray.m7310getSizeimpl(destination) - i2;
        }
        Intrinsics.checkNotNullParameter(loadUByteArray, "$this$loadUByteArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        MemoryJvmKt.m6968copyToFs5fovk(loadUByteArray, destination, i, i3, i2);
    }

    /* JADX INFO: renamed from: loadUByteArray-MNnqWwU, reason: not valid java name */
    public static final void m7019loadUByteArrayMNnqWwU(ByteBuffer loadUByteArray, int i, byte[] destination, int i2, int i3) {
        Intrinsics.checkNotNullParameter(loadUByteArray, "$this$loadUByteArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        MemoryJvmKt.m6968copyToFs5fovk(loadUByteArray, destination, i, i3, i2);
    }

    /* JADX INFO: renamed from: loadUByteArray-zUZJq0w$default, reason: not valid java name */
    public static /* synthetic */ void m7022loadUByteArrayzUZJq0w$default(ByteBuffer loadUByteArray, long j, byte[] destination, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = UByteArray.m7310getSizeimpl(destination) - i4;
        }
        Intrinsics.checkNotNullParameter(loadUByteArray, "$this$loadUByteArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        MemoryJvmKt.m6970copyToodTdu9Q(loadUByteArray, destination, j, i2, i4);
    }

    /* JADX INFO: renamed from: loadUByteArray-zUZJq0w, reason: not valid java name */
    public static final void m7021loadUByteArrayzUZJq0w(ByteBuffer loadUByteArray, long j, byte[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(loadUByteArray, "$this$loadUByteArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        MemoryJvmKt.m6970copyToodTdu9Q(loadUByteArray, destination, j, i2, i);
    }

    /* JADX INFO: renamed from: loadUShortArray-Fd_0kgM$default, reason: not valid java name */
    public static /* synthetic */ void m7032loadUShortArrayFd_0kgM$default(ByteBuffer loadUShortArray, int i, short[] destination, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = UShortArray.m7573getSizeimpl(destination) - i2;
        }
        Intrinsics.checkNotNullParameter(loadUShortArray, "$this$loadUShortArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        PrimitiveArraysJvmKt.m7071loadShortArray96Q0Wk8(loadUShortArray, i, destination, i2, i3);
    }

    /* JADX INFO: renamed from: loadUShortArray-Fd_0kgM, reason: not valid java name */
    public static final void m7031loadUShortArrayFd_0kgM(ByteBuffer loadUShortArray, int i, short[] destination, int i2, int i3) {
        Intrinsics.checkNotNullParameter(loadUShortArray, "$this$loadUShortArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        PrimitiveArraysJvmKt.m7071loadShortArray96Q0Wk8(loadUShortArray, i, destination, i2, i3);
    }

    /* JADX INFO: renamed from: loadUShortArray-ItsHwlw$default, reason: not valid java name */
    public static /* synthetic */ void m7034loadUShortArrayItsHwlw$default(ByteBuffer loadUShortArray, long j, short[] destination, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = UShortArray.m7573getSizeimpl(destination) - i4;
        }
        Intrinsics.checkNotNullParameter(loadUShortArray, "$this$loadUShortArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        PrimitiveArraysJvmKt.m7073loadShortArrayc7X_M7M(loadUShortArray, j, destination, i4, i2);
    }

    /* JADX INFO: renamed from: loadUShortArray-ItsHwlw, reason: not valid java name */
    public static final void m7033loadUShortArrayItsHwlw(ByteBuffer loadUShortArray, long j, short[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(loadUShortArray, "$this$loadUShortArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        PrimitiveArraysJvmKt.m7073loadShortArrayc7X_M7M(loadUShortArray, j, destination, i, i2);
    }

    /* JADX INFO: renamed from: loadUIntArray-c9ghqu0$default, reason: not valid java name */
    public static /* synthetic */ void m7026loadUIntArrayc9ghqu0$default(ByteBuffer loadUIntArray, int i, int[] destination, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = UIntArray.m7389getSizeimpl(destination) - i2;
        }
        Intrinsics.checkNotNullParameter(loadUIntArray, "$this$loadUIntArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        PrimitiveArraysJvmKt.m7063loadIntArrayfL2E08M(loadUIntArray, i, destination, i2, i3);
    }

    /* JADX INFO: renamed from: loadUIntArray-c9ghqu0, reason: not valid java name */
    public static final void m7025loadUIntArrayc9ghqu0(ByteBuffer loadUIntArray, int i, int[] destination, int i2, int i3) {
        Intrinsics.checkNotNullParameter(loadUIntArray, "$this$loadUIntArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        PrimitiveArraysJvmKt.m7063loadIntArrayfL2E08M(loadUIntArray, i, destination, i2, i3);
    }

    /* JADX INFO: renamed from: loadUIntArray-IiM6BKY$default, reason: not valid java name */
    public static /* synthetic */ void m7024loadUIntArrayIiM6BKY$default(ByteBuffer loadUIntArray, long j, int[] destination, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = UIntArray.m7389getSizeimpl(destination) - i4;
        }
        Intrinsics.checkNotNullParameter(loadUIntArray, "$this$loadUIntArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        PrimitiveArraysJvmKt.m7065loadIntArrayyGba50k(loadUIntArray, j, destination, i4, i2);
    }

    /* JADX INFO: renamed from: loadUIntArray-IiM6BKY, reason: not valid java name */
    public static final void m7023loadUIntArrayIiM6BKY(ByteBuffer loadUIntArray, long j, int[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(loadUIntArray, "$this$loadUIntArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        PrimitiveArraysJvmKt.m7065loadIntArrayyGba50k(loadUIntArray, j, destination, i, i2);
    }

    /* JADX INFO: renamed from: loadULongArray--ReD1cY$default, reason: not valid java name */
    public static /* synthetic */ void m7028loadULongArrayReD1cY$default(ByteBuffer loadULongArray, int i, long[] destination, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = ULongArray.m7468getSizeimpl(destination) - i2;
        }
        Intrinsics.checkNotNullParameter(loadULongArray, "$this$loadULongArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        PrimitiveArraysJvmKt.m7069loadLongArrayv7_xXSA(loadULongArray, i, destination, i2, i3);
    }

    /* JADX INFO: renamed from: loadULongArray--ReD1cY, reason: not valid java name */
    public static final void m7027loadULongArrayReD1cY(ByteBuffer loadULongArray, int i, long[] destination, int i2, int i3) {
        Intrinsics.checkNotNullParameter(loadULongArray, "$this$loadULongArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        PrimitiveArraysJvmKt.m7069loadLongArrayv7_xXSA(loadULongArray, i, destination, i2, i3);
    }

    /* JADX INFO: renamed from: loadULongArray-LZRIK90$default, reason: not valid java name */
    public static /* synthetic */ void m7030loadULongArrayLZRIK90$default(ByteBuffer loadULongArray, long j, long[] destination, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = ULongArray.m7468getSizeimpl(destination) - i4;
        }
        Intrinsics.checkNotNullParameter(loadULongArray, "$this$loadULongArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        PrimitiveArraysJvmKt.m7067loadLongArray7oynhWg(loadULongArray, j, destination, i4, i2);
    }

    /* JADX INFO: renamed from: loadULongArray-LZRIK90, reason: not valid java name */
    public static final void m7029loadULongArrayLZRIK90(ByteBuffer loadULongArray, long j, long[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(loadULongArray, "$this$loadULongArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        PrimitiveArraysJvmKt.m7067loadLongArray7oynhWg(loadULongArray, j, destination, i, i2);
    }

    /* JADX INFO: renamed from: storeByteArray-1sQv-GY$default, reason: not valid java name */
    public static /* synthetic */ void m7036storeByteArray1sQvGY$default(ByteBuffer storeByteArray, int i, byte[] source, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = source.length - i2;
        }
        Intrinsics.checkNotNullParameter(storeByteArray, "$this$storeByteArray");
        Intrinsics.checkNotNullParameter(source, "source");
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(source, i2, i3).slice().order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        Memory.m6952copyTof5Ywojk(Memory.m6951constructorimpl(byteBufferOrder), storeByteArray, 0, i3, i);
    }

    /* JADX INFO: renamed from: storeByteArray-tS5kjXo$default, reason: not valid java name */
    public static /* synthetic */ void m7038storeByteArraytS5kjXo$default(ByteBuffer storeByteArray, long j, byte[] source, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = source.length - i;
        }
        Intrinsics.checkNotNullParameter(storeByteArray, "$this$storeByteArray");
        Intrinsics.checkNotNullParameter(source, "source");
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(source, i, i2).slice().order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        Memory.m6953copyToiAfECsU(Memory.m6951constructorimpl(byteBufferOrder), storeByteArray, 0L, i2, j);
    }

    /* JADX INFO: renamed from: storeUByteArray-MNnqWwU$default, reason: not valid java name */
    public static /* synthetic */ void m7040storeUByteArrayMNnqWwU$default(ByteBuffer storeUByteArray, int i, byte[] source, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = UByteArray.m7310getSizeimpl(source) - i2;
        }
        Intrinsics.checkNotNullParameter(storeUByteArray, "$this$storeUByteArray");
        Intrinsics.checkNotNullParameter(source, "source");
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(source, i2, i3).slice().order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        Memory.m6952copyTof5Ywojk(Memory.m6951constructorimpl(byteBufferOrder), storeUByteArray, 0, i3, i);
    }

    /* JADX INFO: renamed from: storeUByteArray-zUZJq0w$default, reason: not valid java name */
    public static /* synthetic */ void m7042storeUByteArrayzUZJq0w$default(ByteBuffer storeUByteArray, long j, byte[] source, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = UByteArray.m7310getSizeimpl(source) - i;
        }
        Intrinsics.checkNotNullParameter(storeUByteArray, "$this$storeUByteArray");
        Intrinsics.checkNotNullParameter(source, "source");
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(source, i, i2).slice().order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        Memory.m6953copyToiAfECsU(Memory.m6951constructorimpl(byteBufferOrder), storeUByteArray, 0L, i2, j);
    }

    /* JADX INFO: renamed from: storeUShortArray-Fd_0kgM$default, reason: not valid java name */
    public static /* synthetic */ void m7052storeUShortArrayFd_0kgM$default(ByteBuffer storeUShortArray, int i, short[] source, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = UShortArray.m7573getSizeimpl(source) - i2;
        }
        Intrinsics.checkNotNullParameter(storeUShortArray, "$this$storeUShortArray");
        Intrinsics.checkNotNullParameter(source, "source");
        PrimitiveArraysJvmKt.m7091storeShortArray96Q0Wk8(storeUShortArray, i, source, i2, i3);
    }

    /* JADX INFO: renamed from: storeUShortArray-Fd_0kgM, reason: not valid java name */
    public static final void m7051storeUShortArrayFd_0kgM(ByteBuffer storeUShortArray, int i, short[] source, int i2, int i3) {
        Intrinsics.checkNotNullParameter(storeUShortArray, "$this$storeUShortArray");
        Intrinsics.checkNotNullParameter(source, "source");
        PrimitiveArraysJvmKt.m7091storeShortArray96Q0Wk8(storeUShortArray, i, source, i2, i3);
    }

    /* JADX INFO: renamed from: storeUShortArray-ItsHwlw$default, reason: not valid java name */
    public static /* synthetic */ void m7054storeUShortArrayItsHwlw$default(ByteBuffer storeUShortArray, long j, short[] source, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = UShortArray.m7573getSizeimpl(source) - i4;
        }
        Intrinsics.checkNotNullParameter(storeUShortArray, "$this$storeUShortArray");
        Intrinsics.checkNotNullParameter(source, "source");
        PrimitiveArraysJvmKt.m7093storeShortArrayc7X_M7M(storeUShortArray, j, source, i4, i2);
    }

    /* JADX INFO: renamed from: storeUShortArray-ItsHwlw, reason: not valid java name */
    public static final void m7053storeUShortArrayItsHwlw(ByteBuffer storeUShortArray, long j, short[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(storeUShortArray, "$this$storeUShortArray");
        Intrinsics.checkNotNullParameter(source, "source");
        PrimitiveArraysJvmKt.m7093storeShortArrayc7X_M7M(storeUShortArray, j, source, i, i2);
    }

    /* JADX INFO: renamed from: storeUIntArray-c9ghqu0$default, reason: not valid java name */
    public static /* synthetic */ void m7046storeUIntArrayc9ghqu0$default(ByteBuffer storeUIntArray, int i, int[] source, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = UIntArray.m7389getSizeimpl(source) - i2;
        }
        Intrinsics.checkNotNullParameter(storeUIntArray, "$this$storeUIntArray");
        Intrinsics.checkNotNullParameter(source, "source");
        PrimitiveArraysJvmKt.m7083storeIntArrayfL2E08M(storeUIntArray, i, source, i2, i3);
    }

    /* JADX INFO: renamed from: storeUIntArray-c9ghqu0, reason: not valid java name */
    public static final void m7045storeUIntArrayc9ghqu0(ByteBuffer storeUIntArray, int i, int[] source, int i2, int i3) {
        Intrinsics.checkNotNullParameter(storeUIntArray, "$this$storeUIntArray");
        Intrinsics.checkNotNullParameter(source, "source");
        PrimitiveArraysJvmKt.m7083storeIntArrayfL2E08M(storeUIntArray, i, source, i2, i3);
    }

    /* JADX INFO: renamed from: storeUIntArray-IiM6BKY$default, reason: not valid java name */
    public static /* synthetic */ void m7044storeUIntArrayIiM6BKY$default(ByteBuffer storeUIntArray, long j, int[] source, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = UIntArray.m7389getSizeimpl(source) - i4;
        }
        Intrinsics.checkNotNullParameter(storeUIntArray, "$this$storeUIntArray");
        Intrinsics.checkNotNullParameter(source, "source");
        PrimitiveArraysJvmKt.m7085storeIntArrayyGba50k(storeUIntArray, j, source, i4, i2);
    }

    /* JADX INFO: renamed from: storeUIntArray-IiM6BKY, reason: not valid java name */
    public static final void m7043storeUIntArrayIiM6BKY(ByteBuffer storeUIntArray, long j, int[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(storeUIntArray, "$this$storeUIntArray");
        Intrinsics.checkNotNullParameter(source, "source");
        PrimitiveArraysJvmKt.m7085storeIntArrayyGba50k(storeUIntArray, j, source, i, i2);
    }

    /* JADX INFO: renamed from: storeULongArray--ReD1cY$default, reason: not valid java name */
    public static /* synthetic */ void m7048storeULongArrayReD1cY$default(ByteBuffer storeULongArray, int i, long[] source, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = ULongArray.m7468getSizeimpl(source) - i2;
        }
        Intrinsics.checkNotNullParameter(storeULongArray, "$this$storeULongArray");
        Intrinsics.checkNotNullParameter(source, "source");
        PrimitiveArraysJvmKt.m7089storeLongArrayv7_xXSA(storeULongArray, i, source, i2, i3);
    }

    /* JADX INFO: renamed from: storeULongArray--ReD1cY, reason: not valid java name */
    public static final void m7047storeULongArrayReD1cY(ByteBuffer storeULongArray, int i, long[] source, int i2, int i3) {
        Intrinsics.checkNotNullParameter(storeULongArray, "$this$storeULongArray");
        Intrinsics.checkNotNullParameter(source, "source");
        PrimitiveArraysJvmKt.m7089storeLongArrayv7_xXSA(storeULongArray, i, source, i2, i3);
    }

    /* JADX INFO: renamed from: storeULongArray-LZRIK90$default, reason: not valid java name */
    public static /* synthetic */ void m7050storeULongArrayLZRIK90$default(ByteBuffer storeULongArray, long j, long[] source, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = ULongArray.m7468getSizeimpl(source) - i4;
        }
        Intrinsics.checkNotNullParameter(storeULongArray, "$this$storeULongArray");
        Intrinsics.checkNotNullParameter(source, "source");
        PrimitiveArraysJvmKt.m7087storeLongArray7oynhWg(storeULongArray, j, source, i4, i2);
    }

    /* JADX INFO: renamed from: storeULongArray-LZRIK90, reason: not valid java name */
    public static final void m7049storeULongArrayLZRIK90(ByteBuffer storeULongArray, long j, long[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(storeULongArray, "$this$storeULongArray");
        Intrinsics.checkNotNullParameter(source, "source");
        PrimitiveArraysJvmKt.m7087storeLongArray7oynhWg(storeULongArray, j, source, i, i2);
    }

    /* JADX INFO: renamed from: storeByteArray-1sQv-GY, reason: not valid java name */
    public static final void m7035storeByteArray1sQvGY(ByteBuffer storeByteArray, int i, byte[] source, int i2, int i3) {
        Intrinsics.checkNotNullParameter(storeByteArray, "$this$storeByteArray");
        Intrinsics.checkNotNullParameter(source, "source");
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(source, i2, i3).slice().order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        Memory.m6952copyTof5Ywojk(Memory.m6951constructorimpl(byteBufferOrder), storeByteArray, 0, i3, i);
    }

    /* JADX INFO: renamed from: storeByteArray-tS5kjXo, reason: not valid java name */
    public static final void m7037storeByteArraytS5kjXo(ByteBuffer storeByteArray, long j, byte[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(storeByteArray, "$this$storeByteArray");
        Intrinsics.checkNotNullParameter(source, "source");
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(source, i, i2).slice().order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        Memory.m6953copyToiAfECsU(Memory.m6951constructorimpl(byteBufferOrder), storeByteArray, 0L, i2, j);
    }

    /* JADX INFO: renamed from: storeUByteArray-MNnqWwU, reason: not valid java name */
    public static final void m7039storeUByteArrayMNnqWwU(ByteBuffer storeUByteArray, int i, byte[] source, int i2, int i3) {
        Intrinsics.checkNotNullParameter(storeUByteArray, "$this$storeUByteArray");
        Intrinsics.checkNotNullParameter(source, "source");
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(source, i2, i3).slice().order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        Memory.m6952copyTof5Ywojk(Memory.m6951constructorimpl(byteBufferOrder), storeUByteArray, 0, i3, i);
    }

    /* JADX INFO: renamed from: storeUByteArray-zUZJq0w, reason: not valid java name */
    public static final void m7041storeUByteArrayzUZJq0w(ByteBuffer storeUByteArray, long j, byte[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(storeUByteArray, "$this$storeUByteArray");
        Intrinsics.checkNotNullParameter(source, "source");
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(source, i, i2).slice().order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        Memory.m6953copyToiAfECsU(Memory.m6951constructorimpl(byteBufferOrder), storeUByteArray, 0L, i2, j);
    }
}
