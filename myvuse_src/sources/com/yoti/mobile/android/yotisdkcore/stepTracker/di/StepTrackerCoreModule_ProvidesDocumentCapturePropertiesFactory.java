package com.yoti.mobile.android.yotisdkcore.stepTracker.di;

import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.DocumentCaptureProperties;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes4.dex */
public final class StepTrackerCoreModule_ProvidesDocumentCapturePropertiesFactory implements Factory<DocumentCaptureProperties> {

    /* JADX INFO: renamed from: a */
    private final StepTrackerCoreModule f7627a;

    public StepTrackerCoreModule_ProvidesDocumentCapturePropertiesFactory(StepTrackerCoreModule stepTrackerCoreModule) {
        this.f7627a = stepTrackerCoreModule;
    }

    public static StepTrackerCoreModule_ProvidesDocumentCapturePropertiesFactory create(StepTrackerCoreModule stepTrackerCoreModule) {
        return new StepTrackerCoreModule_ProvidesDocumentCapturePropertiesFactory(stepTrackerCoreModule);
    }

    public static DocumentCaptureProperties providesDocumentCaptureProperties(StepTrackerCoreModule stepTrackerCoreModule) {
        return (DocumentCaptureProperties) Preconditions.checkNotNullFromProvides(stepTrackerCoreModule.m5150b());
    }

    @Override // javax.inject.Provider
    public DocumentCaptureProperties get() {
        return providesDocumentCaptureProperties(this.f7627a);
    }
}
