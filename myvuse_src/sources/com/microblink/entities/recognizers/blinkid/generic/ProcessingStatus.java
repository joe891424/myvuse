package com.microblink.entities.recognizers.blinkid.generic;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public enum ProcessingStatus {
    Success,
    DetectionFailed,
    ImagePreprocessingFailed,
    StabilityTestFailed,
    ScanningWrongSide,
    FieldIdentificationFailed,
    MandatoryFieldMissing,
    InvalidCharactersFound,
    ImageReturnFailed,
    BarcodeRecognitionFailed,
    MrzParsingFailed,
    ClassFiltered,
    UnsupportedClass,
    UnsupportedByLicense,
    AwaitingOtherSide,
    NotScanned
}
