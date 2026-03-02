package com.yoti.mobile.android.documentcapture.p055id.view.navigation;

import android.os.Bundle;
import androidx.navigation.NavController;
import com.yoti.mobile.android.commonui.GenericMessageFragmentArgs;
import com.yoti.mobile.android.commonui.extension.NavigationKt;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanResultViewData;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.DocumentTextExtractionErrorFragmentArgs;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.TextExtractionUploadFailureType;
import com.yoti.mobile.android.documentcapture.view.navigation.IUploadNavigator;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailureType;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\rH\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/navigation/IdDocumentUploadNavigator;", "Lcom/yoti/mobile/android/documentcapture/view/navigation/IUploadNavigator;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "navController", "Landroidx/navigation/NavController;", "documentCaptureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;", "(Landroidx/navigation/NavController;Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;)V", "getDocumentCaptureConfiguration", "()Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;", "getNavController", "()Landroidx/navigation/NavController;", "handleDocumentTextExtractionError", "", "failure", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError;", "capture", "handleIdentifiedTextExtractionError", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType;", "navigateBackToScan", "navigateToTextExtractionUploadFailure", "navigateToUploadError", "", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class IdDocumentUploadNavigator implements IUploadNavigator<DocumentScanResultViewData> {
    private final DocumentCaptureConfiguration documentCaptureConfiguration;
    private final NavController navController;

    public IdDocumentUploadNavigator(NavController navController, DocumentCaptureConfiguration documentCaptureConfiguration) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(documentCaptureConfiguration, "documentCaptureConfiguration");
        this.navController = navController;
        this.documentCaptureConfiguration = documentCaptureConfiguration;
    }

    private final void handleDocumentTextExtractionError(TextExtractionUploadFailureType.DocumentTextExtractionError failure, DocumentScanResultViewData capture) {
        NavigationKt.navigateSafe$default(getNavController(), C4608R.id.action_global_to_document_text_extraction_error, new DocumentTextExtractionErrorFragmentArgs(failure, capture).toBundle(), null, null, 12, null);
    }

    private final void handleIdentifiedTextExtractionError(TextExtractionUploadFailureType failure) {
        Bundle bundle = new GenericMessageFragmentArgs(failure.getF7488a(), failure.getF7489b(), null, failure.getF7490c(), null, failure.getButtonTextId(), null, failure.getButtonIcon(), 0, null, 0, null, 3924, null).toBundle();
        if (failure instanceof TextExtractionUploadFailureType.NoMoreAttempts) {
            NavigationKt.navigateSafeToNavGraph(getNavController(), C4608R.navigation.yds_dead_end_nav_graph, bundle);
        } else {
            NavigationKt.navigateSafe$default(getNavController(), C4608R.id.action_to_documentUploadErrorFragment, bundle, null, null, 12, null);
        }
    }

    private final void navigateToTextExtractionUploadFailure(TextExtractionUploadFailureType failure, DocumentScanResultViewData capture) {
        if (failure instanceof TextExtractionUploadFailureType.DocumentTextExtractionError) {
            handleDocumentTextExtractionError((TextExtractionUploadFailureType.DocumentTextExtractionError) failure, capture);
        } else {
            handleIdentifiedTextExtractionError(failure);
        }
    }

    @Override // com.yoti.mobile.android.documentcapture.view.navigation.IUploadNavigator
    public DocumentCaptureConfiguration getDocumentCaptureConfiguration() {
        return this.documentCaptureConfiguration;
    }

    @Override // com.yoti.mobile.android.documentcapture.view.navigation.IUploadNavigator
    public NavController getNavController() {
        return this.navController;
    }

    @Override // com.yoti.mobile.android.documentcapture.view.navigation.IUploadNavigator
    public void navigateBackToFirstScreen() {
        IUploadNavigator.DefaultImpls.navigateBackToFirstScreen(this);
    }

    @Override // com.yoti.mobile.android.documentcapture.view.navigation.IUploadNavigator
    public void navigateBackToScan() {
        getNavController().popBackStack(C4608R.id.id_nav_scan_fragment, false);
    }

    @Override // com.yoti.mobile.android.documentcapture.view.navigation.IUploadNavigator
    public boolean navigateToUploadError(YdsFailure failure, DocumentScanResultViewData capture) {
        Intrinsics.checkNotNullParameter(failure, "failure");
        Intrinsics.checkNotNullParameter(capture, "capture");
        YdsFailureType failureType = failure.getFailureType();
        TextExtractionUploadFailureType textExtractionUploadFailureType = failureType instanceof TextExtractionUploadFailureType ? (TextExtractionUploadFailureType) failureType : null;
        if (textExtractionUploadFailureType == null) {
            return IUploadNavigator.DefaultImpls.navigateToUploadError(this, failure, capture);
        }
        navigateToTextExtractionUploadFailure(textExtractionUploadFailureType, capture);
        return true;
    }
}
