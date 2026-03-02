package com.yoti.mobile.android.documentcapture.p055id.data;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes5.dex */
public final class NfcEntityToDataMapper_Factory implements Factory<NfcEntityToDataMapper> {

    private static final class InstanceHolder {
        private static final NfcEntityToDataMapper_Factory INSTANCE = new NfcEntityToDataMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static NfcEntityToDataMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static NfcEntityToDataMapper newInstance() {
        return new NfcEntityToDataMapper();
    }

    @Override // javax.inject.Provider
    public NfcEntityToDataMapper get() {
        return newInstance();
    }
}
