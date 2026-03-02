package com.zoontek.rnlocalize;

import android.provider.Settings;
import android.text.TextUtils;
import android.text.format.DateFormat;
import androidx.core.os.LocaleListCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes4.dex */
public class RNLocalizeModuleImpl {
    public static final String NAME = "RNLocalize";
    private static final List<String> USES_FAHRENHEIT = Arrays.asList("BS", "BZ", "KY", "PR", "PW", "US");
    private static final List<String> USES_IMPERIAL = Arrays.asList("LR", "MM", "US");

    private static String createLanguageTag(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2)) {
            str = str + "-" + str2;
        }
        return str + "-" + str3;
    }

    private static String getCountryCodeForLocale(Locale locale) {
        try {
            String country = locale.getCountry();
            if (country.equals("419")) {
                return "UN";
            }
            return TextUtils.isEmpty(country) ? "" : country.toUpperCase();
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getCurrencyCodeForLocale(Locale locale) {
        try {
            Currency currency = Currency.getInstance(locale);
            if (currency == null) {
                return "";
            }
            return currency.getCurrencyCode();
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getLanguageCodeForLocale(Locale locale) {
        String language;
        language = locale.getLanguage();
        language.hashCode();
        switch (language) {
            case "in":
                return "id";
            case "iw":
                return "he";
            case "ji":
                return "yi";
            default:
                return language;
        }
    }

    private static String getScriptCodeForLocale(Locale locale) {
        String script = locale.getScript();
        return TextUtils.isEmpty(script) ? "" : script;
    }

    private static Locale getSystemLocale(ReactApplicationContext reactApplicationContext) {
        return reactApplicationContext.getResources().getConfiguration().getLocales().get(0);
    }

    private static List<Locale> getSystemLocales(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        reactApplicationContext.getResources().getConfiguration();
        LocaleListCompat localeListCompat = LocaleListCompat.getDefault();
        for (int i = 0; i < localeListCompat.size(); i++) {
            arrayList.add(localeListCompat.get(i));
        }
        return arrayList;
    }

    private static String getMiuiRegionCode() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) Objects.requireNonNull(cls.getMethod("get", String.class).invoke(cls, "ro.miui.region"));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getCalendar() {
        return "gregorian";
    }

    public static String getCountry(ReactApplicationContext reactApplicationContext) {
        String miuiRegionCode = getMiuiRegionCode();
        if (!TextUtils.isEmpty(miuiRegionCode)) {
            return miuiRegionCode;
        }
        String countryCodeForLocale = getCountryCodeForLocale(getSystemLocale(reactApplicationContext));
        return TextUtils.isEmpty(countryCodeForLocale) ? "US" : countryCodeForLocale;
    }

    public static WritableArray getCurrencies(ReactApplicationContext reactApplicationContext) {
        List<Locale> systemLocales = getSystemLocales(reactApplicationContext);
        ArrayList arrayList = new ArrayList();
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Iterator<Locale> it2 = systemLocales.iterator();
        while (it2.hasNext()) {
            String currencyCodeForLocale = getCurrencyCodeForLocale(it2.next());
            if (!TextUtils.isEmpty(currencyCodeForLocale) && !arrayList.contains(currencyCodeForLocale)) {
                arrayList.add(currencyCodeForLocale);
                writableArrayCreateArray.pushString(currencyCodeForLocale);
            }
        }
        if (writableArrayCreateArray.size() == 0) {
            writableArrayCreateArray.pushString("USD");
        }
        return writableArrayCreateArray;
    }

    public static WritableArray getLocales(ReactApplicationContext reactApplicationContext) {
        List<Locale> systemLocales = getSystemLocales(reactApplicationContext);
        ArrayList arrayList = new ArrayList();
        WritableArray writableArrayCreateArray = Arguments.createArray();
        String country = getCountry(reactApplicationContext);
        for (Locale locale : systemLocales) {
            String languageCodeForLocale = getLanguageCodeForLocale(locale);
            String scriptCodeForLocale = getScriptCodeForLocale(locale);
            String countryCodeForLocale = getCountryCodeForLocale(locale);
            if (TextUtils.isEmpty(countryCodeForLocale)) {
                countryCodeForLocale = country;
            }
            String strCreateLanguageTag = createLanguageTag(languageCodeForLocale, scriptCodeForLocale, countryCodeForLocale);
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString(RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE, languageCodeForLocale);
            writableMapCreateMap.putString(RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE, countryCodeForLocale);
            writableMapCreateMap.putString("languageTag", strCreateLanguageTag);
            writableMapCreateMap.putBoolean("isRTL", TextUtils.getLayoutDirectionFromLocale(locale) == 1);
            if (!TextUtils.isEmpty(scriptCodeForLocale)) {
                writableMapCreateMap.putString("scriptCode", scriptCodeForLocale);
            }
            if (!arrayList.contains(strCreateLanguageTag)) {
                arrayList.add(strCreateLanguageTag);
                writableArrayCreateArray.pushMap(writableMapCreateMap);
            }
        }
        return writableArrayCreateArray;
    }

    public static WritableMap getNumberFormatSettings(ReactApplicationContext reactApplicationContext) {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(getSystemLocale(reactApplicationContext));
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("decimalSeparator", String.valueOf(decimalFormatSymbols.getDecimalSeparator()));
        writableMapCreateMap.putString("groupingSeparator", String.valueOf(decimalFormatSymbols.getGroupingSeparator()));
        return writableMapCreateMap;
    }

    public static String getTemperatureUnit(ReactApplicationContext reactApplicationContext) {
        return USES_FAHRENHEIT.contains(getCountry(reactApplicationContext)) ? "fahrenheit" : "celsius";
    }

    public static String getTimeZone() {
        return TimeZone.getDefault().getID();
    }

    public static boolean uses24HourClock(ReactApplicationContext reactApplicationContext) {
        return DateFormat.is24HourFormat(reactApplicationContext);
    }

    public static boolean usesMetricSystem(ReactApplicationContext reactApplicationContext) {
        return !USES_IMPERIAL.contains(getCountry(reactApplicationContext));
    }

    public static boolean usesAutoDateAndTime(ReactApplicationContext reactApplicationContext) {
        return Settings.Global.getInt(reactApplicationContext.getContentResolver(), "auto_time", 0) != 0;
    }

    public static boolean usesAutoTimeZone(ReactApplicationContext reactApplicationContext) {
        return Settings.Global.getInt(reactApplicationContext.getContentResolver(), "auto_time_zone", 0) != 0;
    }
}
