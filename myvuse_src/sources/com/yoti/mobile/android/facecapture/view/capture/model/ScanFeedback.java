package com.yoti.mobile.android.facecapture.view.capture.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0016B\u001b\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\t\u0010\r\u001a\u00020\u0005HÆ\u0003J$\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/ScanFeedback;", "", "tooltipText", "", "frameType", "Lcom/yoti/mobile/android/facecapture/view/capture/model/ScanFeedback$FrameType;", "(Ljava/lang/Integer;Lcom/yoti/mobile/android/facecapture/view/capture/model/ScanFeedback$FrameType;)V", "getFrameType", "()Lcom/yoti/mobile/android/facecapture/view/capture/model/ScanFeedback$FrameType;", "getTooltipText", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;Lcom/yoti/mobile/android/facecapture/view/capture/model/ScanFeedback$FrameType;)Lcom/yoti/mobile/android/facecapture/view/capture/model/ScanFeedback;", "equals", "", "other", "hashCode", "toString", "", "FrameType", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class ScanFeedback {
    private final FrameType frameType;
    private final Integer tooltipText;

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/ScanFeedback$FrameType;", "", "(Ljava/lang/String;I)V", "NONE", "DEFAULT", "CAPTURE_ERROR", "VALID_FACE_DETECTED", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public enum FrameType {
        NONE,
        DEFAULT,
        CAPTURE_ERROR,
        VALID_FACE_DETECTED
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScanFeedback() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public ScanFeedback(Integer num, FrameType frameType) {
        Intrinsics.checkNotNullParameter(frameType, "frameType");
        this.tooltipText = num;
        this.frameType = frameType;
    }

    public static /* synthetic */ ScanFeedback copy$default(ScanFeedback scanFeedback, Integer num, FrameType frameType, int i, Object obj) {
        if ((i & 1) != 0) {
            num = scanFeedback.tooltipText;
        }
        if ((i & 2) != 0) {
            frameType = scanFeedback.frameType;
        }
        return scanFeedback.copy(num, frameType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getTooltipText() {
        return this.tooltipText;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FrameType getFrameType() {
        return this.frameType;
    }

    public final ScanFeedback copy(Integer tooltipText, FrameType frameType) {
        Intrinsics.checkNotNullParameter(frameType, "frameType");
        return new ScanFeedback(tooltipText, frameType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScanFeedback)) {
            return false;
        }
        ScanFeedback scanFeedback = (ScanFeedback) other;
        return Intrinsics.areEqual(this.tooltipText, scanFeedback.tooltipText) && this.frameType == scanFeedback.frameType;
    }

    public final FrameType getFrameType() {
        return this.frameType;
    }

    public final Integer getTooltipText() {
        return this.tooltipText;
    }

    public int hashCode() {
        Integer num = this.tooltipText;
        return ((num == null ? 0 : num.hashCode()) * 31) + this.frameType.hashCode();
    }

    public String toString() {
        return "ScanFeedback(tooltipText=" + this.tooltipText + ", frameType=" + this.frameType + ')';
    }

    public /* synthetic */ ScanFeedback(Integer num, FrameType frameType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? FrameType.DEFAULT : frameType);
    }
}
