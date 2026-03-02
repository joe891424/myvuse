package com.facetec.sdk;

import android.view.View;
import android.view.ViewConfiguration;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;

/* JADX INFO: renamed from: com.facetec.sdk.cv */
/* JADX INFO: loaded from: classes3.dex */
public final class C2208cv {

    /* JADX INFO: renamed from: B */
    private static char f3131B = 12492;
    private static char Code = 15074;

    /* JADX INFO: renamed from: D */
    private static int f3132D = 1;

    /* JADX INFO: renamed from: I */
    private static int f3133I = 0;

    /* JADX INFO: renamed from: V */
    private static char f3134V = 56164;

    /* JADX INFO: renamed from: Z */
    private static char f3135Z = 52710;

    public static String Code(byte[] bArr) {
        byte b;
        int iMin;
        byte[] bArr2;
        byte b2;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < bArr.length) {
            int i2 = f3132D + 89;
            f3133I = i2 % 128;
            if (i2 % 2 != 0) {
                b = bArr[i];
                if (m2049V(b)) {
                    iMin = Math.min(m2050Z(b) + 1, bArr.length - i);
                    bArr2 = new byte[iMin];
                    System.arraycopy(bArr, i, bArr2, 0, iMin);
                    try {
                        sb.append((CharSequence) Charset.forName(m2048I("\uaa3a甦쥌筺ꕽᝣ", 5 - View.MeasureSpec.getMode(0))).newDecoder().decode(ByteBuffer.wrap(bArr2)));
                        i += iMin;
                    } catch (CharacterCodingException unused) {
                        sb.append(m2047I(bArr2[0]));
                        int i3 = 1;
                        int i4 = 1;
                        while (i3 < iMin) {
                            int i5 = f3133I + 85;
                            f3132D = i5 % 128;
                            if (i5 % 2 != 0) {
                                b2 = bArr2[i3];
                                if (m2049V(b2)) {
                                    break;
                                }
                                sb.append(m2047I(b2));
                                i4++;
                                i3++;
                                int i6 = f3133I + 87;
                                f3132D = i6 % 128;
                                int i7 = i6 % 2;
                            } else {
                                b2 = bArr2[i3];
                                if (!(!m2049V(b2))) {
                                    break;
                                }
                                sb.append(m2047I(b2));
                                i4++;
                                i3++;
                                int i62 = f3133I + 87;
                                f3132D = i62 % 128;
                                int i72 = i62 % 2;
                            }
                        }
                        i += i4;
                        int i8 = f3132D + 21;
                        f3133I = i8 % 128;
                        int i9 = i8 % 2;
                    }
                } else {
                    sb.append(m2047I(b));
                    i++;
                }
            } else {
                b = bArr[i];
                if (m2049V(b)) {
                    iMin = Math.min(m2050Z(b) + 1, bArr.length - i);
                    bArr2 = new byte[iMin];
                    System.arraycopy(bArr, i, bArr2, 0, iMin);
                    sb.append((CharSequence) Charset.forName(m2048I("\uaa3a甦쥌筺ꕽᝣ", 5 - View.MeasureSpec.getMode(0))).newDecoder().decode(ByteBuffer.wrap(bArr2)));
                    i += iMin;
                } else {
                    sb.append(m2047I(b));
                    i++;
                }
            }
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: Z */
    private static int m2050Z(byte b) {
        int i = (b >> 7) & 1;
        if (i == 0) {
            int i2 = f3132D + 93;
            f3133I = i2 % 128;
            int i3 = i2 % 2;
            return 0;
        }
        if (i == 1) {
            int i4 = f3133I;
            int i5 = i4 + 47;
            f3132D = i5 % 128;
            int i6 = i5 % 2;
            if (((b >> 6) & 1) == 1 && ((b >> 5) & 1) == 0) {
                int i7 = i4 + 29;
                f3132D = i7 % 128;
                int i8 = i7 % 2;
                return 1;
            }
        }
        if (i == 1) {
            int i9 = f3132D + 31;
            int i10 = i9 % 128;
            f3133I = i10;
            if (i9 % 2 == 0 ? ((b >> 6) & 1) == 1 : (b << Ascii.f3759US) == 1) {
                if (((b >> 5) & 1) == 1) {
                    int i11 = i10 + 99;
                    f3132D = i11 % 128;
                    if (i11 % 2 != 0 ? ((b >> 4) & 1) == 0 : (b >> 2) == 0) {
                        return 2;
                    }
                }
            }
        }
        if (i != 1) {
            return -1;
        }
        int i12 = f3133I;
        int i13 = i12 + 71;
        f3132D = i13 % 128;
        int i14 = i13 % 2;
        if (((b >> 6) & 1) != 1 || ((b >> 5) & 1) != 1 || ((b >> 4) & 1) != 1 || ((b >> 3) & 1) != 0) {
            return -1;
        }
        int i15 = i12 + 117;
        f3132D = i15 % 128;
        int i16 = i15 % 2;
        return 3;
    }

    /* JADX INFO: renamed from: V */
    private static boolean m2049V(byte b) {
        int i = f3133I + 1;
        f3132D = i % 128;
        int i2 = i % 2;
        if (m2050Z(b) == -1) {
            return false;
        }
        int i3 = f3132D + 95;
        f3133I = i3 % 128;
        int i4 = i3 % 2;
        return true;
    }

    /* JADX INFO: renamed from: I */
    private static String m2047I(byte b) {
        String string = new StringBuilder().append(m2048I("᧾\uebf0", 2 - View.MeasureSpec.getMode(0))).append(String.format(m2048I("诂鈻佝\u19cb", (ViewConfiguration.getLongPressTimeout() >> 16) + 4), Byte.valueOf(b))).toString();
        int i = f3133I + 73;
        f3132D = i % 128;
        int i2 = i % 2;
        return string;
    }

    /* JADX INFO: renamed from: I */
    private static String m2048I(String str, int i) {
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
                    char c3 = (char) (c - (((c2 + i2) ^ ((c2 << 4) + Code)) ^ ((c2 >>> 5) + f3134V)));
                    cArr2[1] = c3;
                    cArr2[0] = (char) (c2 - (((c3 >>> 5) + f3131B) ^ ((c3 + i2) ^ ((c3 << 4) + f3135Z))));
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
