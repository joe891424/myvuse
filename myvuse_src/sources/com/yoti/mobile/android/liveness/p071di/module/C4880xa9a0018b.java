package com.yoti.mobile.android.liveness.p071di.module;

import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.liveness.di.module.LivenessCoreViewModelModule_ProvidesBiometricConsentViewModelFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4880xa9a0018b implements Factory<ViewModel> {
    private final LivenessCoreViewModelModule module;
    private final Provider<BiometricConsentViewModel> viewModelProvider;

    public C4880xa9a0018b(LivenessCoreViewModelModule livenessCoreViewModelModule, Provider<BiometricConsentViewModel> provider) {
        this.module = livenessCoreViewModelModule;
        this.viewModelProvider = provider;
    }

    public static C4880xa9a0018b create(LivenessCoreViewModelModule livenessCoreViewModelModule, Provider<BiometricConsentViewModel> provider) {
        return new C4880xa9a0018b(livenessCoreViewModelModule, provider);
    }

    public static ViewModel providesBiometricConsentViewModel(LivenessCoreViewModelModule livenessCoreViewModelModule, BiometricConsentViewModel biometricConsentViewModel) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(livenessCoreViewModelModule.providesBiometricConsentViewModel(biometricConsentViewModel));
    }

    @Override // javax.inject.Provider
    public ViewModel get() {
        return providesBiometricConsentViewModel(this.module, this.viewModelProvider.get());
    }
}
