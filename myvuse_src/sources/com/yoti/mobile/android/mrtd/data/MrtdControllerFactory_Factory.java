package com.yoti.mobile.android.mrtd.data;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class MrtdControllerFactory_Factory implements Factory<MrtdControllerFactory> {

    private static final class InstanceHolder {
        private static final MrtdControllerFactory_Factory INSTANCE = new MrtdControllerFactory_Factory();

        private InstanceHolder() {
        }
    }

    public static MrtdControllerFactory_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static MrtdControllerFactory newInstance() {
        return new MrtdControllerFactory();
    }

    @Override // javax.inject.Provider
    public MrtdControllerFactory get() {
        return newInstance();
    }
}
