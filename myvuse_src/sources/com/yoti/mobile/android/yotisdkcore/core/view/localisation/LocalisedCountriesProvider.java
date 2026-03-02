package com.yoti.mobile.android.yotisdkcore.core.view.localisation;

import com.yoti.mobile.android.commonui.localisation.LanguageCompatKt;
import com.yoti.mobile.android.yotidocs.common.extension.LocaleExtensionKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\nB\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/view/localisation/LocalisedCountriesProvider;", "", "()V", "countryList", "", "Lcom/yoti/mobile/android/yotisdkcore/core/view/localisation/LocalisedCountriesProvider$Country;", "getLocalisedCountries", "getLocalizedCountryName", "", "iso3Code", "Country", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class LocalisedCountriesProvider {
    private final List<Country> countryList = getLocalisedCountries();

    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/view/localisation/LocalisedCountriesProvider$Country;", "", "iso3Code", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getIso3Code", "()Ljava/lang/String;", "getName", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Country {
        private final String iso3Code;
        private final String name;

        public Country(String iso3Code, String name) {
            Intrinsics.checkNotNullParameter(iso3Code, "iso3Code");
            Intrinsics.checkNotNullParameter(name, "name");
            this.iso3Code = iso3Code;
            this.name = name;
        }

        public final String getIso3Code() {
            return this.iso3Code;
        }

        public final String getName() {
            return this.name;
        }
    }

    @Inject
    public LocalisedCountriesProvider() {
    }

    private final List<Country> getLocalisedCountries() {
        Country country;
        Locale locale = Locale.getDefault();
        Locale.setDefault(LanguageCompatKt.getLocaleCompat());
        Locale[] availableLocales = Locale.getAvailableLocales();
        Intrinsics.checkNotNullExpressionValue(availableLocales, "getAvailableLocales()");
        ArrayList arrayList = new ArrayList();
        for (Locale locale2 : availableLocales) {
            Intrinsics.checkNotNullExpressionValue(locale2, "locale");
            Locale localeValidate = LocaleExtensionKt.validate(locale2);
            if (localeValidate != null) {
                String iSO3Country = localeValidate.getISO3Country();
                Intrinsics.checkNotNullExpressionValue(iSO3Country, "it.isO3Country");
                String displayCountry = localeValidate.getDisplayCountry();
                Intrinsics.checkNotNullExpressionValue(displayCountry, "it.displayCountry");
                country = new Country(iSO3Country, displayCountry);
            } else {
                country = null;
            }
            if (country != null) {
                arrayList.add(country);
            }
        }
        Locale.setDefault(locale);
        return arrayList;
    }

    public final String getLocalizedCountryName(String iso3Code) {
        Object next;
        Intrinsics.checkNotNullParameter(iso3Code, "iso3Code");
        Iterator<T> it2 = this.countryList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (Intrinsics.areEqual(((Country) next).getIso3Code(), iso3Code)) {
                break;
            }
        }
        Country country = (Country) next;
        if (country != null) {
            return country.getName();
        }
        return null;
    }
}
