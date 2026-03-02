package com.yoti.mobile.android.facecapture.view.capture;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceCaptureStateMachineFactory_Factory implements Factory<FaceCaptureStateMachineFactory> {

    private static final class InstanceHolder {
        private static final FaceCaptureStateMachineFactory_Factory INSTANCE = new FaceCaptureStateMachineFactory_Factory();

        private InstanceHolder() {
        }
    }

    public static FaceCaptureStateMachineFactory_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FaceCaptureStateMachineFactory newInstance() {
        return new FaceCaptureStateMachineFactory();
    }

    @Override // javax.inject.Provider
    public FaceCaptureStateMachineFactory get() {
        return newInstance();
    }
}
