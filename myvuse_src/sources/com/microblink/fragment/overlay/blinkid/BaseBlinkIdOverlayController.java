package com.microblink.fragment.overlay.blinkid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import com.microblink.entities.recognizers.HighResImagesBundle;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.entities.recognizers.blinkid.ProcessingStatusResult;
import com.microblink.entities.recognizers.blinkid.generic.BarcodeScanningStartedCallback;
import com.microblink.entities.recognizers.blinkid.generic.BarcodeScanningStartedCallbackOptions;
import com.microblink.entities.recognizers.blinkid.generic.ProcessingStatus;
import com.microblink.entities.recognizers.classifier.ClassifierCallback;
import com.microblink.entities.recognizers.classifier.ClassifierCallbackOptions;
import com.microblink.fragment.RecognizerRunnerFragment;
import com.microblink.fragment.overlay.BaseOverlayController;
import com.microblink.fragment.overlay.DocumentRecognizerManager;
import com.microblink.fragment.overlay.DocumentSide;
import com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView;
import com.microblink.fragment.overlay.components.TorchController;
import com.microblink.fragment.overlay.components.debug.DebugViewHandler;
import com.microblink.fragment.overlay.components.feedback.PointSetFeedbackHandler;
import com.microblink.fragment.overlay.components.feedback.RecognitionFeedbackHandler;
import com.microblink.fragment.overlay.components.feedback.RecognitionFeedbackHandlerFactory;
import com.microblink.fragment.overlay.verification.OverlayTorchStateListener;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.image.highres.HighResImageWrapper;
import com.microblink.metadata.MetadataCallbacks;
import com.microblink.metadata.detection.FailedDetectionCallback;
import com.microblink.metadata.detection.points.DisplayablePointsDetection;
import com.microblink.metadata.detection.points.PointsDetectionCallback;
import com.microblink.metadata.detection.points.PointsType;
import com.microblink.metadata.detection.quad.DisplayableQuadDetection;
import com.microblink.metadata.detection.quad.QuadDetectionCallback;
import com.microblink.metadata.glare.GlareCallback;
import com.microblink.metadata.recognition.FirstSideRecognitionCallback;
import com.microblink.recognition.RecognitionSuccessType;
import com.microblink.view.OrientationAllowedListener;
import com.microblink.view.recognition.HighResImageListener;
import com.microblink.view.recognition.RecognizerRunnerView;
import com.microblink.view.recognition.ScanResultListener;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseBlinkIdOverlayController extends BaseOverlayController {
    private final InternalBlinkIdRecognizerCallbacks IlIIlIIIII;
    protected final DocumentRecognizerManager IlIIlllIIl;
    private final BlinkIdOverlaySettings IlIllIlllI;
    private DocumentSide IlIlllllII;
    private final ProcessingStatusHandler IllIIlIIII;
    private int lIIIIIlIlI;
    private final FirstSideRecognitionCallback lIllIIlIIl;
    protected ImageUploadManager lIlllIlIlI;
    private final HighResImagesBundle llIIlIIIll;
    private final RecognitionFeedbackHandler llIllIIlll;
    private final Runnable lllIIlIIlI;
    private final BlinkIdOverlayView lllIlIlIIl;
    private final RecognitionFeedbackHandler lllllIlIll;

    /* JADX INFO: renamed from: com.microblink.fragment.overlay.blinkid.BaseBlinkIdOverlayController$4 */
    /* JADX INFO: compiled from: line */
    class RunnableC36604 implements Runnable {
        final /* synthetic */ RecognitionSuccessType llIIlIlIIl;

        RunnableC36604(RecognitionSuccessType recognitionSuccessType) {
            this.llIIlIlIIl = recognitionSuccessType;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((BaseOverlayController) BaseBlinkIdOverlayController.this).llIIlIlIIl.onScanningDone(this.llIIlIlIIl);
            BaseBlinkIdOverlayController baseBlinkIdOverlayController = BaseBlinkIdOverlayController.this;
            baseBlinkIdOverlayController.lIlllIlIlI.uploadImages(baseBlinkIdOverlayController.getContext(), BaseBlinkIdOverlayController.this.getRecognizerBundle());
            BaseBlinkIdOverlayController.this.resumeScanning();
            if (((BaseOverlayController) BaseBlinkIdOverlayController.this).IllIIIllII.getActivity().isFinishing()) {
                return;
            }
            BaseBlinkIdOverlayController.this.IlIllIlIIl(100L);
        }
    }

    /* JADX INFO: compiled from: line */
    interface BlinkIdRecognizerCallbacks {
        void onBarcodeScanningStarted();

        void onDocumentSupportStatus(boolean z);
    }

    /* JADX INFO: compiled from: line */
    static class InternalBlinkIdRecognizerCallbacks implements ClassifierCallback, BarcodeScanningStartedCallback {
        public static final Parcelable.Creator<InternalBlinkIdRecognizerCallbacks> CREATOR = new Parcelable.Creator<InternalBlinkIdRecognizerCallbacks>() { // from class: com.microblink.fragment.overlay.blinkid.BaseBlinkIdOverlayController.InternalBlinkIdRecognizerCallbacks.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public InternalBlinkIdRecognizerCallbacks createFromParcel(Parcel parcel) {
                return new InternalBlinkIdRecognizerCallbacks(null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public InternalBlinkIdRecognizerCallbacks[] newArray(int i) {
                return new InternalBlinkIdRecognizerCallbacks[i];
            }
        };
        private final BlinkIdRecognizerCallbacks llIIlIlIIl;

        InternalBlinkIdRecognizerCallbacks(BlinkIdRecognizerCallbacks blinkIdRecognizerCallbacks) {
            this.llIIlIlIIl = blinkIdRecognizerCallbacks;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.microblink.entities.recognizers.blinkid.generic.BarcodeScanningStartedCallback
        public void onBarcodeScanningStarted() {
            BlinkIdRecognizerCallbacks blinkIdRecognizerCallbacks = this.llIIlIlIIl;
            if (blinkIdRecognizerCallbacks != null) {
                blinkIdRecognizerCallbacks.onBarcodeScanningStarted();
            }
        }

        @Override // com.microblink.entities.recognizers.classifier.ClassifierCallback
        public void onDocumentSupportStatus(boolean z) {
            BlinkIdRecognizerCallbacks blinkIdRecognizerCallbacks = this.llIIlIlIIl;
            if (blinkIdRecognizerCallbacks != null) {
                blinkIdRecognizerCallbacks.onDocumentSupportStatus(z);
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
        }
    }

    /* JADX INFO: compiled from: line */
    private static class ProcessingStatusHandler {
        private int IlIllIlIIl = 0;
        BlinkIdOverlayView llIIlIlIIl;

        ProcessingStatusHandler(BlinkIdOverlayView blinkIdOverlayView) {
            this.llIIlIlIIl = blinkIdOverlayView;
        }

        void llIIlIlIIl(ProcessingStatus processingStatus) {
            if (processingStatus != ProcessingStatus.MandatoryFieldMissing) {
                this.IlIllIlIIl = 0;
                return;
            }
            int i = this.IlIllIlIIl + 1;
            this.IlIllIlIIl = i;
            if (i >= 3) {
                this.llIIlIlIIl.onProcessingError(BlinkIdOverlayView.ProcessingError.MANDATORY_FIELD_MISSING);
                this.IlIllIlIIl = 0;
            }
        }
    }

    public BaseBlinkIdOverlayController(BlinkIdOverlaySettings blinkIdOverlaySettings, ScanResultListener scanResultListener, BlinkIdOverlayView blinkIdOverlayView) {
        super(scanResultListener);
        this.lIIIIIlIlI = 0;
        this.IlIlllllII = DocumentSide.FIRST_SIDE;
        this.llIIlIIIll = new HighResImagesBundle();
        DocumentRecognizerManager documentRecognizerManager = new DocumentRecognizerManager();
        this.IlIIlllIIl = documentRecognizerManager;
        this.lIllIIlIIl = new FirstSideRecognitionCallback() { // from class: com.microblink.fragment.overlay.blinkid.BaseBlinkIdOverlayController.12
            @Override // com.microblink.metadata.recognition.FirstSideRecognitionCallback
            public void onFirstSideRecognitionFinished() {
                ((BaseOverlayController) BaseBlinkIdOverlayController.this).llIIIlllll.pauseScanning();
                if (BaseBlinkIdOverlayController.this.IlIllIlllI.lIIIIIllll()) {
                    ((BaseOverlayController) BaseBlinkIdOverlayController.this).llIIIlllll.captureHighResImage(new HighResImageListener() { // from class: com.microblink.fragment.overlay.blinkid.BaseBlinkIdOverlayController.12.1
                        @Override // com.microblink.view.recognition.HighResImageListener
                        public void onHighResImageAvailable(HighResImageWrapper highResImageWrapper) {
                            BaseBlinkIdOverlayController.this.llIIlIIIll.addImage(highResImageWrapper);
                            llIIlIlIIl();
                        }
                    });
                } else {
                    llIIlIlIIl();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void llIIlIlIIl() {
                ((BaseOverlayController) BaseBlinkIdOverlayController.this).llIIlIIlll.play();
                BaseBlinkIdOverlayController.this.IlIlllllII = DocumentSide.SECOND_SIDE;
                RecognizerRunnerView recognizerRunnerView = ((BaseOverlayController) BaseBlinkIdOverlayController.this).llIIIlllll;
                BaseBlinkIdOverlayController baseBlinkIdOverlayController = BaseBlinkIdOverlayController.this;
                recognizerRunnerView.reconfigureRecognizers(baseBlinkIdOverlayController.IlIIlllIIl.buildRecognizerBundle(baseBlinkIdOverlayController.IlIlllllII));
                BaseBlinkIdOverlayController.this.lIIIIIllll();
                BaseBlinkIdOverlayController.this.llIIlIlIIl(0L);
                ((BaseOverlayController) BaseBlinkIdOverlayController.this).llIIIlllll.resumeScanning(false);
                BaseBlinkIdOverlayController.this.lllIlIlIIl();
            }
        };
        this.lllIIlIIlI = new Runnable() { // from class: com.microblink.fragment.overlay.blinkid.BaseBlinkIdOverlayController.13
            @Override // java.lang.Runnable
            public void run() {
                BaseBlinkIdOverlayController.this.pauseScanning();
                BaseBlinkIdOverlayController.lIIIIIllll(BaseBlinkIdOverlayController.this);
                BaseBlinkIdOverlayController baseBlinkIdOverlayController = BaseBlinkIdOverlayController.this;
                baseBlinkIdOverlayController.lIlllIlIlI.uploadImages(baseBlinkIdOverlayController.getContext(), BaseBlinkIdOverlayController.this.getRecognizerBundle());
            }
        };
        this.IlIIlIIIII = new InternalBlinkIdRecognizerCallbacks(new BlinkIdRecognizerCallbacks() { // from class: com.microblink.fragment.overlay.blinkid.BaseBlinkIdOverlayController.14
            @Override // com.microblink.fragment.overlay.blinkid.BaseBlinkIdOverlayController.BlinkIdRecognizerCallbacks
            public void onBarcodeScanningStarted() {
                BaseBlinkIdOverlayController.this.lllIlIlIIl.onMovingCloserToBarcodeRequired();
            }

            @Override // com.microblink.fragment.overlay.blinkid.BaseBlinkIdOverlayController.BlinkIdRecognizerCallbacks
            public void onDocumentSupportStatus(boolean z) {
                if (z) {
                    BaseBlinkIdOverlayController.this.lllIlIlIIl.onDocumentClassified();
                    BaseBlinkIdOverlayController.this.lIIIIIlIlI = 0;
                } else {
                    BaseBlinkIdOverlayController.IlIllIlllI(BaseBlinkIdOverlayController.this);
                }
                if (BaseBlinkIdOverlayController.this.lIIIIIlIlI < 3 || !BaseBlinkIdOverlayController.this.IlIllIlllI.lllIlIlIIl()) {
                    return;
                }
                BaseBlinkIdOverlayController.this.pauseScanning();
                BaseBlinkIdOverlayController.this.lllIlIlIIl.onErrorDialogShown();
                BaseBlinkIdOverlayController baseBlinkIdOverlayController = BaseBlinkIdOverlayController.this;
                baseBlinkIdOverlayController.llIIlIlIIl(baseBlinkIdOverlayController.lllIlIlIIl.getDocumentNotSupportedDialogStrings());
                BaseBlinkIdOverlayController.this.lIIIIIlIlI = 0;
            }
        });
        this.lllIlIlIIl = blinkIdOverlayView;
        this.IlIllIlllI = blinkIdOverlaySettings;
        this.lIlllIlIlI = lllIIIlIlI();
        documentRecognizerManager.setup(getRecognizerBundle(), blinkIdOverlaySettings.llIIIlllll());
        this.llIllIIlll = RecognitionFeedbackHandlerFactory.create(blinkIdOverlaySettings.lIlIIIIlIl());
        this.IllIIlIIII = new ProcessingStatusHandler(blinkIdOverlayView);
        if (blinkIdOverlaySettings.IlIllIlllI()) {
            this.lllllIlIll = new PointSetFeedbackHandler(PointsType.MRTD_DETECTION);
        } else {
            this.lllllIlIll = RecognitionFeedbackHandler.EMPTY;
        }
        this.lIlllIlIlI.setupUploadManager(llIIlIlIIl(getRecognizerBundle()));
    }

    static /* synthetic */ int IlIllIlllI(BaseBlinkIdOverlayController baseBlinkIdOverlayController) {
        int i = baseBlinkIdOverlayController.lIIIIIlIlI;
        baseBlinkIdOverlayController.lIIIIIlIlI = i + 1;
        return i;
    }

    static void lIIIIIllll(BaseBlinkIdOverlayController baseBlinkIdOverlayController) {
        baseBlinkIdOverlayController.lllIlIlIIl.onErrorDialogShown();
        baseBlinkIdOverlayController.llIIlIlIIl(baseBlinkIdOverlayController.lllIlIlIIl.getRecognitionTimeoutDialogStrings());
    }

    @Override // com.microblink.fragment.overlay.BaseOverlayController
    protected void IllIIIllII() {
    }

    public HighResImagesBundle getHighResImagesBundle() {
        return this.llIIlIIIll;
    }

    public RecognizerBundle getRecognizerBundle() {
        return this.IlIllIlllI.getRecognizerBundle();
    }

    protected abstract ImageUploadManager lllIIIlIlI();

    @Override // com.microblink.fragment.overlay.BaseOverlayController, com.microblink.fragment.overlay.ScanningOverlay
    public void onFrameRecognitionDone(RecognitionSuccessType recognitionSuccessType) {
        for (Recognizer<?> recognizer : llIIlIlIIl(this.llIIIlllll.getRecognizerBundle())) {
            Parcelable parcelable = (Recognizer.Result) recognizer.getResult();
            if (parcelable instanceof ProcessingStatusResult) {
                this.IllIIlIIII.llIIlIlIIl(((ProcessingStatusResult) parcelable).getProcessingStatus());
            }
        }
    }

    @Override // com.microblink.fragment.overlay.BaseOverlayController, com.microblink.fragment.overlay.ScanningOverlay
    public void onRecognizerRunnerViewCreated(RecognizerRunnerFragment recognizerRunnerFragment) {
        super.onRecognizerRunnerViewCreated(recognizerRunnerFragment);
        boolean z = false;
        for (Object obj : llIIlIlIIl(getRecognizerBundle())) {
            if (obj instanceof ClassifierCallbackOptions) {
                ((ClassifierCallbackOptions) obj).setClassifierCallback(this.IlIIlIIIII);
                z = true;
            }
            if (obj instanceof BarcodeScanningStartedCallbackOptions) {
                ((BarcodeScanningStartedCallbackOptions) obj).setBarcodeScanningStartedCallback(this.IlIIlIIIII);
            }
        }
        this.lllIlIlIIl.setRecognizerSupportsClassification(z);
        this.llIIIlllll.setRecognizerBundle(this.IlIIlllIIl.buildRecognizerBundle(this.IlIlllllII));
        this.llIIIlllll.setHighResFrameCaptureEnabled(this.IlIllIlllI.lIIIIIllll());
        this.IlIllIlllI.IllIIIllII().apply(this.llIIIlllll);
        MetadataCallbacks metadataCallbacks = new MetadataCallbacks();
        metadataCallbacks.setFailedDetectionCallback(new FailedDetectionCallback() { // from class: com.microblink.fragment.overlay.blinkid.BaseBlinkIdOverlayController.6
            @Override // com.microblink.metadata.detection.FailedDetectionCallback
            public void onDetectionFailed() {
                BaseBlinkIdOverlayController.this.lIIIIIllll();
            }
        });
        metadataCallbacks.setPointsDetectionCallback(new PointsDetectionCallback() { // from class: com.microblink.fragment.overlay.blinkid.BaseBlinkIdOverlayController.7
            @Override // com.microblink.metadata.detection.points.PointsDetectionCallback
            public void onPointsDetection(DisplayablePointsDetection displayablePointsDetection) {
                BaseBlinkIdOverlayController.this.llIllIIlll.onPointsDetection(displayablePointsDetection);
                BaseBlinkIdOverlayController.this.lllllIlIll.onPointsDetection(displayablePointsDetection);
            }
        });
        metadataCallbacks.setFirstSideRecognitionCallback(this.lIllIIlIIl);
        metadataCallbacks.setDebugImageCallback(this.IlIllIlllI.IllIIIIllI());
        metadataCallbacks.setQuadDetectionCallback(new QuadDetectionCallback() { // from class: com.microblink.fragment.overlay.blinkid.BaseBlinkIdOverlayController.8
            @Override // com.microblink.metadata.detection.quad.QuadDetectionCallback
            public void onQuadDetection(DisplayableQuadDetection displayableQuadDetection) {
                BaseBlinkIdOverlayController.this.lllIlIlIIl.onCardDetectionUpdate(displayableQuadDetection.getDetectionStatus());
            }
        });
        metadataCallbacks.setGlareCallback(new GlareCallback() { // from class: com.microblink.fragment.overlay.blinkid.BaseBlinkIdOverlayController.9
            @Override // com.microblink.metadata.glare.GlareCallback
            public void onGlare(boolean z2) {
                BaseBlinkIdOverlayController.this.lllIlIlIIl.onGlare(z2);
            }
        });
        View viewCreateView = this.lllllIlIll.createView(this.llIIIlllll, metadataCallbacks);
        if (viewCreateView != null) {
            this.llIIIlllll.addChildView(viewCreateView, false);
        }
        View viewCreateView2 = this.llIllIIlll.createView(this.llIIIlllll, metadataCallbacks);
        if (viewCreateView2 != null) {
            this.llIIIlllll.addChildView(viewCreateView2, false);
        }
        final boolean zIsInMultiWindowMode = recognizerRunnerFragment.getActivity().isInMultiWindowMode();
        this.llIIIlllll.setMetadataCallbacks(metadataCallbacks);
        this.llIIIlllll.setOrientationAllowedListener(new OrientationAllowedListener() { // from class: com.microblink.fragment.overlay.blinkid.BaseBlinkIdOverlayController.2
            @Override // com.microblink.view.OrientationAllowedListener
            public boolean isOrientationAllowed(Orientation orientation) {
                return zIsInMultiWindowMode || !BaseBlinkIdOverlayController.this.IlIllIlllI.lllIIIlIlI() || orientation == Orientation.ORIENTATION_PORTRAIT || orientation == Orientation.ORIENTATION_PORTRAIT_UPSIDE;
            }
        });
        ViewGroup viewGroupCreateLayout = this.lllIlIlIIl.createLayout(recognizerRunnerFragment.getActivity(), this.llIIIlllll);
        if (this.IlIIlllIIl.getRecognitionDebugMode() != RecognizerBundle.RecognitionDebugMode.RECOGNITION) {
            new DebugViewHandler().initialize(recognizerRunnerFragment.getActivity(), viewGroupCreateLayout, metadataCallbacks);
        }
        TorchController torchControllerCreateTorchController = this.lllIlIlIIl.createTorchController(this.llIIIlllll);
        this.IIlIIIllIl = torchControllerCreateTorchController;
        torchControllerCreateTorchController.setTorchStateListener(new OverlayTorchStateListener() { // from class: com.microblink.fragment.overlay.blinkid.BaseBlinkIdOverlayController.3
            @Override // com.microblink.fragment.overlay.verification.OverlayTorchStateListener
            public void onTorchStateChanged(boolean z2) {
                BaseBlinkIdOverlayController.this.lllIlIlIIl.onTorchStateChanged(z2);
            }

            @Override // com.microblink.fragment.overlay.verification.OverlayTorchStateListener
            public void onTorchStateInitialised(boolean z2) {
            }
        });
    }

    @Override // com.microblink.view.recognition.ScanResultListener
    public void onScanningDone(RecognitionSuccessType recognitionSuccessType) {
        if (recognitionSuccessType == RecognitionSuccessType.UNSUCCESSFUL) {
            return;
        }
        pauseScanning();
        this.llIIlIIlll.play();
        if (!this.IlIllIlllI.IIlIIIllIl() || !this.IlIIlllIIl.hasInvalidDocumentDataMatch()) {
            if (this.IlIllIlllI.lIIIIIllll()) {
                this.llIIIlllll.captureHighResImage(new HighResImageListener() { // from class: com.microblink.fragment.overlay.blinkid.BaseBlinkIdOverlayController.1
                    @Override // com.microblink.view.recognition.HighResImageListener
                    public void onHighResImageAvailable(HighResImageWrapper highResImageWrapper) {
                        BaseBlinkIdOverlayController.this.llIIlIIIll.addImage(highResImageWrapper);
                        BaseBlinkIdOverlayController baseBlinkIdOverlayController = BaseBlinkIdOverlayController.this;
                        BaseBlinkIdOverlayController.llIIlIlIIl(baseBlinkIdOverlayController, baseBlinkIdOverlayController.IlIIlllIIl.getScanSuccessType());
                    }
                });
                return;
            }
            RecognitionSuccessType scanSuccessType = this.IlIIlllIIl.getScanSuccessType();
            long jOnScanSuccess = this.lllIlIlIIl.onScanSuccess();
            IIlIIIllIl();
            this.IllIIIIllI.postDelayed(new RunnableC36604(scanSuccessType), jOnScanSuccess);
            return;
        }
        if (recognitionSuccessType == RecognitionSuccessType.PARTIAL || recognitionSuccessType == RecognitionSuccessType.STAGE_SUCCESSFUL) {
            this.lllIlIlIIl.onErrorDialogShown();
            llIIlIlIIl(this.lllIlIlIIl.getRecognitionTimeoutDialogStrings());
        } else if (recognitionSuccessType == RecognitionSuccessType.SUCCESSFUL) {
            this.lllIlIlIIl.onErrorDialogShown();
            if (this.IlIlllllII == DocumentSide.FIRST_SIDE) {
                llIIlIlIIl(this.lllIlIlIIl.getDataMismatchStrings());
            } else {
                llIIlIlIIl(this.lllIlIlIIl.getSidesNotMatchingDialogStrings());
            }
            IIlIIIllIl();
        }
        this.lIlllIlIlI.uploadImages(getContext(), getRecognizerBundle());
    }

    @Override // com.microblink.fragment.overlay.BaseOverlayController, com.microblink.fragment.overlay.ScanningOverlay
    public void pauseScanning() {
        super.pauseScanning();
        IIlIIIllIl();
    }

    @Override // com.microblink.fragment.overlay.BaseOverlayController, com.microblink.fragment.overlay.ScanningOverlay
    public void resumeScanning() {
        super.resumeScanning();
        RecognizerRunnerView recognizerRunnerView = this.llIIIlllll;
        if (recognizerRunnerView == null || recognizerRunnerView.isScanningPaused()) {
            return;
        }
        IllIIlIIII();
    }

    private void IIlIIIllIl() {
        this.IllIIIIllI.removeCallbacks(this.lllIIlIIlI);
    }

    private void IllIIlIIII() {
        if (this.IlIlllllII != DocumentSide.SECOND_SIDE || this.IlIllIlllI.llIIlIlIIl() == 0) {
            return;
        }
        this.IllIIIIllI.postDelayed(this.lllIIlIIlI, this.IlIllIlllI.llIIlIlIIl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lllIlIlIIl() {
        pauseScanning();
        this.lllIlIlIIl.setShowBackSideBarcodeInstructions(false);
        this.lllIlIlIIl.onSecondSideScanStarted();
        this.IllIIIIllI.postDelayed(new Runnable() { // from class: com.microblink.fragment.overlay.blinkid.BaseBlinkIdOverlayController.11
            @Override // java.lang.Runnable
            public void run() {
                BaseBlinkIdOverlayController.this.resumeScanning();
            }
        }, 1500L);
        IllIIlIIII();
    }

    @Override // com.microblink.fragment.overlay.BaseOverlayController
    protected int IlIllIlIIl() {
        return this.IlIllIlllI.llIIlIIlll();
    }

    protected void IlIllIlllI() {
        this.lllIlIlIIl.onFirstSideScanStarted();
    }

    @Override // com.microblink.fragment.overlay.BaseOverlayController
    protected void IllIIIIllI() {
        IIlIIIllIl();
    }

    @Override // com.microblink.fragment.overlay.BaseOverlayController
    protected void lIlIIIIlIl() {
        this.IlIIlllIIl.clearBundleState();
        this.llIIlIIIll.clearSavedState();
        lIIIIIllll();
        if (this.IlIlllllII == DocumentSide.SECOND_SIDE) {
            IlIllIlIIl(0L);
        } else {
            llIIlIlIIl(0L);
        }
    }

    @Override // com.microblink.fragment.overlay.BaseOverlayController
    protected void llIIIlllll() {
        this.lllIlIlIIl.cleanup();
    }

    @Override // com.microblink.fragment.overlay.BaseOverlayController
    protected boolean llIIlIIlll() {
        return this.IlIlllllII == DocumentSide.FIRST_SIDE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlIllIlIIl(long j) {
        this.IlIlllllII = DocumentSide.FIRST_SIDE;
        this.llIIlIIIll.clearImages();
        lIIIIIllll();
        this.llIIIlllll.reconfigureRecognizers(this.IlIIlllIIl.buildRecognizerBundle(this.IlIlllllII));
        llIIlIlIIl(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lIIIIIllll() {
        this.llIllIIlll.clear();
        this.lllllIlIll.clear();
    }

    @Override // com.microblink.fragment.overlay.BaseOverlayController
    protected int llIIlIlIIl() {
        return this.IlIllIlllI.IlIllIlIIl();
    }

    private Recognizer<?>[] llIIlIlIIl(RecognizerBundle recognizerBundle) {
        Recognizer<Recognizer.Result>[] recognizers = recognizerBundle.getRecognizers();
        Recognizer<?>[] recognizerArr = new Recognizer[recognizers.length];
        for (int i = 0; i < recognizers.length; i++) {
            recognizerArr[i] = this.IlIIlllIIl.getConcreteRecognizer(recognizers[i]);
        }
        return recognizerArr;
    }

    static void llIIlIlIIl(BaseBlinkIdOverlayController baseBlinkIdOverlayController, RecognitionSuccessType recognitionSuccessType) {
        long jOnScanSuccess = baseBlinkIdOverlayController.lllIlIlIIl.onScanSuccess();
        baseBlinkIdOverlayController.IIlIIIllIl();
        baseBlinkIdOverlayController.IllIIIIllI.postDelayed(baseBlinkIdOverlayController.new RunnableC36604(recognitionSuccessType), jOnScanSuccess);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void llIIlIlIIl(RetryDialogStrings retryDialogStrings) {
        new AlertDialog.Builder(getContext()).setTitle(retryDialogStrings.title).setMessage(retryDialogStrings.message).setPositiveButton(retryDialogStrings.retryButton, new DialogInterface.OnClickListener() { // from class: com.microblink.fragment.overlay.blinkid.BaseBlinkIdOverlayController.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                BaseBlinkIdOverlayController.this.IlIllIlIIl(0L);
                BaseBlinkIdOverlayController.this.resumeScanning();
            }
        }).setCancelable(false).create().show();
    }

    protected void llIIlIlIIl(long j) {
        if (this.IlIlllllII == DocumentSide.FIRST_SIDE) {
            this.IllIIIIllI.postDelayed(new Runnable() { // from class: com.microblink.fragment.overlay.blinkid.BaseBlinkIdOverlayController.10
                @Override // java.lang.Runnable
                public void run() {
                    BaseBlinkIdOverlayController.this.IlIllIlllI();
                }
            }, j);
        } else {
            lllIlIlIIl();
        }
    }

    @Override // com.microblink.fragment.overlay.BaseOverlayController
    protected void llIIlIlIIl(Configuration configuration) {
        int hostScreenOrientation = this.llIIIlllll.getHostScreenOrientation();
        this.llIllIIlll.onOrientationChange(hostScreenOrientation);
        this.lllllIlIll.onOrientationChange(hostScreenOrientation);
        this.lllIlIlIIl.onConfigurationChanged(hostScreenOrientation);
    }

    @Override // com.microblink.fragment.overlay.BaseOverlayController
    protected void llIIlIlIIl(Bundle bundle) {
        this.IlIIlllIIl.saveBundleState();
        this.llIIlIIIll.saveState();
    }
}
