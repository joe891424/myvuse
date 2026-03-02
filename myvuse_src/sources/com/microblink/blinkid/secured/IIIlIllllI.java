package com.microblink.blinkid.secured;

import com.microblink.hardware.MicroblinkDeviceManager;
import com.microblink.util.Log;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class IIIlIllllI {
    private static Error IlIllIlIIl = null;
    private static boolean llIIlIlIIl = false;

    public static boolean IlIllIlIIl() {
        return llIIlIlIIl;
    }

    public static boolean IllIIIllII() {
        if (!llIIlIlIIl) {
            try {
                if (!MicroblinkDeviceManager.lIlIIIIlIl()) {
                    throw new UnsatisfiedLinkError("Incompatible CPU!");
                }
                for (String str : lllIlIlIIl.llIIlIlIIl) {
                    Log.m2707d(IIIlIllllI.class, "Loading lib{}.so", str);
                    System.loadLibrary(str);
                }
                llIIlIlIIl = true;
            } catch (Error e) {
                llIIlIlIIl = false;
                Log.m2710e(IIIlIllllI.class, e, "error loading native library", new Object[0]);
                IlIllIlIIl = e;
            }
        }
        return llIIlIlIIl;
    }

    public static void llIIlIlIIl() {
        if (IllIIIllII()) {
            return;
        }
        Error error = IlIllIlIIl;
        if (error == null) {
            throw new RuntimeException("Native library is not loaded");
        }
        throw error;
    }
}
