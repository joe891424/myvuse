package com.yoti.mobile.android.yotisdkcore.core.p085di;

import com.yoti.mobile.android.yotisdkcore.core.view.localisation.LocalisedCountriesProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes4.dex */
public final class CountryHelperModule_ProvidesLocalisedCountriesProviderFactory implements Factory<LocalisedCountriesProvider> {
    private final CountryHelperModule module;

    public CountryHelperModule_ProvidesLocalisedCountriesProviderFactory(CountryHelperModule countryHelperModule) {
        this.module = countryHelperModule;
    }

    public static CountryHelperModule_ProvidesLocalisedCountriesProviderFactory create(CountryHelperModule countryHelperModule) {
        return new CountryHelperModule_ProvidesLocalisedCountriesProviderFactory(countryHelperModule);
    }

    public static LocalisedCountriesProvider providesLocalisedCountriesProvider(CountryHelperModule countryHelperModule) {
        return (LocalisedCountriesProvider) Preconditions.checkNotNullFromProvides(countryHelperModule.providesLocalisedCountriesProvider());
    }

    @Override // javax.inject.Provider
    public LocalisedCountriesProvider get() {
        return providesLocalisedCountriesProvider(this.module);
    }
}
