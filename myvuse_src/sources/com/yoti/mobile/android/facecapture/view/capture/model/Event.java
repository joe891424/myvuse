package com.yoti.mobile.android.facecapture.view.capture.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.yoti.mobile.android.commons.image.ImageBuffer;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/Event;", "", "()V", "OnCapturePressed", "OnFlashTimeout", "OnInvalidFrame", "OnLifecycleStart", "OnLifecycleStop", "OnTimeout", "OnValidFrame", "Lcom/yoti/mobile/android/facecapture/view/capture/model/Event$OnLifecycleStart;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/Event$OnLifecycleStop;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/Event$OnCapturePressed;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/Event$OnInvalidFrame;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/Event$OnValidFrame;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/Event$OnTimeout;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/Event$OnFlashTimeout;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class Event {

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/Event$OnCapturePressed;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/Event;", "lightLevel", "", "(F)V", "getLightLevel", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class OnCapturePressed extends Event {
        private final float lightLevel;

        public OnCapturePressed(float f) {
            super(null);
            this.lightLevel = f;
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
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/Event$OnFlashTimeout;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/Event;", "()V", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class OnFlashTimeout extends Event {
        public static final OnFlashTimeout INSTANCE = new OnFlashTimeout();

        private OnFlashTimeout() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/Event$OnInvalidFrame;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/Event;", "error", "Lcom/yoti/mobile/android/facecapture/view/capture/model/ScanFeedbackType;", TypedValues.AttributesType.S_FRAME, "Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "lightLevel", "", "(Lcom/yoti/mobile/android/facecapture/view/capture/model/ScanFeedbackType;Lcom/yoti/mobile/android/commons/image/ImageBuffer;F)V", "getError", "()Lcom/yoti/mobile/android/facecapture/view/capture/model/ScanFeedbackType;", "getFrame", "()Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "getLightLevel", "()F", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class OnInvalidFrame extends Event {
        private final ScanFeedbackType error;
        private final ImageBuffer frame;
        private final float lightLevel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnInvalidFrame(ScanFeedbackType error, ImageBuffer frame, float f) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(frame, "frame");
            this.error = error;
            this.frame = frame;
            this.lightLevel = f;
        }

        public static /* synthetic */ OnInvalidFrame copy$default(OnInvalidFrame onInvalidFrame, ScanFeedbackType scanFeedbackType, ImageBuffer imageBuffer, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                scanFeedbackType = onInvalidFrame.error;
            }
            if ((i & 2) != 0) {
                imageBuffer = onInvalidFrame.frame;
            }
            if ((i & 4) != 0) {
                f = onInvalidFrame.lightLevel;
            }
            return onInvalidFrame.copy(scanFeedbackType, imageBuffer, f);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ScanFeedbackType getError() {
            return this.error;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ImageBuffer getFrame() {
            return this.frame;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final float getLightLevel() {
            return this.lightLevel;
        }

        public final OnInvalidFrame copy(ScanFeedbackType error, ImageBuffer frame, float lightLevel) {
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(frame, "frame");
            return new OnInvalidFrame(error, frame, lightLevel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnInvalidFrame)) {
                return false;
            }
            OnInvalidFrame onInvalidFrame = (OnInvalidFrame) other;
            return this.error == onInvalidFrame.error && Intrinsics.areEqual(this.frame, onInvalidFrame.frame) && Intrinsics.areEqual((Object) Float.valueOf(this.lightLevel), (Object) Float.valueOf(onInvalidFrame.lightLevel));
        }

        public final ScanFeedbackType getError() {
            return this.error;
        }

        public final ImageBuffer getFrame() {
            return this.frame;
        }

        public final float getLightLevel() {
            return this.lightLevel;
        }

        public int hashCode() {
            return (((this.error.hashCode() * 31) + this.frame.hashCode()) * 31) + Float.hashCode(this.lightLevel);
        }

        public String toString() {
            return "OnInvalidFrame(error=" + this.error + ", frame=" + this.frame + ", lightLevel=" + this.lightLevel + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/Event$OnLifecycleStart;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/Event;", "()V", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class OnLifecycleStart extends Event {
        public static final OnLifecycleStart INSTANCE = new OnLifecycleStart();

        private OnLifecycleStart() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/Event$OnLifecycleStop;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/Event;", "()V", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class OnLifecycleStop extends Event {
        public static final OnLifecycleStop INSTANCE = new OnLifecycleStop();

        private OnLifecycleStop() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/Event$OnTimeout;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/Event;", "()V", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class OnTimeout extends Event {
        public static final OnTimeout INSTANCE = new OnTimeout();

        private OnTimeout() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/Event$OnValidFrame;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/Event;", "jpegData", "", TypedValues.AttributesType.S_FRAME, "Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "lightLevel", "", "([BLcom/yoti/mobile/android/commons/image/ImageBuffer;F)V", "getFrame", "()Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "getJpegData", "()[B", "getLightLevel", "()F", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class OnValidFrame extends Event {
        private final ImageBuffer frame;
        private final byte[] jpegData;
        private final float lightLevel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnValidFrame(byte[] jpegData, ImageBuffer frame, float f) {
            super(null);
            Intrinsics.checkNotNullParameter(jpegData, "jpegData");
            Intrinsics.checkNotNullParameter(frame, "frame");
            this.jpegData = jpegData;
            this.frame = frame;
            this.lightLevel = f;
        }

        public static /* synthetic */ OnValidFrame copy$default(OnValidFrame onValidFrame, byte[] bArr, ImageBuffer imageBuffer, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                bArr = onValidFrame.jpegData;
            }
            if ((i & 2) != 0) {
                imageBuffer = onValidFrame.frame;
            }
            if ((i & 4) != 0) {
                f = onValidFrame.lightLevel;
            }
            return onValidFrame.copy(bArr, imageBuffer, f);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final byte[] getJpegData() {
            return this.jpegData;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ImageBuffer getFrame() {
            return this.frame;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final float getLightLevel() {
            return this.lightLevel;
        }

        public final OnValidFrame copy(byte[] jpegData, ImageBuffer frame, float lightLevel) {
            Intrinsics.checkNotNullParameter(jpegData, "jpegData");
            Intrinsics.checkNotNullParameter(frame, "frame");
            return new OnValidFrame(jpegData, frame, lightLevel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnValidFrame)) {
                return false;
            }
            OnValidFrame onValidFrame = (OnValidFrame) other;
            return Intrinsics.areEqual(this.jpegData, onValidFrame.jpegData) && Intrinsics.areEqual(this.frame, onValidFrame.frame) && Intrinsics.areEqual((Object) Float.valueOf(this.lightLevel), (Object) Float.valueOf(onValidFrame.lightLevel));
        }

        public final ImageBuffer getFrame() {
            return this.frame;
        }

        public final byte[] getJpegData() {
            return this.jpegData;
        }

        public final float getLightLevel() {
            return this.lightLevel;
        }

        public int hashCode() {
            return (((Arrays.hashCode(this.jpegData) * 31) + this.frame.hashCode()) * 31) + Float.hashCode(this.lightLevel);
        }

        public String toString() {
            return "OnValidFrame(jpegData=" + Arrays.toString(this.jpegData) + ", frame=" + this.frame + ", lightLevel=" + this.lightLevel + ')';
        }
    }

    private Event() {
    }

    public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
