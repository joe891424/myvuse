package com.yoti.mobile.android.mrtd.domain;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class MrtdErrorHandler_Factory implements Factory<MrtdErrorHandler> {

    private static final class InstanceHolder {
        private static final MrtdErrorHandler_Factory INSTANCE = new MrtdErrorHandler_Factory();

        private InstanceHolder() {
        }
    }

    public static MrtdErrorHandler_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static MrtdErrorHandler newInstance() {
        return new MrtdErrorHandler();
    }

    @Override // javax.inject.Provider
    public MrtdErrorHandler get() {
        return newInstance();
    }
}
