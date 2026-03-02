package com.yoti.mobile.android.documentcapture.p054di;

import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.documentcapture.view.upload.DocumentUploadViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class ViewModelModule_ProvidesDocumentUploadViewModelFactory implements Factory<ViewModel> {
    private final ViewModelModule module;
    private final Provider<DocumentUploadViewModel> viewModelProvider;

    public ViewModelModule_ProvidesDocumentUploadViewModelFactory(ViewModelModule viewModelModule, Provider<DocumentUploadViewModel> provider) {
        this.module = viewModelModule;
        this.viewModelProvider = provider;
    }

    public static ViewModelModule_ProvidesDocumentUploadViewModelFactory create(ViewModelModule viewModelModule, Provider<DocumentUploadViewModel> provider) {
        return new ViewModelModule_ProvidesDocumentUploadViewModelFactory(viewModelModule, provider);
    }

    public static ViewModel providesDocumentUploadViewModel(ViewModelModule viewModelModule, DocumentUploadViewModel documentUploadViewModel) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(viewModelModule.providesDocumentUploadViewModel(documentUploadViewModel));
    }

    @Override // javax.inject.Provider
    public ViewModel get() {
        return providesDocumentUploadViewModel(this.module, this.viewModelProvider.get());
    }
}
