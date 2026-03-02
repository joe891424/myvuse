package androidx.camera.core;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class Logger {
    static final int DEFAULT_MIN_LOG_LEVEL = 3;
    private static final int MAX_TAG_LENGTH = 23;
    private static int sMinLogLevel = 3;

    private Logger() {
    }

    static void setMinLogLevel(int logLevel) {
        sMinLogLevel = logLevel;
    }

    static void resetMinLogLevel() {
        sMinLogLevel = 3;
    }

    public static boolean isDebugEnabled(String tag) {
        return sMinLogLevel <= 3 || Log.isLoggable(truncateTag(tag), 3);
    }

    public static boolean isInfoEnabled(String tag) {
        return sMinLogLevel <= 4 || Log.isLoggable(truncateTag(tag), 4);
    }

    public static boolean isWarnEnabled(String tag) {
        return sMinLogLevel <= 5 || Log.isLoggable(truncateTag(tag), 5);
    }

    public static boolean isErrorEnabled(String tag) {
        return sMinLogLevel <= 6 || Log.isLoggable(truncateTag(tag), 6);
    }

    /* JADX INFO: renamed from: d */
    public static void m1137d(String tag, String message) {
        m1138d(tag, message, null);
    }

    /* JADX INFO: renamed from: d */
    public static void m1138d(String tag, String message, final Throwable throwable) {
        if (isDebugEnabled(tag)) {
            Log.d(truncateTag(tag), message, throwable);
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1141i(String tag, String message) {
        m1142i(tag, message, null);
    }

    /* JADX INFO: renamed from: i */
    public static void m1142i(String tag, String message, final Throwable throwable) {
        if (isInfoEnabled(tag)) {
            Log.i(truncateTag(tag), message, throwable);
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m1143w(String tag, String message) {
        m1144w(tag, message, null);
    }

    /* JADX INFO: renamed from: w */
    public static void m1144w(String tag, String message, final Throwable throwable) {
        if (isWarnEnabled(tag)) {
            Log.w(truncateTag(tag), message, throwable);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m1139e(String tag, String message) {
        m1140e(tag, message, null);
    }

    /* JADX INFO: renamed from: e */
    public static void m1140e(String tag, String message, final Throwable throwable) {
        if (isErrorEnabled(tag)) {
            Log.e(truncateTag(tag), message, throwable);
        }
    }

    private static String truncateTag(String tag) {
        tag.length();
        return tag;
    }
}
