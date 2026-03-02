package com.yoti.mobile.android.documentcapture.sup.p057di;

import com.yoti.mobile.android.documentcapture.sup.view.scan.ICaptureChooser;
import com.yoti.mobile.android.documentcapture.sup.view.scan.IntentChooser;
import com.yoti.mobile.android.documentcapture.sup.view.scan.automation.AutomationChooser;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class SupDocumentCaptureModule_ProvidesCaptureChooserFactory implements Factory<ICaptureChooser> {
    private final Provider<AutomationChooser> automationChooserProvider;
    private final Provider<IntentChooser> intentChooserProvider;
    private final SupDocumentCaptureModule module;

    public SupDocumentCaptureModule_ProvidesCaptureChooserFactory(SupDocumentCaptureModule supDocumentCaptureModule, Provider<IntentChooser> provider, Provider<AutomationChooser> provider2) {
        this.module = supDocumentCaptureModule;
        this.intentChooserProvider = provider;
        this.automationChooserProvider = provider2;
    }

    public static SupDocumentCaptureModule_ProvidesCaptureChooserFactory create(SupDocumentCaptureModule supDocumentCaptureModule, Provider<IntentChooser> provider, Provider<AutomationChooser> provider2) {
        return new SupDocumentCaptureModule_ProvidesCaptureChooserFactory(supDocumentCaptureModule, provider, provider2);
    }

    public static ICaptureChooser providesCaptureChooser(SupDocumentCaptureModule supDocumentCaptureModule, IntentChooser intentChooser, AutomationChooser automationChooser) {
        return (ICaptureChooser) Preconditions.checkNotNullFromProvides(supDocumentCaptureModule.providesCaptureChooser(intentChooser, automationChooser));
    }

    @Override // javax.inject.Provider
    public ICaptureChooser get() {
        return providesCaptureChooser(this.module, this.intentChooserProvider.get(), this.automationChooserProvider.get());
    }
}
