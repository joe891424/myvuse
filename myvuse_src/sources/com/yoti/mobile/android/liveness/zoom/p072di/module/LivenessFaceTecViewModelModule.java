package com.yoti.mobile.android.liveness.zoom.p072di.module;

import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelKey;
import com.yoti.mobile.android.liveness.zoom.view.capture.LivenessFaceTecCaptureViewModel;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\t\u001a\u00020\nH\u0017¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/di/module/LivenessFaceTecViewModelModule;", "", "()V", "providesLivenessFaceTecCaptureViewModel", "Landroidx/lifecycle/ViewModel;", "viewModel", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecCaptureViewModel;", "providesSavedStateViewModelFactoryForLivenessFaceTecCapture", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "savedStateViewModelFactoryProvider", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateHandleHolderViewModelFactoryProvider;", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module
public class LivenessFaceTecViewModelModule {
    @Provides
    @ViewModelKey(LivenessFaceTecCaptureViewModel.class)
    @IntoMap
    public ViewModel providesLivenessFaceTecCaptureViewModel(LivenessFaceTecCaptureViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        return viewModel;
    }

    @Provides
    @Singleton
    @ForLivenessCapture
    public SavedStateViewModelFactory<LivenessFaceTecCaptureViewModel> providesSavedStateViewModelFactoryForLivenessFaceTecCapture(SavedStateHandleHolderViewModelFactoryProvider savedStateViewModelFactoryProvider) {
        Intrinsics.checkNotNullParameter(savedStateViewModelFactoryProvider, "savedStateViewModelFactoryProvider");
        return new SavedStateViewModelFactory<>(LivenessFaceTecCaptureViewModel.class, savedStateViewModelFactoryProvider);
    }
}
