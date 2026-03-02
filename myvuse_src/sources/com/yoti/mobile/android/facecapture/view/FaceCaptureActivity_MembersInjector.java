package com.yoti.mobile.android.facecapture.view;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceCaptureActivity_MembersInjector implements MembersInjector<FaceCaptureActivity> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public FaceCaptureActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<FaceCaptureActivity> create(Provider<ViewModelProvider.Factory> provider) {
        return new FaceCaptureActivity_MembersInjector(provider);
    }

    public static void injectViewModelFactory(FaceCaptureActivity faceCaptureActivity, ViewModelProvider.Factory factory) {
        faceCaptureActivity.viewModelFactory = factory;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(FaceCaptureActivity faceCaptureActivity) {
        injectViewModelFactory(faceCaptureActivity, this.viewModelFactoryProvider.get());
    }
}
