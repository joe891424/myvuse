package com.yoti.mobile.android.facecapture.data.remote;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceCaptureResourceResponseToEntityMapper_Factory implements Factory<FaceCaptureResourceResponseToEntityMapper> {

    private static final class InstanceHolder {
        private static final FaceCaptureResourceResponseToEntityMapper_Factory INSTANCE = new FaceCaptureResourceResponseToEntityMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static FaceCaptureResourceResponseToEntityMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FaceCaptureResourceResponseToEntityMapper newInstance() {
        return new FaceCaptureResourceResponseToEntityMapper();
    }

    @Override // javax.inject.Provider
    public FaceCaptureResourceResponseToEntityMapper get() {
        return newInstance();
    }
}
