package com.microblink.blinkid.secured;

import android.hardware.camera2.CameraCharacteristics;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class IllIllIIll extends lIlIIllIll {
    public static final CameraCharacteristics.Key<int[]> IlIllIlIIl;
    public static final CameraCharacteristics.Key<Boolean> llIIlIlIIl;

    static {
        IIlIlIllll.llIIlIlIIl("samsung.android.control.meteringAvailableMode", int[].class);
        llIIlIlIIl = IIlIlIllll.llIIlIlIIl("samsung.android.control.pafAvailableMode", Boolean.TYPE);
        IlIllIlIIl = IIlIlIllll.llIIlIlIIl("samsung.android.lens.info.availableOpticalStabilizationOperationMode", int[].class);
    }
}
