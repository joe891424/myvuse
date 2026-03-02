package com.yoti.mobile.android.liveness.zoom.data;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessFaceTecCaptureEntityToDataMapper_Factory implements Factory<LivenessFaceTecCaptureEntityToDataMapper> {

    private static final class InstanceHolder {
        private static final LivenessFaceTecCaptureEntityToDataMapper_Factory INSTANCE = new LivenessFaceTecCaptureEntityToDataMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static LivenessFaceTecCaptureEntityToDataMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static LivenessFaceTecCaptureEntityToDataMapper newInstance() {
        return new LivenessFaceTecCaptureEntityToDataMapper();
    }

    @Override // javax.inject.Provider
    public LivenessFaceTecCaptureEntityToDataMapper get() {
        return newInstance();
    }
}
