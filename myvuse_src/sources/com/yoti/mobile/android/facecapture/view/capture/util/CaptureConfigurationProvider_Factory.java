package com.yoti.mobile.android.facecapture.view.capture.util;

import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class CaptureConfigurationProvider_Factory implements Factory<CaptureConfigurationProvider> {
    private final Provider<LivenessFeatureConfiguration> featureConfigurationProvider;

    public CaptureConfigurationProvider_Factory(Provider<LivenessFeatureConfiguration> provider) {
        this.featureConfigurationProvider = provider;
    }

    public static CaptureConfigurationProvider_Factory create(Provider<LivenessFeatureConfiguration> provider) {
        return new CaptureConfigurationProvider_Factory(provider);
    }

    public static CaptureConfigurationProvider newInstance(LivenessFeatureConfiguration livenessFeatureConfiguration) {
        return new CaptureConfigurationProvider(livenessFeatureConfiguration);
    }

    @Override // javax.inject.Provider
    public CaptureConfigurationProvider get() {
        return newInstance(this.featureConfigurationProvider.get());
    }
}
