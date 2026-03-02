package com.yoti.mobile.android.facecapture.view.navigation;

import androidx.navigation.NavController;
import com.yoti.mobile.android.commonui.extension.NavigationKt;
import com.yoti.mobile.android.commonui.moreabout.MoreAboutFragmentArgs;
import com.yoti.mobile.android.commonui.moreabout.MoreAboutFragmentContent;
import com.yoti.mobile.android.commonui.moreabout.MoreAboutItem;
import com.yoti.mobile.android.facecapture.C4832R;
import com.yoti.mobile.android.facecapture.domain.model.FaceCaptureResourceEntity;
import com.yoti.mobile.android.facecapture.view.capture.FaceCaptureFragmentArgs;
import com.yoti.mobile.android.facecapture.view.capture.model.CaptureConfig;
import com.yoti.mobile.android.liveness.C4871R;
import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData;
import com.yoti.mobile.android.liveness.view.navigation.ILivenessEducationalNavigator;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFailureType;
import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/navigation/FaceCaptureEducationalNavigator;", "Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessEducationalNavigator;", "Lcom/yoti/mobile/android/facecapture/domain/model/FaceCaptureResourceEntity;", "navController", "Landroidx/navigation/NavController;", "guidelinesViewDataFactory", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData$Factory;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadFailureType;", "(Landroidx/navigation/NavController;Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData$Factory;)V", "getGuidelinesViewDataFactory", "()Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData$Factory;", "getNavController", "()Landroidx/navigation/NavController;", "createMoreAboutContent", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutFragmentArgs;", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;", "navigateToLivenessCapture", "", "resource", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceCaptureEducationalNavigator implements ILivenessEducationalNavigator<FaceCaptureResourceEntity> {
    private final LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> guidelinesViewDataFactory;
    private final NavController navController;

    /* JADX WARN: Multi-variable type inference failed */
    public FaceCaptureEducationalNavigator(NavController navController, LivenessGuidelinesViewData.Factory<? super LivenessUploadFailureType> guidelinesViewDataFactory) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(guidelinesViewDataFactory, "guidelinesViewDataFactory");
        this.navController = navController;
        this.guidelinesViewDataFactory = guidelinesViewDataFactory;
    }

    @Override // com.yoti.mobile.android.liveness.view.navigation.ILivenessEducationalNavigator
    public MoreAboutFragmentArgs createMoreAboutContent(LivenessFeatureConfiguration featureConfiguration) {
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        MoreAboutItem.MoreAboutTitleItem moreAboutTitleItem = new MoreAboutItem.MoreAboutTitleItem(C4871R.string.yds_facecapture_more_about_verification_header);
        List listListOf = CollectionsKt.listOf(new MoreAboutItem.MoreAboutDescItem(C4871R.string.yds_facecapture_more_about_verification_intro_decription));
        List listListOf2 = CollectionsKt.listOf((Object[]) new MoreAboutItem.MoreAboutAccordionItem[]{new MoreAboutItem.MoreAboutAccordionItem(C4871R.string.yds_facecapture_more_about_verification_title_selfie_use, C4871R.string.yds_facecapture_more_about_verification_description_selfie_use), new MoreAboutItem.MoreAboutAccordionItem(C4871R.string.yds_facecapture_more_about_verification_title_real_person, C4871R.string.yds_facecapture_more_about_verification_description_real_person), new MoreAboutItem.MoreAboutAccordionItem(C4871R.string.yds_facecapture_more_about_verification_title_what_happens, C4871R.string.yds_facecapture_more_about_verification_descriptionwhat_happens), new MoreAboutItem.MoreAboutAccordionItem(C4871R.string.yds_facecapture_more_about_verification_title_no_selfie, C4871R.string.yds_facecapture_more_about_verification_description_no_selfie), new MoreAboutItem.MoreAboutAccordionItem(C4871R.string.yds_verification_info_yoti_header, C4871R.string.yds_liveness_verification_info_yoti_description), new MoreAboutItem.MoreAboutAccordionItem(C4871R.string.yds_verification_info_security_header, C4871R.string.yds_verification_info_security_description)});
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
    public void navigateToMoreAbout(LivenessFeatureConfiguration livenessFeatureConfiguration) {
        ILivenessEducationalNavigator.DefaultImpls.navigateToMoreAbout(this, livenessFeatureConfiguration);
    }

    @Override // com.yoti.mobile.android.liveness.view.navigation.ILivenessEducationalNavigator
    public void navigateToLivenessCapture(FaceCaptureResourceEntity resource) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        NavigationKt.navigateSafe$default(getNavController(), C4832R.id.action_global_to_face_capture, new FaceCaptureFragmentArgs(new CaptureConfig(resource.getResourceId(), resource.getFrames())).toBundle(), null, null, 12, null);
    }
}
