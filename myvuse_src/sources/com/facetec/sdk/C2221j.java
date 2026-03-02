package com.facetec.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Looper;
import android.util.Base64;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.core.content.ContextCompat;
import com.facebook.hermes.intl.Constants;
import com.facetec.sdk.C2127I;
import com.facetec.sdk.C2229t;
import com.facetec.sdk.FaceTecSDK;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facetec.sdk.j */
/* JADX INFO: loaded from: classes3.dex */
class C2221j {

    /* JADX INFO: renamed from: B */
    static JSONObject f3478B = null;

    /* JADX INFO: renamed from: C */
    private static boolean f3479C = false;
    private static String Code = null;

    /* JADX INFO: renamed from: D */
    private static Boolean f3480D = null;

    /* JADX INFO: renamed from: F */
    private static Z f3481F = null;

    /* JADX INFO: renamed from: I */
    private static String f3482I = null;

    /* JADX INFO: renamed from: L */
    private static String f3483L = null;

    /* JADX INFO: renamed from: S */
    private static SharedPreferences f3484S = null;

    /* JADX INFO: renamed from: V */
    static FaceTecAuditTrailType f3485V = null;

    /* JADX INFO: renamed from: Z */
    static String f3486Z = null;

    /* JADX INFO: renamed from: a */
    private static int f3487a = 1;

    /* JADX INFO: renamed from: b */
    private static char[] f3488b;

    /* JADX INFO: renamed from: c */
    private static char f3489c;

    /* JADX INFO: renamed from: d */
    private static int f3490d;

    /* JADX INFO: renamed from: e */
    private static /* synthetic */ boolean f3491e;

    /* JADX INFO: renamed from: com.facetec.sdk.j$Z */
    enum Z {
        NEVER_VALIDATED,
        VALIDATED,
        REJECTED,
        VERSION_DEPRECATED,
        NETWORK_ERROR,
        IN_GRACE_PERIOD
    }

    /* JADX INFO: renamed from: S */
    static void m2243S() {
        f3488b = new char[]{'L', 'e', 'n', 'o', 'v', SafeJsonPrimitive.NULL_CHAR, 'Y', 'T', '3', '-', '8', '5', '0', 'F', 'M', 'N'};
        f3489c = (char) 4;
    }

    C2221j() {
    }

    /* JADX INFO: renamed from: I */
    static /* synthetic */ void m2238I(FaceTecSDK.InitializeCallback initializeCallback) {
        int i = 2 % 2;
        int i2 = f3487a + 59;
        f3490d = i2 % 128;
        int i3 = i2 % 2;
        m2239I(initializeCallback, false);
        int i4 = f3490d + 47;
        f3487a = i4 % 128;
        int i5 = i4 % 2;
    }

    /* JADX INFO: renamed from: Z */
    static /* synthetic */ boolean m2250Z(String str) {
        int i = 2 % 2;
        int i2 = f3487a + 65;
        f3490d = i2 % 128;
        int i3 = i2 % 2;
        boolean zM2227B = m2227B(str);
        int i4 = f3487a + 123;
        f3490d = i4 % 128;
        int i5 = i4 % 2;
        return zM2227B;
    }

    /* JADX INFO: renamed from: B */
    static boolean m2226B() {
        int i = 2 % 2;
        int i2 = f3490d + 69;
        f3487a = i2 % 128;
        int i3 = i2 % 2;
        if (!(!Constants.COLLATION_STANDARD.equals("minimal"))) {
            int i4 = f3490d + 5;
            f3487a = i4 % 128;
            int i5 = i4 % 2;
            return false;
        }
        int i6 = f3487a + 75;
        f3490d = i6 % 128;
        if (i6 % 2 == 0) {
            return true;
        }
        throw null;
    }

