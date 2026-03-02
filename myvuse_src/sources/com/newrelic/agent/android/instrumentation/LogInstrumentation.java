package com.newrelic.agent.android.instrumentation;

import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.newrelic.agent.android.logging.LogLevel;
import com.newrelic.agent.android.logging.LogReporting;
import java.util.HashMap;
import java.util.Map;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: loaded from: classes6.dex */
public class LogInstrumentation {
    /* JADX INFO: renamed from: d */
    public static int m2726d(String str, String str2) {
        Log.d(str, str2);
        LogReporting.getLogger().logAttributes(asAttributes(LogLevel.DEBUG, str, str2));
        return LogReporting.isLevelEnabled(LogLevel.DEBUG) ? 1 : 0;
    }

    /* JADX INFO: renamed from: w */
    public static int m2734w(String str, String str2) {
        Log.w(str, str2);
        LogReporting.getLogger().logAttributes(asAttributes(LogLevel.WARN, str, str2));
        return LogReporting.isLevelEnabled(LogLevel.WARN) ? 1 : 0;
    }

    /* JADX INFO: renamed from: i */
    public static int m2730i(String str, String str2) {
        Log.i(str, str2);
        LogReporting.getLogger().logAttributes(asAttributes(LogLevel.INFO, str, str2));
        return LogReporting.isLevelEnabled(LogLevel.INFO) ? 1 : 0;
    }

    /* JADX INFO: renamed from: v */
    public static int m2732v(String str, String str2) {
        Log.v(str, str2);
        LogReporting.getLogger().logAttributes(asAttributes(LogLevel.VERBOSE, str, str2));
        return LogReporting.isLevelEnabled(LogLevel.VERBOSE) ? 1 : 0;
    }

    /* JADX INFO: renamed from: e */
    public static int m2728e(String str, String str2) {
        Log.e(str, str2);
        LogReporting.getLogger().logAttributes(asAttributes(LogLevel.ERROR, str, str2));
        return LogReporting.isLevelEnabled(LogLevel.ERROR) ? 1 : 0;
    }

    /* JADX INFO: renamed from: e */
    public static int m2729e(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
        LogReporting.getLogger().logAll(th, asAttributes(LogLevel.ERROR, str, str2));
        return LogReporting.isLevelEnabled(LogLevel.ERROR) ? 1 : 0;
    }

    /* JADX INFO: renamed from: d */
    public static int m2727d(String str, String str2, Throwable th) {
        Log.d(str, str2, th);
        LogReporting.getLogger().logAll(th, asAttributes(LogLevel.DEBUG, str, str2));
        return LogReporting.isLevelEnabled(LogLevel.DEBUG) ? 1 : 0;
    }

    /* JADX INFO: renamed from: w */
    public static int m2735w(String str, String str2, Throwable th) {
        Log.w(str, str2, th);
        LogReporting.getLogger().logAll(th, asAttributes(LogLevel.WARN, str, str2));
        return LogReporting.isLevelEnabled(LogLevel.WARN) ? 1 : 0;
    }

    /* JADX INFO: renamed from: i */
    public static int m2731i(String str, String str2, Throwable th) {
        Log.i(str, str2, th);
        LogReporting.getLogger().logAll(th, asAttributes(LogLevel.INFO, str, str2));
        return LogReporting.isLevelEnabled(LogLevel.DEBUG) ? 1 : 0;
    }

    /* JADX INFO: renamed from: v */
    public static int m2733v(String str, String str2, Throwable th) {
        Log.v(str, str2, th);
        LogReporting.getLogger().logAll(th, asAttributes(LogLevel.VERBOSE, str, str2));
        return LogReporting.isLevelEnabled(LogLevel.VERBOSE) ? 1 : 0;
    }

    private static Map<String, Object> asAttributes(LogLevel logLevel, String str, String str2) {
        HashMap map = new HashMap();
        map.put(HeaderParameterNames.AUTHENTICATION_TAG, str);
        map.put("message", str2);
        map.put(FirebaseAnalytics.Param.LEVEL, logLevel.name().toUpperCase());
        return map;
    }
}
