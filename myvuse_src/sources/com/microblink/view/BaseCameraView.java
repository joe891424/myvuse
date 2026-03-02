package com.microblink.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.facebook.imagepipeline.common.RotationOptions;
import com.microblink.blinkid.secured.IIIIlIlIll;
import com.microblink.blinkid.secured.IIIIlIllIl;
import com.microblink.blinkid.secured.IIlIIlIllI;
import com.microblink.blinkid.secured.IIllIllIII;
import com.microblink.blinkid.secured.IIllIllIIl;
import com.microblink.blinkid.secured.IIllllllll;
import com.microblink.blinkid.secured.IlIIIIIlll;
import com.microblink.blinkid.secured.lIIIlIIllI;
import com.microblink.blinkid.secured.lIlIIlIIll;
import com.microblink.blinkid.secured.lIlIllIIlI;
import com.microblink.blinkid.secured.llIlIlIlIl;
import com.microblink.blinkid.secured.llllllllll;
import com.microblink.hardware.SuccessCallback;
import com.microblink.hardware.accelerometer.ShakeCallback;
import com.microblink.hardware.camera.CameraType;
import com.microblink.hardware.camera.VideoResolutionPreset;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.hardware.orientation.OrientationChangeListener;
import com.microblink.util.Log;
import com.microblink.view.exception.CalledFromWrongThreadException;
import com.microblink.view.exception.NonLandscapeOrientationNotSupportedException;
import com.microblink.view.surface.CameraSurface;
import com.microblink.view.surface.ICameraView;
import com.microblink.view.surface.IllIIIllII;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseCameraView extends ViewGroup {
    private VisiblePartUpdateListener IIIIIIIIII;
    private boolean IIIllIlIIl;
    protected int IIlIIIllIl;
    private boolean IIlIlIIlll;
    private float IIlIlllIIl;
    private RectF IlIIIIIlll;
    private int IlIIlIIIII;
    private llllllllll IlIIlllIIl;
    private OrientationAllowedListener IlIlIIllll;
    private Handler IlIlIlIIlI;
    protected boolean IlIllIlIIl;
    protected boolean IlIllIlllI;
    protected Orientation IlIlllllII;
    protected ICameraView IllIIIIllI;
    protected lIlIllIIlI IllIIIllII;
    protected OrientationChangeListener IllIIlIIII;
    private boolean IlllIIIllI;
    protected boolean lIIIIIlIlI;
    protected CameraAspectMode lIIIIIllll;
    private boolean lIIIlIIllI;
    protected int lIlIIIIlIl;
    private Orientation lIlIIlIIll;
    private IIllllllll lIllIIlIIl;
    private IIIIlIlIll lIlllIlIlI;
    protected CameraViewState llIIIlllll;
    protected ConcurrentLinkedQueue<OrientationChangeListener> llIIlIIIll;
    protected OnActivityFlipListener llIIlIIlll;
    protected CameraEventsListener llIIlIlIIl;
    private RectF[] llIlIlIlIl;
    private OnSizeChangedListener llIllIIlll;
    protected float lllIIIlIlI;
    private int lllIIlIIlI;
    protected boolean lllIlIlIIl;
    private ShakeCallback lllllIlIll;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: compiled from: line */
    public abstract class BaseCameraListener implements llIlIlIlIl {

        /* JADX INFO: compiled from: line */
        class IlIllIlIIl implements Runnable {
            final /* synthetic */ Rect[] llIIlIlIIl;

            IlIllIlIIl(Rect[] rectArr) {
                this.llIIlIlIIl = rectArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseCameraView.this.llIIlIlIIl.onAutofocusStopped(BaseCameraView.llIIlIlIIl(BaseCameraView.this, this.llIIlIlIIl));
            }
        }

        /* JADX INFO: compiled from: line */
        class llIIlIlIIl implements Runnable {
            final /* synthetic */ Rect[] llIIlIlIIl;

            llIIlIlIIl(Rect[] rectArr) {
                this.llIIlIlIIl = rectArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseCameraView.this.llIIlIlIIl.onAutofocusStarted(BaseCameraView.llIIlIlIIl(BaseCameraView.this, this.llIIlIlIIl));
            }
        }

        protected BaseCameraListener() {
        }

        @Override // com.microblink.blinkid.secured.llIlIlIlIl
        public abstract /* synthetic */ boolean canReceiveFrame();

        @Override // com.microblink.hardware.camera.AutofocusListener
        public final void onAutofocusFailed() {
            CameraEventsListener cameraEventsListener = BaseCameraView.this.llIIlIlIIl;
            if (cameraEventsListener != null) {
                cameraEventsListener.onAutofocusFailed();
            }
        }

        @Override // com.microblink.hardware.camera.AutofocusListener
        public final void onAutofocusStarted(Rect[] rectArr) {
            BaseCameraView baseCameraView = BaseCameraView.this;
            if (baseCameraView.llIIlIlIIl != null) {
                baseCameraView.llIIlIlIIl(new llIIlIlIIl(rectArr));
            }
        }

        @Override // com.microblink.hardware.camera.AutofocusListener
        public final void onAutofocusStopped(Rect[] rectArr) {
            BaseCameraView baseCameraView = BaseCameraView.this;
            if (baseCameraView.llIIlIlIIl != null) {
                baseCameraView.llIIlIlIIl(new IlIllIlIIl(rectArr));
            }
        }

        @Override // com.microblink.blinkid.secured.llIlIlIlIl
        public abstract /* synthetic */ void onCameraFrame(IIllIllIII iIllIllIII);

        @Override // com.microblink.blinkid.secured.llIlIlIlIl
        public abstract /* synthetic */ void onHighResFrame(IIllIllIII iIllIllIII);
    }

    /* JADX INFO: compiled from: line */
    protected class BaseCameraViewEventsListener implements ICameraView.CameraViewEventListener {
        protected BaseCameraViewEventsListener() {
        }

        @Override // com.microblink.view.surface.ICameraView.CameraViewEventListener
        public void onCameraPinchEvent(float f) {
            if (!BaseCameraView.this.lIIIlIIllI || BaseCameraView.this.IlIIlllIIl == null) {
                return;
            }
            BaseCameraView baseCameraView = BaseCameraView.this;
            baseCameraView.setZoomLevel(baseCameraView.IIlIlllIIl + (f - 1.0f));
        }

        @Override // com.microblink.view.surface.ICameraView.CameraViewEventListener
        public void onCameraTapEvent(float f, float f2) {
            if (!BaseCameraView.this.IIIllIlIIl || BaseCameraView.this.IlIIlllIIl == null || BaseCameraView.this.getCurrentOrientation() == null) {
                return;
            }
            if (BaseCameraView.this.llIlIlIlIl == null) {
                float f3 = f - 0.165f;
                float f4 = f2 - 0.165f;
                if (f3 > 1.0f || f4 > 1.0f) {
                    return;
                }
                if (f3 < 0.0f) {
                    f3 = 0.0f;
                }
                if (f4 < 0.0f) {
                    f4 = 0.0f;
                }
                BaseCameraView.this.setMeteringAreas(new RectF[]{new RectF(f3, f4, (f3 + 0.33f > 1.0f ? 1.0f - f3 : 0.33f) + f3, (f4 + 0.33f > 1.0f ? 1.0f - f4 : 0.33f) + f4)}, false);
            }
            BaseCameraView.this.focusCamera();
        }
    }

    /* JADX INFO: compiled from: line */
    protected class BaseOrientationChangeListener implements OrientationChangeListener {
        protected BaseOrientationChangeListener() {
        }

        private boolean llIIlIlIIl(int i, Orientation orientation) {
            return i != 0 ? i != 1 ? i != 8 ? i == 9 && orientation == Orientation.ORIENTATION_PORTRAIT : orientation == Orientation.ORIENTATION_LANDSCAPE_RIGHT : orientation == Orientation.ORIENTATION_PORTRAIT_UPSIDE : orientation == Orientation.ORIENTATION_LANDSCAPE_LEFT;
        }

        @Override // com.microblink.hardware.orientation.OrientationChangeListener
        public void onOrientationChange(Orientation orientation) {
            BaseCameraView baseCameraView = BaseCameraView.this;
            int i = baseCameraView.IIlIIIllIl;
            int i2 = 9;
            Log.m2711i(baseCameraView, "Orientation changed to {}, host screen orientation is {}", orientation, i != 0 ? i != 1 ? i != 8 ? i != 9 ? "unknown" : "reverse_portrait" : "reverse_landscape" : "portrait" : "landscape");
            BaseCameraView baseCameraView2 = BaseCameraView.this;
            Log.m2711i(baseCameraView2, "is host activity on sensor: {}", Boolean.valueOf(baseCameraView2.llIIlIIlll()));
            BaseCameraView baseCameraView3 = BaseCameraView.this;
            Log.m2711i(baseCameraView3, "is flipped: {}", Boolean.valueOf(llIIlIlIIl(baseCameraView3.IIlIIIllIl, orientation)));
            if (BaseCameraView.this.llIIlIIlll() && llIIlIlIIl(BaseCameraView.this.IIlIIIllIl, orientation)) {
                Log.m2711i(BaseCameraView.this, "Activity is flipped", new Object[0]);
                BaseCameraView baseCameraView4 = BaseCameraView.this;
                if (baseCameraView4.llIIIlllll != CameraViewState.DESTROYED) {
                    int i3 = llIIlIlIIl.llIIlIlIIl[orientation.ordinal()];
                    if (i3 == 1) {
                        i2 = 0;
                    } else if (i3 == 2) {
                        i2 = 8;
                    } else if (i3 == 3) {
                        i2 = 1;
                    } else if (i3 != 4) {
                        i2 = -1;
                    }
                    baseCameraView4.IIlIIIllIl = i2;
                    BaseCameraView baseCameraView5 = BaseCameraView.this;
                    baseCameraView5.llIIlIlIIl(baseCameraView5.getContext().getResources().getConfiguration());
                    BaseCameraView.this.IIlIIIllIl();
                    OnActivityFlipListener onActivityFlipListener = BaseCameraView.this.llIIlIIlll;
                    if (onActivityFlipListener != null) {
                        onActivityFlipListener.onActivityFlip();
                    }
                }
            }
            if (BaseCameraView.this.llIIlIlIIl(orientation)) {
                Log.m2713v(BaseCameraView.this, "{} orientation is allowed. Dispatching...", orientation);
                BaseCameraView.this.lIlIIlIIll = orientation;
                BaseCameraView baseCameraView6 = BaseCameraView.this;
                if (baseCameraView6.lIIIIIlIlI) {
                    baseCameraView6.lllIlIlIIl();
                }
            }
        }
    }

    /* JADX INFO: compiled from: line */
    public enum CameraViewState {
        DESTROYED,
        CREATED,
        STARTED,
        RESUMED
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: compiled from: line */
    public interface VisiblePartUpdateListener {
        void onVisiblePartUpdated(RectF rectF);
    }

    /* JADX INFO: compiled from: line */
    static /* synthetic */ class llIIlIlIIl {
        static final /* synthetic */ int[] llIIlIlIIl;

        static {
            int[] iArr = new int[Orientation.values().length];
            llIIlIlIIl = iArr;
            try {
                iArr[Orientation.ORIENTATION_LANDSCAPE_RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                llIIlIlIIl[Orientation.ORIENTATION_LANDSCAPE_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                llIIlIlIIl[Orientation.ORIENTATION_PORTRAIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                llIIlIlIIl[Orientation.ORIENTATION_PORTRAIT_UPSIDE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public BaseCameraView(Context context) {
        super(context);
        this.IlIllIlIIl = false;
        this.IllIIIllII = null;
        this.llIIIlllll = CameraViewState.DESTROYED;
        this.IIlIIIllIl = 1;
        this.lIIIIIllll = CameraAspectMode.ASPECT_FILL;
        this.lllIIIlIlI = 1.0f;
        this.IlIllIlllI = false;
        this.lllIlIlIIl = false;
        this.lIIIIIlIlI = false;
        this.llIIlIIIll = new ConcurrentLinkedQueue<>();
        this.lIlllIlIlI = null;
        this.lIllIIlIIl = new IIllllllll();
        this.lllIIlIIlI = 0;
        this.IlIIlIIIII = 0;
        this.IlllIIIllI = false;
        this.IlIlIlIIlI = new Handler();
        this.IlIIIIIlll = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
        this.IIIIIIIIII = null;
        this.IIlIlllIIl = 0.0f;
        this.IIIllIlIIl = true;
        this.lIIIlIIllI = false;
        this.lIlIIlIIll = Orientation.ORIENTATION_UNKNOWN;
        this.IIlIlIIlll = false;
        llIIlIlIIl(context);
    }

    private int getCameraRotation() {
        int i = this.IIlIIIllIl;
        if (i == 1) {
            return 90;
        }
        if (i == 8) {
            return RotationOptions.ROTATE_180;
        }
        if (i != 9) {
            return 0;
        }
        return RotationOptions.ROTATE_270;
    }

    private float llIIlIlIIl(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    protected abstract void IIlIIIllIl();

    protected abstract boolean IlIllIlllI();

    protected boolean IllIIlIIII() {
        return true;
    }

    public void addOrientationChangeListener(OrientationChangeListener orientationChangeListener) {
        CameraViewState cameraViewState = this.llIIIlllll;
        if (cameraViewState != CameraViewState.DESTROYED && cameraViewState != CameraViewState.CREATED) {
            throw new IllegalStateException("Method addOrientationChangeListener must be called before calling start()");
        }
        this.llIIlIIIll.add(orientationChangeListener);
    }

    public void changeConfiguration(Configuration configuration) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new CalledFromWrongThreadException("ChangeConfiguration must be called from UI thread!");
        }
        Log.m2711i(this, "changeConfiguration: Context: {}", getContext());
        this.lIlIIIIlIl = configuration.orientation;
        this.IIlIIIllIl = IlIllIlIIl();
        llIIlIlIIl(configuration);
    }

    public void create() {
        if (this.llIIIlllll != CameraViewState.DESTROYED) {
            throw new IllegalStateException(IIllIllIIl.llIIlIlIIl("It is not allowed to call create() on already created view (state is ").append(this.llIIIlllll.name()).append(")").toString());
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new CalledFromWrongThreadException("Create must be called from UI thread!");
        }
        if (getCameraFactorySettings().llIIlIlIIl() == null) {
            throw new NullPointerException("You have to set camera factory settings before calling create()");
        }
        this.IlIllIlIIl = false;
        Log.m2711i(this, "Camera view create. Context = {}", getContext());
        if (this.llIIlIlIIl == null) {
            throw new NullPointerException("Please set CameraEventsListener with method setCameraEventsListener before calling create method!");
        }
        this.lIlIIlIIll = this.IlIlllllII;
        this.IllIIlIIII = IllIIIIllI();
        this.lIlllIlIlI = new IIIIlIlIll(this.IllIIIllII, this.IllIIlIIII);
        llIIlIlIIl(this.lIllIIlIIl);
        llllllllll llllllllllVarLlIIlIlIIl = new lIlIIlIIll(getContext()).llIIlIlIIl(llIIIlllll(), this.lIllIIlIIl);
        this.IlIIlllIIl = llllllllllVarLlIIlIlIIl;
        llllllllllVarLlIIlIlIIl.llIIlIlIIl(this.lllllIlIll);
        ICameraView iCameraViewLlIIlIlIIl = IIIIlIllIl.llIIlIlIIl(this.IllIIIllII, this.lIllIIlIIl, this.IlIIlllIIl);
        this.IllIIIIllI = iCameraViewLlIIlIlIIl;
        iCameraViewLlIIlIlIIl.setAspectMode(this.lIIIIIllll);
        this.IllIIIIllI.setPreviewZoomScale(this.lllIIIlIlI);
        this.IllIIIIllI.setCameraViewEventListener(new BaseCameraViewEventsListener());
        this.IllIIIIllI.setHostActivityOrientation(this.IIlIIIllIl);
        this.IllIIIIllI.setDeviceNaturalOrientationLandscape(this.IIlIlIIlll);
        addView(this.IllIIIIllI.getView(), 0);
        this.llIIIlllll = CameraViewState.CREATED;
    }

    public void destroy() {
        if (this.llIIIlllll != CameraViewState.CREATED) {
            throw new IllegalStateException(IIllIllIIl.llIIlIlIIl("It is not allowed to call destroy() method on view that is not stopped. State is ").append(this.llIIIlllll.name()).toString());
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new CalledFromWrongThreadException("Destroy must be called from UI thread!");
        }
        Log.m2711i(this, "Camera view destroy. Context = {}", getContext());
        this.IlIIlllIIl.dispose();
        this.IllIIIIllI.dispose();
        this.IllIIIIllI = null;
        this.IlIIlllIIl = null;
        this.lIllIIlIIl.getClass();
        removeAllViews();
        this.llIIIlllll = CameraViewState.DESTROYED;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ICameraView iCameraView = this.IllIIIIllI;
        return (iCameraView == null || iCameraView.getView() == null || !this.IllIIIIllI.getView().dispatchTouchEvent(motionEvent)) ? false : true;
    }

    public final void focusCamera() {
        llllllllll llllllllllVar = this.IlIIlllIIl;
        if (llllllllllVar != null) {
            llllllllllVar.lIIIIIllll();
        }
    }

    public CameraAspectMode getAspectMode() {
        return this.lIIIIIllll;
    }

    public CameraEventsListener getCameraEventsListener() {
        return this.llIIlIlIIl;
    }

    protected IIllllllll getCameraFactorySettings() {
        return this.lIllIIlIIl;
    }

    public final int getCameraPreviewHeight() {
        return this.IlIIlIIIII;
    }

    public final int getCameraPreviewWidth() {
        return this.lllIIlIIlI;
    }

    protected int getCameraSensorOrientation() {
        return this.IlIIlllIIl.IllIIIllII();
    }

    public final CameraViewState getCameraViewState() {
        return this.llIIIlllll;
    }

    protected final int getConfigurationOrientation() {
        return this.lIlIIIIlIl;
    }

    public Orientation getCurrentOrientation() {
        return this.lIlIIlIIll;
    }

    public final int getHighResFrameLimit() {
        return this.lIllIIlIIl.IllIIIllII();
    }

    protected Activity getHostActivity() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public int getHostScreenOrientation() {
        return this.IIlIIIllIl;
    }

    public final Orientation getInitialOrientation() {
        return this.IlIlllllII;
    }

    public final CameraType getOpenedCameraType() {
        llllllllll llllllllllVar = this.IlIIlllIIl;
        if (llllllllllVar != null) {
            return llllllllllVar.lIlIIIIlIl();
        }
        return null;
    }

    public float getPreviewZoomScale() {
        return this.lllIIIlIlI;
    }

    public RectF getVisiblePart() {
        return this.IlIIIIIlll;
    }

    public final float getZoomLevel() {
        return this.IIlIlllIIl;
    }

    public final Boolean isAutofocusSupported() {
        llllllllll llllllllllVar = this.IlIIlllIIl;
        if (llllllllllVar != null) {
            return llllllllllVar.llIIlIIlll();
        }
        return null;
    }

    public final boolean isCameraActive() {
        return this.IlllIIIllI;
    }

    public final boolean isCameraFocused() {
        llllllllll llllllllllVar = this.IlIIlllIIl;
        if (llllllllllVar != null) {
            return llllllllllVar.llIIlIlIIl();
        }
        return false;
    }

    public final boolean isCameraTorchSupported() {
        llllllllll llllllllllVar = this.IlIIlllIIl;
        if (llllllllllVar != null) {
            return llllllllllVar.IlIllIlllI();
        }
        return false;
    }

    public final boolean isDeviceShaking() {
        llllllllll llllllllllVar = this.IlIIlllIIl;
        if (llllllllllVar != null) {
            return llllllllllVar.IlIllIlIIl();
        }
        Log.m2709e(this, "Camera manager is null! Defining that device is shaking!", new Object[0]);
        return true;
    }

    public boolean isHighResFrameCaptureEnabled() {
        return this.lIllIIlIIl.lIIIIIllll();
    }

    public final boolean isPinchToZoomAllowed() {
        return this.lIIIlIIllI;
    }

    public final boolean isTapToFocusAllowed() {
        return this.IIIllIlIIl;
    }

    protected void lIIIIIllll() {
    }

    protected abstract llIlIlIlIl llIIIlllll();

    protected void lllIIIlIlI() {
    }

    protected void lllIlIlIIl() {
        RectF rectF;
        RectF rectF2;
        llllllllll llllllllllVar = this.IlIIlllIIl;
        if (llllllllllVar == null) {
            Log.m2715w(this, "CameraView is already disposed. Cannot set metering areas!", new Object[0]);
            return;
        }
        RectF[] rectFArr = this.llIlIlIlIl;
        if (rectFArr == null) {
            llllllllllVar.llIIlIlIIl((Rect[]) null);
            return;
        }
        Rect[] rectArr = new Rect[rectFArr.length];
        int i = 0;
        while (true) {
            RectF[] rectFArr2 = this.llIlIlIlIl;
            if (i >= rectFArr2.length) {
                this.IlIIlllIIl.llIIlIlIIl(rectArr);
                return;
            }
            RectF rectF3 = rectFArr2[i];
            if (rectF3 == null) {
                throw new NullPointerException("Metering area elements cannot be null!");
            }
            Log.m2707d(this, "Metering rect is for orientation {}!", this.lIlIIlIIll);
            int i2 = llIIlIlIIl.llIIlIlIIl[this.lIlIIlIIll.ordinal()];
            if (i2 != 2) {
                if (i2 == 3) {
                    float fHeight = rectF3.height();
                    float fWidth = rectF3.width();
                    float f = rectF3.top;
                    float fWidth2 = 1.0f - (rectF3.width() + rectF3.left);
                    rectF2 = new RectF(f, fWidth2, fHeight + f, fWidth + fWidth2);
                } else if (i2 == 4) {
                    float fHeight2 = rectF3.height();
                    float fWidth3 = rectF3.width();
                    float fHeight3 = 1.0f - (rectF3.height() + rectF3.top);
                    float f2 = rectF3.left;
                    rectF2 = new RectF(fHeight3, f2, fHeight2 + fHeight3, fWidth3 + f2);
                }
                rectF3 = rectF2;
            } else {
                float f3 = 1.0f - rectF3.right;
                float f4 = 1.0f - rectF3.bottom;
                rectF3 = new RectF(f3, f4, rectF3.width() + f3, rectF3.height() + f4);
            }
            if (lIlIIIIlIl()) {
                Log.m2707d(this, "Metering rect is sensor upside down!", new Object[0]);
                float f5 = 1.0f - rectF3.right;
                float f6 = 1.0f - rectF3.bottom;
                rectF3 = new RectF(f5, f6, rectF3.width() + f5, rectF3.height() + f6);
            } else {
                Log.m2707d(this, "Metering rect is sensor normal!", new Object[0]);
            }
            RectF rectF4 = this.IlIIIIIlll;
            float fWidth4 = (rectF4.width() * rectF3.left) + rectF4.left;
            RectF rectF5 = this.IlIIIIIlll;
            float fHeight4 = (rectF5.height() * rectF3.top) + rectF5.top;
            rectF = new RectF(fWidth4, fHeight4, (this.IlIIIIIlll.width() * rectF3.width()) + fWidth4, (this.IlIIIIIlll.height() * rectF3.height()) + fHeight4);
            int iRound = Math.round(rectF.left * 2000.0f) - 1000;
            int iRound2 = Math.round(rectF.top * 2000.0f) - 1000;
            Rect rect = new Rect(iRound, iRound2, Math.round(rectF.width() * 2000.0f) + iRound, Math.round(rectF.height() * 2000.0f) + iRound2);
            if (rect.left < -1000) {
                rect.left = -1000;
            }
            if (rect.right > 1000) {
                rect.right = 1000;
            }
            if (rect.top < -1000) {
                rect.top = -1000;
            }
            if (rect.bottom > 1000) {
                rect.bottom = 1000;
            }
            if (rect.isEmpty() || !rect.intersects(-1000, -1000, 1000, 1000)) {
                break;
            }
            Log.m2711i(this, "Metering rect is {} (original rect was {})", rect, rectF);
            rectArr[i] = rect;
            i++;
        }
        throw new IllegalArgumentException(IIllIllIIl.llIIlIlIIl("Invalid metering area: ").append(rectF.toString()).toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int i5;
        int i6;
        int i7;
        int i8;
        Log.m2707d(this, "Camera preview ({} childs) layouting to: top: {} bottom: {}, left: {}, right: {} (changed: {}) ", Integer.valueOf(getChildCount()), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i3), Boolean.valueOf(z));
        if (getChildCount() == 0) {
            Log.wtf(this, "Camera view has no children?!?", new Object[0]);
            return;
        }
        int i9 = i3 - i;
        int i10 = i4 - i2;
        if (i9 == 0 || i10 == 0) {
            Log.wtf(this, "Layout size is 0x0?!?", new Object[0]);
            return;
        }
        ICameraView iCameraView = this.IllIIIIllI;
        if (iCameraView == null) {
            Log.m2709e(this, "Create not called. Cannot layout view!", new Object[0]);
            return;
        }
        int size = View.MeasureSpec.getSize(iCameraView.getView().getMeasuredWidth());
        int size2 = View.MeasureSpec.getSize(this.IllIIIIllI.getView().getMeasuredHeight());
        Log.m2707d(this, "Camera surface view size is {}x{}", Integer.valueOf(size), Integer.valueOf(size2));
        Log.m2707d(this, "Base camera view size: {}x{}", Integer.valueOf(i9), Integer.valueOf(i10));
        int i11 = (i9 - size) / 2;
        int i12 = (i9 + size) / 2;
        int i13 = (i10 - size2) / 2;
        int i14 = (i10 + size2) / 2;
        if (this.lIIIIIllll == CameraAspectMode.ASPECT_FIT) {
            Log.m2707d(this, "Layouting in ASPECT_FIT mode", new Object[0]);
            RectF rectF = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
            if (this.IIIIIIIIII != null && !rectF.equals(this.IlIIIIIlll)) {
                this.IIIIIIIIII.onVisiblePartUpdated(rectF);
            }
            this.IlIIIIIlll = rectF;
            i5 = i11;
            i7 = i12;
            i6 = i13;
            i8 = i14;
        } else {
            Log.m2707d(this, "Layouting in ASPECT_FILL mode", new Object[0]);
            if (size <= 0 || size2 <= 0) {
                f = 1.0f;
                f2 = 1.0f;
                f3 = 0.0f;
                f4 = 0.0f;
            } else {
                float f5 = size;
                f = i9 / f5;
                float f6 = size2;
                f2 = i10 / f6;
                f4 = (-i11) / f5;
                f3 = (-i13) / f6;
            }
            if (IIlIIlIllI.llIIlIlIIl(getContext())) {
                float f7 = f4;
                f4 = f3;
                f3 = f7;
            } else {
                float f8 = f2;
                f2 = f;
                f = f8;
            }
            float fLlIIlIlIIl = llIIlIlIIl(f4, 0.0f, 1.0f);
            float fLlIIlIlIIl2 = llIIlIlIIl(f3, 0.0f, 1.0f);
            RectF rectF2 = new RectF(fLlIIlIlIIl, fLlIIlIlIIl2, llIIlIlIIl(f2, 0.0f, 1.0f) + fLlIIlIlIIl, llIIlIlIIl(f, 0.0f, 1.0f) + fLlIIlIlIIl2);
            if (this.IIIIIIIIII != null && !rectF2.equals(this.IlIIIIIlll)) {
                this.IIIIIIIIII.onVisiblePartUpdated(rectF2);
            }
            this.IlIIIIIlll = rectF2;
            Log.m2707d(this, IIllIllIIl.llIIlIlIIl("Visible ROI: ").append(this.IlIIIIIlll.toString()).toString(), new Object[0]);
            i5 = i;
            i6 = i2;
            i7 = i3;
            i8 = i4;
        }
        this.lllIIlIIlI = i7 - i5;
        this.IlIIlIIIII = i8 - i6;
        Log.m2711i(this, "Layouting camera surface view: Left: {}, Top: {}, Right: {}, Bottom: {}", Integer.valueOf(i11), Integer.valueOf(i13), Integer.valueOf(i12), Integer.valueOf(i14));
        this.IllIIIIllI.getView().layout(i11, i13, i12, i14);
        if (this.llIllIIlll != null) {
            if (this.lIlIIlIIll.isHorizontal()) {
                this.llIllIIlll.onSizeChanged(this.IlIIlIIIII, this.lllIIlIIlI);
            } else {
                this.llIllIIlll.onSizeChanged(this.lllIIlIIlI, this.IlIIlIIIII);
            }
        }
        for (int i15 = 1; i15 < getChildCount(); i15++) {
            View childAt = getChildAt(i15);
            Log.m2711i(this, "Layouting child {}: Left: {}, Top: {}, Right: {}, Bottom: {}", Integer.valueOf(i15), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8));
            childAt.layout(i5, i6, i7, i8);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int iResolveSize = ViewGroup.resolveSize(getSuggestedMinimumWidth(), i);
        int iResolveSize2 = ViewGroup.resolveSize(getSuggestedMinimumHeight(), i2);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(iResolveSize, 1073741824), View.MeasureSpec.makeMeasureSpec(iResolveSize2, 1073741824));
            }
        }
        Log.m2707d(this, "Measured dimension: {}x{}", Integer.valueOf(iResolveSize), Integer.valueOf(iResolveSize2));
        setMeasuredDimension(iResolveSize, iResolveSize2);
    }

    public void pause() {
        if (this.llIIIlllll != CameraViewState.RESUMED) {
            throw new IllegalStateException(IIllIllIIl.llIIlIlIIl("Cannot pause view that has not been resumed. Please make sure that your view has been resumed with resume() method. State is ").append(this.llIIIlllll.name()).toString());
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new CalledFromWrongThreadException("Pause must be called from UI thread!");
        }
        Log.m2711i(this, "Camera view pause. Context = {}", getContext());
        IIIIlIlIll iIIIlIlIll = this.lIlllIlIlI;
        if (iIIIlIlIll != null) {
            iIIIlIlIll.disable();
        }
        llllllllll llllllllllVar = this.IlIIlllIIl;
        if (llllllllllVar != null) {
            llllllllllVar.lllIIIlIlI();
            this.IlllIIIllI = false;
        }
        this.llIIIlllll = CameraViewState.STARTED;
    }

    public void removeOrientationChangeListener(OrientationChangeListener orientationChangeListener) {
        this.llIIlIIIll.remove(orientationChangeListener);
    }

    public void resume() {
        if (this.llIIIlllll != CameraViewState.STARTED) {
            throw new IllegalStateException(IIllIllIIl.llIIlIlIIl("Cannot resume view that has not been started. Please call start() first. State is ").append(this.llIIIlllll.name()).toString());
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new CalledFromWrongThreadException("Resume must be called from UI thread!");
        }
        Log.m2711i(this, "Camera view resume. Context = {}", getContext());
        this.llIIIlllll = CameraViewState.RESUMED;
        if (getContext().checkSelfPermission("android.permission.CAMERA") != 0) {
            this.llIIlIlIIl.onCameraPermissionDenied();
            return;
        }
        if (this.IlIllIlIIl) {
            return;
        }
        IIIIlIlIll iIIIlIlIll = this.lIlllIlIlI;
        if (iIIIlIlIll != null) {
            iIIIlIlIll.enable();
        }
        Context context = getContext();
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            Log.m2709e(this, "Will not open camera because activity is already finishing.", new Object[0]);
            return;
        }
        if (IllIIlIIII()) {
            this.IllIIIIllI.setRotation(getCameraRotation());
            this.lIllIIlIIl.llIIlIlIIl(this.IIlIlllIIl);
            this.IlIIlllIIl.llIIlIlIIl(getContext(), this.lIllIIlIIl, new com.microblink.view.llIIlIlIIl(this));
        } else {
            this.IlllIIIllI = false;
            this.IlIllIlIIl = true;
            CameraEventsListener cameraEventsListener = this.llIIlIlIIl;
            if (cameraEventsListener != null) {
                cameraEventsListener.onError(new Exception("Initialization failed!"));
            }
        }
    }

    public void setAspectMode(CameraAspectMode cameraAspectMode) {
        if (this.llIIIlllll != CameraViewState.DESTROYED) {
            throw new IllegalStateException("Method setAspectMode must be called before calling create()");
        }
        this.lIIIIIllll = cameraAspectMode;
        if (cameraAspectMode == null) {
            this.lIIIIIllll = CameraAspectMode.ASPECT_FILL;
        }
    }

    public void setCameraEventsListener(CameraEventsListener cameraEventsListener) {
        if (this.llIIIlllll != CameraViewState.DESTROYED) {
            throw new IllegalStateException("Method setCameraEventsListener must be called before calling create()");
        }
        this.llIIlIlIIl = cameraEventsListener;
    }

    public final void setCameraFrameFactory(lIIIlIIllI liiiliilli) {
        if (this.llIIIlllll != CameraViewState.DESTROYED) {
            throw new IllegalStateException("This method can only be called before calling create().");
        }
        this.lIllIIlIIl.llIIlIlIIl(liiiliilli);
    }

    public void setCameraType(CameraType cameraType) {
        if (this.llIIIlllll != CameraViewState.DESTROYED) {
            throw new IllegalStateException("Method setCameraType must be called before calling create()");
        }
        if (cameraType != null) {
            this.lIllIIlIIl.llIIlIlIIl(cameraType);
        }
    }

    public final void setForceUseLegacyCamera(boolean z) {
        if (this.llIIIlllll != CameraViewState.DESTROYED) {
            throw new IllegalStateException("This method can only be called before calling create().");
        }
        this.lIllIIlIIl.lIlIIIIlIl(z);
    }

    public void setHighResFrameCaptureEnabled(boolean z) {
        if (this.llIIIlllll != CameraViewState.DESTROYED) {
            throw new IllegalStateException("This method can only be called before calling create().");
        }
        this.lIllIIlIIl.IlIllIlIIl(z);
    }

    public final void setHighResFrameLimit(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("High res frame limit has to be at least 1");
        }
        this.lIllIIlIIl.llIIlIlIIl(i);
    }

    public void setInitialOrientation(Orientation orientation) {
        if (this.llIIIlllll != CameraViewState.DESTROYED) {
            throw new IllegalStateException("Method setInitialOrientation must be called before calling create()");
        }
        if (orientation != null) {
            this.IlIlllllII = orientation;
        }
    }

    public final void setMeteringAreas(RectF[] rectFArr, boolean z) {
        this.llIlIlIlIl = rectFArr;
        this.lIIIIIlIlI = z;
        lllIlIlIIl();
    }

    public final void setOnActivityFlipListener(OnActivityFlipListener onActivityFlipListener) {
        this.llIIlIIlll = onActivityFlipListener;
    }

    public final void setOnSizeChangedListener(OnSizeChangedListener onSizeChangedListener) {
        this.llIllIIlll = onSizeChangedListener;
    }

    public final void setOptimizeCameraForNearScan(boolean z) {
        if (this.llIIIlllll != CameraViewState.DESTROYED) {
            throw new IllegalStateException("This method can only be called before calling create().");
        }
        this.lIllIIlIIl.IllIIIllII(z);
    }

    public void setOrientationAllowedListener(OrientationAllowedListener orientationAllowedListener) {
        if (this.llIIIlllll != CameraViewState.DESTROYED) {
            throw new IllegalStateException("Method setOrientationAllowedListener must be called before calling create()");
        }
        this.IlIlIIllll = orientationAllowedListener;
    }

    public final void setPinchToZoomAllowed(boolean z) {
        this.lIIIlIIllI = z;
    }

    public void setPreviewZoomScale(float f) {
        this.lllIIIlIlI = f;
        ICameraView iCameraView = this.IllIIIIllI;
        if (iCameraView != null) {
            iCameraView.setPreviewZoomScale(f);
        }
    }

    public final void setRequestAutofocusOnShakingStopInContinousAutofocusMode(boolean z) {
        if (this.llIIIlllll != CameraViewState.DESTROYED) {
            throw new IllegalStateException("This method can only be called before calling create().");
        }
        this.lIllIIlIIl.IllIIIIllI(z);
    }

    public final void setRequestedSurfaceViewForCameraDisplay(CameraSurface cameraSurface) {
        if (this.llIIIlllll != CameraViewState.DESTROYED) {
            throw new IllegalStateException("This method can only be called before calling create().");
        }
        this.lIllIIlIIl.llIIlIlIIl(cameraSurface);
    }

    public void setShakeListener(ShakeCallback shakeCallback) {
        this.lllllIlIll = shakeCallback;
    }

    public final void setTapToFocusAllowed(boolean z) {
        this.IIIllIlIIl = z;
    }

    public final void setTorchState(boolean z, SuccessCallback successCallback) {
        llllllllll llllllllllVar = this.IlIIlllIIl;
        if (llllllllllVar != null) {
            llllllllllVar.llIIlIlIIl(z, successCallback);
        } else {
            successCallback.onOperationDone(false);
        }
    }

    public final void setVideoResolutionPreset(VideoResolutionPreset videoResolutionPreset) {
        if (this.llIIIlllll != CameraViewState.DESTROYED) {
            throw new IllegalStateException("This method can only be called before calling create().");
        }
        this.lIllIIlIIl.llIIlIlIIl(videoResolutionPreset);
    }

    protected void setVisiblePartUpdateListener(VisiblePartUpdateListener visiblePartUpdateListener) {
        this.IIIIIIIIII = visiblePartUpdateListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0006 A[PHI: r0
      0x0006: PHI (r0v3 float) = (r0v0 float), (r0v1 float) binds: [B:3:0x0004, B:6:0x000b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setZoomLevel(float r3) {
        /*
            r2 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 <= 0) goto L8
        L6:
            r3 = r0
            goto Le
        L8:
            r0 = 0
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 >= 0) goto Le
            goto L6
        Le:
            r2.IIlIlllIIl = r3
            com.microblink.blinkid.secured.llllllllll r0 = r2.IlIIlllIIl
            if (r0 == 0) goto L17
            r0.llIIlIlIIl(r3)
        L17:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.view.BaseCameraView.setZoomLevel(float):void");
    }

    public void start() {
        if (this.llIIIlllll != CameraViewState.CREATED) {
            throw new IllegalStateException(IIllIllIIl.llIIlIlIIl("Cannot start view that has not been created. Please call create() first. State is ").append(this.llIIIlllll.name()).toString());
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new CalledFromWrongThreadException("Start must be called from UI thread!");
        }
        Log.m2711i(this, "Camera view start. Context = {}", getContext());
        this.IlIllIlIIl = false;
        this.IllIIIIllI.installCallback(this.IlIIlllIIl);
        this.llIIIlllll = CameraViewState.STARTED;
    }

    public void stop() {
        if (this.llIIIlllll != CameraViewState.STARTED) {
            throw new IllegalStateException(IIllIllIIl.llIIlIlIIl("Cannot stop view that has not been paused. Please call pause() method first. State is ").append(this.llIIIlllll.name()).toString());
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new CalledFromWrongThreadException("Stop must be called from UI thread!");
        }
        Log.m2711i(this, "Camera view stop. Context = {}", getContext());
        this.IllIIIIllI.removeCallback();
        this.llIIIlllll = CameraViewState.CREATED;
    }

    private boolean lIlIIIIlIl() {
        llllllllll llllllllllVar = this.IlIIlllIIl;
        if (llllllllllVar == null) {
            return false;
        }
        CameraType cameraTypeLIlIIIIlIl = llllllllllVar.lIlIIIIlIl();
        boolean zLlIIIlllll = this.IlIIlllIIl.llIIIlllll();
        return cameraTypeLIlIIIIlIl == CameraType.CAMERA_BACKFACE ? zLlIIIlllll : !zLlIIIlllll;
    }

    protected int IlIllIlIIl() {
        int rotation = (isInEditMode() ? (WindowManager) getContext().getSystemService("window") : (WindowManager) getHostActivity().getApplicationContext().getSystemService("window")).getDefaultDisplay().getRotation();
        if (!IIlIIlIllI.llIIlIlIIl(getContext())) {
            Log.m2707d(this, "Activity is in landscape", new Object[0]);
            if (rotation != 1) {
                if (rotation == 3) {
                    Log.m2707d(this, "Screen orientation is 270", new Object[0]);
                } else if (rotation == 0) {
                    Log.m2707d(this, "Screen orientation is 0", new Object[0]);
                    this.IIlIlIIlll = true;
                } else {
                    Log.m2707d(this, "Screen orientation is 180", new Object[0]);
                    this.IIlIlIIlll = true;
                }
                return 8;
            }
            Log.m2707d(this, "Screen orientation is 90", new Object[0]);
            return 0;
        }
        Log.m2707d(this, "Activity is in portrait", new Object[0]);
        if (rotation == 0) {
            Log.m2707d(this, "Screen orientation is 0", new Object[0]);
            return 1;
        }
        if (rotation == 2) {
            Log.m2707d(this, "Screen orientation is 180", new Object[0]);
        } else {
            if (rotation == 3) {
                Log.m2707d(this, "Screen orientation is 270", new Object[0]);
                this.IIlIlIIlll = true;
                return 1;
            }
            Log.m2707d(this, "Screen orientation is 90", new Object[0]);
            this.IIlIlIIlll = true;
        }
        return 9;
    }

    protected OrientationChangeListener IllIIIIllI() {
        return new BaseOrientationChangeListener();
    }

    protected void IllIIIllII() {
        if (!this.lIllIIlIIl.lIIIIIllll()) {
            throw new IllegalStateException("High res frame capture is not enabled!");
        }
        this.IlIIlllIIl.IIlIIIllIl();
    }

    protected boolean llIIlIIlll() {
        if (this.IlIllIlllI) {
            return true;
        }
        if (this.lllIlIlIIl || getHostActivity().isInMultiWindowMode()) {
            try {
                return Settings.System.getInt(getContext().getContentResolver(), "accelerometer_rotation") == 1;
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    static Rect[] llIIlIlIIl(BaseCameraView baseCameraView, Rect[] rectArr) {
        baseCameraView.getClass();
        if (rectArr == null || baseCameraView.IllIIIIllI == null) {
            return null;
        }
        Rect[] rectArr2 = new Rect[rectArr.length];
        for (int i = 0; i < rectArr.length; i++) {
            Rect rect = rectArr[i];
            RectF rectF = new RectF((rect.left + 1000) / 2000.0f, (rect.top + 1000) / 2000.0f, (rect.right + 1000) / 2000.0f, (rect.bottom + 1000) / 2000.0f);
            if (baseCameraView.lIlIIIIlIl()) {
                float f = 1.0f - rectF.right;
                float f2 = 1.0f - rectF.bottom;
                rectF = new RectF(f, f2, rectF.width() + f, rectF.height() + f2);
            }
            rectArr2[i] = baseCameraView.IllIIIIllI.convertRectangleToActualRect(rectF);
        }
        return rectArr2;
    }

    private void llIIlIlIIl(Context context) {
        this.lIlIIIIlIl = context.getResources().getConfiguration().orientation;
        int iIlIllIlIIl = IlIllIlIIl();
        this.IIlIIIllIl = iIlIllIlIIl;
        this.IlIlllllII = Orientation.fromActivityInfoCode(iIlIllIlIIl);
        if (!isInEditMode()) {
            lIlIllIIlI lililliiliLlIIlIIlll = lIlIllIIlI.llIIlIIlll();
            this.IllIIIllII = lililliiliLlIIlIIlll;
            IlIIIIIlll.llIIlIlIIl(this.IIlIIIllIl, lililliiliLlIIlIIlll);
            if (!IlIIIIIlll.IlIllIlIIl() && this.IIlIIIllIl != 0) {
                throw new NonLandscapeOrientationNotSupportedException("This device does not support having camera on non-landscape oriented activity. Please set activity orientation to landscape!");
            }
            Activity hostActivity = getHostActivity();
            int requestedOrientation = hostActivity.getRequestedOrientation();
            this.IlIllIlllI = requestedOrientation == 10 || requestedOrientation == 4 || requestedOrientation == 6 || requestedOrientation == 7;
            int requestedOrientation2 = hostActivity.getRequestedOrientation();
            this.lllIlIlIIl = requestedOrientation2 == 2 || requestedOrientation2 == 12 || requestedOrientation2 == 11 || requestedOrientation2 == 13 || requestedOrientation2 == -1;
            return;
        }
        IllIIIllII illIIIllII = new IllIIIllII(getContext(), this.lIIIIIllll);
        this.IllIIIIllI = illIIIllII;
        addView(illIIIllII.getView(), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void llIIlIlIIl(Runnable runnable) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            runnable.run();
        } else {
            this.IlIlIlIIlI.post(runnable);
        }
    }

    protected void llIIlIlIIl(Configuration configuration) {
        this.IllIIIIllI.setRotation(getCameraRotation());
        this.IllIIIIllI.setHostActivityOrientation(this.IIlIIIllIl);
        this.IllIIIIllI.getView().dispatchConfigurationChanged(configuration);
    }

    protected void llIIlIlIIl(IIllllllll iIllllllll) {
        iIllllllll.llIIlIlIIl(IlIllIlllI());
    }

    protected boolean llIIlIlIIl() {
        llllllllll llllllllllVar = this.IlIIlllIIl;
        if (llllllllllVar != null) {
            return llllllllllVar.llIIIlllll();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean llIIlIlIIl(Orientation orientation) {
        OrientationAllowedListener orientationAllowedListener = this.IlIlIIllll;
        if (orientationAllowedListener != null) {
            return orientationAllowedListener.isOrientationAllowed(orientation);
        }
        return orientation == Orientation.fromActivityInfoCode(this.IIlIIIllIl);
    }

    public BaseCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.IlIllIlIIl = false;
        this.IllIIIllII = null;
        this.llIIIlllll = CameraViewState.DESTROYED;
        this.IIlIIIllIl = 1;
        this.lIIIIIllll = CameraAspectMode.ASPECT_FILL;
        this.lllIIIlIlI = 1.0f;
        this.IlIllIlllI = false;
        this.lllIlIlIIl = false;
        this.lIIIIIlIlI = false;
        this.llIIlIIIll = new ConcurrentLinkedQueue<>();
        this.lIlllIlIlI = null;
        this.lIllIIlIIl = new IIllllllll();
        this.lllIIlIIlI = 0;
        this.IlIIlIIIII = 0;
        this.IlllIIIllI = false;
        this.IlIlIlIIlI = new Handler();
        this.IlIIIIIlll = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
        this.IIIIIIIIII = null;
        this.IIlIlllIIl = 0.0f;
        this.IIIllIlIIl = true;
        this.lIIIlIIllI = false;
        this.lIlIIlIIll = Orientation.ORIENTATION_UNKNOWN;
        this.IIlIlIIlll = false;
        llIIlIlIIl(context);
    }
}
