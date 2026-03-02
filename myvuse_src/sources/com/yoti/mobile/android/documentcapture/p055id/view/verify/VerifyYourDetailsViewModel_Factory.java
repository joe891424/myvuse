package com.yoti.mobile.android.documentcapture.p055id.view.verify;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class VerifyYourDetailsViewModel_Factory implements Factory<VerifyYourDetailsViewModel> {
    private final Provider<DocumentScanResultViewDataToBacCredentialMapper> bacCredentialMapperProvider;

    public VerifyYourDetailsViewModel_Factory(Provider<DocumentScanResultViewDataToBacCredentialMapper> provider) {
        this.bacCredentialMapperProvider = provider;
    }

    public static VerifyYourDetailsViewModel_Factory create(Provider<DocumentScanResultViewDataToBacCredentialMapper> provider) {
        return new VerifyYourDetailsViewModel_Factory(provider);
    }

    public static VerifyYourDetailsViewModel newInstance(DocumentScanResultViewDataToBacCredentialMapper documentScanResultViewDataToBacCredentialMapper) {
        return new VerifyYourDetailsViewModel(documentScanResultViewDataToBacCredentialMapper);
    }

    @Override // javax.inject.Provider
    public VerifyYourDetailsViewModel get() {
        return newInstance(this.bacCredentialMapperProvider.get());
    }
}
