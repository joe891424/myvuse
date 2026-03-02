package com.yoti.mobile.android.documentcapture.sup.view.scan.automation;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class AutomationChooser_Factory implements Factory<AutomationChooser> {
    private final Provider<AutomationSupDocFileUriProvider> supDocFileUriProvider;

    public AutomationChooser_Factory(Provider<AutomationSupDocFileUriProvider> provider) {
        this.supDocFileUriProvider = provider;
    }

    public static AutomationChooser_Factory create(Provider<AutomationSupDocFileUriProvider> provider) {
        return new AutomationChooser_Factory(provider);
    }

    public static AutomationChooser newInstance(AutomationSupDocFileUriProvider automationSupDocFileUriProvider) {
        return new AutomationChooser(automationSupDocFileUriProvider);
    }

    @Override // javax.inject.Provider
    public AutomationChooser get() {
        return newInstance(this.supDocFileUriProvider.get());
    }
}
