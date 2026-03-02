package com.babisoft.ReactNativeLocalization;

import android.content.SharedPreferences;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ReactNativeLocalization extends ReactContextBaseJavaModule {
    private static final String LANGUAGE = "language";

    public ReactNativeLocalization(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "ReactLocalization";
    }

    private String getCurrentLanguage() {
        String userLocale = getUserLocale();
        if (userLocale != null) {
            return userLocale;
        }
        Locale locale = getReactApplicationContext().getResources().getConfiguration().locale;
        return locale.getLanguage() + "-" + locale.getCountry();
    }

    public String getUserLocale() {
        return getPreferences().getString("locale_override", null);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        map.put(LANGUAGE, getCurrentLanguage());
        return map;
    }

    @ReactMethod
    public void getLanguage(Callback callback) {
        String currentLanguage = getCurrentLanguage();
        System.out.println("The current language is " + currentLanguage);
        callback.invoke(null, currentLanguage);
    }

    private SharedPreferences getPreferences() {
        return getReactApplicationContext().getSharedPreferences("react-native", 0);
    }

    private SharedPreferences.Editor getEditor() {
        return getPreferences().edit();
    }
}
