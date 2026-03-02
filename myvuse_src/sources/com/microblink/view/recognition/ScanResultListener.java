package com.microblink.view.recognition;

import com.microblink.recognition.RecognitionSuccessType;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public interface ScanResultListener {
    void onScanningDone(RecognitionSuccessType recognitionSuccessType);

    void onUnrecoverableError(Throwable th);
}
