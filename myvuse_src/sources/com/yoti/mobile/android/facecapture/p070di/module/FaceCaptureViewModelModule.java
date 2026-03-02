package com.yoti.mobile.android.facecapture.p070di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelKey;
import com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel;
import com.yoti.mobile.android.facecapture.view.review.FaceCaptureReviewViewModel;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0017J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/di/module/FaceCaptureViewModelModule;", "", "()V", "providesFaceCaptureReviewViewModel", "Landroidx/lifecycle/ViewModel;", "viewModel", "Lcom/yoti/mobile/android/facecapture/view/review/FaceCaptureReviewViewModel;", "providesFaceCaptureViewModel", "Lcom/yoti/mobile/android/facecapture/view/capture/FaceCaptureViewModel;", "providesViewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module
public class FaceCaptureViewModelModule {
    @Provides
    @ViewModelKey(FaceCaptureReviewViewModel.class)
    @IntoMap
    public ViewModel providesFaceCaptureReviewViewModel(FaceCaptureReviewViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        return viewModel;
    }

    @Provides
    @ViewModelKey(FaceCaptureViewModel.class)
    @IntoMap
    public ViewModel providesFaceCaptureViewModel(FaceCaptureViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        return viewModel;
    }

    @Provides
    @Singleton
    public ViewModelProvider.Factory providesViewModelFactory(ViewModelFactory factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        return factory;
    }
}
