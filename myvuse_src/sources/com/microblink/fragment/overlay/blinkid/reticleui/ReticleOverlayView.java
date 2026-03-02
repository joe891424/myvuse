package com.microblink.fragment.overlay.blinkid.reticleui;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.microblink.blinkid.secured.llIIllllIl;
import com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView;
import com.microblink.fragment.overlay.blinkid.RetryDialogStrings;
import com.microblink.fragment.overlay.blinkid.reticleui.ReticleOverlayStrings;
import com.microblink.fragment.overlay.components.TorchController;
import com.microblink.fragment.overlay.components.feedback.view.SuccessFlashView;
import com.microblink.fragment.overlay.components.snackbar.SnackbarManager;
import com.microblink.fragment.overlay.components.statusmsg.StatusTextManager;
import com.microblink.fragment.overlay.components.statusmsg.StatusTextStyler;
import com.microblink.library.C3714R;
import com.microblink.recognition.Right;
import com.microblink.recognition.RightsManager;
import com.microblink.view.recognition.DetectionStatus;
import com.microblink.view.recognition.RecognizerRunnerView;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class ReticleOverlayView implements BlinkIdOverlayView {
    private ImageView IlIIlllIIl;
    private int IlIllIlIIl;
    private ImageView IlIlllllII;
    private boolean IllIIIIllI;
    private ReticleOverlayResources IllIIIllII;
    private ReticleView lIIIIIlIlI;
    private boolean lIlIIIIlIl;
    private SnackbarManager lIlllIlIlI;
    protected ReticleOverlayStrings llIIIlllll;
    private ProgressBar llIIlIIIll;
    private PulseView llIllIIlll;
    private StatusTextManager lllIlIlIIl;
    private SuccessFlashView lllllIlIll;
    private Handler llIIlIlIIl = new Handler(Looper.getMainLooper());
    protected ReticleUiState llIIlIIlll = ReticleUiState.SENSING;
    private long IIlIIIllIl = 0;
    private boolean lIIIIIllll = false;
    private boolean lllIIIlIlI = false;
    private boolean IlIllIlllI = false;
    private CardAnimator IllIIlIIII = CardAnimator.EMPTY;

    /* JADX INFO: renamed from: com.microblink.fragment.overlay.blinkid.reticleui.ReticleOverlayView$6 */
    /* JADX INFO: compiled from: line */
    static /* synthetic */ class C36916 {
        static final /* synthetic */ int[] IlIllIlIIl;
        static final /* synthetic */ int[] IllIIIllII;
        static final /* synthetic */ int[] llIIlIlIIl;

        static {
            int[] iArr = new int[StatusMessageMode.values().length];
            IllIIIllII = iArr;
            try {
                iArr[StatusMessageMode.IMMEDIATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                IllIIIllII[StatusMessageMode.DELAYED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[BlinkIdOverlayView.ProcessingError.values().length];
            IlIllIlIIl = iArr2;
            try {
                iArr2[BlinkIdOverlayView.ProcessingError.MANDATORY_FIELD_MISSING.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr3 = new int[DetectionStatus.values().length];
            llIIlIlIIl = iArr3;
            try {
                iArr3[DetectionStatus.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                llIIlIlIIl[DetectionStatus.FALLBACK_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                llIIlIlIIl[DetectionStatus.CAMERA_TOO_HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                llIIlIlIIl[DetectionStatus.CAMERA_TOO_NEAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                llIIlIlIIl[DetectionStatus.PARTIAL_OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                llIIlIlIIl[DetectionStatus.DOCUMENT_TOO_CLOSE_TO_EDGE.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public ReticleOverlayView(boolean z, boolean z2, ReticleOverlayStrings reticleOverlayStrings, int i) {
        this.IllIIIIllI = z;
        this.lIlIIIIlIl = z2;
        this.llIIIlllll = reticleOverlayStrings;
        this.IlIllIlIIl = i;
    }

    public void changeState(final ReticleUiState reticleUiState, final String str) {
        this.IIlIIIllIl = System.currentTimeMillis();
        final ReticleUiState reticleUiState2 = this.llIIlIIlll;
        this.llIIlIIlll = reticleUiState;
        this.llIIlIlIIl.post(new Runnable() { // from class: com.microblink.fragment.overlay.blinkid.reticleui.ReticleOverlayView.5
            @Override // java.lang.Runnable
            public void run() {
                ReticleOverlayView.llIIlIlIIl(ReticleOverlayView.this, reticleUiState2, reticleUiState, str);
            }
        });
    }

    public void changeStateIfRequired(ReticleUiState reticleUiState, String str) {
        ReticleUiState reticleUiState2;
        ReticleUiState reticleUiState3 = this.llIIlIIlll;
        if (reticleUiState3 == reticleUiState) {
            this.IIlIIIllIl = System.currentTimeMillis();
            return;
        }
        if (reticleUiState != ReticleUiState.ERROR_DIALOG) {
            ReticleUiState reticleUiState4 = ReticleUiState.SUCCESS;
            if (reticleUiState3 == reticleUiState4) {
                return;
            }
            if (reticleUiState != reticleUiState4 && ((!reticleUiState3.isDetectionError || reticleUiState3 == ReticleUiState.DOCUMENT_NOT_IN_HAND || reticleUiState != ReticleUiState.PROCESSING) && ((reticleUiState3 != (reticleUiState2 = ReticleUiState.PROCESSING) || reticleUiState != ReticleUiState.DOCUMENT_NOT_IN_HAND) && ((reticleUiState3 != reticleUiState2 || !reticleUiState.isProcessingError) && System.currentTimeMillis() - this.IIlIIIllIl < this.llIIlIIlll.minDurationMs)))) {
                return;
            }
        }
        changeState(reticleUiState, str);
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void cleanup() {
        this.lllllIlIll.cancelAnimation();
        this.lIIIIIlIlI.clearAnimation();
        this.llIllIIlll.setAnimationEnabled(false);
        this.llIIlIlIIl.removeCallbacksAndMessages(null);
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public ViewGroup createLayout(final Activity activity, RecognizerRunnerView recognizerRunnerView) {
        if (this.llIIIlllll == null) {
            this.llIIIlllll = new ReticleOverlayStrings.Builder(activity).build();
        }
        this.IllIIIllII = new ReticleOverlayResources(activity, this.IlIllIlIIl);
        ViewGroup viewGroup = (ViewGroup) activity.getLayoutInflater().inflate(llIIllllIl.llIIIlllll, (ViewGroup) recognizerRunnerView, false);
        ReticleView reticleView = (ReticleView) viewGroup.findViewById(C3714R.id.reticleView);
        this.lIIIIIlIlI = reticleView;
        ReticleOverlayResources reticleOverlayResources = this.IllIIIllII;
        reticleView.setDrawables(reticleOverlayResources.IllIIIllII, reticleOverlayResources.llIIIlllll, reticleOverlayResources.IllIIIIllI);
        ProgressBar progressBar = (ProgressBar) viewGroup.findViewById(C3714R.id.progressBar);
        this.llIIlIIIll = progressBar;
        progressBar.setIndeterminateDrawable(this.IllIIIllII.lIlIIIIlIl);
        this.IlIIlllIIl = (ImageView) viewGroup.findViewById(C3714R.id.cardAnimationView);
        PulseView pulseView = (PulseView) viewGroup.findViewById(C3714R.id.pulseView);
        this.llIllIIlll = pulseView;
        pulseView.setup(this.IllIIIllII.llIIlIIIll);
        SuccessFlashView successFlashView = (SuccessFlashView) viewGroup.findViewById(C3714R.id.successFlashView);
        this.lllllIlIll = successFlashView;
        successFlashView.setup(this.IllIIIllII.IlIIlllIIl);
        ImageView imageView = (ImageView) viewGroup.findViewById(C3714R.id.poweredByMicroblinkView);
        if (!RightsManager.llIIIlllll() || !RightsManager.llIIlIlIIl(Right.ALLOW_REMOVE_PRODUCTION_OVERLAY)) {
            imageView.setVisibility(0);
        }
        TextSwitcher textSwitcher = (TextSwitcher) viewGroup.findViewById(C3714R.id.instructionsView);
        textSwitcher.setBackground(this.IllIIIllII.lllIlIlIIl);
        StatusTextManager statusTextManager = new StatusTextManager(textSwitcher, new StatusTextStyler() { // from class: com.microblink.fragment.overlay.blinkid.reticleui.ReticleOverlayView.3
            @Override // com.microblink.fragment.overlay.components.statusmsg.StatusTextStyler
            public void applyStyle(TextView textView) {
                textView.setLineSpacing(4.0f, 1.0f);
                textView.setTextAppearance(textView.getContext(), ReticleOverlayView.this.IllIIIllII.IllIIlIIII);
            }
        });
        this.lllIlIlIIl = statusTextManager;
        statusTextManager.setShouldAnimate(false);
        ImageView imageView2 = (ImageView) viewGroup.findViewById(C3714R.id.defaultBackButton);
        if (this.IllIIIIllI) {
            imageView2.setImageDrawable(this.IllIIIllII.lIIIIIllll);
            imageView2.setVisibility(0);
            imageView2.setOnClickListener(new View.OnClickListener(this) { // from class: com.microblink.fragment.overlay.blinkid.reticleui.ReticleOverlayView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    activity.onBackPressed();
                }
            });
        } else {
            imageView2.setVisibility(8);
        }
        ImageView imageView3 = (ImageView) viewGroup.findViewById(C3714R.id.defaultTorchButton);
        this.IlIlllllII = imageView3;
        if (this.IllIIIIllI) {
            imageView3.setVisibility(0);
        } else {
            imageView3.setVisibility(8);
            this.IlIlllllII = null;
        }
        this.lIlllIlIlI = new SnackbarManager((ViewSwitcher) viewGroup.findViewById(C3714R.id.snackbarViewSwitcher), this.llIIIlllll.flashlightWarning, this.IllIIIllII.lIIIIIlIlI, new StatusTextStyler() { // from class: com.microblink.fragment.overlay.blinkid.reticleui.ReticleOverlayView.1
            @Override // com.microblink.fragment.overlay.components.statusmsg.StatusTextStyler
            public void applyStyle(TextView textView) {
                textView.setLineSpacing(4.0f, 1.0f);
                textView.setTextAppearance(textView.getContext(), ReticleOverlayView.this.IllIIIllII.IlIlllllII);
            }
        });
        recognizerRunnerView.addChildView(viewGroup, false);
        return viewGroup;
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public TorchController createTorchController(RecognizerRunnerView recognizerRunnerView) {
        TorchController torchController = new TorchController();
        ImageView imageView = this.IlIlllllII;
        ReticleOverlayResources reticleOverlayResources = this.IllIIIllII;
        torchController.setup(imageView, recognizerRunnerView, reticleOverlayResources.IIlIIIllIl, reticleOverlayResources.llIIlIIlll);
        return torchController;
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public RetryDialogStrings getDataMismatchStrings() {
        ReticleOverlayStrings reticleOverlayStrings = this.llIIIlllll;
        return new RetryDialogStrings(reticleOverlayStrings.dataMismatchTitle, reticleOverlayStrings.dataMismatchMessage, reticleOverlayStrings.retryButton);
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public RetryDialogStrings getDocumentNotSupportedDialogStrings() {
        ReticleOverlayStrings reticleOverlayStrings = this.llIIIlllll;
        return new RetryDialogStrings(reticleOverlayStrings.unsupportedDocumentTitle, reticleOverlayStrings.unsupportedDocumentMessage, reticleOverlayStrings.retryButton);
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public RetryDialogStrings getRecognitionTimeoutDialogStrings() {
        ReticleOverlayStrings reticleOverlayStrings = this.llIIIlllll;
        return new RetryDialogStrings(reticleOverlayStrings.recognitionTimeoutTitle, reticleOverlayStrings.recognitionTimeoutMessage, reticleOverlayStrings.retryButton);
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public RetryDialogStrings getSidesNotMatchingDialogStrings() {
        ReticleOverlayStrings reticleOverlayStrings = this.llIIIlllll;
        return new RetryDialogStrings(reticleOverlayStrings.sidesNotMatchingTitle, reticleOverlayStrings.sidesNotMatchingMessage, reticleOverlayStrings.retryButton);
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void onCardDetectionUpdate(DetectionStatus detectionStatus) {
        ReticleUiState reticleUiState = ReticleUiState.SENSING;
        String str = this.lIIIIIllll ? this.IlIllIlllI ? this.llIIIlllll.backSideBarcodeInstructions : this.llIIIlllll.backSideInstructions : this.llIIIlllll.firstSideInstructions;
        switch (C36916.llIIlIlIIl[detectionStatus.ordinal()]) {
            case 1:
            case 2:
                if (this.lIIIIIllll || !this.lllIIIlIlI) {
                    reticleUiState = ReticleUiState.PROCESSING;
                }
                break;
            case 3:
                reticleUiState = ReticleUiState.CAMERA_TOO_HIGH;
                str = this.llIIIlllll.errorMoveCloser;
                break;
            case 4:
            case 5:
                reticleUiState = ReticleUiState.CAMERA_TOO_CLOSE;
                str = this.llIIIlllll.errorMoveFarther;
                break;
            case 6:
                reticleUiState = ReticleUiState.DOCUMENT_TOO_CLOSE_TO_EDGE;
                str = this.llIIIlllll.errorDocumentTooCloseToEdge;
                break;
        }
        Pair pair = new Pair(reticleUiState, str);
        changeStateIfRequired((ReticleUiState) pair.first, (String) pair.second);
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void onConfigurationChanged(int i) {
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void onDocumentClassified() {
        changeStateIfRequired(ReticleUiState.PROCESSING, "");
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void onErrorDialogShown() {
        ReticleUiState reticleUiState = this.llIIlIIlll;
        ReticleUiState reticleUiState2 = ReticleUiState.ERROR_DIALOG;
        if (reticleUiState != reticleUiState2) {
            changeState(reticleUiState2, "");
        }
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void onFirstSideScanStarted() {
        this.lIIIIIllll = false;
        changeState(ReticleUiState.SENSING, this.llIIIlllll.firstSideInstructions);
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void onGlare(boolean z) {
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void onMovingCloserToBarcodeRequired() {
        this.IlIllIlllI = true;
        changeState(ReticleUiState.SENSING, this.llIIIlllll.backSideBarcodeInstructions);
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void onProcessingError(BlinkIdOverlayView.ProcessingError processingError) {
        if (C36916.IlIllIlIIl[processingError.ordinal()] != 1) {
            return;
        }
        changeStateIfRequired(ReticleUiState.DOCUMENT_NOT_FULLY_VISIBLE, this.llIIIlllll.errorDocumentNotFullyVisible);
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public long onScanSuccess() {
        ReticleUiState reticleUiState = this.llIIlIIlll;
        ReticleUiState reticleUiState2 = ReticleUiState.SUCCESS;
        if (reticleUiState == reticleUiState2) {
            return 0L;
        }
        changeState(reticleUiState2, "");
        return reticleUiState2.minDurationMs;
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void onSecondSideScanStarted() {
        this.lIIIIIllll = true;
        ReticleUiState reticleUiState = this.llIIlIIlll;
        ReticleUiState reticleUiState2 = ReticleUiState.FLIP_CARD;
        if (reticleUiState == reticleUiState2) {
            return;
        }
        changeState(reticleUiState2, this.llIIIlllll.flipInstructions);
        final ReticleUiState reticleUiState3 = ReticleUiState.AFTER_CARD_FLIP;
        final String str = "";
        this.llIIlIlIIl.postDelayed(new Runnable() { // from class: com.microblink.fragment.overlay.blinkid.reticleui.ReticleOverlayView.4
            @Override // java.lang.Runnable
            public void run() {
                ReticleOverlayView.this.changeState(reticleUiState3, str);
            }
        }, reticleUiState2.minDurationMs);
        ReticleOverlayStrings reticleOverlayStrings = this.llIIIlllll;
        final String str2 = reticleOverlayStrings.backSideInstructions;
        if (this.IlIllIlllI) {
            str2 = reticleOverlayStrings.backSideBarcodeInstructions;
        }
        this.llIIlIlIIl.postDelayed(new Runnable() { // from class: com.microblink.fragment.overlay.blinkid.reticleui.ReticleOverlayView.4
            @Override // java.lang.Runnable
            public void run() {
                ReticleOverlayView.this.changeState(reticleUiState3, str2);
            }
        }, reticleUiState2.minDurationMs + 350);
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void onTorchStateChanged(boolean z) {
        if (this.lIlIIIIlIl) {
            if (z) {
                this.lIlllIlIlI.showSnackbar();
            } else {
                this.lIlllIlIlI.hideSnackbar();
            }
        }
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void setRecognizerSupportsClassification(boolean z) {
        this.lllIIIlIlI = z;
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void setShowBackSideBarcodeInstructions(boolean z) {
        this.IlIllIlllI = z;
    }

    static void llIIlIlIIl(ReticleOverlayView reticleOverlayView, ReticleUiState reticleUiState, ReticleUiState reticleUiState2, String str) {
        reticleOverlayView.IllIIlIIII.cancel();
        if (reticleOverlayView.llIIlIIlll.shouldShowProgress) {
            reticleOverlayView.llIIlIIIll.setVisibility(0);
        } else {
            reticleOverlayView.llIIlIIIll.setVisibility(8);
        }
        reticleOverlayView.lIIIIIlIlI.setType(reticleUiState2.reticleType);
        if (reticleUiState.isDetectionError) {
            reticleOverlayView.llIIlIlIIl(reticleOverlayView.llIIlIIlll.llIIlIlIIl.hurried(), str);
        } else {
            reticleOverlayView.llIIlIlIIl(reticleOverlayView.llIIlIIlll.llIIlIlIIl, str);
        }
        CardAnimator cardAnimator = reticleOverlayView.llIIlIIlll.cardAnimator;
        reticleOverlayView.IllIIlIIII = cardAnimator;
        cardAnimator.start(reticleOverlayView.IlIIlllIIl, reticleOverlayView.IllIIIllII);
        reticleOverlayView.llIllIIlll.setAnimationEnabled(reticleOverlayView.llIIlIIlll.shouldShowPulse);
        if (reticleUiState2 == ReticleUiState.SUCCESS) {
            reticleOverlayView.lllllIlIll.setVisibility(0);
            reticleOverlayView.lllllIlIll.startAnimation();
        }
    }

    private void llIIlIlIIl(StatusMessageMode statusMessageMode, String str) {
        int i = C36916.IllIIIllII[statusMessageMode.ordinal()];
        if (i == 1) {
            this.lllIlIlIIl.updateStatusImmediately(str);
        } else {
            if (i != 2) {
                return;
            }
            this.lllIlIlIIl.updateStatus(str);
        }
    }
}
