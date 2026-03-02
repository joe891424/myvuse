package com.yoti.mobile.android.mrtd.p073di;

import com.yoti.mobile.android.mrtd.domain.INfcTagProcessor;
import com.yoti.mobile.android.mrtd.domain.NfcTagProcessor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.mrtd.di.MrtdCoreModule_ProvidesNfcTagProcessor$mrtd_productionReleaseFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4906x5fe47894 implements Factory<INfcTagProcessor> {
    private final MrtdCoreModule module;
    private final Provider<NfcTagProcessor> processorProvider;

    public C4906x5fe47894(MrtdCoreModule mrtdCoreModule, Provider<NfcTagProcessor> provider) {
        this.module = mrtdCoreModule;
        this.processorProvider = provider;
    }

    public static C4906x5fe47894 create(MrtdCoreModule mrtdCoreModule, Provider<NfcTagProcessor> provider) {
        return new C4906x5fe47894(mrtdCoreModule, provider);
    }

    public static INfcTagProcessor providesNfcTagProcessor$mrtd_productionRelease(MrtdCoreModule mrtdCoreModule, NfcTagProcessor nfcTagProcessor) {
        return (INfcTagProcessor) Preconditions.checkNotNullFromProvides(mrtdCoreModule.providesNfcTagProcessor$mrtd_productionRelease(nfcTagProcessor));
    }

    @Override // javax.inject.Provider
    public INfcTagProcessor get() {
        return providesNfcTagProcessor$mrtd_productionRelease(this.module, this.processorProvider.get());
    }
}
