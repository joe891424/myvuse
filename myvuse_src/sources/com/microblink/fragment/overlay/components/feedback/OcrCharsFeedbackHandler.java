package com.microblink.fragment.overlay.components.feedback;

import android.view.View;
import com.microblink.metadata.MetadataCallbacks;
import com.microblink.metadata.detection.points.DisplayablePointsDetection;
import com.microblink.metadata.ocr.DisplayableOcrResult;
import com.microblink.metadata.ocr.OcrCallback;
import com.microblink.view.ocrResult.OcrResultCharsView;
import com.microblink.view.recognition.RecognizerRunnerView;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class OcrCharsFeedbackHandler implements RecognitionFeedbackHandler {
    private OcrResultCharsView llIIlIlIIl;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void llIIlIlIIl(DisplayableOcrResult displayableOcrResult) {
        this.llIIlIlIIl.addOcrResult(displayableOcrResult);
    }

    @Override // com.microblink.fragment.overlay.components.feedback.RecognitionFeedbackHandler
    public void clear() {
        this.llIIlIlIIl.clearDisplayedContent();
    }

    @Override // com.microblink.fragment.overlay.components.feedback.RecognitionFeedbackHandler
    public View createView(RecognizerRunnerView recognizerRunnerView, MetadataCallbacks metadataCallbacks) {
        this.llIIlIlIIl = new OcrResultCharsView(recognizerRunnerView.getContext(), null, recognizerRunnerView.getHostScreenOrientation());
        metadataCallbacks.setOcrCallback(new OcrCallback() { // from class: com.microblink.fragment.overlay.components.feedback.OcrCharsFeedbackHandler$$ExternalSyntheticLambda0
            @Override // com.microblink.metadata.ocr.OcrCallback
            public final void onOcrResult(DisplayableOcrResult displayableOcrResult) {
                this.f$0.llIIlIlIIl(displayableOcrResult);
            }
        });
        return this.llIIlIlIIl;
    }

    @Override // com.microblink.fragment.overlay.components.feedback.RecognitionFeedbackHandler
    public void onOrientationChange(int i) {
        this.llIIlIlIIl.setHostActivityOrientation(i);
    }

    @Override // com.microblink.fragment.overlay.components.feedback.RecognitionFeedbackHandler
    public void onPointsDetection(DisplayablePointsDetection displayablePointsDetection) {
    }
}
