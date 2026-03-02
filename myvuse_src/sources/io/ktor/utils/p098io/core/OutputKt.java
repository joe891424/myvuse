package io.ktor.utils.p098io.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.brentvatne.react.ReactVideoViewManager;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.utils.p098io.bits.Memory;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.core.internal.DangerousInternalIoApi;
import io.ktor.utils.p098io.core.internal.UnsafeKt;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;

/* JADX INFO: compiled from: Output.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0013\n\u0002\u0010\u0014\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007\u001a*\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007\u001a\u001c\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u001a\u001c\u0010\u0010\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a,\u0010\u0011\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a,\u0010\u0011\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001c\u0010\u0011\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u001a2\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u001a\u001e\u0010\u0011\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u001b2\b\b\u0002\u0010\u0015\u001a\u00020\u0007H\u0007\u001a&\u0010\u0011\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u001c2\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u001a&\u0010\u0011\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u001d2\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u001a&\u0010\u0011\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u001e2\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u001a&\u0010\u0011\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u001f2\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u001a&\u0010\u0011\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0012\u001a\u00020 2\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u001a&\u0010\u0011\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0012\u001a\u00020!2\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u001a[\u0010\"\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072<\u0010#\u001a8\u0012\u0004\u0012\u00020\u001a\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u000b0$H\u0082\b\u001a\u0082\u0001\u0010\"\u001a\u00020\u000b*\u00020\u00032\u0006\u0010)\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2`\u0010#\u001a\\\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110\r¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\r¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\r¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u000b0*H\u0082\bø\u0001\u0000\u001ac\u0010-\u001a\u00020\u000b*\u00020\u00032\u0006\u0010.\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072<\u0010#\u001a8\u0012\u0004\u0012\u00020\u001a\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u000b0$H\u0082\b\u001a\u0012\u0010/\u001a\u00020\u000b*\u00020\u00032\u0006\u00100\u001a\u000201\u001a$\u00102\u001a\u00020\u000b*\u00020\u00032\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020403H\u0087\bø\u0001\u0001\u001a.\u00105\u001a\u00020\u000b*\u00020\u00032\b\b\u0002\u00106\u001a\u00020\u00072\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000703H\u0087\bø\u0001\u0001\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u00067"}, m5598d2 = {"append", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "Lio/ktor/utils/io/core/Output;", "csq", "", "start", "", ViewProps.END, "", "fill", "", "times", "", "value", "", "fillFallback", "writeFully", ReactVideoViewManager.PROP_SRC, "Lio/ktor/utils/io/bits/Memory;", TypedValues.CycleType.S_WAVE_OFFSET, "length", "writeFully-p0stHsI", "(Lio/ktor/utils/io/core/Output;Ljava/nio/ByteBuffer;II)V", "writeFully-sqKbz-I", "(Lio/ktor/utils/io/core/Output;Ljava/nio/ByteBuffer;JJ)V", "Lio/ktor/utils/io/core/Buffer;", "Lio/ktor/utils/io/core/IoBuffer;", "", "", "", "", "", "", "writeFullyBytesTemplate", "block", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "currentOffset", NewHtcHomeBadger.COUNT, "initialOffset", "Lkotlin/Function4;", FirebaseAnalytics.Param.DESTINATION, "destinationOffset", "writeFullyTemplate", "componentSize", "writePacket", "packet", "Lio/ktor/utils/io/core/ByteReadPacket;", "writeWhile", "Lkotlin/Function1;", "", "writeWhileSize", "initialSize", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class OutputKt {
    public static /* synthetic */ Appendable append$default(Output output, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return append(output, charSequence, i, i2);
    }

    public static final Appendable append(Output output, CharSequence csq, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(csq, "csq");
        Appendable appendableAppend = output.append(csq, i, i2);
        Intrinsics.checkNotNullExpressionValue(appendableAppend, "append(csq, start, end)");
        return appendableAppend;
    }

    public static /* synthetic */ Appendable append$default(Output output, char[] cArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        return append(output, cArr, i, i2);
    }

    public static final Appendable append(Output output, char[] csq, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(csq, "csq");
        return output.append(csq, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Output output, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        writeFully(output, bArr, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Output output, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length - i;
        }
        writeFully(output, sArr, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Output output, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = iArr.length - i;
        }
        writeFully(output, iArr, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Output output, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length - i;
        }
        writeFully(output, jArr, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Output output, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length - i;
        }
        writeFully(output, fArr, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Output output, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length - i;
        }
        writeFully(output, dArr, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Output output, IoBuffer ioBuffer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            IoBuffer ioBuffer2 = ioBuffer;
            i = ioBuffer2.getWritePosition() - ioBuffer2.getReadPosition();
        }
        writeFully(output, ioBuffer, i);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ void writeFully(Output output, IoBuffer src, int i) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        writeFully(output, (Buffer) src, i);
    }

    /* JADX INFO: renamed from: writeFully-p0stHsI, reason: not valid java name */
    public static final void m7173writeFullyp0stHsI(Output writeFully, ByteBuffer src, int i, int i2) throws Throwable {
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(src, "src");
        m7174writeFullysqKbzI(writeFully, src, i, i2);
    }

    public static /* synthetic */ void fill$default(Output output, long j, byte b, int i, Object obj) {
        if ((i & 2) != 0) {
            b = 0;
        }
        fill(output, j, b);
    }

    public static final void fill(Output output, long j, byte b) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        if (!(output instanceof AbstractOutput)) {
            fillFallback(output, j, b);
            return;
        }
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, (ChunkBuffer) null);
        long j2 = 0;
        while (true) {
            try {
                int iMin = (int) Math.min(r4.getLimit() - r4.getWritePosition(), j - j2);
                BufferCompatibilityKt.fill((Buffer) chunkBufferPrepareWriteHead, iMin, b);
                j2 += (long) iMin;
                if (j2 >= j) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, chunkBufferPrepareWriteHead);
                }
            } finally {
                UnsafeKt.afterHeadWrite(output, chunkBufferPrepareWriteHead);
            }
        }
    }

    private static final void fillFallback(Output output, long j, byte b) {
        long j2 = 0;
        if (0 < j) {
            do {
                j2++;
                output.writeByte(b);
            } while (j2 < j);
        }
    }

    @DangerousInternalIoApi
    public static final void writeWhile(Output output, Function1<? super Buffer, Boolean> block) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, (ChunkBuffer) null);
        while (block.invoke(chunkBufferPrepareWriteHead).booleanValue()) {
            try {
                chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, chunkBufferPrepareWriteHead);
            } finally {
                InlineMarker.finallyStart(1);
                UnsafeKt.afterHeadWrite(output, chunkBufferPrepareWriteHead);
                InlineMarker.finallyEnd(1);
            }
        }
    }

    public static /* synthetic */ void writeWhileSize$default(Output output, int i, Function1 block, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i, (ChunkBuffer) null);
        while (true) {
            try {
                int iIntValue = ((Number) block.invoke(chunkBufferPrepareWriteHead)).intValue();
                if (iIntValue <= 0) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, iIntValue, chunkBufferPrepareWriteHead);
                }
            } finally {
                InlineMarker.finallyStart(1);
                UnsafeKt.afterHeadWrite(output, chunkBufferPrepareWriteHead);
                InlineMarker.finallyEnd(1);
            }
        }
    }

    @DangerousInternalIoApi
    public static final void writeWhileSize(Output output, int i, Function1<? super Buffer, Integer> block) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i, (ChunkBuffer) null);
        while (true) {
            try {
                int iIntValue = block.invoke(chunkBufferPrepareWriteHead).intValue();
                if (iIntValue <= 0) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, iIntValue, chunkBufferPrepareWriteHead);
                }
            } finally {
                InlineMarker.finallyStart(1);
                UnsafeKt.afterHeadWrite(output, chunkBufferPrepareWriteHead);
                InlineMarker.finallyEnd(1);
            }
        }
    }

    public static final void writePacket(Output output, ByteReadPacket packet) throws Throwable {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(packet, "packet");
        if (output instanceof BytePacketBuilderBase) {
            ((BytePacketBuilderBase) output).writePacket(packet);
            return;
        }
        ByteReadPacket byteReadPacket = packet;
        boolean z = true;
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead((Input) byteReadPacket, 1);
        if (chunkBufferM7223prepareReadFirstHead == null) {
            return;
        }
        do {
            try {
                writeFully$default(output, chunkBufferM7223prepareReadFirstHead, 0, 2, (Object) null);
            } catch (Throwable th) {
                th = th;
            }
            try {
                chunkBufferM7223prepareReadFirstHead = UnsafeKt.prepareReadNextHead(byteReadPacket, chunkBufferM7223prepareReadFirstHead);
            } catch (Throwable th2) {
                th = th2;
                z = false;
                if (z) {
                    UnsafeKt.completeReadHead(byteReadPacket, chunkBufferM7223prepareReadFirstHead);
                }
                throw th;
            }
        } while (chunkBufferM7223prepareReadFirstHead != null);
    }

    public static final void writeFully(Output output, byte[] src, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, (ChunkBuffer) null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min(i2, chunkBuffer.getLimit() - chunkBuffer.getWritePosition());
                BufferPrimitivesKt.writeFully((Buffer) chunkBuffer, src, i, iMin);
                i += iMin;
                i2 -= iMin;
                if (i2 <= 0) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, chunkBufferPrepareWriteHead);
                }
            } finally {
                UnsafeKt.afterHeadWrite(output, chunkBufferPrepareWriteHead);
            }
        }
    }

    public static final void writeFully(Output output, short[] src, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 2, (ChunkBuffer) null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min(i2, chunkBuffer.getLimit() - chunkBuffer.getWritePosition());
                BufferPrimitivesKt.writeFully((Buffer) chunkBuffer, src, i, iMin);
                i += iMin;
                i2 -= iMin;
                int i3 = i2 * 2;
                if (i3 <= 0) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i3, chunkBufferPrepareWriteHead);
                }
            } finally {
                UnsafeKt.afterHeadWrite(output, chunkBufferPrepareWriteHead);
            }
        }
    }

    public static final void writeFully(Output output, int[] src, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 4, (ChunkBuffer) null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min(i2, chunkBuffer.getLimit() - chunkBuffer.getWritePosition());
                BufferPrimitivesKt.writeFully((Buffer) chunkBuffer, src, i, iMin);
                i += iMin;
                i2 -= iMin;
                int i3 = i2 * 4;
                if (i3 <= 0) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i3, chunkBufferPrepareWriteHead);
                }
            } finally {
                UnsafeKt.afterHeadWrite(output, chunkBufferPrepareWriteHead);
            }
        }
    }

    public static final void writeFully(Output output, long[] src, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 8, (ChunkBuffer) null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min(i2, chunkBuffer.getLimit() - chunkBuffer.getWritePosition());
                BufferPrimitivesKt.writeFully((Buffer) chunkBuffer, src, i, iMin);
                i += iMin;
                i2 -= iMin;
                int i3 = i2 * 8;
                if (i3 <= 0) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i3, chunkBufferPrepareWriteHead);
                }
            } finally {
                UnsafeKt.afterHeadWrite(output, chunkBufferPrepareWriteHead);
            }
        }
    }

    public static final void writeFully(Output output, float[] src, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 4, (ChunkBuffer) null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min(i2, chunkBuffer.getLimit() - chunkBuffer.getWritePosition());
                BufferPrimitivesKt.writeFully((Buffer) chunkBuffer, src, i, iMin);
                i += iMin;
                i2 -= iMin;
                int i3 = i2 * 4;
                if (i3 <= 0) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i3, chunkBufferPrepareWriteHead);
                }
            } finally {
                UnsafeKt.afterHeadWrite(output, chunkBufferPrepareWriteHead);
            }
        }
    }

    public static final void writeFully(Output output, double[] src, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 8, (ChunkBuffer) null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min(i2, chunkBuffer.getLimit() - chunkBuffer.getWritePosition());
                BufferPrimitivesKt.writeFully(chunkBuffer, src, i, iMin);
                i += iMin;
                i2 -= iMin;
                int i3 = i2 * 8;
                if (i3 <= 0) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i3, chunkBufferPrepareWriteHead);
                }
            } finally {
                UnsafeKt.afterHeadWrite(output, chunkBufferPrepareWriteHead);
            }
        }
    }

    public static final void writeFully(Output output, Buffer src, int i) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, (ChunkBuffer) null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min(i, chunkBuffer.getLimit() - chunkBuffer.getWritePosition());
                BufferPrimitivesKt.writeFully(chunkBuffer, src, iMin);
                i -= iMin;
                if (i <= 0) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, chunkBufferPrepareWriteHead);
                }
            } finally {
                UnsafeKt.afterHeadWrite(output, chunkBufferPrepareWriteHead);
            }
        }
    }

    public static /* synthetic */ void writeFully$default(Output output, Buffer buffer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = buffer.getWritePosition() - buffer.getReadPosition();
        }
        writeFully(output, buffer, i);
    }

    /* JADX INFO: renamed from: writeFully-sqKbz-I, reason: not valid java name */
    public static final void m7174writeFullysqKbzI(Output writeFully, ByteBuffer src, long j, long j2) throws Throwable {
        ChunkBuffer chunkBuffer;
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(src, "src");
        long j3 = j;
        long j4 = j2;
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(writeFully, 1, (ChunkBuffer) null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer2 = chunkBufferPrepareWriteHead;
                long jMin = Math.min(j4, chunkBuffer2.getLimit() - chunkBuffer2.getWritePosition());
                chunkBuffer = chunkBufferPrepareWriteHead;
                try {
                    Memory.m6953copyToiAfECsU(src, chunkBuffer2.getMemory(), j3, jMin, chunkBuffer2.getWritePosition());
                    chunkBuffer2.commitWritten((int) jMin);
                    j3 += jMin;
                    j4 -= jMin;
                    if (j4 > 0) {
                        chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(writeFully, 1, chunkBuffer);
                    } else {
                        UnsafeKt.afterHeadWrite(writeFully, chunkBuffer);
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    UnsafeKt.afterHeadWrite(writeFully, chunkBuffer);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                chunkBuffer = chunkBufferPrepareWriteHead;
            }
        }
    }

    private static final void writeFullyBytesTemplate(Output output, int i, int i2, Function3<? super Buffer, ? super Integer, ? super Integer, Unit> function3) {
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, (ChunkBuffer) null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min(i2, chunkBuffer.getLimit() - chunkBuffer.getWritePosition());
                function3.invoke(chunkBuffer, Integer.valueOf(i), Integer.valueOf(iMin));
                i += iMin;
                i2 -= iMin;
                if (i2 <= 0) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, chunkBufferPrepareWriteHead);
                }
            } finally {
                InlineMarker.finallyStart(1);
                UnsafeKt.afterHeadWrite(output, chunkBufferPrepareWriteHead);
                InlineMarker.finallyEnd(1);
            }
        }
    }

    private static final void writeFullyBytesTemplate(Output output, long j, long j2, Function4<? super Memory, ? super Long, ? super Long, ? super Long, Unit> function4) {
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, (ChunkBuffer) null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                long jMin = Math.min(j2, chunkBuffer.getLimit() - chunkBuffer.getWritePosition());
                function4.invoke(Memory.m6950boximpl(chunkBuffer.getMemory()), Long.valueOf(chunkBuffer.getWritePosition()), Long.valueOf(j), Long.valueOf(jMin));
                chunkBuffer.commitWritten((int) jMin);
                j += jMin;
                j2 -= jMin;
                if (j2 <= 0) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, chunkBufferPrepareWriteHead);
                }
            } finally {
                InlineMarker.finallyStart(1);
                UnsafeKt.afterHeadWrite(output, chunkBufferPrepareWriteHead);
                InlineMarker.finallyEnd(1);
            }
        }
    }

    private static final void writeFullyTemplate(Output output, int i, int i2, int i3, Function3<? super Buffer, ? super Integer, ? super Integer, Unit> function3) {
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i, (ChunkBuffer) null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min(i3, chunkBuffer.getLimit() - chunkBuffer.getWritePosition());
                function3.invoke(chunkBuffer, Integer.valueOf(i2), Integer.valueOf(iMin));
                i2 += iMin;
                i3 -= iMin;
                int i4 = i3 * i;
                if (i4 <= 0) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i4, chunkBufferPrepareWriteHead);
                }
            } finally {
                InlineMarker.finallyStart(1);
                UnsafeKt.afterHeadWrite(output, chunkBufferPrepareWriteHead);
                InlineMarker.finallyEnd(1);
            }
        }
    }
}
