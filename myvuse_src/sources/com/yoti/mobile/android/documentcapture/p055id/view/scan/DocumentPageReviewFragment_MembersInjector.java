package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.p055id.p056di.ForDocumentReview;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentPageReviewFragment_MembersInjector implements MembersInjector<DocumentPageReviewFragment> {
    private final Provider<DocumentImageLoader> documentImageLoaderProvider;
    private final Provider<SavedStateViewModelFactory<PageScanReviewViewModel>> viewModelFactoryProvider;

    public DocumentPageReviewFragment_MembersInjector(Provider<SavedStateViewModelFactory<PageScanReviewViewModel>> provider, Provider<DocumentImageLoader> provider2) {
        this.viewModelFactoryProvider = provider;
        this.documentImageLoaderProvider = provider2;
    }

    public static MembersInjector<DocumentPageReviewFragment> create(Provider<SavedStateViewModelFactory<PageScanReviewViewModel>> provider, Provider<DocumentImageLoader> provider2) {
        return new DocumentPageReviewFragment_MembersInjector(provider, provider2);
    }

    public static void injectDocumentImageLoader(DocumentPageReviewFragment documentPageReviewFragment, DocumentImageLoader documentImageLoader) {
        documentPageReviewFragment.documentImageLoader = documentImageLoader;
    }

    @ForDocumentReview
    public static void injectViewModelFactory(DocumentPageReviewFragment documentPageReviewFragment, SavedStateViewModelFactory<PageScanReviewViewModel> savedStateViewModelFactory) {
        documentPageReviewFragment.viewModelFactory = savedStateViewModelFactory;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(DocumentPageReviewFragment documentPageReviewFragment) {
        injectViewModelFactory(documentPageReviewFragment, this.viewModelFactoryProvider.get());
        injectDocumentImageLoader(documentPageReviewFragment, this.documentImageLoaderProvider.get());
    }
}
