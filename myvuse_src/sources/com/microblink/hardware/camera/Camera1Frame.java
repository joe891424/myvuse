package com.microblink.hardware.camera;

import com.microblink.blinkid.secured.IlIlllllII;
import com.microblink.blinkid.secured.llIIlIIlll;
import com.microblink.blinkid.secured.lllllIlIll;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class Camera1Frame extends llIIlIIlll {
    public Camera1Frame(int i, int i2, int i3, lllllIlIll lllllilill, IlIlllllII ilIlllllII) {
        super(i, i2, i3, lllllilill, ilIlllllII);
    }

    private static native long initializeNativeCamera1Frame(long j, int i, int i2, byte[] bArr, boolean z, boolean z2, int i3, float f, float f2, float f3, float f4);

    private static native double nativeGetCamera1FrameQuality(long j);

    private static native void terminateNativeCamera1Frame(long j);

    private static native void updateNativeCamera1Frame(long j, int i, int i2, byte[] bArr, boolean z, boolean z2, int i3, float f, float f2, float f3, float f4);

    @Override // com.microblink.blinkid.secured.llIIlIIlll
    protected void IlIllIlIIl(long j, int i, int i2, byte[] bArr, boolean z, boolean z2, int i3, float f, float f2, float f3, float f4) {
        updateNativeCamera1Frame(j, i, i2, bArr, z, z2, i3, f, f2, f3, f4);
    }

    @Override // com.microblink.blinkid.secured.llIIlIIlll
    protected double IllIIIllII(long j) {
        return nativeGetCamera1FrameQuality(j);
    }

    @Override // com.microblink.blinkid.secured.llIIlIIlll
    protected void llIIIlllll(long j) {
        terminateNativeCamera1Frame(j);
    }

    @Override // com.microblink.blinkid.secured.llIIlIIlll
    protected long llIIlIlIIl(long j, int i, int i2, byte[] bArr, boolean z, boolean z2, int i3, float f, float f2, float f3, float f4) {
        return initializeNativeCamera1Frame(j, i, i2, bArr, z, z2, i3, f, f2, f3, f4);
    }
}