    /* JADX INFO: renamed from: V */
    static void m2246V(final Context context, String str, final String str2, final FaceTecSDK.InitializeCallback initializeCallback) {
        int i = 2 % 2;
        int i2 = f3487a + 93;
        f3490d = i2 % 128;
        if (i2 % 2 == 0) {
            if (m2226B()) {
                throw new RuntimeException("FaceTec: Development mode not supported in minimal library");
            }
            if (C2120C.Code.equals("")) {
                C2120C.Code = UUID.randomUUID().toString();
            }
            Code(context);
            if (f3481F != Z.VALIDATED) {
                if (f3481F == Z.IN_GRACE_PERIOD) {
                    if (m2232F(context)) {
                        int i3 = f3487a + 103;
                        f3490d = i3 % 128;
                        if (i3 % 2 != 0) {
                            m2224B(context);
                            m2239I(initializeCallback, false);
                            return;
                        } else {
                            m2224B(context);
                            m2239I(initializeCallback, true);
                            return;
                        }
                    }
                    m2253c(context);
                    return;
                }
                f3486Z = str;
                f3479C = false;
                if (m2254d(context)) {
                    AbstractAsyncTaskC2155au.m1616Z(new Runnable() { // from class: com.facetec.sdk.j.4
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (!C2221j.m2250Z(str2)) {
                                C2221j.m2238I(initializeCallback);
                            } else {
                                C2221j.m2255e(context);
                                C2221j.m2252b(context);
                            }
                        }
                    });
                    return;
                } else {
                    m2239I(initializeCallback, false);
                    return;
                }
            }
            int i4 = f3490d + 21;
            f3487a = i4 % 128;
            int i5 = i4 % 2;
            m2239I(initializeCallback, true);
            return;
        }
        m2226B();
        Object obj = null;
        super.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: B */
    static void m2225B(final Context context, final String str, final String str2, final String str3, final FaceTecSDK.InitializeCallback initializeCallback) {
        int i = 2 % 2;
        int i2 = f3487a + 125;
        f3490d = i2 % 128;
        int i3 = i2 % 2;
        if (f3481F == Z.VALIDATED) {
            m2239I(initializeCallback, true);
            return;
        }
        if (str3 != null) {
            Code(context);
            f3486Z = str2;
            f3479C = true;
            if (m2254d(context)) {
                AbstractAsyncTaskC2155au.m1616Z(new Runnable() { // from class: com.facetec.sdk.j.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (!C2221j.m2250Z(str3)) {
                            C2221j.m2238I(initializeCallback);
                        } else {
                            C2221j.m2255e(context);
                            C2221j.Code(context, str, str2, initializeCallback);
                        }
                    }
                });
                int i4 = f3487a + 27;
                f3490d = i4 % 128;
                if (i4 % 2 != 0) {
                    int i5 = 51 / 0;
                    return;
                }
                return;
            }
            m2239I(initializeCallback, false);
            return;
        }
        int i6 = f3487a + 93;
        f3490d = i6 % 128;
        if (i6 % 2 != 0) {
            m2239I(initializeCallback, true);
        } else {
            m2239I(initializeCallback, false);
        }
    }

    /* JADX INFO: renamed from: B */
    static void m2224B(Context context) {
        int i = 2 % 2;
        int i2 = f3490d + 89;
        f3487a = i2 % 128;
        if (i2 % 2 == 0) {
            Z z = Z.IN_GRACE_PERIOD;
            throw null;
        }
        if (f3481F == Z.IN_GRACE_PERIOD) {
            m2253c(context);
        }
        int i3 = f3490d + 1;
        f3487a = i3 % 128;
        if (i3 % 2 == 0) {
            int i4 = 43 / 0;
        }
    }

    /* JADX INFO: renamed from: c */
    private static synchronized void m2253c(Context context) {
        int i = 2 % 2;
        int i2 = f3487a + 7;
        f3490d = i2 % 128;
        if (i2 % 2 == 0) {
            m2242S(context);
            m2240L(context);
            int i3 = f3490d + 35;
            f3487a = i3 % 128;
            int i4 = i3 % 2;
        } else {
            m2242S(context);
            m2240L(context);
            Object obj = null;
            super.hashCode();
            throw null;
        }
    }

    /* JADX INFO: renamed from: I */
    private static void m2239I(final FaceTecSDK.InitializeCallback initializeCallback, final boolean z) {
        int i = 2 % 2;
        int i2 = f3490d + 23;
        f3487a = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
        if (initializeCallback != null) {
            AbstractAsyncTaskC2155au.m1616Z(new Runnable() { // from class: com.facetec.sdk.j.5
                @Override // java.lang.Runnable
                public final void run() {
                    initializeCallback.onCompletion(z);
                }
            });
        }
        int i3 = f3490d + 103;
        f3487a = i3 % 128;
        if (i3 % 2 == 0) {
            int i4 = 85 / 0;
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.j$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: Z */
        static final /* synthetic */ int[] f3497Z;

        static {
            int[] iArr = new int[Z.values().length];
            f3497Z = iArr;
            try {
                iArr[Z.VALIDATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3497Z[Z.IN_GRACE_PERIOD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3497Z[Z.REJECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3497Z[Z.NETWORK_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3497Z[Z.VERSION_DEPRECATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3497Z[Z.NEVER_VALIDATED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: renamed from: V */
    static FaceTecSDKStatus m2244V(Context context) {
        int i = 2 % 2;
        if (!m2254d(context)) {
            return FaceTecSDKStatus.DEVICE_NOT_SUPPORTED;
        }
        if (f3486Z != null) {
            int i2 = f3487a + 119;
            f3490d = i2 % 128;
            int i3 = i2 % 2;
            String str = f3483L;
            if (str == null || str.isEmpty()) {
                return FaceTecSDKStatus.ENCRYPTION_KEY_INVALID;
            }
        }
        if (m2247V(context.getResources().getConfiguration())) {
            return FaceTecSDKStatus.DEVICE_IN_LANDSCAPE_MODE;
        }
        if (C2188cb.m1994V(context) == 9) {
            int i4 = f3490d + 109;
            f3487a = i4 % 128;
            if (i4 % 2 != 0) {
                return FaceTecSDKStatus.DEVICE_IN_REVERSE_PORTRAIT_MODE;
            }
            int i5 = 80 / 0;
            return FaceTecSDKStatus.DEVICE_IN_REVERSE_PORTRAIT_MODE;
        }
        switch (AnonymousClass3.f3497Z[f3481F.ordinal()]) {
            case 1:
                if (!C2179bs.m1943S(context)) {
                    return FaceTecSDKStatus.INITIALIZED;
                }
                int i6 = f3490d + ModuleDescriptor.MODULE_VERSION;
                f3487a = i6 % 128;
                int i7 = i6 % 2;
                return FaceTecSDKStatus.DEVICE_LOCKED_OUT;
            case 2:
                if (!m2232F(context)) {
                    return FaceTecSDKStatus.GRACE_PERIOD_EXCEEDED;
                }
                int i8 = f3490d + 1;
                f3487a = i8 % 128;
                int i9 = i8 % 2;
                return !(C2179bs.m1943S(context) ^ true) ? FaceTecSDKStatus.DEVICE_LOCKED_OUT : FaceTecSDKStatus.INITIALIZED;
            case 3:
                return f3479C ? FaceTecSDKStatus.KEY_EXPIRED_OR_INVALID : FaceTecSDKStatus.INVALID_DEVICE_KEY_IDENTIFIER;
            case 4:
                return FaceTecSDKStatus.NETWORK_ISSUES;
            case 5:
                return FaceTecSDKStatus.VERSION_DEPRECATED;
            case 6:
                return FaceTecSDKStatus.NEVER_INITIALIZED;
            default:
                return FaceTecSDKStatus.NEVER_INITIALIZED;
        }
    }

    /* JADX INFO: renamed from: I */
    static Long m2233I(Context context) {
        int i = 2 % 2;
        int i2 = f3487a + 87;
        f3490d = i2 % 128;
        int i3 = i2 % 2;
        long jM1938C = C2179bs.m1938C(context);
        if (jM1938C != 0) {
            return Long.valueOf(jM1938C);
        }
        int i4 = f3490d + 47;
        f3487a = i4 % 128;
        int i5 = i4 % 2;
        return null;
    }

    /* JADX INFO: renamed from: Z */
    static boolean m2249Z(Context context) {
        int i = 2 % 2;
        int i2 = f3490d + 3;
        f3487a = i2 % 128;
        int i3 = i2 % 2;
        boolean zM1943S = C2179bs.m1943S(context);
        if (i3 == 0) {
            int i4 = 10 / 0;
        }
        int i5 = f3490d + 79;
        f3487a = i5 % 128;
        if (i5 % 2 == 0) {
            int i6 = 92 / 0;
        }
        return zM1943S;
    }

    static void Code(final Context context) {
        int i = 2 % 2;
        AbstractAsyncTaskC2155au.m1615B(new Runnable() { // from class: com.facetec.sdk.j.2
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC2165be.m1838B(context);
            }
        });
        if (m2254d(context)) {
            C2140af.m1484B(context);
            int i2 = f3487a + 67;
            f3490d = i2 % 128;
            int i3 = i2 % 2;
        }
        int i4 = f3490d + 63;
        f3487a = i4 % 128;
        if (i4 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: I */
    static void m2236I() {
        int i = 2 % 2;
        AbstractAsyncTaskC2155au.m1615B(new Runnable() { // from class: com.facetec.sdk.j.8
            @Override // java.lang.Runnable
            public final void run() {
                C2138ad.Code();
            }
        });
        int i2 = f3490d + 37;
        f3487a = i2 % 128;
        int i3 = i2 % 2;
    }

    /* JADX INFO: renamed from: D */
    static FaceTecSDK.CameraPermissionStatus m2229D(Context context) {
        int i = 2 % 2;
        int i2 = f3490d + 119;
        f3487a = i2 % 128;
        Object obj = null;
        if (i2 % 2 == 0 && Build.VERSION.SDK_INT < 115) {
            FaceTecSDK.CameraPermissionStatus cameraPermissionStatus = FaceTecSDK.CameraPermissionStatus.GRANTED;
            int i3 = f3490d + 87;
            f3487a = i3 % 128;
            if (i3 % 2 != 0) {
                return cameraPermissionStatus;
            }
            super.hashCode();
            throw null;
        }
        int i4 = f3490d + 81;
        f3487a = i4 % 128;
        if (i4 % 2 != 0) {
            if (ContextCompat.checkSelfPermission(context, "android.permission.CAMERA") != 0) {
                return FaceTecSDK.CameraPermissionStatus.NOT_YET_REQUESTED;
            }
            return FaceTecSDK.CameraPermissionStatus.GRANTED;
        }
        ContextCompat.checkSelfPermission(context, "android.permission.CAMERA");
        throw null;
    }

    static boolean Code() {
        int i = 2 % 2;
        int i2 = f3490d + 95;
        f3487a = i2 % 128;
        int i3 = i2 % 2;
        if (f3485V == FaceTecAuditTrailType.DISABLED) {
            return false;
        }
        int i4 = f3487a + 45;
        f3490d = i4 % 128;
        return true ^ (i4 % 2 != 0);
    }

    /* JADX INFO: renamed from: I */
    static void m2237I(FaceTecAuditTrailType faceTecAuditTrailType) {
        int i = 2 % 2;
        int i2 = f3490d + 19;
        f3487a = i2 % 128;
        int i3 = i2 % 2;
        if (faceTecAuditTrailType != f3485V) {
            f3485V = faceTecAuditTrailType;
            AbstractAsyncTaskC2155au.m1616Z(new Runnable() { // from class: com.facetec.sdk.j.6
                @Override // java.lang.Runnable
                public final void run() {
                    C2140af.m1518Z();
                }
            });
            int i4 = f3487a + 91;
            f3490d = i4 % 128;
            if (i4 % 2 != 0) {
                int i5 = 3 / 4;
            }
        }
    }

    /* JADX INFO: renamed from: F */
    static boolean m2232F(Context context) {
        int i = 2 % 2;
        int i2 = f3487a + 105;
        f3490d = i2 % 128;
        if (i2 % 2 == 0) {
            return C2127I.m1424V(context);
        }
        C2127I.m1424V(context);
        Object obj = null;
        super.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: Z */
    static boolean m2248Z() {
        int i = 2 % 2;
        int i2 = f3490d + 55;
        f3487a = i2 % 128;
        int i3 = i2 % 2;
        if (f3481F != Z.IN_GRACE_PERIOD) {
            return false;
        }
        int i4 = f3490d + 31;
        f3487a = i4 % 128;
        if (i4 % 2 != 0) {
            return true;
        }
        throw null;
    }

    /* JADX INFO: renamed from: V */
    static void m2245V() {
        int i = 2 % 2;
        int i2 = f3490d + 49;
        f3487a = i2 % 128;
        if (i2 % 2 == 0) {
            f3481F = Z.IN_GRACE_PERIOD;
            int i3 = 21 / 0;
        } else {
            f3481F = Z.IN_GRACE_PERIOD;
        }
        int i4 = f3487a + 105;
        f3490d = i4 % 128;
        if (i4 % 2 == 0) {
            return;
        }
        Object obj = null;
        super.hashCode();
        throw null;
    }

    static {
        m2243S();
        int i = f3487a + 31;
        int i2 = i % 128;
        f3490d = i2;
        int i3 = i % 2;
        int i4 = i2 + 125;
        f3487a = i4 % 128;
        int i5 = i4 % 2;
        int i6 = 2 % 2;
        f3491e = true;
        f3486Z = null;
        f3485V = FaceTecAuditTrailType.HEIGHT_640;
        f3478B = null;
        f3481F = Z.NEVER_VALIDATED;
        f3479C = false;
        f3483L = null;
        f3480D = null;
    }

    /* JADX INFO: renamed from: d */
    private static synchronized boolean m2254d(Context context) {
        boolean zBooleanValue;
        boolean z;
        int i = 2 % 2;
        int i2 = f3487a + 63;
        int i3 = i2 % 128;
        f3490d = i3;
        int i4 = i2 % 2;
        if (f3480D == null) {
            int i5 = i3 + 85;
            f3487a = i5 % 128;
            if (i5 % 2 == 0) {
                m2241L();
                Object obj = null;
                super.hashCode();
                throw null;
            }
            if (m2241L() && m2251a(context)) {
                int i6 = f3487a + 53;
                f3490d = i6 % 128;
                int i7 = i6 % 2;
                int i8 = 2 % 2;
                z = true;
            } else {
                int i9 = f3490d + 47;
                f3487a = i9 % 128;
                int i10 = i9 % 2;
                int i11 = 2 % 2;
                z = false;
            }
            f3480D = Boolean.valueOf(z);
        }
        zBooleanValue = f3480D.booleanValue();
        int i12 = f3487a + 47;
        f3490d = i12 % 128;
        int i13 = i12 % 2;
        return zBooleanValue;
    }

    /* JADX INFO: renamed from: L */
    private static boolean m2241L() {
        int i = 2 % 2;
        if (!Build.CPU_ABI.toLowerCase().startsWith("arm")) {
            return false;
        }
        int i2 = f3487a + 43;
        int i3 = i2 % 128;
        f3490d = i3;
        boolean z = !(i2 % 2 != 0);
        int i4 = i3 + 69;
        f3487a = i4 % 128;
        if (i4 % 2 != 0) {
            return z;
        }
        throw null;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m2251a(Context context) {
        int i = 2 % 2;
        if (!context.getPackageManager().hasSystemFeature("android.hardware.camera.front")) {
            int i2 = f3490d + 37;
            f3487a = i2 % 128;
            int i3 = i2 % 2;
            if (!Build.MODEL.equals(m2234I(15 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), "\u0001\u0002\u0003\u0000\u0007\u0000\u0006\u0007\u0004\u000b\n\u000b\b\u000f]", (byte) (ExpandableListView.getPackedPositionGroup(0L) + 23)).intern())) {
                int i4 = f3487a + 41;
                f3490d = i4 % 128;
                int i5 = i4 % 2;
                C2166bf.m1847I();
                return false;
            }
        }
        int i6 = f3490d + 113;
        f3487a = i6 % 128;
        if (i6 % 2 != 0) {
            return true;
        }
        Object obj = null;
        super.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: V */
    static boolean m2247V(Configuration configuration) {
        int i = 2 % 2;
        int i2 = f3487a + 95;
        f3490d = i2 % 128;
        int i3 = i2 % 2;
        if (configuration.orientation == 2) {
            return true;
        }
        int i4 = f3490d + 95;
        f3487a = i4 % 128;
        int i5 = i4 % 2;
        return false;
    }

    /* JADX INFO: renamed from: F */
    static float m2231F() {
        int i = 2 % 2;
        if (AbstractC2165be.m1842V() != null) {
            return r1.f2911Z / r1.f2910B;
        }
        int i2 = f3490d + 117;
        int i3 = i2 % 128;
        f3487a = i3;
        int i4 = i2 % 2;
        int i5 = i3 + 63;
        f3490d = i5 % 128;
        if (i5 % 2 != 0) {
            int i6 = 4 / 0;
        }
        return 0.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /* JADX INFO: renamed from: I */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static java.lang.String m2235I(java.lang.String r4) {
        /*
            r0 = 2
            int r1 = r0 % r0
            int r1 = com.facetec.sdk.C2221j.f3490d
            int r1 = r1 + 23
            int r2 = r1 % 128
            com.facetec.sdk.C2221j.f3487a = r2
            int r1 = r1 % r0
            r2 = 0
            if (r1 != 0) goto L1a
            java.lang.String r1 = m2242S(r2)
            r2 = 90
            int r2 = r2 / 0
            if (r1 != 0) goto L2b
            goto L20
        L1a:
            java.lang.String r1 = m2242S(r2)
            if (r1 != 0) goto L2b
        L20:
            int r1 = com.facetec.sdk.C2221j.f3490d
            int r1 = r1 + 83
            int r2 = r1 % 128
            com.facetec.sdk.C2221j.f3487a = r2
            int r1 = r1 % r0
            java.lang.String r1 = "_"
        L2b:
            java.lang.String r0 = com.facetec.sdk.C2221j.f3482I
            if (r0 == 0) goto L94
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "facetec|sdk|android|"
            r0.<init>(r2)
            java.lang.String r2 = com.facetec.sdk.C2221j.f3482I
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = "|"
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r3 = com.facetec.sdk.C2221j.f3486Z
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r1 = android.os.Build.MODEL
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r1 = com.facetec.sdk.FaceTecSDK.version()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.util.Locale r1 = java.util.Locale.getDefault()
            java.lang.String r1 = r1.toString()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.util.Locale r1 = java.util.Locale.getDefault()
            java.lang.String r1 = r1.getLanguage()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r4 = r0.append(r4)
            java.lang.String r4 = r4.toString()
            return r4
        L94:
            java.lang.String r4 = ""
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facetec.sdk.C2221j.m2235I(java.lang.String):java.lang.String");
    }

    /* JADX INFO: renamed from: S */
    static synchronized String m2242S(Context context) {
        int i = 2 % 2;
        int i2 = f3490d + 25;
        int i3 = i2 % 128;
        f3487a = i3;
        int i4 = i2 % 2;
        if (Code == null) {
            int i5 = i3 + 73;
            f3490d = i5 % 128;
            if (i5 % 2 != 0) {
                Object obj = null;
                super.hashCode();
                throw null;
            }
            if (context != null) {
                Code = m2256f(context);
                int i6 = f3487a + 61;
                f3490d = i6 % 128;
                if (i6 % 2 == 0) {
                    int i7 = 2 % 2;
                }
            }
        }
        return Code;
    }

    /* JADX INFO: renamed from: L */
    static synchronized String m2240L(Context context) {
        String str;
        int i = 2 % 2;
        if (f3482I == null) {
            int i2 = f3487a + 103;
            int i3 = i2 % 128;
            f3490d = i3;
            int i4 = i2 % 2;
            if (context != null) {
                int i5 = i3 + 99;
                f3487a = i5 % 128;
                int i6 = i5 % 2;
                f3482I = context.getPackageName();
            }
        }
        str = f3482I;
        int i7 = f3490d + 31;
        f3487a = i7 % 128;
        if (i7 % 2 == 0) {
            Object obj = null;
            super.hashCode();
            throw null;
        }
        return str;
    }

    /* JADX INFO: renamed from: f */
    private static String m2256f(Context context) {
        int i = 2 % 2;
        int i2 = f3487a + 47;
        f3490d = i2 % 128;
        int i3 = i2 % 2;
        try {
            String strSubstring = C2222k.m2257B(C2127I.m1426Z(context), "gz9X05zb1cRaOLl8hkyP").substring(0, 16);
            int i4 = f3490d + 3;
            f3487a = i4 % 128;
            int i5 = i4 % 2;
            return strSubstring;
        } catch (Exception e) {
            C2121D.Code(e);
            return "unknown";
        }
    }

    /* JADX INFO: renamed from: C */
    static SharedPreferences m2228C(Context context) {
        int i = 2 % 2;
        int i2 = f3487a + 63;
        f3490d = i2 % 128;
        int i3 = i2 % 2;
        if (f3484S == null) {
            if ((!f3491e) && Looper.myLooper() == Looper.getMainLooper()) {
                throw new AssertionError();
            }
            f3484S = context.getSharedPreferences("zoom.sdk.settings", 0);
        }
        SharedPreferences sharedPreferences = f3484S;
        int i4 = f3490d + 61;
        f3487a = i4 % 128;
        int i5 = i4 % 2;
        return sharedPreferences;
    }

    /* JADX INFO: renamed from: D */
    static String m2230D() {
        int i = 2 % 2;
        int i2 = f3490d + 55;
        int i3 = i2 % 128;
        f3487a = i3;
        if (i2 % 2 == 0) {
            Object obj = null;
            super.hashCode();
            throw null;
        }
        String str = f3483L;
        int i4 = i3 + 69;
        f3490d = i4 % 128;
        if (i4 % 2 != 0) {
            int i5 = 12 / 0;
        }
        return str;
    }

    /* JADX INFO: renamed from: B */
    private static boolean m2227B(String str) {
        int i = 2 % 2;
        int i2 = f3487a + 29;
        f3490d = i2 % 128;
        Object obj = null;
        if (i2 % 2 != 0) {
            super.hashCode();
            throw null;
        }
        if (str != null) {
            try {
                KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.replace("-----BEGIN PUBLIC KEY-----\n", "").replace("-----END PUBLIC KEY-----", ""), 0)));
                f3483L = str.trim();
                int i3 = f3490d + 101;
                f3487a = i3 % 128;
                if (i3 % 2 != 0) {
                    return true;
                }
                throw null;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: e */
    static /* synthetic */ void m2255e(Context context) {
        int i = 2 % 2;
        int i2 = f3490d + 117;
        f3487a = i2 % 128;
        int i3 = i2 % 2;
        C2179bs.m1947Z(context);
        C2178br.m1931V(context);
        m2228C(context);
        int i4 = f3487a + 79;
        f3490d = i4 % 128;
        int i5 = i4 % 2;
        C2161ba.m1807Z(context);
        int i6 = f3490d + 81;
        f3487a = i6 % 128;
        int i7 = i6 % 2;
    }

    /* JADX INFO: renamed from: b */
    static /* synthetic */ void m2252b(Context context) {
        int i = 2 % 2;
        int i2 = f3490d + 79;
        f3487a = i2 % 128;
        int i3 = i2 % 2;
        m2253c(context);
        if (i3 != 0) {
            return;
        }
        Object obj = null;
        super.hashCode();
        throw null;
    }

    static /* synthetic */ void Code(Context context, String str, String str2, FaceTecSDK.InitializeCallback initializeCallback) {
        int i = 2 % 2;
        int i2 = f3487a + 105;
        f3490d = i2 % 128;
        if (i2 % 2 == 0) {
            m2242S(context);
            m2240L(context);
            if (C2229t.m2293Z(context, str, str2) == C2229t.Code.VALIDATED) {
                f3481F = Z.VALIDATED;
                C2127I.I i3 = new C2127I.I();
                i3.Code = Boolean.FALSE;
                i3.f2285I = 100;
                C2127I.m1423V(context, i3);
                m2239I(initializeCallback, true);
                return;
            }
            f3481F = Z.REJECTED;
            m2239I(initializeCallback, false);
            int i4 = f3487a + 39;
            f3490d = i4 % 128;
            int i5 = i4 % 2;
            return;
        }
        m2242S(context);
        m2240L(context);
        C2229t.m2293Z(context, str, str2);
        C2229t.Code code = C2229t.Code.VALIDATED;
        throw null;
    }

    /* JADX INFO: renamed from: I */
    private static String m2234I(int i, String str, byte b) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (C2190cd.f3022F) {
            char[] cArr2 = f3488b;
            char c = f3489c;
            char[] cArr3 = new char[i];
            if (i % 2 != 0) {
                i--;
                cArr3[i] = (char) (cArr[i] - b);
            }
            if (i > 1) {
                C2190cd.f3020B = 0;
                while (C2190cd.f3020B < i) {
                    C2190cd.f3025V = cArr[C2190cd.f3020B];
                    C2190cd.f3026Z = cArr[C2190cd.f3020B + 1];
                    if (C2190cd.f3025V == C2190cd.f3026Z) {
                        cArr3[C2190cd.f3020B] = (char) (C2190cd.f3025V - b);
                        cArr3[C2190cd.f3020B + 1] = (char) (C2190cd.f3026Z - b);
                    } else {
                        C2190cd.f3023I = C2190cd.f3025V / c;
                        C2190cd.f3024S = C2190cd.f3025V % c;
                        C2190cd.Code = C2190cd.f3026Z / c;
                        C2190cd.f3021C = C2190cd.f3026Z % c;
                        if (C2190cd.f3024S == C2190cd.f3021C) {
                            C2190cd.f3023I = ((C2190cd.f3023I + c) - 1) % c;
                            C2190cd.Code = ((C2190cd.Code + c) - 1) % c;
                            int i2 = (C2190cd.f3023I * c) + C2190cd.f3024S;
                            int i3 = (C2190cd.Code * c) + C2190cd.f3021C;
                            cArr3[C2190cd.f3020B] = cArr2[i2];
                            cArr3[C2190cd.f3020B + 1] = cArr2[i3];
                        } else if (C2190cd.f3023I == C2190cd.Code) {
                            C2190cd.f3024S = ((C2190cd.f3024S + c) - 1) % c;
                            C2190cd.f3021C = ((C2190cd.f3021C + c) - 1) % c;
                            int i4 = (C2190cd.f3023I * c) + C2190cd.f3024S;
                            int i5 = (C2190cd.Code * c) + C2190cd.f3021C;
                            cArr3[C2190cd.f3020B] = cArr2[i4];
                            cArr3[C2190cd.f3020B + 1] = cArr2[i5];
                        } else {
                            int i6 = (C2190cd.f3023I * c) + C2190cd.f3021C;
                            int i7 = (C2190cd.Code * c) + C2190cd.f3024S;
                            cArr3[C2190cd.f3020B] = cArr2[i6];
                            cArr3[C2190cd.f3020B + 1] = cArr2[i7];
                        }
                    }
                    C2190cd.f3020B += 2;
                }
            }
            str2 = new String(cArr3);
        }
        return str2;
    }
}
