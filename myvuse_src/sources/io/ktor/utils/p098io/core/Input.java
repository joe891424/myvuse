package io.ktor.utils.p098io.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import java.io.Closeable;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: InputJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0013\n\u0002\u0010\u0014\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\n\n\u0002\b\u0002\bf\u0018\u00002\u00060\u0001j\u0002`\u0002J\b\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H&J@\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u0012H&ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0014\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0017J\u0018\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001dH\u0017J\u001a\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020#2\b\b\u0002\u0010\"\u001a\u00020\u001dH\u0017J \u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001dH\u0017J \u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001dH\u0017J \u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020&2\u0006\u0010\u0018\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001dH\u0017J \u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020'2\u0006\u0010\u0018\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001dH\u0017J \u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001dH\u0017J \u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020)2\u0006\u0010\u0018\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001dH\u0017J\b\u0010*\u001a\u00020+H&J\b\u0010,\u001a\u00020-H\u0017J\b\u0010.\u001a\u00020/H\u0017J\u0018\u00100\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001dH\u0017J\u001a\u00100\u001a\u00020\u00102\u0006\u0010!\u001a\u00020#2\b\b\u0002\u0010\"\u001a\u00020\u001dH\u0017J \u00100\u001a\u00020\u00102\u0006\u0010!\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001dH\u0017J \u00100\u001a\u00020\u00102\u0006\u0010!\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001dH\u0017J \u00100\u001a\u00020\u00102\u0006\u0010!\u001a\u00020&2\u0006\u0010\u0018\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001dH\u0017J \u00100\u001a\u00020\u00102\u0006\u0010!\u001a\u00020'2\u0006\u0010\u0018\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001dH\u0017J \u00100\u001a\u00020\u00102\u0006\u0010!\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001dH\u0017J \u00100\u001a\u00020\u00102\u0006\u0010!\u001a\u00020)2\u0006\u0010\u0018\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001dH\u0017J\b\u00101\u001a\u00020\u001dH\u0017J\b\u00102\u001a\u00020\u0012H\u0017J\b\u00103\u001a\u000204H\u0017J\b\u00105\u001a\u00020\u001dH&R\"\u0010\u0003\u001a\u00020\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u00066"}, m5598d2 = {"Lio/ktor/utils/io/core/Input;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "byteOrder", "Lio/ktor/utils/io/core/ByteOrder;", "getByteOrder$annotations", "()V", "getByteOrder", "()Lio/ktor/utils/io/core/ByteOrder;", "setByteOrder", "(Lio/ktor/utils/io/core/ByteOrder;)V", "endOfInput", "", "getEndOfInput", "()Z", "close", "", "discard", "", RsaJsonWebKey.MODULUS_MEMBER_NAME, "peekTo", FirebaseAnalytics.Param.DESTINATION, "Lio/ktor/utils/io/bits/Memory;", "destinationOffset", TypedValues.CycleType.S_WAVE_OFFSET, "min", "max", "peekTo-1dgeIsk", "(Ljava/nio/ByteBuffer;JJJJ)J", "", "buffer", "Lio/ktor/utils/io/core/IoBuffer;", "readAvailable", C4352k.a.f5652f, "length", "Ljava/nio/ByteBuffer;", "", "", "", "", "", "", "readByte", "", "readDouble", "", "readFloat", "", "readFully", "readInt", "readLong", "readShort", "", "tryPeek", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public interface Input extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    long discard(long n);

    ByteOrder getByteOrder();

    /* JADX INFO: renamed from: getEndOfInput */
    boolean isEmpty();

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ int peekTo(IoBuffer buffer);

    /* JADX INFO: renamed from: peekTo-1dgeIsk */
    long mo7100peekTo1dgeIsk(ByteBuffer destination, long destinationOffset, long offset, long min, long max);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ int readAvailable(IoBuffer dst, int length);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ int readAvailable(ByteBuffer dst, int length);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ int readAvailable(byte[] dst, int offset, int length);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ int readAvailable(double[] dst, int offset, int length);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ int readAvailable(float[] dst, int offset, int length);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ int readAvailable(int[] dst, int offset, int length);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ int readAvailable(long[] dst, int offset, int length);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ int readAvailable(short[] dst, int offset, int length);

    byte readByte();

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ double readDouble();

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ float readFloat();

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void readFully(IoBuffer dst, int length);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void readFully(ByteBuffer dst, int length);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void readFully(byte[] dst, int offset, int length);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void readFully(double[] dst, int offset, int length);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void readFully(float[] dst, int offset, int length);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void readFully(int[] dst, int offset, int length);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void readFully(long[] dst, int offset, int length);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void readFully(short[] dst, int offset, int length);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ int readInt();

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ long readLong();

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ short readShort();

    void setByteOrder(ByteOrder byteOrder);

    int tryPeek();

    /* JADX INFO: compiled from: InputJvm.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.ERROR, message = "Not supported anymore. All operations are big endian by default. Use readXXXLittleEndian or readXXX then X.reverseByteOrder() instead.")
        public static /* synthetic */ void getByteOrder$annotations() {
        }

        /* JADX INFO: renamed from: peekTo-1dgeIsk$default, reason: not valid java name */
        public static /* synthetic */ long m7144peekTo1dgeIsk$default(Input input, ByteBuffer byteBuffer, long j, long j2, long j3, long j4, int i, Object obj) {
            if (obj == null) {
                return input.mo7100peekTo1dgeIsk(byteBuffer, j, (i & 4) != 0 ? 0L : j2, (i & 8) != 0 ? 1L : j3, (i & 16) != 0 ? Long.MAX_VALUE : j4);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: peekTo-1dgeIsk");
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ short readShort(Input input) {
            Intrinsics.checkNotNullParameter(input, "this");
            return InputPrimitivesKt.readShort(input);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ int readInt(Input input) {
            Intrinsics.checkNotNullParameter(input, "this");
            return InputPrimitivesKt.readInt(input);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ long readLong(Input input) {
            Intrinsics.checkNotNullParameter(input, "this");
            return InputPrimitivesKt.readLong(input);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ float readFloat(Input input) {
            Intrinsics.checkNotNullParameter(input, "this");
            return InputPrimitivesKt.readFloat(input);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ double readDouble(Input input) {
            Intrinsics.checkNotNullParameter(input, "this");
            return InputPrimitivesKt.readDouble(input);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void readFully(Input input, byte[] dst, int i, int i2) {
            Intrinsics.checkNotNullParameter(input, "this");
            Intrinsics.checkNotNullParameter(dst, "dst");
            InputArraysKt.readFully(input, dst, i, i2);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void readFully(Input input, short[] dst, int i, int i2) {
            Intrinsics.checkNotNullParameter(input, "this");
            Intrinsics.checkNotNullParameter(dst, "dst");
            InputArraysKt.readFully(input, dst, i, i2);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void readFully(Input input, int[] dst, int i, int i2) {
            Intrinsics.checkNotNullParameter(input, "this");
            Intrinsics.checkNotNullParameter(dst, "dst");
            InputArraysKt.readFully(input, dst, i, i2);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void readFully(Input input, long[] dst, int i, int i2) {
            Intrinsics.checkNotNullParameter(input, "this");
            Intrinsics.checkNotNullParameter(dst, "dst");
            InputArraysKt.readFully(input, dst, i, i2);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void readFully(Input input, float[] dst, int i, int i2) {
            Intrinsics.checkNotNullParameter(input, "this");
            Intrinsics.checkNotNullParameter(dst, "dst");
            InputArraysKt.readFully(input, dst, i, i2);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void readFully(Input input, double[] dst, int i, int i2) {
            Intrinsics.checkNotNullParameter(input, "this");
            Intrinsics.checkNotNullParameter(dst, "dst");
            InputArraysKt.readFully(input, dst, i, i2);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void readFully(Input input, IoBuffer dst, int i) {
            Intrinsics.checkNotNullParameter(input, "this");
            Intrinsics.checkNotNullParameter(dst, "dst");
            InputArraysKt.readFully(input, dst, i);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ int readAvailable(Input input, byte[] dst, int i, int i2) {
            Intrinsics.checkNotNullParameter(input, "this");
            Intrinsics.checkNotNullParameter(dst, "dst");
            return InputArraysKt.readAvailable(input, dst, i, i2);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ int readAvailable(Input input, short[] dst, int i, int i2) {
            Intrinsics.checkNotNullParameter(input, "this");
            Intrinsics.checkNotNullParameter(dst, "dst");
            return InputArraysKt.readAvailable(input, dst, i, i2);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ int readAvailable(Input input, int[] dst, int i, int i2) {
            Intrinsics.checkNotNullParameter(input, "this");
            Intrinsics.checkNotNullParameter(dst, "dst");
            return InputArraysKt.readAvailable(input, dst, i, i2);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ int readAvailable(Input input, long[] dst, int i, int i2) {
            Intrinsics.checkNotNullParameter(input, "this");
            Intrinsics.checkNotNullParameter(dst, "dst");
            return InputArraysKt.readAvailable(input, dst, i, i2);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ int readAvailable(Input input, float[] dst, int i, int i2) {
            Intrinsics.checkNotNullParameter(input, "this");
            Intrinsics.checkNotNullParameter(dst, "dst");
            return InputArraysKt.readAvailable(input, dst, i, i2);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ int readAvailable(Input input, double[] dst, int i, int i2) {
            Intrinsics.checkNotNullParameter(input, "this");
            Intrinsics.checkNotNullParameter(dst, "dst");
            return InputArraysKt.readAvailable(input, dst, i, i2);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ int readAvailable(Input input, IoBuffer dst, int i) {
            Intrinsics.checkNotNullParameter(input, "this");
            Intrinsics.checkNotNullParameter(dst, "dst");
            return InputArraysKt.readAvailable(input, dst, i);
        }

        public static /* synthetic */ void readFully$default(Input input, ByteBuffer byteBuffer, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readFully");
            }
            if ((i2 & 2) != 0) {
                i = byteBuffer.remaining();
            }
            input.readFully(byteBuffer, i);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void readFully(Input input, ByteBuffer dst, int i) {
            Intrinsics.checkNotNullParameter(input, "this");
            Intrinsics.checkNotNullParameter(dst, "dst");
            InputArraysJvmKt.readFully(input, dst, i);
        }

        public static /* synthetic */ int readAvailable$default(Input input, ByteBuffer byteBuffer, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readAvailable");
            }
            if ((i2 & 2) != 0) {
                i = byteBuffer.remaining();
            }
            return input.readAvailable(byteBuffer, i);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ int readAvailable(Input input, ByteBuffer dst, int i) {
            Intrinsics.checkNotNullParameter(input, "this");
            Intrinsics.checkNotNullParameter(dst, "dst");
            return InputArraysJvmKt.readAvailable(input, dst, i);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ int peekTo(Input input, IoBuffer buffer) {
            Intrinsics.checkNotNullParameter(input, "this");
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            return InputPeekKt.peekTo$default(input, (Buffer) buffer, 0, 0, 0, 14, (Object) null);
        }
    }
}
