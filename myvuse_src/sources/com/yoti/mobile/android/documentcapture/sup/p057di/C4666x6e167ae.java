package com.yoti.mobile.android.documentcapture.sup.p057di;

import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.documentcapture.sup.view.scan.SupDocumentScanViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.sup.di.SupDocumentCaptureViewModelModule_ProvidesSupDocumentScanViewModelFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4666x6e167ae implements Factory<ViewModel> {
    private final SupDocumentCaptureViewModelModule module;
    private final Provider<SupDocumentScanViewModel> viewModelProvider;

    public C4666x6e167ae(SupDocumentCaptureViewModelModule supDocumentCaptureViewModelModule, Provider<SupDocumentScanViewModel> provider) {
        this.module = supDocumentCaptureViewModelModule;
        this.viewModelProvider = provider;
    }

    public static C4666x6e167ae create(SupDocumentCaptureViewModelModule supDocumentCaptureViewModelModule, Provider<SupDocumentScanViewModel> provider) {
        return new C4666x6e167ae(supDocumentCaptureViewModelModule, provider);
    }

    public static ViewModel providesSupDocumentScanViewModel(SupDocumentCaptureViewModelModule supDocumentCaptureViewModelModule, SupDocumentScanViewModel supDocumentScanViewModel) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(supDocumentCaptureViewModelModule.providesSupDocumentScanViewModel(supDocumentScanViewModel));
    }

    @Override // javax.inject.Provider
    public ViewModel get() {
        return providesSupDocumentScanViewModel(this.module, this.viewModelProvider.get());
    }
}
