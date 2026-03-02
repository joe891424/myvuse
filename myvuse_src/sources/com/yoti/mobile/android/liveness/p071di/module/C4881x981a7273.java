package com.yoti.mobile.android.liveness.p071di.module;

import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.liveness.view.educational.LivenessEducationalViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.liveness.di.module.LivenessCoreViewModelModule_ProvidesLivenessEducationalViewModelFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4881x981a7273 implements Factory<ViewModel> {
    private final LivenessCoreViewModelModule module;
    private final Provider<LivenessEducationalViewModel> viewModelProvider;

    public C4881x981a7273(LivenessCoreViewModelModule livenessCoreViewModelModule, Provider<LivenessEducationalViewModel> provider) {
        this.module = livenessCoreViewModelModule;
        this.viewModelProvider = provider;
    }

    public static C4881x981a7273 create(LivenessCoreViewModelModule livenessCoreViewModelModule, Provider<LivenessEducationalViewModel> provider) {
        return new C4881x981a7273(livenessCoreViewModelModule, provider);
    }

    public static ViewModel providesLivenessEducationalViewModel(LivenessCoreViewModelModule livenessCoreViewModelModule, LivenessEducationalViewModel livenessEducationalViewModel) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(livenessCoreViewModelModule.providesLivenessEducationalViewModel(livenessEducationalViewModel));
    }

    @Override // javax.inject.Provider
    public ViewModel get() {
        return providesLivenessEducationalViewModel(this.module, this.viewModelProvider.get());
    }
}
