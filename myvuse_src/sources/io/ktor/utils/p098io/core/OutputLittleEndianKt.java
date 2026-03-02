package io.ktor.utils.p098io.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.core.internal.UnsafeKt;
import kotlin.Metadata;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OutputLittleEndian.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\u0010\u0014\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0002\u0010\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\u001aM\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\u0006¢\u0006\u0002\b\bH\u0082\b¢\u0006\u0002\u0010\t\u001aU\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\u0006¢\u0006\u0002\b\bH\u0082\b¢\u0006\u0002\u0010\f\u001aD\u0010\r\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u001d\u0010\u0013\u001a\u0019\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\bH\u0082\b\u001aD\u0010\r\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u001d\u0010\u0013\u001a\u0019\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\bH\u0082\b\u001a\u001a\u0010\u0016\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000b\u001a\u0012\u0010\u0018\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0017\u001a\u0012\u0010\u0018\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0017\u001a\u001a\u0010\u0019\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u000b\u001a\u0012\u0010\u001b\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u001a\u001a\u0012\u0010\u001b\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u001a\u001a&\u0010\u001c\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u001a&\u0010\u001c\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u001a&\u0010\u001c\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020 2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u001a&\u0010\u001c\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020!2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u001a&\u0010\u001c\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\"2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u001a0\u0010\u001c\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020#2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a0\u0010\u001c\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020&2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a0\u0010\u001c\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020)2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a&\u0010\u001c\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u001a&\u0010\u001c\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u001a&\u0010\u001c\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u001d\u001a\u00020 2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u001a&\u0010\u001c\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u001d\u001a\u00020!2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u001a&\u0010\u001c\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\"2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u001a0\u0010\u001c\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u001d\u001a\u00020#2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a0\u0010\u001c\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u001d\u001a\u00020&2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a0\u0010\u001c\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u001d\u001a\u00020)2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a\u001a\u00102\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b\u001a\u0012\u00103\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0010\u001a\u0012\u00103\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0010\u001a\u001a\u00104\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0004\u001a\u0002052\u0006\u0010\n\u001a\u00020\u000b\u001a\u0012\u00106\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0004\u001a\u000205\u001a\u0012\u00106\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0004\u001a\u000205\u001a\u001a\u00107\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0004\u001a\u0002082\u0006\u0010\n\u001a\u00020\u000b\u001a\u0012\u00109\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0004\u001a\u000208\u001a\u0012\u00109\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0004\u001a\u000208\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, m5598d2 = {"writePrimitiveTemplate", "", ExifInterface.GPS_DIRECTION_TRUE, "", "value", "write", "Lkotlin/Function1;", "reverse", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "byteOrder", "Lio/ktor/utils/io/core/ByteOrder;", "(Ljava/lang/Object;Lio/ktor/utils/io/core/ByteOrder;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "writeArrayTemplate", "Lio/ktor/utils/io/core/Buffer;", TypedValues.CycleType.S_WAVE_OFFSET, "", "length", "componentSize", "writeComponent", "Lkotlin/Function2;", "Lio/ktor/utils/io/core/Output;", "writeDouble", "", "writeDoubleLittleEndian", "writeFloat", "", "writeFloatLittleEndian", "writeFullyLittleEndian", "source", "", "", "", "", "", "Lkotlin/UIntArray;", "writeFullyLittleEndian-uM_xt_c", "(Lio/ktor/utils/io/core/Buffer;[III)V", "Lkotlin/ULongArray;", "writeFullyLittleEndian-eOostTs", "(Lio/ktor/utils/io/core/Buffer;[JII)V", "Lkotlin/UShortArray;", "writeFullyLittleEndian-d1ESLyo", "(Lio/ktor/utils/io/core/Buffer;[SII)V", "writeFullyLittleEndian-kYjf2rc", "(Lio/ktor/utils/io/core/Output;[III)V", "writeFullyLittleEndian-3GkuuDw", "(Lio/ktor/utils/io/core/Output;[JII)V", "writeFullyLittleEndian-Hjr7jUQ", "(Lio/ktor/utils/io/core/Output;[SII)V", "writeInt", "writeIntLittleEndian", "writeLong", "", "writeLongLittleEndian", "writeShort", "", "writeShortLittleEndian", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class OutputLittleEndianKt {

    /* JADX INFO: compiled from: OutputLittleEndian.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ByteOrder.values().length];
            iArr[ByteOrder.BIG_ENDIAN.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: writeFullyLittleEndian-Hjr7jUQ$default, reason: not valid java name */
    public static /* synthetic */ void m7178writeFullyLittleEndianHjr7jUQ$default(Output output, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m7573getSizeimpl(sArr) - i;
        }
        m7177writeFullyLittleEndianHjr7jUQ(output, sArr, i, i2);
    }

    /* JADX INFO: renamed from: writeFullyLittleEndian-Hjr7jUQ, reason: not valid java name */
    public static final void m7177writeFullyLittleEndianHjr7jUQ(Output writeFullyLittleEndian, short[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(writeFullyLittleEndian, "$this$writeFullyLittleEndian");
        Intrinsics.checkNotNullParameter(source, "source");
        writeFullyLittleEndian(writeFullyLittleEndian, source, i, i2);
    }

    /* JADX INFO: renamed from: writeFullyLittleEndian-d1ESLyo$default, reason: not valid java name */
    public static /* synthetic */ void m7180writeFullyLittleEndiand1ESLyo$default(Buffer buffer, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m7573getSizeimpl(sArr) - i;
        }
        m7179writeFullyLittleEndiand1ESLyo(buffer, sArr, i, i2);
    }

    /* JADX INFO: renamed from: writeFullyLittleEndian-d1ESLyo, reason: not valid java name */
    public static final void m7179writeFullyLittleEndiand1ESLyo(Buffer writeFullyLittleEndian, short[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(writeFullyLittleEndian, "$this$writeFullyLittleEndian");
        Intrinsics.checkNotNullParameter(source, "source");
        writeFullyLittleEndian(writeFullyLittleEndian, source, i, i2);
    }

    public static /* synthetic */ void writeFullyLittleEndian$default(Output output, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length - i;
        }
        writeFullyLittleEndian(output, sArr, i, i2);
    }

    /* JADX INFO: renamed from: writeFullyLittleEndian-kYjf2rc$default, reason: not valid java name */
    public static /* synthetic */ void m7184writeFullyLittleEndiankYjf2rc$default(Output output, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UIntArray.m7389getSizeimpl(iArr) - i;
        }
        m7183writeFullyLittleEndiankYjf2rc(output, iArr, i, i2);
    }

    /* JADX INFO: renamed from: writeFullyLittleEndian-kYjf2rc, reason: not valid java name */
    public static final void m7183writeFullyLittleEndiankYjf2rc(Output writeFullyLittleEndian, int[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(writeFullyLittleEndian, "$this$writeFullyLittleEndian");
        Intrinsics.checkNotNullParameter(source, "source");
        writeFullyLittleEndian(writeFullyLittleEndian, source, i, i2);
    }

    public static /* synthetic */ void writeFullyLittleEndian$default(Output output, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = iArr.length - i;
        }
        writeFullyLittleEndian(output, iArr, i, i2);
    }

    /* JADX INFO: renamed from: writeFullyLittleEndian-3GkuuDw$default, reason: not valid java name */
    public static /* synthetic */ void m7176writeFullyLittleEndian3GkuuDw$default(Output output, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m7468getSizeimpl(jArr) - i;
        }
        m7175writeFullyLittleEndian3GkuuDw(output, jArr, i, i2);
    }

    /* JADX INFO: renamed from: writeFullyLittleEndian-3GkuuDw, reason: not valid java name */
    public static final void m7175writeFullyLittleEndian3GkuuDw(Output writeFullyLittleEndian, long[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(writeFullyLittleEndian, "$this$writeFullyLittleEndian");
        Intrinsics.checkNotNullParameter(source, "source");
        writeFullyLittleEndian(writeFullyLittleEndian, source, i, i2);
    }

    public static /* synthetic */ void writeFullyLittleEndian$default(Output output, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length - i;
        }
        writeFullyLittleEndian(output, jArr, i, i2);
    }

    public static /* synthetic */ void writeFullyLittleEndian$default(Output output, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length - i;
        }
        writeFullyLittleEndian(output, fArr, i, i2);
    }

    public static /* synthetic */ void writeFullyLittleEndian$default(Output output, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length - i;
        }
        writeFullyLittleEndian(output, dArr, i, i2);
    }

    public static /* synthetic */ void writeFullyLittleEndian$default(Buffer buffer, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length - i;
        }
        writeFullyLittleEndian(buffer, sArr, i, i2);
    }

    /* JADX INFO: renamed from: writeFullyLittleEndian-uM_xt_c$default, reason: not valid java name */
    public static /* synthetic */ void m7186writeFullyLittleEndianuM_xt_c$default(Buffer buffer, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UIntArray.m7389getSizeimpl(iArr) - i;
        }
        m7185writeFullyLittleEndianuM_xt_c(buffer, iArr, i, i2);
    }

    /* JADX INFO: renamed from: writeFullyLittleEndian-uM_xt_c, reason: not valid java name */
    public static final void m7185writeFullyLittleEndianuM_xt_c(Buffer writeFullyLittleEndian, int[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(writeFullyLittleEndian, "$this$writeFullyLittleEndian");
        Intrinsics.checkNotNullParameter(source, "source");
        writeFullyLittleEndian(writeFullyLittleEndian, source, i, i2);
    }

    public static /* synthetic */ void writeFullyLittleEndian$default(Buffer buffer, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = iArr.length - i;
        }
        writeFullyLittleEndian(buffer, iArr, i, i2);
    }

    /* JADX INFO: renamed from: writeFullyLittleEndian-eOostTs$default, reason: not valid java name */
    public static /* synthetic */ void m7182writeFullyLittleEndianeOostTs$default(Buffer buffer, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m7468getSizeimpl(jArr) - i;
        }
        m7181writeFullyLittleEndianeOostTs(buffer, jArr, i, i2);
    }

    /* JADX INFO: renamed from: writeFullyLittleEndian-eOostTs, reason: not valid java name */
    public static final void m7181writeFullyLittleEndianeOostTs(Buffer writeFullyLittleEndian, long[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(writeFullyLittleEndian, "$this$writeFullyLittleEndian");
        Intrinsics.checkNotNullParameter(source, "source");
        writeFullyLittleEndian(writeFullyLittleEndian, source, i, i2);
    }

    public static /* synthetic */ void writeFullyLittleEndian$default(Buffer buffer, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length - i;
        }
        writeFullyLittleEndian(buffer, jArr, i, i2);
    }

    public static /* synthetic */ void writeFullyLittleEndian$default(Buffer buffer, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length - i;
        }
        writeFullyLittleEndian(buffer, fArr, i, i2);
    }

    public static /* synthetic */ void writeFullyLittleEndian$default(Buffer buffer, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length - i;
        }
        writeFullyLittleEndian(buffer, dArr, i, i2);
    }

    private static final <T> void writePrimitiveTemplate(T t, Function1<? super T, Unit> function1, Function1<? super T, ? extends T> function12) {
        function1.invoke(function12.invoke(t));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    private static final <T> void writePrimitiveTemplate(T t, ByteOrder byteOrder, Function1<? super T, Unit> function1, Function1<? super T, ? extends T> function12) {
        ?? Invoke = t;
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
            Invoke = function12.invoke(t);
        }
        function1.invoke((Object) Invoke);
    }

    public static final void writeShort(Output output, short s, ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(byteOrder, "byteOrder");
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
            s = Short.reverseBytes(s);
        }
        OutputPrimitivesKt.writeShort(output, s);
    }

    public static final void writeInt(Output output, int i, ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(byteOrder, "byteOrder");
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
            i = Integer.reverseBytes(i);
        }
        OutputPrimitivesKt.writeInt(output, i);
    }

    public static final void writeLong(Output output, long j, ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(byteOrder, "byteOrder");
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
            j = Long.reverseBytes(j);
        }
        OutputPrimitivesKt.writeLong(output, j);
    }

    public static final void writeFloat(Output output, float f, ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(byteOrder, "byteOrder");
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
            f = Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(f)));
        }
        OutputPrimitivesKt.writeFloat(output, f);
    }

    public static final void writeDouble(Output output, double d, ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(byteOrder, "byteOrder");
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
            d = Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(d)));
        }
        OutputPrimitivesKt.writeDouble(output, d);
    }

    public static final void writeShortLittleEndian(Output output, short s) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        OutputPrimitivesKt.writeShort(output, Short.reverseBytes(s));
    }

    public static final void writeIntLittleEndian(Output output, int i) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        OutputPrimitivesKt.writeInt(output, Integer.reverseBytes(i));
    }

    public static final void writeLongLittleEndian(Output output, long j) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        OutputPrimitivesKt.writeLong(output, Long.reverseBytes(j));
    }

    public static final void writeFloatLittleEndian(Output output, float f) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        OutputPrimitivesKt.writeFloat(output, Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(f))));
    }

    public static final void writeDoubleLittleEndian(Output output, double d) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        OutputPrimitivesKt.writeDouble(output, Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(d))));
    }

    public static final void writeShortLittleEndian(Buffer buffer, short s) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        BufferPrimitivesKt.writeShort(buffer, Short.reverseBytes(s));
    }

    public static final void writeIntLittleEndian(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        BufferPrimitivesKt.writeInt(buffer, Integer.reverseBytes(i));
    }

    public static final void writeLongLittleEndian(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        BufferPrimitivesKt.writeLong(buffer, Long.reverseBytes(j));
    }

    public static final void writeFloatLittleEndian(Buffer buffer, float f) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        BufferPrimitivesKt.writeFloat(buffer, Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(f))));
    }

    public static final void writeDoubleLittleEndian(Buffer buffer, double d) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        BufferPrimitivesKt.writeDouble(buffer, Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(d))));
    }

    public static final void writeFullyLittleEndian(Output output, short[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int i3 = i2 + i;
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 2, (ChunkBuffer) null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min((chunkBuffer.getLimit() - chunkBuffer.getWritePosition()) / 2, i3 - i) + i;
                int i4 = iMin - 1;
                if (i <= i4) {
                    while (true) {
                        int i5 = i + 1;
                        BufferPrimitivesKt.writeShort(chunkBuffer, Short.reverseBytes(source[i]));
                        if (i == i4) {
                            break;
                        } else {
                            i = i5;
                        }
                    }
                }
                int i6 = iMin < i3 ? 2 : 0;
                if (i6 <= 0) {
                    return;
                }
                chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i6, chunkBufferPrepareWriteHead);
                i = iMin;
            } finally {
                UnsafeKt.afterHeadWrite(output, chunkBufferPrepareWriteHead);
            }
        }
    }

    public static final void writeFullyLittleEndian(Output output, int[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int i3 = i2 + i;
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 4, (ChunkBuffer) null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min((chunkBuffer.getLimit() - chunkBuffer.getWritePosition()) / 4, i3 - i) + i;
                int i4 = iMin - 1;
                if (i <= i4) {
                    while (true) {
                        int i5 = i + 1;
                        BufferPrimitivesKt.writeInt(chunkBuffer, Integer.reverseBytes(source[i]));
                        if (i == i4) {
                            break;
                        } else {
                            i = i5;
                        }
                    }
                }
                int i6 = iMin < i3 ? 4 : 0;
                if (i6 <= 0) {
                    return;
                }
                chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i6, chunkBufferPrepareWriteHead);
                i = iMin;
            } finally {
                UnsafeKt.afterHeadWrite(output, chunkBufferPrepareWriteHead);
            }
        }
    }

    public static final void writeFullyLittleEndian(Output output, long[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int i3 = i2 + i;
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 8, (ChunkBuffer) null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min((chunkBuffer.getLimit() - chunkBuffer.getWritePosition()) / 8, i3 - i) + i;
                int i4 = iMin - 1;
                if (i <= i4) {
                    while (true) {
                        int i5 = i + 1;
                        BufferPrimitivesKt.writeLong(chunkBuffer, Long.reverseBytes(source[i]));
                        if (i == i4) {
                            break;
                        } else {
                            i = i5;
                        }
                    }
                }
                int i6 = iMin < i3 ? 8 : 0;
                if (i6 <= 0) {
                    return;
                }
                chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i6, chunkBufferPrepareWriteHead);
                i = iMin;
            } finally {
                UnsafeKt.afterHeadWrite(output, chunkBufferPrepareWriteHead);
            }
        }
    }

    public static final void writeFullyLittleEndian(Output output, float[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int i3 = i2 + i;
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 4, (ChunkBuffer) null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min((chunkBuffer.getLimit() - chunkBuffer.getWritePosition()) / 4, i3 - i) + i;
                int i4 = iMin - 1;
                if (i <= i4) {
                    while (true) {
                        int i5 = i + 1;
                        BufferPrimitivesKt.writeFloat(chunkBuffer, Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(source[i]))));
                        if (i == i4) {
                            break;
                        } else {
                            i = i5;
                        }
                    }
                }
                int i6 = iMin < i3 ? 4 : 0;
                if (i6 <= 0) {
                    return;
                }
                chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i6, chunkBufferPrepareWriteHead);
                i = iMin;
            } finally {
                UnsafeKt.afterHeadWrite(output, chunkBufferPrepareWriteHead);
            }
        }
    }

    public static final void writeFullyLittleEndian(Output output, double[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int i3 = i2 + i;
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 8, (ChunkBuffer) null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min((chunkBuffer.getLimit() - chunkBuffer.getWritePosition()) / 8, i3 - i) + i;
                int i4 = iMin - 1;
                if (i <= i4) {
                    while (true) {
                        int i5 = i + 1;
                        BufferPrimitivesKt.writeDouble(chunkBuffer, Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(source[i]))));
                        if (i == i4) {
                            break;
                        } else {
                            i = i5;
                        }
                    }
                }
                int i6 = iMin < i3 ? 8 : 0;
                if (i6 <= 0) {
                    return;
                }
                chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i6, chunkBufferPrepareWriteHead);
                i = iMin;
            } finally {
                UnsafeKt.afterHeadWrite(output, chunkBufferPrepareWriteHead);
            }
        }
    }

    public static final void writeFullyLittleEndian(Buffer buffer, short[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int iMin = (Math.min((buffer.getLimit() - buffer.getWritePosition()) / 2, (i2 + i) - i) + i) - 1;
        if (i > iMin) {
            return;
        }
        while (true) {
            int i3 = i + 1;
            BufferPrimitivesKt.writeShort(buffer, Short.reverseBytes(source[i]));
            if (i == iMin) {
                return;
            } else {
                i = i3;
            }
        }
    }

    public static final void writeFullyLittleEndian(Buffer buffer, int[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int iMin = (Math.min((buffer.getLimit() - buffer.getWritePosition()) / 4, (i2 + i) - i) + i) - 1;
        if (i > iMin) {
            return;
        }
        while (true) {
            int i3 = i + 1;
            BufferPrimitivesKt.writeInt(buffer, Integer.reverseBytes(source[i]));
            if (i == iMin) {
                return;
            } else {
                i = i3;
            }
        }
    }

    public static final void writeFullyLittleEndian(Buffer buffer, long[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int iMin = (Math.min((buffer.getLimit() - buffer.getWritePosition()) / 8, (i2 + i) - i) + i) - 1;
        if (i > iMin) {
            return;
        }
        while (true) {
            int i3 = i + 1;
            BufferPrimitivesKt.writeLong(buffer, Long.reverseBytes(source[i]));
            if (i == iMin) {
                return;
            } else {
                i = i3;
            }
        }
    }

    public static final void writeFullyLittleEndian(Buffer buffer, float[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int iMin = (Math.min((buffer.getLimit() - buffer.getWritePosition()) / 4, (i2 + i) - i) + i) - 1;
        if (i > iMin) {
            return;
        }
        while (true) {
            int i3 = i + 1;
            BufferPrimitivesKt.writeFloat(buffer, Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(source[i]))));
            if (i == iMin) {
                return;
            } else {
                i = i3;
            }
        }
    }

    public static final void writeFullyLittleEndian(Buffer buffer, double[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int iMin = (Math.min((buffer.getLimit() - buffer.getWritePosition()) / 8, (i2 + i) - i) + i) - 1;
        if (i > iMin) {
            return;
        }
        while (true) {
            int i3 = i + 1;
            BufferPrimitivesKt.writeDouble(buffer, Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(source[i]))));
            if (i == iMin) {
                return;
            } else {
                i = i3;
            }
        }
    }

    private static final void writeArrayTemplate(Output output, int i, int i2, int i3, Function2<? super Buffer, ? super Integer, Unit> function2) {
        int i4 = i2 + i;
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i3, (ChunkBuffer) null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min((chunkBuffer.getLimit() - chunkBuffer.getWritePosition()) / i3, i4 - i) + i;
                int i5 = iMin - 1;
                if (i <= i5) {
                    while (true) {
                        int i6 = i + 1;
                        function2.invoke(chunkBuffer, Integer.valueOf(i));
                        if (i == i5) {
                            break;
                        } else {
                            i = i6;
                        }
                    }
                }
                int i7 = iMin < i4 ? i3 : 0;
                if (i7 <= 0) {
                    return;
                }
                chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i7, chunkBufferPrepareWriteHead);
                i = iMin;
            } finally {
                InlineMarker.finallyStart(1);
                UnsafeKt.afterHeadWrite(output, chunkBufferPrepareWriteHead);
                InlineMarker.finallyEnd(1);
            }
        }
    }

    private static final void writeArrayTemplate(Buffer buffer, int i, int i2, int i3, Function2<? super Buffer, ? super Integer, Unit> function2) {
        int iMin = (Math.min((buffer.getLimit() - buffer.getWritePosition()) / i3, (i2 + i) - i) + i) - 1;
        if (i > iMin) {
            return;
        }
        while (true) {
            int i4 = i + 1;
            function2.invoke(buffer, Integer.valueOf(i));
            if (i == iMin) {
                return;
            } else {
                i = i4;
            }
        }
    }
}
