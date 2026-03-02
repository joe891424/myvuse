package com.yoti.mobile.android.facecapture.view.capture.util;

import android.graphics.PointF;
import com.yoti.mobile.android.capture.face.p048ui.models.camera.CameraConfiguration;
import com.yoti.mobile.android.capture.face.p048ui.models.camera.CameraFacing;
import com.yoti.mobile.android.capture.face.p048ui.models.face.FaceCaptureConfiguration;
import com.yoti.mobile.android.capture.face.p048ui.models.face.ImageQuality;
import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/util/CaptureConfigurationProvider;", "", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;", "(Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;)V", "captureMode", "Lcom/yoti/mobile/android/facecapture/view/capture/util/CaptureMode;", "getCaptureMode", "()Lcom/yoti/mobile/android/facecapture/view/capture/util/CaptureMode;", "createCameraConfiguration", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraConfiguration;", "createCaptureConfiguration", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureConfiguration;", "Companion", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class CaptureConfigurationProvider {
    private static final PointF FACE_CENTER = new PointF(0.5f, 0.47f);
    private static final int REQUIRED_STABLE_FRAMES = 3;
    private final CaptureMode captureMode;
    private final LivenessFeatureConfiguration featureConfiguration;

    @Inject
    public CaptureConfigurationProvider(LivenessFeatureConfiguration featureConfiguration) {
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        this.featureConfiguration = featureConfiguration;
        this.captureMode = featureConfiguration.isAutomaticCapture() ? CaptureMode.AUTO : CaptureMode.MANUAL;
    }

    public final CameraConfiguration createCameraConfiguration() {
        return new CameraConfiguration(this.featureConfiguration.getUseBackCamera() ? CameraFacing.BACK : CameraFacing.FRONT);
    }

    public final FaceCaptureConfiguration createCaptureConfiguration() {
        return new FaceCaptureConfiguration(FACE_CENTER, ImageQuality.HIGH, true, true, true, 3);
    }

    public final CaptureMode getCaptureMode() {
        return this.captureMode;
    }
}
