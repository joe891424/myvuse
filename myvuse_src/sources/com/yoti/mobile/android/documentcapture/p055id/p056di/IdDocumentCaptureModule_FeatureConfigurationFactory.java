package com.yoti.mobile.android.documentcapture.p055id.p056di;

import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes5.dex */
public final class IdDocumentCaptureModule_FeatureConfigurationFactory implements Factory<DocumentCaptureConfiguration> {
    private final IdDocumentCaptureModule module;

    public IdDocumentCaptureModule_FeatureConfigurationFactory(IdDocumentCaptureModule idDocumentCaptureModule) {
        this.module = idDocumentCaptureModule;
    }

    public static IdDocumentCaptureModule_FeatureConfigurationFactory create(IdDocumentCaptureModule idDocumentCaptureModule) {
        return new IdDocumentCaptureModule_FeatureConfigurationFactory(idDocumentCaptureModule);
    }

    public static DocumentCaptureConfiguration featureConfiguration(IdDocumentCaptureModule idDocumentCaptureModule) {
        return (DocumentCaptureConfiguration) Preconditions.checkNotNullFromProvides(idDocumentCaptureModule.getFeatureConfiguration());
    }

    @Override // javax.inject.Provider
    public DocumentCaptureConfiguration get() {
        return featureConfiguration(this.module);
    }
}
