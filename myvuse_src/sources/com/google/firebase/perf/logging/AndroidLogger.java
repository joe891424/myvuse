package com.google.firebase.perf.logging;

import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class AndroidLogger {
    private static volatile AndroidLogger instance;
    private boolean isLogcatEnabled;
    private final LogWrapper logWrapper;

    public static AndroidLogger getInstance() {
        if (instance == null) {
            synchronized (AndroidLogger.class) {
                if (instance == null) {
                    instance = new AndroidLogger();
                }
            }
        }
        return instance;
    }

    public AndroidLogger(LogWrapper logWrapper) {
        this.isLogcatEnabled = false;
        this.logWrapper = logWrapper == null ? LogWrapper.getInstance() : logWrapper;
    }

    private AndroidLogger() {
        this(null);
    }

    public void setLogcatEnabled(boolean z) {
        this.isLogcatEnabled = z;
    }

    public boolean isLogcatEnabled() {
        return this.isLogcatEnabled;
    }

    public void debug(String str) {
        if (this.isLogcatEnabled) {
            this.logWrapper.m2651d(str);
        }
    }

    public void debug(String str, Object... objArr) {
        if (this.isLogcatEnabled) {
            this.logWrapper.m2651d(String.format(Locale.ENGLISH, str, objArr));
        }
    }

    public void verbose(String str) {
        if (this.isLogcatEnabled) {
            this.logWrapper.m2654v(str);
        }
    }

    public void verbose(String str, Object... objArr) {
        if (this.isLogcatEnabled) {
            this.logWrapper.m2654v(String.format(Locale.ENGLISH, str, objArr));
        }
    }

    public void info(String str) {
        if (this.isLogcatEnabled) {
            this.logWrapper.m2653i(str);
        }
    }

    public void info(String str, Object... objArr) {
        if (this.isLogcatEnabled) {
            this.logWrapper.m2653i(String.format(Locale.ENGLISH, str, objArr));
        }
    }

    public void warn(String str) {
        if (this.isLogcatEnabled) {
            this.logWrapper.m2655w(str);
        }
    }

    public void warn(String str, Object... objArr) {
        if (this.isLogcatEnabled) {
            this.logWrapper.m2655w(String.format(Locale.ENGLISH, str, objArr));
        }
    }

    public void error(String str) {
        if (this.isLogcatEnabled) {
            this.logWrapper.m2652e(str);
        }
    }

    public void error(String str, Object... objArr) {
        if (this.isLogcatEnabled) {
            this.logWrapper.m2652e(String.format(Locale.ENGLISH, str, objArr));
        }
    }
}
