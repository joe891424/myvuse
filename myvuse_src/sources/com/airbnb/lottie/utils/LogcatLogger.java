package com.airbnb.lottie.utils;

import com.airbnb.lottie.C1363L;
import com.airbnb.lottie.LottieLogger;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class LogcatLogger implements LottieLogger {
    private static final Set<String> loggedMessages = new HashSet();

    @Override // com.airbnb.lottie.LottieLogger
    public void debug(String str) {
        debug(str, null);
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void debug(String str, Throwable th) {
        if (C1363L.DBG) {
            LogInstrumentation.m2727d(C1363L.TAG, str, th);
        }
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void warning(String str) {
        warning(str, null);
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void warning(String str, Throwable th) {
        Set<String> set = loggedMessages;
        if (set.contains(str)) {
            return;
        }
        LogInstrumentation.m2735w(C1363L.TAG, str, th);
        set.add(str);
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void error(String str, Throwable th) {
        if (C1363L.DBG) {
            LogInstrumentation.m2727d(C1363L.TAG, str, th);
        }
    }
}
