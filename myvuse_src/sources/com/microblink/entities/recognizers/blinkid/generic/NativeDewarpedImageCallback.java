package com.microblink.entities.recognizers.blinkid.generic;

import com.microblink.image.Image;
import com.microblink.image.ImageBuilder;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
final class NativeDewarpedImageCallback {
    DewarpedImageCallback llIIlIlIIl;

    NativeDewarpedImageCallback(DewarpedImageCallback dewarpedImageCallback) {
        this.llIIlIlIIl = dewarpedImageCallback;
    }

    void onImageAvailable(long j) {
        if (this.llIIlIlIIl != null) {
            Image imageBuildImageFromNativeContext = ImageBuilder.buildImageFromNativeContext(j, false, null);
            this.llIIlIlIIl.onImageAvailable(imageBuildImageFromNativeContext);
            imageBuildImageFromNativeContext.dispose();
        }
    }
}
