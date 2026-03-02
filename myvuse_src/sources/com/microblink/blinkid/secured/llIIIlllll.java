package com.microblink.blinkid.secured;

import android.hardware.camera2.CaptureRequest;
import com.microblink.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class llIIIlllll {
    private int IllIIIllII;
    private AtomicBoolean llIIIlllll;
    private boolean llIIlIlIIl = false;
    private boolean IlIllIlIIl = false;

    llIIIlllll() {
    }

    boolean IlIllIlIIl() {
        int i = this.IllIIIllII;
        return i == 4 || i == 2;
    }

    void IllIIIllII() {
        this.llIIIlllll = new AtomicBoolean(true);
        this.IllIIIllII = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void llIIlIlIIl(android.hardware.camera2.CameraCharacteristics r6, com.microblink.blinkid.secured.lIlIllIIlI r7) {
        /*
            r5 = this;
            android.hardware.camera2.CameraCharacteristics$Key r0 = android.hardware.camera2.CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE
            java.lang.Object r0 = r6.get(r0)
            java.lang.Float r0 = (java.lang.Float) r0
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L20
            java.lang.Object[] r3 = new java.lang.Object[]{r0}
            java.lang.String r4 = "Minimum focus distance: {}"
            com.microblink.util.Log.m2713v(r5, r4, r3)
            float r0 = r0.floatValue()
            r3 = 0
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L20
            r0 = r1
            goto L21
        L20:
            r0 = r2
        L21:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r0)
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r4 = "Camera has fixed lens: {}"
            com.microblink.util.Log.m2711i(r5, r4, r3)
            r0 = r0 ^ r1
            r5.llIIlIlIIl = r0
            boolean r0 = com.microblink.blinkid.secured.lllllllIIl.llIIlIlIIl()
            if (r0 == 0) goto L75
            android.hardware.camera2.CameraCharacteristics$Key<java.lang.Boolean> r0 = com.microblink.blinkid.secured.IllIllIIll.llIIlIlIIl     // Catch: java.lang.IllegalArgumentException -> L5d
            java.lang.Object r6 = r6.get(r0)     // Catch: java.lang.IllegalArgumentException -> L5d
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch: java.lang.IllegalArgumentException -> L5d
            if (r6 == 0) goto L66
            boolean r0 = r6.booleanValue()     // Catch: java.lang.IllegalArgumentException -> L5d
            if (r0 == 0) goto L56
            boolean r7 = r7.lIlllIlIlI()     // Catch: java.lang.IllegalArgumentException -> L5d
            if (r7 == 0) goto L56
            java.lang.String r6 = "Samsung Phase AF is supported, but buggy on this device. Will not enabled it!"
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch: java.lang.IllegalArgumentException -> L5d
            com.microblink.util.Log.m2711i(r5, r6, r7)     // Catch: java.lang.IllegalArgumentException -> L5d
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch: java.lang.IllegalArgumentException -> L5d
        L56:
            boolean r6 = r6.booleanValue()     // Catch: java.lang.IllegalArgumentException -> L5d
            r5.IlIllIlIIl = r6     // Catch: java.lang.IllegalArgumentException -> L5d
            goto L66
        L5d:
            java.lang.Object[] r6 = new java.lang.Object[r2]
            java.lang.String r7 = "Unable to query device for PAF availability"
            com.microblink.util.Log.m2711i(r5, r7, r6)
            r5.IlIllIlIIl = r2
        L66:
            boolean r6 = r5.IlIllIlIIl
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            java.lang.Object[] r6 = new java.lang.Object[]{r6}
            java.lang.String r7 = "Samsung Phase AF supported: {}"
            com.microblink.util.Log.m2711i(r5, r7, r6)
        L75:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.blinkid.secured.llIIIlllll.llIIlIlIIl(android.hardware.camera2.CameraCharacteristics, com.microblink.blinkid.secured.lIlIllIIlI):void");
    }

    void llIIlIlIIl(CaptureRequest.Builder builder) {
        if (this.llIIlIlIIl) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 4);
        } else {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 0);
        }
        if (this.IlIllIlIIl) {
            Log.m2707d(this, "Activating Samsung Phase AF", new Object[0]);
            builder.set(lIlllIIlll.llIIlIlIIl, 1);
        }
    }

    boolean llIIlIlIIl() {
        return this.llIIlIlIIl;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean llIIlIlIIl(android.hardware.camera2.TotalCaptureResult r6, com.microblink.hardware.camera.AutofocusListener r7, com.microblink.blinkid.secured.llIlllIIIl r8) {
        /*
            r5 = this;
            android.hardware.camera2.CaptureResult$Key r0 = android.hardware.camera2.CaptureResult.CONTROL_AF_STATE
            java.lang.Object r6 = r6.get(r0)
            java.lang.Integer r6 = (java.lang.Integer) r6
            r0 = 0
            if (r6 != 0) goto L13
            java.lang.Object[] r6 = new java.lang.Object[r0]
            java.lang.String r7 = "Focus state is null! This is a bug in device!"
            com.microblink.util.Log.wtf(r5, r7, r6)
            return r0
        L13:
            int r1 = r6.intValue()
            r2 = 3
            r3 = 1
            switch(r1) {
                case 0: goto L8d;
                case 1: goto L78;
                case 2: goto L63;
                case 3: goto L5b;
                case 4: goto L3e;
                case 5: goto L1e;
                case 6: goto L1e;
                default: goto L1c;
            }
        L1c:
            goto La1
        L1e:
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r4 = "Focus state: Unfocused"
            com.microblink.util.Log.m2713v(r5, r4, r1)
            int r1 = r5.IllIIIllII
            if (r1 == r2) goto L2b
            if (r1 != r3) goto L35
        L2b:
            android.graphics.Rect[] r8 = r8.llIIlIlIIl()
            r7.onAutofocusStopped(r8)
            r7.onAutofocusFailed()
        L35:
            java.util.concurrent.atomic.AtomicBoolean r7 = r5.llIIIlllll
            boolean r7 = r7.get()
            if (r7 != 0) goto La1
            goto L59
        L3e:
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r4 = "Focus state: Focus locked"
            com.microblink.util.Log.m2713v(r5, r4, r1)
            java.util.concurrent.atomic.AtomicBoolean r1 = r5.llIIIlllll
            boolean r1 = r1.get()
            if (r1 != 0) goto L63
            int r0 = r5.IllIIIllII
            r1 = 4
            if (r0 == r1) goto L59
            android.graphics.Rect[] r8 = r8.llIIlIlIIl()
            r7.onAutofocusStopped(r8)
        L59:
            r0 = r3
            goto La1
        L5b:
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r4 = "Focus state: Active scan in progress..."
            com.microblink.util.Log.m2713v(r5, r4, r1)
            goto L78
        L63:
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r4 = "Focus state: Focused"
            com.microblink.util.Log.m2713v(r5, r4, r1)
            int r1 = r5.IllIIIllII
            if (r1 == r2) goto L70
            if (r1 != r3) goto La1
        L70:
            android.graphics.Rect[] r8 = r8.llIIlIlIIl()
            r7.onAutofocusStopped(r8)
            goto La1
        L78:
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r4 = "Focus state: Focus in progress..."
            com.microblink.util.Log.m2713v(r5, r4, r1)
            int r1 = r5.IllIIIllII
            if (r1 == r2) goto La1
            if (r1 == r3) goto La1
            android.graphics.Rect[] r8 = r8.llIIlIlIIl()
            r7.onAutofocusStarted(r8)
            goto La1
        L8d:
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r4 = "Focus state: Focus is currently inactive"
            com.microblink.util.Log.m2713v(r5, r4, r1)
            int r1 = r5.IllIIIllII
            if (r1 == r2) goto L9a
            if (r1 != r3) goto La1
        L9a:
            android.graphics.Rect[] r8 = r8.llIIlIlIIl()
            r7.onAutofocusStopped(r8)
        La1:
            int r6 = r6.intValue()
            r5.IllIIIllII = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.blinkid.secured.llIIIlllll.llIIlIlIIl(android.hardware.camera2.TotalCaptureResult, com.microblink.hardware.camera.AutofocusListener, com.microblink.blinkid.secured.llIlllIIIl):boolean");
    }

    void llIIlIlIIl(boolean z) {
        this.llIIIlllll.set(z);
    }
}
