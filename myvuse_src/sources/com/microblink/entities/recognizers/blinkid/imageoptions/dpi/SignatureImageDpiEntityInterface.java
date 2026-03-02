package com.microblink.entities.recognizers.blinkid.imageoptions.dpi;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class SignatureImageDpiEntityInterface implements SignatureImageDpiOptions {
    public static final String CLASS_NAME = "com.microblink.entities.recognizers.blinkid.imageoptions.dpi.SignatureImageDpiEntityInterface";

    private static native int signatureImageDpiNativeGet(long j);

    private static native void signatureImageDpiNativeSet(long j, int i);

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.dpi.SignatureImageDpiOptions
    public int getSignatureImageDpi() {
        return signatureImageDpiNativeGet(0L);
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.dpi.SignatureImageDpiOptions
    public void setSignatureImageDpi(int i) {
        DpiOptionsUtils.checkDpiRange(i);
        signatureImageDpiNativeSet(0L, i);
    }
}
