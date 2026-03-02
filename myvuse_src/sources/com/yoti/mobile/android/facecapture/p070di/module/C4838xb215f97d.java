package com.yoti.mobile.android.facecapture.p070di.module;

import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.facecapture.view.review.FaceCaptureReviewViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.facecapture.di.module.FaceCaptureViewModelModule_ProvidesFaceCaptureReviewViewModelFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4838xb215f97d implements Factory<ViewModel> {
    private final FaceCaptureViewModelModule module;
    private final Provider<FaceCaptureReviewViewModel> viewModelProvider;

    public C4838xb215f97d(FaceCaptureViewModelModule faceCaptureViewModelModule, Provider<FaceCaptureReviewViewModel> provider) {
        this.module = faceCaptureViewModelModule;
        this.viewModelProvider = provider;
    }

    public static C4838xb215f97d create(FaceCaptureViewModelModule faceCaptureViewModelModule, Provider<FaceCaptureReviewViewModel> provider) {
        return new C4838xb215f97d(faceCaptureViewModelModule, provider);
    }

    public static ViewModel providesFaceCaptureReviewViewModel(FaceCaptureViewModelModule faceCaptureViewModelModule, FaceCaptureReviewViewModel faceCaptureReviewViewModel) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(faceCaptureViewModelModule.providesFaceCaptureReviewViewModel(faceCaptureReviewViewModel));
    }

    @Override // javax.inject.Provider
    public ViewModel get() {
        return providesFaceCaptureReviewViewModel(this.module, this.viewModelProvider.get());
    }
}
