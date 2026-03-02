package com.yoti.mobile.android.facecapture.p070di.module;

import com.yoti.mobile.android.facecapture.view.educational.FaceCaptureGuidelinesViewDataFactory;
import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFailureType;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.facecapture.di.module.FaceCaptureModule_ProvidesLivenessGuidelinesViewDataFactoryFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4837xbe8f2e91 implements Factory<LivenessGuidelinesViewData.Factory<LivenessUploadFailureType>> {
    private final Provider<FaceCaptureGuidelinesViewDataFactory> actualProvider;
    private final FaceCaptureModule module;

    public C4837xbe8f2e91(FaceCaptureModule faceCaptureModule, Provider<FaceCaptureGuidelinesViewDataFactory> provider) {
        this.module = faceCaptureModule;
        this.actualProvider = provider;
    }

    public static C4837xbe8f2e91 create(FaceCaptureModule faceCaptureModule, Provider<FaceCaptureGuidelinesViewDataFactory> provider) {
        return new C4837xbe8f2e91(faceCaptureModule, provider);
    }

    public static LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> providesLivenessGuidelinesViewDataFactory(FaceCaptureModule faceCaptureModule, FaceCaptureGuidelinesViewDataFactory faceCaptureGuidelinesViewDataFactory) {
        return (LivenessGuidelinesViewData.Factory) Preconditions.checkNotNullFromProvides(faceCaptureModule.providesLivenessGuidelinesViewDataFactory(faceCaptureGuidelinesViewDataFactory));
    }

    @Override // javax.inject.Provider
    public LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> get() {
        return providesLivenessGuidelinesViewDataFactory(this.module, this.actualProvider.get());
    }
}
