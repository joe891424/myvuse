package com.microblink.fragment.overlay.blinkid.legacy.documentverification;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.ConnectionResult;
import com.microblink.blinkid.secured.llIIllllIl;
import com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView;
import com.microblink.fragment.overlay.blinkid.RetryDialogStrings;
import com.microblink.fragment.overlay.components.TorchController;
import com.microblink.library.C3714R;
import com.microblink.view.recognition.DetectionStatus;
import com.microblink.view.recognition.RecognizerRunnerView;
import com.microblink.view.viewfinder.ViewfinderShapeView;
import com.microblink.view.viewfinder.managers.DocumentViewfinderManager;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class LegacyDocumentVerificationOverlayView implements BlinkIdOverlayView {
    private LegacyDocumentVerificationOverlayStrings IIlIIIllIl;
    private TextView IlIllIlIIl;
    private DocumentViewfinderManager IllIIIIllI;
    private TextView IllIIIllII;
    private int lIIIIIllll;
    private View.OnClickListener lIlIIIIlIl;
    private ImageView llIIIlllll;
    private final boolean llIIlIIlll;
    private LegacyDocumentVerificationOverlayResources lllIIIlIlI;
    private Handler llIIlIlIIl = new Handler(Looper.getMainLooper());
    private CountDownTimer IlIllIlllI = new CountDownTimer(1500, 1500) { // from class: com.microblink.fragment.overlay.blinkid.legacy.documentverification.LegacyDocumentVerificationOverlayView.5
        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (LegacyDocumentVerificationOverlayView.this.IllIIIllII != null) {
                LegacyDocumentVerificationOverlayView.this.llIIlIlIIl.post(new Runnable() { // from class: com.microblink.fragment.overlay.blinkid.legacy.documentverification.LegacyDocumentVerificationOverlayView.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LegacyDocumentVerificationOverlayView.this.IllIIIllII.setVisibility(4);
                    }
                });
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }
    };

    /* JADX INFO: renamed from: com.microblink.fragment.overlay.blinkid.legacy.documentverification.LegacyDocumentVerificationOverlayView$2 */
    /* JADX INFO: compiled from: line */
    class RunnableC36722 implements Runnable {
        final /* synthetic */ Drawable IlIllIlIIl;
        final /* synthetic */ String IllIIIllII;
        final /* synthetic */ Drawable llIIIlllll;
        final /* synthetic */ String llIIlIlIIl;

        RunnableC36722(String str, Drawable drawable, String str2, Drawable drawable2) {
            this.llIIlIlIIl = str;
            this.IlIllIlIIl = drawable;
            this.IllIIIllII = str2;
            this.llIIIlllll = drawable2;
        }

        @Override // java.lang.Runnable
        public void run() {
            LegacyDocumentVerificationOverlayView.this.IlIllIlIIl.setVisibility(4);
            if (LegacyDocumentVerificationOverlayView.this.IllIIIIllI != null) {
                LegacyDocumentVerificationOverlayView.this.IllIIIIllI.showSplashScreen(this.llIIlIlIIl, this.IlIllIlIIl, C3714R.color.mb_viewfinder_inner_splash);
            }
            LegacyDocumentVerificationOverlayView.this.IlIllIlIIl.setText(this.IllIIIllII);
            LegacyDocumentVerificationOverlayView.this.IlIllIlIIl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.llIIIlllll, (Drawable) null);
        }
    }

    /* JADX INFO: renamed from: com.microblink.fragment.overlay.blinkid.legacy.documentverification.LegacyDocumentVerificationOverlayView$3 */
    /* JADX INFO: compiled from: line */
    class RunnableC36733 implements Runnable {
        RunnableC36733() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LegacyDocumentVerificationOverlayView.this.IllIIIIllI.clearSplashScreen(0L, 500L, new Runnable() { // from class: com.microblink.fragment.overlay.blinkid.legacy.documentverification.LegacyDocumentVerificationOverlayView.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (LegacyDocumentVerificationOverlayView.this.IlIllIlIIl != null) {
                        LegacyDocumentVerificationOverlayView.this.IlIllIlIIl.setVisibility(0);
                    }
                }
            });
        }
    }

    public LegacyDocumentVerificationOverlayView(boolean z, LegacyDocumentVerificationOverlayStrings legacyDocumentVerificationOverlayStrings, int i, View.OnClickListener onClickListener) {
        this.llIIlIIlll = z;
        this.IIlIIIllIl = legacyDocumentVerificationOverlayStrings;
        this.lIIIIIllll = i;
        this.lIlIIIIlIl = onClickListener;
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void cleanup() {
        this.llIIlIlIIl.removeCallbacksAndMessages(null);
        this.IlIllIlllI.cancel();
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public ViewGroup createLayout(final Activity activity, RecognizerRunnerView recognizerRunnerView) {
        if (this.IIlIIIllIl == null) {
            this.IIlIIIllIl = LegacyDocumentVerificationOverlayStrings.createDefault(activity);
        }
        this.lllIIIlIlI = new LegacyDocumentVerificationOverlayResources(activity, this.lIIIIIllll);
        ViewGroup viewGroup = (ViewGroup) activity.getLayoutInflater().inflate(llIIllllIl.IllIIIIllI, (ViewGroup) recognizerRunnerView, false);
        TextView textView = (TextView) viewGroup.findViewById(C3714R.id.documentScanInstructions);
        this.IlIllIlIIl = textView;
        View.OnClickListener onClickListener = this.lIlIIIIlIl;
        if (onClickListener != null) {
            textView.setOnClickListener(onClickListener);
        }
        TextView textView2 = (TextView) viewGroup.findViewById(C3714R.id.tvGlareMessage);
        this.IllIIIllII = textView2;
        textView2.setText(this.IIlIIIllIl.lIIIIIlIlI);
        ImageView imageView = (ImageView) viewGroup.findViewById(C3714R.id.defaultBackButton);
        if (this.llIIlIIlll) {
            imageView.setImageDrawable(this.lllIIIlIlI.IllIIIIllI);
            imageView.setVisibility(0);
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.microblink.fragment.overlay.blinkid.legacy.documentverification.LegacyDocumentVerificationOverlayView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    activity.onBackPressed();
                }
            });
        } else {
            imageView.setVisibility(8);
        }
        View viewFindViewById = viewGroup.findViewById(C3714R.id.torchContainer);
        if (this.llIIlIIlll) {
            View viewFindViewById2 = viewGroup.findViewById(C3714R.id.viewfinderMarginTop);
            if (viewFindViewById2 != null) {
                viewFindViewById2.setVisibility(8);
            }
            this.llIIIlllll = (ImageView) viewFindViewById.findViewById(C3714R.id.defaultTorchButton);
        } else {
            viewFindViewById.setVisibility(8);
            this.llIIIlllll = null;
        }
        this.IllIIIIllI = new DocumentViewfinderManager((ViewfinderShapeView) viewGroup.findViewById(C3714R.id.viewfinderRectangle), (TextView) viewGroup.findViewById(C3714R.id.tvCardMessage), (ImageView) viewGroup.findViewById(C3714R.id.ivCardIcon));
        recognizerRunnerView.addChildView(viewGroup, false);
        return viewGroup;
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public TorchController createTorchController(RecognizerRunnerView recognizerRunnerView) {
        TorchController torchController = new TorchController();
        ImageView imageView = this.llIIIlllll;
        LegacyDocumentVerificationOverlayResources legacyDocumentVerificationOverlayResources = this.lllIIIlIlI;
        torchController.setup(imageView, recognizerRunnerView, legacyDocumentVerificationOverlayResources.llIIIlllll, legacyDocumentVerificationOverlayResources.IllIIIllII);
        return torchController;
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public RetryDialogStrings getDataMismatchStrings() {
        LegacyDocumentVerificationOverlayStrings legacyDocumentVerificationOverlayStrings = this.IIlIIIllIl;
        return new RetryDialogStrings(legacyDocumentVerificationOverlayStrings.llIIlIIlll, legacyDocumentVerificationOverlayStrings.IIlIIIllIl, legacyDocumentVerificationOverlayStrings.IllIIlIIII);
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public RetryDialogStrings getDocumentNotSupportedDialogStrings() {
        LegacyDocumentVerificationOverlayStrings legacyDocumentVerificationOverlayStrings = this.IIlIIIllIl;
        return new RetryDialogStrings(legacyDocumentVerificationOverlayStrings.lIIIIIllll, legacyDocumentVerificationOverlayStrings.lllIIIlIlI, legacyDocumentVerificationOverlayStrings.IllIIlIIII);
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public RetryDialogStrings getRecognitionTimeoutDialogStrings() {
        LegacyDocumentVerificationOverlayStrings legacyDocumentVerificationOverlayStrings = this.IIlIIIllIl;
        return new RetryDialogStrings(legacyDocumentVerificationOverlayStrings.IlIllIlllI, legacyDocumentVerificationOverlayStrings.lllIlIlIIl, legacyDocumentVerificationOverlayStrings.IllIIlIIII);
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public RetryDialogStrings getSidesNotMatchingDialogStrings() {
        LegacyDocumentVerificationOverlayStrings legacyDocumentVerificationOverlayStrings = this.IIlIIIllIl;
        return new RetryDialogStrings(legacyDocumentVerificationOverlayStrings.IllIIIIllI, legacyDocumentVerificationOverlayStrings.lIlIIIIlIl, legacyDocumentVerificationOverlayStrings.IllIIlIIII);
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
        LegacyDocumentVerificationOverlayStrings legacyDocumentVerificationOverlayStrings = this.IIlIIIllIl;
        String str = legacyDocumentVerificationOverlayStrings.IllIIIllII;
        LegacyDocumentVerificationOverlayResources legacyDocumentVerificationOverlayResources = this.lllIIIlIlI;
        this.llIIlIlIIl.post(new RunnableC36722(str, legacyDocumentVerificationOverlayResources.lIlIIIIlIl, legacyDocumentVerificationOverlayStrings.llIIlIlIIl, legacyDocumentVerificationOverlayResources.IIlIIIllIl));
        this.llIIlIlIIl.postDelayed(new RunnableC36733(), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
    }

    @Override // com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView
    public void onGlare(boolean z) {
        if (this.IllIIIllII == null || !z) {
            return;
        }
        this.IlIllIlllI.cancel();
        this.llIIlIlIIl.post(new Runnable() { // from class: com.microblink.fragment.overlay.blinkid.legacy.documentverification.LegacyDocumentVerificationOverlayView.4
            @Override // java.lang.Runnable
            public void run() {
                LegacyDocumentVerificationOverlayView.this.IllIIIllII.setVisibility(0);
            }
        });
        this.IlIllIlllI.start();
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
        LegacyDocumentVerificationOverlayStrings legacyDocumentVerificationOverlayStrings = this.IIlIIIllIl;
        String str = legacyDocumentVerificationOverlayStrings.llIIIlllll;
        LegacyDocumentVerificationOverlayResources legacyDocumentVerificationOverlayResources = this.lllIIIlIlI;
        this.llIIlIlIIl.post(new RunnableC36722(str, legacyDocumentVerificationOverlayResources.llIIlIIlll, legacyDocumentVerificationOverlayStrings.IlIllIlIIl, legacyDocumentVerificationOverlayResources.lIIIIIllll));
        this.llIIlIlIIl.postDelayed(new RunnableC36733(), 1000);
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
