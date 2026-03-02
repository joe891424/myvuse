package com.facetec.sdk;

import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.os.Build;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: renamed from: com.facetec.sdk.cn */
/* JADX INFO: loaded from: classes3.dex */
public class C2200cn extends C2207cu {

    /* JADX INFO: renamed from: D */
    private static int f3051D = 0;

    /* JADX INFO: renamed from: B */
    private static char[] f3050B = {347, 348, 293, 361, 358, 345, 365, 344, 357, 352, 367, 359, 362, 335, 313, 350, 332, 331, 317, 292, 303, 327};

    /* JADX INFO: renamed from: Z */
    private static boolean f3055Z = true;

    /* JADX INFO: renamed from: I */
    private static int f3053I = 247;

    /* JADX INFO: renamed from: V */
    private static boolean f3054V = true;
    private static long Code = -8264099994146092894L;

    /* JADX INFO: renamed from: F */
    private static int f3052F = 119 % 128;

    /* JADX INFO: renamed from: b */
    private static native byte[] m2008b(int i, int i2);

    /* JADX INFO: renamed from: I */
    public static int m2002I(int i) {
        int i2 = f3052F + 95;
        int i3 = i2 % 128;
        f3051D = i3;
        int i4 = i2 % 2;
        int i5 = i3 + 11;
        f3052F = i5 % 128;
        int i6 = i5 % 2;
        int iCode = m2000B(i).Code();
        int i7 = f3051D + 55;
        f3052F = i7 % 128;
        int i8 = i7 % 2;
        return iCode;
    }

