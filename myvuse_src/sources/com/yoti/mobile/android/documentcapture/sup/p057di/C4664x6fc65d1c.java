package com.yoti.mobile.android.documentcapture.sup.p057di;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.sup.di.SupDocumentCaptureViewModelModule_ProvidesSavedStateViewModelFactoryForDocumentReviewFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4664x6fc65d1c implements Factory<SavedStateViewModelFactory<DocumentReviewViewModel>> {
    private final SupDocumentCaptureViewModelModule module;
    private final Provider<SavedStateHandleHolderViewModelFactoryProvider> savedStateViewModelFactoryProvider;

    public C4664x6fc65d1c(SupDocumentCaptureViewModelModule supDocumentCaptureViewModelModule, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider) {
        this.module = supDocumentCaptureViewModelModule;
        this.savedStateViewModelFactoryProvider = provider;
    }

    public static C4664x6fc65d1c create(SupDocumentCaptureViewModelModule supDocumentCaptureViewModelModule, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider) {
        return new C4664x6fc65d1c(supDocumentCaptureViewModelModule, provider);
    }

    public static SavedStateViewModelFactory<DocumentReviewViewModel> providesSavedStateViewModelFactoryForDocumentReview(SupDocumentCaptureViewModelModule supDocumentCaptureViewModelModule, SavedStateHandleHolderViewModelFactoryProvider savedStateHandleHolderViewModelFactoryProvider) {
        return (SavedStateViewModelFactory) Preconditions.checkNotNullFromProvides(supDocumentCaptureViewModelModule.providesSavedStateViewModelFactoryForDocumentReview(savedStateHandleHolderViewModelFactoryProvider));
    }

    @Override // javax.inject.Provider
    public SavedStateViewModelFactory<DocumentReviewViewModel> get() {
        return providesSavedStateViewModelFactoryForDocumentReview(this.module, this.savedStateViewModelFactoryProvider.get());
    }
}
