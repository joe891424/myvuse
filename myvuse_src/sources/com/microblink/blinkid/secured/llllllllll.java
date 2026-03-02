package com.microblink.blinkid.secured;

import android.content.Context;
import android.graphics.Rect;
import com.microblink.hardware.SuccessCallback;
import com.microblink.hardware.accelerometer.ShakeCallback;
import com.microblink.hardware.camera.CameraType;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public interface llllllllll {

    /* JADX INFO: compiled from: line */
    public interface llIIlIlIIl {
        void IlIllIlIIl();

        void llIIlIlIIl();

        void llIIlIlIIl(int i, int i2);

        void llIIlIlIIl(Throwable th);
    }

    void IIlIIIllIl();

    boolean IlIllIlIIl();

    boolean IlIllIlllI();

    IIllIlIIII IllIIIIllI();

    int IllIIIllII();

    void dispose();

    void lIIIIIllll();

    CameraType lIlIIIIlIl();

    boolean llIIIlllll();

    Boolean llIIlIIlll();

    void llIIlIlIIl(float f);

    void llIIlIlIIl(Context context, IIllllllll iIllllllll, llIIlIlIIl lliililiil);

    void llIIlIlIIl(ShakeCallback shakeCallback);

    void llIIlIlIIl(boolean z, SuccessCallback successCallback);

    void llIIlIlIIl(Rect[] rectArr);

    boolean llIIlIlIIl();

    void lllIIIlIlI();
}
