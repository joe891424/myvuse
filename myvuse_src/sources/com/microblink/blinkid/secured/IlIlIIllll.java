package com.microblink.blinkid.secured;

import android.hardware.Camera;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.microblink.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class IlIlIIllll {
    private static List<String> IllIIIIllI;
    private static List<String> llIIIlllll;
    private Camera.Parameters llIIlIlIIl;
    private static List<String> IlIllIlIIl = Arrays.asList("continuous-picture", "macro", "auto");
    private static List<String> IllIIIllII = Arrays.asList("continuous-picture", "auto", "macro");

    static {
        Arrays.asList("macro", "auto");
        llIIIlllll = Arrays.asList("macro", "auto");
        IllIIIIllI = Collections.singletonList("auto");
    }

    public IlIlIIllll(Camera camera) {
        this.llIIlIlIIl = camera.getParameters();
    }

    public String IIlIIIllIl() {
        return llIIlIlIIl(IllIIIllII);
    }

    public void IlIllIlIIl() {
        if (this.llIIlIlIIl.isVideoStabilizationSupported()) {
            Log.m2711i(this, "Enabling video stabilization", new Object[0]);
            this.llIIlIlIIl.setVideoStabilization(true);
        }
    }

    public void IlIllIlllI() {
        this.llIIlIlIIl.setPictureFormat(256);
        this.llIIlIlIIl.setJpegQuality(100);
        List<Camera.Size> supportedPictureSizes = this.llIIlIlIIl.getSupportedPictureSizes();
        if (supportedPictureSizes.isEmpty()) {
            return;
        }
        Camera.Size size = supportedPictureSizes.get(0);
        int i = size.height * size.width;
        for (Camera.Size size2 : supportedPictureSizes) {
            int i2 = size2.height * size2.width;
            if (i2 > i) {
                size = size2;
                i = i2;
            }
        }
        this.llIIlIlIIl.setPictureSize(size.width, size.height);
    }

    public Boolean IllIIIIllI() {
        List<String> supportedFlashModes = this.llIIlIlIIl.getSupportedFlashModes();
        if (supportedFlashModes == null || !supportedFlashModes.contains("torch")) {
            Log.m2711i(this, "Camera does not support torch!", new Object[0]);
            return Boolean.FALSE;
        }
        Log.m2711i(this, "Camera supports torch!", new Object[0]);
        return Boolean.TRUE;
    }

    public Camera.Parameters IllIIIllII() {
        return this.llIIlIlIIl;
    }

    public void lIIIIIllll() {
        this.llIIlIlIIl.setPreviewFpsRange(HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT, HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT);
    }

    public void lIlIIIIlIl() {
        List<String> supportedWhiteBalance = this.llIIlIlIIl.getSupportedWhiteBalance();
        if (supportedWhiteBalance == null || !supportedWhiteBalance.contains("auto")) {
            Log.m2715w(this, "Automatic white balance not supported!!!", new Object[0]);
        } else {
            this.llIIlIlIIl.setWhiteBalance("auto");
            Log.m2713v(this, "Activated automatic white balance correction", new Object[0]);
        }
    }

    public boolean llIIIlllll() {
        return this.llIIlIlIIl.getSupportedFocusModes().contains("auto");
    }

    public String llIIlIIlll() {
        return llIIlIlIIl(IlIllIlIIl);
    }

    public IlIlIIllll llIIlIlIIl(Camera.Size size) {
        this.llIIlIlIIl.setPreviewSize(size.width, size.height);
        return this;
    }

    public void lllIIIlIlI() {
        this.llIIlIlIIl.setRecordingHint(true);
        this.llIIlIlIIl.setPictureSize(3264, 2448);
    }

    public String toString() {
        return this.llIIlIlIIl.flatten();
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0006 A[PHI: r0
      0x0006: PHI (r0v6 float) = (r0v0 float), (r0v1 float) binds: [B:3:0x0004, B:6:0x000b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.microblink.blinkid.secured.IlIlIIllll llIIlIlIIl(float r3) {
        /*
            r2 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 <= 0) goto L8
        L6:
            r3 = r0
            goto Le
        L8:
            r0 = 0
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 >= 0) goto Le
            goto L6
        Le:
            android.hardware.Camera$Parameters r0 = r2.llIIlIlIIl
            int r0 = r0.getMaxZoom()
            float r0 = (float) r0
            float r3 = r3 * r0
            int r3 = java.lang.Math.round(r3)
            android.hardware.Camera$Parameters r0 = r2.llIIlIlIIl
            r0.setZoom(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.blinkid.secured.IlIlIIllll.llIIlIlIIl(float):com.microblink.blinkid.secured.IlIlIIllll");
    }

    public boolean IlIllIlIIl(boolean z) {
        if (z) {
            this.llIIlIlIIl.setFlashMode("torch");
            return true;
        }
        List<String> supportedFlashModes = this.llIIlIlIIl.getSupportedFlashModes();
        if (supportedFlashModes != null && supportedFlashModes.contains(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
            this.llIIlIlIIl.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            return true;
        }
        Log.m2709e(this, "Flash mode OFF not supported!!!!", new Object[0]);
        return false;
    }

    public void llIIlIlIIl(boolean z) {
        if (z) {
            llIIlIlIIl(llIIIlllll);
        } else {
            llIIlIlIIl(IllIIIIllI);
        }
    }

    public void llIIlIlIIl() {
        String str = this.llIIlIlIIl.get("phase-af-values");
        Log.m2711i(this, "Supported Phase AutoFocus modes: {}", str);
        if (str != null) {
            for (String str2 : str.split(",")) {
                if ("on".equals(str2)) {
                    Log.m2711i(this, "Activating Phase Autofocus!", new Object[0]);
                    this.llIIlIlIIl.set("phase-af", "on");
                }
            }
        }
    }

    public void llIIlIlIIl(int i) {
        this.llIIlIlIIl.setPreviewFrameRate(i);
    }

    public void llIIlIlIIl(Camera camera) {
        camera.setParameters(this.llIIlIlIIl);
    }

    private String llIIlIlIIl(List<String> list) {
        List<String> supportedFocusModes = this.llIIlIlIIl.getSupportedFocusModes();
        if (supportedFocusModes == null) {
            return "noSupport";
        }
        for (String str : list) {
            if (supportedFocusModes.contains(str)) {
                this.llIIlIlIIl.setFocusMode(str);
                return str;
            }
        }
        return "noSupport";
    }
}
