package com.yoti.mobile.mpp.smartcard.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: String.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0004"}, m5598d2 = {"HEX_CHARS", "", "hexStringToByteArray", "", "smartcard-common"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class StringKt {
    private static final String HEX_CHARS = "0123456789ABCDEF";

    public static final byte[] hexStringToByteArray(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bArr = new byte[str.length() / 2];
        IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, str.length()), 2);
        int first = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (true) {
                int i = first + step;
                String str2 = HEX_CHARS;
                bArr[first >> 1] = (byte) (StringsKt.indexOf$default((CharSequence) str2, str.charAt(first + 1), 0, false, 6, (Object) null) | (StringsKt.indexOf$default((CharSequence) str2, str.charAt(first), 0, false, 6, (Object) null) << 4));
                if (first == last) {
                    break;
                }
                first = i;
            }
        }
        return bArr;
    }
}
