package com.yoti.mobile.android.liveness.zoom.view.capture;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceTecErrorToSessionStatusTypeMapper_Factory implements Factory<FaceTecErrorToSessionStatusTypeMapper> {

    private static final class InstanceHolder {
        private static final FaceTecErrorToSessionStatusTypeMapper_Factory INSTANCE = new FaceTecErrorToSessionStatusTypeMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static FaceTecErrorToSessionStatusTypeMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FaceTecErrorToSessionStatusTypeMapper newInstance() {
        return new FaceTecErrorToSessionStatusTypeMapper();
    }

    @Override // javax.inject.Provider
    public FaceTecErrorToSessionStatusTypeMapper get() {
        return newInstance();
    }
}
