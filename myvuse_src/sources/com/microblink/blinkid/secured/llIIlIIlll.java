package com.microblink.blinkid.secured;

import android.graphics.RectF;
import com.microblink.util.Log;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public abstract class llIIlIIlll extends IllIIlIIII {
    private double IlIllIlllI;
    private lllllIlIll lllIIIlIlI;
    protected IlIlllllII lllIlIlIIl;

    public llIIlIIlll(int i, int i2, int i3, lllllIlIll lllllilill, IlIlllllII ilIlllllII) {
        super(i, i2, i3);
        this.IlIllIlllI = -1.0d;
        this.lllIlIlIIl = ilIlllllII;
        this.lllIIIlIlI = lllllilill;
    }

    public void IIlIIIllIl() {
        Log.m2713v(this, "Disposing frame ID: {}", Long.valueOf(this.lIIIIIllll));
        this.llIIlIlIIl = null;
        this.lIlIIIIlIl = null;
        this.IIlIIIllIl = null;
        llIIIlllll(this.llIIlIIlll);
        this.llIIlIIlll = 0L;
        this.lllIlIlIIl = null;
        this.lllIIIlIlI = null;
    }

    protected abstract void IlIllIlIIl(long j, int i, int i2, byte[] bArr, boolean z, boolean z2, int i3, float f, float f2, float f3, float f4);

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public double IllIIIIllI() {
        if (this.IlIllIlllI < 0.0d) {
            long j = this.llIIlIIlll;
            if (j == 0) {
                throw new IllegalStateException("Prior calling getFrameQuality make sure you have initialized native part of frame");
            }
            this.IlIllIlllI = IllIIIllII(j);
        }
        return this.IlIllIlllI;
    }

    protected abstract double IllIIIllII(long j);

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public void IllIIIllII() {
        lllllIlIll lllllilill = this.lllIIIlIlI;
        if (lllllilill != null) {
            lllllilill.llIIlIlIIl(this);
        }
    }

    @Override // com.microblink.blinkid.secured.IllIIlIIII, com.microblink.blinkid.secured.IIllIllIII
    public void llIIIlllll() {
        this.lIlIIIIlIl = null;
        this.IIlIIIllIl = null;
        this.IlIllIlllI = -1.0d;
    }

    protected abstract void llIIIlllll(long j);

    protected abstract long llIIlIlIIl(long j, int i, int i2, byte[] bArr, boolean z, boolean z2, int i3, float f, float f2, float f3, float f4);

    @Override // com.microblink.blinkid.secured.IllIIlIIII, com.microblink.blinkid.secured.IIllIllIII
    public void llIIlIlIIl() {
        Log.m2713v(this, "Finalizing frame ID: {}", Long.valueOf(this.lIIIIIllll));
        IlIlllllII ilIlllllII = this.lllIlIlIIl;
        if (ilIlllllII != null) {
            ilIlllllII.llIIlIlIIl(this);
        }
        super.llIIlIlIIl();
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public boolean llIIlIlIIl(long j) {
        long j2 = this.llIIlIIlll;
        if (j2 != 0) {
            int i = this.IlIllIlIIl;
            int i2 = this.IllIIIllII;
            byte[] bArr = this.llIIlIlIIl;
            boolean z = this.llIIIlllll;
            boolean z2 = this.IllIIIIllI;
            int iIntValue = this.IIlIIIllIl.intValue();
            RectF rectF = this.lIlIIIIlIl;
            IlIllIlIIl(j2, i, i2, bArr, z, z2, iIntValue, rectF.left, rectF.top, rectF.width(), this.lIlIIIIlIl.height());
            return true;
        }
        int i3 = this.IlIllIlIIl;
        int i4 = this.IllIIIllII;
        byte[] bArr2 = this.llIIlIlIIl;
        boolean z3 = this.llIIIlllll;
        boolean z4 = this.IllIIIIllI;
        int iIntValue2 = this.IIlIIIllIl.intValue();
        RectF rectF2 = this.lIlIIIIlIl;
        long jLlIIlIlIIl = llIIlIlIIl(j, i3, i4, bArr2, z3, z4, iIntValue2, rectF2.left, rectF2.top, rectF2.width(), this.lIlIIIIlIl.height());
        this.llIIlIIlll = jLlIIlIlIIl;
        return jLlIIlIlIIl != 0;
    }
}
