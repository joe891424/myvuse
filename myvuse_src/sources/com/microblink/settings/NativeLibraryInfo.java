package com.microblink.settings;

import com.microblink.blinkid.secured.IIIlIllllI;
import com.microblink.blinkid.secured.lIllIIIlll;
import com.microblink.blinkid.secured.llIIlllIll;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class NativeLibraryInfo {
    private long llIIlIlIIl;

    static {
        IIIlIllllI.IllIIIllII();
        IIIlIllllI.IllIIIllII();
    }

    public NativeLibraryInfo(long j) {
        this.llIIlIlIIl = j;
    }

    public static lIllIIIlll IllIIIllII() {
        return new lIllIIIlll(llIIlllIll.IlIllIlIIl(9)[nativeObtainProductId()], getNativeBuildVersion());
    }

    public static native String getNativeBuildVersion();

    public static native boolean isProtectionEnabled();

    private static native void nativeDestruct(long j);

    private static native String nativeGetErrorList(long j);

    private static native boolean nativeIsLibrarySuccessfullyInitialized(long j);

    private static native int nativeObtainProductId();

    public final boolean IlIllIlIIl() {
        return nativeIsLibrarySuccessfullyInitialized(this.llIIlIlIIl);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        long j = this.llIIlIlIIl;
        if (j != 0) {
            nativeDestruct(j);
        }
    }

    public String llIIlIlIIl() {
        String strNativeGetErrorList = nativeGetErrorList(this.llIIlIlIIl);
        return strNativeGetErrorList == null ? "" : strNativeGetErrorList;
    }
}
