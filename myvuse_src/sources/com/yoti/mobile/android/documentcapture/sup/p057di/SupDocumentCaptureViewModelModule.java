package com.yoti.mobile.android.documentcapture.sup.p057di;

import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelKey;
import com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel;
import com.yoti.mobile.android.documentcapture.sup.view.scan.SupDocumentScanViewModel;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\t\u001a\u00020\nH\u0017J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\t\u001a\u00020\nH\u0017J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\fH\u0017¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/di/SupDocumentCaptureViewModelModule;", "", "()V", "providesDocumentReviewViewModel", "Landroidx/lifecycle/ViewModel;", "viewModel", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel;", "providesSavedStateViewModelFactoryForDocumentReview", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "savedStateViewModelFactoryProvider", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateHandleHolderViewModelFactoryProvider;", "providesSavedStateViewModelFactoryForDocumentScan", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanViewModel;", "providesSupDocumentScanViewModel", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module
public class SupDocumentCaptureViewModelModule {
    @Provides
    @ViewModelKey(DocumentReviewViewModel.class)
    @IntoMap
    public ViewModel providesDocumentReviewViewModel(DocumentReviewViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        return viewModel;
    }

    @Provides
    @Singleton
    @ForDocumentReview
    public SavedStateViewModelFactory<DocumentReviewViewModel> providesSavedStateViewModelFactoryForDocumentReview(SavedStateHandleHolderViewModelFactoryProvider savedStateViewModelFactoryProvider) {
        Intrinsics.checkNotNullParameter(savedStateViewModelFactoryProvider, "savedStateViewModelFactoryProvider");
        return new SavedStateViewModelFactory<>(DocumentReviewViewModel.class, savedStateViewModelFactoryProvider);
    }

    @Provides
    @Singleton
    @ForDocumentScan
    public SavedStateViewModelFactory<SupDocumentScanViewModel> providesSavedStateViewModelFactoryForDocumentScan(SavedStateHandleHolderViewModelFactoryProvider savedStateViewModelFactoryProvider) {
        Intrinsics.checkNotNullParameter(savedStateViewModelFactoryProvider, "savedStateViewModelFactoryProvider");
        return new SavedStateViewModelFactory<>(SupDocumentScanViewModel.class, savedStateViewModelFactoryProvider);
    }

    @Provides
    @ViewModelKey(SupDocumentScanViewModel.class)
    @IntoMap
    public ViewModel providesSupDocumentScanViewModel(SupDocumentScanViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        return viewModel;
    }
}
