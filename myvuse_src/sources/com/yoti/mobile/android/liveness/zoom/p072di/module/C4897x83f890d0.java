package com.yoti.mobile.android.liveness.zoom.p072di.module;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.liveness.zoom.view.capture.LivenessFaceTecCaptureViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.liveness.zoom.di.module.LivenessFaceTecViewModelModule_ProvidesSavedStateViewModelFactoryForLivenessFaceTecCaptureFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4897x83f890d0 implements Factory<SavedStateViewModelFactory<LivenessFaceTecCaptureViewModel>> {
    private final LivenessFaceTecViewModelModule module;
    private final Provider<SavedStateHandleHolderViewModelFactoryProvider> savedStateViewModelFactoryProvider;

    public C4897x83f890d0(LivenessFaceTecViewModelModule livenessFaceTecViewModelModule, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider) {
        this.module = livenessFaceTecViewModelModule;
        this.savedStateViewModelFactoryProvider = provider;
    }

    public static C4897x83f890d0 create(LivenessFaceTecViewModelModule livenessFaceTecViewModelModule, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider) {
        return new C4897x83f890d0(livenessFaceTecViewModelModule, provider);
    }

    public static SavedStateViewModelFactory<LivenessFaceTecCaptureViewModel> providesSavedStateViewModelFactoryForLivenessFaceTecCapture(LivenessFaceTecViewModelModule livenessFaceTecViewModelModule, SavedStateHandleHolderViewModelFactoryProvider savedStateHandleHolderViewModelFactoryProvider) {
        return (SavedStateViewModelFactory) Preconditions.checkNotNullFromProvides(livenessFaceTecViewModelModule.providesSavedStateViewModelFactoryForLivenessFaceTecCapture(savedStateHandleHolderViewModelFactoryProvider));
    }

    @Override // javax.inject.Provider
    public SavedStateViewModelFactory<LivenessFaceTecCaptureViewModel> get() {
        return providesSavedStateViewModelFactoryForLivenessFaceTecCapture(this.module, this.savedStateViewModelFactoryProvider.get());
    }
}
