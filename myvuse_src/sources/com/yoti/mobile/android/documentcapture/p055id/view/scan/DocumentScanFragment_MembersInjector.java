package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.p055id.p056di.ForDocumentCapture;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentScanFragment_MembersInjector implements MembersInjector<DocumentScanFragment> {
    private final Provider<IScanFragmentFactoryWrapper> scanFragmentFactoryProvider;
    private final Provider<SavedStateViewModelFactory<DocumentScanViewModel>> viewModelFactoryProvider;

    public DocumentScanFragment_MembersInjector(Provider<SavedStateViewModelFactory<DocumentScanViewModel>> provider, Provider<IScanFragmentFactoryWrapper> provider2) {
        this.viewModelFactoryProvider = provider;
        this.scanFragmentFactoryProvider = provider2;
    }

    public static MembersInjector<DocumentScanFragment> create(Provider<SavedStateViewModelFactory<DocumentScanViewModel>> provider, Provider<IScanFragmentFactoryWrapper> provider2) {
        return new DocumentScanFragment_MembersInjector(provider, provider2);
    }

    public static void injectScanFragmentFactory(DocumentScanFragment documentScanFragment, IScanFragmentFactoryWrapper iScanFragmentFactoryWrapper) {
        documentScanFragment.scanFragmentFactory = iScanFragmentFactoryWrapper;
    }

    @ForDocumentCapture
    public static void injectViewModelFactory(DocumentScanFragment documentScanFragment, SavedStateViewModelFactory<DocumentScanViewModel> savedStateViewModelFactory) {
        documentScanFragment.viewModelFactory = savedStateViewModelFactory;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(DocumentScanFragment documentScanFragment) {
        injectViewModelFactory(documentScanFragment, this.viewModelFactoryProvider.get());
        injectScanFragmentFactory(documentScanFragment, this.scanFragmentFactoryProvider.get());
    }
}
