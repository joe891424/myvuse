package com.microblink.blinkid.secured;

import android.hardware.camera2.CaptureRequest;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class lIlllIIlll extends lIlIIllIll {
    public static final CaptureRequest.Key<Integer> IlIllIlIIl;
    public static final CaptureRequest.Key<Integer> llIIlIlIIl;

    static {
        Class cls = Integer.TYPE;
        IIlIlIllll.IlIllIlIIl("samsung.android.control.meteringMode", cls);
        llIIlIlIIl = IIlIlIllll.IlIllIlIIl("samsung.android.control.pafMode", cls);
        IlIllIlIIl = IIlIlIllll.IlIllIlIIl("samsung.android.lens.opticalStabilizationOperationMode", cls);
    }
}
