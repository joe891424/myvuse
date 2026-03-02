package com.microblink.blinkid.secured;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class llIIlIIIll implements Runnable {
    final /* synthetic */ IlIlllllII llIIlIlIIl;

    llIIlIIIll(IlIlllllII ilIlllllII) {
        this.llIIlIlIIl = ilIlllllII;
    }

    @Override // java.lang.Runnable
    public void run() {
        llIIlIlIIl lliililiil = this.llIIlIlIIl.IlIllIlIIl;
        if (lliililiil != null) {
            lliililiil.IllIIIllII();
        }
    }
}
