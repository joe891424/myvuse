package com.yoti.mobile.android.liveness.view.upload;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessUploadErrorFragment_MembersInjector implements MembersInjector<LivenessUploadErrorFragment> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public LivenessUploadErrorFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<LivenessUploadErrorFragment> create(Provider<ViewModelProvider.Factory> provider) {
        return new LivenessUploadErrorFragment_MembersInjector(provider);
    }

    public static void injectViewModelFactory(LivenessUploadErrorFragment livenessUploadErrorFragment, ViewModelProvider.Factory factory) {
        livenessUploadErrorFragment.viewModelFactory = factory;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(LivenessUploadErrorFragment livenessUploadErrorFragment) {
        injectViewModelFactory(livenessUploadErrorFragment, this.viewModelFactoryProvider.get());
    }
}
