package com.microblink.blinkid.secured;

import android.hardware.Camera;
import com.microblink.util.Log;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class IlIIIIIlll {
    private static boolean IlIllIlIIl;
    private static int llIIlIlIIl;

    public static boolean IlIllIlIIl() {
        return IlIllIlIIl;
    }

    public static void llIIlIlIIl(int i, lIlIllIIlI lililliili) {
        Log.m2707d(IlIIIIIlll.class, "Initializing default orientation to: {}", Integer.valueOf(i));
        if (lililliili.llIIlIIIll()) {
            Log.m2707d(IlIIIIIlll.class, "Display orientation is blacklisted!", new Object[0]);
            llIIlIlIIl = 0;
            IlIllIlIIl = false;
        } else {
            llIIlIlIIl = i;
            IlIllIlIIl = true;
        }
        Log.m2707d(IlIIIIIlll.class, "Default orientation initialized to: {}", Integer.valueOf(llIIlIlIIl));
    }

    public static void llIIlIlIIl(Camera camera, int i, int i2, boolean z) {
        int i3;
        if (camera != null) {
            if (IlIllIlIIl) {
                if (z) {
                    i3 = (((i2 - 270) + i) + 360) % 360;
                } else {
                    i3 = (((i2 - 90) + i) + 360) % 360;
                }
                camera.setDisplayOrientation(i3);
                return;
            }
            Log.m2715w(IlIIIIIlll.class, "Set DisplayOrientationMethod not supported.", new Object[0]);
        }
    }

    public static int llIIlIlIIl() {
        return llIIlIlIIl;
    }
}
