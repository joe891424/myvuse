package com.facebook.react.util;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.ReactConstants;

/* JADX INFO: loaded from: classes3.dex */
public class RNLog {
    public static final int ADVICE = 4;
    public static final int ERROR = 6;
    public static final int LOG = 2;
    public static final int MINIMUM_LEVEL_FOR_UI = 5;
    public static final int TRACE = 3;
    public static final int WARN = 5;

    /* JADX INFO: renamed from: l */
    public static void m1359l(String str) {
        FLog.m1289i(ReactConstants.TAG, str);
    }

    /* JADX INFO: renamed from: t */
    public static void m1360t(String str) {
        FLog.m1289i(ReactConstants.TAG, str);
    }

    /* JADX INFO: renamed from: a */
    public static void m1356a(String str) {
        FLog.m1317w(ReactConstants.TAG, "(ADVICE)" + str);
    }

    /* JADX INFO: renamed from: w */
    public static void m1361w(ReactContext reactContext, String str) {
        logInternal(reactContext, str, 5);
        FLog.m1317w(ReactConstants.TAG, str);
    }

    /* JADX INFO: renamed from: e */
    public static void m1357e(ReactContext reactContext, String str) {
        logInternal(reactContext, str, 6);
        FLog.m1277e(ReactConstants.TAG, str);
    }

    /* JADX INFO: renamed from: e */
    public static void m1358e(String str) {
        FLog.m1277e(ReactConstants.TAG, str);
    }

    private static void logInternal(ReactContext reactContext, String str, int i) {
        if (i < 5 || reactContext == null || !reactContext.hasActiveReactInstance() || str == null) {
            return;
        }
        ((RCTLog) reactContext.getJSModule(RCTLog.class)).logIfNoNativeHook(levelToString(i), str);
    }

    private static String levelToString(int i) {
        if (i == 2 || i == 3) {
            return "log";
        }
        if (i == 4 || i == 5) {
            return "warn";
        }
        if (i == 6) {
            return "error";
        }
        return "none";
    }
}
