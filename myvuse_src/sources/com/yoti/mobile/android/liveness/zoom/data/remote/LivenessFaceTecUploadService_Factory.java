package com.yoti.mobile.android.liveness.zoom.data.remote;

import com.yoti.mobile.android.remote.MultiPartBodyFactory;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessFaceTecUploadService_Factory implements Factory<LivenessFaceTecUploadService> {
    private final Provider<LivenessFaceTecApiService> livenessFaceTecApiServiceProvider;
    private final Provider<MultiPartBodyFactory> multipartBodyFactoryProvider;

    public LivenessFaceTecUploadService_Factory(Provider<MultiPartBodyFactory> provider, Provider<LivenessFaceTecApiService> provider2) {
        this.multipartBodyFactoryProvider = provider;
        this.livenessFaceTecApiServiceProvider = provider2;
    }

    public static LivenessFaceTecUploadService_Factory create(Provider<MultiPartBodyFactory> provider, Provider<LivenessFaceTecApiService> provider2) {
        return new LivenessFaceTecUploadService_Factory(provider, provider2);
    }

    public static LivenessFaceTecUploadService newInstance(MultiPartBodyFactory multiPartBodyFactory, LivenessFaceTecApiService livenessFaceTecApiService) {
        return new LivenessFaceTecUploadService(multiPartBodyFactory, livenessFaceTecApiService);
    }

    @Override // javax.inject.Provider
    public LivenessFaceTecUploadService get() {
        return newInstance(this.multipartBodyFactoryProvider.get(), this.livenessFaceTecApiServiceProvider.get());
    }
}
