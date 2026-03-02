package com.microblink.entities.recognizers.blinkid.imageoptions.extension;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class FullDocumentImageExtensionEntityInterface implements FullDocumentImageExtensionOptions {
    public static final String CLASS_NAME = "com.microblink.entities.recognizers.blinkid.imageoptions.extension.FullDocumentImageExtensionEntityInterface";

    private static native float[] fullDocumentImageExtensionFactorsNativeGet(long j);

    private static native void fullDocumentImageExtensionFactorsNativeSet(long j, float[] fArr);

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.extension.FullDocumentImageExtensionOptions
    public ImageExtensionFactors getFullDocumentImageExtensionFactors() {
        return ImageExtensionFactors.createFromArray(fullDocumentImageExtensionFactorsNativeGet(0L));
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.extension.FullDocumentImageExtensionOptions
    public void setFullDocumentImageExtensionFactors(ImageExtensionFactors imageExtensionFactors) {
        fullDocumentImageExtensionFactorsNativeSet(0L, imageExtensionFactors.serializeToArray());
    }
}
