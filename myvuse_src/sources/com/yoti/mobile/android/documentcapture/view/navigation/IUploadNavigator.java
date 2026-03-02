package com.yoti.mobile.android.documentcapture.view.navigation;

import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.NavController;
import com.yoti.mobile.android.documentcapture.C4597R;
import com.yoti.mobile.android.documentcapture.view.upload.IDocumentViewData;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH&J\u001d\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/navigation/IUploadNavigator;", ExifInterface.LONGITUDE_EAST, "Lcom/yoti/mobile/android/documentcapture/view/upload/IDocumentViewData;", "", "documentCaptureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;", "getDocumentCaptureConfiguration", "()Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;", "navController", "Landroidx/navigation/NavController;", "getNavController", "()Landroidx/navigation/NavController;", "navigateBackToFirstScreen", "", "navigateBackToScan", "navigateToUploadError", "", "failure", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "capture", "(Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;Lcom/yoti/mobile/android/documentcapture/view/upload/IDocumentViewData;)Z", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface IUploadNavigator<E extends IDocumentViewData> {

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class DefaultImpls {
        public static <E extends IDocumentViewData> void navigateBackToFirstScreen(IUploadNavigator<E> iUploadNavigator) {
            iUploadNavigator.getNavController().popBackStack(iUploadNavigator.getNavController().getBackStackEntry(iUploadNavigator.getDocumentCaptureConfiguration().getIsSelectableDocumentFlow() ? C4597R.id.documentSelectionFragment : iUploadNavigator.getDocumentCaptureConfiguration().getIsValidationAndGuidanceEnabled() ? C4597R.id.documentRequirementsFragment : C4597R.id.documentEducationalFragment).getDestination().getId(), false);
        }

        public static <E extends IDocumentViewData> boolean navigateToUploadError(IUploadNavigator<E> iUploadNavigator, YdsFailure failure, E capture) {
            Intrinsics.checkNotNullParameter(failure, "failure");
            Intrinsics.checkNotNullParameter(capture, "capture");
            return false;
        }
    }

    DocumentCaptureConfiguration getDocumentCaptureConfiguration();

    NavController getNavController();

    void navigateBackToFirstScreen();

    void navigateBackToScan();

    boolean navigateToUploadError(YdsFailure failure, E capture);
}
