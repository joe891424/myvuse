package com.yoti.mobile.android.common.p049ui.components.utils;

import android.content.res.Resources;
import android.text.TextUtils;
import androidx.core.os.ConfigurationCompat;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.yoti.mobile.android.common.p049ui.components.country.Country;
import com.yoti.mobile.android.common.p049ui.widgets.utils.YotiLocaleListCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CountryCodeHelper {

    /* JADX INFO: renamed from: a */
    private PhoneNumberUtil f5890a;

    /* JADX INFO: renamed from: b */
    private IDemonymProvider f5891b;

    /* JADX INFO: renamed from: c */
    private YotiLocaleListCompat f5892c;

    public CountryCodeHelper(Resources resources, IDemonymProvider iDemonymProvider) {
        this(PhoneNumberUtil.getInstance(), iDemonymProvider, new YotiLocaleListCompat(ConfigurationCompat.getLocales(resources.getConfiguration())));
    }

    CountryCodeHelper(PhoneNumberUtil phoneNumberUtil, IDemonymProvider iDemonymProvider, YotiLocaleListCompat yotiLocaleListCompat) {
        this.f5890a = phoneNumberUtil;
        this.f5891b = iDemonymProvider;
        Locale.getDefault();
        this.f5892c = yotiLocaleListCompat;
    }

    /* JADX INFO: renamed from: a */
    private int m4379a(String str) {
        return this.f5890a.getCountryCodeForRegion(str);
    }

    /* JADX INFO: renamed from: a */
    private Country m4380a(Locale locale) {
        String iSO3Country;
        String country = locale.getCountry();
        String name = null;
        try {
            iSO3Country = locale.getISO3Country();
            try {
                Demonym demonym = this.f5891b.getDemonym(iSO3Country);
                if (demonym != null) {
                    name = demonym.getName();
                }
            } catch (MissingResourceException unused) {
            }
        } catch (MissingResourceException unused2) {
            iSO3Country = null;
        }
        return new Country(country, iSO3Country, m4379a(locale.getCountry()), m4382b(locale), name);
    }

    /* JADX INFO: renamed from: a */
    private Locale m4381a(Locale locale, String str) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return new Locale(locale.getLanguage(), str);
    }

    /* JADX INFO: renamed from: b */
    private String m4382b(Locale locale) {
        return locale.getDisplayCountry();
    }

    /* JADX INFO: renamed from: b */
    private Map<String, Country> m4383b() {
        HashMap map = new HashMap();
        for (Locale locale : mo4385a()) {
            Country countryM4380a = m4380a(locale);
            map.put(countryM4380a.getIso2Code(), countryM4380a);
        }
        return map;
    }

    /* JADX INFO: renamed from: c */
    private Map<String, Country> m4384c() {
        HashMap map = new HashMap();
        for (Locale locale : mo4385a()) {
            Country countryM4380a = m4380a(locale);
            if (countryM4380a.getIso3Code() != null) {
                map.put(countryM4380a.getIso3Code(), countryM4380a);
            }
        }
        return map;
    }

    /* JADX INFO: renamed from: a */
    protected abstract Locale[] mo4385a();

    public List<Country> getCountriesForDeviceSupportedPhoneCode() {
        ArrayList arrayList = new ArrayList();
        Set<String> supportedRegions = this.f5890a.getSupportedRegions();
        Map<String, Country> mapM4383b = m4383b();
        Iterator<String> it2 = supportedRegions.iterator();
        while (it2.hasNext()) {
            Country country = mapM4383b.get(it2.next());
            if (country != null) {
                arrayList.add(country);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public Country getCountryForCode(String str) {
        Map<String, Country> mapM4384c;
        if (str.length() == 2) {
            mapM4384c = m4383b();
        } else {
            if (str.equals("D<<")) {
                str = Locale.GERMANY.getISO3Country();
            }
            mapM4384c = m4384c();
        }
        return mapM4384c.get(str);
    }

    public Locale getSuitableLocale(String str) {
        Locale locale = Locale.getDefault();
        if (TextUtils.isEmpty(str)) {
            str = locale.getCountry();
        }
        String language = locale.getLanguage() == null ? "" : locale.getLanguage();
        if (str == null) {
            str = "";
        }
        Locale firstMatch = this.f5892c.getFirstMatch(new String[]{new Locale(language, str).toString()});
        return (firstMatch == null || TextUtils.isEmpty(firstMatch.getCountry())) ? m4381a(firstMatch, str) : firstMatch;
    }
}
