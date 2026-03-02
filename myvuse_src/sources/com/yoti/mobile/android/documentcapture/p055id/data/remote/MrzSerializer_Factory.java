package com.yoti.mobile.android.documentcapture.p055id.data.remote;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes5.dex */
public final class MrzSerializer_Factory implements Factory<MrzSerializer> {

    private static final class InstanceHolder {
        private static final MrzSerializer_Factory INSTANCE = new MrzSerializer_Factory();

        private InstanceHolder() {
        }
    }

    public static MrzSerializer_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static MrzSerializer newInstance() {
        return new MrzSerializer();
    }

    @Override // javax.inject.Provider
    public MrzSerializer get() {
        return newInstance();
    }
}
