package com.yoti.mobile.android.documentcapture.p055id.p056di;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.p055id.view.verify.VerifyYourDetailsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.di.IdDocumentCaptureViewModelModule_ProvidesSavedStateViewModelFactoryForDocumentNfcVerificationFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4621xccd43347 implements Factory<SavedStateViewModelFactory<VerifyYourDetailsViewModel>> {
    private final IdDocumentCaptureViewModelModule module;
    private final Provider<SavedStateHandleHolderViewModelFactoryProvider> savedStateViewModelFactoryProvider;

    public C4621xccd43347(IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider) {
        this.module = idDocumentCaptureViewModelModule;
        this.savedStateViewModelFactoryProvider = provider;
    }

    public static C4621xccd43347 create(IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider) {
        return new C4621xccd43347(idDocumentCaptureViewModelModule, provider);
    }

    public static SavedStateViewModelFactory<VerifyYourDetailsViewModel> providesSavedStateViewModelFactoryForDocumentNfcVerification(IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule, SavedStateHandleHolderViewModelFactoryProvider savedStateHandleHolderViewModelFactoryProvider) {
        return (SavedStateViewModelFactory) Preconditions.checkNotNullFromProvides(idDocumentCaptureViewModelModule.providesSavedStateViewModelFactoryForDocumentNfcVerification(savedStateHandleHolderViewModelFactoryProvider));
    }

    @Override // javax.inject.Provider
    public SavedStateViewModelFactory<VerifyYourDetailsViewModel> get() {
        return providesSavedStateViewModelFactoryForDocumentNfcVerification(this.module, this.savedStateViewModelFactoryProvider.get());
    }
}
