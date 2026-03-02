package com.facetec.sdk;

import com.google.common.base.Ascii;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import net.lingala.zip4j.crypto.PBKDF2.BinTools;
import org.jose4j.lang.HashUtil;
import org.jose4j.mac.MacUtil;

/* JADX INFO: renamed from: com.facetec.sdk.k */
/* JADX INFO: loaded from: classes3.dex */
final class C2222k {

    /* JADX INFO: renamed from: I */
    private static final char[] f3508I = BinTools.hex.toCharArray();

    C2222k() {
    }

    /* JADX INFO: renamed from: V */
    static String m2263V(String str) throws Exception {
        return m2259I(m2264Z(str.getBytes(StandardCharsets.UTF_8)));
    }

    /* JADX INFO: renamed from: B */
    static byte[] m2258B(String str) throws Exception {
        return m2264Z(str.getBytes(StandardCharsets.UTF_8));
    }

    /* JADX INFO: renamed from: Z */
    static byte[] m2264Z(byte[]... bArr) throws Exception {
        return MessageDigest.getInstance(HashUtil.SHA_256).digest(m2262I(bArr));
    }

    /* JADX INFO: renamed from: B */
    static String m2257B(byte[] bArr, String str) throws Exception {
        return m2259I(m2261I(bArr, str.getBytes(StandardCharsets.UTF_8)));
    }

    /* JADX INFO: renamed from: I */
    static byte[] m2260I(byte[] bArr, String str) throws Exception {
        return m2261I(bArr, str.getBytes(StandardCharsets.UTF_8));
    }

    /* JADX INFO: renamed from: I */
    private static byte[] m2261I(byte[] bArr, byte[]... bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, MacUtil.HMAC_SHA256);
        Mac mac = Mac.getInstance(MacUtil.HMAC_SHA256);
        mac.init(secretKeySpec);
        return mac.doFinal(m2262I(bArr2));
    }

    /* JADX INFO: renamed from: I */
    private static byte[] m2262I(byte[]... bArr) {
        int length = 0;
        for (byte[] bArr2 : bArr) {
            length += bArr2.length;
        }
        byte[] bArr3 = new byte[length];
        int length2 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, length2, bArr4.length);
            length2 += bArr4.length;
        }
        return bArr3;
    }

    /* JADX INFO: renamed from: I */
    static String m2259I(byte[] bArr) {
        char[] cArr = new char[bArr.length << 1];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = i << 1;
            char[] cArr2 = f3508I;
            cArr[i2] = cArr2[(b & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b & Ascii.f3756SI];
        }
        return new String(cArr);
    }
}
