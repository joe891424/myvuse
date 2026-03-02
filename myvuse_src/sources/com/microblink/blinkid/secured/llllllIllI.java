package com.microblink.blinkid.secured;

import android.content.Context;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class llllllIllI implements Runnable {
    final /* synthetic */ llIlIIIIIl IlIllIlIIl;
    final /* synthetic */ Context llIIlIlIIl;

    llllllIllI(llIlIIIIIl lliliiiiil, Context context) {
        this.IlIllIlIIl = lliliiiiil;
        this.llIIlIlIIl = context;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        try {
            this.IlIllIlIIl.llIIlIlIIl(this.llIIlIlIIl, true);
        } catch (Exception unused) {
        }
    }
}
