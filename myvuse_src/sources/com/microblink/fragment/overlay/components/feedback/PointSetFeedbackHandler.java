package com.microblink.fragment.overlay.components.feedback;

import android.content.Context;
import android.view.View;
import com.microblink.library.C3714R;
import com.microblink.metadata.MetadataCallbacks;
import com.microblink.metadata.detection.points.DisplayablePointsDetection;
import com.microblink.metadata.detection.points.PointsType;
import com.microblink.view.recognition.RecognizerRunnerView;
import com.microblink.view.viewfinder.points.PointSetView;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class PointSetFeedbackHandler implements RecognitionFeedbackHandler {
    private PointsType IlIllIlIIl;
    private PointSetView llIIlIlIIl;

    public PointSetFeedbackHandler(PointsType pointsType) {
        this.IlIllIlIIl = pointsType;
    }

    @Override // com.microblink.fragment.overlay.components.feedback.RecognitionFeedbackHandler
    public void clear() {
        this.llIIlIlIIl.clearDisplayedContent();
    }

    @Override // com.microblink.fragment.overlay.components.feedback.RecognitionFeedbackHandler
    public View createView(RecognizerRunnerView recognizerRunnerView, MetadataCallbacks metadataCallbacks) {
        Context context = recognizerRunnerView.getContext();
        if (this.IlIllIlIIl == PointsType.MRTD_DETECTION) {
            this.llIIlIlIIl = new PointSetView(context, null, recognizerRunnerView.getHostScreenOrientation(), 7, context.getResources().getColor(C3714R.color.mb_mrz_point_color));
        } else {
            this.llIIlIlIIl = new PointSetView(context, null, recognizerRunnerView.getHostScreenOrientation());
        }
        return this.llIIlIlIIl;
    }

    @Override // com.microblink.fragment.overlay.components.feedback.RecognitionFeedbackHandler
    public void onOrientationChange(int i) {
        this.llIIlIlIIl.setHostActivityOrientation(i);
    }

    @Override // com.microblink.fragment.overlay.components.feedback.RecognitionFeedbackHandler
    public void onPointsDetection(DisplayablePointsDetection displayablePointsDetection) {
        if (displayablePointsDetection.getPointsType() == this.IlIllIlIIl) {
            this.llIIlIlIIl.addDisplayablePointsDetection(displayablePointsDetection);
        }
    }
}
