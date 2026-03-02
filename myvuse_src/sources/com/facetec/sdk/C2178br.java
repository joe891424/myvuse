package com.facetec.sdk;

import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.text.Typography;
import net.lingala.zip4j.util.InternalZipConstants;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facetec.sdk.br */
/* JADX INFO: loaded from: classes3.dex */
final class C2178br {

    /* JADX INFO: renamed from: B */
    private static boolean f2935B = false;

    /* JADX INFO: renamed from: C */
    private static int f2936C = 0;
    private static String Code = null;

    /* JADX INFO: renamed from: I */
    private static HashMap<String, Integer> f2937I = null;

    /* JADX INFO: renamed from: L */
    private static int f2938L = 1;

    /* JADX INFO: renamed from: V */
    private static char[] f2939V;

    /* JADX INFO: renamed from: Z */
    private static String f2940Z;

    /* JADX INFO: renamed from: Z */
    static void m1932Z() {
        f2939V = new char[]{'[', Typography.middleDot, '9', 'n', 'h', 'p', 'u', 'p', 'q', 'D', '4', 'h', 'n', 's', 'q', 'p', 'u', 'l', 'b', 'g', 'j', 'h', 'b', 'd', 'k', 'q', 'l', 'k', 'p', 'g', 'f', '9', 'n', 'h', 'p', 'o', 'h', 'e', 'l', 'u', 'p', 'q'};
    }

    C2178br() {
    }

    static {
        m1932Z();
        Code = "";
        f2935B = false;
        f2940Z = "";
        int i = f2936C + 15;
        f2938L = i % 128;
        if (i % 2 == 0) {
            int i2 = 5 / 0;
        }
    }

