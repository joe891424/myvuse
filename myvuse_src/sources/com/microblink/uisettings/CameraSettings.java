package com.microblink.uisettings;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.hardware.camera.CameraType;
import com.microblink.hardware.camera.VideoResolutionPreset;
import com.microblink.view.CameraAspectMode;
import com.microblink.view.recognition.RecognizerRunnerView;
import com.microblink.view.surface.CameraSurface;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class CameraSettings implements Parcelable {
    public static final Parcelable.Creator<CameraSettings> CREATOR = new Parcelable.Creator<CameraSettings>() { // from class: com.microblink.uisettings.CameraSettings.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraSettings createFromParcel(Parcel parcel) {
            return new CameraSettings(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraSettings[] newArray(int i) {
            return new CameraSettings[i];
        }
    };
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

        public CameraSettings build() {
            return new CameraSettings(this.llIIlIlIIl, this.IlIllIlIIl, this.IllIIIllII, this.llIIIlllll, this.IllIIIIllI, this.lIlIIIIlIl, this.llIIlIIlll, this.IIlIIIllIl);
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

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.type, i);
        parcel.writeByte(this.isOptimizedForNearScan ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.aspectMode, i);
        parcel.writeFloat(this.previewZoomScale);
        parcel.writeParcelable(this.surface, i);
        parcel.writeByte(this.forceLegacyApi ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isPinchToZoomAllowed ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.videoResolutionPreset, i);
    }

    private CameraSettings(CameraType cameraType, boolean z, CameraAspectMode cameraAspectMode, float f, CameraSurface cameraSurface, boolean z2, boolean z3, VideoResolutionPreset videoResolutionPreset) {
        this.type = cameraType;
        this.isOptimizedForNearScan = z;
        this.aspectMode = cameraAspectMode;
        this.previewZoomScale = f;
        this.surface = cameraSurface;
        this.forceLegacyApi = z2;
        this.isPinchToZoomAllowed = z3;
        this.videoResolutionPreset = videoResolutionPreset;
    }

    private CameraSettings(Parcel parcel) {
        this.type = (CameraType) parcel.readParcelable(CameraType.class.getClassLoader());
        this.isOptimizedForNearScan = parcel.readByte() != 0;
        this.aspectMode = (CameraAspectMode) parcel.readParcelable(CameraAspectMode.class.getClassLoader());
        this.previewZoomScale = parcel.readFloat();
        this.surface = (CameraSurface) parcel.readParcelable(CameraSurface.class.getClassLoader());
        this.forceLegacyApi = parcel.readByte() != 0;
        this.isPinchToZoomAllowed = parcel.readByte() != 0;
        this.videoResolutionPreset = (VideoResolutionPreset) parcel.readParcelable(VideoResolutionPreset.class.getClassLoader());
    }
}
