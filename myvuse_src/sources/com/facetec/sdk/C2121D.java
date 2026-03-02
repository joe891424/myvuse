package com.facetec.sdk;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import net.lingala.zip4j.util.InternalZipConstants;
import okhttp3.internal.p103ws.WebSocketProtocol;

/* JADX INFO: renamed from: com.facetec.sdk.D */
/* JADX INFO: loaded from: classes3.dex */
final class C2121D implements ZoomEncryptStrings {

    /* JADX INFO: renamed from: B */
    private static char[] f2157B = {383, 395, 393, 330, 386, 381, 385, 400, 398, 399, 388, 392, 405, 389, 394, 384, 351, 387, 353, 404, 396};
    private static boolean Code = true;

    /* JADX INFO: renamed from: I */
    private static boolean f2158I = true;

    /* JADX INFO: renamed from: S */
    private static int f2159S = 1;

    /* JADX INFO: renamed from: V */
    private static int f2160V = 0;

    /* JADX INFO: renamed from: Z */
    private static int f2161Z = 284;

    C2121D() {
    }

    static void Code(Throwable th) {
        Method methodM1366V;
        int i = 2 % 2;
        String strM2240L = C2221j.m2240L(null);
        if (strM2240L != null && strM2240L.startsWith(m1365I(TextUtils.indexOf("", "", 0, 0) + 127, null, null, "\u0084\u0081\u0087\u0088\u0087\u0081\u0086\u0085\u0084\u0083\u0082\u0081").intern()) && (methodM1366V = m1366V()) != null) {
            int i2 = f2160V + 91;
            f2159S = i2 % 128;
            int i3 = i2 % 2;
            try {
                methodM1366V.invoke(null, th);
            } catch (Exception unused) {
            }
        }
        Log.getStackTraceString(th);
        int i4 = f2159S + 55;
        f2160V = i4 % 128;
        if (i4 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: V */
    private static Method m1366V() {
        int i = 2 % 2;
        int i2 = f2159S + 29;
        f2160V = i2 % 128;
        int i3 = i2 % 2;
        Method method = null;
        try {
            method = Class.forName(m1365I(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 128, null, null, "\u008a\u0081\u008e\u0088\u008d\u008c\u008b\u008a\u0086\u0089\u0091\u0084\u0090\u008e\u0082\u0089\u0090\u008f\u0086\u0084\u008a\u0081\u008e\u0088\u008d\u008c\u008b\u008a\u0086\u0089\u0081\u0084\u0083\u0082\u0081").intern()).getMethod(m1365I((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + WebSocketProtocol.PAYLOAD_SHORT, null, null, "\u008f\u0082\u008e\u0088\u0095\u0087\u0081\u0094\u0093\u0092\u0082\u008c").intern(), Throwable.class);
            int i4 = f2159S + 27;
            f2160V = i4 % 128;
            int i5 = i4 % 2;
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
        }
        return method;
    }

    /* JADX INFO: renamed from: I */
    private static String m1365I(int i, String str, int[] iArr, String str2) throws UnsupportedEncodingException {
        Object bytes = str2;
        if (str2 != null) {
            bytes = str2.getBytes(InternalZipConstants.AES_HASH_CHARSET);
        }
        byte[] bArr = (byte[]) bytes;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (C2193cg.f3032B) {
            char[] cArr2 = f2157B;
            int i2 = f2161Z;
            if (f2158I) {
                int length = bArr.length;
                C2193cg.f3033I = length;
                char[] cArr3 = new char[length];
                C2193cg.Code = 0;
                while (C2193cg.Code < C2193cg.f3033I) {
                    cArr3[C2193cg.Code] = (char) (cArr2[bArr[(C2193cg.f3033I - 1) - C2193cg.Code] + i] - i2);
                    C2193cg.Code++;
                }
                return new String(cArr3);
            }
            if (Code) {
                int length2 = cArr.length;
                C2193cg.f3033I = length2;
                char[] cArr4 = new char[length2];
                C2193cg.Code = 0;
                while (C2193cg.Code < C2193cg.f3033I) {
                    cArr4[C2193cg.Code] = (char) (cArr2[cArr[(C2193cg.f3033I - 1) - C2193cg.Code] - i] - i2);
                    C2193cg.Code++;
                }
                return new String(cArr4);
            }
            int length3 = iArr.length;
            C2193cg.f3033I = length3;
            char[] cArr5 = new char[length3];
            C2193cg.Code = 0;
            while (C2193cg.Code < C2193cg.f3033I) {
                cArr5[C2193cg.Code] = (char) (cArr2[iArr[(C2193cg.f3033I - 1) - C2193cg.Code] - i] - i2);
                C2193cg.Code++;
            }
            return new String(cArr5);
        }
    }
}
