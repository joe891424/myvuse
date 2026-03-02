package com.yoti.mobile.android.documentcapture.sup.view.scan.automation;

import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class AutomationCaptureActivity_MembersInjector implements MembersInjector<AutomationCaptureActivity> {
    private final Provider<AutomationSupDocFileUriProvider> supDocFileUriProvider;

    public AutomationCaptureActivity_MembersInjector(Provider<AutomationSupDocFileUriProvider> provider) {
        this.supDocFileUriProvider = provider;
    }

    public static MembersInjector<AutomationCaptureActivity> create(Provider<AutomationSupDocFileUriProvider> provider) {
        return new AutomationCaptureActivity_MembersInjector(provider);
    }

    public static void injectSupDocFileUriProvider(AutomationCaptureActivity automationCaptureActivity, AutomationSupDocFileUriProvider automationSupDocFileUriProvider) {
        automationCaptureActivity.supDocFileUriProvider = automationSupDocFileUriProvider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(AutomationCaptureActivity automationCaptureActivity) {
        injectSupDocFileUriProvider(automationCaptureActivity, this.supDocFileUriProvider.get());
    }
}
