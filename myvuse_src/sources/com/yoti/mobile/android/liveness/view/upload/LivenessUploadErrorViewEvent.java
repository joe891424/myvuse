package com.yoti.mobile.android.liveness.view.upload;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorViewEvent;", "", "()V", "NavigateBack", "ScanAgain", "SeeGuidelines", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorViewEvent$ScanAgain;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorViewEvent$SeeGuidelines;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorViewEvent$NavigateBack;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class LivenessUploadErrorViewEvent {

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorViewEvent$NavigateBack;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorViewEvent;", "()V", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class NavigateBack extends LivenessUploadErrorViewEvent {
        public static final NavigateBack INSTANCE = new NavigateBack();

        private NavigateBack() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorViewEvent$ScanAgain;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorViewEvent;", "()V", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class ScanAgain extends LivenessUploadErrorViewEvent {
        public static final ScanAgain INSTANCE = new ScanAgain();

        private ScanAgain() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorViewEvent$SeeGuidelines;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorViewEvent;", "failureType", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadFailureType;", "(Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadFailureType;)V", "getFailureType", "()Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadFailureType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class SeeGuidelines extends LivenessUploadErrorViewEvent {
        private final LivenessUploadFailureType failureType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SeeGuidelines(LivenessUploadFailureType failureType) {
            super(null);
            Intrinsics.checkNotNullParameter(failureType, "failureType");
            this.failureType = failureType;
        }

        public static /* synthetic */ SeeGuidelines copy$default(SeeGuidelines seeGuidelines, LivenessUploadFailureType livenessUploadFailureType, int i, Object obj) {
            if ((i & 1) != 0) {
                livenessUploadFailureType = seeGuidelines.failureType;
            }
            return seeGuidelines.copy(livenessUploadFailureType);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final LivenessUploadFailureType getFailureType() {
            return this.failureType;
        }

        public final SeeGuidelines copy(LivenessUploadFailureType failureType) {
            Intrinsics.checkNotNullParameter(failureType, "failureType");
            return new SeeGuidelines(failureType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SeeGuidelines) && Intrinsics.areEqual(this.failureType, ((SeeGuidelines) other).failureType);
        }

        public final LivenessUploadFailureType getFailureType() {
            return this.failureType;
        }

        public int hashCode() {
            return this.failureType.hashCode();
        }

        public String toString() {
            return "SeeGuidelines(failureType=" + this.failureType + ')';
        }
    }

    private LivenessUploadErrorViewEvent() {
    }

    public /* synthetic */ LivenessUploadErrorViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
