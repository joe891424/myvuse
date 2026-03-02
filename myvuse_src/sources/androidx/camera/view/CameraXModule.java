package androidx.camera.view;

import android.content.Context;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.impl.LensFacingConverter;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.CameraView;
import androidx.core.util.Preconditions;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
final class CameraXModule {
    public static final String TAG = "CameraXModule";
    private static final float UNITY_ZOOM_SCALE = 1.0f;
    private static final float ZOOM_NOT_SUPPORTED = 1.0f;
    Camera mCamera;
    ProcessCameraProvider mCameraProvider;
    private final CameraView mCameraView;
    LifecycleOwner mCurrentLifecycle;
    private ImageCapture mImageCapture;
    private final ImageCapture.Builder mImageCaptureBuilder;
    private LifecycleOwner mNewLifecycle;
    Preview mPreview;
    private final Preview.Builder mPreviewBuilder;
    private VideoCapture mVideoCapture;
    private final VideoCapture.Builder mVideoCaptureBuilder;
    private static final Rational ASPECT_RATIO_16_9 = new Rational(16, 9);
    private static final Rational ASPECT_RATIO_4_3 = new Rational(4, 3);
    private static final Rational ASPECT_RATIO_9_16 = new Rational(9, 16);
    private static final Rational ASPECT_RATIO_3_4 = new Rational(3, 4);
    final AtomicBoolean mVideoIsRecording = new AtomicBoolean(false);
    private CameraView.CaptureMode mCaptureMode = CameraView.CaptureMode.IMAGE;
    private long mMaxVideoDuration = -1;
    private long mMaxVideoSize = -1;
    private int mFlash = 2;
    private final LifecycleObserver mCurrentLifecycleObserver = new LifecycleObserver() { // from class: androidx.camera.view.CameraXModule.1
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy(LifecycleOwner owner) {
            if (owner == CameraXModule.this.mCurrentLifecycle) {
                CameraXModule.this.clearCurrentLifecycle();
            }
        }
    };
    Integer mCameraLensFacing = 1;

    public boolean isPaused() {
        return false;
    }

    CameraXModule(CameraView view) {
        this.mCameraView = view;
        Futures.addCallback(ProcessCameraProvider.getInstance(view.getContext()), new FutureCallback<ProcessCameraProvider>() { // from class: androidx.camera.view.CameraXModule.2
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(ProcessCameraProvider provider) {
                Preconditions.checkNotNull(provider);
                CameraXModule.this.mCameraProvider = provider;
                if (CameraXModule.this.mCurrentLifecycle != null) {
                    CameraXModule cameraXModule = CameraXModule.this;
                    cameraXModule.bindToLifecycle(cameraXModule.mCurrentLifecycle);
                }
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable t) {
                throw new RuntimeException("CameraX failed to initialize.", t);
            }
        }, CameraXExecutors.mainThreadExecutor());
        this.mPreviewBuilder = new Preview.Builder().setTargetName("Preview");
        this.mImageCaptureBuilder = new ImageCapture.Builder().setTargetName("ImageCapture");
        this.mVideoCaptureBuilder = new VideoCapture.Builder().setTargetName("VideoCapture");
    }

    void bindToLifecycle(LifecycleOwner lifecycleOwner) {
        this.mNewLifecycle = lifecycleOwner;
        if (getMeasuredWidth() <= 0 || getMeasuredHeight() <= 0) {
            return;
        }
        bindToLifecycleAfterViewMeasured();
    }

