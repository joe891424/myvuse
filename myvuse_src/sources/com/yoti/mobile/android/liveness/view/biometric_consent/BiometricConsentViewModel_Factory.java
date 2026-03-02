package com.yoti.mobile.android.liveness.view.biometric_consent;

import com.yoti.mobile.android.liveness.domain.GiveBiometricConsentInteractor;
import com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentViewData;
import com.yoti.mobile.android.yotidocs.common.error.ExceptionToFailureMapper;
import com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class BiometricConsentViewModel_Factory implements Factory<BiometricConsentViewModel> {
    private final Provider<BiometricConsentViewData.Factory> biometricConsentViewDataFactoryProvider;
    private final Provider<ExceptionToFailureMapper> errorToFailureMapperProvider;
    private final Provider<ErrorToSessionStatusTypeMapper> errorToSessionStatusTypeMapperProvider;
    private final Provider<LivenessFeatureConfiguration> featureConfigurationProvider;
    private final Provider<GiveBiometricConsentInteractor> giveBiometricConsentInteractorProvider;
    private final Provider<SessionStatus> sessionStatusProvider;

    public BiometricConsentViewModel_Factory(Provider<LivenessFeatureConfiguration> provider, Provider<BiometricConsentViewData.Factory> provider2, Provider<GiveBiometricConsentInteractor> provider3, Provider<SessionStatus> provider4, Provider<ExceptionToFailureMapper> provider5, Provider<ErrorToSessionStatusTypeMapper> provider6) {
        this.featureConfigurationProvider = provider;
        this.biometricConsentViewDataFactoryProvider = provider2;
        this.giveBiometricConsentInteractorProvider = provider3;
        this.sessionStatusProvider = provider4;
        this.errorToFailureMapperProvider = provider5;
        this.errorToSessionStatusTypeMapperProvider = provider6;
    }

    public static BiometricConsentViewModel_Factory create(Provider<LivenessFeatureConfiguration> provider, Provider<BiometricConsentViewData.Factory> provider2, Provider<GiveBiometricConsentInteractor> provider3, Provider<SessionStatus> provider4, Provider<ExceptionToFailureMapper> provider5, Provider<ErrorToSessionStatusTypeMapper> provider6) {
        return new BiometricConsentViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static BiometricConsentViewModel newInstance(LivenessFeatureConfiguration livenessFeatureConfiguration, BiometricConsentViewData.Factory factory, GiveBiometricConsentInteractor giveBiometricConsentInteractor, SessionStatus sessionStatus, ExceptionToFailureMapper exceptionToFailureMapper, ErrorToSessionStatusTypeMapper errorToSessionStatusTypeMapper) {
        return new BiometricConsentViewModel(livenessFeatureConfiguration, factory, giveBiometricConsentInteractor, sessionStatus, exceptionToFailureMapper, errorToSessionStatusTypeMapper);
    }

    @Override // javax.inject.Provider
    public BiometricConsentViewModel get() {
        return newInstance(this.featureConfigurationProvider.get(), this.biometricConsentViewDataFactoryProvider.get(), this.giveBiometricConsentInteractorProvider.get(), this.sessionStatusProvider.get(), this.errorToFailureMapperProvider.get(), this.errorToSessionStatusTypeMapperProvider.get());
    }
}
