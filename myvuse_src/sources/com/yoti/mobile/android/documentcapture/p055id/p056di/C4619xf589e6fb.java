package com.yoti.mobile.android.documentcapture.p055id.p056di;

import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.PageScanReviewViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.di.IdDocumentCaptureViewModelModule_ProvidesPageScanReviewViewModelFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4619xf589e6fb implements Factory<ViewModel> {
    private final IdDocumentCaptureViewModelModule module;
    private final Provider<PageScanReviewViewModel> viewModelProvider;

    public C4619xf589e6fb(IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule, Provider<PageScanReviewViewModel> provider) {
        this.module = idDocumentCaptureViewModelModule;
        this.viewModelProvider = provider;
    }

    public static C4619xf589e6fb create(IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule, Provider<PageScanReviewViewModel> provider) {
        return new C4619xf589e6fb(idDocumentCaptureViewModelModule, provider);
    }

    public static ViewModel providesPageScanReviewViewModel(IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule, PageScanReviewViewModel pageScanReviewViewModel) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(idDocumentCaptureViewModelModule.providesPageScanReviewViewModel(pageScanReviewViewModel));
    }

    @Override // javax.inject.Provider
    public ViewModel get() {
        return providesPageScanReviewViewModel(this.module, this.viewModelProvider.get());
    }
}
