package com.yoti.mobile.android.liveness.p071di.module;

import com.yoti.mobile.android.liveness.data.BiometricConsentRepository;
import com.yoti.mobile.android.liveness.domain.IBiometricConsentRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.liveness.di.module.LivenessCoreEducationalModule_ProvidesBiometricConsentRepositoryFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4873x16c9cf2a implements Factory<IBiometricConsentRepository> {
    private final LivenessCoreEducationalModule module;
    private final Provider<BiometricConsentRepository> repositoryImplProvider;

    public C4873x16c9cf2a(LivenessCoreEducationalModule livenessCoreEducationalModule, Provider<BiometricConsentRepository> provider) {
        this.module = livenessCoreEducationalModule;
        this.repositoryImplProvider = provider;
    }

    public static C4873x16c9cf2a create(LivenessCoreEducationalModule livenessCoreEducationalModule, Provider<BiometricConsentRepository> provider) {
        return new C4873x16c9cf2a(livenessCoreEducationalModule, provider);
    }

    public static IBiometricConsentRepository providesBiometricConsentRepository(LivenessCoreEducationalModule livenessCoreEducationalModule, BiometricConsentRepository biometricConsentRepository) {
        return (IBiometricConsentRepository) Preconditions.checkNotNullFromProvides(livenessCoreEducationalModule.providesBiometricConsentRepository(biometricConsentRepository));
    }

    @Override // javax.inject.Provider
    public IBiometricConsentRepository get() {
        return providesBiometricConsentRepository(this.module, this.repositoryImplProvider.get());
    }
}
