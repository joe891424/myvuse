package com.yoti.mobile.android.liveness.view.navigation;

import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import com.yoti.mobile.android.commonui.GenericMessageFragmentArgs;
import com.yoti.mobile.android.commonui.extension.NavigationKt;
import com.yoti.mobile.android.liveness.C4871R;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFailureType;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessUploadNavigator;", "", "navController", "Landroidx/navigation/NavController;", "getNavController", "()Landroidx/navigation/NavController;", "navigateBack", "", "navigateToLivenessValidationFailure", "failureType", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadFailureType;", "navigateToUploadError", "", "failure", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface ILivenessUploadNavigator {

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class DefaultImpls {
        public static void navigateBack(ILivenessUploadNavigator iLivenessUploadNavigator) {
            NavBackStackEntry backStackEntry = iLivenessUploadNavigator.getNavController().getBackStackEntry(C4871R.id.livenessEducationalFragment);
            Intrinsics.checkNotNullExpressionValue(backStackEntry, "navController.getBackSta…enessEducationalFragment)");
            iLivenessUploadNavigator.getNavController().popBackStack(backStackEntry.getDestination().getId(), false);
        }

        private static void navigateToLivenessValidationFailure(ILivenessUploadNavigator iLivenessUploadNavigator, LivenessUploadFailureType livenessUploadFailureType) {
            NavigationKt.navigateSafe$default(iLivenessUploadNavigator.getNavController(), C4871R.id.action_to_livenessUploadValidationError, new GenericMessageFragmentArgs(livenessUploadFailureType.getF7488a(), livenessUploadFailureType.getF7489b(), null, livenessUploadFailureType.getF7490c(), null, C4871R.string.ios_android_yds_liveness_retry_primary_cta, null, C4871R.drawable.yds_ico_retry, livenessUploadFailureType.getSecondaryActionButtonText(), null, livenessUploadFailureType.getSecondaryActionButtonIcon(), livenessUploadFailureType, 596, null).toBundle(), null, null, 12, null);
        }

        public static boolean navigateToUploadError(ILivenessUploadNavigator iLivenessUploadNavigator, YdsFailure failure) {
            Intrinsics.checkNotNullParameter(failure, "failure");
            if (!(failure.getFailureType() instanceof LivenessUploadFailureType)) {
                return false;
            }
            navigateToLivenessValidationFailure(iLivenessUploadNavigator, (LivenessUploadFailureType) failure.getFailureType());
            return true;
        }
    }

    NavController getNavController();

    void navigateBack();

    boolean navigateToUploadError(YdsFailure failure);
}
