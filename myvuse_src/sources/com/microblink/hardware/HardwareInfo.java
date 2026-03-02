package com.microblink.hardware;

import com.microblink.blinkid.secured.IIIlIllllI;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class HardwareInfo {
    static {
        IIIlIllllI.IllIIIllII();
    }

    public static long allocatedMLSize() {
        return nativeAllocatedSize();
    }

    public static long compactMLNativeMemory() {
        return doCompactNativeMemory();
    }

    private static native long doCompactNativeMemory();

    public static String getHardwareInfo() {
        return hardwareInfoNativeGet();
    }

    private static native String hardwareInfoNativeGet();

    private static native long nativeAllocatedSize();
}
