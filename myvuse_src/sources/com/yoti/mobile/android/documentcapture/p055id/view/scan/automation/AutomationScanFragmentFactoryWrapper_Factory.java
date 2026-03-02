package com.yoti.mobile.android.documentcapture.p055id.view.scan.automation;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes5.dex */
public final class AutomationScanFragmentFactoryWrapper_Factory implements Factory<AutomationScanFragmentFactoryWrapper> {

    private static final class InstanceHolder {
        private static final AutomationScanFragmentFactoryWrapper_Factory INSTANCE = new AutomationScanFragmentFactoryWrapper_Factory();

        private InstanceHolder() {
        }
    }

    public static AutomationScanFragmentFactoryWrapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AutomationScanFragmentFactoryWrapper newInstance() {
        return new AutomationScanFragmentFactoryWrapper();
    }

    @Override // javax.inject.Provider
    public AutomationScanFragmentFactoryWrapper get() {
        return newInstance();
    }
}
