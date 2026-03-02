package com.yoti.mobile.android.documentcapture.p054di;

import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class ViewModelModule_ProvidesDocumentRequirementsViewModelFactory implements Factory<ViewModel> {
    private final ViewModelModule module;
    private final Provider<DocumentRequirementsViewModel> viewModelProvider;

    public ViewModelModule_ProvidesDocumentRequirementsViewModelFactory(ViewModelModule viewModelModule, Provider<DocumentRequirementsViewModel> provider) {
        this.module = viewModelModule;
        this.viewModelProvider = provider;
    }

    public static ViewModelModule_ProvidesDocumentRequirementsViewModelFactory create(ViewModelModule viewModelModule, Provider<DocumentRequirementsViewModel> provider) {
        return new ViewModelModule_ProvidesDocumentRequirementsViewModelFactory(viewModelModule, provider);
    }

    public static ViewModel providesDocumentRequirementsViewModel(ViewModelModule viewModelModule, DocumentRequirementsViewModel documentRequirementsViewModel) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(viewModelModule.providesDocumentRequirementsViewModel(documentRequirementsViewModel));
    }

    @Override // javax.inject.Provider
    public ViewModel get() {
        return providesDocumentRequirementsViewModel(this.module, this.viewModelProvider.get());
    }
}
