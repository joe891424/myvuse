package com.yoti.mobile.android.facecapture.p070di.module;

import androidx.lifecycle.ViewModelProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceCaptureViewModelModule_ProvidesViewModelFactoryFactory implements Factory<ViewModelProvider.Factory> {
    private final Provider<ViewModelFactory> factoryProvider;
    private final FaceCaptureViewModelModule module;

    public FaceCaptureViewModelModule_ProvidesViewModelFactoryFactory(FaceCaptureViewModelModule faceCaptureViewModelModule, Provider<ViewModelFactory> provider) {
        this.module = faceCaptureViewModelModule;
        this.factoryProvider = provider;
    }

    public static FaceCaptureViewModelModule_ProvidesViewModelFactoryFactory create(FaceCaptureViewModelModule faceCaptureViewModelModule, Provider<ViewModelFactory> provider) {
        return new FaceCaptureViewModelModule_ProvidesViewModelFactoryFactory(faceCaptureViewModelModule, provider);
    }

    public static ViewModelProvider.Factory providesViewModelFactory(FaceCaptureViewModelModule faceCaptureViewModelModule, ViewModelFactory viewModelFactory) {
        return (ViewModelProvider.Factory) Preconditions.checkNotNullFromProvides(faceCaptureViewModelModule.providesViewModelFactory(viewModelFactory));
    }

    @Override // javax.inject.Provider
    public ViewModelProvider.Factory get() {
        return providesViewModelFactory(this.module, this.factoryProvider.get());
    }
}
