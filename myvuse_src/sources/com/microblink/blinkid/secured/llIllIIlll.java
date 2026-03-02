package com.microblink.blinkid.secured;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class llIllIIlll extends IllIIlIIII {
    public llIllIIlll(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public static llIllIIlll llIIlIlIIl(int i, int i2, byte[] bArr) {
        llIllIIlll llilliilll = new llIllIIlll(i, i2, 0);
        llilliilll.llIIIlllll = true;
        llilliilll.IllIIIIllI = false;
        llilliilll.llIIlIlIIl = bArr;
        return llilliilll;
    }

    @Override // com.microblink.blinkid.secured.IllIIlIIII, com.microblink.blinkid.secured.IIllIllIII
    public long IlIllIlIIl() {
        throw new UnsupportedOperationException("JPEG frames do not have native part.");
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public double IllIIIIllI() {
        return -1.0d;
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public void IllIIIllII() {
        llIIlIlIIl();
    }

    @Override // com.microblink.blinkid.secured.IIllIllIII
    public boolean llIIlIlIIl(long j) {
        throw new UnsupportedOperationException("JPEG frames do not have native part.");
    }
}
