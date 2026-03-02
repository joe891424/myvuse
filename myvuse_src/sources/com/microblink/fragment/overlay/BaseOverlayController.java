package com.microblink.fragment.overlay;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.microblink.fragment.LifecycleObserver;
import com.microblink.fragment.RecognizerRunnerFragment;
import com.microblink.fragment.overlay.components.ErrorDialogFactory;
import com.microblink.fragment.overlay.components.ScanSoundPlayer;
import com.microblink.fragment.overlay.components.TorchController;
import com.microblink.geometry.Rectangle;
import com.microblink.recognition.RecognitionSuccessType;
import com.microblink.util.Log;
import com.microblink.view.BaseCameraEventsListener;
import com.microblink.view.CameraEventsListener;
import com.microblink.view.recognition.RecognizerRunnerView;
import com.microblink.view.recognition.ScanResultListener;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseOverlayController implements ScanningOverlay {
    protected RecognizerRunnerFragment IllIIIllII;
    protected AlertDialog lIlIIIIlIl;
    protected RecognizerRunnerView llIIIlllll;
    protected ScanResultListener llIIlIlIIl;
    protected OverlayState IlIllIlIIl = OverlayState.DESTROYED;
    protected Handler IllIIIIllI = new Handler(Looper.getMainLooper());
    protected ScanSoundPlayer llIIlIIlll = new ScanSoundPlayer();
    protected TorchController IIlIIIllIl = new TorchController();
    private final BaseCameraEventsListener lIIIIIllll = new CameraEventsListener() { // from class: com.microblink.fragment.overlay.BaseOverlayController.1
        @Override // com.microblink.hardware.camera.AutofocusListener
        public void onAutofocusFailed() {
            BaseOverlayController.this.IllIIIllII();
        }

        @Override // com.microblink.hardware.camera.AutofocusListener
        public void onAutofocusStarted(Rect[] rectArr) {
        }

        @Override // com.microblink.hardware.camera.AutofocusListener
        public void onAutofocusStopped(Rect[] rectArr) {
        }

        @Override // com.microblink.view.CameraEventsListener
        public void onCameraPermissionDenied() {
        }

        @Override // com.microblink.view.BaseCameraEventsListener
        public void onCameraPreviewStarted() {
            BaseOverlayController.this.IIlIIIllIl.onTorchSupportStatusAvailable();
            BaseOverlayController baseOverlayController = BaseOverlayController.this;
            if (baseOverlayController.IlIllIlIIl == OverlayState.RESUMED) {
                baseOverlayController.llIIIlllll.setMeteringAreas(new RectF[]{new Rectangle(0.33f, 0.33f, 0.33f, 0.33f).toRectF()}, true);
            }
        }

        @Override // com.microblink.view.BaseCameraEventsListener
        public void onCameraPreviewStopped() {
        }

        @Override // com.microblink.view.BaseCameraEventsListener
        public void onError(final Throwable th) {
            RecognizerRunnerFragment recognizerRunnerFragment = BaseOverlayController.this.IllIIIllII;
            if (recognizerRunnerFragment == null || recognizerRunnerFragment.getActivity() == null) {
                Log.m2715w(this, "RecognizerRunnerFragment or Activity is null", new Object[0]);
                return;
            }
            BaseOverlayController.this.lIlIIIIlIl = new ErrorDialogFactory().createErrorDialog(BaseOverlayController.this.IllIIIllII.getActivity(), th, new Runnable() { // from class: com.microblink.fragment.overlay.BaseOverlayController.1.1
                @Override // java.lang.Runnable
                public void run() {
                    BaseOverlayController.this.onUnrecoverableError(th);
                    BaseOverlayController.this.IllIIIllII.getActivity().onBackPressed();
                }
            });
            BaseOverlayController baseOverlayController = BaseOverlayController.this;
            OverlayState overlayState = baseOverlayController.IlIllIlIIl;
            if (overlayState == OverlayState.RESUMED || overlayState == OverlayState.STARTED) {
                baseOverlayController.lIlIIIIlIl.show();
                BaseOverlayController.this.lIlIIIIlIl = null;
            }
        }
    };
    private final LifecycleObserver lllIIIlIlI = new LifecycleObserver() { // from class: com.microblink.fragment.overlay.BaseOverlayController.2
        @Override // com.microblink.fragment.LifecycleObserver
        public void onConfigurationChanged(Configuration configuration) {
            BaseOverlayController.this.llIIlIlIIl(configuration);
        }

        @Override // com.microblink.fragment.LifecycleObserver
        public void onCreate(Bundle bundle) {
            BaseOverlayController baseOverlayController = BaseOverlayController.this;
            baseOverlayController.IlIllIlIIl = OverlayState.CREATED;
            baseOverlayController.getClass();
        }

        @Override // com.microblink.fragment.LifecycleObserver
        public void onDestroy() {
            BaseOverlayController baseOverlayController = BaseOverlayController.this;
            baseOverlayController.IlIllIlIIl = OverlayState.DESTROYED;
            baseOverlayController.llIIlIIlll.clear();
            BaseOverlayController baseOverlayController2 = BaseOverlayController.this;
            baseOverlayController2.IllIIIllII = null;
            baseOverlayController2.IllIIIIllI.removeCallbacksAndMessages(null);
            BaseOverlayController.this.llIIIlllll();
        }

        @Override // com.microblink.fragment.LifecycleObserver
        public void onPause() {
            BaseOverlayController baseOverlayController = BaseOverlayController.this;
            baseOverlayController.IlIllIlIIl = OverlayState.STARTED;
            baseOverlayController.IllIIIIllI();
        }

        @Override // com.microblink.fragment.LifecycleObserver
        public void onResume() {
            BaseOverlayController baseOverlayController = BaseOverlayController.this;
            baseOverlayController.IlIllIlIIl = OverlayState.RESUMED;
            AlertDialog alertDialog = baseOverlayController.lIlIIIIlIl;
            if (alertDialog != null) {
                alertDialog.show();
                BaseOverlayController.this.lIlIIIIlIl = null;
            }
            BaseOverlayController.this.lIlIIIIlIl();
        }

        @Override // com.microblink.fragment.LifecycleObserver
        public void onSaveInstanceState(Bundle bundle) {
            BaseOverlayController.this.llIIlIlIIl(bundle);
        }

        @Override // com.microblink.fragment.LifecycleObserver
        public void onStart() {
            BaseOverlayController baseOverlayController = BaseOverlayController.this;
            baseOverlayController.IlIllIlIIl = OverlayState.STARTED;
            baseOverlayController.getClass();
        }

        @Override // com.microblink.fragment.LifecycleObserver
        public void onStop() {
            BaseOverlayController baseOverlayController = BaseOverlayController.this;
            baseOverlayController.IlIllIlIIl = OverlayState.CREATED;
            baseOverlayController.getClass();
        }
    };

    protected BaseOverlayController(ScanResultListener scanResultListener) {
        this.llIIlIlIIl = scanResultListener;
    }

    protected abstract int IlIllIlIIl();

    protected void IllIIIIllI() {
    }

    protected void IllIIIllII() {
    }

    public Context getContext() {
        RecognizerRunnerFragment recognizerRunnerFragment = this.IllIIIllII;
        if (recognizerRunnerFragment == null) {
            return null;
        }
        return recognizerRunnerFragment.getActivity();
    }

    protected void lIlIIIIlIl() {
    }

    protected void llIIIlllll() {
    }

    protected abstract boolean llIIlIIlll();

    protected abstract int llIIlIlIIl();

    protected void llIIlIlIIl(Configuration configuration) {
    }

    protected void llIIlIlIIl(Bundle bundle) {
    }

    @Override // com.microblink.fragment.overlay.ScanningOverlay
    public void onFrameRecognitionDone(RecognitionSuccessType recognitionSuccessType) {
    }

    @Override // com.microblink.fragment.overlay.ScanningOverlay
    public void onRecognizerRunnerFragmentAttached(RecognizerRunnerFragment recognizerRunnerFragment, Activity activity) {
        this.IllIIIllII = recognizerRunnerFragment;
        recognizerRunnerFragment.setCameraEventsListener(this.lIIIIIllll);
        recognizerRunnerFragment.registerLifecycleObserver(this.lllIIIlIlI);
        recognizerRunnerFragment.setSplashScreenResourceId(IlIllIlIIl());
    }

    @Override // com.microblink.fragment.overlay.ScanningOverlay
    public void onRecognizerRunnerViewCreated(RecognizerRunnerFragment recognizerRunnerFragment) {
        this.llIIIlllll = recognizerRunnerFragment.getRecognizerRunnerView();
        this.llIIlIIlll.initialize(recognizerRunnerFragment.getActivity(), llIIlIlIIl());
    }

    @Override // com.microblink.view.recognition.ScanResultListener
    public void onUnrecoverableError(Throwable th) {
        this.llIIlIlIIl.onUnrecoverableError(th);
    }

    @Override // com.microblink.fragment.overlay.ScanningOverlay
    public void pauseScanning() {
        RecognizerRunnerView recognizerRunnerView = this.llIIIlllll;
        if (recognizerRunnerView != null) {
            recognizerRunnerView.pauseScanning();
        }
    }

    @Override // com.microblink.fragment.overlay.ScanningOverlay
    public void resumeScanning() {
        RecognizerRunnerView recognizerRunnerView = this.llIIIlllll;
        if (recognizerRunnerView != null) {
            recognizerRunnerView.resumeScanning(llIIlIIlll());
        }
    }
}
