package com.yoti.mobile.android.liveness.zoom.view.capture;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceTecErrorToFailureMapper_Factory implements Factory<FaceTecErrorToFailureMapper> {

    private static final class InstanceHolder {
        private static final FaceTecErrorToFailureMapper_Factory INSTANCE = new FaceTecErrorToFailureMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static FaceTecErrorToFailureMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FaceTecErrorToFailureMapper newInstance() {
        return new FaceTecErrorToFailureMapper();
    }

    @Override // javax.inject.Provider
    public FaceTecErrorToFailureMapper get() {
        return newInstance();
    }
}
