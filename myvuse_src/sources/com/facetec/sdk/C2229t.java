package com.facetec.sdk;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.Base64;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReasonCode;
import com.yoti.mobile.mpp.smartcard.ISO7816Kt;
import java.io.IOException;
import java.io.StringReader;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

/* JADX INFO: renamed from: com.facetec.sdk.t */
/* JADX INFO: loaded from: classes3.dex */
final class C2229t implements ZoomEncryptStrings {

    /* JADX INFO: renamed from: C */
    private static int f3562C = 0;
    private static int Code = 52;

    /* JADX INFO: renamed from: I */
    private static short[] f3564I = null;

    /* JADX INFO: renamed from: S */
    private static int f3566S = 1;

    /* JADX INFO: renamed from: Z */
    private static int f3568Z = -1088431093;

    /* JADX INFO: renamed from: V */
    private static byte[] f3567V = {58, Ascii.CAN, Ascii.SYN, SignedBytes.MAX_POWER_OF_TWO, Ascii.f3749FF, 2, 50, 49, Ascii.CAN, 97, -93, 92, 85, 93, -117, -121, 4, -10, -110, -92, -11, -8, -9, 86, 96, -25, 4, -19, 90, -13, -96, 96, 98, -16, -24, -20, 0, 0, 0, 0, 0};

    /* JADX INFO: renamed from: B */
    private static int f3561B = -2110411200;

    /* JADX INFO: renamed from: F */
    private static char[] f3563F = {63348, 'y', 24613, 49345, 8557, 33117, 57729, 16997, 41641, 644, 25432, 1887, 26455, 51111, 9731, 34413, 59096, 17667, 42409, 1524, 25618, 50327, 9453, 33558, 58263, 16928, 41543, 653, 24855, 49450, 8595, 32875, 12692, 1467, 26105, 50462, 'M', 24602, 49363, 8547, 33077, 57787, 17009, 41676, 683, 25427, 50114, 9149, 33834, 58566, 17720, 42279, 1409, 26189, 50721, 9885, 34683, 59363, 18354, 43021, 2266, 26774, 51560, 10736, 35409, 59965, 19115, 43872, 3025, 27579, 52345, 11473, 35968, 60714, 19856, 44650, 3668, 28389, 53086, 12085, 36838, 61528, 20690, 45232, 4366, 29131, 53676, 12804, 37509, 62331, 21305, 46002, 5236, 29713, 54412, 13665, 38345, 62882, 22072, 46837, 5898, 30476, 55257, 14400, 38941, 63622, 22908, 47604, 6538, 31314, 56019, 14993, 39722, 64405, 23657, 48133, 7354, 32081, 56619, 15845, 40551, 65262, 24238, 48902, 8182, 32658, 57449, 16612, 41252, 292, 24960, 49731, 8879, 33514, 58219, 17343, 41886, 1052, 25822, 50544, 9560, 34258, 58954, 17987, 42654, 1876, 26584, 51072, 10295, 35049, 59535, 18715, 43514, 2623, 27162, 51880, 11095, 35592, 60297, 19465, 44205, 3302, 40437, 64943, '*'};

    /* JADX INFO: renamed from: L */
    private static long f3565L = 8979325937931280476L;

    /* JADX INFO: renamed from: com.facetec.sdk.t$Code */
    enum Code {
        NOT_PRESENT,
        INVALID,
        VALIDATED
    }

    C2229t() {
    }

