package com.microblink.blinkid.secured;

import android.os.Handler;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class lIIllIIIll implements IIIIIlIIII {
    private Handler llIIlIlIIl = new Handler();

    @Override // com.microblink.blinkid.secured.IIIIIlIIII
    public void llIIlIlIIl(Runnable runnable) {
        this.llIIlIlIIl.post(runnable);
    }

    @Override // com.microblink.blinkid.secured.IIIIIlIIII
    public void llIIlIlIIl(Runnable runnable, long j) {
        this.llIIlIlIIl.postDelayed(runnable, j);
    }

    @Override // com.microblink.blinkid.secured.IIIIIlIIII
    public Handler llIIlIlIIl() {
        return this.llIIlIlIIl;
    }
}
