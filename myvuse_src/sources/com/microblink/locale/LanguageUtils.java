package com.microblink.locale;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.microblink.util.Log;
import java.util.Locale;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class LanguageUtils {
    private static String IlIllIlIIl;
    private static String llIIlIlIIl;

    public static void setLanguageAndCountry(String str, String str2, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Microblink.prefs", 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        llIIlIlIIl = str;
        IlIllIlIIl = str2;
        if (str == null) {
            String string = sharedPreferences.getString("PREFS_LANGUAGE", null);
            llIIlIlIIl = string;
            if (string == null) {
                String language = Locale.getDefault().getLanguage();
                llIIlIlIIl = language;
                editorEdit.putString("PREFS_LANGUAGE", language);
            }
        } else {
            editorEdit.putString("PREFS_LANGUAGE", str);
        }
        String str3 = IlIllIlIIl;
        if (str3 == null) {
            String string2 = sharedPreferences.getString("PREFS_COUNTRY", null);
            IlIllIlIIl = string2;
            if (string2 == null) {
                String country = Locale.getDefault().getCountry();
                IlIllIlIIl = country;
                editorEdit.putString("PREFS_COUNTRY", country);
            }
        } else {
            editorEdit.putString("PREFS_COUNTRY", str3);
        }
        editorEdit.commit();
        setLanguageConfiguration(context.getResources());
    }

    public static void setLanguageConfiguration(Resources resources) {
        Configuration configuration = resources.getConfiguration();
        String str = llIIlIlIIl;
        if (str != null && !str.equals("")) {
            String str2 = IlIllIlIIl;
            if (str2 == null || str2.equals("")) {
                Log.m2711i(LanguageUtils.class, "Setting language to '{}'", llIIlIlIIl);
                configuration.setLocale(new Locale(llIIlIlIIl));
            } else {
                Log.m2711i(LanguageUtils.class, "Setting language to '{}', country to '{}'", llIIlIlIIl, IlIllIlIIl);
                configuration.setLocale(new Locale(llIIlIlIIl, IlIllIlIIl));
            }
        }
        resources.updateConfiguration(configuration, null);
    }
}
