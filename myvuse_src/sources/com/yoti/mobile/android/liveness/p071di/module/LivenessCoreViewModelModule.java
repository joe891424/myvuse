package com.yoti.mobile.android.liveness.p071di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelKey;
import com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentViewModel;
import com.yoti.mobile.android.liveness.view.educational.LivenessEducationalViewModel;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadErrorViewModel;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadViewModel;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0017J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\nH\u0017J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\fH\u0017J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0017¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/di/module/LivenessCoreViewModelModule;", "", "()V", "providesBiometricConsentViewModel", "Landroidx/lifecycle/ViewModel;", "viewModel", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel;", "providesLivenessEducationalViewModel", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel;", "providesLivenessUploadErrorViewModel", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorViewModel;", "providesLivenessUploadViewModel", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadViewModel;", "providesSavedStateViewModelFactoryForLivenessUpload", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "savedStateViewModelFactoryProvider", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateHandleHolderViewModelFactoryProvider;", "providesViewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module
public class LivenessCoreViewModelModule {
    @Provides
    @ViewModelKey(BiometricConsentViewModel.class)
    @IntoMap
    public ViewModel providesBiometricConsentViewModel(BiometricConsentViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        return viewModel;
    }

    @Provides
    @ViewModelKey(LivenessEducationalViewModel.class)
    @IntoMap
    public ViewModel providesLivenessEducationalViewModel(LivenessEducationalViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        return viewModel;
    }

    @Provides
    @ViewModelKey(LivenessUploadErrorViewModel.class)
    @IntoMap
    public ViewModel providesLivenessUploadErrorViewModel(LivenessUploadErrorViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        return viewModel;
    }

    @Provides
    @ViewModelKey(LivenessUploadViewModel.class)
    @IntoMap
    public ViewModel providesLivenessUploadViewModel(LivenessUploadViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        return viewModel;
    }

    @ForLivenessUpload
    @Provides
    @Singleton
    public SavedStateViewModelFactory<LivenessUploadViewModel> providesSavedStateViewModelFactoryForLivenessUpload(SavedStateHandleHolderViewModelFactoryProvider savedStateViewModelFactoryProvider) {
        Intrinsics.checkNotNullParameter(savedStateViewModelFactoryProvider, "savedStateViewModelFactoryProvider");
        return new SavedStateViewModelFactory<>(LivenessUploadViewModel.class, savedStateViewModelFactoryProvider);
    }

    @Provides
    @Singleton
    public ViewModelProvider.Factory providesViewModelFactory(ViewModelFactory factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        return factory;
    }
}
