package com.yoti.mobile.android.facecapture.view.navigation;

import androidx.navigation.NavController;
import com.yoti.mobile.android.liveness.view.navigation.ILivenessUploadNavigator;
import com.yoti.mobile.android.liveness.view.navigation.ILivenessUploadNavigatorProvider;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/navigation/FaceCaptureUploadNavigatorProvider;", "Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessUploadNavigatorProvider;", "()V", "getNavigator", "Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessUploadNavigator;", "navController", "Landroidx/navigation/NavController;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceCaptureUploadNavigatorProvider implements ILivenessUploadNavigatorProvider {
    @Inject
    public FaceCaptureUploadNavigatorProvider() {
    }

    @Override // com.yoti.mobile.android.liveness.view.navigation.ILivenessUploadNavigatorProvider
    public ILivenessUploadNavigator getNavigator(NavController navController) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        return new FaceCaptureUploadNavigator(navController);
    }
}
