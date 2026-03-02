package com.yoti.mobile.android.liveness.zoom.view.navigation;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessFaceTecUploadNavigatorProvider_Factory implements Factory<LivenessFaceTecUploadNavigatorProvider> {

    private static final class InstanceHolder {
        private static final LivenessFaceTecUploadNavigatorProvider_Factory INSTANCE = new LivenessFaceTecUploadNavigatorProvider_Factory();

        private InstanceHolder() {
        }
    }

    public static LivenessFaceTecUploadNavigatorProvider_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static LivenessFaceTecUploadNavigatorProvider newInstance() {
        return new LivenessFaceTecUploadNavigatorProvider();
    }

    @Override // javax.inject.Provider
    public LivenessFaceTecUploadNavigatorProvider get() {
        return newInstance();
    }
}
