package com.google.android.datatransport.runtime.logging;

import android.util.Log;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;

/* JADX INFO: loaded from: classes3.dex */
public final class Logging {
    private static final String LOG_PREFIX = "TRuntime.";
    private static final int MAX_LOG_TAG_SIZE_IN_SDK_N = 23;

    private Logging() {
    }

    private static String getTag(String str) {
        return LOG_PREFIX + str;
    }

    private static String concatTag(String str, String str2) {
        String str3 = str + str2;
        return str3.length() > 23 ? str3.substring(0, 23) : str3;
    }

    /* JADX INFO: renamed from: d */
    public static void m2322d(String str, String str2) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 3)) {
            LogInstrumentation.m2726d(tag, str2);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m2323d(String str, String str2, Object obj) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 3)) {
            LogInstrumentation.m2726d(tag, String.format(str2, obj));
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m2324d(String str, String str2, Object obj, Object obj2) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 3)) {
            LogInstrumentation.m2726d(tag, String.format(str2, obj, obj2));
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m2325d(String str, String str2, Object... objArr) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 3)) {
            LogInstrumentation.m2726d(tag, String.format(str2, objArr));
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m2327i(String str, String str2, Object obj) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 4)) {
            LogInstrumentation.m2730i(tag, String.format(str2, obj));
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m2326e(String str, String str2, Throwable th) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 6)) {
            LogInstrumentation.m2729e(tag, str2, th);
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m2328w(String str, String str2, Object obj) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 5)) {
            LogInstrumentation.m2734w(tag, String.format(str2, obj));
        }
    }
}
