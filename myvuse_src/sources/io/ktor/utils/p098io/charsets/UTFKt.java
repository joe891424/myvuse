package io.ktor.utils.p098io.charsets;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.base.Ascii;
import io.ktor.utils.p098io.core.ExperimentalIoApi;
import io.ktor.utils.p098io.core.internal.DangerousInternalIoApi;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import net.lingala.zip4j.util.InternalZipConstants;
import okio.Utf8;

/* JADX INFO: compiled from: UTF.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000J\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0002\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0007\u001a\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0007H\u0000\u001a\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0007\u001a\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0002\u001a$\u0010\"\u001a\u00020\u0007*\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0007\u001a(\u0010&\u001a\u00020\u0007*\u00020#2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u0014\u001a\u00020\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u0001H\u0007\u001a$\u0010'\u001a\u00020\u0007*\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0002\u001a$\u0010(\u001a\u00020\u0007*\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0002\u001a$\u0010)\u001a\u00020\u0007*\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0002\u001a9\u0010)\u001a\u00020\u0007*\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00012\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00180+H\u0082\b\u001a$\u0010-\u001a\u00020\u0007*\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0002\u001a9\u0010-\u001a\u00020\u0007*\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00012\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00180+H\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006."}, m5598d2 = {"HighSurrogateMagic", "", "MaxCodePoint", "MinHighSurrogate", "MinLowSurrogate", "MinSupplementary", "decodeUtf8Result", "", "numberOfChars", "requireBytes", "decodeUtf8ResultAcc", "predecoded", "result", "decodeUtf8ResultCombine", "prev", "next", "highSurrogate", "cp", "indexOutOfBounds", "", TypedValues.CycleType.S_WAVE_OFFSET, "length", "arrayLength", "isBmpCodePoint", "", "isValidCodePoint", "codePoint", "lowSurrogate", "malformedCodePoint", "", "value", "unsupportedByteCount", "b", "", "decodeUTF", "Ljava/nio/ByteBuffer;", "out", "", "decodeUTF8Line", "decodeUTF8Line_array", "decodeUTF8Line_buffer", "decodeUTF8_array", "predicate", "Lkotlin/Function1;", "", "decodeUTF8_buffer", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class UTFKt {
    private static final int HighSurrogateMagic = 55232;
    private static final int MaxCodePoint = 1114111;
    private static final int MinHighSurrogate = 55296;
    private static final int MinLowSurrogate = 56320;
    private static final int MinSupplementary = 65536;

    @DangerousInternalIoApi
    public static final long decodeUtf8Result(int i, int i2) {
        return (((long) i2) & InternalZipConstants.ZIP_64_SIZE_LIMIT) | (((long) i) << 32);
    }

    @DangerousInternalIoApi
    public static final long decodeUtf8ResultCombine(long j, long j2) {
        return ((j & (-4294967296L)) + ((-4294967296L) & j2)) | (j2 & InternalZipConstants.ZIP_64_SIZE_LIMIT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int highSurrogate(int i) {
        return (i >>> 10) + 55232;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isBmpCodePoint(int i) {
        return (i >>> 16) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isValidCodePoint(int i) {
        return i <= MaxCodePoint;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int lowSurrogate(int i) {
        return (i & 1023) + 56320;
    }

    public static final long decodeUtf8ResultAcc(int i, long j) {
        return decodeUtf8Result(i + ((int) (j >> 32)), (int) (j & InternalZipConstants.ZIP_64_SIZE_LIMIT));
    }

    @ExperimentalIoApi
    public static final long decodeUTF(ByteBuffer byteBuffer, char[] out, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        int iDecodeASCII = StringsKt.decodeASCII(byteBuffer, out, i, i2);
        if (!byteBuffer.hasRemaining() || iDecodeASCII == i2) {
            return decodeUtf8Result(iDecodeASCII, 0);
        }
        return byteBuffer.hasArray() ? decodeUtf8ResultAcc(iDecodeASCII, decodeUTF8_array(byteBuffer, out, i + iDecodeASCII, i2 - iDecodeASCII)) : decodeUtf8ResultAcc(iDecodeASCII, decodeUTF8_buffer(byteBuffer, out, i + iDecodeASCII, i2 - iDecodeASCII));
    }

    public static /* synthetic */ long decodeUTF8Line$default(ByteBuffer byteBuffer, char[] cArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        return decodeUTF8Line(byteBuffer, cArr, i, i2);
    }

    @ExperimentalIoApi
    public static final long decodeUTF8Line(ByteBuffer byteBuffer, char[] out, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        return byteBuffer.hasArray() ? decodeUTF8Line_array(byteBuffer, out, i, i2) : decodeUTF8Line_buffer(byteBuffer, out, i, i2);
    }

    private static final long decodeUTF8_array(ByteBuffer byteBuffer, char[] cArr, int i, int i2) throws Throwable {
        int i3;
        byte[] bArrArray = byteBuffer.array();
        Intrinsics.checkNotNull(bArrArray);
        int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        int iRemaining = byteBuffer.remaining() + iArrayOffset;
        if (!(iArrayOffset <= iRemaining)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(iRemaining <= bArrArray.length)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i4 = i + i2;
        if (i4 > cArr.length) {
            throw indexOutOfBounds(i, i2, cArr.length);
        }
        int i5 = i;
        while (iArrayOffset < iRemaining && i5 < i4) {
            int i6 = iArrayOffset + 1;
            byte b = bArrArray[iArrayOffset];
            if (b >= 0) {
                char c = (char) b;
                i3 = i5 + 1;
                cArr[i5] = c;
                iArrayOffset = i6;
            } else if ((b & 224) == 192) {
                if (i6 >= iRemaining) {
                    return decodeUtf8Result(i5 - i, 2);
                }
                iArrayOffset += 2;
                cArr[i5] = (char) ((bArrArray[i6] & Utf8.REPLACEMENT_BYTE) | ((b & Ascii.f3759US) << 6));
                i5++;
            } else if ((b & 240) == 224) {
                if (iRemaining - i6 < 2) {
                    return decodeUtf8Result(i5 - i, 3);
                }
                int i7 = iArrayOffset + 2;
                byte b2 = bArrArray[i6];
                iArrayOffset += 3;
                byte b3 = bArrArray[i7];
                int i8 = b & Ascii.f3756SI;
                int i9 = ((b2 & Utf8.REPLACEMENT_BYTE) << 6) | (i8 << 12) | (b3 & Utf8.REPLACEMENT_BYTE);
                if (i8 == 0 || isBmpCodePoint(i9)) {
                    i3 = i5 + 1;
                    cArr[i5] = (char) i9;
                } else {
                    malformedCodePoint(i9);
                    throw new KotlinNothingValueException();
                }
            } else {
                if ((b & 248) != 240) {
                    unsupportedByteCount(b);
                    throw new KotlinNothingValueException();
                }
                if (iRemaining - i6 < 3) {
                    return decodeUtf8Result(i5 - i, 4);
                }
                int i10 = iArrayOffset + 4;
                int i11 = ((bArrArray[i6] & Utf8.REPLACEMENT_BYTE) << 12) | ((b & 7) << 18) | ((bArrArray[iArrayOffset + 2] & Utf8.REPLACEMENT_BYTE) << 6) | (bArrArray[iArrayOffset + 3] & Utf8.REPLACEMENT_BYTE);
                if (!isValidCodePoint(i11)) {
                    malformedCodePoint(i11);
                    throw new KotlinNothingValueException();
                }
                if (i4 - i5 >= 2) {
                    int iHighSurrogate = highSurrogate(i11);
                    int iLowSurrogate = lowSurrogate(i11);
                    int i12 = i5 + 1;
                    cArr[i5] = (char) iHighSurrogate;
                    i5 += 2;
                    cArr[i12] = (char) iLowSurrogate;
                    iArrayOffset = i10;
                } else {
                    return decodeUtf8Result(i5 - i, 0);
                }
            }
            i5 = i3;
        }
        return decodeUtf8Result(i5 - i, 0);
    }

    private static final long decodeUTF8_buffer(ByteBuffer byteBuffer, char[] cArr, int i, int i2) throws Throwable {
        int i3 = i + i2;
        if (i3 > cArr.length) {
            throw indexOutOfBounds(i, i2, cArr.length);
        }
        int i4 = i;
        while (byteBuffer.hasRemaining() && i4 < i3) {
            byte b = byteBuffer.get();
            if (b >= 0) {
                cArr[i4] = (char) b;
                i4++;
            } else if ((b & 224) == 192) {
                if (byteBuffer.hasRemaining()) {
                    return decodeUtf8Result(i4 - i, 2);
                }
                cArr[i4] = (char) (((b & Ascii.f3759US) << 6) | (byteBuffer.get() & Utf8.REPLACEMENT_BYTE));
                i4++;
            } else if ((b & 240) == 224) {
                if (byteBuffer.remaining() < 2) {
                    return decodeUtf8Result(i4 - i, 3);
                }
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                int i5 = b & Ascii.f3756SI;
                int i6 = ((b2 & Utf8.REPLACEMENT_BYTE) << 6) | (i5 << 12) | (b3 & Utf8.REPLACEMENT_BYTE);
                if (i5 == 0 || isBmpCodePoint(i6)) {
                    cArr[i4] = (char) i6;
                    i4++;
                } else {
                    malformedCodePoint(i6);
                    throw new KotlinNothingValueException();
                }
            } else if ((b & 248) == 240) {
                if (byteBuffer.remaining() < 3) {
                    return decodeUtf8Result(i4 - i, 4);
                }
                int i7 = ((b & 7) << 18) | ((byteBuffer.get() & Utf8.REPLACEMENT_BYTE) << 12) | ((byteBuffer.get() & Utf8.REPLACEMENT_BYTE) << 6) | (byteBuffer.get() & Utf8.REPLACEMENT_BYTE);
                if (!isValidCodePoint(i7)) {
                    malformedCodePoint(i7);
                    throw new KotlinNothingValueException();
                }
                if (i3 - i4 >= 2) {
                    int iHighSurrogate = highSurrogate(i7);
                    int iLowSurrogate = lowSurrogate(i7);
                    int i8 = i4 + 1;
                    cArr[i4] = (char) iHighSurrogate;
                    i4 += 2;
                    cArr[i8] = (char) iLowSurrogate;
                } else {
                    return decodeUtf8Result(i4 - i, 0);
                }
            } else {
                unsupportedByteCount(b);
                throw new KotlinNothingValueException();
            }
        }
        return decodeUtf8Result(i4 - i, 0);
    }

    private static final long decodeUTF8_array(ByteBuffer byteBuffer, char[] cArr, int i, int i2, Function1<? super Character, Boolean> function1) throws Throwable {
        int i3;
        int i4;
        byte[] bArrArray = byteBuffer.array();
        Intrinsics.checkNotNull(bArrArray);
        int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        int iRemaining = byteBuffer.remaining() + iArrayOffset;
        if (!(iArrayOffset <= iRemaining)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(iRemaining <= bArrArray.length)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i5 = i + i2;
        if (i5 > cArr.length) {
            throw indexOutOfBounds(i, i2, cArr.length);
        }
        int i6 = i;
        while (iArrayOffset < iRemaining && i6 < i5) {
            int i7 = iArrayOffset + 1;
            byte b = bArrArray[iArrayOffset];
            if (b >= 0) {
                char c = (char) b;
                if (!function1.invoke(Character.valueOf(c)).booleanValue()) {
                    return decodeUtf8Result(i6 - i, -1);
                }
                cArr[i6] = c;
                i6++;
                iArrayOffset = i7;
            } else {
                if ((b & 224) == 192) {
                    if (i7 >= iRemaining) {
                        return decodeUtf8Result(i6 - i, 2);
                    }
                    i3 = iArrayOffset + 2;
                    char c2 = (char) ((bArrArray[i7] & Utf8.REPLACEMENT_BYTE) | ((b & Ascii.f3759US) << 6));
                    if (!function1.invoke(Character.valueOf(c2)).booleanValue()) {
                        return decodeUtf8Result(i6 - i, -1);
                    }
                    i4 = i6 + 1;
                    cArr[i6] = c2;
                } else if ((b & 240) == 224) {
                    if (iRemaining - i7 < 2) {
                        return decodeUtf8Result(i6 - i, 3);
                    }
                    byte b2 = bArrArray[i7];
                    i3 = iArrayOffset + 3;
                    byte b3 = bArrArray[iArrayOffset + 2];
                    int i8 = b & Ascii.f3756SI;
                    int i9 = (b3 & Utf8.REPLACEMENT_BYTE) | ((b2 & Utf8.REPLACEMENT_BYTE) << 6) | (i8 << 12);
                    if (i8 != 0 && !isBmpCodePoint(i9)) {
                        malformedCodePoint(i9);
                        throw new KotlinNothingValueException();
                    }
                    char c3 = (char) i9;
                    if (!function1.invoke(Character.valueOf(c3)).booleanValue()) {
                        return decodeUtf8Result(i6 - i, -1);
                    }
                    i4 = i6 + 1;
                    cArr[i6] = c3;
                } else {
                    if ((b & 248) != 240) {
                        unsupportedByteCount(b);
                        throw new KotlinNothingValueException();
                    }
                    if (iRemaining - i7 < 3) {
                        return decodeUtf8Result(i6 - i, 4);
                    }
                    byte b4 = bArrArray[i7];
                    int i10 = iArrayOffset + 4;
                    int i11 = ((bArrArray[iArrayOffset + 2] & Utf8.REPLACEMENT_BYTE) << 6) | ((b4 & Utf8.REPLACEMENT_BYTE) << 12) | ((b & 7) << 18) | (bArrArray[iArrayOffset + 3] & Utf8.REPLACEMENT_BYTE);
                    if (!isValidCodePoint(i11)) {
                        malformedCodePoint(i11);
                        throw new KotlinNothingValueException();
                    }
                    if (i5 - i6 >= 2) {
                        char cHighSurrogate = (char) highSurrogate(i11);
                        char cLowSurrogate = (char) lowSurrogate(i11);
                        if (!function1.invoke(Character.valueOf(cHighSurrogate)).booleanValue() || !function1.invoke(Character.valueOf(cLowSurrogate)).booleanValue()) {
                            return decodeUtf8Result(i6 - i, -1);
                        }
                        int i12 = i6 + 1;
                        cArr[i6] = cHighSurrogate;
                        i6 += 2;
                        cArr[i12] = cLowSurrogate;
                        iArrayOffset = i10;
                    } else {
                        return decodeUtf8Result(i6 - i, 0);
                    }
                }
                i6 = i4;
                iArrayOffset = i3;
            }
        }
        return decodeUtf8Result(i6 - i, 0);
    }

    private static final long decodeUTF8_buffer(ByteBuffer byteBuffer, char[] cArr, int i, int i2, Function1<? super Character, Boolean> function1) throws Throwable {
        int i3;
        int i4 = i + i2;
        if (i4 > cArr.length) {
            throw indexOutOfBounds(i, i2, cArr.length);
        }
        int i5 = i;
        while (byteBuffer.hasRemaining() && i5 < i4) {
            byte b = byteBuffer.get();
            if (b >= 0) {
                char c = (char) b;
                if (!function1.invoke(Character.valueOf(c)).booleanValue()) {
                    return decodeUtf8Result(i5 - i, -1);
                }
                i3 = i5 + 1;
                cArr[i5] = c;
            } else if ((b & 224) == 192) {
                if (!byteBuffer.hasRemaining()) {
                    return decodeUtf8Result(i5 - i, 2);
                }
                char c2 = (char) (((b & Ascii.f3759US) << 6) | (byteBuffer.get() & Utf8.REPLACEMENT_BYTE));
                if (!function1.invoke(Character.valueOf(c2)).booleanValue()) {
                    return decodeUtf8Result(i5 - i, -1);
                }
                i3 = i5 + 1;
                cArr[i5] = c2;
            } else if ((b & 240) == 224) {
                if (byteBuffer.remaining() < 2) {
                    return decodeUtf8Result(i5 - i, 3);
                }
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                int i6 = b & Ascii.f3756SI;
                int i7 = ((b2 & Utf8.REPLACEMENT_BYTE) << 6) | (i6 << 12) | (b3 & Utf8.REPLACEMENT_BYTE);
                if (i6 != 0 && !isBmpCodePoint(i7)) {
                    malformedCodePoint(i7);
                    throw new KotlinNothingValueException();
                }
                char c3 = (char) i7;
                if (!function1.invoke(Character.valueOf(c3)).booleanValue()) {
                    return decodeUtf8Result(i5 - i, -1);
                }
                i3 = i5 + 1;
                cArr[i5] = c3;
            } else {
                if ((b & 248) != 240) {
                    unsupportedByteCount(b);
                    throw new KotlinNothingValueException();
                }
                if (byteBuffer.remaining() < 3) {
                    return decodeUtf8Result(i5 - i, 4);
                }
                int i8 = ((b & 7) << 18) | ((byteBuffer.get() & Utf8.REPLACEMENT_BYTE) << 12) | ((byteBuffer.get() & Utf8.REPLACEMENT_BYTE) << 6) | (byteBuffer.get() & Utf8.REPLACEMENT_BYTE);
                if (!isValidCodePoint(i8)) {
                    malformedCodePoint(i8);
                    throw new KotlinNothingValueException();
                }
                if (i4 - i5 >= 2) {
                    char cHighSurrogate = (char) highSurrogate(i8);
                    char cLowSurrogate = (char) lowSurrogate(i8);
                    if (!function1.invoke(Character.valueOf(cHighSurrogate)).booleanValue() || !function1.invoke(Character.valueOf(cLowSurrogate)).booleanValue()) {
                        return decodeUtf8Result(i5 - i, -1);
                    }
                    int i9 = i5 + 1;
                    cArr[i5] = cHighSurrogate;
                    i5 += 2;
                    cArr[i9] = cLowSurrogate;
                } else {
                    return decodeUtf8Result(i5 - i, 0);
                }
            }
            i5 = i3;
        }
        return decodeUtf8Result(i5 - i, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable indexOutOfBounds(int i, int i2, int i3) {
        return new IndexOutOfBoundsException(i + " (offset) + " + i2 + " (length) > " + i3 + " (array.length)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void malformedCodePoint(int i) {
        throw new IllegalArgumentException("Malformed code-point " + ((Object) Integer.toHexString(i)) + " found");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void unsupportedByteCount(byte b) {
        String string = Integer.toString(b & 255, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        throw new IllegalStateException(Intrinsics.stringPlus("Unsupported byte code, first byte is 0x", StringsKt.padStart(string, 2, '0')).toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0197  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final long decodeUTF8Line_array(java.nio.ByteBuffer r16, char[] r17, int r18, int r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 609
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.charsets.UTFKt.decodeUTF8Line_array(java.nio.ByteBuffer, char[], int, int):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0036 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00f6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0189 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0189 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x017f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final long decodeUTF8Line_buffer(java.nio.ByteBuffer r17, char[] r18, int r19, int r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 526
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.charsets.UTFKt.decodeUTF8Line_buffer(java.nio.ByteBuffer, char[], int, int):long");
    }
}
