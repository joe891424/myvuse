package com.microblink.blinkid.secured;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import com.microblink.blinkid.secured.IIlIlIlIlI;
import com.microblink.util.Log;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class IIlIlIllll {
    public static <T> CaptureRequest.Key<T> IlIllIlIIl(String str, Class<T> cls) {
        IIlIlIlIlI.IlIllIlIIl ilIllIlIIl = new IIlIlIlIlI.IlIllIlIIl(cls);
        if (!lllllllIIl.llIIlIlIIl()) {
            return null;
        }
        try {
            return (CaptureRequest.Key) lllllIIIlI.llIIlIlIIl(new Object[]{str, ilIllIlIIl.llIIlIlIIl(), 1});
        } catch (Exception e) {
            Log.m2710e(IIlIlIllll.class, e, "Failed to create Camera Key", new Object[0]);
            return null;
        }
    }

    public static <T> CameraCharacteristics.Key<T> llIIlIlIIl(String str, Class<T> cls) {
        IIlIlIlIlI.IlIllIlIIl ilIllIlIIl = new IIlIlIlIlI.IlIllIlIIl(cls);
        if (!lllllllIIl.llIIlIlIIl()) {
            return null;
        }
        try {
            return (CameraCharacteristics.Key) lllllIIIlI.llIIlIlIIl(new Object[]{str, ilIllIlIIl.llIIlIlIIl(), 0});
        } catch (Exception e) {
            Log.m2710e(IIlIlIllll.class, e, "Fail to create Camera Key.", new Object[0]);
            return null;
        }
    }
}
