package com.yoti.mobile.android.facecapture.view.navigation;

import androidx.navigation.NavController;
import com.yoti.mobile.android.facecapture.domain.model.FaceCaptureResourceEntity;
import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData;
import com.yoti.mobile.android.liveness.view.navigation.ILivenessEducationalNavigatorProvider;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFailureType;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001a\b\u0007\u0012\u0011\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0019\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/navigation/FaceCaptureEducationalNavigatorProvider;", "Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessEducationalNavigatorProvider;", "Lcom/yoti/mobile/android/facecapture/domain/model/FaceCaptureResourceEntity;", "guidelinesViewDataFactory", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData$Factory;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadFailureType;", "Lkotlin/jvm/JvmSuppressWildcards;", "(Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData$Factory;)V", "getNavigator", "Lcom/yoti/mobile/android/facecapture/view/navigation/FaceCaptureEducationalNavigator;", "navController", "Landroidx/navigation/NavController;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceCaptureEducationalNavigatorProvider implements ILivenessEducationalNavigatorProvider<FaceCaptureResourceEntity> {
    private final LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> guidelinesViewDataFactory;

    @Inject
    public FaceCaptureEducationalNavigatorProvider(LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> guidelinesViewDataFactory) {
        Intrinsics.checkNotNullParameter(guidelinesViewDataFactory, "guidelinesViewDataFactory");
        this.guidelinesViewDataFactory = guidelinesViewDataFactory;
    }

    @Override // com.yoti.mobile.android.liveness.view.navigation.ILivenessEducationalNavigatorProvider
    public FaceCaptureEducationalNavigator getNavigator(NavController navController) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        return new FaceCaptureEducationalNavigator(navController, this.guidelinesViewDataFactory);
    }
}
