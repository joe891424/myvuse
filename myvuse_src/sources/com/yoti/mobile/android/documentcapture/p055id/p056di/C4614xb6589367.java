package com.yoti.mobile.android.documentcapture.p055id.p056di;

import dagger.internal.Factory;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.di.IdDocumentCaptureApiServiceModule_ProvidesSessionFeedbackActivationFlagFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4614xb6589367 implements Factory<Boolean> {
    private final IdDocumentCaptureApiServiceModule module;

    public C4614xb6589367(IdDocumentCaptureApiServiceModule idDocumentCaptureApiServiceModule) {
        this.module = idDocumentCaptureApiServiceModule;
    }

    public static C4614xb6589367 create(IdDocumentCaptureApiServiceModule idDocumentCaptureApiServiceModule) {
        return new C4614xb6589367(idDocumentCaptureApiServiceModule);
    }

    public static boolean providesSessionFeedbackActivationFlag(IdDocumentCaptureApiServiceModule idDocumentCaptureApiServiceModule) {
        return idDocumentCaptureApiServiceModule.providesSessionFeedbackActivationFlag();
    }

    @Override // javax.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(providesSessionFeedbackActivationFlag(this.module));
    }
}
