package com.yoti.mobile.android.documentcapture.p054di;

import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.di.DocumentCaptureCoreModule_ProvidesDocumentCaptureConfigurationFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4599xe5632e24 implements Factory<DocumentCaptureConfiguration> {
    private final DocumentCaptureCoreModule module;

    public C4599xe5632e24(DocumentCaptureCoreModule documentCaptureCoreModule) {
        this.module = documentCaptureCoreModule;
    }

    public static C4599xe5632e24 create(DocumentCaptureCoreModule documentCaptureCoreModule) {
        return new C4599xe5632e24(documentCaptureCoreModule);
    }

    public static DocumentCaptureConfiguration providesDocumentCaptureConfiguration(DocumentCaptureCoreModule documentCaptureCoreModule) {
        return (DocumentCaptureConfiguration) Preconditions.checkNotNullFromProvides(documentCaptureCoreModule.getFeatureConfiguration());
    }

    @Override // javax.inject.Provider
    public DocumentCaptureConfiguration get() {
        return providesDocumentCaptureConfiguration(this.module);
    }
}
