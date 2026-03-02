package com.microblink.entities.recognizers.blinkid.imageoptions.dpi;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class FullDocumentImageDpiEntityInterface implements FullDocumentImageDpiOptions {
    public static final String CLASS_NAME = "com.microblink.entities.recognizers.blinkid.imageoptions.dpi.FullDocumentImageDpiEntityInterface";

    private static native int fullDocumentImageDpiNativeGet(long j);

    private static native void fullDocumentImageDpiNativeSet(long j, int i);

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.dpi.FullDocumentImageDpiOptions
    public int getFullDocumentImageDpi() {
        return fullDocumentImageDpiNativeGet(0L);
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.dpi.FullDocumentImageDpiOptions
    public void setFullDocumentImageDpi(int i) {
        DpiOptionsUtils.checkDpiRange(i);
        fullDocumentImageDpiNativeSet(0L, i);
    }
}
