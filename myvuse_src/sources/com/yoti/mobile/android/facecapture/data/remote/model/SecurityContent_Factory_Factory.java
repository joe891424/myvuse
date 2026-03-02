package com.yoti.mobile.android.facecapture.data.remote.model;

import com.yoti.mobile.android.facecapture.data.remote.model.SecurityContent;
import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class SecurityContent_Factory_Factory implements Factory<SecurityContent.Factory> {
    private final Provider<LivenessFeatureConfiguration> featureConfigurationProvider;

    public SecurityContent_Factory_Factory(Provider<LivenessFeatureConfiguration> provider) {
        this.featureConfigurationProvider = provider;
    }

    public static SecurityContent_Factory_Factory create(Provider<LivenessFeatureConfiguration> provider) {
        return new SecurityContent_Factory_Factory(provider);
    }

    public static SecurityContent.Factory newInstance(LivenessFeatureConfiguration livenessFeatureConfiguration) {
        return new SecurityContent.Factory(livenessFeatureConfiguration);
    }

    @Override // javax.inject.Provider
    public SecurityContent.Factory get() {
        return newInstance(this.featureConfigurationProvider.get());
    }
}
