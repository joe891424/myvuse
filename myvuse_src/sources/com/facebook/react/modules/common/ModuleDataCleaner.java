package com.facebook.react.modules.common;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.ReactConstants;

/* JADX INFO: loaded from: classes3.dex */
public class ModuleDataCleaner {

    public interface Cleanable {
        void clearSensitiveData();
    }

    @Deprecated
    public static void cleanDataFromModules(CatalystInstance catalystInstance) {
        for (NativeModule nativeModule : catalystInstance.getNativeModules()) {
            if (nativeModule instanceof Cleanable) {
                FLog.m1265d(ReactConstants.TAG, "Cleaning data from " + nativeModule.getName());
                ((Cleanable) nativeModule).clearSensitiveData();
            }
        }
    }

    public static void cleanDataFromModules(ReactContext reactContext) {
        for (NativeModule nativeModule : reactContext.getNativeModules()) {
            if (nativeModule instanceof Cleanable) {
                FLog.m1265d(ReactConstants.TAG, "Cleaning data from " + nativeModule.getName());
                ((Cleanable) nativeModule).clearSensitiveData();
            }
        }
    }
}
