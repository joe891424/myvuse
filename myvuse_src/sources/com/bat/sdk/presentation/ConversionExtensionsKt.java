package com.bat.sdk.presentation;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import java.io.IOException;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import net.lingala.zip4j.crypto.PBKDF2.BinTools;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ConversionExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000>\n\u0000\n\u0002\u0010\t\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0005\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u001e\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a\u000f\u0010\t\u001a\u00020\n*\u00020\u0002¢\u0006\u0002\u0010\u000b\u001a\n\u0010\f\u001a\u00020\u0002*\u00020\u0001\u001a\u0014\u0010\r\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u001a\n\u0010\r\u001a\u00020\u0002*\u00020\u0004\u001a\u0011\u0010\r\u001a\u00020\u0002*\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011\u001a\f\u0010\f\u001a\u00020\u0002*\u00020\u0012H\u0007\u001a\f\u0010\u0013\u001a\u00020\u0012*\u0004\u0018\u00010\u0002\u001a\n\u0010\u0014\u001a\u00020\u0012*\u00020\u0002\u001a\n\u0010\u0015\u001a\u00020\u0002*\u00020\u0012\u001a\u0012\u0010\u0013\u001a\u00020\u0012*\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016\u001a\u001e\u0010\u0018\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\u0019"}, m5598d2 = {"toLong", "", "", TypedValues.CycleType.S_WAVE_OFFSET, "", "toLongBigEndian", "getLongValue", "byteOrder", "Ljava/nio/ByteOrder;", "toUIntLittleEndian", "Lkotlin/UInt;", "([B)I", "toByteArray", "toByteArrayBigEndian", "size", "Lkotlin/UShort;", "toByteArrayBigEndian-xj2QHRw", "(S)[B", "", "toHexString", "toHex", "parseHex", "", "", "getShortValue", "sdk_release"}, m5599k = 2, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class ConversionExtensionsKt {
    public static /* synthetic */ long toLong$default(byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return toLong(bArr, i);
    }

    public static final long toLong(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length < i + 4 || i < 0) {
            return -1L;
        }
        return (((long) UByte.m7251constructorimpl(bArr[i])) & 255) + ((((long) UByte.m7251constructorimpl(bArr[i + 1])) & 255) << 8) + ((((long) UByte.m7251constructorimpl(bArr[i + 2])) & 255) << 16) + ((((long) UByte.m7251constructorimpl(bArr[i + 3])) & 255) << 24);
    }

    public static /* synthetic */ long toLongBigEndian$default(byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return toLongBigEndian(bArr, i);
    }

    public static final long toLongBigEndian(byte[] bArr, int i) {
        long jM7251constructorimpl;
        long jM7251constructorimpl2;
        long jM7251constructorimpl3;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        char c = '\b';
        if (bArr.length == 2 && i >= 0) {
            jM7251constructorimpl = ((long) UByte.m7251constructorimpl(bArr[i + 1])) & 255;
            jM7251constructorimpl3 = ((long) UByte.m7251constructorimpl(bArr[i])) & 255;
        } else {
            int i2 = i + 4;
            if (bArr.length == i2 || i >= 0) {
                jM7251constructorimpl = (((long) UByte.m7251constructorimpl(bArr[i + 3])) & 255) + ((((long) UByte.m7251constructorimpl(bArr[i + 2])) & 255) << 8) + ((((long) UByte.m7251constructorimpl(bArr[i + 1])) & 255) << 16);
                jM7251constructorimpl2 = (((long) UByte.m7251constructorimpl(bArr[i])) & 255) << 24;
                return jM7251constructorimpl + jM7251constructorimpl2;
            }
            if (bArr.length != i + 5 && i < 0) {
                return -1L;
            }
            jM7251constructorimpl = (((long) UByte.m7251constructorimpl(bArr[i2])) & 255) + ((((long) UByte.m7251constructorimpl(bArr[i + 3])) & 255) << 8) + ((((long) UByte.m7251constructorimpl(bArr[i + 2])) & 255) << 16) + ((((long) UByte.m7251constructorimpl(bArr[i + 1])) & 255) << 24);
            jM7251constructorimpl3 = ((long) UByte.m7251constructorimpl(bArr[i])) & 255;
            c = SafeJsonPrimitive.NULL_CHAR;
        }
        jM7251constructorimpl2 = jM7251constructorimpl3 << c;
        return jM7251constructorimpl + jM7251constructorimpl2;
    }

    public static /* synthetic */ long getLongValue$default(byte[] bArr, int i, ByteOrder byteOrder, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        return getLongValue(bArr, i, byteOrder);
    }

    public static final long getLongValue(byte[] bArr, int i, ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length < i + 4) {
            return -1L;
        }
        return (((long) UByte.m7251constructorimpl(Intrinsics.areEqual(byteOrder, ByteOrder.LITTLE_ENDIAN) ? bArr[i] : bArr[i + 3])) & 255) + ((((long) UByte.m7251constructorimpl(Intrinsics.areEqual(byteOrder, ByteOrder.LITTLE_ENDIAN) ? bArr[i + 1] : bArr[i + 2])) & 255) << 8) + ((((long) UByte.m7251constructorimpl(Intrinsics.areEqual(byteOrder, ByteOrder.LITTLE_ENDIAN) ? bArr[i + 2] : bArr[i + 1])) & 255) << 16) + ((((long) UByte.m7251constructorimpl(Intrinsics.areEqual(byteOrder, ByteOrder.LITTLE_ENDIAN) ? bArr[i + 3] : bArr[i])) & 255) << 24);
    }

    public static final int toUIntLittleEndian(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length != 2) {
            throw new IllegalArgumentException("Byte array must be exactly 2 bytes long".toString());
        }
        return UInt.m7328constructorimpl(UInt.m7328constructorimpl(UInt.m7328constructorimpl(UInt.m7328constructorimpl(bArr[1]) & 255) << 8) | UInt.m7328constructorimpl(UInt.m7328constructorimpl(bArr[0]) & 255));
    }

    public static final byte[] toByteArray(long j) {
        byte[] bArr = {0, 0, 0, 0};
        bArr[0] = (byte) (j & 255);
        bArr[1] = (byte) ((j >> 8) & 255);
        bArr[2] = (byte) ((j >> 16) & 255);
        bArr[3] = (byte) ((j >> 24) & 255);
        return bArr;
    }

    public static /* synthetic */ byte[] toByteArrayBigEndian$default(long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 4;
        }
        return toByteArrayBigEndian(j, i);
    }

    public static final byte[] toByteArrayBigEndian(long j, int i) {
        if (i == 2) {
            byte[] bArr = {0, 0};
            bArr[1] = (byte) (j & 255);
            bArr[0] = (byte) ((j >> 8) & 255);
            return bArr;
        }
        byte[] bArr2 = {0, 0, 0, 0};
        bArr2[3] = (byte) (j & 255);
        bArr2[2] = (byte) ((j >> 8) & 255);
        bArr2[1] = (byte) ((j >> 16) & 255);
        bArr2[0] = (byte) ((j >> 24) & 255);
        return bArr2;
    }

    public static final byte[] toByteArrayBigEndian(int i) {
        return toByteArrayBigEndian$default(i, 0, 1, null);
    }

    /* JADX INFO: renamed from: toByteArrayBigEndian-xj2QHRw, reason: not valid java name */
    public static final byte[] m5931toByteArrayBigEndianxj2QHRw(short s) {
        byte[] bArr = {0, 0};
        bArr[1] = (byte) (s & 255);
        bArr[0] = (byte) (((65535 & s) >> 8) & 255);
        return bArr;
    }

    public static final byte[] toByteArray(String str) throws IOException {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String upperCase = str.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase()");
        String str2 = upperCase;
        StringBuilder sb = new StringBuilder();
        int length = str2.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str2.charAt(i);
            if (StringsKt.contains$default((CharSequence) BinTools.hex, cCharAt, false, 2, (Object) null)) {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "filterTo(StringBuilder(), predicate).toString()");
        int length2 = string.length() % 2 == 1 ? (string.length() / 2) + 1 : string.length() / 2;
        byte[] bArr = new byte[length2];
        for (int i2 = 0; i2 < length2; i2++) {
            int i3 = i2 * 2;
            int i4 = i3 + 1;
            bArr[i2] = (byte) ((StringsKt.indexOf$default((CharSequence) str, string.charAt(i3), 0, false, 6, (Object) null) * 16) + (i4 == string.length() ? 0 : StringsKt.indexOf$default((CharSequence) str, string.charAt(i4), 0, false, 6, (Object) null)));
        }
        return bArr;
    }

    public static final String toHexString(byte[] bArr) {
        return toHexString(bArr != null ? ArraysKt.asList(bArr) : null);
    }

    public static final String toHex(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.bat.sdk.presentation.ConversionExtensionsKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ConversionExtensionsKt.toHex$lambda$2(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toHex$lambda$2(byte b) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%02X", Arrays.copyOf(new Object[]{Integer.valueOf(b & 255)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }

    public static final byte[] parseHex(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bArr = new byte[str.length() / 2];
        IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, str.length()), 2);
        int first = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (true) {
                bArr[first / 2] = (byte) ((CharsKt.digitToInt(str.charAt(first), 16) << 4) + CharsKt.digitToInt(str.charAt(first + 1), 16));
                if (first == last) {
                    break;
                }
                first += step;
            }
        }
        return bArr;
    }

    public static final String toHexString(List<Byte> list) {
        if (list == null) {
            return "null";
        }
        if (list.isEmpty()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        return CollectionsKt.joinToString$default(list, " ", "[ ", " ]", 0, null, new Function1() { // from class: com.bat.sdk.presentation.ConversionExtensionsKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ConversionExtensionsKt.toHexString$lambda$3(((Byte) obj).byteValue());
            }
        }, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toHexString$lambda$3(byte b) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%02X", Arrays.copyOf(new Object[]{Integer.valueOf(b & 255)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }

    public static /* synthetic */ int getShortValue$default(byte[] bArr, int i, ByteOrder byteOrder, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        return getShortValue(bArr, i, byteOrder);
    }

    public static final int getShortValue(byte[] bArr, int i, ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length < i + 2 || i == -1) {
            return -1;
        }
        return (UByte.m7251constructorimpl(Intrinsics.areEqual(byteOrder, ByteOrder.LITTLE_ENDIAN) ? bArr[i] : bArr[i + 1]) & 255) + ((UByte.m7251constructorimpl(Intrinsics.areEqual(byteOrder, ByteOrder.LITTLE_ENDIAN) ? bArr[i + 1] : bArr[i]) & 255) << 8);
    }
}
