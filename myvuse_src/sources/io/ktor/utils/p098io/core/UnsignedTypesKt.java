package io.ktor.utils.p098io.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UnsignedTypes.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\r2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00102\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0015\u0010\u0013\u001a\u00020\u0014*\u00020\u0002H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u00020\u0017*\u00020\u0002H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a\u0015\u0010\u0019\u001a\u00020\u001a*\u00020\u0002H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001a\u0015\u0010\u001c\u001a\u00020\u001d*\u00020\u0002H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a3\u0010\u001f\u001a\u00020\u0001*\u00020 2\u0006\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a3\u0010\u001f\u001a\u00020\u0001*\u00020 2\u0006\u0010!\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a3\u0010\u001f\u001a\u00020\u0001*\u00020 2\u0006\u0010!\u001a\u00020\r2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a3\u0010\u001f\u001a\u00020\u0001*\u00020 2\u0006\u0010!\u001a\u00020\u00102\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a\u001f\u0010*\u001a\u00020\u0001*\u00020 2\u0006\u0010+\u001a\u00020\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a\u001f\u0010.\u001a\u00020\u0001*\u00020 2\u0006\u0010+\u001a\u00020\u0017H\u0087\bø\u0001\u0000¢\u0006\u0004\b/\u00100\u001a\u001f\u00101\u001a\u00020\u0001*\u00020 2\u0006\u0010+\u001a\u00020\u001aH\u0087\bø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a\u001f\u00104\u001a\u00020\u0001*\u00020 2\u0006\u0010+\u001a\u00020\u001dH\u0087\bø\u0001\u0000¢\u0006\u0004\b5\u00106\u0082\u0002\u0004\n\u0002\b\u0019¨\u00067"}, m5598d2 = {"readFully", "", "Lio/ktor/utils/io/core/Input;", C4352k.a.f5652f, "Lkotlin/UByteArray;", TypedValues.CycleType.S_WAVE_OFFSET, "", "length", "readFully-kDL3d6Y", "(Lio/ktor/utils/io/core/Input;[BII)V", "Lkotlin/UIntArray;", "readFully-PIFet3Y", "(Lio/ktor/utils/io/core/Input;[III)V", "Lkotlin/ULongArray;", "readFully-r2sAqVg", "(Lio/ktor/utils/io/core/Input;[JII)V", "Lkotlin/UShortArray;", "readFully-Lv-FXd8", "(Lio/ktor/utils/io/core/Input;[SII)V", "readUByte", "Lkotlin/UByte;", "(Lio/ktor/utils/io/core/Input;)B", "readUInt", "Lkotlin/UInt;", "(Lio/ktor/utils/io/core/Input;)I", "readULong", "Lkotlin/ULong;", "(Lio/ktor/utils/io/core/Input;)J", "readUShort", "Lkotlin/UShort;", "(Lio/ktor/utils/io/core/Input;)S", "writeFully", "Lio/ktor/utils/io/core/Output;", "array", "writeFully-wDeirj4", "(Lio/ktor/utils/io/core/Output;[BII)V", "writeFully-kYjf2rc", "(Lio/ktor/utils/io/core/Output;[III)V", "writeFully-3GkuuDw", "(Lio/ktor/utils/io/core/Output;[JII)V", "writeFully-Hjr7jUQ", "(Lio/ktor/utils/io/core/Output;[SII)V", "writeUByte", "v", "writeUByte-9EPp-TE", "(Lio/ktor/utils/io/core/Output;B)V", "writeUInt", "writeUInt-fzK-hLo", "(Lio/ktor/utils/io/core/Output;I)V", "writeULong", "writeULong-O6EZHW0", "(Lio/ktor/utils/io/core/Output;J)V", "writeUShort", "writeUShort-SLr1GAc", "(Lio/ktor/utils/io/core/Output;S)V", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class UnsignedTypesKt {
    public static final byte readUByte(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return UByte.m7251constructorimpl(input.readByte());
    }

    public static final short readUShort(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return UShort.m7514constructorimpl(InputPrimitivesKt.readShort(input));
    }

    public static final int readUInt(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return UInt.m7328constructorimpl(InputPrimitivesKt.readInt(input));
    }

    public static final long readULong(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return ULong.m7407constructorimpl(InputPrimitivesKt.readLong(input));
    }

    /* JADX INFO: renamed from: readFully-kDL3d6Y$default, reason: not valid java name */
    public static /* synthetic */ void m7192readFullykDL3d6Y$default(Input readFully, byte[] dst, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m7310getSizeimpl(dst) - i;
        }
        Intrinsics.checkNotNullParameter(readFully, "$this$readFully");
        Intrinsics.checkNotNullParameter(dst, "dst");
        InputArraysKt.readFully(readFully, dst, i, i2);
    }

    /* JADX INFO: renamed from: readFully-kDL3d6Y, reason: not valid java name */
    public static final void m7191readFullykDL3d6Y(Input readFully, byte[] dst, int i, int i2) {
        Intrinsics.checkNotNullParameter(readFully, "$this$readFully");
        Intrinsics.checkNotNullParameter(dst, "dst");
        InputArraysKt.readFully(readFully, dst, i, i2);
    }

    /* JADX INFO: renamed from: readFully-Lv-FXd8$default, reason: not valid java name */
    public static /* synthetic */ void m7188readFullyLvFXd8$default(Input readFully, short[] dst, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m7573getSizeimpl(dst) - i;
        }
        Intrinsics.checkNotNullParameter(readFully, "$this$readFully");
        Intrinsics.checkNotNullParameter(dst, "dst");
        InputArraysKt.readFully(readFully, dst, i, i2);
    }

    /* JADX INFO: renamed from: readFully-Lv-FXd8, reason: not valid java name */
    public static final void m7187readFullyLvFXd8(Input readFully, short[] dst, int i, int i2) {
        Intrinsics.checkNotNullParameter(readFully, "$this$readFully");
        Intrinsics.checkNotNullParameter(dst, "dst");
        InputArraysKt.readFully(readFully, dst, i, i2);
    }

    /* JADX INFO: renamed from: readFully-PIFet3Y$default, reason: not valid java name */
    public static /* synthetic */ void m7190readFullyPIFet3Y$default(Input readFully, int[] dst, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UIntArray.m7389getSizeimpl(dst) - i;
        }
        Intrinsics.checkNotNullParameter(readFully, "$this$readFully");
        Intrinsics.checkNotNullParameter(dst, "dst");
        InputArraysKt.readFully(readFully, dst, i, i2);
    }

    /* JADX INFO: renamed from: readFully-PIFet3Y, reason: not valid java name */
    public static final void m7189readFullyPIFet3Y(Input readFully, int[] dst, int i, int i2) {
        Intrinsics.checkNotNullParameter(readFully, "$this$readFully");
        Intrinsics.checkNotNullParameter(dst, "dst");
        InputArraysKt.readFully(readFully, dst, i, i2);
    }

    /* JADX INFO: renamed from: readFully-r2sAqVg$default, reason: not valid java name */
    public static /* synthetic */ void m7194readFullyr2sAqVg$default(Input readFully, long[] dst, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m7468getSizeimpl(dst) - i;
        }
        Intrinsics.checkNotNullParameter(readFully, "$this$readFully");
        Intrinsics.checkNotNullParameter(dst, "dst");
        InputArraysKt.readFully(readFully, dst, i, i2);
    }

    /* JADX INFO: renamed from: readFully-r2sAqVg, reason: not valid java name */
    public static final void m7193readFullyr2sAqVg(Input readFully, long[] dst, int i, int i2) {
        Intrinsics.checkNotNullParameter(readFully, "$this$readFully");
        Intrinsics.checkNotNullParameter(dst, "dst");
        InputArraysKt.readFully(readFully, dst, i, i2);
    }

    /* JADX INFO: renamed from: writeUByte-9EPp-TE, reason: not valid java name */
    public static final void m7203writeUByte9EPpTE(Output writeUByte, byte b) {
        Intrinsics.checkNotNullParameter(writeUByte, "$this$writeUByte");
        writeUByte.writeByte(b);
    }

    /* JADX INFO: renamed from: writeUShort-SLr1GAc, reason: not valid java name */
    public static final void m7206writeUShortSLr1GAc(Output writeUShort, short s) {
        Intrinsics.checkNotNullParameter(writeUShort, "$this$writeUShort");
        OutputPrimitivesKt.writeShort(writeUShort, s);
    }

    /* JADX INFO: renamed from: writeUInt-fzK-hLo, reason: not valid java name */
    public static final void m7204writeUIntfzKhLo(Output writeUInt, int i) {
        Intrinsics.checkNotNullParameter(writeUInt, "$this$writeUInt");
        OutputPrimitivesKt.writeInt(writeUInt, i);
    }

    /* JADX INFO: renamed from: writeULong-O6EZHW0, reason: not valid java name */
    public static final void m7205writeULongO6EZHW0(Output writeULong, long j) {
        Intrinsics.checkNotNullParameter(writeULong, "$this$writeULong");
        OutputPrimitivesKt.writeLong(writeULong, j);
    }

    /* JADX INFO: renamed from: writeFully-wDeirj4$default, reason: not valid java name */
    public static /* synthetic */ void m7202writeFullywDeirj4$default(Output writeFully, byte[] array, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m7310getSizeimpl(array) - i;
        }
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(array, "array");
        OutputKt.writeFully(writeFully, array, i, i2);
    }

    /* JADX INFO: renamed from: writeFully-wDeirj4, reason: not valid java name */
    public static final void m7201writeFullywDeirj4(Output writeFully, byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(array, "array");
        OutputKt.writeFully(writeFully, array, i, i2);
    }

    /* JADX INFO: renamed from: writeFully-Hjr7jUQ$default, reason: not valid java name */
    public static /* synthetic */ void m7198writeFullyHjr7jUQ$default(Output writeFully, short[] array, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m7573getSizeimpl(array) - i;
        }
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(array, "array");
        OutputKt.writeFully(writeFully, array, i, i2);
    }

    /* JADX INFO: renamed from: writeFully-Hjr7jUQ, reason: not valid java name */
    public static final void m7197writeFullyHjr7jUQ(Output writeFully, short[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(array, "array");
        OutputKt.writeFully(writeFully, array, i, i2);
    }

    /* JADX INFO: renamed from: writeFully-kYjf2rc$default, reason: not valid java name */
    public static /* synthetic */ void m7200writeFullykYjf2rc$default(Output writeFully, int[] array, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UIntArray.m7389getSizeimpl(array) - i;
        }
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(array, "array");
        OutputKt.writeFully(writeFully, array, i, i2);
    }

    /* JADX INFO: renamed from: writeFully-kYjf2rc, reason: not valid java name */
    public static final void m7199writeFullykYjf2rc(Output writeFully, int[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(array, "array");
        OutputKt.writeFully(writeFully, array, i, i2);
    }

    /* JADX INFO: renamed from: writeFully-3GkuuDw$default, reason: not valid java name */
    public static /* synthetic */ void m7196writeFully3GkuuDw$default(Output writeFully, long[] array, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m7468getSizeimpl(array) - i;
        }
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(array, "array");
        OutputKt.writeFully(writeFully, array, i, i2);
    }

    /* JADX INFO: renamed from: writeFully-3GkuuDw, reason: not valid java name */
    public static final void m7195writeFully3GkuuDw(Output writeFully, long[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(array, "array");
        OutputKt.writeFully(writeFully, array, i, i2);
    }
}
