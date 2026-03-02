package com.yoti.mobile.android.facecapture.view.navigation;

import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFailureType;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceCaptureEducationalNavigatorProvider_Factory implements Factory<FaceCaptureEducationalNavigatorProvider> {
    private final Provider<LivenessGuidelinesViewData.Factory<LivenessUploadFailureType>> guidelinesViewDataFactoryProvider;

    public FaceCaptureEducationalNavigatorProvider_Factory(Provider<LivenessGuidelinesViewData.Factory<LivenessUploadFailureType>> provider) {
        this.guidelinesViewDataFactoryProvider = provider;
    }

    public static FaceCaptureEducationalNavigatorProvider_Factory create(Provider<LivenessGuidelinesViewData.Factory<LivenessUploadFailureType>> provider) {
        return new FaceCaptureEducationalNavigatorProvider_Factory(provider);
    }

    public static FaceCaptureEducationalNavigatorProvider newInstance(LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> factory) {
        return new FaceCaptureEducationalNavigatorProvider(factory);
    }

    @Override // javax.inject.Provider
    public FaceCaptureEducationalNavigatorProvider get() {
        return newInstance(this.guidelinesViewDataFactoryProvider.get());
    }
}
