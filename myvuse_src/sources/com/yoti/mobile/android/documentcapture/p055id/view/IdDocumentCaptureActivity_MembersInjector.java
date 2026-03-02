package com.yoti.mobile.android.documentcapture.p055id.view;

import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider;
import com.yoti.mobile.android.documentcapture.view.navigation.DocumentStartDestinationResolver;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class IdDocumentCaptureActivity_MembersInjector implements MembersInjector<IdDocumentCaptureActivity> {
    private final Provider<DocumentStartDestinationResolver> startDestinationResolverProvider;
    private final Provider<SavedStateHandleHolderViewModelFactoryProvider> viewModelFactoryProvider;

    public IdDocumentCaptureActivity_MembersInjector(Provider<DocumentStartDestinationResolver> provider, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider2) {
        this.startDestinationResolverProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static MembersInjector<IdDocumentCaptureActivity> create(Provider<DocumentStartDestinationResolver> provider, Provider<SavedStateHandleHolderViewModelFactoryProvider> provider2) {
        return new IdDocumentCaptureActivity_MembersInjector(provider, provider2);
    }

    public static void injectStartDestinationResolver(IdDocumentCaptureActivity idDocumentCaptureActivity, DocumentStartDestinationResolver documentStartDestinationResolver) {
        idDocumentCaptureActivity.startDestinationResolver = documentStartDestinationResolver;
    }

    public static void injectViewModelFactoryProvider(IdDocumentCaptureActivity idDocumentCaptureActivity, SavedStateHandleHolderViewModelFactoryProvider savedStateHandleHolderViewModelFactoryProvider) {
        idDocumentCaptureActivity.viewModelFactoryProvider = savedStateHandleHolderViewModelFactoryProvider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(IdDocumentCaptureActivity idDocumentCaptureActivity) {
        injectStartDestinationResolver(idDocumentCaptureActivity, this.startDestinationResolverProvider.get());
        injectViewModelFactoryProvider(idDocumentCaptureActivity, this.viewModelFactoryProvider.get());
    }
}
