package com.yoti.mobile.android.yotisdkcore.stepTracker.di;

import androidx.lifecycle.ViewModelProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.di.ViewModelModule_ProvidesViewModelFactory$yoti_sdk_core_productionReleaseFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4999xd49f4e00 implements Factory<ViewModelProvider.Factory> {

    /* JADX INFO: renamed from: a */
    private final ViewModelModule f7638a;

    /* JADX INFO: renamed from: b */
    private final Provider<ViewModelFactory> f7639b;

    public C4999xd49f4e00(ViewModelModule viewModelModule, Provider<ViewModelFactory> provider) {
        this.f7638a = viewModelModule;
        this.f7639b = provider;
    }

    public static C4999xd49f4e00 create(ViewModelModule viewModelModule, Provider<ViewModelFactory> provider) {
        return new C4999xd49f4e00(viewModelModule, provider);
    }

    public static ViewModelProvider.Factory providesViewModelFactory$yoti_sdk_core_productionRelease(ViewModelModule viewModelModule, ViewModelFactory viewModelFactory) {
        return (ViewModelProvider.Factory) Preconditions.checkNotNullFromProvides(viewModelModule.m5165a(viewModelFactory));
    }

    @Override // javax.inject.Provider
    public ViewModelProvider.Factory get() {
        return providesViewModelFactory$yoti_sdk_core_productionRelease(this.f7638a, this.f7639b.get());
    }
}
