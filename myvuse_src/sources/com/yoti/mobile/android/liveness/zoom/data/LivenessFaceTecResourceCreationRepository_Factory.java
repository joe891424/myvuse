package com.yoti.mobile.android.liveness.zoom.data;

import com.yoti.mobile.android.liveness.zoom.data.remote.LivenessFaceTecResourceCreationService;
import com.yoti.mobile.android.remote.exception.RemoteExceptionToEntityMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessFaceTecResourceCreationRepository_Factory implements Factory<LivenessFaceTecResourceCreationRepository> {
    private final Provider<RemoteExceptionToEntityMapper> exceptionToEntityMapperProvider;
    private final Provider<LivenessFaceTecResourceCreationService> livenessResourceCreationServiceProvider;
    private final Provider<LivenessFaceTecResourceToEntityMapper> livenessResourceMapperProvider;
    private final Provider<String> requirementIdProvider;

    public LivenessFaceTecResourceCreationRepository_Factory(Provider<String> provider, Provider<LivenessFaceTecResourceCreationService> provider2, Provider<LivenessFaceTecResourceToEntityMapper> provider3, Provider<RemoteExceptionToEntityMapper> provider4) {
        this.requirementIdProvider = provider;
        this.livenessResourceCreationServiceProvider = provider2;
        this.livenessResourceMapperProvider = provider3;
        this.exceptionToEntityMapperProvider = provider4;
    }

    public static LivenessFaceTecResourceCreationRepository_Factory create(Provider<String> provider, Provider<LivenessFaceTecResourceCreationService> provider2, Provider<LivenessFaceTecResourceToEntityMapper> provider3, Provider<RemoteExceptionToEntityMapper> provider4) {
        return new LivenessFaceTecResourceCreationRepository_Factory(provider, provider2, provider3, provider4);
    }

    public static LivenessFaceTecResourceCreationRepository newInstance(String str, LivenessFaceTecResourceCreationService livenessFaceTecResourceCreationService, LivenessFaceTecResourceToEntityMapper livenessFaceTecResourceToEntityMapper, RemoteExceptionToEntityMapper remoteExceptionToEntityMapper) {
        return new LivenessFaceTecResourceCreationRepository(str, livenessFaceTecResourceCreationService, livenessFaceTecResourceToEntityMapper, remoteExceptionToEntityMapper);
    }

    @Override // javax.inject.Provider
    public LivenessFaceTecResourceCreationRepository get() {
        return newInstance(this.requirementIdProvider.get(), this.livenessResourceCreationServiceProvider.get(), this.livenessResourceMapperProvider.get(), this.exceptionToEntityMapperProvider.get());
    }
}
