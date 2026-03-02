package com.yoti.mobile.android.liveness.view.educational;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessGuidelinesViewDataFactory_Factory implements Factory<LivenessGuidelinesViewDataFactory> {

    private static final class InstanceHolder {
        private static final LivenessGuidelinesViewDataFactory_Factory INSTANCE = new LivenessGuidelinesViewDataFactory_Factory();

        private InstanceHolder() {
        }
    }

    public static LivenessGuidelinesViewDataFactory_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static LivenessGuidelinesViewDataFactory newInstance() {
        return new LivenessGuidelinesViewDataFactory();
    }

    @Override // javax.inject.Provider
    public LivenessGuidelinesViewDataFactory get() {
        return newInstance();
    }
}
