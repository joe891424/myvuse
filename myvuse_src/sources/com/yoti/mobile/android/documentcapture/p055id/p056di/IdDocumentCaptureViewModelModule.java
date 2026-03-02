package com.yoti.mobile.android.documentcapture.p055id.p056di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelKey;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanViewModel;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.PageScanReviewViewModel;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.TextExtractionErrorViewModel;
import com.yoti.mobile.android.documentcapture.p055id.view.verify.VerifyYourDetailsViewModel;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0017J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0017J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\u0006\u0010\f\u001a\u00020\rH\u0017J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\f\u001a\u00020\rH\u0017J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000bH\u0017J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000fH\u0017J\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0011¢\u0006\u0002\b\u0017¨\u0006\u0018"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/di/IdDocumentCaptureViewModelModule;", "", "()V", "providesGenericTextExtractionErrorViewModel", "Landroidx/lifecycle/ViewModel;", "viewModel", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel;", "providesPageScanReviewViewModel", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel;", "providesSavedStateViewModelFactoryForDocumentCapture", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel;", "savedStateViewModelFactoryProvider", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateHandleHolderViewModelFactoryProvider;", "providesSavedStateViewModelFactoryForDocumentNfcVerification", "Lcom/yoti/mobile/android/documentcapture/id/view/verify/VerifyYourDetailsViewModel;", "providesSavedStateViewModelFactoryForDocumentReview", "providesScanConfigurationViewModel", "providesVerifyYourDetailsViewModel", "providesViewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;", "providesViewModelFactory$documentcapture_id_productionRelease", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module
public class IdDocumentCaptureViewModelModule {
    @Provides
    @ViewModelKey(TextExtractionErrorViewModel.class)
    @IntoMap
    public ViewModel providesGenericTextExtractionErrorViewModel(TextExtractionErrorViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        return viewModel;
    }

    @Provides
    @ViewModelKey(PageScanReviewViewModel.class)
    @IntoMap
    public ViewModel providesPageScanReviewViewModel(PageScanReviewViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        return viewModel;
    }

    @Provides
    @Singleton
    @ForDocumentCapture
    public SavedStateViewModelFactory<DocumentScanViewModel> providesSavedStateViewModelFactoryForDocumentCapture(SavedStateHandleHolderViewModelFactoryProvider savedStateViewModelFactoryProvider) {
        Intrinsics.checkNotNullParameter(savedStateViewModelFactoryProvider, "savedStateViewModelFactoryProvider");
        return new SavedStateViewModelFactory<>(DocumentScanViewModel.class, savedStateViewModelFactoryProvider);
    }

    @Provides
    @Singleton
    @ForDocumentNfcVerification
    public SavedStateViewModelFactory<VerifyYourDetailsViewModel> providesSavedStateViewModelFactoryForDocumentNfcVerification(SavedStateHandleHolderViewModelFactoryProvider savedStateViewModelFactoryProvider) {
        Intrinsics.checkNotNullParameter(savedStateViewModelFactoryProvider, "savedStateViewModelFactoryProvider");
        return new SavedStateViewModelFactory<>(VerifyYourDetailsViewModel.class, savedStateViewModelFactoryProvider);
    }

    @ForDocumentReview
    @Provides
    @Singleton
    public SavedStateViewModelFactory<PageScanReviewViewModel> providesSavedStateViewModelFactoryForDocumentReview(SavedStateHandleHolderViewModelFactoryProvider savedStateViewModelFactoryProvider) {
        Intrinsics.checkNotNullParameter(savedStateViewModelFactoryProvider, "savedStateViewModelFactoryProvider");
        return new SavedStateViewModelFactory<>(PageScanReviewViewModel.class, savedStateViewModelFactoryProvider);
    }

    @Provides
    @ViewModelKey(DocumentScanViewModel.class)
    @IntoMap
    public ViewModel providesScanConfigurationViewModel(DocumentScanViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        return viewModel;
    }

    @Provides
    @ViewModelKey(VerifyYourDetailsViewModel.class)
    @IntoMap
    public ViewModel providesVerifyYourDetailsViewModel(VerifyYourDetailsViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        return viewModel;
    }

    @Provides
    public ViewModelProvider.Factory providesViewModelFactory$documentcapture_id_productionRelease(ViewModelFactory factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        return factory;
    }
}
