package com.yoti.mobile.android.documentcapture.view.selection;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.p054di.ForDocumentSelection;
import com.yoti.mobile.android.documentcapture.view.DocumentFailureTypeToErrorTagMapper;
import com.yoti.mobile.android.documentcapture.view.DocumentFeatureErrorTagToViewEventMapper;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentSelectionFragment_MembersInjector implements MembersInjector<DocumentSelectionFragment> {
    private final Provider<DocumentSelectionCoordinator> coordinatorProvider;
    private final Provider<DocumentsAdapter> documentsAdapterProvider;
    private final Provider<DocumentFeatureErrorTagToViewEventMapper> errorTagToViewEventMapperProvider;
    private final Provider<SavedStateViewModelFactory<DocumentSelectionViewModel>> factoryProvider;
    private final Provider<DocumentFailureTypeToErrorTagMapper> failureTypeToErrorTagMapperProvider;

    public DocumentSelectionFragment_MembersInjector(Provider<DocumentsAdapter> provider, Provider<DocumentSelectionCoordinator> provider2, Provider<DocumentFailureTypeToErrorTagMapper> provider3, Provider<DocumentFeatureErrorTagToViewEventMapper> provider4, Provider<SavedStateViewModelFactory<DocumentSelectionViewModel>> provider5) {
        this.documentsAdapterProvider = provider;
        this.coordinatorProvider = provider2;
        this.failureTypeToErrorTagMapperProvider = provider3;
        this.errorTagToViewEventMapperProvider = provider4;
        this.factoryProvider = provider5;
    }

    public static MembersInjector<DocumentSelectionFragment> create(Provider<DocumentsAdapter> provider, Provider<DocumentSelectionCoordinator> provider2, Provider<DocumentFailureTypeToErrorTagMapper> provider3, Provider<DocumentFeatureErrorTagToViewEventMapper> provider4, Provider<SavedStateViewModelFactory<DocumentSelectionViewModel>> provider5) {
        return new DocumentSelectionFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    public static void injectCoordinator(DocumentSelectionFragment documentSelectionFragment, DocumentSelectionCoordinator documentSelectionCoordinator) {
        documentSelectionFragment.coordinator = documentSelectionCoordinator;
    }

    public static void injectDocumentsAdapter(DocumentSelectionFragment documentSelectionFragment, DocumentsAdapter documentsAdapter) {
        documentSelectionFragment.documentsAdapter = documentsAdapter;
    }

    public static void injectErrorTagToViewEventMapper(DocumentSelectionFragment documentSelectionFragment, DocumentFeatureErrorTagToViewEventMapper documentFeatureErrorTagToViewEventMapper) {
        documentSelectionFragment.errorTagToViewEventMapper = documentFeatureErrorTagToViewEventMapper;
    }

    @ForDocumentSelection
    public static void injectFactory(DocumentSelectionFragment documentSelectionFragment, SavedStateViewModelFactory<DocumentSelectionViewModel> savedStateViewModelFactory) {
        documentSelectionFragment.factory = savedStateViewModelFactory;
    }

    public static void injectFailureTypeToErrorTagMapper(DocumentSelectionFragment documentSelectionFragment, DocumentFailureTypeToErrorTagMapper documentFailureTypeToErrorTagMapper) {
        documentSelectionFragment.failureTypeToErrorTagMapper = documentFailureTypeToErrorTagMapper;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(DocumentSelectionFragment documentSelectionFragment) {
        injectDocumentsAdapter(documentSelectionFragment, this.documentsAdapterProvider.get());
        injectCoordinator(documentSelectionFragment, this.coordinatorProvider.get());
        injectFailureTypeToErrorTagMapper(documentSelectionFragment, this.failureTypeToErrorTagMapperProvider.get());
        injectErrorTagToViewEventMapper(documentSelectionFragment, this.errorTagToViewEventMapperProvider.get());
        injectFactory(documentSelectionFragment, this.factoryProvider.get());
    }
}
