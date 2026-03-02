package com.microblink.blinkid.secured;

import com.microblink.hardware.camera.Camera2Frame;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class lIllIIlIIl {
    private IllIllllII llIIlIlIIl;

    /* JADX INFO: compiled from: line */
    class llIIlIlIIl implements lIIlIllIll {
        final /* synthetic */ lIIIlIIllI llIIlIlIIl;

        llIIlIlIIl(lIIIlIIllI liiiliilli) {
            this.llIIlIlIIl = liiiliilli;
        }

        @Override // com.microblink.blinkid.secured.lIIlIllIll
        public IIllIllIII llIIlIlIIl() {
            lIIIlIIllI liiiliilli = this.llIIlIlIIl;
            lIllIIlIIl lilliiliil = lIllIIlIIl.this;
            ((IlIIllIlII) liiiliilli).getClass();
            return new Camera2Frame(lilliiliil);
        }
    }

    public lIllIIlIIl(int i, lIIIlIIllI liiiliilli) {
        this.llIIlIlIIl = null;
        this.llIIlIlIIl = new IllIllllII(new llIIlIlIIl(liiiliilli), i);
    }

    public IIlIIIllIl llIIlIlIIl() {
        return (IIlIIIllIl) this.llIIlIlIIl.llIIlIlIIl();
    }

    public void llIIlIlIIl(IIlIIIllIl iIlIIIllIl) {
        this.llIIlIlIIl.llIIlIlIIl(iIlIIIllIl);
    }
}
