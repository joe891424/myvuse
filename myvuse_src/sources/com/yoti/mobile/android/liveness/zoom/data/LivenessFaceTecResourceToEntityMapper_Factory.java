package com.yoti.mobile.android.liveness.zoom.data;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessFaceTecResourceToEntityMapper_Factory implements Factory<LivenessFaceTecResourceToEntityMapper> {

    private static final class InstanceHolder {
        private static final LivenessFaceTecResourceToEntityMapper_Factory INSTANCE = new LivenessFaceTecResourceToEntityMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static LivenessFaceTecResourceToEntityMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static LivenessFaceTecResourceToEntityMapper newInstance() {
        return new LivenessFaceTecResourceToEntityMapper();
    }

    @Override // javax.inject.Provider
    public LivenessFaceTecResourceToEntityMapper get() {
        return newInstance();
    }
}
