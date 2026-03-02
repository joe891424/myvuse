package com.yoti.mobile.android.liveness.view.upload;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.liveness.p071di.module.ForLivenessUpload;
import com.yoti.mobile.android.liveness.view.navigation.ILivenessUploadNavigatorProvider;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessUploadFragment_MembersInjector implements MembersInjector<LivenessUploadFragment> {
    private final Provider<ILivenessUploadNavigatorProvider> uploadNavigatorProvider;
    private final Provider<SavedStateViewModelFactory<LivenessUploadViewModel>> viewModelFactoryProvider;

    public LivenessUploadFragment_MembersInjector(Provider<SavedStateViewModelFactory<LivenessUploadViewModel>> provider, Provider<ILivenessUploadNavigatorProvider> provider2) {
        this.viewModelFactoryProvider = provider;
        this.uploadNavigatorProvider = provider2;
    }

    public static MembersInjector<LivenessUploadFragment> create(Provider<SavedStateViewModelFactory<LivenessUploadViewModel>> provider, Provider<ILivenessUploadNavigatorProvider> provider2) {
        return new LivenessUploadFragment_MembersInjector(provider, provider2);
    }

    public static void injectUploadNavigatorProvider(LivenessUploadFragment livenessUploadFragment, ILivenessUploadNavigatorProvider iLivenessUploadNavigatorProvider) {
        livenessUploadFragment.uploadNavigatorProvider = iLivenessUploadNavigatorProvider;
    }

    @ForLivenessUpload
    public static void injectViewModelFactory(LivenessUploadFragment livenessUploadFragment, SavedStateViewModelFactory<LivenessUploadViewModel> savedStateViewModelFactory) {
        livenessUploadFragment.viewModelFactory = savedStateViewModelFactory;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(LivenessUploadFragment livenessUploadFragment) {
        injectViewModelFactory(livenessUploadFragment, this.viewModelFactoryProvider.get());
        injectUploadNavigatorProvider(livenessUploadFragment, this.uploadNavigatorProvider.get());
    }
}
