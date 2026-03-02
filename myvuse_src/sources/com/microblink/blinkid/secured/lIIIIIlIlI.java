package com.microblink.blinkid.secured;

import com.microblink.blinkid.secured.lIlllIlIlI;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class lIIIIIlIlI implements lIlllIlIlI.llIIIlllll {
    final /* synthetic */ IlIlllllII llIIlIlIIl;

    /* JADX INFO: compiled from: line */
    class llIIlIlIIl implements Runnable {
        llIIlIlIIl() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IlIlllllII.lllIlIlIIl(lIIIIIlIlI.this.llIIlIlIIl);
        }
    }

    lIIIIIlIlI(IlIlllllII ilIlllllII) {
        this.llIIlIlIIl = ilIlllllII;
    }

    public void llIIlIlIIl() {
        this.llIIlIlIIl.lllllIlIll.llIIlIlIIl(new llIIlIlIIl());
    }
}
