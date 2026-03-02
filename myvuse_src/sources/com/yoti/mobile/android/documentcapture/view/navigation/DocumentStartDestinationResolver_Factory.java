package com.yoti.mobile.android.documentcapture.view.navigation;

import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentStartDestinationResolver_Factory implements Factory<DocumentStartDestinationResolver> {
    private final Provider<DocumentCaptureConfiguration> featureConfigurationProvider;

    public DocumentStartDestinationResolver_Factory(Provider<DocumentCaptureConfiguration> provider) {
        this.featureConfigurationProvider = provider;
    }

    public static DocumentStartDestinationResolver_Factory create(Provider<DocumentCaptureConfiguration> provider) {
        return new DocumentStartDestinationResolver_Factory(provider);
    }

    public static DocumentStartDestinationResolver newInstance(DocumentCaptureConfiguration documentCaptureConfiguration) {
        return new DocumentStartDestinationResolver(documentCaptureConfiguration);
    }

    @Override // javax.inject.Provider
    public DocumentStartDestinationResolver get() {
        return newInstance(this.featureConfigurationProvider.get());
    }
}
