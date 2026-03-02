package com.qualtrics.digital;

import com.newrelic.agent.android.instrumentation.LogInstrumentation;

/* JADX INFO: loaded from: classes6.dex */
class QualtricsLog {
    private static final String LOG_TAG = "Qualtrics";
    static QualtricsLogLevel mLogLevel = QualtricsLogLevel.NONE;

    private QualtricsLog() {
    }

    static void setLogLevel(QualtricsLogLevel qualtricsLogLevel) {
        mLogLevel = qualtricsLogLevel;
    }

    static void logError(String str) {
        LogInstrumentation.m2728e("Qualtrics", str);
    }

    static void logError(String str, Throwable th) {
        LogInstrumentation.m2729e("Qualtrics", str, th);
    }

    static void logInfo(String str) {
        if (mLogLevel == QualtricsLogLevel.INFO) {
            LogInstrumentation.m2730i("Qualtrics", str);
        }
    }

    static void logError(Throwable th) {
        if (th == null || th.toString() == null) {
            return;
        }
        LogInstrumentation.m2728e("Qualtrics", th.toString());
    }
}
