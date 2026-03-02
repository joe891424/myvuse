package com.yoti.mobile.android.documentcapture.p054di;

import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class ViewModelModule_ProvidesDocumentSelectionViewModelFactory implements Factory<ViewModel> {
    private final ViewModelModule module;
    private final Provider<DocumentSelectionViewModel> viewModelProvider;

    public ViewModelModule_ProvidesDocumentSelectionViewModelFactory(ViewModelModule viewModelModule, Provider<DocumentSelectionViewModel> provider) {
        this.module = viewModelModule;
        this.viewModelProvider = provider;
    }

    public static ViewModelModule_ProvidesDocumentSelectionViewModelFactory create(ViewModelModule viewModelModule, Provider<DocumentSelectionViewModel> provider) {
        return new ViewModelModule_ProvidesDocumentSelectionViewModelFactory(viewModelModule, provider);
    }

    public static ViewModel providesDocumentSelectionViewModel(ViewModelModule viewModelModule, DocumentSelectionViewModel documentSelectionViewModel) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(viewModelModule.providesDocumentSelectionViewModel(documentSelectionViewModel));
    }

    @Override // javax.inject.Provider
    public ViewModel get() {
        return providesDocumentSelectionViewModel(this.module, this.viewModelProvider.get());
    }
}
