package com.microblink.blinkid.secured;

import android.graphics.Rect;
import android.hardware.Camera;
import com.microblink.hardware.camera.AutofocusListener;
import com.microblink.util.Log;
import java.util.ArrayList;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class llIIllIlII implements IIIIIllIll {
    private boolean IIlIIIllIl;
    private AutofocusListener IlIllIlIIl;
    private lIlIllIIlI llIIlIIlll;
    private Camera llIIlIlIIl;
    private boolean IllIIIllII = false;
    private Rect[] llIIIlllll = null;
    private boolean IllIIIIllI = false;
    private boolean lIlIIIIlIl = false;

    /* JADX INFO: compiled from: line */
    class IlIllIlIIl implements Camera.AutoFocusMoveCallback {
        IlIllIlIIl() {
        }

        @Override // android.hardware.Camera.AutoFocusMoveCallback
        public void onAutoFocusMoving(boolean z, Camera camera) {
            Log.m2707d(llIIllIlII.this, "Autofocus move callback start: {}", Boolean.valueOf(z));
            llIIllIlII.this.IllIIIllII = z;
            if (llIIllIlII.this.IlIllIlIIl != null) {
                if (z) {
                    llIIllIlII.this.IlIllIlIIl.onAutofocusStarted(llIIllIlII.this.llIIIlllll);
                    llIIllIlII.this.lIlIIIIlIl = false;
                } else {
                    llIIllIlII.this.IlIllIlIIl.onAutofocusStopped(llIIllIlII.this.llIIIlllll);
                    llIIllIlII.this.lIlIIIIlIl = true;
                }
            }
        }
    }

    /* JADX INFO: compiled from: line */
    class llIIlIlIIl implements Camera.AutoFocusCallback {
        llIIlIlIIl() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            Log.m2713v(llIIllIlII.this, "Full autofocus cycle completed with success: {}", Boolean.valueOf(z));
            llIIllIlII.this.IllIIIIllI = false;
            llIIllIlII.this.IllIIIllII = false;
            if (llIIllIlII.this.llIIlIIlll != null && llIIllIlII.this.llIIlIIlll.IlIIlllIIl()) {
                Log.m2711i(llIIllIlII.this, "This is a device with untrusty focus. We will assume that focus has succeeded!", new Object[0]);
                z = true;
            }
            if (llIIllIlII.this.IlIllIlIIl != null) {
                llIIllIlII.this.IlIllIlIIl.onAutofocusStopped(llIIllIlII.this.llIIIlllll);
                llIIllIlII.this.lIlIIIIlIl = z;
                if (!z) {
                    llIIllIlII.this.IlIllIlIIl.onAutofocusFailed();
                }
            }
            if (llIIllIlII.this.llIIlIlIIl != null) {
                try {
                    Camera.Parameters parameters = camera.getParameters();
                    parameters.setFocusMode("continuous-picture");
                    camera.setParameters(parameters);
                } catch (RuntimeException e) {
                    int i = IIIIIIIIII.llIIlIlIIl;
                    Log.m2716w(llIIllIlII.this, e, "Failed to transfer camera back into continuous autofocus mode! This is a device issue!", new Object[0]);
                }
            }
            int i2 = IIIIIIIIII.llIIlIlIIl;
        }
    }

    public llIIllIlII(AutofocusListener autofocusListener, lIlIllIIlI lililliili, boolean z) {
        this.IlIllIlIIl = autofocusListener;
        this.llIIlIIlll = lililliili;
        if (!lililliili.lIIIIIlIlI()) {
            throw new IllegalArgumentException("Device manager needs to have device lists loaded");
        }
        this.IIlIIIllIl = z;
    }

    @Override // com.microblink.blinkid.secured.IIIIIllIll
    public void IIlIIIllIl() {
    }

    @Override // com.microblink.blinkid.secured.IIIIIllIll
    public void IllIIIIllI() {
    }

    @Override // com.microblink.blinkid.secured.IIIIIllIll
    public void dispose() {
        this.llIIlIlIIl = null;
        this.IlIllIlIIl = null;
        this.llIIIlllll = null;
        this.llIIlIIlll = null;
    }

    @Override // com.microblink.blinkid.secured.IIIIIllIll
    public void lIIIIIllll() {
        this.lIlIIIIlIl = false;
    }

    @Override // com.microblink.blinkid.secured.IIIIIllIll
    public boolean lIlIIIIlIl() {
        return true;
    }

    @Override // com.microblink.blinkid.secured.IIIIIllIll
    public void llIIIlllll() {
    }

    @Override // com.microblink.blinkid.secured.IIIIIllIll
    public boolean llIIlIIlll() {
        Log.m2713v(this, "Focus in progress: {}, full autofocus in progress: {}", Boolean.valueOf(this.IllIIIllII), Boolean.valueOf(this.IllIIIIllI));
        return this.IllIIIllII || this.IllIIIIllI;
    }

    @Override // com.microblink.blinkid.secured.IIIIIllIll
    public boolean llIIlIlIIl() {
        return true;
    }

    @Override // com.microblink.blinkid.secured.IIIIIllIll
    public boolean IlIllIlIIl() {
        return this.lIlIIIIlIl;
    }

    @Override // com.microblink.blinkid.secured.IIIIIllIll
    public void IllIIIllII() {
        Camera camera = this.llIIlIlIIl;
        if (camera == null || !this.IllIIIIllI) {
            return;
        }
        try {
            camera.cancelAutoFocus();
            Camera.Parameters parameters = this.llIIlIlIIl.getParameters();
            parameters.setFocusMode("continuous-picture");
            this.llIIlIlIIl.setParameters(parameters);
        } catch (RuntimeException e) {
            int i = IIIIIIIIII.llIIlIlIIl;
            Log.m2716w(this, e, "Failed to resume continuous autofocus because attempt to modify camera parameters failed or because autofocus cancelling has failed.", new Object[0]);
        }
    }

    @Override // com.microblink.blinkid.secured.IIIIIllIll
    public void llIIlIlIIl(boolean z) {
        if ((!z && this.lIlIIIIlIl) || this.IllIIIIllI || this.llIIlIlIIl == null) {
            return;
        }
        Log.m2713v(this, "Performing full autofocus cycle", new Object[0]);
        try {
            IlIlIIllll ilIlIIllll = new IlIlIIllll(this.llIIlIlIIl);
            ilIlIIllll.llIIlIlIIl(this.IIlIIIllIl);
            try {
                ilIlIIllll.llIIlIlIIl(this.llIIlIlIIl);
            } catch (RuntimeException e) {
                int i = IIIIIIIIII.llIIlIlIIl;
                Log.m2716w(this, e, "Failed to transfer camera into autofocus mode from continuous autofocus. Focus may fail! This is a device issue!", new Object[0]);
            }
            AutofocusListener autofocusListener = this.IlIllIlIIl;
            if (autofocusListener != null) {
                autofocusListener.onAutofocusStarted(this.llIIIlllll);
            }
            this.IllIIIIllI = true;
            this.IllIIIllII = true;
            try {
                this.llIIlIlIIl.autoFocus(new llIIlIlIIl());
            } catch (RuntimeException e2) {
                int i2 = IIIIIIIIII.llIIlIlIIl;
                Log.m2716w(this, e2, "A runtime exception occurred while attempting to perform autofocus", new Object[0]);
                this.IllIIIIllI = false;
                this.IllIIIllII = false;
                this.lIlIIIIlIl = false;
                AutofocusListener autofocusListener2 = this.IlIllIlIIl;
                if (autofocusListener2 != null) {
                    autofocusListener2.onAutofocusStopped(this.llIIIlllll);
                }
                Camera camera = this.llIIlIlIIl;
                if (camera != null) {
                    try {
                        Camera.Parameters parameters = camera.getParameters();
                        parameters.setFocusMode("continuous-picture");
                        this.llIIlIlIIl.setParameters(parameters);
                    } catch (RuntimeException e3) {
                        int i3 = IIIIIIIIII.llIIlIlIIl;
                        Log.m2716w(this, e3, "Failed to transfer camera back into continuous autofocus mode! This is a device issue!", new Object[0]);
                    }
                }
            }
        } catch (RuntimeException e4) {
            int i4 = IIIIIIIIII.llIIlIlIIl;
            Log.m2716w(this, e4, "Failed to obtain parameters from camera! Cannot perform autofocus cycle.", new Object[0]);
        }
    }

    @Override // com.microblink.blinkid.secured.IIIIIllIll
    public void llIIlIlIIl(Camera camera) {
        if (camera == null) {
            return;
        }
        this.llIIlIlIIl = camera;
        camera.setAutoFocusMoveCallback(new IlIllIlIIl());
    }

    @Override // com.microblink.blinkid.secured.IIIIIllIll
    public void llIIlIlIIl(Rect[] rectArr) {
        Camera camera = this.llIIlIlIIl;
        if (camera != null) {
            try {
                Camera.Parameters parameters = camera.getParameters();
                if (rectArr == null) {
                    parameters.setMeteringAreas(null);
                    parameters.setFocusAreas(null);
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < parameters.getMaxNumFocusAreas() && i < rectArr.length; i++) {
                        Log.m2707d(this, "Adding focus area {}", rectArr[i]);
                        arrayList.add(new Camera.Area(rectArr[i], 1000));
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < parameters.getMaxNumMeteringAreas() && i2 < rectArr.length; i2++) {
                        Log.m2707d(this, "Adding metering area {}", rectArr[i2]);
                        arrayList2.add(new Camera.Area(rectArr[i2], 1000));
                    }
                    parameters.setMeteringAreas(arrayList2);
                    parameters.setFocusAreas(arrayList);
                }
                try {
                    this.llIIlIlIIl.setParameters(parameters);
                    this.llIIIlllll = rectArr;
                    return;
                } catch (RuntimeException unused) {
                    int i3 = IIIIIIIIII.llIIlIlIIl;
                    Log.m2709e(this, "Failed to apply new camera parameters!", new Object[0]);
                    return;
                }
            } catch (RuntimeException e) {
                int i4 = IIIIIIIIII.llIIlIlIIl;
                Log.m2716w(this, e, "Failed to obtain camera paremeters. Cannot set metering areas!", new Object[0]);
                return;
            }
        }
        Log.m2715w(this, "Cannot set focus area, camera is null", new Object[0]);
    }
}
