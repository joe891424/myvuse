package com.yoti.mobile.android.documentcapture.p055id.p056di;

import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.di.IdDocumentCaptureViewModelModule_ProvidesScanConfigurationViewModelFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4623xf6e2250e implements Factory<ViewModel> {
    private final IdDocumentCaptureViewModelModule module;
    private final Provider<DocumentScanViewModel> viewModelProvider;

    public C4623xf6e2250e(IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule, Provider<DocumentScanViewModel> provider) {
        this.module = idDocumentCaptureViewModelModule;
        this.viewModelProvider = provider;
    }

    public static C4623xf6e2250e create(IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule, Provider<DocumentScanViewModel> provider) {
        return new C4623xf6e2250e(idDocumentCaptureViewModelModule, provider);
    }

    public static ViewModel providesScanConfigurationViewModel(IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule, DocumentScanViewModel documentScanViewModel) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(idDocumentCaptureViewModelModule.providesScanConfigurationViewModel(documentScanViewModel));
    }

    @Override // javax.inject.Provider
    public ViewModel get() {
        return providesScanConfigurationViewModel(this.module, this.viewModelProvider.get());
    }
}