    void bindToLifecycleAfterViewMeasured() {
        Rational rational;
        if (this.mNewLifecycle == null) {
            return;
        }
        clearCurrentLifecycle();
        if (this.mNewLifecycle.getLifecycle().getState() == Lifecycle.State.DESTROYED) {
            this.mNewLifecycle = null;
            return;
        }
        this.mCurrentLifecycle = this.mNewLifecycle;
        this.mNewLifecycle = null;
        if (this.mCameraProvider == null) {
            return;
        }
        Set<Integer> availableCameraLensFacing = getAvailableCameraLensFacing();
        if (availableCameraLensFacing.isEmpty()) {
            Logger.m1143w(TAG, "Unable to bindToLifeCycle since no cameras available");
            this.mCameraLensFacing = null;
        }
        Integer num = this.mCameraLensFacing;
        if (num != null && !availableCameraLensFacing.contains(num)) {
            Logger.m1143w(TAG, "Camera does not exist with direction " + this.mCameraLensFacing);
            this.mCameraLensFacing = availableCameraLensFacing.iterator().next();
            Logger.m1143w(TAG, "Defaulting to primary camera with direction " + this.mCameraLensFacing);
        }
        if (this.mCameraLensFacing == null) {
            return;
        }
        boolean z = getDisplayRotationDegrees() == 0 || getDisplayRotationDegrees() == 180;
        if (getCaptureMode() == CameraView.CaptureMode.IMAGE) {
            rational = z ? ASPECT_RATIO_3_4 : ASPECT_RATIO_4_3;
        } else {
            this.mImageCaptureBuilder.setTargetAspectRatio(1);
            this.mVideoCaptureBuilder.setTargetAspectRatio(1);
            rational = z ? ASPECT_RATIO_9_16 : ASPECT_RATIO_16_9;
        }
        this.mImageCaptureBuilder.setTargetRotation(getDisplaySurfaceRotation());
        this.mImageCapture = this.mImageCaptureBuilder.build();
        this.mVideoCaptureBuilder.setTargetRotation(getDisplaySurfaceRotation());
        this.mVideoCapture = this.mVideoCaptureBuilder.build();
        this.mPreviewBuilder.setTargetResolution(new Size(getMeasuredWidth(), (int) (getMeasuredWidth() / rational.floatValue())));
        Preview previewBuild = this.mPreviewBuilder.build();
        this.mPreview = previewBuild;
        previewBuild.setSurfaceProvider(this.mCameraView.getPreviewView().getSurfaceProvider());
        CameraSelector cameraSelectorBuild = new CameraSelector.Builder().requireLensFacing(this.mCameraLensFacing.intValue()).build();
        if (getCaptureMode() == CameraView.CaptureMode.IMAGE) {
            this.mCamera = this.mCameraProvider.bindToLifecycle(this.mCurrentLifecycle, cameraSelectorBuild, this.mImageCapture, this.mPreview);
        } else if (getCaptureMode() == CameraView.CaptureMode.VIDEO) {
            this.mCamera = this.mCameraProvider.bindToLifecycle(this.mCurrentLifecycle, cameraSelectorBuild, this.mVideoCapture, this.mPreview);
        } else {
            this.mCamera = this.mCameraProvider.bindToLifecycle(this.mCurrentLifecycle, cameraSelectorBuild, this.mImageCapture, this.mVideoCapture, this.mPreview);
        }
        setZoomRatio(1.0f);
        this.mCurrentLifecycle.getLifecycle().addObserver(this.mCurrentLifecycleObserver);
        setFlash(getFlash());
    }

    public void open() {
        throw new UnsupportedOperationException("Explicit open/close of camera not yet supported. Use bindtoLifecycle() instead.");
    }

    public void close() {
        throw new UnsupportedOperationException("Explicit open/close of camera not yet supported. Use bindtoLifecycle() instead.");
    }

    public void takePicture(Executor executor, ImageCapture.OnImageCapturedCallback callback) {
        if (this.mImageCapture == null) {
            return;
        }
        if (getCaptureMode() == CameraView.CaptureMode.VIDEO) {
            throw new IllegalStateException("Can not take picture under VIDEO capture mode.");
        }
        if (callback == null) {
            throw new IllegalArgumentException("OnImageCapturedCallback should not be empty");
        }
        this.mImageCapture.m5728lambda$takePicture$4$androidxcameracoreImageCapture(executor, callback);
    }

    public void takePicture(ImageCapture.OutputFileOptions outputFileOptions, Executor executor, ImageCapture.OnImageSavedCallback callback) {
        if (this.mImageCapture == null) {
            return;
        }
        if (getCaptureMode() == CameraView.CaptureMode.VIDEO) {
            throw new IllegalStateException("Can not take picture under VIDEO capture mode.");
        }
        if (callback == null) {
            throw new IllegalArgumentException("OnImageSavedCallback should not be empty");
        }
        ImageCapture.Metadata metadata = outputFileOptions.getMetadata();
        Integer num = this.mCameraLensFacing;
        metadata.setReversedHorizontal(num != null && num.intValue() == 0);
        this.mImageCapture.takePicture(outputFileOptions, executor, callback);
    }

