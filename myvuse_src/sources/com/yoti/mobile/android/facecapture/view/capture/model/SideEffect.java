package com.yoti.mobile.android.facecapture.view.capture.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.yoti.mobile.android.commons.image.ImageBuffer;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/SideEffect;", "", "()V", "CompleteCapture", "CompleteCaptureRaw", "FallbackMode", "StartFlashTimeout", "StartTimeout", "StopTimeout", "Lcom/yoti/mobile/android/facecapture/view/capture/model/SideEffect$StartTimeout;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/SideEffect$StopTimeout;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/SideEffect$CompleteCapture;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/SideEffect$CompleteCaptureRaw;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/SideEffect$StartFlashTimeout;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/SideEffect$FallbackMode;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class SideEffect {

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/SideEffect$CompleteCapture;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/SideEffect;", TypedValues.AttributesType.S_FRAME, "", "([B)V", "getFrame", "()[B", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class CompleteCapture extends SideEffect {
        private final byte[] frame;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CompleteCapture(byte[] frame) {
            super(null);
            Intrinsics.checkNotNullParameter(frame, "frame");
            this.frame = frame;
        }

        public static /* synthetic */ CompleteCapture copy$default(CompleteCapture completeCapture, byte[] bArr, int i, Object obj) {
            if ((i & 1) != 0) {
                bArr = completeCapture.frame;
            }
            return completeCapture.copy(bArr);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final byte[] getFrame() {
            return this.frame;
        }

        public final CompleteCapture copy(byte[] frame) {
            Intrinsics.checkNotNullParameter(frame, "frame");
            return new CompleteCapture(frame);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CompleteCapture) && Intrinsics.areEqual(this.frame, ((CompleteCapture) other).frame);
        }

        public final byte[] getFrame() {
            return this.frame;
        }

        public int hashCode() {
            return Arrays.hashCode(this.frame);
        }

        public String toString() {
            return "CompleteCapture(frame=" + Arrays.toString(this.frame) + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/SideEffect$CompleteCaptureRaw;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/SideEffect;", "rawImage", "Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "(Lcom/yoti/mobile/android/commons/image/ImageBuffer;)V", "getRawImage", "()Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class CompleteCaptureRaw extends SideEffect {
        private final ImageBuffer rawImage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CompleteCaptureRaw(ImageBuffer rawImage) {
            super(null);
            Intrinsics.checkNotNullParameter(rawImage, "rawImage");
            this.rawImage = rawImage;
        }

        public static /* synthetic */ CompleteCaptureRaw copy$default(CompleteCaptureRaw completeCaptureRaw, ImageBuffer imageBuffer, int i, Object obj) {
            if ((i & 1) != 0) {
                imageBuffer = completeCaptureRaw.rawImage;
            }
            return completeCaptureRaw.copy(imageBuffer);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ImageBuffer getRawImage() {
            return this.rawImage;
        }

        public final CompleteCaptureRaw copy(ImageBuffer rawImage) {
            Intrinsics.checkNotNullParameter(rawImage, "rawImage");
            return new CompleteCaptureRaw(rawImage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CompleteCaptureRaw) && Intrinsics.areEqual(this.rawImage, ((CompleteCaptureRaw) other).rawImage);
        }

        public final ImageBuffer getRawImage() {
            return this.rawImage;
        }

        public int hashCode() {
            return this.rawImage.hashCode();
        }

        public String toString() {
            return "CompleteCaptureRaw(rawImage=" + this.rawImage + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/SideEffect$FallbackMode;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/SideEffect;", "()V", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class FallbackMode extends SideEffect {
        public static final FallbackMode INSTANCE = new FallbackMode();

        private FallbackMode() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/SideEffect$StartFlashTimeout;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/SideEffect;", "()V", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class StartFlashTimeout extends SideEffect {
        public static final StartFlashTimeout INSTANCE = new StartFlashTimeout();

        private StartFlashTimeout() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/SideEffect$StartTimeout;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/SideEffect;", "()V", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class StartTimeout extends SideEffect {
        public static final StartTimeout INSTANCE = new StartTimeout();

        private StartTimeout() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/SideEffect$StopTimeout;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/SideEffect;", "()V", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class StopTimeout extends SideEffect {
        public static final StopTimeout INSTANCE = new StopTimeout();

        private StopTimeout() {
            super(null);
        }
    }

    private SideEffect() {
    }

    public /* synthetic */ SideEffect(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
