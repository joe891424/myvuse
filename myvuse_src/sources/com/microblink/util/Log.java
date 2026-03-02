package com.microblink.util;

import com.microblink.blinkid.secured.IIllIllIIl;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class Log {
    private static int llIIlIlIIl = LogLevel.LOG_WARNINGS_AND_ERRORS.ordinal();
    private static LogWriter IlIllIlIIl = null;

    /* JADX INFO: compiled from: line */
    public enum LogLevel {
        LOG_QUIET,
        LOG_WARNINGS_AND_ERRORS,
        LOG_INFORMATION,
        LOG_DEBUG,
        LOG_VERBOSE
    }

    /* JADX INFO: compiled from: line */
    public interface LogWriter {
        void writeLog(String str, String str2, String str3, Throwable th);
    }

    /* JADX INFO: renamed from: d */
    public static void m2707d(Object obj, String str, Object... objArr) {
        if (llIIlIlIIl >= LogLevel.LOG_DEBUG.ordinal()) {
            String strLlIIlIlIIl = llIIlIlIIl(obj);
            String strLlIIlIlIIl2 = llIIlIlIIl(str, objArr);
            LogInstrumentation.m2726d(strLlIIlIlIIl, strLlIIlIlIIl2);
            llIIlIlIIl("[D]", strLlIIlIlIIl, strLlIIlIlIIl2, null);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m2709e(Object obj, String str, Object... objArr) {
        if (llIIlIlIIl >= LogLevel.LOG_WARNINGS_AND_ERRORS.ordinal()) {
            String strLlIIlIlIIl = llIIlIlIIl(obj);
            String strLlIIlIlIIl2 = llIIlIlIIl(str, objArr);
            LogInstrumentation.m2728e(strLlIIlIlIIl, strLlIIlIlIIl2);
            llIIlIlIIl("[E]", strLlIIlIlIIl, strLlIIlIlIIl2, null);
        }
    }

    public static LogLevel getCurrentLogLevel() {
        return LogLevel.values()[llIIlIlIIl];
    }

    public static int getLineNumber() {
        if (Thread.currentThread().getStackTrace().length > 5) {
            return Thread.currentThread().getStackTrace()[5].getLineNumber();
        }
        return -1;
    }

    public static LogWriter getLogWriter() {
        return IlIllIlIIl;
    }

    public static String getThreadName() {
        return IIllIllIIl.llIIlIlIIl("@").append(Thread.currentThread().getName()).toString();
    }

    /* JADX INFO: renamed from: i */
    public static void m2711i(Object obj, String str, Object... objArr) {
        if (llIIlIlIIl >= LogLevel.LOG_INFORMATION.ordinal()) {
            String strLlIIlIlIIl = llIIlIlIIl(obj);
            String strLlIIlIlIIl2 = llIIlIlIIl(str, objArr);
            LogInstrumentation.m2730i(strLlIIlIlIIl, strLlIIlIlIIl2);
            llIIlIlIIl("[I]", strLlIIlIlIIl, strLlIIlIlIIl2, null);
        }
    }

    private static String llIIlIlIIl(String str, Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit = str.split("(?<!\\\\)\\{\\}", -1);
        int i = 0;
        int i2 = 0;
        while (i < strArrSplit.length) {
            int i3 = i + 1;
            sb.append(strArrSplit[i]);
            if (i3 < strArrSplit.length) {
                if (i2 >= objArr.length) {
                    throw new RuntimeException("missing parameter for log message '" + str + "'");
                }
                sb.append(objArr[i2]);
                i2++;
            }
            i = i3;
        }
        return sb.toString();
    }

    public static void setLogLevel(LogLevel logLevel) {
        llIIlIlIIl = logLevel.ordinal();
    }

    public static void setLogWriter(LogWriter logWriter) {
        IlIllIlIIl = logWriter;
    }

    /* JADX INFO: renamed from: v */
    public static void m2713v(Object obj, String str, Object... objArr) {
        if (llIIlIlIIl >= LogLevel.LOG_VERBOSE.ordinal()) {
            String strLlIIlIlIIl = llIIlIlIIl(obj);
            String strLlIIlIlIIl2 = llIIlIlIIl(str, objArr);
            LogInstrumentation.m2732v(strLlIIlIlIIl, strLlIIlIlIIl2);
            llIIlIlIIl("[V]", strLlIIlIlIIl, strLlIIlIlIIl2, null);
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m2715w(Object obj, String str, Object... objArr) {
        if (llIIlIlIIl >= LogLevel.LOG_WARNINGS_AND_ERRORS.ordinal()) {
            String strLlIIlIlIIl = llIIlIlIIl(obj);
            String strLlIIlIlIIl2 = llIIlIlIIl(str, objArr);
            LogInstrumentation.m2734w(strLlIIlIlIIl, strLlIIlIlIIl2);
            llIIlIlIIl("[W]", strLlIIlIlIIl, strLlIIlIlIIl2, null);
        }
    }

    public static void wtf(Object obj, String str, Object... objArr) {
        if (llIIlIlIIl >= LogLevel.LOG_WARNINGS_AND_ERRORS.ordinal()) {
            String strLlIIlIlIIl = llIIlIlIIl(obj);
            String strLlIIlIlIIl2 = llIIlIlIIl(str, objArr);
            android.util.Log.wtf(strLlIIlIlIIl, strLlIIlIlIIl2);
            llIIlIlIIl("[WTF]", strLlIIlIlIIl, strLlIIlIlIIl2, null);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m2708d(Object obj, Throwable th, String str, Object... objArr) {
        if (llIIlIlIIl >= LogLevel.LOG_DEBUG.ordinal()) {
            String strLlIIlIlIIl = llIIlIlIIl(obj);
            String strLlIIlIlIIl2 = llIIlIlIIl(str, objArr);
            LogInstrumentation.m2727d(strLlIIlIlIIl, strLlIIlIlIIl2, th);
            llIIlIlIIl("[D]", strLlIIlIlIIl, strLlIIlIlIIl2, th);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m2710e(Object obj, Throwable th, String str, Object... objArr) {
        if (llIIlIlIIl >= LogLevel.LOG_WARNINGS_AND_ERRORS.ordinal()) {
            String strLlIIlIlIIl = llIIlIlIIl(obj);
            String strLlIIlIlIIl2 = llIIlIlIIl(str, objArr);
            LogInstrumentation.m2729e(strLlIIlIlIIl, strLlIIlIlIIl2, th);
            llIIlIlIIl("[E]", strLlIIlIlIIl, strLlIIlIlIIl2, th);
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m2712i(Object obj, Throwable th, String str, Object... objArr) {
        if (llIIlIlIIl >= LogLevel.LOG_INFORMATION.ordinal()) {
            String strLlIIlIlIIl = llIIlIlIIl(obj);
            String strLlIIlIlIIl2 = llIIlIlIIl(str, objArr);
            LogInstrumentation.m2731i(strLlIIlIlIIl, strLlIIlIlIIl2, th);
            llIIlIlIIl("[I]", strLlIIlIlIIl, strLlIIlIlIIl2, th);
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m2714v(Object obj, Throwable th, String str, Object... objArr) {
        if (llIIlIlIIl >= LogLevel.LOG_VERBOSE.ordinal()) {
            String strLlIIlIlIIl = llIIlIlIIl(obj);
            String strLlIIlIlIIl2 = llIIlIlIIl(str, objArr);
            LogInstrumentation.m2733v(strLlIIlIlIIl, strLlIIlIlIIl2, th);
            llIIlIlIIl("[V]", strLlIIlIlIIl, strLlIIlIlIIl2, th);
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m2716w(Object obj, Throwable th, String str, Object... objArr) {
        if (llIIlIlIIl >= LogLevel.LOG_WARNINGS_AND_ERRORS.ordinal()) {
            String strLlIIlIlIIl = llIIlIlIIl(obj);
            String strLlIIlIlIIl2 = llIIlIlIIl(str, objArr);
            LogInstrumentation.m2735w(strLlIIlIlIIl, strLlIIlIlIIl2, th);
            llIIlIlIIl("[W]", strLlIIlIlIIl, strLlIIlIlIIl2, th);
        }
    }

    public static void wtf(Object obj, Throwable th, String str, Object... objArr) {
        if (llIIlIlIIl >= LogLevel.LOG_WARNINGS_AND_ERRORS.ordinal()) {
            String strLlIIlIlIIl = llIIlIlIIl(obj);
            String strLlIIlIlIIl2 = llIIlIlIIl(str, objArr);
            android.util.Log.wtf(strLlIIlIlIIl, strLlIIlIlIIl2, th);
            llIIlIlIIl("[WTF]", strLlIIlIlIIl, strLlIIlIlIIl2, th);
        }
    }

    private static String llIIlIlIIl(Object obj) {
        String str;
        if (obj == null) {
            str = "";
        } else if (obj instanceof String) {
            str = (String) obj;
        } else if (obj instanceof Class) {
            str = ((Class) obj).getSimpleName() + ".java";
        } else {
            str = obj.getClass().getSimpleName() + ".java";
        }
        return str + ":" + getLineNumber() + getThreadName();
    }

    private static void llIIlIlIIl(String str, String str2, String str3, Throwable th) {
        LogWriter logWriter = IlIllIlIIl;
        if (logWriter != null) {
            logWriter.writeLog(str, str2, str3, th);
        }
    }
}
