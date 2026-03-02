package com.yoti.mobile.android.documentcapture.sup;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.yoti.mobile.android.documentcapture.sup.view.scan.SupplementaryDocumentViewData;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/IdDocumentCaptureNavGraphDirections;", "", "()V", "ActionGlobalToReview", "Companion", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class IdDocumentCaptureNavGraphDirections {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/IdDocumentCaptureNavGraphDirections$ActionGlobalToReview;", "Landroidx/navigation/NavDirections;", "captureViewData", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupplementaryDocumentViewData;", "(Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupplementaryDocumentViewData;)V", "getCaptureViewData", "()Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupplementaryDocumentViewData;", "component1", "copy", "equals", "", "other", "", "getActionId", "", "getArguments", "Landroid/os/Bundle;", "hashCode", "toString", "", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    private static final /* data */ class ActionGlobalToReview implements NavDirections {
        private final SupplementaryDocumentViewData captureViewData;

        public ActionGlobalToReview(SupplementaryDocumentViewData captureViewData) {
            Intrinsics.checkNotNullParameter(captureViewData, "captureViewData");
            this.captureViewData = captureViewData;
        }

        public static /* synthetic */ ActionGlobalToReview copy$default(ActionGlobalToReview actionGlobalToReview, SupplementaryDocumentViewData supplementaryDocumentViewData, int i, Object obj) {
            if ((i & 1) != 0) {
                supplementaryDocumentViewData = actionGlobalToReview.captureViewData;
            }
            return actionGlobalToReview.copy(supplementaryDocumentViewData);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final SupplementaryDocumentViewData getCaptureViewData() {
            return this.captureViewData;
        }

        public final ActionGlobalToReview copy(SupplementaryDocumentViewData captureViewData) {
            Intrinsics.checkNotNullParameter(captureViewData, "captureViewData");
            return new ActionGlobalToReview(captureViewData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ActionGlobalToReview) && Intrinsics.areEqual(this.captureViewData, ((ActionGlobalToReview) other).captureViewData);
        }

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return C4653R.id.action_global_to_review;
        }

        @Override // androidx.navigation.NavDirections
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            if (Parcelable.class.isAssignableFrom(SupplementaryDocumentViewData.class)) {
                bundle.putParcelable("captureViewData", this.captureViewData);
            } else {
                if (!Serializable.class.isAssignableFrom(SupplementaryDocumentViewData.class)) {
                    throw new UnsupportedOperationException(SupplementaryDocumentViewData.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
                }
                bundle.putSerializable("captureViewData", (Serializable) this.captureViewData);
            }
            return bundle;
        }

        public final SupplementaryDocumentViewData getCaptureViewData() {
            return this.captureViewData;
        }

        public int hashCode() {
            return this.captureViewData.hashCode();
        }

        public String toString() {
            return "ActionGlobalToReview(captureViewData=" + this.captureViewData + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/IdDocumentCaptureNavGraphDirections$Companion;", "", "()V", "actionGlobalToGuidelines", "Landroidx/navigation/NavDirections;", "actionGlobalToReview", "captureViewData", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupplementaryDocumentViewData;", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NavDirections actionGlobalToGuidelines() {
            return new ActionOnlyNavDirections(C4653R.id.action_global_to_guidelines);
        }

        public final NavDirections actionGlobalToReview(SupplementaryDocumentViewData captureViewData) {
            Intrinsics.checkNotNullParameter(captureViewData, "captureViewData");
            return new ActionGlobalToReview(captureViewData);
        }
    }

    private IdDocumentCaptureNavGraphDirections() {
    }
}
