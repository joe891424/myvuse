package com.yoti.mobile.android.liveness.data.remote;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class GiveBiometricConsentService_Factory implements Factory<GiveBiometricConsentService> {
    private final Provider<LivenessCoreApiService> apiServiceProvider;

    public GiveBiometricConsentService_Factory(Provider<LivenessCoreApiService> provider) {
        this.apiServiceProvider = provider;
    }

    public static GiveBiometricConsentService_Factory create(Provider<LivenessCoreApiService> provider) {
        return new GiveBiometricConsentService_Factory(provider);
    }

    public static GiveBiometricConsentService newInstance(LivenessCoreApiService livenessCoreApiService) {
        return new GiveBiometricConsentService(livenessCoreApiService);
    }

    @Override // javax.inject.Provider
    public GiveBiometricConsentService get() {
        return newInstance(this.apiServiceProvider.get());
    }
}
