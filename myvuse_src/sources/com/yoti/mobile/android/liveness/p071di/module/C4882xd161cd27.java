package com.yoti.mobile.android.liveness.p071di.module;

import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadErrorViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.liveness.di.module.LivenessCoreViewModelModule_ProvidesLivenessUploadErrorViewModelFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4882xd161cd27 implements Factory<ViewModel> {
    private final LivenessCoreViewModelModule module;
    private final Provider<LivenessUploadErrorViewModel> viewModelProvider;

    public C4882xd161cd27(LivenessCoreViewModelModule livenessCoreViewModelModule, Provider<LivenessUploadErrorViewModel> provider) {
        this.module = livenessCoreViewModelModule;
        this.viewModelProvider = provider;
    }

    public static C4882xd161cd27 create(LivenessCoreViewModelModule livenessCoreViewModelModule, Provider<LivenessUploadErrorViewModel> provider) {
        return new C4882xd161cd27(livenessCoreViewModelModule, provider);
    }

    public static ViewModel providesLivenessUploadErrorViewModel(LivenessCoreViewModelModule livenessCoreViewModelModule, LivenessUploadErrorViewModel livenessUploadErrorViewModel) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(livenessCoreViewModelModule.providesLivenessUploadErrorViewModel(livenessUploadErrorViewModel));
    }

    @Override // javax.inject.Provider
    public ViewModel get() {
        return providesLivenessUploadErrorViewModel(this.module, this.viewModelProvider.get());
    }
}
