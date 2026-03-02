package com.yoti.mobile.android.liveness.zoom.view.capture.automation;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class AutomationFaceTecResultProcessor_Factory implements Factory<AutomationFaceTecResultProcessor> {
    private final Provider<AutomationFaceTecLivenessResultProvider> faceTecLivenessResultProvider;

    public AutomationFaceTecResultProcessor_Factory(Provider<AutomationFaceTecLivenessResultProvider> provider) {
        this.faceTecLivenessResultProvider = provider;
    }

    public static AutomationFaceTecResultProcessor_Factory create(Provider<AutomationFaceTecLivenessResultProvider> provider) {
        return new AutomationFaceTecResultProcessor_Factory(provider);
    }

    public static AutomationFaceTecResultProcessor newInstance(AutomationFaceTecLivenessResultProvider automationFaceTecLivenessResultProvider) {
        return new AutomationFaceTecResultProcessor(automationFaceTecLivenessResultProvider);
    }

    @Override // javax.inject.Provider
    public AutomationFaceTecResultProcessor get() {
        return newInstance(this.faceTecLivenessResultProvider.get());
    }
}
