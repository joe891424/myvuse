package com.yoti.mobile.android.yotisdkcore.stepTracker.di;

import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.StepTrackerViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewModelModule_ProvidesStepTrackerViewModelFactory implements Factory<ViewModel> {

    /* JADX INFO: renamed from: a */
    private final ViewModelModule f7636a;

    /* JADX INFO: renamed from: b */
    private final Provider<StepTrackerViewModel> f7637b;

    public ViewModelModule_ProvidesStepTrackerViewModelFactory(ViewModelModule viewModelModule, Provider<StepTrackerViewModel> provider) {
        this.f7636a = viewModelModule;
        this.f7637b = provider;
    }

    public static ViewModelModule_ProvidesStepTrackerViewModelFactory create(ViewModelModule viewModelModule, Provider<StepTrackerViewModel> provider) {
        return new ViewModelModule_ProvidesStepTrackerViewModelFactory(viewModelModule, provider);
    }

    public static ViewModel providesStepTrackerViewModel(ViewModelModule viewModelModule, StepTrackerViewModel stepTrackerViewModel) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(viewModelModule.m5164a(stepTrackerViewModel));
    }

    @Override // javax.inject.Provider
    public ViewModel get() {
        return providesStepTrackerViewModel(this.f7636a, this.f7637b.get());
    }
}
