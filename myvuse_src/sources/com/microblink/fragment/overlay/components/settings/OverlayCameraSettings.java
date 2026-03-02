package com.microblink.fragment.overlay.components.settings;

import com.microblink.hardware.camera.CameraType;
import com.microblink.hardware.camera.VideoResolutionPreset;
import com.microblink.view.CameraAspectMode;
import com.microblink.view.recognition.RecognizerRunnerView;
import com.microblink.view.surface.CameraSurface;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class OverlayCameraSettings {
    public final CameraAspectMode aspectMode;
    public final boolean forceLegacyApi;
    public final boolean isOptimizedForNearScan;
    public final boolean isPinchToZoomAllowed;
    public final float previewZoomScale;
    public final CameraSurface surface;
    public final CameraType type;
    public final VideoResolutionPreset videoResolutionPreset;

    /* JADX INFO: compiled from: line */
    public static class Builder {
        private CameraType llIIlIlIIl = CameraType.CAMERA_DEFAULT;
        private boolean IlIllIlIIl = false;
        private CameraAspectMode IllIIIllII = CameraAspectMode.ASPECT_FILL;
        private float llIIIlllll = 1.0f;
        private CameraSurface IllIIIIllI = CameraSurface.SURFACE_DEFAULT;
        private boolean lIlIIIIlIl = false;
        private boolean llIIlIIlll = false;
        private VideoResolutionPreset IIlIIIllIl = VideoResolutionPreset.VIDEO_RESOLUTION_DEFAULT;

        public OverlayCameraSettings build() {
            return new OverlayCameraSettings(this.llIIlIlIIl, this.IlIllIlIIl, this.IllIIIllII, this.llIIIlllll, this.IllIIIIllI, this.lIlIIIIlIl, this.llIIlIIlll, this.IIlIIIllIl);
        }

        public Builder setAspectMode(CameraAspectMode cameraAspectMode) {
            this.IllIIIllII = cameraAspectMode;
            return this;
        }

        public Builder setForceLegacyApi(boolean z) {
            this.lIlIIIIlIl = z;
            return this;
        }

        public Builder setIsOptimizedForNearScan(boolean z) {
            this.IlIllIlIIl = z;
            return this;
        }

        public Builder setIsPinchToZoomAllowed(boolean z) {
            this.llIIlIIlll = z;
            return this;
        }

        public Builder setPreviewZoomScale(float f) {
            this.llIIIlllll = f;
            return this;
        }

        public Builder setSurface(CameraSurface cameraSurface) {
            this.IllIIIIllI = cameraSurface;
            return this;
        }

        public Builder setType(CameraType cameraType) {
            this.llIIlIlIIl = cameraType;
            return this;
        }

        public Builder setVideoResolutionPreset(VideoResolutionPreset videoResolutionPreset) {
            this.IIlIIIllIl = videoResolutionPreset;
            return this;
        }
    }

    public void apply(RecognizerRunnerView recognizerRunnerView) {
        recognizerRunnerView.setOptimizeCameraForNearScan(this.isOptimizedForNearScan);
        recognizerRunnerView.setCameraType(this.type);
        recognizerRunnerView.setAspectMode(this.aspectMode);
        recognizerRunnerView.setPreviewZoomScale(this.previewZoomScale);
        recognizerRunnerView.setRequestedSurfaceViewForCameraDisplay(this.surface);
        recognizerRunnerView.setVideoResolutionPreset(this.videoResolutionPreset);
        recognizerRunnerView.setForceUseLegacyCamera(this.forceLegacyApi);
        recognizerRunnerView.setPinchToZoomAllowed(this.isPinchToZoomAllowed);
    }

    private OverlayCameraSettings(CameraType cameraType, boolean z, CameraAspectMode cameraAspectMode, float f, CameraSurface cameraSurface, boolean z2, boolean z3, VideoResolutionPreset videoResolutionPreset) {
        this.type = cameraType;
        this.isOptimizedForNearScan = z;
        this.aspectMode = cameraAspectMode;
        this.previewZoomScale = f;
        this.surface = cameraSurface;
        this.forceLegacyApi = z2;
        this.isPinchToZoomAllowed = z3;
        this.videoResolutionPreset = videoResolutionPreset;
    }
}
