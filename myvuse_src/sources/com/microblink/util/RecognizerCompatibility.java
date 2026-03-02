package com.microblink.util;

import android.content.Context;
import com.microblink.blinkid.secured.IIIlIllllI;
import com.microblink.blinkid.secured.IlIlIlIIlI;
import com.microblink.blinkid.secured.lIlIllIIlI;
import com.microblink.hardware.MicroblinkDeviceManager;
import com.microblink.hardware.camera.CameraType;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class RecognizerCompatibility {
    private static RecognizerCompatibilityStatus llIIlIlIIl;

    /* JADX INFO: compiled from: line */
    static /* synthetic */ class llIIlIlIIl {
        static final /* synthetic */ int[] llIIlIlIIl;

        static {
            int[] iArr = new int[CameraType.values().length];
            llIIlIlIIl = iArr;
            try {
                iArr[CameraType.CAMERA_BACKFACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                llIIlIlIIl[CameraType.CAMERA_FRONTFACE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                llIIlIlIIl[CameraType.CAMERA_DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static boolean cameraHasAutofocus(CameraType cameraType, Context context) {
        int i = lIlIllIIlI.lIlIIIIlIl;
        return IlIlIlIIlI.llIIlIlIIl(context.getApplicationContext(), cameraType);
    }

    public static RecognizerCompatibilityStatus getRecognizerCompatibilityStatus(Context context) {
        if (llIIlIlIIl == null) {
            try {
                IIIlIllllI.llIIlIlIIl();
                lIlIllIIlI.llIIlIlIIl(context, "microblink");
                lIlIllIIlI lililliiliLlIIlIIlll = lIlIllIIlI.llIIlIIlll();
                if (!MicroblinkDeviceManager.lIlIIIIlIl()) {
                    Log.m2709e(RecognizerCompatibility.class, "Device has ARMv7 processor without NEON support. These processors are not supported!", new Object[0]);
                    llIIlIlIIl = RecognizerCompatibilityStatus.PROCESSOR_ARCHITECTURE_NOT_SUPPORTED;
                } else if (lililliiliLlIIlIIlll.llIIlIlIIl()) {
                    llIIlIlIIl = RecognizerCompatibilityStatus.RECOGNIZER_SUPPORTED;
                } else {
                    Log.m2709e(RecognizerCompatibility.class, "Device does not have a camera", new Object[0]);
                    llIIlIlIIl = RecognizerCompatibilityStatus.NO_CAMERA;
                }
            } catch (Throwable th) {
                Log.m2710e(RecognizerCompatibility.class, th, "Unable to load native library. Native recognizer will not be supported!", new Object[0]);
                llIIlIlIIl = RecognizerCompatibilityStatus.PROCESSOR_ARCHITECTURE_NOT_SUPPORTED;
            }
        }
        return llIIlIlIIl;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean llIIlIlIIl(com.microblink.hardware.camera.CameraType r9, android.content.Context r10) {
        /*
            android.hardware.Camera$CameraInfo r0 = new android.hardware.Camera$CameraInfo
            r0.<init>()
            int r1 = android.hardware.Camera.getNumberOfCameras()
            r2 = -1
            r3 = 0
            r5 = r2
            r6 = r5
            r4 = r3
        Le:
            r7 = 1
            if (r4 >= r1) goto L21
            android.hardware.Camera.getCameraInfo(r4, r0)
            int r8 = r0.facing
            if (r8 == 0) goto L1d
            if (r8 == r7) goto L1b
            goto L1e
        L1b:
            r6 = r4
            goto L1e
        L1d:
            r5 = r4
        L1e:
            int r4 = r4 + 1
            goto Le
        L21:
            int[] r0 = com.microblink.util.RecognizerCompatibility.llIIlIlIIl.llIIlIlIIl
            int r9 = r9.ordinal()
            r9 = r0[r9]
            if (r9 == r7) goto L3a
            r0 = 2
            if (r9 == r0) goto L3b
            r0 = 3
            if (r9 == r0) goto L32
            goto L38
        L32:
            if (r5 == r2) goto L35
            goto L3a
        L35:
            if (r6 == r2) goto L38
            goto L3b
        L38:
            r6 = r2
            goto L3b
        L3a:
            r6 = r5
        L3b:
            if (r6 != r2) goto L3e
            return r3
        L3e:
            if (r6 != r5) goto L4b
            android.content.pm.PackageManager r9 = r10.getPackageManager()
            java.lang.String r10 = "android.hardware.camera.autofocus"
            boolean r9 = r9.hasSystemFeature(r10)
            return r9
        L4b:
            android.hardware.Camera r9 = android.hardware.Camera.open(r6)     // Catch: java.lang.RuntimeException -> L6d
            android.hardware.Camera$Parameters r10 = r9.getParameters()     // Catch: java.lang.RuntimeException -> L6d
            java.util.List r10 = r10.getSupportedFocusModes()     // Catch: java.lang.RuntimeException -> L6d
            java.lang.String r0 = "auto"
            boolean r0 = r10.contains(r0)     // Catch: java.lang.RuntimeException -> L6d
            if (r0 != 0) goto L69
            java.lang.String r0 = "macro"
            boolean r10 = r10.contains(r0)     // Catch: java.lang.RuntimeException -> L6d
            if (r10 == 0) goto L68
            goto L69
        L68:
            r7 = r3
        L69:
            r9.release()     // Catch: java.lang.RuntimeException -> L6d
            return r7
        L6d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.util.RecognizerCompatibility.llIIlIlIIl(com.microblink.hardware.camera.CameraType, android.content.Context):boolean");
    }
}
