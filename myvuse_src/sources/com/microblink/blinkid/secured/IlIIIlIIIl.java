package com.microblink.blinkid.secured;

import android.content.Context;
import android.hardware.Camera;
import com.microblink.hardware.camera.CameraType;
import com.microblink.util.Log;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public abstract class IlIIIlIIIl {
    protected List<Camera.Size> IlIllIlIIl;
    protected int IllIIIllII = 0;
    protected int llIIIlllll;
    protected Camera llIIlIlIIl;

    /* JADX INFO: compiled from: line */
    public static class llIIlIlIIl {
        private int IlIllIlIIl;
        private int llIIlIlIIl;

        public llIIlIlIIl(int i, int i2) {
            if (i <= 0 || i2 <= 0) {
                throw new IllegalArgumentException("Width and mHeight must be larger than zero!");
            }
            this.llIIlIlIIl = i;
            this.IlIllIlIIl = i2;
        }

        public int IlIllIlIIl() {
            return this.llIIlIlIIl;
        }

        public int llIIlIlIIl() {
            return this.IlIllIlIIl;
        }
    }

    public IlIIIlIIIl(Camera camera, int i, Context context) {
        this.llIIIlllll = 230400;
        if (camera == null) {
            Log.m2709e(this, "Camera cannot be null while initializing camera strategy", new Object[0]);
            throw new NullPointerException("Camera for CameraStragy cannot be null");
        }
        this.llIIlIlIIl = camera;
        this.llIIIlllll = i;
        this.IlIllIlIIl = camera.getParameters().getSupportedPreviewSizes();
        if (Log.getCurrentLogLevel().ordinal() >= Log.LogLevel.LOG_VERBOSE.ordinal()) {
            List<Camera.Size> list = this.IlIllIlIIl;
            if (list == null) {
                Log.m2707d(this, "List of supported preview sizes is null!", new Object[0]);
                return;
            }
            for (Camera.Size size : list) {
                Log.m2707d(this, "Camera supported preview size: {}x{}", Integer.valueOf(size.width), Integer.valueOf(size.height));
            }
        }
    }

    public abstract void IlIllIlIIl();

    abstract double llIIlIlIIl(Camera.Size size, double d, long j, CameraType cameraType);

    public abstract Camera.Size llIIlIlIIl(int i, int i2, CameraType cameraType);

    protected boolean llIIlIlIIl(Camera.Size size, CameraType cameraType) {
        Camera.Size sizeLlIIlIlIIl = llIIlIlIIl(cameraType);
        boolean z = size.height * size.width >= this.llIIIlllll;
        boolean z2 = sizeLlIIlIlIIl != null && sizeLlIIlIlIIl.equals(size);
        if (Log.getCurrentLogLevel().ordinal() >= Log.LogLevel.LOG_VERBOSE.ordinal()) {
            Log.m2713v(this, "Resolution {}x{}: resolution high enough: {}, resolution specific for device: {}", Integer.valueOf(size.width), Integer.valueOf(size.height), Boolean.valueOf(z), Boolean.valueOf(z2));
        }
        return z || z2;
    }

    protected Camera.Size llIIlIlIIl(CameraType cameraType) {
        llIIlIlIIl lliililiilLllIlIlIIl;
        if (cameraType == CameraType.CAMERA_FRONTFACE) {
            lliililiilLllIlIlIIl = lIlIllIIlI.llIIlIIlll().IllIIlIIII();
        } else {
            lliililiilLllIlIlIIl = lIlIllIIlI.llIIlIIlll().lllIlIlIIl();
        }
        if (lliililiilLllIlIlIIl == null || this.llIIlIlIIl == null) {
            return null;
        }
        Camera camera = this.llIIlIlIIl;
        Objects.requireNonNull(camera);
        Camera.Size size = new Camera.Size(camera, lliililiilLllIlIlIIl.IlIllIlIIl(), lliililiilLllIlIlIIl.llIIlIlIIl());
        List<Camera.Size> list = this.IlIllIlIIl;
        if (list != null && list.contains(size)) {
            Log.m2713v(this, "Using device specific resolution {}x{}", Integer.valueOf(lliililiilLllIlIlIIl.IlIllIlIIl()), Integer.valueOf(lliililiilLllIlIlIIl.llIIlIlIIl()));
            return size;
        }
        Log.m2715w(this, "Device specific resolution {}x{} is not supported on Camera1 API. If possible, use Camera2 API.", Integer.valueOf(lliililiilLllIlIlIIl.IlIllIlIIl()), Integer.valueOf(lliililiilLllIlIlIIl.llIIlIlIIl()));
        return null;
    }

    protected Camera.Size llIIlIlIIl(List<Camera.Size> list, double d, long j, CameraType cameraType) {
        Camera.Size size = null;
        double d2 = Double.POSITIVE_INFINITY;
        for (Camera.Size size2 : list) {
            if (size2.width % 4 == 0) {
                double dLlIIlIlIIl = llIIlIlIIl(size2, d, j, cameraType);
                if (dLlIIlIlIIl < d2) {
                    size = size2;
                    d2 = dLlIIlIlIIl;
                }
                Log.m2713v(this, "Compatibility for preview size {}x{} is {}", Integer.valueOf(size2.width), Integer.valueOf(size2.height), Double.valueOf(dLlIIlIlIIl));
            }
        }
        return size;
    }

    public int llIIlIlIIl() {
        return this.IllIIIllII;
    }

    public void llIIlIlIIl(int i) {
        this.IllIIIllII = i;
    }
}
