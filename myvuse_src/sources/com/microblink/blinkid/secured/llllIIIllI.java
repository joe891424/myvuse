package com.microblink.blinkid.secured;

import android.hardware.camera2.CaptureRequest;
import com.microblink.util.Log;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class llllIIIllI {
    private boolean llIIlIlIIl = false;
    private boolean IlIllIlIIl = false;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001a, code lost:
    
        r6.llIIlIlIIl = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void llIIlIlIIl(android.hardware.camera2.CameraCharacteristics r7) {
        /*
            r6 = this;
            boolean r0 = com.microblink.blinkid.secured.lllllllIIl.llIIlIlIIl()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L38
            android.hardware.camera2.CameraCharacteristics$Key<int[]> r0 = com.microblink.blinkid.secured.IllIllIIll.IlIllIlIIl     // Catch: java.lang.IllegalArgumentException -> L20
            java.lang.Object r0 = r7.get(r0)     // Catch: java.lang.IllegalArgumentException -> L20
            int[] r0 = (int[]) r0     // Catch: java.lang.IllegalArgumentException -> L20
            if (r0 == 0) goto L29
            int r3 = r0.length     // Catch: java.lang.IllegalArgumentException -> L20
            r4 = r1
        L14:
            if (r4 >= r3) goto L29
            r5 = r0[r4]     // Catch: java.lang.IllegalArgumentException -> L20
            if (r5 != 0) goto L1d
            r6.llIIlIlIIl = r2     // Catch: java.lang.IllegalArgumentException -> L20
            goto L29
        L1d:
            int r4 = r4 + 1
            goto L14
        L20:
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r3 = "Unable to query device for OIS operation mode availability"
            com.microblink.util.Log.m2711i(r6, r3, r0)
            r6.llIIlIlIIl = r1
        L29:
            boolean r0 = r6.llIIlIlIIl
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r3 = "Samsung optical image stabilisation picture mode supported: {}"
            com.microblink.util.Log.m2711i(r6, r3, r0)
        L38:
            android.hardware.camera2.CameraCharacteristics$Key r0 = android.hardware.camera2.CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION
            java.lang.Object r7 = r7.get(r0)
            int[] r7 = (int[]) r7
            if (r7 == 0) goto L4f
            int r0 = r7.length
        L43:
            if (r1 >= r0) goto L4f
            r3 = r7[r1]
            if (r3 != r2) goto L4c
            r6.IlIllIlIIl = r2
            goto L4f
        L4c:
            int r1 = r1 + 1
            goto L43
        L4f:
            boolean r7 = r6.IlIllIlIIl
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            java.lang.Object[] r7 = new java.lang.Object[]{r7}
            java.lang.String r0 = "Optical image stabilisation supported: {}"
            com.microblink.util.Log.m2711i(r6, r0, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.blinkid.secured.llllIIIllI.llIIlIlIIl(android.hardware.camera2.CameraCharacteristics):void");
    }

    public void llIIlIlIIl(CaptureRequest.Builder builder) {
        if (this.IlIllIlIIl) {
            Log.m2707d(this, "Activating optical image stabilisation", new Object[0]);
            builder.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, 1);
            if (this.llIIlIlIIl) {
                Log.m2707d(this, "Activating Samsung picture mode for optical image stabilisation", new Object[0]);
                builder.set(lIlllIIlll.IlIllIlIIl, 0);
            }
        }
    }
}
