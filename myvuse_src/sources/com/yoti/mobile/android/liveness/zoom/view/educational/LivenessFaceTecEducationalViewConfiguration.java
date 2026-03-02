package com.yoti.mobile.android.liveness.zoom.view.educational;

import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.commonui.MediaResource;
import com.yoti.mobile.android.liveness.view.educational.ILivenessEducationalViewConfiguration;
import com.yoti.mobile.android.liveness.zoom.C4888R;
import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/educational/LivenessFaceTecEducationalViewConfiguration;", "Lcom/yoti/mobile/android/liveness/view/educational/ILivenessEducationalViewConfiguration;", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;", "media", "Lcom/yoti/mobile/android/commonui/MediaResource;", "(Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;Lcom/yoti/mobile/android/commonui/MediaResource;)V", "getFeatureConfiguration", "()Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;", "getMedia", "()Lcom/yoti/mobile/android/commonui/MediaResource;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class LivenessFaceTecEducationalViewConfiguration implements ILivenessEducationalViewConfiguration {
    private final LivenessFeatureConfiguration featureConfiguration;
    private final MediaResource media;

    public LivenessFaceTecEducationalViewConfiguration(LivenessFeatureConfiguration featureConfiguration, MediaResource media) {
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        Intrinsics.checkNotNullParameter(media, "media");
        this.featureConfiguration = featureConfiguration;
        this.media = media;
    }

    public /* synthetic */ LivenessFaceTecEducationalViewConfiguration(LivenessFeatureConfiguration livenessFeatureConfiguration, MediaResource mediaResource, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(livenessFeatureConfiguration, (i & 2) != 0 ? new MediaResource(MediaResource.MediaType.VIDEO, C4888R.raw.yds_liveness_educational) : mediaResource);
    }

    public static /* synthetic */ LivenessFaceTecEducationalViewConfiguration copy$default(LivenessFaceTecEducationalViewConfiguration livenessFaceTecEducationalViewConfiguration, LivenessFeatureConfiguration livenessFeatureConfiguration, MediaResource mediaResource, int i, Object obj) {
        if ((i & 1) != 0) {
            livenessFeatureConfiguration = livenessFaceTecEducationalViewConfiguration.getFeatureConfiguration();
        }
        if ((i & 2) != 0) {
            mediaResource = livenessFaceTecEducationalViewConfiguration.getMedia();
        }
        return livenessFaceTecEducationalViewConfiguration.copy(livenessFeatureConfiguration, mediaResource);
    }

    public final LivenessFeatureConfiguration component1() {
        return getFeatureConfiguration();
    }

    public final MediaResource component2() {
        return getMedia();
    }

    public final LivenessFaceTecEducationalViewConfiguration copy(LivenessFeatureConfiguration featureConfiguration, MediaResource media) {
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        Intrinsics.checkNotNullParameter(media, "media");
        return new LivenessFaceTecEducationalViewConfiguration(featureConfiguration, media);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LivenessFaceTecEducationalViewConfiguration)) {
            return false;
        }
        LivenessFaceTecEducationalViewConfiguration livenessFaceTecEducationalViewConfiguration = (LivenessFaceTecEducationalViewConfiguration) other;
        return Intrinsics.areEqual(getFeatureConfiguration(), livenessFaceTecEducationalViewConfiguration.getFeatureConfiguration()) && Intrinsics.areEqual(getMedia(), livenessFaceTecEducationalViewConfiguration.getMedia());
    }

    @Override // com.yoti.mobile.android.liveness.view.educational.ILivenessEducationalViewConfiguration
    public LivenessFeatureConfiguration getFeatureConfiguration() {
        return this.featureConfiguration;
    }

    @Override // com.yoti.mobile.android.liveness.view.educational.ILivenessEducationalViewConfiguration
    public int getGuidelinesTitle() {
        return ILivenessEducationalViewConfiguration.DefaultImpls.getGuidelinesTitle(this);
    }

    @Override // com.yoti.mobile.android.liveness.view.educational.ILivenessEducationalViewConfiguration
    public MediaResource getMedia() {
        return this.media;
    }

    @Override // com.yoti.mobile.android.liveness.view.educational.ILivenessEducationalViewConfiguration
    public NavigationIcon getNavigationIcon() {
        return ILivenessEducationalViewConfiguration.DefaultImpls.getNavigationIcon(this);
    }

    @Override // com.yoti.mobile.android.liveness.view.educational.ILivenessEducationalViewConfiguration
    public int getPrimaryCtaText() {
        return ILivenessEducationalViewConfiguration.DefaultImpls.getPrimaryCtaText(this);
    }

    @Override // com.yoti.mobile.android.liveness.view.educational.ILivenessEducationalViewConfiguration
    public int getText() {
        return ILivenessEducationalViewConfiguration.DefaultImpls.getText(this);
    }

    @Override // com.yoti.mobile.android.liveness.view.educational.ILivenessEducationalViewConfiguration
    public int getTitle() {
        return ILivenessEducationalViewConfiguration.DefaultImpls.getTitle(this);
    }

    public int hashCode() {
        return (getFeatureConfiguration().hashCode() * 31) + getMedia().hashCode();
    }

    @Override // com.yoti.mobile.android.liveness.view.educational.ILivenessEducationalViewConfiguration
    public boolean isGuidelinesLinkVisible() {
        return ILivenessEducationalViewConfiguration.DefaultImpls.isGuidelinesLinkVisible(this);
    }

    public String toString() {
        return "LivenessFaceTecEducationalViewConfiguration(featureConfiguration=" + getFeatureConfiguration() + ", media=" + getMedia() + ')';
    }
}
