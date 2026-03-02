package com.yoti.mobile.android.yotisdkcore.stepTracker.di;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.StepTrackerViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewModelModule_ProvidesSavedStateViewModelFactoryFactory implements Factory<SavedStateViewModelFactory<StepTrackerViewModel>> {

    /* JADX INFO: renamed from: a */
    private final ViewModelModule f7634a;

    /* JADX INFO: renamed from: b */
    private final Provider<SavedStateHandleHolderViewModelFactoryProvider> f7635b;

    public ViewModelModule_ProvidesSavedStateViewModelFactoryFactory(ViewModelModule viewModelModule, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider) {
        this.f7634a = viewModelModule;
        this.f7635b = provider;
    }

    public static ViewModelModule_ProvidesSavedStateViewModelFactoryFactory create(ViewModelModule viewModelModule, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider) {
        return new ViewModelModule_ProvidesSavedStateViewModelFactoryFactory(viewModelModule, provider);
    }

    public static SavedStateViewModelFactory<StepTrackerViewModel> providesSavedStateViewModelFactory(ViewModelModule viewModelModule, SavedStateHandleHolderViewModelFactoryProvider savedStateHandleHolderViewModelFactoryProvider) {
        return (SavedStateViewModelFactory) Preconditions.checkNotNullFromProvides(viewModelModule.m5166a(savedStateHandleHolderViewModelFactoryProvider));
    }

    @Override // javax.inject.Provider
    public SavedStateViewModelFactory<StepTrackerViewModel> get() {
        return providesSavedStateViewModelFactory(this.f7634a, this.f7635b.get());
    }
}
