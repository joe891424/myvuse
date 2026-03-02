package com.yoti.mobile.android.facecapture.view.navigation;

import com.yoti.mobile.android.facecapture.view.capture.model.CaptureResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/navigation/CaptureNavigationEvent;", "", "()V", "NavigateToCaptureReview", "NavigateToFaceCapture", "NavigateToUpload", "Lcom/yoti/mobile/android/facecapture/view/navigation/CaptureNavigationEvent$NavigateToFaceCapture;", "Lcom/yoti/mobile/android/facecapture/view/navigation/CaptureNavigationEvent$NavigateToCaptureReview;", "Lcom/yoti/mobile/android/facecapture/view/navigation/CaptureNavigationEvent$NavigateToUpload;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class CaptureNavigationEvent {

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/navigation/CaptureNavigationEvent$NavigateToCaptureReview;", "Lcom/yoti/mobile/android/facecapture/view/navigation/CaptureNavigationEvent;", "capture", "Lcom/yoti/mobile/android/facecapture/view/capture/model/CaptureResult;", "(Lcom/yoti/mobile/android/facecapture/view/capture/model/CaptureResult;)V", "getCapture", "()Lcom/yoti/mobile/android/facecapture/view/capture/model/CaptureResult;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class NavigateToCaptureReview extends CaptureNavigationEvent {
        private final CaptureResult capture;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavigateToCaptureReview(CaptureResult capture) {
            super(null);
            Intrinsics.checkNotNullParameter(capture, "capture");
            this.capture = capture;
        }

        public static /* synthetic */ NavigateToCaptureReview copy$default(NavigateToCaptureReview navigateToCaptureReview, CaptureResult captureResult, int i, Object obj) {
            if ((i & 1) != 0) {
                captureResult = navigateToCaptureReview.capture;
            }
            return navigateToCaptureReview.copy(captureResult);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CaptureResult getCapture() {
            return this.capture;
        }

        public final NavigateToCaptureReview copy(CaptureResult capture) {
            Intrinsics.checkNotNullParameter(capture, "capture");
            return new NavigateToCaptureReview(capture);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NavigateToCaptureReview) && Intrinsics.areEqual(this.capture, ((NavigateToCaptureReview) other).capture);
        }

        public final CaptureResult getCapture() {
            return this.capture;
        }

        public int hashCode() {
            return this.capture.hashCode();
        }

        public String toString() {
            return "NavigateToCaptureReview(capture=" + this.capture + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/navigation/CaptureNavigationEvent$NavigateToFaceCapture;", "Lcom/yoti/mobile/android/facecapture/view/navigation/CaptureNavigationEvent;", "()V", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class NavigateToFaceCapture extends CaptureNavigationEvent {
        public static final NavigateToFaceCapture INSTANCE = new NavigateToFaceCapture();

        private NavigateToFaceCapture() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/navigation/CaptureNavigationEvent$NavigateToUpload;", "Lcom/yoti/mobile/android/facecapture/view/navigation/CaptureNavigationEvent;", "()V", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class NavigateToUpload extends CaptureNavigationEvent {
        public static final NavigateToUpload INSTANCE = new NavigateToUpload();

        private NavigateToUpload() {
            super(null);
        }
    }

    private CaptureNavigationEvent() {
    }

    public /* synthetic */ CaptureNavigationEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
