package com.yoti.mobile.android.documentcapture.view.upload;

import com.yoti.mobile.android.documentcapture.view.navigation.IUploadNavigatorProvider;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentUploadErrorFragment_MembersInjector implements MembersInjector<DocumentUploadErrorFragment> {
    private final Provider<IUploadNavigatorProvider<IDocumentViewData>> navigatorProvider;

    public DocumentUploadErrorFragment_MembersInjector(Provider<IUploadNavigatorProvider<IDocumentViewData>> provider) {
        this.navigatorProvider = provider;
    }

    public static MembersInjector<DocumentUploadErrorFragment> create(Provider<IUploadNavigatorProvider<IDocumentViewData>> provider) {
        return new DocumentUploadErrorFragment_MembersInjector(provider);
    }

    public static void injectNavigatorProvider(DocumentUploadErrorFragment documentUploadErrorFragment, IUploadNavigatorProvider<IDocumentViewData> iUploadNavigatorProvider) {
        documentUploadErrorFragment.navigatorProvider = iUploadNavigatorProvider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(DocumentUploadErrorFragment documentUploadErrorFragment) {
        injectNavigatorProvider(documentUploadErrorFragment, this.navigatorProvider.get());
    }
}
