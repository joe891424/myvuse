package com.yoti.mobile.android.documentcapture.sup.p057di;

import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes5.dex */
public final class SupDocumentCaptureModule_ProvidesFeatureConfigurationFactory implements Factory<DocumentCaptureConfiguration> {
    private final SupDocumentCaptureModule module;

    public SupDocumentCaptureModule_ProvidesFeatureConfigurationFactory(SupDocumentCaptureModule supDocumentCaptureModule) {
        this.module = supDocumentCaptureModule;
    }

    public static SupDocumentCaptureModule_ProvidesFeatureConfigurationFactory create(SupDocumentCaptureModule supDocumentCaptureModule) {
        return new SupDocumentCaptureModule_ProvidesFeatureConfigurationFactory(supDocumentCaptureModule);
    }

    public static DocumentCaptureConfiguration providesFeatureConfiguration(SupDocumentCaptureModule supDocumentCaptureModule) {
        return (DocumentCaptureConfiguration) Preconditions.checkNotNullFromProvides(supDocumentCaptureModule.getFeatureConfiguration());
    }

    @Override // javax.inject.Provider
    public DocumentCaptureConfiguration get() {
        return providesFeatureConfiguration(this.module);
    }
}
