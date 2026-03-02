package com.yoti.mobile.android.documentcapture.p054di;

import android.content.Context;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentCaptureCoreSession_Factory implements Factory<DocumentCaptureCoreSession> {
    private final Provider<Context> appContextProvider;
    private final Provider<DocumentCaptureConfiguration> featureConfigurationProvider;
    private final Provider<IDocumentScanDependenciesProvider> scanDependenciesProvider;
    private final Provider<IDocumentSelectionDependenciesProvider> selectionDependenciesProvider;
    private final Provider<IDocumentUploadDependenciesProvider> uploadDependenciesProvider;

    public DocumentCaptureCoreSession_Factory(Provider<Context> provider, Provider<IDocumentSelectionDependenciesProvider> provider2, Provider<IDocumentScanDependenciesProvider> provider3, Provider<IDocumentUploadDependenciesProvider> provider4, Provider<DocumentCaptureConfiguration> provider5) {
        this.appContextProvider = provider;
        this.selectionDependenciesProvider = provider2;
        this.scanDependenciesProvider = provider3;
        this.uploadDependenciesProvider = provider4;
        this.featureConfigurationProvider = provider5;
    }

    public static DocumentCaptureCoreSession_Factory create(Provider<Context> provider, Provider<IDocumentSelectionDependenciesProvider> provider2, Provider<IDocumentScanDependenciesProvider> provider3, Provider<IDocumentUploadDependenciesProvider> provider4, Provider<DocumentCaptureConfiguration> provider5) {
        return new DocumentCaptureCoreSession_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static DocumentCaptureCoreSession newInstance(Context context, IDocumentSelectionDependenciesProvider iDocumentSelectionDependenciesProvider, IDocumentScanDependenciesProvider iDocumentScanDependenciesProvider, IDocumentUploadDependenciesProvider iDocumentUploadDependenciesProvider, DocumentCaptureConfiguration documentCaptureConfiguration) {
        return new DocumentCaptureCoreSession(context, iDocumentSelectionDependenciesProvider, iDocumentScanDependenciesProvider, iDocumentUploadDependenciesProvider, documentCaptureConfiguration);
    }

    @Override // javax.inject.Provider
    public DocumentCaptureCoreSession get() {
        return newInstance(this.appContextProvider.get(), this.selectionDependenciesProvider.get(), this.scanDependenciesProvider.get(), this.uploadDependenciesProvider.get(), this.featureConfigurationProvider.get());
    }
}
