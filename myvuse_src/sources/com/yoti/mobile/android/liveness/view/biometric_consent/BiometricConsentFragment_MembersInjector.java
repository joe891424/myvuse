package com.yoti.mobile.android.liveness.view.biometric_consent;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class BiometricConsentFragment_MembersInjector implements MembersInjector<BiometricConsentFragment> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public BiometricConsentFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<BiometricConsentFragment> create(Provider<ViewModelProvider.Factory> provider) {
        return new BiometricConsentFragment_MembersInjector(provider);
    }

    public static void injectViewModelFactory(BiometricConsentFragment biometricConsentFragment, ViewModelProvider.Factory factory) {
        biometricConsentFragment.viewModelFactory = factory;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(BiometricConsentFragment biometricConsentFragment) {
        injectViewModelFactory(biometricConsentFragment, this.viewModelFactoryProvider.get());
    }
}
