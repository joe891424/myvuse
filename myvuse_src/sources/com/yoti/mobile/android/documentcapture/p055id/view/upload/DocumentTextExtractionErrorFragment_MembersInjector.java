package com.yoti.mobile.android.documentcapture.p055id.view.upload;

import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import com.yoti.mobile.android.documentcapture.p055id.view.navigation.IdDocumentUploadNavigatorProvider;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentTextExtractionErrorFragment_MembersInjector implements MembersInjector<DocumentTextExtractionErrorFragment> {
    private final Provider<IdDocumentUploadNavigatorProvider> navigatorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;

    public DocumentTextExtractionErrorFragment_MembersInjector(Provider<ViewModelFactory> provider, Provider<IdDocumentUploadNavigatorProvider> provider2) {
        this.viewModelFactoryProvider = provider;
        this.navigatorProvider = provider2;
    }

    public static MembersInjector<DocumentTextExtractionErrorFragment> create(Provider<ViewModelFactory> provider, Provider<IdDocumentUploadNavigatorProvider> provider2) {
        return new DocumentTextExtractionErrorFragment_MembersInjector(provider, provider2);
    }

    public static void injectNavigatorProvider(DocumentTextExtractionErrorFragment documentTextExtractionErrorFragment, IdDocumentUploadNavigatorProvider idDocumentUploadNavigatorProvider) {
        documentTextExtractionErrorFragment.navigatorProvider = idDocumentUploadNavigatorProvider;
    }

    public static void injectViewModelFactory(DocumentTextExtractionErrorFragment documentTextExtractionErrorFragment, ViewModelFactory viewModelFactory) {
        documentTextExtractionErrorFragment.viewModelFactory = viewModelFactory;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(DocumentTextExtractionErrorFragment documentTextExtractionErrorFragment) {
        injectViewModelFactory(documentTextExtractionErrorFragment, this.viewModelFactoryProvider.get());
        injectNavigatorProvider(documentTextExtractionErrorFragment, this.navigatorProvider.get());
    }
}
