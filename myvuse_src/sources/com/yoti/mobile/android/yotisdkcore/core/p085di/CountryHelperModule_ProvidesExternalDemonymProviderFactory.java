package com.yoti.mobile.android.yotisdkcore.core.p085di;

import com.yoti.mobile.android.common.p049ui.components.utils.IDemonymProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes4.dex */
public final class CountryHelperModule_ProvidesExternalDemonymProviderFactory implements Factory<IDemonymProvider> {
    private final CountryHelperModule module;

    public CountryHelperModule_ProvidesExternalDemonymProviderFactory(CountryHelperModule countryHelperModule) {
        this.module = countryHelperModule;
    }

    public static CountryHelperModule_ProvidesExternalDemonymProviderFactory create(CountryHelperModule countryHelperModule) {
        return new CountryHelperModule_ProvidesExternalDemonymProviderFactory(countryHelperModule);
    }

    public static IDemonymProvider providesExternalDemonymProvider(CountryHelperModule countryHelperModule) {
        return (IDemonymProvider) Preconditions.checkNotNullFromProvides(countryHelperModule.providesExternalDemonymProvider());
    }

    @Override // javax.inject.Provider
    public IDemonymProvider get() {
        return providesExternalDemonymProvider(this.module);
    }
}
