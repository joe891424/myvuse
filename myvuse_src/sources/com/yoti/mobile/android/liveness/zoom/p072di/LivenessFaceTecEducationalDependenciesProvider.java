package com.yoti.mobile.android.liveness.zoom.p072di;

import com.yoti.mobile.android.liveness.domain.ILivenessResourceCreationRepository;
import com.yoti.mobile.android.liveness.domain.model.ILivenessResourceEntity;
import com.yoti.mobile.android.liveness.p071di.ILivenessEducationalDependeciesProvider;
import com.yoti.mobile.android.liveness.view.educational.ILivenessEducationalViewConfiguration;
import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData;
import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewDataFactory;
import com.yoti.mobile.android.liveness.view.navigation.ILivenessEducationalNavigatorProvider;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFailureType;
import com.yoti.mobile.android.liveness.zoom.data.LivenessFaceTecResourceCreationRepository;
import com.yoti.mobile.android.liveness.zoom.view.educational.LivenessFaceTecEducationalViewConfiguration;
import com.yoti.mobile.android.liveness.zoom.view.navigation.LivenessFaceTecEducationalNavigatorProvider;
import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/di/LivenessFaceTecEducationalDependenciesProvider;", "Lcom/yoti/mobile/android/liveness/di/ILivenessEducationalDependeciesProvider;", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;", "livenessFaceTecEducationalNavigatorProvider", "Lcom/yoti/mobile/android/liveness/zoom/view/navigation/LivenessFaceTecEducationalNavigatorProvider;", "livenessFaceTecResourceRepository", "Lcom/yoti/mobile/android/liveness/zoom/data/LivenessFaceTecResourceCreationRepository;", "livenessGuidelinesViewDataFactory", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewDataFactory;", "(Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;Lcom/yoti/mobile/android/liveness/zoom/view/navigation/LivenessFaceTecEducationalNavigatorProvider;Lcom/yoti/mobile/android/liveness/zoom/data/LivenessFaceTecResourceCreationRepository;Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewDataFactory;)V", "educationalNavigatorProvider", "Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessEducationalNavigatorProvider;", "Lcom/yoti/mobile/android/liveness/domain/model/ILivenessResourceEntity;", "getEducationalNavigatorProvider", "()Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessEducationalNavigatorProvider;", "educationalViewConfiguration", "Lcom/yoti/mobile/android/liveness/view/educational/ILivenessEducationalViewConfiguration;", "getEducationalViewConfiguration", "()Lcom/yoti/mobile/android/liveness/view/educational/ILivenessEducationalViewConfiguration;", "guidelinesViewDataFactory", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData$Factory;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadFailureType;", "getGuidelinesViewDataFactory", "()Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData$Factory;", "resourceCreationRepository", "Lcom/yoti/mobile/android/liveness/domain/ILivenessResourceCreationRepository;", "getResourceCreationRepository", "()Lcom/yoti/mobile/android/liveness/domain/ILivenessResourceCreationRepository;", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class LivenessFaceTecEducationalDependenciesProvider implements ILivenessEducationalDependeciesProvider {
    private final ILivenessEducationalNavigatorProvider<ILivenessResourceEntity> educationalNavigatorProvider;
    private final ILivenessEducationalViewConfiguration educationalViewConfiguration;
    private final LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> guidelinesViewDataFactory;
    private final ILivenessResourceCreationRepository<ILivenessResourceEntity> resourceCreationRepository;

    @Inject
    public LivenessFaceTecEducationalDependenciesProvider(LivenessFeatureConfiguration featureConfiguration, LivenessFaceTecEducationalNavigatorProvider livenessFaceTecEducationalNavigatorProvider, LivenessFaceTecResourceCreationRepository livenessFaceTecResourceRepository, LivenessGuidelinesViewDataFactory livenessGuidelinesViewDataFactory) {
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        Intrinsics.checkNotNullParameter(livenessFaceTecEducationalNavigatorProvider, "livenessFaceTecEducationalNavigatorProvider");
        Intrinsics.checkNotNullParameter(livenessFaceTecResourceRepository, "livenessFaceTecResourceRepository");
        Intrinsics.checkNotNullParameter(livenessGuidelinesViewDataFactory, "livenessGuidelinesViewDataFactory");
        this.educationalNavigatorProvider = livenessFaceTecEducationalNavigatorProvider;
        this.educationalViewConfiguration = new LivenessFaceTecEducationalViewConfiguration(featureConfiguration, null, 2, null);
        this.resourceCreationRepository = livenessFaceTecResourceRepository;
        this.guidelinesViewDataFactory = livenessGuidelinesViewDataFactory;
    }

    @Override // com.yoti.mobile.android.liveness.p071di.ILivenessEducationalDependeciesProvider
    public ILivenessEducationalNavigatorProvider<ILivenessResourceEntity> getEducationalNavigatorProvider() {
        return this.educationalNavigatorProvider;
    }

    @Override // com.yoti.mobile.android.liveness.p071di.ILivenessEducationalDependeciesProvider
    public ILivenessEducationalViewConfiguration getEducationalViewConfiguration() {
        return this.educationalViewConfiguration;
    }

    @Override // com.yoti.mobile.android.liveness.p071di.ILivenessEducationalDependeciesProvider
    public LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> getGuidelinesViewDataFactory() {
        return this.guidelinesViewDataFactory;
    }

    @Override // com.yoti.mobile.android.liveness.p071di.ILivenessEducationalDependeciesProvider
    public ILivenessResourceCreationRepository<ILivenessResourceEntity> getResourceCreationRepository() {
        return this.resourceCreationRepository;
    }
}
