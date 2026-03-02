package com.microblink.entities.recognizers.blinkid.generic;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class RecognitionModeFilterOptions {
    public static final String CLASS_NAME = "com.microblink.entities.recognizers.blinkid.generic.RecognitionModeFilterOptions";

    private static native boolean[] recognitionModeFilterNativeGet(long j);

    private static native void recognitionModeFilterNativeSet(long j, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6);

    public RecognitionModeFilter getRecognitionModeFilter() {
        boolean[] zArrRecognitionModeFilterNativeGet = recognitionModeFilterNativeGet(0L);
        return zArrRecognitionModeFilterNativeGet.length == 5 ? new RecognitionModeFilter(zArrRecognitionModeFilterNativeGet[0], zArrRecognitionModeFilterNativeGet[1], zArrRecognitionModeFilterNativeGet[2], zArrRecognitionModeFilterNativeGet[3], zArrRecognitionModeFilterNativeGet[4], zArrRecognitionModeFilterNativeGet[5]) : new RecognitionModeFilter();
    }

    public void setRecognitionModeFilter(RecognitionModeFilter recognitionModeFilter) {
        recognitionModeFilterNativeSet(0L, recognitionModeFilter.enableMrzId, recognitionModeFilter.enableMrzVisa, recognitionModeFilter.enableMrzPassport, recognitionModeFilter.enablePhotoId, recognitionModeFilter.enableBarcodeId, recognitionModeFilter.enableFullDocumentRecognition);
    }
}
