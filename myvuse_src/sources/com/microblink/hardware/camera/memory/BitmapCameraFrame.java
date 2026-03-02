package com.microblink.hardware.camera.memory;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.microblink.blinkid.secured.IIlIIlIllI;
import com.microblink.blinkid.secured.IIllIllIII;
import com.microblink.hardware.orientation.Orientation;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class BitmapCameraFrame implements IIllIllIII {
    private long IlIllIlIIl;
    private Orientation IllIIIIllI = Orientation.ORIENTATION_LANDSCAPE_RIGHT;
    private RectF IllIIIllII;
    private long llIIIlllll;
    private Bitmap llIIlIlIIl;

    public BitmapCameraFrame(Bitmap bitmap, long j) {
        this.llIIlIlIIl = bitmap;
        if (bitmap == null) {
            throw new NullPointerException("Cannot use null bitmap!");
        }
        if (bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            throw new UnsupportedOperationException("Cannot recognizer bitmaps that are not in ARGB_8888 config!");
        }
        this.llIIIlllll = j;
    }

    private static native long initializeNativeBitmapFrame(long j, Bitmap bitmap, int i, float f, float f2, float f3, float f4);

    private static native void terminateNativeBitmapFrame(long j);

    private static native void updateNativeBitmapFrame(long j, Bitmap bitmap, int i, float f, float f2, float f3, float f4);

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public long IlIllIlIIl() {
        return this.IlIllIlIIl;
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public double IllIIIIllI() {
        return -1.0d;
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public void IllIIIllII() {
        terminateNativeBitmapFrame(this.IlIllIlIIl);
        this.IlIllIlIIl = 0L;
        this.llIIlIlIIl = null;
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public long lIlIIIIlIl() {
        return this.llIIIlllll;
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public void llIIIlllll() {
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public void llIIlIlIIl() {
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public void llIIlIlIIl(RectF rectF) {
        this.IllIIIllII = rectF;
        IIlIIlIllI.llIIlIlIIl(rectF);
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public boolean llIIlIlIIl(long j) {
        long j2 = this.IlIllIlIIl;
        if (j2 != 0) {
            Bitmap bitmap = this.llIIlIlIIl;
            int iIntValue = this.IllIIIIllI.intValue();
            RectF rectF = this.IllIIIllII;
            updateNativeBitmapFrame(j2, bitmap, iIntValue, rectF.left, rectF.top, rectF.width(), this.IllIIIllII.height());
        } else {
            Bitmap bitmap2 = this.llIIlIlIIl;
            int iIntValue2 = this.IllIIIIllI.intValue();
            RectF rectF2 = this.IllIIIllII;
            this.IlIllIlIIl = initializeNativeBitmapFrame(j, bitmap2, iIntValue2, rectF2.left, rectF2.top, rectF2.width(), this.IllIIIllII.height());
        }
        return this.IlIllIlIIl != 0;
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public void llIIlIlIIl(Orientation orientation) {
        this.IllIIIIllI = orientation;
    }
}
