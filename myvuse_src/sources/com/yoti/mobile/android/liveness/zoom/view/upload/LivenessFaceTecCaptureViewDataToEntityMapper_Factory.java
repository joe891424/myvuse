package com.yoti.mobile.android.liveness.zoom.view.upload;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessFaceTecCaptureViewDataToEntityMapper_Factory implements Factory<LivenessFaceTecCaptureViewDataToEntityMapper> {

    private static final class InstanceHolder {
        private static final LivenessFaceTecCaptureViewDataToEntityMapper_Factory INSTANCE = new LivenessFaceTecCaptureViewDataToEntityMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static LivenessFaceTecCaptureViewDataToEntityMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static LivenessFaceTecCaptureViewDataToEntityMapper newInstance() {
        return new LivenessFaceTecCaptureViewDataToEntityMapper();
    }

    @Override // javax.inject.Provider
    public LivenessFaceTecCaptureViewDataToEntityMapper get() {
        return newInstance();
    }
}
