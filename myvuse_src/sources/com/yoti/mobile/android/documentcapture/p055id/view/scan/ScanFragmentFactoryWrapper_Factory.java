package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes5.dex */
public final class ScanFragmentFactoryWrapper_Factory implements Factory<ScanFragmentFactoryWrapper> {

    private static final class InstanceHolder {
        private static final ScanFragmentFactoryWrapper_Factory INSTANCE = new ScanFragmentFactoryWrapper_Factory();

        private InstanceHolder() {
        }
    }

    public static ScanFragmentFactoryWrapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ScanFragmentFactoryWrapper newInstance() {
        return new ScanFragmentFactoryWrapper();
    }

    @Override // javax.inject.Provider
    public ScanFragmentFactoryWrapper get() {
        return newInstance();
    }
}
