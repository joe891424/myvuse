package com.microblink.blinkid.secured;

import android.hardware.camera2.CameraCaptureSession;
import com.microblink.util.Log;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class IIIlIIIIll extends CameraCaptureSession.StateCallback {
    IIIlIIIIll() {
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onActive(CameraCaptureSession cameraCaptureSession) {
        super.onActive(cameraCaptureSession);
        Log.m2707d(lllIIlIIlI.class, "Session is now active", new Object[0]);
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onClosed(CameraCaptureSession cameraCaptureSession) {
        super.onClosed(cameraCaptureSession);
        Log.m2707d(lllIIlIIlI.class, "Session is now closed", new Object[0]);
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onReady(CameraCaptureSession cameraCaptureSession) {
        super.onReady(cameraCaptureSession);
        Log.m2707d(lllIIlIIlI.class, "Session is now ready", new Object[0]);
    }
}
