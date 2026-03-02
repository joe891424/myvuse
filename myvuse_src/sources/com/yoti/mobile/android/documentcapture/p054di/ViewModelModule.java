package com.yoti.mobile.android.documentcapture.p054di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelKey;
import com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsViewModel;
import com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalViewModel;
import com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsViewModel;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionViewModel;
import com.yoti.mobile.android.documentcapture.view.upload.DocumentUploadViewModel;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0017J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\nH\u0017J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\fH\u0017J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000eH\u0017J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0017¨\u0006\u001a"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/di/ViewModelModule;", "", "()V", "providesAdditionalInstructionsViewModel", "Landroidx/lifecycle/ViewModel;", "viewModel", "Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsViewModel;", "providesDocumentEducationalViewModel", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewModel;", "providesDocumentRequirementsViewModel", "Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsViewModel;", "providesDocumentSelectionViewModel", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewModel;", "providesDocumentUploadViewModel", "Lcom/yoti/mobile/android/documentcapture/view/upload/DocumentUploadViewModel;", "providesSavedStateViewModelFactoryForDocumentEducational", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "savedStateViewModelFactoryProvider", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateHandleHolderViewModelFactoryProvider;", "providesSavedStateViewModelFactoryForDocumentRequirements", "providesSavedStateViewModelFactoryForDocumentSelection", "providesSavedStateViewModelFactoryForDocumentUpload", "providesViewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module
public class ViewModelModule {
    @Provides
    @ViewModelKey(AdditionalInstructionsViewModel.class)
    @IntoMap
    public ViewModel providesAdditionalInstructionsViewModel(AdditionalInstructionsViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        return viewModel;
    }

    @Provides
    @ViewModelKey(DocumentEducationalViewModel.class)
    @IntoMap
    public ViewModel providesDocumentEducationalViewModel(DocumentEducationalViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        return viewModel;
    }

    @Provides
    @ViewModelKey(DocumentRequirementsViewModel.class)
    @IntoMap
    public ViewModel providesDocumentRequirementsViewModel(DocumentRequirementsViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        return viewModel;
    }

    @Provides
    @ViewModelKey(DocumentSelectionViewModel.class)
    @IntoMap
    public ViewModel providesDocumentSelectionViewModel(DocumentSelectionViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        return viewModel;
    }

    @Provides
    @ViewModelKey(DocumentUploadViewModel.class)
    @IntoMap
    public ViewModel providesDocumentUploadViewModel(DocumentUploadViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        return viewModel;
    }

    @ForDocumentEducational
    @Provides
    @Singleton
    public SavedStateViewModelFactory<DocumentEducationalViewModel> providesSavedStateViewModelFactoryForDocumentEducational(SavedStateHandleHolderViewModelFactoryProvider savedStateViewModelFactoryProvider) {
        Intrinsics.checkNotNullParameter(savedStateViewModelFactoryProvider, "savedStateViewModelFactoryProvider");
        return new SavedStateViewModelFactory<>(DocumentEducationalViewModel.class, savedStateViewModelFactoryProvider);
    }

    @Provides
    @Singleton
    @ForDocumentRequirements
    public SavedStateViewModelFactory<DocumentRequirementsViewModel> providesSavedStateViewModelFactoryForDocumentRequirements(SavedStateHandleHolderViewModelFactoryProvider savedStateViewModelFactoryProvider) {
        Intrinsics.checkNotNullParameter(savedStateViewModelFactoryProvider, "savedStateViewModelFactoryProvider");
        return new SavedStateViewModelFactory<>(DocumentRequirementsViewModel.class, savedStateViewModelFactoryProvider);
    }

    @Provides
    @Singleton
    @ForDocumentSelection
    public SavedStateViewModelFactory<DocumentSelectionViewModel> providesSavedStateViewModelFactoryForDocumentSelection(SavedStateHandleHolderViewModelFactoryProvider savedStateViewModelFactoryProvider) {
        Intrinsics.checkNotNullParameter(savedStateViewModelFactoryProvider, "savedStateViewModelFactoryProvider");
        return new SavedStateViewModelFactory<>(DocumentSelectionViewModel.class, savedStateViewModelFactoryProvider);
    }

    @Provides
    @Singleton
    @ForDocumentUpload
    public SavedStateViewModelFactory<DocumentUploadViewModel> providesSavedStateViewModelFactoryForDocumentUpload(SavedStateHandleHolderViewModelFactoryProvider savedStateViewModelFactoryProvider) {
        Intrinsics.checkNotNullParameter(savedStateViewModelFactoryProvider, "savedStateViewModelFactoryProvider");
        return new SavedStateViewModelFactory<>(DocumentUploadViewModel.class, savedStateViewModelFactoryProvider);
    }

    @Provides
    @Singleton
    public ViewModelProvider.Factory providesViewModelFactory(ViewModelFactory factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        return factory;
    }
}
