package com.yoti.mobile.android.documentcapture.view.additional_instructions;

import android.content.Context;
import com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsFragment;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class AdditionalInstructionsFragment_FragmentArgsFactory_Factory implements Factory<AdditionalInstructionsFragment.FragmentArgsFactory> {
    private final Provider<Context> contextProvider;
    private final Provider<DocumentCaptureConfiguration> featureConfigurationProvider;

    public AdditionalInstructionsFragment_FragmentArgsFactory_Factory(Provider<Context> provider, Provider<DocumentCaptureConfiguration> provider2) {
        this.contextProvider = provider;
        this.featureConfigurationProvider = provider2;
    }

    public static AdditionalInstructionsFragment_FragmentArgsFactory_Factory create(Provider<Context> provider, Provider<DocumentCaptureConfiguration> provider2) {
        return new AdditionalInstructionsFragment_FragmentArgsFactory_Factory(provider, provider2);
    }

    public static AdditionalInstructionsFragment.FragmentArgsFactory newInstance(Context context, DocumentCaptureConfiguration documentCaptureConfiguration) {
        return new AdditionalInstructionsFragment.FragmentArgsFactory(context, documentCaptureConfiguration);
    }

    @Override // javax.inject.Provider
    public AdditionalInstructionsFragment.FragmentArgsFactory get() {
        return newInstance(this.contextProvider.get(), this.featureConfigurationProvider.get());
    }
}
