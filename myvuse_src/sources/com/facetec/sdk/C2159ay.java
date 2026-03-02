package com.facetec.sdk;

import android.graphics.Color;
import android.os.Process;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: renamed from: com.facetec.sdk.ay */
/* JADX INFO: loaded from: classes3.dex */
final class C2159ay extends AbstractC2169bi {

    /* JADX INFO: renamed from: B */
    private static int f2669B = 352001984;

    /* JADX INFO: renamed from: C */
    private static int f2670C = 1;

    /* JADX INFO: renamed from: D */
    private static int f2671D = 0;

    /* JADX INFO: renamed from: S */
    private static short[] f2672S = null;

    /* JADX INFO: renamed from: V */
    private static int f2673V = 92;

    /* JADX INFO: renamed from: I */
    private final SecretKeySpec f2675I;

    /* JADX INFO: renamed from: Z */
    private static byte[] f2674Z = {121, 111, -125, 79, 79, 74, 77, 91, 101, 108, 90, -126, -123, 43, 118, 75, -119, 94, -90, 88, 78, 0, 0};
    private static int Code = -1309218560;

    public C2159ay(byte[] bArr) throws Exception {
        this.f2675I = new SecretKeySpec(bArr, m1796B((short) (53 - (ViewConfiguration.getTapTimeout() >> 16)), (byte) (TextUtils.indexOf((CharSequence) "", '0') - 95), (-352001984) - (ViewConfiguration.getDoubleTapTimeout() >> 16), (-89) - (ViewConfiguration.getTouchSlop() >> 8), (ViewConfiguration.getScrollBarSize() >> 8) + 1309218625).intern());
    }

    /* JADX INFO: renamed from: B */
    public final byte[] m1797B(byte[] bArr) {
        int i = 2 % 2;
        try {
            byte[] bArrCode = Code();
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArrCode);
            Cipher cipher = Cipher.getInstance(m1796B((short) (TextUtils.indexOf("", "") + 22), (byte) (AndroidCharacter.getMirror('0') + '0'), ExpandableListView.getPackedPositionGroup(0L) - 352001982, TextUtils.indexOf("", "") - 72, 1309218625 - View.resolveSizeAndState(0, 0, 0)).intern());
            cipher.init(1, this.f2675I, ivParameterSpec);
            byte[] bArrCode2 = Code(cipher, bArr);
            byte[] bArr2 = new byte[bArrCode2.length + bArrCode.length];
            System.arraycopy(bArrCode, 0, bArr2, 0, bArrCode.length);
            System.arraycopy(bArrCode2, 0, bArr2, bArrCode.length, bArrCode2.length);
            int i2 = f2671D + 21;
            f2670C = i2 % 128;
            if (i2 % 2 != 0) {
                return bArr2;
            }
            throw null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: I */
    public final byte[] m1798I(byte[] bArr) throws Exception {
        int i = 2 % 2;
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, 16);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, 16, bArr.length);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArrCopyOfRange);
        Cipher cipher = Cipher.getInstance(m1796B((short) (22 - Gravity.getAbsoluteGravity(0, 0)), (byte) ((ViewConfiguration.getKeyRepeatDelay() >> 16) + 96), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) - 352001982, (-72) - (Process.myPid() >> 22), Color.argb(0, 0, 0, 0) + 1309218625).intern());
        cipher.init(2, this.f2675I, ivParameterSpec);
        byte[] bArrB = m1878B(cipher, bArrCopyOfRange2);
        int i2 = f2671D + 21;
        f2670C = i2 % 128;
        if (i2 % 2 != 0) {
            return bArrB;
        }
        Object obj = null;
        super.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: B */
    private static String m1796B(short s, byte b, int i, int i2, int i3) {
        String string;
        synchronized (C2197ck.f3042C) {
            StringBuilder sb = new StringBuilder();
            int i4 = f2673V;
            int i5 = i2 + i4;
            int i6 = i5 == -1 ? 1 : 0;
            if (i6 != 0) {
                byte[] bArr = f2674Z;
                if (bArr != null) {
                    i5 = (byte) (bArr[f2669B + i] + i4);
                } else {
                    i5 = (short) (f2672S[f2669B + i] + i4);
                }
            }
            if (i5 > 0) {
                C2197ck.f3045Z = ((i + i5) - 2) + f2669B + i6;
                C2197ck.f3044V = b;
                C2197ck.f3043I = (char) (i3 + Code);
                sb.append(C2197ck.f3043I);
                C2197ck.Code = C2197ck.f3043I;
                C2197ck.f3041B = 1;
                while (C2197ck.f3041B < i5) {
                    byte[] bArr2 = f2674Z;
                    if (bArr2 != null) {
                        int i7 = C2197ck.f3045Z;
                        C2197ck.f3045Z = i7 - 1;
                        C2197ck.f3043I = (char) (C2197ck.Code + (((byte) (bArr2[i7] + s)) ^ C2197ck.f3044V));
                    } else {
                        short[] sArr = f2672S;
                        int i8 = C2197ck.f3045Z;
                        C2197ck.f3045Z = i8 - 1;
                        C2197ck.f3043I = (char) (C2197ck.Code + (((short) (sArr[i8] + s)) ^ C2197ck.f3044V));
                    }
                    sb.append(C2197ck.f3043I);
                    C2197ck.Code = C2197ck.f3043I;
                    C2197ck.f3041B++;
                }
            }
            string = sb.toString();
        }
        return string;
    }
}
