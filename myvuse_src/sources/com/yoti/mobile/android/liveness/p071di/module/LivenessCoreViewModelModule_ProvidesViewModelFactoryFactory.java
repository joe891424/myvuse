package com.yoti.mobile.android.liveness.p071di.module;

import androidx.lifecycle.ViewModelProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessCoreViewModelModule_ProvidesViewModelFactoryFactory implements Factory<ViewModelProvider.Factory> {
    private final Provider<ViewModelFactory> factoryProvider;
    private final LivenessCoreViewModelModule module;

    public LivenessCoreViewModelModule_ProvidesViewModelFactoryFactory(LivenessCoreViewModelModule livenessCoreViewModelModule, Provider<ViewModelFactory> provider) {
        this.module = livenessCoreViewModelModule;
        this.factoryProvider = provider;
    }

    public static LivenessCoreViewModelModule_ProvidesViewModelFactoryFactory create(LivenessCoreViewModelModule livenessCoreViewModelModule, Provider<ViewModelFactory> provider) {
        return new LivenessCoreViewModelModule_ProvidesViewModelFactoryFactory(livenessCoreViewModelModule, provider);
    }

    public static ViewModelProvider.Factory providesViewModelFactory(LivenessCoreViewModelModule livenessCoreViewModelModule, ViewModelFactory viewModelFactory) {
        return (ViewModelProvider.Factory) Preconditions.checkNotNullFromProvides(livenessCoreViewModelModule.providesViewModelFactory(viewModelFactory));
    }

    @Override // javax.inject.Provider
    public ViewModelProvider.Factory get() {
        return providesViewModelFactory(this.module, this.factoryProvider.get());
    }
}
