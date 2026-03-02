package com.microblink.blinkid.secured;

import android.graphics.RectF;
import android.media.Image;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.util.Log;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public abstract class IIlIIIllIl implements IIllIllIII {
    private lIllIIlIIl IlIllIlIIl;
    private boolean IllIIIIllI;
    private llIIlIlIIl IllIIIllII;
    private Orientation lIIIIIllll;
    private RectF lIlIIIIlIl;
    private boolean llIIIlllll;
    public Image llIIlIlIIl;
    private long lllIIIlIlI;
    private long llIIlIIlll = 0;
    private double IIlIIIllIl = -1.0d;

    /* JADX INFO: compiled from: line */
    public interface llIIlIlIIl {
        void llIIlIlIIl(Image image);
    }

    public IIlIIIllIl(lIllIIlIIl lilliiliil) {
        this.IlIllIlIIl = lilliiliil;
    }

    protected abstract double IlIllIlIIl(long j);

    protected abstract void IlIllIlIIl(long j, int i, int i2, boolean z, boolean z2, int i3, float f, float f2, float f3, float f4, ByteBuffer byteBuffer, int i4, int i5, ByteBuffer byteBuffer2, int i6, int i7, ByteBuffer byteBuffer3, int i8, int i9);

    public final void IlIllIlIIl(boolean z) {
        this.llIIIlllll = z;
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public double IllIIIIllI() {
        if (this.IIlIIIllIl < 0.0d) {
            long j = this.llIIlIIlll;
            if (j == 0) {
                throw new IllegalStateException("Prior calling getFrameQuality make sure you have initialized native part of frame");
            }
            this.IIlIIIllIl = IlIllIlIIl(j);
        }
        return this.IIlIIIllIl;
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public void IllIIIllII() {
        this.IlIllIlIIl.llIIlIlIIl(this);
    }

    protected abstract void IllIIIllII(long j);

    protected void finalize() throws Throwable {
        Log.m2713v(this, "Disposing frame ID: {}", Long.valueOf(this.lllIIIlIlI));
        IllIIIllII(this.llIIlIIlll);
        this.llIIlIIlll = 0L;
        super.finalize();
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public long lIlIIIIlIl() {
        return this.lllIIIlIlI;
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public void llIIIlllll() {
        this.llIIlIlIIl = null;
        this.IllIIIllII = null;
        this.lIlIIIIlIl = null;
        this.lIIIIIllll = null;
        this.IIlIIIllIl = -1.0d;
    }

    protected abstract long llIIlIlIIl(long j, int i, int i2, boolean z, boolean z2, int i3, float f, float f2, float f3, float f4, ByteBuffer byteBuffer, int i4, int i5, ByteBuffer byteBuffer2, int i6, int i7, ByteBuffer byteBuffer3, int i8, int i9);

    public void llIIlIlIIl(Image image, llIIlIlIIl lliililiil) {
        this.llIIlIlIIl = image;
        this.IllIIIllII = lliililiil;
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public long IlIllIlIIl() {
        return this.llIIlIIlll;
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public void llIIlIlIIl() {
        Log.m2713v(this, "Finalizing frame ID: {}", Long.valueOf(this.lllIIIlIlI));
        Image image = this.llIIlIlIIl;
        if (image != null) {
            this.IllIIIllII.llIIlIlIIl(image);
            this.IllIIIllII = null;
        }
    }

    public void llIIIlllll(long j) {
        this.lllIIIlIlI = j;
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public void llIIlIlIIl(RectF rectF) {
        this.lIlIIIIlIl = rectF;
        IIlIIlIllI.llIIlIlIIl(rectF);
    }

    public final void llIIlIlIIl(boolean z) {
        this.IllIIIIllI = z;
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public void llIIlIlIIl(Orientation orientation) {
        this.lIIIIIllll = orientation;
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public boolean llIIlIlIIl(long j) {
        long j2 = this.llIIlIIlll;
        if (j2 != 0) {
            int width = this.llIIlIlIIl.getWidth();
            int height = this.llIIlIlIIl.getHeight();
            boolean z = this.llIIIlllll;
            boolean z2 = this.IllIIIIllI;
            int iIntValue = this.lIIIIIllll.intValue();
            RectF rectF = this.lIlIIIIlIl;
            IlIllIlIIl(j2, width, height, z, z2, iIntValue, rectF.left, rectF.top, rectF.width(), this.lIlIIIIlIl.height(), this.llIIlIlIIl.getPlanes()[0].getBuffer(), this.llIIlIlIIl.getPlanes()[0].getRowStride(), this.llIIlIlIIl.getPlanes()[0].getPixelStride(), this.llIIlIlIIl.getPlanes()[1].getBuffer(), this.llIIlIlIIl.getPlanes()[1].getRowStride(), this.llIIlIlIIl.getPlanes()[1].getPixelStride(), this.llIIlIlIIl.getPlanes()[2].getBuffer(), this.llIIlIlIIl.getPlanes()[2].getRowStride(), this.llIIlIlIIl.getPlanes()[2].getPixelStride());
            return true;
        }
        int width2 = this.llIIlIlIIl.getWidth();
        int height2 = this.llIIlIlIIl.getHeight();
        boolean z3 = this.llIIIlllll;
        boolean z4 = this.IllIIIIllI;
        int iIntValue2 = this.lIIIIIllll.intValue();
        RectF rectF2 = this.lIlIIIIlIl;
        long jLlIIlIlIIl = llIIlIlIIl(j, width2, height2, z3, z4, iIntValue2, rectF2.left, rectF2.top, rectF2.width(), this.lIlIIIIlIl.height(), this.llIIlIlIIl.getPlanes()[0].getBuffer(), this.llIIlIlIIl.getPlanes()[0].getRowStride(), this.llIIlIlIIl.getPlanes()[0].getPixelStride(), this.llIIlIlIIl.getPlanes()[1].getBuffer(), this.llIIlIlIIl.getPlanes()[1].getRowStride(), this.llIIlIlIIl.getPlanes()[1].getPixelStride(), this.llIIlIlIIl.getPlanes()[2].getBuffer(), this.llIIlIlIIl.getPlanes()[2].getRowStride(), this.llIIlIlIIl.getPlanes()[2].getPixelStride());
        this.llIIlIIlll = jLlIIlIlIIl;
        return jLlIIlIlIIl != 0;
    }
}
