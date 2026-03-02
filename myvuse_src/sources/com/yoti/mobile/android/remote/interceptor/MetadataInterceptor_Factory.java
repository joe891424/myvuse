package com.yoti.mobile.android.remote.interceptor;

import com.yoti.mobile.android.remote.model.DeviceMetadata;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class MetadataInterceptor_Factory implements Factory<MetadataInterceptor> {
    private final Provider<DeviceMetadata.Factory> metadataFactoryProvider;

    public MetadataInterceptor_Factory(Provider<DeviceMetadata.Factory> provider) {
        this.metadataFactoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public MetadataInterceptor get() {
        return newInstance(this.metadataFactoryProvider.get());
    }

    public static MetadataInterceptor_Factory create(Provider<DeviceMetadata.Factory> provider) {
        return new MetadataInterceptor_Factory(provider);
    }

    public static MetadataInterceptor newInstance(DeviceMetadata.Factory factory) {
        return new MetadataInterceptor(factory);
    }
}