    public void startRecording(VideoCapture.OutputFileOptions outputFileOptions, Executor executor, final VideoCapture.OnVideoSavedCallback callback) {
        if (this.mVideoCapture == null) {
            return;
        }
        if (getCaptureMode() == CameraView.CaptureMode.IMAGE) {
            throw new IllegalStateException("Can not record video under IMAGE capture mode.");
        }
        if (callback == null) {
            throw new IllegalArgumentException("OnVideoSavedCallback should not be empty");
        }
        this.mVideoIsRecording.set(true);
        this.mVideoCapture.m5744lambda$startRecording$0$androidxcameracoreVideoCapture(outputFileOptions, executor, new VideoCapture.OnVideoSavedCallback() { // from class: androidx.camera.view.CameraXModule.3
            @Override // androidx.camera.core.VideoCapture.OnVideoSavedCallback
            public void onVideoSaved(VideoCapture.OutputFileResults outputFileResults) {
                CameraXModule.this.mVideoIsRecording.set(false);
                callback.onVideoSaved(outputFileResults);
            }

            @Override // androidx.camera.core.VideoCapture.OnVideoSavedCallback
            public void onError(int videoCaptureError, String message, Throwable cause) {
                CameraXModule.this.mVideoIsRecording.set(false);
                Logger.m1140e(CameraXModule.TAG, message, cause);
                callback.onError(videoCaptureError, message, cause);
            }
        });
    }

    public void stopRecording() {
        VideoCapture videoCapture = this.mVideoCapture;
        if (videoCapture == null) {
            return;
        }
        videoCapture.m5748lambda$stopRecording$5$androidxcameracoreVideoCapture();
    }

    public boolean isRecording() {
        return this.mVideoIsRecording.get();
    }

    public void setCameraLensFacing(Integer lensFacing) {
        if (Objects.equals(this.mCameraLensFacing, lensFacing)) {
            return;
        }
        this.mCameraLensFacing = lensFacing;
        LifecycleOwner lifecycleOwner = this.mCurrentLifecycle;
        if (lifecycleOwner != null) {
            bindToLifecycle(lifecycleOwner);
        }
    }

    public boolean hasCameraWithLensFacing(int lensFacing) {
        ProcessCameraProvider processCameraProvider = this.mCameraProvider;
        if (processCameraProvider == null) {
            return false;
        }
        try {
            return processCameraProvider.hasCamera(new CameraSelector.Builder().requireLensFacing(lensFacing).build());
        } catch (CameraInfoUnavailableException unused) {
            return false;
        }
    }

    public Integer getLensFacing() {
        return this.mCameraLensFacing;
    }

    public void toggleCamera() {
        Set<Integer> availableCameraLensFacing = getAvailableCameraLensFacing();
        if (availableCameraLensFacing.isEmpty()) {
            return;
        }
        Integer num = this.mCameraLensFacing;
        if (num == null) {
            setCameraLensFacing(availableCameraLensFacing.iterator().next());
            return;
        }
        if (num.intValue() == 1 && availableCameraLensFacing.contains(0)) {
            setCameraLensFacing(0);
        } else if (this.mCameraLensFacing.intValue() == 0 && availableCameraLensFacing.contains(1)) {
            setCameraLensFacing(1);
        }
    }

    public float getZoomRatio() {
        Camera camera = this.mCamera;
        if (camera != null) {
            return camera.getCameraInfo().getZoomState().getValue().getZoomRatio();
        }
        return 1.0f;
    }

