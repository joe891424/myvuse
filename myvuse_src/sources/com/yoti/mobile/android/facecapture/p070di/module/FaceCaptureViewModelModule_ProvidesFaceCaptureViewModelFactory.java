package com.yoti.mobile.android.facecapture.p070di.module;

import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceCaptureViewModelModule_ProvidesFaceCaptureViewModelFactory implements Factory<ViewModel> {
    private final FaceCaptureViewModelModule module;
    private final Provider<FaceCaptureViewModel> viewModelProvider;

    public FaceCaptureViewModelModule_ProvidesFaceCaptureViewModelFactory(FaceCaptureViewModelModule faceCaptureViewModelModule, Provider<FaceCaptureViewModel> provider) {
        this.module = faceCaptureViewModelModule;
        this.viewModelProvider = provider;
    }

    public static FaceCaptureViewModelModule_ProvidesFaceCaptureViewModelFactory create(FaceCaptureViewModelModule faceCaptureViewModelModule, Provider<FaceCaptureViewModel> provider) {
        return new FaceCaptureViewModelModule_ProvidesFaceCaptureViewModelFactory(faceCaptureViewModelModule, provider);
    }

    public static ViewModel providesFaceCaptureViewModel(FaceCaptureViewModelModule faceCaptureViewModelModule, FaceCaptureViewModel faceCaptureViewModel) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(faceCaptureViewModelModule.providesFaceCaptureViewModel(faceCaptureViewModel));
    }

    @Override // javax.inject.Provider
    public ViewModel get() {
        return providesFaceCaptureViewModel(this.module, this.viewModelProvider.get());
    }
}
