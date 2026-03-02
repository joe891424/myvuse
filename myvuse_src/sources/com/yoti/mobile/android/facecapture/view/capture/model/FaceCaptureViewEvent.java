package com.yoti.mobile.android.facecapture.view.capture.model;

import com.newrelic.agent.android.agentdata.HexAttribute;
import com.yoti.mobile.android.capture.face.p048ui.models.camera.CameraError;
import com.yoti.mobile.android.capture.face.p048ui.models.face.FaceCaptureResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/FaceCaptureViewEvent;", "", "()V", "OnAnalysisStarted", "OnCameraError", "OnCapturePressed", "OnDetectionResult", "OnFaceCaptureFinished", "OnMissingPermissions", "Lcom/yoti/mobile/android/facecapture/view/capture/model/FaceCaptureViewEvent$OnCapturePressed;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/FaceCaptureViewEvent$OnAnalysisStarted;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/FaceCaptureViewEvent$OnDetectionResult;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/FaceCaptureViewEvent$OnCameraError;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/FaceCaptureViewEvent$OnMissingPermissions;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/FaceCaptureViewEvent$OnFaceCaptureFinished;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class FaceCaptureViewEvent {

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/FaceCaptureViewEvent$OnAnalysisStarted;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/FaceCaptureViewEvent;", "config", "Lcom/yoti/mobile/android/facecapture/view/capture/model/CaptureConfig;", "(Lcom/yoti/mobile/android/facecapture/view/capture/model/CaptureConfig;)V", "getConfig", "()Lcom/yoti/mobile/android/facecapture/view/capture/model/CaptureConfig;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class OnAnalysisStarted extends FaceCaptureViewEvent {
        private final CaptureConfig config;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnAnalysisStarted(CaptureConfig config) {
            super(null);
            Intrinsics.checkNotNullParameter(config, "config");
            this.config = config;
        }

        public static /* synthetic */ OnAnalysisStarted copy$default(OnAnalysisStarted onAnalysisStarted, CaptureConfig captureConfig, int i, Object obj) {
            if ((i & 1) != 0) {
                captureConfig = onAnalysisStarted.config;
            }
            return onAnalysisStarted.copy(captureConfig);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CaptureConfig getConfig() {
            return this.config;
        }

        public final OnAnalysisStarted copy(CaptureConfig config) {
            Intrinsics.checkNotNullParameter(config, "config");
            return new OnAnalysisStarted(config);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnAnalysisStarted) && Intrinsics.areEqual(this.config, ((OnAnalysisStarted) other).config);
        }

        public final CaptureConfig getConfig() {
            return this.config;
        }

        public int hashCode() {
            return this.config.hashCode();
        }

        public String toString() {
            return "OnAnalysisStarted(config=" + this.config + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/FaceCaptureViewEvent$OnCameraError;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/FaceCaptureViewEvent;", HexAttribute.HEX_ATTR_CAUSE, "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraError;", "(Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraError;)V", "getCause", "()Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraError;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class OnCameraError extends FaceCaptureViewEvent {
        private final CameraError cause;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnCameraError(CameraError cause) {
            super(null);
            Intrinsics.checkNotNullParameter(cause, "cause");
            this.cause = cause;
        }

        public static /* synthetic */ OnCameraError copy$default(OnCameraError onCameraError, CameraError cameraError, int i, Object obj) {
            if ((i & 1) != 0) {
                cameraError = onCameraError.cause;
            }
            return onCameraError.copy(cameraError);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CameraError getCause() {
            return this.cause;
        }

        public final OnCameraError copy(CameraError cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            return new OnCameraError(cause);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnCameraError) && Intrinsics.areEqual(this.cause, ((OnCameraError) other).cause);
        }

        public final CameraError getCause() {
            return this.cause;
        }

        public int hashCode() {
            return this.cause.hashCode();
        }

        public String toString() {
            return "OnCameraError(cause=" + this.cause + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/FaceCaptureViewEvent$OnCapturePressed;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/FaceCaptureViewEvent;", "lightLevel", "", "(F)V", "getLightLevel", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class OnCapturePressed extends FaceCaptureViewEvent {
        private final float lightLevel;

        public OnCapturePressed() {
            this(0.0f, 1, null);
        }

        public /* synthetic */ OnCapturePressed(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 2000.0f : f);
        }

        public static /* synthetic */ OnCapturePressed copy$default(OnCapturePressed onCapturePressed, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = onCapturePressed.lightLevel;
            }
            return onCapturePressed.copy(f);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getLightLevel() {
            return this.lightLevel;
        }

        public final OnCapturePressed copy(float lightLevel) {
            return new OnCapturePressed(lightLevel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnCapturePressed) && Intrinsics.areEqual((Object) Float.valueOf(this.lightLevel), (Object) Float.valueOf(((OnCapturePressed) other).lightLevel));
        }

        public final float getLightLevel() {
            return this.lightLevel;
        }

        public int hashCode() {
            return Float.hashCode(this.lightLevel);
        }

        public String toString() {
            return "OnCapturePressed(lightLevel=" + this.lightLevel + ')';
        }

        public OnCapturePressed(float f) {
            super(null);
            this.lightLevel = f;
        }
    }

    @Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/FaceCaptureViewEvent$OnDetectionResult;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/FaceCaptureViewEvent;", "result", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureResult;", "lightLevel", "", "(Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureResult;F)V", "getLightLevel", "()F", "getResult", "()Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureResult;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class OnDetectionResult extends FaceCaptureViewEvent {
        private final float lightLevel;
        private final FaceCaptureResult result;

        public /* synthetic */ OnDetectionResult(FaceCaptureResult faceCaptureResult, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(faceCaptureResult, (i & 2) != 0 ? 2000.0f : f);
        }

        public static /* synthetic */ OnDetectionResult copy$default(OnDetectionResult onDetectionResult, FaceCaptureResult faceCaptureResult, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                faceCaptureResult = onDetectionResult.result;
            }
            if ((i & 2) != 0) {
                f = onDetectionResult.lightLevel;
            }
            return onDetectionResult.copy(faceCaptureResult, f);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FaceCaptureResult getResult() {
            return this.result;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getLightLevel() {
            return this.lightLevel;
        }

        public final OnDetectionResult copy(FaceCaptureResult result, float lightLevel) {
            Intrinsics.checkNotNullParameter(result, "result");
            return new OnDetectionResult(result, lightLevel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnDetectionResult)) {
                return false;
            }
            OnDetectionResult onDetectionResult = (OnDetectionResult) other;
            return Intrinsics.areEqual(this.result, onDetectionResult.result) && Intrinsics.areEqual((Object) Float.valueOf(this.lightLevel), (Object) Float.valueOf(onDetectionResult.lightLevel));
        }

        public final float getLightLevel() {
            return this.lightLevel;
        }

        public final FaceCaptureResult getResult() {
            return this.result;
        }

        public int hashCode() {
            return (this.result.hashCode() * 31) + Float.hashCode(this.lightLevel);
        }

        public String toString() {
            return "OnDetectionResult(result=" + this.result + ", lightLevel=" + this.lightLevel + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnDetectionResult(FaceCaptureResult result, float f) {
            super(null);
            Intrinsics.checkNotNullParameter(result, "result");
            this.result = result;
            this.lightLevel = f;
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/FaceCaptureViewEvent$OnFaceCaptureFinished;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/FaceCaptureViewEvent;", "()V", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class OnFaceCaptureFinished extends FaceCaptureViewEvent {
        public static final OnFaceCaptureFinished INSTANCE = new OnFaceCaptureFinished();

        private OnFaceCaptureFinished() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/FaceCaptureViewEvent$OnMissingPermissions;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/FaceCaptureViewEvent;", "()V", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class OnMissingPermissions extends FaceCaptureViewEvent {
        public static final OnMissingPermissions INSTANCE = new OnMissingPermissions();

        private OnMissingPermissions() {
            super(null);
        }
    }

    private FaceCaptureViewEvent() {
    }

    public /* synthetic */ FaceCaptureViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
