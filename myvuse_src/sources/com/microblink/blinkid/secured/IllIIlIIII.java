package com.microblink.blinkid.secured;

import android.graphics.RectF;
import com.microblink.hardware.orientation.Orientation;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public abstract class IllIIlIIII implements IIllIllIII {
    protected Orientation IIlIIIllIl;
    protected int IlIllIlIIl;
    protected boolean IllIIIIllI;
    protected int IllIIIllII;
    protected long lIIIIIllll;
    protected RectF lIlIIIIlIl;
    protected boolean llIIIlllll;
    protected long llIIlIIlll = 0;
    protected byte[] llIIlIlIIl;

    protected IllIIlIIII(int i, int i2, int i3) {
        this.llIIlIlIIl = null;
        this.IlIllIlIIl = i;
        this.IllIIIllII = i2;
        if (i3 > 0) {
            this.llIIlIlIIl = new byte[i3];
        }
    }

    public final void IlIllIlIIl(boolean z) {
        this.llIIIlllll = z;
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public long lIlIIIIlIl() {
        return this.lIIIIIllll;
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public void llIIIlllll() {
        this.lIlIIIIlIl = null;
        this.IIlIIIllIl = null;
    }

    public byte[] llIIlIIlll() {
        return this.llIIlIlIIl;
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public final void llIIlIlIIl(RectF rectF) {
        this.lIlIIIIlIl = rectF;
        IIlIIlIllI.llIIlIlIIl(rectF);
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public long IlIllIlIIl() {
        return this.llIIlIIlll;
    }

    public void IlIllIlIIl(long j) {
        this.lIIIIIllll = j;
    }

    public final void llIIlIlIIl(byte[] bArr) {
        this.llIIlIlIIl = bArr;
    }

    public final void llIIlIlIIl(boolean z) {
        this.IllIIIIllI = z;
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public void llIIlIlIIl(Orientation orientation) {
        this.IIlIIIllIl = orientation;
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public void llIIlIlIIl() {
        this.lIlIIIIlIl = null;
        this.IIlIIIllIl = null;
    }
}
