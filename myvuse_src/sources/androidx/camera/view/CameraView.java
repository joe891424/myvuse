package androidx.camera.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.camera.core.Camera;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.impl.LensFacingConverter;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.view.PreviewView;
import androidx.camera.view.video.OnVideoSavedCallback;
import androidx.camera.view.video.OutputFileOptions;
import androidx.camera.view.video.OutputFileResults;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import java.io.File;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class CameraView extends FrameLayout {
    private static final String EXTRA_CAMERA_DIRECTION = "camera_direction";
    private static final String EXTRA_CAPTURE_MODE = "captureMode";
    private static final String EXTRA_FLASH = "flash";
    private static final String EXTRA_MAX_VIDEO_DURATION = "max_video_duration";
    private static final String EXTRA_MAX_VIDEO_SIZE = "max_video_size";
    private static final String EXTRA_PINCH_TO_ZOOM_ENABLED = "pinch_to_zoom_enabled";
    private static final String EXTRA_SCALE_TYPE = "scale_type";
    private static final String EXTRA_SUPER = "super";
    private static final String EXTRA_ZOOM_RATIO = "zoom_ratio";
    private static final int FLASH_MODE_AUTO = 1;
    private static final int FLASH_MODE_OFF = 4;
    private static final int FLASH_MODE_ON = 2;
    static final int INDEFINITE_VIDEO_DURATION = -1;
    static final int INDEFINITE_VIDEO_SIZE = -1;
    private static final int LENS_FACING_BACK = 2;
    private static final int LENS_FACING_FRONT = 1;
    private static final int LENS_FACING_NONE = 0;
    static final String TAG = "CameraView";
    CameraXModule mCameraModule;
    private final DisplayManager.DisplayListener mDisplayListener;
    private long mDownEventTimestamp;
    private boolean mIsPinchToZoomEnabled;
    private PinchToZoomGestureDetector mPinchToZoomGestureDetector;
    private PreviewView mPreviewView;
    private MotionEvent mUpEvent;

    public CameraView(Context context) {
        this(context, null);
    }

    public CameraView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CameraView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mIsPinchToZoomEnabled = true;
        this.mDisplayListener = new DisplayManager.DisplayListener() { // from class: androidx.camera.view.CameraView.1
            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayAdded(int displayId) {
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayRemoved(int displayId) {
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayChanged(int displayId) {
                CameraView.this.mCameraModule.invalidateView();
            }
        };
        init(context, attrs);
    }

    public CameraView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.mIsPinchToZoomEnabled = true;
        this.mDisplayListener = new DisplayManager.DisplayListener() { // from class: androidx.camera.view.CameraView.1
            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayAdded(int displayId) {
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayRemoved(int displayId) {
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayChanged(int displayId) {
                CameraView.this.mCameraModule.invalidateView();
            }
        };
        init(context, attrs);
    }

    public void bindToLifecycle(LifecycleOwner lifecycleOwner) {
        this.mCameraModule.bindToLifecycle(lifecycleOwner);
    }

    private void init(Context context, AttributeSet attrs) {
        PreviewView previewView = new PreviewView(getContext());
        this.mPreviewView = previewView;
        addView(previewView, 0);
        this.mCameraModule = new CameraXModule(this);
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, C0507R.styleable.CameraView);
            setScaleType(PreviewView.ScaleType.fromId(typedArrayObtainStyledAttributes.getInteger(C0507R.styleable.CameraView_scaleType, getScaleType().getId())));
            setPinchToZoomEnabled(typedArrayObtainStyledAttributes.getBoolean(C0507R.styleable.CameraView_pinchToZoomEnabled, isPinchToZoomEnabled()));
            setCaptureMode(CaptureMode.fromId(typedArrayObtainStyledAttributes.getInteger(C0507R.styleable.CameraView_captureMode, getCaptureMode().getId())));
            int i = typedArrayObtainStyledAttributes.getInt(C0507R.styleable.CameraView_lensFacing, 2);
            if (i == 0) {
                setCameraLensFacing(null);
            } else if (i == 1) {
                setCameraLensFacing(0);
            } else if (i == 2) {
                setCameraLensFacing(1);
            }
            int i2 = typedArrayObtainStyledAttributes.getInt(C0507R.styleable.CameraView_flash, 0);
            if (i2 == 1) {
                setFlash(0);
            } else if (i2 == 2) {
                setFlash(1);
            } else if (i2 == 4) {
                setFlash(2);
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        if (getBackground() == null) {
            setBackgroundColor(-15658735);
        }
        this.mPinchToZoomGestureDetector = new PinchToZoomGestureDetector(this, context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(EXTRA_SUPER, super.onSaveInstanceState());
        bundle.putInt(EXTRA_SCALE_TYPE, getScaleType().getId());
        bundle.putFloat(EXTRA_ZOOM_RATIO, getZoomRatio());
        bundle.putBoolean(EXTRA_PINCH_TO_ZOOM_ENABLED, isPinchToZoomEnabled());
        bundle.putString(EXTRA_FLASH, FlashModeConverter.nameOf(getFlash()));
        bundle.putLong(EXTRA_MAX_VIDEO_DURATION, getMaxVideoDuration());
        bundle.putLong(EXTRA_MAX_VIDEO_SIZE, getMaxVideoSize());
        if (getCameraLensFacing() != null) {
            bundle.putString(EXTRA_CAMERA_DIRECTION, LensFacingConverter.nameOf(getCameraLensFacing().intValue()));
        }
        bundle.putInt(EXTRA_CAPTURE_MODE, getCaptureMode().getId());
        return bundle;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable savedState) {
        if (savedState instanceof Bundle) {
            Bundle bundle = (Bundle) savedState;
            super.onRestoreInstanceState(bundle.getParcelable(EXTRA_SUPER));
            setScaleType(PreviewView.ScaleType.fromId(bundle.getInt(EXTRA_SCALE_TYPE)));
            setZoomRatio(bundle.getFloat(EXTRA_ZOOM_RATIO));
            setPinchToZoomEnabled(bundle.getBoolean(EXTRA_PINCH_TO_ZOOM_ENABLED));
            setFlash(FlashModeConverter.valueOf(bundle.getString(EXTRA_FLASH)));
            setMaxVideoDuration(bundle.getLong(EXTRA_MAX_VIDEO_DURATION));
            setMaxVideoSize(bundle.getLong(EXTRA_MAX_VIDEO_SIZE));
            String string = bundle.getString(EXTRA_CAMERA_DIRECTION);
            setCameraLensFacing(TextUtils.isEmpty(string) ? null : Integer.valueOf(LensFacingConverter.valueOf(string)));
            setCaptureMode(CaptureMode.fromId(bundle.getInt(EXTRA_CAPTURE_MODE)));
            return;
        }
        super.onRestoreInstanceState(savedState);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((DisplayManager) getContext().getSystemService("display")).registerDisplayListener(this.mDisplayListener, new Handler(Looper.getMainLooper()));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ((DisplayManager) getContext().getSystemService("display")).unregisterDisplayListener(this.mDisplayListener);
    }

    public LiveData<PreviewView.StreamState> getPreviewStreamState() {
        return this.mPreviewView.getPreviewStreamState();
    }

    PreviewView getPreviewView() {
        return this.mPreviewView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0) {
            this.mCameraModule.bindToLifecycleAfterViewMeasured();
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.mCameraModule.bindToLifecycleAfterViewMeasured();
        this.mCameraModule.invalidateView();
        super.onLayout(changed, left, top, right, bottom);
    }

    int getDisplaySurfaceRotation() {
        Display display = getDisplay();
        if (display == null) {
            return 0;
        }
        return display.getRotation();
    }

    public PreviewView.ScaleType getScaleType() {
        return this.mPreviewView.getScaleType();
    }

    public void setScaleType(PreviewView.ScaleType scaleType) {
        this.mPreviewView.setScaleType(scaleType);
    }

    public CaptureMode getCaptureMode() {
        return this.mCameraModule.getCaptureMode();
    }

    public void setCaptureMode(CaptureMode captureMode) {
        this.mCameraModule.setCaptureMode(captureMode);
    }

    public long getMaxVideoDuration() {
        return this.mCameraModule.getMaxVideoDuration();
    }

    private void setMaxVideoDuration(long duration) {
        this.mCameraModule.setMaxVideoDuration(duration);
    }

    private long getMaxVideoSize() {
        return this.mCameraModule.getMaxVideoSize();
    }

    private void setMaxVideoSize(long size) {
        this.mCameraModule.setMaxVideoSize(size);
    }

    public void takePicture(Executor executor, ImageCapture.OnImageCapturedCallback callback) {
        this.mCameraModule.takePicture(executor, callback);
    }

    public void takePicture(ImageCapture.OutputFileOptions outputFileOptions, Executor executor, ImageCapture.OnImageSavedCallback callback) {
        this.mCameraModule.takePicture(outputFileOptions, executor, callback);
    }

    public void startRecording(File file, Executor executor, OnVideoSavedCallback callback) {
        startRecording(OutputFileOptions.builder(file).build(), executor, callback);
    }

    public void startRecording(ParcelFileDescriptor fd, Executor executor, OnVideoSavedCallback callback) {
        startRecording(OutputFileOptions.builder(fd).build(), executor, callback);
    }

    public void startRecording(OutputFileOptions outputFileOptions, Executor executor, final OnVideoSavedCallback callback) {
        this.mCameraModule.startRecording(outputFileOptions.toVideoCaptureOutputFileOptions(), executor, new VideoCapture.OnVideoSavedCallback() { // from class: androidx.camera.view.CameraView.2
            @Override // androidx.camera.core.VideoCapture.OnVideoSavedCallback
            public void onVideoSaved(VideoCapture.OutputFileResults outputFileResults) {
                callback.onVideoSaved(OutputFileResults.create(outputFileResults.getSavedUri()));
            }

            @Override // androidx.camera.core.VideoCapture.OnVideoSavedCallback
            public void onError(int videoCaptureError, String message, Throwable cause) {
                callback.onError(videoCaptureError, message, cause);
            }
        });
    }

    public void stopRecording() {
        this.mCameraModule.stopRecording();
    }

    public boolean isRecording() {
        return this.mCameraModule.isRecording();
    }

    public boolean hasCameraWithLensFacing(int lensFacing) {
        return this.mCameraModule.hasCameraWithLensFacing(lensFacing);
    }

    public void toggleCamera() {
        this.mCameraModule.toggleCamera();
    }

    public void setCameraLensFacing(Integer lensFacing) {
        this.mCameraModule.setCameraLensFacing(lensFacing);
    }

    public Integer getCameraLensFacing() {
        return this.mCameraModule.getLensFacing();
    }

    public int getFlash() {
        return this.mCameraModule.getFlash();
    }

    public void setFlash(int flashMode) {
        this.mCameraModule.setFlash(flashMode);
    }

    private long delta() {
        return System.currentTimeMillis() - this.mDownEventTimestamp;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (this.mCameraModule.isPaused()) {
            return false;
        }
        if (isPinchToZoomEnabled()) {
            this.mPinchToZoomGestureDetector.onTouchEvent(event);
        }
        if (event.getPointerCount() == 2 && isPinchToZoomEnabled() && isZoomSupported()) {
            return true;
        }
        int action = event.getAction();
        if (action == 0) {
            this.mDownEventTimestamp = System.currentTimeMillis();
        } else {
            if (action != 1) {
                return false;
            }
            if (delta() < ViewConfiguration.getLongPressTimeout() && this.mCameraModule.isBoundToLifecycle()) {
                this.mUpEvent = event;
                performClick();
            }
        }
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        MotionEvent motionEvent = this.mUpEvent;
        float x = motionEvent != null ? motionEvent.getX() : getX() + (getWidth() / 2.0f);
        MotionEvent motionEvent2 = this.mUpEvent;
        float y = motionEvent2 != null ? motionEvent2.getY() : getY() + (getHeight() / 2.0f);
        this.mUpEvent = null;
        Camera camera = this.mCameraModule.getCamera();
        if (camera != null) {
            MeteringPointFactory meteringPointFactory = this.mPreviewView.getMeteringPointFactory();
            Futures.addCallback(camera.getCameraControl().startFocusAndMetering(new FocusMeteringAction.Builder(meteringPointFactory.createPoint(x, y, 0.16666667f), 1).addPoint(meteringPointFactory.createPoint(x, y, 0.25f), 2).build()), new FutureCallback<FocusMeteringResult>() { // from class: androidx.camera.view.CameraView.3
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(FocusMeteringResult result) {
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(Throwable t) {
                    throw new RuntimeException(t);
                }
            }, CameraXExecutors.directExecutor());
        } else {
            Logger.m1137d(TAG, "cannot access camera");
        }
        return true;
    }

    float rangeLimit(float val, float max, float min) {
        return Math.min(Math.max(val, min), max);
    }

    public boolean isPinchToZoomEnabled() {
        return this.mIsPinchToZoomEnabled;
    }

    public void setPinchToZoomEnabled(boolean enabled) {
        this.mIsPinchToZoomEnabled = enabled;
    }

    public float getZoomRatio() {
        return this.mCameraModule.getZoomRatio();
    }

    public void setZoomRatio(float zoomRatio) {
        this.mCameraModule.setZoomRatio(zoomRatio);
    }

    public float getMinZoomRatio() {
        return this.mCameraModule.getMinZoomRatio();
    }

    public float getMaxZoomRatio() {
        return this.mCameraModule.getMaxZoomRatio();
    }

    public boolean isZoomSupported() {
        return this.mCameraModule.isZoomSupported();
    }

    public void enableTorch(boolean torch) {
        this.mCameraModule.enableTorch(torch);
    }

    public boolean isTorchOn() {
        return this.mCameraModule.isTorchOn();
    }

    public enum CaptureMode {
        IMAGE(0),
        VIDEO(1),
        MIXED(2);

        private final int mId;

        int getId() {
            return this.mId;
        }

        CaptureMode(int id) {
            this.mId = id;
        }

        static CaptureMode fromId(int id) {
            for (CaptureMode captureMode : values()) {
                if (captureMode.mId == id) {
                    return captureMode;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: renamed from: androidx.camera.view.CameraView$S */
    static class C0496S extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private ScaleGestureDetector.OnScaleGestureListener mListener;

        C0496S() {
        }

        void setRealGestureDetector(ScaleGestureDetector.OnScaleGestureListener l) {
            this.mListener = l;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector detector) {
            return this.mListener.onScale(detector);
        }
    }

    private class PinchToZoomGestureDetector extends ScaleGestureDetector implements ScaleGestureDetector.OnScaleGestureListener {
        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector detector) {
        }

        PinchToZoomGestureDetector(final CameraView this$0, Context context) {
            this(context, new C0496S());
        }

        PinchToZoomGestureDetector(Context context, C0496S s) {
            super(context, s);
            s.setRealGestureDetector(this);
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector detector) {
            float scaleFactor = detector.getScaleFactor();
            float zoomRatio = CameraView.this.getZoomRatio() * (scaleFactor > 1.0f ? ((scaleFactor - 1.0f) * 2.0f) + 1.0f : 1.0f - ((1.0f - scaleFactor) * 2.0f));
            CameraView cameraView = CameraView.this;
            CameraView.this.setZoomRatio(cameraView.rangeLimit(zoomRatio, cameraView.getMaxZoomRatio(), CameraView.this.getMinZoomRatio()));
            return true;
        }
    }
}
