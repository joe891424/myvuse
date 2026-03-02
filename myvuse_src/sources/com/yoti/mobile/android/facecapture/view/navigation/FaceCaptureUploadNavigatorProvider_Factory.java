package com.yoti.mobile.android.facecapture.view.navigation;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceCaptureUploadNavigatorProvider_Factory implements Factory<FaceCaptureUploadNavigatorProvider> {

    private static final class InstanceHolder {
        private static final FaceCaptureUploadNavigatorProvider_Factory INSTANCE = new FaceCaptureUploadNavigatorProvider_Factory();

        private InstanceHolder() {
        }
    }

    public static FaceCaptureUploadNavigatorProvider_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FaceCaptureUploadNavigatorProvider newInstance() {
        return new FaceCaptureUploadNavigatorProvider();
    }

    @Override // javax.inject.Provider
    public FaceCaptureUploadNavigatorProvider get() {
        return newInstance();
    }
}
