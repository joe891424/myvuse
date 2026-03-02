package com.microblink.blinkid.secured;

import android.hardware.camera2.CameraCaptureSession;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class IlIIlIIIII extends IIIlIIIIll {
    final /* synthetic */ lllIIlIIlI llIIlIlIIl;

    IlIIlIIIII(lllIIlIIlI llliiliili) {
        this.llIIlIlIIl = llliiliili;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        this.llIIlIlIIl.lIIIIIlIlI = null;
        this.llIIlIlIIl.IIIIIIIIII.llIIIlllll();
        this.llIIlIlIIl.IlIIIIIlll = false;
        this.llIIlIlIIl.lllIIlIIlI = false;
        this.llIIlIlIIl.IlIllIlllI.llIIlIlIIl(new RuntimeException("Failed to configure camera capture session"));
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onConfigured(CameraCaptureSession cameraCaptureSession) {
        if (this.llIIlIlIIl.IlllIIIllI) {
            return;
        }
        this.llIIlIlIIl.lIIIIIlIlI = cameraCaptureSession;
        this.llIIlIlIIl.IlIIIIIlll = false;
        this.llIIlIlIIl.lllIIlIIlI = true;
        this.llIIlIlIIl.IlIIlllIIl();
    }
}
