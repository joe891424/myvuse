package com.microblink.fragment.overlay;

import android.app.Activity;
import com.microblink.fragment.RecognizerRunnerFragment;
import com.microblink.recognition.RecognitionSuccessType;
import com.microblink.view.recognition.ScanResultListener;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public interface ScanningOverlay extends ScanResultListener {
    void onFrameRecognitionDone(RecognitionSuccessType recognitionSuccessType);

    void onRecognizerRunnerFragmentAttached(RecognizerRunnerFragment recognizerRunnerFragment, Activity activity);

    void onRecognizerRunnerViewCreated(RecognizerRunnerFragment recognizerRunnerFragment);

    void pauseScanning();

    void resumeScanning();
}
