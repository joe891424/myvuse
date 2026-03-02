package com.microblink.blinkid.secured;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
enum llllIllllI {
    INSTANCE;

    private IIIIIlIIII llIIlIlIIl;

    llllIllllI() {
        lIIlIIlIll liiliilill = new lIIlIIlIll("Camera1");
        liiliilill.start();
        this.llIIlIlIIl = liiliilill;
    }

    public IIIIIlIIII llIIlIlIIl() {
        return this.llIIlIlIIl;
    }
}
