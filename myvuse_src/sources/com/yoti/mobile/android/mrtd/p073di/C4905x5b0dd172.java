package com.yoti.mobile.android.mrtd.p073di;

import com.yoti.mobile.android.mrtd.domain.INfcDispatcher;
import com.yoti.mobile.android.mrtd.domain.NfcDispatcher;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.mrtd.di.MrtdCoreModule_ProvideNfcDispatcher$mrtd_productionReleaseFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4905x5b0dd172 implements Factory<INfcDispatcher> {
    private final Provider<NfcDispatcher> dispatcherProvider;
    private final MrtdCoreModule module;

    public C4905x5b0dd172(MrtdCoreModule mrtdCoreModule, Provider<NfcDispatcher> provider) {
        this.module = mrtdCoreModule;
        this.dispatcherProvider = provider;
    }

    public static C4905x5b0dd172 create(MrtdCoreModule mrtdCoreModule, Provider<NfcDispatcher> provider) {
        return new C4905x5b0dd172(mrtdCoreModule, provider);
    }

    public static INfcDispatcher provideNfcDispatcher$mrtd_productionRelease(MrtdCoreModule mrtdCoreModule, NfcDispatcher nfcDispatcher) {
        return (INfcDispatcher) Preconditions.checkNotNullFromProvides(mrtdCoreModule.provideNfcDispatcher$mrtd_productionRelease(nfcDispatcher));
    }

    @Override // javax.inject.Provider
    public INfcDispatcher get() {
        return provideNfcDispatcher$mrtd_productionRelease(this.module, this.dispatcherProvider.get());
    }
}
