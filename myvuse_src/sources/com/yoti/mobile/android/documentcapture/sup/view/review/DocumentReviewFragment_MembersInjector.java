package com.yoti.mobile.android.documentcapture.sup.view.review;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.sup.p057di.ForDocumentReview;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentReviewFragment_MembersInjector implements MembersInjector<DocumentReviewFragment> {
    private final Provider<SavedStateViewModelFactory<DocumentReviewViewModel>> viewModelFactoryProvider;

    public DocumentReviewFragment_MembersInjector(Provider<SavedStateViewModelFactory<DocumentReviewViewModel>> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<DocumentReviewFragment> create(Provider<SavedStateViewModelFactory<DocumentReviewViewModel>> provider) {
        return new DocumentReviewFragment_MembersInjector(provider);
    }

    @ForDocumentReview
    public static void injectViewModelFactory(DocumentReviewFragment documentReviewFragment, SavedStateViewModelFactory<DocumentReviewViewModel> savedStateViewModelFactory) {
        documentReviewFragment.viewModelFactory = savedStateViewModelFactory;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(DocumentReviewFragment documentReviewFragment) {
        injectViewModelFactory(documentReviewFragment, this.viewModelFactoryProvider.get());
    }
}