    /* JADX INFO: renamed from: Z */
    static Code m2293Z(Context context, String str, String str2) {
        int i = 2 % 2;
        Properties properties = new Properties();
        try {
            properties.load(new StringReader(str));
            int i2 = f3566S + 43;
            f3562C = i2 % 128;
            int i3 = i2 % 2;
            String property = properties.getProperty(Code(Color.argb(0, 0, 0, 0) + 2110411301, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 1088431093, (short) (98 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), (byte) (Color.alpha(0) + 106), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 43).intern(), "");
            String strReplaceAll = properties.getProperty(Code(2110411298 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 1088431101 - TextUtils.indexOf((CharSequence) "", '0'), (short) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_SHOW_BANNER_CALLED), (byte) ((-53) - Color.green(0)), (ViewConfiguration.getFadingEdgeLength() >> 16) - 47).intern(), "").replaceAll(m2291I((char) (TextUtils.indexOf("", "", 0, 0) + 63318), ViewConfiguration.getMaximumDrawingCacheSize() >> 24, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 1).intern(), "");
            String property2 = properties.getProperty(Code(2110411308 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), TextUtils.indexOf((CharSequence) "", '0') + 1088431107, (short) (3 - Color.green(0)), (byte) (116 - TextUtils.getCapsMode("", 0, 0)), View.MeasureSpec.getSize(0) - 49).intern(), "");
            if (!property.isEmpty() && !strReplaceAll.isEmpty()) {
                int i4 = f3562C + 11;
                f3566S = i4 % 128;
                int i5 = i4 % 2;
                if (!property2.isEmpty()) {
                    String property3 = properties.getProperty(Code(TextUtils.indexOf("", "", 0, 0) + 2110411302, TextUtils.lastIndexOf("", '0') + 1088431109, (short) (TextUtils.lastIndexOf("", '0') - 68), (byte) (Gravity.getAbsoluteGravity(0, 0) + 76), (-44) - Color.green(0)).intern(), "");
                    if (!m2294Z(context, strReplaceAll)) {
                        int i6 = f3562C + 51;
                        f3566S = i6 % 128;
                        int i7 = i6 % 2;
                        Code code = Code.INVALID;
                        int i8 = f3566S + 11;
                        f3562C = i8 % 128;
                        int i9 = i8 % 2;
                        return code;
                    }
                    try {
                        if (new Date().after(new SimpleDateFormat(m2291I((char) KeyEvent.getDeadChar(0, 0), Color.blue(0) + 1, 10 - KeyEvent.normalizeMetaState(0)).intern()).parse(property))) {
                            int i10 = f3562C + 119;
                            f3566S = i10 % 128;
                            int i11 = i10 % 2;
                            return Code.INVALID;
                        }
                        byte[] bArrCode = Code(property2);
                        try {
                            boolean zM2292I = m2292I(C2222k.m2260I(m2291I((char) (1919 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), (Process.myPid() >> 22) + 11, 22 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))).intern().getBytes(), new StringBuilder().append(str2).append(strReplaceAll).append(property).append(property3).toString()), Arrays.copyOfRange(bArrCode, 1, bArrCode.length));
                            if (zM2292I && !property3.isEmpty() && Arrays.asList(property3.split(m2291I((char) (12728 - KeyEvent.normalizeMetaState(0)), 32 - TextUtils.getTrimmedLength(""), -MotionEvent.axisFromString("")).intern())).contains(m2291I((char) (1480 - ((byte) KeyEvent.getModifierMetaStateMask())), 33 - KeyEvent.getDeadChar(0, 0), 3 - ExpandableListView.getPackedPositionType(0L)).intern())) {
                                C2179bs.f2947I = true;
                            }
                            return zM2292I ? Code.VALIDATED : Code.INVALID;
                        } catch (Exception unused) {
                            return Code.INVALID;
                        }
                    } catch (ParseException unused2) {
                        return Code.INVALID;
                    }
                }
            }
            Code code2 = Code.INVALID;
            int i12 = f3566S + 23;
            f3562C = i12 % 128;
            if (i12 % 2 == 0) {
                return code2;
            }
            throw null;
        } catch (IOException unused3) {
            return Code.NOT_PRESENT;
        }
    }

    /* JADX INFO: renamed from: I */
    private static boolean m2292I(byte[] bArr, byte[] bArr2) throws InvalidKeySpecException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, NoSuchProviderException {
        int i = 2 % 2;
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(m2291I((char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 40368), 162 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 2).intern()).generatePublic(new X509EncodedKeySpec(Base64.decode(m2291I((char) Drawable.resolveOpacity(0, 0), 36 - KeyEvent.getDeadChar(0, 0), 125 - TextUtils.lastIndexOf("", '0')).intern(), 0)));
        Signature signature = Signature.getInstance(Code(TextUtils.indexOf((CharSequence) "", '0') + 2110411284, Color.rgb(0, 0, 0) + 1105208331, (short) (91 - TextUtils.lastIndexOf("", '0', 0, 0)), (byte) (TextUtils.indexOf((CharSequence) "", '0', 0) - 66), KeyEvent.getDeadChar(0, 0) - 37).intern());
        signature.initVerify(publicKeyGeneratePublic);
        signature.update(bArr);
        boolean zVerify = signature.verify(bArr2);
        int i2 = f3562C + 43;
        f3566S = i2 % 128;
        if (i2 % 2 == 0) {
            int i3 = 48 / 0;
        }
        return zVerify;
    }

    private static byte[] Code(String str) {
        int length;
        byte[] bArr;
        int i;
        int i2 = 2 % 2;
        int i3 = f3566S + 81;
        f3562C = i3 % 128;
        if (i3 % 2 != 0) {
            length = str.length();
            bArr = new byte[length / 2];
            i = 1;
        } else {
            length = str.length();
            bArr = new byte[length / 2];
            i = 0;
        }
        while (i < length) {
            int i4 = f3562C + 71;
            f3566S = i4 % 128;
            int i5 = i4 % 2;
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
            i += 2;
        }
        return bArr;
    }

    /* JADX INFO: renamed from: Z */
    private static boolean m2294Z(Context context, String str) {
        boolean zEquals;
        int i = 2 % 2;
        int i2 = f3566S + 41;
        f3562C = i2 % 128;
        int i3 = i2 % 2;
        for (String str2 : str.split(m2291I((char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 12728), 32 - (ViewConfiguration.getWindowTouchSlop() >> 8), View.MeasureSpec.makeMeasureSpec(0, 0) + 1).intern())) {
            int i4 = f3562C + 45;
            f3566S = i4 % 128;
            int i5 = i4 % 2;
            if (!str2.endsWith(m2291I((char) (ViewConfiguration.getFadingEdgeLength() >> 16), Color.red(0) + ISO7816Kt.INS_SELECT, TextUtils.getCapsMode("", 0, 0) + 1).intern())) {
                zEquals = str2.equals(context.getPackageName());
            } else {
                int i6 = f3566S + 31;
                f3562C = i6 % 128;
                int i7 = i6 % 2;
                zEquals = context.getPackageName().startsWith(str2.substring(0, str2.length() - 1));
            }
            if (zEquals) {
                int i8 = f3566S + 13;
                f3562C = i8 % 128;
                return (i8 % 2 != 0 ? '`' : 'Q') != '`';
            }
        }
        return false;
    }

    private static String Code(int i, int i2, short s, byte b, int i3) {
        String string;
        synchronized (C2197ck.f3042C) {
            StringBuilder sb = new StringBuilder();
            int i4 = Code;
            int i5 = i3 + i4;
            int i6 = i5 == -1 ? 1 : 0;
            if (i6 != 0) {
                byte[] bArr = f3567V;
                if (bArr != null) {
                    i5 = (byte) (bArr[f3568Z + i2] + i4);
                } else {
                    i5 = (short) (f3564I[f3568Z + i2] + i4);
                }
            }
            if (i5 > 0) {
                C2197ck.f3045Z = ((i2 + i5) - 2) + f3568Z + i6;
                C2197ck.f3044V = b;
                C2197ck.f3043I = (char) (i + f3561B);
                sb.append(C2197ck.f3043I);
                C2197ck.Code = C2197ck.f3043I;
                C2197ck.f3041B = 1;
                while (C2197ck.f3041B < i5) {
                    byte[] bArr2 = f3567V;
                    if (bArr2 != null) {
                        int i7 = C2197ck.f3045Z;
                        C2197ck.f3045Z = i7 - 1;
                        C2197ck.f3043I = (char) (C2197ck.Code + (((byte) (bArr2[i7] + s)) ^ C2197ck.f3044V));
                    } else {
                        short[] sArr = f3564I;
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

    /* JADX INFO: renamed from: I */
    private static String m2291I(char c, int i, int i2) {
        String str;
        synchronized (C2195ci.f3036B) {
            char[] cArr = new char[i2];
            C2195ci.f3037V = 0;
            while (C2195ci.f3037V < i2) {
                cArr[C2195ci.f3037V] = (char) ((((long) f3563F[C2195ci.f3037V + i]) ^ (((long) C2195ci.f3037V) * f3565L)) ^ ((long) c));
                C2195ci.f3037V++;
            }
            str = new String(cArr);
        }
        return str;
    }
}
