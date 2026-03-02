package com.yoti.mobile.android.documentcapture.view.selection;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.p054di.ForDocumentSelection;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class CountrySelectionFragment_MembersInjector implements MembersInjector<CountrySelectionFragment> {
    private final Provider<DocumentSelectionCoordinator> coordinatorProvider;
    private final Provider<SavedStateViewModelFactory<DocumentSelectionViewModel>> factoryProvider;

    public CountrySelectionFragment_MembersInjector(Provider<DocumentSelectionCoordinator> provider, Provider<SavedStateViewModelFactory<DocumentSelectionViewModel>> provider2) {
        this.coordinatorProvider = provider;
        this.factoryProvider = provider2;
    }

    public static MembersInjector<CountrySelectionFragment> create(Provider<DocumentSelectionCoordinator> provider, Provider<SavedStateViewModelFactory<DocumentSelectionViewModel>> provider2) {
        return new CountrySelectionFragment_MembersInjector(provider, provider2);
    }

    public static void injectCoordinator(CountrySelectionFragment countrySelectionFragment, DocumentSelectionCoordinator documentSelectionCoordinator) {
        countrySelectionFragment.coordinator = documentSelectionCoordinator;
    }

    @ForDocumentSelection
    public static void injectFactory(CountrySelectionFragment countrySelectionFragment, SavedStateViewModelFactory<DocumentSelectionViewModel> savedStateViewModelFactory) {
        countrySelectionFragment.factory = savedStateViewModelFactory;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(CountrySelectionFragment countrySelectionFragment) {
        injectCoordinator(countrySelectionFragment, this.coordinatorProvider.get());
        injectFactory(countrySelectionFragment, this.factoryProvider.get());
    }
}
