package com.yoti.mobile.android.liveness.zoom.view.navigation;

import androidx.navigation.NavController;
import com.yoti.mobile.android.commons.util.C4588L;
import com.yoti.mobile.android.commonui.C4590R;
import com.yoti.mobile.android.commonui.GenericMessageFragmentArgs;
import com.yoti.mobile.android.commonui.extension.NavigationKt;
import com.yoti.mobile.android.commonui.moreabout.MoreAboutFragmentArgs;
import com.yoti.mobile.android.commonui.moreabout.MoreAboutFragmentContent;
import com.yoti.mobile.android.commonui.moreabout.MoreAboutItem;
import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData;
import com.yoti.mobile.android.liveness.view.navigation.ILivenessEducationalNavigator;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFailureType;
import com.yoti.mobile.android.liveness.zoom.C4888R;
import com.yoti.mobile.android.liveness.zoom.domain.model.LivenessFaceTecResourceEntity;
import com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecInitializationCallback;
import com.yoti.mobile.android.liveness.zoom.view.capture.IFaceTecInitializer;
import com.yoti.mobile.android.liveness.zoom.view.capture.LivenessFaceTecCaptureFragmentArgs;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailureType;
import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/navigation/LivenessFaceTecEducationalNavigator;", "Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessEducationalNavigator;", "Lcom/yoti/mobile/android/liveness/zoom/domain/model/LivenessFaceTecResourceEntity;", "navController", "Landroidx/navigation/NavController;", "guidelinesViewDataFactory", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData$Factory;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadFailureType;", "faceTecInitializer", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/IFaceTecInitializer;", "(Landroidx/navigation/NavController;Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData$Factory;Lcom/yoti/mobile/android/liveness/zoom/view/capture/IFaceTecInitializer;)V", "getGuidelinesViewDataFactory", "()Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData$Factory;", "getNavController", "()Landroidx/navigation/NavController;", "createMoreAboutContent", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutFragmentArgs;", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;", "navigateToLivenessCapture", "", "resource", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class LivenessFaceTecEducationalNavigator implements ILivenessEducationalNavigator<LivenessFaceTecResourceEntity> {
    private final IFaceTecInitializer faceTecInitializer;
    private final LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> guidelinesViewDataFactory;
    private final NavController navController;

    /* JADX WARN: Multi-variable type inference failed */
    public LivenessFaceTecEducationalNavigator(NavController navController, LivenessGuidelinesViewData.Factory<? super LivenessUploadFailureType> guidelinesViewDataFactory, IFaceTecInitializer faceTecInitializer) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(guidelinesViewDataFactory, "guidelinesViewDataFactory");
        Intrinsics.checkNotNullParameter(faceTecInitializer, "faceTecInitializer");
        this.navController = navController;
        this.guidelinesViewDataFactory = guidelinesViewDataFactory;
        this.faceTecInitializer = faceTecInitializer;
    }

    @Override // com.yoti.mobile.android.liveness.view.navigation.ILivenessEducationalNavigator
    public MoreAboutFragmentArgs createMoreAboutContent(LivenessFeatureConfiguration featureConfiguration) {
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        MoreAboutItem.MoreAboutTitleItem moreAboutTitleItem = new MoreAboutItem.MoreAboutTitleItem(C4888R.string.yds_verification_info_header);
        List listListOf = CollectionsKt.listOf(new MoreAboutItem.MoreAboutDescItem(C4888R.string.yds_liveness_verification_info_description));
        List listListOf2 = CollectionsKt.listOf((Object[]) new MoreAboutItem.MoreAboutAccordionItem[]{new MoreAboutItem.MoreAboutAccordionItem(C4888R.string.yds_liveness_verification_info_scan_usage_header, C4888R.string.yds_liveness_verification_info_scan_usage_description), new MoreAboutItem.MoreAboutAccordionItem(C4888R.string.yds_liveness_verification_info_prove_identity_header, C4888R.string.yds_liveness_verification_info_prove_identity_description), new MoreAboutItem.MoreAboutAccordionItem(C4888R.string.yds_liveness_verification_info_privacy_header, C4888R.string.yds_liveness_verification_info_privacy_description), new MoreAboutItem.MoreAboutAccordionItem(C4888R.string.yds_liveness_verification_info_support_header, C4888R.string.yds_liveness_verification_info_support_description), new MoreAboutItem.MoreAboutAccordionItem(C4888R.string.yds_verification_info_yoti_header, C4888R.string.yds_liveness_verification_info_yoti_description), new MoreAboutItem.MoreAboutAccordionItem(C4888R.string.yds_verification_info_security_header, C4888R.string.yds_verification_info_security_description)});
        Integer logo = featureConfiguration.getUiSessionConfiguration().getLogo();
        return new MoreAboutFragmentArgs(new MoreAboutFragmentContent(moreAboutTitleItem, listListOf, listListOf2, logo != null ? new MoreAboutItem.MoreAboutLogoItem(logo.intValue()) : null, 0, null, 48, null));
    }

    @Override // com.yoti.mobile.android.liveness.view.navigation.ILivenessEducationalNavigator
    public LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> getGuidelinesViewDataFactory() {
        return this.guidelinesViewDataFactory;
    }

    @Override // com.yoti.mobile.android.liveness.view.navigation.ILivenessEducationalNavigator
    public NavController getNavController() {
        return this.navController;
    }

    @Override // com.yoti.mobile.android.liveness.view.navigation.ILivenessEducationalNavigator
    public void navigateToGuidelines() {
        ILivenessEducationalNavigator.DefaultImpls.navigateToGuidelines(this);
    }

    @Override // com.yoti.mobile.android.liveness.view.navigation.ILivenessEducationalNavigator
    public void navigateToLivenessCapture(final LivenessFaceTecResourceEntity resource) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        this.faceTecInitializer.initialize(resource.getLicense(), new FaceTecInitializationCallback() { // from class: com.yoti.mobile.android.liveness.zoom.view.navigation.LivenessFaceTecEducationalNavigator.navigateToLivenessCapture.1
            @Override // com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecInitializationCallback
            public void onError(YdsFailure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                YdsFailureType failureType = failure.getFailureType();
                LivenessFaceTecEducationalNavigator livenessFaceTecEducationalNavigator = LivenessFaceTecEducationalNavigator.this;
                C4588L.logError("LivenessFaceTecEducationalNavigator", "Error initialising FaceTec, cause: " + failure, failure.getCause());
                NavigationKt.navigateSafeToNavGraph(livenessFaceTecEducationalNavigator.getNavController(), C4888R.navigation.yds_dead_end_nav_graph, new GenericMessageFragmentArgs(failureType.getF7488a(), failureType.getF7489b(), null, failureType.getF7490c(), null, C4590R.string.yds_common_exit, null, 0, 0, null, 0, null, 4052, null).toBundle());
            }

            @Override // com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecInitializationCallback
            public void onSuccess() {
                NavigationKt.navigateSafe$default(LivenessFaceTecEducationalNavigator.this.getNavController(), C4888R.id.action_global_to_liveness_facetec_capture, new LivenessFaceTecCaptureFragmentArgs(resource.getResourceId()).toBundle(), null, null, 12, null);
            }
        });
    }

    @Override // com.yoti.mobile.android.liveness.view.navigation.ILivenessEducationalNavigator
    public void navigateToMoreAbout(LivenessFeatureConfiguration livenessFeatureConfiguration) {
        ILivenessEducationalNavigator.DefaultImpls.navigateToMoreAbout(this, livenessFeatureConfiguration);
    }
}
