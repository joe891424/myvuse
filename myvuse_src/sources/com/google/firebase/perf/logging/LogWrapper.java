package com.google.firebase.perf.logging;

import com.newrelic.agent.android.instrumentation.LogInstrumentation;

/* JADX INFO: loaded from: classes2.dex */
class LogWrapper {
    private static final String LOG_TAG = "FirebasePerformance";
    private static LogWrapper instance;

    public static synchronized LogWrapper getInstance() {
        if (instance == null) {
            instance = new LogWrapper();
        }
        return instance;
    }

    /* JADX INFO: renamed from: d */
    void m2651d(String str) {
        LogInstrumentation.m2726d(LOG_TAG, str);
    }

    /* JADX INFO: renamed from: v */
    void m2654v(String str) {
        LogInstrumentation.m2732v(LOG_TAG, str);
    }

    /* JADX INFO: renamed from: i */
    void m2653i(String str) {
        LogInstrumentation.m2730i(LOG_TAG, str);
    }

    /* JADX INFO: renamed from: w */
    void m2655w(String str) {
        LogInstrumentation.m2734w(LOG_TAG, str);
    }

    /* JADX INFO: renamed from: e */
    void m2652e(String str) {
        LogInstrumentation.m2728e(LOG_TAG, str);
    }

    private LogWrapper() {
    }
}
