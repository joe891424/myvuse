package com.microblink.blinkid.secured;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import com.microblink.hardware.camera.CameraType;
import com.microblink.util.Log;
import com.onetrust.otpublishers.headless.Public.OTBannerHeightRatio;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class IlIlIlIIlI {
    public static boolean IlIllIlIIl(Context context, CameraType cameraType) throws CameraAccessException {
        CameraManager cameraManager = (CameraManager) context.getApplicationContext().getSystemService("camera");
        if (cameraManager == null) {
            Log.m2709e(lllIIlIIlI.class, "Cannot obtain camera manager from context!", new Object[0]);
            return false;
        }
        String strLlIIlIlIIl = llIIlIlIIl(cameraManager, cameraType);
        if (strLlIIlIlIIl == null) {
            Log.m2709e(lllIIlIIlI.class, "Cannot obtain information for camera type {}", cameraType);
            return false;
        }
        Integer num = (Integer) cameraManager.getCameraCharacteristics(strLlIIlIlIIl).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (num == null) {
            Log.m2707d(lllIIlIIlI.class, "Supported hardware level is 'null'", new Object[0]);
            return false;
        }
        Log.m2707d(lllIIlIIlI.class, "Camera 2 supported HW level is '{}'", num.intValue() == 1 ? OTBannerHeightRatio.FULL : num.intValue() == 0 ? "limited" : "legacy");
        return num.intValue() != 2;
    }

    public static boolean llIIlIlIIl(Context context, CameraType cameraType) {
        CameraManager cameraManager = (CameraManager) context.getApplicationContext().getSystemService("camera");
        boolean z = false;
        if (cameraManager == null) {
            Log.m2709e(lllIIlIIlI.class, "Cannot obtain camera manager from context!", new Object[0]);
            return false;
        }
        try {
            String strLlIIlIlIIl = llIIlIlIIl(cameraManager, cameraType);
            if (strLlIIlIlIIl == null) {
                Log.m2709e(lllIIlIIlI.class, "Cannot obtain information for camera type {}", cameraType);
                return false;
            }
            Float f = (Float) cameraManager.getCameraCharacteristics(strLlIIlIlIIl).get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE);
            if (f != null) {
                Log.m2711i(lllIIlIIlI.class, "{} minimum focus distance: {}", cameraType, f);
                if (f.floatValue() == 0.0f) {
                    z = true;
                }
            }
            return !z;
        } catch (CameraAccessException unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0088, code lost:
    
        if (r5 != null) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String llIIlIlIIl(android.hardware.camera2.CameraManager r11, com.microblink.hardware.camera.CameraType r12) {
        /*
            r0 = 0
            r1 = 0
            java.lang.String[] r2 = r11.getCameraIdList()     // Catch: java.lang.Throwable -> L97 java.lang.NumberFormatException -> La2 java.lang.NullPointerException -> Lac java.lang.AssertionError -> Lb6
            int r3 = r2.length
            r4 = r0
            r5 = r1
            r6 = r5
        La:
            if (r4 >= r3) goto L84
            r7 = r2[r4]
            android.hardware.camera2.CameraCharacteristics r8 = r11.getCameraCharacteristics(r7)     // Catch: java.lang.Throwable -> L3b java.lang.NumberFormatException -> L46 java.lang.NullPointerException -> L50 java.lang.AssertionError -> L5a android.hardware.camera2.CameraAccessException -> L64
            android.hardware.camera2.CameraCharacteristics$Key r9 = android.hardware.camera2.CameraCharacteristics.LENS_FACING     // Catch: java.lang.Throwable -> L3b java.lang.NumberFormatException -> L46 java.lang.NullPointerException -> L50 java.lang.AssertionError -> L5a android.hardware.camera2.CameraAccessException -> L64
            java.lang.Object r8 = r8.get(r9)     // Catch: java.lang.Throwable -> L3b java.lang.NumberFormatException -> L46 java.lang.NullPointerException -> L50 java.lang.AssertionError -> L5a android.hardware.camera2.CameraAccessException -> L64
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch: java.lang.Throwable -> L3b java.lang.NumberFormatException -> L46 java.lang.NullPointerException -> L50 java.lang.AssertionError -> L5a android.hardware.camera2.CameraAccessException -> L64
            if (r8 != 0) goto L26
            java.lang.Class<com.microblink.blinkid.secured.lllIIlIIlI> r8 = com.microblink.blinkid.secured.lllIIlIIlI.class
            java.lang.String r9 = "Obtained null value for lens facing info. This is a bug in device!"
            java.lang.Object[] r10 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L3b java.lang.NumberFormatException -> L46 java.lang.NullPointerException -> L50 java.lang.AssertionError -> L5a android.hardware.camera2.CameraAccessException -> L64
            com.microblink.util.Log.m2715w(r8, r9, r10)     // Catch: java.lang.Throwable -> L3b java.lang.NumberFormatException -> L46 java.lang.NullPointerException -> L50 java.lang.AssertionError -> L5a android.hardware.camera2.CameraAccessException -> L64
            return r1
        L26:
            int r9 = r8.intValue()     // Catch: java.lang.Throwable -> L3b java.lang.NumberFormatException -> L46 java.lang.NullPointerException -> L50 java.lang.AssertionError -> L5a android.hardware.camera2.CameraAccessException -> L64
            if (r9 != 0) goto L30
            if (r6 != 0) goto L81
            r6 = r7
            goto L81
        L30:
            int r8 = r8.intValue()     // Catch: java.lang.Throwable -> L3b java.lang.NumberFormatException -> L46 java.lang.NullPointerException -> L50 java.lang.AssertionError -> L5a android.hardware.camera2.CameraAccessException -> L64
            r9 = 1
            if (r8 != r9) goto L81
            if (r5 != 0) goto L81
            r5 = r7
            goto L81
        L3b:
            r11 = move-exception
            java.lang.Object[] r12 = new java.lang.Object[r0]
            java.lang.Class<com.microblink.blinkid.secured.lllIIlIIlI> r0 = com.microblink.blinkid.secured.lllIIlIIlI.class
            java.lang.String r2 = "There was unhandled exception when calling getCameraCharacteristics. This is probably a bug in device!"
            com.microblink.util.Log.m2716w(r0, r11, r2, r12)
            return r1
        L46:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.Class<com.microblink.blinkid.secured.lllIIlIIlI> r12 = com.microblink.blinkid.secured.lllIIlIIlI.class
            java.lang.String r0 = "There was a NumberFormatException when calling getCameraCharacteristics. This is probably a bug in device!"
            com.microblink.util.Log.m2715w(r12, r0, r11)
            return r1
        L50:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.Class<com.microblink.blinkid.secured.lllIIlIIlI> r12 = com.microblink.blinkid.secured.lllIIlIIlI.class
            java.lang.String r0 = "There was a NullPointerException when calling getCameraCharacteristics. This is probably a bug in device!"
            com.microblink.util.Log.m2715w(r12, r0, r11)
            return r1
        L5a:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.Class<com.microblink.blinkid.secured.lllIIlIIlI> r12 = com.microblink.blinkid.secured.lllIIlIIlI.class
            java.lang.String r0 = "There was assertion error when calling getCameraCharacteristics. This is probably a bug in device!"
            com.microblink.util.Log.m2715w(r12, r0, r11)
            return r1
        L64:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "Unable to access camera with ID "
            r9.<init>(r10)
            java.lang.StringBuilder r7 = r9.append(r7)
            java.lang.String r9 = ". Skipping it..."
            java.lang.StringBuilder r7 = r7.append(r9)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r9 = new java.lang.Object[r0]
            java.lang.Class<com.microblink.blinkid.secured.lllIIlIIlI> r10 = com.microblink.blinkid.secured.lllIIlIIlI.class
            com.microblink.util.Log.m2710e(r10, r8, r7, r9)
        L81:
            int r4 = r4 + 1
            goto La
        L84:
            com.microblink.hardware.camera.CameraType r11 = com.microblink.hardware.camera.CameraType.CAMERA_DEFAULT
            if (r12 != r11) goto L8b
            if (r5 == 0) goto L95
            goto L8f
        L8b:
            com.microblink.hardware.camera.CameraType r11 = com.microblink.hardware.camera.CameraType.CAMERA_BACKFACE
            if (r12 != r11) goto L91
        L8f:
            r1 = r5
            goto L96
        L91:
            com.microblink.hardware.camera.CameraType r11 = com.microblink.hardware.camera.CameraType.CAMERA_FRONTFACE
            if (r12 != r11) goto L96
        L95:
            r1 = r6
        L96:
            return r1
        L97:
            r11 = move-exception
            java.lang.Object[] r12 = new java.lang.Object[r0]
            java.lang.Class<com.microblink.blinkid.secured.lllIIlIIlI> r0 = com.microblink.blinkid.secured.lllIIlIIlI.class
            java.lang.String r2 = "There was unhandled exception when calling getCameraIdList. This is probably a bug in device!"
            com.microblink.util.Log.m2716w(r0, r11, r2, r12)
            return r1
        La2:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.Class<com.microblink.blinkid.secured.lllIIlIIlI> r12 = com.microblink.blinkid.secured.lllIIlIIlI.class
            java.lang.String r0 = "There was a NumberFormatException when calling getCameraIdList. This is probably a bug in device!"
            com.microblink.util.Log.m2715w(r12, r0, r11)
            return r1
        Lac:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.Class<com.microblink.blinkid.secured.lllIIlIIlI> r12 = com.microblink.blinkid.secured.lllIIlIIlI.class
            java.lang.String r0 = "There was a NullPointerException when calling getCameraIdList. This is probably a bug in device!"
            com.microblink.util.Log.m2715w(r12, r0, r11)
            return r1
        Lb6:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.Class<com.microblink.blinkid.secured.lllIIlIIlI> r12 = com.microblink.blinkid.secured.lllIIlIIlI.class
            java.lang.String r0 = "There was assertion error when calling getCameraIdList. This is probably a bug in device!"
            com.microblink.util.Log.m2715w(r12, r0, r11)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.blinkid.secured.IlIlIlIIlI.llIIlIlIIl(android.hardware.camera2.CameraManager, com.microblink.hardware.camera.CameraType):java.lang.String");
    }
}
