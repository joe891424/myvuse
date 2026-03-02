package com.yoti.mobile.android.documentcapture.view.selection;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes5.dex */
public final class CaptureObjectiveTypeEntityToViewDataMapper_Factory implements Factory<CaptureObjectiveTypeEntityToViewDataMapper> {

    private static final class InstanceHolder {
        private static final CaptureObjectiveTypeEntityToViewDataMapper_Factory INSTANCE = new CaptureObjectiveTypeEntityToViewDataMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static CaptureObjectiveTypeEntityToViewDataMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CaptureObjectiveTypeEntityToViewDataMapper newInstance() {
        return new CaptureObjectiveTypeEntityToViewDataMapper();
    }

    @Override // javax.inject.Provider
    public CaptureObjectiveTypeEntityToViewDataMapper get() {
        return newInstance();
    }
}
