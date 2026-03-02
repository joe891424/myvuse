package com.yoti.mobile.android.facecapture.view.capture;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceCaptureToEntityMapper_Factory implements Factory<FaceCaptureToEntityMapper> {

    private static final class InstanceHolder {
        private static final FaceCaptureToEntityMapper_Factory INSTANCE = new FaceCaptureToEntityMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static FaceCaptureToEntityMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FaceCaptureToEntityMapper newInstance() {
        return new FaceCaptureToEntityMapper();
    }

    @Override // javax.inject.Provider
    public FaceCaptureToEntityMapper get() {
        return newInstance();
    }
}
