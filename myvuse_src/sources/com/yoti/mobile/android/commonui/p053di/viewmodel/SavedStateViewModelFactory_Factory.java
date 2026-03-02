package com.yoti.mobile.android.commonui.p053di.viewmodel;

import androidx.lifecycle.ViewModel;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class SavedStateViewModelFactory_Factory<VM extends ViewModel> implements Factory<SavedStateViewModelFactory<VM>> {
    private final Provider<SavedStateHandleHolderViewModelFactoryProvider> savedStateViewModelFactoryProvider;
    private final Provider<Class<VM>> viewModelClassProvider;

    public SavedStateViewModelFactory_Factory(Provider<Class<VM>> provider, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider2) {
        this.viewModelClassProvider = provider;
        this.savedStateViewModelFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public SavedStateViewModelFactory<VM> get() {
        return newInstance(this.viewModelClassProvider.get(), this.savedStateViewModelFactoryProvider.get());
    }

    public static <VM extends ViewModel> SavedStateViewModelFactory_Factory<VM> create(Provider<Class<VM>> provider, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider2) {
        return new SavedStateViewModelFactory_Factory<>(provider, provider2);
    }

    public static <VM extends ViewModel> SavedStateViewModelFactory<VM> newInstance(Class<VM> cls, SavedStateHandleHolderViewModelFactoryProvider savedStateHandleHolderViewModelFactoryProvider) {
        return new SavedStateViewModelFactory<>(cls, savedStateHandleHolderViewModelFactoryProvider);
    }
}
