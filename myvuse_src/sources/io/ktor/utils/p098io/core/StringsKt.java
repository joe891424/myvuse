package io.ktor.utils.p098io.core;

import io.ktor.utils.p098io.charsets.CharsetJVMKt;
import io.ktor.utils.p098io.charsets.EncodingKt;
import io.ktor.utils.p098io.core.internal.CharArraySequence;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.core.internal.UTF8Kt;
import io.ktor.utils.p098io.core.internal.UnsafeKt;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\u0001\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u001a\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0003H\u0002\u001a\r\u0010\t\u001a\u00020\n*\u00020\u000bH\u0082\b\u001a\u0014\u0010\f\u001a\u00020\r*\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u001a\n\u0010\f\u001a\u00020\r*\u00020\u0010\u001a\u0012\u0010\f\u001a\u00020\r*\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0003\u001a\u001e\u0010\u0011\u001a\u00020\r*\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u001a\"\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u001a\"\u0010\u0014\u001a\u00020\u0015*\u00020\u00102\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u001a\"\u0010\u0014\u001a\u00020\u0015*\u00020\u00102\n\u0010\u001a\u001a\u00060\u001bj\u0002`\u001c2\b\b\u0002\u0010\u0013\u001a\u00020\u0003H\u0007\u001a.\u0010\u0014\u001a\u00020\u0003*\u00020\u00102\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001f2\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u001a.\u0010\u0014\u001a\u00020\u0003*\u00020\u00102\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001f2\n\u0010\u001a\u001a\u00060\u001bj\u0002`\u001c2\b\b\u0002\u0010\u0013\u001a\u00020\u0003H\u0007\u001a\"\u0010 \u001a\u00020\u0015*\u00020\u00102\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010\u000f\u001a\u00020\u0003H\u0007\u001a\"\u0010!\u001a\u00020\u0015*\u00020\u00102\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010\"\u001a\u00020\u0003H\u0007\u001a \u0010!\u001a\u00020\u0015*\u00020\u00102\u0006\u0010#\u001a\u00020\u00032\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019\u001a \u0010$\u001a\u00020\u0015*\u00020\u00102\u0006\u0010\b\u001a\u00020\u00032\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019\u001a \u0010%\u001a\u0004\u0018\u00010\u0015*\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a \u0010%\u001a\u0004\u0018\u00010\u0015*\u00020\u00102\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a\u001e\u0010'\u001a\u00020\n*\u00020\u00102\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001f2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001c\u0010(\u001a\u00020\u0015*\u00020\u00102\u0006\u0010)\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a&\u0010*\u001a\u00020\u0003*\u00020\u00102\u0006\u0010\u001d\u001a\u00020+2\u0006\u0010)\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007\u001a$\u0010*\u001a\u00020\u0003*\u00020\u00102\u0006\u0010\u001d\u001a\u00020,2\u0006\u0010)\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a(\u0010*\u001a\u00020\u0003*\u00020\u00102\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001f2\u0006\u0010)\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a,\u0010-\u001a\u00020\u0003*\u00020\u00102\u0006\u0010\u001d\u001a\u00020,2\u0006\u0010)\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0003H\u0002\u001a0\u0010-\u001a\u00020\u0003*\u00020\u00102\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001f2\u0006\u0010)\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0003H\u0002\u001a$\u0010/\u001a\u00020\u0003*\u00020\u00102\u0006\u0010)\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020,H\u0002\u001a\u001b\u00100\u001a\u00020\r*\u00020\u00152\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019H\u0086\b\u001a4\u00101\u001a\u000202*\u00020,2\u0006\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u00020\u00032\b\b\u0002\u00106\u001a\u00020\u00032\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019\u001a4\u00101\u001a\u000202*\u00020,2\u0006\u00103\u001a\u0002072\b\b\u0002\u00105\u001a\u00020\u00032\b\b\u0002\u00106\u001a\u00020\u00032\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019\u001a4\u00101\u001a\u000202*\u00020,2\u0006\u00103\u001a\u0002072\b\b\u0002\u00105\u001a\u00020\u00032\b\b\u0002\u00106\u001a\u00020\u00032\n\u00108\u001a\u000609j\u0002`:H\u0007\u001a$\u0010;\u001a\u000202*\u00020,2\u0006\u00103\u001a\u0002072\u0006\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u0003H\u0002¨\u0006<"}, m5598d2 = {"bufferLimitExceeded", "", "limit", "", "prematureEndOfStream", "size", "", "prematureEndOfStreamToReadChars", "charactersCount", "isAsciiChar", "", "", "readBytes", "", "Lio/ktor/utils/io/core/ByteReadPacket;", RsaJsonWebKey.MODULUS_MEMBER_NAME, "Lio/ktor/utils/io/core/Input;", "readBytesOf", "min", "max", "readText", "", "Lio/ktor/utils/io/core/Buffer;", "charset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "decoder", "Ljava/nio/charset/CharsetDecoder;", "Lio/ktor/utils/io/charsets/CharsetDecoder;", "out", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "readTextExact", "readTextExactBytes", "bytes", "bytesCount", "readTextExactCharacters", "readUTF8Line", "estimate", "readUTF8LineTo", "readUTF8UntilDelimiter", "delimiters", "readUTF8UntilDelimiterTo", "Lio/ktor/utils/io/core/BytePacketBuilderBase;", "Lio/ktor/utils/io/core/Output;", "readUTF8UntilDelimiterToSlowUtf8", "decoded0", "readUTFUntilDelimiterToSlowAscii", "toByteArray", "writeText", "", "text", "", "fromIndex", "toIndex", "", "encoder", "Ljava/nio/charset/CharsetEncoder;", "Lio/ktor/utils/io/charsets/CharsetEncoder;", "writeTextUtf8", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class StringsKt {
    private static final boolean isAsciiChar(char c) {
        return c <= 127;
    }

    public static /* synthetic */ byte[] toByteArray$default(String str, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder, "charset.newEncoder()");
        return CharsetJVMKt.encodeToByteArray(charsetEncoderNewEncoder, str, 0, str.length());
    }

    public static final byte[] toByteArray(String str, Charset charset) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder, "charset.newEncoder()");
        return CharsetJVMKt.encodeToByteArray(charsetEncoderNewEncoder, str, 0, str.length());
    }

    public static /* synthetic */ String readUTF8Line$default(ByteReadPacket byteReadPacket, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 16;
        }
        if ((i3 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        return readUTF8Line(byteReadPacket, i, i2);
    }

    public static /* synthetic */ String readUTF8Line$default(Input input, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 16;
        }
        if ((i3 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        return readUTF8Line(input, i, i2);
    }

    public static final String readUTF8Line(Input input, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        StringBuilder sb = new StringBuilder(i);
        if (readUTF8LineTo(input, sb, i2)) {
            return sb.toString();
        }
        return null;
    }

    public static /* synthetic */ String readUTF8UntilDelimiter$default(Input input, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readUTF8UntilDelimiter(input, str, i);
    }

    public static final String readUTF8UntilDelimiter(Input input, String delimiters, int i) throws Throwable {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        StringBuilder sb = new StringBuilder();
        readUTF8UntilDelimiterTo(input, sb, delimiters, i);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ int readUTF8UntilDelimiterTo$default(Input input, Appendable appendable, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readUTF8UntilDelimiterTo(input, appendable, str, i);
    }

    public static /* synthetic */ int readUTF8UntilDelimiterTo$default(Input input, Output output, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readUTF8UntilDelimiterTo(input, output, str, i);
    }

    public static final int readUTF8UntilDelimiterTo(Input input, Output out, String delimiters, int i) {
        long untilDelimiters;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        int length = delimiters.length();
        if (length == 1 && delimiters.charAt(0) <= 127) {
            untilDelimiters = ScannerKt.readUntilDelimiter(input, (byte) delimiters.charAt(0), out);
        } else if (length == 2 && delimiters.charAt(0) <= 127 && delimiters.charAt(1) <= 127) {
            untilDelimiters = ScannerKt.readUntilDelimiters(input, (byte) delimiters.charAt(0), (byte) delimiters.charAt(1), out);
        } else {
            return readUTFUntilDelimiterToSlowAscii(input, delimiters, i, out);
        }
        return (int) untilDelimiters;
    }

    public static /* synthetic */ int readUTF8UntilDelimiterTo$default(Input input, BytePacketBuilderBase bytePacketBuilderBase, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readUTF8UntilDelimiterTo(input, bytePacketBuilderBase, str, i);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use Output version instead")
    public static final /* synthetic */ int readUTF8UntilDelimiterTo(Input input, BytePacketBuilderBase out, String delimiters, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        return readUTF8UntilDelimiterTo(input, (Output) out, delimiters, i);
    }

    public static /* synthetic */ byte[] readBytes$default(ByteReadPacket byteReadPacket, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            long remaining = byteReadPacket.getRemaining();
            if (remaining > 2147483647L) {
                throw new IllegalArgumentException("Unable to convert to a ByteArray: packet is too big");
            }
            i = (int) remaining;
        }
        return readBytes(byteReadPacket, i);
    }

    public static final byte[] readBytes(ByteReadPacket byteReadPacket, int i) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        if (i != 0) {
            byte[] bArr = new byte[i];
            InputArraysKt.readFully((Input) byteReadPacket, bArr, 0, i);
            return bArr;
        }
        return UnsafeKt.EmptyByteArray;
    }

    public static final byte[] readBytes(Input input, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return readBytesOf(input, i, i);
    }

    public static final byte[] readBytes(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return readBytesOf$default(input, 0, 0, 3, null);
    }

    public static /* synthetic */ byte[] readBytesOf$default(Input input, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        return readBytesOf(input, i, i2);
    }

    public static final byte[] readBytesOf(Input input, int i, int i2) throws EOFException {
        int available;
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (i == i2 && i == 0) {
            return UnsafeKt.EmptyByteArray;
        }
        int i3 = 0;
        if (i == i2) {
            byte[] bArr = new byte[i];
            InputArraysKt.readFully(input, bArr, 0, i);
            return bArr;
        }
        byte[] bArrCopyOf = new byte[(int) RangesKt.coerceAtLeast(RangesKt.coerceAtMost(i2, EncodingKt.sizeEstimate(input)), i)];
        while (i3 < i2 && (available = InputArraysKt.readAvailable(input, bArrCopyOf, i3, Math.min(i2, bArrCopyOf.length) - i3)) > 0) {
            i3 += available;
            if (bArrCopyOf.length == i3) {
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i3 * 2);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
            }
        }
        if (i3 < i) {
            throw new EOFException("Not enough bytes available to read " + i + " bytes: " + (i - i3) + " more required");
        }
        if (i3 == bArrCopyOf.length) {
            return bArrCopyOf;
        }
        byte[] bArrCopyOf2 = Arrays.copyOf(bArrCopyOf, i3);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf2, "java.util.Arrays.copyOf(this, newSize)");
        return bArrCopyOf2;
    }

    public static /* synthetic */ int readText$default(Input input, Appendable appendable, CharsetDecoder charsetDecoder, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readText(input, appendable, charsetDecoder, i);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use CharsetDecoder.decode instead", replaceWith = @ReplaceWith(expression = "decoder.decode(this, out, max)", imports = {"io.ktor.utils.io.charsets.decode"}))
    public static final int readText(Input input, Appendable out, CharsetDecoder decoder, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return CharsetJVMKt.decode(decoder, input, out, i);
    }

    public static /* synthetic */ int readText$default(Input input, Appendable appendable, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 4) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readText(input, appendable, charset, i);
    }

    public static final int readText(Input input, Appendable out, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(charset, "charset");
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(charsetDecoderNewDecoder, "charset.newDecoder()");
        return CharsetJVMKt.decode(charsetDecoderNewDecoder, input, out, i);
    }

    public static /* synthetic */ String readText$default(Input input, CharsetDecoder charsetDecoder, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readText(input, charsetDecoder, i);
    }

    @Deprecated(message = "Use CharsetDecoder.decode instead", replaceWith = @ReplaceWith(expression = "decoder.decode(this, max)", imports = {"io.ktor.utils.io.charsets.decode"}))
    public static final String readText(Input input, CharsetDecoder decoder, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return EncodingKt.decode(decoder, input, i);
    }

    public static /* synthetic */ String readText$default(Input input, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readText(input, charset, i);
    }

    public static final String readText(Input input, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(charsetDecoderNewDecoder, "charset.newDecoder()");
        return EncodingKt.decode(charsetDecoderNewDecoder, input, i);
    }

    public static final String readText(Buffer buffer, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        StringBuilder sb = new StringBuilder();
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(charsetDecoderNewDecoder, "charset.newDecoder()");
        CharsetJVMKt.decodeBuffer(charsetDecoderNewDecoder, buffer, sb, true, i);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String readText$default(Buffer buffer, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readText(buffer, charset, i);
    }

    public static /* synthetic */ String readTextExact$default(Input input, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return readTextExact(input, charset, i);
    }

    @Deprecated(message = "Use readTextExactCharacters instead.", replaceWith = @ReplaceWith(expression = "readTextExactCharacters(n, charset)", imports = {}))
    public static final String readTextExact(Input input, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return readTextExactCharacters(input, i, charset);
    }

    public static /* synthetic */ String readTextExactCharacters$default(Input input, int i, Charset charset, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        return readTextExactCharacters(input, i, charset);
    }

    public static final String readTextExactCharacters(Input input, int i, Charset charset) throws EOFException {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        String text = readText(input, charset, i);
        if (text.length() >= i) {
            return text;
        }
        prematureEndOfStreamToReadChars(i);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ String readTextExactBytes$default(Input input, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return readTextExactBytes(input, charset, i);
    }

    @Deprecated(message = "Parameters order is changed.", replaceWith = @ReplaceWith(expression = "readTextExactBytes(bytes, charset)", imports = {}))
    public static final String readTextExactBytes(Input input, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return readTextExactBytes(input, i, charset);
    }

    public static /* synthetic */ String readTextExactBytes$default(Input input, int i, Charset charset, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        return readTextExactBytes(input, i, charset);
    }

    public static final String readTextExactBytes(Input input, int i, Charset charset) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(charsetDecoderNewDecoder, "charset.newDecoder()");
        return CharsetJVMKt.decodeExactBytes(charsetDecoderNewDecoder, input, i);
    }

    public static /* synthetic */ void writeText$default(Output output, CharSequence charSequence, int i, int i2, CharsetEncoder charsetEncoder, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        writeText(output, charSequence, i, i2, charsetEncoder);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use the implementation with Charset instead", replaceWith = @ReplaceWith(expression = "writeText(text, fromIndex, toIndex, encoder.charset)", imports = {"io.ktor.utils.io.charsets.charset"}))
    public static final void writeText(Output output, CharSequence text, int i, int i2, CharsetEncoder encoder) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        EncodingKt.encodeToImpl(encoder, output, text, i, i2);
    }

    public static /* synthetic */ void writeText$default(Output output, CharSequence charSequence, int i, int i2, Charset charset, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        if ((i3 & 8) != 0) {
            charset = Charsets.UTF_8;
        }
        writeText(output, charSequence, i, i2, charset);
    }

    public static final void writeText(Output output, CharSequence text, int i, int i2, Charset charset) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (charset == Charsets.UTF_8) {
            writeTextUtf8(output, text, i, i2);
            return;
        }
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder, "charset.newEncoder()");
        EncodingKt.encodeToImpl(charsetEncoderNewEncoder, output, text, i, i2);
    }

    public static /* synthetic */ void writeText$default(Output output, char[] cArr, int i, int i2, Charset charset, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        if ((i3 & 8) != 0) {
            charset = Charsets.UTF_8;
        }
        writeText(output, cArr, i, i2, charset);
    }

    public static final void writeText(Output output, char[] text, int i, int i2, Charset charset) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (charset == Charsets.UTF_8) {
            writeTextUtf8(output, new CharArraySequence(text, 0, text.length), i, i2);
            return;
        }
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder, "charset.newEncoder()");
        EncodingKt.encode(charsetEncoderNewEncoder, text, i, i2, output);
    }

    private static final Void bufferLimitExceeded(int i) throws BufferLimitExceededException {
        throw new BufferLimitExceededException("Too many characters before delimiter: limit " + i + " exceeded");
    }

    public static final Void prematureEndOfStream(int i) throws EOFException {
        throw new EOFException("Premature end of stream: expected " + i + " bytes");
    }

    public static final Void prematureEndOfStream(long j) throws EOFException {
        throw new EOFException("Premature end of stream: expected " + j + " bytes");
    }

    private static final Void prematureEndOfStreamToReadChars(int i) throws EOFException {
        throw new EOFException("Not enough input bytes to read " + i + " characters.");
    }

    public static final String readUTF8Line(ByteReadPacket byteReadPacket, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        if (byteReadPacket.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder(i);
        if (readUTF8LineTo(byteReadPacket, sb, i2)) {
            return sb.toString();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0085, code lost:
    
        r1 = r17;
        r9 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0179, code lost:
    
        r6.discardExact(((r13 - r11) - r16) + 1);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x019a A[LOOP:1: B:12:0x0046->B:106:0x019a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0081 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0106 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0179 A[EDGE_INSN: B:173:0x0179->B:98:0x0179 BREAK  A[LOOP:1: B:12:0x0046->B:106:0x019a], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x016d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0199 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0148 A[Catch: all -> 0x01c8, TryCatch #2 {all -> 0x01c8, blocks: (B:9:0x002e, B:12:0x0046, B:15:0x005c, B:28:0x0081, B:110:0x01ad, B:113:0x01b4, B:108:0x01a4, B:26:0x0077, B:30:0x008b, B:31:0x0093, B:32:0x0094, B:33:0x009c, B:36:0x00a4, B:38:0x00aa, B:42:0x00b8, B:44:0x00bf, B:46:0x00d1, B:48:0x00db, B:50:0x00e1, B:63:0x0106, B:61:0x00fc, B:64:0x0110, B:65:0x0118, B:66:0x0119, B:68:0x011f, B:81:0x0148, B:92:0x0165, B:96:0x0170, B:97:0x0178, B:98:0x0179, B:79:0x013e, B:99:0x0183, B:100:0x018b, B:101:0x018c, B:102:0x0194), top: B:158:0x002e, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean readUTF8LineTo(io.ktor.utils.p098io.core.Input r22, java.lang.Appendable r23, int r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 561
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.core.StringsKt.readUTF8LineTo(io.ktor.utils.io.core.Input, java.lang.Appendable, int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006c, code lost:
    
        bufferLimitExceeded(r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0074, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int readUTF8UntilDelimiterTo(io.ktor.utils.p098io.core.Input r18, java.lang.Appendable r19, java.lang.String r20, int r21) throws java.lang.Throwable {
        /*
            r1 = r18
            r0 = r19
            r2 = r20
            r3 = r21
            java.lang.String r4 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            java.lang.String r4 = "out"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r4)
            java.lang.String r4 = "delimiters"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
            r4 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.p098io.core.internal.UnsafeKt.m7223prepareReadFirstHead(r1, r4)
            if (r5 != 0) goto L22
            r6 = 0
            r7 = 0
            goto L91
        L22:
            r7 = 0
            r8 = 0
        L24:
            r9 = r5
            io.ktor.utils.io.core.Buffer r9 = (io.ktor.utils.p098io.core.Buffer) r9     // Catch: java.lang.Throwable -> L9d
            java.nio.ByteBuffer r10 = r9.getMemory()     // Catch: java.lang.Throwable -> L9d
            int r11 = r9.getReadPosition()     // Catch: java.lang.Throwable -> L9d
            int r12 = r9.getWritePosition()     // Catch: java.lang.Throwable -> L9d
            if (r11 >= r12) goto L7e
            r13 = r11
        L36:
            int r14 = r13 + 1
            byte r15 = r10.get(r13)     // Catch: java.lang.Throwable -> L9d
            r4 = r15 & 255(0xff, float:3.57E-43)
            r6 = 128(0x80, float:1.8E-43)
            r15 = r15 & r6
            if (r15 == r6) goto L75
            char r4 = (char) r4     // Catch: java.lang.Throwable -> L9d
            r6 = r2
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch: java.lang.Throwable -> L9d
            r15 = 2
            r16 = r8
            r8 = 0
            r17 = r10
            r10 = 0
            boolean r6 = kotlin.text.StringsKt.contains$default(r6, r4, r10, r15, r8)     // Catch: java.lang.Throwable -> L9d
            if (r6 == 0) goto L57
            r4 = r10
            r8 = 1
            goto L61
        L57:
            if (r7 == r3) goto L6c
            int r7 = r7 + 1
            r0.append(r4)     // Catch: java.lang.Throwable -> L9d
            r8 = r16
            r4 = 1
        L61:
            if (r4 != 0) goto L64
            goto L78
        L64:
            if (r14 < r12) goto L67
            goto L7f
        L67:
            r13 = r14
            r10 = r17
            r4 = 1
            goto L36
        L6c:
            bufferLimitExceeded(r21)     // Catch: java.lang.Throwable -> L9d
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L9d
            r0.<init>()     // Catch: java.lang.Throwable -> L9d
            throw r0     // Catch: java.lang.Throwable -> L9d
        L75:
            r16 = r8
            r10 = 0
        L78:
            int r13 = r13 - r11
            r9.discardExact(r13)     // Catch: java.lang.Throwable -> L9d
            r4 = r10
            goto L84
        L7e:
            r10 = 0
        L7f:
            int r12 = r12 - r11
            r9.discardExact(r12)     // Catch: java.lang.Throwable -> L9d
            r4 = 1
        L84:
            if (r4 != 0) goto L8a
            io.ktor.utils.p098io.core.internal.UnsafeKt.completeReadHead(r1, r5)
            goto L90
        L8a:
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.p098io.core.internal.UnsafeKt.prepareReadNextHead(r1, r5)     // Catch: java.lang.Throwable -> L9a
            if (r5 != 0) goto L98
        L90:
            r6 = r8
        L91:
            if (r6 != 0) goto L97
            int r7 = readUTF8UntilDelimiterToSlowUtf8(r1, r0, r2, r3, r7)
        L97:
            return r7
        L98:
            r4 = 1
            goto L24
        L9a:
            r0 = move-exception
            r4 = r10
            goto L9f
        L9d:
            r0 = move-exception
            r4 = 1
        L9f:
            if (r4 == 0) goto La4
            io.ktor.utils.p098io.core.internal.UnsafeKt.completeReadHead(r1, r5)
        La4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.core.StringsKt.readUTF8UntilDelimiterTo(io.ktor.utils.io.core.Input, java.lang.Appendable, java.lang.String, int):int");
    }

    private static final void writeTextUtf8(Output output, CharSequence charSequence, int i, int i2) {
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, (ChunkBuffer) null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iM7219encodeUTF83CNuoPE = UTF8Kt.m7219encodeUTF83CNuoPE(chunkBuffer.getMemory(), charSequence, i, i2, chunkBuffer.getWritePosition(), chunkBuffer.getLimit());
                short sM7514constructorimpl = UShort.m7514constructorimpl((short) (iM7219encodeUTF83CNuoPE >>> 16));
                short sM7514constructorimpl2 = UShort.m7514constructorimpl((short) (iM7219encodeUTF83CNuoPE & 65535));
                int i3 = sM7514constructorimpl & UShort.MAX_VALUE;
                i += i3;
                chunkBuffer.commitWritten(sM7514constructorimpl2 & UShort.MAX_VALUE);
                int i4 = (i3 != 0 || i >= i2) ? i < i2 ? 1 : 0 : 8;
                if (i4 <= 0) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i4, chunkBufferPrepareWriteHead);
                }
            } finally {
                UnsafeKt.afterHeadWrite(output, chunkBufferPrepareWriteHead);
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:(2:63|6)|(8:8|(4:9|59|10|(3:12|(1:14)(3:(1:16)(1:65)|(1:55)|56)|(2:68|18)(1:(2:69|20)(1:21)))(2:70|24))|25|26|32|33|(1:35)|(2:66|37)(4:38|57|39|(1:67)(1:47)))(1:29)|30|61|31|32|33|(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0065, code lost:
    
        bufferLimitExceeded(r20);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006d, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b8, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b9, code lost:
    
        r1 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00bd, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008e A[Catch: all -> 0x0077, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0077, blocks: (B:10:0x0032, B:12:0x003f, B:25:0x0071, B:35:0x008e, B:16:0x0053, B:22:0x0065, B:23:0x006d), top: B:59:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0096 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final int readUTFUntilDelimiterToSlowAscii(io.ktor.utils.p098io.core.Input r18, java.lang.String r19, int r20, io.ktor.utils.p098io.core.Output r21) throws java.lang.Throwable {
        /*
            r1 = r18
            r0 = r19
            r2 = r20
            r3 = r21
            r4 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.p098io.core.internal.UnsafeKt.m7223prepareReadFirstHead(r1, r4)
            if (r5 != 0) goto L13
            r6 = 0
            r7 = 0
            goto La6
        L13:
            r7 = 0
            r8 = 0
        L15:
            r9 = r5
            io.ktor.utils.io.core.Buffer r9 = (io.ktor.utils.p098io.core.Buffer) r9     // Catch: java.lang.Throwable -> Lbc
            int r10 = r9.getWritePosition()     // Catch: java.lang.Throwable -> Lbc
            int r11 = r9.getReadPosition()     // Catch: java.lang.Throwable -> Lbc
            int r10 = r10 - r11
            java.nio.ByteBuffer r11 = r9.getMemory()     // Catch: java.lang.Throwable -> Lbc
            int r12 = r9.getReadPosition()     // Catch: java.lang.Throwable -> Lbc
            int r13 = r9.getWritePosition()     // Catch: java.lang.Throwable -> Lbc
            if (r12 >= r13) goto L7c
            r14 = r12
        L30:
            int r15 = r14 + 1
            byte r4 = r11.get(r14)     // Catch: java.lang.Throwable -> L77
            r6 = r4 & 255(0xff, float:3.57E-43)
            r16 = r8
            r8 = 128(0x80, float:1.8E-43)
            r4 = r4 & r8
            if (r4 == r8) goto L6e
            char r4 = (char) r6     // Catch: java.lang.Throwable -> L77
            r6 = r0
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch: java.lang.Throwable -> L77
            r8 = 2
            r17 = r11
            r11 = 0
            r1 = 0
            boolean r4 = kotlin.text.StringsKt.contains$default(r6, r4, r1, r8, r11)     // Catch: java.lang.Throwable -> L77
            if (r4 == 0) goto L51
            r4 = r1
            r8 = 1
            goto L58
        L51:
            if (r7 == r2) goto L65
            int r7 = r7 + 1
            r8 = r16
            r4 = 1
        L58:
            if (r4 != 0) goto L5b
            goto L71
        L5b:
            if (r15 < r13) goto L5e
            goto L7d
        L5e:
            r4 = 1
            r1 = r18
            r14 = r15
            r11 = r17
            goto L30
        L65:
            bufferLimitExceeded(r20)     // Catch: java.lang.Throwable -> L77
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L77
            r0.<init>()     // Catch: java.lang.Throwable -> L77
            throw r0     // Catch: java.lang.Throwable -> L77
        L6e:
            r1 = 0
            r8 = r16
        L71:
            int r14 = r14 - r12
            r9.discardExact(r14)     // Catch: java.lang.Throwable -> L77
            r4 = r1
            goto L82
        L77:
            r0 = move-exception
            r4 = 1
            r1 = r18
            goto Lbe
        L7c:
            r1 = 0
        L7d:
            int r13 = r13 - r12
            r9.discardExact(r13)     // Catch: java.lang.Throwable -> Lb8
            r4 = 1
        L82:
            int r6 = r9.getWritePosition()     // Catch: java.lang.Throwable -> Lb8
            int r11 = r9.getReadPosition()     // Catch: java.lang.Throwable -> Lb8
            int r6 = r6 - r11
            int r10 = r10 - r6
            if (r10 <= 0) goto L94
            r9.rewind(r10)     // Catch: java.lang.Throwable -> L77
            io.ktor.utils.p098io.core.OutputKt.writeFully(r3, r9, r10)     // Catch: java.lang.Throwable -> L77
        L94:
            if (r4 != 0) goto L9c
            r1 = r18
            io.ktor.utils.p098io.core.internal.UnsafeKt.completeReadHead(r1, r5)
            goto La5
        L9c:
            r4 = r1
            r1 = r18
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.p098io.core.internal.UnsafeKt.prepareReadNextHead(r1, r5)     // Catch: java.lang.Throwable -> Lb6
            if (r5 != 0) goto Lb3
        La5:
            r6 = r8
        La6:
            if (r6 != 0) goto Lb2
            boolean r4 = r18.isEmpty()
            if (r4 != 0) goto Lb2
            int r7 = readUTF8UntilDelimiterToSlowUtf8(r1, r3, r0, r2, r7)
        Lb2:
            return r7
        Lb3:
            r4 = 1
            goto L15
        Lb6:
            r0 = move-exception
            goto Lbe
        Lb8:
            r0 = move-exception
            r1 = r18
            goto Lbd
        Lbc:
            r0 = move-exception
        Lbd:
            r4 = 1
        Lbe:
            if (r4 == 0) goto Lc3
            io.ktor.utils.p098io.core.internal.UnsafeKt.completeReadHead(r1, r5)
        Lc3:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.core.StringsKt.readUTFUntilDelimiterToSlowAscii(io.ktor.utils.io.core.Input, java.lang.String, int, io.ktor.utils.io.core.Output):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006e, code lost:
    
        r4 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ae, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0131, code lost:
    
        r5.discardExact(((r12 - r9) - r15) + 1);
        r4 = -1;
     */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x014f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0150 A[LOOP:1: B:12:0x0041->B:83:0x0150, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final int readUTF8UntilDelimiterToSlowUtf8(io.ktor.utils.p098io.core.Input r19, io.ktor.utils.p098io.core.Output r20, java.lang.String r21, int r22, int r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 523
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.core.StringsKt.readUTF8UntilDelimiterToSlowUtf8(io.ktor.utils.io.core.Input, io.ktor.utils.io.core.Output, java.lang.String, int, int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006a, code lost:
    
        r1 = -1;
        r5 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ac, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0138, code lost:
    
        r6.discardExact(((r12 - r9) - r15) + 1);
        r1 = -1;
        r5 = -1;
     */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0157 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0158 A[LOOP:1: B:12:0x003a->B:83:0x0158, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final int readUTF8UntilDelimiterToSlowUtf8(io.ktor.utils.p098io.core.Input r19, java.lang.Appendable r20, java.lang.String r21, int r22, int r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 503
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.core.StringsKt.readUTF8UntilDelimiterToSlowUtf8(io.ktor.utils.io.core.Input, java.lang.Appendable, java.lang.String, int, int):int");
    }
}
