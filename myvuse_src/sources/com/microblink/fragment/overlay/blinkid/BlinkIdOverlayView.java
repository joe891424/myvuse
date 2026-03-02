package com.microblink.fragment.overlay.blinkid;

import android.app.Activity;
import android.view.ViewGroup;
import com.microblink.fragment.overlay.components.TorchController;
import com.microblink.view.recognition.DetectionStatus;
import com.microblink.view.recognition.RecognizerRunnerView;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public interface BlinkIdOverlayView {

    /* JADX INFO: compiled from: line */
    public enum ProcessingError {
        MANDATORY_FIELD_MISSING
    }

    void cleanup();

    ViewGroup createLayout(Activity activity, RecognizerRunnerView recognizerRunnerView);

    TorchController createTorchController(RecognizerRunnerView recognizerRunnerView);

    RetryDialogStrings getDataMismatchStrings();

    RetryDialogStrings getDocumentNotSupportedDialogStrings();

    RetryDialogStrings getRecognitionTimeoutDialogStrings();

    RetryDialogStrings getSidesNotMatchingDialogStrings();

    void onCardDetectionUpdate(DetectionStatus detectionStatus);

    void onConfigurationChanged(int i);

    void onDocumentClassified();

    void onErrorDialogShown();

    void onFirstSideScanStarted();

    void onGlare(boolean z);

    void onMovingCloserToBarcodeRequired();

    void onProcessingError(ProcessingError processingError);

    long onScanSuccess();

    void onSecondSideScanStarted();

    void onTorchStateChanged(boolean z);

    void setRecognizerSupportsClassification(boolean z);

    void setShowBackSideBarcodeInstructions(boolean z);
}
