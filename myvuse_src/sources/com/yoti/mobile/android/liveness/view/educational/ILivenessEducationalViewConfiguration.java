package com.yoti.mobile.android.liveness.view.educational;

import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.commonui.MediaResource;
import com.yoti.mobile.android.liveness.C4871R;
import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00078WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\tR\u0014\u0010\u0017\u001a\u00020\u00078WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\tR\u0014\u0010\u0019\u001a\u00020\u00078WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\t¨\u0006\u001b"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/educational/ILivenessEducationalViewConfiguration;", "", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;", "getFeatureConfiguration", "()Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;", "guidelinesTitle", "", "getGuidelinesTitle", "()I", "isGuidelinesLinkVisible", "", "()Z", "media", "Lcom/yoti/mobile/android/commonui/MediaResource;", "getMedia", "()Lcom/yoti/mobile/android/commonui/MediaResource;", "navigationIcon", "Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "getNavigationIcon", "()Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "primaryCtaText", "getPrimaryCtaText", "text", "getText", "title", "getTitle", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface ILivenessEducationalViewConfiguration {

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class DefaultImpls {
        public static int getGuidelinesTitle(ILivenessEducationalViewConfiguration iLivenessEducationalViewConfiguration) {
            return C4871R.string.yds_liveness_education_guidelines_title;
        }

        public static MediaResource getMedia(ILivenessEducationalViewConfiguration iLivenessEducationalViewConfiguration) {
            return null;
        }

        public static NavigationIcon getNavigationIcon(ILivenessEducationalViewConfiguration iLivenessEducationalViewConfiguration) {
            return (iLivenessEducationalViewConfiguration.getFeatureConfiguration().isSingleStepFlow() || iLivenessEducationalViewConfiguration.getFeatureConfiguration().getRequireBiometricConsent()) ? NavigationIcon.BACK_BLUE : NavigationIcon.CLOSE_BLUE;
        }

        public static int getPrimaryCtaText(ILivenessEducationalViewConfiguration iLivenessEducationalViewConfiguration) {
            return C4871R.string.yds_liveness_education_primary_cta;
        }

        public static int getText(ILivenessEducationalViewConfiguration iLivenessEducationalViewConfiguration) {
            return C4871R.string.yds_liveness_education_description;
        }

        public static int getTitle(ILivenessEducationalViewConfiguration iLivenessEducationalViewConfiguration) {
            return C4871R.string.yds_liveness_education_header;
        }

        public static boolean isGuidelinesLinkVisible(ILivenessEducationalViewConfiguration iLivenessEducationalViewConfiguration) {
            return true;
        }
    }

    LivenessFeatureConfiguration getFeatureConfiguration();

    int getGuidelinesTitle();

    MediaResource getMedia();

    NavigationIcon getNavigationIcon();

    int getPrimaryCtaText();

    int getText();

    int getTitle();

    boolean isGuidelinesLinkVisible();
}
