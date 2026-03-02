package com.yoti.mobile.android.liveness.view.biometric_consent;

import com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentViewData;
import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class BiometricConsentViewData_Factory_Factory implements Factory<BiometricConsentViewData.Factory> {
    private final Provider<LivenessFeatureConfiguration> featureConfigurationProvider;

    public BiometricConsentViewData_Factory_Factory(Provider<LivenessFeatureConfiguration> provider) {
        this.featureConfigurationProvider = provider;
    }

    public static BiometricConsentViewData_Factory_Factory create(Provider<LivenessFeatureConfiguration> provider) {
        return new BiometricConsentViewData_Factory_Factory(provider);
    }

    public static BiometricConsentViewData.Factory newInstance(LivenessFeatureConfiguration livenessFeatureConfiguration) {
        return new BiometricConsentViewData.Factory(livenessFeatureConfiguration);
    }

    @Override // javax.inject.Provider
    public BiometricConsentViewData.Factory get() {
        return newInstance(this.featureConfigurationProvider.get());
    }
}
