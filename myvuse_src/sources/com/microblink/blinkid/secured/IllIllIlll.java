package com.microblink.blinkid.secured;

import android.content.Context;
import android.hardware.Camera;
import com.microblink.hardware.camera.CameraType;
import com.microblink.hardware.camera.VideoResolutionPreset;
import com.microblink.util.Log;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class IllIllIlll extends IlIIIlIIIl {
    private VideoResolutionPreset IllIIIIllI;

    public IllIllIlll(Camera camera, int i, Context context, VideoResolutionPreset videoResolutionPreset) {
        super(camera, i, context);
        this.IllIIIIllI = videoResolutionPreset;
    }

    @Override // com.microblink.blinkid.secured.IlIIIlIIIl
    public void IlIllIlIIl() {
        Log.m2711i(this, "Using VideoPreset strategy with preset: {}", this.IllIIIIllI);
    }

    @Override // com.microblink.blinkid.secured.IlIIIlIIIl
    double llIIlIlIIl(Camera.Size size, double d, long j, CameraType cameraType) {
        if (!llIIlIlIIl(size, cameraType)) {
            return Double.POSITIVE_INFINITY;
        }
        return (Math.abs((((double) size.width) / ((double) size.height)) - d) * 1100.0d) + (Math.abs(((((double) size.width) * ((double) size.height)) / j) - 1.0d) * 1200.0d);
    }

    @Override // com.microblink.blinkid.secured.IlIIIlIIIl
    public Camera.Size llIIlIlIIl(int i, int i2, CameraType cameraType) {
        Camera.Size sizeLlIIlIlIIl;
        Camera.Size size = null;
        if (this.IlIllIlIIl == null) {
            return null;
        }
        Log.m2713v(this, "surface size is: {}x{}", Integer.valueOf(i), Integer.valueOf(i2));
        if (this.IllIIIIllI == VideoResolutionPreset.VIDEO_RESOLUTION_DEFAULT && (sizeLlIIlIlIIl = llIIlIlIIl(cameraType)) != null) {
            return sizeLlIIlIlIIl;
        }
        VideoResolutionPreset videoResolutionPreset = this.IllIIIIllI;
        if (videoResolutionPreset != VideoResolutionPreset.VIDEO_RESOLUTION_MAX_AVAILABLE) {
            long jRound = Math.round(((double) videoResolutionPreset.getIdealHeight()) * 1.7777777777777777d);
            Log.m2711i(this, "Ideal camera resolution is {}x{}", Long.valueOf(jRound), Integer.valueOf(this.IllIIIIllI.getIdealHeight()));
            return llIIlIlIIl(this.IlIllIlIIl, 1.7777777777777777d, jRound * ((long) this.IllIIIIllI.getIdealHeight()), cameraType);
        }
        long j = 0;
        for (Camera.Size size2 : this.IlIllIlIIl) {
            int i3 = size2.width;
            if (i3 % 4 == 0) {
                long j2 = ((long) i3) * ((long) size2.height);
                if (j2 > j) {
                    size = size2;
                    j = j2;
                }
            }
        }
        return size;
    }
}
