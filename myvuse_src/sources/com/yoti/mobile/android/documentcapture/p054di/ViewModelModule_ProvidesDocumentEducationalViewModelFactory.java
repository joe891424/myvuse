package com.yoti.mobile.android.documentcapture.p054di;

import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class ViewModelModule_ProvidesDocumentEducationalViewModelFactory implements Factory<ViewModel> {
    private final ViewModelModule module;
    private final Provider<DocumentEducationalViewModel> viewModelProvider;

    public ViewModelModule_ProvidesDocumentEducationalViewModelFactory(ViewModelModule viewModelModule, Provider<DocumentEducationalViewModel> provider) {
        this.module = viewModelModule;
        this.viewModelProvider = provider;
    }

    public static ViewModelModule_ProvidesDocumentEducationalViewModelFactory create(ViewModelModule viewModelModule, Provider<DocumentEducationalViewModel> provider) {
        return new ViewModelModule_ProvidesDocumentEducationalViewModelFactory(viewModelModule, provider);
    }

    public static ViewModel providesDocumentEducationalViewModel(ViewModelModule viewModelModule, DocumentEducationalViewModel documentEducationalViewModel) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(viewModelModule.providesDocumentEducationalViewModel(documentEducationalViewModel));
    }

    @Override // javax.inject.Provider
    public ViewModel get() {
        return providesDocumentEducationalViewModel(this.module, this.viewModelProvider.get());
    }
}
