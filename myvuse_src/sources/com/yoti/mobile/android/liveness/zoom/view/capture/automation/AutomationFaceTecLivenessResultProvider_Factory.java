package com.yoti.mobile.android.liveness.zoom.view.capture.automation;

import com.yoti.mobile.android.yotidocs.common.file.AssetToFileConverter;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class AutomationFaceTecLivenessResultProvider_Factory implements Factory<AutomationFaceTecLivenessResultProvider> {
    private final Provider<AssetToFileConverter> assetToFileConverterProvider;

    public AutomationFaceTecLivenessResultProvider_Factory(Provider<AssetToFileConverter> provider) {
        this.assetToFileConverterProvider = provider;
    }

    public static AutomationFaceTecLivenessResultProvider_Factory create(Provider<AssetToFileConverter> provider) {
        return new AutomationFaceTecLivenessResultProvider_Factory(provider);
    }

    public static AutomationFaceTecLivenessResultProvider newInstance(AssetToFileConverter assetToFileConverter) {
        return new AutomationFaceTecLivenessResultProvider(assetToFileConverter);
    }

    @Override // javax.inject.Provider
    public AutomationFaceTecLivenessResultProvider get() {
        return newInstance(this.assetToFileConverterProvider.get());
    }
}
