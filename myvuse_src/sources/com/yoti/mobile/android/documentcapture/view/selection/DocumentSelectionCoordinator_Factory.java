package com.yoti.mobile.android.documentcapture.view.selection;

import com.yoti.mobile.android.documentcapture.view.navigation.DocumentNavigationCoordinatorHelper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentSelectionCoordinator_Factory implements Factory<DocumentSelectionCoordinator> {
    private final Provider<DocumentNavigationCoordinatorHelper> documentNavigationCoordinatorHelperProvider;

    public DocumentSelectionCoordinator_Factory(Provider<DocumentNavigationCoordinatorHelper> provider) {
        this.documentNavigationCoordinatorHelperProvider = provider;
    }

    public static DocumentSelectionCoordinator_Factory create(Provider<DocumentNavigationCoordinatorHelper> provider) {
        return new DocumentSelectionCoordinator_Factory(provider);
    }

    public static DocumentSelectionCoordinator newInstance(DocumentNavigationCoordinatorHelper documentNavigationCoordinatorHelper) {
        return new DocumentSelectionCoordinator(documentNavigationCoordinatorHelper);
    }

    @Override // javax.inject.Provider
    public DocumentSelectionCoordinator get() {
        return newInstance(this.documentNavigationCoordinatorHelperProvider.get());
    }
}
