package com.microblink.entities.recognizers.blinkid.imageoptions.dpi;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class FaceImageDpiEntityInterface implements FaceImageDpiOptions {
    public static final String CLASS_NAME = "com.microblink.entities.recognizers.blinkid.imageoptions.dpi.FaceImageDpiEntityInterface";

    private static native int faceImageDpiNativeGet(long j);

    private static native void faceImageDpiNativeSet(long j, int i);

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.dpi.FaceImageDpiOptions
    public int getFaceImageDpi() {
        return faceImageDpiNativeGet(0L);
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.dpi.FaceImageDpiOptions
    public void setFaceImageDpi(int i) {
        DpiOptionsUtils.checkDpiRange(i);
        faceImageDpiNativeSet(0L, i);
    }
}
