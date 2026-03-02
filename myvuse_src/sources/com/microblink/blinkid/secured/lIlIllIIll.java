package com.microblink.blinkid.secured;

import android.content.Context;
import android.hardware.Camera;
import com.microblink.hardware.camera.CameraType;
import com.microblink.util.Log;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class lIlIllIIll extends IlIIIlIIIl {
    public lIlIllIIll(Camera camera, int i, Context context) {
        super(camera, i, context);
    }

    @Override // com.microblink.blinkid.secured.IlIIIlIIIl
    public void IlIllIlIIl() {
        Log.m2711i(this, "Using HQ strategy", new Object[0]);
    }

    @Override // com.microblink.blinkid.secured.IlIIIlIIIl
    double llIIlIlIIl(Camera.Size size, double d, long j, CameraType cameraType) {
        if (llIIlIlIIl(size, cameraType)) {
            return Math.abs(((((double) size.width) * ((double) size.height)) / j) - 1.0d) * 1200.0d;
        }
        return Double.POSITIVE_INFINITY;
    }

    public String toString() {
        return "HQ camera strategy!";
    }

    @Override // com.microblink.blinkid.secured.IlIIIlIIIl
    public Camera.Size llIIlIlIIl(int i, int i2, CameraType cameraType) {
        if (this.IlIllIlIIl == null) {
            return null;
        }
        Log.m2713v(this, "surface size is: {}x{}", Integer.valueOf(i), Integer.valueOf(i2));
        Camera.Size sizeLlIIlIlIIl = llIIlIlIIl(cameraType);
        if (sizeLlIIlIlIIl != null) {
            return sizeLlIIlIlIIl;
        }
        if (IlIIIIIlll.llIIlIlIIl() == 1) {
            i2 = i;
            i = i2;
        }
        return llIIlIlIIl(this.IlIllIlIIl, ((double) i) / ((double) i2), 2073600L, cameraType);
    }
}
