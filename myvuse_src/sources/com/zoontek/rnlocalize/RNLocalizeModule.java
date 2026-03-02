package com.zoontek.rnlocalize;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;

/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = RNLocalizeModuleImpl.NAME)
public class RNLocalizeModule extends ReactContextBaseJavaModule {
    public RNLocalizeModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return RNLocalizeModuleImpl.NAME;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public String getCalendar() {
        return RNLocalizeModuleImpl.getCalendar();
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public String getCountry() {
        return RNLocalizeModuleImpl.getCountry(getReactApplicationContext());
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableArray getCurrencies() {
        return RNLocalizeModuleImpl.getCurrencies(getReactApplicationContext());
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableArray getLocales() {
        return RNLocalizeModuleImpl.getLocales(getReactApplicationContext());
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getNumberFormatSettings() {
        return RNLocalizeModuleImpl.getNumberFormatSettings(getReactApplicationContext());
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public String getTemperatureUnit() {
        return RNLocalizeModuleImpl.getTemperatureUnit(getReactApplicationContext());
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public String getTimeZone() {
        return RNLocalizeModuleImpl.getTimeZone();
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean uses24HourClock() {
        return RNLocalizeModuleImpl.uses24HourClock(getReactApplicationContext());
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean usesMetricSystem() {
        return RNLocalizeModuleImpl.usesMetricSystem(getReactApplicationContext());
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public Boolean usesAutoDateAndTime() {
        return Boolean.valueOf(RNLocalizeModuleImpl.usesAutoDateAndTime(getReactApplicationContext()));
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public Boolean usesAutoTimeZone() {
        return Boolean.valueOf(RNLocalizeModuleImpl.usesAutoTimeZone(getReactApplicationContext()));
    }
}
