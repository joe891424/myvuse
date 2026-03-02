package com.qualtrics.digital;

import java.util.Calendar;

/* JADX INFO: loaded from: classes6.dex */
class LatencyReporter {
    private static final String LOG_TAG = "Qualtrics";
    private String mID;
    private long mStartTime = getCurrentTimeInMillis();
    private String mURL;

    LatencyReporter(String str, String str2) {
        this.mID = str;
        this.mURL = str2;
    }

    void resetTimer() {
        this.mStartTime = -1L;
    }

    void startTimer() {
        if (this.mStartTime < 0) {
            this.mStartTime = getCurrentTimeInMillis();
        }
    }

    private long getCurrentTimeInMillis() {
        return Calendar.getInstance().getTimeInMillis();
    }

    void stopTimerAndReport() {
        try {
            LatencyReportingService.instance().reportLatency(this.mID, this.mURL, getCurrentTimeInMillis() - this.mStartTime);
        } catch (Exception e) {
            SiteInterceptService.instance().postErrorLog(e);
        }
    }
}