    /* JADX INFO: renamed from: V */
    static void m1931V(Context context) {
        int i = 2 % 2;
        int i2 = f2936C + 89;
        f2938L = i2 % 128;
        int i3 = i2 % 2;
        if (f2935B) {
            return;
        }
        f2937I = new HashMap<>();
        for (FaceTecSessionStatus faceTecSessionStatus : FaceTecSessionStatus.values()) {
            f2937I.put(Code(faceTecSessionStatus), 0);
        }
        f2937I.put(Code(true, new int[]{0, 2, ModuleDescriptor.MODULE_VERSION, 0}, "\u0000\u0001").intern(), 1);
        Code = context.getPackageName();
        f2940Z = Settings.Secure.getString(context.getContentResolver(), "android_id");
        m1927B(context);
        f2935B = true;
        int i4 = f2936C + 35;
        f2938L = i4 % 128;
        if (i4 % 2 != 0) {
            return;
        }
        Object obj = null;
        super.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: Z */
    static void m1934Z(FaceTecSessionStatus faceTecSessionStatus, Context context) {
        int i;
        int i2 = 2 % 2;
        int i3 = f2936C + 37;
        f2938L = i3 % 128;
        int i4 = i3 % 2;
        if (f2935B) {
            String strCode = Code(faceTecSessionStatus);
            if (f2937I.get(strCode) == null) {
                f2937I.put(strCode, 0);
                i = f2936C + 91;
            } else {
                HashMap<String, Integer> map = f2937I;
                map.put(strCode, Integer.valueOf(map.get(strCode).intValue() + 1));
                i = f2936C + 47;
            }
            f2938L = i % 128;
            int i5 = i % 2;
            m1933Z(context);
        }
    }

    static void Code(Context context) {
        HashMap<String, Integer> map;
        String strIntern;
        int i;
        int i2 = 2 % 2;
        int i3 = f2936C + 67;
        f2938L = i3 % 128;
        if (i3 % 2 == 0) {
            int i4 = 85 / 0;
            if (!f2935B) {
                return;
            }
        } else if (!f2935B) {
            return;
        }
        if (f2937I.get(Code(true, new int[]{0, 2, ModuleDescriptor.MODULE_VERSION, 0}, "\u0000\u0001").intern()) != null) {
            f2937I.put(Code(true, new int[]{0, 2, ModuleDescriptor.MODULE_VERSION, 0}, "\u0000\u0001").intern(), Integer.valueOf(f2937I.get(Code(true, new int[]{0, 2, ModuleDescriptor.MODULE_VERSION, 0}, "\u0000\u0001").intern()).intValue() + 1));
        } else {
            int i5 = f2936C + 107;
            f2938L = i5 % 128;
            if (i5 % 2 == 0) {
                map = f2937I;
                strIntern = Code(true, new int[]{0, 2, ModuleDescriptor.MODULE_VERSION, 0}, "\u0000\u0001").intern();
                i = 0;
            } else {
                map = f2937I;
                strIntern = Code(true, new int[]{0, 2, ModuleDescriptor.MODULE_VERSION, 0}, "\u0000\u0001").intern();
                i = 1;
            }
            map.put(strIntern, i);
        }
        m1933Z(context);
    }

    static String Code() {
        int i = 2 % 2;
        int i2 = f2936C + 9;
        f2938L = i2 % 128;
        if (i2 % 2 == 0) {
            f2937I.toString();
            Object obj = null;
            super.hashCode();
            throw null;
        }
        String string = f2937I.toString();
        int i3 = f2938L + ModuleDescriptor.MODULE_VERSION;
        f2936C = i3 % 128;
        int i4 = i3 % 2;
        return string;
    }

    /* JADX INFO: renamed from: I */
    static int m1928I(Context context) {
        int i = 2 % 2;
        int i2 = f2938L + 49;
        f2936C = i2 % 128;
        if (i2 % 2 == 0 ? !f2937I.containsKey(Code(true, new int[]{0, 2, ModuleDescriptor.MODULE_VERSION, 0}, "\u0000\u0001").intern()) : !f2937I.containsKey(Code(false, new int[]{0, 2, ModuleDescriptor.MODULE_VERSION, 0}, "\u0000\u0001").intern())) {
            Code(context);
            int i3 = f2936C + 47;
            f2938L = i3 % 128;
            int i4 = i3 % 2;
        }
        return f2937I.get(Code(true, new int[]{0, 2, ModuleDescriptor.MODULE_VERSION, 0}, "\u0000\u0001").intern()).intValue();
    }

    /* JADX INFO: renamed from: B */
    private static boolean m1927B(Context context) {
        int i = 2 % 2;
        try {
            byte[] bArrM2270B = C2225o.m2270B(new File(context.getCacheDir(), m1926B()), m1930I());
            JSONObject jSONObject = new JSONObject(new String(bArrM2270B, 0, bArrM2270B.length, StandardCharsets.UTF_8));
            f2937I.clear();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(Code(true, new int[]{2, 7, 0, 3}, "\u0001\u0000\u0001\u0001\u0001\u0001\u0001").intern());
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (!(!itKeys.hasNext())) {
                    int i2 = f2938L + 103;
                    f2936C = i2 % 128;
                    int i3 = i2 % 2;
                    String next = itKeys.next();
                    f2937I.put(next, Integer.valueOf(jSONObjectOptJSONObject.optInt(next)));
                    int i4 = f2936C + 17;
                    f2938L = i4 % 128;
                    int i5 = i4 % 2;
                }
            }
            int i6 = f2938L + 121;
            f2936C = i6 % 128;
            int i7 = i6 % 2;
            return true;
        } catch (FileNotFoundException unused) {
            return false;
        } catch (Exception e) {
            C2188cb.m1995V(e.getMessage());
            e.getStackTrace();
            return false;
        }
    }

