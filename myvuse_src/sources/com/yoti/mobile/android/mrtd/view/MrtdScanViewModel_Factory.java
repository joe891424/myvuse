package com.yoti.mobile.android.mrtd.view;

import com.yoti.mobile.android.mrtd.domain.MrtdGetReadEventsUseCase;
import com.yoti.mobile.android.mrtd.domain.NfcEnabledInteractor;
import com.yoti.mobile.android.mrtd.domain.NfcStartListeningUseCase;
import com.yoti.mobile.android.mrtd.domain.NfcStopListeningUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class MrtdScanViewModel_Factory implements Factory<MrtdScanViewModel> {
    private final Provider<MrtdGetReadEventsUseCase> getReadEventsProvider;
    private final Provider<NfcEnabledInteractor> nfcEnabledInteractorProvider;
    private final Provider<NfcStartListeningUseCase> startListeningProvider;
    private final Provider<NfcStopListeningUseCase> stopListeningProvider;

    public MrtdScanViewModel_Factory(Provider<NfcEnabledInteractor> provider, Provider<NfcStartListeningUseCase> provider2, Provider<MrtdGetReadEventsUseCase> provider3, Provider<NfcStopListeningUseCase> provider4) {
        this.nfcEnabledInteractorProvider = provider;
        this.startListeningProvider = provider2;
        this.getReadEventsProvider = provider3;
        this.stopListeningProvider = provider4;
    }

    public static MrtdScanViewModel_Factory create(Provider<NfcEnabledInteractor> provider, Provider<NfcStartListeningUseCase> provider2, Provider<MrtdGetReadEventsUseCase> provider3, Provider<NfcStopListeningUseCase> provider4) {
        return new MrtdScanViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static MrtdScanViewModel newInstance(NfcEnabledInteractor nfcEnabledInteractor, NfcStartListeningUseCase nfcStartListeningUseCase, MrtdGetReadEventsUseCase mrtdGetReadEventsUseCase, NfcStopListeningUseCase nfcStopListeningUseCase) {
        return new MrtdScanViewModel(nfcEnabledInteractor, nfcStartListeningUseCase, mrtdGetReadEventsUseCase, nfcStopListeningUseCase);
    }

    @Override // javax.inject.Provider
    public MrtdScanViewModel get() {
        return newInstance(this.nfcEnabledInteractorProvider.get(), this.startListeningProvider.get(), this.getReadEventsProvider.get(), this.stopListeningProvider.get());
    }
}
