package com.microblink.recognition.callback;

import com.microblink.blinkid.secured.IlIlIlllIl;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.geometry.Rectangle;
import com.microblink.metadata.MetadataCallbacks;
import com.microblink.metadata.ocr.DisplayableOcrResult;
import com.microblink.recognition.NativeRecognizerWrapper;
import com.microblink.results.ocr.OcrResult;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class RecognitionProcessCallback extends BaseRecognitionProcessCallback {
    public RecognitionProcessCallback(IlIlIlllIl ilIlIlllIl, MetadataCallbacks metadataCallbacks, Rectangle rectangle, RecognizerBundle.RecognitionDebugMode recognitionDebugMode) {
        super(ilIlIlllIl, rectangle, recognitionDebugMode);
        setMetadataCallbacks(metadataCallbacks);
    }

    private static native void nativeSetGlareCallback(long j, boolean z);

    private static native void nativeSetOcrCallback(long j, boolean z);

    public void onFirstSideResult() {
        NativeRecognizerWrapper nativeRecognizerWrapper = this.mNativeRecognizerWrapper;
        if (nativeRecognizerWrapper != null) {
            nativeRecognizerWrapper.llIIlIlIIl();
        }
        if (this.mMetadataCallbacks.getFirstSideRecognitionCallback() != null) {
            this.mMetadataCallbacks.getFirstSideRecognitionCallback().onFirstSideRecognitionFinished();
        }
    }

    public void onGlare(boolean z) {
        this.mMetadataCallbacks.getGlareCallback().onGlare(z);
    }

    public void onOcrResult(float[] fArr, String str, long j) {
        this.mMetadataCallbacks.getOcrCallback().onOcrResult(new DisplayableOcrResult(new OcrResult(j, (Object) null), str, fArr));
    }

    @Override // com.microblink.recognition.callback.BaseRecognitionProcessCallback
    public void setMetadataCallbacks(MetadataCallbacks metadataCallbacks) {
        super.setMetadataCallbacks(metadataCallbacks);
        nativeSetOcrCallback(this.mNativeContext, metadataCallbacks.getOcrCallback() != null);
        nativeSetGlareCallback(this.mNativeContext, metadataCallbacks.getGlareCallback() != null);
    }
}
