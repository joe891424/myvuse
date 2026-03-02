package com.yoti.mobile.android.documentcapture.p055id.view.upload;

import androidx.navigation.NavDirections;
import com.yoti.mobile.android.documentcapture.p055id.IdDocumentCaptureNavGraphDirections;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanResultViewData;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.IdScanConfigurationViewData;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.TextExtractionUploadFailureType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/DocumentTextExtractionErrorFragmentDirections;", "", "()V", "Companion", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentTextExtractionErrorFragmentDirections {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/DocumentTextExtractionErrorFragmentDirections$Companion;", "", "()V", "actionGlobalToDocumentTextExtractionError", "Landroidx/navigation/NavDirections;", "documentTextExtractionError", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError;", "documentScanResultViewData", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "actionGlobalToScan", "idScanConfigurationViewData", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
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
    }

    private DocumentTextExtractionErrorFragmentDirections() {
    }
}
