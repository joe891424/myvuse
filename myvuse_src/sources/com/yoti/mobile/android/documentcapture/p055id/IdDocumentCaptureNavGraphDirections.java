package com.yoti.mobile.android.documentcapture.p055id;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavDirections;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanResultViewData;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.IdScanConfigurationViewData;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.TextExtractionUploadFailureType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/IdDocumentCaptureNavGraphDirections;", "", "()V", "ActionGlobalToDocumentTextExtractionError", "ActionGlobalToScan", "Companion", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class IdDocumentCaptureNavGraphDirections {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/IdDocumentCaptureNavGraphDirections$ActionGlobalToDocumentTextExtractionError;", "Landroidx/navigation/NavDirections;", "documentTextExtractionError", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError;", "documentScanResultViewData", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "(Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError;Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;)V", "getDocumentScanResultViewData", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "getDocumentTextExtractionError", "()Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError;", "component1", "component2", "copy", "equals", "", "other", "", "getActionId", "", "getArguments", "Landroid/os/Bundle;", "hashCode", "toString", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    private static final /* data */ class ActionGlobalToDocumentTextExtractionError implements NavDirections {
        private final DocumentScanResultViewData documentScanResultViewData;
        private final TextExtractionUploadFailureType.DocumentTextExtractionError documentTextExtractionError;

        public ActionGlobalToDocumentTextExtractionError(TextExtractionUploadFailureType.DocumentTextExtractionError documentTextExtractionError, DocumentScanResultViewData documentScanResultViewData) {
            Intrinsics.checkNotNullParameter(documentTextExtractionError, "documentTextExtractionError");
            Intrinsics.checkNotNullParameter(documentScanResultViewData, "documentScanResultViewData");
            this.documentTextExtractionError = documentTextExtractionError;
            this.documentScanResultViewData = documentScanResultViewData;
        }

        public static /* synthetic */ ActionGlobalToDocumentTextExtractionError copy$default(ActionGlobalToDocumentTextExtractionError actionGlobalToDocumentTextExtractionError, TextExtractionUploadFailureType.DocumentTextExtractionError documentTextExtractionError, DocumentScanResultViewData documentScanResultViewData, int i, Object obj) {
            if ((i & 1) != 0) {
                documentTextExtractionError = actionGlobalToDocumentTextExtractionError.documentTextExtractionError;
            }
            if ((i & 2) != 0) {
                documentScanResultViewData = actionGlobalToDocumentTextExtractionError.documentScanResultViewData;
            }
            return actionGlobalToDocumentTextExtractionError.copy(documentTextExtractionError, documentScanResultViewData);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final TextExtractionUploadFailureType.DocumentTextExtractionError getDocumentTextExtractionError() {
            return this.documentTextExtractionError;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final DocumentScanResultViewData getDocumentScanResultViewData() {
            return this.documentScanResultViewData;
        }

        public final ActionGlobalToDocumentTextExtractionError copy(TextExtractionUploadFailureType.DocumentTextExtractionError documentTextExtractionError, DocumentScanResultViewData documentScanResultViewData) {
            Intrinsics.checkNotNullParameter(documentTextExtractionError, "documentTextExtractionError");
            Intrinsics.checkNotNullParameter(documentScanResultViewData, "documentScanResultViewData");
            return new ActionGlobalToDocumentTextExtractionError(documentTextExtractionError, documentScanResultViewData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActionGlobalToDocumentTextExtractionError)) {
                return false;
            }
            ActionGlobalToDocumentTextExtractionError actionGlobalToDocumentTextExtractionError = (ActionGlobalToDocumentTextExtractionError) other;
            return Intrinsics.areEqual(this.documentTextExtractionError, actionGlobalToDocumentTextExtractionError.documentTextExtractionError) && Intrinsics.areEqual(this.documentScanResultViewData, actionGlobalToDocumentTextExtractionError.documentScanResultViewData);
        }

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return C4608R.id.action_global_to_document_text_extraction_error;
        }

        @Override // androidx.navigation.NavDirections
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            if (Parcelable.class.isAssignableFrom(TextExtractionUploadFailureType.DocumentTextExtractionError.class)) {
                bundle.putParcelable("documentTextExtractionError", this.documentTextExtractionError);
            } else {
                if (!Serializable.class.isAssignableFrom(TextExtractionUploadFailureType.DocumentTextExtractionError.class)) {
                    throw new UnsupportedOperationException(TextExtractionUploadFailureType.DocumentTextExtractionError.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
                }
                bundle.putSerializable("documentTextExtractionError", (Serializable) this.documentTextExtractionError);
            }
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

        public final TextExtractionUploadFailureType.DocumentTextExtractionError getDocumentTextExtractionError() {
            return this.documentTextExtractionError;
        }

        public int hashCode() {
            return (this.documentTextExtractionError.hashCode() * 31) + this.documentScanResultViewData.hashCode();
        }

        public String toString() {
            return "ActionGlobalToDocumentTextExtractionError(documentTextExtractionError=" + this.documentTextExtractionError + ", documentScanResultViewData=" + this.documentScanResultViewData + ')';
        }
    }

    @Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/IdDocumentCaptureNavGraphDirections$ActionGlobalToScan;", "Landroidx/navigation/NavDirections;", "idScanConfigurationViewData", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "(Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;)V", "getIdScanConfigurationViewData", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "component1", "copy", "equals", "", "other", "", "getActionId", "", "getArguments", "Landroid/os/Bundle;", "hashCode", "toString", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    private static final /* data */ class ActionGlobalToScan implements NavDirections {
        private final IdScanConfigurationViewData idScanConfigurationViewData;

        public ActionGlobalToScan(IdScanConfigurationViewData idScanConfigurationViewData) {
            Intrinsics.checkNotNullParameter(idScanConfigurationViewData, "idScanConfigurationViewData");
            this.idScanConfigurationViewData = idScanConfigurationViewData;
        }

        public static /* synthetic */ ActionGlobalToScan copy$default(ActionGlobalToScan actionGlobalToScan, IdScanConfigurationViewData idScanConfigurationViewData, int i, Object obj) {
            if ((i & 1) != 0) {
                idScanConfigurationViewData = actionGlobalToScan.idScanConfigurationViewData;
            }
            return actionGlobalToScan.copy(idScanConfigurationViewData);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final IdScanConfigurationViewData getIdScanConfigurationViewData() {
            return this.idScanConfigurationViewData;
        }

        public final ActionGlobalToScan copy(IdScanConfigurationViewData idScanConfigurationViewData) {
            Intrinsics.checkNotNullParameter(idScanConfigurationViewData, "idScanConfigurationViewData");
            return new ActionGlobalToScan(idScanConfigurationViewData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ActionGlobalToScan) && Intrinsics.areEqual(this.idScanConfigurationViewData, ((ActionGlobalToScan) other).idScanConfigurationViewData);
        }

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return C4608R.id.action_global_to_scan;
        }

        @Override // androidx.navigation.NavDirections
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            if (Parcelable.class.isAssignableFrom(IdScanConfigurationViewData.class)) {
                bundle.putParcelable("idScanConfigurationViewData", this.idScanConfigurationViewData);
            } else {
                if (!Serializable.class.isAssignableFrom(IdScanConfigurationViewData.class)) {
                    throw new UnsupportedOperationException(IdScanConfigurationViewData.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
                }
                bundle.putSerializable("idScanConfigurationViewData", (Serializable) this.idScanConfigurationViewData);
            }
            return bundle;
        }

        public final IdScanConfigurationViewData getIdScanConfigurationViewData() {
            return this.idScanConfigurationViewData;
        }

        public int hashCode() {
            return this.idScanConfigurationViewData.hashCode();
        }

        public String toString() {
            return "ActionGlobalToScan(idScanConfigurationViewData=" + this.idScanConfigurationViewData + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/IdDocumentCaptureNavGraphDirections$Companion;", "", "()V", "actionGlobalToDocumentTextExtractionError", "Landroidx/navigation/NavDirections;", "documentTextExtractionError", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError;", "documentScanResultViewData", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "actionGlobalToScan", "idScanConfigurationViewData", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NavDirections actionGlobalToDocumentTextExtractionError(TextExtractionUploadFailureType.DocumentTextExtractionError documentTextExtractionError, DocumentScanResultViewData documentScanResultViewData) {
            Intrinsics.checkNotNullParameter(documentTextExtractionError, "documentTextExtractionError");
            Intrinsics.checkNotNullParameter(documentScanResultViewData, "documentScanResultViewData");
            return new ActionGlobalToDocumentTextExtractionError(documentTextExtractionError, documentScanResultViewData);
        }

        public final NavDirections actionGlobalToScan(IdScanConfigurationViewData idScanConfigurationViewData) {
            Intrinsics.checkNotNullParameter(idScanConfigurationViewData, "idScanConfigurationViewData");
            return new ActionGlobalToScan(idScanConfigurationViewData);
        }
    }

    private IdDocumentCaptureNavGraphDirections() {
    }
}
