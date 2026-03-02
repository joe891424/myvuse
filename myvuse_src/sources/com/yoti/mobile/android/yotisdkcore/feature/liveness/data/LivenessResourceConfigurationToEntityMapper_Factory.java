package com.yoti.mobile.android.yotisdkcore.feature.liveness.data;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessResourceConfigurationToEntityMapper_Factory implements Factory<LivenessResourceConfigurationToEntityMapper> {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.feature.liveness.data.LivenessResourceConfigurationToEntityMapper_Factory$a */
    private static final class C4994a {

        /* JADX INFO: renamed from: a */
        private static final LivenessResourceConfigurationToEntityMapper_Factory f7619a = new LivenessResourceConfigurationToEntityMapper_Factory();
    }

    public static LivenessResourceConfigurationToEntityMapper_Factory create() {
        return C4994a.f7619a;
    }

    public static LivenessResourceConfigurationToEntityMapper newInstance() {
        return new LivenessResourceConfigurationToEntityMapper();
    }

    @Override // javax.inject.Provider
    public LivenessResourceConfigurationToEntityMapper get() {
        return newInstance();
    }
}
