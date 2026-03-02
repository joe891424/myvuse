package com.yoti.mobile.android.documentcapture.view.requirements;

import com.yoti.mobile.android.documentcapture.view.navigation.DocumentNavigationCoordinatorHelper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentRequirementsCoordinator_Factory implements Factory<DocumentRequirementsCoordinator> {
    private final Provider<DocumentNavigationCoordinatorHelper> documentNavigationCoordinatorHelperProvider;

    public DocumentRequirementsCoordinator_Factory(Provider<DocumentNavigationCoordinatorHelper> provider) {
        this.documentNavigationCoordinatorHelperProvider = provider;
    }

    public static DocumentRequirementsCoordinator_Factory create(Provider<DocumentNavigationCoordinatorHelper> provider) {
        return new DocumentRequirementsCoordinator_Factory(provider);
    }

    public static DocumentRequirementsCoordinator newInstance(DocumentNavigationCoordinatorHelper documentNavigationCoordinatorHelper) {
        return new DocumentRequirementsCoordinator(documentNavigationCoordinatorHelper);
    }

    @Override // javax.inject.Provider
    public DocumentRequirementsCoordinator get() {
        return newInstance(this.documentNavigationCoordinatorHelperProvider.get());
    }
}
