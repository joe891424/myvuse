package com.yoti.mobile.android.liveness.p071di.module;

import com.yoti.mobile.android.liveness.view.educational.ILivenessEducationalViewConfiguration;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: renamed from: com.yoti.mobile.android.liveness.di.module.LivenessCoreEducationalModule_ProvidesEducationalViewConfigurationFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4875x6bffa058 implements Factory<ILivenessEducationalViewConfiguration> {
    private final LivenessCoreEducationalModule module;

    public C4875x6bffa058(LivenessCoreEducationalModule livenessCoreEducationalModule) {
        this.module = livenessCoreEducationalModule;
    }

    public static C4875x6bffa058 create(LivenessCoreEducationalModule livenessCoreEducationalModule) {
        return new C4875x6bffa058(livenessCoreEducationalModule);
    }

    public static ILivenessEducationalViewConfiguration providesEducationalViewConfiguration(LivenessCoreEducationalModule livenessCoreEducationalModule) {
        return (ILivenessEducationalViewConfiguration) Preconditions.checkNotNullFromProvides(livenessCoreEducationalModule.providesEducationalViewConfiguration());
    }

    @Override // javax.inject.Provider
    public ILivenessEducationalViewConfiguration get() {
        return providesEducationalViewConfiguration(this.module);
    }
}
