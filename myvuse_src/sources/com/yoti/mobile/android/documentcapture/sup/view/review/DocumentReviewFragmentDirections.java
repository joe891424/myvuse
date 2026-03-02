package com.yoti.mobile.android.documentcapture.sup.view.review;

import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.yoti.mobile.android.documentcapture.sup.C4653R;
import com.yoti.mobile.android.documentcapture.sup.IdDocumentCaptureNavGraphDirections;
import com.yoti.mobile.android.documentcapture.sup.view.scan.SupplementaryDocumentViewData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewFragmentDirections;", "", "()V", "Companion", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentReviewFragmentDirections {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0004¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewFragmentDirections$Companion;", "", "()V", "actionGlobalToGuidelines", "Landroidx/navigation/NavDirections;", "actionGlobalToReview", "captureViewData", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupplementaryDocumentViewData;", "actionReviewToFileOpenError", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NavDirections actionGlobalToGuidelines() {
            return IdDocumentCaptureNavGraphDirections.INSTANCE.actionGlobalToGuidelines();
        }

        public final NavDirections actionGlobalToReview(SupplementaryDocumentViewData captureViewData) {
            Intrinsics.checkNotNullParameter(captureViewData, "captureViewData");
            return IdDocumentCaptureNavGraphDirections.INSTANCE.actionGlobalToReview(captureViewData);
        }

        public final NavDirections actionReviewToFileOpenError() {
            return new ActionOnlyNavDirections(C4653R.id.action_review_to_file_open_error);
        }
    }

    private DocumentReviewFragmentDirections() {
    }
}
