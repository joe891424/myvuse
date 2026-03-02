package com.microblink.entities.recognizers.blinkid.mrtd;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
final class MrzFilterCallback {
    MrzFilter IlIllIlIIl;
    private MrzResult llIIlIlIIl;

    MrzFilterCallback(MrzFilter mrzFilter, MrzResult mrzResult) {
        this.IlIllIlIIl = mrzFilter;
        this.llIIlIlIIl = mrzResult;
    }

    public boolean mrzFilter() {
        return this.IlIllIlIIl.mrzFilter(this.llIIlIlIIl);
    }
}
