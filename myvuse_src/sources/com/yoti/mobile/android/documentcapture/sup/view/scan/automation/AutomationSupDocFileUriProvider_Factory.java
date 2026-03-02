package com.yoti.mobile.android.documentcapture.sup.view.scan.automation;

import com.yoti.mobile.android.yotidocs.common.file.AssetToFileConverter;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class AutomationSupDocFileUriProvider_Factory implements Factory<AutomationSupDocFileUriProvider> {
    private final Provider<AssetToFileConverter> assetToFileConverterProvider;

    public AutomationSupDocFileUriProvider_Factory(Provider<AssetToFileConverter> provider) {
        this.assetToFileConverterProvider = provider;
    }

    public static AutomationSupDocFileUriProvider_Factory create(Provider<AssetToFileConverter> provider) {
        return new AutomationSupDocFileUriProvider_Factory(provider);
    }

    public static AutomationSupDocFileUriProvider newInstance(AssetToFileConverter assetToFileConverter) {
        return new AutomationSupDocFileUriProvider(assetToFileConverter);
    }

    @Override // javax.inject.Provider
    public AutomationSupDocFileUriProvider get() {
        return newInstance(this.assetToFileConverterProvider.get());
    }
}
