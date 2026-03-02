package com.yoti.mobile.android.facecapture.view.educational;

import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.commonui.MediaResource;
import com.yoti.mobile.android.facecapture.C4832R;
import com.yoti.mobile.android.liveness.view.educational.ILivenessEducationalViewConfiguration;
import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.LivenessResourceConfigEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\nR\u0014\u0010\u0014\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\n¨\u0006\u001e"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/educational/FaceCaptureEducationalViewConfiguration;", "Lcom/yoti/mobile/android/liveness/view/educational/ILivenessEducationalViewConfiguration;", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;", "(Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;)V", "getFeatureConfiguration", "()Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;", "guidelinesTitle", "", "getGuidelinesTitle", "()I", "isGuidelinesLinkVisible", "", "()Z", "media", "Lcom/yoti/mobile/android/commonui/MediaResource;", "getMedia", "()Lcom/yoti/mobile/android/commonui/MediaResource;", "primaryCtaText", "getPrimaryCtaText", "text", "getText", "component1", "copy", "equals", "other", "", "hashCode", "toString", "", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class FaceCaptureEducationalViewConfiguration implements ILivenessEducationalViewConfiguration {
    private final LivenessFeatureConfiguration featureConfiguration;

    public FaceCaptureEducationalViewConfiguration(LivenessFeatureConfiguration featureConfiguration) {
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        this.featureConfiguration = featureConfiguration;
    }

    public static /* synthetic */ FaceCaptureEducationalViewConfiguration copy$default(FaceCaptureEducationalViewConfiguration faceCaptureEducationalViewConfiguration, LivenessFeatureConfiguration livenessFeatureConfiguration, int i, Object obj) {
        if ((i & 1) != 0) {
            livenessFeatureConfiguration = faceCaptureEducationalViewConfiguration.getFeatureConfiguration();
        }
        return faceCaptureEducationalViewConfiguration.copy(livenessFeatureConfiguration);
    }

    public final LivenessFeatureConfiguration component1() {
        return getFeatureConfiguration();
    }

    public final FaceCaptureEducationalViewConfiguration copy(LivenessFeatureConfiguration featureConfiguration) {
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        return new FaceCaptureEducationalViewConfiguration(featureConfiguration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FaceCaptureEducationalViewConfiguration) && Intrinsics.areEqual(getFeatureConfiguration(), ((FaceCaptureEducationalViewConfiguration) other).getFeatureConfiguration());
    }

    @Override // com.yoti.mobile.android.liveness.view.educational.ILivenessEducationalViewConfiguration
    public LivenessFeatureConfiguration getFeatureConfiguration() {
        return this.featureConfiguration;
    }

    @Override // com.yoti.mobile.android.liveness.view.educational.ILivenessEducationalViewConfiguration
    public int getGuidelinesTitle() {
        return C4832R.string.yds_face_capture_education_guidelines;
    }

    @Override // com.yoti.mobile.android.liveness.view.educational.ILivenessEducationalViewConfiguration
    public MediaResource getMedia() {
        return new MediaResource(MediaResource.MediaType.IMAGE, C4832R.drawable.yds_face_capture_education_media);
    }

    @Override // com.yoti.mobile.android.liveness.view.educational.ILivenessEducationalViewConfiguration
    public NavigationIcon getNavigationIcon() {
        return ILivenessEducationalViewConfiguration.DefaultImpls.getNavigationIcon(this);
    }

    @Override // com.yoti.mobile.android.liveness.view.educational.ILivenessEducationalViewConfiguration
    public int getPrimaryCtaText() {
        return getFeatureConfiguration().getLivenessType() == LivenessResourceConfigEntity.LivenessTypeEntity.STATIC ? C4832R.string.yds_common_continue : ILivenessEducationalViewConfiguration.DefaultImpls.getPrimaryCtaText(this);
    }

    @Override // com.yoti.mobile.android.liveness.view.educational.ILivenessEducationalViewConfiguration
    public int getText() {
        return C4832R.string.yds_face_capture_education_description;
    }

    @Override // com.yoti.mobile.android.liveness.view.educational.ILivenessEducationalViewConfiguration
    public int getTitle() {
        return ILivenessEducationalViewConfiguration.DefaultImpls.getTitle(this);
    }

    public int hashCode() {
        return getFeatureConfiguration().hashCode();
    }

    @Override // com.yoti.mobile.android.liveness.view.educational.ILivenessEducationalViewConfiguration
    public boolean isGuidelinesLinkVisible() {
        return getFeatureConfiguration().getLivenessType() != LivenessResourceConfigEntity.LivenessTypeEntity.STATIC;
    }

    public String toString() {
        return "FaceCaptureEducationalViewConfiguration(featureConfiguration=" + getFeatureConfiguration() + ')';
    }
}
