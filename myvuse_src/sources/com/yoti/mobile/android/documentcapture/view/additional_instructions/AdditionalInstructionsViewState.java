package com.yoti.mobile.android.documentcapture.view.additional_instructions;

import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsViewState;", "", "()V", "Error", "Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsViewState$Error;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class AdditionalInstructionsViewState {

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsViewState$Error;", "Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsViewState;", "failure", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "(Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;)V", "getFailure", "()Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class Error extends AdditionalInstructionsViewState {
        private final YdsFailure failure;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(YdsFailure failure) {
            super(null);
            Intrinsics.checkNotNullParameter(failure, "failure");
            this.failure = failure;
        }

        public static /* synthetic */ Error copy$default(Error error, YdsFailure ydsFailure, int i, Object obj) {
            if ((i & 1) != 0) {
                ydsFailure = error.failure;
            }
            return error.copy(ydsFailure);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final YdsFailure getFailure() {
            return this.failure;
        }

        public final Error copy(YdsFailure failure) {
            Intrinsics.checkNotNullParameter(failure, "failure");
            return new Error(failure);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && Intrinsics.areEqual(this.failure, ((Error) other).failure);
        }

        public final YdsFailure getFailure() {
            return this.failure;
        }

        public int hashCode() {
            return this.failure.hashCode();
        }

        public String toString() {
            return "Error(failure=" + this.failure + ')';
        }
    }

    private AdditionalInstructionsViewState() {
    }

    public /* synthetic */ AdditionalInstructionsViewState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
