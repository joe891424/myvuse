package com.yoti.mobile.mpp.smartcard.extensions;

import com.google.common.base.Ascii;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.lingala.zip4j.crypto.PBKDF2.BinTools;

/* JADX INFO: compiled from: ByteArray.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0000\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0007\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, m5598d2 = {"HEX_CHARS", "", "getHEX_CHARS$annotations", "()V", "toStringHex", "", "", "smartcard-common"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ByteArrayKt {
    private static final char[] HEX_CHARS;

    private static /* synthetic */ void getHEX_CHARS$annotations() {
    }

    static {
        char[] charArray = BinTools.hex.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        HEX_CHARS = charArray;
    }

    public static final String toStringHex(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            byte b = bArr[i];
            i++;
            int i2 = (b & 240) >>> 4;
            int i3 = b & Ascii.f3756SI;
            char[] cArr = HEX_CHARS;
            sb.append(cArr[i2]);
            sb.append(cArr[i3]);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "result.toString()");
        return string;
    }
}
