package com.yoti.mobile.android.facecapture.view.navigation;

import androidx.navigation.NavController;
import com.yoti.mobile.android.liveness.view.navigation.ILivenessUploadNavigator;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/navigation/FaceCaptureUploadNavigator;", "Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessUploadNavigator;", "navController", "Landroidx/navigation/NavController;", "(Landroidx/navigation/NavController;)V", "getNavController", "()Landroidx/navigation/NavController;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceCaptureUploadNavigator implements ILivenessUploadNavigator {
    private final NavController navController;

    public FaceCaptureUploadNavigator(NavController navController) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        this.navController = navController;
    }

    @Override // com.yoti.mobile.android.liveness.view.navigation.ILivenessUploadNavigator
    public NavController getNavController() {
        return this.navController;
    }

    @Override // com.yoti.mobile.android.liveness.view.navigation.ILivenessUploadNavigator
    public void navigateBack() {
        ILivenessUploadNavigator.DefaultImpls.navigateBack(this);
    }

    @Override // com.yoti.mobile.android.liveness.view.navigation.ILivenessUploadNavigator
    public boolean navigateToUploadError(YdsFailure ydsFailure) {
        return ILivenessUploadNavigator.DefaultImpls.navigateToUploadError(this, ydsFailure);
    }
}
