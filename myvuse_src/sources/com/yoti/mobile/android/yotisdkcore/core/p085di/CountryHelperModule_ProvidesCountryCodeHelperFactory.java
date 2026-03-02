package com.yoti.mobile.android.yotisdkcore.core.p085di;

import com.yoti.mobile.android.common.p049ui.components.utils.CountryCodeHelper;
import com.yoti.mobile.android.common.p049ui.components.utils.IDemonymProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class CountryHelperModule_ProvidesCountryCodeHelperFactory implements Factory<CountryCodeHelper> {
    private final Provider<IDemonymProvider> demonymProvider;
    private final CountryHelperModule module;

    public CountryHelperModule_ProvidesCountryCodeHelperFactory(CountryHelperModule countryHelperModule, Provider<IDemonymProvider> provider) {
        this.module = countryHelperModule;
        this.demonymProvider = provider;
    }

    public static CountryHelperModule_ProvidesCountryCodeHelperFactory create(CountryHelperModule countryHelperModule, Provider<IDemonymProvider> provider) {
        return new CountryHelperModule_ProvidesCountryCodeHelperFactory(countryHelperModule, provider);
    }

    public static CountryCodeHelper providesCountryCodeHelper(CountryHelperModule countryHelperModule, IDemonymProvider iDemonymProvider) {
        return (CountryCodeHelper) Preconditions.checkNotNullFromProvides(countryHelperModule.providesCountryCodeHelper(iDemonymProvider));
    }

    @Override // javax.inject.Provider
    public CountryCodeHelper get() {
        return providesCountryCodeHelper(this.module, this.demonymProvider.get());
    }
}
