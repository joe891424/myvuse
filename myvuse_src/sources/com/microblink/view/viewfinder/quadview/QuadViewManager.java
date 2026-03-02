package com.microblink.view.viewfinder.quadview;

import android.content.res.Configuration;
import com.microblink.blinkid.secured.IllIIlIIIl;
import com.microblink.metadata.detection.quad.DisplayableQuadDetection;
import com.microblink.view.recognition.DetectionStatus;
import com.microblink.view.recognition.RecognizerRunnerView;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class QuadViewManager {
    protected IllIIlIIIl llIIlIlIIl;

    QuadViewManager(IllIIlIIIl illIIlIIIl) {
        this.llIIlIlIIl = illIIlIIIl;
    }

    public void animateQuadToDefaultPosition() {
        this.llIIlIlIIl.llIIlIlIIl(DetectionStatus.FAIL);
    }

    public void animateQuadToDetectionPosition(DisplayableQuadDetection displayableQuadDetection) {
        if (displayableQuadDetection.getDisplayLocation().isEmpty()) {
            this.llIIlIlIIl.llIIlIlIIl(displayableQuadDetection.getDetectionStatus());
        } else {
            this.llIIlIlIIl.llIIlIlIIl(displayableQuadDetection.getTransformedDisplayLocation(), displayableQuadDetection.getDetectionStatus());
        }
    }

    public void configurationChanged(RecognizerRunnerView recognizerRunnerView, Configuration configuration) {
        if (recognizerRunnerView.getContext().getResources().getConfiguration().orientation != configuration.orientation) {
            throw new IllegalStateException("You must first call changeConfiguration on recognizerView and then on QuadViewManager");
        }
        this.llIIlIlIIl.setHostActivityOrientation(recognizerRunnerView.getHostScreenOrientation());
    }

    public boolean isAnimationInProgress() {
        return this.llIIlIlIIl.llIIlIlIIl();
    }

    public void setAnimationDuration(long j) {
        this.llIIlIlIIl.setAnimationDuration(j);
    }

    public void setAnimationListener(QuadViewAnimationListener quadViewAnimationListener) {
        this.llIIlIlIIl.setAnimationListener(quadViewAnimationListener);
    }

    public void setInitialHostActivityOrientation(int i) {
        this.llIIlIlIIl.setHostActivityOrientation(i);
    }

    QuadViewManager() {
    }
}
