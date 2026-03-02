package com.microblink.recognition.callback;

import com.microblink.blinkid.secured.IIIlIllllI;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class NativeCancelDelegate {
    private boolean IlIllIlIIl = true;
    long llIIlIlIIl;

    static {
        IIIlIllllI.IllIIIllII();
    }

    public NativeCancelDelegate() {
        this.llIIlIlIIl = 0L;
        this.llIIlIlIIl = nativeConstruct();
    }

    private native long nativeConstruct();

    private static native void nativeDestruct(long j);

    private static native void nativeSetPaused(long j, boolean z);

    public boolean IlIllIlIIl() {
        return this.IlIllIlIIl;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        long j = this.llIIlIlIIl;
        if (j != 0) {
            nativeDestruct(j);
            this.llIIlIlIIl = 0L;
        }
    }

    public long llIIlIlIIl() {
        return this.llIIlIlIIl;
    }

    public void llIIlIlIIl(boolean z) {
        this.IlIllIlIIl = z;
        nativeSetPaused(this.llIIlIlIIl, z);
    }
}
