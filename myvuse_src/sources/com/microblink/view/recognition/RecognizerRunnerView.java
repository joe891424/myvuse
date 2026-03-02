package com.microblink.view.recognition;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.microblink.blinkid.secured.IIIlIllllI;
import com.microblink.blinkid.secured.IIllIllIII;
import com.microblink.blinkid.secured.IIllIllIIl;
import com.microblink.blinkid.secured.IIllllllll;
import com.microblink.blinkid.secured.IlIIllIlII;
import com.microblink.blinkid.secured.IlIlIlllIl;
import com.microblink.blinkid.secured.IlIllllllI;
import com.microblink.blinkid.secured.lIIlIIIIlI;
import com.microblink.blinkid.secured.llIlIlIlIl;
import com.microblink.blinkid.secured.lllIlIIlIl;
import com.microblink.blinkid.secured.llllIIIIIl;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.geometry.Rectangle;
import com.microblink.hardware.MicroblinkDeviceManager;
import com.microblink.hardware.accelerometer.ShakeCallback;
import com.microblink.hardware.camera.AutoFocusRequiredButNotSupportedException;
import com.microblink.hardware.camera.CameraType;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.hardware.orientation.OrientationChangeListener;
import com.microblink.image.highres.HighResImageWrapper;
import com.microblink.licence.exception.InvalidLicenceKeyException;
import com.microblink.metadata.MetadataCallbacks;
import com.microblink.recognition.FeatureNotSupportedException;
import com.microblink.recognition.FrameAnalyzers;
import com.microblink.recognition.NativeRecognizerWrapper;
import com.microblink.recognition.RecognitionSuccessType;
import com.microblink.recognition.Right;
import com.microblink.recognition.RightsManager;
import com.microblink.recognition.callback.RecognitionProcessCallback;
import com.microblink.util.Log;
import com.microblink.view.BaseCameraView;
import com.microblink.view.CameraEventsListener;
import com.microblink.view.CameraViewGroup;
import com.microblink.view.NotSupportedReason;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class RecognizerRunnerView extends CameraViewGroup implements LifecycleObserver {
    private final BaseCameraView.BaseOrientationChangeListener IIIIIllIll;
    private HighResImageListener IIIlIIlIll;
    private View IIIllIIlIl;
    private boolean IIIlllIlII;
    private FrameAnalyzers IIlIIlIllI;
    private Rectangle IIllIIllll;
    private final IIlIIIllIl IIllIllIII;
    private FrameRecognitionCallback IIllllIIlI;
    private RecognitionProcessCallback IlIIlllIll;
    private MicroblinkDeviceManager IllIllIllI;
    private AtomicBoolean IlllIlllll;
    private RecognizerBundle IlllllIIIl;
    private AtomicBoolean lIIIIIllIl;
    private final BaseCameraView.BaseCameraListener lIIIllIIlI;
    private MetadataCallbacks lIIlllIIlI;
    private Rectangle lIlIllIIlI;
    private AtomicReference<IIllIllIII> lIlIllIIll;
    private ScanResultListener lIllIlIlIl;
    private NotSupportedReason llIIllIlII;
    private AtomicInteger llIIlllIll;
    private AtomicBoolean llIllllIIl;
    private NativeRecognizerWrapper lllIIIllII;
    private final com.microblink.recognition.llIIlIlIIl llllllllll;

    /* JADX INFO: compiled from: line */
    private class IIlIIIllIl implements NativeRecognizerWrapper.lllIlIlIIl, NativeRecognizerWrapper.lllIIIlIlI, IlIlIlllIl {

        /* JADX INFO: compiled from: line */
        class IlIllIlIIl implements Runnable {
            final /* synthetic */ String llIIlIlIIl;

            IlIllIlIIl(String str) {
                this.llIIlIlIIl = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                RecognizerRunnerView.llIIlIlIIl(RecognizerRunnerView.this, this.llIIlIlIIl);
            }
        }

        /* JADX INFO: compiled from: line */
        class llIIlIlIIl implements Runnable {
            final /* synthetic */ Throwable llIIlIlIIl;

            llIIlIlIIl(Throwable th) {
                this.llIIlIlIIl = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                ((BaseCameraView) RecognizerRunnerView.this).llIIlIlIIl.onError(this.llIIlIlIIl);
            }
        }

        private IIlIIIllIl() {
        }

        @Override // com.microblink.blinkid.secured.IlIlIlllIl
        public void onLicenseInformation(String str) {
            RecognizerRunnerView.this.lIIIIIllIl.set(true);
            RecognizerRunnerView.this.llIIlIlIIl(new IlIllIlIIl(str));
        }

        @Override // com.microblink.recognition.NativeRecognizerWrapper.lllIlIlIIl
        public void onRecognitionDone(RecognitionSuccessType recognitionSuccessType) {
            if (RecognizerRunnerView.this.lIIIIIllIl.get()) {
                return;
            }
            Log.m2713v(RecognizerRunnerView.this, "recognition done", new Object[0]);
            boolean z = recognitionSuccessType == RecognitionSuccessType.PARTIAL;
            RecognizerRunnerView recognizerRunnerView = RecognizerRunnerView.this;
            Log.m2713v(recognizerRunnerView, "Is camera active: {}, Should start timer: {}", Boolean.valueOf(recognizerRunnerView.isCameraActive()), Boolean.valueOf(z));
            if (RecognizerRunnerView.this.isCameraActive() && z) {
                RecognizerRunnerView recognizerRunnerView2 = RecognizerRunnerView.this;
                recognizerRunnerView2.setRecognitionTimeout(recognizerRunnerView2.IlllllIIIl.getNumMsBeforeTimeout());
            } else {
                RecognizerRunnerView.IllIIIllII(RecognizerRunnerView.this);
            }
            if (RecognizerRunnerView.this.IIllllIIlI != null) {
                RecognizerRunnerView.this.IIllllIIlI.onFrameRecognitionDone(recognitionSuccessType);
            }
            if (RecognizerRunnerView.this.IlllllIIIl.getRecognitionDebugMode() != RecognizerBundle.RecognitionDebugMode.RECOGNITION) {
                RecognizerRunnerView.this.llIIlIlIIl(true);
                RecognizerRunnerView.this.llIIlIIIll();
            } else if (recognitionSuccessType == RecognitionSuccessType.SUCCESSFUL) {
                RecognizerRunnerView.llIIlIlIIl(RecognizerRunnerView.this, recognitionSuccessType);
            } else {
                RecognizerRunnerView.this.llIIlIIIll();
            }
        }

        @Override // com.microblink.recognition.NativeRecognizerWrapper.lllIlIlIIl
        public void onRecognitionDoneWithTimeout(RecognitionSuccessType recognitionSuccessType) {
            if (RecognizerRunnerView.this.lIIIIIllIl.get()) {
                return;
            }
            Log.m2707d(RecognizerRunnerView.this, "recognition done with timeout", new Object[0]);
            if (RecognizerRunnerView.this.IlllllIIIl.getRecognitionDebugMode() == RecognizerBundle.RecognitionDebugMode.RECOGNITION) {
                RecognizerRunnerView.llIIlIlIIl(RecognizerRunnerView.this, recognitionSuccessType);
            } else {
                RecognizerRunnerView.this.llIIlIlIIl(true);
                RecognizerRunnerView.this.llIIlIIIll();
            }
        }

        @Override // com.microblink.recognition.NativeRecognizerWrapper.lllIIIlIlI
        public void onRecognizerError(Throwable th) {
            RecognizerRunnerView.this.llIIlIlIIl(new llIIlIlIIl(th));
        }

        /* synthetic */ IIlIIIllIl(RecognizerRunnerView recognizerRunnerView, llIIlIlIIl lliililiil) {
            this();
        }
    }

    /* JADX INFO: compiled from: line */
    class IlIllIlIIl implements ShakeCallback {
        IlIllIlIIl() {
        }

        @Override // com.microblink.hardware.accelerometer.ShakeCallback
        public void onShakingStarted() {
        }

        @Override // com.microblink.hardware.accelerometer.ShakeCallback
        public void onShakingStopped() {
            if (RecognizerRunnerView.IlIIlllIIl(RecognizerRunnerView.this)) {
                return;
            }
            RecognizerRunnerView.this.llIIlIlIIl(false);
        }
    }

    /* JADX INFO: compiled from: line */
    class IllIIIIllI implements com.microblink.recognition.llIIlIlIIl {
        IllIIIIllI() {
        }

        @Override // com.microblink.recognition.llIIlIlIIl
        public RecognizerBundle IlIllIlIIl() {
            return RecognizerRunnerView.this.IlllllIIIl;
        }

        @Override // com.microblink.recognition.llIIlIlIIl
        public RecognitionProcessCallback IllIIIIllI() {
            return RecognizerRunnerView.this.IlIIlllIll;
        }

        @Override // com.microblink.recognition.llIIlIlIIl
        public NativeRecognizerWrapper.lllIlIlIIl IllIIIllII() {
            return RecognizerRunnerView.this.IIllIllIII;
        }

        @Override // com.microblink.recognition.llIIlIlIIl
        public NativeRecognizerWrapper.lllIIIlIlI llIIIlllll() {
            return RecognizerRunnerView.this.IIllIllIII;
        }

        @Override // com.microblink.recognition.llIIlIlIIl
        public IIllIllIII llIIlIlIIl() {
            if (RecognizerRunnerView.this.IlllIlllll.get()) {
                return null;
            }
            return (IIllIllIII) RecognizerRunnerView.this.lIlIllIIll.getAndSet(null);
        }
    }

    /* JADX INFO: compiled from: line */
    class IllIIIllII implements Runnable {
        IllIIIllII() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecognizerRunnerView.this.IIIllIIlIl.setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: line */
    class lIlIIIIlIl extends BaseCameraView.BaseCameraListener {
        private long IlIllIlIIl;

        lIlIIIIlIl() {
            super();
            this.IlIllIlIIl = -1L;
        }

        @Override // com.microblink.view.BaseCameraView.BaseCameraListener, com.microblink.blinkid.secured.llIlIlIlIl
        public boolean canReceiveFrame() {
            RecognizerRunnerView recognizerRunnerView = RecognizerRunnerView.this;
            Log.m2713v(recognizerRunnerView, "Recognition paused: {}, Analyzing frame: {}, Camera view state: {}", Boolean.valueOf(recognizerRunnerView.IlllIlllll.get()), Boolean.valueOf(RecognizerRunnerView.this.llIllllIIl.get()), ((BaseCameraView) RecognizerRunnerView.this).llIIIlllll);
            return (RecognizerRunnerView.this.IlllIlllll.get() || RecognizerRunnerView.this.llIllllIIl.get() || ((BaseCameraView) RecognizerRunnerView.this).llIIIlllll != BaseCameraView.CameraViewState.RESUMED) ? false : true;
        }

        /* JADX WARN: Removed duplicated region for block: B:64:0x021b  */
        @Override // com.microblink.view.BaseCameraView.BaseCameraListener, com.microblink.blinkid.secured.llIlIlIlIl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void onCameraFrame(com.microblink.blinkid.secured.IIllIllIII r12) {
            /*
                Method dump skipped, instruction units count: 723
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microblink.view.recognition.RecognizerRunnerView.lIlIIIIlIl.onCameraFrame(com.microblink.blinkid.secured.IIllIllIII):void");
        }

        @Override // com.microblink.view.BaseCameraView.BaseCameraListener, com.microblink.blinkid.secured.llIlIlIlIl
        public void onHighResFrame(IIllIllIII iIllIllIII) {
            if (RecognizerRunnerView.this.IIIlIIlIll != null) {
                RecognizerRunnerView.this.IIIlIIlIll.onHighResImageAvailable(HighResImageWrapper.Factory.createFromFrame(iIllIllIII, RecognizerRunnerView.this.getOrientationForRecognition()));
            }
        }
    }

    /* JADX INFO: compiled from: line */
    class llIIIlllll implements Runnable {
        llIIIlllll() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecognizerRunnerView.this.IIIllIIlIl.setVisibility(0);
        }
    }

    /* JADX INFO: compiled from: line */
    class llIIlIIlll extends CameraViewGroup.CameraViewGroupOrientationChangeListener {
        llIIlIIlll() {
            super();
        }

        @Override // com.microblink.view.CameraViewGroup.CameraViewGroupOrientationChangeListener, com.microblink.view.BaseCameraView.BaseOrientationChangeListener, com.microblink.hardware.orientation.OrientationChangeListener
        public final void onOrientationChange(Orientation orientation) {
            super.onOrientationChange(orientation);
            if (RecognizerRunnerView.this.lllIIIllII == null || orientation == Orientation.ORIENTATION_UNKNOWN || !RecognizerRunnerView.this.llIIlIlIIl(orientation) || !RecognizerRunnerView.this.IIIlllIlII || RecognizerRunnerView.this.IIllIIllll == null) {
                return;
            }
            RecognizerRunnerView.this.IlIllIlIIl(orientation);
            RecognizerRunnerView.this.IlIIlllIll.setScanningRegion(RecognizerRunnerView.this.lIlIllIIlI);
        }
    }

    /* JADX INFO: compiled from: line */
    class llIIlIlIIl implements BaseCameraView.VisiblePartUpdateListener {
        llIIlIlIIl() {
        }

        @Override // com.microblink.view.BaseCameraView.VisiblePartUpdateListener
        public void onVisiblePartUpdated(RectF rectF) {
            if (RecognizerRunnerView.this.IIllIllIII != null) {
                if (RecognizerRunnerView.this.IlIIlllIIl()) {
                    RecognizerRunnerView.this.IlIIlllIll.setVisiblePartRelativeDestination(Rectangle.fromRectF(rectF));
                } else {
                    RecognizerRunnerView.this.IlIIlllIll.setVisiblePartRelativeDestination(null);
                }
            }
        }
    }

    public RecognizerRunnerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.llIIllIlII = null;
        this.lllIIIllII = null;
        this.IIllIIllll = Rectangle.getDefaultROI();
        this.lIlIllIIlI = Rectangle.getDefaultROI();
        this.IIIlllIlII = false;
        this.IlllIlllll = new AtomicBoolean(true);
        this.lIIIIIllIl = new AtomicBoolean(false);
        this.lIIlllIIlI = new MetadataCallbacks();
        this.lIlIllIIll = new AtomicReference<>(null);
        this.llIllllIIl = new AtomicBoolean(false);
        this.llIIlllIll = new AtomicInteger(0);
        this.IIllIllIII = new IIlIIIllIl(this, null);
        this.llllllllll = new IllIIIIllI();
        this.lIIIllIIlI = new lIlIIIIlIl();
        this.IIIIIllIll = new llIIlIIlll();
        this.IIIllIIlIl = new lllIlIIlIl(context, null);
        IlIllIlIIl(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean IlIIlllIIl() {
        return this.lllIIIlIlI != 1.0f && this.IIllIIllll.equals(Rectangle.getDefaultROI());
    }

    static void IllIIIllII(RecognizerRunnerView recognizerRunnerView) {
        recognizerRunnerView.lllIIIllII.llIIlIlIIl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Orientation getOrientationForRecognition() {
        Orientation currentOrientation = getCurrentOrientation();
        if (currentOrientation == null || currentOrientation == Orientation.ORIENTATION_UNKNOWN) {
            currentOrientation = getInitialOrientation();
        }
        if (llIIlIlIIl()) {
            currentOrientation = currentOrientation.rotate180();
        }
        Log.m2707d(this, "Current orientation for recognition: {}", currentOrientation);
        return currentOrientation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRecognitionTimeout(int i) {
        this.lllIIIllII.llIIlIlIIl(i);
    }

    @Override // com.microblink.view.BaseCameraView
    protected void IIlIIIllIl() {
    }

    public void captureHighResImage(HighResImageListener highResImageListener) {
        this.IIIlIIlIll = highResImageListener;
        IllIIIllII();
    }

    @Override // com.microblink.view.CameraViewGroup, com.microblink.view.BaseCameraView
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void create() {
        if (this.llIIIlllll != BaseCameraView.CameraViewState.DESTROYED) {
            throw new IllegalStateException(IIllIllIIl.llIIlIlIIl("It is not allowed to call create() on already created view (state is ").append(this.llIIIlllll.name()).append(")").toString());
        }
        IIIlIllllI.llIIlIlIIl();
        FrameAnalyzers frameAnalyzers = this.IIlIIlIllI;
        if (frameAnalyzers == null) {
            this.IIlIIlIllI = new FrameAnalyzers(this.IlllllIIIl, this.IllIllIllI.IlIllIlIIl());
        } else {
            frameAnalyzers.llIIlIlIIl(this.IlllllIIIl);
        }
        this.IlIIlllIll = new RecognitionProcessCallback(this.IIllIllIII, this.lIIlllIIlI, this.lIlIllIIlI, this.IlllllIIIl.getRecognitionDebugMode());
        setVisiblePartUpdateListener(new llIIlIlIIl());
        if (this.lIllIlIlIl == null) {
            throw new NullPointerException("Please set ScanResultListener with method setScanResultListener before calling create method!");
        }
        setCameraFrameFactory(new IlIIllIlII());
        super.create();
        View view = this.IIIllIIlIl;
        if (view != null) {
            view.setVisibility(8);
            addChildView(this.IIIllIIlIl, false);
        }
    }

    @Override // com.microblink.view.BaseCameraView
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void destroy() {
        super.destroy();
        this.IlIIlllIll.dispose();
        this.IlIIlllIll = null;
        this.IIlIIlIllI.llIIlIlIIl();
        this.IIlIIlIllI = null;
    }

    public RecognizerBundle getRecognizerBundle() {
        return this.IlllllIIIl;
    }

    public ScanResultListener getScanResultListener() {
        return this.lIllIlIlIl;
    }

    public Rectangle getScanningRegion() {
        return this.IIllIIllll;
    }

    public boolean isScanningPaused() {
        RecognitionProcessCallback recognitionProcessCallback = this.IlIIlllIll;
        return recognitionProcessCallback == null || recognitionProcessCallback.getCancelDelegate().IlIllIlIIl();
    }

    @Override // com.microblink.view.BaseCameraView
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void pause() {
        if (this.llIIIlllll != BaseCameraView.CameraViewState.RESUMED) {
            throw new IllegalStateException(IIllIllIIl.llIIlIlIIl("Cannot pause view that has not been resumed. Please make sure that your view has been resumed with resume() method. State is ").append(this.llIIIlllll.name()).toString());
        }
        IlIlllllII();
        this.lllIIIllII.llIIlIIlll();
        while (this.llIllllIIl.get()) {
        }
        super.pause();
    }

    public final void pauseScanning() {
        if (this.llIIlllIll.getAndIncrement() == 0) {
            IlIlllllII();
        }
        Log.m2711i(this, "pauseScanning: pause count is {}", this.llIIlllIll);
    }

    public void reconfigureRecognizers(RecognizerBundle recognizerBundle) {
        if (recognizerBundle != null) {
            BaseCameraView.CameraViewState cameraViewState = this.llIIIlllll;
            if (cameraViewState == BaseCameraView.CameraViewState.DESTROYED || cameraViewState == BaseCameraView.CameraViewState.CREATED) {
                throw new IllegalStateException("Method must be called after calling start()");
            }
            Boolean boolIsAutofocusSupported = isAutofocusSupported();
            if (boolIsAutofocusSupported == null) {
                Log.m2715w(this, "Reconfiguring recognizers while camera is paused. Cannot perform autofocus check.", new Object[0]);
            } else if (!boolIsAutofocusSupported.booleanValue() && llIIlIlIIl(recognizerBundle.getRecognizers())) {
                throw new AutoFocusRequiredButNotSupportedException("New recognition settings require camera with autofocus, while opened camera does not support that!");
            }
            this.IlllllIIIl = recognizerBundle;
            this.IIlIIlIllI.llIIlIlIIl(recognizerBundle);
            NativeRecognizerWrapper nativeRecognizerWrapper = this.lllIIIllII;
            if (nativeRecognizerWrapper != null) {
                nativeRecognizerWrapper.llIIlIlIIl(this.IlllllIIIl, this.IIllIllIII);
            }
        }
    }

    public final void resetRecognitionState() {
        resetRecognitionState(true);
    }

    @Override // com.microblink.view.BaseCameraView
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void resume() {
        if (this.llIIIlllll != BaseCameraView.CameraViewState.STARTED) {
            throw new IllegalStateException(IIllIllIIl.llIIlIlIIl("Cannot resume view that has not been started. Please call start() first. State is ").append(this.llIIIlllll.name()).toString());
        }
        Log.m2711i(this, "RecognizerRunner view resume: Context = {}", getContext());
        if (this.llIIllIlII == null) {
            super.resume();
        } else {
            this.llIIIlllll = BaseCameraView.CameraViewState.RESUMED;
        }
    }

    public final void resumeScanning(boolean z) {
        if (this.llIIlllIll.decrementAndGet() <= 0) {
            IlIllIlIIl(z);
        }
        Log.m2711i(this, "resumeScanning: pause count is {}", Integer.valueOf(this.llIIlllIll.get()));
    }

    public void setFrameRecognitionCallback(FrameRecognitionCallback frameRecognitionCallback) {
        this.IIllllIIlI = frameRecognitionCallback;
    }

    public void setLifecycle(Lifecycle lifecycle) {
        lifecycle.addObserver(this);
    }

    public void setMetadataCallbacks(MetadataCallbacks metadataCallbacks) {
        if (metadataCallbacks == null) {
            metadataCallbacks = new MetadataCallbacks();
        }
        this.lIIlllIIlI = metadataCallbacks;
        RecognitionProcessCallback recognitionProcessCallback = this.IlIIlllIll;
        if (recognitionProcessCallback != null) {
            recognitionProcessCallback.setMetadataCallbacks(metadataCallbacks);
        }
    }

    public void setRecognizerBundle(RecognizerBundle recognizerBundle) {
        if (this.llIIIlllll != BaseCameraView.CameraViewState.DESTROYED) {
            throw new IllegalStateException("Method setRecognizerBundle must be called before calling create()");
        }
        if (recognizerBundle != null) {
            this.IlllllIIIl = recognizerBundle;
        }
    }

    public void setScanResultListener(ScanResultListener scanResultListener) {
        if (this.llIIIlllll != BaseCameraView.CameraViewState.DESTROYED) {
            throw new IllegalStateException("Method setScanResultListener must be called before calling create()");
        }
        this.lIllIlIlIl = scanResultListener;
    }

    public final void setScanningRegion(Rectangle rectangle, boolean z) {
        this.IIllIIllll = rectangle;
        this.IIIlllIlII = z;
        if (rectangle != null && !rectangle.isRelative()) {
            throw new IllegalArgumentException("Scanning region must be given in relative coordinates, i.e. following must hold true: x + width <= 1.f && y + height <= 1.f. Given region is " + rectangle);
        }
        if (getOpenedCameraType() != null) {
            IlIllIlIIl(getCurrentOrientation());
            Log.m2707d(this, "Updated scanning region", new Object[0]);
            RecognitionProcessCallback recognitionProcessCallback = this.IlIIlllIll;
            if (recognitionProcessCallback != null) {
                recognitionProcessCallback.setScanningRegion(this.lIlIllIIlI);
            }
        }
    }

    public boolean shouldRotateScanningRegion() {
        return this.IIIlllIlII;
    }

    @Override // com.microblink.view.BaseCameraView
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void start() {
        CameraEventsListener cameraEventsListener;
        super.start();
        Context context = getContext();
        Log.m2711i(this, "Loading Native Library!", new Object[0]);
        if (this.lllIIIllII == null) {
            this.lllIIIllII = NativeRecognizerWrapper.INSTANCE;
        }
        this.lllIIIllII.llIIlIlIIl(this.llllllllll);
        NotSupportedReason notSupportedReason = null;
        try {
            boolean zLlIIIlllll = RightsManager.llIIIlllll();
            NotSupportedReason notSupportedReasonIllIIIllII = this.IllIllIllI.IllIIIllII();
            if (notSupportedReasonIllIIIllII != null) {
                notSupportedReason = notSupportedReasonIllIIIllII;
            } else if (!zLlIIIlllll) {
                notSupportedReason = NotSupportedReason.INVALID_OR_MISSING_LICENSE;
            } else if (!com.microblink.view.recognition.llIIlIlIIl.llIIlIlIIl(context)) {
                notSupportedReason = NotSupportedReason.CUSTOM_UI_FORBIDDEN;
            } else if (!this.IlIllIlIIl) {
                this.lllIIIllII.llIIlIlIIl(getContext(), this.IlllllIIIl, this.IIllIllIII);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            CameraEventsListener cameraEventsListener2 = this.llIIlIlIIl;
            if (cameraEventsListener2 != null) {
                cameraEventsListener2.onError(th);
            }
            this.IlIllIlIIl = true;
        }
        this.llIIllIlII = notSupportedReason;
        Log.m2711i(this, "Not support reason: {}", notSupportedReason);
        if (this.llIIllIlII == null || (cameraEventsListener = this.llIIlIlIIl) == null) {
            return;
        }
        cameraEventsListener.onError(new FeatureNotSupportedException(this.llIIllIlII));
    }

    @Override // com.microblink.view.BaseCameraView
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void stop() {
        super.stop();
        NativeRecognizerWrapper nativeRecognizerWrapper = this.lllIIIllII;
        if (nativeRecognizerWrapper != null) {
            nativeRecognizerWrapper.llIIlIlIIl((com.microblink.recognition.llIIlIlIIl) null);
            this.lllIIIllII.llIIIlllll();
            this.lllIIIllII = null;
        }
    }

    static boolean IlIIlllIIl(RecognizerRunnerView recognizerRunnerView) {
        NativeRecognizerWrapper nativeRecognizerWrapper;
        llllIIIIIl lllliiiiilIlIllIlIIl;
        return recognizerRunnerView.isScanningPaused() || (nativeRecognizerWrapper = recognizerRunnerView.lllIIIllII) == null || (lllliiiiilIlIllIlIIl = nativeRecognizerWrapper.IlIllIlIIl()) == llllIIIIIl.DONE || lllliiiiilIlIllIlIIl == llllIIIIIl.UNINITIALIZED;
    }

    private void IlIlllllII() {
        lIIIIIlIlI();
        RecognitionProcessCallback recognitionProcessCallback = this.IlIIlllIll;
        if (recognitionProcessCallback != null) {
            recognitionProcessCallback.getCancelDelegate().llIIlIlIIl(true);
        }
        NativeRecognizerWrapper nativeRecognizerWrapper = this.lllIIIllII;
        if (nativeRecognizerWrapper != null) {
            nativeRecognizerWrapper.IlIllIlIIl(true);
        }
    }

    private void lIIIIIlIlI() {
        this.IlllIlllll.set(true);
        IIllIllIII andSet = this.lIlIllIIll.getAndSet(null);
        if (andSet != null) {
            andSet.IllIIIllII();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void llIIlIIIll() {
        NativeRecognizerWrapper nativeRecognizerWrapper = this.lllIIIllII;
        if (nativeRecognizerWrapper != null) {
            Log.m2707d(this, "Before preparing for next recognition, recognizer state is: {}", nativeRecognizerWrapper.IlIllIlIIl());
        }
        NativeRecognizerWrapper nativeRecognizerWrapper2 = this.lllIIIllII;
        if (nativeRecognizerWrapper2 == null || nativeRecognizerWrapper2.IlIllIlIIl() != llllIIIIIl.DONE) {
            return;
        }
        this.lllIIIllII.IllIIIllII();
    }

    @Override // com.microblink.view.BaseCameraView
    protected boolean IlIllIlllI() {
        return llIIlIlIIl(this.IlllllIIIl.getRecognizers());
    }

    @Override // com.microblink.view.CameraViewGroup, com.microblink.view.BaseCameraView
    protected final OrientationChangeListener IllIIIIllI() {
        return this.IIIIIllIll;
    }

    @Override // com.microblink.view.BaseCameraView
    protected final boolean IllIIlIIII() {
        try {
            NativeRecognizerWrapper nativeRecognizerWrapper = this.lllIIIllII;
            if (nativeRecognizerWrapper != null) {
                nativeRecognizerWrapper.llIIlIlIIl(true);
            }
            return IIIlIllllI.IlIllIlIIl();
        } catch (UnsatisfiedLinkError e) {
            Log.m2710e(this, e, "Unable to load native library", new Object[0]);
            throw e;
        }
    }

    @Override // com.microblink.view.BaseCameraView
    protected void lIIIIIllll() {
        if (getCameraViewState() != BaseCameraView.CameraViewState.RESUMED) {
            Log.m2715w(this, "Camera preview started callback received after view was paused", new Object[0]);
            return;
        }
        Orientation currentOrientation = getCurrentOrientation();
        if (currentOrientation == null || currentOrientation == Orientation.ORIENTATION_UNKNOWN) {
            currentOrientation = getInitialOrientation();
        }
        if (currentOrientation == null || currentOrientation == Orientation.ORIENTATION_UNKNOWN) {
            currentOrientation = getConfigurationOrientation() == 1 ? Orientation.ORIENTATION_PORTRAIT : Orientation.ORIENTATION_LANDSCAPE_RIGHT;
        }
        IlIllIlIIl(currentOrientation);
        this.IlIIlllIll.setScanningRegion(this.lIlIllIIlI);
        if (this.IIIllIIlIl != null) {
            if (RightsManager.llIIIlllll() && RightsManager.llIIlIlIIl(Right.ALLOW_REMOVE_DEMO_OVERLAY)) {
                llIIlIlIIl(new IllIIIllII());
            } else {
                llIIlIlIIl(new llIIIlllll());
            }
        }
        RecognitionProcessCallback recognitionProcessCallback = this.IlIIlllIll;
        if (recognitionProcessCallback != null) {
            recognitionProcessCallback.setCameraOptions(getOpenedCameraType() == CameraType.CAMERA_FRONTFACE, llIIlIlIIl());
        }
        if (this.llIIlllIll.get() <= 0) {
            IlIllIlIIl(true);
        }
    }

    @Override // com.microblink.view.BaseCameraView
    protected final llIlIlIlIl llIIIlllll() {
        return this.lIIIllIIlI;
    }

    @Override // com.microblink.view.BaseCameraView
    protected void lllIIIlIlI() {
        IIllIllIII andSet = this.lIlIllIIll.getAndSet(null);
        if (andSet != null) {
            andSet.IllIIIllII();
        }
    }

    public final void resetRecognitionState(boolean z) {
        llIIlIlIIl(z);
    }

    private void IlIllIlIIl(Context context) {
        if (isInEditMode()) {
            return;
        }
        this.IllIllIllI = MicroblinkDeviceManager.llIIlIlIIl(context);
        if (RightsManager.llIIIlllll()) {
            getContext().getApplicationContext();
            return;
        }
        throw new InvalidLicenceKeyException("Please set valid license key before creating RecognizerRunnerView");
    }

    @Override // com.microblink.view.BaseCameraView
    protected final void llIIlIlIIl(IIllllllll iIllllllll) {
        super.llIIlIlIIl(iIllllllll);
        iIllllllll.llIIIlllll(false);
        iIllllllll.IlIllIlIIl(230400);
        iIllllllll.llIIlIlIIl(new IlIllIlIIl());
    }

    static RectF llIIlIlIIl(RecognizerRunnerView recognizerRunnerView, RectF rectF) {
        float fWidth;
        float width;
        float f;
        float height;
        if (recognizerRunnerView.IlIIlllIIl()) {
            height = 1.0f;
            fWidth = 0.0f;
            width = 1.0f;
            f = 0.0f;
        } else {
            fWidth = (rectF.width() * recognizerRunnerView.lIlIllIIlI.getX()) + rectF.left;
            float fHeight = rectF.top + (rectF.height() * recognizerRunnerView.lIlIllIIlI.getY());
            width = recognizerRunnerView.lIlIllIIlI.getWidth() * rectF.width();
            f = fHeight;
            height = recognizerRunnerView.lIlIllIIlI.getHeight() * rectF.height();
        }
        RectF rectF2 = new RectF(fWidth, f, width + fWidth, height + f);
        Log.m2713v(recognizerRunnerView, "From visible {}, scanning region {} and zoomScale {}, calculated absolute region is {}", rectF, recognizerRunnerView.lIlIllIIlI, Float.valueOf(recognizerRunnerView.lllIIIlIlI), rectF2);
        return rectF2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a8 A[PHI: r0
      0x00a8: PHI (r0v12 float) = (r0v11 float), (r0v15 float) binds: [B:20:0x00a6, B:17:0x00a1] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void IlIllIlIIl(com.microblink.hardware.orientation.Orientation r7) {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.view.recognition.RecognizerRunnerView.IlIllIlIIl(com.microblink.hardware.orientation.Orientation):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void llIIlIlIIl(boolean z) {
        if (this.lllIIIllII != null) {
            Log.m2707d(this, "Resetting recognizer state!", new Object[0]);
            this.lllIIIllII.llIIlIlIIl(z);
        }
    }

    private boolean llIIlIlIIl(Recognizer[] recognizerArr) {
        if (recognizerArr == null) {
            return false;
        }
        for (Recognizer recognizer : recognizerArr) {
            if (recognizer != null && recognizer.requiresAutofocus()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.microblink.view.CameraViewGroup, com.microblink.view.BaseCameraView
    protected void llIIlIlIIl(Configuration configuration) {
        super.llIIlIlIIl(configuration);
        if (getOpenedCameraType() != null) {
            IlIllIlIIl(getCurrentOrientation());
            Log.m2707d(this, "Updated scanning region", new Object[0]);
            RecognitionProcessCallback recognitionProcessCallback = this.IlIIlllIll;
            if (recognitionProcessCallback != null) {
                recognitionProcessCallback.setScanningRegion(this.lIlIllIIlI);
            }
        }
    }

    static void llIIlIlIIl(RecognizerRunnerView recognizerRunnerView, String str) {
        if (recognizerRunnerView.IlllIlllll.get()) {
            return;
        }
        AlertDialog alertDialogCreate = new AlertDialog.Builder(recognizerRunnerView.getContext()).setCancelable(false).setTitle("Library information").setMessage(str).setNeutralButton("OK", new com.microblink.view.recognition.IlIllIlIIl(recognizerRunnerView)).create();
        if (recognizerRunnerView.llIIIlllll == BaseCameraView.CameraViewState.RESUMED) {
            recognizerRunnerView.lIIIIIlIlI();
            alertDialogCreate.show();
        }
    }

    static void llIIlIlIIl(RecognizerRunnerView recognizerRunnerView, RecognitionSuccessType recognitionSuccessType) {
        if (!recognizerRunnerView.IlllIlllll.get()) {
            RecognitionProcessCallback recognitionProcessCallback = recognizerRunnerView.IlIIlllIll;
            if (recognitionProcessCallback == null || recognitionProcessCallback.getCancelDelegate().IlIllIlIIl()) {
                return;
            }
            recognizerRunnerView.lIIIIIlIlI();
            recognizerRunnerView.lIllIlIlIl.onScanningDone(recognitionSuccessType);
            IlIllllllI.llIIlIlIIl().llIIlIlIIl(recognizerRunnerView.IlllllIIIl, lIIlIIIIlI.VIDEO_STREAM);
            if (recognizerRunnerView.llIIlllIll.get() <= 0) {
                recognizerRunnerView.IlllIlllll.set(false);
                recognizerRunnerView.llIIlIIIll();
                return;
            }
            return;
        }
        Log.m2711i(recognizerRunnerView, "Recognition has been paused, will not raise scanning done event.", new Object[0]);
    }

    private void IlIllIlIIl(boolean z) {
        this.llIIlllIll.set(0);
        RecognitionProcessCallback recognitionProcessCallback = this.IlIIlllIll;
        if (recognitionProcessCallback != null) {
            recognitionProcessCallback.getCancelDelegate().llIIlIlIIl(false);
        }
        NativeRecognizerWrapper nativeRecognizerWrapper = this.lllIIIllII;
        if (nativeRecognizerWrapper != null) {
            nativeRecognizerWrapper.IlIllIlIIl(false);
        }
        if (z) {
            llIIlIlIIl(true);
        }
        this.IlllIlllll.set(false);
        llIIlIIIll();
    }

    static void IlIllIlIIl(RecognizerRunnerView recognizerRunnerView, boolean z) {
        if (recognizerRunnerView.llIIlllIll.get() <= 0) {
            recognizerRunnerView.IlIllIlIIl(z);
        }
    }

    public RecognizerRunnerView(Context context) {
        this(context, null);
    }
}
