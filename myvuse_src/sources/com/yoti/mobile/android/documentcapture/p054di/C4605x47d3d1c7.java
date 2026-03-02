package com.yoti.mobile.android.documentcapture.p054di;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.di.ViewModelModule_ProvidesSavedStateViewModelFactoryForDocumentRequirementsFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4605x47d3d1c7 implements Factory<SavedStateViewModelFactory<DocumentRequirementsViewModel>> {
    private final ViewModelModule module;
    private final Provider<SavedStateHandleHolderViewModelFactoryProvider> savedStateViewModelFactoryProvider;

    public C4605x47d3d1c7(ViewModelModule viewModelModule, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider) {
        this.module = viewModelModule;
        this.savedStateViewModelFactoryProvider = provider;
    }

    public static C4605x47d3d1c7 create(ViewModelModule viewModelModule, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider) {
        return new C4605x47d3d1c7(viewModelModule, provider);
    }

    public static SavedStateViewModelFactory<DocumentRequirementsViewModel> providesSavedStateViewModelFactoryForDocumentRequirements(ViewModelModule viewModelModule, SavedStateHandleHolderViewModelFactoryProvider savedStateHandleHolderViewModelFactoryProvider) {
        return (SavedStateViewModelFactory) Preconditions.checkNotNullFromProvides(viewModelModule.providesSavedStateViewModelFactoryForDocumentRequirements(savedStateHandleHolderViewModelFactoryProvider));
    }

    @Override // javax.inject.Provider
    public SavedStateViewModelFactory<DocumentRequirementsViewModel> get() {
        return providesSavedStateViewModelFactoryForDocumentRequirements(this.module, this.savedStateViewModelFactoryProvider.get());
    }
}
