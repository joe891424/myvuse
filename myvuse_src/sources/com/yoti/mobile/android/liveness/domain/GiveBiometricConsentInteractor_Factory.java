package com.yoti.mobile.android.liveness.domain;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class GiveBiometricConsentInteractor_Factory implements Factory<GiveBiometricConsentInteractor> {
    private final Provider<IBiometricConsentRepository> biometricConsentRepositoryProvider;

    public GiveBiometricConsentInteractor_Factory(Provider<IBiometricConsentRepository> provider) {
        this.biometricConsentRepositoryProvider = provider;
    }

    public static GiveBiometricConsentInteractor_Factory create(Provider<IBiometricConsentRepository> provider) {
        return new GiveBiometricConsentInteractor_Factory(provider);
    }

    public static GiveBiometricConsentInteractor newInstance(IBiometricConsentRepository iBiometricConsentRepository) {
        return new GiveBiometricConsentInteractor(iBiometricConsentRepository);
    }

    @Override // javax.inject.Provider
    public GiveBiometricConsentInteractor get() {
        return newInstance(this.biometricConsentRepositoryProvider.get());
    }
}
