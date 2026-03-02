package com.yoti.mobile.android.documentcapture.sup.view.scan;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.sup.p057di.ForDocumentScan;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentGuidelinesFragment_MembersInjector implements MembersInjector<DocumentGuidelinesFragment> {
    private final Provider<SavedStateViewModelFactory<SupDocumentScanViewModel>> viewModelFactoryProvider;

    public DocumentGuidelinesFragment_MembersInjector(Provider<SavedStateViewModelFactory<SupDocumentScanViewModel>> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<DocumentGuidelinesFragment> create(Provider<SavedStateViewModelFactory<SupDocumentScanViewModel>> provider) {
        return new DocumentGuidelinesFragment_MembersInjector(provider);
    }

    @ForDocumentScan
    public static void injectViewModelFactory(DocumentGuidelinesFragment documentGuidelinesFragment, SavedStateViewModelFactory<SupDocumentScanViewModel> savedStateViewModelFactory) {
        documentGuidelinesFragment.viewModelFactory = savedStateViewModelFactory;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(DocumentGuidelinesFragment documentGuidelinesFragment) {
        injectViewModelFactory(documentGuidelinesFragment, this.viewModelFactoryProvider.get());
    }
}
