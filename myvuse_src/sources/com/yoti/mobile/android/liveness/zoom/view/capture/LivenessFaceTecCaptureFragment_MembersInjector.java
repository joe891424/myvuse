package com.yoti.mobile.android.liveness.zoom.view.capture;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.liveness.zoom.p072di.module.ForLivenessCapture;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessFaceTecCaptureFragment_MembersInjector implements MembersInjector<LivenessFaceTecCaptureFragment> {
    private final Provider<SavedStateViewModelFactory<LivenessFaceTecCaptureViewModel>> viewModelFactoryProvider;

    public LivenessFaceTecCaptureFragment_MembersInjector(Provider<SavedStateViewModelFactory<LivenessFaceTecCaptureViewModel>> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<LivenessFaceTecCaptureFragment> create(Provider<SavedStateViewModelFactory<LivenessFaceTecCaptureViewModel>> provider) {
        return new LivenessFaceTecCaptureFragment_MembersInjector(provider);
    }

    @ForLivenessCapture
    public static void injectViewModelFactory(LivenessFaceTecCaptureFragment livenessFaceTecCaptureFragment, SavedStateViewModelFactory<LivenessFaceTecCaptureViewModel> savedStateViewModelFactory) {
        livenessFaceTecCaptureFragment.viewModelFactory = savedStateViewModelFactory;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(LivenessFaceTecCaptureFragment livenessFaceTecCaptureFragment) {
        injectViewModelFactory(livenessFaceTecCaptureFragment, this.viewModelFactoryProvider.get());
    }
}
