package com.yoti.mobile.android.mrtd.data;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class MrtdReaderFactory_Factory implements Factory<MrtdReaderFactory> {

    private static final class InstanceHolder {
        private static final MrtdReaderFactory_Factory INSTANCE = new MrtdReaderFactory_Factory();

        private InstanceHolder() {
        }
    }

    public static MrtdReaderFactory_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static MrtdReaderFactory newInstance() {
        return new MrtdReaderFactory();
    }

    @Override // javax.inject.Provider
    public MrtdReaderFactory get() {
        return newInstance();
    }
}
