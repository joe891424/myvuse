package com.yoti.mobile.android.liveness.p071di.module;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.liveness.di.module.LivenessCoreViewModelModule_ProvidesSavedStateViewModelFactoryForLivenessUploadFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4884xfdfab2f0 implements Factory<SavedStateViewModelFactory<LivenessUploadViewModel>> {
    private final LivenessCoreViewModelModule module;
    private final Provider<SavedStateHandleHolderViewModelFactoryProvider> savedStateViewModelFactoryProvider;

    public C4884xfdfab2f0(LivenessCoreViewModelModule livenessCoreViewModelModule, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider) {
        this.module = livenessCoreViewModelModule;
        this.savedStateViewModelFactoryProvider = provider;
    }

    public static C4884xfdfab2f0 create(LivenessCoreViewModelModule livenessCoreViewModelModule, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider) {
        return new C4884xfdfab2f0(livenessCoreViewModelModule, provider);
    }

    public static SavedStateViewModelFactory<LivenessUploadViewModel> providesSavedStateViewModelFactoryForLivenessUpload(LivenessCoreViewModelModule livenessCoreViewModelModule, SavedStateHandleHolderViewModelFactoryProvider savedStateHandleHolderViewModelFactoryProvider) {
        return (SavedStateViewModelFactory) Preconditions.checkNotNullFromProvides(livenessCoreViewModelModule.providesSavedStateViewModelFactoryForLivenessUpload(savedStateHandleHolderViewModelFactoryProvider));
    }

    @Override // javax.inject.Provider
    public SavedStateViewModelFactory<LivenessUploadViewModel> get() {
        return providesSavedStateViewModelFactoryForLivenessUpload(this.module, this.savedStateViewModelFactoryProvider.get());
    }
}
