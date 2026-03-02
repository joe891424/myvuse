package com.qualtrics.digital.resolvers;

import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.qualtrics.digital.SamplingUtil;

/* JADX INFO: loaded from: classes6.dex */
public class SamplingResolver {
    public boolean evaluateSampling(String str) {
        try {
            return SamplingUtil.checkSampling(Double.valueOf(Double.parseDouble(str)));
        } catch (Exception unused) {
            LogInstrumentation.m2728e("Qualtrics", "Error, unexpected variable leftExpression: " + str);
            return false;
        }
    }
}
