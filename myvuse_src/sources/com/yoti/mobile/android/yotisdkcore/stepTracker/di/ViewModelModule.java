package com.yoti.mobile.android.yotisdkcore.stepTracker.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelKey;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.StepTrackerViewModel;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.di.f, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0017J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0011¢\u0006\u0002\b\u000f¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/di/ViewModelModule;", "", "()V", "providesSavedStateViewModelFactory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewModel;", "savedStateViewModelFactoryProvider", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateHandleHolderViewModelFactoryProvider;", "providesStepTrackerViewModel", "Landroidx/lifecycle/ViewModel;", "viewModel", "providesViewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;", "providesViewModelFactory$yoti_sdk_core_productionRelease", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module
public class ViewModelModule {
    @Provides
    @ViewModelKey(StepTrackerViewModel.class)
    @IntoMap
    /* JADX INFO: renamed from: a */
    public ViewModel m5164a(StepTrackerViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        return viewModel;
    }

    @Provides
    @Singleton
    /* JADX INFO: renamed from: a */
    public ViewModelProvider.Factory m5165a(ViewModelFactory factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        return factory;
    }

    @Provides
    @Singleton
    /* JADX INFO: renamed from: a */
    public SavedStateViewModelFactory<StepTrackerViewModel> m5166a(SavedStateHandleHolderViewModelFactoryProvider savedStateViewModelFactoryProvider) {
        Intrinsics.checkNotNullParameter(savedStateViewModelFactoryProvider, "savedStateViewModelFactoryProvider");
        return new SavedStateViewModelFactory<>(StepTrackerViewModel.class, savedStateViewModelFactoryProvider);
    }
}
