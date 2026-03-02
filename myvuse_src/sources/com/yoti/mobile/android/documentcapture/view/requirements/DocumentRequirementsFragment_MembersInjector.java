package com.yoti.mobile.android.documentcapture.view.requirements;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.p054di.ForDocumentRequirements;
import com.yoti.mobile.android.documentcapture.view.DocumentFailureTypeToErrorTagMapper;
import com.yoti.mobile.android.documentcapture.view.DocumentFeatureErrorTagToViewEventMapper;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentRequirementsFragment_MembersInjector implements MembersInjector<DocumentRequirementsFragment> {
    private final Provider<DocumentRequirementsCoordinator> coordinatorProvider;
    private final Provider<DocumentFeatureErrorTagToViewEventMapper> errorTagToViewEventMapperProvider;
    private final Provider<SavedStateViewModelFactory<DocumentRequirementsViewModel>> factoryProvider;
    private final Provider<DocumentFailureTypeToErrorTagMapper> failureTypeToErrorTagMapperProvider;

    public DocumentRequirementsFragment_MembersInjector(Provider<SavedStateViewModelFactory<DocumentRequirementsViewModel>> provider, Provider<DocumentRequirementsCoordinator> provider2, Provider<DocumentFailureTypeToErrorTagMapper> provider3, Provider<DocumentFeatureErrorTagToViewEventMapper> provider4) {
        this.factoryProvider = provider;
        this.coordinatorProvider = provider2;
        this.failureTypeToErrorTagMapperProvider = provider3;
        this.errorTagToViewEventMapperProvider = provider4;
    }

    public static MembersInjector<DocumentRequirementsFragment> create(Provider<SavedStateViewModelFactory<DocumentRequirementsViewModel>> provider, Provider<DocumentRequirementsCoordinator> provider2, Provider<DocumentFailureTypeToErrorTagMapper> provider3, Provider<DocumentFeatureErrorTagToViewEventMapper> provider4) {
        return new DocumentRequirementsFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    public static void injectCoordinator(DocumentRequirementsFragment documentRequirementsFragment, DocumentRequirementsCoordinator documentRequirementsCoordinator) {
        documentRequirementsFragment.coordinator = documentRequirementsCoordinator;
    }

    public static void injectErrorTagToViewEventMapper(DocumentRequirementsFragment documentRequirementsFragment, DocumentFeatureErrorTagToViewEventMapper documentFeatureErrorTagToViewEventMapper) {
        documentRequirementsFragment.errorTagToViewEventMapper = documentFeatureErrorTagToViewEventMapper;
    }

    @ForDocumentRequirements
    public static void injectFactory(DocumentRequirementsFragment documentRequirementsFragment, SavedStateViewModelFactory<DocumentRequirementsViewModel> savedStateViewModelFactory) {
        documentRequirementsFragment.factory = savedStateViewModelFactory;
    }

    public static void injectFailureTypeToErrorTagMapper(DocumentRequirementsFragment documentRequirementsFragment, DocumentFailureTypeToErrorTagMapper documentFailureTypeToErrorTagMapper) {
        documentRequirementsFragment.failureTypeToErrorTagMapper = documentFailureTypeToErrorTagMapper;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(DocumentRequirementsFragment documentRequirementsFragment) {
        injectFactory(documentRequirementsFragment, this.factoryProvider.get());
        injectCoordinator(documentRequirementsFragment, this.coordinatorProvider.get());
        injectFailureTypeToErrorTagMapper(documentRequirementsFragment, this.failureTypeToErrorTagMapperProvider.get());
        injectErrorTagToViewEventMapper(documentRequirementsFragment, this.errorTagToViewEventMapperProvider.get());
    }
}
