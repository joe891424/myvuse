package com.yoti.mobile.android.facecapture.view.review;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceCaptureReviewFragment_MembersInjector implements MembersInjector<FaceCaptureReviewFragment> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public FaceCaptureReviewFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<FaceCaptureReviewFragment> create(Provider<ViewModelProvider.Factory> provider) {
        return new FaceCaptureReviewFragment_MembersInjector(provider);
    }

    public static void injectViewModelFactory(FaceCaptureReviewFragment faceCaptureReviewFragment, ViewModelProvider.Factory factory) {
        faceCaptureReviewFragment.viewModelFactory = factory;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(FaceCaptureReviewFragment faceCaptureReviewFragment) {
        injectViewModelFactory(faceCaptureReviewFragment, this.viewModelFactoryProvider.get());
    }
}
