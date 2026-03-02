package com.yoti.mobile.android.documentcapture.view.additional_instructions.navigation;

import com.yoti.mobile.android.documentcapture.view.navigation.DocumentNavigationCoordinatorHelper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class AdditionalInstructionsCoordinator_Factory implements Factory<AdditionalInstructionsCoordinator> {
    private final Provider<DocumentNavigationCoordinatorHelper> documentNavigationCoordinatorHelperProvider;

    public AdditionalInstructionsCoordinator_Factory(Provider<DocumentNavigationCoordinatorHelper> provider) {
        this.documentNavigationCoordinatorHelperProvider = provider;
    }

    public static AdditionalInstructionsCoordinator_Factory create(Provider<DocumentNavigationCoordinatorHelper> provider) {
        return new AdditionalInstructionsCoordinator_Factory(provider);
    }

    public static AdditionalInstructionsCoordinator newInstance(DocumentNavigationCoordinatorHelper documentNavigationCoordinatorHelper) {
        return new AdditionalInstructionsCoordinator(documentNavigationCoordinatorHelper);
    }

    @Override // javax.inject.Provider
    public AdditionalInstructionsCoordinator get() {
        return newInstance(this.documentNavigationCoordinatorHelperProvider.get());
    }
}
