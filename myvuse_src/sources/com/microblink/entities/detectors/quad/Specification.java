package com.microblink.entities.detectors.quad;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Specification {
    private boolean IlIllIlIIl;
    protected long llIIlIlIIl;

    protected Specification(long j, boolean z) {
        this.llIIlIlIIl = j;
        this.IlIllIlIIl = z;
    }

    private static native float nativeGetPhysicalHeightInInches(long j);

    protected void finalize() throws Throwable {
        super.finalize();
        long j = this.llIIlIlIIl;
        if (j == 0 || !this.IlIllIlIIl) {
            return;
        }
        llIIlIlIIl(j);
    }

    public float getPhysicalHeightInInches() {
        return nativeGetPhysicalHeightInInches(this.llIIlIlIIl);
    }

    protected abstract void llIIlIlIIl(long j);
}
