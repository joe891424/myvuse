package io.ktor.utils.p098io.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.brentvatne.react.ReactVideoViewManager;
import com.facebook.react.uimanager.ViewProps;
import java.io.Closeable;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: OutputJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0013\n\u0002\u0010\u0014\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0002\u0010\u0017\n\u0002\b\u0003\n\u0002\u0010\n\n\u0000\bf\u0018\u00002\u00060\u0001j\u0002`\u00022\u00060\u0003j\u0002`\u0004J$\u0010\r\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H&J\b\u0010\u0013\u001a\u00020\u0014H&J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0017J\b\u0010\u001a\u001a\u00020\u0014H&J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u001dH\u0017J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u001fH\u0017J\u0018\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0011H\u0017J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010$\u001a\u00020%H\u0017J \u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0011H\u0017J \u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020(2\u0006\u0010'\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0011H\u0017J \u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020)2\u0006\u0010'\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0011H\u0017J \u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020*2\u0006\u0010'\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0011H\u0017J \u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020+2\u0006\u0010'\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0011H\u0017J \u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020,2\u0006\u0010'\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0011H\u0017J\u0010\u0010-\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0011H\u0017J\u0010\u0010.\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0017H\u0017J\u0010\u0010/\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u000200H\u0017R\"\u0010\u0005\u001a\u00020\u00068&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u00061"}, m5598d2 = {"Lio/ktor/utils/io/core/Output;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "byteOrder", "Lio/ktor/utils/io/core/ByteOrder;", "getByteOrder$annotations", "()V", "getByteOrder", "()Lio/ktor/utils/io/core/ByteOrder;", "setByteOrder", "(Lio/ktor/utils/io/core/ByteOrder;)V", "append", "csq", "", "start", "", ViewProps.END, "close", "", "fill", RsaJsonWebKey.MODULUS_MEMBER_NAME, "", "v", "", "flush", "writeByte", "writeDouble", "", "writeFloat", "", "writeFully", ReactVideoViewManager.PROP_SRC, "Lio/ktor/utils/io/core/IoBuffer;", "length", "bb", "Ljava/nio/ByteBuffer;", "", TypedValues.CycleType.S_WAVE_OFFSET, "", "", "", "", "", "writeInt", "writeLong", "writeShort", "", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public interface Output extends Closeable, Appendable {
    Appendable append(char[] csq, int start, int end);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void fill(long n, byte v);

    void flush();

    ByteOrder getByteOrder();

    void setByteOrder(ByteOrder byteOrder);

    void writeByte(byte v);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void writeDouble(double v);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void writeFloat(float v);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void writeFully(IoBuffer src, int length);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void writeFully(ByteBuffer bb);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void writeFully(byte[] src, int offset, int length);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void writeFully(double[] src, int offset, int length);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void writeFully(float[] src, int offset, int length);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void writeFully(int[] src, int offset, int length);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void writeFully(long[] src, int offset, int length);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void writeFully(short[] src, int offset, int length);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void writeInt(int v);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void writeLong(long v);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void writeShort(short v);

    /* JADX INFO: compiled from: OutputJvm.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    public static final class DefaultImpls {
        @Deprecated(message = "Write with writeXXXLittleEndian or do X.reverseByteOrder() and then writeXXX instead.")
        public static /* synthetic */ void getByteOrder$annotations() {
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void writeShort(Output output, short s) {
            Intrinsics.checkNotNullParameter(output, "this");
            OutputPrimitivesKt.writeShort(output, s);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void writeInt(Output output, int i) {
            Intrinsics.checkNotNullParameter(output, "this");
            OutputPrimitivesKt.writeInt(output, i);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void writeLong(Output output, long j) {
            Intrinsics.checkNotNullParameter(output, "this");
            OutputPrimitivesKt.writeLong(output, j);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void writeFloat(Output output, float f) {
            Intrinsics.checkNotNullParameter(output, "this");
            OutputPrimitivesKt.writeFloat(output, f);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void writeDouble(Output output, double d) {
            Intrinsics.checkNotNullParameter(output, "this");
            OutputPrimitivesKt.writeDouble(output, d);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void writeFully(Output output, byte[] src, int i, int i2) {
            Intrinsics.checkNotNullParameter(output, "this");
            Intrinsics.checkNotNullParameter(src, "src");
            OutputKt.writeFully(output, src, i, i2);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void writeFully(Output output, short[] src, int i, int i2) {
            Intrinsics.checkNotNullParameter(output, "this");
            Intrinsics.checkNotNullParameter(src, "src");
            OutputKt.writeFully(output, src, i, i2);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void writeFully(Output output, int[] src, int i, int i2) {
            Intrinsics.checkNotNullParameter(output, "this");
            Intrinsics.checkNotNullParameter(src, "src");
            OutputKt.writeFully(output, src, i, i2);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void writeFully(Output output, long[] src, int i, int i2) {
            Intrinsics.checkNotNullParameter(output, "this");
            Intrinsics.checkNotNullParameter(src, "src");
            OutputKt.writeFully(output, src, i, i2);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void writeFully(Output output, float[] src, int i, int i2) {
            Intrinsics.checkNotNullParameter(output, "this");
            Intrinsics.checkNotNullParameter(src, "src");
            OutputKt.writeFully(output, src, i, i2);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void writeFully(Output output, double[] src, int i, int i2) {
            Intrinsics.checkNotNullParameter(output, "this");
            Intrinsics.checkNotNullParameter(src, "src");
            OutputKt.writeFully(output, src, i, i2);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void writeFully(Output output, IoBuffer src, int i) {
            Intrinsics.checkNotNullParameter(output, "this");
            Intrinsics.checkNotNullParameter(src, "src");
            OutputKt.writeFully(output, (Buffer) src, i);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void writeFully(Output output, ByteBuffer bb) {
            Intrinsics.checkNotNullParameter(output, "this");
            Intrinsics.checkNotNullParameter(bb, "bb");
            OutputArraysJVMKt.writeFully(output, bb);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void fill(Output output, long j, byte b) {
            Intrinsics.checkNotNullParameter(output, "this");
            OutputKt.fill(output, j, b);
        }
    }
}