    public void setZoomRatio(float zoomRatio) {
        Camera camera = this.mCamera;
        if (camera != null) {
            Futures.addCallback(camera.getCameraControl().setZoomRatio(zoomRatio), new FutureCallback<Void>() { // from class: androidx.camera.view.CameraXModule.4
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(Void result) {
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(Throwable t) {
                    throw new RuntimeException(t);
                }
            }, CameraXExecutors.directExecutor());
        } else {
            Logger.m1139e(TAG, "Failed to set zoom ratio");
        }
    }

    public float getMinZoomRatio() {
        Camera camera = this.mCamera;
        if (camera != null) {
            return camera.getCameraInfo().getZoomState().getValue().getMinZoomRatio();
        }
        return 1.0f;
    }

    public float getMaxZoomRatio() {
        Camera camera = this.mCamera;
        if (camera != null) {
            return camera.getCameraInfo().getZoomState().getValue().getMaxZoomRatio();
        }
        return 1.0f;
    }

    public boolean isZoomSupported() {
        return getMaxZoomRatio() != 1.0f;
    }

    private void rebindToLifecycle() {
        LifecycleOwner lifecycleOwner = this.mCurrentLifecycle;
        if (lifecycleOwner != null) {
            bindToLifecycle(lifecycleOwner);
        }
    }

    boolean isBoundToLifecycle() {
        return this.mCamera != null;
    }

    int getRelativeCameraOrientation(boolean compensateForMirroring) {
        Camera camera = this.mCamera;
        if (camera == null) {
            return 0;
        }
        int sensorRotationDegrees = camera.getCameraInfo().getSensorRotationDegrees(getDisplaySurfaceRotation());
        return compensateForMirroring ? (360 - sensorRotationDegrees) % 360 : sensorRotationDegrees;
    }

    public void invalidateView() {
        updateViewInfo();
    }

    void clearCurrentLifecycle() {
        if (this.mCurrentLifecycle != null && this.mCameraProvider != null) {
            ArrayList arrayList = new ArrayList();
            ImageCapture imageCapture = this.mImageCapture;
            if (imageCapture != null && this.mCameraProvider.isBound(imageCapture)) {
                arrayList.add(this.mImageCapture);
            }
            VideoCapture videoCapture = this.mVideoCapture;
            if (videoCapture != null && this.mCameraProvider.isBound(videoCapture)) {
                arrayList.add(this.mVideoCapture);
            }
            Preview preview = this.mPreview;
            if (preview != null && this.mCameraProvider.isBound(preview)) {
                arrayList.add(this.mPreview);
            }
            if (!arrayList.isEmpty()) {
                this.mCameraProvider.unbind((UseCase[]) arrayList.toArray(new UseCase[0]));
            }
            Preview preview2 = this.mPreview;
            if (preview2 != null) {
                preview2.setSurfaceProvider(null);
            }
        }
        this.mCamera = null;
        this.mCurrentLifecycle = null;
    }

    private void updateViewInfo() {
        ImageCapture imageCapture = this.mImageCapture;
        if (imageCapture != null) {
            imageCapture.setCropAspectRatio(new Rational(getWidth(), getHeight()));
            this.mImageCapture.setTargetRotation(getDisplaySurfaceRotation());
        }
        VideoCapture videoCapture = this.mVideoCapture;
        if (videoCapture != null) {
            videoCapture.setTargetRotation(getDisplaySurfaceRotation());
        }
    }

    private Set<Integer> getAvailableCameraLensFacing() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(LensFacingConverter.values()));
        if (this.mCurrentLifecycle != null) {
            if (!hasCameraWithLensFacing(1)) {
                linkedHashSet.remove(1);
            }
            if (!hasCameraWithLensFacing(0)) {
                linkedHashSet.remove(0);
            }
        }
        return linkedHashSet;
    }

    public int getFlash() {
        return this.mFlash;
    }

    public void setFlash(int flash) {
        this.mFlash = flash;
        ImageCapture imageCapture = this.mImageCapture;
        if (imageCapture == null) {
            return;
        }
        imageCapture.setFlashMode(flash);
    }

    public void enableTorch(boolean torch) {
        Camera camera = this.mCamera;
        if (camera == null) {
            return;
        }
        Futures.addCallback(camera.getCameraControl().enableTorch(torch), new FutureCallback<Void>() { // from class: androidx.camera.view.CameraXModule.5
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(Void result) {
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable t) {
                throw new RuntimeException(t);
            }
        }, CameraXExecutors.directExecutor());
    }

    public boolean isTorchOn() {
        Camera camera = this.mCamera;
        return camera != null && camera.getCameraInfo().getTorchState().getValue().intValue() == 1;
    }

    public Context getContext() {
        return this.mCameraView.getContext();
    }

    public int getWidth() {
        return this.mCameraView.getWidth();
    }

    public int getHeight() {
        return this.mCameraView.getHeight();
    }

    public int getDisplayRotationDegrees() {
        return CameraOrientationUtil.surfaceRotationToDegrees(getDisplaySurfaceRotation());
    }

    protected int getDisplaySurfaceRotation() {
        return this.mCameraView.getDisplaySurfaceRotation();
    }

    private int getMeasuredWidth() {
        return this.mCameraView.getMeasuredWidth();
    }

    private int getMeasuredHeight() {
        return this.mCameraView.getMeasuredHeight();
    }

    public Camera getCamera() {
        return this.mCamera;
    }

    public CameraView.CaptureMode getCaptureMode() {
        return this.mCaptureMode;
    }

    public void setCaptureMode(CameraView.CaptureMode captureMode) {
        this.mCaptureMode = captureMode;
        rebindToLifecycle();
    }

    public long getMaxVideoDuration() {
        return this.mMaxVideoDuration;
    }

    public void setMaxVideoDuration(long duration) {
        this.mMaxVideoDuration = duration;
    }

    public long getMaxVideoSize() {
        return this.mMaxVideoSize;
    }

    public void setMaxVideoSize(long size) {
        this.mMaxVideoSize = size;
    }
}
