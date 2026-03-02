package com.yoti.mobile.android.documentcapture.p054di;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.di.ViewModelModule_ProvidesSavedStateViewModelFactoryForDocumentSelectionFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4606x412bc991 implements Factory<SavedStateViewModelFactory<DocumentSelectionViewModel>> {
    private final ViewModelModule module;
    private final Provider<SavedStateHandleHolderViewModelFactoryProvider> savedStateViewModelFactoryProvider;

    public C4606x412bc991(ViewModelModule viewModelModule, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider) {
        this.module = viewModelModule;
        this.savedStateViewModelFactoryProvider = provider;
    }

    public static C4606x412bc991 create(ViewModelModule viewModelModule, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider) {
        return new C4606x412bc991(viewModelModule, provider);
    }

    public static SavedStateViewModelFactory<DocumentSelectionViewModel> providesSavedStateViewModelFactoryForDocumentSelection(ViewModelModule viewModelModule, SavedStateHandleHolderViewModelFactoryProvider savedStateHandleHolderViewModelFactoryProvider) {
        return (SavedStateViewModelFactory) Preconditions.checkNotNullFromProvides(viewModelModule.providesSavedStateViewModelFactoryForDocumentSelection(savedStateHandleHolderViewModelFactoryProvider));
    }

    @Override // javax.inject.Provider
    public SavedStateViewModelFactory<DocumentSelectionViewModel> get() {
        return providesSavedStateViewModelFactoryForDocumentSelection(this.module, this.savedStateViewModelFactoryProvider.get());
    }
}
