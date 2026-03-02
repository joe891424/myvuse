package com.microblink.recognition;

import com.microblink.blinkid.secured.IIIlIllllI;
import com.microblink.blinkid.secured.lIlIllIIlI;
import com.microblink.entities.recognizers.RecognizerBundle;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class FrameAnalyzers {
    private RecognizerBundle IlIllIlIIl;
    private long llIIlIlIIl;

    static {
        IIIlIllllI.IllIIIllII();
    }

    public FrameAnalyzers(RecognizerBundle recognizerBundle, double d) {
        this.llIIlIlIIl = 0L;
        this.IlIllIlIIl = null;
        IIIlIllllI.llIIlIlIIl();
        this.llIIlIlIIl = initializeNativeFrameSupport(NativeRecognizerWrapper.llIIlIlIIl(recognizerBundle.getRecognizers()), recognizerBundle.getFrameQualityEstimationMode().ordinal(), lIlIllIIlI.IlIllIlllI(), d);
        this.IlIllIlIIl = recognizerBundle;
    }

    private static native long initializeNativeFrameSupport(long[] jArr, int i, int i2, double d);

    private static native void terminateNativeFrameSupport(long j);

    private static native void updateNativeFrameSupport(long j, long[] jArr, int i, int i2);

    public long IlIllIlIIl() {
        return this.llIIlIlIIl;
    }

    public void llIIlIlIIl(RecognizerBundle recognizerBundle) {
        if (recognizerBundle.equals(this.IlIllIlIIl)) {
            return;
        }
        updateNativeFrameSupport(this.llIIlIlIIl, NativeRecognizerWrapper.llIIlIlIIl(recognizerBundle.getRecognizers()), recognizerBundle.getFrameQualityEstimationMode().ordinal(), lIlIllIIlI.IlIllIlllI());
        this.IlIllIlIIl = recognizerBundle;
    }

    public void llIIlIlIIl() {
        terminateNativeFrameSupport(this.llIIlIlIIl);
        this.IlIllIlIIl = null;
    }
}
