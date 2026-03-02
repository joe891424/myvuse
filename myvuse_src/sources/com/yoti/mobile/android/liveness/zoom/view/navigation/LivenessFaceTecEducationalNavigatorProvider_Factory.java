package com.yoti.mobile.android.liveness.zoom.view.navigation;

import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFailureType;
import com.yoti.mobile.android.liveness.zoom.view.capture.IFaceTecInitializer;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessFaceTecEducationalNavigatorProvider_Factory implements Factory<LivenessFaceTecEducationalNavigatorProvider> {
    private final Provider<IFaceTecInitializer> faceTecInitializerProvider;
    private final Provider<LivenessGuidelinesViewData.Factory<LivenessUploadFailureType>> guidelinesViewDataFactoryProvider;

    public LivenessFaceTecEducationalNavigatorProvider_Factory(Provider<IFaceTecInitializer> provider, Provider<LivenessGuidelinesViewData.Factory<LivenessUploadFailureType>> provider2) {
        this.faceTecInitializerProvider = provider;
        this.guidelinesViewDataFactoryProvider = provider2;
    }

    public static LivenessFaceTecEducationalNavigatorProvider_Factory create(Provider<IFaceTecInitializer> provider, Provider<LivenessGuidelinesViewData.Factory<LivenessUploadFailureType>> provider2) {
        return new LivenessFaceTecEducationalNavigatorProvider_Factory(provider, provider2);
    }

    public static LivenessFaceTecEducationalNavigatorProvider newInstance(IFaceTecInitializer iFaceTecInitializer, LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> factory) {
        return new LivenessFaceTecEducationalNavigatorProvider(iFaceTecInitializer, factory);
    }

    @Override // javax.inject.Provider
    public LivenessFaceTecEducationalNavigatorProvider get() {
        return newInstance(this.faceTecInitializerProvider.get(), this.guidelinesViewDataFactoryProvider.get());
    }
}
