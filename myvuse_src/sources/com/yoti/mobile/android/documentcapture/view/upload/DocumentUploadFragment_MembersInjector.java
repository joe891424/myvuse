package com.yoti.mobile.android.documentcapture.view.upload;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.p054di.ForDocumentUpload;
import com.yoti.mobile.android.documentcapture.view.navigation.IUploadNavigatorProvider;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentUploadFragment_MembersInjector implements MembersInjector<DocumentUploadFragment> {
    private final Provider<IUploadNavigatorProvider<IDocumentViewData>> uploadNavigationProvider;
    private final Provider<SavedStateViewModelFactory<DocumentUploadViewModel>> viewModelFactoryProvider;

    public DocumentUploadFragment_MembersInjector(Provider<SavedStateViewModelFactory<DocumentUploadViewModel>> provider, Provider<IUploadNavigatorProvider<IDocumentViewData>> provider2) {
        this.viewModelFactoryProvider = provider;
        this.uploadNavigationProvider = provider2;
    }

    public static MembersInjector<DocumentUploadFragment> create(Provider<SavedStateViewModelFactory<DocumentUploadViewModel>> provider, Provider<IUploadNavigatorProvider<IDocumentViewData>> provider2) {
        return new DocumentUploadFragment_MembersInjector(provider, provider2);
    }

    public static void injectUploadNavigationProvider(DocumentUploadFragment documentUploadFragment, IUploadNavigatorProvider<IDocumentViewData> iUploadNavigatorProvider) {
        documentUploadFragment.uploadNavigationProvider = iUploadNavigatorProvider;
    }

    @ForDocumentUpload
    public static void injectViewModelFactory(DocumentUploadFragment documentUploadFragment, SavedStateViewModelFactory<DocumentUploadViewModel> savedStateViewModelFactory) {
        documentUploadFragment.viewModelFactory = savedStateViewModelFactory;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(DocumentUploadFragment documentUploadFragment) {
        injectViewModelFactory(documentUploadFragment, this.viewModelFactoryProvider.get());
        injectUploadNavigationProvider(documentUploadFragment, this.uploadNavigationProvider.get());
    }
}