    /* JADX INFO: renamed from: Z */
    private static C2215dd m2007Z(int i) {
        try {
            V v = new V((byte) 0);
            try {
                new RuntimeException().printStackTrace(new PrintStream(v));
                long jM2010B = V.m2010B(v);
                if (jM2010B == 1078223722248L) {
                    int i2 = f3051D + 7;
                    f3052F = i2 % 128;
                    int i3 = i2 % 2;
                    int i4 = (int) jM2010B;
                    m2003I("䣺ᘕ", ImageFormat.getBitsPerPixel(0) + 24198);
                    int i5 = i4 ^ i;
                    if (i5 != i) {
                        return new C2215dd(i5, (byte) 0);
                    }
                }
                v.close();
            } finally {
                v.close();
            }
        } catch (Exception unused) {
        }
        C2215dd c2215dd = new C2215dd(i, (byte) 0);
        int i6 = f3051D + 35;
        f3052F = i6 % 128;
        int i7 = i6 % 2;
        return c2215dd;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [byte[], int] */
    /* JADX INFO: renamed from: V */
    private static synchronized C2215dd m2004V(int i) {
        String strCode;
        CharBuffer charBufferDecode;
        int i2 = f3051D + 93;
        f3052F = i2 % 128;
        ?? r1 = i2 % 2;
        try {
            if (r1 == 0) {
                charBufferDecode = Charset.forName(m2005V(null, null, TextUtils.indexOf("", "") + 60, "\u0095\u0094\u0093\u0092\u0091")).newDecoder().decode(ByteBuffer.wrap(m2008b(i, 0)));
            } else {
                charBufferDecode = Charset.forName(m2005V(null, null, 127 - TextUtils.indexOf("", ""), "\u0095\u0094\u0093\u0092\u0091")).newDecoder().decode(ByteBuffer.wrap(m2008b(i, 0)));
            }
            strCode = charBufferDecode.toString();
            int i3 = f3052F + 101;
            f3051D = i3 % 128;
            int i4 = i3 % 2;
        } catch (CharacterCodingException unused) {
            strCode = C2208cv.Code(r1);
        }
        int iIndexOf = strCode.indexOf(m2003I("䢙", TextUtils.lastIndexOf("", '0', 0) + 32310));
        int i5 = Integer.parseInt(strCode.substring(0, iIndexOf));
        String strSubstring = strCode.substring(iIndexOf + 1);
        if (i == i5) {
            return new C2215dd(i5, (byte) 0);
        }
        if (6 != strSubstring.split(m2003I("䢙", (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 32308)).length) {
            return new C2215dd(i5, (byte) 0);
        }
        return new C2215dd(i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x005d A[Catch: all -> 0x009f, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0045, B:8:0x0057, B:10:0x006b, B:12:0x0071, B:15:0x007c, B:17:0x0086, B:24:0x0098, B:25:0x0099, B:9:0x005d, B:21:0x0093, B:22:0x0096), top: B:33:0x0003, inners: #0 }] */
    /* JADX INFO: renamed from: B */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static synchronized com.facetec.sdk.C2215dd m2000B(int r9) {
        /*
            java.lang.Class<com.facetec.sdk.cn> r0 = com.facetec.sdk.C2200cn.class
            monitor-enter(r0)
            int r1 = com.facetec.sdk.C2200cn.f3051D     // Catch: java.lang.Throwable -> L9f
            int r1 = r1 + 63
            int r2 = r1 % 128
            com.facetec.sdk.C2200cn.f3052F = r2     // Catch: java.lang.Throwable -> L9f
            r2 = 2
            int r1 = r1 % r2
            java.lang.String[] r1 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L9f
            float r3 = android.media.AudioTrack.getMinVolume()     // Catch: java.lang.Throwable -> L9f
            r4 = 0
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            int r3 = r3 + 127
            java.lang.String r5 = "\u0082\u0090\u0081\u008a\u0084\u008f\u0081\u0082\u008d\u0085\u008c\u008e\u0083\u0081\u0082\u008d\u0085\u008c\u008b\u0083\u0081\u008a\u0085\u0084\u0081\u0089\u0088\u0083\u0087\u0086\u0085\u0084\u0083\u0082\u0081"
            r6 = 0
            java.lang.String r3 = m2005V(r6, r6, r3, r5)     // Catch: java.lang.Throwable -> L9f
            java.lang.String r3 = r3.intern()     // Catch: java.lang.Throwable -> L9f
            r5 = 0
            r1[r5] = r3     // Catch: java.lang.Throwable -> L9f
            java.lang.String r3 = "䣆뵶ꏮ꧃鸉蒵諲｛\ue54b\uebf5퀬왋첁ㄶ❨ⷓᏊ᠓\u0ebf瓲礓潃喺娝䁹뚴묕ꅬ鞊鷇艳袩ﻊ\ue31c\ue94f\udffa"
            int r7 = android.view.ViewConfiguration.getFadingEdgeLength()     // Catch: java.lang.Throwable -> L9f
            int r7 = r7 >> 16
            r8 = 62897(0xf5b1, float:8.8137E-41)
            int r7 = r7 + r8
            java.lang.String r3 = m2003I(r3, r7)     // Catch: java.lang.Throwable -> L9f
            java.lang.String r3 = r3.intern()     // Catch: java.lang.Throwable -> L9f
            r7 = 1
            r1[r7] = r3     // Catch: java.lang.Throwable -> L9f
            boolean r1 = m2001B(r1)     // Catch: java.lang.Throwable -> L9f
            if (r1 == 0) goto L5d
            java.lang.String r1 = "䣺ኺ"
            float r3 = android.media.AudioTrack.getMinVolume()     // Catch: java.lang.Throwable -> L9f
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            int r3 = 23081 - r3
            m2003I(r1, r3)     // Catch: java.lang.Throwable -> L9f
            r1 = r9 ^ 1
            if (r1 == r9) goto L5d
            com.facetec.sdk.dd r3 = new com.facetec.sdk.dd     // Catch: java.lang.Throwable -> L9f
            r3.<init>(r1, r5)     // Catch: java.lang.Throwable -> L9f
            goto L6b
        L5d:
            com.facetec.sdk.dd r3 = new com.facetec.sdk.dd     // Catch: java.lang.Throwable -> L9f
            r3.<init>(r9, r5)     // Catch: java.lang.Throwable -> L9f
            int r1 = com.facetec.sdk.C2200cn.f3052F     // Catch: java.lang.Throwable -> L9f
            int r1 = r1 + 73
            int r4 = r1 % 128
            com.facetec.sdk.C2200cn.f3051D = r4     // Catch: java.lang.Throwable -> L9f
            int r1 = r1 % r2
        L6b:
            int r1 = r3.Code()     // Catch: java.lang.Throwable -> L9f
            if (r9 == r1) goto L7c
            int r9 = com.facetec.sdk.C2200cn.f3052F     // Catch: java.lang.Throwable -> L9f
            int r9 = r9 + 3
            int r1 = r9 % 128
            com.facetec.sdk.C2200cn.f3051D = r1     // Catch: java.lang.Throwable -> L9f
            int r9 = r9 % r2
            monitor-exit(r0)
            return r3
        L7c:
            com.facetec.sdk.dd r1 = m2007Z(r9)     // Catch: java.lang.Throwable -> L9f
            int r3 = r1.Code()     // Catch: java.lang.Throwable -> L9f
            if (r9 == r3) goto L99
            int r9 = com.facetec.sdk.C2200cn.f3051D     // Catch: java.lang.Throwable -> L9f
            int r9 = r9 + 53
            int r3 = r9 % 128
            com.facetec.sdk.C2200cn.f3052F = r3     // Catch: java.lang.Throwable -> L9f
            int r9 = r9 % r2
            if (r9 == 0) goto L93
            monitor-exit(r0)
            return r1
        L93:
            super.hashCode()     // Catch: java.lang.Throwable -> L97
            throw r6     // Catch: java.lang.Throwable -> L97
        L97:
            r9 = move-exception
            throw r9     // Catch: java.lang.Throwable -> L9f
        L99:
            com.facetec.sdk.dd r9 = m2004V(r9)     // Catch: java.lang.Throwable -> L9f
            monitor-exit(r0)
            return r9
        L9f:
            r9 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9f
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facetec.sdk.C2200cn.m2000B(int):com.facetec.sdk.dd");
    }

    /* JADX INFO: renamed from: B */
    private static boolean m2001B(String... strArr) {
        int i = f3051D + 105;
        f3052F = i % 128;
        int i2 = i % 2;
        int i3 = 0;
        while (i3 < 2) {
            String str = strArr[i3];
            try {
                try {
                    Class.forName(str, false, C2200cn.class.getClassLoader());
                    return true;
                } catch (Exception unused) {
                    Class.forName(str, false, ClassLoader.getSystemClassLoader());
                    return true;
                }
            } catch (Exception unused2) {
                if (new I(ClassLoader.getSystemClassLoader()).Code(str)) {
                    return true;
                }
                try {
                    if (Build.VERSION.SDK_INT < 28) {
                        Object obj = null;
                        if (Build.VERSION.RELEASE.equals(m2005V(null, null, 127 - (ViewConfiguration.getFadingEdgeLength() >> 16), "\u0096"))) {
                            continue;
                        } else {
                            int i4 = f3052F + 97;
                            f3051D = i4 % 128;
                            int i5 = i4 % 2;
                            Method declaredMethod = Class.class.getDeclaredMethod(m2003I("䣁㣽ꢥᡈ蠝砛\ue9ff妵쥴뤈⤱髶", 28771 - AndroidCharacter.getMirror('0')), String.class, Boolean.TYPE, ClassLoader.class);
                            declaredMethod.setAccessible(true);
                            try {
                                declaredMethod.invoke(null, str, Boolean.FALSE, ClassLoader.getSystemClassLoader());
                                int i6 = f3052F + 109;
                                f3051D = i6 % 128;
                                if (i6 % 2 == 0) {
                                    return true;
                                }
                                super.hashCode();
                                throw null;
                            } catch (InvocationTargetException e) {
                                e.getTargetException();
                                i3++;
                                int i7 = f3051D + 69;
                                f3052F = i7 % 128;
                                int i8 = i7 % 2;
                            }
                        }
                    } else {
                        continue;
                    }
                } catch (IllegalAccessException | NoSuchMethodException unused3) {
                }
                i3++;
                int i72 = f3051D + 69;
                f3052F = i72 % 128;
                int i82 = i72 % 2;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: B */
    static long m1999B(long j) {
        BigInteger bigIntegerSubtract;
        int i = f3051D + 45;
        f3052F = i % 128;
        if (i % 2 != 0 ? j < 0 : j < 0) {
            bigIntegerSubtract = BigInteger.valueOf(j & Long.MAX_VALUE).subtract(BigInteger.valueOf(Long.MIN_VALUE));
        } else {
            bigIntegerSubtract = BigInteger.valueOf(j);
        }
        long jLongValue = bigIntegerSubtract.modPow(new BigInteger(m2003I("䢒짯䩠쳣䴴쿢䁾싺䍾얥", (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 33149).intern(), 16), new BigInteger(m2003I("䢒䧙䩕䭺䷬亳佘䇊䋏䌹䑴䚭䜞堉嫞寳屷嵨", 331 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))).intern(), 16)).longValue();
        int i2 = f3051D + 9;
        f3052F = i2 % 128;
        if (i2 % 2 != 0) {
            return jLongValue;
        }
        Object obj = null;
        super.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: Z */
    static int m2006Z(long j) {
        int i;
        int i2 = f3052F + 45;
        int i3 = i2 % 128;
        f3051D = i3;
        if (i2 % 2 != 0) {
            i = (((int) j) ^ (-1437226411)) & ((int) (j >> 94)) & 1437226410;
        } else {
            i = (((int) j) & (-1437226411)) | (((int) (j >> 32)) & 1437226410);
        }
        int i4 = i3 + 103;
        f3052F = i4 % 128;
        int i5 = i4 % 2;
        return i;
    }

    /* JADX INFO: renamed from: com.facetec.sdk.cn$V */
    static class V extends OutputStream {

        /* JADX INFO: renamed from: I */
        private static int f3062I = 1;

        /* JADX INFO: renamed from: Z */
        private static int f3063Z;
        private long Code;

        private V() {
        }

        /* synthetic */ V(byte b) {
            this();
        }

        /* JADX INFO: renamed from: B */
        static /* synthetic */ long m2010B(V v) {
            int i = f3063Z;
            int i2 = ((i | 33) << 1) - (i ^ 33);
            int i3 = i2 % 128;
            f3062I = i3;
            int i4 = i2 % 2;
            long j = v.Code;
            int i5 = ((i3 | 99) << 1) - (i3 ^ 99);
            f3063Z = i5 % 128;
            int i6 = i5 % 2;
            return j;
        }

        @Override // java.io.OutputStream
        public final void write(int i) throws IOException {
            int i2 = f3062I;
            int i3 = ((i2 | 5) << 1) - (i2 ^ 5);
            int i4 = i3 % 128;
            f3063Z = i4;
            int i5 = i3 % 2;
            long j = this.Code;
            if (j != 1078223722248L) {
                int i6 = (i4 ^ 69) + ((i4 & 69) << 1);
                f3062I = i6 % 128;
                int i7 = i6 % 2;
                this.Code = ((j << 1) ^ ((long) i)) & 1099511627775L;
                int i8 = ((i4 | 125) << 1) - (i4 ^ 125);
                f3062I = i8 % 128;
                int i9 = i8 % 2;
            }
            int i10 = (i4 & 91) + (i4 | 91);
            f3062I = i10 % 128;
            int i11 = i10 % 2;
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.cn$I */
    static class I extends ClassLoader {
        private static char Code = 35215;

        /* JADX INFO: renamed from: F */
        private static int f3056F = 1;

        /* JADX INFO: renamed from: I */
        private static char f3057I = 19927;

        /* JADX INFO: renamed from: L */
        private static int f3058L = 0;

        /* JADX INFO: renamed from: V */
        private static char f3059V = 44586;

        /* JADX INFO: renamed from: Z */
        private static char f3060Z = 6788;

        /* JADX INFO: renamed from: B */
        private final ClassLoader f3061B;

        I(ClassLoader classLoader) {
            super(classLoader);
            this.f3061B = classLoader;
        }

        final boolean Code(String str) {
            int i = f3058L + 9;
            f3056F = i % 128;
            int i2 = i % 2;
            try {
                Method declaredMethod = ClassLoader.class.getDeclaredMethod(m2009Z("೩ꙅإꖢ슢ꩅꇅ樅狱뾵䥔ꀅ扻姐룤\ud8b0", 15 - (KeyEvent.getMaxKeyCode() >> 16)), String.class);
                declaredMethod.setAccessible(true);
                if (((Class) declaredMethod.invoke(this.f3061B, str)) != null) {
                    int i3 = f3058L + 107;
                    int i4 = i3 % 128;
                    f3056F = i4;
                    z = i3 % 2 != 0;
                    int i5 = i4 + 105;
                    f3058L = i5 % 128;
                    int i6 = i5 % 2;
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
            return z;
        }

        /* JADX INFO: renamed from: Z */
        private static String m2009Z(String str, int i) {
            String str2;
            char[] charArray = str.toCharArray();
            synchronized (C2209cw.f3136B) {
                char[] cArr = new char[charArray.length];
                C2209cw.f3137I = 0;
                char[] cArr2 = new char[2];
                while (C2209cw.f3137I < charArray.length) {
                    cArr2[0] = charArray[C2209cw.f3137I];
                    cArr2[1] = charArray[C2209cw.f3137I + 1];
                    int i2 = 58224;
                    for (int i3 = 0; i3 < 16; i3++) {
                        char c = cArr2[1];
                        char c2 = cArr2[0];
                        char c3 = (char) (c - (((c2 + i2) ^ ((c2 << 4) + f3059V)) ^ ((c2 >>> 5) + Code)));
                        cArr2[1] = c3;
                        cArr2[0] = (char) (c2 - (((c3 >>> 5) + f3060Z) ^ ((c3 + i2) ^ ((c3 << 4) + f3057I))));
                        i2 -= 40503;
                    }
                    cArr[C2209cw.f3137I] = cArr2[0];
                    cArr[C2209cw.f3137I + 1] = cArr2[1];
                    C2209cw.f3137I += 2;
                }
                str2 = new String(cArr, 0, i);
            }
            return str2;
        }
    }

    /* JADX INFO: renamed from: V */
    private static String m2005V(String str, int[] iArr, int i, String str2) throws UnsupportedEncodingException {
        byte[] bytes = str2.getBytes(InternalZipConstants.AES_HASH_CHARSET);
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (C2212cz.f3181I) {
            char[] cArr2 = f3050B;
            int i2 = f3053I;
            if (f3055Z) {
                int length = bytes.length;
                C2212cz.Code = length;
                char[] cArr3 = new char[length];
                C2212cz.f3182V = 0;
                while (C2212cz.f3182V < C2212cz.Code) {
                    cArr3[C2212cz.f3182V] = (char) (cArr2[bytes[(C2212cz.Code - 1) - C2212cz.f3182V] + i] - i2);
                    C2212cz.f3182V++;
                }
                return new String(cArr3);
            }
            if (f3054V) {
                int length2 = cArr.length;
                C2212cz.Code = length2;
                char[] cArr4 = new char[length2];
                C2212cz.f3182V = 0;
                while (C2212cz.f3182V < C2212cz.Code) {
                    cArr4[C2212cz.f3182V] = (char) (cArr2[cArr[(C2212cz.Code - 1) - C2212cz.f3182V] - i] - i2);
                    C2212cz.f3182V++;
                }
                return new String(cArr4);
            }
            int length3 = iArr.length;
            C2212cz.Code = length3;
            char[] cArr5 = new char[length3];
            C2212cz.f3182V = 0;
            while (C2212cz.f3182V < C2212cz.Code) {
                cArr5[C2212cz.f3182V] = (char) (cArr2[iArr[(C2212cz.Code - 1) - C2212cz.f3182V] - i] - i2);
                C2212cz.f3182V++;
            }
            return new String(cArr5);
        }
    }

    /* JADX INFO: renamed from: I */
    private static String m2003I(String str, int i) {
        String str2;
        char[] charArray = str.toCharArray();
        synchronized (C2201co.f3064B) {
            C2201co.f3066V = i;
            char[] cArr = new char[charArray.length];
            C2201co.f3065I = 0;
            while (C2201co.f3065I < charArray.length) {
                cArr[C2201co.f3065I] = (char) (((long) (charArray[C2201co.f3065I] ^ (C2201co.f3065I * C2201co.f3066V))) ^ Code);
                C2201co.f3065I++;
            }
            str2 = new String(cArr);
        }
        return str2;
    }

    static {
        int i = 119 % 2;
    }
}
