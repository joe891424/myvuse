package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavDirections;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;
import com.yoti.mobile.android.documentcapture.p055id.IdDocumentCaptureNavGraphDirections;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.TextExtractionUploadFailureType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanFragmentDirections;", "", "()V", "ActionIdNavScanFragmentToVerifyYourDetailsFragment", "Companion", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentScanFragmentDirections {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanFragmentDirections$ActionIdNavScanFragmentToVerifyYourDetailsFragment;", "Landroidx/navigation/NavDirections;", "documentScanResultViewData", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "(Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;)V", "getDocumentScanResultViewData", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "component1", "copy", "equals", "", "other", "", "getActionId", "", "getArguments", "Landroid/os/Bundle;", "hashCode", "toString", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    private static final /* data */ class ActionIdNavScanFragmentToVerifyYourDetailsFragment implements NavDirections {
        private final DocumentScanResultViewData documentScanResultViewData;

        public ActionIdNavScanFragmentToVerifyYourDetailsFragment(DocumentScanResultViewData documentScanResultViewData) {
            Intrinsics.checkNotNullParameter(documentScanResultViewData, "documentScanResultViewData");
            this.documentScanResultViewData = documentScanResultViewData;
        }

        public static /* synthetic */ ActionIdNavScanFragmentToVerifyYourDetailsFragment copy$default(ActionIdNavScanFragmentToVerifyYourDetailsFragment actionIdNavScanFragmentToVerifyYourDetailsFragment, DocumentScanResultViewData documentScanResultViewData, int i, Object obj) {
            if ((i & 1) != 0) {
                documentScanResultViewData = actionIdNavScanFragmentToVerifyYourDetailsFragment.documentScanResultViewData;
            }
            return actionIdNavScanFragmentToVerifyYourDetailsFragment.copy(documentScanResultViewData);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DocumentScanResultViewData getDocumentScanResultViewData() {
            return this.documentScanResultViewData;
        }

        public final ActionIdNavScanFragmentToVerifyYourDetailsFragment copy(DocumentScanResultViewData documentScanResultViewData) {
            Intrinsics.checkNotNullParameter(documentScanResultViewData, "documentScanResultViewData");
            return new ActionIdNavScanFragmentToVerifyYourDetailsFragment(documentScanResultViewData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ActionIdNavScanFragmentToVerifyYourDetailsFragment) && Intrinsics.areEqual(this.documentScanResultViewData, ((ActionIdNavScanFragmentToVerifyYourDetailsFragment) other).documentScanResultViewData);
        }

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return C4608R.id.action_id_nav_scan_fragment_to_verifyYourDetailsFragment;
        }

        @Override // androidx.navigation.NavDirections
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            if (Parcelable.class.isAssignableFrom(DocumentScanResultViewData.class)) {
                bundle.putParcelable("documentScanResultViewData", this.documentScanResultViewData);
            } else {
                if (!Serializable.class.isAssignableFrom(DocumentScanResultViewData.class)) {
                    throw new UnsupportedOperationException(DocumentScanResultViewData.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
                }
                bundle.putSerializable("documentScanResultViewData", (Serializable) this.documentScanResultViewData);
            }
            return bundle;
        }

        public final DocumentScanResultViewData getDocumentScanResultViewData() {
            return this.documentScanResultViewData;
        }

        public int hashCode() {
            return this.documentScanResultViewData.hashCode();
        }

        public String toString() {
            return "ActionIdNavScanFragmentToVerifyYourDetailsFragment(documentScanResultViewData=" + this.documentScanResultViewData + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanFragmentDirections$Companion;", "", "()V", "actionGlobalToDocumentTextExtractionError", "Landroidx/navigation/NavDirections;", "documentTextExtractionError", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError;", "documentScanResultViewData", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "actionGlobalToScan", "idScanConfigurationViewData", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "actionIdNavScanFragmentToVerifyYourDetailsFragment", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NavDirections actionGlobalToDocumentTextExtractionError(TextExtractionUploadFailureType.DocumentTextExtractionError documentTextExtractionError, DocumentScanResultViewData documentScanResultViewData) {
            Intrinsics.checkNotNullParameter(documentTextExtractionError, "documentTextExtractionError");
            Intrinsics.checkNotNullParameter(documentScanResultViewData, "documentScanResultViewData");
            return IdDocumentCaptureNavGraphDirections.INSTANCE.actionGlobalToDocumentTextExtractionError(documentTextExtractionError, documentScanResultViewData);
        }

        public final NavDirections actionGlobalToScan(IdScanConfigurationViewData idScanConfigurationViewData) {
            Intrinsics.checkNotNullParameter(idScanConfigurationViewData, "idScanConfigurationViewData");
            return IdDocumentCaptureNavGraphDirections.INSTANCE.actionGlobalToScan(idScanConfigurationViewData);
        }

        public final NavDirections actionIdNavScanFragmentToVerifyYourDetailsFragment(DocumentScanResultViewData documentScanResultViewData) {
            Intrinsics.checkNotNullParameter(documentScanResultViewData, "documentScanResultViewData");
            return new ActionIdNavScanFragmentToVerifyYourDetailsFragment(documentScanResultViewData);
        }
    }

    private DocumentScanFragmentDirections() {
    }
}
