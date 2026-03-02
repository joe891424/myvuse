package com.yoti.mobile.android.liveness.zoom.p072di.module;

import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData;
import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewDataFactory;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFailureType;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.liveness.zoom.di.module.LivenessFaceTecModule_ProvidesLivenessGuidelinesViewDataFactoryFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4895xce5e64e8 implements Factory<LivenessGuidelinesViewData.Factory<LivenessUploadFailureType>> {
    private final Provider<LivenessGuidelinesViewDataFactory> actualProvider;
    private final LivenessFaceTecModule module;

    public C4895xce5e64e8(LivenessFaceTecModule livenessFaceTecModule, Provider<LivenessGuidelinesViewDataFactory> provider) {
        this.module = livenessFaceTecModule;
        this.actualProvider = provider;
    }

    public static C4895xce5e64e8 create(LivenessFaceTecModule livenessFaceTecModule, Provider<LivenessGuidelinesViewDataFactory> provider) {
        return new C4895xce5e64e8(livenessFaceTecModule, provider);
    }

    public static LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> providesLivenessGuidelinesViewDataFactory(LivenessFaceTecModule livenessFaceTecModule, LivenessGuidelinesViewDataFactory livenessGuidelinesViewDataFactory) {
        return (LivenessGuidelinesViewData.Factory) Preconditions.checkNotNullFromProvides(livenessFaceTecModule.providesLivenessGuidelinesViewDataFactory(livenessGuidelinesViewDataFactory));
    }

    @Override // javax.inject.Provider
    public LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> get() {
        return providesLivenessGuidelinesViewDataFactory(this.module, this.actualProvider.get());
    }
}
