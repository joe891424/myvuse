package com.yoti.mobile.android.liveness.view.navigation;

import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.NavController;
import com.yoti.mobile.android.commonui.extension.NavigationKt;
import com.yoti.mobile.android.commonui.moreabout.MoreAboutFragmentArgs;
import com.yoti.mobile.android.liveness.C4871R;
import com.yoti.mobile.android.liveness.domain.model.ILivenessResourceEntity;
import com.yoti.mobile.android.liveness.view.educational.LivenessEducationalGuidelineFragmentArgs;
import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFailureType;
import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessEducationalNavigator;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/yoti/mobile/android/liveness/domain/model/ILivenessResourceEntity;", "", "guidelinesViewDataFactory", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData$Factory;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadFailureType;", "getGuidelinesViewDataFactory", "()Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData$Factory;", "navController", "Landroidx/navigation/NavController;", "getNavController", "()Landroidx/navigation/NavController;", "createMoreAboutContent", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutFragmentArgs;", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;", "navigateToGuidelines", "", "navigateToLivenessCapture", "resource", "(Lcom/yoti/mobile/android/liveness/domain/model/ILivenessResourceEntity;)V", "navigateToMoreAbout", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface ILivenessEducationalNavigator<T extends ILivenessResourceEntity> {

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class DefaultImpls {
        public static <T extends ILivenessResourceEntity> void navigateToGuidelines(ILivenessEducationalNavigator<T> iLivenessEducationalNavigator) {
            NavigationKt.navigateSafe$default(iLivenessEducationalNavigator.getNavController(), C4871R.id.action_educational_to_livenessEducationalGuidelineFragment, new LivenessEducationalGuidelineFragmentArgs(LivenessGuidelinesViewData.Factory.DefaultImpls.create$default(iLivenessEducationalNavigator.getGuidelinesViewDataFactory(), null, 1, null)).toBundle(), null, null, 12, null);
        }

        public static <T extends ILivenessResourceEntity> void navigateToMoreAbout(ILivenessEducationalNavigator<T> iLivenessEducationalNavigator, LivenessFeatureConfiguration featureConfiguration) {
            Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
            NavigationKt.navigateSafeToNavGraph(iLivenessEducationalNavigator.getNavController(), C4871R.navigation.yds_more_about_nav_graph, iLivenessEducationalNavigator.createMoreAboutContent(featureConfiguration).toBundle());
        }
    }

    MoreAboutFragmentArgs createMoreAboutContent(LivenessFeatureConfiguration featureConfiguration);

    LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> getGuidelinesViewDataFactory();

    NavController getNavController();

    void navigateToGuidelines();

    void navigateToLivenessCapture(T resource);

    void navigateToMoreAbout(LivenessFeatureConfiguration featureConfiguration);
}
