package io.ktor.utils.p098io.bits;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.utils.p098io.core.internal.NumbersKt;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Memory.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001f\u0010\r\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0086\nø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001f\u0010\r\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\nH\u0086\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a'\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000eH\u0086\nø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a'\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u000eH\u0086\nø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a'\u0010\u001a\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u001bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0017\u001a'\u0010\u001a\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u001bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, m5598d2 = {"copyTo", "", "Lio/ktor/utils/io/bits/Memory;", FirebaseAnalytics.Param.DESTINATION, "", TypedValues.CycleType.S_WAVE_OFFSET, "", "length", "copyTo-ylBjBJw", "(Ljava/nio/ByteBuffer;[BII)V", "", "copyTo-f8252NU", "(Ljava/nio/ByteBuffer;[BJI)V", "get", "", FirebaseAnalytics.Param.INDEX, "get-xtk156I", "(Ljava/nio/ByteBuffer;I)B", "get-pkUVrfw", "(Ljava/nio/ByteBuffer;J)B", "set", "value", "set-bxgQ-Fg", "(Ljava/nio/ByteBuffer;IB)V", "set-sgt2R-Q", "(Ljava/nio/ByteBuffer;JB)V", "storeAt", "Lkotlin/UByte;", "storeAt-Fn34HUQ", "storeAt-SVZKsBI", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class MemoryKt {
    /* JADX INFO: renamed from: copyTo-ylBjBJw, reason: not valid java name */
    public static final void m6976copyToylBjBJw(ByteBuffer copyTo, byte[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(copyTo, "$this$copyTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        MemoryJvmKt.m6968copyToFs5fovk(copyTo, destination, i, i2, 0);
    }

    /* JADX INFO: renamed from: copyTo-f8252NU, reason: not valid java name */
    public static final void m6975copyTof8252NU(ByteBuffer copyTo, byte[] destination, long j, int i) {
        Intrinsics.checkNotNullParameter(copyTo, "$this$copyTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        MemoryJvmKt.m6970copyToodTdu9Q(copyTo, destination, j, i, 0);
    }

    /* JADX INFO: renamed from: get-xtk156I, reason: not valid java name */
    public static final byte m6978getxtk156I(ByteBuffer get, int i) {
        Intrinsics.checkNotNullParameter(get, "$this$get");
        return get.get(i);
    }

    /* JADX INFO: renamed from: get-pkUVrfw, reason: not valid java name */
    public static final byte m6977getpkUVrfw(ByteBuffer get, long j) {
        Intrinsics.checkNotNullParameter(get, "$this$get");
        if (j < 2147483647L) {
            return get.get((int) j);
        }
        NumbersKt.failLongToIntConversion(j, FirebaseAnalytics.Param.INDEX);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: set-sgt2R-Q, reason: not valid java name */
    public static final void m6980setsgt2RQ(ByteBuffer set, long j, byte b) {
        Intrinsics.checkNotNullParameter(set, "$this$set");
        if (j < 2147483647L) {
            set.put((int) j, b);
        } else {
            NumbersKt.failLongToIntConversion(j, FirebaseAnalytics.Param.INDEX);
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: set-bxgQ-Fg, reason: not valid java name */
    public static final void m6979setbxgQFg(ByteBuffer set, int i, byte b) {
        Intrinsics.checkNotNullParameter(set, "$this$set");
        set.put(i, b);
    }

    /* JADX INFO: renamed from: storeAt-SVZKsBI, reason: not valid java name */
    public static final void m6982storeAtSVZKsBI(ByteBuffer storeAt, long j, byte b) {
        Intrinsics.checkNotNullParameter(storeAt, "$this$storeAt");
        if (j < 2147483647L) {
            storeAt.put((int) j, b);
        } else {
            NumbersKt.failLongToIntConversion(j, FirebaseAnalytics.Param.INDEX);
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: storeAt-Fn34HUQ, reason: not valid java name */
    public static final void m6981storeAtFn34HUQ(ByteBuffer storeAt, int i, byte b) {
        Intrinsics.checkNotNullParameter(storeAt, "$this$storeAt");
        storeAt.put(i, b);
    }
}
