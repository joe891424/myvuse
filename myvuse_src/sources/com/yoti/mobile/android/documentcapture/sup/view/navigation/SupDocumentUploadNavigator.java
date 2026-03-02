package com.yoti.mobile.android.documentcapture.sup.view.navigation;

import androidx.navigation.NavController;
import com.yoti.mobile.android.commonui.GenericMessageFragmentArgs;
import com.yoti.mobile.android.commonui.extension.NavigationKt;
import com.yoti.mobile.android.documentcapture.sup.C4653R;
import com.yoti.mobile.android.documentcapture.sup.view.scan.SupplementaryDocumentViewData;
import com.yoti.mobile.android.documentcapture.sup.view.upload.UnprocessableMedia;
import com.yoti.mobile.android.documentcapture.view.navigation.IUploadNavigator;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailureType;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/navigation/SupDocumentUploadNavigator;", "Lcom/yoti/mobile/android/documentcapture/view/navigation/IUploadNavigator;", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupplementaryDocumentViewData;", "navController", "Landroidx/navigation/NavController;", "documentCaptureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;", "(Landroidx/navigation/NavController;Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;)V", "getDocumentCaptureConfiguration", "()Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;", "getNavController", "()Landroidx/navigation/NavController;", "navigateBackToScan", "", "navigateToUnprocessableMediaFailure", "failure", "Lcom/yoti/mobile/android/documentcapture/sup/view/upload/UnprocessableMedia;", "navigateToUploadError", "", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "capture", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SupDocumentUploadNavigator implements IUploadNavigator<SupplementaryDocumentViewData> {
    private final DocumentCaptureConfiguration documentCaptureConfiguration;
    private final NavController navController;

    public SupDocumentUploadNavigator(NavController navController, DocumentCaptureConfiguration documentCaptureConfiguration) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(documentCaptureConfiguration, "documentCaptureConfiguration");
        this.navController = navController;
        this.documentCaptureConfiguration = documentCaptureConfiguration;
    }

    private final void navigateToUnprocessableMediaFailure(UnprocessableMedia failure) {
        NavigationKt.navigateSafe$default(getNavController(), C4653R.id.action_to_documentUploadErrorFragment, new GenericMessageFragmentArgs(failure.getF7488a(), failure.getF7489b(), null, failure.getF7490c(), null, failure.getButtonTextId(), null, failure.getButtonIcon(), 0, null, 0, null, 3924, null).toBundle(), null, null, 12, null);
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
        if (getDocumentCaptureConfiguration().getIsValidationAndGuidanceEnabled()) {
            getNavController().popBackStack(C4653R.id.documentRequirementsFragment, false);
        } else {
            getNavController().popBackStack(C4653R.id.supDocumentGuidelinesFragment, false);
        }
    }

    @Override // com.yoti.mobile.android.documentcapture.view.navigation.IUploadNavigator
    public boolean navigateToUploadError(YdsFailure failure, SupplementaryDocumentViewData capture) {
        Intrinsics.checkNotNullParameter(failure, "failure");
        Intrinsics.checkNotNullParameter(capture, "capture");
        YdsFailureType failureType = failure.getFailureType();
        UnprocessableMedia unprocessableMedia = failureType instanceof UnprocessableMedia ? (UnprocessableMedia) failureType : null;
        if (unprocessableMedia == null) {
            return IUploadNavigator.DefaultImpls.navigateToUploadError(this, failure, capture);
        }
        navigateToUnprocessableMediaFailure(unprocessableMedia);
        return true;
    }
}
