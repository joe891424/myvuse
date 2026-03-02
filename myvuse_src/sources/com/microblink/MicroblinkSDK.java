package com.microblink;

import android.content.Context;
import com.microblink.blinkid.secured.IIIlIllllI;
import com.microblink.blinkid.secured.lIlIllIIlI;
import com.microblink.hardware.MicroblinkDeviceManager;
import com.microblink.intent.IntentDataTransferMode;
import com.microblink.licence.LicenceManager;
import com.microblink.licence.exception.InvalidLicenceKeyException;
import com.microblink.settings.NativeLibraryInfo;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes2.dex */
public final class MicroblinkSDK {
    private static IntentDataTransferMode IlIllIlIIl;
    private static Context llIIlIlIIl;

    static {
        IIIlIllllI.llIIlIlIIl();
        IlIllIlIIl = IntentDataTransferMode.PERSISTED_OPTIMISED;
    }

    private MicroblinkSDK() {
        throw new AssertionError();
    }

    private static native void applicationContextNativeInitialize(Context context);

    public static Context getApplicationContext() {
        return llIIlIlIIl;
    }

    public static IntentDataTransferMode getIntentDataTransferMode() {
        return IlIllIlIIl;
    }

    public static String getNativeLibraryVersionString() {
        return NativeLibraryInfo.getNativeBuildVersion();
    }

    private static void llIIlIlIIl(Context context) {
        if (!MicroblinkDeviceManager.lIlIIIIlIl()) {
            throw new InvalidLicenceKeyException("Incompatible processor. This device is not supported!");
        }
        applicationContextNativeInitialize(context);
        llIIlIlIIl = context;
        lIlIllIIlI.llIIlIlIIl(context, "microblink");
    }

    public static void setIntentDataTransferMode(IntentDataTransferMode intentDataTransferMode) {
        IlIllIlIIl = intentDataTransferMode;
    }

    public static void setLicenseBuffer(byte[] bArr, Context context) {
        if (bArr == null) {
            throw new NullPointerException("License buffer cannot be null");
        }
        llIIlIlIIl(context);
        LicenceManager.llIIlIlIIl(context, bArr);
    }

    public static void setLicenseFile(String str, Context context) {
        if (str == null) {
            throw new NullPointerException("License file path cannot be null");
        }
        if (context == null) {
            throw new NullPointerException("Context cannot be null");
        }
        llIIlIlIIl(context);
        LicenceManager.IlIllIlIIl(context, str);
    }

    public static void setLicenseKey(String str, Context context) {
        if (str == null) {
            throw new NullPointerException("License buffer cannot be null");
        }
        llIIlIlIIl(context);
        LicenceManager.IllIIIllII(context, str);
    }

    public static void setShowTrialLicenseWarning(boolean z) {
        LicenceManager.llIIlIlIIl(z);
    }

    public static void setLicenseBuffer(byte[] bArr, String str, Context context) {
        if (bArr == null) {
            throw new NullPointerException("License buffer cannot be null");
        }
        if (str != null) {
            llIIlIlIIl(context);
            LicenceManager.llIIlIlIIl(context, bArr, str);
            return;
        }
        throw new NullPointerException("Licensee cannot be null");
    }

    public static void setLicenseKey(String str, String str2, Context context) {
        if (str == null) {
            throw new NullPointerException("License buffer cannot be null");
        }
        if (str2 != null) {
            llIIlIlIIl(context);
            LicenceManager.IlIllIlIIl(context, str, str2);
            return;
        }
        throw new NullPointerException("Licensee cannot be null");
    }

    public static void setLicenseFile(String str, String str2, Context context) {
        if (str == null) {
            throw new NullPointerException("License file path cannot be null");
        }
        if (str2 == null) {
            throw new NullPointerException("Licensee cannot be null");
        }
        if (context != null) {
            llIIlIlIIl(context);
            LicenceManager.llIIlIlIIl(context, str, str2);
            return;
        }
        throw new NullPointerException("Context cannot be null");
    }
}
