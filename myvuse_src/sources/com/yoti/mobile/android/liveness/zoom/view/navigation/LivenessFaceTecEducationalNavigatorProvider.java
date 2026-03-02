package com.yoti.mobile.android.liveness.zoom.view.navigation;

import androidx.navigation.NavController;
import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData;
import com.yoti.mobile.android.liveness.view.navigation.ILivenessEducationalNavigatorProvider;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFailureType;
import com.yoti.mobile.android.liveness.zoom.domain.model.LivenessFaceTecResourceEntity;
import com.yoti.mobile.android.liveness.zoom.view.capture.IFaceTecInitializer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\"\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0011\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/navigation/LivenessFaceTecEducationalNavigatorProvider;", "Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessEducationalNavigatorProvider;", "Lcom/yoti/mobile/android/liveness/zoom/domain/model/LivenessFaceTecResourceEntity;", "faceTecInitializer", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/IFaceTecInitializer;", "guidelinesViewDataFactory", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData$Factory;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadFailureType;", "Lkotlin/jvm/JvmSuppressWildcards;", "(Lcom/yoti/mobile/android/liveness/zoom/view/capture/IFaceTecInitializer;Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData$Factory;)V", "getNavigator", "Lcom/yoti/mobile/android/liveness/zoom/view/navigation/LivenessFaceTecEducationalNavigator;", "navController", "Landroidx/navigation/NavController;", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class LivenessFaceTecEducationalNavigatorProvider implements ILivenessEducationalNavigatorProvider<LivenessFaceTecResourceEntity> {
    private final IFaceTecInitializer faceTecInitializer;
    private final LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> guidelinesViewDataFactory;

    @Inject
    public LivenessFaceTecEducationalNavigatorProvider(IFaceTecInitializer faceTecInitializer, LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> guidelinesViewDataFactory) {
        Intrinsics.checkNotNullParameter(faceTecInitializer, "faceTecInitializer");
        Intrinsics.checkNotNullParameter(guidelinesViewDataFactory, "guidelinesViewDataFactory");
        this.faceTecInitializer = faceTecInitializer;
        this.guidelinesViewDataFactory = guidelinesViewDataFactory;
    }

    @Override // com.yoti.mobile.android.liveness.view.navigation.ILivenessEducationalNavigatorProvider
    public LivenessFaceTecEducationalNavigator getNavigator(NavController navController) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        return new LivenessFaceTecEducationalNavigator(navController, this.guidelinesViewDataFactory, this.faceTecInitializer);
    }
}
