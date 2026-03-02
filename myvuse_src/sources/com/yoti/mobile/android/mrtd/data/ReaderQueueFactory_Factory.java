package com.yoti.mobile.android.mrtd.data;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class ReaderQueueFactory_Factory implements Factory<ReaderQueueFactory> {

    private static final class InstanceHolder {
        private static final ReaderQueueFactory_Factory INSTANCE = new ReaderQueueFactory_Factory();

        private InstanceHolder() {
        }
    }

    public static ReaderQueueFactory_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ReaderQueueFactory newInstance() {
        return new ReaderQueueFactory();
    }

    @Override // javax.inject.Provider
    public ReaderQueueFactory get() {
        return newInstance();
    }
}
