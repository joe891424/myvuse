package com.microblink.licence;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.Toast;
import com.microblink.blinkid.secured.IIIlIllllI;
import com.microblink.blinkid.secured.IlIllllllI;
import com.microblink.blinkid.secured.IllIIlllIl;
import com.microblink.blinkid.secured.llIIlllIll;
import com.microblink.licence.exception.InvalidLicenceKeyException;
import com.microblink.recognition.Right;
import com.microblink.recognition.RightsManager;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class LicenceManager {
    private static boolean llIIlIlIIl = true;

    static {
        IIIlIllllI.llIIlIlIIl();
    }

    public static void IlIllIlIIl(Context context, String str, String str2) {
        llIIlIlIIl(context, nativeSetBase64LibraryLicenseKey(str, str2));
        llIIlIlIIl(context);
    }

    public static void IllIIIllII(Context context, String str) {
        llIIlIlIIl(context, nativeSetBase64LicenseKey(str));
        llIIlIlIIl(context);
    }

    public static void llIIlIlIIl(boolean z) {
        llIIlIlIIl = z;
    }

    private static native long nativeGetLease();

    private static native boolean nativeIsLicenceOnline();

    private static native String nativeSetBase64LibraryLicenseKey(String str, String str2);

    private static native String nativeSetBase64LicenseKey(String str);

    private static native String nativeSetLibraryLicenseBuffer(byte[] bArr, String str);

    private static native String nativeSetLibraryLicenseFile(String str, String str2, AssetManager assetManager);

    private static native String nativeSetLicenseBuffer(byte[] bArr);

    private static native String nativeSetLicenseFile(String str, AssetManager assetManager);

    private static native int nativeSubmitServerPermission(String str);

    public static void llIIlIlIIl(Context context, byte[] bArr) {
        llIIlIlIIl(context, nativeSetLicenseBuffer(bArr));
        llIIlIlIIl(context);
    }

    public static void IlIllIlIIl(Context context, String str) {
        llIIlIlIIl(context, nativeSetLicenseFile(str, context.getAssets()));
        llIIlIlIIl(context);
    }

    public static void llIIlIlIIl(Context context, byte[] bArr, String str) {
        llIIlIlIIl(context, nativeSetLibraryLicenseBuffer(bArr, str));
        llIIlIlIIl(context);
    }

    public static void llIIlIlIIl(Context context, String str, String str2) {
        llIIlIlIIl(context, nativeSetLibraryLicenseFile(str, str2, context.getAssets()));
        llIIlIlIIl(context);
    }

    public static llIIlIlIIl llIIlIlIIl(String str) {
        int iNativeSubmitServerPermission = nativeSubmitServerPermission(str);
        int i = 0;
        boolean z = iNativeSubmitServerPermission == -1;
        if (!z) {
            i = iNativeSubmitServerPermission >= llIIlllIll.IlIllIlIIl(5).length ? 3 : llIIlllIll.IlIllIlIIl(5)[iNativeSubmitServerPermission];
        }
        return new llIIlIlIIl(z, nativeGetLease() * 1000, i);
    }

    private static void llIIlIlIIl(Context context, String str) {
        if (str == null) {
            if (RightsManager.llIIlIlIIl(Right.IS_TRIAL) && llIIlIlIIl) {
                Toast.makeText(context, "Using trial license!", 1).show();
                return;
            }
            return;
        }
        throw new InvalidLicenceKeyException(str);
    }

    public static boolean llIIlIlIIl() {
        return nativeIsLicenceOnline();
    }

    private static void llIIlIlIIl(Context context) {
        IlIllllllI.llIIlIlIIl(context);
        IlIllllllI.llIIlIlIIl().llIIlIlIIl();
        IllIIlllIl.llIIlIlIIl().IlIllIlIIl(context);
    }
}
