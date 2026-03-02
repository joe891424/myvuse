package com.yoti.mobile.android.liveness.view.upload;

import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorNavigationEvent;", "", "()V", "CancelFlow", "NavigateBackToLivenessEducational", "NavigateToGuidelines", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorNavigationEvent$NavigateBackToLivenessEducational;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorNavigationEvent$NavigateToGuidelines;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorNavigationEvent$CancelFlow;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class LivenessUploadErrorNavigationEvent {

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorNavigationEvent$CancelFlow;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorNavigationEvent;", "()V", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class CancelFlow extends LivenessUploadErrorNavigationEvent {
        public static final CancelFlow INSTANCE = new CancelFlow();

        private CancelFlow() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorNavigationEvent$NavigateBackToLivenessEducational;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorNavigationEvent;", "()V", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class NavigateBackToLivenessEducational extends LivenessUploadErrorNavigationEvent {
        public static final NavigateBackToLivenessEducational INSTANCE = new NavigateBackToLivenessEducational();

        private NavigateBackToLivenessEducational() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorNavigationEvent$NavigateToGuidelines;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorNavigationEvent;", "guidelinesViewData", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData;", "(Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData;)V", "getGuidelinesViewData", "()Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class NavigateToGuidelines extends LivenessUploadErrorNavigationEvent {
        private final LivenessGuidelinesViewData guidelinesViewData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavigateToGuidelines(LivenessGuidelinesViewData guidelinesViewData) {
            super(null);
            Intrinsics.checkNotNullParameter(guidelinesViewData, "guidelinesViewData");
            this.guidelinesViewData = guidelinesViewData;
        }

        public static /* synthetic */ NavigateToGuidelines copy$default(NavigateToGuidelines navigateToGuidelines, LivenessGuidelinesViewData livenessGuidelinesViewData, int i, Object obj) {
            if ((i & 1) != 0) {
                livenessGuidelinesViewData = navigateToGuidelines.guidelinesViewData;
            }
            return navigateToGuidelines.copy(livenessGuidelinesViewData);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final LivenessGuidelinesViewData getGuidelinesViewData() {
            return this.guidelinesViewData;
        }

        public final NavigateToGuidelines copy(LivenessGuidelinesViewData guidelinesViewData) {
            Intrinsics.checkNotNullParameter(guidelinesViewData, "guidelinesViewData");
            return new NavigateToGuidelines(guidelinesViewData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NavigateToGuidelines) && Intrinsics.areEqual(this.guidelinesViewData, ((NavigateToGuidelines) other).guidelinesViewData);
        }

        public final LivenessGuidelinesViewData getGuidelinesViewData() {
            return this.guidelinesViewData;
        }

        public int hashCode() {
            return this.guidelinesViewData.hashCode();
        }

        public String toString() {
            return "NavigateToGuidelines(guidelinesViewData=" + this.guidelinesViewData + ')';
        }
    }

    private LivenessUploadErrorNavigationEvent() {
    }

    public /* synthetic */ LivenessUploadErrorNavigationEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
