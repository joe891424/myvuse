package com.yoti.mobile.android.documentcapture.sup.view.selection;

import com.yoti.mobile.android.yotisdkcore.core.view.localisation.LocalisedCountriesProvider;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class SupDocumentEducationalArgumentsToViewDataMapper_Factory implements Factory<SupDocumentEducationalArgumentsToViewDataMapper> {
    private final Provider<LocalisedCountriesProvider> localisedCountriesProvider;

    public SupDocumentEducationalArgumentsToViewDataMapper_Factory(Provider<LocalisedCountriesProvider> provider) {
        this.localisedCountriesProvider = provider;
    }

    public static SupDocumentEducationalArgumentsToViewDataMapper_Factory create(Provider<LocalisedCountriesProvider> provider) {
        return new SupDocumentEducationalArgumentsToViewDataMapper_Factory(provider);
    }

    public static SupDocumentEducationalArgumentsToViewDataMapper newInstance(LocalisedCountriesProvider localisedCountriesProvider) {
        return new SupDocumentEducationalArgumentsToViewDataMapper(localisedCountriesProvider);
    }

    @Override // javax.inject.Provider
    public SupDocumentEducationalArgumentsToViewDataMapper get() {
        return newInstance(this.localisedCountriesProvider.get());
    }
}
