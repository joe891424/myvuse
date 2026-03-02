package com.yoti.mobile.android.liveness.zoom.view.capture.automation;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class AutomationFaceTecInitializer_Factory implements Factory<AutomationFaceTecInitializer> {

    private static final class InstanceHolder {
        private static final AutomationFaceTecInitializer_Factory INSTANCE = new AutomationFaceTecInitializer_Factory();

        private InstanceHolder() {
        }
    }

    public static AutomationFaceTecInitializer_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AutomationFaceTecInitializer newInstance() {
        return new AutomationFaceTecInitializer();
    }

    @Override // javax.inject.Provider
    public AutomationFaceTecInitializer get() {
        return newInstance();
    }
}
