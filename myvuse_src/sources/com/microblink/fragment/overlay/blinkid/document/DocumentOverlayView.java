package com.microblink.fragment.overlay.blinkid.document;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.microblink.blinkid.secured.llIIllllIl;
import com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView;
import com.microblink.fragment.overlay.blinkid.RetryDialogStrings;
import com.microblink.fragment.overlay.components.TorchController;
import com.microblink.library.C3714R;
import com.microblink.view.recognition.DetectionStatus;
import com.microblink.view.recognition.RecognizerRunnerView;
import com.microblink.view.viewfinder.quadview.QuadViewManagerFactory;
import com.microblink.view.viewfinder.quadview.QuadViewPreset;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class DocumentOverlayView implements BlinkIdOverlayView {
    private DocumentOverlayResources IlIllIlIIl;
    private DocumentOverlayStrings IllIIIllII;
    private ImageView llIIIlllll;
    private int llIIlIlIIl;

    public DocumentOverlayView(DocumentOverlayStrings documentOverlayStrings, int i) {
        this.llIIlIlIIl = i;
        this.IllIIIllII = documentOverlayStrings;
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void cleanup() {
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public ViewGroup createLayout(final Activity activity, RecognizerRunnerView recognizerRunnerView) {
        this.IlIllIlIIl = new DocumentOverlayResources(activity, this.llIIlIlIIl);
        if (this.IllIIIllII == null) {
            this.IllIIIllII = DocumentOverlayStrings.createDefault(activity);
        }
        ViewGroup viewGroup = (ViewGroup) activity.getLayoutInflater().inflate(llIIllllIl.IllIIIllII, (ViewGroup) recognizerRunnerView, false);
        this.llIIIlllll = (ImageView) viewGroup.findViewById(C3714R.id.defaultTorchButton);
        ImageView imageView = (ImageView) viewGroup.findViewById(C3714R.id.defaultBackButton);
        imageView.setImageDrawable(this.IlIllIlIIl.IllIIIIllI);
        imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.microblink.fragment.overlay.blinkid.document.DocumentOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                activity.onBackPressed();
            }
        });
        recognizerRunnerView.addChildView(viewGroup, true);
        QuadViewManagerFactory.createQuadViewFromPreset(recognizerRunnerView, QuadViewPreset.DEFAULT_FROM_DOCUMENT_SCAN_ACTIVITY);
        return viewGroup;
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public TorchController createTorchController(RecognizerRunnerView recognizerRunnerView) {
        TorchController torchController = new TorchController();
        ImageView imageView = this.llIIIlllll;
        DocumentOverlayResources documentOverlayResources = this.IlIllIlIIl;
        torchController.setup(imageView, recognizerRunnerView, documentOverlayResources.llIIIlllll, documentOverlayResources.IllIIIllII);
        return torchController;
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public RetryDialogStrings getDataMismatchStrings() {
        DocumentOverlayStrings documentOverlayStrings = this.IllIIIllII;
        return new RetryDialogStrings(documentOverlayStrings.IllIIIllII, documentOverlayStrings.llIIIlllll, documentOverlayStrings.lIIIIIllll);
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public RetryDialogStrings getDocumentNotSupportedDialogStrings() {
        DocumentOverlayStrings documentOverlayStrings = this.IllIIIllII;
        return new RetryDialogStrings(documentOverlayStrings.IllIIIIllI, documentOverlayStrings.lIlIIIIlIl, documentOverlayStrings.lIIIIIllll);
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public RetryDialogStrings getRecognitionTimeoutDialogStrings() {
        DocumentOverlayStrings documentOverlayStrings = this.IllIIIllII;
        return new RetryDialogStrings(documentOverlayStrings.llIIlIIlll, documentOverlayStrings.IIlIIIllIl, documentOverlayStrings.lIIIIIllll);
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public RetryDialogStrings getSidesNotMatchingDialogStrings() {
        DocumentOverlayStrings documentOverlayStrings = this.IllIIIllII;
        return new RetryDialogStrings(documentOverlayStrings.llIIlIlIIl, documentOverlayStrings.IlIllIlIIl, documentOverlayStrings.lIIIIIllll);
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void onCardDetectionUpdate(DetectionStatus detectionStatus) {
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void onConfigurationChanged(int i) {
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void onDocumentClassified() {
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void onErrorDialogShown() {
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void onFirstSideScanStarted() {
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void onGlare(boolean z) {
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void onMovingCloserToBarcodeRequired() {
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void onProcessingError(BlinkIdOverlayView.ProcessingError processingError) {
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public long onScanSuccess() {
        return 0L;
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void onSecondSideScanStarted() {
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void onTorchStateChanged(boolean z) {
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void setRecognizerSupportsClassification(boolean z) {
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void setShowBackSideBarcodeInstructions(boolean z) {
    }
}
