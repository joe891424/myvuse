package com.microblink.fragment.overlay.components.feedback;

import android.view.View;
import com.microblink.metadata.MetadataCallbacks;
import com.microblink.metadata.detection.points.DisplayablePointsDetection;
import com.microblink.view.recognition.RecognizerRunnerView;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public interface RecognitionFeedbackHandler {
    public static final RecognitionFeedbackHandler EMPTY = new RecognitionFeedbackHandler() { // from class: com.microblink.fragment.overlay.components.feedback.RecognitionFeedbackHandler.1
        @Override // com.microblink.fragment.overlay.components.feedback.RecognitionFeedbackHandler
        public void clear() {
        }

        @Override // com.microblink.fragment.overlay.components.feedback.RecognitionFeedbackHandler
        public View createView(RecognizerRunnerView recognizerRunnerView, MetadataCallbacks metadataCallbacks) {
            return null;
        }

        @Override // com.microblink.fragment.overlay.components.feedback.RecognitionFeedbackHandler
        public void onOrientationChange(int i) {
        }

        @Override // com.microblink.fragment.overlay.components.feedback.RecognitionFeedbackHandler
        public void onPointsDetection(DisplayablePointsDetection displayablePointsDetection) {
        }
    };

    void clear();

    View createView(RecognizerRunnerView recognizerRunnerView, MetadataCallbacks metadataCallbacks);

    void onOrientationChange(int i);

    void onPointsDetection(DisplayablePointsDetection displayablePointsDetection);
}
