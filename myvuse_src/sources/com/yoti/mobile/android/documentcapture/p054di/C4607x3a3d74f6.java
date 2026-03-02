package com.yoti.mobile.android.documentcapture.p054di;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.view.upload.DocumentUploadViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.di.ViewModelModule_ProvidesSavedStateViewModelFactoryForDocumentUploadFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4607x3a3d74f6 implements Factory<SavedStateViewModelFactory<DocumentUploadViewModel>> {
    private final ViewModelModule module;
    private final Provider<SavedStateHandleHolderViewModelFactoryProvider> savedStateViewModelFactoryProvider;

    public C4607x3a3d74f6(ViewModelModule viewModelModule, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider) {
        this.module = viewModelModule;
        this.savedStateViewModelFactoryProvider = provider;
    }

    public static C4607x3a3d74f6 create(ViewModelModule viewModelModule, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider) {
        return new C4607x3a3d74f6(viewModelModule, provider);
    }

    public static SavedStateViewModelFactory<DocumentUploadViewModel> providesSavedStateViewModelFactoryForDocumentUpload(ViewModelModule viewModelModule, SavedStateHandleHolderViewModelFactoryProvider savedStateHandleHolderViewModelFactoryProvider) {
        return (SavedStateViewModelFactory) Preconditions.checkNotNullFromProvides(viewModelModule.providesSavedStateViewModelFactoryForDocumentUpload(savedStateHandleHolderViewModelFactoryProvider));
    }

    @Override // javax.inject.Provider
    public SavedStateViewModelFactory<DocumentUploadViewModel> get() {
        return providesSavedStateViewModelFactoryForDocumentUpload(this.module, this.savedStateViewModelFactoryProvider.get());
    }
}
