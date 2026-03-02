package com.yoti.mobile.android.documentcapture.p055id.p056di;

import androidx.lifecycle.ViewModelProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.di.IdDocumentCaptureViewModelModule_ProvidesViewModelFactory$documentcapture_id_productionReleaseFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4625xf581519f implements Factory<ViewModelProvider.Factory> {
    private final Provider<ViewModelFactory> factoryProvider;
    private final IdDocumentCaptureViewModelModule module;

    public C4625xf581519f(IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule, Provider<ViewModelFactory> provider) {
        this.module = idDocumentCaptureViewModelModule;
        this.factoryProvider = provider;
    }

    public static C4625xf581519f create(IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule, Provider<ViewModelFactory> provider) {
        return new C4625xf581519f(idDocumentCaptureViewModelModule, provider);
    }

    public static ViewModelProvider.Factory providesViewModelFactory$documentcapture_id_productionRelease(IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule, ViewModelFactory viewModelFactory) {
        return (ViewModelProvider.Factory) Preconditions.checkNotNullFromProvides(idDocumentCaptureViewModelModule.providesViewModelFactory$documentcapture_id_productionRelease(viewModelFactory));
    }

    @Override // javax.inject.Provider
    public ViewModelProvider.Factory get() {
        return providesViewModelFactory$documentcapture_id_productionRelease(this.module, this.factoryProvider.get());
    }
}
