package com.yoti.mobile.android.documentcapture.sup.view;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.sup.p057di.ForDocumentScan;
import com.yoti.mobile.android.documentcapture.sup.view.scan.ICaptureChooser;
import com.yoti.mobile.android.documentcapture.sup.view.scan.SupDocumentScanViewModel;
import com.yoti.mobile.android.documentcapture.view.navigation.DocumentStartDestinationResolver;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class SupDocumentCaptureActivity_MembersInjector implements MembersInjector<SupDocumentCaptureActivity> {
    private final Provider<ICaptureChooser> captureChooserProvider;
    private final Provider<DocumentStartDestinationResolver> startDestinationResolverProvider;
    private final Provider<SavedStateViewModelFactory<SupDocumentScanViewModel>> viewModelFactoryProvider;

    public SupDocumentCaptureActivity_MembersInjector(Provider<DocumentStartDestinationResolver> provider, Provider<SavedStateViewModelFactory<SupDocumentScanViewModel>> provider2, Provider<ICaptureChooser> provider3) {
        this.startDestinationResolverProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.captureChooserProvider = provider3;
    }

    public static MembersInjector<SupDocumentCaptureActivity> create(Provider<DocumentStartDestinationResolver> provider, Provider<SavedStateViewModelFactory<SupDocumentScanViewModel>> provider2, Provider<ICaptureChooser> provider3) {
        return new SupDocumentCaptureActivity_MembersInjector(provider, provider2, provider3);
    }

    public static void injectCaptureChooser(SupDocumentCaptureActivity supDocumentCaptureActivity, ICaptureChooser iCaptureChooser) {
        supDocumentCaptureActivity.captureChooser = iCaptureChooser;
    }

    public static void injectStartDestinationResolver(SupDocumentCaptureActivity supDocumentCaptureActivity, DocumentStartDestinationResolver documentStartDestinationResolver) {
        supDocumentCaptureActivity.startDestinationResolver = documentStartDestinationResolver;
    }

    @ForDocumentScan
    public static void injectViewModelFactory(SupDocumentCaptureActivity supDocumentCaptureActivity, SavedStateViewModelFactory<SupDocumentScanViewModel> savedStateViewModelFactory) {
        supDocumentCaptureActivity.viewModelFactory = savedStateViewModelFactory;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(SupDocumentCaptureActivity supDocumentCaptureActivity) {
        injectStartDestinationResolver(supDocumentCaptureActivity, this.startDestinationResolverProvider.get());
        injectViewModelFactory(supDocumentCaptureActivity, this.viewModelFactoryProvider.get());
        injectCaptureChooser(supDocumentCaptureActivity, this.captureChooserProvider.get());
    }
}
