package com.yoti.mobile.android.documentcapture.view.educational;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.p054di.ForDocumentEducational;
import com.yoti.mobile.android.documentcapture.view.DocumentFailureTypeToErrorTagMapper;
import com.yoti.mobile.android.documentcapture.view.DocumentFeatureErrorTagToViewEventMapper;
import com.yoti.mobile.android.documentcapture.view.navigation.DocumentNavigationCoordinatorHelper;
import com.yoti.mobile.android.documentcapture.view.selection.ObjectiveRequirementsAdapter;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentEducationalFragment_MembersInjector implements MembersInjector<DocumentEducationalFragment> {
    private final Provider<DocumentNavigationCoordinatorHelper> coordinatorProvider;
    private final Provider<DocumentFeatureErrorTagToViewEventMapper> errorTagToViewEventMapperProvider;
    private final Provider<SavedStateViewModelFactory<DocumentEducationalViewModel>> factoryProvider;
    private final Provider<DocumentFailureTypeToErrorTagMapper> failureTypeToErrorTagMapperProvider;
    private final Provider<ObjectiveRequirementsAdapter> objRequirementsAdapterProvider;

    public DocumentEducationalFragment_MembersInjector(Provider<ObjectiveRequirementsAdapter> provider, Provider<SavedStateViewModelFactory<DocumentEducationalViewModel>> provider2, Provider<DocumentNavigationCoordinatorHelper> provider3, Provider<DocumentFailureTypeToErrorTagMapper> provider4, Provider<DocumentFeatureErrorTagToViewEventMapper> provider5) {
        this.objRequirementsAdapterProvider = provider;
        this.factoryProvider = provider2;
        this.coordinatorProvider = provider3;
        this.failureTypeToErrorTagMapperProvider = provider4;
        this.errorTagToViewEventMapperProvider = provider5;
    }

    public static MembersInjector<DocumentEducationalFragment> create(Provider<ObjectiveRequirementsAdapter> provider, Provider<SavedStateViewModelFactory<DocumentEducationalViewModel>> provider2, Provider<DocumentNavigationCoordinatorHelper> provider3, Provider<DocumentFailureTypeToErrorTagMapper> provider4, Provider<DocumentFeatureErrorTagToViewEventMapper> provider5) {
        return new DocumentEducationalFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    public static void injectCoordinator(DocumentEducationalFragment documentEducationalFragment, DocumentNavigationCoordinatorHelper documentNavigationCoordinatorHelper) {
        documentEducationalFragment.coordinator = documentNavigationCoordinatorHelper;
    }

    public static void injectErrorTagToViewEventMapper(DocumentEducationalFragment documentEducationalFragment, DocumentFeatureErrorTagToViewEventMapper documentFeatureErrorTagToViewEventMapper) {
        documentEducationalFragment.errorTagToViewEventMapper = documentFeatureErrorTagToViewEventMapper;
    }

    @ForDocumentEducational
    public static void injectFactory(DocumentEducationalFragment documentEducationalFragment, SavedStateViewModelFactory<DocumentEducationalViewModel> savedStateViewModelFactory) {
        documentEducationalFragment.factory = savedStateViewModelFactory;
    }

    public static void injectFailureTypeToErrorTagMapper(DocumentEducationalFragment documentEducationalFragment, DocumentFailureTypeToErrorTagMapper documentFailureTypeToErrorTagMapper) {
        documentEducationalFragment.failureTypeToErrorTagMapper = documentFailureTypeToErrorTagMapper;
    }

    public static void injectObjRequirementsAdapter(DocumentEducationalFragment documentEducationalFragment, ObjectiveRequirementsAdapter objectiveRequirementsAdapter) {
        documentEducationalFragment.objRequirementsAdapter = objectiveRequirementsAdapter;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(DocumentEducationalFragment documentEducationalFragment) {
        injectObjRequirementsAdapter(documentEducationalFragment, this.objRequirementsAdapterProvider.get());
        injectFactory(documentEducationalFragment, this.factoryProvider.get());
        injectCoordinator(documentEducationalFragment, this.coordinatorProvider.get());
        injectFailureTypeToErrorTagMapper(documentEducationalFragment, this.failureTypeToErrorTagMapperProvider.get());
        injectErrorTagToViewEventMapper(documentEducationalFragment, this.errorTagToViewEventMapperProvider.get());
    }
}
