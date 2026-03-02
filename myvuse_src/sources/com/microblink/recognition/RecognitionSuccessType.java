package com.microblink.recognition;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public enum RecognitionSuccessType {
    UNSUCCESSFUL,
    PARTIAL,
    SUCCESSFUL,
    STAGE_SUCCESSFUL;

    public static RecognitionSuccessType fromNativeRecognitionState(int i) {
        return values()[i];
    }
}
