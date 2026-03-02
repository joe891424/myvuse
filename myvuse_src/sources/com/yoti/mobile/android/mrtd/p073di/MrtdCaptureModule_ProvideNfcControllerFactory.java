package com.yoti.mobile.android.mrtd.p073di;

import com.yoti.mobile.android.mrtd.data.NfcPlatformController;
import com.yoti.mobile.android.mrtd.domain.INfcReadController;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class MrtdCaptureModule_ProvideNfcControllerFactory implements Factory<INfcReadController> {
    private final Provider<NfcPlatformController> actualProvider;
    private final MrtdCaptureModule module;

    public MrtdCaptureModule_ProvideNfcControllerFactory(MrtdCaptureModule mrtdCaptureModule, Provider<NfcPlatformController> provider) {
        this.module = mrtdCaptureModule;
        this.actualProvider = provider;
    }

    public static MrtdCaptureModule_ProvideNfcControllerFactory create(MrtdCaptureModule mrtdCaptureModule, Provider<NfcPlatformController> provider) {
        return new MrtdCaptureModule_ProvideNfcControllerFactory(mrtdCaptureModule, provider);
    }

    public static INfcReadController provideNfcController(MrtdCaptureModule mrtdCaptureModule, NfcPlatformController nfcPlatformController) {
        return (INfcReadController) Preconditions.checkNotNullFromProvides(mrtdCaptureModule.provideNfcController(nfcPlatformController));
    }

    @Override // javax.inject.Provider
    public INfcReadController get() {
        return provideNfcController(this.module, this.actualProvider.get());
    }
}
