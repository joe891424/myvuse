package com.yoti.mobile.android.yotisdkcore.core.data;

import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentResourceConfigurationToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.data.LivenessResourceConfigurationToEntityMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class SessionConfigurationDataToEntityMapper_Factory implements Factory<SessionConfigurationDataToEntityMapper> {
    private final Provider<DocumentResourceConfigurationToEntityMapper> documentResourceMapperProvider;
    private final Provider<LivenessResourceConfigurationToEntityMapper> livenessResourceMapperProvider;

    public SessionConfigurationDataToEntityMapper_Factory(Provider<DocumentResourceConfigurationToEntityMapper> provider, Provider<LivenessResourceConfigurationToEntityMapper> provider2) {
        this.documentResourceMapperProvider = provider;
        this.livenessResourceMapperProvider = provider2;
    }

    public static SessionConfigurationDataToEntityMapper_Factory create(Provider<DocumentResourceConfigurationToEntityMapper> provider, Provider<LivenessResourceConfigurationToEntityMapper> provider2) {
        return new SessionConfigurationDataToEntityMapper_Factory(provider, provider2);
    }

    public static SessionConfigurationDataToEntityMapper newInstance(DocumentResourceConfigurationToEntityMapper documentResourceConfigurationToEntityMapper, LivenessResourceConfigurationToEntityMapper livenessResourceConfigurationToEntityMapper) {
        return new SessionConfigurationDataToEntityMapper(documentResourceConfigurationToEntityMapper, livenessResourceConfigurationToEntityMapper);
    }

    @Override // javax.inject.Provider
    public SessionConfigurationDataToEntityMapper get() {
        return newInstance(this.documentResourceMapperProvider.get(), this.livenessResourceMapperProvider.get());
    }
}
