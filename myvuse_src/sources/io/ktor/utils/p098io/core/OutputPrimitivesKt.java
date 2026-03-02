package io.ktor.utils.p098io.core;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.utils.p098io.bits.Memory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: OutputPrimitives.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0006\u001a\u0012\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\b\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0002\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0002\u001a\u0012\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\f\u001a\u0014\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\fH\u0002\u001a)\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012H\u0082\b\u001aA\u0010\u0014\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\b2'\u0010\u0015\u001a#\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00010\u0016H\u0082\bø\u0001\u0000\u001a\u0012\u0010\u001b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u001c\u001a\u0014\u0010\u001d\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u001cH\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, m5598d2 = {"writeDouble", "", "Lio/ktor/utils/io/core/Output;", "value", "", "writeFloat", "", "writeInt", "", "writeIntByteByByte", "writeIntFallback", "writeLong", "", "writeLongFallback", "writePrimitiveFallbackTemplate", "", "componentSize", "writeOperation", "Lkotlin/Function1;", "Lio/ktor/utils/io/core/Buffer;", "writePrimitiveTemplate", "block", "Lkotlin/Function2;", "Lio/ktor/utils/io/bits/Memory;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "writeShort", "", "writeShortFallback", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class OutputPrimitivesKt {
    private static final void writeIntByteByByte(Output output, int i) {
        short s = (short) (i >>> 16);
        output.writeByte((byte) (s >>> 8));
        output.writeByte((byte) (s & 255));
        short s2 = (short) (i & 65535);
        output.writeByte((byte) (s2 >>> 8));
        output.writeByte((byte) (s2 & 255));
    }

    private static final boolean writePrimitiveTemplate(Output output, int i, Function2<? super Memory, ? super Integer, Unit> function2) {
        if (!(output instanceof AbstractOutput)) {
            return false;
        }
        AbstractOutput abstractOutput = (AbstractOutput) output;
        int tailPosition$ktor_io = abstractOutput.getTailPosition$ktor_io();
        if (abstractOutput.getTailEndExclusive$ktor_io() - tailPosition$ktor_io <= i) {
            return false;
        }
        abstractOutput.setTailPosition$ktor_io(i + tailPosition$ktor_io);
        function2.invoke(Memory.m6950boximpl(abstractOutput.m7105getTailMemorySK3TCg8$ktor_io()), Integer.valueOf(tailPosition$ktor_io));
        return true;
    }

    private static final boolean writePrimitiveFallbackTemplate(Output output, int i, Function1<? super Buffer, Unit> function1) {
        if (!(output instanceof AbstractOutput)) {
            return false;
        }
        AbstractOutput abstractOutput = (AbstractOutput) output;
        function1.invoke(abstractOutput.prepareWriteHead(i));
        abstractOutput.afterHeadWrite();
        return true;
    }

    public static final void writeShort(Output output, short s) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        if (output instanceof AbstractOutput) {
            AbstractOutput abstractOutput = (AbstractOutput) output;
            int tailPosition$ktor_io = abstractOutput.getTailPosition$ktor_io();
            if (abstractOutput.getTailEndExclusive$ktor_io() - tailPosition$ktor_io > 2) {
                abstractOutput.setTailPosition$ktor_io(tailPosition$ktor_io + 2);
                abstractOutput.m7105getTailMemorySK3TCg8$ktor_io().putShort(tailPosition$ktor_io, s);
                return;
            }
        }
        writeShortFallback(output, s);
    }

    private static final void writeShortFallback(Output output, short s) {
        if (!(output instanceof AbstractOutput)) {
            output.writeByte((byte) (s >>> 8));
            output.writeByte((byte) (s & 255));
        } else {
            AbstractOutput abstractOutput = (AbstractOutput) output;
            BufferPrimitivesKt.writeShort(abstractOutput.prepareWriteHead(2), s);
            abstractOutput.afterHeadWrite();
        }
    }

    public static final void writeInt(Output output, int i) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        if (output instanceof AbstractOutput) {
            AbstractOutput abstractOutput = (AbstractOutput) output;
            int tailPosition$ktor_io = abstractOutput.getTailPosition$ktor_io();
            if (abstractOutput.getTailEndExclusive$ktor_io() - tailPosition$ktor_io > 4) {
                abstractOutput.setTailPosition$ktor_io(tailPosition$ktor_io + 4);
                abstractOutput.m7105getTailMemorySK3TCg8$ktor_io().putInt(tailPosition$ktor_io, i);
                return;
            }
        }
        writeIntFallback(output, i);
    }

    private static final void writeIntFallback(Output output, int i) {
        if (!(output instanceof AbstractOutput)) {
            writeIntByteByByte(output, i);
            return;
        }
        AbstractOutput abstractOutput = (AbstractOutput) output;
        BufferPrimitivesKt.writeInt(abstractOutput.prepareWriteHead(4), i);
        abstractOutput.afterHeadWrite();
    }

    public static final void writeLong(Output output, long j) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        if (output instanceof AbstractOutput) {
            AbstractOutput abstractOutput = (AbstractOutput) output;
            int tailPosition$ktor_io = abstractOutput.getTailPosition$ktor_io();
            if (abstractOutput.getTailEndExclusive$ktor_io() - tailPosition$ktor_io > 8) {
                abstractOutput.setTailPosition$ktor_io(tailPosition$ktor_io + 8);
                abstractOutput.m7105getTailMemorySK3TCg8$ktor_io().putLong(tailPosition$ktor_io, j);
                return;
            }
        }
        writeLongFallback(output, j);
    }

    private static final void writeLongFallback(Output output, long j) {
        if (!(output instanceof AbstractOutput)) {
            writeIntByteByByte(output, (int) (j >>> 32));
            writeIntByteByByte(output, (int) (j & InternalZipConstants.ZIP_64_SIZE_LIMIT));
        } else {
            AbstractOutput abstractOutput = (AbstractOutput) output;
            BufferPrimitivesKt.writeLong(abstractOutput.prepareWriteHead(8), j);
            abstractOutput.afterHeadWrite();
        }
    }

    public static final void writeFloat(Output output, float f) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        if (output instanceof AbstractOutput) {
            AbstractOutput abstractOutput = (AbstractOutput) output;
            int tailPosition$ktor_io = abstractOutput.getTailPosition$ktor_io();
            if (abstractOutput.getTailEndExclusive$ktor_io() - tailPosition$ktor_io > 4) {
                abstractOutput.setTailPosition$ktor_io(tailPosition$ktor_io + 4);
                abstractOutput.m7105getTailMemorySK3TCg8$ktor_io().putFloat(tailPosition$ktor_io, f);
                return;
            }
        }
        writeIntFallback(output, Float.floatToRawIntBits(f));
    }

    public static final void writeDouble(Output output, double d) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        if (output instanceof AbstractOutput) {
            AbstractOutput abstractOutput = (AbstractOutput) output;
            int tailPosition$ktor_io = abstractOutput.getTailPosition$ktor_io();
            if (abstractOutput.getTailEndExclusive$ktor_io() - tailPosition$ktor_io > 8) {
                abstractOutput.setTailPosition$ktor_io(tailPosition$ktor_io + 8);
                abstractOutput.m7105getTailMemorySK3TCg8$ktor_io().putDouble(tailPosition$ktor_io, d);
                return;
            }
        }
        writeLongFallback(output, Double.doubleToRawLongBits(d));
    }
}
