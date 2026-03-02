package com.yoti.mobile.android.documentcapture.p055id.view.verify;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.p055id.p056di.ForDocumentNfcVerification;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class VerifyYourDetailsFragment_MembersInjector implements MembersInjector<VerifyYourDetailsFragment> {
    private final Provider<SavedStateViewModelFactory<VerifyYourDetailsViewModel>> viewModelFactoryProvider;

    public VerifyYourDetailsFragment_MembersInjector(Provider<SavedStateViewModelFactory<VerifyYourDetailsViewModel>> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<VerifyYourDetailsFragment> create(Provider<SavedStateViewModelFactory<VerifyYourDetailsViewModel>> provider) {
        return new VerifyYourDetailsFragment_MembersInjector(provider);
    }

    @ForDocumentNfcVerification
    public static void injectViewModelFactory(VerifyYourDetailsFragment verifyYourDetailsFragment, SavedStateViewModelFactory<VerifyYourDetailsViewModel> savedStateViewModelFactory) {
        verifyYourDetailsFragment.viewModelFactory = savedStateViewModelFactory;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(VerifyYourDetailsFragment verifyYourDetailsFragment) {
        injectViewModelFactory(verifyYourDetailsFragment, this.viewModelFactoryProvider.get());
    }
}
