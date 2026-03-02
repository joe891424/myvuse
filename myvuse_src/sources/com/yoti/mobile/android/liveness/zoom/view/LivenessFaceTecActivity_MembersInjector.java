package com.yoti.mobile.android.liveness.zoom.view;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.liveness.zoom.p072di.module.ForLivenessCapture;
import com.yoti.mobile.android.liveness.zoom.view.capture.LivenessFaceTecCaptureViewModel;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessFaceTecActivity_MembersInjector implements MembersInjector<LivenessFaceTecActivity> {
    private final Provider<SavedStateViewModelFactory<LivenessFaceTecCaptureViewModel>> viewModelFactoryProvider;

    public LivenessFaceTecActivity_MembersInjector(Provider<SavedStateViewModelFactory<LivenessFaceTecCaptureViewModel>> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<LivenessFaceTecActivity> create(Provider<SavedStateViewModelFactory<LivenessFaceTecCaptureViewModel>> provider) {
        return new LivenessFaceTecActivity_MembersInjector(provider);
    }

    @ForLivenessCapture
    public static void injectViewModelFactory(LivenessFaceTecActivity livenessFaceTecActivity, SavedStateViewModelFactory<LivenessFaceTecCaptureViewModel> savedStateViewModelFactory) {
        livenessFaceTecActivity.viewModelFactory = savedStateViewModelFactory;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(LivenessFaceTecActivity livenessFaceTecActivity) {
        injectViewModelFactory(livenessFaceTecActivity, this.viewModelFactoryProvider.get());
    }
}
