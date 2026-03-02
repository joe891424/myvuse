package com.yoti.mobile.android.mrtd.data;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class NfcEventMapper_Factory implements Factory<NfcEventMapper> {

    private static final class InstanceHolder {
        private static final NfcEventMapper_Factory INSTANCE = new NfcEventMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static NfcEventMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static NfcEventMapper newInstance() {
        return new NfcEventMapper();
    }

    @Override // javax.inject.Provider
    public NfcEventMapper get() {
        return newInstance();
    }
}
