package androidx.camera.core.impl;

import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.UseCase;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public interface CameraInternal extends Camera, UseCase.StateChangeCallback {
    void attachUseCases(Collection<UseCase> useCases);

    void close();

    void detachUseCases(Collection<UseCase> useCases);

    CameraControlInternal getCameraControlInternal();

    CameraInfoInternal getCameraInfoInternal();

    Observable<State> getCameraState();

    void open();

    ListenableFuture<Void> release();

    @Override // androidx.camera.core.Camera
    default void setExtendedConfig(CameraConfig cameraConfig) throws CameraUseCaseAdapter.CameraException {
    }

    public enum State {
        PENDING_OPEN(false),
        OPENING(true),
        OPEN(true),
        CLOSING(true),
        CLOSED(false),
        RELEASING(true),
        RELEASED(false);

        private final boolean mHoldsCameraSlot;

        State(boolean holdsCameraSlot) {
            this.mHoldsCameraSlot = holdsCameraSlot;
        }

        boolean holdsCameraSlot() {
            return this.mHoldsCameraSlot;
        }
    }

    @Override // androidx.camera.core.Camera
    default CameraControl getCameraControl() {
        return getCameraControlInternal();
    }

    @Override // androidx.camera.core.Camera
    default CameraInfo getCameraInfo() {
        return getCameraInfoInternal();
    }

    @Override // androidx.camera.core.Camera
    default LinkedHashSet<CameraInternal> getCameraInternals() {
        return new LinkedHashSet<>(Collections.singleton(this));
    }

    @Override // androidx.camera.core.Camera
    default CameraConfig getExtendedConfig() {
        return CameraConfigs.emptyConfig();
    }
}
