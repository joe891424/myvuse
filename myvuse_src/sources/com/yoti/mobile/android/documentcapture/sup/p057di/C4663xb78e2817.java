package com.yoti.mobile.android.documentcapture.sup.p057di;

import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.sup.di.SupDocumentCaptureViewModelModule_ProvidesDocumentReviewViewModelFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4663xb78e2817 implements Factory<ViewModel> {
    private final SupDocumentCaptureViewModelModule module;
    private final Provider<DocumentReviewViewModel> viewModelProvider;

    public C4663xb78e2817(SupDocumentCaptureViewModelModule supDocumentCaptureViewModelModule, Provider<DocumentReviewViewModel> provider) {
        this.module = supDocumentCaptureViewModelModule;
        this.viewModelProvider = provider;
    }

    public static C4663xb78e2817 create(SupDocumentCaptureViewModelModule supDocumentCaptureViewModelModule, Provider<DocumentReviewViewModel> provider) {
        return new C4663xb78e2817(supDocumentCaptureViewModelModule, provider);
    }

    public static ViewModel providesDocumentReviewViewModel(SupDocumentCaptureViewModelModule supDocumentCaptureViewModelModule, DocumentReviewViewModel documentReviewViewModel) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(supDocumentCaptureViewModelModule.providesDocumentReviewViewModel(documentReviewViewModel));
    }

    @Override // javax.inject.Provider
    public ViewModel get() {
        return providesDocumentReviewViewModel(this.module, this.viewModelProvider.get());
    }
}
