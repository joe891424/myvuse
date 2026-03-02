package com.yoti.mobile.android.documentcapture.p054di;

import androidx.lifecycle.ViewModelProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class ViewModelModule_ProvidesViewModelFactoryFactory implements Factory<ViewModelProvider.Factory> {
    private final Provider<ViewModelFactory> factoryProvider;
    private final ViewModelModule module;

    public ViewModelModule_ProvidesViewModelFactoryFactory(ViewModelModule viewModelModule, Provider<ViewModelFactory> provider) {
        this.module = viewModelModule;
        this.factoryProvider = provider;
    }

    public static ViewModelModule_ProvidesViewModelFactoryFactory create(ViewModelModule viewModelModule, Provider<ViewModelFactory> provider) {
        return new ViewModelModule_ProvidesViewModelFactoryFactory(viewModelModule, provider);
    }

    public static ViewModelProvider.Factory providesViewModelFactory(ViewModelModule viewModelModule, ViewModelFactory viewModelFactory) {
        return (ViewModelProvider.Factory) Preconditions.checkNotNullFromProvides(viewModelModule.providesViewModelFactory(viewModelFactory));
    }

    @Override // javax.inject.Provider
    public ViewModelProvider.Factory get() {
        return providesViewModelFactory(this.module, this.factoryProvider.get());
    }
}
