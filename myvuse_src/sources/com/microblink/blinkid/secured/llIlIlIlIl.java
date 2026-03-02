package com.microblink.blinkid.secured;

import com.microblink.hardware.camera.AutofocusListener;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public interface llIlIlIlIl extends AutofocusListener {
    boolean canReceiveFrame();

    void onCameraFrame(IIllIllIII iIllIllIII);

    void onHighResFrame(IIllIllIII iIllIllIII);
}