    /* JADX INFO: renamed from: Z */
    private static void m1933Z(Context context) {
        int i = 2 % 2;
        int i2 = f2938L + 61;
        f2936C = i2 % 128;
        int i3 = i2 % 2;
        if (context == null) {
            return;
        }
        Thread thread = new Thread(new Z(context));
        thread.setPriority(1);
        thread.start();
        int i4 = f2936C + ModuleDescriptor.MODULE_VERSION;
        f2938L = i4 % 128;
        if (i4 % 2 == 0) {
            int i5 = 14 / 0;
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.br$Z */
    static class Z implements Runnable {

        /* JADX INFO: renamed from: Z */
        private final WeakReference<Context> f2942Z;

        Z(Context context) {
            this.f2942Z = new WeakReference<>(context.getApplicationContext());
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context = this.f2942Z.get();
            if (context == null) {
                return;
            }
            try {
                C2178br.m1929I(context.getCacheDir());
            } catch (Exception e) {
                C2188cb.m1995V(e.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: B */
    private static String m1926B() throws Exception {
        int i = 2 % 2;
        String strM2263V = C2222k.m2263V(new StringBuilder().append(Code).append(f2940Z).append(Code(false, new int[]{10, 21, 0, 0}, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0001").intern()).toString());
        int i2 = f2936C + 91;
        f2938L = i2 % 128;
        int i3 = i2 % 2;
        return strM2263V;
    }

    /* JADX INFO: renamed from: I */
    private static byte[] m1930I() throws Exception {
        int i = 2 % 2;
        byte[] bArrM2258B = C2222k.m2258B(new StringBuilder().append(Code).append(f2940Z).append(Code(true, new int[]{31, 11, 0, 3}, "\u0001\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0001\u0001\u0001").intern()).toString());
        int i2 = f2936C + 33;
        f2938L = i2 % 128;
        int i3 = i2 % 2;
        return bArrM2258B;
    }

    /* JADX INFO: renamed from: com.facetec.sdk.br$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* JADX INFO: renamed from: I */
        static final /* synthetic */ int[] f2941I;

        static {
            int[] iArr = new int[FaceTecSessionStatus.values().length];
            f2941I = iArr;
            try {
                iArr[FaceTecSessionStatus.NON_PRODUCTION_MODE_KEY_INVALID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2941I[FaceTecSessionStatus.NON_PRODUCTION_MODE_NETWORK_REQUIRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2941I[FaceTecSessionStatus.GRACE_PERIOD_EXCEEDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2941I[FaceTecSessionStatus.USER_CANCELLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2941I[FaceTecSessionStatus.USER_CANCELLED_VIA_HARDWARE_BUTTON.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2941I[FaceTecSessionStatus.SESSION_COMPLETED_SUCCESSFULLY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2941I[FaceTecSessionStatus.SESSION_UNSUCCESSFUL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2941I[FaceTecSessionStatus.CAMERA_PERMISSION_DENIED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2941I[FaceTecSessionStatus.ENCRYPTION_KEY_INVALID.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2941I[FaceTecSessionStatus.TIMEOUT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f2941I[FaceTecSessionStatus.CONTEXT_SWITCH.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f2941I[FaceTecSessionStatus.CAMERA_INITIALIZATION_ISSUE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f2941I[FaceTecSessionStatus.UNKNOWN_INTERNAL_ERROR.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f2941I[FaceTecSessionStatus.LANDSCAPE_MODE_NOT_ALLOWED.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f2941I[FaceTecSessionStatus.REVERSE_PORTRAIT_NOT_ALLOWED.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f2941I[FaceTecSessionStatus.LOCKED_OUT.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f2941I[FaceTecSessionStatus.MISSING_GUIDANCE_IMAGES.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private static String Code(FaceTecSessionStatus faceTecSessionStatus) {
        int i = 2 % 2;
        int i2 = f2936C + 31;
        f2938L = i2 % 128;
        if (i2 % 2 == 0) {
            int i3 = 26 / 0;
            switch (AnonymousClass5.f2941I[faceTecSessionStatus.ordinal()]) {
                case 1:
                    return "LI";
                case 2:
                    return "DM";
                case 3:
                    return "OE";
                case 4:
                    return "UC";
                case 5:
                    return "CH";
                case 6:
                    return "PS";
                case 7:
                    return "NP";
                case 8:
                    return "CD";
                case 9:
                    return "EI";
                case 10:
                    break;
                case 11:
                    return "CS";
                case 12:
                    return "CE";
                case 13:
                    return "IE";
                case 14:
                    return "LA";
                case 15:
                    return "RP";
                case 16:
                    return "UL";
                case 17:
                    return "GI";
                default:
                    return "NA";
            }
        } else {
            switch (AnonymousClass5.f2941I[faceTecSessionStatus.ordinal()]) {
                case 1:
                    return "LI";
                case 2:
                    return "DM";
                case 3:
                    return "OE";
                case 4:
                    return "UC";
                case 5:
                    return "CH";
                case 6:
                    return "PS";
                case 7:
                    return "NP";
                case 8:
                    return "CD";
                case 9:
                    return "EI";
                case 10:
                    break;
                case 11:
                    return "CS";
                case 12:
                    return "CE";
                case 13:
                    return "IE";
                case 14:
                    return "LA";
                case 15:
                    return "RP";
                case 16:
                    return "UL";
                case 17:
                    return "GI";
                default:
                    return "NA";
            }
        }
        int i4 = f2936C + 31;
        f2938L = i4 % 128;
        if (i4 % 2 != 0) {
            return "TO";
        }
        Object obj = null;
        super.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: I */
    static /* synthetic */ void m1929I(File file) throws Exception {
        int i = 2 % 2;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Code(true, new int[]{2, 7, 0, 3}, "\u0001\u0000\u0001\u0001\u0001\u0001\u0001").intern(), new JSONObject(f2937I));
        jSONObject.put(Code(false, new int[]{9, 1, 22, 1}, WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR).intern(), C2188cb.Code(128));
        C2225o.m2274Z(new File(file, m1926B()), m1930I(), (!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)).getBytes(StandardCharsets.UTF_8));
        int i2 = f2938L + 75;
        f2936C = i2 % 128;
        int i3 = i2 % 2;
    }

    private static String Code(boolean z, int[] iArr, String str) throws UnsupportedEncodingException {
        String str2;
        Object bytes = str;
        if (str != null) {
            bytes = str.getBytes(InternalZipConstants.AES_HASH_CHARSET);
        }
        byte[] bArr = (byte[]) bytes;
        synchronized (C2198cl.f3046V) {
            int i = iArr[0];
            int i2 = iArr[1];
            int i3 = iArr[2];
            int i4 = iArr[3];
            char[] cArr = new char[i2];
            System.arraycopy(f2939V, i, cArr, 0, i2);
            if (bArr != null) {
                char[] cArr2 = new char[i2];
                C2198cl.Code = 0;
                char c = 0;
                while (C2198cl.Code < i2) {
                    if (bArr[C2198cl.Code] == 1) {
                        cArr2[C2198cl.Code] = (char) (((cArr[C2198cl.Code] << 1) + 1) - c);
                    } else {
                        cArr2[C2198cl.Code] = (char) ((cArr[C2198cl.Code] << 1) - c);
                    }
                    c = cArr2[C2198cl.Code];
                    C2198cl.Code++;
                }
                cArr = cArr2;
            }
            if (i4 > 0) {
                char[] cArr3 = new char[i2];
                System.arraycopy(cArr, 0, cArr3, 0, i2);
                int i5 = i2 - i4;
                System.arraycopy(cArr3, 0, cArr, i5, i4);
                System.arraycopy(cArr3, i4, cArr, 0, i5);
            }
            if (z) {
                char[] cArr4 = new char[i2];
                C2198cl.Code = 0;
                while (C2198cl.Code < i2) {
                    cArr4[C2198cl.Code] = cArr[(i2 - C2198cl.Code) - 1];
                    C2198cl.Code++;
                }
                cArr = cArr4;
            }
            if (i3 > 0) {
                C2198cl.Code = 0;
                while (C2198cl.Code < i2) {
                    cArr[C2198cl.Code] = (char) (cArr[C2198cl.Code] - iArr[2]);
                    C2198cl.Code++;
                }
            }
            str2 = new String(cArr);
        }
        return str2;
    }
}
