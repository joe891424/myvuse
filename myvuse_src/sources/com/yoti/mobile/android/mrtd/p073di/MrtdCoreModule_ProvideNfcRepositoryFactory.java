package com.yoti.mobile.android.mrtd.p073di;

import com.yoti.mobile.android.mrtd.data.NfcStateRepository;
import com.yoti.mobile.android.mrtd.domain.INfcStateRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class MrtdCoreModule_ProvideNfcRepositoryFactory implements Factory<INfcStateRepository> {
    private final Provider<NfcStateRepository> actualProvider;
    private final MrtdCoreModule module;

    public MrtdCoreModule_ProvideNfcRepositoryFactory(MrtdCoreModule mrtdCoreModule, Provider<NfcStateRepository> provider) {
        this.module = mrtdCoreModule;
        this.actualProvider = provider;
    }

    public static MrtdCoreModule_ProvideNfcRepositoryFactory create(MrtdCoreModule mrtdCoreModule, Provider<NfcStateRepository> provider) {
        return new MrtdCoreModule_ProvideNfcRepositoryFactory(mrtdCoreModule, provider);
    }

    public static INfcStateRepository provideNfcRepository(MrtdCoreModule mrtdCoreModule, NfcStateRepository nfcStateRepository) {
        return (INfcStateRepository) Preconditions.checkNotNullFromProvides(mrtdCoreModule.provideNfcRepository(nfcStateRepository));
    }

    @Override // javax.inject.Provider
    public INfcStateRepository get() {
        return provideNfcRepository(this.module, this.actualProvider.get());
    }
}
