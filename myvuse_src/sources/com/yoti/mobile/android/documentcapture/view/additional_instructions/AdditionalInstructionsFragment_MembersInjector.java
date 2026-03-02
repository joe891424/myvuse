package com.yoti.mobile.android.documentcapture.view.additional_instructions;

import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import com.yoti.mobile.android.documentcapture.view.DocumentFailureTypeToErrorTagMapper;
import com.yoti.mobile.android.documentcapture.view.DocumentFeatureErrorTagToViewEventMapper;
import com.yoti.mobile.android.documentcapture.view.additional_instructions.navigation.AdditionalInstructionsCoordinator;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class AdditionalInstructionsFragment_MembersInjector implements MembersInjector<AdditionalInstructionsFragment> {
    private final Provider<AdditionalInstructionsCoordinator> coordinatorProvider;
    private final Provider<DocumentFeatureErrorTagToViewEventMapper> errorTagToViewEventMapperProvider;
    private final Provider<DocumentFailureTypeToErrorTagMapper> failureTypeToErrorTagMapperProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;

    public AdditionalInstructionsFragment_MembersInjector(Provider<ViewModelFactory> provider, Provider<AdditionalInstructionsCoordinator> provider2, Provider<DocumentFailureTypeToErrorTagMapper> provider3, Provider<DocumentFeatureErrorTagToViewEventMapper> provider4) {
        this.viewModelFactoryProvider = provider;
        this.coordinatorProvider = provider2;
        this.failureTypeToErrorTagMapperProvider = provider3;
        this.errorTagToViewEventMapperProvider = provider4;
    }

    public static MembersInjector<AdditionalInstructionsFragment> create(Provider<ViewModelFactory> provider, Provider<AdditionalInstructionsCoordinator> provider2, Provider<DocumentFailureTypeToErrorTagMapper> provider3, Provider<DocumentFeatureErrorTagToViewEventMapper> provider4) {
        return new AdditionalInstructionsFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    public static void injectCoordinator(AdditionalInstructionsFragment additionalInstructionsFragment, AdditionalInstructionsCoordinator additionalInstructionsCoordinator) {
        additionalInstructionsFragment.coordinator = additionalInstructionsCoordinator;
    }

    public static void injectErrorTagToViewEventMapper(AdditionalInstructionsFragment additionalInstructionsFragment, DocumentFeatureErrorTagToViewEventMapper documentFeatureErrorTagToViewEventMapper) {
        additionalInstructionsFragment.errorTagToViewEventMapper = documentFeatureErrorTagToViewEventMapper;
    }

    public static void injectFailureTypeToErrorTagMapper(AdditionalInstructionsFragment additionalInstructionsFragment, DocumentFailureTypeToErrorTagMapper documentFailureTypeToErrorTagMapper) {
        additionalInstructionsFragment.failureTypeToErrorTagMapper = documentFailureTypeToErrorTagMapper;
    }

    public static void injectViewModelFactory(AdditionalInstructionsFragment additionalInstructionsFragment, ViewModelFactory viewModelFactory) {
        additionalInstructionsFragment.viewModelFactory = viewModelFactory;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(AdditionalInstructionsFragment additionalInstructionsFragment) {
        injectViewModelFactory(additionalInstructionsFragment, this.viewModelFactoryProvider.get());
        injectCoordinator(additionalInstructionsFragment, this.coordinatorProvider.get());
        injectFailureTypeToErrorTagMapper(additionalInstructionsFragment, this.failureTypeToErrorTagMapperProvider.get());
        injectErrorTagToViewEventMapper(additionalInstructionsFragment, this.errorTagToViewEventMapperProvider.get());
    }
}
