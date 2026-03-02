package com.microblink.blinkid.secured;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.microblink.hardware.camera.memory.BitmapCameraFrame;
import com.microblink.hardware.orientation.Orientation;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class IlIIlllIIl implements IIllIllIII {
    private BitmapCameraFrame IlIllIlIIl;
    private llIllIIlll llIIlIlIIl;

    public IlIIlllIIl(llIllIIlll llilliilll) {
        this.llIIlIlIIl = llilliilll;
        Bitmap bitmapDecodeByteArray = BitmapFactoryInstrumentation.decodeByteArray(llilliilll.llIIlIIlll(), 0, this.llIIlIlIIl.llIIlIIlll().length);
        if (bitmapDecodeByteArray == null) {
            throw new RuntimeException("Failed to decode photo data!");
        }
        this.IlIllIlIIl = new BitmapCameraFrame(bitmapDecodeByteArray, this.llIIlIlIIl.lIlIIIIlIl());
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public long IlIllIlIIl() {
        return this.IlIllIlIIl.IlIllIlIIl();
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public double IllIIIIllI() {
        this.IlIllIlIIl.getClass();
        return -1.0d;
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public void IllIIIllII() {
        this.IlIllIlIIl.IllIIIllII();
        this.llIIlIlIIl.llIIlIlIIl();
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public long lIlIIIIlIl() {
        return this.llIIlIlIIl.lIIIIIllll;
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public void llIIIlllll() {
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public void llIIlIlIIl() {
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public void llIIlIlIIl(RectF rectF) {
        this.IlIllIlIIl.llIIlIlIIl(rectF);
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public boolean llIIlIlIIl(long j) {
        return this.IlIllIlIIl.llIIlIlIIl(j);
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public void llIIlIlIIl(Orientation orientation) {
        this.IlIllIlIIl.llIIlIlIIl(orientation);
    }
}
