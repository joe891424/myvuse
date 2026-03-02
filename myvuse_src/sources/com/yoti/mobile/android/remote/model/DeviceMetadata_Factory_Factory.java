package com.yoti.mobile.android.remote.model;

import com.yoti.mobile.android.remote.ip_tracking.domain.IIpRepository;
import com.yoti.mobile.android.remote.model.DeviceMetadata;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class DeviceMetadata_Factory_Factory implements Factory<DeviceMetadata.Factory> {
    private final Provider<IIpRepository> ipRepositoryProvider;
    private final Provider<Session> sessionProvider;

    public DeviceMetadata_Factory_Factory(Provider<Session> provider, Provider<IIpRepository> provider2) {
        this.sessionProvider = provider;
        this.ipRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public DeviceMetadata.Factory get() {
        return newInstance(this.sessionProvider.get(), this.ipRepositoryProvider.get());
    }

    public static DeviceMetadata_Factory_Factory create(Provider<Session> provider, Provider<IIpRepository> provider2) {
        return new DeviceMetadata_Factory_Factory(provider, provider2);
    }

    public static DeviceMetadata.Factory newInstance(Session session, IIpRepository iIpRepository) {
        return new DeviceMetadata.Factory(session, iIpRepository);
    }
}
