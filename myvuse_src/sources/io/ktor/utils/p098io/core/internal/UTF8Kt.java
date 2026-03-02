package io.ktor.utils.p098io.core.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.uimanager.ViewProps;
import com.yoti.mobile.mpp.smartcard.ISO7816Kt;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: UTF8.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000d\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0014\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0001\u001a\u0011\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0082\b\u001a\u0018\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0000\u001aK\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\u0013\u001a\u00020\u00012$\u0010\u0014\u001a \b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0015H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u0001H\u0001\u001a\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0001H\u0001\u001a\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u0001H\u0001\u001a\u0010\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u0001H\u0001\u001a\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0001H\u0001\u001a\u0010\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0001H\u0001\u001a\u0010\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\u0001H\u0002\u001a$\u0010&\u001a\u00020\u000f*\u00020'2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0)H\u0080\bø\u0001\u0001\u001a$\u0010*\u001a\u00020\u0001*\u00020'2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0)H\u0087\bø\u0001\u0001\u001a$\u0010*\u001a\u00020\u0001*\u00020+2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0)H\u0087\bø\u0001\u0001\u001a>\u0010,\u001a\u00020-*\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001aN\u00107\u001a\u00020-*\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00108\u001a\u00020\u00012\u0006\u00109\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001aN\u0010>\u001a\u00020-*\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00108\u001a\u00020\u00012\u0006\u00109\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b?\u0010=\u001a'\u0010@\u001a\u00020\u0001*\u00020.2\u0006\u0010A\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0080\bø\u0001\u0000¢\u0006\u0004\bB\u0010C\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006D"}, m5598d2 = {"HighSurrogateMagic", "", "MaxCodePoint", "MinHighSurrogate", "MinLowSurrogate", "MinSupplementary", "byteCountUtf8", "firstByte", "charactersSize", "v", "codePoint", "high", "", "low", "decodeUTF8LineLoopSuspend", "", "out", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "limit", "nextChunk", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lio/ktor/utils/io/core/AbstractInput;", "", "(Ljava/lang/Appendable;ILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "highSurrogate", "cp", "isBmpCodePoint", "isValidCodePoint", "lowSurrogate", "malformedByteCount", "", "byteCount", "malformedCodePoint", "value", "prematureEndOfStreamUtf", "size", "decodeASCII", "Lio/ktor/utils/io/core/Buffer;", "consumer", "Lkotlin/Function1;", "decodeUTF8", "Lio/ktor/utils/io/core/IoBuffer;", "encodeUTF8", "Lio/ktor/utils/io/core/internal/EncodeResult;", "Lio/ktor/utils/io/bits/Memory;", "text", "", "from", TypedValues.TransitionType.S_TO, "dstOffset", "dstLimit", "encodeUTF8-3CNuoPE", "(Ljava/nio/ByteBuffer;Ljava/lang/CharSequence;IIII)I", "encodeUTF8Stage1", "index1", "lastCharIndex", "resultPosition1", "resultLimit", "encodeUTF8Stage1-eX5EW5U", "(Ljava/nio/ByteBuffer;Ljava/lang/CharSequence;IIIIII)I", "encodeUTF8Stage2", "encodeUTF8Stage2-eX5EW5U", "putUtf8Char", TypedValues.CycleType.S_WAVE_OFFSET, "putUtf8Char-5Mw_xsg", "(Ljava/nio/ByteBuffer;II)I", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class UTF8Kt {
    private static final int HighSurrogateMagic = 55232;
    private static final int MaxCodePoint = 1114111;
    private static final int MinHighSurrogate = 55296;
    private static final int MinLowSurrogate = 56320;
    private static final int MinSupplementary = 65536;

    /* JADX INFO: renamed from: io.ktor.utils.io.core.internal.UTF8Kt$decodeUTF8LineLoopSuspend$1 */
    /* JADX INFO: compiled from: UTF8.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.core.internal.UTF8Kt", m5608f = "UTF8.kt", m5609i = {0, 0, 0, 0, 0, 0, 0}, m5610l = {35}, m5611m = "decodeUTF8LineLoopSuspend", m5612n = {"out", "nextChunk", "decoded", "size", "cr", ViewProps.END, "limit"}, m5613s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"})
    static final class C53401 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C53401(Continuation<? super C53401> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UTF8Kt.decodeUTF8LineLoopSuspend(null, 0, null, this);
        }
    }

    @DangerousInternalIoApi
    public static final int byteCountUtf8(int i) {
        int i2 = 0;
        int i3 = 128;
        int i4 = 1;
        do {
            i4++;
            if ((i & i3) == 0) {
                break;
            }
            i &= ~i3;
            i3 >>= 1;
            i2++;
        } while (i4 <= 6);
        return i2;
    }

    public static final int codePoint(char c, char c2) {
        return ((c - 55232) << 10) | (c2 - CharCompanionObject.MIN_LOW_SURROGATE);
    }

    public static final int highSurrogate(int i) {
        return (i >>> 10) + 55232;
    }

    public static final boolean isBmpCodePoint(int i) {
        return (i >>> 16) == 0;
    }

    public static final boolean isValidCodePoint(int i) {
        return i <= MaxCodePoint;
    }

    public static final int lowSurrogate(int i) {
        return (i & 1023) + 56320;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x021e, code lost:
    
        r0.discardExact(((r12 - r3) - r13.element) + r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x026d, code lost:
    
        r5 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x026e, code lost:
    
        r7.element = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x027c, code lost:
    
        r14.element = r5 ? 1 : 0;
        r5 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0283, code lost:
    
        r7.element = r5;
        r5 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x02b4, code lost:
    
        r0.discardExact(((r12 - r3) - r13.element) + r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x012a, code lost:
    
        r7.element = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0145, code lost:
    
        r0.discardExact(r12 - r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0149, code lost:
    
        r9 = r19;
        r3 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x014d, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0202, code lost:
    
        r5 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0203, code lost:
    
        r7.element = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:108:0x0254, B:86:0x01f7], limit reached: 253 */
    /* JADX WARN: Path cross not found for [B:185:0x0398, B:189:0x03ab], limit reached: 253 */
    /* JADX WARN: Path cross not found for [B:51:0x0135, B:222:0x0125], limit reached: 253 */
    /* JADX WARN: Path cross not found for [B:69:0x018f, B:40:0x011e], limit reached: 253 */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0318 A[LOOP:1: B:36:0x00fc->B:157:0x0318, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0317 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Type inference failed for: r5v15, types: [int] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v58 */
    /* JADX WARN: Type inference failed for: r5v59 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00a0 -> B:23:0x00a5). Please report as a decompilation issue!!! */
    @io.ktor.utils.p098io.core.internal.DangerousInternalIoApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object decodeUTF8LineLoopSuspend(java.lang.Appendable r27, int r28, kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super kotlin.coroutines.Continuation<? super io.ktor.utils.p098io.core.AbstractInput>, ? extends java.lang.Object> r29, kotlin.coroutines.Continuation<? super java.lang.Boolean> r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1031
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.core.internal.UTF8Kt.decodeUTF8LineLoopSuspend(java.lang.Appendable, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Void prematureEndOfStreamUtf(int i) throws EOFException {
        throw new EOFException("Premature end of stream: expected " + i + " bytes to decode UTF-8 char");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cc, code lost:
    
        r13.discardExact(((r4 - r1) - r7) + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:?, code lost:
    
        return -1;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e0 A[LOOP:0: B:5:0x001f->B:44:0x00e0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e3 A[EDGE_INSN: B:54:0x00e3->B:45:0x00e3 BREAK  A[LOOP:0: B:5:0x001f->B:44:0x00e0], SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ int decodeUTF8(io.ktor.utils.p098io.core.IoBuffer r13, kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> r14) throws io.ktor.utils.p098io.core.internal.MalformedUTF8InputException {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.core.internal.UTF8Kt.decodeUTF8(io.ktor.utils.io.core.IoBuffer, kotlin.jvm.functions.Function1):int");
    }

    /* JADX INFO: renamed from: encodeUTF8-3CNuoPE, reason: not valid java name */
    public static final int m7219encodeUTF83CNuoPE(ByteBuffer encodeUTF8, CharSequence text, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(encodeUTF8, "$this$encodeUTF8");
        Intrinsics.checkNotNullParameter(text, "text");
        int iMin = Math.min(i2, i + 65535);
        int iCoerceAtMost = RangesKt.coerceAtMost(i4, 65535);
        int i5 = i;
        int i6 = i3;
        while (i6 < iCoerceAtMost && i5 < iMin) {
            int i7 = i5 + 1;
            char cCharAt = text.charAt(i5);
            int i8 = cCharAt & CharCompanionObject.MAX_VALUE;
            if ((cCharAt & 65408) != 0) {
                return m7220encodeUTF8Stage1eX5EW5U(encodeUTF8, text, i5, iMin, i, i6, iCoerceAtMost, i3);
            }
            encodeUTF8.put(i6, (byte) i8);
            i5 = i7;
            i6++;
        }
        return EncodeResult.m7211constructorimpl(UShort.m7514constructorimpl((short) (i5 - i)), UShort.m7514constructorimpl((short) (i6 - i3)));
    }

    /* JADX INFO: renamed from: encodeUTF8Stage1-eX5EW5U, reason: not valid java name */
    private static final int m7220encodeUTF8Stage1eX5EW5U(ByteBuffer byteBuffer, CharSequence charSequence, int i, int i2, int i3, int i4, int i5, int i6) {
        int iCodePoint;
        int i7;
        int i8 = i5 - 3;
        int i9 = i;
        int i10 = i4;
        while (i8 - i10 > 0 && i9 < i2) {
            int i11 = i9 + 1;
            char cCharAt = charSequence.charAt(i9);
            if (!Character.isHighSurrogate(cCharAt)) {
                i9 = i11;
                iCodePoint = cCharAt;
            } else if (i11 == i2 || !Character.isLowSurrogate(charSequence.charAt(i11))) {
                i9 = i11;
                iCodePoint = 63;
            } else {
                i9 += 2;
                iCodePoint = codePoint(cCharAt, charSequence.charAt(i11));
            }
            if (iCodePoint >= 0 && iCodePoint <= 127) {
                byteBuffer.put(i10, (byte) iCodePoint);
                i7 = 1;
            } else if (128 <= iCodePoint && iCodePoint <= 2047) {
                byteBuffer.put(i10, (byte) (((iCodePoint >> 6) & 31) | JfifUtil.MARKER_SOFn));
                byteBuffer.put(i10 + 1, (byte) (128 | (iCodePoint & 63)));
                i7 = 2;
            } else if (2048 <= iCodePoint && iCodePoint <= 65535) {
                byteBuffer.put(i10, (byte) (((iCodePoint >> 12) & 15) | ISO7816Kt.INS_CREATE_FILE));
                byteBuffer.put(i10 + 1, (byte) ((63 & (iCodePoint >> 6)) | 128));
                byteBuffer.put(i10 + 2, (byte) (128 | (iCodePoint & 63)));
                i7 = 3;
            } else {
                if (65536 > iCodePoint || iCodePoint > MaxCodePoint) {
                    malformedCodePoint(iCodePoint);
                    throw new KotlinNothingValueException();
                }
                byteBuffer.put(i10, (byte) (((iCodePoint >> 18) & 7) | 240));
                byteBuffer.put(i10 + 1, (byte) (((iCodePoint >> 12) & 63) | 128));
                byteBuffer.put(i10 + 2, (byte) ((63 & (iCodePoint >> 6)) | 128));
                byteBuffer.put(i10 + 3, (byte) (128 | (iCodePoint & 63)));
                i7 = 4;
            }
            i10 += i7;
        }
        if (i10 == i8) {
            return m7221encodeUTF8Stage2eX5EW5U(byteBuffer, charSequence, i9, i2, i3, i10, i5, i6);
        }
        return EncodeResult.m7211constructorimpl(UShort.m7514constructorimpl((short) (i9 - i3)), UShort.m7514constructorimpl((short) (i10 - i6)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00eb, code lost:
    
        malformedCodePoint(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f3, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0106, code lost:
    
        return io.ktor.utils.p098io.core.internal.EncodeResult.m7211constructorimpl(kotlin.UShort.m7514constructorimpl((short) (r3 - r21)), kotlin.UShort.m7514constructorimpl((short) (r4 - r24)));
     */
    /* JADX INFO: renamed from: encodeUTF8Stage2-eX5EW5U, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final int m7221encodeUTF8Stage2eX5EW5U(java.nio.ByteBuffer r17, java.lang.CharSequence r18, int r19, int r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instruction units count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.core.internal.UTF8Kt.m7221encodeUTF8Stage2eX5EW5U(java.nio.ByteBuffer, java.lang.CharSequence, int, int, int, int, int, int):int");
    }

    private static final int charactersSize(int i) {
        if (1 <= i && i <= 127) {
            return 1;
        }
        if (128 <= i && i <= 2047) {
            return 2;
        }
        if (2048 <= i && i <= 65535) {
            return 3;
        }
        if (65536 <= i && i <= MaxCodePoint) {
            return 4;
        }
        malformedCodePoint(i);
        throw new KotlinNothingValueException();
    }

    public static final Void malformedByteCount(int i) throws MalformedUTF8InputException {
        throw new MalformedUTF8InputException("Expected " + i + " more character bytes");
    }

    public static final Void malformedCodePoint(int i) {
        throw new IllegalArgumentException("Malformed code-point " + i + " found");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
    
        r8.discardExact(r3 - r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean decodeASCII(io.ktor.utils.p098io.core.Buffer r8, kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "consumer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.nio.ByteBuffer r0 = r8.getMemory()
            int r1 = r8.getReadPosition()
            int r2 = r8.getWritePosition()
            if (r1 >= r2) goto L43
            r3 = r1
        L19:
            int r4 = r3 + 1
            byte r5 = r0.get(r3)
            r6 = r5 & 255(0xff, float:3.57E-43)
            r7 = 128(0x80, float:1.8E-43)
            r5 = r5 & r7
            if (r5 == r7) goto L3d
            char r5 = (char) r6
            java.lang.Character r5 = java.lang.Character.valueOf(r5)
            java.lang.Object r5 = r9.invoke(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L38
            goto L3d
        L38:
            if (r4 < r2) goto L3b
            goto L43
        L3b:
            r3 = r4
            goto L19
        L3d:
            int r3 = r3 - r1
            r8.discardExact(r3)
            r8 = 0
            return r8
        L43:
            int r2 = r2 - r1
            r8.discardExact(r2)
            r8 = 1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.core.internal.UTF8Kt.decodeASCII(io.ktor.utils.io.core.Buffer, kotlin.jvm.functions.Function1):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c6, code lost:
    
        r13.discardExact(((r4 - r1) - r7) + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00cc, code lost:
    
        return -1;
     */
    @io.ktor.utils.p098io.core.internal.DangerousInternalIoApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int decodeUTF8(io.ktor.utils.p098io.core.Buffer r13, kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> r14) throws io.ktor.utils.p098io.core.internal.MalformedUTF8InputException {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.core.internal.UTF8Kt.decodeUTF8(io.ktor.utils.io.core.Buffer, kotlin.jvm.functions.Function1):int");
    }

    /* JADX INFO: renamed from: putUtf8Char-5Mw_xsg, reason: not valid java name */
    public static final int m7222putUtf8Char5Mw_xsg(ByteBuffer putUtf8Char, int i, int i2) {
        Intrinsics.checkNotNullParameter(putUtf8Char, "$this$putUtf8Char");
        if (i2 >= 0 && i2 <= 127) {
            putUtf8Char.put(i, (byte) i2);
            return 1;
        }
        if (128 <= i2 && i2 <= 2047) {
            putUtf8Char.put(i, (byte) (((i2 >> 6) & 31) | JfifUtil.MARKER_SOFn));
            putUtf8Char.put(i + 1, (byte) ((i2 & 63) | 128));
            return 2;
        }
        if (2048 <= i2 && i2 <= 65535) {
            putUtf8Char.put(i, (byte) (((i2 >> 12) & 15) | ISO7816Kt.INS_CREATE_FILE));
            putUtf8Char.put(i + 1, (byte) (((i2 >> 6) & 63) | 128));
            putUtf8Char.put(i + 2, (byte) ((i2 & 63) | 128));
            return 3;
        }
        if (65536 > i2 || i2 > MaxCodePoint) {
            malformedCodePoint(i2);
            throw new KotlinNothingValueException();
        }
        putUtf8Char.put(i, (byte) (((i2 >> 18) & 7) | 240));
        putUtf8Char.put(i + 1, (byte) (((i2 >> 12) & 63) | 128));
        putUtf8Char.put(i + 2, (byte) (((i2 >> 6) & 63) | 128));
        putUtf8Char.put(i + 3, (byte) ((i2 & 63) | 128));
        return 4;
    }
}
