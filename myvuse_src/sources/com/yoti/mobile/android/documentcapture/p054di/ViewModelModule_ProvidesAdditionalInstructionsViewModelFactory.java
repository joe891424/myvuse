package com.yoti.mobile.android.documentcapture.p054di;

import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class ViewModelModule_ProvidesAdditionalInstructionsViewModelFactory implements Factory<ViewModel> {
    private final ViewModelModule module;
    private final Provider<AdditionalInstructionsViewModel> viewModelProvider;

    public ViewModelModule_ProvidesAdditionalInstructionsViewModelFactory(ViewModelModule viewModelModule, Provider<AdditionalInstructionsViewModel> provider) {
        this.module = viewModelModule;
        this.viewModelProvider = provider;
    }

    public static ViewModelModule_ProvidesAdditionalInstructionsViewModelFactory create(ViewModelModule viewModelModule, Provider<AdditionalInstructionsViewModel> provider) {
        return new ViewModelModule_ProvidesAdditionalInstructionsViewModelFactory(viewModelModule, provider);
    }

    public static ViewModel providesAdditionalInstructionsViewModel(ViewModelModule viewModelModule, AdditionalInstructionsViewModel additionalInstructionsViewModel) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(viewModelModule.providesAdditionalInstructionsViewModel(additionalInstructionsViewModel));
    }

    @Override // javax.inject.Provider
    public ViewModel get() {
        return providesAdditionalInstructionsViewModel(this.module, this.viewModelProvider.get());
    }
}
