package com.microblink.recognition;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class RightsManager {
    public static String IlIllIlIIl() {
        String strNativeGetLicensee = nativeGetLicensee();
        return strNativeGetLicensee == null ? "" : strNativeGetLicensee;
    }

    public static int IllIIIllII() {
        return nativeGetPingInterval();
    }

    public static boolean llIIIlllll() {
        return nativeIsLicenseOk();
    }

    public static boolean llIIlIlIIl(Right right) {
        return nativeIsRightEnabled(right.llIIlIlIIl());
    }

    private static native String nativeGetLicenseID();

    private static native String nativeGetLicensee();

    private static native int nativeGetPingInterval();

    private static native boolean nativeIsLicenseOk();

    private static native boolean nativeIsRightEnabled(int i);

    public static String llIIlIlIIl() {
        String strNativeGetLicenseID = nativeGetLicenseID();
        return strNativeGetLicenseID == null ? "" : strNativeGetLicenseID;
    }
}
