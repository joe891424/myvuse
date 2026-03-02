package com.microblink.blinkid.secured;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
enum IIIllIIlIl {
    INSTANCE;

    private IIIIIlIIII IlIllIlIIl;
    private IIIIIlIIII llIIlIlIIl;

    IIIllIIlIl() {
        lIIlIIlIll liiliilill = new lIIlIIlIll("BaseCamera2Frame");
        liiliilill.start();
        this.llIIlIlIIl = liiliilill;
        lIIlIIlIll liiliilill2 = new lIIlIIlIll("Camera2FullResFrame");
        liiliilill2.start();
        this.IlIllIlIIl = liiliilill2;
    }

    public IIIIIlIIII IlIllIlIIl() {
        return this.IlIllIlIIl;
    }

    IIIIIlIIII llIIlIlIIl() {
        return this.llIIlIlIIl;
    }
}
