package com.yoti.mobile.android.documentcapture.p055id.p056di;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.di.IdDocumentCaptureViewModelModule_ProvidesSavedStateViewModelFactoryForDocumentCaptureFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4620x8a5c2e67 implements Factory<SavedStateViewModelFactory<DocumentScanViewModel>> {
    private final IdDocumentCaptureViewModelModule module;
    private final Provider<SavedStateHandleHolderViewModelFactoryProvider> savedStateViewModelFactoryProvider;

    public C4620x8a5c2e67(IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider) {
        this.module = idDocumentCaptureViewModelModule;
        this.savedStateViewModelFactoryProvider = provider;
    }

    public static C4620x8a5c2e67 create(IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider) {
        return new C4620x8a5c2e67(idDocumentCaptureViewModelModule, provider);
    }

    public static SavedStateViewModelFactory<DocumentScanViewModel> providesSavedStateViewModelFactoryForDocumentCapture(IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule, SavedStateHandleHolderViewModelFactoryProvider savedStateHandleHolderViewModelFactoryProvider) {
        return (SavedStateViewModelFactory) Preconditions.checkNotNullFromProvides(idDocumentCaptureViewModelModule.providesSavedStateViewModelFactoryForDocumentCapture(savedStateHandleHolderViewModelFactoryProvider));
    }

    @Override // javax.inject.Provider
    public SavedStateViewModelFactory<DocumentScanViewModel> get() {
        return providesSavedStateViewModelFactoryForDocumentCapture(this.module, this.savedStateViewModelFactoryProvider.get());
    }
}
