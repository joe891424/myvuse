package com.yoti.mobile.android.documentcapture.view.selection;

import com.yoti.mobile.android.yotisdkcore.core.view.localisation.LocalisedCountriesProvider;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeEntityToViewDataMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class CountryEntityToViewDataMapper_Factory implements Factory<CountryEntityToViewDataMapper> {
    private final Provider<DocumentTypeEntityToViewDataMapper> documentTypeEntityToViewDataMapperProvider;
    private final Provider<LocalisedCountriesProvider> localisedCountriesProvider;

    public CountryEntityToViewDataMapper_Factory(Provider<LocalisedCountriesProvider> provider, Provider<DocumentTypeEntityToViewDataMapper> provider2) {
        this.localisedCountriesProvider = provider;
        this.documentTypeEntityToViewDataMapperProvider = provider2;
    }

    public static CountryEntityToViewDataMapper_Factory create(Provider<LocalisedCountriesProvider> provider, Provider<DocumentTypeEntityToViewDataMapper> provider2) {
        return new CountryEntityToViewDataMapper_Factory(provider, provider2);
    }

    public static CountryEntityToViewDataMapper newInstance(LocalisedCountriesProvider localisedCountriesProvider, DocumentTypeEntityToViewDataMapper documentTypeEntityToViewDataMapper) {
        return new CountryEntityToViewDataMapper(localisedCountriesProvider, documentTypeEntityToViewDataMapper);
    }

    @Override // javax.inject.Provider
    public CountryEntityToViewDataMapper get() {
        return newInstance(this.localisedCountriesProvider.get(), this.documentTypeEntityToViewDataMapperProvider.get());
    }
}
