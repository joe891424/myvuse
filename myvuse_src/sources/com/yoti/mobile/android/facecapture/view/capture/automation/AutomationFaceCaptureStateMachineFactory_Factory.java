package com.yoti.mobile.android.facecapture.view.capture.automation;

import com.yoti.mobile.android.yotidocs.common.file.AssetToFileConverter;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class AutomationFaceCaptureStateMachineFactory_Factory implements Factory<AutomationFaceCaptureStateMachineFactory> {
    private final Provider<AssetToFileConverter> assetToFileConverterProvider;

    public AutomationFaceCaptureStateMachineFactory_Factory(Provider<AssetToFileConverter> provider) {
        this.assetToFileConverterProvider = provider;
    }

    public static AutomationFaceCaptureStateMachineFactory_Factory create(Provider<AssetToFileConverter> provider) {
        return new AutomationFaceCaptureStateMachineFactory_Factory(provider);
    }

    public static AutomationFaceCaptureStateMachineFactory newInstance(AssetToFileConverter assetToFileConverter) {
        return new AutomationFaceCaptureStateMachineFactory(assetToFileConverter);
    }

    @Override // javax.inject.Provider
    public AutomationFaceCaptureStateMachineFactory get() {
        return newInstance(this.assetToFileConverterProvider.get());
    }
}
