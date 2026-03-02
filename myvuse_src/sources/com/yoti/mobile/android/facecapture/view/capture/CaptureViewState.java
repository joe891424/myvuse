package com.yoti.mobile.android.facecapture.view.capture;

import com.yoti.mobile.android.facecapture.view.capture.model.ScanFeedback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/CaptureViewState;", "", "()V", "CaptureInProgress", "CaptureSuccess", "Lcom/yoti/mobile/android/facecapture/view/capture/CaptureViewState$CaptureInProgress;", "Lcom/yoti/mobile/android/facecapture/view/capture/CaptureViewState$CaptureSuccess;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class CaptureViewState {

    @Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\n¨\u0006\u0016"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/CaptureViewState$CaptureInProgress;", "Lcom/yoti/mobile/android/facecapture/view/capture/CaptureViewState;", "isManualCapture", "", "isFlashEnabled", "feedback", "Lcom/yoti/mobile/android/facecapture/view/capture/model/ScanFeedback;", "(ZZLcom/yoti/mobile/android/facecapture/view/capture/model/ScanFeedback;)V", "getFeedback", "()Lcom/yoti/mobile/android/facecapture/view/capture/model/ScanFeedback;", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class CaptureInProgress extends CaptureViewState {
        private final ScanFeedback feedback;
        private final boolean isFlashEnabled;
        private final boolean isManualCapture;

        public /* synthetic */ CaptureInProgress(boolean z, boolean z2, ScanFeedback scanFeedback, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? false : z2, scanFeedback);
        }

        public static /* synthetic */ CaptureInProgress copy$default(CaptureInProgress captureInProgress, boolean z, boolean z2, ScanFeedback scanFeedback, int i, Object obj) {
            if ((i & 1) != 0) {
                z = captureInProgress.isManualCapture;
            }
            if ((i & 2) != 0) {
                z2 = captureInProgress.isFlashEnabled;
            }
            if ((i & 4) != 0) {
                scanFeedback = captureInProgress.feedback;
            }
            return captureInProgress.copy(z, z2, scanFeedback);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsManualCapture() {
            return this.isManualCapture;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsFlashEnabled() {
            return this.isFlashEnabled;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ScanFeedback getFeedback() {
            return this.feedback;
        }

        public final CaptureInProgress copy(boolean isManualCapture, boolean isFlashEnabled, ScanFeedback feedback) {
            Intrinsics.checkNotNullParameter(feedback, "feedback");
            return new CaptureInProgress(isManualCapture, isFlashEnabled, feedback);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CaptureInProgress)) {
                return false;
            }
            CaptureInProgress captureInProgress = (CaptureInProgress) other;
            return this.isManualCapture == captureInProgress.isManualCapture && this.isFlashEnabled == captureInProgress.isFlashEnabled && Intrinsics.areEqual(this.feedback, captureInProgress.feedback);
        }

        public final ScanFeedback getFeedback() {
            return this.feedback;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        public int hashCode() {
            boolean z = this.isManualCapture;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z2 = this.isFlashEnabled;
            return ((i + (z2 ? 1 : z2)) * 31) + this.feedback.hashCode();
        }

        public final boolean isFlashEnabled() {
            return this.isFlashEnabled;
        }

        public final boolean isManualCapture() {
            return this.isManualCapture;
        }

        public String toString() {
            return "CaptureInProgress(isManualCapture=" + this.isManualCapture + ", isFlashEnabled=" + this.isFlashEnabled + ", feedback=" + this.feedback + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CaptureInProgress(boolean z, boolean z2, ScanFeedback feedback) {
            super(null);
            Intrinsics.checkNotNullParameter(feedback, "feedback");
            this.isManualCapture = z;
            this.isFlashEnabled = z2;
            this.feedback = feedback;
        }
    }

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/CaptureViewState$CaptureSuccess;", "Lcom/yoti/mobile/android/facecapture/view/capture/CaptureViewState;", "feedback", "Lcom/yoti/mobile/android/facecapture/view/capture/model/ScanFeedback;", "(Lcom/yoti/mobile/android/facecapture/view/capture/model/ScanFeedback;)V", "getFeedback", "()Lcom/yoti/mobile/android/facecapture/view/capture/model/ScanFeedback;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class CaptureSuccess extends CaptureViewState {
        private final ScanFeedback feedback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CaptureSuccess(ScanFeedback feedback) {
            super(null);
            Intrinsics.checkNotNullParameter(feedback, "feedback");
            this.feedback = feedback;
        }

        public static /* synthetic */ CaptureSuccess copy$default(CaptureSuccess captureSuccess, ScanFeedback scanFeedback, int i, Object obj) {
            if ((i & 1) != 0) {
                scanFeedback = captureSuccess.feedback;
            }
            return captureSuccess.copy(scanFeedback);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ScanFeedback getFeedback() {
            return this.feedback;
        }

        public final CaptureSuccess copy(ScanFeedback feedback) {
            Intrinsics.checkNotNullParameter(feedback, "feedback");
            return new CaptureSuccess(feedback);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CaptureSuccess) && Intrinsics.areEqual(this.feedback, ((CaptureSuccess) other).feedback);
        }

        public final ScanFeedback getFeedback() {
            return this.feedback;
        }

        public int hashCode() {
            return this.feedback.hashCode();
        }

        public String toString() {
            return "CaptureSuccess(feedback=" + this.feedback + ')';
        }
    }

    private CaptureViewState() {
    }

    public /* synthetic */ CaptureViewState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
