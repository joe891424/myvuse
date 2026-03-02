package com.microblink.blinkid.secured;

import android.content.Context;
import android.hardware.Camera;
import com.microblink.hardware.camera.VideoResolutionPreset;
import com.microblink.util.Log;
import java.util.List;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class IlIIlllIll implements lIIIllIIlI {
    public IlIIIlIIIl llIIlIlIIl(Context context, Camera camera, IIllllllll iIllllllll) {
        IlIIIlIIIl illIllIlll;
        if (context == null) {
            Log.m2709e(this, "Device manager must be set to create CameraStrategy", new Object[0]);
            throw new NullPointerException("Device manager must be set to create CameraStrategy");
        }
        if (camera == null) {
            Log.m2709e(this, "Cannot create strategy for null camera!", new Object[0]);
            throw new NullPointerException("Cannot create strategy for null camera!");
        }
        if (iIllllllll == null) {
            Log.m2709e(this, "Cannot create strategy with empty settings", new Object[0]);
            throw new NullPointerException("Cannot create strategy with empty settings");
        }
        if (iIllllllll.IIlIIIllIl() == VideoResolutionPreset.VIDEO_RESOLUTION_DEFAULT) {
            List<Camera.Size> supportedPreviewSizes = camera.getParameters().getSupportedPreviewSizes();
            if (supportedPreviewSizes == null) {
                illIllIlll = new lIIllIIlIl(camera, iIllllllll.IllIIIIllI(), context);
            } else {
                for (Camera.Size size : supportedPreviewSizes) {
                    if (Math.min(size.width, size.height) >= 720) {
                        Log.m2711i(this, "Device camera is HD ready!", new Object[0]);
                        illIllIlll = new lIlIllIIll(camera, iIllllllll.IllIIIIllI(), context);
                        break;
                    }
                }
                Log.m2711i(this, "Device camera is not HD ready!", new Object[0]);
                illIllIlll = new lIIllIIlIl(camera, iIllllllll.IllIIIIllI(), context);
            }
        } else {
            illIllIlll = new IllIllIlll(camera, iIllllllll.IllIIIIllI(), context, iIllllllll.IIlIIIllIl());
        }
        int iIllIIIllII = lIlIllIIlI.llIIlIIlll().IllIIIllII();
        if (iIllIIIllII != -1) {
            illIllIlll.llIIlIlIIl(iIllIIIllII);
        } else {
            List<String> supportedFocusModes = camera.getParameters().getSupportedFocusModes();
            if (supportedFocusModes == null || !supportedFocusModes.contains("continuous-picture")) {
                illIllIlll.llIIlIlIIl(300);
            } else {
                illIllIlll.llIIlIlIIl(0);
            }
        }
        illIllIlll.IlIllIlIIl();
        return illIllIlll;
    }
}
