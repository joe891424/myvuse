package com.microblink.blinkid.secured;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class lIllllIlll {
    private int IlIllIlIIl;
    private int llIIlIlIIl;

    public lIllllIlll(int i, int i2) {
        this.llIIlIlIIl = i;
        this.IlIllIlIIl = i2;
    }

    public int IlIllIlIIl() {
        return this.llIIlIlIIl;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof lIllllIlll)) {
            return false;
        }
        lIllllIlll lillllilll = (lIllllIlll) obj;
        return this.llIIlIlIIl == lillllilll.llIIlIlIIl && this.IlIllIlIIl == lillllilll.IlIllIlIIl;
    }

    public int hashCode() {
        return (this.llIIlIlIIl * 32713) + this.IlIllIlIIl;
    }

    public boolean llIIlIlIIl(int i, int i2) {
        return this.llIIlIlIIl == i && this.IlIllIlIIl == i2;
    }

    public int llIIlIlIIl() {
        return this.IlIllIlIIl;
    }
}
