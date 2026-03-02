package com.microblink.entities.recognizers.blinkid.generic;

import com.microblink.entities.recognizers.classifier.ClassifierCallback;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
final class NativeClassifierCallback {
    ClassifierCallback llIIlIlIIl;

    public NativeClassifierCallback(ClassifierCallback classifierCallback) {
        this.llIIlIlIIl = classifierCallback;
    }

    public void onDocumentSupportStatus(boolean z) {
        ClassifierCallback classifierCallback = this.llIIlIlIIl;
        if (classifierCallback != null) {
            classifierCallback.onDocumentSupportStatus(z);
        }
    }
}
