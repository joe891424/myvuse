package com.yoti.mobile.android.commons.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HexConverter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\f\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0015\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0003¨\u0006\u0006"}, m5598d2 = {"", "", "toHex", "([B)Ljava/lang/String;", "byteArray", "bytesToHex", "commons-utils_release"}, m5599k = 2, m5600mv = {1, 4, 2})
public final class HexConverter {
    public static final String bytesToHex(byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        StringBuilder sb = new StringBuilder();
        for (byte b : byteArray) {
            String hexString = Integer.toHexString(b & 255);
            Intrinsics.checkNotNullExpressionValue(hexString, "Integer.toHexString(0xFF and byteArray[i].toInt())");
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    public static final String toHex(byte[] toHex) {
        Intrinsics.checkNotNullParameter(toHex, "$this$toHex");
        return bytesToHex(toHex);
    }
}
