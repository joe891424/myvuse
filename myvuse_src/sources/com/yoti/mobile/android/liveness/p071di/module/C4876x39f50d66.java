package com.yoti.mobile.android.liveness.p071di.module;

import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFailureType;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: renamed from: com.yoti.mobile.android.liveness.di.module.LivenessCoreEducationalModule_ProvidesGuidelinesViewDataFactoryFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4876x39f50d66 implements Factory<LivenessGuidelinesViewData.Factory<LivenessUploadFailureType>> {
    private final LivenessCoreEducationalModule module;

    public C4876x39f50d66(LivenessCoreEducationalModule livenessCoreEducationalModule) {
        this.module = livenessCoreEducationalModule;
    }

    public static C4876x39f50d66 create(LivenessCoreEducationalModule livenessCoreEducationalModule) {
        return new C4876x39f50d66(livenessCoreEducationalModule);
    }

    public static LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> providesGuidelinesViewDataFactory(LivenessCoreEducationalModule livenessCoreEducationalModule) {
        return (LivenessGuidelinesViewData.Factory) Preconditions.checkNotNullFromProvides(livenessCoreEducationalModule.providesGuidelinesViewDataFactory());
    }

    @Override // javax.inject.Provider
    public LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> get() {
        return providesGuidelinesViewDataFactory(this.module);
    }
}
