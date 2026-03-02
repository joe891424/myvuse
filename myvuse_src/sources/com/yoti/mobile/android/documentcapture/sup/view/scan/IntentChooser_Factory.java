package com.yoti.mobile.android.documentcapture.sup.view.scan;

import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class IntentChooser_Factory implements Factory<IntentChooser> {
    private final Provider<DocumentCaptureConfiguration> captureConfigurationProvider;
    private final Provider<SupDocumentFileProvider> fileProvider;

    public IntentChooser_Factory(Provider<SupDocumentFileProvider> provider, Provider<DocumentCaptureConfiguration> provider2) {
        this.fileProvider = provider;
        this.captureConfigurationProvider = provider2;
    }

    public static IntentChooser_Factory create(Provider<SupDocumentFileProvider> provider, Provider<DocumentCaptureConfiguration> provider2) {
        return new IntentChooser_Factory(provider, provider2);
    }

    public static IntentChooser newInstance(SupDocumentFileProvider supDocumentFileProvider, DocumentCaptureConfiguration documentCaptureConfiguration) {
        return new IntentChooser(supDocumentFileProvider, documentCaptureConfiguration);
    }

    @Override // javax.inject.Provider
    public IntentChooser get() {
        return newInstance(this.fileProvider.get(), this.captureConfigurationProvider.get());
    }
}
