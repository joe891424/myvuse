package com.microblink.image;

import android.graphics.RectF;
import com.microblink.blinkid.secured.IIllIllIII;
import com.microblink.hardware.orientation.Orientation;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class ImageFrame implements IIllIllIII {
    private long IlIllIlIIl = 0;
    private long IllIIIllII;
    private boolean llIIIlllll;
    protected Image llIIlIlIIl;

    public ImageFrame(Image image, boolean z, long j) {
        this.llIIlIlIIl = image;
        this.IllIIIllII = j;
        this.llIIIlllll = z;
    }

    private static native long nativeConstruct(long j, long j2, boolean z);

    private static native void nativeDestruct(long j);

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public final long IlIllIlIIl() {
        return this.IlIllIlIIl;
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public final double IllIIIIllI() {
        return -1.0d;
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public void IllIIIllII() {
        nativeDestruct(this.IlIllIlIIl);
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public final long lIlIIIIlIl() {
        return this.IllIIIllII;
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public final void llIIIlllll() {
        throw new UnsupportedOperationException("Image frame should not be used in object pool.");
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public final void llIIlIlIIl(RectF rectF) {
        throw new UnsupportedOperationException("ImageFrame's ROI is obtained from image object!");
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public boolean llIIlIlIIl(long j) {
        long jNativeConstruct = nativeConstruct(this.llIIlIlIIl.lllIIIlIlI, j, this.llIIIlllll);
        this.IlIllIlIIl = jNativeConstruct;
        return jNativeConstruct != 0;
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public final void llIIlIlIIl(Orientation orientation) {
        throw new UnsupportedOperationException("Orientation should be set to image object before creating Image frame");
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public final void llIIlIlIIl() {
        throw new UnsupportedOperationException("Image frame should not be used in object pool.");
    }
}
