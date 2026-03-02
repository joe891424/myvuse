package io.ktor.utils.p098io.charsets;

import com.salesforce.marketingcloud.storage.p047db.C4352k;
import io.ktor.utils.p098io.bits.Memory;
import io.ktor.utils.p098io.core.AbstractInput;
import io.ktor.utils.p098io.core.Buffer;
import io.ktor.utils.p098io.core.Input;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.core.internal.UnsafeKt;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.MalformedInputException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CharsetJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0014\u001a\u00020\u0001*\u00060\tj\u0002`\n2\u0006\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010\u001a\u001a\u00020\u0001\u001a6\u0010\u001b\u001a\u00020\u0001*\u00060\tj\u0002`\n2\u0006\u0010\u0015\u001a\u00020\u001c2\n\u0010\u001d\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u001a\u001a\u00020\u0001H\u0000\u001a\u001e\u0010 \u001a\u00020\u0011*\u00060\tj\u0002`\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0001\u001a \u0010\"\u001a\u00020\u0011*\u00060\tj\u0002`\n2\u0006\u0010\u0015\u001a\u00020#2\u0006\u0010!\u001a\u00020\u0001H\u0002\u001a \u0010$\u001a\u00020\u0011*\u00060\tj\u0002`\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0001H\u0002\u001a\u0018\u0010%\u001a\u00020\u001f*\u00060\rj\u0002`\u000e2\u0006\u0010\u0017\u001a\u00020\u001cH\u0000\u001a0\u0010&\u001a\u00020\u0001*\u00060\rj\u0002`\u000e2\u0006\u0010\u0015\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u001cH\u0000\u001a*\u0010*\u001a\u00020+*\u00060\rj\u0002`\u000e2\u0006\u0010\u0015\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u0001\u001a(\u0010,\u001a\u00020+*\u00060\rj\u0002`\u000e2\u0006\u0010\u0015\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u0001H\u0002\u001a\u001e\u0010-\u001a\u00020.*\u00060\rj\u0002`\u000e2\u0006\u0010\u0015\u001a\u00020/2\u0006\u0010\u0017\u001a\u000200\u001a\f\u00101\u001a\u00020.*\u000202H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001d\u0010\u0006\u001a\u00060\u0007j\u0002`\b*\u00060\tj\u0002`\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u001d\u0010\u0006\u001a\u00060\u0007j\u0002`\b*\u00060\rj\u0002`\u000e8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u000f\"\u0019\u0010\u0010\u001a\u00020\u0011*\u00060\u0007j\u0002`\b8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013*\n\u00103\"\u00020\u00072\u00020\u0007*\n\u00104\"\u00020\t2\u00020\t*\n\u00105\"\u00020\r2\u00020\r*\n\u00106\"\u0002072\u000207¨\u00068"}, m5598d2 = {"DECODE_CHAR_BUFFER_SIZE", "", "EmptyByteBuffer", "Ljava/nio/ByteBuffer;", "EmptyCharBuffer", "Ljava/nio/CharBuffer;", "charset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "Ljava/nio/charset/CharsetDecoder;", "Lio/ktor/utils/io/charsets/CharsetDecoder;", "getCharset", "(Ljava/nio/charset/CharsetDecoder;)Ljava/nio/charset/Charset;", "Ljava/nio/charset/CharsetEncoder;", "Lio/ktor/utils/io/charsets/CharsetEncoder;", "(Ljava/nio/charset/CharsetEncoder;)Ljava/nio/charset/Charset;", "name", "", "getName", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "decode", "input", "Lio/ktor/utils/io/core/Input;", C4352k.a.f5652f, "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "max", "decodeBuffer", "Lio/ktor/utils/io/core/Buffer;", "out", "lastBuffer", "", "decodeExactBytes", "inputLength", "decodeImplByteBuffer", "Lio/ktor/utils/io/core/AbstractInput;", "decodeImplSlow", "encodeComplete", "encodeImpl", "", "fromIndex", "toIndex", "encodeToByteArray", "", "encodeToByteArraySlow", "encodeUTF8", "", "Lio/ktor/utils/io/core/ByteReadPacket;", "Lio/ktor/utils/io/core/Output;", "throwExceptionWrapped", "Ljava/nio/charset/CoderResult;", "Charset", "CharsetDecoder", "CharsetEncoder", "Charsets", "Lkotlin/text/Charsets;", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class CharsetJVMKt {
    private static final int DECODE_CHAR_BUFFER_SIZE = 8192;
    private static final ByteBuffer EmptyByteBuffer;
    private static final CharBuffer EmptyCharBuffer;

    public static /* synthetic */ void Charset$annotations() {
    }

    public static final String getName(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "<this>");
        String strName = charset.name();
        Intrinsics.checkNotNullExpressionValue(strName, "name()");
        return strName;
    }

    public static final Charset getCharset(CharsetEncoder charsetEncoder) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Charset charset = charsetEncoder.charset();
        Intrinsics.checkNotNullExpressionValue(charset, "charset()");
        return charset;
    }

    public static final byte[] encodeToByteArray(CharsetEncoder charsetEncoder, CharSequence input, int i, int i2) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        if (input instanceof String) {
            if (i == 0 && i2 == input.length()) {
                byte[] bytes = ((String) input).getBytes(charsetEncoder.charset());
                Intrinsics.checkNotNullExpressionValue(bytes, "input as java.lang.String).getBytes(charset())");
                return bytes;
            }
            String strSubstring = ((String) input).substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            byte[] bytes2 = strSubstring.getBytes(charsetEncoder.charset());
            Intrinsics.checkNotNullExpressionValue(bytes2, "input.substring(fromInde…ring).getBytes(charset())");
            return bytes2;
        }
        return encodeToByteArraySlow(charsetEncoder, input, i, i2);
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return encodeToByteArray(charsetEncoder, charSequence, i, i2);
    }

    private static final byte[] encodeToByteArraySlow(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2) throws CharacterCodingException {
        byte[] bArrArray;
        ByteBuffer byteBufferEncode = charsetEncoder.encode(CharBuffer.wrap(charSequence, i, i2));
        byte[] bArr = null;
        if (byteBufferEncode.hasArray() && byteBufferEncode.arrayOffset() == 0 && (bArrArray = byteBufferEncode.array()) != null && bArrArray.length == byteBufferEncode.remaining()) {
            bArr = bArrArray;
        }
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[byteBufferEncode.remaining()];
        byteBufferEncode.get(bArr2);
        return bArr2;
    }

    public static final int encodeImpl(CharsetEncoder charsetEncoder, CharSequence input, int i, int i2, Buffer dst) throws CharacterCodingException {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(dst, "dst");
        CharBuffer charBufferWrap = CharBuffer.wrap(input, i, i2);
        int iRemaining = charBufferWrap.remaining();
        ByteBuffer memory = dst.getMemory();
        int writePosition = dst.getWritePosition();
        int limit = dst.getLimit() - writePosition;
        ByteBuffer byteBufferM6961sliceSK3TCg8 = Memory.m6961sliceSK3TCg8(memory, writePosition, limit);
        CoderResult result = charsetEncoder.encode(charBufferWrap, byteBufferM6961sliceSK3TCg8, false);
        if (result.isMalformed() || result.isUnmappable()) {
            Intrinsics.checkNotNullExpressionValue(result, "result");
            throwExceptionWrapped(result);
        }
        if (!(byteBufferM6961sliceSK3TCg8.limit() == limit)) {
            throw new IllegalStateException("Buffer's limit change is not allowed".toString());
        }
        dst.commitWritten(byteBufferM6961sliceSK3TCg8.position());
        return iRemaining - charBufferWrap.remaining();
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x01ff, code lost:
    
        r20 = r3;
        r21 = r4;
        r25 = r5;
        r23 = r7;
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x012e, code lost:
    
        r14.discardExact(((r13 - r12) - r19) + 1);
        r10 = r10;
        r20 = r20;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0144 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0145 A[LOOP:1: B:17:0x007d->B:61:0x0145, LOOP_END] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [io.ktor.utils.io.core.internal.ChunkBuffer] */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v34 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void encodeUTF8(java.nio.charset.CharsetEncoder r26, io.ktor.utils.p098io.core.ByteReadPacket r27, io.ktor.utils.p098io.core.Output r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 723
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.charsets.CharsetJVMKt.encodeUTF8(java.nio.charset.CharsetEncoder, io.ktor.utils.io.core.ByteReadPacket, io.ktor.utils.io.core.Output):void");
    }

    public static /* synthetic */ int decodeBuffer$default(CharsetDecoder charsetDecoder, Buffer buffer, Appendable appendable, boolean z, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = Integer.MAX_VALUE;
        }
        return decodeBuffer(charsetDecoder, buffer, appendable, z, i);
    }

    public static final Charset getCharset(CharsetDecoder charsetDecoder) {
        Intrinsics.checkNotNullParameter(charsetDecoder, "<this>");
        Charset charset = charsetDecoder.charset();
        Intrinsics.checkNotNull(charset);
        return charset;
    }

    public static final int decode(CharsetDecoder charsetDecoder, Input input, Appendable dst, int i) throws Throwable {
        CoderResult cr;
        ChunkBuffer chunkBuffer;
        int writePosition;
        ChunkBuffer chunkBufferPrepareReadNextHead;
        Intrinsics.checkNotNullParameter(charsetDecoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(dst, "dst");
        CharBuffer charBufferAllocate = CharBuffer.allocate(8192);
        boolean z = true;
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 1);
        int iRemaining = 0;
        if (chunkBufferM7223prepareReadFirstHead != null) {
            int i2 = 1;
            int i3 = 1;
            int iRemaining2 = 0;
            while (true) {
                try {
                    writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                } catch (Throwable th) {
                    th = th;
                }
                if (writePosition >= i2) {
                    try {
                        ChunkBuffer chunkBuffer2 = chunkBufferM7223prepareReadFirstHead;
                        int i4 = i - iRemaining2;
                        if (i4 != 0) {
                            ByteBuffer memory = chunkBuffer2.getMemory();
                            int readPosition = chunkBuffer2.getReadPosition();
                            int writePosition2 = chunkBuffer2.getWritePosition() - readPosition;
                            ByteBuffer byteBufferM6961sliceSK3TCg8 = Memory.m6961sliceSK3TCg8(memory, readPosition, writePosition2);
                            if (i4 < 8192) {
                            }
                            CoderResult rc = charsetDecoder.decode(byteBufferM6961sliceSK3TCg8, charBufferAllocate, false);
                            iRemaining2 += charBufferAllocate.remaining();
                            dst.append(charBufferAllocate);
                            if (rc.isMalformed() || rc.isUnmappable()) {
                                Intrinsics.checkNotNullExpressionValue(rc, "rc");
                                throwExceptionWrapped(rc);
                            }
                            i3 = (rc.isUnderflow() && byteBufferM6961sliceSK3TCg8.hasRemaining()) ? i3 + 1 : 1;
                            if (!(byteBufferM6961sliceSK3TCg8.limit() == writePosition2)) {
                                throw new IllegalStateException("Buffer's limit change is not allowed".toString());
                            }
                            chunkBuffer2.discardExact(byteBufferM6961sliceSK3TCg8.position());
                            i2 = i3;
                            th = th;
                            if (z) {
                                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            }
                            throw th;
                        }
                        i2 = 0;
                        writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                    } finally {
                    }
                }
                if (writePosition == 0) {
                    try {
                        chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadNextHead(input, chunkBufferM7223prepareReadFirstHead);
                    } catch (Throwable th2) {
                        th = th2;
                        z = false;
                    }
                } else if (writePosition >= i2) {
                    ChunkBuffer chunkBuffer3 = chunkBufferM7223prepareReadFirstHead;
                    if (chunkBuffer3.getCapacity() - chunkBuffer3.getLimit() < 8) {
                        UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                        chunkBufferPrepareReadNextHead = UnsafeKt.m7223prepareReadFirstHead(input, i2);
                    } else {
                        chunkBufferPrepareReadNextHead = chunkBufferM7223prepareReadFirstHead;
                    }
                } else {
                    UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                    chunkBufferPrepareReadNextHead = UnsafeKt.m7223prepareReadFirstHead(input, i2);
                }
                if (chunkBufferPrepareReadNextHead == null) {
                    break;
                }
                if (i2 <= 0) {
                    iRemaining = 1;
                    chunkBufferM7223prepareReadFirstHead = chunkBufferPrepareReadNextHead;
                    break;
                }
                chunkBufferM7223prepareReadFirstHead = chunkBufferPrepareReadNextHead;
            }
            if (iRemaining != 0) {
                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
            }
            iRemaining = iRemaining2;
        }
        do {
            int i5 = i - iRemaining;
            if (i5 == 0) {
                break;
            }
            if (i5 < 8192) {
            }
            cr = charsetDecoder.decode(EmptyByteBuffer, charBufferAllocate, true);
            iRemaining += charBufferAllocate.remaining();
            dst.append(charBufferAllocate);
            if (cr.isUnmappable() || cr.isMalformed()) {
                Intrinsics.checkNotNullExpressionValue(cr, "cr");
                throwExceptionWrapped(cr);
            }
        } while (cr.isOverflow());
        return iRemaining;
    }

    public static final String decodeExactBytes(CharsetDecoder charsetDecoder, Input input, int i) throws EOFException {
        Intrinsics.checkNotNullParameter(charsetDecoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        if (i == 0) {
            return "";
        }
        if (input instanceof AbstractInput) {
            AbstractInput abstractInput = (AbstractInput) input;
            if (abstractInput.getHeadEndExclusive() - abstractInput.getHeadPosition() >= i) {
                if (abstractInput.m7099getHeadMemorySK3TCg8().hasArray()) {
                    ByteBuffer byteBufferM7099getHeadMemorySK3TCg8 = abstractInput.m7099getHeadMemorySK3TCg8();
                    byte[] bArrArray = byteBufferM7099getHeadMemorySK3TCg8.array();
                    Intrinsics.checkNotNullExpressionValue(bArrArray, "bb.array()");
                    int iArrayOffset = byteBufferM7099getHeadMemorySK3TCg8.arrayOffset() + byteBufferM7099getHeadMemorySK3TCg8.position() + abstractInput.getHead().getReadPosition();
                    Charset charset = charsetDecoder.charset();
                    Intrinsics.checkNotNullExpressionValue(charset, "charset()");
                    String str = new String(bArrArray, iArrayOffset, i, charset);
                    abstractInput.discardExact(i);
                    return str;
                }
                return decodeImplByteBuffer(charsetDecoder, abstractInput, i);
            }
        }
        return decodeImplSlow(charsetDecoder, input, i);
    }

    private static final String decodeImplByteBuffer(CharsetDecoder charsetDecoder, AbstractInput abstractInput, int i) throws CharacterCodingException, EOFException {
        CharBuffer charBufferAllocate = CharBuffer.allocate(i);
        ByteBuffer byteBufferM6961sliceSK3TCg8 = Memory.m6961sliceSK3TCg8(abstractInput.m7099getHeadMemorySK3TCg8(), abstractInput.getHead().getReadPosition(), i);
        CoderResult rc = charsetDecoder.decode(byteBufferM6961sliceSK3TCg8, charBufferAllocate, true);
        if (rc.isMalformed() || rc.isUnmappable()) {
            Intrinsics.checkNotNullExpressionValue(rc, "rc");
            throwExceptionWrapped(rc);
        }
        abstractInput.discardExact(byteBufferM6961sliceSK3TCg8.position());
        String string = charBufferAllocate.toString();
        Intrinsics.checkNotNullExpressionValue(string, "cb.toString()");
        return string;
    }

    private static final String decodeImplSlow(CharsetDecoder charsetDecoder, Input input, int i) throws Throwable {
        int iPosition;
        ChunkBuffer chunkBuffer;
        ChunkBuffer chunkBufferPrepareReadNextHead;
        boolean z;
        boolean z2;
        CharBuffer charBufferAllocate = CharBuffer.allocate(i);
        boolean z3 = true;
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 1);
        if (chunkBufferM7223prepareReadFirstHead == null) {
            iPosition = i;
            z2 = false;
        } else {
            iPosition = i;
            int i2 = 1;
            int i3 = 1;
            boolean z4 = false;
            while (true) {
                try {
                    int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                    if (writePosition >= i2) {
                        try {
                            ChunkBuffer chunkBuffer2 = chunkBufferM7223prepareReadFirstHead;
                            if (!charBufferAllocate.hasRemaining() || iPosition == 0) {
                                i2 = 0;
                            } else {
                                ByteBuffer memory = chunkBuffer2.getMemory();
                                int readPosition = chunkBuffer2.getReadPosition();
                                int writePosition2 = chunkBuffer2.getWritePosition() - readPosition;
                                ByteBuffer byteBufferM6961sliceSK3TCg8 = Memory.m6961sliceSK3TCg8(memory, readPosition, writePosition2);
                                int iLimit = byteBufferM6961sliceSK3TCg8.limit();
                                int iPosition2 = byteBufferM6961sliceSK3TCg8.position();
                                boolean z5 = iLimit - iPosition2 >= iPosition;
                                if (z5) {
                                }
                                CoderResult rc = charsetDecoder.decode(byteBufferM6961sliceSK3TCg8, charBufferAllocate, z5);
                                if (rc.isMalformed() || rc.isUnmappable()) {
                                    Intrinsics.checkNotNullExpressionValue(rc, "rc");
                                    throwExceptionWrapped(rc);
                                }
                                i3 = (rc.isUnderflow() && byteBufferM6961sliceSK3TCg8.hasRemaining()) ? i3 + 1 : 1;
                                iPosition -= byteBufferM6961sliceSK3TCg8.position() - iPosition2;
                                if (!(byteBufferM6961sliceSK3TCg8.limit() == writePosition2)) {
                                    throw new IllegalStateException("Buffer's limit change is not allowed".toString());
                                }
                                chunkBuffer2.discardExact(byteBufferM6961sliceSK3TCg8.position());
                                i2 = i3;
                                z4 = z5;
                            }
                            ChunkBuffer chunkBuffer3 = chunkBufferM7223prepareReadFirstHead;
                            writePosition = chunkBuffer3.getWritePosition() - chunkBuffer3.getReadPosition();
                        } finally {
                            chunkBuffer = chunkBufferM7223prepareReadFirstHead;
                            chunkBuffer.getWritePosition();
                            chunkBuffer.getReadPosition();
                        }
                    }
                    if (writePosition == 0) {
                        try {
                            chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadNextHead(input, chunkBufferM7223prepareReadFirstHead);
                        } catch (Throwable th) {
                            th = th;
                            z3 = false;
                            if (z3) {
                                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else if (writePosition >= i2) {
                        ChunkBuffer chunkBuffer4 = chunkBufferM7223prepareReadFirstHead;
                        if (chunkBuffer4.getCapacity() - chunkBuffer4.getLimit() < 8) {
                            UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            chunkBufferPrepareReadNextHead = UnsafeKt.m7223prepareReadFirstHead(input, i2);
                        } else {
                            chunkBufferPrepareReadNextHead = chunkBufferM7223prepareReadFirstHead;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                        chunkBufferPrepareReadNextHead = UnsafeKt.m7223prepareReadFirstHead(input, i2);
                    }
                    if (chunkBufferPrepareReadNextHead == null) {
                        z = false;
                        break;
                    }
                    chunkBufferM7223prepareReadFirstHead = chunkBufferPrepareReadNextHead;
                    if (i2 <= 0) {
                        z = true;
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (z) {
                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
            }
            z2 = z4;
        }
        if (charBufferAllocate.hasRemaining() && !z2) {
            CoderResult rc2 = charsetDecoder.decode(EmptyByteBuffer, charBufferAllocate, true);
            if (rc2.isMalformed() || rc2.isUnmappable()) {
                Intrinsics.checkNotNullExpressionValue(rc2, "rc");
                throwExceptionWrapped(rc2);
            }
        }
        if (iPosition > 0) {
            throw new EOFException("Not enough bytes available: had only " + (i - iPosition) + " instead of " + i);
        }
        if (iPosition < 0) {
            throw new AssertionError("remainingInputBytes < 0");
        }
        String string = charBufferAllocate.toString();
        Intrinsics.checkNotNullExpressionValue(string, "cb.toString()");
        return string;
    }

    private static final void throwExceptionWrapped(CoderResult coderResult) throws CharacterCodingException {
        try {
            coderResult.throwException();
        } catch (MalformedInputException e) {
            String message = e.getMessage();
            if (message == null) {
                message = "Failed to decode bytes";
            }
            throw new MalformedInputException(message);
        }
    }

    static {
        CharBuffer charBufferAllocate = CharBuffer.allocate(0);
        Intrinsics.checkNotNull(charBufferAllocate);
        EmptyCharBuffer = charBufferAllocate;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(0);
        Intrinsics.checkNotNull(byteBufferAllocate);
        EmptyByteBuffer = byteBufferAllocate;
    }

    public static final boolean encodeComplete(CharsetEncoder charsetEncoder, Buffer dst) throws CharacterCodingException {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        ByteBuffer memory = dst.getMemory();
        int writePosition = dst.getWritePosition();
        int limit = dst.getLimit() - writePosition;
        ByteBuffer byteBufferM6961sliceSK3TCg8 = Memory.m6961sliceSK3TCg8(memory, writePosition, limit);
        CoderResult result = charsetEncoder.encode(EmptyCharBuffer, byteBufferM6961sliceSK3TCg8, true);
        if (result.isMalformed() || result.isUnmappable()) {
            Intrinsics.checkNotNullExpressionValue(result, "result");
            throwExceptionWrapped(result);
        }
        boolean zIsUnderflow = result.isUnderflow();
        if (!(byteBufferM6961sliceSK3TCg8.limit() == limit)) {
            throw new IllegalStateException("Buffer's limit change is not allowed".toString());
        }
        dst.commitWritten(byteBufferM6961sliceSK3TCg8.position());
        return zIsUnderflow;
    }

    public static final int decodeBuffer(CharsetDecoder charsetDecoder, Buffer input, Appendable out, boolean z, int i) {
        Intrinsics.checkNotNullParameter(charsetDecoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(out, "out");
        ByteBuffer memory = input.getMemory();
        int readPosition = input.getReadPosition();
        int writePosition = input.getWritePosition() - readPosition;
        ByteBuffer byteBufferM6961sliceSK3TCg8 = Memory.m6961sliceSK3TCg8(memory, readPosition, writePosition);
        ChunkBuffer chunkBufferBorrow = ChunkBuffer.INSTANCE.getPool().borrow();
        CharBuffer charBufferAsCharBuffer = chunkBufferBorrow.getMemory().asCharBuffer();
        Intrinsics.checkNotNull(charBufferAsCharBuffer);
        int i2 = 0;
        while (byteBufferM6961sliceSK3TCg8.hasRemaining() && i2 < i) {
            try {
                int iMin = Math.min(charBufferAsCharBuffer.capacity(), i - i2);
                CoderResult result = charsetDecoder.decode(byteBufferM6961sliceSK3TCg8, charBufferAsCharBuffer, z);
                if (result.isMalformed() || result.isUnmappable()) {
                    Intrinsics.checkNotNullExpressionValue(result, "result");
                    throwExceptionWrapped(result);
                }
                i2 += iMin;
            } catch (Throwable th) {
                chunkBufferBorrow.release(ChunkBuffer.INSTANCE.getPool());
                throw th;
            }
        }
        chunkBufferBorrow.release(ChunkBuffer.INSTANCE.getPool());
        if (!(byteBufferM6961sliceSK3TCg8.limit() == writePosition)) {
            throw new IllegalStateException("Buffer's limit change is not allowed".toString());
        }
        input.discardExact(byteBufferM6961sliceSK3TCg8.position());
        return i2;
    }
}
