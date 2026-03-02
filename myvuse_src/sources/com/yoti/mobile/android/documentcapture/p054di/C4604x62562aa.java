package com.yoti.mobile.android.documentcapture.p054di;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.di.ViewModelModule_ProvidesSavedStateViewModelFactoryForDocumentEducationalFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4604x62562aa implements Factory<SavedStateViewModelFactory<DocumentEducationalViewModel>> {
    private final ViewModelModule module;
    private final Provider<SavedStateHandleHolderViewModelFactoryProvider> savedStateViewModelFactoryProvider;

    public C4604x62562aa(ViewModelModule viewModelModule, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider) {
        this.module = viewModelModule;
        this.savedStateViewModelFactoryProvider = provider;
    }

    public static C4604x62562aa create(ViewModelModule viewModelModule, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider) {
        return new C4604x62562aa(viewModelModule, provider);
    }

    public static SavedStateViewModelFactory<DocumentEducationalViewModel> providesSavedStateViewModelFactoryForDocumentEducational(ViewModelModule viewModelModule, SavedStateHandleHolderViewModelFactoryProvider savedStateHandleHolderViewModelFactoryProvider) {
        return (SavedStateViewModelFactory) Preconditions.checkNotNullFromProvides(viewModelModule.providesSavedStateViewModelFactoryForDocumentEducational(savedStateHandleHolderViewModelFactoryProvider));
    }

    @Override // javax.inject.Provider
    public SavedStateViewModelFactory<DocumentEducationalViewModel> get() {
        return providesSavedStateViewModelFactoryForDocumentEducational(this.module, this.savedStateViewModelFactoryProvider.get());
    }
}
