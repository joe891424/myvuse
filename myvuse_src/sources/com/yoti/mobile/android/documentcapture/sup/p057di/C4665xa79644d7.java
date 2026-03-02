package com.yoti.mobile.android.documentcapture.sup.p057di;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.sup.view.scan.SupDocumentScanViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.sup.di.SupDocumentCaptureViewModelModule_ProvidesSavedStateViewModelFactoryForDocumentScanFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4665xa79644d7 implements Factory<SavedStateViewModelFactory<SupDocumentScanViewModel>> {
    private final SupDocumentCaptureViewModelModule module;
    private final Provider<SavedStateHandleHolderViewModelFactoryProvider> savedStateViewModelFactoryProvider;

    public C4665xa79644d7(SupDocumentCaptureViewModelModule supDocumentCaptureViewModelModule, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider) {
        this.module = supDocumentCaptureViewModelModule;
        this.savedStateViewModelFactoryProvider = provider;
    }

    public static C4665xa79644d7 create(SupDocumentCaptureViewModelModule supDocumentCaptureViewModelModule, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider) {
        return new C4665xa79644d7(supDocumentCaptureViewModelModule, provider);
    }

    public static SavedStateViewModelFactory<SupDocumentScanViewModel> providesSavedStateViewModelFactoryForDocumentScan(SupDocumentCaptureViewModelModule supDocumentCaptureViewModelModule, SavedStateHandleHolderViewModelFactoryProvider savedStateHandleHolderViewModelFactoryProvider) {
        return (SavedStateViewModelFactory) Preconditions.checkNotNullFromProvides(supDocumentCaptureViewModelModule.providesSavedStateViewModelFactoryForDocumentScan(savedStateHandleHolderViewModelFactoryProvider));
    }

    @Override // javax.inject.Provider
    public SavedStateViewModelFactory<SupDocumentScanViewModel> get() {
        return providesSavedStateViewModelFactoryForDocumentScan(this.module, this.savedStateViewModelFactoryProvider.get());
    }
}
