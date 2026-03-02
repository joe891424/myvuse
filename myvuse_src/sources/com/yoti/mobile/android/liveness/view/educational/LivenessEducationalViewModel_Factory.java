package com.yoti.mobile.android.liveness.view.educational;

import com.yoti.mobile.android.liveness.domain.CreateLivenessResourceInteractor;
import com.yoti.mobile.android.yotidocs.common.error.ExceptionToFailureMapper;
import com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessEducationalViewModel_Factory implements Factory<LivenessEducationalViewModel> {
    private final Provider<CreateLivenessResourceInteractor> createLivenessResourceInteractorProvider;
    private final Provider<ExceptionToFailureMapper> errorToFailureMapperProvider;
    private final Provider<ErrorToSessionStatusTypeMapper> errorToSessionStatusTypeMapperProvider;
    private final Provider<LivenessFeatureConfiguration> featureConfigurationProvider;
    private final Provider<SessionStatus> sessionStatusProvider;
    private final Provider<ILivenessEducationalViewConfiguration> viewConfigurationProvider;

    public LivenessEducationalViewModel_Factory(Provider<ILivenessEducationalViewConfiguration> provider, Provider<CreateLivenessResourceInteractor> provider2, Provider<SessionStatus> provider3, Provider<ExceptionToFailureMapper> provider4, Provider<ErrorToSessionStatusTypeMapper> provider5, Provider<LivenessFeatureConfiguration> provider6) {
        this.viewConfigurationProvider = provider;
        this.createLivenessResourceInteractorProvider = provider2;
        this.sessionStatusProvider = provider3;
        this.errorToFailureMapperProvider = provider4;
        this.errorToSessionStatusTypeMapperProvider = provider5;
        this.featureConfigurationProvider = provider6;
    }

    public static LivenessEducationalViewModel_Factory create(Provider<ILivenessEducationalViewConfiguration> provider, Provider<CreateLivenessResourceInteractor> provider2, Provider<SessionStatus> provider3, Provider<ExceptionToFailureMapper> provider4, Provider<ErrorToSessionStatusTypeMapper> provider5, Provider<LivenessFeatureConfiguration> provider6) {
        return new LivenessEducationalViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static LivenessEducationalViewModel newInstance(ILivenessEducationalViewConfiguration iLivenessEducationalViewConfiguration, CreateLivenessResourceInteractor createLivenessResourceInteractor, SessionStatus sessionStatus, ExceptionToFailureMapper exceptionToFailureMapper, ErrorToSessionStatusTypeMapper errorToSessionStatusTypeMapper, LivenessFeatureConfiguration livenessFeatureConfiguration) {
        return new LivenessEducationalViewModel(iLivenessEducationalViewConfiguration, createLivenessResourceInteractor, sessionStatus, exceptionToFailureMapper, errorToSessionStatusTypeMapper, livenessFeatureConfiguration);
    }

    @Override // javax.inject.Provider
    public LivenessEducationalViewModel get() {
        return newInstance(this.viewConfigurationProvider.get(), this.createLivenessResourceInteractorProvider.get(), this.sessionStatusProvider.get(), this.errorToFailureMapperProvider.get(), this.errorToSessionStatusTypeMapperProvider.get(), this.featureConfigurationProvider.get());
    }
}
