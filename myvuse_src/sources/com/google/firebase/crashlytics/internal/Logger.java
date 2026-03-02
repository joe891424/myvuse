package com.google.firebase.crashlytics.internal;

import android.util.Log;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;

/* JADX INFO: loaded from: classes2.dex */
public class Logger {
    private int logLevel = 4;
    private final String tag;
    public static final String TAG = "FirebaseCrashlytics";
    static final Logger DEFAULT_LOGGER = new Logger(TAG);

    public Logger(String str) {
        this.tag = str;
    }

    public static Logger getLogger() {
        return DEFAULT_LOGGER;
    }

    private boolean canLog(int i) {
        return this.logLevel <= i || Log.isLoggable(this.tag, i);
    }

    /* JADX INFO: renamed from: d */
    public void m2613d(String str, Throwable th) {
        if (canLog(3)) {
            LogInstrumentation.m2727d(this.tag, str, th);
        }
    }

    /* JADX INFO: renamed from: v */
    public void m2619v(String str, Throwable th) {
        if (canLog(2)) {
            LogInstrumentation.m2733v(this.tag, str, th);
        }
    }

    /* JADX INFO: renamed from: i */
    public void m2617i(String str, Throwable th) {
        if (canLog(4)) {
            LogInstrumentation.m2731i(this.tag, str, th);
        }
    }

    /* JADX INFO: renamed from: w */
    public void m2621w(String str, Throwable th) {
        if (canLog(5)) {
            LogInstrumentation.m2735w(this.tag, str, th);
        }
    }

    /* JADX INFO: renamed from: e */
    public void m2615e(String str, Throwable th) {
        if (canLog(6)) {
            LogInstrumentation.m2729e(this.tag, str, th);
        }
    }

    /* JADX INFO: renamed from: d */
    public void m2612d(String str) {
        m2613d(str, null);
    }

    /* JADX INFO: renamed from: v */
    public void m2618v(String str) {
        m2619v(str, null);
    }

    /* JADX INFO: renamed from: i */
    public void m2616i(String str) {
        m2617i(str, null);
    }

    /* JADX INFO: renamed from: w */
    public void m2620w(String str) {
        m2621w(str, null);
    }

    /* JADX INFO: renamed from: e */
    public void m2614e(String str) {
        m2615e(str, null);
    }

    public void log(int i, String str) {
        log(i, str, false);
    }

    public void log(int i, String str, boolean z) {
        if (z || canLog(i)) {
            Log.println(i, this.tag, str);
        }
    }
}
