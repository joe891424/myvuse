package io.ktor.utils.p098io.bits;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.utils.p098io.core.internal.NumbersKt;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;

/* JADX INFO: compiled from: PrimitiveArraysJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0005\n\u0002\u0010\u0017\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a8\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a8\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000f2\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a8\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000f2\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a8\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00152\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a8\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00152\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a8\u0010\u001a\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u001b2\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a8\u0010\u001a\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u001b2\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a8\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020!2\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a8\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020!2\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a8\u0010&\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b)\u0010\n\u001a8\u0010&\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b*\u0010\r\u001a8\u0010+\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u000f2\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b,\u0010\u0011\u001a8\u0010+\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000f2\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b-\u0010\u0013\u001a8\u0010.\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00152\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0017\u001a8\u0010.\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u00152\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0019\u001a8\u00101\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u001b2\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b2\u0010\u001d\u001a8\u00101\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u001b2\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b3\u0010\u001f\u001a8\u00104\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010'\u001a\u00020!2\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b5\u0010#\u001a8\u00104\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020!2\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b6\u0010%\u001a\u0015\u00107\u001a\u000208*\u0002082\u0006\u0010\u0003\u001a\u00020\u0004H\u0082\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u00069"}, m5598d2 = {"loadDoubleArray", "", "Lio/ktor/utils/io/bits/Memory;", TypedValues.CycleType.S_WAVE_OFFSET, "", FirebaseAnalytics.Param.DESTINATION, "", "destinationOffset", NewHtcHomeBadger.COUNT, "loadDoubleArray-KUjKYZc", "(Ljava/nio/ByteBuffer;I[DII)V", "", "loadDoubleArray-XWWvNjo", "(Ljava/nio/ByteBuffer;J[DII)V", "loadFloatArray", "", "loadFloatArray-4iahAcY", "(Ljava/nio/ByteBuffer;I[FII)V", "loadFloatArray-ECwikis", "(Ljava/nio/ByteBuffer;J[FII)V", "loadIntArray", "", "loadIntArray-fL2E08M", "(Ljava/nio/ByteBuffer;I[III)V", "loadIntArray-yGba50k", "(Ljava/nio/ByteBuffer;J[III)V", "loadLongArray", "", "loadLongArray-v7_xXSA", "(Ljava/nio/ByteBuffer;I[JII)V", "loadLongArray-7oynhWg", "(Ljava/nio/ByteBuffer;J[JII)V", "loadShortArray", "", "loadShortArray-96Q0Wk8", "(Ljava/nio/ByteBuffer;I[SII)V", "loadShortArray-c7X_M7M", "(Ljava/nio/ByteBuffer;J[SII)V", "storeDoubleArray", "source", "sourceOffset", "storeDoubleArray-KUjKYZc", "storeDoubleArray-XWWvNjo", "storeFloatArray", "storeFloatArray-4iahAcY", "storeFloatArray-ECwikis", "storeIntArray", "storeIntArray-fL2E08M", "storeIntArray-yGba50k", "storeLongArray", "storeLongArray-v7_xXSA", "storeLongArray-7oynhWg", "storeShortArray", "storeShortArray-96Q0Wk8", "storeShortArray-c7X_M7M", "withOffset", "Ljava/nio/ByteBuffer;", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class PrimitiveArraysJvmKt {
    /* JADX INFO: renamed from: loadShortArray-c7X_M7M, reason: not valid java name */
    public static final void m7073loadShortArrayc7X_M7M(ByteBuffer loadShortArray, long j, short[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(loadShortArray, "$this$loadShortArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (j < 2147483647L) {
            m7071loadShortArray96Q0Wk8(loadShortArray, (int) j, destination, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: loadIntArray-yGba50k, reason: not valid java name */
    public static final void m7065loadIntArrayyGba50k(ByteBuffer loadIntArray, long j, int[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(loadIntArray, "$this$loadIntArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (j < 2147483647L) {
            m7063loadIntArrayfL2E08M(loadIntArray, (int) j, destination, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: loadShortArray-96Q0Wk8$default, reason: not valid java name */
    public static /* synthetic */ void m7072loadShortArray96Q0Wk8$default(ByteBuffer byteBuffer, int i, short[] sArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = sArr.length - i2;
        }
        m7071loadShortArray96Q0Wk8(byteBuffer, i, sArr, i2, i3);
    }

    /* JADX INFO: renamed from: loadShortArray-c7X_M7M$default, reason: not valid java name */
    public static /* synthetic */ void m7074loadShortArrayc7X_M7M$default(ByteBuffer byteBuffer, long j, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = sArr.length - i4;
        }
        m7073loadShortArrayc7X_M7M(byteBuffer, j, sArr, i4, i2);
    }

    /* JADX INFO: renamed from: loadLongArray-7oynhWg, reason: not valid java name */
    public static final void m7067loadLongArray7oynhWg(ByteBuffer loadLongArray, long j, long[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(loadLongArray, "$this$loadLongArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (j < 2147483647L) {
            m7069loadLongArrayv7_xXSA(loadLongArray, (int) j, destination, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: loadFloatArray-ECwikis, reason: not valid java name */
    public static final void m7061loadFloatArrayECwikis(ByteBuffer loadFloatArray, long j, float[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(loadFloatArray, "$this$loadFloatArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (j < 2147483647L) {
            m7059loadFloatArray4iahAcY(loadFloatArray, (int) j, destination, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: loadIntArray-fL2E08M$default, reason: not valid java name */
    public static /* synthetic */ void m7064loadIntArrayfL2E08M$default(ByteBuffer byteBuffer, int i, int[] iArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = iArr.length - i2;
        }
        m7063loadIntArrayfL2E08M(byteBuffer, i, iArr, i2, i3);
    }

    /* JADX INFO: renamed from: loadIntArray-yGba50k$default, reason: not valid java name */
    public static /* synthetic */ void m7066loadIntArrayyGba50k$default(ByteBuffer byteBuffer, long j, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = iArr.length - i4;
        }
        m7065loadIntArrayyGba50k(byteBuffer, j, iArr, i4, i2);
    }

    /* JADX INFO: renamed from: loadDoubleArray-XWWvNjo, reason: not valid java name */
    public static final void m7057loadDoubleArrayXWWvNjo(ByteBuffer loadDoubleArray, long j, double[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(loadDoubleArray, "$this$loadDoubleArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (j < 2147483647L) {
            m7055loadDoubleArrayKUjKYZc(loadDoubleArray, (int) j, destination, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: storeShortArray-c7X_M7M, reason: not valid java name */
    public static final void m7093storeShortArrayc7X_M7M(ByteBuffer storeShortArray, long j, short[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(storeShortArray, "$this$storeShortArray");
        Intrinsics.checkNotNullParameter(source, "source");
        if (j < 2147483647L) {
            m7091storeShortArray96Q0Wk8(storeShortArray, (int) j, source, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: loadLongArray-v7_xXSA$default, reason: not valid java name */
    public static /* synthetic */ void m7070loadLongArrayv7_xXSA$default(ByteBuffer byteBuffer, int i, long[] jArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = jArr.length - i2;
        }
        m7069loadLongArrayv7_xXSA(byteBuffer, i, jArr, i2, i3);
    }

    /* JADX INFO: renamed from: loadLongArray-7oynhWg$default, reason: not valid java name */
    public static /* synthetic */ void m7068loadLongArray7oynhWg$default(ByteBuffer byteBuffer, long j, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = jArr.length - i4;
        }
        m7067loadLongArray7oynhWg(byteBuffer, j, jArr, i4, i2);
    }

    /* JADX INFO: renamed from: storeIntArray-yGba50k, reason: not valid java name */
    public static final void m7085storeIntArrayyGba50k(ByteBuffer storeIntArray, long j, int[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(storeIntArray, "$this$storeIntArray");
        Intrinsics.checkNotNullParameter(source, "source");
        if (j < 2147483647L) {
            m7083storeIntArrayfL2E08M(storeIntArray, (int) j, source, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: storeLongArray-7oynhWg, reason: not valid java name */
    public static final void m7087storeLongArray7oynhWg(ByteBuffer storeLongArray, long j, long[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(storeLongArray, "$this$storeLongArray");
        Intrinsics.checkNotNullParameter(source, "source");
        if (j < 2147483647L) {
            m7089storeLongArrayv7_xXSA(storeLongArray, (int) j, source, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: loadFloatArray-4iahAcY$default, reason: not valid java name */
    public static /* synthetic */ void m7060loadFloatArray4iahAcY$default(ByteBuffer byteBuffer, int i, float[] fArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = fArr.length - i2;
        }
        m7059loadFloatArray4iahAcY(byteBuffer, i, fArr, i2, i3);
    }

    /* JADX INFO: renamed from: storeFloatArray-ECwikis, reason: not valid java name */
    public static final void m7081storeFloatArrayECwikis(ByteBuffer storeFloatArray, long j, float[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(storeFloatArray, "$this$storeFloatArray");
        Intrinsics.checkNotNullParameter(source, "source");
        if (j < 2147483647L) {
            m7079storeFloatArray4iahAcY(storeFloatArray, (int) j, source, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: loadFloatArray-ECwikis$default, reason: not valid java name */
    public static /* synthetic */ void m7062loadFloatArrayECwikis$default(ByteBuffer byteBuffer, long j, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = fArr.length - i4;
        }
        m7061loadFloatArrayECwikis(byteBuffer, j, fArr, i4, i2);
    }

    /* JADX INFO: renamed from: loadDoubleArray-KUjKYZc$default, reason: not valid java name */
    public static /* synthetic */ void m7056loadDoubleArrayKUjKYZc$default(ByteBuffer byteBuffer, int i, double[] dArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = dArr.length - i2;
        }
        m7055loadDoubleArrayKUjKYZc(byteBuffer, i, dArr, i2, i3);
    }

    /* JADX INFO: renamed from: storeDoubleArray-XWWvNjo, reason: not valid java name */
    public static final void m7077storeDoubleArrayXWWvNjo(ByteBuffer storeDoubleArray, long j, double[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(storeDoubleArray, "$this$storeDoubleArray");
        Intrinsics.checkNotNullParameter(source, "source");
        if (j < 2147483647L) {
            m7075storeDoubleArrayKUjKYZc(storeDoubleArray, (int) j, source, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, TypedValues.CycleType.S_WAVE_OFFSET);
            throw new KotlinNothingValueException();
        }
    }

    private static final ByteBuffer withOffset(ByteBuffer byteBuffer, int i) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        Intrinsics.checkNotNull(byteBufferDuplicate);
        return byteBufferDuplicate;
    }

    /* JADX INFO: renamed from: loadDoubleArray-XWWvNjo$default, reason: not valid java name */
    public static /* synthetic */ void m7058loadDoubleArrayXWWvNjo$default(ByteBuffer byteBuffer, long j, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = dArr.length - i4;
        }
        m7057loadDoubleArrayXWWvNjo(byteBuffer, j, dArr, i4, i2);
    }

    /* JADX INFO: renamed from: storeDoubleArray-KUjKYZc$default, reason: not valid java name */
    public static /* synthetic */ void m7076storeDoubleArrayKUjKYZc$default(ByteBuffer byteBuffer, int i, double[] dArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = dArr.length - i2;
        }
        m7075storeDoubleArrayKUjKYZc(byteBuffer, i, dArr, i2, i3);
    }

    /* JADX INFO: renamed from: storeDoubleArray-XWWvNjo$default, reason: not valid java name */
    public static /* synthetic */ void m7078storeDoubleArrayXWWvNjo$default(ByteBuffer byteBuffer, long j, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = dArr.length - i4;
        }
        m7077storeDoubleArrayXWWvNjo(byteBuffer, j, dArr, i4, i2);
    }

    /* JADX INFO: renamed from: storeFloatArray-4iahAcY$default, reason: not valid java name */
    public static /* synthetic */ void m7080storeFloatArray4iahAcY$default(ByteBuffer byteBuffer, int i, float[] fArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = fArr.length - i2;
        }
        m7079storeFloatArray4iahAcY(byteBuffer, i, fArr, i2, i3);
    }

    /* JADX INFO: renamed from: storeFloatArray-ECwikis$default, reason: not valid java name */
    public static /* synthetic */ void m7082storeFloatArrayECwikis$default(ByteBuffer byteBuffer, long j, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = fArr.length - i4;
        }
        m7081storeFloatArrayECwikis(byteBuffer, j, fArr, i4, i2);
    }

    /* JADX INFO: renamed from: storeIntArray-fL2E08M$default, reason: not valid java name */
    public static /* synthetic */ void m7084storeIntArrayfL2E08M$default(ByteBuffer byteBuffer, int i, int[] iArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = iArr.length - i2;
        }
        m7083storeIntArrayfL2E08M(byteBuffer, i, iArr, i2, i3);
    }

    /* JADX INFO: renamed from: storeIntArray-yGba50k$default, reason: not valid java name */
    public static /* synthetic */ void m7086storeIntArrayyGba50k$default(ByteBuffer byteBuffer, long j, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = iArr.length - i4;
        }
        m7085storeIntArrayyGba50k(byteBuffer, j, iArr, i4, i2);
    }

    /* JADX INFO: renamed from: storeLongArray-7oynhWg$default, reason: not valid java name */
    public static /* synthetic */ void m7088storeLongArray7oynhWg$default(ByteBuffer byteBuffer, long j, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = jArr.length - i4;
        }
        m7087storeLongArray7oynhWg(byteBuffer, j, jArr, i4, i2);
    }

    /* JADX INFO: renamed from: storeLongArray-v7_xXSA$default, reason: not valid java name */
    public static /* synthetic */ void m7090storeLongArrayv7_xXSA$default(ByteBuffer byteBuffer, int i, long[] jArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = jArr.length - i2;
        }
        m7089storeLongArrayv7_xXSA(byteBuffer, i, jArr, i2, i3);
    }

    /* JADX INFO: renamed from: storeShortArray-96Q0Wk8$default, reason: not valid java name */
    public static /* synthetic */ void m7092storeShortArray96Q0Wk8$default(ByteBuffer byteBuffer, int i, short[] sArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = sArr.length - i2;
        }
        m7091storeShortArray96Q0Wk8(byteBuffer, i, sArr, i2, i3);
    }

    /* JADX INFO: renamed from: storeShortArray-c7X_M7M$default, reason: not valid java name */
    public static /* synthetic */ void m7094storeShortArrayc7X_M7M$default(ByteBuffer byteBuffer, long j, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = sArr.length - i4;
        }
        m7093storeShortArrayc7X_M7M(byteBuffer, j, sArr, i4, i2);
    }

    /* JADX INFO: renamed from: loadShortArray-96Q0Wk8, reason: not valid java name */
    public static final void m7071loadShortArray96Q0Wk8(ByteBuffer loadShortArray, int i, short[] destination, int i2, int i3) {
        Intrinsics.checkNotNullParameter(loadShortArray, "$this$loadShortArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        ByteBuffer byteBufferDuplicate = loadShortArray.duplicate();
        Intrinsics.checkNotNull(byteBufferDuplicate);
        byteBufferDuplicate.asShortBuffer().get(destination, i2, i3);
    }

    /* JADX INFO: renamed from: loadIntArray-fL2E08M, reason: not valid java name */
    public static final void m7063loadIntArrayfL2E08M(ByteBuffer loadIntArray, int i, int[] destination, int i2, int i3) {
        Intrinsics.checkNotNullParameter(loadIntArray, "$this$loadIntArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        ByteBuffer byteBufferDuplicate = loadIntArray.duplicate();
        Intrinsics.checkNotNull(byteBufferDuplicate);
        byteBufferDuplicate.asIntBuffer().get(destination, i2, i3);
    }

    /* JADX INFO: renamed from: loadLongArray-v7_xXSA, reason: not valid java name */
    public static final void m7069loadLongArrayv7_xXSA(ByteBuffer loadLongArray, int i, long[] destination, int i2, int i3) {
        Intrinsics.checkNotNullParameter(loadLongArray, "$this$loadLongArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        ByteBuffer byteBufferDuplicate = loadLongArray.duplicate();
        Intrinsics.checkNotNull(byteBufferDuplicate);
        byteBufferDuplicate.asLongBuffer().get(destination, i2, i3);
    }

    /* JADX INFO: renamed from: loadFloatArray-4iahAcY, reason: not valid java name */
    public static final void m7059loadFloatArray4iahAcY(ByteBuffer loadFloatArray, int i, float[] destination, int i2, int i3) {
        Intrinsics.checkNotNullParameter(loadFloatArray, "$this$loadFloatArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        ByteBuffer byteBufferDuplicate = loadFloatArray.duplicate();
        Intrinsics.checkNotNull(byteBufferDuplicate);
        byteBufferDuplicate.asFloatBuffer().get(destination, i2, i3);
    }

    /* JADX INFO: renamed from: loadDoubleArray-KUjKYZc, reason: not valid java name */
    public static final void m7055loadDoubleArrayKUjKYZc(ByteBuffer loadDoubleArray, int i, double[] destination, int i2, int i3) {
        Intrinsics.checkNotNullParameter(loadDoubleArray, "$this$loadDoubleArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        ByteBuffer byteBufferDuplicate = loadDoubleArray.duplicate();
        Intrinsics.checkNotNull(byteBufferDuplicate);
        byteBufferDuplicate.asDoubleBuffer().get(destination, i2, i3);
    }

    /* JADX INFO: renamed from: storeShortArray-96Q0Wk8, reason: not valid java name */
    public static final void m7091storeShortArray96Q0Wk8(ByteBuffer storeShortArray, int i, short[] source, int i2, int i3) {
        Intrinsics.checkNotNullParameter(storeShortArray, "$this$storeShortArray");
        Intrinsics.checkNotNullParameter(source, "source");
        ByteBuffer byteBufferDuplicate = storeShortArray.duplicate();
        Intrinsics.checkNotNull(byteBufferDuplicate);
        byteBufferDuplicate.asShortBuffer().put(source, i2, i3);
    }

    /* JADX INFO: renamed from: storeIntArray-fL2E08M, reason: not valid java name */
    public static final void m7083storeIntArrayfL2E08M(ByteBuffer storeIntArray, int i, int[] source, int i2, int i3) {
        Intrinsics.checkNotNullParameter(storeIntArray, "$this$storeIntArray");
        Intrinsics.checkNotNullParameter(source, "source");
        ByteBuffer byteBufferDuplicate = storeIntArray.duplicate();
        Intrinsics.checkNotNull(byteBufferDuplicate);
        byteBufferDuplicate.asIntBuffer().put(source, i2, i3);
    }

    /* JADX INFO: renamed from: storeLongArray-v7_xXSA, reason: not valid java name */
    public static final void m7089storeLongArrayv7_xXSA(ByteBuffer storeLongArray, int i, long[] source, int i2, int i3) {
        Intrinsics.checkNotNullParameter(storeLongArray, "$this$storeLongArray");
        Intrinsics.checkNotNullParameter(source, "source");
        ByteBuffer byteBufferDuplicate = storeLongArray.duplicate();
        Intrinsics.checkNotNull(byteBufferDuplicate);
        byteBufferDuplicate.asLongBuffer().put(source, i2, i3);
    }

    /* JADX INFO: renamed from: storeFloatArray-4iahAcY, reason: not valid java name */
    public static final void m7079storeFloatArray4iahAcY(ByteBuffer storeFloatArray, int i, float[] source, int i2, int i3) {
        Intrinsics.checkNotNullParameter(storeFloatArray, "$this$storeFloatArray");
        Intrinsics.checkNotNullParameter(source, "source");
        ByteBuffer byteBufferDuplicate = storeFloatArray.duplicate();
        Intrinsics.checkNotNull(byteBufferDuplicate);
        byteBufferDuplicate.asFloatBuffer().put(source, i2, i3);
    }

    /* JADX INFO: renamed from: storeDoubleArray-KUjKYZc, reason: not valid java name */
    public static final void m7075storeDoubleArrayKUjKYZc(ByteBuffer storeDoubleArray, int i, double[] source, int i2, int i3) {
        Intrinsics.checkNotNullParameter(storeDoubleArray, "$this$storeDoubleArray");
        Intrinsics.checkNotNullParameter(source, "source");
        ByteBuffer byteBufferDuplicate = storeDoubleArray.duplicate();
        Intrinsics.checkNotNull(byteBufferDuplicate);
        byteBufferDuplicate.asDoubleBuffer().put(source, i2, i3);
    }
}
