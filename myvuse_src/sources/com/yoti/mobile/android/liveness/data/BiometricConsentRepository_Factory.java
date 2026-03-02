package com.yoti.mobile.android.liveness.data;

import com.yoti.mobile.android.liveness.data.remote.GiveBiometricConsentService;
import com.yoti.mobile.android.remote.exception.RemoteExceptionToEntityMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class BiometricConsentRepository_Factory implements Factory<BiometricConsentRepository> {
    private final Provider<GiveBiometricConsentService> giveBiometricConsentServiceProvider;
    private final Provider<RemoteExceptionToEntityMapper> remoteExceptionToEntityMapperProvider;

    public BiometricConsentRepository_Factory(Provider<GiveBiometricConsentService> provider, Provider<RemoteExceptionToEntityMapper> provider2) {
        this.giveBiometricConsentServiceProvider = provider;
        this.remoteExceptionToEntityMapperProvider = provider2;
    }

    public static BiometricConsentRepository_Factory create(Provider<GiveBiometricConsentService> provider, Provider<RemoteExceptionToEntityMapper> provider2) {
        return new BiometricConsentRepository_Factory(provider, provider2);
    }

    public static BiometricConsentRepository newInstance(GiveBiometricConsentService giveBiometricConsentService, RemoteExceptionToEntityMapper remoteExceptionToEntityMapper) {
        return new BiometricConsentRepository(giveBiometricConsentService, remoteExceptionToEntityMapper);
    }

    @Override // javax.inject.Provider
    public BiometricConsentRepository get() {
        return newInstance(this.giveBiometricConsentServiceProvider.get(), this.remoteExceptionToEntityMapperProvider.get());
    }
}
