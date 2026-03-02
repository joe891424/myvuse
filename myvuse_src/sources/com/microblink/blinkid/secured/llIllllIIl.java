package com.microblink.blinkid.secured;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class llIllllIIl {
    private float IlIllIlIIl;
    private float IllIIIIllI;
    private float IllIIIllII;
    private float lIlIIIIlIl;
    private float llIIIlllll;
    private float llIIlIIlll;
    private float llIIlIlIIl;

    public llIllllIIl(float f, float f2) {
        this.llIIlIIlll = f / ((f2 * f) + f);
    }

    public float IlIllIlIIl() {
        return this.IlIllIlIIl;
    }

    public float IllIIIllII() {
        return this.IllIIIllII;
    }

    public float llIIlIlIIl() {
        return this.llIIlIlIIl;
    }

    public void llIIlIlIIl(float f, float f2, float f3) {
        float f4 = this.llIIlIIlll;
        float f5 = 1.0f - f4;
        float f6 = (this.llIIIlllll * f5) + (f * f4);
        this.llIIIlllll = f6;
        float f7 = (this.IllIIIIllI * f5) + (f2 * f4);
        this.IllIIIIllI = f7;
        float f8 = (f5 * this.lIlIIIIlIl) + (f4 * f3);
        this.lIlIIIIlIl = f8;
        this.llIIlIlIIl = f - f6;
        this.IlIllIlIIl = f2 - f7;
        this.IllIIIllII = f3 - f8;
    }

    public void llIIlIlIIl(float f) {
        this.llIIlIIlll = f / ((1.0f * f) + f);
    }
}
