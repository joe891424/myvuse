package com.yoti.mobile.android.documentcapture.p055id.p056di;

import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.TextExtractionErrorViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.di.IdDocumentCaptureViewModelModule_ProvidesGenericTextExtractionErrorViewModelFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4618x55e7c974 implements Factory<ViewModel> {
    private final IdDocumentCaptureViewModelModule module;
    private final Provider<TextExtractionErrorViewModel> viewModelProvider;

    public C4618x55e7c974(IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule, Provider<TextExtractionErrorViewModel> provider) {
        this.module = idDocumentCaptureViewModelModule;
        this.viewModelProvider = provider;
    }

    public static C4618x55e7c974 create(IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule, Provider<TextExtractionErrorViewModel> provider) {
        return new C4618x55e7c974(idDocumentCaptureViewModelModule, provider);
    }

    public static ViewModel providesGenericTextExtractionErrorViewModel(IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule, TextExtractionErrorViewModel textExtractionErrorViewModel) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(idDocumentCaptureViewModelModule.providesGenericTextExtractionErrorViewModel(textExtractionErrorViewModel));
    }

    @Override // javax.inject.Provider
    public ViewModel get() {
        return providesGenericTextExtractionErrorViewModel(this.module, this.viewModelProvider.get());
    }
}
