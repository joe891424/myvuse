package com.yoti.mobile.android.documentcapture.p055id.view.scan.automation;

import com.yoti.mobile.android.yotidocs.common.file.AssetToFileConverter;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class AutomationScanFragment_MembersInjector implements MembersInjector<AutomationScanFragment> {
    private final Provider<AssetToFileConverter> assetToFileConverterProvider;

    public AutomationScanFragment_MembersInjector(Provider<AssetToFileConverter> provider) {
        this.assetToFileConverterProvider = provider;
    }

    public static MembersInjector<AutomationScanFragment> create(Provider<AssetToFileConverter> provider) {
        return new AutomationScanFragment_MembersInjector(provider);
    }

    public static void injectAssetToFileConverter(AutomationScanFragment automationScanFragment, AssetToFileConverter assetToFileConverter) {
        automationScanFragment.assetToFileConverter = assetToFileConverter;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(AutomationScanFragment automationScanFragment) {
        injectAssetToFileConverter(automationScanFragment, this.assetToFileConverterProvider.get());
    }
}
