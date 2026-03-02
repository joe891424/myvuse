package com.microblink.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.microblink.blinkid.secured.IIllIllIIl;
import com.microblink.blinkid.secured.llIIllllIl;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.fragment.overlay.ScanningOverlay;
import com.microblink.locale.LanguageUtils;
import com.microblink.recognition.RecognitionSuccessType;
import com.microblink.util.CameraPermissionManager;
import com.microblink.util.Log;
import com.microblink.view.BaseCameraEventsListener;
import com.microblink.view.BaseCameraView;
import com.microblink.view.CameraEventsListener;
import com.microblink.view.exception.NonLandscapeOrientationNotSupportedException;
import com.microblink.view.recognition.FrameRecognitionCallback;
import com.microblink.view.recognition.RecognizerRunnerView;
import com.microblink.view.recognition.ScanResultListener;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class RecognizerRunnerFragment extends Fragment implements TraceFieldInterface {
    private LifecycleObserver IIlIIIllIl;
    private RecognizerBundle IlIllIlIIl;
    private FrameLayout IllIIIIllI;
    private ScanningOverlay IllIIIllII;
    public Trace _nr_trace;
    private CameraPermissionManager llIIIlllll;
    private BaseCameraEventsListener llIIlIIlll;
    private RecognizerRunnerView llIIlIlIIl;
    private View lIlIIIIlIl = null;
    private int lIIIIIllll = llIIllllIl.lIlIIIIlIl;
    private final ScanResultListener lllIIIlIlI = new ScanResultListener() { // from class: com.microblink.fragment.RecognizerRunnerFragment.1
        @Override // com.microblink.view.recognition.ScanResultListener
        public void onScanningDone(RecognitionSuccessType recognitionSuccessType) {
            RecognizerRunnerFragment.this.IllIIIllII.onScanningDone(recognitionSuccessType);
        }

        @Override // com.microblink.view.recognition.ScanResultListener
        public void onUnrecoverableError(Throwable th) {
            RecognizerRunnerFragment.this.IllIIIllII.onUnrecoverableError(th);
        }
    };
    private final CameraEventsListener IlIllIlllI = new CameraEventsListener() { // from class: com.microblink.fragment.RecognizerRunnerFragment.2
        @Override // com.microblink.hardware.camera.AutofocusListener
        public void onAutofocusFailed() {
            if (RecognizerRunnerFragment.this.llIIlIIlll != null) {
                RecognizerRunnerFragment.this.llIIlIIlll.onAutofocusFailed();
            }
        }

        @Override // com.microblink.hardware.camera.AutofocusListener
        public void onAutofocusStarted(Rect[] rectArr) {
            if (RecognizerRunnerFragment.this.llIIlIIlll != null) {
                RecognizerRunnerFragment.this.llIIlIIlll.onAutofocusStarted(rectArr);
            }
        }

        @Override // com.microblink.hardware.camera.AutofocusListener
        public void onAutofocusStopped(Rect[] rectArr) {
            if (RecognizerRunnerFragment.this.llIIlIIlll != null) {
                RecognizerRunnerFragment.this.llIIlIIlll.onAutofocusStopped(rectArr);
            }
        }

        @Override // com.microblink.view.CameraEventsListener
        public void onCameraPermissionDenied() {
            RecognizerRunnerFragment.this.llIIIlllll.askForCameraPermission();
        }

        @Override // com.microblink.view.BaseCameraEventsListener
        public void onCameraPreviewStarted() {
            if (RecognizerRunnerFragment.this.lIlIIIIlIl != null && RecognizerRunnerFragment.this.lIlIIIIlIl.getVisibility() == 0) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.microblink.fragment.RecognizerRunnerFragment.2.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        RecognizerRunnerFragment.this.lIlIIIIlIl.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                RecognizerRunnerFragment.this.lIlIIIIlIl.startAnimation(alphaAnimation);
            }
            if (RecognizerRunnerFragment.this.llIIlIIlll != null) {
                RecognizerRunnerFragment.this.llIIlIIlll.onCameraPreviewStarted();
            }
        }

        @Override // com.microblink.view.BaseCameraEventsListener
        public void onCameraPreviewStopped() {
            if (RecognizerRunnerFragment.this.llIIlIIlll != null) {
                RecognizerRunnerFragment.this.llIIlIIlll.onCameraPreviewStopped();
            }
        }

        @Override // com.microblink.view.BaseCameraEventsListener
        public void onError(Throwable th) {
            if (RecognizerRunnerFragment.this.llIIlIIlll != null) {
                RecognizerRunnerFragment.this.llIIlIIlll.onError(th);
            }
        }
    };
    private final FrameRecognitionCallback lllIlIlIIl = new FrameRecognitionCallback() { // from class: com.microblink.fragment.RecognizerRunnerFragment.3
        @Override // com.microblink.view.recognition.FrameRecognitionCallback
        public void onFrameRecognitionDone(RecognitionSuccessType recognitionSuccessType) {
            RecognizerRunnerFragment.this.IllIIIllII.onFrameRecognitionDone(recognitionSuccessType);
        }
    };

    /* JADX INFO: renamed from: com.microblink.fragment.RecognizerRunnerFragment$4 */
    /* JADX INFO: compiled from: line */
    static /* synthetic */ class C36494 {
        static final /* synthetic */ int[] llIIlIlIIl;

        static {
            int[] iArr = new int[BaseCameraView.CameraViewState.values().length];
            llIIlIlIIl = iArr;
            try {
                iArr[BaseCameraView.CameraViewState.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                llIIlIlIIl[BaseCameraView.CameraViewState.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                llIIlIlIIl[BaseCameraView.CameraViewState.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: line */
    public interface ScanningOverlayBinder {
        ScanningOverlay getScanningOverlay();
    }

    public FrameLayout getContentLayout() {
        return this.IllIIIIllI;
    }

    public RecognizerRunnerView getRecognizerRunnerView() {
        return this.llIIlIlIIl;
    }

    public int getSplashScreenResourceId() {
        return this.lIIIIIllll;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ScanningOverlayBinder scanningOverlayBinder = activity instanceof ScanningOverlayBinder ? (ScanningOverlayBinder) activity : getParentFragment() instanceof ScanningOverlayBinder ? (ScanningOverlayBinder) getParentFragment() : null;
        if (scanningOverlayBinder == null) {
            throw new ClassCastException(activity.toString() + (getParentFragment() != null ? IIllIllIIl.llIIlIlIIl(" or ").append(getParentFragment().toString()).toString() : "") + " must implement ScanningOverlayBinder interface!");
        }
        ScanningOverlay scanningOverlay = scanningOverlayBinder.getScanningOverlay();
        this.IllIIIllII = scanningOverlay;
        scanningOverlay.onRecognizerRunnerFragmentAttached(this, activity);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        RecognizerRunnerView recognizerRunnerView = this.llIIlIlIIl;
        if (recognizerRunnerView != null) {
            recognizerRunnerView.changeConfiguration(configuration);
        }
        LifecycleObserver lifecycleObserver = this.IIlIIIllIl;
        if (lifecycleObserver != null) {
            lifecycleObserver.onConfigurationChanged(configuration);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing("RecognizerRunnerFragment");
        try {
            TraceMachine.enterMethod(this._nr_trace, "RecognizerRunnerFragment#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "RecognizerRunnerFragment#onCreate", null);
        }
        LanguageUtils.setLanguageConfiguration(getResources());
        super.onCreate(bundle);
        Log.m2711i(this, "onCreate: {}", this);
        Log.m2707d(this, "My instance is: {}", RecognizerRunnerFragment.class.getName());
        LifecycleObserver lifecycleObserver = this.IIlIIIllIl;
        if (lifecycleObserver != null) {
            lifecycleObserver.onCreate(bundle);
        }
        TraceMachine.exitMethod();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "RecognizerRunnerFragment#onCreateView", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "RecognizerRunnerFragment#onCreateView", null);
        }
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        this.IllIIIIllI = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.IllIIIIllI.setVisibility(0);
        this.llIIIlllll = new CameraPermissionManager(this);
        llIIlIlIIl(layoutInflater.getContext());
        RecognizerRunnerView recognizerRunnerView = this.llIIlIlIIl;
        if (recognizerRunnerView == null) {
            TraceMachine.exitMethod();
            return null;
        }
        RecognizerBundle recognizerBundle = recognizerRunnerView.getRecognizerBundle();
        this.IlIllIlIIl = recognizerBundle;
        if (recognizerBundle == null) {
            NullPointerException nullPointerException = new NullPointerException("You must set RecognizerBundle in your onRecognizerRunnerViewCreated callback");
            TraceMachine.exitMethod();
            throw nullPointerException;
        }
        if (recognizerBundle.getRecognizers().length == 0) {
            IllegalStateException illegalStateException = new IllegalStateException("You must set at least one Recognizer object into RecognizerBundle which is set to RecognizerRunnerView in onRecognizerRunnerViewCreated callback");
            TraceMachine.exitMethod();
            throw illegalStateException;
        }
        for (Recognizer<Recognizer.Result> recognizer : this.IlIllIlIIl.getRecognizers()) {
            if (recognizer == null) {
                NullPointerException nullPointerException2 = new NullPointerException("It is not allowed to set null Recognizer in RecognizerBundle!");
                TraceMachine.exitMethod();
                throw nullPointerException2;
            }
        }
        int i = this.lIIIIIllll;
        if (i != 0) {
            this.lIlIIIIlIl = layoutInflater.inflate(i, (ViewGroup) null);
        }
        View view = this.lIlIIIIlIl;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.lIlIIIIlIl;
        if (view2 != null) {
            this.IllIIIIllI.addView(view2);
        }
        View askPermissionOverlay = this.llIIIlllll.getAskPermissionOverlay();
        if (askPermissionOverlay != null) {
            this.IllIIIIllI.addView(askPermissionOverlay);
        }
        this.llIIlIlIIl.create();
        FrameLayout frameLayout2 = this.IllIIIIllI;
        TraceMachine.exitMethod();
        return frameLayout2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LifecycleObserver lifecycleObserver = this.IIlIIIllIl;
        if (lifecycleObserver != null) {
            lifecycleObserver.onDestroy();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        RecognizerRunnerView recognizerRunnerView = this.llIIlIlIIl;
        if (recognizerRunnerView != null) {
            recognizerRunnerView.destroy();
            this.llIIlIlIIl = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        RecognizerRunnerView recognizerRunnerView = this.llIIlIlIIl;
        if (recognizerRunnerView != null) {
            recognizerRunnerView.pause();
        }
        LifecycleObserver lifecycleObserver = this.IIlIIIllIl;
        if (lifecycleObserver != null) {
            lifecycleObserver.onPause();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.llIIIlllll.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        LanguageUtils.setLanguageConfiguration(getResources());
        super.onResume();
        RecognizerRunnerView recognizerRunnerView = this.llIIlIlIIl;
        if (recognizerRunnerView != null) {
            recognizerRunnerView.resume();
            View view = this.lIlIIIIlIl;
            if (view != null) {
                view.setVisibility(0);
            }
        }
        LifecycleObserver lifecycleObserver = this.IIlIIIllIl;
        if (lifecycleObserver != null) {
            lifecycleObserver.onResume();
        }
        CameraPermissionManager cameraPermissionManager = this.llIIIlllll;
        if (cameraPermissionManager != null) {
            cameraPermissionManager.onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        LifecycleObserver lifecycleObserver = this.IIlIIIllIl;
        if (lifecycleObserver != null) {
            lifecycleObserver.onSaveInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        RecognizerRunnerView recognizerRunnerView = this.llIIlIlIIl;
        if (recognizerRunnerView != null) {
            recognizerRunnerView.start();
        }
        LifecycleObserver lifecycleObserver = this.IIlIIIllIl;
        if (lifecycleObserver != null) {
            lifecycleObserver.onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        RecognizerRunnerView recognizerRunnerView = this.llIIlIlIIl;
        if (recognizerRunnerView != null) {
            recognizerRunnerView.stop();
        }
        LifecycleObserver lifecycleObserver = this.IIlIIIllIl;
        if (lifecycleObserver != null) {
            lifecycleObserver.onStop();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0037 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void recreateRecognizerRunnerView() {
        /*
            r6 = this;
            com.microblink.view.recognition.RecognizerRunnerView r0 = r6.llIIlIlIIl
            if (r0 == 0) goto L63
            com.microblink.view.BaseCameraView$CameraViewState r0 = r0.getCameraViewState()
            int[] r1 = com.microblink.fragment.RecognizerRunnerFragment.C36494.llIIlIlIIl
            int r2 = r0.ordinal()
            r2 = r1[r2]
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == r5) goto L1a
            if (r2 == r4) goto L1f
            if (r2 == r3) goto L24
            goto L29
        L1a:
            com.microblink.view.recognition.RecognizerRunnerView r2 = r6.llIIlIlIIl
            r2.pause()
        L1f:
            com.microblink.view.recognition.RecognizerRunnerView r2 = r6.llIIlIlIIl
            r2.stop()
        L24:
            com.microblink.view.recognition.RecognizerRunnerView r2 = r6.llIIlIlIIl
            r2.destroy()
        L29:
            r2 = 0
            r6.llIIlIlIIl = r2
            androidx.fragment.app.FragmentActivity r2 = r6.getActivity()
            r6.llIIlIlIIl(r2)
            com.microblink.view.recognition.RecognizerRunnerView r2 = r6.llIIlIlIIl
            if (r2 != 0) goto L38
            return
        L38:
            int r0 = r0.ordinal()
            r0 = r1[r0]
            if (r0 == r5) goto L4a
            r1 = 0
            if (r0 == r4) goto L4b
            if (r0 == r3) goto L48
            r0 = r1
            r5 = r0
            goto L4d
        L48:
            r0 = r1
            goto L4d
        L4a:
            r1 = r5
        L4b:
            r0 = r1
            r1 = r5
        L4d:
            if (r5 == 0) goto L54
            com.microblink.view.recognition.RecognizerRunnerView r2 = r6.llIIlIlIIl
            r2.create()
        L54:
            if (r1 == 0) goto L5b
            com.microblink.view.recognition.RecognizerRunnerView r1 = r6.llIIlIlIIl
            r1.start()
        L5b:
            if (r0 == 0) goto L62
            com.microblink.view.recognition.RecognizerRunnerView r0 = r6.llIIlIlIIl
            r0.resume()
        L62:
            return
        L63:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "RecognizerRunnerView has not been created yet,it is created in onCreateView() method!"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.fragment.RecognizerRunnerFragment.recreateRecognizerRunnerView():void");
    }

    public void registerLifecycleObserver(LifecycleObserver lifecycleObserver) {
        this.IIlIIIllIl = lifecycleObserver;
    }

    public void setCameraEventsListener(BaseCameraEventsListener baseCameraEventsListener) {
        this.llIIlIIlll = baseCameraEventsListener;
    }

    public void setSplashScreenResourceId(int i) {
        this.lIIIIIllll = i;
    }

    private void llIIlIlIIl(Context context) {
        try {
            this.llIIlIlIIl = new RecognizerRunnerView(context);
        } catch (NonLandscapeOrientationNotSupportedException unused) {
            getActivity().setRequestedOrientation(0);
            getActivity().recreate();
            this.llIIlIlIIl = null;
        } catch (NullPointerException e) {
            e.printStackTrace();
            this.llIIlIlIIl = null;
        }
        if (this.llIIlIlIIl != null) {
            this.IllIIIIllI.removeAllViews();
            this.IllIIIIllI.addView(this.llIIlIlIIl);
            this.IllIIIllII.onRecognizerRunnerViewCreated(this);
            this.llIIlIlIIl.setScanResultListener(this.lllIIIlIlI);
            this.llIIlIlIIl.setFrameRecognitionCallback(this.lllIlIlIIl);
            this.llIIlIlIIl.setCameraEventsListener(this.IlIllIlllI);
        }
    }
}
