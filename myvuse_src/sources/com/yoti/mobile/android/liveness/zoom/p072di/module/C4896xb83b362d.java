package com.yoti.mobile.android.liveness.zoom.p072di.module;

import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.liveness.zoom.view.capture.LivenessFaceTecCaptureViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.liveness.zoom.di.module.LivenessFaceTecViewModelModule_ProvidesLivenessFaceTecCaptureViewModelFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4896xb83b362d implements Factory<ViewModel> {
    private final LivenessFaceTecViewModelModule module;
    private final Provider<LivenessFaceTecCaptureViewModel> viewModelProvider;

    public C4896xb83b362d(LivenessFaceTecViewModelModule livenessFaceTecViewModelModule, Provider<LivenessFaceTecCaptureViewModel> provider) {
        this.module = livenessFaceTecViewModelModule;
        this.viewModelProvider = provider;
    }

    public static C4896xb83b362d create(LivenessFaceTecViewModelModule livenessFaceTecViewModelModule, Provider<LivenessFaceTecCaptureViewModel> provider) {
        return new C4896xb83b362d(livenessFaceTecViewModelModule, provider);
    }

    public static ViewModel providesLivenessFaceTecCaptureViewModel(LivenessFaceTecViewModelModule livenessFaceTecViewModelModule, LivenessFaceTecCaptureViewModel livenessFaceTecCaptureViewModel) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(livenessFaceTecViewModelModule.providesLivenessFaceTecCaptureViewModel(livenessFaceTecCaptureViewModel));
    }

    @Override // javax.inject.Provider
    public ViewModel get() {
        return providesLivenessFaceTecCaptureViewModel(this.module, this.viewModelProvider.get());
    }
}
