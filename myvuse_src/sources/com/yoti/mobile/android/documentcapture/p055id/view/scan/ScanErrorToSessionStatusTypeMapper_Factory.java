package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes5.dex */
public final class ScanErrorToSessionStatusTypeMapper_Factory implements Factory<ScanErrorToSessionStatusTypeMapper> {

    private static final class InstanceHolder {
        private static final ScanErrorToSessionStatusTypeMapper_Factory INSTANCE = new ScanErrorToSessionStatusTypeMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static ScanErrorToSessionStatusTypeMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ScanErrorToSessionStatusTypeMapper newInstance() {
        return new ScanErrorToSessionStatusTypeMapper();
    }

    @Override // javax.inject.Provider
    public ScanErrorToSessionStatusTypeMapper get() {
        return newInstance();
    }
}
