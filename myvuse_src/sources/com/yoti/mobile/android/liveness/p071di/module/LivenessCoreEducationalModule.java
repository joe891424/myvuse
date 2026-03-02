package com.yoti.mobile.android.liveness.p071di.module;

import com.yoti.mobile.android.liveness.data.BiometricConsentRepository;
import com.yoti.mobile.android.liveness.domain.IBiometricConsentRepository;
import com.yoti.mobile.android.liveness.domain.ILivenessResourceCreationRepository;
import com.yoti.mobile.android.liveness.domain.model.ILivenessResourceEntity;
import com.yoti.mobile.android.liveness.p071di.ILivenessEducationalDependeciesProvider;
import com.yoti.mobile.android.liveness.view.educational.ILivenessEducationalViewConfiguration;
import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData;
import com.yoti.mobile.android.liveness.view.navigation.ILivenessEducationalNavigatorProvider;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFailureType;
import com.yoti.mobile.android.remote.p075di.RemoteModule;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.SchedulersModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionStatusModule;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007J\b\u0010\f\u001a\u00020\rH\u0007J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0007J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/di/module/LivenessCoreEducationalModule;", "", "dependecyProvider", "Lcom/yoti/mobile/android/liveness/di/ILivenessEducationalDependeciesProvider;", "(Lcom/yoti/mobile/android/liveness/di/ILivenessEducationalDependeciesProvider;)V", "providesBiometricConsentRepository", "Lcom/yoti/mobile/android/liveness/domain/IBiometricConsentRepository;", "repositoryImpl", "Lcom/yoti/mobile/android/liveness/data/BiometricConsentRepository;", "providesEducationalNavigatorProvider", "Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessEducationalNavigatorProvider;", "Lcom/yoti/mobile/android/liveness/domain/model/ILivenessResourceEntity;", "providesEducationalViewConfiguration", "Lcom/yoti/mobile/android/liveness/view/educational/ILivenessEducationalViewConfiguration;", "providesGuidelinesViewDataFactory", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData$Factory;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadFailureType;", "providesResourceCreationRepository", "Lcom/yoti/mobile/android/liveness/domain/ILivenessResourceCreationRepository;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module(includes = {LivenessCoreApiServiceModule.class, LivenessFeatureConfigurationModule.class, RemoteModule.class, SchedulersModule.class, LivenessCoreViewModelModule.class, SessionStatusModule.class, CommonModule.class})
public final class LivenessCoreEducationalModule {
    private final ILivenessEducationalDependeciesProvider dependecyProvider;

    public LivenessCoreEducationalModule(ILivenessEducationalDependeciesProvider dependecyProvider) {
        Intrinsics.checkNotNullParameter(dependecyProvider, "dependecyProvider");
        this.dependecyProvider = dependecyProvider;
    }

    @Provides
    public final IBiometricConsentRepository providesBiometricConsentRepository(BiometricConsentRepository repositoryImpl) {
        Intrinsics.checkNotNullParameter(repositoryImpl, "repositoryImpl");
        return repositoryImpl;
    }

    @Provides
    public final ILivenessEducationalNavigatorProvider<ILivenessResourceEntity> providesEducationalNavigatorProvider() {
        return this.dependecyProvider.getEducationalNavigatorProvider();
    }

    @Provides
    public final ILivenessEducationalViewConfiguration providesEducationalViewConfiguration() {
        return this.dependecyProvider.getEducationalViewConfiguration();
    }

    @Provides
    public final LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> providesGuidelinesViewDataFactory() {
        return this.dependecyProvider.getGuidelinesViewDataFactory();
    }

    @Provides
    public final ILivenessResourceCreationRepository<ILivenessResourceEntity> providesResourceCreationRepository() {
        return this.dependecyProvider.getResourceCreationRepository();
    }
}
