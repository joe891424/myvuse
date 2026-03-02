package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Range;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.ZoomControl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.CameraControl;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
final class AndroidRZoomImpl implements ZoomControl.ZoomImpl {
    public static final float DEFAULT_ZOOM_RATIO = 1.0f;
    private final CameraCharacteristicsCompat mCameraCharacteristics;
    private float mCurrentZoomRatio = 1.0f;
    private float mPendingZoomRatio = 1.0f;
    private CallbackToFutureAdapter.Completer<Void> mPendingZoomRatioCompleter;
    private final Range<Float> mZoomRatioRange;

    AndroidRZoomImpl(CameraCharacteristicsCompat cameraCharacteristics) {
        this.mCameraCharacteristics = cameraCharacteristics;
        this.mZoomRatioRange = (Range) cameraCharacteristics.get(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public float getMinZoom() {
        return ((Float) this.mZoomRatioRange.getLower()).floatValue();
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public float getMaxZoom() {
        return ((Float) this.mZoomRatioRange.getUpper()).floatValue();
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void addRequestOption(Camera2ImplConfig.Builder builder) {
        builder.setCaptureRequestOption(CaptureRequest.CONTROL_ZOOM_RATIO, Float.valueOf(this.mCurrentZoomRatio));
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void resetZoom() {
        this.mCurrentZoomRatio = 1.0f;
        CallbackToFutureAdapter.Completer<Void> completer = this.mPendingZoomRatioCompleter;
        if (completer != null) {
            completer.setException(new CameraControl.OperationCanceledException("Camera is not active."));
            this.mPendingZoomRatioCompleter = null;
        }
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void setZoomRatio(float zoomRatio, CallbackToFutureAdapter.Completer<Void> completer) {
        this.mCurrentZoomRatio = zoomRatio;
        CallbackToFutureAdapter.Completer<Void> completer2 = this.mPendingZoomRatioCompleter;
        if (completer2 != null) {
            completer2.setException(new CameraControl.OperationCanceledException("There is a new zoomRatio being set"));
        }
        this.mPendingZoomRatio = this.mCurrentZoomRatio;
        this.mPendingZoomRatioCompleter = completer;
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void onCaptureResult(TotalCaptureResult captureResult) {
        Float f;
        if (this.mPendingZoomRatioCompleter == null || (f = (Float) captureResult.get(CaptureResult.CONTROL_ZOOM_RATIO)) == null) {
            return;
        }
        if (this.mPendingZoomRatio == f.floatValue()) {
            this.mPendingZoomRatioCompleter.set(null);
            this.mPendingZoomRatioCompleter = null;
        }
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public Rect getCropSensorRegion() {
        return (Rect) Preconditions.checkNotNull((Rect) this.mCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
    }
}
