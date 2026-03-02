package com.scottyab.rootbeer.util;

import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes6.dex */
public final class QLog {
    public static final int ALL = 5;
    public static final int ERRORS_ONLY = 1;
    public static final int ERRORS_WARNINGS = 2;
    public static final int ERRORS_WARNINGS_INFO = 3;
    public static final int ERRORS_WARNINGS_INFO_DEBUG = 4;
    public static int LOGGING_LEVEL = 5;
    public static final int NONE = 0;
    private static final String TAG = "RootBeer";
    private static final String TAG_GENERAL_OUTPUT = "QLog";

    /* JADX INFO: renamed from: e */
    public static void m4358e(Object obj, Throwable th) {
        if (isELoggable()) {
            LogInstrumentation.m2728e(TAG, getTrace() + String.valueOf(obj));
            LogInstrumentation.m2728e(TAG, getThrowableTrace(th));
            LogInstrumentation.m2728e(TAG_GENERAL_OUTPUT, getTrace() + String.valueOf(obj));
            LogInstrumentation.m2728e(TAG_GENERAL_OUTPUT, getThrowableTrace(th));
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m4357e(Object obj) {
        if (isELoggable()) {
            LogInstrumentation.m2728e(TAG, getTrace() + String.valueOf(obj));
            LogInstrumentation.m2728e(TAG_GENERAL_OUTPUT, getTrace() + String.valueOf(obj));
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m4356e(Exception exc) {
        if (isELoggable()) {
            exc.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m4362w(Object obj, Throwable th) {
        if (isWLoggable()) {
            LogInstrumentation.m2734w(TAG, getTrace() + String.valueOf(obj));
            LogInstrumentation.m2734w(TAG, getThrowableTrace(th));
            LogInstrumentation.m2734w(TAG_GENERAL_OUTPUT, getTrace() + String.valueOf(obj));
            LogInstrumentation.m2734w(TAG_GENERAL_OUTPUT, getThrowableTrace(th));
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m4361w(Object obj) {
        if (isWLoggable()) {
            LogInstrumentation.m2734w(TAG, getTrace() + String.valueOf(obj));
            LogInstrumentation.m2734w(TAG_GENERAL_OUTPUT, getTrace() + String.valueOf(obj));
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m4359i(Object obj) {
        if (isILoggable()) {
            LogInstrumentation.m2730i(TAG, getTrace() + String.valueOf(obj));
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m4355d(Object obj) {
        if (isDLoggable()) {
            LogInstrumentation.m2726d(TAG, getTrace() + String.valueOf(obj));
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m4360v(Object obj) {
        if (isVLoggable()) {
            LogInstrumentation.m2732v(TAG, getTrace() + String.valueOf(obj));
        }
    }

    public static boolean isVLoggable() {
        return LOGGING_LEVEL > 4;
    }

    public static boolean isDLoggable() {
        return LOGGING_LEVEL > 3;
    }

    public static boolean isILoggable() {
        return LOGGING_LEVEL > 2;
    }

    public static boolean isWLoggable() {
        return LOGGING_LEVEL > 1;
    }

    public static boolean isELoggable() {
        return LOGGING_LEVEL > 0;
    }

    private static String getThrowableTrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    private static String getTrace() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String methodName = stackTrace[2].getMethodName();
        String className = stackTrace[2].getClassName();
        return className.substring(className.lastIndexOf(46) + 1) + ": " + methodName + "() [" + stackTrace[2].getLineNumber() + "] - ";
    }

    private QLog() {
    }
}
