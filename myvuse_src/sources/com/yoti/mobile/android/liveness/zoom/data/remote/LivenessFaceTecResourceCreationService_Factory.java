package com.yoti.mobile.android.liveness.zoom.data.remote;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessFaceTecResourceCreationService_Factory implements Factory<LivenessFaceTecResourceCreationService> {
    private final Provider<LivenessFaceTecApiService> livenessFaceTecApiServiceProvider;

    public LivenessFaceTecResourceCreationService_Factory(Provider<LivenessFaceTecApiService> provider) {
        this.livenessFaceTecApiServiceProvider = provider;
    }

    public static LivenessFaceTecResourceCreationService_Factory create(Provider<LivenessFaceTecApiService> provider) {
        return new LivenessFaceTecResourceCreationService_Factory(provider);
    }

    public static LivenessFaceTecResourceCreationService newInstance(LivenessFaceTecApiService livenessFaceTecApiService) {
        return new LivenessFaceTecResourceCreationService(livenessFaceTecApiService);
    }

    @Override // javax.inject.Provider
    public LivenessFaceTecResourceCreationService get() {
        return newInstance(this.livenessFaceTecApiServiceProvider.get());
    }
}
