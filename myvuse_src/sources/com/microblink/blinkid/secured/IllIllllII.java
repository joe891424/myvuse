package com.microblink.blinkid.secured;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class IllIllllII {
    private lIIlIllIll IlIllIlIIl;
    private IIllIllIII[] IllIIIllII;
    private int llIIIlllll = -1;
    protected final int llIIlIlIIl;

    public IllIllllII(lIIlIllIll liilillill, int i) {
        this.IlIllIlIIl = liilillill;
        this.IllIIIllII = new IIllIllIII[i];
        this.llIIlIlIIl = i - 1;
    }

    public synchronized IIllIllIII llIIlIlIIl() {
        IIllIllIII iIllIllIIILlIIlIlIIl;
        int i = this.llIIIlllll;
        if (i == -1) {
            iIllIllIIILlIIlIlIIl = this.IlIllIlIIl.llIIlIlIIl();
        } else {
            IIllIllIII iIllIllIII = this.IllIIIllII[i];
            this.llIIIlllll = i - 1;
            iIllIllIIILlIIlIlIIl = iIllIllIII;
        }
        iIllIllIIILlIIlIlIIl.llIIIlllll();
        return iIllIllIIILlIIlIlIIl;
    }

    public synchronized void llIIlIlIIl(IIllIllIII iIllIllIII) {
        if (iIllIllIII != null) {
            iIllIllIII.llIIlIlIIl();
            int i = this.llIIIlllll;
            if (i < this.llIIlIlIIl) {
                int i2 = i + 1;
                this.llIIIlllll = i2;
                this.IllIIIllII[i2] = iIllIllIII;
            }
        }
    }
}
