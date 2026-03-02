package com.yoti.mobile.android.documentcapture.p055id.p056di;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.PageScanReviewViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.di.IdDocumentCaptureViewModelModule_ProvidesSavedStateViewModelFactoryForDocumentReviewFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4622x7ac1aaf implements Factory<SavedStateViewModelFactory<PageScanReviewViewModel>> {
    private final IdDocumentCaptureViewModelModule module;
    private final Provider<SavedStateHandleHolderViewModelFactoryProvider> savedStateViewModelFactoryProvider;

    public C4622x7ac1aaf(IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider) {
        this.module = idDocumentCaptureViewModelModule;
        this.savedStateViewModelFactoryProvider = provider;
    }

    public static C4622x7ac1aaf create(IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider) {
        return new C4622x7ac1aaf(idDocumentCaptureViewModelModule, provider);
    }

    public static SavedStateViewModelFactory<PageScanReviewViewModel> providesSavedStateViewModelFactoryForDocumentReview(IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule, SavedStateHandleHolderViewModelFactoryProvider savedStateHandleHolderViewModelFactoryProvider) {
        return (SavedStateViewModelFactory) Preconditions.checkNotNullFromProvides(idDocumentCaptureViewModelModule.providesSavedStateViewModelFactoryForDocumentReview(savedStateHandleHolderViewModelFactoryProvider));
    }

    @Override // javax.inject.Provider
    public SavedStateViewModelFactory<PageScanReviewViewModel> get() {
        return providesSavedStateViewModelFactoryForDocumentReview(this.module, this.savedStateViewModelFactoryProvider.get());
    }
}
