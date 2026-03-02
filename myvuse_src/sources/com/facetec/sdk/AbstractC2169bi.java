package com.facetec.sdk;

import android.graphics.Color;
import android.os.Process;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

/* JADX INFO: renamed from: com.facetec.sdk.bi */
/* JADX INFO: loaded from: classes3.dex */
abstract class AbstractC2169bi implements ZoomEncryptStrings {

    /* JADX INFO: renamed from: B */
    private static int f2825B = 0;
    private static int Code = 1;

    /* JADX INFO: renamed from: I */
    private static char f2826I = 39553;

    /* JADX INFO: renamed from: V */
    private static long f2827V;

    /* JADX INFO: renamed from: Z */
    private static int f2828Z;

    protected AbstractC2169bi() {
    }

    protected static byte[] Code(Cipher cipher, byte[] bArr) throws Exception {
        int i = 2 % 2;
        int i2 = f2828Z + 107;
        Code = i2 % 128;
        try {
            if (i2 % 2 != 0) {
                return cipher.doFinal(bArr);
            }
            cipher.doFinal(bArr);
            throw null;
        } catch (Exception e) {
            C2121D.Code(e);
            return null;
        }
    }

    /* JADX INFO: renamed from: B */
    protected static byte[] m1878B(Cipher cipher, byte[] bArr) throws Exception {
        int i = 2 % 2;
        int i2 = f2828Z + 119;
        Code = i2 % 128;
        int i3 = i2 % 2;
        try {
            byte[] bArrDoFinal = cipher.doFinal(bArr);
            int i4 = Code + 87;
            f2828Z = i4 % 128;
            if (i4 % 2 == 0) {
                return bArrDoFinal;
            }
            throw null;
        } catch (Exception e) {
            C2121D.Code(e);
            return null;
        }
    }

    protected static byte[] Code() throws Exception {
        int i = 2 % 2;
        SecureRandom secureRandom = new SecureRandom();
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(m1877B((-503339646) - (Process.myTid() >> 22), "芫ﾥ鷡꾛", "\u0000\u0000\u0000\u0000", (char) (Color.blue(0) + 39837), "彌\uf3d7龤").intern());
            keyGenerator.init(128, secureRandom);
            byte[] encoded = keyGenerator.generateKey().getEncoded();
            int i2 = f2828Z + 33;
            Code = i2 % 128;
            if (i2 % 2 != 0) {
                return encoded;
            }
            throw null;
        } catch (NoSuchAlgorithmException e) {
            throw new Exception(C2188cb.m1995V(e.getMessage()));
        }
    }

    /* JADX INFO: renamed from: B */
    private static String m1877B(int i, String str, String str2, char c, String str3) {
        String str4;
        Object charArray = str3;
        if (str3 != null) {
            charArray = str3.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        Object charArray2 = str2;
        if (str2 != null) {
            charArray2 = str2.toCharArray();
        }
        char[] cArr2 = (char[]) charArray2;
        Object charArray3 = str;
        if (str != null) {
            charArray3 = str.toCharArray();
        }
        char[] cArr3 = (char[]) charArray3;
        synchronized (C2189cc.f3019Z) {
            char[] cArr4 = (char[]) cArr3.clone();
            char[] cArr5 = (char[]) cArr2.clone();
            cArr4[0] = (char) (c ^ cArr4[0]);
            cArr5[2] = (char) (cArr5[2] + ((char) i));
            int length = cArr.length;
            char[] cArr6 = new char[length];
            C2189cc.f3018V = 0;
            while (C2189cc.f3018V < length) {
                int i2 = (C2189cc.f3018V + 2) % 4;
                int i3 = (C2189cc.f3018V + 3) % 4;
                C2189cc.f3017I = (char) (((cArr4[C2189cc.f3018V % 4] * 32718) + cArr5[i2]) % 65535);
                cArr5[i3] = (char) (((cArr4[i3] * 32718) + cArr5[i2]) / 65535);
                cArr4[i3] = C2189cc.f3017I;
                cArr6[C2189cc.f3018V] = (char) (((((long) (cArr4[i3] ^ cArr[C2189cc.f3018V])) ^ f2827V) ^ ((long) f2825B)) ^ ((long) f2826I));
                C2189cc.f3018V++;
            }
            str4 = new String(cArr6);
        }
        return str4;
    }
}
