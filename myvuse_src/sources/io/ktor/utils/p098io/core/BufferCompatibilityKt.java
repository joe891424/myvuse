package io.ktor.utils.p098io.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.uimanager.ViewProps;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import com.yoti.mobile.mpp.smartcard.ISO7816Kt;
import io.ktor.utils.p098io.bits.MemoryJvmKt;
import io.ktor.utils.p098io.charsets.CharsetJVMKt;
import io.ktor.utils.p098io.core.internal.CharArraySequence;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.core.internal.NumbersKt;
import io.ktor.utils.p098io.core.internal.RequireFailureCapture;
import io.ktor.utils.p098io.core.internal.UTF8Kt;
import io.ktor.utils.p098io.pool.ObjectPool;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.charset.CharsetDecoder;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: BufferCompatibility.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u001a$\u0010\u000e\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0007\u001a\u0016\u0010\u000e\u001a\u00020\u0003*\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0015H\u0007\u001a&\u0010\u000e\u001a\u00020\u0003*\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0007\u001a$\u0010\u0016\u001a\u00020\r*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0000\u001a$\u0010\u0016\u001a\u00020\r*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0000\u001a\u001a\u0010\u0017\u001a\u00020\u0018*\u00020\u00032\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b\u001a$\u0010\u0017\u001a\u00020\u0018*\u00020\u00032\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001cø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001c\u0010\u0017\u001a\u00020\u0018*\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001bH\u0007\u001a\f\u0010\"\u001a\u00020\u0018*\u00020\u0003H\u0007\u001a\f\u0010#\u001a\u00020\u0003*\u00020\u0003H\u0007\u001a\f\u0010#\u001a\u00020$*\u00020$H\u0007\u001a\u0014\u0010%\u001a\u00020\u0018*\u00020\u00032\u0006\u0010\u001f\u001a\u00020\rH\u0007\u001a1\u0010&\u001a\u00020\u0018*\u00020\u00032\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001b0(2\b\b\u0002\u0010)\u001a\u00020\r2\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010*\u001a6\u0010+\u001a\u00020\r*\u00020\u00032\n\u0010,\u001a\u00060-j\u0002`.2\n\u0010/\u001a\u000600j\u0002`12\u0006\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u00020\rH\u0007\u001a\u0018\u00105\u001a\u00020\u0018*\u0002062\f\u00107\u001a\b\u0012\u0004\u0012\u00020608\u001a\f\u00109\u001a\u00020\r*\u00020\u0003H\u0007\".\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, m5598d2 = {"newOrder", "Lio/ktor/utils/io/core/ByteOrder;", "byteOrder", "Lio/ktor/utils/io/core/Buffer;", "getByteOrder$annotations", "(Lio/ktor/utils/io/core/Buffer;)V", "getByteOrder", "(Lio/ktor/utils/io/core/Buffer;)Lio/ktor/utils/io/core/ByteOrder;", "setByteOrder", "(Lio/ktor/utils/io/core/Buffer;Lio/ktor/utils/io/core/ByteOrder;)V", "appendFailed", "", "length", "", "append", "c", "", "csq", "", "start", ViewProps.END, "", "appendChars", "fill", "", "times", "value", "", "Lkotlin/UByte;", "fill-3Qyljrw", "(Lio/ktor/utils/io/core/Buffer;IB)V", RsaJsonWebKey.MODULUS_MEMBER_NAME, "", "v", "flush", "makeView", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "pushBack", "readFully", C4352k.a.f5652f, "", TypedValues.CycleType.S_WAVE_OFFSET, "(Lio/ktor/utils/io/core/Buffer;[Ljava/lang/Byte;II)V", "readText", "decoder", "Ljava/nio/charset/CharsetDecoder;", "Lio/ktor/utils/io/charsets/CharsetDecoder;", "out", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "lastBuffer", "", "max", "release", "Lio/ktor/utils/io/core/IoBuffer;", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "tryPeek", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class BufferCompatibilityKt {
    @Deprecated(message = "Does nothing.")
    public static final void flush(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "This is no longer supported. All operations are big endian by default. Use readXXXLittleEndian to read primitives in little endian")
    public static /* synthetic */ void getByteOrder$annotations(Buffer buffer) {
    }

    /* JADX INFO: renamed from: fill-3Qyljrw, reason: not valid java name */
    public static final void m7110fill3Qyljrw(Buffer fill, int i, byte b) {
        Intrinsics.checkNotNullParameter(fill, "$this$fill");
        fill(fill, i, b);
    }

    @Deprecated(message = "Use fill with n with type Int")
    public static final void fill(Buffer buffer, long j, byte b) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (j < 2147483647L) {
            fill(buffer, (int) j, b);
        } else {
            NumbersKt.failLongToIntConversion(j, RsaJsonWebKey.MODULUS_MEMBER_NAME);
            throw new KotlinNothingValueException();
        }
    }

    @Deprecated(message = "Use rewind instead", replaceWith = @ReplaceWith(expression = "rewind(n)", imports = {}))
    public static final void pushBack(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        buffer.rewind(i);
    }

    @Deprecated(message = "Use duplicate instead", replaceWith = @ReplaceWith(expression = "duplicate()", imports = {}))
    public static final Buffer makeView(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return buffer.makeView();
    }

    @Deprecated(message = "Use duplicate instead", replaceWith = @ReplaceWith(expression = "duplicate()", imports = {}))
    public static final ChunkBuffer makeView(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        return chunkBuffer.makeView();
    }

    public static final int appendChars(Buffer buffer, char[] csq, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(csq, "csq");
        return appendChars(buffer, new CharArraySequence(csq, 0, csq.length), i, i2);
    }

    @Deprecated(message = "This is no longer supported. Use a packet builder to append characters instead.")
    public static final Buffer append(Buffer buffer, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (charSequence == null) {
            return append(buffer, "null");
        }
        return append(buffer, charSequence, 0, charSequence.length());
    }

    @Deprecated(message = "This is no longer supported. Use a packet builder to append characters instead.")
    public static final Buffer append(Buffer buffer, CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (charSequence == null) {
            return append(buffer, "null", i, i2);
        }
        if (appendChars(buffer, charSequence, i, i2) == i2) {
            return buffer;
        }
        appendFailed(i2 - i);
        throw new KotlinNothingValueException();
    }

    private static final Void appendFailed(int i) throws BufferLimitExceededException {
        throw new BufferLimitExceededException("Not enough free space available to write " + i + " character(s).");
    }

    @Deprecated(message = "This is no longer supported. Use a packet builder to append characters instead.")
    public static final Buffer append(Buffer buffer, char[] csq, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(csq, "csq");
        return append(buffer, new CharArraySequence(csq, 0, csq.length), i, i2);
    }

    public static /* synthetic */ int readText$default(Buffer buffer, CharsetDecoder charsetDecoder, Appendable appendable, boolean z, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readText(buffer, charsetDecoder, appendable, z, i);
    }

    @Deprecated(message = "This is no longer supported. Read from a packet instead.")
    public static final int readText(Buffer buffer, CharsetDecoder decoder, Appendable out, boolean z, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(out, "out");
        return CharsetJVMKt.decodeBuffer(decoder, buffer, out, z, i);
    }

    public static final void release(IoBuffer ioBuffer, ObjectPool<IoBuffer> pool) {
        Intrinsics.checkNotNullParameter(ioBuffer, "<this>");
        Intrinsics.checkNotNullParameter(pool, "pool");
        ioBuffer.release(pool);
    }

    @Deprecated(message = "Use tryPeekByte instead", replaceWith = @ReplaceWith(expression = "tryPeekByte()", imports = {}))
    public static final int tryPeek(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return buffer.tryPeekByte();
    }

    public static /* synthetic */ void readFully$default(Buffer buffer, Byte[] bArr, int i, int i2, int i3, Object obj) throws EOFException {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        readFully(buffer, bArr, i, i2);
    }

    public static final ByteOrder getByteOrder(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return ByteOrder.BIG_ENDIAN;
    }

    public static final void setByteOrder(Buffer buffer, ByteOrder newOrder) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(newOrder, "newOrder");
        if (newOrder != ByteOrder.BIG_ENDIAN) {
            throw new UnsupportedOperationException("Only BIG_ENDIAN is supported");
        }
    }

    public static final void fill(final Buffer buffer, final int i, byte b) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (!(i >= 0)) {
            new RequireFailureCapture() { // from class: io.ktor.utils.io.core.BufferCompatibilityKt$fill$$inlined$require$1
                @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                public Void doFail() {
                    throw new IllegalArgumentException(Intrinsics.stringPlus("times shouldn't be negative: ", Integer.valueOf(i)));
                }
            }.doFail();
            throw new KotlinNothingValueException();
        }
        if (i <= buffer.getLimit() - buffer.getWritePosition()) {
            MemoryJvmKt.m6973fillBd10AMI(buffer.getMemory(), buffer.getWritePosition(), i, b);
            buffer.commitWritten(i);
        } else {
            new RequireFailureCapture() { // from class: io.ktor.utils.io.core.BufferCompatibilityKt$fill$$inlined$require$2
                @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                public Void doFail() {
                    StringBuilder sbAppend = new StringBuilder("times shouldn't be greater than the write remaining space: ").append(i).append(" > ");
                    Buffer buffer2 = buffer;
                    throw new IllegalArgumentException(sbAppend.append(buffer2.getLimit() - buffer2.getWritePosition()).toString());
                }
            }.doFail();
            throw new KotlinNothingValueException();
        }
    }

    public static final int appendChars(Buffer buffer, CharSequence csq, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(csq, "csq");
        int iM7219encodeUTF83CNuoPE = UTF8Kt.m7219encodeUTF83CNuoPE(buffer.getMemory(), csq, i, i2, buffer.getWritePosition(), buffer.getLimit());
        int iM7514constructorimpl = UShort.m7514constructorimpl((short) (iM7219encodeUTF83CNuoPE >>> 16)) & UShort.MAX_VALUE;
        buffer.commitWritten(UShort.m7514constructorimpl((short) (iM7219encodeUTF83CNuoPE & 65535)) & UShort.MAX_VALUE);
        return i + iM7514constructorimpl;
    }

    @Deprecated(message = "This is no longer supported. Use a packet builder to append characters instead.")
    public static final Buffer append(Buffer buffer, char c) {
        int i;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit();
        if (c >= 0 && c <= 127) {
            memory.put(writePosition, (byte) c);
            i = 1;
        } else if (128 <= c && c <= 2047) {
            memory.put(writePosition, (byte) (((c >> 6) & 31) | JfifUtil.MARKER_SOFn));
            memory.put(writePosition + 1, (byte) ((c & '?') | 128));
            i = 2;
        } else if (2048 <= c && c <= 65535) {
            memory.put(writePosition, (byte) (((c >> '\f') & 15) | ISO7816Kt.INS_CREATE_FILE));
            memory.put(writePosition + 1, (byte) (((c >> 6) & 63) | 128));
            memory.put(writePosition + 2, (byte) ((c & '?') | 128));
            i = 3;
        } else {
            if (0 > c || c > 65535) {
                UTF8Kt.malformedCodePoint(c);
                throw new KotlinNothingValueException();
            }
            memory.put(writePosition, (byte) (((c >> 18) & 7) | 240));
            memory.put(writePosition + 1, (byte) (((c >> '\f') & 63) | 128));
            memory.put(writePosition + 2, (byte) (((c >> 6) & 63) | 128));
            memory.put(writePosition + 3, (byte) ((c & '?') | 128));
            i = 4;
        }
        if (i > limit - writePosition) {
            appendFailed(1);
            throw new KotlinNothingValueException();
        }
        buffer.commitWritten(i);
        return buffer;
    }

    public static final void readFully(Buffer buffer, Byte[] dst, int i, int i2) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition < i2) {
            throw new EOFException("Not enough bytes available to read " + i2 + " bytes");
        }
        if (i2 > 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                dst[i3 + i] = Byte.valueOf(memory.get(i3 + readPosition));
                if (i4 >= i2) {
                    break;
                } else {
                    i3 = i4;
                }
            }
        }
        buffer.discardExact(i2);
    }
}
