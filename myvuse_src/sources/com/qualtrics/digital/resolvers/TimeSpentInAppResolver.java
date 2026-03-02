package com.qualtrics.digital.resolvers;

import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.qualtrics.digital.DurationTimer;

/* JADX INFO: loaded from: classes6.dex */
public class TimeSpentInAppResolver {
    private static DurationTimer durationTimer = DurationTimer.instance();

    public boolean evaluateTimeSpentInApp(String str, String str2) {
        try {
            Long lValueOf = Long.valueOf(Long.parseLong(str2));
            str.hashCode();
            if (str.equals("GT")) {
                return durationTimer.getElapsedSeconds() > lValueOf.longValue();
            }
            if (str.equals("LT")) {
                return durationTimer.getElapsedSeconds() < lValueOf.longValue();
            }
            LogInstrumentation.m2728e("Qualtrics", "Error, unexpected variable operator: " + str);
            return false;
        } catch (Exception unused) {
            LogInstrumentation.m2728e("Qualtrics", "Error, unexpected rightValue: " + str2);
            return false;
        }
    }
}
