package com.yoti.mobile.android.liveness.p071di.module;

import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.liveness.di.module.LivenessCoreViewModelModule_ProvidesLivenessUploadViewModelFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4883x5519472d implements Factory<ViewModel> {
    private final LivenessCoreViewModelModule module;
    private final Provider<LivenessUploadViewModel> viewModelProvider;

    public C4883x5519472d(LivenessCoreViewModelModule livenessCoreViewModelModule, Provider<LivenessUploadViewModel> provider) {
        this.module = livenessCoreViewModelModule;
        this.viewModelProvider = provider;
    }

    public static C4883x5519472d create(LivenessCoreViewModelModule livenessCoreViewModelModule, Provider<LivenessUploadViewModel> provider) {
        return new C4883x5519472d(livenessCoreViewModelModule, provider);
    }

    public static ViewModel providesLivenessUploadViewModel(LivenessCoreViewModelModule livenessCoreViewModelModule, LivenessUploadViewModel livenessUploadViewModel) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(livenessCoreViewModelModule.providesLivenessUploadViewModel(livenessUploadViewModel));
    }

    @Override // javax.inject.Provider
    public ViewModel get() {
        return providesLivenessUploadViewModel(this.module, this.viewModelProvider.get());
    }
}
