package com.qualtrics.digital;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class BackOffRetrier {
    private String retrierName;
    private IBackOffRetrierFormulaCallback retryBackOffFormula;
    int retryCount = 0;
    public int retryLimit;

    BackOffRetrier(String str, int i, IBackOffRetrierFormulaCallback iBackOffRetrierFormulaCallback) {
        this.retrierName = str;
        this.retryLimit = i;
        this.retryBackOffFormula = iBackOffRetrierFormulaCallback;
    }

    public void backOffAndRetry(Runnable runnable, ScheduledExecutorService scheduledExecutorService) {
        int i = this.retryCount;
        if (i >= this.retryLimit) {
            QualtricsLog.logInfo("Retrier for " + this.retrierName + " - Exceeded retry limit of " + this.retryLimit + "; No longer retrying");
            return;
        }
        int i2 = i + 1;
        this.retryCount = i2;
        int backOffDelayInMilliseconds = this.retryBackOffFormula.getBackOffDelayInMilliseconds(i2);
        QualtricsLog.logInfo("Retrying " + this.retrierName + " after " + backOffDelayInMilliseconds + " seconds");
        scheduledExecutorService.schedule(runnable, backOffDelayInMilliseconds, TimeUnit.MILLISECONDS);
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public void resetRetryCount() {
        this.retryCount = 0;
    }
}
