package com.yoti.mobile.android.documentcapture.p055id.data;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes5.dex */
public final class AddressEntityToDataMapper_Factory implements Factory<AddressEntityToDataMapper> {

    private static final class InstanceHolder {
        private static final AddressEntityToDataMapper_Factory INSTANCE = new AddressEntityToDataMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static AddressEntityToDataMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AddressEntityToDataMapper newInstance() {
        return new AddressEntityToDataMapper();
    }

    @Override // javax.inject.Provider
    public AddressEntityToDataMapper get() {
        return newInstance();
    }
}
