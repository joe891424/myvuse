package com.yoti.mobile.android.yotisdkcore.core.p085di;

import com.yoti.mobile.android.common.p049ui.components.utils.IDemonymProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class CountryHelperModule_ProvidesYdsDemonymProviderFactory implements Factory<IDemonymProvider> {
    private final Provider<IDemonymProvider> externalDemonymProvider;
    private final CountryHelperModule module;

    public CountryHelperModule_ProvidesYdsDemonymProviderFactory(CountryHelperModule countryHelperModule, Provider<IDemonymProvider> provider) {
        this.module = countryHelperModule;
        this.externalDemonymProvider = provider;
    }

    public static CountryHelperModule_ProvidesYdsDemonymProviderFactory create(CountryHelperModule countryHelperModule, Provider<IDemonymProvider> provider) {
        return new CountryHelperModule_ProvidesYdsDemonymProviderFactory(countryHelperModule, provider);
    }

    public static IDemonymProvider providesYdsDemonymProvider(CountryHelperModule countryHelperModule, IDemonymProvider iDemonymProvider) {
        return (IDemonymProvider) Preconditions.checkNotNullFromProvides(countryHelperModule.providesYdsDemonymProvider(iDemonymProvider));
    }

    @Override // javax.inject.Provider
    public IDemonymProvider get() {
        return providesYdsDemonymProvider(this.module, this.externalDemonymProvider.get());
    }
}
