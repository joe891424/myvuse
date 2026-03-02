package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes5.dex */
public final class ScanErrorToEntityMapper_Factory implements Factory<ScanErrorToEntityMapper> {

    private static final class InstanceHolder {
        private static final ScanErrorToEntityMapper_Factory INSTANCE = new ScanErrorToEntityMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static ScanErrorToEntityMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ScanErrorToEntityMapper newInstance() {
        return new ScanErrorToEntityMapper();
    }

    @Override // javax.inject.Provider
    public ScanErrorToEntityMapper get() {
        return newInstance();
    }
}
