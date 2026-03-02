package com.microblink.blinkid.secured;

import android.content.Context;
import android.hardware.Camera;
import com.microblink.hardware.camera.CameraType;
import com.microblink.util.Log;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class lIIllIIlIl extends IlIIIlIIIl {
    public lIIllIIlIl(Camera camera, int i, Context context) {
        super(camera, i, context);
    }

    @Override // com.microblink.blinkid.secured.IlIIIlIIIl
    public void IlIllIlIIl() {
        Log.m2711i(this, "Using LQ strategy", new Object[0]);
    }

    @Override // com.microblink.blinkid.secured.IlIIIlIIIl
    double llIIlIlIIl(Camera.Size size, double d, long j, CameraType cameraType) {
        if (!llIIlIlIIl(size, cameraType)) {
            return Double.POSITIVE_INFINITY;
        }
        return (Math.abs(((((double) size.width) * ((double) size.height)) / j) - 1.0d) * 1000.0d) + (Math.abs((((double) size.width) / ((double) size.height)) - d) * 2000.0d);
    }

    public String toString() {
        return "LQ camera strategy";
    }

    @Override // com.microblink.blinkid.secured.IlIIIlIIIl
    public Camera.Size llIIlIlIIl(int i, int i2, CameraType cameraType) {
        if (this.IlIllIlIIl == null) {
            return null;
        }
        Camera.Size sizeLlIIlIlIIl = llIIlIlIIl(cameraType);
        if (sizeLlIIlIlIIl != null) {
            return sizeLlIIlIlIIl;
        }
        if (IlIIIIIlll.llIIlIlIIl() == 1) {
            i2 = i;
            i = i2;
        }
        return llIIlIlIIl(this.IlIllIlIIl, ((double) i) / ((double) i2), 384000L, cameraType);
    }
}
