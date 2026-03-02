package com.yoti.mobile.mpp.mrtddump.p096j;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.j.f */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0006H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0001*\u00020\bH\u0002\u001a\u0014\u0010\t\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\n\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m5598d2 = {"EXPECTED_MRZ_DATE_LENGTH", "", "EXPECTED_MRZ_DOC_NUMBER_LENGTH", "MRZ_DIGIT_WEIGHTS", "", "addMrzCheckDigit", "", "getValueForChecksum", "", "padMrzField", "requiredLength", "mrtddump_release"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class C5122f {

    /* JADX INFO: renamed from: a */
    private static final int[] f8138a = {7, 3, 1};

    /* JADX INFO: renamed from: a */
    private static final int m5544a(byte b) {
        if (48 <= b && b <= 57) {
            return b - 48;
        }
        if (65 > b || b > 90) {
            return 0;
        }
        return b - 55;
    }

    /* JADX INFO: renamed from: a */
    public static final String m5545a(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            i++;
            int iM5544a = m5544a((byte) cCharAt);
            int[] iArr = f8138a;
            i2 += iM5544a * iArr[i3];
            i3++;
            if (i3 >= iArr.length) {
                i3 = 0;
            }
        }
        return Intrinsics.stringPlus(str, Integer.valueOf(i2 % 10));
    }

    /* JADX INFO: renamed from: a */
    public static final String m5546a(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() >= i) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() < i) {
            sb.append(Typography.less);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString()");
        return string;
    }
}
