package com.yoti.mobile.android.facecapture.view.educational;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceCaptureGuidelinesViewDataFactory_Factory implements Factory<FaceCaptureGuidelinesViewDataFactory> {

    private static final class InstanceHolder {
        private static final FaceCaptureGuidelinesViewDataFactory_Factory INSTANCE = new FaceCaptureGuidelinesViewDataFactory_Factory();

        private InstanceHolder() {
        }
    }

    public static FaceCaptureGuidelinesViewDataFactory_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FaceCaptureGuidelinesViewDataFactory newInstance() {
        return new FaceCaptureGuidelinesViewDataFactory();
    }

    @Override // javax.inject.Provider
    public FaceCaptureGuidelinesViewDataFactory get() {
        return newInstance();
    }
}
