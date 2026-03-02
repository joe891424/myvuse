package com.yoti.mobile.android.liveness.p071di.module;

import com.yoti.mobile.android.liveness.domain.ILivenessCaptureRepository;
import com.yoti.mobile.android.liveness.domain.model.ILivenessCaptureEntity;
import com.yoti.mobile.android.liveness.p071di.ILivenessUploadDependenciesProvider;
import com.yoti.mobile.android.liveness.view.capture.model.ILivenessCapture;
import com.yoti.mobile.android.liveness.view.navigation.ILivenessUploadNavigatorProvider;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.SchedulersModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionStatusModule;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0007J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u0006H\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/di/module/LivenessCoreUploadModule;", "", "dependenciesProvider", "Lcom/yoti/mobile/android/liveness/di/ILivenessUploadDependenciesProvider;", "(Lcom/yoti/mobile/android/liveness/di/ILivenessUploadDependenciesProvider;)V", "providesCaptureToEntityMapper", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/liveness/view/capture/model/ILivenessCapture;", "Lcom/yoti/mobile/android/liveness/domain/model/ILivenessCaptureEntity;", "providesLivenessCaptureRepository", "Lcom/yoti/mobile/android/liveness/domain/ILivenessCaptureRepository;", "providesUploadErrorToFailureMapper", "", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "providesUploadNavigatorProvider", "Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessUploadNavigatorProvider;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module(includes = {LivenessFeatureConfigurationModule.class, SchedulersModule.class, LivenessCoreViewModelModule.class, SessionStatusModule.class, CommonModule.class})
public final class LivenessCoreUploadModule {
    private final ILivenessUploadDependenciesProvider dependenciesProvider;

    public LivenessCoreUploadModule(ILivenessUploadDependenciesProvider dependenciesProvider) {
        Intrinsics.checkNotNullParameter(dependenciesProvider, "dependenciesProvider");
        this.dependenciesProvider = dependenciesProvider;
    }

    @Provides
    public final Mapper<ILivenessCapture, ILivenessCaptureEntity> providesCaptureToEntityMapper() {
        return this.dependenciesProvider.getCaptureToEntityMapper();
    }

    @Provides
    public final ILivenessCaptureRepository<ILivenessCaptureEntity> providesLivenessCaptureRepository() {
        return this.dependenciesProvider.getLivenessCaptureRepository();
    }

    @Provides
    public final Mapper<Throwable, YdsFailure> providesUploadErrorToFailureMapper() {
        return this.dependenciesProvider.getUploadErrorToFailureMapper();
    }

    @Provides
    public final ILivenessUploadNavigatorProvider providesUploadNavigatorProvider() {
        return this.dependenciesProvider.getUploadNavigatorProvider();
    }
}
